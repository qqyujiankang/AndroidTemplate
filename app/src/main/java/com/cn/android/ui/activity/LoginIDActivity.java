package com.cn.android.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.bean.Register;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.utils.SPUtils;
import com.hjq.widget.view.ClearEditText;
import com.hjq.widget.view.CountdownView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

/**
 * 登录
 */
public class LoginIDActivity extends MyActivity implements PublicInterfaceView {
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.et_login_phone)
    ClearEditText etLoginPhone;
    @BindView(R.id.cv_bind_countdown)
    CountdownView cvBindCountdown;
    @BindView(R.id.btn_login_commit)
    Button btnLoginCommit;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.etsmscode)
    ClearEditText etsmscode;
    private PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_id;
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
                if (etLoginPhone.getText().toString().equals( "" )) {
                    toast( "请输入11位手机号" );
                    cvBindCountdown.resetState();
                    return;
                }
                showLoading();
                presenetr.getPostRequest( getActivity(), ServerUrl.sendSms, Constant.sendSms );
                toast( R.string.common_code_send_hint );
                break;
            case R.id.btn_login_commit:
                //
                if (etLoginPhone.getText().toString().equals( "" )) {
                    toast( "请输入11位手机号" );
                    return;
                } else if (etsmscode.getText().toString().equals( "" )) {
                    toast( "请输入验证码" );
                }
                showLoading();
                presenetr.getPostRequest( getActivity(), ServerUrl.login, Constant.login );
                break;
            case R.id.btn_register:
                startActivity( NewRegisterActivity.class );
                break;
        }
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.login:
                paramsMap.put( "userphone", etLoginPhone.getText().toString() );
                paramsMap.put( "smscode", etsmscode.getText().toString() );
                paramsMap.put( "type", TheloginIdActivity.state );
                paramsMap.put( "province", Province );
                paramsMap.put( "city", City );
                paramsMap.put( "area", District );
                return paramsMap;
            case Constant.sendSms:
                paramsMap.put( "loginName", etLoginPhone.getText().toString() );
                return paramsMap;
        }
        return null;
    }

    public static Userdata userdata = new Userdata();

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {
            case Constant.login:
                showComplete();
                if (!data.equals( "null" )) {
                    userdata = GsonUtils.getPerson( data, Userdata.class );

                    /**
                     *" ：code":200,"userId":"15535958281","token":"BZ//rc/gZm1iOgN57xUDMDVTPjpnzvGsgskHghc8vyyxw8DF0jUqBBsMIfiJFAxsfvEA/GdAnm+EBipMC21EQPLnRY4RvKEz"
                     *   "code":200,"userId":"15535958282","token":"LLqHSs10ZXIR7cDzjAg8lDVTPjpnzvGsgskHghc8vyyxw8DF0jUqBImmZ5zz5eQQfvEA/GdAnm+EBipMC21EQOjkBKrT647W"}
                     */
                    SPUtils.putString( "AppUser", data );
                    SPUtils.putString( "token", userdata.getToken() );
                    RongIM.connect( userdata().getRongyunToken(), new RongIMClient.ConnectCallback() {
                        @Override
                        public void onTokenIncorrect() {

                        }

                        @Override
                        public void onSuccess(String userid) {
                            Log.d( "TAG", "--onSuccess" + userid );//123456

                        }

                        @Override
                        public void onError(RongIMClient.ErrorCode errorCode) {
                            Log.d( "TAG", "--onSuccess" + errorCode );
                        }
                    } );
                    RongIM.getInstance().setCurrentUserInfo( new UserInfo( userdata.getId(), userdata.getNickname(), Uri.parse( userdata.getHeadImg() ) ) );

                    finish();
                    startActivity( HomeActivity.class );

                }
                break;
        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }
}
