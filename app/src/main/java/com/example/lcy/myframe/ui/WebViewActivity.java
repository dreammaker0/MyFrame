package com.example.lcy.myframe.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.lcy.myframe.R;
import com.example.lcy.myframe.base.BaseAppCompatActivity;

import butterknife.BindView;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-29.
 */
public class WebViewActivity extends BaseAppCompatActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    @BindView(R.id.webView)
    WebView mWebView;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    private WebSettings mWebSettings;

    private String mUrl;
    private String mTitle;

    @Override
    protected void getBundleExtras(Bundle extras) {
        mUrl = extras.getString("url");
        mTitle = extras.getString("title");
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_web;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true); //如果访问的页面中有Javascript，则WebView必须设置支持Javascript
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebSettings.setSupportZoom(true); //支持缩放
        mWebSettings.setBuiltInZoomControls(true); //支持手势缩放
        mWebSettings.setDisplayZoomControls(false); //是否显示缩放按钮

        // >= 19(SDK4.4)启动硬件加速，否则启动软件加速
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            mWebSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        } else {
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            mWebSettings.setLoadsImagesAutomatically(false);
        }

        mWebSettings.setUseWideViewPort(true); //将图片调整到适合WebView的大小
        mWebSettings.setLoadWithOverviewMode(true); //自适应屏幕
        mWebSettings.setDomStorageEnabled(true);
        mWebSettings.setSaveFormData(true);
        mWebSettings.setSupportMultipleWindows(true);
        mWebSettings.setAppCacheEnabled(true);
        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT); //优先使用缓存

        mWebView.setHorizontalScrollbarOverlay(true);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setOverScrollMode(View.OVER_SCROLL_NEVER); // 取消WebView中滚动或拖动到顶部、底部时的阴影
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); // 取消滚动条白边效果
        mWebView.requestFocus();

        mWebView.loadUrl(mUrl);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mWebView.setLayerType(View.LAYER_TYPE_NONE, null);
                mProgressBar.setVisibility(View.GONE);
                if (!mWebSettings.getLoadsImagesAutomatically()) {
                    mWebSettings.setLoadsImagesAutomatically(true);
                }
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                mProgressBar.setVisibility(View.GONE);
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress >= 100) {
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    if (mProgressBar.getVisibility() == View.GONE) {
                        mProgressBar.setVisibility(View.VISIBLE);
                    }
                    mProgressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                mToolbar.setTitle(mWebView.getTitle());
            }
        });
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
