package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cn.android.R;
import com.cn.android.common.MyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录身份
 */
public class TheloginIdActivity extends MyActivity {
    @BindView(R.id.btn_Enterprise_portal)
    Button btnEnterprisePortal;
    @BindView(R.id.btn_Personal_portal)
    Button btnPersonalPortal;
    public static int state = 0;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_thelogin_id;
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

    @OnClick({R.id.btn_Enterprise_portal, R.id.btn_Personal_portal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_Enterprise_portal:
                state = 1;
                startActivity(LoginIDActivity.class);
                break;
            case R.id.btn_Personal_portal:
                state = 2;
                startActivity(LoginIDActivity.class);
                break;
        }
    }
}
