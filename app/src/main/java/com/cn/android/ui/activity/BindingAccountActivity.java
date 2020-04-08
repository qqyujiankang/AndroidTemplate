package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.cn.android.R;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 绑定账号
 */
public class BindingAccountActivity extends MyActivity implements OnTitleBarListener, PublicInterfaceView {

    @BindView(R.id.btn)
    TitleBar btn;
    @BindView(R.id.et_01)
    EditText et01;
    @BindView(R.id.et_02)
    EditText et02;
    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }
    private int anInt = 1;
    private PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_binding_account;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        btn.setOnTitleBarListener( this );
        anInt = getIntent().getIntExtra( "name", 0 );
        if (anInt == 1) {
            et01.setHint( "请输入微信账号" );
            et02.setHint( "请输入姓名" );


        } else if (anInt == 2) {
            et01.setHint( "请输入支付宝账号" );
            et02.setHint( "请输入支付宝实名姓名" );
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick( v );
        //finish();
        if (et01.getText().toString().equals( "" )) {
            if (anInt == 1) {
                toast( "请输入微信账号" );
                return;
            } else {
                toast( "请输入支付宝账号" );
                return;
            }

        } else if (et02.getText().toString().equals( "" )) {
            if (anInt == 2) {

                toast( "请输入姓名" );
                return;
            } else {
                toast( "请输入微信账号" );
                return;

            }
        }
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.updateAccount, Constant.updateAccount );
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.updateAccount:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "accountno", "15535958281" );
                paramsMap.put( "account_name", "庾建康" );
                paramsMap.put( "type", anInt );
                return paramsMap;
        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        Userdata userdata = userdata();
        if (anInt == 1) {
            userdata.setIsWechat( 1 );
        } else if (anInt == 2) {
            userdata.setIsAlipay( 1 );
        }
        SaveUserBean( userdata );
        finish();
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }
}
