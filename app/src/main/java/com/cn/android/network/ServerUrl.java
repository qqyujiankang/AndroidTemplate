package com.cn.android.network;

import com.cn.android.bean.Userdata;
import com.cn.android.utils.SPUtils;

/**
 * Created by PC-122 on 2017/12/21.
 */
public class ServerUrl {
    public static String defaultIp = "http://192.168.0.119:8077";
    //  public static String defaultIp = "http://118.24.159.31:80";

    public static String LOGIN_API = defaultIp + "/app/login/";
    public static String User_API = defaultIp + "/app/user/";
    public static String address = defaultIp + "/app/address/";


    public String useIp = "http://192.168.100.190:8080";
    public boolean s = SPUtils.getBoolean( "isS", false );
    public String ip = s ? useIp : defaultIp;
    public String agentIp = ip;

    //和user用户有关URL
    public String API = agentIp + "/btlcommon/UserCompMapping/";
    public static String getHtml = "http://www.391k.com/api/xapi.ashx/info.json";
    public static String getPost = "http://192.168.0.111:8012/app/photo/addAlbum";
    public static String uploadFile = "http://47.105.171.135:3000/upload/";
    public static String downloadFile = "http://p.gdown.baidu.com/67327e8c8685bca04ccdd877dea57de6d44a01c4b3dedcf2a3e14a80da15b6c5633bfee4dafdbfc9a23b0541b9c595fabff514f4f95de457c2d85bcf9c73b5f4fdce21e0a06cd1829cfe52a561251e8dd2cda14c3089995a37860ab1619402fe3e143b38212ed7ae6f73caf02cf2b7eb494c21cce868c5abbf05fce5593b27fcdeecc405ba08a97ec964642314f444ff96c586125818c11dd0ef497961b1c8fd24aa654001e8ce1b7da5d826ad0aa21f3651f5e0abd6be3f1538926fee90cd002550638cf98ad3fe3b05ecc7f9fa138fce273455fa5877c35a225c555a91eaa5ce69af76bc1f38d31220c93f73ecd73854cae34f9a1fc070bae0bcdcea929b9e2dc5a65113bc2c41";
    public static String getImage = "http://images.csdn.net/20150817/1.jpg";

