package com.cn.android.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.MyOrder;
import com.cn.android.network.Constant;
import com.hjq.image.ImageLoader;

import java.util.List;

import androidx.annotation.Nullable;

public class MyordeshopListAdapter extends BaseQuickAdapter<MyOrder.ShopListBean, BaseViewHolder> {
    private Context context;

    public MyordeshopListAdapter(Context context) {
        super( R.layout.adapter_order );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyOrder.ShopListBean item) {
        ImageView imageView = helper.getView( R.id.iv_shop_img );
        ImageLoader.with( context ).load( item.getShop_img() ).into( imageView );
        helper.setText( R.id.tv_shop_name, item.getShop_name() );
        helper.setText( R.id.tv_sku_name, "规格" + item.getSku_name() );//
        helper.setText( R.id.tv_time, item.getCtime() );
        helper.setText( R.id.tv_shop_money, item.getShop_money() );
        helper.setText( R.id.tv_shop_num, "x" + item.getShop_num() );
    }
}
