package com.cn.android.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.bar.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 *发布评价
 */
public class PostEvaluationActivity extends MyActivity {
    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.iv_01)
    ImageView iv01;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_post_evaluation;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_bind_commit)
    public void onViewClicked() {
        finish();
    }
}
