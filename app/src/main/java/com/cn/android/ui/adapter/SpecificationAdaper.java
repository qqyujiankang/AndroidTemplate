package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.ProductDetails;
import com.cn.android.bean.ShopBean;

import java.util.List;

import androidx.annotation.Nullable;

/**
 *
 */
public class SpecificationAdaper extends BaseQuickAdapter<ProductDetails.SkuListBean, BaseViewHolder> {
    private Context context;

    public SpecificationAdaper(Context context) {
        super( R.layout.adaper_specification );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductDetails.SkuListBean item) {
        helper.setText( R.id.btn, item.getSkuName() );
    }
}
