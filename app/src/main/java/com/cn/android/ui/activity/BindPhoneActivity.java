package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.widget.view.CountdownView;
import com.hjq.widget.view.RegexEditText;

import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 更换手机
 */
public class BindPhoneActivity extends MyActivity implements OnTitleBarListener {


    @BindView(R.id.btn)
    TitleBar btn;
    @BindView(R.id.et_bind_phone)
    RegexEditText etBindPhone;
    @BindView(R.id.iv01)
    ImageView iv01;
    @BindView(R.id.et_bind_code)
    AppCompatEditText etBindCode;
    @BindView(R.id.cv_bind_countdown)
    CountdownView cvBindCountdown;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_phone;
    }

    @Override
    protected void initView() {
        btn.setOnTitleBarListener(this);
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
