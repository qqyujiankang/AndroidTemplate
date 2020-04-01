package com.cn.android.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.hjq.image.ImageLoader;

import java.util.List;

public class MorepicturesAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Context context;

    public MorepicturesAdapter(Context context) {
        super(R.layout.adapter_more_pictures);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.iv_particulars);
        ImageView imageView = helper.getView(R.id.iv_particulars);
        ImageLoader.with(context).load(item).error(context.getResources().getDrawable(R.mipmap.tj)).into(imageView);
    }
}
