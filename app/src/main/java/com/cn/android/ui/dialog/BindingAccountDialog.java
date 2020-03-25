package com.cn.android.ui.dialog;

import android.view.Gravity;

import com.cn.android.R;
import com.cn.android.common.MyDialogFragment;
import com.hjq.dialog.base.BaseDialog;

import androidx.fragment.app.FragmentActivity;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/10/18
 *    desc   : 可进行拷贝的副本
 */
public final class BindingAccountDialog {

    public static final class Builder
            extends MyDialogFragment.Builder<Builder> {

        public Builder(FragmentActivity activity) {
            super(activity);

            setContentView(R.layout.dialog_binding_account);
            setAnimStyle(BaseDialog.AnimStyle.BOTTOM);
            setGravity(Gravity.CENTER);
            setCanceledOnTouchOutside(true);

        }
    }
}