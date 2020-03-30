package com.cn.android.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.DiscountCoupon;
import com.cn.android.bean.SelectAccountByUserid;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.ThebalanceDetailsAdapter;
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

import static com.cn.android.network.ServerUrl.selectAccountByUserid;

/**
 * 余额详情
 */
public class ThebalanceDetailsActivity extends MyActivity implements PublicInterfaceView, OnRefreshListener, OnLoadMoreListener {
    ThebalanceDetailsAdapter thebalanceDetailsAdapter;
    @BindView(R.id.tv_balance_of_account)
    TextView tvBalanceOfAccount;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    List<SelectAccountByUserid> selectAccountByUserids = new ArrayList<>();
    List<SelectAccountByUserid> selectAccountByUseridArrayList = new ArrayList<>();
    int page = 1;
    int rows = 10;
    private PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_thebalance_details;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        thebalanceDetailsAdapter = new ThebalanceDetailsAdapter( getActivity() );
        recyclerView.setAdapter( thebalanceDetailsAdapter );
    }

    @Override
    protected void initData() {
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), selectAccountByUserid, Constant.selectAccountByUserid );

    }


    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.selectAccountByUserid:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );
                return paramsMap;

        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();

        if (data != null) {
            smartRefresh.closeHeaderOrFooter();
            selectAccountByUserids = GsonUtils.getPersons( data, SelectAccountByUserid.class );
            selectAccountByUseridArrayList.addAll( selectAccountByUserids );
            thebalanceDetailsAdapter.replaceData( selectAccountByUseridArrayList );
        } else {
            ivHintIcon.show();
        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page = page + 1;
        initData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        selectAccountByUseridArrayList.clear();
        page = 1;
        initData();
    }
}
