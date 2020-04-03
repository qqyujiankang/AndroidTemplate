package com.cn.android.ui.activity;


import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.SelectTypeListByPid;
import com.hjq.image.ImageLoader;


/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/11/05
 * desc   : 可进行拷贝的副本
 */
public final class Class3ItemAdapter extends BaseQuickAdapter<SelectTypeListByPid.ThreeListBean, BaseViewHolder> {

    private Context context;

    public Class3ItemAdapter(Context context) {
        super( R.layout.item_class_item );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectTypeListByPid.ThreeListBean item) {


        helper.setText( R.id.shop_name, item.getName() );
     //   helper.addOnClickListener(  R.id.shop_name);


    }
}