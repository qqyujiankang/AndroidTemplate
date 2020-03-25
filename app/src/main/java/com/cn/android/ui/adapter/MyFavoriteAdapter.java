package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 我的收藏
 */
public class MyFavoriteAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;

    public MyFavoriteAdapter(Context context) {
        super(R.layout.adapter_my_favorite);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {

    }
}
