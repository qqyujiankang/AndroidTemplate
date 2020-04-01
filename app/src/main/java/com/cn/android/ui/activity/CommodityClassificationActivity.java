package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.HomeData;
import com.cn.android.bean.SelectTypeListByPid;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.SetushopClassAdapter;
import com.cn.android.ui.adapter.ShopAdapter;
import com.cn.android.ui.adapter.ShopItemAdapter;
import com.cn.android.utils.L;
import com.cn.android.widget.SpaceItemDecoration;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CommodityClassificationActivity extends MyActivity implements TabLayout.OnTabSelectedListener,
        PublicInterfaceView, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.tlTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.rv)
    RecyclerView rv;
    private PublicInterfaceePresenetr presenetr;
    private ShopAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commodity_classification;
    }

    @Override
    protected void initView() {

        mTabLayout.addOnTabSelectedListener( this );
        presenetr = new PublicInterfaceePresenetr( this );
        rv.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        rv.addItemDecoration( new SpaceItemDecoration( 1 ) );
        setushopClassAdapter = new SetushopClassAdapter( getActivity() );
        setushopClassAdapter.setOnItemClickListener( this );
        rv.setAdapter( setushopClassAdapter );


    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectFristTypeList, Constant.selectFristTypeList );
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        switch (tab.getPosition()) {
            case 0:
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectFristTypeList, Constant.selectFristTypeList );
                break;
            case 1:
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectTypeListByPid, Constant.selectTypeListByPid );
                break;

        }


    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();


        switch (tag) {
            case Constant.selectFristTypeList:
                paramsMap.put( "type", userdata().getType() );
                return paramsMap;
            case Constant.selectTypeListByPid:
                paramsMap.put( "pid", "1" );
                return paramsMap;
        }
        return null;
    }

    private List<HomeData.ShopTypeListBean> shopTypeListBeanList = new ArrayList<>();
    private List<SelectTypeListByPid> selectTypeListByPids = new ArrayList<>();
    SetushopClassAdapter setushopClassAdapter;

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {

            case Constant.selectFristTypeList:
                log( "selectFristTypeList=============" + data );
                shopTypeListBeanList = GsonUtils.getPersons( data, HomeData.ShopTypeListBean.class );
                shopTypeListBeanList.get( 0 ).setClick( true );
                //

                setushopClassAdapter.replaceData( shopTypeListBeanList );

                break;
            case Constant.selectTypeListByPid:
                adapter = new ShopAdapter( getActivity() );
                adapter.setOnItemClickListener( this );
                rv.setAdapter( adapter );
                shopTypeListBeanList.clear();
                selectTypeListByPids = GsonUtils.getPersons( data, SelectTypeListByPid.class );
                adapter.replaceData( selectTypeListByPids );
                L.e( "Https", " selectFristTypeList1 = " + data );
                break;
        }
    }


    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    private String pid;
    private int ThreeListposition;

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (adapter instanceof SetushopClassAdapter) {
            pid = shopTypeListBeanList.get( position ).getId();
            mTabLayout.addTab( mTabLayout.newTab().setText( shopTypeListBeanList.get( position ).getName() ) );
            presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectTypeListByPid, Constant.selectTypeListByPid );
        } else if (adapter instanceof ShopAdapter) {
            ThreeListposition = position;
            mTabLayout.addTab( mTabLayout.newTab().setText( selectTypeListByPids.get( position ).getName() ) );
            adapter = new ShopItemAdapter( getActivity() );
            adapter.setOnItemClickListener( this );
            rv.setAdapter( adapter );
            adapter.replaceData( selectTypeListByPids.get( position ).getThreeList() );


        } else if (adapter instanceof ShopItemAdapter) {

            mTabLayout.addTab( mTabLayout.newTab().setText( selectTypeListByPids.get( ThreeListposition ).getThreeList().get( position ).getName() ) );
            finish();
        }

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate( savedInstanceState );
//        setContentView( R.layout.activity_commodity_classification );
//    }
}
