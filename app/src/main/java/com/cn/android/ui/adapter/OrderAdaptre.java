package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.CommodityManagement;
import com.cn.android.utils.DataUtils;

/**
 * 确认人订单
 */
public class OrderAdaptre extends BaseQuickAdapter<CommodityManagement.ShopListBean, BaseViewHolder> {
    private Context context;

    public OrderAdaptre(Context context) {
        super( R.layout.adaptre_order );
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityManagement.ShopListBean item) {
        helper.setText( R.id.tv_money, context.getString( R.string.test01 ) + DataUtils.getMoney( item.getShop_money() ) );
        helper.setText( R.id.tv_test02,item.getShop_name() );
        helper.setText( R.id.tv_test03,"规格 "+item.getSku() );
        helper.setText( R.id.tv_shop_num,"X "+item.getShop_num() );


    }
}
