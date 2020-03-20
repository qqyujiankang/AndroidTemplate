package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.cn.android.R;
import com.cn.android.common.MyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的订单
 */
public class MyOrderActivity extends MyActivity {
    @BindView(R.id.rbt_obligation)
    RadioButton rbtObligation;
    @BindView(R.id.rbt_To_send_the_goods)
    RadioButton rbtToSendTheGoods;
    @BindView(R.id.rbt_off_the_stocks)
    RadioButton rbtOffTheStocks;
    @BindView(R.id.btn_remain_to_be_evaluated)
    RadioButton btnRemainToBeEvaluated;
    private int order = 0;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void initView() {
        order = getIntent().getIntExtra("order", 0);

        if (order == 1) {
            rbtObligation.setChecked(true);

        } else if (order == 2) {
            rbtToSendTheGoods.setChecked(true);
        } else if (order == 3) {
            rbtOffTheStocks.setChecked(true);
        } else if (order == 4) {
            btnRemainToBeEvaluated.setChecked(true);
        }
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rbt_obligation, R.id.rbt_To_send_the_goods, R.id.rbt_off_the_stocks, R.id.btn_remain_to_be_evaluated})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbt_obligation:
                break;
            case R.id.rbt_To_send_the_goods:
                break;
            case R.id.rbt_off_the_stocks:
                break;
            case R.id.btn_remain_to_be_evaluated:
                break;
        }
    }
}
