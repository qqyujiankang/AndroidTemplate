package com.cn.android.bean;

import com.google.gson.Gson;

public class SelectNewShop {

    /**
     * id : 5
     * type : 1
     * shopImg : http://129.28.62.84/seal/2.png
     * imgUrls : http://129.28.62.84/seal/2.png,http://129.28.62.84/seal/2.png,http://129.28.62.84/seal/2.png
     * shopName : 商品名称商品名称商品名称商品名称
     * sellPrice : 15.0
     * realPrice : 18.0
     * vipPrice : 14.0
     * isBurst : 1
     * firstTypeId : 1
     * secondeTypeId :
     * threeTypeId :
     * stockNum : 100000
     * saleNum : 100
     * userid :
     * isSort : 2
     * sortTime :
     * ctime : 2020-03-26 12:12:41
     * status : 1
     * isUp : 1
     * detilas : http://129.28.62.84/seal/s1.png
     * isSend : 1
     * shareUrl :
     */

    private String id;
    private int type;
    private String shopImg;
    private String imgUrls;
    private String shopName;
    private double sellPrice;
    private double realPrice;
    private double vipPrice;
    private int isBurst;
    private String firstTypeId;
    private String secondeTypeId;
    private String threeTypeId;
    private int stockNum;
    private int saleNum;
    private String userid;
    private int isSort;
    private String sortTime;
    private String ctime;
    private int status;
    private int isUp;
    private String detilas;
    private int isSend;
    private String shareUrl;

    public static SelectNewShop objectFromData(String str) {

        return new Gson().fromJson( str, SelectNewShop.class );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }

    public double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public int getIsBurst() {
        return isBurst;
    }

    public void setIsBurst(int isBurst) {
        this.isBurst = isBurst;
    }

    public String getFirstTypeId() {
        return firstTypeId;
    }

    public void setFirstTypeId(String firstTypeId) {
        this.firstTypeId = firstTypeId;
    }

    public String getSecondeTypeId() {
        return secondeTypeId;
    }

    public void setSecondeTypeId(String secondeTypeId) {
        this.secondeTypeId = secondeTypeId;
    }

    public String getThreeTypeId() {
        return threeTypeId;
    }

    public void setThreeTypeId(String threeTypeId) {
        this.threeTypeId = threeTypeId;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
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

    public int getIsSort() {
        return isSort;
    }

    public void setIsSort(int isSort) {
        this.isSort = isSort;
    }

    public String getSortTime() {
        return sortTime;
    }

    public void setSortTime(String sortTime) {
        this.sortTime = sortTime;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsUp() {
        return isUp;
    }

    public void setIsUp(int isUp) {
        this.isUp = isUp;
    }

    public String getDetilas() {
        return detilas;
    }

    public void setDetilas(String detilas) {
        this.detilas = detilas;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }
}
