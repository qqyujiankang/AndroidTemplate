package com.cn.android.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.OnShopCartItemListener;
import com.cn.android.R;
import com.cn.android.bean.ShopBean;
import com.cn.android.helper.RadioButtonGroupHelper;
import com.hjq.image.ImageLoader;

import java.util.List;

public class goodsCartAdapter extends BaseQuickAdapter<ShopBean.ShopListBean, BaseViewHolder> {
    private OnShopCartItemListener onShopCartItemListener;
    private int parentPos;
    private Context context;

    public goodsCartAdapter(Context context, int parentPos, OnShopCartItemListener onShopCartItemListener) {
        super( R.layout.item_cart_goods );
        this.parentPos = parentPos;
        this.context = context;
        this.onShopCartItemListener = onShopCartItemListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopBean.ShopListBean item) {
        final int pos = helper.getAdapterPosition();
        addOnClickListener( helper.getView( R.id.goods_add ), pos, parentPos );
        addOnClickListener( helper.getView( R.id.goods_jian ), pos, parentPos );
        ImageView imageView = helper.getView( R.id.goods_img );
        ImageLoader.with( context ).load( item.getShop_img() ).into( imageView );
        helper.setText( R.id.goods_name, item.getShop_name() );
        helper.setText( R.id.goods_price, context.getString( R.string.test01 ) + item.getSku_price() );
        helper.setText( R.id.goods_num, item.getShop_num() + "" );
        addOnClickListener( helper.getView( R.id.goods_num ), pos, parentPos );
        CheckBox checkBox = helper.getView( R.id.goods_check );
        checkBox.setChecked( item.isChecked() );
        checkBox.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                onShopCartItemListener.OnChildCheckedListener( isChecked, parentPos, pos );
            }
        } );
    }

    // 给item中的控件添加点击监听
    private void addOnClickListener(final View view, final int childPos, final int parentPos) {
        if (onShopCartItemListener != null) {
            view.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onShopCartItemListener.onChildItemClickListener( view, childPos, parentPos );
                }
            } );
        }
    }
}
