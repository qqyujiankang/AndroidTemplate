package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.MyOrder;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.MyordeshopListAdapter;
import com.cn.android.ui.dialog.QRcoDialog;
import com.hjq.bar.TitleBar;

import java.util.HashMap;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 订单详情
 */
public class TheOrderDetailsActivity extends MyActivity implements PublicInterfaceView {


    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.tv_order_reference)
    TextView tvOrderReference;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.vv)
    View vv;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.btn_01)
    Button btn01;
    @BindView(R.id.btn_02)
    Button btn02;
    @BindView(R.id.btn_login_commit)
    Button btnLoginCommit;
    @BindView(R.id.tv_order_reference1)
    TextView tvOrderReference1;
    @BindView(R.id.tv_time01)
    TextView tvTime01;
    @BindView(R.id.tv_progress)
    TextView tvProgress;
    @BindView(R.id.tv_no_pr)
    TextView tvNoPr;
    private MyOrder myOrder;
    MyordeshopListAdapter myordeshopListAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_the_order_details;
    }

    @Override
    protected void initView() {
        myOrder = getIntent().getParcelableExtra( "myOrder" );
        tvOrderReference.setText( "订单编号：" + myOrder.getOrdercode() );
        tvOrderReference1.setText( "订单编号：" + myOrder.getOrdercode() );
        tvTime01.setText( "创建时间：" + myOrder.getCtime() );
        tvProgress.setText( "订单总价:" + getString( R.string.test01 ) + myOrder.getPay_money() );


        tvTime.setText( myOrder.getPay_time() );
        rv.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        myordeshopListAdapter = new MyordeshopListAdapter( getActivity() );
        rv.setAdapter( myordeshopListAdapter );
        myordeshopListAdapter.replaceData( myOrder.getShopList() );
        if (myOrder.getStatus() == 1) {
            tvNoPr.setText( "待付款:" + getString( R.string.test01 ) + myOrder.getPay_money() );
        } else {
            tvNoPr.setText( "已付款:" + getString( R.string.test01 ) + myOrder.getPay_money() );
        }
        if (myOrder.getStatus() == 1) {
            tvStatus.setText( "待付款" );
            btnLoginCommit.setText( "去付款" );
        } else if (myOrder.getStatus() == 2) {
            tvStatus.setText( "待发货" );
            btnLoginCommit.setText( "联系客服" );
        } else if (myOrder.getStatus() == 3) {
            tvStatus.setText( "待收货" );
            btnLoginCommit.setText( "收货码" );
            btn01.setVisibility( View.VISIBLE );
            btn02.setVisibility( View.VISIBLE );
            btn01.setText( "确认收货" );
            btn02.setText( "查看物流" );
            btn02.setTextColor( getActivity().getResources().getColor( R.color.huise ) );
            btn02.setBackgroundResource( R.drawable.bg_home_search_bar_transparent );
        } else if (myOrder.getStatus() == 4) {
            btnLoginCommit.setText( "去评价" );
            tvStatus.setText( "待评价" );
        }
    }

    @Override
    protected void initData() {

    }

    private String ordercode, shop_userid;
    private PublicInterfaceePresenetr presenetr;

    @OnClick({R.id.btn_01, R.id.btn_02, R.id.btn_login_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_01:
                shop_userid = myOrder.getShop_user_id();
                ordercode = myOrder.getOrdercode();
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.surePickOrder, Constant.surePickOrder );
                break;
            case R.id.btn_02:
                startActivity( CheckTheLogisticsActivity.class );
                break;
            case R.id.btn_login_commit:
                if (myOrder.getStatus() == 1) {
                    startActivity( ConfirmAnOrderActivity.class );
                } else if (myOrder.getStatus() == 2) {
                    startActivity( ServiceActivity.class );
                } else if (myOrder.getStatus() == 3) {
                    new QRcoDialog.Builder( getActivity(), Gravity.TOP, "扫码核销", "" ).show();

                } else if (myOrder.getStatus() == 4) {
                    Intent intent = new Intent( getActivity(), PostEvaluationActivity.class );
                    intent.putExtra( "myOrder", myOrder );
                    startActivity( intent );
                }
                break;
        }
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "ordercode", ordercode );
        paramsMap.put( "shop_userid", shop_userid );
        return paramsMap;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        MyOrderActivity.aBoolean = true;
        finish();

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }
}
