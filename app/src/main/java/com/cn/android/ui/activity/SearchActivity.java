package com.cn.android.ui.activity;

import android.os.Bundle;
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
        ImmersionBar.setTitleBar(getActivity(), ll);

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

    @OnClick(R.id.iv_bank)
    public void onViewClicked() {
        finish();
    }
}
