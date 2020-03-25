package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.ShippingAddressAdatper;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收货地址
 */
public class ShippingAddressActivity extends MyActivity {


    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.rv)
    RecyclerView rv;
    ShippingAddressAdatper shippingAddressAdatper;
    GridLayoutManager gridLayoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shipping_address;
    }

    @Override
    protected void initView() {
        shippingAddressAdatper = new ShippingAddressAdatper(getActivity());
        rv.addItemDecoration(new SpaceItemDecoration(10));
        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        //设置布局管理器， 参数gridLayoutManager对象
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(shippingAddressAdatper);


    }

    @Override
    protected void initData() {
        List<Commodity.DataBean> dataBeans = new ArrayList<>();
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        shippingAddressAdatper.setNewData(dataBeans);
        shippingAddressAdatper.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), AddressDetailActivity.class);
                intent.putExtra("name", 1);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_bind_commit})
    public void onViewClicked() {

        startActivity(AddressDetailActivity.class);
    }
}
