package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/*
优质店铺
 */
public class HighQualityShopsAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    public HighQualityShopsAdapter(Context context) {
        super(R.layout.adapter_high_quality_shops);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.addOnClickListener(R.id.btn_login_commit);
    }
}
