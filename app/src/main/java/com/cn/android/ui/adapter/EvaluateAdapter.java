package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 评价
 */
public class EvaluateAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    public EvaluateAdapter(Context context) {
        super(R.layout.adapter_evaluate);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {

    }
}
