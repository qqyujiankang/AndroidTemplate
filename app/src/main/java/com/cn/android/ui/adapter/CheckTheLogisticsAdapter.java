package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 物流信息
 */
public class CheckTheLogisticsAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;

    public CheckTheLogisticsAdapter(Context context) {
        super(R.layout.draw_example_step10);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.setText(R.id.start_name, item.getName());
        helper.setText(R.id.start_time, item.getPrice());

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (position == 0) {
           holder.setBackgroundRes(R.id.iv_new, R.drawable.shop_cart_selected);
        } else {
            holder.setBackgroundRes(R.id.iv_new, R.drawable.refund_circle_gray);
        }

    }
}
