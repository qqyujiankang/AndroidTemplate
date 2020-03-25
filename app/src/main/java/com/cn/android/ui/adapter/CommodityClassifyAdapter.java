package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

/**
 * 每日爆品分类
 */
public class CommodityClassifyAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;

    public CommodityClassifyAdapter(Context context) {
        super(R.layout.adapter_commodity_classify);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.setText(R.id.tv_name, item.getName());
        helper.setBackgroundRes(R.id.iv, item.getDrawable());
        helper.addOnClickListener(R.id.ll_01);
    }
}
