package com.cn.android.bean;

import java.util.List;

public class ShopBean {
    private String className;

    private List<ShopItem> list;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ShopItem> getList() {
        return list;
    }

    public void setList(List<ShopItem> list) {
        this.list = list;
    }

    public static class ShopItem {
        public ShopItem(int img, String name, String goods_num) {
            this.img = img;
            this.name = name;
            this.goods_num = goods_num;
        }

        public String getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(String goods_num) {
            this.goods_num = goods_num;
        }

        private int img;
        private String name;
        private String goods_num;

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
