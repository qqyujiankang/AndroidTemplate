package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.widget.view.ClearEditText;
import com.hjq.widget.view.CountdownView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewRegisterActivity extends MyActivity {
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.et_login_phone)
    ClearEditText etLoginPhone;
    @BindView(R.id.cv_bind_countdown)
    CountdownView cvBindCountdown;
    @BindView(R.id.iv_Invitation_code)
    ImageView ivInvitationCode;
    @BindView(R.id.et_Invitation_code)
    ClearEditText etInvitationCode;
    @BindView(R.id.btn_login_commit)
    Button btnLoginCommit;
    @BindView(R.id.btn_register)
    Button btnRegister;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_register;
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

    @OnClick({R.id.btn_login_commit, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login_commit:
                finish();
                break;
            case R.id.btn_register:
                finish();
                break;
        }
    }
}
