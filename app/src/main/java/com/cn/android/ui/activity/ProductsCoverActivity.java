package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

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

/**
 * Products cover商品自荐
 */
public class ProductsCoverActivity extends MyActivity implements OnTitleBarListener {


    @BindView(R.id.rv_products_cover)
    RecyclerView rvProductsCover;
    CommodityManagementAdapter commodityManagementAdapter;
    @BindView(R.id.ttb)
    TitleBar ttb;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_products_cover;
    }

    List<Commodity.DataBean> dataBeans = new ArrayList<>();

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        ttb.setOnTitleBarListener(this);
        rvProductsCover.addItemDecoration(new SpaceItemDecoration(2));
        //设置布局管理器， 参数gridLayoutManager对象
        rvProductsCover.setLayoutManager(new LinearLayoutManager(getActivity()));
        commodityManagementAdapter = new CommodityManagementAdapter(getActivity(), 0);
        rvProductsCover.setAdapter(commodityManagementAdapter);

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
      //  commodityManagementAdapter.setNewData(dataBeans);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
        if (!ttb.getRightTitle().toString().equals("保存")) {
            ttb.setRightTitle("保存");
            commodityManagementAdapter = new CommodityManagementAdapter(getActivity(), 1);
            rvProductsCover.setAdapter(commodityManagementAdapter);
            initData();
        } else {
            finish();
        }
    }
}
