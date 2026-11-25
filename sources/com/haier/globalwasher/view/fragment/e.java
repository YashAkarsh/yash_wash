package com.haier.globalwasher.view.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import c.t0;
import com.facebook.CallbackManager;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.presenter.y;
import com.haier.globalwasher.view.activity.WebActivity;
import com.haier.globalwasher.view.custom_view.webview.MyWebView;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.haier.globalwasher.base.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private y f26140n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MyWebView f26141o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BaseActivity f26142p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Bundle f26145s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    CallbackManager f26146t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.haier.globalwasher.modle.js_api.a f26148v;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f26139m = "<div style=\"text-align: left;margin: 15px auto 0 auto;padding: 0\"><div style=\"font-size: 16px;color: black;\">{0}</div><div style=\"margin: 15px auto 15px auto;padding: 0;color: rgba(153,153,153,1); font-size: 12px;\">{1}</div><div style=\"margin: 15px auto 15px auto;padding: 0;color: rgba(51,51,51,1);margin:0;\">{2}</div></div>";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f26143q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f26144r = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f26147u = "WebFragment";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f26149w = false;

    class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z7, boolean z8, Message message) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i7) {
            q.c(e.this.f26147u, "=onProgressChanged==" + i7);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            q.c(e.this.f26147u, "=onReceivedTitle==" + str);
            if (e.this.f26142p instanceof WebActivity) {
                ((WebActivity) e.this.f26142p).k0(str);
            }
        }
    }

    public static e J(Bundle bundle) {
        e eVar = new e();
        if (bundle != null) {
            eVar.setArguments(bundle);
            q.c("WebFragment", bundle.getString(y.f25407e) + " url");
        }
        return eVar;
    }

    public WebView K() {
        return this.f26141o;
    }

    @SuppressLint({"JavascriptInterface"})
    public void L() {
        WebSettings settings = this.f26141o.getSettings();
        this.f26141o.requestFocusFromTouch();
        settings.setMixedContentMode(0);
        settings.setAllowFileAccess(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.supportMultipleWindows();
        settings.setDatabaseEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setGeolocationDatabasePath(this.f26142p.getApplicationContext().getDir("database", 0).getPath());
        com.haier.globalwasher.modle.js_api.a aVar = new com.haier.globalwasher.modle.js_api.a(this.f26142p, this.f26141o);
        this.f26148v = aVar;
        this.f26141o.addJavascriptInterface(aVar, "AndroidJSApi");
        this.f26141o.setWebChromeClient(new a());
        this.f26141o.setWebViewClient(new b());
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        L();
        q.c(this.f26147u, "url=" + this.f26143q);
        this.f26141o.loadUrl("http://www.sharewash.cn/saywash/WashCallWxtest/Feedback/index.html");
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.web_fragment;
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        this.f26146t = CallbackManager.Factory.create();
        this.f26142p = (BaseActivity) getActivity();
        MyWebView myWebView = (MyWebView) findViewById(R.id.wv_webview);
        this.f26141o = myWebView;
        if (myWebView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.f26141o.getLayoutParams();
            layoutParams.height = n0.a(this.f26142p);
            this.f26141o.setLayoutParams(layoutParams);
        }
        Bundle arguments = getArguments();
        this.f26145s = arguments;
        if (arguments == null) {
            return;
        }
        this.f26144r = arguments.getString(y.f25408f);
        String string = this.f26145s.getString(y.f25407e);
        this.f26143q = string;
        q.c(this.f26147u, string);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        y yVar = new y();
        this.f26140n = yVar;
        return yVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i7, int i8, Intent intent) {
        super.onActivityResult(i7, i8, intent);
        q.c("Share", "requestCode=" + i7 + "  resultCode=" + i8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        K().destroy();
    }

    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            e.this.f26149w = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i7, String str, String str2) {
            q.c(e.this.f26147u, "=onReceivedError==" + e.this.f26143q);
            super.onReceivedError(webView, i7, str, str2);
            e.this.f26149w = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            q.c(e.this.f26147u, "=onReceivedSslError==" + e.this.f26143q);
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f8, float f9) {
            super.onScaleChanged(webView, f8, f9);
            e.this.f26141o.requestFocus();
            e.this.f26141o.requestFocusFromTouch();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            q.c(e.this.f26147u, "===" + str);
            if (str.startsWith("weixin://wap/pay?")) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                e.this.startActivity(intent);
                return true;
            }
            if (str.startsWith("tel:")) {
                e.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return false;
            }
            webView.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        @t0(api = 21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            q.c(e.this.f26147u, "=shouldOverrideUrlLoading==" + e.this.f26143q);
            webView.loadUrl(webResourceRequest.getUrl().toString());
            return true;
        }
    }
}
