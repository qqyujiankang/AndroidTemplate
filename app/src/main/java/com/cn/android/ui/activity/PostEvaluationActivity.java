package com.cn.android.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.MyOrder;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.hjq.bar.TitleBar;
import com.hjq.image.ImageLoader;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 *发布评价n
 */
public class PostEvaluationActivity extends MyActivity implements PublicInterfaceView {
    @BindView(R.id.t_test_title)
    TitleBar tTestTitle;
    @BindView(R.id.iv_01)
    ImageView iv01;
    @BindView(R.id.btn_bind_commit)
    Button btnBindCommit;
    @BindView(R.id.tv_time_title)
    TextView tvTimeTitle;
    @BindView(R.id.tv_progress)
    TextView tvProgress;
    @BindView(R.id.et_content)
    EditText etContent;
    private PublicInterfaceePresenetr presenetr;
    SelectNewShop selectNewShop;
    private MyOrder myOrder;
    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//    }
    String shopid;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_post_evaluation;
    }

    @Override
    protected void initView() {

        presenetr = new PublicInterfaceePresenetr( this );


        selectNewShop = getIntent().getParcelableExtra( "selectNewShop" );
        myOrder = getIntent().getParcelableExtra( "myOrder" );
        if (selectNewShop != null) {
            tvProgress.setText( getString( R.string.test01 ) + selectNewShop.getVipPrice() );
            tvTimeTitle.setText( selectNewShop.getShopName() );
            ImageLoader.with( getActivity() ).load( selectNewShop.getShopImg() ).into( iv01 );
            shopid = selectNewShop.getId();
        } else if (myOrder != null) {
            tvProgress.setText( getString( R.string.test01 ) + myOrder.getShopList().get( 0 ).getShop_money() );
            tvTimeTitle.setText( myOrder.getShopList().get( 0 ).getShop_name() );
            ImageLoader.with( getActivity() ).load( myOrder.getShopList().get( 0 ).getShop_img() ).into( iv01 );
            shopid = myOrder.getShopList().get( 0 ).getShopid();
        }
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

    @OnClick(R.id.btn_bind_commit)
    public void onViewClicked() {
        if (etContent.getText().toString().trim().equals( "" )) {
            toast( "请填写评价内容" );
            return;
        }
        showLoading();
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.addShopEva, Constant.addShopEva );
        //finish();
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "userid", userdata().getId() );

        paramsMap.put( "shopid", shopid );
        paramsMap.put( "content", etContent.getText().toString().trim() );

        return paramsMap;
    }

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        showComplete();
        finish();
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }
}
