package com.cn.android.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.Inform;
import com.cn.android.ui.activity.ServiceNotificationsActivity;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 服务通知和优惠促销
 */
public class ServiceNotificationsAdapter extends BaseQuickAdapter<Inform, BaseViewHolder> {
    private Context context;
    private String i;

    public ServiceNotificationsAdapter(Context context, String string) {
        super( R.layout.adapter_service_notifications );
        this.context = context;
        this.i = string;
    }

    @Override
    protected void convert(BaseViewHolder helper, Inform item) {
        helper.setText( R.id.tv_name, item.getTitle() );
        helper.setText( R.id.tv_contet, item.getContent() );
        helper.setText( R.id.tv_time, item.getCtime() );
        if (i.equals( "服务通知" )) {
            helper.setBackgroundRes( R.id.iv_f, R.mipmap.youhuicuxiao );
        } else {
            helper.setBackgroundRes( R.id.iv_f, R.mipmap.zhanghutongzhi );
        }
    }
}
