package com.cn.android.bean;

public class ShopGuiGeBean {
    private String guiGe;
    private String vipMoney;
    private String money;
    private boolean isClick;

    public ShopGuiGeBean(String guiGe, boolean isClick) {
        this.guiGe = guiGe;
        this.isClick = isClick;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public String getGuiGe() {
        return guiGe;
    }

    public void setGuiGe(String guiGe) {
        this.guiGe = guiGe;
    }

    public String getVipMoney() {
        return vipMoney;
    }

    public void setVipMoney(String vipMoney) {
        this.vipMoney = vipMoney;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
