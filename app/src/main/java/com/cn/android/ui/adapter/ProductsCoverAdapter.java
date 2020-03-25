package com.cn.android.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * cover商品自荐
 */
public class ProductsCoverAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    public ProductsCoverAdapter(int layoutResId, @Nullable List<Commodity.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.setText(R.id.tv_name, item.getName());
    }
}
