package com.cn.android.presenter.view;

import java.util.Map;

/**
 * Created by desk 3-2 on 2018/5/23.
 */

public interface PublicInterfaceView {
    Map<String, Object> setPublicInterfaceData(final int tag);

    void onPublicInterfaceSuccess(String data, final int tag);
    void onPublicInterfaceError(String error, final int tag);
}
