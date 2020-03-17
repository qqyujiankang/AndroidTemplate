package com.cn.android.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

/**
 * Created by Xie JiaBin on 2019/12/31.
 */
public class BannerBean {


    /**
     * status : 200
     * msg : ok
     * data : [{"id":"1a","imgUrl":"http://47.92.247.250:80/upload/1.png","ctime":"2019-03-08 12:12:12","status":1},{"id":"2b","imgUrl":"http://47.92.247.250:80/upload/b1.png","ctime":"2019-03-08 12:12:12","status":1},{"id":"3c","imgUrl":"http://47.92.247.250:80/upload/b2.png","ctime":"2019-03-08 12:12:12","status":1},{"id":"4d","imgUrl":"http://47.92.247.250:80/upload/b3.png","ctime":"2019-03-08 12:12:12","status":1}]
     */

    private int status;
    private String msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends SimpleBannerInfo {
        public DataBean(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        /**
         * id : 1a
         * imgUrl : http://47.92.247.250:80/upload/1.png
         * ctime : 2019-03-08 12:12:12
         * status : 1
         */

        private String id;
        private String imgUrl;
        private String ctime;
        private int status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImgUrl() {
            return imgUrl;
        }
        @Override
        public Object getXBannerUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
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


    }
}
