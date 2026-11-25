package com.alipay.sdk.widget;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
class s extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewWindow f13900a;

    s(WebViewWindow webViewWindow) {
        this.f13900a = webViewWindow;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.f13900a.f13836f.a(this.f13900a, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i7) {
        if (i7 == 100) {
            this.f13900a.f13834d.setVisibility(4);
            return;
        }
        if (4 == this.f13900a.f13834d.getVisibility()) {
            this.f13900a.f13834d.setVisibility(0);
        }
        this.f13900a.f13834d.setProgress(i7);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        this.f13900a.f13836f.e(this.f13900a, str);
    }
}