    /**
     * 发送短信
     */
    public static String sendSms = LOGIN_API + "sendSms";
    //注册
    public static String register = LOGIN_API + "register";
    //登录
    public static String login = LOGIN_API + "login";
    //修改头像
    public static String updateHeadImg = User_API + "updateHeadImg";
    //绑定支付宝//绑定微信/支付宝
    public static String updateAccount = User_API + "updateAccount";
    //修改手机号
    public static String updatePhone = User_API + "updatePhone";
    // 修改昵称
    public static String updateNickname = User_API + "updateNickname";
    //    上传图片
    public static String upload = User_API + "upload";
    //    修改性别
    public static String updateSex = User_API + "updateSex";
    //添加地址
    public static String addAddress = address + "addAddress";
    //地址编辑用户
    public static String updateAddress = address + "updateAddress";
    //我的地址列表
    public static String selectAddressByUserid = address + "selectAddressByUserid";
    //删除用户地址
    public static String deleteAddress = address + "deleteAddress";
    //优惠券列表
    public static String selectConpostByUserid = defaultIp + "/app/user/selectConpostByUserid";
    //交易明细列表
    public static String selectAccountByUserid = defaultIp + "/app/user/selectAccountByUserid";
    //意见反馈
    public static String addFeedBack = defaultIp + "/app/user/addFeedBack";
    //    提现
    public static String addAccountByUserid = defaultIp + "/app/user/addAccountByUserid";
    //    企业入驻
    public static String realAppUser = defaultIp + "/app/user/realAppUser";
    //首页
    public static String selectHome = defaultIp + "/app/home/selectHome";
    //    首页  最新商品/附近商品
    public static String selectNewShopList = defaultIp + "/app/home/selectNewShopList";
    //一级分类
    public static String selectFristTypeList = defaultIp + "/app/home/selectFristTypeList";
    //    一级分类id查询二、三级的分类
    public static String selectTypeListByPid = defaultIp + "/app/home/selectTypeListByPid";
    //    修改店铺
    public static String updateStore = defaultIp + "/app/user/updateStore";
    //    企业首页  文章详情
    public static String selectWordsById = defaultIp + "/app/home/selectWordsById";
    //    企业首页  营销师详情
    public static String selectMarketingUserById = defaultIp + "/app/home/selectMarketingUserById";
    //分类下的商品列表
    public static String selectShopListByShopType = defaultIp + "/app/home/selectShopListByShopType";
    //    商品管理
    public static String selectShopsByUserid = defaultIp + "/app/shop/selectShopsByUserid";
    //企业 商品自荐/店铺每日爆品/店铺商品
    public static String selectShopListByUserid = defaultIp + "/app/shop/selectShopListByUserid";
    //    企业 商品管理-删除
    public static String deleteShopByUserid = defaultIp + "/app/shop/deleteShopByUserid";
    //      我的团队
    public static String selecttTeamByUserid = defaultIp + "/app/user/selecttTeamByUserid";
    //    我的收藏
    public static String selectConlectShopsByUserid = defaultIp + "/app/shop/selectConlectShopsByUserid";
    //    收藏/取消收藏
    public static String sureConlectShopsByUserid = defaultIp + "/app/shop/sureConlectShopsByUserid";
    //    评价
    public static String addShopEva = defaultIp + "/app/order/addShopEva";
    //    我的订单  状态  1待付款 2代发货 3已发货 4已完成 5已评价
    public static String selectOrderListByStatus = defaultIp + "/app/order/selectOrderListByStatus";
    //    企业 商品管理-上架/下架
    public static String upShopByUserid = defaultIp + "/app/shop/upShopByUserid";
    //    企业 自荐商品排序
    public static String sortShopByUserid = defaultIp + "/app/shop/sortShopByUserid";
    //    个人信息
    public static String selectAppUserByUserid = defaultIp + "/app/user/selectAppUserByUserid";
    //    确认发货
    public static String sureSendOrder = defaultIp + "/app/order/sureSendOrder";
    //确认收货
    public static String surePickOrder = defaultIp + "/app/order/surePickOrder";
    //    我卖出的
    public static String selectOrdersByStatus = defaultIp + "/app/order/selectOrdersByStatus";
    //    搜索
    public static String selectShopListBySearch = defaultIp + "/app/home/selectShopListBySearch";
    //    企业 商品管理-添加
    public static String saveShopByUserid = defaultIp + "/app/shop/saveShopByUserid";
    //一级分类id查询所有店铺
    public static String selectStoreListByPid = defaultIp + "/app/home/selectStoreListByPid";
    //    商品详情
    public static String selectShopByid = defaultIp + "/app/shop/selectShopByid";
    //    企业 商品管理-编辑详情
    public static String selectShopByID = defaultIp + "/app/shop/selectShopByID";
    //企业 商品管理-编辑
    public static String updateShopByUserid = defaultIp + "/app/shop/updateShopByUserid";
    //    商品详情规格
    public static String addOrderShop = defaultIp + "/app/shop/addOrderShop";
    //    购物车列表
    public static String selectOrderShopsByUserid = defaultIp + "/app/shop/selectOrderShopsByUserid";
    //  购物车==改变数量
    public static String updateOrderShopNum = defaultIp + "/app/shop/updateOrderShopNum";
    //购物车==删除
    public static String deleteOrderShop = defaultIp + "/app/shop/deleteOrderShop";
    //购物车==清空购物车
    public static String deleteAllOrderShop = defaultIp + "/app/shop/deleteAllOrderShop";
    //立即购买
    public static String buyOrderShop = defaultIp + "/app/shop/buyOrderShop";
    //购物车结算
    public static String sureOrderShop = defaultIp + "/app/shop/sureOrderShop";
    //    我的消息
    public static String selectMessgeList = defaultIp + "/app/user/selectMessgeList";
    //    生成邀请码
    public static String selectPoster = defaultIp + "/app/user/selectPoster";


}
