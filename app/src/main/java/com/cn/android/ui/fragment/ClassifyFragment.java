package com.cn.android.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.ClassifyBean;
import com.cn.android.bean.ShopBean;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.adapter.ClassAdapter;
import com.cn.android.ui.adapter.ShopAdapter;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/***
 * 分类
 */
public class ClassifyFragment extends MyLazyFragment<HomeActivity> implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.tv_qi_q)
    TextView tvQiQ;
    @BindView(R.id.iv_information)
    ImageView ivInformation;
    @BindView(R.id.iv_RichScan)
    ImageView ivRichScan;
    ClassAdapter classAdapter;
    @BindView(R.id.rv_class_nmae)
    RecyclerView rvClassNmae;
    List<ClassifyBean> dataBeans;
    List<ShopBean> dataShop;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.shop_recyclerView)
    RecyclerView shopRecyclerView;
    private ShopAdapter adapter;

    public static ClassifyFragment newInstance() {
        return new ClassifyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;

    }

    @Override
    protected void initView() {
        ImmersionBar.setTitleBar(getActivity(), title);
        rvClassNmae.setLayoutManager(new LinearLayoutManager(getActivity()));
        shopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        classAdapter = new ClassAdapter(getActivity());
        adapter = new ShopAdapter(getActivity());
        shopRecyclerView.setAdapter(adapter);
        rvClassNmae.setAdapter(classAdapter);
    }

    @Override
    protected void initData() {
        dataBeans = new ArrayList<>();
        dataBeans.add(new ClassifyBean(true, "手机数码"));
        dataBeans.add(new ClassifyBean(false, "电脑办公"));
        dataBeans.add(new ClassifyBean(false, "家用电器"));
        dataBeans.add(new ClassifyBean(false, "分类四"));
        dataBeans.add(new ClassifyBean(false, "分类五"));
        dataBeans.add(new ClassifyBean(false, "分类六"));
        dataBeans.add(new ClassifyBean(false, "分类七"));
        classAdapter.replaceData(dataBeans);
        classAdapter.setOnItemClickListener(this);
        dataShop = new ArrayList<>();
        ShopBean shopBean1=new ShopBean();
        shopBean1.setClassName("品牌");
        List<ShopBean.ShopItem> list1=new ArrayList<>();
        list1.add(new ShopBean.ShopItem(R.mipmap.test1,"华为"));
        list1.add(new ShopBean.ShopItem(R.mipmap.test2,"苹果"));
        list1.add(new ShopBean.ShopItem(R.mipmap.test3,"小米"));
        list1.add(new ShopBean.ShopItem(R.mipmap.test4,"OPPO"));
        list1.add(new ShopBean.ShopItem(R.mipmap.test5,"VIVO"));
        list1.add(new ShopBean.ShopItem(R.mipmap.test6,"三星"));
        shopBean1.setList(list1);
        dataShop.add(shopBean1);
        ShopBean shopBean2=new ShopBean();
        shopBean2.setClassName("手机");
        List<ShopBean.ShopItem> list2=new ArrayList<>();
        list2.add(new ShopBean.ShopItem(R.mipmap.test7,"iphonexr"));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7,"猕猴桃"));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7,"草莓"));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7,"苹果"));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7,"猕猴桃"));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7,"菠萝"));
        shopBean2.setList(list2);
        dataShop.add(shopBean2);
        adapter.replaceData(dataShop);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        for (int i = 0; i < dataBeans.size(); i++) {
            dataBeans.get(i).setClick(false);
        }
        dataBeans.get(position).setClick(true);
        adapter.replaceData(dataBeans);
    }
}
