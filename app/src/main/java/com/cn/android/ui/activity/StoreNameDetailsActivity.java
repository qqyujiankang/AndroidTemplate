package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.HomeData;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.CommodityAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 店铺名详情
 */
public class StoreNameDetailsActivity extends MyActivity {
    @BindView(R.id.tv_title)
    TitleBar tvTitle;
    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.rv)
    RecyclerView rv;
    CommodityAdapter commodityAdapte1r;
    List<Commodity.DataBean> dataBeans = new ArrayList<>();
        private HomeData.AppUserListBean appUserListBean;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_store_name_details;
    }

    GridLayoutManager gridLayoutManager;

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        appUserListBean=getIntent().getParcelableExtra( "AppUserListBean" );

//布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        gridLayoutManager = new GridLayoutManager( getActivity(), 2 );
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation( GridLayout.VERTICAL );
        //设置布局管理器， 参数gridLayoutManager对象
        rv.setLayoutManager( gridLayoutManager );
        rv.addItemDecoration( new SpaceItemDecoration( 8 ) );
        commodityAdapte1r = new CommodityAdapter( getActivity(), 2 );
        rv.setAdapter( commodityAdapte1r );
        commodityAdapte1r.setOnItemChildClickListener( new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity( CommodityDetailsActivity.class );
            }
        } );
    }

    @Override
    protected void initData() {
        dataBeans.add( new Commodity.DataBean( "", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji ) );
        dataBeans.add( new Commodity.DataBean( "", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji ) );
        dataBeans.add( new Commodity.DataBean( "", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji ) );
        dataBeans.add( new Commodity.DataBean( "", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji ) );
        dataBeans.add( new Commodity.DataBean( "", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji ) );

        //commodityAdapte1r.setNewData(dataBeans);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_store_name_details);
//    }
}
