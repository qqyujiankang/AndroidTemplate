package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.MyTeamAdapter;
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
import butterknife.OnClick;

/**
 * 我的团队
 */
public class MyTeamActivity extends MyActivity implements PublicInterfaceView, OnRefreshListener, OnLoadMoreListener {


    MyTeamAdapter myTeamAdapter;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_hear)
    ImageView ivHear;
    @BindView(R.id.tv_balance_of_account)
    TextView tvBalanceOfAccount;
    @BindView(R.id.tv_view_details)
    TextView tvViewDetails;
    @BindView(R.id.tv_ti_xian)
    TextView tvTiXian;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;

    private PublicInterfaceePresenetr presenetr;
    private boolean isUpRefresh = true;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_team;
    }

    @Override
    protected void initView() {
        tvBalanceOfAccount.setText( userdata().getUmoney()+"" );
        presenetr = new PublicInterfaceePresenetr( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        myTeamAdapter = new MyTeamAdapter( getActivity() );
        recyclerView.setAdapter( myTeamAdapter );
    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selecttTeamByUserid, Constant.selecttTeamByUserid );
    }


    @OnClick({R.id.tv_view_details, R.id.tv_ti_xian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_ti_xian:
                startActivity( WithdrawDepositActivity.class );
                break;
            case R.id.tv_view_details:
                startActivity( ThebalanceDetailsActivity.class );
                break;
        }
    }

    private int page = 1, rows = 10;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> map = new HashMap<>();
        map.put( "userid", userdata().getId() );
        map.put( "page", page );
        map.put( "rows", rows );
        return map;
    }

    List<Userdata> userBeans = new ArrayList<>();
    List<Userdata> userBeanArrayList = new ArrayList<>();

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        if (isUpRefresh) {
            userBeanArrayList.clear();
        }
        if (!data.equals( "null" )) {
            smartRefresh.closeHeaderOrFooter();
            userBeans = GsonUtils.getPersons( data, Userdata.class );
            userBeanArrayList.addAll( userBeans );
            myTeamAdapter.replaceData( userBeanArrayList );
        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
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
}
