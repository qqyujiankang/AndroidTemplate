package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.widget.view.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 搜索
 */
public class SearchActivity extends MyActivity implements TextWatcher {

    @BindView(R.id.iv_bank)
    ImageView ivBank;
    @BindView(R.id.search_txt)
    ClearEditText searchTxt;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.ll)
    LinearLayout ll;
    int EDIT_OK = 200;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            if (EDIT_OK == msg.what) {
                // toast( msg.getData() );
                Intent intent = new Intent( getActivity(), ProductListActivity.class );
                intent.putExtra( "search", searchTxt.getText().toString().trim() );
                startActivity( intent );
            }

        }
    };

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

            mHandler.sendEmptyMessage( EDIT_OK );
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        ImmersionBar.setTitleBar( getActivity(), ll );
        searchTxt.addTextChangedListener( this );
    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.iv_bank)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //这个方法被调用，说明在s字符串中，从start位置开始的count个字符即将被长度为after的新文本所取代。
        // 在这个方法里面改变s，会报错。

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //这个方法被调用，说明在s字符串中，从start位置开始的count个字符刚刚取代了长度为before的旧文本。
        // 在这个方法里面改变s，会报错
        mHandler.postDelayed( mRunnable, 800 );
    }

    @Override
    public void afterTextChanged(Editable editable) {
        //这个方法被调用，那么说明s字符串的某个地方已经被改变。

    }
}
