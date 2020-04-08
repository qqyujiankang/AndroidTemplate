package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.MyOrder;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.MyOrderAdapter;
import com.cn.android.ui.dialog.QRcoDialog;
import com.hjq.widget.layout.HintLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.cn.android.network.Constant.sureSendOrder;

/**
 * 我的订单
 */
public class MyOrderActivity extends MyActivity implements
        PublicInterfaceView, BaseQuickAdapter.OnItemChildClickListener, OnRefreshListener, OnLoadMoreListener {
    @BindView(R.id.rbt_obligation)
    RadioButton rbtObligation;
    @BindView(R.id.rbt_To_send_the_goods)
    RadioButton rbtToSendTheGoods;
    @BindView(R.id.rbt_off_the_stocks)
    RadioButton rbtOffTheStocks;
    @BindView(R.id.btn_remain_to_be_evaluated)
    RadioButton btnRemainToBeEvaluated;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private int order = 0;
    MyOrderAdapter adapter;
    GridLayoutManager gridLayoutManager;
    private PublicInterfaceePresenetr presenetr;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        order = getIntent().getIntExtra( "order", 0 );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        if (order == 1) {
            rbtObligation.setChecked( true );

        } else if (order == 2) {
            rbtToSendTheGoods.setChecked( true );
        } else if (order == 3) {
            rbtOffTheStocks.setChecked( true );
        } else if (order == 4) {
            btnRemainToBeEvaluated.setChecked( true );
        }

        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        gridLayoutManager = new GridLayoutManager( getActivity(), 1 );
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        //设置布局管理器， 参数gridLayoutManager对象
        recyclerView.setLayoutManager( gridLayoutManager );
        adapter = new MyOrderAdapter( getActivity() );
        adapter.setOnItemChildClickListener( this::onItemChildClick );
        recyclerView.setAdapter( adapter );

    }


    @Override
    protected void initData() {

        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectOrderListByStatus, Constant.selectOrderListByStatus );

    }

    public static boolean aBoolean = false;

    @Override
    protected void onResume() {
        super.onResume();
        if (aBoolean) {
            aBoolean = false;
        }

    }

    @OnClick({R.id.rbt_obligation, R.id.rbt_To_send_the_goods, R.id.rbt_off_the_stocks, R.id.btn_remain_to_be_evaluated})
    public void onViewClicked(View view) {
        page = 1;
        shopInfoListBeanArrayLis1.clear();
        switch (view.getId()) {
            case R.id.rbt_obligation:

                order = 1;
                initData();
                break;
            case R.id.rbt_To_send_the_goods:
                order = 2;
                initData();
                break;
            case R.id.rbt_off_the_stocks:
                order = 3;
                initData();
                break;
            case R.id.btn_remain_to_be_evaluated:
                order = 4;
                initData();
                break;
        }
    }

    private int page = 1, rows = 10;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.selectOrderListByStatus:

                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "type", userdata().getType() );
                paramsMap.put( "status", order );
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );

                return paramsMap;
            case Constant.surePickOrder:
                paramsMap.put( "ordercode", ordercode );
                paramsMap.put( "shop_userid", shop_userid );
                return paramsMap;
        }
        return null;
    }

    private String ordercode, shop_userid;

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {
            case Constant.selectOrderListByStatus:
                smartRefresh.closeHeaderOrFooter();
                if (isUpRefresh) {
                    shopInfoListBeanArrayLis1.clear();
                }
                if (!data.equals( "[]" )) {

                    shopInfoListBeanArrayList = GsonUtils.getPersons( data, MyOrder.class );
                    shopInfoListBeanArrayLis1.addAll( shopInfoListBeanArrayList );
                    adapter.replaceData( shopInfoListBeanArrayLis1 );
                } else {
                    if (shopInfoListBeanArrayLis1.size() == 0) {
                        ivHintIcon.show();
                    }
                }
                break;
            case Constant.surePickOrder:
                shopInfoListBeanArrayLis1.remove( getPage );
                adapter.replaceData( shopInfoListBeanArrayLis1 );

                break;
        }
    }

    private List<MyOrder> shopInfoListBeanArrayList = new ArrayList<>();
    private List<MyOrder> shopInfoListBeanArrayLis1 = new ArrayList<>();
    private String shopid = "";
    private int getPage;

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        getPage = position;
        switch (view.getId()) {
            case R.id.btn_01:
                //   toast( "6565+" );
                shop_userid = shopInfoListBeanArrayLis1.get( position ).getShop_user_id();
                ordercode = shopInfoListBeanArrayLis1.get( position ).getOrdercode();
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.surePickOrder, Constant.surePickOrder );
                break;
            case R.id.Rl_01:
                Intent intent1 = new Intent( getActivity(), TheOrderDetailsActivity.class );
                intent1.putExtra( "myOrder", shopInfoListBeanArrayLis1.get( position ) );
                startActivity( intent1 );
                break;
            case R.id.btn_02://CheckTheLogisticsActivity

                startActivity( CheckTheLogisticsActivity.class );
                break;
            case R.id.btn_login_commit:
                if (shopInfoListBeanArrayLis1.get( position ).getStatus() == 3) {
                    new QRcoDialog.Builder( getActivity(), Gravity.TOP, "扫码核销","" ).show();

                } else if (shopInfoListBeanArrayLis1.get( position ).getStatus() == 1) {
                    startActivity( ConfirmAnOrderActivity.class );
                } else if (shopInfoListBeanArrayLis1.get( position ).getStatus() == 2) {
                    startActivity( ServiceActivity.class );
                }

                break;
            case R.id.tv_status:
                if (shopInfoListBeanArrayLis1.get( position ).getStatus() == 4) {
                    Intent intent = new Intent( getActivity(), PostEvaluationActivity.class );
                    intent.putExtra( "myOrder", shopInfoListBeanArrayLis1.get( position ) );
                    startActivity( intent );
                }
                break;
        }
    }

    private boolean isUpRefresh = true;

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        isUpRefresh = false;
        page = page + 1;
        initData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        isUpRefresh = true;
        page = 1;
        initData();
    }
}
