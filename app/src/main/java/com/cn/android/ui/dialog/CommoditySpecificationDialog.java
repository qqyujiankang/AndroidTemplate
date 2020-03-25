package com.cn.android.ui.dialog;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.common.MyDialogFragment;
import com.cn.android.ui.activity.ConfirmAnOrderActivity;
import com.cn.android.ui.activity.StoreNameDetailsActivity;
import com.hjq.dialog.base.BaseDialog;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商品详情规格
 */
public class CommoditySpecificationDialog {


    public static final class Builder
            extends MyDialogFragment.Builder<CopyDialog.Builder> {

        @BindView(R.id.iv_01)
        ImageView iv01;
        @BindView(R.id.tv_02)
        TextView tv02;
        @BindView(R.id.rv_01)
        RecyclerView rv01;
        @BindView(R.id.tv_03)
        TextView tv03;
        @BindView(R.id.rv02)
        RecyclerView rv02;
        @BindView(R.id.tv_sua)
        TextView tvSua;
        @BindView(R.id.goods_add)
        ImageButton goodsAdd;
        @BindView(R.id.goods_jian)
        ImageButton goodsJian;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv01)
        TextView tv01;
        @BindView(R.id.tv_04)
        TextView tv04;
        private FragmentActivity fragmentActivity;

        public Builder(FragmentActivity activity) {
            super(activity);
            this.fragmentActivity = activity;

            setContentView(R.layout.dialog_commodity_specification);
            setAnimStyle(BaseDialog.AnimStyle.BOTTOM);
            setGravity(Gravity.BOTTOM);
        }

        @OnClick({R.id.goods_add, R.id.goods_jian, R.id.tv_04, R.id.tv01})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.tv01:
                    dismiss();
                    break;
                case R.id.tv_04:
                    Intent intent = new Intent(getActivity(), ConfirmAnOrderActivity.class);
                    fragmentActivity.startActivity(intent);
                    break;
                case R.id.goods_add:

                    sub();
                    break;
                case R.id.goods_jian:

                    add();
                    break;
            }
        }

        private void sub() {
            //控件初始化的时候已经给了  1  获取
            String sub = tv.getText().toString();
            //String类型转换成Int类型
            int parseInt = Integer.parseInt(sub);
            //判断
            if (parseInt > 1) {
                parseInt--;
                tv.setText(String.valueOf(parseInt));
                // setCurentCount(parseInt);
            } else {
                // ToastUtil.showToast("不能再少了");
            }
        }

        private void add() {
            //控件初始化的时候已经给了  1 获取
            String add = tv.getText().toString();
            //String类型转换成Int类型
            int parseInt = Integer.parseInt(add);
            parseInt++;
            tv.setText(String.valueOf(parseInt));
        }

    }
}