package com.cn.android.bean;

import android.graphics.drawable.Drawable;

import java.util.List;

public class Commodity {

    private int status;
    private String msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String imgUrl;
        private String name;
        private String price;
        private String vipprice;
        private int drawable;

        public DataBean() {

        }

        public DataBean(String imgUrl, String name, String price, String vipprice, int drawable) {
            this.imgUrl = imgUrl;
            this.name = name;
            this.price = price;
            this.vipprice = vipprice;
            this.drawable = drawable;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getVipprice() {
            return vipprice;
        }

        public void setVipprice(String vipprice) {
            this.vipprice = vipprice;
        }

        public int getDrawable() {
            return drawable;
        }

        public void setDrawable(int drawable) {
            this.drawable = drawable;
        }
    }
}
