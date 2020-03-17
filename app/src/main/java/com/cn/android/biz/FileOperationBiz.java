package com.cn.android.biz;

import android.app.Activity;
import android.content.Context;

import java.io.File;
import java.util.Map;

/**
 * Created by desk 3-2 on 2018/5/23.
 */

public interface FileOperationBiz {
    void uploadSingleFileRequest(Activity context, String fileKey, File file, String url, OnFileListener requestListener);

    void uploadMultipleFileRequest(Activity context, String fileKey, Map<String, File> paramsMap, String url, OnFileListener requestListener);

    void downloadFileRequest(Activity context, String fileName, String url, OnFileListener requestListener);

    void getImageRequest(Activity context, String url, OnFileListener requestListener);

    interface OnFileListener {
        void onFileProgress(float progress);

        /**
         * uploadFile   return  String
         * downloadFile return  file
         * getImage     return  bitmap
         */
        void onFileSuccess(Object data);

        void onFileError(String error);
    }
}
