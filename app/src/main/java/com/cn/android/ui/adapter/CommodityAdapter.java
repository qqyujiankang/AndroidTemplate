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

import androidx.annotation.Nullable;

/**
 * 每日爆品
 */
public class CommodityAdapter extends BaseQuickAdapter<SelectNewShop, BaseViewHolder> {
    private Context context;
    private int anInt;

    public CommodityAdapter(Context context, int i) {
        super( R.layout.adapter_commodity );
        this.context = context;
        this.anInt = i;
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectNewShop item) {
        if (anInt == 0) {
            helper.setGone( R.id.iv_bao, false );
        } else if (anInt == 2) {
            helper.setGone( R.id.iv, false );

        } else {
            helper.setGone( R.id.iv_bao, false );
        }
        helper.setText( R.id.tv_name, item.getShopName() );
        helper.setText( R.id.tv_price, context.getString( R.string.test01 ) + item.getSellPrice() );
        helper.setText( R.id.iv_vpi_price, context.getString( R.string.test01 ) + " " + item.getVipPrice() );
        ImageView imageView=helper.getView( R.id.iv_commodity );
        ImageLoader.with( context ).load( item.getShopImg() ).into( imageView );

        helper.addOnClickListener( R.id.Rl_01 );
        helper.addOnClickListener( R.id.iv );
    }
}
