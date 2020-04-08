package com.cn.android.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.image.ImageLoader;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 邀请码
 */
public class InvitationCodeActivity extends MyActivity implements PublicInterfaceView {


    @BindView(R.id.iv)
    ImageView iv;

    private PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_invitation_code;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectPoster, Constant.selectPoster );
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "userId", userdata().getId() );
        return paramsMap;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        ImageLoader.with( getActivity() ).load( data ).into( iv );
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
