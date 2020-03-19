package com.cn.android.ui.fragment;

import com.cn.android.R;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.HomeActivity;

/**
 * 购物车
 */
public class ShoppingTrolleyFragment extends MyLazyFragment<HomeActivity> {
    public static MyLazyFragment newInstance() {
        return new ShoppingTrolleyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shopping_trolley;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
