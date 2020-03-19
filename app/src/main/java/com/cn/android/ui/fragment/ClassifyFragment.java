package com.cn.android.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.adapter.ClassAdapter;
import com.cn.android.widget.searchviewd.components.view.seach.KylinSearchView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/***
 * 分类
 */
public class ClassifyFragment extends MyLazyFragment<HomeActivity>  {
    @BindView(R.id.tv_qi_q)
    TextView tvQiQ;
    @BindView(R.id.sv_default)
    KylinSearchView svDefault;
    @BindView(R.id.iv_information)
    ImageView ivInformation;
    @BindView(R.id.iv_RichScan)
    ImageView ivRichScan;
    ClassAdapter classAdapter;
    @BindView(R.id.rv_class_nmae)
    RecyclerView rvClassNmae;
    List<Commodity.DataBean> dataBeans ;

    public static ClassifyFragment newInstance() {
        return new ClassifyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;

    }

    @Override
    protected void initView() {
        rvClassNmae.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBeans= new ArrayList<>();
        dataBeans.add(new Commodity.DataBean("", "手机数码", "", ""));
        dataBeans.add(new Commodity.DataBean("", "电脑办公", "", ""));
        dataBeans.add(new Commodity.DataBean("", "家用电器", "", ""));
        dataBeans.add(new Commodity.DataBean("", "手机数码", "", ""));
        dataBeans.add(new Commodity.DataBean("", "手机数码", "", ""));
        dataBeans.add(new Commodity.DataBean("", "手机数码", "", ""));
        classAdapter = new ClassAdapter(getActivity(), dataBeans);
        rvClassNmae.setAdapter(classAdapter);
    }

    @Override
    protected void initData() {


    }




}
