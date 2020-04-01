package com.cn.android.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.hjq.image.ImageLoader;

import java.util.List;

public class MorepicturesAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Context context;
    private List<String> strings;

    public MorepicturesAdapter(Context context, List<String> strings) {
        super( R.layout.adapter_more_pictures );
        this.context = context;
        this.strings = strings;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener( R.id.iv_particulars );
        ImageView imageView = helper.getView( R.id.iv_particulars );
        if (TextUtils.isEmpty( item )) {

            ImageLoader.with( context ).load( R.mipmap.tj ).into( imageView );
            //  helper.setGone( R.id. iv_particulars,false);
        } else {
            ImageLoader.with( context ).load( item ).into( imageView );
            //helper.setGone( R.id. iv_particulars,true);

        }


//
    }
}
