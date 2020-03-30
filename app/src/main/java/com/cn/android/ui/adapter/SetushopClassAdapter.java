package com.cn.android.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.HomeData;

public final class SetushopClassAdapter extends BaseQuickAdapter<HomeData.ShopTypeListBean, BaseViewHolder> {
    private Context context;

    public SetushopClassAdapter(Context context) {
        super( R.layout.item_class1 );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeData.ShopTypeListBean item) {
        helper.setText( R.id.tv_class_name, item.getName() );


    }


}
