package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.HomeData;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.CommodityAdapter;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商品列表
 */
public class ProductListActivity extends MyActivity implements PublicInterfaceView, BaseQuickAdapter.
        OnItemChildClickListener, OnRefreshListener, OnLoadMoreListener {

    CommodityAdapter commodityAdapte1r;

    GridLayoutManager gridLayoutManager;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_list;
    }

    private String typeid;

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        typeid = getIntent().getStringExtra( "typeid" );
        presenetr = new PublicInterfaceePresenetr( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        gridLayoutManager = new GridLayoutManager( getActivity(), 2 );
        gridLayoutManager.setOrientation( GridLayout.VERTICAL );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 10 ) );
        recyclerView.setLayoutManager( gridLayoutManager );
        commodityAdapte1r = new CommodityAdapter( getActivity(), 0 );
        commodityAdapte1r.setOnItemChildClickListener( this::onItemChildClick );
        recyclerView.setAdapter( commodityAdapte1r );
    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopListByShopType, Constant.selectShopListByShopType );

    }

    private int page = 1, rows = 10;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "type", userdata().getType() );
        paramsMap.put( "province", userdata().getProvince() );
        paramsMap.put( "city", userdata().getCity() );
        paramsMap.put( "area", userdata().getArea() );
        paramsMap.put( "page", page );
        paramsMap.put( "rows", rows );
        paramsMap.put( "typeid", typeid );


        return paramsMap;
    }

    private List<SelectNewShop> shopInfoListBeanArrayList = new ArrayList<>();
    private List<SelectNewShop> shopInfoListBeanArrayLis1 = new ArrayList<>();
    private boolean isUpRefresh = true;

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        if (isUpRefresh) {
            shopInfoListBeanArrayLis1.clear();
        }
        if (!data.equals( "" )) {
            smartRefresh.closeHeaderOrFooter();
            shopInfoListBeanArrayList = GsonUtils.getPersons( data, SelectNewShop.class );
            shopInfoListBeanArrayLis1.addAll( shopInfoListBeanArrayList );
            commodityAdapte1r.replaceData( shopInfoListBeanArrayLis1 );
        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity( CommodityDetailsActivity.class );
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
