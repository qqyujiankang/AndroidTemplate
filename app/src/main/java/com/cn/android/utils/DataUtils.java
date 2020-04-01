package com.cn.android.utils;

import java.text.DecimalFormat;

public class DataUtils {
    /**
     * 获取double数据小数点后两位不进行四舍五入
     *
     * @param value
     * @return -1 , double
     */
    public static String getMoney(double value) {
        DecimalFormat dFormat = new DecimalFormat( "#.0000" );//设置小数点后四位
        String money = dFormat.format( value );
        String frist = money.substring( 0, 1 );
        if (".".equals( frist )) {
            return "0" + money.substring( 0, 3 );
        }
        int index = getIndex( money, '.' );
        if (index == -1) {
            return "0.0";
        }
        return money.substring( 0, index + 3 );
    }

    /**
     * 获取小数点的位数
     *
     * @param str
     * @param ch
     * @return i , -1
     */
    public static int getIndex(String str, char ch) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt( i ) == (char) '.') {
                return i;
            }
        }
        return -1;
    }
}
