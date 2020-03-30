package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.cn.android.R;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.widget.view.ClearEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Modify the nickname 昵称
 */
public class ModifyTheNicknameActivity extends MyActivity implements OnTitleBarListener, PublicInterfaceView {


    @BindView(R.id.tib)
    TitleBar tib;
    @BindView(R.id.et_name)
    ClearEditText etName;
    PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_the_nickname;
    }

    @Override
    protected void initView() {
        tib.setOnTitleBarListener( this );
        if (userdata().getNickname() != null || !userdata().getNickname().equals( "" )) {
            etName.setText( userdata().getNickname() );
        }
        presenetr = new PublicInterfaceePresenetr( this );

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onRightClick(View v) {
        super.onRightClick( v );
        if (etName.getText().toString().equals( "" )) {
            toast( "请输入昵称" );
            return;
        }
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.updateNickname, Constant.updateNickname );
    }


    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.updateNickname:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "nickname", etName.getText().toString() );
                return paramsMap;

        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        Userdata userdata = userdata();
        userdata.setNickname( etName.getText().toString() );
        SaveUserBean( userdata );
        finish();
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }
}
