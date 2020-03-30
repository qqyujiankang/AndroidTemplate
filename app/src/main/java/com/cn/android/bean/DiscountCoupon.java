package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 优惠卷
 */
public class DiscountCoupon implements Parcelable {

    /**
     * id : 1
     * useMoney : 50.0
     * conditionMoney : 500.0
     * stime : 2020-03-27
     * etime : 2020-04-27
     * content : 满500元可用
     * isUse : 1使用 2未使用
     * userid : 899079
     * ctime : 2020-03-27 12:12:12
     * status : 1
     */

    private String id;
    private double useMoney;
    private double conditionMoney;
    private String stime;
    private String etime;
    private String content;
    private int isUse;
    private String userid;
    private String ctime;
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getUseMoney() {
        return useMoney;
    }

    public void setUseMoney(double useMoney) {
        this.useMoney = useMoney;
    }

    public double getConditionMoney() {
        return conditionMoney;
    }

    public void setConditionMoney(double conditionMoney) {
        this.conditionMoney = conditionMoney;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( this.id );
        dest.writeDouble( this.useMoney );
        dest.writeDouble( this.conditionMoney );
        dest.writeString( this.stime );
        dest.writeString( this.etime );
        dest.writeString( this.content );
        dest.writeInt( this.isUse );
        dest.writeString( this.userid );
        dest.writeString( this.ctime );
        dest.writeInt( this.status );
    }

    public DiscountCoupon() {
    }

    protected DiscountCoupon(Parcel in) {
        this.id = in.readString();
        this.useMoney = in.readDouble();
        this.conditionMoney = in.readDouble();
        this.stime = in.readString();
        this.etime = in.readString();
        this.content = in.readString();
        this.isUse = in.readInt();
        this.userid = in.readString();
        this.ctime = in.readString();
        this.status = in.readInt();
    }

    public static final Parcelable.Creator<DiscountCoupon> CREATOR = new Parcelable.Creator<DiscountCoupon>() {
        @Override
        public DiscountCoupon createFromParcel(Parcel source) {
            return new DiscountCoupon( source );
        }

        @Override
        public DiscountCoupon[] newArray(int size) {
            return new DiscountCoupon[size];
        }
    };
}
