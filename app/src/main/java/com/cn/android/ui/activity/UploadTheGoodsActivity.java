package com.cn.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.SelectNewShop;
import com.cn.android.bean.ShopGuiGeBean;
import com.cn.android.bean.UploadTheGoods;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.FileOperationPresenetr;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.FileOperationView;
import com.cn.android.presenter.view.PublicInterfaceView;
import com.cn.android.ui.adapter.CommercialSpecificationAdapter;
import com.cn.android.ui.adapter.MorepicturesAdapter;
import com.cn.android.utils.DataUtils;
import com.cn.android.utils.L;
import com.cn.android.utils.TimeUtils;
import com.cn.android.widget.SpaceItemDecoration;
import com.google.gson.Gson;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.image.ImageLoader;
import com.hjq.widget.view.SwitchButton;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Upload the goods 上传商品
 */
public class UploadTheGoodsActivity extends MyActivity implements BaseQuickAdapter.OnItemChildClickListener, OnTitleBarListener, FileOperationView, PublicInterfaceView {

    CommercialSpecificationAdapter commercialSpecificationAdapter;
    List<ShopGuiGeBean> strings = new ArrayList<>();
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.iv_particulars)
    ImageView ivParticulars;
    @BindView(R.id.sb_test_switch)
    SwitchButton sbTestSwitch;
    @BindView(R.id.ll_01)
    LinearLayout ll01;
    @BindView(R.id.ll02)
    LinearLayout ll02;

    @BindView(R.id.relativeLayout)
    RecyclerView relativeLayout;

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tlte)
    TitleBar tlte;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.vipmoney)
    EditText vipmoney;
    @BindView(R.id.money)
    EditText money;
    @BindView(R.id.swap)
    NestedScrollView swap;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.et_ser_mun)
    EditText etSerMun;
    private ArrayList<String> morepicturesArrayList = new ArrayList<>();
    private ArrayList<String> morepicturesArrayList1 = new ArrayList<>();
    private int is_send = 0;
    SelectNewShop selectNewShop;
    MorepicturesAdapter morepicturesAdapter;
    PublicInterfaceePresenetr presenetr;
    FileOperationPresenetr fileOperation;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload_the_goods;
    }

    @Override
    protected void initView() {
        selectNewShop = getIntent().getParcelableExtra( "selectNewShop" );
        fileOperation = new FileOperationPresenetr( this );
        presenetr = new PublicInterfaceePresenetr( this );
        relativeLayout.setLayoutManager( new GridLayoutManager( getActivity(), 3 ) );
        morepicturesAdapter = new MorepicturesAdapter( getActivity() );
        relativeLayout.setAdapter( morepicturesAdapter );
        rv.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        rv.addItemDecoration( new SpaceItemDecoration( 1 ) );
        commercialSpecificationAdapter = new CommercialSpecificationAdapter( getActivity(), strings );
        rv.setAdapter( commercialSpecificationAdapter );
        commercialSpecificationAdapter.setNewData( strings );
        commercialSpecificationAdapter.setOnItemChildClickListener( this );
        morepicturesAdapter.setOnItemChildClickListener( this );


    }

    private String url;

    @Override
    protected void initData() {

        if (selectNewShop != null) {
            presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectShopByID, Constant.selectShopByID );
        } else {
            strings.add( new ShopGuiGeBean( "", true ) );
            morepicturesArrayList.add( "" );
            morepicturesAdapter.setNewData( morepicturesArrayList );

        }
    }


    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (adapter instanceof CommercialSpecificationAdapter) {
            switch (view.getId()) {
                case R.id.iv_add:
                    L.e( "123", "strings = " + new Gson().toJson( strings ) );
                    CheckBox checkBox = view.findViewById( R.id.iv_add );
                    if (!checkBox.isChecked()) {
                        strings.add( 0, new ShopGuiGeBean( "", false ) );
                    } else if (strings.size() != 1) {
                        strings.remove( position );
                    }
                    commercialSpecificationAdapter.replaceData( strings );
                    break;

            }
        } else if (adapter instanceof MorepicturesAdapter) {
            switch (view.getId()) {
                case R.id.iv_particulars:
                    if (position == morepicturesArrayList.size() - 1) {
                        int page = 6 - morepicturesArrayList.size();
                        PhotoActivity.start( this, page, new PhotoActivity.OnPhotoSelectListener() {
                            @Override
                            public void onSelect(List<String> data) {
                                morepicturesArrayList.addAll( 0, data );
                                if (morepicturesArrayList.size() == 6) {
                                    morepicturesArrayList.remove( 5 );
                                }
                                morepicturesAdapter.replaceData( morepicturesArrayList );
                                showLoading();
                                for (String item : morepicturesArrayList) {
                                    saveShopByUserid( item );
                                }
                            }

                            @Override
                            public void onCancel() {

                            }
                        } );
                    } else {
                        ImageActivity.start( UploadTheGoodsActivity.this, morepicturesArrayList, position );
                    }
                    break;
                case R.id.iv_cha:
                    morepicturesArrayList.remove( position );
                    morepicturesArrayList1.remove( position );
                    morepicturesAdapter.replaceData( morepicturesArrayList );

                    break;
            }


        }
    }

    @OnClick({R.id.iv_particulars, R.id.ll_01, R.id.ll02, R.id.rl_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_search:
                Intent intent = new Intent( getActivity(), CommodityClassificationActivity.class );
                startActivityForResult( intent, 2 );
                break;

            case R.id.iv_particulars:
                ivview( ivParticulars );

                break;
            case R.id.ll_01:
                is_send = 2;
                shangchuangshangpin();


                break;


            case R.id.ll02:
                is_send = 1;
                shangchuangshangpin();
                break;
        }

    }

    private void shangchuangshangpin() {
        if (etSerMun.getText().toString().equals( "" )) {
            toast( "请输入成交量" );
        }
        if (etName.getText().toString().equals( "" )) {
            toast( "请输入宝贝名称" );
        }
        if (morepicturesArrayList.get( 0 ).equals( "" )) {
            toast( "请选择图片" );
            return;

        }
        if (strings.get( 0 ).getGuiGe().equals( "" )) {
            toast( "请填写规格" );
            return;

        }
        if (strings.get( 0 ).getprice().equals( "" )) {
            toast( "请填写价格" );
            return;

        }
        if (strings.get( 0 ).getGuiGe().equals( "" )) {
            toast( "请填写商品规格" );
        }
        if (vipmoney.getText().toString().equals( "" )) {
            toast( "请填写VIP价格" );
            return;
        }
        if (money.getText().toString().equals( "" )) {
            toast( "请填写市场指导价" );
            return;
        }
        if (detilas == null) {
            toast( "请选择详情图" );
            return;
        }
        showLoading();
        if (selectNewShop == null) {
            url = ServerUrl.saveShopByUserid;
        } else {
            url = ServerUrl.updateShopByUserid;
        }
        presenetr.getPostTokenRequest( getActivity(), url, Constant.saveShopByUserid );

    }


    /**
     * 上传图片多张
     *
     * @param url
     */
    private void saveShopByUserid(String url) {
        showLoading();
        fileOperation.uploadSingleFileRequest( getActivity(), "file",
                new File( url ), ServerUrl.upload, Constant.updateHeadImg );
    }

    private void ivview(ImageView ivParticulars) {
        PhotoActivity.start( this, 5, new PhotoActivity.OnPhotoSelectListener() {
            @Override
            public void onSelect(List<String> data) {
                showLoading();
                ImageLoader.with( getActivity() )
                        .load( data.get( 0 ) )
                        .into( ivParticulars );
                fileOperation.uploadSingleFileRequest( getActivity(), "file",
                        new File( data.get( 0 ) ), ServerUrl.upload, Constant.updateHeadImg01 );
            }

            @Override
            public void onCancel() {

            }
        } );
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick( v );
        finish();
    }

    private String img_urls, detilas;

    /**
     * @return
     */
    public String getimg() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < morepicturesArrayList1.size(); i++) {
            if (morepicturesArrayList1.size() != 0) {
                if (i == morepicturesArrayList1.size() - 1) {
                    sb.append( morepicturesArrayList1.get( i ) );
                } else {
                    sb.append( morepicturesArrayList1.get( i ) + "," );
                }
            }
        }
        return sb.toString();
    }


    @Override
    public void FileOperationSuccess(Object data, int tag) {
        showComplete();
        switch (tag) {

            case Constant.updateHeadImg:

                Log.e( "https", "=========" + data.toString() );
                img_urls = data.toString();
                morepicturesArrayList1.add( img_urls );
                break;
            case Constant.updateHeadImg01:
                detilas = data.toString();
                break;
        }

    }

    @Override
    public void FileOperationProgress(float progress, int tag) {

    }

    @Override
    public void FileOperationError(String error, int tag) {
        showComplete();
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> map = new HashMap<>();
        switch (tag) {
            case Constant.saveShopByUserid:
                if (selectNewShop != null) {
                    map.put( "shopid", selectNewShop.getId() );
                }
                map.put( "shop_name", etName.getText().toString() );
                map.put( "userid", userdata().getId() );
                map.put( "sell_price", money.getText().toString().trim() );
                map.put( "vip_price", vipmoney.getText().toString().trim() );
                map.put( "sku", new Gson().toJson( strings ) );
                map.put( "is_send", is_send );
                map.put( "detilas", detilas );
                if (sbTestSwitch.isChecked()) {
                    map.put( "is_burst", 1 );
                } else {
                    map.put( "is_burst", 2 );
                }
                map.put( "three_type_id", three_type_id );
                map.put( "first_type_id", pid );
                map.put( "seconde_type_id", seconde_type_id );


                map.put( "shop_img", morepicturesArrayList1.get( 0 ) );

                map.put( "img_urls", getimg() );
                map.put( "sale_num", etSerMun.getText().toString().trim() );


                return map;
            case Constant.selectShopByID:
                map.put( "shopid", selectNewShop.getId() );
                return map;
        }

        return null;

    }

    UploadTheGoods uploadTheGoods;

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {

        showComplete();
        switch (tag) {
            case Constant.selectShopByID:
                uploadTheGoods = GsonUtils.getPerson( data, UploadTheGoods.class );

                tv01.setText( uploadTheGoods.getShopType() );
                etName.setText( uploadTheGoods.getShopName() );
                //morepicturesArrayList = (ArrayList<String>) TimeUtils.getStiringlist( uploadTheGoods.getImgUrls() );
                morepicturesArrayList.addAll( TimeUtils.getStiringlist( uploadTheGoods.getImgUrls() ) );
                morepicturesArrayList1.addAll( TimeUtils.getStiringlist( uploadTheGoods.getImgUrls() ) );
                if (morepicturesArrayList.size() != 5) {
                    morepicturesArrayList.add( "" );
                }

                morepicturesAdapter.replaceData( morepicturesArrayList );
                //ivParticulars
                vipmoney.setText( DataUtils.getMoney( uploadTheGoods.getVipPrice() ) );
                money.setText( DataUtils.getMoney( uploadTheGoods.getRealPrice() ) );
                if (uploadTheGoods.getIsBurst() == 1) {
                    sbTestSwitch.setChecked( true );
                } else {
                    sbTestSwitch.setChecked( false );
                }
                if (uploadTheGoods.getSkuList().size() != 0) {
                    for (int i = 0; i < uploadTheGoods.getSkuList().size(); i++) {
                        ShopGuiGeBean bean = new ShopGuiGeBean();
                        if (uploadTheGoods.getSkuList().size() == 1) {
                            bean.setClick( true );
                        }
                        if (uploadTheGoods.getSkuList().size() - 1 == i) {

                            bean.setClick( true );
                        } else {
                            bean.setClick( false );
                        }
                        bean.setprice( DataUtils.getMoney( uploadTheGoods.getSkuList().get( i ).getSkuPrice() ) );
                        bean.setGuiGe( uploadTheGoods.getSkuList().get( i ).getSkuName() );
                        strings.add( bean );
                    }
                } else {
                    strings.add( new ShopGuiGeBean( "", true ) );
                }
                commercialSpecificationAdapter.replaceData( strings );
                detilas = uploadTheGoods.getDetilas();
                ImageLoader.with( getActivity() ).load( detilas ).into( ivParticulars );
                seconde_type_id = uploadTheGoods.getSecondeTypeId();
                three_type_id = uploadTheGoods.getThreeTypeId();
                pid = uploadTheGoods.getFirstTypeId();


                break;
            case Constant.saveShopByUserid:
                if (TextUtils.isEmpty( data )) {

                } else {
                    finish();
                }
                break;
        }
    }

    @Override
    public void onPublicInterfaceError(String error, int tag) {
        showComplete();
    }

    private String pid, seconde_type_id, three_type_id;
    private String pidname, seconde_type_idname, three_type_idname;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == 2 && resultCode == 22) {
            pid = data.getStringExtra( "first_type_id" );

            pidname = data.getStringExtra( "pidname" );
            seconde_type_id = data.getStringExtra( "seconde_type_id" );
            seconde_type_idname = data.getStringExtra( "seconde_type_idname" );
            three_type_id = data.getStringExtra( "three_type_id" );
            three_type_idname = data.getStringExtra( "three_type_idname" );
            tv01.setText( pidname + "-" + seconde_type_idname + "-" + three_type_idname );

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }
}
