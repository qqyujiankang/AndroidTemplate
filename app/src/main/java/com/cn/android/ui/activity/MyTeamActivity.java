package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.MyTeamAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的团队
 */
public class MyTeamActivity extends MyActivity {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_hear)
    ImageView ivHear;
    @BindView(R.id.tv_balance_of_account)
    TextView tvBalanceOfAccount;
    @BindView(R.id.tv_view_details)
    TextView tvViewDetails;
    @BindView(R.id.rv)
    RecyclerView rv;

    MyTeamAdapter myTeamAdapter;
    @BindView(R.id.tv_ti_xian)
    TextView tvTiXian;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_team;
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myTeamAdapter = new MyTeamAdapter(getActivity());
        rv.setAdapter(myTeamAdapter);
    }

    @Override
    protected void initData() {
        List<Commodity.DataBean> dataBeans = new ArrayList<>();
        dataBeans.add(new Commodity.DataBean("", "昵称", "", "", 0));
        dataBeans.add(new Commodity.DataBean("", "昵称", "", "", 0));
        myTeamAdapter.setNewData(dataBeans);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_view_details, R.id.tv_ti_xian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_ti_xian:
                startActivity(WithdrawDepositActivity.class);
                break;
            case R.id.tv_view_details:
                startActivity(ThebalanceDetailsActivity.class);
                break;
        }
    }
}
