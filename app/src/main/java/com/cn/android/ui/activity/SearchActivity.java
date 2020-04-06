package com.cn.android.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
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
public class SearchActivity extends MyActivity {

    @BindView(R.id.iv_bank)
    ImageView ivBank;
    @BindView(R.id.search_txt)
    ClearEditText searchTxt;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.ll)
    LinearLayout ll;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        ImmersionBar.setTitleBar( getActivity(), ll );
        searchTxt.setOnEditorActionListener( new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Intent intent = new Intent( getActivity(), ProductListActivity.class );
                    intent.putExtra( "search", searchTxt.getText().toString().trim() );
                    startActivity( intent );

                    return true;
                }
                return false;
            }
        } );
    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.iv_bank)
    public void onViewClicked() {
        finish();
    }


}
