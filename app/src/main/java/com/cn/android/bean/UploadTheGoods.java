package com.cn.android.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * 企业 商品管理-编辑详情
 */
public class UploadTheGoods {


    /**
     * isSort : 1
     * skuList : [{"id":"1","shopid":"1","skuName":"10g","skuPrice":10,"ctime":"2020-03-30 12:12:12","status":1}]
     * imgUrls : http://129.28.62.84/seal/2.png,http://129.28.62.84/seal/2.png,http://129.28.62.84/seal/2.png
     * sortTime : 2020-04-01 10:50:42
     * shopName : 商品名称商品名称商品名称商品名称
     * sellPrice : 11
     * type : 1
     * userid :
     * isBurst : 1
     * isUp : 1
     * vipPrice : 10.58
     * stockNum : 100000
     * shopImg : http://129.28.62.84/seal/2.png
     * ctime : 2020-03-26 12:12:41
     * id : 1
     * threeTypeId : 11
     * firstTypeId : 1
     * secondeTypeId : 10
     * saleNum : 100
     * detilas : http://129.28.62.84/seal/s1.png
     * isSend : 1
     * shareUrl :
     * shopType : 新鲜水果-热门品牌-华为
     * realPrice : 12
     * status : 1
     */

    private int isSort;
    private String imgUrls;
    private String sortTime;
    private String shopName;
    private int sellPrice;
    private int type;
    private String userid;
    private int isBurst;
    private int isUp;
    private double vipPrice;
    private int stockNum;
    private String shopImg;
    private String ctime;
    private String id;
    private String threeTypeId;
    private String firstTypeId;
    private String secondeTypeId;
    private int saleNum;
    private String detilas;
    private int isSend;
    private String shareUrl;
    private String shopType;
    private int realPrice;
    private int status;
    private List<SkuListBean> skuList;

    public static UploadTheGoods objectFromData(String str) {

        return new Gson().fromJson( str, UploadTheGoods.class );
    }

    public int getIsSort() {
        return isSort;
    }

    public void setIsSort(int isSort) {
        this.isSort = isSort;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getSortTime() {
        return sortTime;
    }

    public void setSortTime(String sortTime) {
        this.sortTime = sortTime;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getIsBurst() {
        return isBurst;
    }

    public void setIsBurst(int isBurst) {
        this.isBurst = isBurst;
    }

    public int getIsUp() {
        return isUp;
    }

    public void setIsUp(int isUp) {
        this.isUp = isUp;
    }

    public double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThreeTypeId() {
        return threeTypeId;
    }

    public void setThreeTypeId(String threeTypeId) {
        this.threeTypeId = threeTypeId;
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

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
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

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public int getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(int realPrice) {
        this.realPrice = realPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SkuListBean> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuListBean> skuList) {
        this.skuList = skuList;
    }

    public static class SkuListBean {
        /**
         * id : 1
         * shopid : 1
         * skuName : 10g
         * skuPrice : 10
         * ctime : 2020-03-30 12:12:12
         * status : 1
         */

        private String id;
        private String shopid;
        private String skuName;
        private int skuPrice;
        private String ctime;
        private int status;

        public static SkuListBean objectFromData(String str) {

            return new Gson().fromJson( str, SkuListBean.class );
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getShopid() {
            return shopid;
        }

        public void setShopid(String shopid) {
            this.shopid = shopid;
        }

        public String getSkuName() {
            return skuName;
        }

        public void setSkuName(String skuName) {
            this.skuName = skuName;
        }

        public int getSkuPrice() {
            return skuPrice;
        }

        public void setSkuPrice(int skuPrice) {
            this.skuPrice = skuPrice;
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
    }
}
