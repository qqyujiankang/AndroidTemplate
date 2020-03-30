package com.cn.android.ui.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cn.android.R;
import com.cn.android.bean.Commodity;
import com.cn.android.common.MyActivity;
import com.cn.android.ui.adapter.MyOrderAdapter;
import com.cn.android.ui.adapter.Myiseelladapter;
import com.cn.android.ui.dialog.QRcoDialog;
import com.cn.android.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我卖出的
 */
public class IsellActivity extends MyActivity {


    @BindView(R.id.rbt_obligation)
    RadioButton rbtObligation;
    @BindView(R.id.rbt_To_send_the_goods)
    RadioButton rbtToSendTheGoods;
    @BindView(R.id.rbt_off_the_stocks)
    RadioButton rbtOffTheStocks;
    @BindView(R.id.btn_remain_to_be_evaluated)
    RadioButton btnRemainToBeEvaluated;
    Myiseelladapter adapter;
    @BindView(R.id.rv)
    RecyclerView rv;
    List<Commodity.DataBean> dataBeans = new ArrayList<>();
    Commodity.DataBean dataBean = new Commodity.DataBean();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_isell;
    }

    @Override
    protected void initView() {

        rv.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        rv.addItemDecoration( new SpaceItemDecoration( 10 ) );
        adapter = new Myiseelladapter( getActivity() );
        rv.setAdapter( adapter );
        myOrder( 0 );

    }

    @Override
    protected void initData() {


    }

    private void myOrder(int order) {
        if (order == 0) {
            dataBeans.add( new Commodity.DataBean( "", "", "", "", 1 ) );
            dataBeans.add( new Commodity.DataBean( "", "", "", "", 2 ) );
            dataBeans.add( new Commodity.DataBean( "", "", "", "", 3 ) );
            adapter.setNewData( dataBeans );
            adapter.notifyDataSetChanged();
        } else if (order == 1) {
            dataBeans.add( new Commodity.DataBean( "", "", "", "", 1 ) );
            adapter.setNewData( dataBeans );
            adapter.notifyDataSetChanged();
        } else if (order == 2) {

            dataBeans.add( new Commodity.DataBean( "", "", "", "", 2 ) );
            adapter.setNewData( dataBeans );
            adapter.notifyDataSetChanged();
        } else if (order == 3) {
            dataBeans.add( new Commodity.DataBean( "", "", "", "", 3 ) );
            adapter.setNewData( dataBeans );
            adapter.notifyDataSetChanged();
        }


        adapter.setOnItemChildClickListener( new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                dataBean = (Commodity.DataBean) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.btn_01:
                        if (dataBean.getDrawable() == 2) {
                            finish();
                        } else if (dataBean.getDrawable() == 3) {
                            startActivity( ServiceActivity.class );
                        }
                        break;
                    case R.id.btn_02:
                        if (dataBean.getDrawable() == 2) {
                            startActivity( ServiceActivity.class );
                        } else if (dataBean.getDrawable() == 3) {
                            startActivity( CheckTheLogisticsActivity.class );
                        }
                        break;
                }


            }
        } );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }

    @OnClick({R.id.rbt_obligation, R.id.rbt_To_send_the_goods, R.id.rbt_off_the_stocks, R.id.btn_remain_to_be_evaluated})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbt_obligation:
                dataBeans.clear();
                myOrder( 0 );
                break;
            case R.id.rbt_To_send_the_goods:
                dataBeans.clear();
                myOrder( 1 );
                break;
            case R.id.rbt_off_the_stocks:
                dataBeans.clear();
                myOrder( 2 );
                break;
            case R.id.btn_remain_to_be_evaluated:
                dataBeans.clear();
                myOrder( 3 );
                break;
        }
    }
}
