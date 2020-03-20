package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品管理
 */
public class CommodityManagementActivity extends MyActivity {
    @BindView(R.id.rbt_obligation)
    RadioButton rbtObligation;
    @BindView(R.id.rbt_To_send_the_goods)
    RadioButton rbtToSendTheGoods;
    @BindView(R.id.tite_bar)
    TitleBar titeBar;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commodity_management;
    }

    @Override
    protected void initView() {
        titeBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {

            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {
                startActivity(UploadTheGoodsActivity.class);

            }
        });
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

    @OnClick({R.id.rbt_obligation, R.id.rbt_To_send_the_goods})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbt_obligation:
                break;
            case R.id.rbt_To_send_the_goods:
                break;
        }
    }

}
