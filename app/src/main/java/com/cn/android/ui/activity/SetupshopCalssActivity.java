package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.base.BaseAdapter;
import com.cn.android.bean.HomeData;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.SetushopClassAdapter;
import com.cn.android.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 设置店铺分类
 */
public class SetupshopCalssActivity extends MyActivity implements PublicInterfaceView, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv)
    RecyclerView rv;
    private PublicInterfaceePresenetr presenetr;
    SetushopClassAdapter setushopClassAdapter;
    private List<HomeData.ShopTypeListBean> shopTypeListBeanList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setupshop_calss;
    }

    @Override
    protected void initView() {
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
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "type", userdata().getType() );
        return paramsMap;
    }


    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        shopTypeListBeanList = GsonUtils.getPersons( data, HomeData.ShopTypeListBean.class );
        setushopClassAdapter.replaceData( shopTypeListBeanList );
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


    HomeData.ShopTypeListBean shopTypeListBean;

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        shopTypeListBean = shopTypeListBeanList.get( position );
        Intent intent = getIntent();
        intent.putExtra( "shopTypeListBean", shopTypeListBean );
        setResult(33,intent);
        finish();
    }
}
