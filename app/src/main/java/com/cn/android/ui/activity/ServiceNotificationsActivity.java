package com.cn.android.ui.activity;

import android.os.Bundle;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.bar.TitleBar;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 服务通知
 */
public class ServiceNotificationsActivity extends MyActivity {
    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.rv)
    RecyclerView rv;
    private String name;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_service_notifications;
    }

    @Override
    protected void initView() {
        name = getIntent().getStringExtra("TestTitle");
        tTestTitle.setTitle(name);


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

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }
}
