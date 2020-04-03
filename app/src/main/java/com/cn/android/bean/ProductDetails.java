package com.cn.android.bean;

import com.google.gson.Gson;

import java.util.List;

public class ProductDetails {

    /**
     * shopid : 1
     * shopName : 商品名称商品名称商品名称商品名称
     * shopImg : http://129.28.62.84/seal/2.png
     * imgUrls : http://129.28.62.84/seal/2.png,http://129.28.62.84/seal/2.png,http://129.28.62.84/seal/2.png
     * detilas : http://129.28.62.84/seal/s1.png
     * sellPrice : 11.0
     * vipPrice : 10.58
     * saleNum : 100
     * userid :
     * skuList : [{"skuName":"10g","ctime":"2020-03-30 12:12:12","skuPrice":10,"shopid":"1","id":"1","status":1}]
     * evaList : []
     * is_conlect : 2
     */

    private String shopid;
    private String shopName;
    private String shopImg;
    private String imgUrls;
    private String detilas;
    private double sellPrice;
    private double vipPrice;
    private int saleNum;
    private String userid;
    private int is_conlect;
    private List<SkuListBean> skuList;
    private List<?> evaList;

    public static ProductDetails objectFromData(String str) {

        return new Gson().fromJson( str, ProductDetails.class );
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getDetilas() {
        return detilas;
    }

    public void setDetilas(String detilas) {
        this.detilas = detilas;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getIs_conlect() {
        return is_conlect;
    }

    public void setIs_conlect(int is_conlect) {
        this.is_conlect = is_conlect;
    }

    public List<SkuListBean> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuListBean> skuList) {
        this.skuList = skuList;
    }

    public List<?> getEvaList() {
        return evaList;
    }

    public void setEvaList(List<?> evaList) {
        this.evaList = evaList;
    }

    public static class SkuListBean {
        /**
         * skuName : 10g
         * ctime : 2020-03-30 12:12:12
         * skuPrice : 10.0
         * shopid : 1
         * id : 1
         * status : 1
         */

        private String skuName;
        private String ctime;
        private double skuPrice;
        private String shopid;
        private String id;
        private int status;

        public static SkuListBean objectFromData(String str) {

            return new Gson().fromJson( str, SkuListBean.class );
        }

        public String getSkuName() {
            return skuName;
        }

        public void setSkuName(String skuName) {
            this.skuName = skuName;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public double getSkuPrice() {
            return skuPrice;
        }

        public void setSkuPrice(double skuPrice) {
            this.skuPrice = skuPrice;
        }

        public String getShopid() {
            return shopid;
        }

        public void setShopid(String shopid) {
            this.shopid = shopid;
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
    }
}
