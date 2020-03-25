package com.cn.android.ui.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.OnShopCartItemListener;
import com.cn.android.R;
import com.cn.android.bean.ShopBean;
import com.cn.android.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class shopCartAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {
    goodsCartAdapter adapter;
    private OnShopCartItemListener onShopCartItemListener;
    public shopCartAdapter(@Nullable List<ShopBean> data,OnShopCartItemListener onShopCartItemListener) {
        super(R.layout.item_cart_shop, data);
        this.onShopCartItemListener = onShopCartItemListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopBean item) {
        final int pos = helper.getAdapterPosition();
        RecyclerView recyclerView = helper.getView(R.id.shop_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(helper.itemView.getContext()));
        recyclerView.addItemDecoration(new SpaceItemDecoration(1));
        adapter = new goodsCartAdapter(item.getList(),pos,onShopCartItemListener);
        recyclerView.setAdapter(adapter);
        helper.getView(R.id.goods_num);



    }



//    private List<ShopBean.ShopItem> getdata() {
//        List<ShopBean> lists = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            lists.add(new ShopBean(""));
//        }
//        return lists;
//    }

}
