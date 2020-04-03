package com.cn.android.ui.dialog;

import android.view.Gravity;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyDialogFragment;
import com.hjq.dialog.base.BaseDialog;

import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 可进行拷贝的副本
 */
public final class TostDialog {

    public static final class Builder
            extends MyDialogFragment.Builder<Builder> {

        @BindView(R.id.text)
        TextView text;

        public Builder(FragmentActivity activity, String string) {
            super( activity );

            setContentView( R.layout.dialog_toast1 );
            setAnimStyle( BaseDialog.AnimStyle.BOTTOM );
            setGravity( Gravity.CENTER );
            setCanceledOnTouchOutside( true );
            text.setText( string );
        }
    }
}