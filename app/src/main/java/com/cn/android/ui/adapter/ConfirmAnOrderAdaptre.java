package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.CommodityManagement;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.utils.DataUtils;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 确认人订单
 */
public class ConfirmAnOrderAdaptre extends BaseQuickAdapter<CommodityManagement, BaseViewHolder> {
    private Context context;

    public ConfirmAnOrderAdaptre(Context context) {
        super( R.layout.adaptre_confirm_an_order );
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityManagement item) {
        //helper.setText( R.id.tv_money, );
        RecyclerView recyclerView = helper.getView( R.id.rv_01 );
        recyclerView.setLayoutManager( new LinearLayoutManager( context ) );
        OrderAdaptre adaptre = new OrderAdaptre( context );
        recyclerView.setAdapter( adaptre );
        adaptre.setNewData( item.getShopList() );

    }
}
