package com.cn.android.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.BannerBean;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.CommodityDetailsActivity;
import com.cn.android.ui.activity.DetailsOfMarketingDivisionActivity;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.activity.InformActivity;
import com.cn.android.ui.activity.NformationForDetailsActivity;
import com.cn.android.ui.activity.SearchActivity;
import com.cn.android.ui.activity.StoreNameDetailsActivity;
import com.cn.android.ui.activity.TheloginIdActivity;
import com.cn.android.ui.activity.locationActivity;
import com.cn.android.ui.adapter.CommodityAdapter;
import com.cn.android.ui.adapter.CommodityClassifyAdapter;
import com.cn.android.ui.adapter.HighQualityShopsAdapter;
import com.cn.android.ui.adapter.MarketingDivisionAdapter;
import com.cn.android.ui.adapter.NotCommodityAdapter;
import com.cn.android.ui.adapter.TheMarketingDivisionAdapter;
import com.cn.android.widget.RecyclerViewDivider;
import com.cn.android.widget.SpaceItemDecoration;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.image.ImageLoader;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.QrConfig;
import cn.bertsir.zbar.QrManager;

/**
 * 首页
 */
public class HomePageFragment extends MyLazyFragment<HomeActivity> {


    GridLayoutManager gridLayoutManager;

    NotCommodityAdapter notCommodityAdapter;
    CommodityAdapter commodityAdapte1r;
    CommodityClassifyAdapter commodityClassifyAdapter;
    @BindView(R.id.tv_qi_q)
    TextView tvQiQ;
    @BindView(R.id.sv_default)
    TextView svDefault;
    @BindView(R.id.iv_information)
    ImageView ivInformation;
    @BindView(R.id.iv_RichScan)
    ImageView ivRichScan;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.message_recycler)
    RecyclerView messageRecycler;
    @BindView(R.id.message_recycler1)
    RecyclerView messageRecycler1;
    @BindView(R.id.message_recycler2)
    RecyclerView messageRecycler2;
    @BindView(R.id.netsv)
    NestedScrollView netsv;
    @BindView(R.id.rbn_01)
    RadioButton rbn01;
    @BindView(R.id.rv_03)
    RecyclerView rv03;
    @BindView(R.id.ll_marketing_division)
    LinearLayout llMarketingDivision;
    TheMarketingDivisionAdapter theMarketingDivisionAdapter;
    @BindView(R.id.rv_04)
    RecyclerView rv04;
    MarketingDivisionAdapter marketingDivisionAdapter;
    @BindView(R.id.rv_05)
    RecyclerView rv05;
    @BindView(R.id.ll_High_quality_shops)
    LinearLayout llHighQualityShops;
    HighQualityShopsAdapter highQualityShopsAdapter;

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
        if (TheloginIdActivity.state == 0) {
            tvQiQ.setVisibility(View.GONE);
            ivInformation.setVisibility(View.VISIBLE);
            rbn01.setVisibility(View.GONE);
            llMarketingDivision.setVisibility(View.VISIBLE);
            llHighQualityShops.setVisibility(View.VISIBLE);


        } else {

        }
        ImmersionBar.setTitleBar(getActivity(), netsv);
//        List<BannerBean.DataBean> banners = new ArrayList<>();
        List<Object> integers = new ArrayList<>();
        integers.add(R.mipmap.test26);
        integers.add(R.mipmap.test26);
        integers.add(R.mipmap.test26);
        xbanner.setData(integers, null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(integers.get(position)).into((ImageView) view);
            }
        });
