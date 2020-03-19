package com.cn.android.ui.activity;

import android.os.Bundle;

import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.DiscountCouponAdapter;
import com.cn.android.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 优惠券
 */
public class DiscountCouponActivity extends MyActivity {


    @BindView(R.id.rv_dc)
    RecyclerView rvDc;
    DiscountCouponAdapter discountCouponAdapter;
    List<Commodity.DataBean> dataBeans=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_discount_coupon;
    }

    @Override
    protected void initView() {
        dataBeans.add(new Commodity.DataBean("50","满300元可用","2020年10月21日—2020年11月28日",""));
        dataBeans.add(new Commodity.DataBean("50","满300元可用","2020年10月21日—2020年11月28日",""));
        dataBeans.add(new Commodity.DataBean("50","满300元可用","2020年10月21日—2020年11月28日",""));
        dataBeans.add(new Commodity.DataBean("50","满300元可用","2020年10月21日—2020年11月28日",""));
        dataBeans.add(new Commodity.DataBean("50","满300元可用","2020年10月21日—2020年11月28日",""));
        rvDc.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDc.addItemDecoration(new SpaceItemDecoration(30));
        discountCouponAdapter=new DiscountCouponAdapter(R.layout.adapter_discount_coupon,dataBeans);
        rvDc.setAdapter(discountCouponAdapter);

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
}
