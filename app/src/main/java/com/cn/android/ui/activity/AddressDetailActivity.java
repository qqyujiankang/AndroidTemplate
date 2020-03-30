package com.cn.android.ui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.AddressByUserid;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.dialog.AddressDialog;
import com.hjq.dialog.MessageDialog;
import com.hjq.widget.layout.SettingBar;
import com.hjq.widget.view.SwitchButton;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.cn.android.ui.activity.ShippingAddressActivity.aBoolean;

/**
 * 收货地址"
 */
public class AddressDetailActivity extends MyActivity implements PublicInterfaceView {
    @BindView(R.id.sb_test_switch)
    SwitchButton sbTestSwitch;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.sb01)
    SettingBar sb01;
    @BindView(R.id.tv_04)
    TextView tv04;
    PublicInterfaceePresenetr presenetr;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_address)
    EditText etAddress;
    AddressByUserid addressByUserid;
    String url;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_address_detail;
    }

    private int anInt = 0;

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        anInt = getIntent().getIntExtra( "name", 0 );
        addressByUserid = getIntent().getParcelableExtra( "addressByUserid" );
        if (addressByUserid != null) {
            etName.setText( addressByUserid.getName() );
            etPhone.setText( addressByUserid.getPhone() );
            sb01.setLeftText( addressByUserid.getProCityArea() );
            etAddress.setText( addressByUserid.getAddress() );
            if (addressByUserid.getIsDefault() == 1) {
                sbTestSwitch.setChecked( true );
            } else {
                sbTestSwitch.setChecked( false );
            }
            tv04.setVisibility( View.VISIBLE );

        }

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

    @OnClick({R.id.sb01, R.id.btn_bind_commit, R.id.tv_04})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_04:
                new MessageDialog.Builder( this )
                        // 标题可以不用填写
                        //.setTitle("我是标题")
                        // 内容必须要填写
                        .setMessage( "确定要删除此地址吗？" )
                        // 确定按钮文本
                        .setConfirm( "删除" )
                        // 设置 null 表示不显示取消按钮
                        .setCancel( "再想想" )

                        // 设置点击按钮后不关闭对话框
                        //.setAutoDismiss(false)
                        .setListener( new MessageDialog.OnListener() {

                            @Override
                            public void onConfirm(Dialog dialog) {

                                // toast("确定了");
                                presenetr.getPostTokenRequest( getActivity(), ServerUrl.deleteAddress, Constant.deleteAddress );
                                dialog.dismiss();
                            }

                            @Override
                            public void onCancel(Dialog dialog) {
                                //  toast("取消了");
                                dialog.dismiss();
                            }
                        } )
                        .show();
                break;
            case R.id.sb01:
                new AddressDialog.Builder( getActivity() )

                        .setTitle( "选择地区" )
                        // 设置默认省份
                        // 不选择县级区域
                        //.setIgnoreArea()
                        //  .setContentView(R.layout.dialog_address)
                        .setListener( new AddressDialog.OnListener() {

                            @Override
                            public void onSelected(Dialog dialog, String province, String city, String area) {
                                String address = province + city + area;
                                if (!sb01.getRightText().equals( address )) {
                                    sb01.setLeftText( address );
                                }
                            }

                            @Override
                            public void onCancel(Dialog dialog) {
                            }
                        } )
                        .show();
                break;
            case R.id.btn_bind_commit:
                showLoading();
                if (addressByUserid == null) {
                    url = ServerUrl.addAddress;
                } else {
                    url = ServerUrl.updateAddress;
                }
                presenetr.getPostTokenRequest( getActivity(), url, Constant.addAddress );
                break;
        }
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.addAddress:

                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "phone", etPhone.getText().toString() );
                paramsMap.put( "name", etName.getText().toString() );
                paramsMap.put( "pro_city_area", sb01.getLeftText().toString() );
                paramsMap.put( "address", etAddress.getText().toString() );
                if (sbTestSwitch.isChecked()) {
                    paramsMap.put( "is_default", "1" );
                } else {
                    paramsMap.put( "is_default", "2" );
                }
                if (addressByUserid != null) {
                    paramsMap.put( "id", addressByUserid.getId() );
                }
                return paramsMap;
            case Constant.deleteAddress:
                paramsMap.put( "id", addressByUserid.getId() );
                return paramsMap;
        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        aBoolean=true;
        finish();


    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }
}
