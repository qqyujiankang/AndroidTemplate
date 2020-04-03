package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Personal;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.CommodityAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.bar.TitleBar;
import com.hjq.image.ImageLoader;
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

/**
 * 店铺名详情
 */
public class StoreNameDetailsActivity extends MyActivity implements
        PublicInterfaceView, BaseQuickAdapter.OnItemChildClickListener, OnLoadMoreListener, OnRefreshListener {

    @BindView(R.id.iv_shop_img)
    ImageView ivShopImg;
    @BindView(R.id.tv_title)
    TitleBar tvTitle;
    @BindView(R.id.iv_hear)
    ImageView ivHear;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.ll)
    RelativeLayout ll;
    @BindView(R.id.rbn_01)
    RadioButton rbn01;
    @BindView(R.id.rbn_02)
    RadioButton rbn02;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private PublicInterfaceePresenetr presenetr;
    private String userid;
    CommodityAdapter commodityAdapte1r;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_store_name_details;
    }

    GridLayoutManager gridLayoutManager;

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        gridLayoutManager = new GridLayoutManager( getActivity(), 2 );
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation( GridLayout.VERTICAL );
        //设置布局管理器， 参数gridLayoutManager对象
        recyclerView.setLayoutManager( gridLayoutManager );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 8 ) );
        commodityAdapte1r = new CommodityAdapter( getActivity(), 2 );
        recyclerView.setAdapter( commodityAdapte1r );
        commodityAdapte1r.setOnItemChildClickListener( this );
    }

    @Override
    protected void initData() {

        userid = getIntent().getStringExtra( "userid" );
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopListByUserid, Constant.selectShopListByUserid );
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectAppUserByUserid, Constant.selectAppUserByUserid );
    }

    private List<SelectNewShop> shopInfoListBeanArrayList = new ArrayList<>();
    private List<SelectNewShop> shopInfoListBeanArrayLis1 = new ArrayList<>();
    private int page = 1, rows = 10;
    private boolean isUpRefresh = true;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();

        switch (tag) {
            case Constant.selectShopListByUserid:
                paramsMap.put( "userid", userid );
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );
                paramsMap.put( "type", type );
                return paramsMap;
            case Constant.selectAppUserByUserid:
                paramsMap.put( "userid", userid );
                return paramsMap;
        }
        return null;
    }

    Personal personal = new Personal();

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {
            case Constant.selectShopListByUserid:
                if (isUpRefresh) {
                    shopInfoListBeanArrayLis1.clear();
                }

                if (!data.equals( "[]" )) {

                    shopInfoListBeanArrayList = GsonUtils.getPersons( data, SelectNewShop.class );
                    shopInfoListBeanArrayLis1.addAll( shopInfoListBeanArrayList );
                    commodityAdapte1r.replaceData( shopInfoListBeanArrayLis1 );
                } else if (shopInfoListBeanArrayLis1.size() == 0) {
                    ivHintIcon.show();
                }
                break;
            case Constant.selectAppUserByUserid:

                if (!data.equals( "[]" )) {
                    personal = GsonUtils.getPerson( data, Personal.class );
                    tvShopName.setText( personal.getStoreName() );
                    ImageLoader.with( getActivity() ).load( personal.getHeadImg() ).into( ivHear );
                    ImageLoader.with( getActivity() ).load( personal.getStoreImg() ).into( ivShopImg );
                }
                break;

        }

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }


    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent( getActivity(), CommodityDetailsActivity.class );
        intent.putExtra( "SelectNewShop", shopInfoListBeanArrayList.get( position ) );
        startActivity( intent );
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }

    private String type = "1";

    @OnClick({R.id.rbn_01, R.id.rbn_02})
    public void onViewClicked(View view) {
        shopInfoListBeanArrayList.clear();
        page = 1;
        switch (view.getId()) {
            case R.id.rbn_01:
                type = "1";
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopListByUserid, Constant.selectShopListByUserid );
                break;
            case R.id.rbn_02:
                type = "2";
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopListByUserid, Constant.selectShopListByUserid );
                break;
        }
    }
}
