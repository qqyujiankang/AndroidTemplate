package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.DiscountCoupon;
import com.cn.android.common.MyActivity;
import com.cn.android.helper.RadioButtonGroupHelper;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.DiscountCouponAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.bar.TitleBar;
import com.hjq.widget.layout.HintLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 优惠券
 */
public class DiscountCouponActivity extends MyActivity implements
        PublicInterfaceView, OnRefreshListener, OnLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {


    DiscountCouponAdapter discountCouponAdapter;
    @BindView(R.id.titleBar)
    TitleBar titleBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    private PublicInterfaceePresenetr presenetr;
    private boolean isUpRefresh = true;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_discount_coupon;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 30 ) );
        discountCouponAdapter = new DiscountCouponAdapter( getActivity() );
        recyclerView.setAdapter( discountCouponAdapter );
        discountCouponAdapter.setOnItemChildClickListener( this::onItemChildClick );

    }

    @Override
    protected void initData() {
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectConpostByUserid, Constant.selectConpostByUserid );

    }

    int page = 1;
    int rows = 10;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.selectConpostByUserid:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );
                return paramsMap;

        }
        return null;
    }

    List<DiscountCoupon> couponArrayList = new ArrayList<>();
    List<DiscountCoupon> couponArrayList1 = new ArrayList<>();

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        if (isUpRefresh) {
            couponArrayList1.clear();
        }
        smartRefresh.closeHeaderOrFooter();
        if (!data.equals( "[]" )) {
            ivHintIcon.hide();
            couponArrayList = GsonUtils.getPersons( data, DiscountCoupon.class );
            couponArrayList1.addAll( couponArrayList );
            discountCouponAdapter.replaceData( couponArrayList1 );
        } else if (couponArrayList.size() == 0) {
            ivHintIcon.show();
        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        isUpRefresh = false;
        page = page + 1;
        initData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        isUpRefresh = true;
        page = 1;
        initData();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        DiscountCoupon discountCoupon = couponArrayList1.get( position );
        Intent intent = getIntent();
        intent.putExtra( "discountCoupon", discountCoupon );
        setResult( 300, intent );
        finish();
    }
}
