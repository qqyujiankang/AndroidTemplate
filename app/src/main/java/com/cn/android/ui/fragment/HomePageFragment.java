package com.cn.android.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.HomeData;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.network.Constant;
import com.cn.android.network.GetJsonDate;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.activity.CommodityDetailsActivity;
import com.cn.android.ui.activity.DetailsOfMarketingDivisionActivity;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.activity.InformActivity;
import com.cn.android.ui.activity.NformationForDetailsActivity;
import com.cn.android.ui.activity.SearchActivity;
import com.cn.android.ui.activity.StoreNameDetailsActivity;
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
import com.hjq.widget.layout.HintLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
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
public class HomePageFragment extends MyLazyFragment<HomeActivity> implements
        PublicInterfaceView, OnRefreshListener, OnLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {


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
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smallLabel)
    SmartRefreshLayout smallLabel;
    private PublicInterfaceePresenetr presenetr;


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
        presenetr = new PublicInterfaceePresenetr( this );
        smallLabel.setOnRefreshListener( this );
        smallLabel.setOnLoadMoreListener( this );
        if (userdata().getType() == 1) {
            tvQiQ.setVisibility( View.GONE );
            ivInformation.setVisibility( View.VISIBLE );
            rbn01.setVisibility( View.GONE );
            llMarketingDivision.setVisibility( View.VISIBLE );
            llHighQualityShops.setVisibility( View.VISIBLE );
        } else {
        }
        tvQiQ.setText( userdata().getArea() );
        ImmersionBar.setTitleBar( getActivity(), netsv );
        rv03.setLayoutManager( new LinearLayoutManager( getContext(), LinearLayoutManager.HORIZONTAL, false ) );
        rv03.addItemDecoration( new SpaceItemDecoration( 30 ) );
        theMarketingDivisionAdapter = new TheMarketingDivisionAdapter( getContext() );
        rv03.setAdapter( theMarketingDivisionAdapter );

        theMarketingDivisionAdapter.setOnItemChildClickListener( this );

        rv05.setLayoutManager( new LinearLayoutManager( getContext(), LinearLayoutManager.HORIZONTAL, false ) );
        rv05.addItemDecoration( new SpaceItemDecoration( 20 ) );
        highQualityShopsAdapter = new HighQualityShopsAdapter( getContext() );
        rv05.setAdapter( highQualityShopsAdapter );
        highQualityShopsAdapter.setOnItemChildClickListener( this );

        messageRecycler.setLayoutManager( new LinearLayoutManager( getContext(), LinearLayoutManager.HORIZONTAL, false ) );
        messageRecycler.addItemDecoration( new SpaceItemDecoration( 30 ) );
        notCommodityAdapter = new NotCommodityAdapter( getContext() );
        messageRecycler.setAdapter( notCommodityAdapter );
        notCommodityAdapter.setOnItemChildClickListener( this );

        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        gridLayoutManager = new GridLayoutManager( getContext(), 5 );
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation( GridLayout.VERTICAL );
        //设置布局管理器， 参数gridLayoutManager对象
        messageRecycler1.setLayoutManager( gridLayoutManager );
        commodityClassifyAdapter = new CommodityClassifyAdapter( getContext() );
        messageRecycler1.setAdapter( commodityClassifyAdapter );


        commodityClassifyAdapter.setOnItemChildClickListener( this );

        //布局管理器对象 参数1.上下文 2.规定一行显示几列的参数常量
        gridLayoutManager = new GridLayoutManager( getContext(), 2 );
        //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
        gridLayoutManager.setOrientation( GridLayout.VERTICAL );
        //设置布局管理器， 参数gridLayoutManager对象
        messageRecycler2.setLayoutManager( gridLayoutManager );
        messageRecycler2.addItemDecoration( new SpaceItemDecoration( 8 ) );
        commodityAdapte1r = new CommodityAdapter( getContext(), 0 );
        messageRecycler2.setAdapter( commodityAdapte1r );
        commodityAdapte1r.setOnItemChildClickListener( this );


        gridLayoutManager = new GridLayoutManager( getContext(), 1 );
        rv04.addItemDecoration( new RecyclerViewDivider( getActivity(), LinearLayoutManager.VERTICAL ) );
        rv04.setLayoutManager( gridLayoutManager );
        marketingDivisionAdapter = new MarketingDivisionAdapter( getActivity() );
        rv04.setAdapter( marketingDivisionAdapter );
        marketingDivisionAdapter.setOnItemChildClickListener( this );


    }

    @Override
    protected void initData() {
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectHome, Constant.selectHome );
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectNewShopList, Constant.selectNewShopList );
    }

    private int category = 1;

    @OnClick({R.id.tv_qi_q, R.id.sv_default, R.id.iv_information, R.id.iv_RichScan, R.id.rbn_01, R.id.rbn_02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbn_02:
                selectNewShopArrayList.clear();
                category = 2;
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectNewShopList, Constant.selectNewShopList );
                break;
            case R.id.rbn_01:
                selectNewShopArrayList.clear();
                category = 1;
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectNewShopList, Constant.selectNewShopList );
                break;
            case R.id.tv_qi_q:
                startActivity( locationActivity.class );
                break;
            case R.id.sv_default:
                startActivity( SearchActivity.class );
                break;
            case R.id.iv_information:
                QrConfig qrConfig = new QrConfig.Builder()
                        .setDesText( "(识别二维码)" )//扫描框下文字
                        .setShowDes( false )//是否显示扫描框下面文字
                        .setShowLight( true )//显示手电筒按钮
                        .setShowTitle( true )//显示Title
                        .setShowAlbum( true )//显示从相册选择按钮
                        .setCornerColor( Color.WHITE )//设置扫描框颜色
                        .setLineColor( Color.WHITE )//设置扫描线颜色
                        .setLineSpeed( QrConfig.LINE_MEDIUM )//设置扫描线速度
                        .setScanType( QrConfig.TYPE_ALL )//设置扫码类型（二维码，条形码，全部，自定义，默认为二维码）
                        .setScanViewType( QrConfig.SCANVIEW_TYPE_QRCODE )//设置扫描框类型（二维码还是条形码，默认为二维码）
                        .setCustombarcodeformat( QrConfig.BARCODE_I25 )//此项只有在扫码类型为TYPE_CUSTOM时才有效
                        .setPlaySound( true )//是否扫描成功后bi~的声音
                        .setNeedCrop( true )//从相册选择二维码之后再次截取二维码
                        //.setDingPath(R.raw.test)//设置提示音(不设置为默认的Ding~)
                        .setIsOnlyCenter( true )//是否只识别框中内容(默认为全屏识别)
                        .setTitleText( "扫描二维码" )//设置Tilte文字
                        .setTitleBackgroudColor( Color.BLUE )//设置状态栏颜色
                        .setTitleTextColor( Color.BLACK )//设置Title文字颜色
                        .setShowZoom( false )//是否手动调整焦距
                        .setAutoZoom( false )//是否自动调整焦距
                        .setScreenOrientation( QrConfig.SCREEN_PORTRAIT )//设置屏幕方向
                        .create();
                QrManager.getInstance().init( qrConfig ).startScan( getActivity(), new QrManager.OnScanResultCallback() {
                    @Override
                    public void onScanSuccess(ScanResult result) {

                    }


                } );
                break;
            case R.id.iv_RichScan:
                startActivity( InformActivity.class );
                break;
        }
    }


    private int page = 1, rows = 10;

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "type", userdata().getType() );
        paramsMap.put( "province", userdata().getProvince() );
        paramsMap.put( "city", userdata().getCity() );
        paramsMap.put( "area", userdata().getArea() );

        switch (tag) {
            case Constant.selectHome:

                return paramsMap;
            case Constant.selectNewShopList:
                paramsMap.put( "page", page );
                paramsMap.put( "rows", rows );

                paramsMap.put( "category", category );
                return paramsMap;
        }
        return null;
    }

    List<SelectNewShop> shops = new ArrayList<>();
    List<SelectNewShop> selectNewShopArrayList = new ArrayList<>();
    List<HomeData.ShufflingInfoListBean> shufflingInfoListBeans = new ArrayList<>();
    //优秀营销师
    private List<HomeData.MarketingUserListBean> marketingUserListBeanList = new ArrayList<>();
    //咨询列表
    private List<HomeData.WordsInfoListBean> wordsInfoListBeanList = new ArrayList<>();
    //    优质店铺
    private List<HomeData.AppUserListBean> appUserListBeanList = new ArrayList<>();

    //    每日爆品
    private List<SelectNewShop> shopInfoListBeanArrayList = new ArrayList<>();
    //分类
    private List<HomeData.ShopTypeListBean> shopTypeListBeanList = new ArrayList<>();

    String shufflingInfoList, marketingUserList, wordsInfoList, appUserList, shopInfoList, shopTypeList;

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        switch (tag) {
            case Constant.selectHome:
                shufflingInfoList = GetJsonDate.getJsonDriveq( data, "shufflingInfoList" );
                marketingUserList = GetJsonDate.getJsonDriveq( data, "marketingUserList" );
                wordsInfoList = GetJsonDate.getJsonDriveq( data, "wordsInfoList" );
                appUserList = GetJsonDate.getJsonDriveq( data, "appUserList" );
                shopInfoList = GetJsonDate.getJsonDriveq( data, "shopInfoList" );
                shopTypeList = GetJsonDate.getJsonDriveq( data, "shopTypeList" );
                shufflingInfoListBeans = GsonUtils.getPersons( shufflingInfoList, HomeData.ShufflingInfoListBean.class );
                marketingUserListBeanList = GsonUtils.getPersons( marketingUserList, HomeData.MarketingUserListBean.class );
                wordsInfoListBeanList = GsonUtils.getPersons( wordsInfoList, HomeData.WordsInfoListBean.class );
                appUserListBeanList = GsonUtils.getPersons( appUserList, HomeData.AppUserListBean.class );
                shopInfoListBeanArrayList = GsonUtils.getPersons( shopInfoList, SelectNewShop.class );
                shopTypeListBeanList = GsonUtils.getPersons( shopTypeList, HomeData.ShopTypeListBean.class );

                if (userdata().getType() == 1) {
                    theMarketingDivisionAdapter.setNewData( marketingUserListBeanList );
                    highQualityShopsAdapter.setNewData( appUserListBeanList );
                    marketingDivisionAdapter.setNewData( wordsInfoListBeanList );
                }

                //homeData = GsonUtils.getPerson( data, HomeData.class );

                xbanner.setData( shufflingInfoListBeans, null );
                xbanner.setmAdapter( new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with( getActivity() ).load( shufflingInfoListBeans.get( position ).getImgUrl() ).into( (ImageView) view );
                    }
                } );


                commodityClassifyAdapter.setNewData( shopTypeListBeanList );

                notCommodityAdapter.setNewData( shopInfoListBeanArrayList );

                //commodityAdapte1r.setNewData( dataBeans );
                break;
            case Constant.selectNewShopList:
                if (isUpRefresh) {
                    selectNewShopArrayList.clear();
                    if (data.equals( "null" )) {
                        showEmpty();
                        return;
                    }
                }
                smallLabel.closeHeaderOrFooter();
                shops = GsonUtils.getPersons( data, SelectNewShop.class );
                selectNewShopArrayList.addAll( shops );
                commodityAdapte1r.replaceData( selectNewShopArrayList );
                break;
        }

    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    private boolean isUpRefresh = true;

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        isUpRefresh = false;
        page = page + 1;
        initData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        isUpRefresh = true;
        page = 1;
        initData();
    }

    private SelectNewShop selectNewShop;

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (adapter instanceof MarketingDivisionAdapter) {
            Intent intent = new Intent( getActivity(), NformationForDetailsActivity.class );
            intent.putExtra( "id", wordsInfoListBeanList.get( position ).getId() );
            startActivity( intent );
        } else if (adapter instanceof CommodityAdapter) {
            selectNewShop = shopInfoListBeanArrayList.get( position );
            Intent intent = new Intent( getActivity(), CommodityDetailsActivity.class );
            intent.putExtra( "SelectNewShop", selectNewShop );
            startActivity( intent );
        } else if (adapter instanceof CommodityClassifyAdapter) {
            if (position!=9){
                ((HomeActivity) getActivity()).onFragmentClick( position );
            }else {
                ((HomeActivity) getActivity()).onFragmentClick( 0 );
            }

        } else if (adapter instanceof HighQualityShopsAdapter) {
            Intent intent = new Intent( getActivity(), StoreNameDetailsActivity.class );
            intent.putExtra( "AppUserListBean", appUserListBeanList.get( position ) );
            startActivity( intent );
        } else if (adapter instanceof TheMarketingDivisionAdapter) {
            Intent intent = new Intent( getActivity(), DetailsOfMarketingDivisionActivity.class );
            intent.putExtra( "id", marketingUserListBeanList.get( position ).getId() );
            startActivity( intent );
        } else if (adapter instanceof NotCommodityAdapter) {//每日爆品
            selectNewShop = shopInfoListBeanArrayList.get( position );
            Intent intent = new Intent( getActivity(), CommodityDetailsActivity.class );
            intent.putExtra( "SelectNewShop", selectNewShop );

            startActivity( intent );
        }
    }
}
