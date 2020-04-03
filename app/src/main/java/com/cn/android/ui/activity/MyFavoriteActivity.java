package com.cn.android.ui.activity;

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
import com.cn.android.ui.adapter.MyFavoriteAdapter;
import com.cn.android.widget.SpaceItemDecoration;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的收藏
 */
public class MyFavoriteActivity extends MyActivity implements PublicInterfaceView, OnRefreshListener, OnLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {


    MyFavoriteAdapter adapter;
    GridLayoutManager gridLayoutManager;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;

    private PublicInterfaceePresenetr presenetr;
    private boolean isUpRefresh = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_favorite;
    }

    @Override

    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        adapter = new MyFavoriteAdapter( getActivity() );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 10 ) );
        gridLayoutManager = new GridLayoutManager( getActivity(), 1 );
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        //设置布局管理器， 参数gridLayoutManager对象
        recyclerView.setLayoutManager( gridLayoutManager );
        recyclerView.setAdapter( adapter );
        adapter.setOnItemChildClickListener( this::onItemChildClick );

    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectConlectShopsByUserid, Constant.selectConlectShopsByUserid );
    }

    private int page = 1, rows = 10;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> map = new HashMap<>();
        map.put( "userid", userdata().getId() );
        switch (tag) {
            case Constant.selectConlectShopsByUserid:

                map.put( "page", page );
                map.put( "rows", rows );
                map.put( "type", userdata().getType() );

                return map;
            case Constant.sureConlectShopsByUserid:
                map.put( "shopid", shopid );
                return map;
        }

        return null;
    }

    private List<SelectNewShop> shopInfoListBeanArrayList = new ArrayList<>();
    private List<SelectNewShop> shopInfoListBeanArrayLis1 = new ArrayList<>();

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {
            case Constant.selectConlectShopsByUserid:

                if (isUpRefresh) {
                    shopInfoListBeanArrayLis1.clear();
                }
                if (!data.equals( "[]" )) {
                    smartRefresh.closeHeaderOrFooter();
                    shopInfoListBeanArrayList = GsonUtils.getPersons( data, SelectNewShop.class );
                    shopInfoListBeanArrayLis1.addAll( shopInfoListBeanArrayList );
                    adapter.replaceData( shopInfoListBeanArrayLis1 );
                } else if (shopInfoListBeanArrayLis1.size()==0){
                    ivHintIcon.show();
                }
                break;
            case Constant.sureConlectShopsByUserid:
                shopInfoListBeanArrayLis1.remove( anIntposition );
                adapter.replaceData( shopInfoListBeanArrayLis1 );
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

    private int anIntposition;
    private String shopid;

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.cb:
                anIntposition = position;
                new MessageDialog.Builder( this )
                        // 标题可以不用填写
                        //.setTitle("我是标题")
                        // 内容必须要填写
                        .setMessage( "确定要取消收藏的商品吗？" )
                        // 确定按钮文本
                        .setConfirm( "确定" )
                        // 设置 null 表示不显示取消按钮
                        .setCancel( "再想想" )

                        // 设置点击按钮后不关闭对话框
                        //.setAutoDismiss(false)
                        .setListener( new MessageDialog.OnListener() {

                            @Override
                            public void onConfirm(Dialog dialog) {
                                shopid = shopInfoListBeanArrayLis1.get( position ).getId();
                                // toast("确定了");
                                presenetr.getPostTokenRequest( getActivity(), ServerUrl.sureConlectShopsByUserid, Constant.sureConlectShopsByUserid );
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
