package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MyOrder implements Parcelable {


    /**
     * address : 天津市天津市南开区55555444444
     * pay_money : 10
     * shop_user_id : 899079
     * pay_time : 2020-03-30 12:12:12
     * shopList : [{"shop_money":10,"ctime":"2020-03-30 12:12:12","shop_img":"http://129.28.62.84/seal/2.png","sku_name":"10g","shopid":"1","shop_name":"商品名称商品名称商品名称商品名称","shop_num":1}]
     * ordercode : 222222
     * phone : 15535958281
     * name : 租可伶可俐
     * ctime : 2020-03-30 12:12:12
     * total_shop_money : 10
     * id : 4
     * status : 2
     * total_shop_num : 1
     */

    private String address;
    private double pay_money;
    private String shop_user_id;
    private String pay_time;
    private String ordercode;
    private String phone;
    private String name;
    private String ctime;
    private double total_shop_money;
    private String id;
    private int status;
    private int total_shop_num;
    private List<ShopListBean> shopList;

    public static MyOrder objectFromData(String str) {

        return new Gson().fromJson( str, MyOrder.class );
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPay_money() {
        return pay_money;
    }

    public void setPay_money(double pay_money) {
        this.pay_money = pay_money;
    }

    public String getShop_user_id() {
        return shop_user_id;
    }

    public void setShop_user_id(String shop_user_id) {
        this.shop_user_id = shop_user_id;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public double getTotal_shop_money() {
        return total_shop_money;
    }

    public void setTotal_shop_money(int total_shop_money) {
        this.total_shop_money = total_shop_money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal_shop_num() {
        return total_shop_num;
    }

    public void setTotal_shop_num(int total_shop_num) {
        this.total_shop_num = total_shop_num;
    }

    public List<ShopListBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopListBean> shopList) {
        this.shopList = shopList;
    }

    public static class ShopListBean {
        /**
         * shop_money : 10
         * ctime : 2020-03-30 12:12:12
         * shop_img : http://129.28.62.84/seal/2.png
         * sku_name : 10g
         * shopid : 1
         * shop_name : 商品名称商品名称商品名称商品名称
         * shop_num : 1
         */

        private int shop_money;
        private String ctime;
        private String shop_img;
        private String sku_name;
        private String shopid;
        private String shop_name;
        private int shop_num;

        public static ShopListBean objectFromData(String str) {

            return new Gson().fromJson( str, ShopListBean.class );
        }

        public int getShop_money() {
            return shop_money;
        }

        public void setShop_money(int shop_money) {
            this.shop_money = shop_money;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getShop_img() {
            return shop_img;
        }

        public void setShop_img(String shop_img) {
            this.shop_img = shop_img;
        }

        public String getSku_name() {
            return sku_name;
        }

        public void setSku_name(String sku_name) {
            this.sku_name = sku_name;
        }

        public String getShopid() {
            return shopid;
        }

        public void setShopid(String shopid) {
            this.shopid = shopid;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public int getShop_num() {
            return shop_num;
        }

        public void setShop_num(int shop_num) {
            this.shop_num = shop_num;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( this.address );
        dest.writeDouble( this.pay_money );
        dest.writeString( this.shop_user_id );
        dest.writeString( this.pay_time );
        dest.writeString( this.ordercode );
        dest.writeString( this.phone );
        dest.writeString( this.name );
        dest.writeString( this.ctime );
        dest.writeDouble( this.total_shop_money );
        dest.writeString( this.id );
        dest.writeInt( this.status );
        dest.writeInt( this.total_shop_num );
        dest.writeList( this.shopList );
    }

    public MyOrder() {
    }

    protected MyOrder(Parcel in) {
        this.address = in.readString();
        this.pay_money = in.readDouble();
        this.shop_user_id = in.readString();
        this.pay_time = in.readString();
        this.ordercode = in.readString();
        this.phone = in.readString();
        this.name = in.readString();
        this.ctime = in.readString();
        this.total_shop_money = in.readDouble();
        this.id = in.readString();
        this.status = in.readInt();
        this.total_shop_num = in.readInt();
        this.shopList = new ArrayList<ShopListBean>();
        in.readList( this.shopList, ShopListBean.class.getClassLoader() );
    }

    public static final Parcelable.Creator<MyOrder> CREATOR = new Parcelable.Creator<MyOrder>() {
        @Override
        public MyOrder createFromParcel(Parcel source) {
            return new MyOrder( source );
        }

        @Override
        public MyOrder[] newArray(int size) {
            return new MyOrder[size];
        }
    };
}
