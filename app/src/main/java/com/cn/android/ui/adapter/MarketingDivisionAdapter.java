package com.cn.android.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.HomeData;
import com.cn.android.bean.Userdata;
import com.hjq.image.ImageLoader;

/**
 * 咨询
 */
public class MarketingDivisionAdapter extends BaseQuickAdapter<HomeData.WordsInfoListBean, BaseViewHolder> {
    private Context context;

    public MarketingDivisionAdapter(Context context) {
        super( R.layout.adapter_marketin_division );
        this.context = context;
    }

    @Override
        protected void convert(BaseViewHolder helper, HomeData.WordsInfoListBean item) {
            ImageView img = helper.getView( R.id.iv01 );
        ImageLoader.with( context ).load( item.getImgUrl() ).into( img );
        helper.setText( R.id.tv_time, item.getCtime() );
        helper.setText( R.id.tv_title, item.getTitle() );
        helper.addOnClickListener( R.id.rl_search );

    }
}
