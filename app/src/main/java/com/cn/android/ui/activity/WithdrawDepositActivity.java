package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 提现
 */
public class WithdrawDepositActivity extends MyActivity implements PublicInterfaceView {


    @BindView(R.id.tv_balance_of_account)
    TextView tvBalanceOfAccount;
    @BindView(R.id.tv_view_details)
    TextView tvViewDetails;
    @BindView(R.id.tv_money)
    EditText tvMoney;
    @BindView(R.id.tv_upper)
    CheckBox tvUpper;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.tv02)
    CheckBox tv02;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    private int anInt = 1;
    PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_withdraw_deposit;
    }

    @Override
    protected void initView() {
        tvBalanceOfAccount.setText( userdata().getUmoney() + "" );
        presenetr = new PublicInterfaceePresenetr( this );
    }

    @Override
    protected void initData() {


    }


    @OnClick({R.id.tv_view_details, R.id.relativeLayout, R.id.rl_search, R.id.btn_bind_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_view_details:
                startActivity( ThebalanceDetailsActivity.class );
                break;
            case R.id.relativeLayout:
                anInt = 1;
                tvUpper.setChecked( true );
                tv02.setChecked( false );
                break;
            case R.id.rl_search:
                anInt = 2;
                tvUpper.setChecked( false );
                tv02.setChecked( true );
                break;
            case R.id.btn_bind_commit:
                if (anInt == 1) {
                    if (userdata().getIsWechat() == 2) {
                        Intent intent = new Intent( getActivity(), BindingAccountActivity.class );
                        intent.putExtra( "name", anInt );
                        startActivity( intent );

                    } else {
                        addAccountByUserid();
                    }
                } else if (anInt == 2) {
                    if (userdata().getIsAlipay() == 2) {
                        Intent intent = new Intent( getActivity(), BindingAccountActivity.class );
                        intent.putExtra( "name", anInt );
                        startActivity( intent );
                    } else {
                        addAccountByUserid();
                    }
                }

                //     new BindingAccountDialog.Builder(getActivity()).show();
                //finish();

                break;
        }
    }

    /**
     * @param
     */
    private void addAccountByUserid() {
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.addAccountByUserid, Constant.addAccountByUserid );
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.addAccountByUserid:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "money", tvMoney.getText().toString() );
                paramsMap.put( "type", anInt );
                return paramsMap;

        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        Userdata userdata = userdata();
        userdata.setUmoney( userdata.getUmoney() - Double.valueOf( tvMoney.getText().toString() ) );
        SaveUserBean( userdata );
        finish();
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }
}
