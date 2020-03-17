package com.cn.android.ui.fragment;

import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.HomeActivity;

/**
 * 首页
 */
public class HomePageFragment extends MyLazyFragment<HomeActivity> {
    public static MyLazyFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
