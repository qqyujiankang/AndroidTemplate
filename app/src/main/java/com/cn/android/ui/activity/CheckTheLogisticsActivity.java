package com.cn.android.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.CheckTheLogisticsAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 物流信息
 */
public class CheckTheLogisticsActivity extends MyActivity {


    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.iv_01)
    ImageView iv01;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_03)
    TextView tv03;
    @BindView(R.id.tv_04)
    TextView tv04;
    @BindView(R.id.rv)
    RecyclerView rv;
    CheckTheLogisticsAdapter checkTheLogisticsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_check_the_logistics;
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        checkTheLogisticsAdapter = new CheckTheLogisticsAdapter(getActivity());
        rv.setAdapter(checkTheLogisticsAdapter);
    }

    @Override
    protected void initData() {
        List<Commodity.DataBean> beans = new ArrayList<>();
        beans.add(new Commodity.DataBean("", "陕西省西安市高新四路丹枫国际B座", "2020-02-16 12:24:10", "", 0));
        beans.add(new Commodity.DataBean("", "派送中，西安市高新区派送员，陈先生正在派送", "2020-02-16 12:24:10", "", 0));
        beans.add(new Commodity.DataBean("", "西安转运中心公司 已接收", "2020-02-16 12:24:10", "", 0));
        beans.add(new Commodity.DataBean("", "广州转运中心公司 已打包", "2020-02-16 12:24:10", "", 0));
        beans.add(new Commodity.DataBean("", "已发货 已接收", "2020-02-16 12:24:10", "", 0));
        checkTheLogisticsAdapter.setNewData(beans);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
