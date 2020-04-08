package com.cn.android.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cn.android.R;
import com.hjq.image.ImageLoader;

import io.rong.imkit.model.UIConversation;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.ProviderContainerView;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import io.rong.imlib.model.Conversation;

public class ConversationListAdapterEX extends ConversationListAdapter {
    private final Context context;

    public ConversationListAdapterEX(Context context) {
        super( context );
        this.context = context;
    }

    @Override
    protected View newView(Context context, int position, ViewGroup group) {
        ViewHolder holder = new ViewHolder();
        return super.newView( context, position, group );
    }

    @Override
    protected void bindView(View v, int position, UIConversation data) {
        if (data.getConversationType().equals( Conversation.ConversationType.DISCUSSION ))
            data.setUnreadType( UIConversation.UnreadRemindType.REMIND_ONLY );
        ConversationListAdapter.ViewHolder holder = (ConversationListAdapter.ViewHolder) v.getTag();
         holder.leftImageView.setCircle( true );
       // ImageLoader.with( context ).circle().load( String.valueOf( data.getIconUrl() ) ).into( holder.leftImageView );
        super.bindView( v, position, data );
    }

    public class ViewHolder {
        public View layout;
        public View leftImageLayout;
        public View rightImageLayout;
        public View leftUnReadView;
        public View rightUnReadView;
        public AsyncImageView leftImageView;
        public TextView unReadMsgCount;
        public ImageView unReadMsgCountIcon;
        public AsyncImageView rightImageView;
        public TextView unReadMsgCountRight;
        public ImageView unReadMsgCountRightIcon;
        public ProviderContainerView contentView;

        protected ViewHolder() {
        }
    }
}
