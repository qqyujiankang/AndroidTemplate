package com.cn.android.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.cn.android.R;
import com.hjq.image.ImageLoader;

import io.rong.imkit.model.UIConversation;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import io.rong.imkit.widget.adapter.MessageListAdapter;
import io.rong.imlib.model.Conversation;

public class MyMessageListAdapter extends MessageListAdapter {
    private final Context context;

    public MyMessageListAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected View newView(Context context, int position, ViewGroup group) {
        return super.newView(context, position, group);
    }

    @Override
    protected void bindView(View v, int position, UIMessage data) {
        super.bindView(v, position, data);
        final ViewHolder holder = (ViewHolder) v.getTag();
        if (data.getUserInfo() == null) {
            ImageLoader.with(context).load(R.mipmap.tj).circle().into(holder.leftIconView);
            ImageLoader.with(context).load(R.mipmap.tj).circle().into(holder.rightIconView);
        } else {
            ImageLoader.with(context).load(String.valueOf(data.getUserInfo().getPortraitUri())).circle().into(holder.leftIconView);
            ImageLoader.with(context).load(String.valueOf(data.getUserInfo().getPortraitUri())).circle().into(holder.rightIconView);
        }
    }
}

