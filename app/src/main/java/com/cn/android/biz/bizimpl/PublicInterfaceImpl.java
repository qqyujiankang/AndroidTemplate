package com.cn.android.biz.bizimpl;

import android.app.Activity;

import com.cn.android.biz.PublicInterfaceBiz;
import com.cn.android.utils.L;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;

/**
 * Created by desk 3-2 on 2018/5/23.
 */

public class PublicInterfaceImpl implements PublicInterfaceBiz {

    @Override
    public void publicPostStringRequest(Activity context, Map<String, Object> paramsMap, String url, final OnRequestListener requestListener) {
        L.e("Https","PostString url = "+url);
        L.e("Https","PostString paramsMap = "+new Gson().toJson(paramsMap).replace("\\",""));
        OkHttpUtils.postString().url(url)
                .content(new Gson().toJson(paramsMap).replace("\\",""))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .tag(context)
                .build()
                .execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                requestListener.onRequesError(new Gson().toJson(e));
                L.e("Https","onError = "+e.toString());
            }

            @Override
            public void onResponse(String s, int i) {
                SuccessfulTreatment(s, requestListener, context);
                L.e("Https","Successful = "+s);
            }
        });
    }

    @Override
    public void publicPostRequest(Activity context, Map<String, Object> paramsMap, String url, final OnRequestListener requestListener) {
        Map<String, String> params=new HashMap<>();
        L.e("Https","Post url = "+url);
        if(null!=paramsMap){
            for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                params.put(entry.getKey(),entry.getValue().toString());
            }
        }else{
            paramsMap=new HashMap<>();
        }
        L.e("Https","Post params = "+new Gson().toJson(params));
        OkHttpUtils.post().url(url)
                .addHeader("Authorization","865977555")
                .params(params)
                .tag(context)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                requestListener.onRequesError(new Gson().toJson(e));
                L.e("Https","onError = "+e.toString());
            }

            @Override
            public void onResponse(String s, int i) {
                SuccessfulTreatment(s, requestListener, context);
                L.e("Https","Successful = "+s);
            }
        });
    }

    @Override
    public void publicGetRequest(Activity context, Map<String, Object> paramsMap, String url, final OnRequestListener requestListener) {
        Map<String, String> params=new HashMap<>();
        L.e("Https","Get url = "+url);
        if(null!=paramsMap){
            for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                params.put(entry.getKey(),entry.getValue().toString());
            }
        }else{
            paramsMap=new HashMap<>();
        }
        L.e("Https","Get params = "+new Gson().toJson(params));
        OkHttpUtils.get()
                .url(url)
                .params(params)
                .tag(context)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        requestListener.onRequesError(e.toString());
                        L.e("Https","onError = "+e.toString());
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        SuccessfulTreatment(s, requestListener, context);
                        L.e("Https","Successful = "+s);
                    }
                });
    }


    /**
     * 处理成功返回
     */
    private void SuccessfulTreatment(String s, OnRequestListener requestListener,Activity context) {
//        int code = new GetJsonDate().getJsonCode(s);
//        switch (code) {
//            case 200:
                requestListener.onRequesSuccess(s);
//                requestListener.onRequesSuccess(new GetJsonDate().getJsonData(s));
//                break;
//                default:
//                    requestListener.onRequesError(new GetJsonDate().getJsonMsg(s));
//                    break;
//        }
    }
}
