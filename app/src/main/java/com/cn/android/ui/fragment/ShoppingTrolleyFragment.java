package com.cn.android.ui.fragment;

import android.content.Intent;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.OnShopCartItemListener;
import com.cn.android.R;
import com.cn.android.bean.CommodityManagement;
import com.cn.android.bean.ShopBean;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.activity.ConfirmAnOrderActivity;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.adapter.shopCartAdapter;
import com.cn.android.utils.TextUtils;
import com.cn.android.widget.SpaceItemDecoration;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.widget.layout.HintLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 购物车
 */
public class ShoppingTrolleyFragment extends MyLazyFragment<HomeActivity>
        implements OnTitleBarListener, OnShopCartItemListener,
        CompoundButton.OnCheckedChangeListener,
        View.OnTouchListener, PublicInterfaceView, OnRefreshListener, OnLoadMoreListener {

    List<ShopBean> list = new ArrayList<>();
    List<ShopBean> lists = new ArrayList<>();
    shopCartAdapter adapter;
    @BindView(R.id.title_bar)
    TitleBar titleBar;
    @BindView(R.id.total_num)
    TextView totalNum;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_hint_icon)
    HintLayout ivHintIcon;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.parent_check)
    CheckBox parentCheck;
    @BindView(R.id.shop_name)
    TextView shopName;
    @BindView(R.id.btn_jiesuan)
    Button btnJiesuan;
    @BindView(R.id.tv_calculateTotalAmount)
    TextView tvCalculateTotalAmount;
    @BindView(R.id.Rl_01)
    RelativeLayout Rl01;
    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.Rl_02)
    RelativeLayout Rl02;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.tv_02)
    TextView tv02;
    private Handler upDataHandler = new Handler();
    // 当前状态-结算or删除
    private boolean shop_cart_state = true;
    private PublicInterfaceePresenetr presenetr;
    private boolean isUpRefresh = true;
    private int page = 1, rows = 10;

    public static MyLazyFragment newInstance() {
        return new ShoppingTrolleyFragment();
    }

    private boolean isManual = true;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shopping_trolley;
    }

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        ImmersionBar.setTitleBar( getActivity(), titleBar );
        adapter = new shopCartAdapter( getActivity(), lists, this );
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );
        recyclerView.addItemDecoration( new SpaceItemDecoration( 10 ) );
        recyclerView.setAdapter( adapter );
        titleBar.setOnTitleBarListener( this );
        parentCheck.setOnTouchListener( this );
        parentCheck.setOnCheckedChangeListener( this );
        smartRefresh.setOnRefreshListener( this );
        smartRefresh.setOnLoadMoreListener( this );

    }


    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectOrderShopsByUserid, Constant.selectOrderShopsByUserid );
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick( v );
        if (titleBar.getRightTitle().toString().equals( "管理" )) {
            titleBar.setRightTitle( "完成" );
            Rl01.setVisibility( View.GONE );
            Rl02.setVisibility( View.VISIBLE );
        } else if (titleBar.getRightTitle().toString().equals( "完成" )) {
            titleBar.setRightTitle( "管理" );
            Rl01.setVisibility( View.VISIBLE );
            Rl02.setVisibility( View.GONE );
        }


    }

    @OnClick()
    public void onViewClicked() {


    }

    @Override
    public void OnParentCheckedListener(boolean checked, int pos) {
        lists.get( pos ).setChecked( checked );
        List<ShopBean.ShopListBean> shopItems = lists.get( pos ).getShopList();
        for (ShopBean.ShopListBean childEntity : shopItems) {
            childEntity.setChecked( checked );
        }
        lists.get( pos ).setShopList( shopItems );
        upDataHandler.post( new Runnable() {
            @Override
            public void run() {
//                    shopCartAdapter.setNewData(shopCartList);
                adapter.replaceData( lists );
            }
        } );
        tvCalculateTotalAmount.setText( calculateTotalAmount() );
    }

    @Override
    public void OnChildCheckedListener(boolean checked, final int parentPosition, int childPosition) {
        List<ShopBean.ShopListBean> childList = lists.get( parentPosition ).getShopList();
        childList.get( childPosition ).setChecked( checked );
        boolean checkAll = true;
        for (ShopBean.ShopListBean childEntity : childList) {
            if (!childEntity.isChecked()) {
                checkAll = false;
            }
        }
        lists.get( parentPosition ).setChecked( checkAll );
        upDataHandler.post( new Runnable() {
            @Override
            public void run() {
//                    shopCartAdapter.setNewData(shopCartList);
                adapter.replaceData( lists );
            }
        } );
        tvCalculateTotalAmount.setText( calculateTotalAmount() );
    }

    private int goods_num, parentPos, childPos;
    private String id;

    @Override
    public void onChildItemClickListener(View view, int childPos, int parentPos) {
        goods_num = Integer.valueOf( lists.get( parentPos ).getShopList().get( childPos ).getShop_num() );
        id = lists.get( parentPos ).getShopList().get( childPos ).getId();
        parentPos = parentPos;
        childPos = childPos;

        switch (view.getId()) {
            case R.id.goods_add:
                //sub();
                if (goods_num >= 1) {
                    goods_num -= 1;
                    //lists.get(parentPos).get(String.valueOf(goods_num));
                    lists.get( parentPos ).getShopList().get( childPos ).setShop_num( goods_num );
                    adapter.setNewData( lists );
                    tvCalculateTotalAmount.setText( calculateTotalAmount() );
                    updateOrderShopNum( goods_num );
                }


                break;
            case R.id.goods_jian:

                goods_num += 1;
                lists.get( parentPos ).getShopList().get( childPos ).setShop_num( goods_num );
                adapter.setNewData( lists );
                tvCalculateTotalAmount.setText( calculateTotalAmount() );
                updateOrderShopNum( goods_num );
                break;
        }


    }

    /**
     * 购物车==改变数量
     */
    private void updateOrderShopNum(int num) {
        goods_num = num;
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.updateOrderShopNum, Constant.updateOrderShopNum );
    }

    /**
     * 计算购物车中总金额方法
     *
     * @return 总金额
     */

    private String calculateTotalAmount() {
        // 总计金额
        float total = 0;
        // 会员已优惠金额
        float preferential_price = 0;
        boolean checkedAll = true;
        int selectNumber = 0;
        for (ShopBean parentEntity : lists) {
            if (!parentEntity.isChecked()) {
                checkedAll = false;
            }
            for (ShopBean.ShopListBean childEntity : parentEntity.getShopList()) {
                if (childEntity.isChecked()) {
                    //  selectNumber += TextUtils.toInteger(childEntity.getGoods_num());
                    total += TextUtils.toDouble( childEntity.getSku_price() ) * childEntity.getShop_num();
                    //preferential_price += TextUtils.toDouble(childEntity.getDiscount_price()) * TextUtils.toDouble(childEntity.getGoods_num());
                } else {
                    checkedAll = false;
                }
            }
        }
        this.isManual = false;
        if (lists.size() == 0) {
            parentCheck.setChecked( false );
        } else {
            parentCheck.setChecked( checkedAll );
        }
        return "合计: ¥ " + String.valueOf( total );
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        isManual = true;
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (isManual) {
            selectedAll( checked );
        } else {
            isManual = false;
        }
    }

    /**
     * 选择所有
     *
     * @param checked 全选or反选
     */
    private void selectedAll(boolean checked) {
        for (ShopBean parentEntity : lists) {
            parentEntity.setChecked( checked );
            for (ShopBean.ShopListBean childEntity : parentEntity.getShopList()) {
                childEntity.setChecked( checked );
            }
        }
        upDataHandler.post( new Runnable() {
            @Override
            public void run() {
//                        mAdapter.setNewData(shopCartList);
                adapter.replaceData( lists );
            }
        } );
        tvCalculateTotalAmount.setText( calculateTotalAmount() );
    }


    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> map = new HashMap<>();

        switch (tag) {
            case Constant.selectOrderShopsByUserid:
                map.put( "userid", userdata().getId() );
                map.put( "page", page );
                map.put( "rows", rows );
                map.put( "type", userdata().getType() );
                return map;
            case Constant.updateOrderShopNum:
                map.put( "id", id );
                map.put( "num", goods_num );
                return map;
            case Constant.deleteOrderShop:
                map.put( "ids", getids() );
                return map;
            case Constant.deleteAllOrderShop:
                map.put( "userid", userdata().getId() );
                map.put( "type", userdata().getType() );
                return map;
            case Constant.sureOrderShop:
                map.put( "ids", getids() );
                return map;
        }
        return null;
    }

    List<String> stringList;

    private String getids() {
        boolean checkedAll = true;
        stringList = new ArrayList<>();
        for (ShopBean parentEntity : lists) {
            if (!parentEntity.isChecked()) {
                checkedAll = false;
            }
            for (ShopBean.ShopListBean childEntity : parentEntity.getShopList()) {
                if (childEntity.isChecked()) {
                    stringList.add( childEntity.getId() );
                } else {
                    checkedAll = false;
                }
            }
        }
        return new Gson().toJson( stringList );
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        switch (tag) {
            case Constant.updateOrderShopNum:
                break;
            case Constant.selectOrderShopsByUserid:
                if (isUpRefresh) {
                    lists.clear();
                }
                smartRefresh.closeHeaderOrFooter();
                if (!data.equals( "[]" )) {
                    ivHintIcon.hide();

                    list = GsonUtils.getPersons( data, ShopBean.class );
                    lists.addAll( list );
                    adapter.replaceData( lists );
                    totalNum.setText( "总共" + totalNum() + "件宝贝" );
                } else if (lists.size() == 0) {
                    ivHintIcon.show();
                }
                break;
            case Constant.deleteOrderShop:
                if (lists.get( parentPos ).getShopList().size() == 1) {
                    lists.remove( parentPos );
                } else {
                    lists.get( parentPos ).getShopList().remove( childPos );

                }
                adapter.replaceData( lists );
                break;
            case Constant.deleteAllOrderShop:
                lists.clear();
                adapter.replaceData( lists );
                break;
            case Constant.sureOrderShop:
                //  startActivity( ConfirmAnOrderActivity.class );
                CommodityManagement managements = GsonUtils.getPerson( data, CommodityManagement.class );
                Intent intent = new Intent( getActivity(), ConfirmAnOrderActivity.class );
                intent.putExtra( "managements", managements );
                getActivity().startActivity( intent );
                break;
        }


    }

    /**
     * 总共多少件宝贝
     *
     * @return
     */
    private String totalNum() {
        int mun = 0;
        for (ShopBean parentEntity : lists) {


            mun = mun + parentEntity.getShopList().size();
        }

        return String.valueOf( mun );
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }


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

    @OnClick({R.id.tv_01, R.id.tv_02, R.id.btn_jiesuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_jiesuan:
                if (getids().equals( "[]" )) {
                    toast( "请选择商品" );
                    return;
                }
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.sureOrderShop, Constant.sureOrderShop );
                break;
            case R.id.tv_01://删除
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.deleteOrderShop, Constant.deleteOrderShop );
                break;
            case R.id.tv_02://清空购物车
                presenetr.getPostTokenRequest( getActivity(), ServerUrl.deleteAllOrderShop, Constant.deleteAllOrderShop );
                break;
        }
    }
}
