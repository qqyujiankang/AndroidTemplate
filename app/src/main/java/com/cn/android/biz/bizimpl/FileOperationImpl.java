package com.cn.android.biz.bizimpl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Environment;

import com.cn.android.biz.FileOperationBiz;
import com.cn.android.network.GetJsonDate;
import com.cn.android.utils.L;
import com.google.gson.Gson;
import com.hjq.toast.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by desk 3-2 on 2018/5/23.
 */

public class FileOperationImpl implements FileOperationBiz {

    @Override
    public void uploadSingleFileRequest(Activity context, String fileKey, File file, String url, final OnFileListener requestListener) {
        L.e( "Https", "Post fileKey = " + fileKey + "============" + fileKey );
        L.e( "Https", "Post params = " + file.getName() );
        L.e( "Https", "Post url = " + url );

        OkHttpUtils
                .post()
                .url( url )
                .tag( context )
                .addFile( fileKey, file.getName(), file )
                .build()
                .execute( new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        L.e( "Https", "Post onError = " + e );
                        requestListener.onFileError( e.toString() );
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        L.e( "Https", "Post onResponse = " + s );
                        SuccessfulTreatment( s, requestListener, context );
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress( progress, total, id );
                        L.e( "Https", "Post progress = " + progress );
                        requestListener.onFileProgress( progress );
                    }
                } );
    }

    @Override
    public void uploadMultipleFileRequest(Activity context, String fileKey, Map<String, File> paramsMap, String url, final OnFileListener requestListener) {
        L.e( "Https", "Post fileKey = " + fileKey );
        L.e( "Https", "Post params = " + new Gson().toJson( paramsMap ) );
        OkHttpUtils
                .post()
                .tag( context )
                .url( url )
                .files( fileKey, paramsMap )
                .build()
                .execute( new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        requestListener.onFileError( e.toString() );
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        L.e( "Https", "Post onResponse = *************" + s );
                        SuccessfulTreatment( s, requestListener, context );
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress( progress, total, id );
                        requestListener.onFileProgress( progress );
                    }
                } );
    }

    @Override
    public void downloadFileRequest(Activity context, String fileName, String url, final OnFileListener requestListener) {
        OkHttpUtils
                .get()
                .tag( context )
                .url( url )
                .build()
                .execute( new FileCallBack( Environment.getExternalStorageDirectory().getAbsolutePath(), fileName ) {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        requestListener.onFileError( e.toString() );
                    }

                    @Override
                    public void onResponse(File file, int id) {
                        requestListener.onFileSuccess( file );
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress( progress, total, id );
                        requestListener.onFileProgress( progress );
                    }
                } );
    }

    @Override
    public void getImageRequest(Activity context, String url, final OnFileListener requestListener) {
        OkHttpUtils
                .get()
                .url( url )
                .tag( this )
                .build()
                .connTimeOut( 20000 )
                .readTimeOut( 20000 )
                .writeTimeOut( 20000 )
                .execute( new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        requestListener.onFileError( e.toString() );
                    }

                    @Override
                    public void onResponse(Bitmap bitmap, int id) {
                        requestListener.onFileSuccess( bitmap );
                    }
                } );
    }

    /**
     * 处理成功返回
     */
    private void SuccessfulTreatment(String s, OnFileListener requestListener, Activity context) {
        int code = new GetJsonDate().getJsonCode( s );
        switch (code) {
            case 200:
                requestListener.onFileSuccess( new GetJsonDate().getJsonData( s ) );
                break;
        }
    }

}
