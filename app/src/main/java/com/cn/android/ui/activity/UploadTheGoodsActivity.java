package com.cn.android.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.presenter.view.FileOperationView;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.CommercialSpecificationAdapter;
import com.cn.android.ui.adapter.MorepicturesAdapter;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.widget.view.SwitchButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Upload the goods 上传商品
 */
public class UploadTheGoodsActivity extends MyActivity implements BaseQuickAdapter.OnItemChildClickListener, OnTitleBarListener , FileOperationView, PublicInterfaceView {

    CommercialSpecificationAdapter commercialSpecificationAdapter;
    List<Commodity.DataBean> strings = new ArrayList<>();
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.iv_particulars)
    ImageView ivParticulars;
    @BindView(R.id.sb_test_switch)
    SwitchButton sbTestSwitch;
    @BindView(R.id.ll_01)
    LinearLayout ll01;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    MorepicturesAdapter morepicturesAdapter;
    @BindView(R.id.relativeLayout)
    RecyclerView relativeLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload_the_goods;
    }

    @Override
    protected void initView() {
        relativeLayout.setLayoutManager( new GridLayoutManager( getActivity(), 3 ) );
        morepicturesAdapter = new MorepicturesAdapter( getActivity(), morepicturesArrayList );
        relativeLayout.setAdapter( morepicturesAdapter );
        rv.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        commercialSpecificationAdapter = new CommercialSpecificationAdapter( getActivity() );
        rv.setAdapter( commercialSpecificationAdapter );
        commercialSpecificationAdapter.setNewData( strings );
        commercialSpecificationAdapter.setOnItemChildClickListener( this );
        morepicturesAdapter.setOnItemChildClickListener( this );

    }

    List<String> morepicturesArrayList = new ArrayList<>();

    @Override
    protected void initData() {
        strings.add( new Commodity.DataBean( "fdsdfds", "455", "45", "455", 4 ) );
        morepicturesArrayList.add( "" );
        morepicturesAdapter.setNewData( morepicturesArrayList );
    }


    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (adapter instanceof CommercialSpecificationAdapter) {
            switch (view.getId()) {
                case R.id.iv_add:
                    CheckBox checkBox = view.findViewById( R.id.iv_add );
                    if (!checkBox.isChecked()) {
                        strings.add( new Commodity.DataBean( "fdsdfds", "456", "45", "455", 4 ) );
                    } else if (strings.size() != 1) {
                        checkBox.setChecked( true );
                        strings.remove( position );
                    }
                    commercialSpecificationAdapter.setNewData( strings );
                    break;
            }
        } else if (adapter instanceof MorepicturesAdapter) {
            switch (view.getId()){
                case R.id.iv_particulars:

                        PhotoActivity.start( this, 5, new PhotoActivity.OnPhotoSelectListener() {
                            @Override
                            public void onSelect(List<String> data) {

                                morepicturesArrayList.remove( morepicturesArrayList.size() - 1 );
                                if (data.size() < 5) {
                                    data.add( "" );
                                }
                                morepicturesArrayList.addAll( data );
                                Log.e( "上传商品", "===1=====" + morepicturesArrayList.size() );
                                morepicturesAdapter.setNewData( morepicturesArrayList );
                            }

                            @Override
                            public void onCancel() {

                            }
                        } );
                    break;
            }


        }
    }

    @OnClick({R.id.iv_particulars, R.id.ll_01, R.id.ll02})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.iv_particulars:
                ivview( ivParticulars );

                break;
            case R.id.ll_01:
                finish();
                break;
            case R.id.ll02:
                finish();
                break;
        }
    }

    private void ivview(ImageView ivParticulars) {
        PhotoActivity.start( this, 5, new PhotoActivity.OnPhotoSelectListener() {
            @Override
            public void onSelect(List<String> data) {
            }

            @Override
            public void onCancel() {

            }
        } );
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick( v );
        finish();
    }

    @Override
    public void FileOperationSuccess(Object data, int tag) {

    }

    @Override
    public void FileOperationProgress(float progress, int tag) {

    }

    @Override
    public void FileOperationError(String error, int tag) {

    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        return null;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }
}
