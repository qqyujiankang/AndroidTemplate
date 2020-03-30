package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.CommercialSpecificationAdapter;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.widget.view.SwitchButton;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Upload the goods 上传商品
 */
public class UploadTheGoodsActivity extends MyActivity implements BaseQuickAdapter.OnItemChildClickListener, OnTitleBarListener {

    CommercialSpecificationAdapter commercialSpecificationAdapter;
    List<Commodity.DataBean> strings = new ArrayList<>();
    @BindView(R.id.idea_add_image1)
    ImageView ideaAddImage1;
    @BindView(R.id.idea_add_image2)
    ImageView ideaAddImage2;
    @BindView(R.id.idea_add_image3)
    ImageView ideaAddImage3;
    @BindView(R.id.idea_add_image4)
    ImageView ideaAddImage4;
    @BindView(R.id.idea_add_image5)
    ImageView ideaAddImage5;
    @BindView(R.id.idea_add_image)
    ImageView ideaAddImage;
    @BindView(R.id.idea_ll)
    LinearLayout ideaLl;
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

//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload_the_goods;
    }

    @Override
    protected void initView() {


        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        commercialSpecificationAdapter = new CommercialSpecificationAdapter(getActivity());
        rv.setAdapter(commercialSpecificationAdapter);
        commercialSpecificationAdapter.setNewData(strings);
        commercialSpecificationAdapter.setOnItemChildClickListener(this);

    }

    @Override
    protected void initData() {
        strings.add(new Commodity.DataBean("fdsdfds", "455", "45", "455", 4));
    }




    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.iv_add:
                CheckBox checkBox = view.findViewById(R.id.iv_add);
                if (!checkBox.isChecked()) {
                    strings.add(new Commodity.DataBean("fdsdfds", "456", "45", "455", 4));

                } else if (strings.size() != 1) {
                    checkBox.setChecked(true);
                    strings.remove(position);

                }
                commercialSpecificationAdapter.setNewData(strings);
                break;
        }
    }

    @OnClick({R.id.idea_add_image, R.id.iv_particulars, R.id.ll_01, R.id.ll02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.idea_add_image:
                ivview(ideaAddImage);
                break;
            case R.id.iv_particulars:
                ivview(ivParticulars);

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
        PhotoActivity.start(this, 5, new PhotoActivity.OnPhotoSelectListener() {
            @Override
            public void onSelect(List<String> data) {
            }

            @Override
            public void onCancel() {

            }
        });
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
        finish();
    }


}
