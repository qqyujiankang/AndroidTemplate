package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.HomeData;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.FileOperationPresenetr;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.FileOperationView;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.image.ImageLoader;
import com.hjq.widget.view.ClearEditText;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置店铺
 */
public class SetupshopActivity extends MyActivity implements PublicInterfaceView, FileOperationView, OnTitleBarListener {


    @BindView(R.id.tv01)
    TextView tv01;
    @BindView(R.id.tv02)
    TextView tv02;
    @BindView(R.id.tv_03)
    TextView tv03;
    @BindView(R.id.Rl_01)
    RelativeLayout Rl01;
    @BindView(R.id.tv_class_name)
    TextView tvClassName;
    @BindView(R.id.et_01)
    ClearEditText et01;
    @BindView(R.id.iv_hint_icon)
    ImageView ivHintIcon;
    @BindView(R.id.tb)
    TitleBar tb;
    private PublicInterfaceePresenetr presenetr;
    private FileOperationPresenetr filePresenetr;
    private String storeTypeId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setupshop;
    }


    HomeData.ShopTypeListBean shopTypeListBean;

    @Override
    protected void initView() {
        tb.setOnTitleBarListener( this );

        presenetr = new PublicInterfaceePresenetr( this );
        filePresenetr = new FileOperationPresenetr( this );
        tv01.setText( userdata().getStoreTypName() );
        et01.setText( userdata().getStoreName() );
        store_img = userdata().getStoreImg();
        ImageLoader.with( getActivity() ).load( userdata().getStoreImg() ).into( ivHintIcon );
        tvClassName.setText( userdata().getStoreTypName() );
        storeTypeId = userdata().getStoreTypeId();
    }

    @Override
    protected void initData() {


    }


    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "userid", userdata().getId() );
        paramsMap.put( "store_name", et01.getText().toString() );
        paramsMap.put( "store_img", store_img );
        paramsMap.put( "store_type_id", storeTypeId );
        paramsMap.put( "store_typ_name", tvClassName.getText().toString() );

        return paramsMap;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        if (!data.equals( "" )) {
//            tv01.setText( userdata().getStoreTypName() );
//        et01.setText( userdata().getStoreName() );
//        store_img = userdata().getStoreImg();
            Userdata userdata = userdata();
            userdata.setStoreName( et01.getText().toString().trim() );
            userdata.setStoreImg( store_img );
            userdata.setStoreTypName( tvClassName.getText().toString().trim() );
            SaveUserBean( userdata );
            finish();
        }

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }

    @OnClick({R.id.tv01, R.id.Rl_01, R.id.iv_hint_icon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv01:
                break;
            case R.id.Rl_01:
                Intent intent3 = new Intent( this, SetupshopCalssActivity.class );
                int code = 3;
                startActivityForResult( intent3, code );
                break;
            case R.id.iv_hint_icon:
                PhotoActivity.start( this, new PhotoActivity.OnPhotoSelectListener() {
                    @Override
                    public void onSelect(List<String> data) {
                        ImageLoader.with( getActivity() )
                                .load( data.get( 0 ) )
                                .into( ivHintIcon );
                        filePresenetr.uploadSingleFileRequest( getActivity(), "file",
                                new File( data.get( 0 ) ), ServerUrl.upload, Constant.updateHeadImg );


                    }

                    @Override
                    public void onCancel() {

                    }
                } );
                break;
        }
    }

    private String store_img = "";

    @Override
    public void FileOperationSuccess(Object data, int tag) {
        store_img = (String) data;
    }

    @Override
    public void FileOperationProgress(float progress, int tag) {

    }

    @Override
    public void FileOperationError(String error, int tag) {

    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick( v );

        if (tvClassName.getText().toString().equals( "" )) {
            toast( "请选择分类" );
            return;
        }
        if (et01.getText().toString().equals( "" )) {
            toast( "请输入店铺名称" );
            return;
        }
        if (store_img.equals( "" )) {
            toast( "请选择店铺图爿" );
            return;
        }
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.updateStore, Constant.updateStore );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == 3 && resultCode == 33) {

            shopTypeListBean = data.getParcelableExtra( "shopTypeListBean" );
            if (shopTypeListBean != null) {
                storeTypeId = shopTypeListBean.getId();
                tvClassName.setText( shopTypeListBean.getName() );
            }
        }
    }
}
