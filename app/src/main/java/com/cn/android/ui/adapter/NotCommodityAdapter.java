package com.cn.android.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.HomeData;
import com.hjq.image.ImageLoader;

/**
 * 每日爆品
 */
public class NotCommodityAdapter extends BaseQuickAdapter<HomeData.ShopInfoListBean, BaseViewHolder> {
    private Context context;

    public NotCommodityAdapter(Context context) {
        super( R.layout.adapter__not_commodity );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeData.ShopInfoListBean item) {
        ImageView imageView = helper.getView( R.id.iv_commodity );
        ImageLoader.with( context ).load( item.getShopImg() ).into( imageView );
        helper.setText( R.id.tv_name, item.getShopName() );
        helper.setText( R.id.tv_price, context.getString( R.string.test01 ) + item.getSellPrice() );
        helper.setText( R.id.iv_vpi_price, context.getString( R.string.test01 ) + "" + item.getVipPrice() );
        helper.addOnClickListener( R.id.Rl_01 );
    }
}
