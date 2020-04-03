package com.cn.android.ui.activity;

import android.content.Intent;
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
import com.cn.android.utils.L;
import com.cn.android.widget.SpaceItemDecoration;
import com.google.android.material.tabs.TabItem;
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
                shopTypeListBeanList.clear();
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectFristTypeList, Constant.selectFristTypeList );
                break;
            case 1:
                selectTypeListByPids.clear();
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

    private String pid, seconde_type_id, three_type_id;
    private String pidname, seconde_type_idname, three_type_idname;
    private int ThreeListposition;

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (adapter instanceof SetushopClassAdapter) {

            pid = shopTypeListBeanList.get( position ).getId();
            pidname = shopTypeListBeanList.get( position ).getName();
            //mTabLayout.getTabAt( 0 ).setText( pidname );
            presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectTypeListByPid, Constant.selectTypeListByPid );
        } else if (adapter instanceof ShopAdapter) {
            ThreeListposition = position;
            seconde_type_id = selectTypeListByPids.get( position ).getId();
            seconde_type_idname = selectTypeListByPids.get( position ).getName();
          //  mTabLayout.getTabAt( 1 ).setText( seconde_type_idname );
            adapter = new Class3ItemAdapter( getActivity() );
            adapter.setOnItemClickListener( this );
            rv.setAdapter( adapter );
            adapter.replaceData( selectTypeListByPids.get( position ).getThreeList() );


        } else if (adapter instanceof Class3ItemAdapter) {
            three_type_id = selectTypeListByPids.get( ThreeListposition ).getThreeList().get( position ).getId();
            three_type_idname = selectTypeListByPids.get( ThreeListposition ).getThreeList().get( position ).getName();
           // mTabLayout.getTabAt( 2 ).setText( three_type_idname );
            Intent intent = getIntent();
            intent.putExtra( "first_type_id", pid );
            intent.putExtra( "pidname", pidname );
            intent.putExtra( "seconde_type_id", seconde_type_id );
            intent.putExtra( "seconde_type_idname", seconde_type_idname );
            intent.putExtra( "three_type_id", three_type_id );
            intent.putExtra( "three_type_idname", three_type_idname );
            setResult( 22, intent );
            finish();
        }

    }



}
