package com.cn.android.ui.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.helper.ActivityStackManager;
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
import com.cn.android.ui.activity.TheloginIdActivity;
import com.cn.android.ui.activity.WithdrawDepositActivity;
import com.cn.android.utils.DataUtils;
import com.hjq.dialog.MessageDialog;
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
    @BindView(R.id.tv_Enterprises)
    TextView tvEnterprises;
    @BindView(R.id.iv_hear)
    ImageView ivHear;
    @BindView(R.id.tv_balance_of_account)
    TextView tvBalanceOfAccount;
    @BindView(R.id.tv_view_details)
    TextView tvViewDetails;
    @BindView(R.id.tv_withdraw_deposit)
    TextView tvWithdrawDeposit;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.ll_obligation)
    LinearLayout llObligation;
    @BindView(R.id.ll_To_send_the_good)
    LinearLayout llToSendTheGood;
    @BindView(R.id.ll_wait_for_receiving)
    LinearLayout llWaitForReceiving;
    @BindView(R.id.ll_remain_to_be_evaluated)
    LinearLayout llRemainToBeEvaluated;
    @BindView(R.id.tvplis)
    TextView tvplis;
    @BindView(R.id.tvplis01)
    TextView tvplis01;
    @BindView(R.id.iv_tui)
    ImageView ivTui;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.Rl_01)
    LinearLayout llPul;
    @BindView(R.id.ll_AddressDetail)
    LinearLayout llAddressDetail;
    @BindView(R.id.ll_service)
    LinearLayout llService;
    @BindView(R.id.ll_Discount_Coupon)
    LinearLayout llDiscountCoupon;
    @BindView(R.id.ll_favorite)
    LinearLayout llFavorite;
    @BindView(R.id.ll_Products_Cover_Activity)
    LinearLayout llProductsCoverActivity;
    @BindView(R.id.ll_Invitation_Code)
    LinearLayout llInvitationCode;
    @BindView(R.id.ll_my_team)
    LinearLayout llMyTeam;
    @BindView(R.id.ll_CommodityManagement)
    LinearLayout llCommodityManagement;
    @BindView(R.id.ll_isell)
    LinearLayout llIsell;
    @BindView(R.id.ll_updateStore)
    LinearLayout llUpdateStore;
    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.tv_02)
    TextView tv02;
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
        tv01.setText( getString( R.string.test01 )+"1980" );
        tv02.setText( getString( R.string.test01 )+"4980" );
        if (userdata() != null) {
            tvBalanceOfAccount.setText( DataUtils.getMoney( userdata().getUmoney() ) );

            if (TextUtils.isEmpty( userdata().getHeadImg() )) {
                ImageLoader.with( this )
                        .circle()
                        .load( R.mipmap.test24 )
                        .into( ivHear );
            } else {
                ImageLoader.with( this )
                        .circle()
                        .load( userdata().getHeadImg() )
                        .into( ivHear );
            }

            if (userdata().getIsReal() == 2) {
                tvEnterprises.setText( "已入驻" );
            }
            if (userdata().getType() == 2) {
                llPul.setVisibility( View.GONE );
            }
            tvName.setText( userdata().getNickname() );
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
            R.id.ll_service, R.id.tv_add, R.id.ll_updateStore, R.id.Rl_01})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.Rl_01:
                if (userdata().getType() == 1 && userdata().getIsReal() == 2) {
                    startActivity( OpeningOfTheEnterpriseActivity.class );
                } else {
                    bushiqie();
                }
                break;
            case R.id.ll_updateStore:
                if (userdata().getType() == 1 && userdata().getIsReal() == 2) {
                    startActivity( SetupshopActivity.class );
                } else {
                    bushiqie();
                }
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
                if (userdata().getType() == 1 && userdata().getIsReal() == 2) {

                    startActivity( ProductsCoverActivity.class );//cover商品自荐


                } else {
                    //startActivity( EnterprisesActivity.class );
                    bushiqie();
                }//商品管理

                break;
            case R.id.ll_CommodityManagement:
                if (userdata().getType() == 1 && userdata().getIsReal() == 2) {

                    startActivity( CommodityManagementActivity.class );//商品管理
                } else {
                    bushiqie();
                    //startActivity( EnterprisesActivity.class );
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
                // if (userdata().getType() == 1) {
                startActivity( InvitationCodeActivity.class );
                //  } else {
                //startActivity( EnterprisesActivity.class );
                //  bushiqie();
                // }

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
                if (userdata().getType() == 1 && userdata().getIsReal() == 2) {
                    startActivity( MyTeamActivity.class );
                } else {
                    bushiqie();
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

                if (userdata().getType() == 1 && userdata().getIsReal() == 2) {
                    startActivity( IsellActivity.class );
                } else {
                    //startActivity( EnterprisesActivity.class );
                    bushiqie();
                }

                break;
            default:
        }
    }

    private void bushiqie() {
        new MessageDialog.Builder( getAttachActivity() )
                // 标题可以不用填写
                //.setTitle("我是标题")
                // 内容必须要填写
                .setMessage( "请您登录企业账号" )
                // 确定按钮文本
                .setConfirm( "确定" )
                // 设置 null 表示不显示取消按钮
                .setCancel( "取消" )

                // 设置点击按钮后不关闭对话框
                //.setAutoDismiss(false)
                .setListener( new MessageDialog.OnListener() {

                    @Override
                    public void onConfirm(Dialog dialog) {
                        // 退出登录
                        startActivity( TheloginIdActivity.class );
                        // 进行内存优化，销毁掉所有的界面
                        ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                        // toast("确定了");
                        //presenetr.getPostTokenRequest( getActivity(), ServerUrl.deleteAddress, Constant.deleteAddress );

                        dialog.dismiss();
                    }

                    @Override
                    public void onCancel(Dialog dialog) {
                        //  toast("取消了");
                        dialog.dismiss();
                    }
                } )
                .show();
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
