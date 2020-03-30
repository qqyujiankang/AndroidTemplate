package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.cn.android.R;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.CommodityManagementAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品管理
 */
public class CommodityManagementActivity extends MyActivity implements OnTitleBarListener, PublicInterfaceView, OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.tite_bar)
    TitleBar titeBar;
    @BindView(R.id.rbt_obligation)
    RadioButton rbtObligation;
    @BindView(R.id.rbt_To_send_the_goods)
    RadioButton rbtToSendTheGoods;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private PublicInterfaceePresenetr presenetr;
    CommodityManagementAdapter commodityManagementAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commodity_management;

    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        titeBar.setOnTitleBarListener( this );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 1 ) );
        commodityManagementAdapter = new CommodityManagementAdapter( getActivity(), 0 );
        recyclerView.setAdapter( commodityManagementAdapter );
    }


    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopsByUserid, Constant.selectShopsByUserid );

    }

    private String type = "1";

    @OnClick({R.id.rbt_obligation, R.id.rbt_To_send_the_goods})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbt_obligation:
                shopInfoListBeanArrayLis1.clear();
                type = "1";
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopsByUserid, Constant.selectShopsByUserid );
                break;
            case R.id.rbt_To_send_the_goods:
                shopInfoListBeanArrayLis1.clear();
                type = "2";
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopsByUserid, Constant.selectShopsByUserid );

                break;
        }
    }

    @Override
    public void onRightClick(View v) {
        startActivity( UploadTheGoodsActivity.class );

    }

    private int page = 1, rows = 10;
    private boolean isUpRefresh = true;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "userid", userdata().getId() );
        paramsMap.put( "page", page );
        paramsMap.put( "rows", rows );
        paramsMap.put( "type", type );


        return paramsMap;
    }

    private List<SelectNewShop> shopInfoListBeanArrayList = new ArrayList<>();
    private List<SelectNewShop> shopInfoListBeanArrayLis1 = new ArrayList<>();

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        if (isUpRefresh) {
            shopInfoListBeanArrayLis1.clear();
        }
        if (!data.equals( "" )) {
            smartRefresh.closeHeaderOrFooter();
            shopInfoListBeanArrayList = GsonUtils.getPersons( data, SelectNewShop.class );
            shopInfoListBeanArrayLis1.addAll( shopInfoListBeanArrayList );
            commodityManagementAdapter.replaceData( shopInfoListBeanArrayLis1 );
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
