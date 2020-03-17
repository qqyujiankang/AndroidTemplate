package com.cn.android.presenter.view;

/**
 * Created by desk 3-2 on 2018/5/23.
 */

public interface FileOperationView {
    void FileOperationSuccess(Object data, final int tag);
    void FileOperationProgress(float progress, final int tag);
    void FileOperationError(String error, final int tag);
}
