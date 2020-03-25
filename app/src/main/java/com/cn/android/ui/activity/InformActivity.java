package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.cn.android.R;
import com.cn.android.common.MyActivity;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的通知
 */
public class InformActivity extends MyActivity {


    @BindView(R.id.ll_ServiceNotifications)
    LinearLayout llServiceNotifications;
    @BindView(R.id.ll_special_promotion)
    LinearLayout llSpecialPromotion;
    @BindView(R.id.ll_my_team)
    LinearLayout llMyTeam;
    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_inform;
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

    @OnClick({R.id.ll_ServiceNotifications, R.id.ll_special_promotion, R.id.ll_my_team})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.ll_ServiceNotifications://服务通知
                intent.putExtra("TestTitle", "服务通知");
                intent.setClass(getActivity(), ServiceNotificationsActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_special_promotion://
                intent.putExtra("TestTitle", "优惠促销");
                intent.setClass(getActivity(), ServiceNotificationsActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_my_team://kefu
                startActivity(ServiceActivity.class);

                break;

        }
    }
}
