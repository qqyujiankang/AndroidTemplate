package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 分类商铺
 */
public class StoreClassiFicationAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {

    public StoreClassiFicationAdapter(Context context) {
        super(R.layout.adapter_store_classi_fication);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.setBackgroundRes(R.id.rv, item.getDrawable());
        helper.setText(R.id.tv01, item.getName());
        helper.addOnClickListener(R.id.rv);

    }
}
