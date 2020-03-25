package com.cn.android;

import android.view.View;

/**
 * @author Created by stone
 * @since 2019/3/14
 * <p>
 * 购物车中CheckBox选择监听器
 */
public interface OnShopCartItemListener {

    // 父Item checkBox选择监听
    void OnParentCheckedListener(boolean checked, int pos);

    // 子Item checkBox选择监听
    void OnChildCheckedListener(boolean checked, int parentPos, int childPos);

    // 子Item中的控件点击监听
    void onChildItemClickListener(View view, int childPos, int parentPos);
}
