package com.cn.android.ui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.hjq.dialog.AddressDialog;
import com.hjq.dialog.MessageDialog;
import com.hjq.widget.layout.SettingBar;
import com.hjq.widget.view.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收货地址"
 */
public class AddressDetailActivity extends MyActivity {
    @BindView(R.id.sb_test_switch)
    SwitchButton sbTestSwitch;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.sb01)
    SettingBar sb01;
    @BindView(R.id.tv_04)
    TextView tv04;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_address_detail;
    }

    private int anInt = 0;

    @Override
    protected void initView() {
        anInt = getIntent().getIntExtra("name", 0);
        if (anInt == 1) {
            btnBindCommit.setVisibility(View.GONE);
            tv04.setVisibility(View.VISIBLE);
        } else {

        }
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

    @OnClick({R.id.sb01, R.id.btn_bind_commit, R.id.tv_04})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_04:
                new MessageDialog.Builder(this)
                        // 标题可以不用填写
                        //.setTitle("我是标题")
                        // 内容必须要填写
                        .setMessage("确定要删除此地址吗？")
                        // 确定按钮文本
                        .setConfirm("删除")
                        // 设置 null 表示不显示取消按钮
                        .setCancel("再想想")

                        // 设置点击按钮后不关闭对话框
                        //.setAutoDismiss(false)
                        .setListener(new MessageDialog.OnListener() {

                            @Override
                            public void onConfirm(Dialog dialog) {
                                // toast("确定了");
                                finish();
                                dialog.dismiss();
                            }

                            @Override
                            public void onCancel(Dialog dialog) {
                                //  toast("取消了");
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;
            case R.id.sb01:
                new AddressDialog.Builder(getActivity())

                        .setTitle("选择地区")
                        // 设置默认省份
                        // 不选择县级区域
                        //.setIgnoreArea()
                        //  .setContentView(R.layout.dialog_address)
                        .setListener(new AddressDialog.OnListener() {

                            @Override
                            public void onSelected(Dialog dialog, String province, String city, String area) {
                                String address = province + city + area;
                                if (!sb01.getRightText().equals(address)) {
                                    sb01.setLeftText(address);
                                }
                            }

                            @Override
                            public void onCancel(Dialog dialog) {
                            }
                        })
                        .show();
                break;
            case R.id.btn_bind_commit:
                finish();
                break;
        }
    }
}
