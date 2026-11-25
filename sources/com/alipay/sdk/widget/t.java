package com.alipay.sdk.widget;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes.dex */
class t extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewWindow f13901a;

    t(WebViewWindow webViewWindow) {
        this.f13901a = webViewWindow;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f13901a.f13837g.g(this.f13901a, str)) {
            return;
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i7, String str, String str2) {
        if (this.f13901a.f13837g.f(this.f13901a, i7, str, str2)) {
            return;
        }
        super.onReceivedError(webView, i7, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.f13901a.f13837g.b(this.f13901a, sslErrorHandler, sslError)) {
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.f13901a.f13837g.c(this.f13901a, str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
