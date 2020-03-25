package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.dialog.QRcoDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 营销师详情
 */
public class DetailsOfMarketingDivisionActivity extends MyActivity {
    @BindView(R.id.tv01)
    TextView tv01;
    @BindView(R.id.iv_01)
    ImageView iv01;
    @BindView(R.id.iv_02)
    ImageView iv02;
    @BindView(R.id.tv_02)
    TextView tv02;
    @BindView(R.id.tv03)
    TextView tv03;
    @BindView(R.id.tv04)
    TextView tv04;
    @BindView(R.id.tv05)
    TextView tv05;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_details_of_marketing_division);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_of_marketing_division;
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

    @OnClick(R.id.iv_02)
    public void onViewClicked() {
        new QRcoDialog.Builder(getActivity(), Gravity.TOP, "扫一扫二维码，加微信").show();
    }
}
