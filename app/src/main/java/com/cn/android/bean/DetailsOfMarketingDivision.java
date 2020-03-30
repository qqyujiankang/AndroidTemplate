package com.cn.android.bean;

import com.google.gson.Gson;

public class DetailsOfMarketingDivision {

    /**
     * id : 1
     * headImg : http://129.28.62.84/seal/m1.png
     * name : 将将建
     * label : 努力就会成功,开玩笑呢！！！
     * sex : 女
     * age : 20
     * job : 高级营销师
     * jobYear : 1
     * ctime : 2020-03-27 12:12:12
     * status : 1
     * wechatImg : http://129.28.62.84/seal/m1.png
     */

    private String id;
    private String headImg;
    private String name;
    private String label;
    private String sex;
    private int age;
    private String job;
    private String jobYear;
    private String ctime;
    private int status;
    private String wechatImg;

    public static DetailsOfMarketingDivision objectFromData(String str) {

        return new Gson().fromJson( str, DetailsOfMarketingDivision.class );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobYear() {
        return jobYear;
    }

    public void setJobYear(String jobYear) {
        this.jobYear = jobYear;
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

    public String getWechatImg() {
        return wechatImg;
    }

    public void setWechatImg(String wechatImg) {
        this.wechatImg = wechatImg;
    }
}
