package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.ui.activity.CommodityManagementActivity;
import com.cn.android.ui.activity.InformActivity;
import com.cn.android.ui.activity.ProductsCoverActivity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * CommodityManagement商品管理
 */
public class CommodityManagementAdapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;
    private int anInt;

    public CommodityManagementAdapter(Context context, int i) {
        super(R.layout.adapter_commodity_management);
        this.context = context;
        this.anInt = i;
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        if (item.getName().equals("bao")) {
            helper.setGone(R.id.iv_bao, true);
        } else {
            helper.setGone(R.id.iv_bao, false);
        }
        if (context instanceof ProductsCoverActivity) {
            if (anInt == 1) {
                if (item.getName().equals("bao")) {
                    helper.setBackgroundRes(R.id.iv, R.mipmap.test34);
                }else {
                    helper.setBackgroundRes(R.id.iv, R.mipmap.test35);
                }
                helper.setGone(R.id.rl_search,false);
            }
        } else {

        }

    }
}
