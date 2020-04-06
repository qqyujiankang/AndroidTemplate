package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

/**
 * Inform 我的通知
 */
public class Inform implements Parcelable {

    /**
     * id : 1
     * type : 1
     * title : 放水电费水电费
     * content : 水电费而如果官方答复
     * ctime : 2020-04-06 12:12:12
     * status : 1
     */

    private String id;
    private int type;
    private String title;
    private String content;
    private String ctime;
    private int status;

    public static Inform objectFromData(String str) {

        return new Gson().fromJson( str, Inform.class );
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        dest.writeInt( this.type );
        dest.writeString( this.title );
        dest.writeString( this.content );
        dest.writeString( this.ctime );
        dest.writeInt( this.status );
    }

    public Inform() {
    }

    protected Inform(Parcel in) {
        this.id = in.readString();
        this.type = in.readInt();
        this.title = in.readString();
        this.content = in.readString();
        this.ctime = in.readString();
        this.status = in.readInt();
    }

    public static final Parcelable.Creator<Inform> CREATOR = new Parcelable.Creator<Inform>() {
        @Override
        public Inform createFromParcel(Parcel source) {
            return new Inform( source );
        }

        @Override
        public Inform[] newArray(int size) {
            return new Inform[size];
        }
    };
}
