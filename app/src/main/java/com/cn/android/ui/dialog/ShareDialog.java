package com.cn.android.ui.dialog;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.cn.android.R;
import com.cn.android.common.MyDialogFragment;
import com.cn.android.utils.WxShareUtils;
import com.hjq.dialog.base.BaseDialog;

import androidx.annotation.Nullable;
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
            super( activity );

            setContentView( R.layout.dialog_share );
            setAnimStyle( BaseDialog.AnimStyle.BOTTOM );
            setGravity( Gravity.BOTTOM );
        }


        @OnClick({R.id.tv_weixi, R.id.tv02, R.id.tv01})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.tv_weixi:

                    Glide.with( getContext() ).asBitmap().load( R.mipmap.person_id_card ).into( new SimpleTarget<Bitmap>() {
                        /**
                         * 成功的回调
                         */
                        @Override
                        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                            // 下面这句代码是一个过度dialog，因为是获取网络图片，需要等待时间
                            // mDialog.dismiss();
                            // 调用方法
                            WxShareUtils.shareWeb( getContext(), "wx45d9da477e2b96ee",
                                    "https://blog.csdn.net/baidu_35559769/article/details/82497289", "6545646",
                                    "ksdflas;fnl;safasfd;s", bitmap,1);
                        }

                        /**
                         * 失败的回调
                         */
                        @Override
                        public void onLoadFailed(@Nullable Drawable errorDrawable) {
                            super.onLoadFailed( errorDrawable );
                            //mDialog.dismiss();


                        }
                    } );
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