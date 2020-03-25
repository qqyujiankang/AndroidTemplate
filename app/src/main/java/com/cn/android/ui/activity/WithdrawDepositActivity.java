package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.dialog.BindingAccountDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 提现
 */
public class WithdrawDepositActivity extends MyActivity {


    @BindView(R.id.tv_balance_of_account)
    TextView tvBalanceOfAccount;
    @BindView(R.id.tv_view_details)
    TextView tvViewDetails;
    @BindView(R.id.tv_upper)
    CheckBox tvUpper;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.tv02)
    CheckBox tv02;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_withdraw_deposit;
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
        ButterKnife.bind(this);//
    }


    @OnClick({R.id.tv_view_details, R.id.relativeLayout, R.id.rl_search, R.id.btn_bind_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_view_details:
                startActivity(ThebalanceDetailsActivity.class);
                break;
            case R.id.relativeLayout:
                tvUpper.setChecked(true);
                tv02.setChecked(false);
                break;
            case R.id.rl_search:
                tvUpper.setChecked(false);
                tv02.setChecked(true);
                break;
            case R.id.btn_bind_commit:
                new BindingAccountDialog.Builder(getActivity()).show();
                break;
        }
    }
}
