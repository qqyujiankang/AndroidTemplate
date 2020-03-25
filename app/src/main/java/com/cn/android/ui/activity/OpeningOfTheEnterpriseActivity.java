package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.cn.android.R;
import com.cn.android.common.MyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 开通企业
 */
public class OpeningOfTheEnterpriseActivity extends MyActivity {
    @BindView(R.id.tv_upper)
    CheckBox tvUpper;
    @BindView(R.id.Rl_01)
    RelativeLayout Rl01;
    @BindView(R.id.cb02)
    CheckBox cb02;
    @BindView(R.id.Rl_02)
    RelativeLayout Rl02;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_opening_of_the_enterprise;
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

    @OnClick({R.id.Rl_01, R.id.Rl_02, R.id.btn_bind_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Rl_01:
                tvUpper.setChecked(true);
                cb02.setChecked(false);
                break;
            case R.id.Rl_02:
                tvUpper.setChecked(false);
                cb02.setChecked(true);
                break;
            case R.id.btn_bind_commit:
                finish();
                break;
        }
    }
}
