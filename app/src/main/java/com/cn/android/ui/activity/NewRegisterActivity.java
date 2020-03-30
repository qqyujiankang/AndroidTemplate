package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.bean.Register;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.widget.view.ClearEditText;
import com.hjq.widget.view.CountdownView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册
 */
public class NewRegisterActivity extends MyActivity implements PublicInterfaceView {
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.et_login_phone)
    ClearEditText etLoginPhone;
    @BindView(R.id.cv_bind_countdown)
    CountdownView cvBindCountdown;
    @BindView(R.id.iv_Invitation_code)
    ImageView ivInvitationCode;
    @BindView(R.id.et_Invitation_code)
    ClearEditText etInvitationCode;
    @BindView(R.id.btn_login_commit)
    Button btnLoginCommit;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.et_smscode)
    ClearEditText etSmscode;
    private PublicInterfaceePresenetr presenetr;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_register;
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

    @OnClick({R.id.btn_login_commit, R.id.btn_register, R.id.cv_bind_countdown})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cv_bind_countdown:
                if (etLoginPhone.getText().toString().equals( "" )){
                    return;
                }
                showLoading();
                presenetr.getPostRequest( getActivity(), ServerUrl.sendSms, Constant.sendSms );
                toast( R.string.common_code_send_hint );
                break;
            case R.id.btn_login_commit:
                finish();
                break;
            case R.id.btn_register:
                if (etLoginPhone.getText().toString().equals( "" )){
                    toast( "请输入11位手机号" );
                    return;
                }else if (etSmscode.getText().toString().equals( "" )){
                    toast( "请输入验证码" );
                }
                showLoading();
                presenetr.getPostRequest( getActivity(), ServerUrl.register, Constant.register );
                break;
        }
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.register:
                paramsMap.put( "userphone", etLoginPhone.getText().toString() );
                paramsMap.put( "smscode", etSmscode.getText().toString() );
                paramsMap.put( "pid", etInvitationCode.getText().toString() );
                paramsMap.put( "province", "陕西省" );
                paramsMap.put( "city", "西安市" );
                paramsMap.put( "area", "雁塔区" );

                return paramsMap;
            case Constant.sendSms:
                paramsMap.put( "loginName", etLoginPhone.getText().toString() );
                return paramsMap;
        }
        return null;
    }

    Register register = new Register();

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {

        showComplete();
        switch (tag) {
            case Constant.register:
                register = GsonUtils.getPerson( data, Register.class );
                if (!data.equals( "" )||data!=null) {
                    finish();
                }
                break;
        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }


}
