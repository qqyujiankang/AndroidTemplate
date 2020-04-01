package com.cn.android.bean;

import com.google.gson.Gson;

import java.util.List;

public class MyOrder {

    /**
     * shopList : [{"shop_money":20,"ctime":"2020-03-30 12:12:12","shop_img":"http://129.28.62.84/seal/2.png","sku_name":"50g","shopid":"2","shop_name":"商品名称商品名称商品名称商品名称","shop_num":1}]
     * ordercode : 111111
     * ctime : 2020-03-30 12:12:12
     * total_shop_money : 20
     * id : 2
     * pay_money : 20
     * status : 1
     * total_shop_num : 1
     * shop_user_id : 2
     * pay_time : 2020-03-30 12:12:12
     */

    private String ordercode;
    private String ctime;
    private int total_shop_money;
    private String id;
    private int pay_money;
    private int status;
    private int total_shop_num;
    private String shop_user_id;
    private String pay_time;
    private List<ShopListBean> shopList;

    public static MyOrder objectFromData(String str) {

        return new Gson().fromJson( str, MyOrder.class );
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public int getTotal_shop_money() {
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

    public int getPay_money() {
        return pay_money;
    }

    public void setPay_money(int pay_money) {
        this.pay_money = pay_money;
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

    public List<ShopListBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopListBean> shopList) {
        this.shopList = shopList;
    }

    public static class ShopListBean {
        /**
         * shop_money : 20
         * ctime : 2020-03-30 12:12:12
         * shop_img : http://129.28.62.84/seal/2.png
         * sku_name : 50g
         * shopid : 2
         * shop_name : 商品名称商品名称商品名称商品名称
         * shop_num : 1
         */

        private String shop_money;
        private String ctime;
        private String shop_img;
        private String sku_name;
        private String shopid;
        private String shop_name;
        private int shop_num;

        public static ShopListBean objectFromData(String str) {

            return new Gson().fromJson( str, ShopListBean.class );
        }

        public String getShop_money() {
            return shop_money;
        }

        public void setShop_money(String shop_money) {
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
}
