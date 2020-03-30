package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.widget.layout.SettingBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 账号管理
 */
public class AccountManagementActivity extends MyActivity {


    @BindView(R.id.sb_Version_checking)
    SettingBar sbVersionChecking;
    @BindView(R.id.sb_01)
    SettingBar sb01;
    @BindView(R.id.sb02)
    SettingBar sb02;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_management;
    }

    @Override
    protected void initView() {
        sbVersionChecking.setRightText( userdata().getUserphone() );
        if (userdata().getIsWechat() == 1) {
            sb02.setRightText( "已绑定" );

        } else {
            sb02.setRightText( "未绑定" );
        }
        if (userdata().getIsAlipay() == 1) {
            sb01.setRightText( "已绑定" );
        } else {
            sb01.setRightText( "未绑定" );

        }
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.sb_Version_checking, R.id.sb_01, R.id.sb02})
    public void onViewClicked(View view) {
        Intent intent = new Intent( getActivity(), BindingAccountActivity.class );
        switch (view.getId()) {
            case R.id.sb_Version_checking:
                startActivity( BindPhoneActivity.class );
                break;
            case R.id.sb_01:
                if (userdata().getIsAlipay() == 2) {
                    intent.putExtra( "name", 2 );
                    startActivity( intent );
                }
                break;
            case R.id.sb02:
                if (userdata().getIsWechat() == 2) {
                    intent.putExtra( "name", 1 );
                    startActivity( intent );
                }
                break;
        }
    }
}
