package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ShopBean implements Parcelable {

    /**
     * shopList : [{"sku_price":10,"shop_img":"http://129.28.62.84/seal/2.png","sku_name":"10g","id":"FC9143B9BA8135B80A233533734391C9","shop_name":"商品名称商品名称商品名称商品名称","shop_num":2}]
     * store_name : 玺购商城
     * shop_user_id : 1
     */

    private String store_name;
    private String shop_user_id;
    private List<ShopListBean> shopList;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public static ShopBean objectFromData(String str) {

        return new Gson().fromJson( str, ShopBean.class );
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getShop_user_id() {
        return shop_user_id;
    }

    public void setShop_user_id(String shop_user_id) {
        this.shop_user_id = shop_user_id;
    }

    public List<ShopListBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopListBean> shopList) {
        this.shopList = shopList;
    }

    public static class ShopListBean implements Parcelable {

        /**
         * sku_price : 10
         * shop_img : http://129.28.62.84/seal/2.png
         * sku_name : 10g
         * id : FC9143B9BA8135B80A233533734391C9
         * shop_name : 商品名称商品名称商品名称商品名称
         * shop_num : 2
         */

        private String sku_price;
        private String shop_img;
        private String sku_name;
        private String id;
        private String shop_name;
        private int shop_num;
        private boolean checked;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public static ShopListBean objectFromData(String str) {

            return new Gson().fromJson( str, ShopListBean.class );
        }

        public String getSku_price() {
            return sku_price;
        }

        public void setSku_price(String sku_price) {
            this.sku_price = sku_price;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public ShopListBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString( this.sku_price );
            dest.writeString( this.shop_img );
            dest.writeString( this.sku_name );
            dest.writeString( this.id );
            dest.writeString( this.shop_name );
            dest.writeInt( this.shop_num );
            dest.writeByte( this.checked ? (byte) 1 : (byte) 0 );
        }

        protected ShopListBean(Parcel in) {
            this.sku_price = in.readString();
            this.shop_img = in.readString();
            this.sku_name = in.readString();
            this.id = in.readString();
            this.shop_name = in.readString();
            this.shop_num = in.readInt();
            this.checked = in.readByte() != 0;
        }

        public static final Creator<ShopListBean> CREATOR = new Creator<ShopListBean>() {
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

    public ShopBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( this.store_name );
        dest.writeString( this.shop_user_id );
        dest.writeTypedList( this.shopList );
        dest.writeByte( this.checked ? (byte) 1 : (byte) 0 );
    }

    protected ShopBean(Parcel in) {
        this.store_name = in.readString();
        this.shop_user_id = in.readString();
        this.shopList = in.createTypedArrayList( ShopListBean.CREATOR );
        this.checked = in.readByte() != 0;
    }

    public static final Creator<ShopBean> CREATOR = new Creator<ShopBean>() {
        @Override
        public ShopBean createFromParcel(Parcel source) {
            return new ShopBean( source );
        }

        @Override
        public ShopBean[] newArray(int size) {
            return new ShopBean[size];
        }
    };
}
