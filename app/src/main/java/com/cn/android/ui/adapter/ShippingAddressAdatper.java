package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 收货地址
 */
public class ShippingAddressAdatper extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    public ShippingAddressAdatper(Context context) {
        super(R.layout.adatper_shipping_address);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.addOnClickListener(R.id.Rl_01);

    }
}
