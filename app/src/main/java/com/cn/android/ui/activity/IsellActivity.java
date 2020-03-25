package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.MyOrderAdapter;
import com.cn.android.ui.dialog.QRcoDialog;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我卖出的
 */
public class IsellActivity extends MyActivity {


    @BindView(R.id.rbt_obligation)
    RadioButton rbtObligation;
    @BindView(R.id.rbt_To_send_the_goods)
    RadioButton rbtToSendTheGoods;
    @BindView(R.id.rbt_off_the_stocks)
    RadioButton rbtOffTheStocks;
    @BindView(R.id.btn_remain_to_be_evaluated)
    RadioButton btnRemainToBeEvaluated;
    MyOrderAdapter adapter;
    @BindView(R.id.rv)
    RecyclerView rv;
    List<Commodity.DataBean> dataBeans = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_isell;
    }

    @Override
    protected void initView() {
        myOrder(1);
    }

    @Override
    protected void initData() {

        dataBeans.add(new Commodity.DataBean("", "", "", "", 0));
        dataBeans.add(new Commodity.DataBean("", "", "", "", 0));
        dataBeans.add(new Commodity.DataBean("", "", "", "", 0));
        adapter.setNewData(dataBeans);
    }

    private void myOrder(int order) {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyOrderAdapter(getActivity(), order);
        rv.setAdapter(adapter);
        initData();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.Rl_01:
                        startActivity(TheOrderDetailsActivity.class);
                        break;
                    case R.id.btn_02://CheckTheLogisticsActivity
                        startActivity(CheckTheLogisticsActivity.class);
                        break;
                    case R.id.btn_login_commit:
                        if (order == 3) {
                            new QRcoDialog.Builder(getActivity(), Gravity.TOP, "扫码核销").show();

                        } else {
                            startActivity(PostEvaluationActivity.class);
                        }

                        break;
                }

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rbt_obligation, R.id.rbt_To_send_the_goods, R.id.rbt_off_the_stocks, R.id.btn_remain_to_be_evaluated})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbt_obligation:
                myOrder(1);
                break;
            case R.id.rbt_To_send_the_goods:
                myOrder(2);
                break;
            case R.id.rbt_off_the_stocks:
                myOrder(3);
                break;
            case R.id.btn_remain_to_be_evaluated:
                myOrder(4);
                break;
        }
    }
}
