package com.cn.android.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.ClassifyBean;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.ShopBean;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.activity.SearchActivity;
import com.cn.android.ui.activity.StoreNameDetailsActivity;
import com.cn.android.ui.activity.TheloginIdActivity;
import com.cn.android.ui.activity.locationActivity;
import com.cn.android.ui.adapter.ClassAdapter;
import com.cn.android.ui.adapter.ShopAdapter;
import com.cn.android.ui.adapter.StoreClassiFicationAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.sv_default)
    TextView svDefault;
    @BindView(R.id.shop_recyclerView1)
    RecyclerView shopRecyclerView1;
    private ShopAdapter adapter;

    public static ClassifyFragment newInstance() {
        return new ClassifyFragment();
    }

    public void onClick(int position) {
        //toast("分类 = "+position);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;

    }

    @Override
    protected void initView() {
        ImmersionBar.setTitleBar(getActivity(), title);

        if (TheloginIdActivity.state == 0) {
            ivRichScan.setBackground(getResources().getDrawable(R.mipmap.dian01));
            tvQiQ.setText("分类");
            tvQiQ.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else {
            ivRichScan.setBackground(getResources().getDrawable(R.mipmap.xiaoxi));

        }
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
        ShopBean shopBean1 = new ShopBean();
        shopBean1.setClassName("品牌");
        List<ShopBean.ShopItem> list1 = new ArrayList<>();
        list1.add(new ShopBean.ShopItem(R.mipmap.test1, "华为", ""));
        list1.add(new ShopBean.ShopItem(R.mipmap.test2, "苹果", ""));
        list1.add(new ShopBean.ShopItem(R.mipmap.test3, "小米", ""));
        list1.add(new ShopBean.ShopItem(R.mipmap.test4, "OPPO", ""));
        list1.add(new ShopBean.ShopItem(R.mipmap.test5, "VIVO", ""));
        list1.add(new ShopBean.ShopItem(R.mipmap.test6, "三星", ""));
        shopBean1.setList(list1);
        dataShop.add(shopBean1);
        ShopBean shopBean2 = new ShopBean();
        shopBean2.setClassName("手机");
        List<ShopBean.ShopItem> list2 = new ArrayList<>();
        list2.add(new ShopBean.ShopItem(R.mipmap.test7, "iphonexr", ""));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7, "猕猴桃", ""));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7, "草莓", ""));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7, "苹果", ""));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7, "猕猴桃", ""));
        list2.add(new ShopBean.ShopItem(R.mipmap.test7, "菠萝", ""));
        shopBean2.setList(list2);
        dataShop.add(shopBean2);
        adapter.replaceData(dataShop);
    }

    private int store = 1;
    StoreClassiFicationAdapter storeClassiFicationAdapter;
    List<Commodity.DataBean> dataBeans1 = new ArrayList<>();


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        for (int i = 0; i < dataBeans.size(); i++) {
            dataBeans.get(i).setClick(false);
        }
        dataBeans.get(position).setClick(true);
        adapter.replaceData(dataBeans);
    }

    @OnClick({R.id.iv_RichScan, R.id.sv_default, R.id.tv_qi_q})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_RichScan:
                if (TheloginIdActivity.state == 0) {

                    if (store == 1) {
                        store = 2;
                        shopRecyclerView1.setVisibility(View.VISIBLE);
                        shopRecyclerView.setVisibility(View.GONE);
                        ivRichScan.setBackground(getResources().getDrawable(R.drawable.fenlei));

                        if (storeClassiFicationAdapter == null) {
                            shopRecyclerView1.addItemDecoration(new SpaceItemDecoration(10));
                            shopRecyclerView1.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                            storeClassiFicationAdapter = new StoreClassiFicationAdapter(getActivity());

                        }
                        shopRecyclerView1.setAdapter(storeClassiFicationAdapter);
                        if (dataBeans1.size() == 0) {
                            dataBeans1.add(new Commodity.DataBean("", "店铺名称", "", "", R.mipmap.test29));
                            dataBeans1.add(new Commodity.DataBean("", "店铺名称", "", "", R.mipmap.test30));
                            dataBeans1.add(new Commodity.DataBean("", "店铺名称", "", "", R.mipmap.test29));
                            dataBeans1.add(new Commodity.DataBean("", "店铺名称", "", "", R.mipmap.test31));
                        }

                        storeClassiFicationAdapter.setNewData(dataBeans1);//StoreNameDetailsActivity
                        storeClassiFicationAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                startActivity(StoreNameDetailsActivity.class);
                            }
                        });
                    } else if (store == 2) {
                        store = 1;
                        shopRecyclerView1.setVisibility(View.GONE);
                        shopRecyclerView.setVisibility(View.VISIBLE);
                        ivRichScan.setBackground(getResources().getDrawable(R.mipmap.dian01));

                        if (adapter == null) {
                            shopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            adapter = new ShopAdapter(getActivity());
                        }
                        shopRecyclerView.setAdapter(adapter);
                        initData();

                    }
                }
                break;
            case R.id.sv_default:
                startActivity(SearchActivity.class);
                break;
            case R.id.tv_qi_q:
                startActivity(locationActivity.class);
                break;
        }

    }


}
