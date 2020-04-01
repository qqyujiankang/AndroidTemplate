package com.cn.android.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.MyOrder;
import com.cn.android.bean.SelectNewShop;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 我的订单
 */
public class MyOrderAdapter extends BaseQuickAdapter<MyOrder, BaseViewHolder> {
    private Context context;
    MyordeshopListAdapter myordeshopListAdapter;

    public MyOrderAdapter(Context context) {
        super( R.layout.adapter_my_order );
        this.context = context;

    }

    @SuppressLint("ResourceType")
    @Override
    protected void convert(BaseViewHolder helper, MyOrder item) {
        RecyclerView relativeLayout = helper.getView( R.id.relativeLayout );
        relativeLayout.setLayoutManager( new LinearLayoutManager( context ) );
        myordeshopListAdapter = new MyordeshopListAdapter( context );
        relativeLayout.setAdapter( myordeshopListAdapter );
        myordeshopListAdapter.replaceData( item.getShopList() );
        helper.setText( R.id.tv_reference,  item.getOrdercode() );
        helper.setText( R.id.tv_total_shop_money, context.getString( R.string.test01 ) + item.getTotal_shop_money() );
        helper.setText( R.id.total_shop_num, "共" + item.getTotal_shop_money() + "件" );
        helper.addOnClickListener( R.id.btn_login_commit );
        helper.addOnClickListener( R.id.btn_02 );
        if (item.getStatus() == 1) {
            helper.setText( R.id.tv_status, "待付款" );
            helper.setText( R.id.btn_login_commit, "去付款" );

        } else if (item.getStatus() == 2) {
            helper.setText( R.id.btn_login_commit, "联系客服" );
            helper.setText( R.id.tv_status, "待发货" );
        } else if (item.getStatus() == 3) {


            helper.setText( R.id.btn_login_commit, "收货码" );
            helper.setVisible( R.id.btn_01, true );
            helper.setVisible( R.id.btn_02, true );
            helper.setText( R.id.btn_01, "确认收货" );
            helper.setText( R.id.btn_02, "查看物流" );

            helper.setTextColor( R.id.btn_02, context.getResources().getColor(R.color.huise) );
            helper.setBackgroundRes( R.id.btn_02, R.drawable.bg_home_search_bar_transparent );


            helper.setText( R.id.tv_status, "待收货" );
        } else if (item.getStatus() == 3) {
            helper.setText( R.id.btn_login_commit, "去评价" );
            helper.setText( R.id.tv_status, "待评价" );
        }

    }
}
