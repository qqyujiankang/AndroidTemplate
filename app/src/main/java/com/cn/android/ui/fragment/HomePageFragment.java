package com.cn.android.ui.fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.bean.BannerBean;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.adapter.CommodityAdapter;
import com.cn.android.ui.adapter.CommodityClassifyAdapter;
import com.cn.android.ui.adapter.NotCommodityAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.image.ImageLoader;
import com.hjq.widget.view.ClearEditText;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * 首页
 */
public class HomePageFragment extends MyLazyFragment<HomeActivity> {

    @BindView(R.id.iv_information)
    ImageView ivInformation;
    @BindView(R.id.iv_RichScan)
    ImageView ivRichScan;
    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.message_recycler)
    RecyclerView messageRecycler;
    NotCommodityAdapter notCommodityAdapter;
    CommodityAdapter commodityAdapte1r;
    CommodityClassifyAdapter commodityClassifyAdapter;
    @BindView(R.id.message_recycler1)
    RecyclerView messageRecycler1;
    @BindView(R.id.message_recycler2)
    RecyclerView messageRecycler2;
    GridLayoutManager gridLayoutManager;
    @BindView(R.id.search_txt)
    ClearEditText searchTxt;

    public static MyLazyFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        List<BannerBean.DataBean> banners = new ArrayList<>();
        banners.add(new BannerBean.DataBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584430939738&di=55dfff5917398273ac9e5266a9fce139&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D2247852322%2C986532796%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1280%26h%3D853"));
        banners.add(new BannerBean.DataBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584430939738&di=f553ccb256f45ae8748ef539822e1c18&imgtype=0&src=http%3A%2F%2Ft7.baidu.com%2Fit%2Fu%3D3204887199%2C3790688592%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D4610%26h%3D2968"));
        xbanner.setBannerData(banners);
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ImageLoader.with(getActivity()).load(banners.get(position).getImgUrl()).into((ImageView) view);
            }
        });

        messageRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        messageRecycler.addItemDecoration(new SpaceItemDecoration(30));
        notCommodityAdapter = new NotCommodityAdapter(getContext());
        messageRecycler.setAdapter(notCommodityAdapter);


        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        gridLayoutManager = new GridLayoutManager(getContext(), 5);
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation(GridLayout.VERTICAL);
        //设置布局管理器， 参数gridLayoutManager对象
        messageRecycler1.setLayoutManager(gridLayoutManager);
        commodityClassifyAdapter = new CommodityClassifyAdapter(getContext());
        messageRecycler1.setAdapter(commodityClassifyAdapter);

        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation(GridLayout.VERTICAL);
        //设置布局管理器， 参数gridLayoutManager对象
        messageRecycler2.setLayoutManager(gridLayoutManager);
        messageRecycler2.addItemDecoration(new SpaceItemDecoration(20));
        commodityAdapte1r = new CommodityAdapter(getContext());
        messageRecycler2.setAdapter(commodityAdapte1r);


    }

    @Override
    protected void initData() {
        List<Commodity.DataBean> dataBeans = new ArrayList<>();
        List<Commodity.DataBean> dataBeans1 = new ArrayList<>();
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));

        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        notCommodityAdapter.setNewData(dataBeans);
        commodityClassifyAdapter.setNewData(dataBeans1);
        commodityAdapte1r.setNewData(dataBeans);
    }
}
