package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.cn.android.R;
import com.cn.android.bean.MyOrder;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.bar.TitleBar;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 运单填写
 */
public class WaybillFillInActivity extends MyActivity implements PublicInterfaceView {

    MyOrder dataBean;
    @BindView(R.id.btn)
    TitleBar btn;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_tracking_number)
    EditText etTrackingNumber;
    private PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_waybill_fill_in;
    }

    @Override
    protected void initView() {
        presenetr=new PublicInterfaceePresenetr( this );
        dataBean = getIntent().getParcelableExtra( "dataBean" );

    }

    @Override
    protected void initData() {

    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "ordercode", dataBean.getOrdercode() );
        paramsMap.put( "shop_userid", dataBean.getShop_user_id() );
        paramsMap.put( "expressno", etTrackingNumber.getText().toString().trim() );
        paramsMap.put( "express_name", etName.getText().toString().trim() );


        return paramsMap;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        Intent intent = getIntent();
        setResult( 200, intent );
        finish();
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }


    @OnClick(R.id.btn_bind_commit)
    public void onViewClicked() {
        if (TextUtils.isEmpty( etName.getText().toString() )) {
            toast( "请输入快递公司" );
            return;
        }
        if (TextUtils.isEmpty( etTrackingNumber.getText().toString() )) {
            toast( "请输入快递单号" );
            return;
        }
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.sureSendOrder, Constant.sureSendOrder );
    }


}
