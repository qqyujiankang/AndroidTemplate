package com.cn.android.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.base.BaseAdapter;
import com.cn.android.base.BaseViewHolder;
import com.cn.android.bean.Commodity;

import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class ClassAdapter extends BaseAdapter<Commodity.DataBean, ClassAdapter.CoinTypeViewHolder> {


    public ClassAdapter(Context context, List<Commodity.DataBean> list) {
        super(context, list);
    }

    @Override
    protected CoinTypeViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.adapter_class, parent, false);
        return new CoinTypeViewHolder(view);
    }

    @Override
    protected void onItemReset(CoinTypeViewHolder holder) {

    }

    @Override
    protected void onItemSelect(CoinTypeViewHolder holder) {
      //  holder.tvClassName.setBackgroundColor(getContext().getResources().getColor(R.color.white));
    }

    @Override
    protected void onItemSelect(CoinTypeViewHolder holder, int position) {
        super.onItemSelect(holder, position);
       // holder.tvClassName.setBackgroundColor(getContext().getResources().getColor(R.color.white));
    }

    @Override
    protected void viewHolderBind(CoinTypeViewHolder holder, int position) {
        holder.tvClassName.setText(list.get(position).getName());
    }

    class CoinTypeViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_class_name)
        TextView tvClassName;

        public CoinTypeViewHolder(View view) {
            super(view);
        }
    }

}
