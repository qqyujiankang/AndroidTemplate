package com.cn.android.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.HomeData;
import com.hjq.image.ImageLoader;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 优秀营销师
 */
public class TheMarketingDivisionAdapter extends BaseQuickAdapter<HomeData.MarketingUserListBean, BaseViewHolder> {
    private Context context;

    public TheMarketingDivisionAdapter(Context context) {
        super( R.layout.adapter_the_marketin_division );
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeData.MarketingUserListBean item) {
        ImageView imageView = helper.getView( R.id.iv_01 );
        ImageLoader.with( context ).load( item.getHeadImg() ).into( imageView );
        helper.setText( R.id.tv_name, item.getName() );
        helper.setText( R.id.tv, item.getLabel() );
        helper.addOnClickListener( R.id.ll_01 );
    }
}
