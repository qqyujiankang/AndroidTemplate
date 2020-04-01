package com.cn.android.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.bean.Userdata;
import com.cn.android.common.MyActivity;
import com.cn.android.helper.ActivityStackManager;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.FileOperationPresenetr;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.FileOperationView;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.utils.BitmapUtils;
import com.cn.android.utils.SPUtils;
import com.hjq.image.ImageLoader;
import com.hjq.widget.layout.SettingBar;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * personal_data_title 个人资料
 */
public class NewPersonalDataActivity extends MyActivity implements FileOperationView, PublicInterfaceView {


    @BindView(R.id.s02)
    SettingBar s02;
    @BindView(R.id.s01)
    SettingBar s01;
    @BindView(R.id.iv)
    ImageView iv;
    private FileOperationPresenetr filePresenetr;
    private PublicInterfaceePresenetr presenetr;

    private String head_img = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_personal_data;
    }

    @Override
    protected void initView() {
        if (TextUtils.isEmpty( userdata().getHeadImg() )) {
            ImageLoader.with( this )
                    .circle()
                    .load( R.mipmap.test24 )
                    .into( iv );
        } else {
            ImageLoader.with( this )
                    .circle()
                    .load( userdata().getHeadImg() )
                    .into( iv );
        }
        presenetr = new PublicInterfaceePresenetr( this );
        filePresenetr = new FileOperationPresenetr( this );
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

    @OnClick({R.id.iv, R.id.s02, R.id.s01})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv:
                PhotoActivity.start( this, new PhotoActivity.OnPhotoSelectListener() {
                    @Override
                    public void onSelect(List<String> data) {
                        ImageLoader.with( getActivity() )
                                .load( data.get( 0 ) )
                                .circle( 20 )
                                .into( iv );
                        filePresenetr.uploadSingleFileRequest( getActivity(), "file",
                                new File( data.get( 0 ) ), ServerUrl.upload, Constant.updateHeadImg );


                    }

                    @Override
                    public void onCancel() {

                    }
                } );
                break;
            case R.id.s02:
                startActivity( ModifyTheNicknameActivity.class );
                break;
            case R.id.s01:
                startActivity( Genderctivity.class );
                break;
        }
    }

    @Override
    public void FileOperationSuccess(Object data, int tag) {
        showComplete();
        head_img = (String) data;
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.updateHeadImg, Constant.updateHeadImg );
    }

    @Override
    public void FileOperationProgress(float progress, int tag) {

    }

    @Override
    public void FileOperationError(String error, int tag) {
        showComplete();
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        switch (tag) {
            case Constant.updateHeadImg:
                paramsMap.put( "userid", userdata().getId() );
                paramsMap.put( "head_img", head_img );
                return paramsMap;

        }
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        switch (tag) {
            case Constant.updateHeadImg:
                Userdata userBean = userdata();
                userBean.setHeadImg( head_img );
                SaveUserBean( userBean );
                break;

        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();

    }
}
