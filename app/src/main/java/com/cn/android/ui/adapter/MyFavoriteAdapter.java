package com.cn.android.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.SelectNewShop;
import com.hjq.image.ImageLoader;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 我的收藏
 */
public class MyFavoriteAdapter extends BaseQuickAdapter<SelectNewShop, BaseViewHolder> {
    private Context context;

    public MyFavoriteAdapter(Context context) {
        super( R.layout.adapter_my_favorite );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectNewShop item) {
        ImageView imageView=helper.getView( R.id.iv_tu );
        ImageLoader.with( context ).load( item.getShopImg() ).into( imageView );
        helper.setText( R.id.tv_bame, item.getShopName() );
        helper.setText( R.id.tv_price, context.getString( R.string.test01 ) + item.getSellPrice() );
        helper.setText( R.id.tv_vip, context.getString( R.string.test01 ) + " " + item.getVipPrice() );
        helper.addOnClickListener( R.id.cb );

    }
}
