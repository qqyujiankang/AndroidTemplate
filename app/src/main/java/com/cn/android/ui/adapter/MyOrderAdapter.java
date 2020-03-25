package com.cn.android.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 我的订单
 */
public class MyOrderAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;
    private int order;

    public MyOrderAdapter(Context context, int order) {
        super(R.layout.adapter_my_order);
        this.context = context;
        this.order = order;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.addOnClickListener(R.id.Rl_01);
        if (order == 1) {
            helper.setText(R.id.btn_login_commit, "去付款");

        } else if (order == 2) {

            helper.setText(R.id.btn_login_commit, "联系客服");
        } else if (order == 3) {
            helper.addOnClickListener(R.id.btn_login_commit);
            helper.setText(R.id.btn_login_commit, "收货码");
            helper.setVisible(R.id.btn_01, true);
            helper.setVisible(R.id.btn_02, true);
            helper.setText(R.id.btn_01, "确认收货");
            helper.setText(R.id.btn_02, "查看物流");
            helper.addOnClickListener(R.id.btn_02);
            helper.setTextColor(R.id.btn_02, context.getResources().getColor(R.color.huise));
            helper.setBackgroundRes(R.id.btn_02, R.drawable.bg_home_search_bar_transparent);
        } else if (order == 4) {
            helper.setText(R.id.btn_login_commit, "去评价");
            helper.addOnClickListener(R.id.btn_login_commit);
        }
    }
}
