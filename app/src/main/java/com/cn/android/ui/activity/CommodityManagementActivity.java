package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.CommodityManagementAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品管理
 */
public class CommodityManagementActivity extends MyActivity implements OnTitleBarListener {
    @BindView(R.id.rbt_obligation)
    RadioButton rbtObligation;
    @BindView(R.id.rbt_To_send_the_goods)
    RadioButton rbtToSendTheGoods;
    @BindView(R.id.tite_bar)
    TitleBar titeBar;
    CommodityManagementAdapter commodityManagementAdapter;
    @BindView(R.id.iv)
    RecyclerView iv;

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
        titeBar.setOnTitleBarListener(this);
        iv.setLayoutManager(new LinearLayoutManager(getActivity()));
        iv.addItemDecoration(new SpaceItemDecoration(1));
        commodityManagementAdapter = new CommodityManagementAdapter(getActivity(),0);
        iv.setAdapter(commodityManagementAdapter);
    }


    @Override
    protected void initData() {
        List<Commodity.DataBean> dataBeans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                dataBeans.add(new Commodity.DataBean("", "bao", "", "", 0));


            } else {
                dataBeans.add(new Commodity.DataBean("", "4", "", "", 0));
            }

        }
        commodityManagementAdapter.setNewData(dataBeans);
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

    @Override
    public void onRightClick(View v) {
        startActivity(UploadTheGoodsActivity.class);

    }
}
