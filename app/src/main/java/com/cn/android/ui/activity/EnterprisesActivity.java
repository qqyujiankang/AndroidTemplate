package com.cn.android.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.widget.view.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 企业入驻
 */
public class EnterprisesActivity extends MyActivity {


    @BindView(R.id.sb_test_switch)
    SwitchButton sbTestSwitch;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_enterprises;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btn_bind_commit)
    public void onViewClicked() {
        startActivity(OpeningOfTheEnterpriseActivity.class);
    }
}
