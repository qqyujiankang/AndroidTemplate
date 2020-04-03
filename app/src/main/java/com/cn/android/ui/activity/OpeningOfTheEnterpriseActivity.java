package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.presenter.view.PublicInterfaceView;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 开通企业
 */
public class OpeningOfTheEnterpriseActivity extends MyActivity implements PublicInterfaceView {
    @BindView(R.id.tv_upper)
    CheckBox tvUpper;
    @BindView(R.id.Rl_01)
    RelativeLayout Rl01;
    @BindView(R.id.cb02)
    CheckBox cb02;
    @BindView(R.id.Rl_02)
    RelativeLayout Rl02;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_02)
    TextView tv02;
    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.Rl_pus_01)
    RelativeLayout RlPus01;
    @BindView(R.id.tv_03)
    TextView tv03;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.iv_tui)
    ImageView ivTui;
    @BindView(R.id.Rl_pus_02)
    RelativeLayout RlPus02;
    @BindView(R.id.rl_03)
    RelativeLayout rl03;
    @BindView(R.id.tv03)
    TextView tv_03;
    @BindView(R.id.tv_04)
    TextView tv04;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_opening_of_the_enterprise;
    }

    @Override
    protected void initView() {
        tv.setText( getString( R.string.test01 ) + "4980" );
        tv01.setText( getString( R.string.test01 ) + "1980" );
        tvMoney.setText( getString( R.string.test01 ) + "4980" );
        tv_03.setText( getString( R.string.test01 ) + "165/月" );
        tv04.setText( getString( R.string.test01 ) + "138/月" );
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.Rl_01, R.id.Rl_02, R.id.btn_bind_commit, R.id.Rl_pus_01, R.id.Rl_pus_02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Rl_pus_02:
                RlPus01.setBackground( getResources().getDrawable( R.mipmap.plus_no ) );
                rl03.setBackground( getResources().getDrawable( R.mipmap.puls_yes ) );
                tv.setText( tvMoney.getText().toString() );
                break;
            case R.id.Rl_pus_01:
                RlPus01.setBackground( getResources().getDrawable( R.mipmap.puls_yes ) );
                rl03.setBackground( getResources().getDrawable( R.mipmap.plus_no ) );
                tv.setText( tv01.getText().toString() );
                break;
            case R.id.Rl_01:
                tvUpper.setChecked( true );
                cb02.setChecked( false );
                break;
            case R.id.Rl_02:
                tvUpper.setChecked( false );
                cb02.setChecked( true );
                break;
            case R.id.btn_bind_commit:
                finish();
                break;
        }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }
}
