package com.cn.android.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.OnShopCartItemListener;
import com.cn.android.R;
import com.cn.android.bean.ShopBean;
import com.cn.android.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class shopCartAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {
    goodsCartAdapter adapter;
    private OnShopCartItemListener onShopCartItemListener;
    private Context context;

    public shopCartAdapter(Context context, @Nullable List<ShopBean> data, OnShopCartItemListener onShopCartItemListener) {
        super( R.layout.item_cart_shop, data );
        this.onShopCartItemListener = onShopCartItemListener;
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopBean item) {
        final int pos = helper.getAdapterPosition();
        helper.setText( R.id.shop_name, item.getStore_name() );
        RecyclerView recyclerView = helper.getView( R.id.shop_recycle );
        recyclerView.setLayoutManager( new LinearLayoutManager( helper.itemView.getContext() ) );
        final CheckBox checkBox = helper.getView( R.id.parent_check );
        checkBox.setChecked( item.isChecked() );
        helper.setOnCheckedChangeListener( R.id.parent_check, new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!item.isChecked() && !checkBox.isChecked()) {
                } else {
                    onShopCartItemListener.OnParentCheckedListener( b, pos );
                }
            }
        } );
        //recyclerView.addItemDecoration(new SpaceItemDecoration(1));
        adapter = new goodsCartAdapter( context, pos, onShopCartItemListener );
        recyclerView.setAdapter( adapter );
        adapter.replaceData( item.getShopList() );
        helper.getView( R.id.goods_num );


    }


}
