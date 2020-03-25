package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.cn.android.R;
import com.cn.android.common.MyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 性别
 * gender
 */
public class Genderctivity extends MyActivity {
    @BindView(R.id.tv_man)
    CheckBox tvMan;
    @BindView(R.id.ll_man)
    RelativeLayout llMan;
    @BindView(R.id.tv_woman)
    CheckBox tvWoman;
    @BindView(R.id.Rl_tv_woman)
    RelativeLayout RlTvWoman;
    @BindView(R.id.tv_confidentiality)
    CheckBox tvConfidentiality;
    @BindView(R.id.Rl_tv_confidentiality)
    RelativeLayout RlTvConfidentiality;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_genderctivity;
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

    @OnClick({R.id.ll_man, R.id.Rl_tv_woman, R.id.Rl_tv_confidentiality})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_man:
                chein(0);
                break;
            case R.id.Rl_tv_woman:
                chein(1);
                break;
            case R.id.Rl_tv_confidentiality:
                chein(2);
                break;
        }
    }

    private void chein(int i) {
        if (i == 0) {
            tvMan.setChecked(true);
            tvConfidentiality.setChecked(false);
            tvWoman.setChecked(false);
        } else if (i == 1) {
            tvMan.setChecked(false);
            tvConfidentiality.setChecked(false);
            tvWoman.setChecked(true);
        } else if (i == 2) {
            tvMan.setChecked(false);
            tvConfidentiality.setChecked(true);
            tvWoman.setChecked(false);
        }
    }
}
