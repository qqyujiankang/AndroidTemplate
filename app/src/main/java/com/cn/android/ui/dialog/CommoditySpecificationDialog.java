package com.cn.android.ui.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.CommodityManagement;
import com.cn.android.bean.ProductDetails;
import com.cn.android.common.MyActivity;
import com.cn.android.common.MyDialogFragment;
import com.cn.android.helper.ActivityStackManager;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.activity.ConfirmAnOrderActivity;
import com.cn.android.ui.activity.TheloginIdActivity;
import com.cn.android.ui.adapter.SpecificationAdaper;
import com.cn.android.utils.DataUtils;
import com.hjq.dialog.base.BaseDialog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

import static com.cn.android.ui.activity.LoginIDActivity.userdata;

/**
 * 商品详情规格
 */
public class CommoditySpecificationDialog {


    public static final class Builder
            extends MyDialogFragment.Builder<CopyDialog.Builder> implements PublicInterfaceView {

        @BindView(R.id.iv_01)
        ImageView iv01;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_02)
        TextView tv02;
        @BindView(R.id.rv_01)
        RecyclerView rv01;
        @BindView(R.id.tvmun)
        TextView tvmun;
        @BindView(R.id.goods_add)
        ImageButton goodsAdd;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.goods_jian)
        ImageButton goodsJian;
        @BindView(R.id.tv_04)
        TextView tv04;
        @BindView(R.id.ll_button)
        LinearLayout llButton;
        private FragmentActivity fragmentActivity;
        private ProductDetails productDetails;
        SpecificationAdaper specificationAdaper;
        private PublicInterfaceePresenetr presenetr;
        private String skuid, shop_price;
        private int islin, type, tat;
        private CommodityManagement managements ;


        public Builder(FragmentActivity activity, ProductDetails productDetails, int i, int type, int tat) {
            super( activity );
            this.fragmentActivity = activity;
            this.productDetails = productDetails;
            this.type = type;
            this.islin = i;
            this.tat = tat;
            setContentView( R.layout.dialog_commodity_specification );
            setAnimStyle( BaseDialog.AnimStyle.BOTTOM );
            setGravity( Gravity.BOTTOM );

            setCanceledOnTouchOutside( true );
            presenetr = new PublicInterfaceePresenetr( this );
            Glide.with( getActivity() ).load( productDetails.getDetilas() ).into( iv01 );
            tvMoney.setText( activity.getText( R.string.test01 ) + DataUtils.getMoney( productDetails.getSellPrice() ) );
            rv01.setLayoutManager( new GridLayoutManager( getActivity(), 5 ) );
            specificationAdaper = new SpecificationAdaper( getActivity() );
            rv01.setAdapter( specificationAdaper );
            specificationAdaper.replaceData( productDetails.getSkuList() );
            skuid = productDetails.getSkuList().get( 0 ).getId();
            shop_price = DataUtils.getMoney( productDetails.getSkuList().get( 0 ).getSkuPrice() );
            specificationAdaper.setOnItemChildClickListener( new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    tvMoney.setText( getContext().getString( R.string.test01 ) + productDetails.getSkuList().get( position ).getSkuPrice() + "" );
                    skuid = productDetails.getSkuList().get( position ).getId();
                }
            } );
        }

        @OnClick({R.id.goods_add, R.id.goods_jian, R.id.tv_04,})
        public void onViewClicked(View view) {
            switch (view.getId()) {

                case R.id.tv_04:
                    if (islin == 1) {
                        switch (tat) {
                            case Constant.addOrderShop:
                                presenetr.getPostTokenRequest( getActivity(), ServerUrl.addOrderShop, Constant.addOrderShop );
                                break;
                            case Constant.buyOrderShop:
                                presenetr.getPostTokenRequest( getActivity(), ServerUrl.buyOrderShop, Constant.buyOrderShop );
                                break;

                        }


                    } else {
                        Intent intent = new Intent( getActivity(), TheloginIdActivity.class );
                        getActivity().startActivity( intent );
                        ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                    }
//                    Intent intent = new Intent( getActivity(), ConfirmAnOrderActivity.class );
//                    fragmentActivity.startActivity( intent );
                    break;
                case R.id.goods_add:

                    sub();
                    break;
                case R.id.goods_jian:

                    add();
                    break;
            }
        }

        private void sub() {
            //控件初始化的时候已经给了  1  获取
            String sub = tv.getText().toString();
            //String类型转换成Int类型
            int parseInt = Integer.parseInt( sub );
            //判断
            if (parseInt > 1) {
                parseInt--;
                tv.setText( String.valueOf( parseInt ) );
                // setCurentCount(parseInt);
            } else {
                // ToastUtil.showToast("不能再少了");
            }
        }

        private void add() {
            //控件初始化的时候已经给了  1 获取
            String add = tv.getText().toString();
            //String类型转换成Int类型
            int parseInt = Integer.parseInt( add );
            parseInt++;
            tv.setText( String.valueOf( parseInt ) );
        }

        @Override
        public Map<String, Object> setPublicInterfaceData(int tag) {
            Map<String, Object> map = new HashMap<>();
            map.put( "userid", userdata().getId() );
            map.put( "shopid", productDetails.getShopid() );
            map.put( "skuid", skuid );
            map.put( "shop_price", shop_price );
            map.put( "num", tv.getText().toString().trim() );
            map.put( "type", type );

            switch (tag) {
                case Constant.addOrderShop:

                    return map;
                case Constant.buyOrderShop:

                    return map;

            }
            return null;
        }

        @Override
        public void onPublicInterfaceSuccess(String data, int tag) {
            switch (tag) {
                case Constant.addOrderShop:
                    dismiss();
                    toast( "购物车加入成功" );
                    break;
                case Constant.buyOrderShop:
                    managements = GsonUtils.getPerson( data, CommodityManagement.class );
                    Intent intent = new Intent( getActivity(), ConfirmAnOrderActivity.class );
                    intent.putExtra( "managements", managements );
                    getActivity().startActivity( intent );
                    break;
            }


        }

        @Override
        public void onPublicInterfaceError(String error, int tag) {

        }
    }
}
