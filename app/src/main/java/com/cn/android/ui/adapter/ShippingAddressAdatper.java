package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.AddressByUserid;
import com.cn.android.bean.Commodity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 收货地址
 */
public class ShippingAddressAdatper extends BaseQuickAdapter<AddressByUserid, BaseViewHolder> {
    public ShippingAddressAdatper(Context context) {
        super( R.layout.adatper_shipping_address );
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressByUserid item) {
        helper.setText( R.id.tv_name,item.getName() );
        helper.setText( R.id.tv_phone,item.getPhone() );
        helper.setText( R.id.tv_add,item.getProCityArea() +item.getAddress());
        helper.addOnClickListener( R.id.Rl_01 );

    }
}
