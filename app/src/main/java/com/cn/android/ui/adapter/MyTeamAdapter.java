package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 我的团队
 */
public class MyTeamAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;

    public MyTeamAdapter(Context context) {
        super(R.layout.adapter_my_team);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.setText(R.id.tv_name, item.getName());

    }
}
