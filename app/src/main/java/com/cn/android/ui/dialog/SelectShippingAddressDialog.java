package com.cn.android.ui.dialog;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyDialogFragment;
import com.cn.android.ui.activity.AddressDetailActivity;
import com.cn.android.ui.adapter.ShippingAddressAdatper;
import com.cn.android.widget.SpaceItemDecoration;
import com.hjq.dialog.base.BaseDialog;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商品详情选择其他地址
 */
public class SelectShippingAddressDialog {

    public static final class Builder
            extends MyDialogFragment.Builder<Builder> {

        @BindView(R.id.rv_01)
        RecyclerView rv01;
        @BindView(R.id.tv01)
        TextView tv01;
        ShippingAddressAdatper shippingAddressAdatper;
        GridLayoutManager gridLayoutManager;
        private FragmentActivity fragmentActivity;
        Commodity.DataBean dataBean = new Commodity.DataBean();

        public Builder(FragmentActivity activity, onaddressconfidence onaddressconfidence) {
            super(activity);
            this.fragmentActivity = activity;

            setContentView(R.layout.dialog_select_shipping_address);
            shippingAddressAdatper = new ShippingAddressAdatper(getActivity());
            rv01.addItemDecoration(new SpaceItemDecoration(10));
            gridLayoutManager = new GridLayoutManager(getActivity(), 1);
            //设置RecycleView显示的方向是水平还是垂直 GridLayout.HORIZONTAL水平  GridLayout.VERTICAL默认垂直
            //设置布局管理器， 参数gridLayoutManager对象
            rv01.setLayoutManager(gridLayoutManager);
            rv01.setAdapter(shippingAddressAdatper);
            List<Commodity.DataBean> dataBeans = new ArrayList<>();

            //shippingAddressAdatper.setNewData(dataBeans);
            shippingAddressAdatper.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    dataBean = (Commodity.DataBean) adapter.getData().get(position);
                    onaddressconfidence.getaddressconfidence(dataBean);
                    dismiss();
                }
            });
            setAnimStyle(BaseDialog.AnimStyle.BOTTOM);
            setGravity(Gravity.BOTTOM);
        }

        @OnClick(R.id.tv01)
        public void onViewClicked() {
            Intent intent = new Intent(getActivity(), AddressDetailActivity.class);
            fragmentActivity.startActivity(intent);

        }
    }

    public interface onaddressconfidence {
        void getaddressconfidence(Commodity.DataBean dataBean);
    }
}
