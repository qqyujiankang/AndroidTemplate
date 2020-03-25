package com.cn.android.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.widget.AddressPickerLib.AddressPickerView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.cn.android.widget.AddressPickerLib.AddressPickerView.*;

/**
 * 所在地
 */
public class locationActivity extends MyActivity implements OnAddressPickerSureListener {


    @BindView(R.id.tv0)
    TextView tv0;
    @BindView(R.id.apvAddress)
    AddressPickerView apvAddress;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_location;
    }

    @Override
    protected void initView() {
        apvAddress.setOnAddressPickerSure(this);

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

    @Override
    public void onSureClick(String address, String provinceCode, String cityCode, String districtCode) {
        Log.i("exp", "address====" + address +
                "===address====" + provinceCode +
                "address====" + cityCode + "" +
                "address====" + districtCode);
        finish();
    }
}
