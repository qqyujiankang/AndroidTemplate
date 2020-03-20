package com.cn.android.bean;

public class ClassifyBean {

    public ClassifyBean(boolean isClick, String name) {
        this.isClick = isClick;
        this.name = name;
    }

    private boolean isClick;
    private String name;

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
