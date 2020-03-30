package com.cn.android.ui.activity;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cn.android.R;
import com.cn.android.bean.SelectWordsById;
import com.cn.android.common.MyActivity;
import com.cn.android.network.Constant;
import com.cn.android.network.GsonUtils;
import com.cn.android.network.ServerUrl;
import com.cn.android.presenter.PublicInterfaceePresenetr;
import com.cn.android.presenter.view.PublicInterfaceView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 资讯详情
 */
public class NformationForDetailsActivity extends MyActivity implements PublicInterfaceView {


    @BindView(R.id.tvtitle)
    TextView tvtitle;
    @BindView(R.id.tv_ctime)
    TextView tvCtime;
    @BindView(R.id.pb_web_progress)
    ProgressBar pbWebProgress;
    @BindView(R.id.wv_web_view)
    WebView mWebView;
    private PublicInterfaceePresenetr presenetr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nformation_for_details;
    }

    private String id;

    @Override
    protected void initView() {
        id = getIntent().getStringExtra( "id" );
        presenetr = new PublicInterfaceePresenetr( this );


        // 不显示滚动条
        mWebView.setVerticalScrollBarEnabled( false );
        mWebView.setHorizontalScrollBarEnabled( false );

        WebSettings settings = mWebView.getSettings();
        // 允许文件访问
        settings.setAllowFileAccess( true );
        // 允许网页定位
        settings.setGeolocationEnabled( true );
        // 允许保存密码
        settings.setSavePassword( true );
        // 开启 JavaScript
        settings.setJavaScriptEnabled( true );
        // 允许网页弹对话框
        settings.setJavaScriptCanOpenWindowsAutomatically( true );
        // 加快网页加载完成的速度，等页面完成再加载图片
        settings.setLoadsImagesAutomatically( true );
        // 本地 DOM 存储（解决加载某些网页出现白板现象）
        settings.setDomStorageEnabled( true );

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 解决 Android 5.0 上 WebView 默认不允许加载 Http 与 Https 混合内容
            settings.setMixedContentMode( WebSettings.MIXED_CONTENT_ALWAYS_ALLOW );
        }
        settings.setJavaScriptEnabled( true );
        settings.setSupportZoom( true );
        mWebView.getSettings().setLayoutAlgorithm( WebSettings.LayoutAlgorithm.SINGLE_COLUMN );
        mWebView.setWebViewClient( new WebViewClient() );


    }

    @Override
    protected void initData() {
        mWebView.setWebViewClient(new NformationForDetailsActivity.MyWebViewClient());
        mWebView.setWebChromeClient(new NformationForDetailsActivity.MyWebChromeClient());
        presenetr.getPostTokenRequest( getActivity(), ServerUrl.selectWordsById, Constant.selectWordsById );
    }

    @Override
    public Map<String, Object> setPublicInterfaceData(int tag) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put( "id", id );

        return paramsMap;
    }

    SelectWordsById selectWordsById;

    @Override
    public void onPublicInterfaceSuccess(String data, int tag) {
        if (!data.equals( "null" )) {
            selectWordsById = GsonUtils.getPerson( data, SelectWordsById.class );
            tvtitle.setText( selectWordsById.getTitle() );
            tvCtime.setText( selectWordsById.getCtime() );
            mWebView.loadDataWithBaseURL( null, getNewContent( selectWordsById.getContent() ), "text/html", "utf-8", null );

        }
    }


    @Override
    public void onPublicInterfaceError(String error, int tag) {

    }

    private String getNewContent(String htmltext) {
        Document doc = Jsoup.parse( htmltext );
        Elements elements = doc.getElementsByTag( "img" );
        for (Element element : elements) {
            element.attr( "width", "100%" ).attr( "height", "auto" );
        }
        return doc.toString();
    }
    class MyWebViewClient extends WebViewClient {

        /**
         * 同名 API 兼容
         */
        @TargetApi(Build.VERSION_CODES.M)
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            if (request.isForMainFrame()) {
                onReceivedError(view,
                        error.getErrorCode(), error.getDescription().toString(),
                        request.getUrl().toString());
            }
        }

        /**
         * 网页加载错误时回调，这个方法会在 onPageFinished 之前调用
         */
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            // 这里为什么要用延迟呢？因为加载出错之后会先调用 onReceivedError 再调用 onPageFinished
            post(NformationForDetailsActivity.this::showError);
        }

        /**
         * 开始加载网页
         */
        @Override
        public void onPageStarted(final WebView view, final String url, Bitmap favicon) {
            pbWebProgress.setVisibility(View.VISIBLE);
        }

        /**
         * 完成加载网页
         */
        @Override
        public void onPageFinished(WebView view, String url) {
            pbWebProgress.setVisibility(View.GONE);
            showComplete();
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            // 注意一定要去除这行代码，否则设置无效。
            //super.onReceivedSslError(view, handler, error);
            // Android默认的处理方式
            //handler.cancel();
            // 接受所有网站的证书
            handler.proceed();
        }

        /**
         * 同名 API 兼容
         */
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return shouldOverrideUrlLoading(view, request.getUrl().toString());
        }

        /**
         * 跳转到其他链接
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, final String url) {
            String scheme = Uri.parse(url).getScheme();
            if (scheme != null) {
                scheme = scheme.toLowerCase();
            }
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                mWebView.loadUrl(url);
            }
            // 已经处理该链接请求
            return true;
        }
    }

    class MyWebChromeClient extends WebChromeClient {

//        /**
//         * 收到网页标题
//         */
//        @Override
//        public void onReceivedTitle(WebView view, String title) {
//            if (title != null) {
//                switch (dataKey) {
//                    case "url":
//                        setTitle(title);
//                        break;
//                    default:
//                        setTitle("详情");
//                        break;
//                }
//            }
//        }

        /**
         * 收到加载进度变化
         */
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            pbWebProgress.setProgress(newProgress);
        }
    }
}
