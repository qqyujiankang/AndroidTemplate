package com.cn.android.bean;

public class Register {

    /**
     * status : 200
     * msg : 注册成功
     * data : {"id":"008987","isPlatform":2,"type":2,"userphone":"15535958282","pid":"","province":"陕西省","city":"西安市","area":"雁塔区","isReal":0,"applyTime":"","auditTime":"","idcardFront":"","idcardBack":"","businessImg":"","realname":"","phone":"","isCater":2,"caterImg":"","storeName":"","status":1,"token":"8669862129","umoney":0,"isWechat":2,"wechatno":"","wechatName":"","isAlipay":2,"alipayno":"","alipayName":"","nickname":"","sex":"","headImg":"","isGood":2,"ctime":"2020-03-26 14:03:39"}
     */

    private int status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 008987
         * isPlatform : 2
         * type : 2
         * userphone : 15535958282
         * pid :
         * province : 陕西省
         * city : 西安市
         * area : 雁塔区
         * isReal : 0
         * applyTime :
         * auditTime :
         * idcardFront :
         * idcardBack :
         * businessImg :
         * realname :
         * phone :
         * isCater : 2
         * caterImg :
         * storeName :
         * status : 1
         * token : 8669862129
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
         * ctime : 2020-03-26 14:03:39
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
        private String auditTime;
        private String idcardFront;
        private String idcardBack;
        private String businessImg;
        private String realname;
        private String phone;
        private int isCater;
        private String caterImg;
        private String storeName;
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

        public String getAuditTime() {
            return auditTime;
        }

        public void setAuditTime(String auditTime) {
            this.auditTime = auditTime;
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

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
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
    }
}
