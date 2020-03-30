package com.cn.android.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.OnShopCartItemListener;
import com.cn.android.R;
import com.cn.android.bean.ShopBean;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.ConfirmAnOrderActivity;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.adapter.shopCartAdapter;
import com.cn.android.widget.SpaceItemDecoration;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 购物车
 */
public class ShoppingTrolleyFragment extends MyLazyFragment<HomeActivity> implements OnTitleBarListener, OnShopCartItemListener {
    @BindView(R.id.title_bar)
    TitleBar titleBar;
    @BindView(R.id.cart_recycle)
    RecyclerView cartRecycle;
    shopCartAdapter adapter;
    @BindView(R.id.total_num)
    TextView totalNum;
    @BindView(R.id.parent_check)
    CheckBox parentCheck;
    @BindView(R.id.shop_name)
    TextView shopName;
    @BindView(R.id.btn_jiesuan)
    Button btnJiesuan;
    @BindView(R.id.Rl_01)
    RelativeLayout Rl01;
    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.Rl_02)
    RelativeLayout Rl02;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    List<ShopBean> lists = new ArrayList<>();

    public static MyLazyFragment newInstance() {
        return new ShoppingTrolleyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shopping_trolley;
    }

    @Override
    protected void initView() {
        ImmersionBar.setTitleBar(getActivity(), titleBar);
        adapter = new shopCartAdapter(getdata(), this);
        cartRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        cartRecycle.addItemDecoration(new SpaceItemDecoration(10));
        cartRecycle.setAdapter(adapter);
        titleBar.setOnTitleBarListener(this);
    }

    private List<ShopBean> getdata() {

        for (int i = 0; i < 3; i++) {
            List<ShopBean.ShopItem> items = new ArrayList<>();
            ShopBean shopBean = new ShopBean();
            for (int m = 0; m < 3; m++) {
                items.add(new ShopBean.ShopItem(2, "", "1"));
            }
            shopBean.setList(items);
            lists.add(shopBean);

        }
        return lists;
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
        if (titleBar.getRightTitle().toString().equals("管理")) {
            titleBar.setRightTitle("完成");
            Rl01.setVisibility(View.GONE);
            Rl02.setVisibility(View.VISIBLE);
        } else if (titleBar.getRightTitle().toString().equals("完成")) {
            titleBar.setRightTitle("管理");
            Rl01.setVisibility(View.VISIBLE);
            Rl02.setVisibility(View.GONE);
        }


    }

    @OnClick(R.id.btn_jiesuan)
    public void onViewClicked() {

        startActivity(ConfirmAnOrderActivity.class);
    }

    @Override
    public void OnParentCheckedListener(boolean checked, int pos) {

    }

    @Override
    public void OnChildCheckedListener(boolean checked, int parentPos, int childPos) {

    }

    @Override
    public void onChildItemClickListener(View view, int childPos, int parentPos) {
        int goods_num = Integer.valueOf(lists.get(parentPos).getList().get(childPos).getGoods_num());
        switch (view.getId()) {
            case R.id.goods_add:
                //sub();
                if (goods_num >= 1) {
                    goods_num -= 1;
                    //lists.get(parentPos).get(String.valueOf(goods_num));
                    lists.get(parentPos).getList().get(childPos).setGoods_num(String.valueOf(goods_num));
                    adapter.setNewData(lists);
                }


                break;
            case R.id.goods_jian:

                goods_num += 1;
                lists.get(parentPos).getList().get(childPos).setGoods_num(String.valueOf(goods_num));
                adapter.setNewData(lists);
                break;
        }


    }


}
