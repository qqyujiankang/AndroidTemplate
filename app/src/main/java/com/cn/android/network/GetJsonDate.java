package com.cn.android.network;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fjw on 2018/1/19.
 */

public class GetJsonDate {

    public static int getJsonCode(String jsonData) {
        int code=0;
        try {
            JSONObject obj = new JSONObject(jsonData);
            code = obj.optInt("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return code;
    }
    public static String getJsonData(String jsonData) {
         String data="";
        try {
            JSONObject obj = new JSONObject(jsonData);
            data = obj.optString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static String getJsonMsg(String jsonData) {
        String data="";
        try {
            JSONObject obj = new JSONObject(jsonData);
            data = obj.optString("msg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static String getJsonRows(String jsonData) {
        String data="";
        try {
            JSONObject rows = new JSONObject(jsonData);
            data=rows.getString("rows");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static int getJsonTotal(String jsonData) {
         int total=0;
        try {
            JSONObject rows = new JSONObject(jsonData);
            total=rows.getInt("total");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return total;
    }
    public static String getJsonRes(String jsonData) {
        String data="";
        try {
            JSONObject obj = new JSONObject(jsonData);
            data=obj.optString("res");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static String getJsonVehicle(String jsonData) {
        String data="";
        try {
            JSONObject obj = new JSONObject(jsonData);
            data=obj.optString("idletruck");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static String getJsonDriver(String jsonData) {
        String data="";
        try {
            JSONObject obj = new JSONObject(jsonData);
            data=obj.optString("alldriver");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static String getJsonDriveq(String jsonData,String s) {
        String data="";
        try {
            JSONObject obj = new JSONObject(jsonData);
            data=obj.optString(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

}
