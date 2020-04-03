package com.cn.android.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.MyOrder;
import com.cn.android.utils.DataUtils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 我的卖出的
 */
public class Myiseelladapter extends BaseQuickAdapter<MyOrder, BaseViewHolder> {
    private Context context;
    MyordeshopListAdapter myordeshopListAdapter;

    public Myiseelladapter(Context context) {
        super( R.layout.adapter_my_iseell );
        this.context = context;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void convert(BaseViewHolder helper, MyOrder item) {
        RecyclerView relativeLayout = helper.getView( R.id.recyclerView );
        relativeLayout.setLayoutManager( new LinearLayoutManager( context ) );
        myordeshopListAdapter = new MyordeshopListAdapter( context );
        relativeLayout.setAdapter( myordeshopListAdapter );
        myordeshopListAdapter.replaceData( item.getShopList() );
        helper.addOnClickListener( R.id.btn_01 );
        helper.addOnClickListener( R.id.btn_02 );
        helper.setText( R.id.tv_ordercode, item.getOrdercode() );
        helper.setText( R.id.tv_01, context.getString( R.string.test01 ) + DataUtils.getMoney( item.getTotal_shop_money() ) );
        helper.setText( R.id.tv_sum1, "共" + item.getTotal_shop_num() + "件" );
        helper.setText( R.id.tv_name, item.getName() );
        helper.setText( R.id.tv_phone, item.getPhone() );
        helper.setText( R.id.tv_address, item.getAddress() );
        if (item.getStatus() == 2) {
            helper.setGone( R.id.rl03, true );
            helper.setText( R.id.tv_status, "待发货");
        } else if (item.getStatus() == 3) {
            helper.setGone( R.id.rl03, true );
            helper.setText( R.id.tv_status, "已发货" );
        } else if (item.getStatus() == 4) {
            helper.setText( R.id.btn_01, "联系买家" );
            helper.setText( R.id.btn_02, "查看物流" );
            helper.setText( R.id.tv_status, "已完成" );
            helper.setBackgroundRes( R.id.btn_01, R.drawable.bg_w );
            helper.setTextColor( R.id.btn_01, R.color.color666666 );
            helper.setGone( R.id.rl03, true );
        }

    }
}
