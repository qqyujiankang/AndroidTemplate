package com.cn.android.ui.activity.rong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.ConversationListAdapterEX;

public class ConversationListActivity extends MyActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_conversation_list;
    }

    @Override
    protected void initView() {

        ConversationListFragment mConversationListFragment = new ConversationListFragment();
        mConversationListFragment.setAdapter( new ConversationListAdapterEX(  getActivity()) );

        Uri uri = Uri.parse( "rong://" + getApplicationInfo().packageName ).buildUpon()
                .appendPath( "conversationlist" )
                .appendQueryParameter( Conversation.ConversationType.PRIVATE.getName(), "false" )
                .appendQueryParameter( Conversation.ConversationType.GROUP.getName(), "false" )
                .appendQueryParameter( Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false" )
                .appendQueryParameter( Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false" )
                .appendQueryParameter( Conversation.ConversationType.SYSTEM.getName(), "true" )
                .build();
        mConversationListFragment.setUri( uri );
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace( R.id.conversationlist, mConversationListFragment );
        transaction.commit();
        /**
         * 启动会话列表界面。
         */
       // RongIM.getInstance().startConversationList( getActivity(), supportedConversation );
    }

    @Override
    protected void initData() {

    }
}
