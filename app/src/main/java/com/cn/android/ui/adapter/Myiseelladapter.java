package com.cn.android.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;

/**
 * 我的卖出的
 */
public class Myiseelladapter extends BaseQuickAdapter<Commodity.DataBean, BaseViewHolder> {
    private Context context;

    public Myiseelladapter(Context context) {
        super( R.layout.adapter_my_iseell );
        this.context = context;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void convert(BaseViewHolder helper, Commodity.DataBean item) {
        helper.addOnClickListener( R.id.btn_01 );
        helper.addOnClickListener( R.id.btn_02 );
        helper.setText( R.id.tv_01, context.getString( R.string.test01 ) + "4564464" );
        if (item.getDrawable() == 1) {
            helper.setGone( R.id.rl03, false );
        } else if (item.getDrawable() == 2) {
            helper.setGone( R.id.rl03, true );
            helper.setBackgroundRes( R.id.btn_01, R.drawable.selector_button );
            // helper.setBackgroundColor( R.id.btn_01,R.drawable.selector_button);

        } else if (item.getDrawable() == 3) {
            helper.setText( R.id.btn_01, "联系买家" );
            helper.setText( R.id.btn_02, "查看物流" );
            helper.setBackgroundRes( R.id.btn_01, R.drawable.bg_w );
            helper.setTextColor( R.id.btn_01, R.color.color666666 );
            helper.setGone( R.id.rl03, true );
            // helper.setBackgroundColor( R.id. btn_01,R.drawable.bg_w);
        }
    }
}
