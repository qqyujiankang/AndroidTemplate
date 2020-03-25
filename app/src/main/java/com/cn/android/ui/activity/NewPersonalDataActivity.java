package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.widget.layout.SettingBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * personal_data_title 个人资料
 */
public class NewPersonalDataActivity extends MyActivity {


    @BindView(R.id.s03)
    SettingBar s03;
    @BindView(R.id.s02)
    SettingBar s02;
    @BindView(R.id.s01)
    SettingBar s01;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_personal_data;
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

    @OnClick({R.id.s03, R.id.s02, R.id.s01})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.s03:
                PhotoActivity.start(this, new PhotoActivity.OnPhotoSelectListener() {
                    @Override
                    public void onSelect(List<String> data) {

                    }

                    @Override
                    public void onCancel() {

                    }
                });
                break;
            case R.id.s02:
                break;
            case R.id.s01:
                startActivity(Genderctivity.class);
                break;
        }
    }
}
