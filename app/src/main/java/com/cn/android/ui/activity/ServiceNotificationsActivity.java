package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridLayout;

import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.ProductsCoverAdapter;
import com.cn.android.ui.adapter.ServiceNotificationsAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 服务通知
 */
public class ServiceNotificationsActivity extends MyActivity {
    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.rv)
    RecyclerView rv;
    public String name;
    ServiceNotificationsAdapter serviceNotificationsAdapter;
    List<Commodity.DataBean> dataBeans = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_service_notifications;
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        name = getIntent().getStringExtra("TestTitle");
        tTestTitle.setTitle(name);
        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation(GridLayout.VERTICAL);
        rv.addItemDecoration(new SpaceItemDecoration(1));
        //设置布局管理器， 参数gridLayoutManager对象
        rv.setLayoutManager(gridLayoutManager);
        serviceNotificationsAdapter = new ServiceNotificationsAdapter(getActivity(), name);
        rv.setAdapter(serviceNotificationsAdapter);

    }

    @Override
    protected void initData() {
        dataBeans.add(new Commodity.DataBean("fdsdfds", "标题", "45", "455", 4));
        dataBeans.add(new Commodity.DataBean("fdsdfds", "标题", "45", "455", 4));
        serviceNotificationsAdapter.setNewData(dataBeans);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }
}
