package com.cn.android.ui.activity;

import android.os.Bundle;
import android.widget.GridLayout;

import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.MyFavoriteAdapter;
import com.cn.android.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的收藏
 */
public class MyFavoriteActivity extends MyActivity {


    @BindView(R.id.rev)
    RecyclerView rev;
    MyFavoriteAdapter adapter;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_favorite;
    }

    @Override

    protected void initView() {
        adapter = new MyFavoriteAdapter(getActivity());
        rev.addItemDecoration(new SpaceItemDecoration(10));
        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        //设置布局管理器， 参数gridLayoutManager对象
        rev.setLayoutManager(gridLayoutManager);
        rev.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        List<Commodity.DataBean> dataBeans = new ArrayList<>();
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        adapter.setNewData(dataBeans);

    }

}
