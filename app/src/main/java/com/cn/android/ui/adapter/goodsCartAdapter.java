package com.cn.android.ui.adapter;

import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.OnShopCartItemListener;
import com.cn.android.R;
import com.cn.android.bean.ShopBean;

import java.util.List;

public class goodsCartAdapter extends BaseQuickAdapter<ShopBean.ShopItem, BaseViewHolder> {
    private OnShopCartItemListener onShopCartItemListener;
    private int parentPos;

    public goodsCartAdapter(@Nullable List<ShopBean.ShopItem> data, int parentPos, OnShopCartItemListener onShopCartItemListener) {
        super(R.layout.item_cart_goods, data);
        this.parentPos = parentPos;
        this.onShopCartItemListener = onShopCartItemListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopBean.ShopItem item) {
        final int pos = helper.getAdapterPosition();
        addOnClickListener(helper.getView(R.id.goods_add), pos, parentPos);
        addOnClickListener(helper.getView(R.id.goods_jian), pos, parentPos);
        helper.setText(R.id.goods_num, item.getGoods_num());
        addOnClickListener(helper.getView(R.id.goods_num), pos, parentPos);

    }

    // 给item中的控件添加点击监听
    private void addOnClickListener(final View view, final int childPos, final int parentPos) {
        if (onShopCartItemListener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onShopCartItemListener.onChildItemClickListener(view, childPos, parentPos);
                }
            });
        }
    }
}
