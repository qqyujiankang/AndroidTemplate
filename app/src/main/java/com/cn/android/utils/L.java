package com.cn.android.utils;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

public class L {
    //默认的TAG，建议后面加下划线
    private static final String DEFAULT_TAG = "TAG";
    /**
     * 注意：打包的时候记得设置isDebug为false
     */
    public static boolean isDebug = true;

    public static void init(boolean debug) {
        isDebug = debug;
    }

    public static void e(String msg) {
        if (isDebug) {
            e(DEFAULT_TAG,msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Logger.t(tag).e(msg);
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            d(DEFAULT_TAG,msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Logger.t(tag).d(msg);
        }
    }

    public static void i(String msg) {
        if (isDebug) {
            i(DEFAULT_TAG,msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Logger.t(tag).i(msg);
        }
    }

    public static void v(String msg) {
        if (isDebug) {
            v(DEFAULT_TAG,msg);
        }
    }

    public static void v(String tag, String msg) {
        if (isDebug) {
            Logger.t(tag).v(msg);
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            w(DEFAULT_TAG,msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Logger.t(tag).w(msg);
        }
    }

    public static void json(Object json) {
        if (isDebug) {
            json(DEFAULT_TAG,json);
        }
    }
    public static void json(String tag,Object json) {
        if (isDebug) {
            Logger.t(tag).e(new Gson().toJson(json));
        }
    }

    public static void xml(String xml) {
        if (isDebug) {
            xml(xml);
        }
    }
    public static void xml(String tag,String xml) {
        if (isDebug) {
            Logger.t(tag).xml(xml);
        }
    }

    public static void wtf(String wtf) {
        if (isDebug) {
            Logger.wtf(wtf);
        }
    }
}
