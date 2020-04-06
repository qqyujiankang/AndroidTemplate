package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.ProductDetails;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.common.MyActivity;
import com.cn.android.helper.ActivityStackManager;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.EvaluateAdapter;
import com.cn.android.ui.dialog.CommoditySpecificationDialog;
import com.cn.android.ui.dialog.SelectShippingAddressDialog;
import com.cn.android.ui.dialog.ShareDialog;
import com.cn.android.ui.dialog.TostDialog;
import com.cn.android.utils.TimeUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.widget.layout.SettingBar;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品详情
 * commodity details
 */
public class CommodityDetailsActivity extends MyActivity implements
        OnTitleBarListener, SelectShippingAddressDialog.onaddressconfidence, PublicInterfaceView {


    EvaluateAdapter adapter;
    @BindView(R.id.ttb)
    TitleBar ttb;
    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.tv_02)
    TextView tv02;
    @BindView(R.id.tv_)
    TextView tv;
    @BindView(R.id.sb_account_management)
    SettingBar sbAccountManagement;
    @BindView(R.id.sb_add)
    SettingBar sbAdd;
    @BindView(R.id.tv_07)
    TextView tv07;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_08)
    TextView tv08;
    @BindView(R.id.Rl_01)
    RelativeLayout Rl01;
    @BindView(R.id.sb_add0)
    SettingBar sbAdd0;
    @BindView(R.id.rv01)
    RecyclerView rv01;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    CheckBox tv3;
    @BindView(R.id.btn_01)
    Button btn01;
    @BindView(R.id.btn_02)
    Button btn02;
    @BindView(R.id.iv_seal)
    ImageView ivSeal;
    @BindView(R.id.tv_sale_mun)
    TextView tvSaleMun;
    private SelectNewShop selectNewShop;
    PublicInterfaceePresenetr presenetr;
    ProductDetails productDetails;
    List<String> strings = new ArrayList<>();
    private int anInt;
    private int isllogn = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commodity_details;
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        rv01.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false ) );
        //rv01.addItemDecoration(new SpaceItemDecoration(30));
        selectNewShop = getIntent().getParcelableExtra( "SelectNewShop" );
        anInt = getIntent().getIntExtra( "id", 0 );

        adapter = new EvaluateAdapter( getActivity() );
        rv01.setAdapter( adapter );
        ttb.setOnTitleBarListener( this );

    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopByid, Constant.selectShopByid );

    }

    @OnClick({R.id.tv_1, R.id.tv_2, R.id.tv_3, R.id.btn_01, R.id.btn_02, R.id.sb_account_management, R.id.sb_add, R.id.sb_add0})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.sb_add0:
                if (isLogin()) {
                    Intent intent = new Intent( getActivity(), PostEvaluationActivity.class );
                    //intent.putExtra( "selectNewShop", selectNewShop );

                    startActivity( intent );
                } else {
                    startActivity( TheloginIdActivity.class );
                    ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                }
                break;
            case R.id.sb_add:
                if (isLogin()) {
                    new SelectShippingAddressDialog.Builder( getActivity(), this ).show();

                } else {
                    startActivity( TheloginIdActivity.class );
                    ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                }

                break;
            case R.id.sb_account_management:
                if (isLogin()) {
                    isllogn = 1;
                }
                new CommoditySpecificationDialog.Builder( getActivity(), productDetails, 0, userdata().getType(), Constant.buyOrderShop ).show();

                break;

            case R.id.tv_1:
                Intent intent1 = new Intent( getActivity(), StoreNameDetailsActivity.class );
                intent1.putExtra( "userid", selectNewShop.getUserid() );
                startActivity( intent1 );

                break;
            case R.id.tv_2:
                startActivity( ServiceActivity.class );
                break;
            case R.id.tv_3:
                // TODO: 2020/3/31
                if (isLogin()) {
                    presenetr.getPostTokenRequest( getActivity(), ServerUrl.sureConlectShopsByUserid, Constant.sureConlectShopsByUserid );
                } else {
                    startActivity( TheloginIdActivity.class );
                    ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                }
                break;
            case R.id.btn_01:
                if (isLogin()) {
                    if (userdata().getType() == 1) {
                        if (userdata().getIsReal() == 2) {
                            new CommoditySpecificationDialog.Builder( getActivity(), productDetails, 1, userdata().getType(), Constant.addOrderShop ).show();
                        } else {
                            new TostDialog.Builder( getActivity(), "您还未成为企业用户 请先完成企业认证" ).show();
                        }
                    } else {
                        new CommoditySpecificationDialog.Builder( getActivity(), productDetails, 1, userdata().getType(), Constant.addOrderShop ).show();
                    }
                } else {
                    startActivity( TheloginIdActivity.class );
                    ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                }

                break;
            case R.id.btn_02:
                if (isLogin()) {
                    if (userdata().getType() == 1) {
                        if (userdata().getIsReal() == 2) {
                            new CommoditySpecificationDialog.Builder( getActivity(), productDetails, 1, userdata().getType(), Constant.buyOrderShop ).show();
                            //  startActivity( ConfirmAnOrderActivity.class );
                        } else {
                            new TostDialog.Builder( getActivity(), "您还未成为企业用户 请先完成企业认证" ).show();
                        }
                    } else {
                        startActivity( ConfirmAnOrderActivity.class );
                    }
                } else {
                    startActivity( TheloginIdActivity.class );
                    ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                }


                break;
        }

    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick( v );
        new ShareDialog.Builder( getActivity() ).show();
    }

    @Override
    public void getaddressconfidence(Commodity.DataBean dataBean) {
        log( dataBean );
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> map = new HashMap<>();
        if (userdata() != null) {
            map.put( "userid", userdata().getId() );
        }

        switch (tag) {
            case Constant.sureConlectShopsByUserid:
                map.put( "shopid", selectNewShop.getId() );
                return map;
            case Constant.selectShopByid:
                map.put( "shopid", selectNewShop.getId() );
                return map;

        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {
            case Constant.sureConlectShopsByUserid:

                break;
            case Constant.selectShopByid:
                productDetails = GsonUtils.getPerson( data, ProductDetails.class );
                Glide.with( getActivity() ).load( productDetails.getDetilas() ).into( ivSeal );
                tv01.setText( productDetails.getShopName() );
                tv02.setText( getString( R.string.test01 ) + productDetails.getVipPrice() );
                tv.setText( "市场指导价:" + getString( R.string.test01 ) + productDetails.getSellPrice() );
                tvSaleMun.setText( "成交量" + productDetails.getSaleNum() );
                strings = TimeUtils.getStiringlist( productDetails.getImgUrls() );
                xbanner.setData( strings, null );
                if (productDetails.getIs_conlect() == 1) {
                    tv3.setChecked( true );
                } else {
                    tv3.setChecked( false );
                }

                xbanner.setmAdapter( new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with( getActivity() ).load( strings.get( position ) ).into( (ImageView) view );
                    }
                } );
                if (anInt == 1) {
                    new CommoditySpecificationDialog.Builder( getActivity(), productDetails, 1, userdata().getType(), Constant.addOrderShop ).show();
                }
                break;
        }

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }
}
