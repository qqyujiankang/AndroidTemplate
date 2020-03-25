package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.widget.layout.SettingBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 确认订单
 */
public class ConfirmAnOrderActivity extends MyActivity {


    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.vv_1)
    View vv1;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_site)
    TextView tvSite;
    @BindView(R.id.add_tv)
    TextView addTv;
    @BindView(R.id.iv_tet10)
    ImageView ivTet10;
    @BindView(R.id.tv_test02)
    TextView tvTest02;
    @BindView(R.id.tv_test03)
    TextView tvTest03;
    @BindView(R.id.vv_2)
    View vv2;
    @BindView(R.id.sb_setting_language)
    SettingBar sbSettingLanguage;
    @BindView(R.id.tv_upper)
    CheckBox tvUpper;
    @BindView(R.id.ll_01)
    RelativeLayout ll01;
    @BindView(R.id.cb02)
    CheckBox cb02;
    @BindView(R.id.ll02)
    RelativeLayout ll02;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_confirm_an_order;
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

    @OnClick({R.id.add_tv, R.id.sb_setting_language, R.id.ll_01, R.id.ll02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_tv:
                startActivity(ShippingAddressActivity.class);
                break;
            case R.id.sb_setting_language:
                startActivity(DiscountCouponActivity.class);
                break;
            case R.id.ll_01:
                tvUpper.setChecked(true);
                cb02.setChecked(false);
                break;
            case R.id.ll02:
                tvUpper.setChecked(false);
                cb02.setChecked(true);
                break;
        }
    }


//    @OnClick({R.id.add_tv, R.id.sb_setting_language})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.add_tv:
//
//                break;
//            case R.id.sb_setting_language:
//
//                break;
//        }
//    }
}
