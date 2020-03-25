package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 优秀营销师
 */
public class TheMarketingDivisionAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    public TheMarketingDivisionAdapter(Context context) {
        super(R.layout.adapter_the_marketin_division);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.addOnClickListener(R.id.ll_01);
    }
}
