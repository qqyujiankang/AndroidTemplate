package com.cn.android.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
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
import butterknife.OnClick;

/**
 * 商品管理
 */
public class CommodityManagementActivity extends MyActivity implements OnTitleBarListener, PublicInterfaceView,
        OnRefreshListener, OnLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commodity_management;

    }

    @Override
    protected void initView() {

        presenetr = new PublicInterfaceePresenetr( this );
        titeBar.setOnTitleBarListener( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 1 ) );
        commodityManagementAdapter = new CommodityManagementAdapter( getActivity() );
        recyclerView.setAdapter( commodityManagementAdapter );
        commodityManagementAdapter.setOnItemChildClickListener( this );
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
        switch (tag) {
            case Constant.selectShopsByUserid:

                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );
                paramsMap.put( "type", type );
                return paramsMap;
            case Constant.deleteShopByUserid:
                paramsMap.put( "shopid", shopid );
                return paramsMap;
            case Constant.upShopByUserid:
                paramsMap.put( "shopid", shopid );
                return paramsMap;
        }
        return null;
    }

    private List<SelectNewShop> shopInfoListBeanArrayList = new ArrayList<>();
    private List<SelectNewShop> shopInfoListBeanArrayLis1 = new ArrayList<>();
    private String shopid = "";
    private int position;

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {
            case Constant.selectShopsByUserid:
                if (isUpRefresh) {
                    shopInfoListBeanArrayLis1.clear();
                }
                smartRefresh.closeHeaderOrFooter();
                if (!data.equals( "[]" )) {

                    shopInfoListBeanArrayList = GsonUtils.getPersons( data, SelectNewShop.class );
                    shopInfoListBeanArrayLis1.addAll( shopInfoListBeanArrayList );
                    commodityManagementAdapter.replaceData( shopInfoListBeanArrayLis1 );
                } else if (shopInfoListBeanArrayLis1.size()==0){
                    ivHintIcon.show();
                }
                break;
            case Constant.deleteShopByUserid:
                shopInfoListBeanArrayLis1.remove( position );
                commodityManagementAdapter.replaceData( shopInfoListBeanArrayLis1 );
                break;
            case Constant.upShopByUserid:
                shopInfoListBeanArrayLis1.remove( position );
                commodityManagementAdapter.replaceData( shopInfoListBeanArrayLis1 );
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

    SelectNewShop selectNewShop;

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        position = position;
        selectNewShop = shopInfoListBeanArrayLis1.get( position );
        shopid = shopInfoListBeanArrayLis1.get( position ).getId();
        switch (view.getId()) {
            case R.id.tv_03:
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.upShopByUserid, Constant.upShopByUserid );
                break;
            case R.id.tv_02:

                Intent intent = new Intent( getActivity(), UploadTheGoodsActivity.class );
                intent.putExtra( "selectNewShop", selectNewShop );
                startActivity( intent );
                break;
            case R.id.tv_01:

                new MessageDialog.Builder( this )
                        .setMessage( "确定要删除此商品吗？" )
                        .setConfirm( "删除" )
                        .setCancel( "再想想" )
                        .setListener( new MessageDialog.OnListener() {

                            @Override
                            public void onConfirm(Dialog dialog) {

                                presenetr.getPostTokenRequest( getActivity(), ServerUrl.deleteShopByUserid, Constant.deleteShopByUserid );
                                dialog.dismiss();
                            }

                            @Override
                            public void onCancel(Dialog dialog) {
                                //  toast("取消了");
                                dialog.dismiss();
                            }
                        } )
                        .show();
                break;
        }
    }
}
