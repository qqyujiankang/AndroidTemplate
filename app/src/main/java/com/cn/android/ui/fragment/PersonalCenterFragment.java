package com.cn.android.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.ui.activity.CommodityManagementActivity;
import com.cn.android.ui.activity.DiscountCouponActivity;
import com.cn.android.ui.activity.EnterprisesActivity;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.ui.activity.InformActivity;
import com.cn.android.ui.activity.InvitationCodeActivity;
import com.cn.android.ui.activity.IsellActivity;
import com.cn.android.ui.activity.MyFavoriteActivity;
import com.cn.android.ui.activity.MyOrderActivity;
import com.cn.android.ui.activity.MyTeamActivity;
import com.cn.android.ui.activity.NewPersonalDataActivity;
import com.cn.android.ui.activity.OpeningOfTheEnterpriseActivity;
import com.cn.android.ui.activity.ProductsCoverActivity;
import com.cn.android.ui.activity.ServiceActivity;
import com.cn.android.ui.activity.SetActivity;
import com.cn.android.ui.activity.SetupshopActivity;
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
    @BindView(R.id.tv_Enterprises)
    TextView tvEnterprises;
    @BindView(R.id.ll_obligation)
    LinearLayout llObligation;
    @BindView(R.id.ll_To_send_the_good)
    LinearLayout llToSendTheGood;
    @BindView(R.id.ll_wait_for_receiving)
    LinearLayout llWaitForReceiving;
    @BindView(R.id.ll_remain_to_be_evaluated)
    LinearLayout llRemainToBeEvaluated;
    @BindView(R.id.ll_CommodityManagement)
    LinearLayout llCommodityManagement;
    @BindView(R.id.ll_isell)
    LinearLayout llIsell;
    @BindView(R.id.ll_Products_Cover_Activity)
    LinearLayout llProductsCoverActivity;
    @BindView(R.id.ll_service)
    LinearLayout llService;
    @BindView(R.id.tvplis)
    TextView tvplis;
    @BindView(R.id.tvplis01)
    TextView tvplis01;
    @BindView(R.id.iv_tui)
    ImageView ivTui;
    @BindView(R.id.ll_updateStore)
    LinearLayout llUpdateStore;
    private int order = 0;

    public static PersonalCenterFragment newInstance() {
        return new PersonalCenterFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal_center;
    }

    @Override
    protected void initView() {
        tvBalanceOfAccount.setText( userdata().getUmoney() );
        ImageLoader.with( this )
                .circle()
                .load( userdata().getHeadImg() )
                .into( ivHear );

        if (userdata().getType() == 1) {
            tvEnterprises.setText( "已入驻" );
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.iv_set, R.id.iv_hear, R.id.ll_Discount_Coupon,
            R.id.ll_AddressDetail, R.id.ll_my_team,
            R.id.ll_Invitation_Code, R.id.tv_view_details,
            R.id.ll_favorite, R.id.tv_withdraw_deposit, R.id.tv_Enterprises,
            R.id.ll_obligation, R.id.ll_To_send_the_good,
            R.id.ll_wait_for_receiving, R.id.ll_remain_to_be_evaluated,
            R.id.ll_isell, R.id.ll_CommodityManagement,
            R.id.ll_Products_Cover_Activity, R.id.iv_information,
            R.id.ll_service, R.id.tv_add, R.id.ll_updateStore})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.ll_updateStore:
                startActivity( SetupshopActivity.class );
                break;
            case R.id.ll_service://
                startActivity( ServiceActivity.class );
                break;
            case R.id.tv_add:
                order = 1;
                order( 1 );
                break;

            case R.id.iv_information:
                startActivity( InformActivity.class );
                break;
            case R.id.ll_Products_Cover_Activity:
                if (userdata().getType() == 1) {
                    startActivity( ProductsCoverActivity.class );//商品管理
                } else {
                    startActivity( EnterprisesActivity.class );
                }//商品管理

                break;
            case R.id.ll_CommodityManagement:
                if (userdata().getType() == 1) {
                    startActivity( CommodityManagementActivity.class );//商品管理
                } else {
                    startActivity( EnterprisesActivity.class );
                }

                break;
            case R.id.tv_Enterprises:
                if (userdata().getIsReal() == 0) {
                    startActivity( EnterprisesActivity.class );
                } else if (userdata().getIsReal() == 1) {
                    startActivity( OpeningOfTheEnterpriseActivity.class );

                }
                break;
            case R.id.tv_withdraw_deposit://提现
                startActivity( WithdrawDepositActivity.class );
                break;
            case R.id.ll_favorite:
                startActivity( MyFavoriteActivity.class );//我的收藏
                break;
            case R.id.tv_view_details:
                startActivity( ThebalanceDetailsActivity.class );
                break;
            case R.id.ll_Invitation_Code://邀请码
                if (userdata().getType() == 1) {
                    startActivity( InvitationCodeActivity.class );
                } else {
                    startActivity( EnterprisesActivity.class );
                }

                break;
            case R.id.ll_AddressDetail:
                startActivity( ShippingAddressActivity.class );
                break;
            case R.id.ll_Discount_Coupon:
                startActivity( DiscountCouponActivity.class );
                break;
            case R.id.iv_set:
                startActivity( SetActivity.class );
                break;
            case R.id.iv_hear:
                startActivity( NewPersonalDataActivity.class );
                break;
            case R.id.ll_my_team:
                if (userdata().getType() == 1) {
                    startActivity( MyTeamActivity.class );
                } else {
                    startActivity( EnterprisesActivity.class );
                }

                break;
            case R.id.ll_obligation:
                order = 1;
                order( 1 );
                break;
            case R.id.ll_To_send_the_good:
                order = 2;
                order( 2 );
                break;
            case R.id.ll_wait_for_receiving:
                order = 3;
                order( 3 );
                break;
            case R.id.ll_remain_to_be_evaluated:
                order = 4;
                order( 4 );
                break;
            case R.id.ll_isell:
                if (userdata().getType() == 1) {
                    startActivity( IsellActivity.class );
                } else {
                    startActivity( EnterprisesActivity.class );
                }

                break;
            default:
        }
    }

    /**
     * 我的订单
     *
     * @param i
     */
    private void order(int i) {
        Intent intent = new Intent();
        intent.setClass( getContext(), MyOrderActivity.class );
        intent.putExtra( "order", i );
        startActivity( intent );
    }


}
