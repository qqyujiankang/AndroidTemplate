package com.cn.android.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.DiscountCouponActivity;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.activity.InvitationCodeActivity;
import com.cn.android.ui.activity.MyFavoriteActivity;
import com.cn.android.ui.activity.MyTeamActivity;
import com.cn.android.ui.activity.NewPersonalDataActivity;
import com.cn.android.ui.activity.SetActivity;
import com.cn.android.ui.activity.ShippingAddressActivity;
import com.cn.android.ui.activity.ThebalanceDetailsActivity;
import com.cn.android.ui.activity.WithdrawDepositActivity;
import com.hjq.image.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人中心
 */
public class PersonalCenterFragment extends MyLazyFragment<HomeActivity> {
    @BindView(R.id.iv_information)
    ImageView ivInformation;
    @BindView(R.id.iv_set)
    ImageView ivSet;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_hear)
    ImageView ivHear;
    @BindView(R.id.tv_balance_of_account)
    TextView tvBalanceOfAccount;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.tv_view_details)
    TextView tvViewDetails;
    @BindView(R.id.ll_AddressDetail)
    LinearLayout llAddressDetail;
    @BindView(R.id.ll_Discount_Coupon)
    LinearLayout llDiscountCoupon;
    @BindView(R.id.ll_Invitation_Code)
    LinearLayout llInvitationCode;
    @BindView(R.id.ll_my_team)
    LinearLayout llMyTeam;
    @BindView(R.id.tv_withdraw_deposit)
    TextView tvWithdrawDeposit;
    @BindView(R.id.ll_favorite)
    LinearLayout llFavorite;

    public static PersonalCenterFragment newInstance() {
        return new PersonalCenterFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal_center;
    }

    @Override
    protected void initView() {
        ImageLoader.with(this)
                .circle()
                .load("https://www.baidu.com/img/bd_logo.png")
                .into(ivHear);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.iv_set, R.id.iv_hear, R.id.ll_Discount_Coupon,
            R.id.ll_AddressDetail, R.id.ll_my_team,
            R.id.ll_Invitation_Code, R.id.tv_view_details, R.id.ll_favorite, R.id.tv_withdraw_deposit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_withdraw_deposit://提现
                startActivity(WithdrawDepositActivity.class);
                break;
            case R.id.ll_favorite:
                startActivity(MyFavoriteActivity.class);//我的收藏
                break;
            case R.id.tv_view_details:
                startActivity(ThebalanceDetailsActivity.class);
                break;
            case R.id.ll_Invitation_Code://邀请码
                startActivity(InvitationCodeActivity.class);
                break;
            case R.id.ll_AddressDetail:
                startActivity(ShippingAddressActivity.class);
                break;
            case R.id.ll_Discount_Coupon:
                startActivity(DiscountCouponActivity.class);
                break;
            case R.id.iv_set:
                startActivity(SetActivity.class);
                break;
            case R.id.iv_hear:
                startActivity(NewPersonalDataActivity.class);
                break;
            case R.id.ll_my_team:
                startActivity(MyTeamActivity.class);
                break;
        }
    }
}
