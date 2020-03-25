package com.cn.android.ui.dialog;

import android.graphics.Bitmap;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyDialogFragment;
import com.hjq.dialog.base.BaseDialog;

import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import cn.bertsir.zbar.utils.QRUtils;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 可进行拷贝的副本
 */
public final class QRcoDialog {

    public static final class Builder
            extends MyDialogFragment.Builder<Builder> {


        @BindView(R.id.iv_delete)
        ImageView ivDelete;
        @BindView(R.id.iv_code)
        ImageView ivCode;
        @BindView(R.id.ll)
        RelativeLayout ll;
        @BindView(R.id.tv)
        TextView tv;

        public Builder(FragmentActivity activity, int i, String s) {
            super(activity);

            setContentView(R.layout.dialog_qr_code);
            Bitmap qrCode = QRUtils.getInstance().createQRCode("www.qq.com");
            ivCode.setImageBitmap(qrCode);
            setAnimStyle(BaseDialog.AnimStyle.RIGHT);
            tv.setText(s);
            setGravity(i);

            setCanceledOnTouchOutside(true);

        }

        @OnClick(R.id.iv_delete)
        public void onViewClicked() {
            dismiss();
        }
    }
}