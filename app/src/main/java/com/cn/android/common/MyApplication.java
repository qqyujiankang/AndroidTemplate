package com.cn.android.common;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;
import com.cn.android.BuildConfig;
import com.cn.android.other.EventBusManager;
import com.cn.android.ui.activity.CrashActivity;
import com.cn.android.ui.activity.HomeActivity;
import com.cn.android.utils.L;
import com.cn.android.utils.LocationManager;
import com.cn.android.utils.SPUtils;
import com.hjq.image.ImageLoader;
import com.hjq.toast.ToastInterceptor;
import com.hjq.toast.ToastUtils;
import com.nanchen.crashmanager.UncaughtExceptionHandlerImpl;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;
import com.zhy.http.okhttp.https.HttpsUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import cat.ereza.customactivityoncrash.config.CaocConfig;
import okhttp3.OkHttpClient;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 项目中的 Application 基类
 */
public final class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        initSDK( this );


    }

    /**
     * 初始化一些第三方框架
     */
    public static void initSDK(Application application) {
        // 这个过程专门用于堆分析的 leak 金丝雀
        // 你不应该在这个过程中初始化你的应用程序
//        if (LeakCanary.isInAnalyzerProcess(application)) {
//            return;
//        }
//
//        // 内存泄漏检测
//        LeakCanary.install(application);

        // 设置 Toast 拦截器
        ToastUtils.setToastInterceptor( new ToastInterceptor() {
            @Override
            public boolean intercept(Toast toast, CharSequence text) {
                boolean intercept = super.intercept( toast, text );
                if (intercept) {
                    Log.e( "Toast", "空 Toast" );
                } else {
                    Log.i( "Toast", text.toString() );
                }
                return intercept;
            }
        } );
        // 吐司工具类
        ToastUtils.init( application );

        // 图片加载器
        ImageLoader.init( application );

        // EventBus 事件总线
        EventBusManager.init();

        // Bugly 异常捕捉
        CrashReport.initCrashReport( application, BuildConfig.BUGLY_ID, false );

        // Crash 捕捉界面
        CaocConfig.Builder.create()
                .backgroundMode( CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM )
                .enabled( true )
                .trackActivities( true )
                .minTimeBetweenCrashesMs( 2000 )
                // 重启的 Activity
                .restartActivity( HomeActivity.class )
                // 错误的 Activity
                .errorActivity( CrashActivity.class )
                // 设置监听器
                //.eventListener(new YourCustomEventListener())
                .apply();
        SPUtils.init( application );
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory( null,
                null, null );
        CookieJarImpl cookieJar = new CookieJarImpl( new PersistentCookieStore( application ) );
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar( cookieJar )
                .connectTimeout( 10000L, TimeUnit.MILLISECONDS )
                .readTimeout( 10000L, TimeUnit.MILLISECONDS )
                .addInterceptor( new LoggerInterceptor( "HTTPS", true ) )
                .hostnameVerifier( new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                } )
                .sslSocketFactory( sslParams.sSLSocketFactory,
                        sslParams.trustManager ).build();
        OkHttpUtils.initClient( client );
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo( false )  // (Optional) Whether to show thread info or not. Default true
                .methodCount( 0 )         // (Optional) How many method line to show. Default 2
                .methodOffset( 7 )        // (Optional) Hides internal method calls up to offset. Default 5
                .tag( "Https" )   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter( new AndroidLogAdapter( formatStrategy ) );
        L.init( true );
        // 设置崩溃后自动重启 APP
        // 参数依次为 上下文（建议是Application），是否是debug模式，是否崩溃后重启，重启延迟时间，重启的Activity
//        UncaughtExceptionHandlerImpl.getInstance().init(application, BuildConfig.DEBUG, true, 0, HomeActivity.class);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext( base );
        // 使用 Dex分包
//        MultiDex.install(this);
    }



}