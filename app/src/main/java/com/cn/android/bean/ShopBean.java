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
        public ShopItem(int img, String name) {
            this.img = img;
            this.name = name;
        }

        private int img;
        private String name;

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
