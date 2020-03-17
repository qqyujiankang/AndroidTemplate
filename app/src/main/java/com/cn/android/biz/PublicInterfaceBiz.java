package com.cn.android.biz;

import android.app.Activity;
import android.content.Context;

import java.util.Map;

/**
 * Created by desk 3-2 on 2018/5/23.
 */

public interface PublicInterfaceBiz {
    void publicPostStringRequest(Activity context, Map<String, Object> paramsMap, String url, OnRequestListener requestListener);
    void publicPostRequest(Activity context, Map<String, Object> paramsMap, String url, OnRequestListener requestListener);
    void publicGetRequest(Activity context, Map<String, Object> paramsMap, String url, OnRequestListener requestListener);

    interface OnRequestListener {
        void onRequesSuccess(String data);

        void onRequesError(String error);
    }
}
