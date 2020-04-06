package com.cn.android.utils;

import java.text.DecimalFormat;

public class TextUtils {
    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
         * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        String telRegex = "[1][34578]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else {
            return mobiles.matches(telRegex);
        }
    }

    /**
     * 判断是否是银行卡号
     *
     * @param cardId
     * @return
     */

    public static boolean checkBankCard(String cardId) {
        if (cardId == null || cardId.equals("")) {
            return false;
        }
        char bit = getBankCardCheckCode(cardId
                .substring(0, cardId.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    private static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null
                || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            // 如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    public static String getNumWithTwo(String formBat, String num) {
        String str = "";
        try {
            DecimalFormat myformat = new DecimalFormat(formBat);
            str = myformat.format(num);
        } catch (Exception e) {
            return "";
        }
        return str;
    }

    /**
     * 是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (null == s)
            return true;
        if (s.length() == 0)
            return true;
        if (s.trim().length() == 0)
            return true;
        return s.equals("null");
    }

    /**
     * 是否为数字
     *
     * @param str
     * @return
     */
    /*public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }*/

    /**
     * String转Integer
     */
    public static Integer toInteger(String str) {
        if (isEmpty(str) || !isNumeric(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    /**
     * String转Double
     */
    public static Double toDouble(String str) {
        if (isEmpty(str)) {
            return 0.0;
        }
        return Double.parseDouble(str);
    }

    /**
     * 使用java自带的判断方法来判断string字符串中的内容是否是数字
     * @param str 字符串
     * @return 是否成立
     */
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 提取汉字的首字母，如果里面含有费中文字符则忽略之；如果全为非中文则返回""。
     *
     * @param caseType 当为1时获取的首字母为小写，否则为大写。
     */
    /*public static String getPinYinHeadChar(String zn_str, int caseType) {
        if (zn_str != null && !zn_str.trim().equalsIgnoreCase("")) {
            char[] strChar = zn_str.toCharArray();
            // 汉语拼音格式输出类
            HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();
            // 输出设置，大小写，音标方式等
            if (1 == caseType) {
                hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            } else {
                hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
            }
            hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            hanYuPinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
            StringBuffer pyStringBuffer = new StringBuffer();
            char c = strChar[0];
            char pyc;
            if (String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")) {//是中文或者a-z或者A-Z转换拼音
                try {
                    String[] pyStirngArray = PinyinHelper.toHanyuPinyinStringArray(strChar[0], hanYuPinOutputFormat);
                    if (null != pyStirngArray && pyStirngArray[0] != null) {
                        pyc = pyStirngArray[0].charAt(0);
                        pyStringBuffer.append(pyc);
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            }
            return pyStringBuffer.toString();
        }
        return null;
    }*/

    /**
     * app转换用户名字为X**X格式的方法
     * @return
     */
    public static String conversionName(String name) {
        if (isEmpty(name)) {
            return "";
        }
        if (name.length() == 1) {
            return name + "**";
        }
        if (name.length() == 2) {
            return name.charAt(0) + "**" + name.charAt(1);
        }
        return name.charAt(0) + "**" + name.charAt(name.length() - 1);
    }

    /**
     * 价格转换公共方法，价格每隔三位加上一个逗号
     * @param money
     * @return
     */
    public static String formatToSpare(String money) {
        try {
            if (TextUtils.isEmpty(money)) money = "0";
            float value = Float.parseFloat(money);
            DecimalFormat df = new DecimalFormat("#,###");
            return df.format(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return money;
    }
}
