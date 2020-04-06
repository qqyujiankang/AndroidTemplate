package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.Inform;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的通知
 */
public class InformActivity extends MyActivity implements PublicInterfaceView {


    @BindView(R.id.ll_ServiceNotifications)
    LinearLayout llServiceNotifications;
    @BindView(R.id.ll_special_promotion)
    LinearLayout llSpecialPromotion;
    @BindView(R.id.ll_my_team)
    LinearLayout llMyTeam;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.iv_f)
    ImageView ivF;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_contet)
    TextView tvContet;
    @BindView(R.id.iv_fd)
    ImageView ivFd;
    @BindView(R.id.tv_name1)
    TextView tvName1;
    @BindView(R.id.tv_contet1)
    TextView tvContet1;
    @BindView(R.id.iv_fd1)
    ImageView ivFd1;
    @BindView(R.id.tv_name2)
    TextView tvName2;
    @BindView(R.id.tv_contet2)
    TextView tvContet2;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_time1)
    TextView tvTime1;
    private PublicInterfaceePresenetr presenetr;
    private int type = 1;
    private List<Inform> informs = new ArrayList<>();
    private List<Inform> getInforms = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_inform;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectMessgeList, Constant.selectMessgeList );
    }


    @OnClick({R.id.ll_ServiceNotifications, R.id.ll_special_promotion, R.id.ll_my_team})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.ll_ServiceNotifications://服务通知

                intent.putExtra( "TestTitle", "服务通知" );
                intent.setClass( getActivity(), ServiceNotificationsActivity.class );
                startActivity( intent );
                break;
            case R.id.ll_special_promotion://
                intent.putExtra( "TestTitle", "优惠促销" );
                intent.setClass( getActivity(), ServiceNotificationsActivity.class );
                startActivity( intent );
                break;
            case R.id.ll_my_team://kefu
                startActivity( ServiceActivity.class );

                break;

        }
    }

    int page = 1;
    int rows = 10;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {

        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "type", type );
        paramsMap.put( "page", page );
        paramsMap.put( "rows", rows );
        return paramsMap;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {
            case Constant.selectMessgeList:
                informs = GsonUtils.getPersons( data, Inform.class );
                tvName.setText( informs.get( 0 ).getTitle() );
                tvContet.setText( informs.get( 0 ).getContent() );
                tvTime.setText( informs.get( 0 ).getCtime() );

                type = 2;
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectMessgeList, Constant.selectMessgeList1 );
                break;
            case Constant.selectMessgeList1:
                getInforms = GsonUtils.getPersons( data, Inform.class );
                tvName1.setText( getInforms.get( 0 ).getTitle() );
                tvContet1.setText( getInforms.get( 0 ).getContent() );
                tvTime1.setText( getInforms.get( 0 ).getCtime() );
                break;
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
}
