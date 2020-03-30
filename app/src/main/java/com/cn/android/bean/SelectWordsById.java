package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

public class SelectWordsById implements Parcelable {

    /**
     * id : 1
     * imgUrl : http://129.28.62.84/seal/w1.png
     * title : 电商创业：如何参加社交电商的红利标
     * ctime : 2020-03-27 12:12:12
     * status : 1
     * content : <p>短时间发生就懂啊谁都爱我的破万的拉萨们重新做你才没下班v空间的死党是奇偶啥进度空间站的快速在家里看下你快速解冻i阿呆京东鞍山的潇洒 了接下来在奇偶走就行哦自己从小资产帕可持续了村民 。
     班v空间的死党是奇偶啥进度空间站的快速在家里看下你快速解冻i阿呆京东鞍山的潇洒 了接下来在奇偶走就行哦自己从小资产帕可持续了村民 多岁的撒旦执行总裁</p>
     */

    private String id;
    private String imgUrl;
    private String title;
    private String ctime;
    private int status;
    private String content;

    public static SelectWordsById objectFromData(String str) {

        return new Gson().fromJson( str, SelectWordsById.class );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( this.id );
        dest.writeString( this.imgUrl );
        dest.writeString( this.title );
        dest.writeString( this.ctime );
        dest.writeInt( this.status );
        dest.writeString( this.content );
    }

    public SelectWordsById() {
    }

    protected SelectWordsById(Parcel in) {
        this.id = in.readString();
        this.imgUrl = in.readString();
        this.title = in.readString();
        this.ctime = in.readString();
        this.status = in.readInt();
        this.content = in.readString();
    }

    public static final Parcelable.Creator<SelectWordsById> CREATOR = new Parcelable.Creator<SelectWordsById>() {
        @Override
        public SelectWordsById createFromParcel(Parcel source) {
            return new SelectWordsById( source );
        }

        @Override
        public SelectWordsById[] newArray(int size) {
            return new SelectWordsById[size];
        }
    };
}
