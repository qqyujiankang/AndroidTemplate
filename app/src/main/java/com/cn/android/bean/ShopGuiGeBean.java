package com.cn.android.bean;

public class ShopGuiGeBean {
    private String sku_name;
    private String price;
    private boolean isClick;

    public ShopGuiGeBean() {
    }

    public ShopGuiGeBean(String sku_name, boolean isClick) {
        this.sku_name = sku_name;
        this.isClick = isClick;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public String getGuiGe() {
        return sku_name;
    }

    public void setGuiGe(String sku_name) {
        this.sku_name = sku_name;
    }




    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }
}
