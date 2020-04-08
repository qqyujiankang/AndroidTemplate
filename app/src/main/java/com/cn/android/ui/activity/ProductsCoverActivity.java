package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
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
import com.hjq.dialog.MessageDialog;
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

/**
 * Products cover商品自荐
 */
public class ProductsCoverActivity extends MyActivity implements
        OnTitleBarListener, OnRefreshListener, OnLoadMoreListener, PublicInterfaceView, BaseQuickAdapter.OnItemChildClickListener {


    @BindView(R.id.ttb)
    TitleBar ttb;
    CommodityManagementAdapter commodityManagementAdapter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private PublicInterfaceePresenetr presenetr;

    private List<SelectNewShop> shopInfoListBeanArrayList = new ArrayList<>();
    private List<SelectNewShop> shopInfoListBeanArrayLis1 = new ArrayList<>();
    private int page = 1, rows = 10;
    private boolean isUpRefresh = true;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_products_cover;
    }


    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        ttb.setOnTitleBarListener( this );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 2 ) );
        presenetr = new PublicInterfaceePresenetr( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        //设置布局管理器， 参数gridLayoutManager对象
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        commodityManagementAdapter = new CommodityManagementAdapter( getActivity());
        recyclerView.setAdapter( commodityManagementAdapter );
        commodityManagementAdapter.setOnItemChildClickListener( this );

    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopListByUserid, Constant.selectShopListByUserid );
    }

//    @Override
//    public void onRightClick(View v) {
//        super.onRightClick( v );
//        if (!ttb.getRightTitle().toString().equals( "保存" )) {
//            ttb.setRightTitle( "保存" );
//            commodityManagementAdapter = new CommodityManagementAdapter( getActivity(), 1 );
//            recyclerView.setAdapter( commodityManagementAdapter );
//            initData();
//        } else {
//            finish();
//        }
//    }


    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.selectShopListByUserid:

                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );
                paramsMap.put( "type", "1" );
                return paramsMap;
            case Constant.sortShopByUserid:
                paramsMap.put( "shopid", shopid );
                return paramsMap;
        }


        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();

        switch (tag) {
            case Constant.selectShopListByUserid:
                if (isUpRefresh) {
                    shopInfoListBeanArrayLis1.clear();
                }
                smartRefresh.closeHeaderOrFooter();
                if (!data.equals( "[]" )) {

                    shopInfoListBeanArrayList = GsonUtils.getPersons( data, SelectNewShop.class );
                    shopInfoListBeanArrayLis1.addAll( shopInfoListBeanArrayList );
                    commodityManagementAdapter.replaceData( shopInfoListBeanArrayLis1 );
                }else if (shopInfoListBeanArrayLis1.size()==0){
                    ivHintIcon.show();
                }
                break;
            case Constant.sortShopByUserid:
                shopInfoListBeanArrayLis1.clear();
                page=1;

                initData();
               // shopInfoListBeanArrayLis1.remove( position );
                //commodityManagementAdapter.replaceData( shopInfoListBeanArrayLis1 );
                break;
        }

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

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

    private String shopid = "";
    private int position;

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {

            case R.id.iv:
                showLoading();
                position = position;
                shopid = shopInfoListBeanArrayLis1.get( position ).getId();
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.sortShopByUserid, Constant.sortShopByUserid );
                break;
        }
    }
}
