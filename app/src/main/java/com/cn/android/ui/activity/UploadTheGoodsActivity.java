package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.BannerBean;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.CommercialSpecificationAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.widget.view.SwitchButton;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Upload the goods 上传商品
 */
public class UploadTheGoodsActivity extends MyActivity implements BaseQuickAdapter.OnItemChildClickListener {
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
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.iv_particulars)
    ImageView ivParticulars;
    @BindView(R.id.sb_test_switch)
    SwitchButton sbTestSwitch;
    CommercialSpecificationAdapter commercialSpecificationAdapter;
    List<Commodity.DataBean> strings = new ArrayList<>();

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

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @SuppressLint("WrongConstant")
    @OnClick(R.id.iv_add)
    public void onViewClicked() {
        strings.add(new Commodity.DataBean("fdsdfds", "455", "45", "455", 4));
        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation(GridLayout.VERTICAL);
        //设置布局管理器， 参数gridLayoutManager对象
        rv.setLayoutManager(gridLayoutManager);
        commercialSpecificationAdapter = new CommercialSpecificationAdapter(getActivity());
        rv.setAdapter(commercialSpecificationAdapter);
//        if (strings.size() >= 1) {
//            for (int i = 1; i <= 1000; i++) {
//                strings.add(new Commodity.DataBean("fdsdfds", "455", "45", "455", 4));
//            }
//
//        }
        commercialSpecificationAdapter.setNewData(strings);
        commercialSpecificationAdapter.setOnItemChildClickListener(this);

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.iv_add:
//                int i=1;
//                i
//                strings.size();
                break;
        }
    }
}
