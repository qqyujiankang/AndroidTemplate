package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CommodityManagement implements Parcelable {

    /**
     * old_total_money : 30
     * shopList : [{"ordercode":"869208062746","shop_total_money":30,"shop_num":3,"shop_name":"商品名称商品名称商品名称商品名称","shop_img":"http://129.28.62.84/seal/2.png","shop_money":10,"sku":"10g"}]
     */

    private double old_total_money;
    private List<ShopListBean> shopList;


    public static CommodityManagement objectFromData(String str) {

        return new Gson().fromJson( str, CommodityManagement.class );
    }

    public double getOld_total_money() {
        return old_total_money;
    }

    public void setOld_total_money(int old_total_money) {
        this.old_total_money = old_total_money;
    }

    public List<ShopListBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopListBean> shopList) {
        this.shopList = shopList;
    }

    public static class ShopListBean implements Parcelable {

        /**
         * ordercode : 869208062746
         * shop_total_money : 30
         * shop_num : 3
         * shop_name : 商品名称商品名称商品名称商品名称
         * shop_img : http://129.28.62.84/seal/2.png
         * shop_money : 10.0
         * sku : 10g
         */

        private String ordercode;
        private int shop_total_money;
        private int shop_num;
        private String shop_name;
        private String shop_img;
        private double shop_money;
        private String sku;

        public static ShopListBean objectFromData(String str) {

            return new Gson().fromJson( str, ShopListBean.class );
        }

        public String getOrdercode() {
            return ordercode;
        }

        public void setOrdercode(String ordercode) {
            this.ordercode = ordercode;
        }

        public int getShop_total_money() {
            return shop_total_money;
        }

        public void setShop_total_money(int shop_total_money) {
            this.shop_total_money = shop_total_money;
        }

        public int getShop_num() {
            return shop_num;
        }

        public void setShop_num(int shop_num) {
            this.shop_num = shop_num;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getShop_img() {
            return shop_img;
        }

        public void setShop_img(String shop_img) {
            this.shop_img = shop_img;
        }

        public double getShop_money() {
            return shop_money;
        }

        public void setShop_money(double shop_money) {
            this.shop_money = shop_money;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public ShopListBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString( this.ordercode );
            dest.writeInt( this.shop_total_money );
            dest.writeInt( this.shop_num );
            dest.writeString( this.shop_name );
            dest.writeString( this.shop_img );
            dest.writeDouble( this.shop_money );
            dest.writeString( this.sku );
        }

        protected ShopListBean(Parcel in) {
            this.ordercode = in.readString();
            this.shop_total_money = in.readInt();
            this.shop_num = in.readInt();
            this.shop_name = in.readString();
            this.shop_img = in.readString();
            this.shop_money = in.readDouble();
            this.sku = in.readString();
        }

        public static final Parcelable.Creator<ShopListBean> CREATOR = new Parcelable.Creator<ShopListBean>() {
            @Override
            public ShopListBean createFromParcel(Parcel source) {
                return new ShopListBean( source );
            }

            @Override
            public ShopListBean[] newArray(int size) {
                return new ShopListBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble( this.old_total_money );
        dest.writeTypedList( this.shopList );
    }

    public CommodityManagement() {
    }

    protected CommodityManagement(Parcel in) {
        this.old_total_money = in.readDouble();
        this.shopList = in.createTypedArrayList( ShopListBean.CREATOR );
    }

    public static final Parcelable.Creator<CommodityManagement> CREATOR = new Parcelable.Creator<CommodityManagement>() {
        @Override
        public CommodityManagement createFromParcel(Parcel source) {
            return new CommodityManagement( source );
        }

        @Override
        public CommodityManagement[] newArray(int size) {
            return new CommodityManagement[size];
        }
    };
}
