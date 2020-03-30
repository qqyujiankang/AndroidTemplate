package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class AddressByUserid implements Parcelable {

    /**
     * id : D5A2E5308D7BC8B00A7F089148A7CEA8
     * userid : 899079
     * name : 咯啦啦啦
     * phone : 15535958281
     * proCityArea : 重庆市重庆市沙坪坝区
     * address : 涂涂乐
     * isDefault : 2
     * ctime : 2020-03-26 19:26:48
     * status : 1
     */

    private String id;
    private String userid;
    private String name;
    private String phone;
    private String proCityArea;
    private String address;
    private int isDefault;
    private String ctime;
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProCityArea() {
        return proCityArea;
    }

    public void setProCityArea(String proCityArea) {
        this.proCityArea = proCityArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
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
        dest.writeString( this.userid );
        dest.writeString( this.name );
        dest.writeString( this.phone );
        dest.writeString( this.proCityArea );
        dest.writeString( this.address );
        dest.writeInt( this.isDefault );
        dest.writeString( this.ctime );
        dest.writeInt( this.status );
    }

    public AddressByUserid() {
    }

    protected AddressByUserid(Parcel in) {
        this.id = in.readString();
        this.userid = in.readString();
        this.name = in.readString();
        this.phone = in.readString();
        this.proCityArea = in.readString();
        this.address = in.readString();
        this.isDefault = in.readInt();
        this.ctime = in.readString();
        this.status = in.readInt();
    }

    public static final Parcelable.Creator<AddressByUserid> CREATOR = new Parcelable.Creator<AddressByUserid>() {
        @Override
        public AddressByUserid createFromParcel(Parcel source) {
            return new AddressByUserid( source );
        }

        @Override
        public AddressByUserid[] newArray(int size) {
            return new AddressByUserid[size];
        }
    };
}
