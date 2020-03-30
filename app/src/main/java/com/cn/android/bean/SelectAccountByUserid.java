package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 余额详情
 */
public class SelectAccountByUserid implements Parcelable {

    /**
     * id : 1
     * type : 1
     * payType : 1
     * payMoney : 20.99
     * ordercode : 111111
     * shoporder : 111111
     * userid : 899079
     * status : 1
     * ctime : 2020-03-27 12:12:12
     * remark :
     * accountno :
     * accountName :
     */

    private String id;
    private int type;
    private int payType;
    private double payMoney;
    private String ordercode;
    private String shoporder;
    private String userid;
    private int status;
    private String ctime;
    private String remark;
    private String accountno;
    private String accountName;

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

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getShoporder() {
        return shoporder;
    }

    public void setShoporder(String shoporder) {
        this.shoporder = shoporder;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( this.id );
        dest.writeInt( this.type );
        dest.writeInt( this.payType );
        dest.writeDouble( this.payMoney );
        dest.writeString( this.ordercode );
        dest.writeString( this.shoporder );
        dest.writeString( this.userid );
        dest.writeInt( this.status );
        dest.writeString( this.ctime );
        dest.writeString( this.remark );
        dest.writeString( this.accountno );
        dest.writeString( this.accountName );
    }

    public SelectAccountByUserid() {
    }

    protected SelectAccountByUserid(Parcel in) {
        this.id = in.readString();
        this.type = in.readInt();
        this.payType = in.readInt();
        this.payMoney = in.readDouble();
        this.ordercode = in.readString();
        this.shoporder = in.readString();
        this.userid = in.readString();
        this.status = in.readInt();
        this.ctime = in.readString();
        this.remark = in.readString();
        this.accountno = in.readString();
        this.accountName = in.readString();
    }

    public static final Parcelable.Creator<SelectAccountByUserid> CREATOR = new Parcelable.Creator<SelectAccountByUserid>() {
        @Override
        public SelectAccountByUserid createFromParcel(Parcel source) {
            return new SelectAccountByUserid( source );
        }

        @Override
        public SelectAccountByUserid[] newArray(int size) {
            return new SelectAccountByUserid[size];
        }
    };
}
