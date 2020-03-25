package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

/**
 * 优秀营销师
 */
public class MarketingDivisionAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    public MarketingDivisionAdapter(Context context) {
        super(R.layout.adapter_marketin_division);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.setBackgroundRes(R.id.iv01,item.getDrawable());
        helper.addOnClickListener(R.id.rl_search);

    }
}
