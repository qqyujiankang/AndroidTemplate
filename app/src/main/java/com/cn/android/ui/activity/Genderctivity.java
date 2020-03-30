package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.cn.android.R;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.bar.OnTitleBarListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 性别
 * gender
 */
public class Genderctivity extends MyActivity implements PublicInterfaceView, OnTitleBarListener {
    @BindView(R.id.tv_man)
    CheckBox tvMan;
    @BindView(R.id.ll_man)
    RelativeLayout llMan;
    @BindView(R.id.tv_woman)
    CheckBox tvWoman;
    @BindView(R.id.Rl_tv_woman)
    RelativeLayout RlTvWoman;
    @BindView(R.id.tv_confidentiality)
    CheckBox tvConfidentiality;
    @BindView(R.id.Rl_tv_confidentiality)
    RelativeLayout RlTvConfidentiality;
    private PublicInterfaceePresenetr presenetr;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_genderctivity;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }

    @OnClick({R.id.ll_man, R.id.Rl_tv_woman, R.id.Rl_tv_confidentiality})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_man:
                chein( 0 );
                break;
            case R.id.Rl_tv_woman:
                chein( 1 );
                break;
            case R.id.Rl_tv_confidentiality:
                chein( 2 );
                break;
        }
    }

    private void chein(int i) {
        if (i == 0) {
            tvMan.setChecked( true );
            tvConfidentiality.setChecked( false );
            tvWoman.setChecked( false );
        } else if (i == 1) {
            tvMan.setChecked( false );
            tvConfidentiality.setChecked( false );
            tvWoman.setChecked( true );
        } else if (i == 2) {
            tvMan.setChecked( false );
            tvConfidentiality.setChecked( true );
            tvWoman.setChecked( false );
        }
    }

    private String sex;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.updateSex:
                paramsMap.put( "userid", userdata().getId() );
                if (tvMan.isChecked()) {
                    sex = "男";
                } else if (tvWoman.isChecked()) {
                    sex = "男";
                } else if (tvConfidentiality.isChecked()) {
                    sex = "保密";


                }
                paramsMap.put( "sex", sex );
                return paramsMap;

        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        Userdata userdata = userdata();
        userdata.setSex( sex );
        SaveUserBean( userdata );
        finish();

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick( v );
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.updateSex, Constant.updateSex );
    }
}
