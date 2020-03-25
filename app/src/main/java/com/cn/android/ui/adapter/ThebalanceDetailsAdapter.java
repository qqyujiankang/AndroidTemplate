package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 余额详情
 * 交易明细
 */
public class ThebalanceDetailsAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;

    public ThebalanceDetailsAdapter(Context context) {
        super(R.layout.adapter_thebalance_details);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {

    }
}
