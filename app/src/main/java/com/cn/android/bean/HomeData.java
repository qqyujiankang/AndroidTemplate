package com.cn.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HomeData implements Parcelable {

    //优秀营销师
    private List<MarketingUserListBean> marketingUserList;
    //咨询列表
    private List<WordsInfoListBean> wordsInfoList;
    //    优质店铺
    private List<AppUserListBean> appUserList;

    private List<ShufflingInfoListBean> shufflingInfoList;
    //    每日爆品
    private List<ShopInfoListBean> shopInfoList;
    //分类
    private List<ShopTypeListBean> shopTypeList;


    public List<MarketingUserListBean> getMarketingUserList() {
        return marketingUserList;
    }

    public void setMarketingUserList(List<MarketingUserListBean> marketingUserList) {
        this.marketingUserList = marketingUserList;
    }

    public List<WordsInfoListBean> getWordsInfoList() {
        return wordsInfoList;
    }

    public void setWordsInfoList(List<WordsInfoListBean> wordsInfoList) {
        this.wordsInfoList = wordsInfoList;
    }

    public List<AppUserListBean> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUserListBean> appUserList) {
        this.appUserList = appUserList;
    }

    public List<ShufflingInfoListBean> getShufflingInfoList() {
        return shufflingInfoList;
    }

    public void setShufflingInfoList(List<ShufflingInfoListBean> shufflingInfoList) {
        this.shufflingInfoList = shufflingInfoList;
    }

    public List<ShopInfoListBean> getShopInfoList() {
        return shopInfoList;
    }

    public void setShopInfoList(List<ShopInfoListBean> shopInfoList) {
        this.shopInfoList = shopInfoList;
    }

    public List<ShopTypeListBean> getShopTypeList() {
        return shopTypeList;
    }

    public void setShopTypeList(List<ShopTypeListBean> shopTypeList) {
        this.shopTypeList = shopTypeList;
    }

    /**
     * 优秀营销师
     */
    public static class MarketingUserListBean implements Parcelable {
        /**
         * headImg : http://129.28.62.84/seal/m1.png
         * jobYear : 1
         * sex : 女
         * name : 将将建
         * ctime : 2020-03-27 12:12:12
         * id : 1
         * label : 努力就会成功,开玩笑呢！！！
         * job : 高级营销师
         * age : 20
         * wechatImg : http://129.28.62.84/seal/m1.png
         * status : 1
         */

        private String headImg;
        private String jobYear;
        private String sex;
        private String name;
        private String ctime;
        private String id;
        private String label;
        private String job;
        private int age;
        private String wechatImg;
        private int status;

        public static MarketingUserListBean objectFromData(String str) {

            return new Gson().fromJson( str, MarketingUserListBean.class );
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getJobYear() {
            return jobYear;
        }

        public void setJobYear(String jobYear) {
            this.jobYear = jobYear;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getWechatImg() {
            return wechatImg;
        }

        public void setWechatImg(String wechatImg) {
            this.wechatImg = wechatImg;
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
            dest.writeString( this.headImg );
            dest.writeString( this.jobYear );
            dest.writeString( this.sex );
            dest.writeString( this.name );
            dest.writeString( this.ctime );
            dest.writeString( this.id );
            dest.writeString( this.label );
            dest.writeString( this.job );
            dest.writeInt( this.age );
            dest.writeString( this.wechatImg );
            dest.writeInt( this.status );
        }

        public MarketingUserListBean() {
        }

        protected MarketingUserListBean(Parcel in) {
            this.headImg = in.readString();
            this.jobYear = in.readString();
            this.sex = in.readString();
            this.name = in.readString();
            this.ctime = in.readString();
            this.id = in.readString();
            this.label = in.readString();
            this.job = in.readString();
            this.age = in.readInt();
            this.wechatImg = in.readString();
            this.status = in.readInt();
        }

        public static final Creator<MarketingUserListBean> CREATOR = new Creator<MarketingUserListBean>() {
            @Override
            public MarketingUserListBean createFromParcel(Parcel source) {
                return new MarketingUserListBean( source );
            }

            @Override
            public MarketingUserListBean[] newArray(int size) {
                return new MarketingUserListBean[size];
            }
        };
    }

    public static class WordsInfoListBean implements Parcelable {

        /**
         * imgUrl : http://129.28.62.84/seal/w1.png
         * ctime : 2020-03-27 12:12:12
         * id : 1
         * title : 电商创业：如何参加社交电商的红利标
         * content :
         * status : 1
         */

        private String imgUrl;
        private String ctime;
        private String id;
        private String title;
        private String content;
        private int status;

        public static WordsInfoListBean objectFromData(String str) {

            return new Gson().fromJson( str, WordsInfoListBean.class );
        }

        public String getImgUrl() {
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
            dest.writeString( this.imgUrl );
            dest.writeString( this.ctime );
            dest.writeString( this.id );
            dest.writeString( this.title );
            dest.writeString( this.content );
            dest.writeInt( this.status );
        }

        public WordsInfoListBean() {
        }

        protected WordsInfoListBean(Parcel in) {
            this.imgUrl = in.readString();
            this.ctime = in.readString();
            this.id = in.readString();
            this.title = in.readString();
            this.content = in.readString();
            this.status = in.readInt();
        }

        public static final Creator<WordsInfoListBean> CREATOR = new Creator<WordsInfoListBean>() {
            @Override
            public WordsInfoListBean createFromParcel(Parcel source) {
                return new WordsInfoListBean( source );
            }

            @Override
            public WordsInfoListBean[] newArray(int size) {
                return new WordsInfoListBean[size];
            }
        };
    }

    public static class AppUserListBean implements Parcelable {

        /**
         * isReal : 2
         * isAlipay : 2
         * city : 西安市
         * caterImg :
         * isPlatform : 2
         * storeTypeId : 1
         * pid :
         * stime :
         * isWechat : 2
         * type : 2
         * province : 陕西省
         * nickname :
         * ctime : 2020-03-26 14:03:39
         * storeName : 店铺名称
         * id : 008987
         * applyTime :
         * wechatName :
         * area : 雁塔区
         * businessImg :
         * headImg :
         * isGood : 1
         * userphone : 15535958282
         * idcardBack :
         * sex :
         * alipayName :
         * realname :
         * token : 4556808165
         * isCater : 2
         * umoney : 0
         * alipayno :
         * phone :
         * etime :
         * storeImg : http://129.28.62.84/seal/3.png
         * storeTypName : 新鲜水果
         * idcardFront :
         * status : 1
         * wechatno :
         */

        private int isReal;
        private int isAlipay;
        private String city;
        private String caterImg;
        private int isPlatform;
        private String storeTypeId;
        private String pid;
        private String stime;
        private int isWechat;
        private int type;
        private String province;
        private String nickname;
        private String ctime;
        private String storeName;
        private String id;
        private String applyTime;
        private String wechatName;
        private String area;
        private String businessImg;
        private String headImg;
        private int isGood;
        private String userphone;
        private String idcardBack;
        private String sex;
        private String alipayName;
        private String realname;
        private String token;
        private int isCater;
        private int umoney;
        private String alipayno;
        private String phone;
        private String etime;
        private String storeImg;
        private String storeTypName;
        private String idcardFront;
        private int status;
        private String wechatno;

        public static AppUserListBean objectFromData(String str) {

            return new Gson().fromJson( str, AppUserListBean.class );
        }

        public int getIsReal() {
            return isReal;
        }

        public void setIsReal(int isReal) {
            this.isReal = isReal;
        }

        public int getIsAlipay() {
            return isAlipay;
        }

        public void setIsAlipay(int isAlipay) {
            this.isAlipay = isAlipay;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCaterImg() {
            return caterImg;
        }

        public void setCaterImg(String caterImg) {
            this.caterImg = caterImg;
        }

        public int getIsPlatform() {
            return isPlatform;
        }

        public void setIsPlatform(int isPlatform) {
            this.isPlatform = isPlatform;
        }

        public String getStoreTypeId() {
            return storeTypeId;
        }

        public void setStoreTypeId(String storeTypeId) {
            this.storeTypeId = storeTypeId;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getStime() {
            return stime;
        }

        public void setStime(String stime) {
            this.stime = stime;
        }

        public int getIsWechat() {
            return isWechat;
        }

        public void setIsWechat(int isWechat) {
            this.isWechat = isWechat;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getApplyTime() {
            return applyTime;
        }

        public void setApplyTime(String applyTime) {
            this.applyTime = applyTime;
        }

        public String getWechatName() {
            return wechatName;
        }

        public void setWechatName(String wechatName) {
            this.wechatName = wechatName;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getBusinessImg() {
            return businessImg;
        }

        public void setBusinessImg(String businessImg) {
            this.businessImg = businessImg;
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

        public String getUserphone() {
            return userphone;
        }

        public void setUserphone(String userphone) {
            this.userphone = userphone;
        }

        public String getIdcardBack() {
            return idcardBack;
        }

        public void setIdcardBack(String idcardBack) {
            this.idcardBack = idcardBack;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAlipayName() {
            return alipayName;
        }

        public void setAlipayName(String alipayName) {
            this.alipayName = alipayName;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getIsCater() {
            return isCater;
        }

        public void setIsCater(int isCater) {
            this.isCater = isCater;
        }

        public int getUmoney() {
            return umoney;
        }

        public void setUmoney(int umoney) {
            this.umoney = umoney;
        }

        public String getAlipayno() {
            return alipayno;
        }

        public void setAlipayno(String alipayno) {
            this.alipayno = alipayno;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEtime() {
            return etime;
        }

        public void setEtime(String etime) {
            this.etime = etime;
        }

        public String getStoreImg() {
            return storeImg;
        }

        public void setStoreImg(String storeImg) {
            this.storeImg = storeImg;
        }

        public String getStoreTypName() {
            return storeTypName;
        }

        public void setStoreTypName(String storeTypName) {
            this.storeTypName = storeTypName;
        }

        public String getIdcardFront() {
            return idcardFront;
        }

        public void setIdcardFront(String idcardFront) {
            this.idcardFront = idcardFront;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getWechatno() {
            return wechatno;
        }

        public void setWechatno(String wechatno) {
            this.wechatno = wechatno;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt( this.isReal );
            dest.writeInt( this.isAlipay );
            dest.writeString( this.city );
            dest.writeString( this.caterImg );
            dest.writeInt( this.isPlatform );
            dest.writeString( this.storeTypeId );
            dest.writeString( this.pid );
            dest.writeString( this.stime );
            dest.writeInt( this.isWechat );
            dest.writeInt( this.type );
            dest.writeString( this.province );
            dest.writeString( this.nickname );
            dest.writeString( this.ctime );
            dest.writeString( this.storeName );
            dest.writeString( this.id );
            dest.writeString( this.applyTime );
            dest.writeString( this.wechatName );
            dest.writeString( this.area );
            dest.writeString( this.businessImg );
            dest.writeString( this.headImg );
            dest.writeInt( this.isGood );
            dest.writeString( this.userphone );
            dest.writeString( this.idcardBack );
            dest.writeString( this.sex );
            dest.writeString( this.alipayName );
            dest.writeString( this.realname );
            dest.writeString( this.token );
            dest.writeInt( this.isCater );
            dest.writeInt( this.umoney );
            dest.writeString( this.alipayno );
            dest.writeString( this.phone );
            dest.writeString( this.etime );
            dest.writeString( this.storeImg );
            dest.writeString( this.storeTypName );
            dest.writeString( this.idcardFront );
            dest.writeInt( this.status );
            dest.writeString( this.wechatno );
        }

        public AppUserListBean() {
        }

        protected AppUserListBean(Parcel in) {
            this.isReal = in.readInt();
            this.isAlipay = in.readInt();
            this.city = in.readString();
            this.caterImg = in.readString();
            this.isPlatform = in.readInt();
            this.storeTypeId = in.readString();
            this.pid = in.readString();
            this.stime = in.readString();
            this.isWechat = in.readInt();
            this.type = in.readInt();
            this.province = in.readString();
            this.nickname = in.readString();
            this.ctime = in.readString();
            this.storeName = in.readString();
            this.id = in.readString();
            this.applyTime = in.readString();
            this.wechatName = in.readString();
            this.area = in.readString();
            this.businessImg = in.readString();
            this.headImg = in.readString();
            this.isGood = in.readInt();
            this.userphone = in.readString();
            this.idcardBack = in.readString();
            this.sex = in.readString();
            this.alipayName = in.readString();
            this.realname = in.readString();
            this.token = in.readString();
            this.isCater = in.readInt();
            this.umoney = in.readInt();
            this.alipayno = in.readString();
            this.phone = in.readString();
            this.etime = in.readString();
            this.storeImg = in.readString();
            this.storeTypName = in.readString();
            this.idcardFront = in.readString();
            this.status = in.readInt();
            this.wechatno = in.readString();
        }

        public static final Creator<AppUserListBean> CREATOR = new Creator<AppUserListBean>() {
            @Override
            public AppUserListBean createFromParcel(Parcel source) {
                return new AppUserListBean( source );
            }

            @Override
            public AppUserListBean[] newArray(int size) {
                return new AppUserListBean[size];
            }
        };
    }

    /**
     *
     */
    public static class ShufflingInfoListBean implements Parcelable {

        /**
         * imgUrl : http://129.28.62.84/seal/1.png
         * ctime : 2020-03-27 12:12:12
         * id : 1
         * status : 1
         */

        private String imgUrl;
        private String ctime;
        private String id;
        private int status;

        public static ShufflingInfoListBean objectFromData(String str) {

            return new Gson().fromJson( str, ShufflingInfoListBean.class );
        }

        public String getImgUrl() {
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
            dest.writeString( this.imgUrl );
            dest.writeString( this.ctime );
            dest.writeString( this.id );
            dest.writeInt( this.status );
        }

        public ShufflingInfoListBean() {
        }

        protected ShufflingInfoListBean(Parcel in) {
            this.imgUrl = in.readString();
            this.ctime = in.readString();
            this.id = in.readString();
            this.status = in.readInt();
        }

        public static final Creator<ShufflingInfoListBean> CREATOR = new Creator<ShufflingInfoListBean>() {
            @Override
            public ShufflingInfoListBean createFromParcel(Parcel source) {
                return new ShufflingInfoListBean( source );
            }

            @Override
            public ShufflingInfoListBean[] newArray(int size) {
                return new ShufflingInfoListBean[size];
            }
        };
    }

    public static class ShopInfoListBean implements Parcelable {

        /**
         * isSort : 2
         * threeTypeId :
         * firstTypeId : 1
         * secondeTypeId :
         * imgUrls : http://129.28.62.84/seal/2.png,http://129.28.62.84/seal/2.png,http://129.28.62.84/seal/2.png
         * sortTime :
         * shopName : 商品名称商品名称商品名称商品名称
         * sellPrice : 15
         * saleNum : 100
         * type : 1
         * userid :
         * isBurst : 1
         * detilas : http://129.28.62.84/seal/s1.png
         * isUp : 1
         * stockNum : 100000
         * vipPrice : 14
         * ctime : 2020-03-26 12:12:41
         * shopImg : http://129.28.62.84/seal/2.png
         * isSend : 1
         * shareUrl :
         * id : 5
         * realPrice : 18
         * status : 1
         */

        private int isSort;
        private String threeTypeId;
        private String firstTypeId;
        private String secondeTypeId;
        private String imgUrls;
        private String sortTime;
        private String shopName;
        private int sellPrice;
        private int saleNum;
        private int type;
        private String userid;
        private int isBurst;
        private String detilas;
        private int isUp;
        private int stockNum;
        private int vipPrice;
        private String ctime;
        private String shopImg;
        private int isSend;
        private String shareUrl;
        private String id;
        private int realPrice;
        private int status;

        public static ShopInfoListBean objectFromData(String str) {

            return new Gson().fromJson( str, ShopInfoListBean.class );
        }

        public int getIsSort() {
            return isSort;
        }

        public void setIsSort(int isSort) {
            this.isSort = isSort;
        }

        public String getThreeTypeId() {
            return threeTypeId;
        }

        public void setThreeTypeId(String threeTypeId) {
            this.threeTypeId = threeTypeId;
        }

        public String getFirstTypeId() {
            return firstTypeId;
        }

        public void setFirstTypeId(String firstTypeId) {
            this.firstTypeId = firstTypeId;
        }

        public String getSecondeTypeId() {
            return secondeTypeId;
        }

        public void setSecondeTypeId(String secondeTypeId) {
            this.secondeTypeId = secondeTypeId;
        }

        public String getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }

        public String getSortTime() {
            return sortTime;
        }

        public void setSortTime(String sortTime) {
            this.sortTime = sortTime;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public int getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(int sellPrice) {
            this.sellPrice = sellPrice;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public int getIsBurst() {
            return isBurst;
        }

        public void setIsBurst(int isBurst) {
            this.isBurst = isBurst;
        }

        public String getDetilas() {
            return detilas;
        }

        public void setDetilas(String detilas) {
            this.detilas = detilas;
        }

        public int getIsUp() {
            return isUp;
        }

        public void setIsUp(int isUp) {
            this.isUp = isUp;
        }

        public int getStockNum() {
            return stockNum;
        }

        public void setStockNum(int stockNum) {
            this.stockNum = stockNum;
        }

        public int getVipPrice() {
            return vipPrice;
        }

        public void setVipPrice(int vipPrice) {
            this.vipPrice = vipPrice;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getShopImg() {
            return shopImg;
        }

        public void setShopImg(String shopImg) {
            this.shopImg = shopImg;
        }

        public int getIsSend() {
            return isSend;
        }

        public void setIsSend(int isSend) {
            this.isSend = isSend;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getRealPrice() {
            return realPrice;
        }

        public void setRealPrice(int realPrice) {
            this.realPrice = realPrice;
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
            dest.writeInt( this.isSort );
            dest.writeString( this.threeTypeId );
            dest.writeString( this.firstTypeId );
            dest.writeString( this.secondeTypeId );
            dest.writeString( this.imgUrls );
            dest.writeString( this.sortTime );
            dest.writeString( this.shopName );
            dest.writeInt( this.sellPrice );
            dest.writeInt( this.saleNum );
            dest.writeInt( this.type );
            dest.writeString( this.userid );
            dest.writeInt( this.isBurst );
            dest.writeString( this.detilas );
            dest.writeInt( this.isUp );
            dest.writeInt( this.stockNum );
            dest.writeInt( this.vipPrice );
            dest.writeString( this.ctime );
            dest.writeString( this.shopImg );
            dest.writeInt( this.isSend );
            dest.writeString( this.shareUrl );
            dest.writeString( this.id );
            dest.writeInt( this.realPrice );
            dest.writeInt( this.status );
        }

        public ShopInfoListBean() {
        }

        protected ShopInfoListBean(Parcel in) {
            this.isSort = in.readInt();
            this.threeTypeId = in.readString();
            this.firstTypeId = in.readString();
            this.secondeTypeId = in.readString();
            this.imgUrls = in.readString();
            this.sortTime = in.readString();
            this.shopName = in.readString();
            this.sellPrice = in.readInt();
            this.saleNum = in.readInt();
            this.type = in.readInt();
            this.userid = in.readString();
            this.isBurst = in.readInt();
            this.detilas = in.readString();
            this.isUp = in.readInt();
            this.stockNum = in.readInt();
            this.vipPrice = in.readInt();
            this.ctime = in.readString();
            this.shopImg = in.readString();
            this.isSend = in.readInt();
            this.shareUrl = in.readString();
            this.id = in.readString();
            this.realPrice = in.readInt();
            this.status = in.readInt();
        }

        public static final Creator<ShopInfoListBean> CREATOR = new Creator<ShopInfoListBean>() {
            @Override
            public ShopInfoListBean createFromParcel(Parcel source) {
                return new ShopInfoListBean( source );
            }

            @Override
            public ShopInfoListBean[] newArray(int size) {
                return new ShopInfoListBean[size];
            }
        };
    }

    public static class ShopTypeListBean implements Parcelable {

        /**
         * img : http://129.28.62.84/seal/t1.png
         * name : 新鲜水果
         * ctime : 2020-02-27 12:12:12
         * pid :
         * id : 1
         * type : 1
         * status : 1
         */

        private String img;
        private String name;
        private String ctime;
        private String pid;
        private String id;
        private int type;
        private int status;
        private boolean isClick=false;

        public boolean isClick() {
            return isClick;
        }

        public void setClick(boolean click) {
            isClick = click;
        }

        public static ShopTypeListBean objectFromData(String str) {

            return new Gson().fromJson( str, ShopTypeListBean.class );
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

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
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
            dest.writeString( this.img );
            dest.writeString( this.name );
            dest.writeString( this.ctime );
            dest.writeString( this.pid );
            dest.writeString( this.id );
            dest.writeInt( this.type );
            dest.writeInt( this.status );
        }

        public ShopTypeListBean() {
        }

        protected ShopTypeListBean(Parcel in) {
            this.img = in.readString();
            this.name = in.readString();
            this.ctime = in.readString();
            this.pid = in.readString();
            this.id = in.readString();
            this.type = in.readInt();
            this.status = in.readInt();
        }

        public static final Creator<ShopTypeListBean> CREATOR = new Creator<ShopTypeListBean>() {
            @Override
            public ShopTypeListBean createFromParcel(Parcel source) {
                return new ShopTypeListBean( source );
            }

            @Override
            public ShopTypeListBean[] newArray(int size) {
                return new ShopTypeListBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList( this.marketingUserList );
        dest.writeList( this.wordsInfoList );
        dest.writeList( this.appUserList );
        dest.writeList( this.shufflingInfoList );
        dest.writeList( this.shopInfoList );
        dest.writeList( this.shopTypeList );
    }

    public HomeData() {
    }

    protected HomeData(Parcel in) {
        this.marketingUserList = new ArrayList<MarketingUserListBean>();
        in.readList( this.marketingUserList, MarketingUserListBean.class.getClassLoader() );
        this.wordsInfoList = new ArrayList<WordsInfoListBean>();
        in.readList( this.wordsInfoList, WordsInfoListBean.class.getClassLoader() );
        this.appUserList = new ArrayList<AppUserListBean>();
        in.readList( this.appUserList, AppUserListBean.class.getClassLoader() );
        this.shufflingInfoList = new ArrayList<ShufflingInfoListBean>();
        in.readList( this.shufflingInfoList, ShufflingInfoListBean.class.getClassLoader() );
        this.shopInfoList = new ArrayList<ShopInfoListBean>();
        in.readList( this.shopInfoList, ShopInfoListBean.class.getClassLoader() );
        this.shopTypeList = new ArrayList<ShopTypeListBean>();
        in.readList( this.shopTypeList, ShopTypeListBean.class.getClassLoader() );
    }

    public static final Parcelable.Creator<HomeData> CREATOR = new Parcelable.Creator<HomeData>() {
        @Override
        public HomeData createFromParcel(Parcel source) {
            return new HomeData( source );
        }

        @Override
        public HomeData[] newArray(int size) {
            return new HomeData[size];
        }
    };
}
