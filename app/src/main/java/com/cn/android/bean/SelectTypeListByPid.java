package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SelectTypeListByPid implements Parcelable {




        /**
         * threeList : [{"img":"http://129.28.62.84/seal/st1.png","name":"华为","id":"11"},{"img":"http://129.28.62.84/seal/st2.png","name":"苹果","id":"12"},{"img":"http://129.28.62.84/seal/st3.png","name":"小米","id":"13"},{"img":"http://129.28.62.84/seal/st4.png","name":"OPPO","id":"14"},{"img":"http://129.28.62.84/seal/st5.png","name":"VIVO","id":"15"},{"img":"http://129.28.62.84/seal/st6.png","name":"三星","id":"16"}]
         * name : 热门品牌
         * id : 10
         */

        private String name;
        private String id;
        private List<ThreeListBean> threeList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<ThreeListBean> getThreeList() {
            return threeList;
        }

        public void setThreeList(List<ThreeListBean> threeList) {
            this.threeList = threeList;
        }

        public static class ThreeListBean {
            /**
             * img : http://129.28.62.84/seal/st1.png
             * name : 华为
             * id : 11
             */

            private String img;
            private String name;
            private String id;

            public static ThreeListBean objectFromData(String str) {

                return new Gson().fromJson( str, ThreeListBean.class );
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( this.name );
        dest.writeString( this.id );
        dest.writeList( this.threeList );
    }

    public SelectTypeListByPid() {
    }

    protected SelectTypeListByPid(Parcel in) {
        this.name = in.readString();
        this.id = in.readString();
        this.threeList = new ArrayList<ThreeListBean>();
        in.readList( this.threeList, ThreeListBean.class.getClassLoader() );
    }

    public static final Parcelable.Creator<SelectTypeListByPid> CREATOR = new Parcelable.Creator<SelectTypeListByPid>() {
        @Override
        public SelectTypeListByPid createFromParcel(Parcel source) {
            return new SelectTypeListByPid( source );
        }

        @Override
        public SelectTypeListByPid[] newArray(int size) {
            return new SelectTypeListByPid[size];
        }
    };
}
