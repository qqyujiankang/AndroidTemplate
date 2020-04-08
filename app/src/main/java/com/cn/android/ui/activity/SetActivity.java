package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.helper.ActivityStackManager;
import com.cn.android.utils.SPUtils;
import com.hjq.image.ImageLoader;
import com.hjq.toast.ToastUtils;
import com.hjq.widget.layout.SettingBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置
 */
public class SetActivity extends MyActivity {


    @BindView(R.id.sb_account_management)
    SettingBar sbAccountManagement;
    @BindView(R.id.sb_personal_data_title)
    SettingBar sbPersonalDataTitle;
    @BindView(R.id.sb_Comments_and_feedback)
    SettingBar sbCommentsAndFeedback;
    @BindView(R.id.sb_user_agreement)
    SettingBar sbUserAgreement;
    @BindView(R.id.sb_Version_checking)
    SettingBar sbVersionChecking;
    @BindView(R.id.sb_log_out)
    SettingBar sbLogOut;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set;
    }

    @Override
    protected void initView() {
        if (userdata().getType() == 2) {
            btnBindCommit.setText( "切换企业账号" );
        } else if (userdata().getType() == 1) {
            btnBindCommit.setText( "切换个人账号" );
        }
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.sb_account_management, R.id.sb_personal_data_title, R.id.sb_Comments_and_feedback, R.id.sb_user_agreement, R.id.sb_Version_checking, R.id.sb_log_out, R.id.btn_bind_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_account_management://账号管理
                startActivity( AccountManagementActivity.class );
                break;
            case R.id.sb_personal_data_title://个人资料
                startActivity( NewPersonalDataActivity.class );
                break;
            case R.id.sb_Comments_and_feedback://意见与反馈
                startActivity( FeedbackActivity.class );
                break;
            case R.id.sb_user_agreement:
                break;
            case R.id.sb_Version_checking:
                ToastUtils.show( "您目前是版本检测！！！" );
                break;
            case R.id.sb_log_out:
                // 退出登录
                // 清空缓存
                ImageLoader.clear( this );
                startActivity( TheloginIdActivity.class );
                // 进行内存优化，销毁掉所有的界面
                ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                break;
            case R.id.btn_bind_commit:
                // 退出登录
                // 清空缓存
                ImageLoader.clear( this );
                startActivity( TheloginIdActivity.class );
                // 进行内存优化，销毁掉所有的界面
                ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                break;
        }
    }
}
