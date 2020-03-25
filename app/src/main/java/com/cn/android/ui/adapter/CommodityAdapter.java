package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 每日爆品
 */
public class CommodityAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;
    private int anInt;

    public CommodityAdapter(Context context, int i) {
        super(R.layout.adapter_commodity);
        this.context = context;
        this.anInt = i;
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        if (anInt == 0) {
            helper.setGone(R.id.iv_bao, false);
        } else {
            helper.setGone(R.id.iv_bao, false);
        }
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_price, context.getString(R.string.test01) + item.getPrice());
        helper.setText(R.id.iv_vpi_price, context.getString(R.string.test01) + " " + item.getVipprice());
        helper.addOnClickListener(R.id.Rl_01);
    }
}
