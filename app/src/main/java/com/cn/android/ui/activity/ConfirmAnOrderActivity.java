package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.AddressByUserid;
import com.cn.android.bean.CommodityManagement;
import com.cn.android.bean.DiscountCoupon;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.OrderAdaptre;
import com.cn.android.utils.DataUtils;
import com.hjq.widget.layout.SettingBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 确认订单
 */
public class ConfirmAnOrderActivity extends MyActivity implements PublicInterfaceView {


    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.vv_1)
    View vv1;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_site)
    TextView tvSite;
    @BindView(R.id.add_tv)
    TextView addTv;
    @BindView(R.id.rv_01)
    RecyclerView rv01;
    @BindView(R.id.sb_setting_language)
    SettingBar sbSettingLanguage;
    @BindView(R.id.tv_upper)
    CheckBox tvUpper;
    @BindView(R.id.ll_01)
    RelativeLayout ll01;
    @BindView(R.id.cb02)
    CheckBox cb02;
    @BindView(R.id.ll02)
    RelativeLayout ll02;
    @BindView(R.id.vv_2)
    View vv2;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_name_youhui)
    TextView tvNameYouhui;
    @BindView(R.id.tv_youhuijuan)
    TextView tvYouhuijuan;
    @BindView(R.id.tv_upper_youhui)
    CheckBox tvUpperYouhui;
    @BindView(R.id.rl_you)
    RelativeLayout rlYou;
    @BindView(R.id.tv_money01)
    TextView tvMoney01;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    private OrderAdaptre marketingDivisionAdapter;
    CommodityManagement managements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_confirm_an_order;
    }

    private PublicInterfaceePresenetr presenetr;
    private Intent list_intent;

    @Override
    protected void initView() {
        managements = getIntent().getParcelableExtra( "managements" );
        presenetr = new PublicInterfaceePresenetr( this );
        rv01.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        tvMoney.setText( getActivity().getString( R.string.test01 ) + DataUtils.getMoney( managements.getOld_total_money() ) );
        marketingDivisionAdapter = new OrderAdaptre( getActivity() );
        rv01.setAdapter( marketingDivisionAdapter );
        marketingDivisionAdapter.setNewData( managements.getShopList() );
        tvMoney01.setText( "合计：" + getActivity().getString( R.string.test01 ) + DataUtils.getMoney( managements.getOld_total_money() ) );
    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectAddressByUserid, Constant.selectAddressByUserid );
    }

    @OnClick({R.id.add_tv, R.id.sb_setting_language, R.id.ll_01, R.id.ll02})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.add_tv:
                intent.setClass( getActivity(), ShippingAddressActivity.class );
                intent.putExtra( "id", 1 );
                startActivityForResult( intent, 200 );
                break;
            case R.id.sb_setting_language:
                intent.setClass( getActivity(), DiscountCouponActivity.class );
                startActivityForResult( intent, 300 );
                break;
            case R.id.ll_01:
                tvUpper.setChecked( true );
                cb02.setChecked( false );
                break;
            case R.id.ll02:
                tvUpper.setChecked( false );
                cb02.setChecked( true );
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == 300 && resultCode == 300) {
            DiscountCoupon discountCoupon = data.getParcelableExtra( "discountCoupon" );
            rlYou.setVisibility( View.VISIBLE );
            tvNameYouhui.setText( DataUtils.getMoney( discountCoupon.getUseMoney() ) + "元优惠券" );
            tvYouhuijuan.setText( discountCoupon.getContent() );
            double d = managements.getOld_total_money() - discountCoupon.getUseMoney();
            tvMoney01.setText( "合计：" + getActivity().getString( R.string.test01 ) + DataUtils.getMoney( d ) );


        } else if (requestCode == 200 && resultCode == 200) {
            AddressByUserid addressByUserid = data.getParcelableExtra( "addressByUserid" );
            tvName.setText( "收件人：" + addressByUserid.getName() );
            tvPhone.setText( addressByUserid.getPhone() );
            tvSite.setText( addressByUserid.getProCityArea() + addressByUserid.getAddress() );
        }
    }

    int page = 1;
    int rows = 10;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.selectAddressByUserid:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );
                return paramsMap;
        }
        return null;
    }

    List<AddressByUserid> list = new ArrayList<>();

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        list = GsonUtils.getPersons( data, AddressByUserid.class );
        tvName.setText( "收件人：" + list.get( 0 ).getName() );
        tvPhone.setText( list.get( 0 ).getPhone() );
        tvSite.setText( list.get( 0 ).getProCityArea() + list.get( 0 ).getAddress() );
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }
}
