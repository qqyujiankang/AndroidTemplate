package com.cn.android.ui.activity.rong;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.ConversationListAdapterEX;
import com.cn.android.ui.adapter.MyMessageListAdapter;
import com.cn.android.ui.fragment.ChatConversationFragment;
import com.cn.android.utils.AndroidBug5497Workaround;
import com.hjq.bar.TitleBar;

import java.util.Locale;

import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;

/**
 * 对话
 */
public class ConversationActivity extends MyActivity {
    String mTargetId;
    @BindView(R.id.titleBar)
    TitleBar titleBar;
    @BindView(R.id.conversation)
    FrameLayout conversation;
    private String mTargetIds;
    private Conversation.ConversationType mConversationType;
    private String title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_conversation;
    }

    @Override
    protected void initView() {
        // getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        AndroidBug5497Workaround.assistActivity( getActivity() );
        Intent intent = getIntent();
        mTargetId = intent.getData().getQueryParameter( "targetId" );
        mTargetIds = intent.getData().getQueryParameter( "targetIds" );
        title = intent.getData().getQueryParameter( "title" );
        mConversationType = Conversation.ConversationType.valueOf( intent.getData().getLastPathSegment().toUpperCase( new Locale( "en", "US" ) ) );

        /* 新建 ConversationFragment 实例，通过 setUri() 设置相关属性*/
        ChatConversationFragment fragment = new ChatConversationFragment();
        Uri uri = Uri.parse( "rong://" + getApplicationInfo().packageName ).buildUpon()
                .appendPath( "conversation" ).appendPath( mConversationType.getName().toLowerCase() )
                .appendQueryParameter( "targetId", mTargetId ).build();

        fragment.setUri( uri );
        /* 加载 ConversationFragment */
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add( R.id.conversation, fragment );
        transaction.commit();
        titleBar.setTitle( title );
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }


}
