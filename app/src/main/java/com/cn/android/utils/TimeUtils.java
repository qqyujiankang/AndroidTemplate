package com.cn.android.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeUtils {

    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String dataToTime(String data) {
        try {
            String format = "";
            SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ" );
            Date d = sdf1.parse( data );
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
            format = sdf.format( d );
            return format;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String TimeTodata(String create_time) {
        try {
            String format = "";
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
            Date d = sdf.parse( create_time );//Mon Mar 06 00:00:00 CST 2017
            SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ" );
            format = sdf1.format( d );//2017-03-06
            return format;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    // 获取当前时间
    public static String getDay() {
        return new SimpleDateFormat( FORMAT ).format( new Date() );
    }

    // 获取当前日零点时间戳
    public static String getDayZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( new Date() );
        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        Date start = calendar.getTime();
        return new SimpleDateFormat( FORMAT ).format( start );
    }

    /**
     * String val = productDetails.getImgUrls();
     * String[] splitVal = val.split( "\\," );//转数组
     * strings = Arrays.asList( splitVal );//转集合
     */
    public static List<String> getStiringlist(String s) {
        List<String>strings= new ArrayList<>(  );
        String val = s;
        String[] splitVal = val.split( "\\," );//转数组
        strings = Arrays.asList( splitVal );//转集合
        return strings;
    }
}
