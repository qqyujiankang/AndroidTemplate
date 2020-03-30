package com.cn.android.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.ClassifyBean;
import com.cn.android.bean.HomeData;

public final class ClassAdapter extends BaseQuickAdapter<HomeData.ShopTypeListBean, BaseViewHolder> {
    private Context context;

    public ClassAdapter(Context context) {
        super(R.layout.item_class);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeData.ShopTypeListBean item) {
        TextView view = helper.getView(R.id.tv_class_name);
        helper.setText(R.id.tv_class_name,item.getName());

        if(item.isClick()){
            view.setTextColor(Color.parseColor("#FF222222"));
            view.setBackgroundColor(Color.parseColor("#F6F6F6"));
            view.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            setLeftDrawable(view,R.mipmap.caitiao);
        }else{
            view.setTextColor(Color.parseColor("#FF666666"));
            view.setBackgroundColor(Color.parseColor("#FFFFFF"));
            view.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            setLeftDrawable(view,0);
        }
    }

    private void setLeftDrawable(TextView view,int drawableRes) {
        if(drawableRes==0){
            view.setCompoundDrawables(null,null,null,null);
            return;
        }
        Drawable drawable = context.getResources().getDrawable(drawableRes);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());// 设置边界
        // param 左上右下
        view.setCompoundDrawables(drawable,null,null,null);
    }
}