//        xbanner.loadImage(new XBanner.XBannerAdapter() {
//            @Override
//            public void loadBanner(XBanner banner, Object model, View view, int position) {
//                //ImageLoader.with(getActivity()).load(integers.get(position)).into((ImageView) view);
//                Glide.with(getActivity()).load(integers.get(position)).into((ImageView) view);
//            }
//        });


        rv03.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv03.addItemDecoration(new SpaceItemDecoration(30));
        theMarketingDivisionAdapter = new TheMarketingDivisionAdapter(getContext());
        rv03.setAdapter(theMarketingDivisionAdapter);

        theMarketingDivisionAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(DetailsOfMarketingDivisionActivity.class);
            }
        });

        rv05.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv05.addItemDecoration(new SpaceItemDecoration(20));
        highQualityShopsAdapter = new HighQualityShopsAdapter(getContext());
        rv05.setAdapter(highQualityShopsAdapter);
        highQualityShopsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(StoreNameDetailsActivity.class);
            }
        });

        messageRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        messageRecycler.addItemDecoration(new SpaceItemDecoration(30));
        notCommodityAdapter = new NotCommodityAdapter(getContext());
        messageRecycler.setAdapter(notCommodityAdapter);
        notCommodityAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(CommodityDetailsActivity.class);
            }
        });

        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        gridLayoutManager = new GridLayoutManager(getContext(), 5);
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation(GridLayout.VERTICAL);
        //设置布局管理器， 参数gridLayoutManager对象
        messageRecycler1.setLayoutManager(gridLayoutManager);
        commodityClassifyAdapter = new CommodityClassifyAdapter(getContext());
        messageRecycler1.setAdapter(commodityClassifyAdapter);


        commodityClassifyAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ((HomeActivity) getActivity()).onFragmentClick(position);
            }
        });

        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation(GridLayout.VERTICAL);
        //设置布局管理器， 参数gridLayoutManager对象
        messageRecycler2.setLayoutManager(gridLayoutManager);
        messageRecycler2.addItemDecoration(new SpaceItemDecoration(8));
        commodityAdapte1r = new CommodityAdapter(getContext(), 0);
        messageRecycler2.setAdapter(commodityAdapte1r);
        commodityAdapte1r.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(CommodityDetailsActivity.class);
            }
        });


        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        rv04.addItemDecoration(new RecyclerViewDivider(getActivity(), LinearLayoutManager.VERTICAL));
        rv04.setLayoutManager(gridLayoutManager);
        marketingDivisionAdapter = new MarketingDivisionAdapter(getActivity());
        rv04.setAdapter(marketingDivisionAdapter);
        marketingDivisionAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(NformationForDetailsActivity.class);
            }
        });


    }

    @Override
    protected void initData() {
        List<Commodity.DataBean> dataBeans = new ArrayList<>();
        List<Commodity.DataBean> dataBeans1 = new ArrayList<>();
        List<Commodity.DataBean> dataBeans4 = new ArrayList<>();
        List<Commodity.DataBean> dataBeans5 = new ArrayList<>();
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));
        dataBeans.add(new Commodity.DataBean("", "商品名称商品进尼康照相机商品名称商品名...", "100", "984", R.mipmap.zhaoxiangji));

        dataBeans1.add(new Commodity.DataBean("", "新鲜水果", "", "", R.mipmap.xinxianshuiguo));
        dataBeans1.add(new Commodity.DataBean("", "米面粮油", "", "", R.mipmap.mimianliangyou));
        dataBeans1.add(new Commodity.DataBean("", "调料干杂", "", "", R.mipmap.shouye01));
        dataBeans1.add(new Commodity.DataBean("", "新鲜蔬菜", "", "", R.mipmap.shouye03));
        dataBeans1.add(new Commodity.DataBean("", "酒水饮料", "", "", R.mipmap.jiushui));
        dataBeans1.add(new Commodity.DataBean("", "肉禽蛋类", "", "", R.mipmap.rouqindanlei));
        dataBeans1.add(new Commodity.DataBean("", "海鲜水产", "", "", R.mipmap.haixian));
        dataBeans1.add(new Commodity.DataBean("", "速食冻品", "", "", R.mipmap.shouye02));
        dataBeans1.add(new Commodity.DataBean("", "休闲零食", "", "", R.mipmap.xiuxian));
        dataBeans1.add(new Commodity.DataBean("", "全部产品", "", "", R.mipmap.quanbu));

        notCommodityAdapter.setNewData(dataBeans);
        commodityClassifyAdapter.setNewData(dataBeans1);
        commodityAdapte1r.setNewData(dataBeans);


        dataBeans4.add(new Commodity.DataBean("", "", "", "", R.mipmap.test12));
        dataBeans4.add(new Commodity.DataBean("", "", "", "", R.mipmap.test13));
        dataBeans4.add(new Commodity.DataBean("", "", "", "", R.mipmap.test12));


        dataBeans5.add(new Commodity.DataBean("", "", "", "", R.mipmap.test12));
        dataBeans5.add(new Commodity.DataBean("", "", "", "", R.mipmap.test12));
        dataBeans5.add(new Commodity.DataBean("", "", "", "", R.mipmap.test12));
        dataBeans5.add(new Commodity.DataBean("", "", "", "", R.mipmap.test12));
        dataBeans5.add(new Commodity.DataBean("", "", "", "", R.mipmap.test12));
        dataBeans5.add(new Commodity.DataBean("", "", "", "", R.mipmap.test12));


        theMarketingDivisionAdapter.setNewData(dataBeans);
        marketingDivisionAdapter.setNewData(dataBeans4);
        highQualityShopsAdapter.setNewData(dataBeans5);
    }

    @OnClick({R.id.tv_qi_q, R.id.sv_default, R.id.iv_information, R.id.iv_RichScan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_qi_q:
                startActivity(locationActivity.class);
                break;
            case R.id.sv_default:
                startActivity(SearchActivity.class);
                break;
            case R.id.iv_information:
                QrConfig qrConfig = new QrConfig.Builder()
                        .setDesText("(识别二维码)")//扫描框下文字
                        .setShowDes(false)//是否显示扫描框下面文字
                        .setShowLight(true)//显示手电筒按钮
                        .setShowTitle(true)//显示Title
                        .setShowAlbum(true)//显示从相册选择按钮
                        .setCornerColor(Color.WHITE)//设置扫描框颜色
                        .setLineColor(Color.WHITE)//设置扫描线颜色
                        .setLineSpeed(QrConfig.LINE_MEDIUM)//设置扫描线速度
                        .setScanType(QrConfig.TYPE_ALL)//设置扫码类型（二维码，条形码，全部，自定义，默认为二维码）
                        .setScanViewType(QrConfig.SCANVIEW_TYPE_QRCODE)//设置扫描框类型（二维码还是条形码，默认为二维码）
                        .setCustombarcodeformat(QrConfig.BARCODE_I25)//此项只有在扫码类型为TYPE_CUSTOM时才有效
                        .setPlaySound(true)//是否扫描成功后bi~的声音
                        .setNeedCrop(true)//从相册选择二维码之后再次截取二维码
                        //.setDingPath(R.raw.test)//设置提示音(不设置为默认的Ding~)
                        .setIsOnlyCenter(true)//是否只识别框中内容(默认为全屏识别)
                        .setTitleText("扫描二维码")//设置Tilte文字
                        .setTitleBackgroudColor(Color.BLUE)//设置状态栏颜色
                        .setTitleTextColor(Color.BLACK)//设置Title文字颜色
                        .setShowZoom(false)//是否手动调整焦距
                        .setAutoZoom(false)//是否自动调整焦距
                        .setScreenOrientation(QrConfig.SCREEN_PORTRAIT)//设置屏幕方向
                        .create();
                QrManager.getInstance().init(qrConfig).startScan(getActivity(), new QrManager.OnScanResultCallback() {
                    @Override
                    public void onScanSuccess(ScanResult result) {

                    }


                });
                break;
            case R.id.iv_RichScan:
                startActivity(InformActivity.class);
                break;
        }
    }
}
