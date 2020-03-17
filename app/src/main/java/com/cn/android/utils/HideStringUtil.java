package com.cn.android.utils;

public class HideStringUtil {
    /**
     *
     * 方法描述 隐藏银行卡号中间的字符串（使用*号），显示前四后四
     *
     * @param cardNo
     * @return
     *
     * @author yaomy
     * @date 2018年4月3日 上午10:37:00
     */
    public static String hideCardNo(String cardNo) {
        if(cardNo.length()<=8){
            return cardNo;
        }
        int length = cardNo.length();
        int beforeLength = 4;
        int afterLength = 4;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        hideString(cardNo, length, beforeLength, afterLength, replaceSymbol, sb);

        return sb.toString();
    }
    /**
     *
     * 方法描述 隐藏手机号中间位置字符，显示前三后三个字符
     *
     * @param phoneNo
     * @return
     *
     * @author yaomy
     * @date 2018年4月3日 上午10:38:51
     */
    public static String hidePhoneNo(String phoneNo) {
        if(phoneNo.length()<=6){
            return phoneNo;
        }
        int length = phoneNo.length();
        int beforeLength = 3;
        int afterLength = 3;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        hideString(phoneNo, length, beforeLength, afterLength, replaceSymbol, sb);

        return sb.toString();
    }
    public static String hideName(String name) {
        if(name.length()<=1){
            return name;
        }
        int length = name.length();
        int beforeLength = 1;
        int afterLength = 0;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        hideString(name, length, beforeLength, afterLength, replaceSymbol, sb);

        return sb.toString();
    }
    public static String hideAll(String string) {
        int length = string.length();
        int beforeLength = 0;
        int afterLength = 0;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        hideString(string, length, beforeLength, afterLength, replaceSymbol, sb);

        return sb.toString();
    }

    private static void hideString(String phoneNo, int length, int beforeLength, int afterLength, String replaceSymbol, StringBuffer sb) {
        for (int i = 0; i < length; i++) {
            if (i < beforeLength || i >= (length - afterLength)) {
                sb.append(phoneNo.charAt(i));
            } else {
                sb.append(replaceSymbol);
            }
        }
    }
}
