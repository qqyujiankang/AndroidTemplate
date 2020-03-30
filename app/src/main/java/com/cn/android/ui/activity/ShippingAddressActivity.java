package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.AddressByUserid;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.ShippingAddressAdatper;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收货地址
 */
public class ShippingAddressActivity extends MyActivity implements PublicInterfaceView {


    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.rv)
    RecyclerView rv;
    ShippingAddressAdatper shippingAddressAdatper;
    GridLayoutManager gridLayoutManager;
    PublicInterfaceePresenetr presenetr;
    public static boolean aBoolean = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shipping_address;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        shippingAddressAdatper = new ShippingAddressAdatper( getActivity() );
        rv.addItemDecoration( new SpaceItemDecoration( 10 ) );
        gridLayoutManager = new GridLayoutManager( getActivity(), 1 );
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        //设置布局管理器， 参数gridLayoutManager对象
        rv.setLayoutManager( gridLayoutManager );
        rv.setAdapter( shippingAddressAdatper );
        shippingAddressAdatper.setOnItemChildClickListener( new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                AddressByUserid addressByUserid = (AddressByUserid) adapter.getItem( position );
                Intent intent = new Intent( getActivity(), AddressDetailActivity.class );
                intent.putExtra( "addressByUserid", addressByUserid );
                startActivity( intent );
            }
        } );

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
    protected void initData() {


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

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {

            case Constant.selectAddressByUserid:
                list = GsonUtils.getPersons( data, AddressByUserid.class );
                list1.addAll( list );
                shippingAddressAdatper.replaceData( list1 );
                break;
        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }
}
