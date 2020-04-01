package com.cn.android.ui.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.SelectTypeListByPid;
import com.cn.android.bean.ShopBean;
import com.cn.android.ui.activity.CommodityClassificationActivity;
import com.cn.android.ui.activity.ProductListActivity;

import java.util.List;


/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/11/05
 * desc   : 可进行拷贝的副本
 */
public final class ShopAdapter extends BaseQuickAdapter<SelectTypeListByPid, BaseViewHolder> {

    private Context context;
    private ShopItemAdapter adapter;
    private RecyclerView recyclerView;

    public ShopAdapter(Context context) {
        super( R.layout.item_shop );
        this.context = context;

    }

    @Override
    protected void convert(BaseViewHolder helper, SelectTypeListByPid item) {
        recyclerView = helper.getView( R.id.shop );
        helper.setText( R.id.name, item.getName() );
        if (context instanceof CommodityClassificationActivity) {
            helper.setGone( R.id.shop, false );
        }
        adapter = new ShopItemAdapter( context );
        recyclerView.setLayoutManager( new GridLayoutManager( context, 3 ) );
        recyclerView.setAdapter( adapter );
        adapter.replaceData( item.getThreeList() );
        adapter.setOnItemChildClickListener( new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                switch (view.getId()) {
                    case R.id.shop_img:
                        Intent intent = new Intent( context, ProductListActivity.class );
                        intent.putExtra( "typeid", item.getThreeList().get( position ).getId() );
                        context.startActivity( intent );
                        break;

                }
            }
        } );
    }


}