package com.cn.android.ui.adapter;

import android.content.Context;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.DiscountCoupon;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 优惠券
 */
public class DiscountCouponAdapter extends BaseQuickAdapter<DiscountCoupon, BaseViewHolder> {
    private Context context;

    public DiscountCouponAdapter(Context context) {
        super( R.layout.adapter_discount_coupon );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscountCoupon item) {
        Log.i( "Https=================", item.getId() );
        //
        if (item.getIsUse() == 1) {
            helper.setBackgroundRes( R.id.ll01, R.mipmap.yes_discount );
        } else if (item.getIsUse() == 2) {
            helper.setBackgroundRes( R.id.ll01, R.mipmap.test25 );
        }
        helper.setText( R.id.tv_price, context.getString( R.string.test01 ) + item.getUseMoney() + "" );
        helper.setText( R.id.tv_usable, item.getContent() );
        helper.setText( R.id.tv_time, item.getStime() + "-"+item.getEtime() );
        helper.addOnClickListener( R.id.ll01 );
    }
}
