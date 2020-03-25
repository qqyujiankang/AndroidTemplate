package com.cn.android.ui.activity;

import android.os.Bundle;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.widget.layout.SettingBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 账号管理
 */
public class AccountManagementActivity extends MyActivity {


    @BindView(R.id.sb_Version_checking)
    SettingBar sbVersionChecking;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_management;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sb_Version_checking)
    public void onViewClicked() {
        startActivity(BindPhoneActivity.class);
    }
}
