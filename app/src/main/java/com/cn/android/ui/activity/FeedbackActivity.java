package com.cn.android.ui.activity;


import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.toast.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 意见反馈
 */
public final class FeedbackActivity extends MyActivity implements PublicInterfaceView {

    @BindView(R.id.et_special_txt)
    EditText etSpecialTxt;
    @BindView(R.id.btn_special_commit)
    AppCompatButton btnSpecialCommit;
    private PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initView() {

        presenetr = new PublicInterfaceePresenetr( this );

    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.btn_special_commit)
    public void onViewClicked() {

        if (TextUtils.isEmpty( etSpecialTxt.getText().toString().trim() )) {
            ToastUtils.show( "请输入反馈内容！！！" );
            return;
        }
        showLoading();
        presenetr.getPostTokenRequest( FeedbackActivity.this, ServerUrl.addFeedBack, Constant.addFeedBack );

    }


    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.addFeedBack:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "content", etSpecialTxt.getText().toString() );
                return paramsMap;

        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        finish();
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }
}