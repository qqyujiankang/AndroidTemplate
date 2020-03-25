package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.EvaluateAdapter;
import com.cn.android.ui.dialog.CommoditySpecificationDialog;
import com.cn.android.ui.dialog.SelectShippingAddressDialog;
import com.cn.android.ui.dialog.ShareDialog;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.widget.layout.SettingBar;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品详情
 * commodity details
 */
public class CommodityDetailsActivity extends MyActivity implements OnTitleBarListener, SelectShippingAddressDialog.onaddressconfidence {


    @BindView(R.id.ttb)
    TitleBar ttb;
    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.tv_02)
    TextView tv02;
    @BindView(R.id.sb_account_management)
    SettingBar sbAccountManagement;
    @BindView(R.id.sb_add)
    SettingBar sbAdd;
    @BindView(R.id.tv_07)
    TextView tv07;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_08)
    TextView tv08;
    @BindView(R.id.Rl_01)
    RelativeLayout Rl01;
    @BindView(R.id.sb_add0)
    SettingBar sbAdd0;
    @BindView(R.id.rv01)
    RecyclerView rv01;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    CheckBox tv3;
    @BindView(R.id.btn_01)
    Button btn01;
    @BindView(R.id.btn_02)
    Button btn02;
    EvaluateAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commodity_details;
    }

    @Override
    protected void initView() {
        rv01.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //rv01.addItemDecoration(new SpaceItemDecoration(30));

        adapter = new EvaluateAdapter(getActivity());
        rv01.setAdapter(adapter);
        ttb.setOnTitleBarListener(this);

    }

    @Override
    protected void initData() {
        List<Commodity.DataBean> dataBeans = new ArrayList<>();
        dataBeans.add(new Commodity.DataBean("", "", "", "", 0));
        dataBeans.add(new Commodity.DataBean("", "", "", "", 0));
        dataBeans.add(new Commodity.DataBean("", "", "", "", 0));
        dataBeans.add(new Commodity.DataBean("", "", "", "", 0));
        adapter.setNewData(dataBeans);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_1, R.id.tv_2, R.id.tv_3, R.id.btn_01, R.id.btn_02, R.id.sb_account_management, R.id.sb_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_add:
                new SelectShippingAddressDialog.Builder(getActivity(), this).show();
                break;
            case R.id.sb_account_management:
                new CommoditySpecificationDialog.Builder(getActivity()).show();
                break;

            case R.id.tv_1:
                startActivity(StoreNameDetailsActivity.class);

//                Intent intent = new Intent(getActivity(), HomeActivity.class);
//                intent.putExtra("name", 1);
//                startActivity(intent);
                break;
            case R.id.tv_2:
                startActivity(ServiceActivity.class);
                break;
            case R.id.tv_3:

                break;
            case R.id.btn_01:
                new CommoditySpecificationDialog.Builder(getActivity()).show();
                break;
            case R.id.btn_02:
                startActivity(ConfirmAnOrderActivity.class);
                break;
        }
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
        new ShareDialog.Builder(getActivity()).show();
    }

    @Override
    public void getaddressconfidence(Commodity.DataBean dataBean) {
        log(dataBean);
    }
}
