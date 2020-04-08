package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

public class Userdata implements Parcelable {


    /**
     * id : 104681
     * isPlatform : 2
     * type : 2
     * userphone : 15535958293
     * pid :
     * province : 陕西省
     * city : 西安市
     * area : 雁塔区
     * isReal : 0
     * applyTime :
     * idcardFront :
     * idcardBack :
     * businessImg :
     * realname :
     * phone :
     * isCater : 2
     * caterImg :
     * storeTypeId :
     * storeTypName :
     * storeName :
     * storeImg :
     * status : 1
     * token : 5820494987
     * umoney : 0.0
     * isWechat : 2
     * wechatno :
     * wechatName :
     * isAlipay : 2
     * alipayno :
     * alipayName :
     * nickname :
     * sex :
     * headImg :
     * isGood : 2
     * ctime : 2020-04-07 11:40:03
     * stime :
     * etime :
     * rongyunToken : rgQhrfYJ9CfPsBhFQymMyDVTPjpnzvGsgskHghc8vyyxw8DF0jUqBCFUg43zB7FrqZiPTd1nhZsPpUj34UfRGA==
     */

    private String id;
    private int isPlatform;
    private int type;
    private String userphone;
    private String pid;
    private String province;
    private String city;
    private String area;
    private int isReal;
    private String applyTime;
    private String idcardFront;
    private String idcardBack;
    private String businessImg;
    private String realname;
    private String phone;
    private int isCater;
    private String caterImg;
    private String storeTypeId;
    private String storeTypName;
    private String storeName;
    private String storeImg;
    private int status;
    private String token;
    private double umoney;
    private int isWechat;
    private String wechatno;
    private String wechatName;
    private int isAlipay;
    private String alipayno;
    private String alipayName;
    private String nickname;
    private String sex;
    private String headImg;
    private int isGood;
    private String ctime;
    private String stime;
    private String etime;
    private String rongyunToken;

    public static Userdata objectFromData(String str) {

        return new Gson().fromJson( str, Userdata.class );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIsPlatform() {
        return isPlatform;
    }

    public void setIsPlatform(int isPlatform) {
        this.isPlatform = isPlatform;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getIsReal() {
        return isReal;
    }

    public void setIsReal(int isReal) {
        this.isReal = isReal;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getIdcardFront() {
        return idcardFront;
    }

    public void setIdcardFront(String idcardFront) {
        this.idcardFront = idcardFront;
    }

    public String getIdcardBack() {
        return idcardBack;
    }

    public void setIdcardBack(String idcardBack) {
        this.idcardBack = idcardBack;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsCater() {
        return isCater;
    }

    public void setIsCater(int isCater) {
        this.isCater = isCater;
    }

    public String getCaterImg() {
        return caterImg;
    }

    public void setCaterImg(String caterImg) {
        this.caterImg = caterImg;
    }

    public String getStoreTypeId() {
        return storeTypeId;
    }

    public void setStoreTypeId(String storeTypeId) {
        this.storeTypeId = storeTypeId;
    }

    public String getStoreTypName() {
        return storeTypName;
    }

    public void setStoreTypName(String storeTypName) {
        this.storeTypName = storeTypName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(String storeImg) {
        this.storeImg = storeImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getUmoney() {
        return umoney;
    }

    public void setUmoney(double umoney) {
        this.umoney = umoney;
    }

    public int getIsWechat() {
        return isWechat;
    }

    public void setIsWechat(int isWechat) {
        this.isWechat = isWechat;
    }

    public String getWechatno() {
        return wechatno;
    }

    public void setWechatno(String wechatno) {
        this.wechatno = wechatno;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public int getIsAlipay() {
        return isAlipay;
    }

    public void setIsAlipay(int isAlipay) {
        this.isAlipay = isAlipay;
    }

    public String getAlipayno() {
        return alipayno;
    }

    public void setAlipayno(String alipayno) {
        this.alipayno = alipayno;
    }

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public int getIsGood() {
        return isGood;
    }

    public void setIsGood(int isGood) {
        this.isGood = isGood;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
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

    public String getRongyunToken() {
        return rongyunToken;
    }

    public void setRongyunToken(String rongyunToken) {
        this.rongyunToken = rongyunToken;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( this.id );
        dest.writeInt( this.isPlatform );
        dest.writeInt( this.type );
        dest.writeString( this.userphone );
        dest.writeString( this.pid );
        dest.writeString( this.province );
        dest.writeString( this.city );
        dest.writeString( this.area );
        dest.writeInt( this.isReal );
        dest.writeString( this.applyTime );
        dest.writeString( this.idcardFront );
        dest.writeString( this.idcardBack );
        dest.writeString( this.businessImg );
        dest.writeString( this.realname );
        dest.writeString( this.phone );
        dest.writeInt( this.isCater );
        dest.writeString( this.caterImg );
        dest.writeString( this.storeTypeId );
        dest.writeString( this.storeTypName );
        dest.writeString( this.storeName );
        dest.writeString( this.storeImg );
        dest.writeInt( this.status );
        dest.writeString( this.token );
        dest.writeDouble( this.umoney );
        dest.writeInt( this.isWechat );
        dest.writeString( this.wechatno );
        dest.writeString( this.wechatName );
        dest.writeInt( this.isAlipay );
        dest.writeString( this.alipayno );
        dest.writeString( this.alipayName );
        dest.writeString( this.nickname );
        dest.writeString( this.sex );
        dest.writeString( this.headImg );
        dest.writeInt( this.isGood );
        dest.writeString( this.ctime );
        dest.writeString( this.stime );
        dest.writeString( this.etime );
        dest.writeString( this.rongyunToken );
    }

    public Userdata() {
    }

    protected Userdata(Parcel in) {
        this.id = in.readString();
        this.isPlatform = in.readInt();
        this.type = in.readInt();
        this.userphone = in.readString();
        this.pid = in.readString();
        this.province = in.readString();
        this.city = in.readString();
        this.area = in.readString();
        this.isReal = in.readInt();
        this.applyTime = in.readString();
        this.idcardFront = in.readString();
        this.idcardBack = in.readString();
        this.businessImg = in.readString();
        this.realname = in.readString();
        this.phone = in.readString();
        this.isCater = in.readInt();
        this.caterImg = in.readString();
        this.storeTypeId = in.readString();
        this.storeTypName = in.readString();
        this.storeName = in.readString();
        this.storeImg = in.readString();
        this.status = in.readInt();
        this.token = in.readString();
        this.umoney = in.readDouble();
        this.isWechat = in.readInt();
        this.wechatno = in.readString();
        this.wechatName = in.readString();
        this.isAlipay = in.readInt();
        this.alipayno = in.readString();
        this.alipayName = in.readString();
        this.nickname = in.readString();
        this.sex = in.readString();
        this.headImg = in.readString();
        this.isGood = in.readInt();
        this.ctime = in.readString();
        this.stime = in.readString();
        this.etime = in.readString();
        this.rongyunToken = in.readString();
    }

    public static final Parcelable.Creator<Userdata> CREATOR = new Parcelable.Creator<Userdata>() {
        @Override
        public Userdata createFromParcel(Parcel source) {
            return new Userdata( source );
        }

        @Override
        public Userdata[] newArray(int size) {
            return new Userdata[size];
        }
    };
}
