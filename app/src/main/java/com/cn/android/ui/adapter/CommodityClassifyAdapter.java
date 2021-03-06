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
 * 每日爆品分类
 */
public class CommodityClassifyAdapter extends BaseQuickAdapter<HomeData.ShopTypeListBean, BaseViewHolder> {
    private Context context;

    public CommodityClassifyAdapter(Context context) {
        super(R.layout.adapter_commodity_classify);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeData.ShopTypeListBean item) {
        helper.setText(R.id.tv_name, item.getName());
       // helper.setBackgroundRes(R.id.iv, item.getDrawable());
        ImageView img=helper.getView(R.id.iv);
        ImageLoader.with(context).load(item.getImg()).into(img);
        helper.addOnClickListener(R.id.ll_01);
    }
}
