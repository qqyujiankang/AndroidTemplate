package com.cn.android.ui.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cn.android.R;
import com.cn.android.bean.BannerBean;
import com.cn.android.bean.Commodity;
import com.cn.android.bean.ShopGuiGeBean;
import com.cn.android.utils.L;

import java.util.ArrayList;
import java.util.List;

/**
 * 上传商品的规格
 */
public class CommercialSpecificationAdapter extends BaseQuickAdapter<ShopGuiGeBean, BaseViewHolder> {
    private Context context;
    private List<ShopGuiGeBean> list;

    public CommercialSpecificationAdapter(Context context,List<ShopGuiGeBean> list) {
        super(R.layout.adapter_commercial_specification);
        this.context = context;
        this.list = list;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopGuiGeBean item) {
        CheckBox checkBox = helper.getView(R.id.iv_add);
        checkBox.setChecked(item.isClick());
        EditText vipmoney=helper.getView(R.id.vipmoney);
        EditText money=helper.getView(R.id.money);
        EditText guige=helper.getView(R.id.guige);
        helper.setText(R.id.guige,list.get(helper.getLayoutPosition()).getGuiGe());
        helper.setText(R.id.vipmoney,list.get(helper.getLayoutPosition()).getVipMoney()==null?"":list.get(helper.getLayoutPosition()).getVipMoney());
        helper.setText(R.id.money,list.get(helper.getLayoutPosition()).getMoney()==null?"":list.get(helper.getLayoutPosition()).getMoney());
        helper.addOnClickListener(R.id.iv_add);
        vipmoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==0){
                    return;
                }
                if(s.toString().indexOf(".")!=-1){
                    return;
                }
                list.get(helper.getLayoutPosition()).setVipMoney(s.toString());
            }
        });
        money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==0){
                    return;
                }
                if(s.toString().indexOf(".")!=-1){
                    return;
                }
                list.get(helper.getLayoutPosition()).setMoney(s.toString());
            }
        });
        guige.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==0){
                    return;
                }
                list.get(helper.getLayoutPosition()).setGuiGe(s.toString());
            }
        });
    }


}
