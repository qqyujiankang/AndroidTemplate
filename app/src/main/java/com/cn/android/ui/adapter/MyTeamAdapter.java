package com.cn.android.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.UserBean;
import com.cn.android.bean.Userdata;
import com.hjq.image.ImageLoader;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 我的团队
 */
public class MyTeamAdapter extends BaseQuickAdapter<Userdata, BaseViewHolder> {
    private Context context;

    public MyTeamAdapter(Context context) {
        super(R.layout.adapter_my_team);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Userdata item) {
        ImageView imageView=helper.getView( R.id.iv_01 );
        ImageLoader.with( context ).load( item.getHeadImg() ).into( imageView );
        helper.setText(R.id.tv_name, item.getNickname());

    }
}
