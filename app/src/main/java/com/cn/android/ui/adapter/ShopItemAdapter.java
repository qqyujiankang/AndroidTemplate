package com.cn.android.ui.adapter;


import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.SelectTypeListByPid;
import com.cn.android.bean.ShopBean;
import com.cn.android.ui.activity.CommodityClassificationActivity;
import com.hjq.image.ImageLoader;


/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/11/05
 *    desc   : 可进行拷贝的副本
 */
public final class ShopItemAdapter extends BaseQuickAdapter<SelectTypeListByPid.ThreeListBean, BaseViewHolder> {

    private Context context;

    public ShopItemAdapter(Context context) {
        super(R.layout.item_shop_item);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectTypeListByPid.ThreeListBean item) {
        if (context instanceof CommodityClassificationActivity){
            helper.setGone( R.id.shop_img ,false);
            helper.setText(R.id.shop_name,item.getName());

        }else {
            ImageView img=helper.getView(R.id.shop_img);
            ImageLoader.with(context).load(item.getImg()).into(img);
            helper.setText(R.id.shop_name,item.getName());
            helper.addOnClickListener(R.id.shop_img);
        }

    }
}