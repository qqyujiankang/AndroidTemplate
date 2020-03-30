package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.widget.view.CountdownView;
import com.hjq.widget.view.RegexEditText;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 更换手机
 */
public class BindPhoneActivity extends MyActivity implements OnTitleBarListener, PublicInterfaceView {


    @BindView(R.id.btn)
    TitleBar btn;
    @BindView(R.id.et_bind_phone)
    RegexEditText etBindPhone;
    @BindView(R.id.iv01)
    ImageView iv01;
    @BindView(R.id.et_bind_code)
    AppCompatEditText etBindCode;
    @BindView(R.id.cv_bind_countdown)
    CountdownView cvBindCountdown;
    PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_phone;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        btn.setOnTitleBarListener( this );
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onRightClick(View v) {
        super.onRightClick( v );
        if (etBindPhone.getText().toString().equals( "" )) {
            toast( "请输入11位手机号" );
            return;
        }
        showLoading();
        presenetr.getPostRequest( getActivity(), ServerUrl.sendSms, Constant.sendSms );
    }

    @OnClick(R.id.cv_bind_countdown)
    public void onViewClicked() {

        if (etBindPhone.getText().toString().equals( "" )) {
            toast( "请输入11位手机号" );
            return;
        }
        showLoading();
        presenetr.getPostRequest( getActivity(), ServerUrl.updatePhone, Constant.updatePhone );
        toast( R.string.common_code_send_hint );
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.updatePhone:

                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "userphone", etBindPhone.getText().toString() );
                paramsMap.put( "smscode", etBindCode.getText().toString() );

                return paramsMap;
            case Constant.sendSms:
                paramsMap.put( "loginName", etBindPhone.getText().toString() );
                return paramsMap;
        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        switch (tag) {
            case Constant.updatePhone:
                Userdata userdata = userdata();
                userdata.setUserphone( etBindPhone.getText().toString() );
                SaveUserBean( userdata );
                finish();

                break;
            case Constant.sendSms:
                break;
        }

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }
}
