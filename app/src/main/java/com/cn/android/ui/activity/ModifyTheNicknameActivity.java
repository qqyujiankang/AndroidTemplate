package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Modify the nickname
 */
public class ModifyTheNicknameActivity extends MyActivity implements OnTitleBarListener {


    @BindView(R.id.tib)
    TitleBar tib;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_the_nickname;
    }

    @Override
    protected void initView() {
        tib.setOnTitleBarListener(this);

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

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
        finish();
    }
}
