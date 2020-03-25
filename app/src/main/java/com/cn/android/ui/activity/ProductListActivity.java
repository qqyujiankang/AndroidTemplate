package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.CommodityAdapter;
import com.cn.android.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static org.litepal.LitePalApplication.getContext;

/**
 * 商品列表
 */
public class ProductListActivity extends MyActivity {

    CommodityAdapter commodityAdapte1r;
    @BindView(R.id.rv_products_list)
    RecyclerView rvProductsList;
    GridLayoutManager gridLayoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_list;
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayout.VERTICAL);
        rvProductsList.addItemDecoration(new SpaceItemDecoration(10));
        rvProductsList.setLayoutManager(gridLayoutManager);
        commodityAdapte1r = new CommodityAdapter(getActivity(), 0);
        rvProductsList.setAdapter(commodityAdapte1r);
    }

    @Override
    protected void initData() {
        List<Commodity.DataBean> dataBeans = new ArrayList<>();
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));

        commodityAdapte1r.setNewData(dataBeans);
        commodityAdapte1r.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(CommodityDetailsActivity.class);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
