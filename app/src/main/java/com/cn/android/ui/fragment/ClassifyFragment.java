package com.cn.android.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.ClassifyBean;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.HomeData;
import com.cn.android.bean.SelectTypeListByPid;
import com.cn.android.bean.ShopBean;
import com.cn.android.bean.selectStoreListByPid;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.activity.SearchActivity;
import com.cn.android.ui.activity.StoreNameDetailsActivity;
import com.cn.android.ui.activity.TheloginIdActivity;
import com.cn.android.ui.activity.locationActivity;
import com.cn.android.ui.adapter.ClassAdapter;
import com.cn.android.ui.adapter.ShopAdapter;
import com.cn.android.ui.adapter.StoreClassiFicationAdapter;
import com.cn.android.utils.L;
import com.cn.android.widget.SpaceItemDecoration;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/***
 * 分类
 */
public class ClassifyFragment extends MyLazyFragment<HomeActivity> implements BaseQuickAdapter.OnItemClickListener, PublicInterfaceView {
    @BindView(R.id.tv_qi_q)
    TextView tvQiQ;
    @BindView(R.id.iv_information)
    ImageView ivInformation;
    @BindView(R.id.iv_RichScan)
    ImageView ivRichScan;
    ClassAdapter classAdapter;
    @BindView(R.id.rv_class_nmae)
    RecyclerView rvClassNmae;
    List<ShopBean> dataShop;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.shop_recyclerView)
    RecyclerView shopRecyclerView;
    @BindView(R.id.sv_default)
    TextView svDefault;
    @BindView(R.id.shop_recyclerView1)
    RecyclerView shopRecyclerView1;
    private ShopAdapter adapter;
    private PublicInterfaceePresenetr presenetr;
    //分类
    private List<HomeData.ShopTypeListBean> shopTypeListBeanList = new ArrayList<>();
    private List<SelectTypeListByPid> selectTypeListByPids = new ArrayList<>();
    private List<selectStoreListByPid> storeListByPids = new ArrayList<>();
    private String pid = "1";
    private int store = 1;

    StoreClassiFicationAdapter storeClassiFicationAdapter;

    public static ClassifyFragment newInstance() {
        return new ClassifyFragment();
    }

    int aposition = -1;

    public void onClick(int position) {
        aposition = position;
        initData();
        //toast("分类 = "+position);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;

    }

    @Override
    protected void initView() {
        ImmersionBar.setTitleBar( getActivity(), title );
        presenetr = new PublicInterfaceePresenetr( this );
        if (userdata() != null) {
            if (userdata().getType() == 1) {
                ivRichScan.setBackground( getResources().getDrawable( R.mipmap.dian01 ) );
                tvQiQ.setText( "分类" );
                tvQiQ.setCompoundDrawablesWithIntrinsicBounds( null, null, null, null );
            } else {
                ivRichScan.setBackground( getResources().getDrawable( R.mipmap.xiaoxi ) );

            }
        } else {
            ivRichScan.setBackground( getResources().getDrawable( R.mipmap.xiaoxi ) );
        }
        rvClassNmae.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        shopRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        classAdapter = new ClassAdapter( getActivity() );
        adapter = new ShopAdapter( getActivity() );
        classAdapter.setOnItemClickListener( this );
        shopRecyclerView.setAdapter( adapter );

        rvClassNmae.setAdapter( classAdapter );
    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectFristTypeList, Constant.selectFristTypeList );
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        pid = shopTypeListBeanList.get( position ).getId();
        for (int i = 0; i < shopTypeListBeanList.size(); i++) {
            shopTypeListBeanList.get( i ).setClick( false );
        }
        shopTypeListBeanList.get( position ).setClick( true );
        adapter.replaceData( shopTypeListBeanList );
        if (store == 1) {
            presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectTypeListByPid, Constant.selectTypeListByPid );
        } else {
            presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectStoreListByPid, Constant.selectStoreListByPid );
        }


        classAdapter.replaceData( shopTypeListBeanList );

    }

    @OnClick({R.id.iv_RichScan, R.id.sv_default, R.id.tv_qi_q})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_RichScan:
                if (userdata().getType() == 1) {

                    if (store == 1) {
                        store = 2;
                        shopRecyclerView1.setVisibility( View.VISIBLE );
                        shopRecyclerView.setVisibility( View.GONE );
                        ivRichScan.setBackground( getResources().getDrawable( R.drawable.fenlei ) );

                        if (storeClassiFicationAdapter == null) {
                            shopRecyclerView1.addItemDecoration( new SpaceItemDecoration( 10 ) );
                            shopRecyclerView1.setLayoutManager( new GridLayoutManager( getActivity(), 2 ) );
                            storeClassiFicationAdapter = new StoreClassiFicationAdapter( getActivity() );

                        }
                        shopRecyclerView1.setAdapter( storeClassiFicationAdapter );
                        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectStoreListByPid, Constant.selectStoreListByPid );


                        storeClassiFicationAdapter.setOnItemChildClickListener( new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                                Intent intent = new Intent( getActivity(), StoreNameDetailsActivity.class );
                                intent.putExtra( "userid", storeListByPids.get( position ).getId() );
                                startActivity( intent );
                            }
                        } );
                    } else if (store == 2) {
                        store = 1;
                        shopRecyclerView1.setVisibility( View.GONE );
                        shopRecyclerView.setVisibility( View.VISIBLE );
                        ivRichScan.setBackground( getResources().getDrawable( R.mipmap.dian01 ) );

                        if (adapter == null) {
                            shopRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
                            adapter = new ShopAdapter( getActivity() );
                        }
                        shopRecyclerView.setAdapter( adapter );
                        initData();

                    }
                }
                break;
            case R.id.sv_default:
                startActivity( SearchActivity.class );
                break;
            case R.id.tv_qi_q:
                if (userdata() != null) {
                    if (userdata().getType() == 1) {
                        Intent inten = new Intent( getContext(), locationActivity.class );
                        inten.putExtra( "id", 2 );
                        startActivityForResult( inten, 201 );
                    }
                }
                break;
        }

    }


    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();

