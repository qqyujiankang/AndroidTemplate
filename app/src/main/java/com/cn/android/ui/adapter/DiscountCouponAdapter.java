package com.cn.android.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 优惠券
 */
public class DiscountCouponAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    public DiscountCouponAdapter(int layoutResId, @Nullable List<Commodity.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.setText(R.id.tv_price, item.getName());
        helper.setText(R.id.tv_usable, item.getPrice());
        helper.setText(R.id.tv_time, item.getImgUrl());
    }
}
