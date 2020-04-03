package com.cn.android.ui.activity;

import android.os.Bundle;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.bar.TitleBar;
import com.hjq.widget.layout.HintLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.Map;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 评价列表
 */
public class TheEvaluationlistActivity extends MyActivity implements PublicInterfaceView {


    @BindView(R.id.tlte)
    TitleBar tlte;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_the_evaluationlist;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
    }

    @Override
    protected void initData() {
        // TODO: 2020/4/2  
        presenetr.getPostTokenRequest( getActivity(), "", 0 );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }
}
