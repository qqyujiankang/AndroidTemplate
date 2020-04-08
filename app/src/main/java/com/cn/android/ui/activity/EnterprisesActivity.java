package com.cn.android.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.FileOperationPresenetr;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.FileOperationView;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.image.ImageLoader;
import com.hjq.widget.view.SwitchButton;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 企业入驻
 */
public class EnterprisesActivity extends MyActivity implements PublicInterfaceView, FileOperationView {


    @BindView(R.id.sb_test_switch)
    SwitchButton sbTestSwitch;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.iv01)
    ImageView iv01;
    @BindView(R.id.iv_2)
    ImageView iv2;
    @BindView(R.id.iv03)
    ImageView iv03;
    @BindView(R.id.et_realname)
    EditText etRealname;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_store_name)
    EditText etStoreName;
    private PublicInterfaceePresenetr presenetr;
    private FileOperationPresenetr filePresenetr;
    Map<String, File> map = new HashMap<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_enterprises;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        filePresenetr = new FileOperationPresenetr( this );

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.iv, R.id.iv01, R.id.iv_2, R.id.iv03, R.id.btn_bind_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_bind_commit:
                if (etPhone.getText().toString().equals( "" )) {
                    toast( "请输入电话" );
                    return;
                }
                if (etRealname.getText().toString().equals( "" )) {
                    toast( "请输入姓名" );
                    return;
                }
                if (etRealname.getText().toString().equals( "" )) {
                    toast( "请输入店铺名称" );
                    return;
                }
                showLoading();
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.realAppUser, Constant.realAppUser );
                break;
            case R.id.iv:
                ivview( iv, Constant.idcard_front );
                break;
            case R.id.iv01:
                ivview( iv01, Constant.idcaard_back );
                break;
            case R.id.iv_2:
                ivview( iv2, Constant.business_img );
                break;
            case R.id.iv03:
                ivview( iv03, Constant.cater_img );
                break;
        }

    }

    /**
     * @param ivParticulars
     * @param stringkep
     */
    private void ivview(ImageView ivParticulars, int stringkep) {
        PhotoActivity.start( this, 1, new PhotoActivity.OnPhotoSelectListener() {
            @Override
            public void onSelect(List<String> data) {
                showLoading();
                filePresenetr.uploadSingleFileRequest( getActivity(), "file",
                        new File( data.get( 0 ) ), ServerUrl.upload, stringkep );


                ImageLoader.with( getActivity() )
                        .load( data.get( 0 ) )
                        .into( ivParticulars );
            }

            @Override
            public void onCancel() {

            }
        } );
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.realAppUser:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "idcard_front", idcard_front );
                paramsMap.put( "idcaard_back", idcaard_back );
                paramsMap.put( "business_img", business_img );
                paramsMap.put( "cater_img", cater_img );
                paramsMap.put( "Phone", etPhone.getText().toString() );
                paramsMap.put( "Realname", etRealname.getText().toString() );
                paramsMap.put( "StoreName", etStoreName.getText().toString() );
                if (sbTestSwitch.isChecked()) {
                    paramsMap.put( "is_cater", 1 );
                }else {
                    paramsMap.put( "is_cater", 2 );
                }
                return paramsMap;

        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        Userdata userdata = userdata();
        userdata.setIsReal( 1 );
        SaveUserBean( userdata );
        startActivity( OpeningOfTheEnterpriseActivity.class );
        finish();
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    private String idcard_front, idcaard_back, business_img, cater_img;

    @Override
    public void FileOperationSuccess(Object data, int tag) {
        showComplete();
        switch (tag) {

            case Constant.idcard_front:
                idcard_front = data.toString();
                Log.i( "Https==" + "企业入驻===1======", data.toString() );
                break;
            case Constant.idcaard_back:
                idcaard_back = data.toString();
                Log.i( "Https==" + "企业入驻===2======", data.toString() );
                break;
            case Constant.business_img:
                business_img = data.toString();
                Log.i( "Https==" + "企业入驻===3======", data.toString() );
                break;
            case Constant.cater_img:
                cater_img = data.toString();
                Log.i( "Https==" + "企业入驻===4======", data.toString() );
                break;
        }


    }

    @Override
    public void FileOperationProgress(float progress, int tag) {

    }

    @Override
    public void FileOperationError(String error, int tag) {

    }


}
