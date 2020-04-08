package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.AddressByUserid;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.ShippingAddressAdatper;
import com.cn.android.widget.SpaceItemDecoration;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收货地址
 */
public class ShippingAddressActivity extends MyActivity implements PublicInterfaceView, OnRefreshListener, OnLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {


    ShippingAddressAdatper shippingAddressAdatper;
    GridLayoutManager gridLayoutManager;
    PublicInterfaceePresenetr presenetr;
    public static boolean aBoolean = false;
    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (aBoolean) {
            aBoolean = false;
            list1.clear();
            initData();

        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shipping_address;
    }

    @Override
    protected void initView() {
        id = getIntent().getIntExtra( "id", 0 );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        presenetr = new PublicInterfaceePresenetr( this );
        shippingAddressAdatper = new ShippingAddressAdatper( getActivity() );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 10 ) );
        gridLayoutManager = new GridLayoutManager( getActivity(), 1 );
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        //设置布局管理器， 参数gridLayoutManager对象
        recyclerView.setLayoutManager( gridLayoutManager );
        recyclerView.setAdapter( shippingAddressAdatper );
        shippingAddressAdatper.setOnItemChildClickListener( this::onItemChildClick );


    }

    @Override
    protected void initData() {
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectAddressByUserid, Constant.selectAddressByUserid );
    }


    @OnClick({R.id.btn_bind_commit})
    public void onViewClicked() {

        startActivity( AddressDetailActivity.class );
    }

    int page = 1;
    int rows = 10;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.selectAddressByUserid:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );
                return paramsMap;
        }
        return null;
    }

    List<AddressByUserid> list = new ArrayList<>();
    List<AddressByUserid> list1 = new ArrayList<>();
    private boolean isUpRefresh = true;

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {

            case Constant.selectAddressByUserid:
                showComplete();
                smartRefresh.closeHeaderOrFooter();
                if (isUpRefresh) {
                    list1.clear();
                }
                list = GsonUtils.getPersons( data, AddressByUserid.class );

                list1.addAll( list );

                if (list1.size() != 0) {
                    shippingAddressAdatper.replaceData( list1 );
                    ivHintIcon.hide();
                } else {
                    ivHintIcon.show();
                }


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

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        AddressByUserid addressByUserid = (AddressByUserid) adapter.getItem( position );


        if (id == 1) {
            Intent intent = getIntent();
            intent.putExtra( "addressByUserid", addressByUserid );
            setResult( 200,intent );
            finish();
        } else {
            Intent u=new Intent(  );
            u.setClass( getActivity(), AddressDetailActivity.class );

            startActivity( u );
        }

    }
}