//
        switch (tag) {
            case Constant.selectFristTypeList:
                if (userdata() != null) {
                    paramsMap.put( "type", userdata().getType() );
                } else {
                    paramsMap.put( "type", 2 );
                }
                return paramsMap;
            case Constant.selectTypeListByPid:
                paramsMap.put( "pid", pid );
                return paramsMap;
            case Constant.selectStoreListByPid:
                paramsMap.put( "pid", pid );

                return paramsMap;
        }
        return null;
    }


    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {

            case Constant.selectFristTypeList:
                log( "selectFristTypeList=============" + data );
                shopTypeListBeanList = GsonUtils.getPersons( data, HomeData.ShopTypeListBean.class );
                if (aposition == -1) {
                    shopTypeListBeanList.get( 0 ).setClick( true );
                    pid = shopTypeListBeanList.get( 0 ).getId();
                } else {
                    shopTypeListBeanList.get( aposition ).setClick( true );
                    pid = shopTypeListBeanList.get( aposition ).getId();
                }
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectTypeListByPid, Constant.selectTypeListByPid );

                classAdapter.replaceData( shopTypeListBeanList );

                break;
            case Constant.selectTypeListByPid:
                selectTypeListByPids = GsonUtils.getPersons( data, SelectTypeListByPid.class );
                adapter.replaceData( selectTypeListByPids );
                L.e( "Https", " selectFristTypeList1 = " + data );
                break;
            case Constant.selectStoreListByPid:
                storeListByPids = GsonUtils.getPersons( data, selectStoreListByPid.class );
                storeClassiFicationAdapter.setNewData( storeListByPids );//StoreNameDetailsActivity
                break;
        }

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == 201 && resultCode == 201) {
            String s = data.getStringExtra( "address" );
            tvQiQ.setText( s );
        }
    }
}
