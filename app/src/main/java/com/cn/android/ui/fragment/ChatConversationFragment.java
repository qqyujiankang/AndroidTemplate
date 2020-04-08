package com.cn.android.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cn.android.R;
import com.cn.android.ui.adapter.MyMessageListAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.rong.imkit.IExtensionModule;
import io.rong.imkit.IExtensionProxy;
import io.rong.imkit.RongExtension;
import io.rong.imkit.RongExtensionManager;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.utilities.ExtensionHistoryUtil;
import io.rong.imkit.widget.adapter.MessageListAdapter;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.model.Conversation;

import static io.rong.imkit.InputBar.Style.STYLE_SWITCH_CONTAINER;

@SuppressLint("WrongConstant")
public class ChatConversationFragment extends ConversationFragment {


    /**
     * 提供 ListView 的 Adapter 适配器。
     * 使用时，需要继承 {@link ConversationFragment} 并重写此方法。
     * 注意：提供的适配器，要继承自 {@link MessageListAdapter}
     *
     * @return 适配器
     */
    public MessageListAdapter onResolveAdapter(Context context){
        return  new MyMessageListAdapter(context);
    }


}
