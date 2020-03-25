package com.cn.android.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.ThebalanceDetailsAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 余额详情
 */
public class ThebalanceDetailsActivity extends MyActivity {
    @BindView(R.id.tv_balance_of_account)
    TextView tvBalanceOfAccount;
    @BindView(R.id.rv)
    RecyclerView rv;
    ThebalanceDetailsAdapter thebalanceDetailsAdapter;
    List<Commodity.DataBean>dataBeans=new ArrayList<>();

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thebalance_details);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_thebalance_details;
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        thebalanceDetailsAdapter=new ThebalanceDetailsAdapter(getActivity());
        rv.setAdapter(thebalanceDetailsAdapter);
    }

    @Override
    protected void initData() {
        for (int i=0;i<10;i++){
            dataBeans.add(new Commodity.DataBean("","","","",0));
        }
        thebalanceDetailsAdapter.setNewData(dataBeans);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
