package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.widget.view.SwitchButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 企业入驻
 */
public class EnterprisesActivity extends MyActivity {


    @BindView(R.id.sb_test_switch)
    SwitchButton sbTestSwitch;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.iv01)
    ImageView iv01;
    @BindView(R.id.iv_2)
    ImageView iv2;
    @BindView(R.id.iv03)
    ImageView iv03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_enterprises;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btn_bind_commit)
    public void onViewClicked() {
        startActivity(OpeningOfTheEnterpriseActivity.class);
    }

    @OnClick({R.id.iv, R.id.iv01, R.id.iv_2, R.id.iv03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv:
                ivview(iv);
                break;
            case R.id.iv01:
                ivview(iv01);
                break;
            case R.id.iv_2:
                ivview(iv2);
                break;
            case R.id.iv03:
                ivview(iv03);
                break;
        }

    }
    private void ivview(ImageView ivParticulars) {
        PhotoActivity.start(this, 5, new PhotoActivity.OnPhotoSelectListener() {
            @Override
            public void onSelect(List<String> data) {
            }

            @Override
            public void onCancel() {

            }
        });
    }
}
