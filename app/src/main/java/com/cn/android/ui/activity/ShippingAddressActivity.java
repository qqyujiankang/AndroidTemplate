package com.cn.android.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.bar.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收货地址
 */
public class ShippingAddressActivity extends MyActivity {


    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shipping_address;
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

    @OnClick(R.id.btn_bind_commit)
    public void onViewClicked() {
        startActivity(AddressDetailActivity.class);
    }
}
