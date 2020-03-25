package com.cn.android.ui.dialog;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyDialogFragment;
import com.hjq.dialog.base.BaseDialog;

import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 可进行拷贝的副本
 */
public final class ShareDialog {

    public static final class Builder
            extends MyDialogFragment.Builder<Builder> {

        @BindView(R.id.tv_weixi)
        TextView tvWeixi;
        @BindView(R.id.tv01)
        TextView tv01;
        @BindView(R.id.tv02)
        TextView tv02;

        public Builder(FragmentActivity activity) {
            super(activity);

            setContentView(R.layout.dialog_share);
            setAnimStyle(BaseDialog.AnimStyle.BOTTOM);
            setGravity(Gravity.BOTTOM);
        }


        @OnClick({R.id.tv_weixi, R.id.tv02, R.id.tv01})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.tv_weixi:
                    dismiss();
                    break;
                case R.id.tv02:
                    dismiss();
                    break;
                case R.id.tv01:
                    dismiss();
                    break;

            }
        }
    }
}