package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridLayout;

import com.cn.android.R;
import com.cn.android.bean.AddressByUserid;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.Inform;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.ServiceNotificationsAdapter;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 服务通知
 */
public class ServiceNotificationsActivity extends MyActivity implements PublicInterfaceView, OnRefreshListener, OnLoadMoreListener {


    public String name;
    ServiceNotificationsAdapter serviceNotificationsAdapter;
    int page = 1;
    int rows = 10;
    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private int type = 1;
    private PublicInterfaceePresenetr presenetr;
    private boolean isUpRefresh = true;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_service_notifications;
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        presenetr=new PublicInterfaceePresenetr( this );
        name = getIntent().getStringExtra( "TestTitle" );
        tTestTitle.setTitle( name );
        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        GridLayoutManager gridLayoutManager = new GridLayoutManager( getActivity(), 1 );
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation( GridLayout.VERTICAL );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 1 ) );
        //设置布局管理器， 参数gridLayoutManager对象
        recyclerView.setLayoutManager( gridLayoutManager );
        serviceNotificationsAdapter = new ServiceNotificationsAdapter( getActivity(), name );
        recyclerView.setAdapter( serviceNotificationsAdapter );

    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectMessgeList, Constant.selectMessgeList );

    }

    private List<Inform> informs = new ArrayList<>();
    private List<Inform> getInforms = new ArrayList<>();

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        if (name.equals( "服务通知" )) {
            paramsMap.put( "type", 1 );
        } else if (name.equals( "优惠促销" )) {
            paramsMap.put( "type", 2 );
        }

        paramsMap.put( "page", page );
        paramsMap.put( "rows", rows );
        return paramsMap;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        smartRefresh.closeHeaderOrFooter();
        if (isUpRefresh) {
            getInforms.clear();
        }
        informs = GsonUtils.getPersons( data, Inform.class );

        getInforms.addAll( informs );

        if (getInforms.size() != 0) {
            serviceNotificationsAdapter.replaceData( getInforms );
            ivHintIcon.hide();
        } else {
            ivHintIcon.show();
        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

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



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }
}
