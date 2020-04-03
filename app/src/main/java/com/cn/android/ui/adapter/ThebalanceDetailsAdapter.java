package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.SelectAccountByUserid;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 余额详情
 * 交易明细
 */
public class ThebalanceDetailsAdapter extends BaseQuickAdapter<SelectAccountByUserid, BaseViewHolder> {
    private Context context;

    public ThebalanceDetailsAdapter(Context context) {
        super( R.layout.adapter_thebalance_details );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectAccountByUserid item) {
        helper.setText( R.id.tv_time, item.getCtime() );

        String type = "";
        if (item.getType() == 1) {
            type = "-";
            helper.setText( R.id.tv_01, "订单支付" );
        } else if (item.getType() == 2) {
            type = "+";
            helper.setText( R.id.tv_01, "提现" );
        }
        helper.setText( R.id.tv_payMoney, type + item.getPayMoney() );

    }
}
