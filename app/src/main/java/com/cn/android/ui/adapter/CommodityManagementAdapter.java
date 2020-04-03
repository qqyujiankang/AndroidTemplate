package com.cn.android.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.ui.activity.CommodityManagementActivity;
import com.cn.android.ui.activity.InformActivity;
import com.cn.android.ui.activity.ProductsCoverActivity;
import com.hjq.image.ImageLoader;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * CommodityManagement商品管理
 */
public class CommodityManagementAdapter extends BaseQuickAdapter<SelectNewShop, BaseViewHolder> {
    private Context context;


    public CommodityManagementAdapter(Context context) {
        super( R.layout.adapter_commodity_management );
        this.context = context;

    }

    @Override
    protected void convert(BaseViewHolder helper, SelectNewShop item) {


        helper.setText( R.id.tv_name, item.getShopName() );
        helper.setText( R.id.tv_price, context.getString( R.string.test01 ) + item.getSellPrice() );
        helper.setText( R.id.iv_vpi_price, context.getString( R.string.test01 ) + " " + item.getVipPrice() );
        helper.addOnClickListener( R.id.tv_02 );
        helper.addOnClickListener( R.id.tv_03 );
        helper.addOnClickListener( R.id.tv_01 );
        ImageView imageView = helper.getView( R.id.iv_commodity );
        ImageLoader.with( context ).load( item.getShopImg() ).into( imageView );
        if (item.getIsBurst() == 1) {
            helper.setGone( R.id.iv_bao, true );
        } else {
            helper.setGone( R.id.iv_bao, false );
        }
        helper.addOnClickListener( R.id.tv_03 );
        if (item.getIsUp() == 1) {
            helper.setText( R.id.tv_03, "上架" );

        } else if (item.getIsUp() == 2) {
            helper.setText( R.id.tv_03, "下架" );
        }
        if (context instanceof ProductsCoverActivity) {

//            if (item.getIsSort() == 1) {
//                helper.setBackgroundRes( R.id.iv, R.mipmap.test34 );
//            } else {
//
//            }
            helper.setBackgroundRes( R.id.iv, R.mipmap.test35 );
            helper.setGone( R.id.rl_search, false );
            helper.addOnClickListener( R.id.iv );

        } else {
            helper.setGone( R.id.rl_search, true );
        }

    }
}
