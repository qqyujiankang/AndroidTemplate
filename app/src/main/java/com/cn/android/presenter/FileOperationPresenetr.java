package com.cn.android.presenter;


import android.app.Activity;

import com.cn.android.biz.FileOperationBiz;
import com.cn.android.biz.bizimpl.FileOperationImpl;
import com.cn.android.other.StatusManager;
import com.cn.android.presenter.view.FileOperationView;
import com.cn.android.utils.L;
import com.google.gson.Gson;

import java.io.File;
import java.util.Map;


/**
 * Created by desk 3-2 on 2018/5/23.
 */

public class FileOperationPresenetr {
    private FileOperationBiz biz;
    private FileOperationView view;
    private final StatusManager mStatusManager = new StatusManager();

    public FileOperationPresenetr(FileOperationView operationView) {
        this.view = operationView;
        biz = new FileOperationImpl();
    }


    public void uploadSingleFileRequest(Activity context, String fileKey, File file, String url, final int tag) {
        L.e( "Https", "uploadMultipleFile url = " + url );
        L.e( "Https", "uploadMultipleFile paramsMap = " + file.getName() );
        biz.uploadSingleFileRequest( context, fileKey, file, url, new FileOperationBiz.OnFileListener() {
                    @Override
                    public void onFileProgress(float progress) {
                        view.FileOperationProgress( progress, tag );
                    }

                    @Override
                    public void onFileSuccess(Object data) {
                        view.FileOperationSuccess( data, tag );
                    }

                    @Override
                    public void onFileError(String error) {
                        view.FileOperationError( error, tag );
                    }

                }
        );
    }

    public void uploadMultipleFileRequest(Activity context, String fileKey, Map<String, File> paramsMap, String url, final int tag) {
        L.e( "Https", "uploadMultipleFile url = " + url );
        L.e( "Https", "uploadMultipleFile paramsMap = " + new Gson().toJson( paramsMap ) );
        biz.uploadMultipleFileRequest( context, fileKey, paramsMap, url, new FileOperationBiz.OnFileListener() {
                    @Override
                    public void onFileProgress(float progress) {
                        view.FileOperationProgress( progress, tag );
                    }

                    @Override
                    public void onFileSuccess(Object data) {
                        L.e( "Https", "uploadMultipleFile onFileSuccess = " + data.toString() );
                        view.FileOperationSuccess( data, tag );
                    }

                    @Override
                    public void onFileError(String error) {
                        L.e( "Https", "uploadMultipleFile onFileError = " + error );
                        view.FileOperationError( error, tag );
                    }

                }
        );
    }

    public void downloadFileRequest(Activity context, String fileName, String url, final int tag) {
        biz.downloadFileRequest( context, fileName, url, new FileOperationBiz.OnFileListener() {
                    @Override
                    public void onFileProgress(float progress) {
                        view.FileOperationProgress( progress, tag );
                    }

                    @Override
                    public void onFileSuccess(Object data) {
                        view.FileOperationSuccess( data, tag );
                    }

                    @Override
                    public void onFileError(String error) {
                        view.FileOperationError( error, tag );
                    }

                }
        );
    }

    public void getImageRequest(Activity context, String url, final int tag) {
        biz.getImageRequest( context, url, new FileOperationBiz.OnFileListener() {
                    @Override
                    public void onFileProgress(float progress) {
                        view.FileOperationProgress( progress, tag );
                    }

                    @Override
                    public void onFileSuccess(Object data) {
                        view.FileOperationSuccess( data, tag );
                    }

                    @Override
                    public void onFileError(String error) {
                        view.FileOperationError( error, tag );
                    }

                }
        );
    }

}
