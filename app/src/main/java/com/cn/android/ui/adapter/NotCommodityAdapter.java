package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

/**
 * 每日爆品
 */
public class NotCommodityAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;

    public NotCommodityAdapter(Context context) {
        super(R.layout.adapter__not_commodity);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.setText(R.id.tv_name,item.getName());
        helper.setText(R.id.tv_price,item.getPrice());
        helper.setText(R.id.iv_vpi_price,item.getVipprice());
    }
}
