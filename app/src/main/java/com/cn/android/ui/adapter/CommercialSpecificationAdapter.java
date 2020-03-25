package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.BannerBean;
import com.cn.android.bean.Commodity;

import java.util.List;

/**
 * 上传商品的规格
 */
public class CommercialSpecificationAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;

    public CommercialSpecificationAdapter(Context context) {
        super(R.layout.adapter_commercial_specification);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
       // helper.setText(R.id.tv_name, item.getName());
        helper.addOnClickListener(R.id.iv_add);
    }


}
