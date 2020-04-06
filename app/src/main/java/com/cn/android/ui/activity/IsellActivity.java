package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.MyOrder;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.Myiseelladapter;
import com.cn.android.widget.SpaceItemDecoration;
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
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我卖出的
 */
public class IsellActivity extends MyActivity implements PublicInterfaceView, BaseQuickAdapter.OnItemChildClickListener, OnRefreshListener, OnLoadMoreListener {


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
    private String ordercode, shop_userid;
    private String order = "";
    private int page = 1, rows = 10;
    private boolean isUpRefresh = true;

    Myiseelladapter adapter;
    private List<MyOrder> myOrders = new ArrayList<>();
    private List<MyOrder> myOrderArrayList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_isell;
    }

    private PublicInterfaceePresenetr presenetr;

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 10 ) );
        adapter = new Myiseelladapter( getActivity() );
        recyclerView.setAdapter( adapter );
        adapter.setOnItemChildClickListener( this::onItemChildClick );


    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectOrdersByStatus, Constant.selectOrdersByStatus );

    }


    @OnClick({R.id.rbt_obligation, R.id.rbt_To_send_the_goods, R.id.rbt_off_the_stocks, R.id.btn_remain_to_be_evaluated})
    public void onViewClicked(View view) {
        myOrderArrayList.clear();
        page = 1;
        adapter = new Myiseelladapter( getActivity() );
        recyclerView.setAdapter( adapter );
        adapter.setOnItemChildClickListener( this::onItemChildClick );
        switch (view.getId()) {
            case R.id.rbt_obligation:

                order = "";

                initData();
                break;
            case R.id.rbt_To_send_the_goods:
                order = "2";

                initData();
                break;
            case R.id.rbt_off_the_stocks:
                order = "3";

                initData();
                break;
            case R.id.btn_remain_to_be_evaluated:
                order = "4";

                initData();
                break;
        }
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.selectOrdersByStatus:

                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "status", order );
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );

                return paramsMap;
            case Constant.sureSendOrder:

                return paramsMap;
        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {
            case Constant.selectOrdersByStatus:

                if (isUpRefresh) {
                    myOrderArrayList.clear();
                }
                smartRefresh.closeHeaderOrFooter();
                if (!data.equals( "[]" )) {

                    myOrders = GsonUtils.getPersons( data, MyOrder.class );
                    myOrderArrayList.addAll( myOrders );
                    adapter.replaceData( myOrderArrayList );
                } else {
                    if (myOrderArrayList.size() == 0) {
                        ivHintIcon.show();
                    }
                }
                break;
            case Constant.sureSendOrder:


                break;
        }
    }

    private int getPage;

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    MyOrder dataBean;

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        dataBean = (MyOrder) adapter.getItem( position );
        getPage = position;
        switch (view.getId()) {
            case R.id.btn_01:
                if (dataBean.getStatus() == 4) {
                    startActivity( ServiceActivity.class );
                } else if (dataBean.getStatus() == 2) {
                    Intent intent = new Intent( getActivity(), WaybillFillInActivity.class );
                    intent.putExtra( "dataBean", dataBean );
                    startActivityForResult( intent, 200 );
                }
                break;
            case R.id.btn_02:
                if (dataBean.getStatus() == 4) {
                    startActivity( CheckTheLogisticsActivity.class );
                } else if (dataBean.getStatus() == 2) {

                    startActivity( ServiceActivity.class );
                }
                break;
        }
    }


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == 200 && resultCode == 200) {
            myOrderArrayList.clear();
            page = 1;
            initData();
        }
    }
}
