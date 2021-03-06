package com.cn.android.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.selectStoreListByPid;
import com.hjq.image.ImageLoader;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 分类商铺
 */
public class StoreClassiFicationAdapter extends BaseQuickAdapter<selectStoreListByPid, BaseViewHolder> {
    private Context context;

    public StoreClassiFicationAdapter(Context context) {
        super( R.layout.adapter_store_classi_fication );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, selectStoreListByPid item) {
        ImageView imageView = helper.getView( R.id.rv );
        ImageLoader.with( context ).load( item.getStoreImg() ).into( imageView );
        //helper.setBackgroundRes(R.id.rv, item.getDrawable());
        helper.setText( R.id.tv01, item.getStoreName() );
        helper.addOnClickListener( R.id.rv );
        //elper.setBackgroundColor(R.id.tv01,Color.argb(0, 0, 0,0));
    }
}
