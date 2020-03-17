package com.cn.android.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.HomeActivity;
import com.hjq.image.ImageLoader;

import butterknife.BindView;

/**
 * 个人中心
 */
public class PersonalCenterFragment extends MyLazyFragment<HomeActivity> {
    @BindView(R.id.iv_information)
    ImageView ivInformation;
    @BindView(R.id.iv_set)
    ImageView ivSet;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_hear)
    ImageView ivHear;

    public static PersonalCenterFragment newInstance() {
        return new PersonalCenterFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal_center;
    }

    @Override
    protected void initView() {
        ImageLoader.with(this)
                .circle()
                .load("https://www.baidu.com/img/bd_logo.png")
                .into(ivHear);
    }

    @Override
    protected void initData() {

    }
}
