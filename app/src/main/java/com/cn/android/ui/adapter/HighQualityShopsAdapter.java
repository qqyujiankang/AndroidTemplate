package com.cn.android.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.HomeData;
import com.hjq.image.ImageLoader;

import java.util.List;

import androidx.annotation.Nullable;

/*
优质店铺
 */
public class HighQualityShopsAdapter extends BaseQuickAdapter<HomeData.AppUserListBean, BaseViewHolder> {
    private Context context;
    public HighQualityShopsAdapter(Context context) {
        super( R.layout.adapter_high_quality_shops );
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeData.AppUserListBean item) {
        helper.addOnClickListener( R.id.btn_login_commit );
        ImageView img=helper.getView(R.id.iv);
        ImageLoader.with(context).load(item.getStoreImg()).into(img);
        helper.setText( R.id.tv_name, item.getStoreTypName());
    }
}
