package com.cn.android.ui.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.cn.android.R;
import com.cn.android.bean.DetailsOfMarketingDivision;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.dialog.QRcoDialog;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 营销师详情
 */
public class DetailsOfMarketingDivisionActivity extends MyActivity implements PublicInterfaceView {
    @BindView(R.id.tv01)
    TextView tv01;
    @BindView(R.id.iv_01)
    ImageView iv01;
    @BindView(R.id.iv_02)
    ImageView iv02;
    @BindView(R.id.tv_02)
    TextView tv02;
    @BindView(R.id.tv03)
    TextView tv03;
    @BindView(R.id.tv04)
    TextView tv04;
    @BindView(R.id.tv05)
    TextView tv05;
    PublicInterfaceePresenetr presenetr;
    @BindView(R.id.tv_job)
    TextView tvJob;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_label)
    TextView tvLabel;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_details_of_marketing_division);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_of_marketing_division;
    }

    private String id;

    @Override
    protected void initView() {
        presenetr = new PublicInterfaceePresenetr( this );
        id = getIntent().getStringExtra( "id" );


    }

    @Override
    protected void initData() {
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectMarketingUserById, Constant.selectMarketingUserById );
    }


    @OnClick(R.id.iv_02)
    public void onViewClicked() {
        new QRcoDialog.Builder( getActivity(), Gravity.TOP, "扫一扫二维码，加微信" ).show();
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "id", id );

        return paramsMap;
    }

    DetailsOfMarketingDivision detailsOfMarketingDivision;

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        if (!data.equals( "null" )) {
            detailsOfMarketingDivision = GsonUtils.getPerson( data, DetailsOfMarketingDivision.class );
            tv01.setText( detailsOfMarketingDivision.getName() );
            if (detailsOfMarketingDivision.getSex().equals( "女" )) {
                iv01.setBackground( getResources().getDrawable( R.mipmap.test17 ) );
            } else {
                iv01.setBackground( getResources().getDrawable( R.mipmap.test16 ) );
            }
            tvJob.setText( detailsOfMarketingDivision.getJob() );
            tvAge.setText( detailsOfMarketingDivision.getAge() + "年" );
            tvLabel.setText( detailsOfMarketingDivision.getLabel() );




        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }


}
