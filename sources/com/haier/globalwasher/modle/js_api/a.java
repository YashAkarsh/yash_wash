package com.haier.globalwasher.modle.js_api;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.haier.globalwasher.base.BaseActivity;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WebView f24496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    BaseActivity f24497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private q2.a f24498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.globalwasher.modle.js_api.device.a f24499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private s2.a f24500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private r2.a f24501f;

    public a() {
    }

    @JavascriptInterface
    public b UIModule() {
        if (this.f24501f == null) {
            this.f24501f = new r2.a(this.f24497b, this.f24496a);
        }
        return this.f24501f;
    }

    public void a() {
        this.f24501f = null;
        this.f24496a.destroy();
        this.f24498c = null;
        this.f24499d = null;
        this.f24500e = null;
        this.f24496a = null;
        this.f24497b = null;
    }

    @JavascriptInterface
    public b deviceModule() {
        if (this.f24499d == null) {
            this.f24499d = new com.haier.globalwasher.modle.js_api.device.a(this.f24497b, this.f24496a);
        }
        return this.f24499d;
    }

    @JavascriptInterface
    public b loginModule() {
        if (this.f24500e == null) {
            this.f24500e = new s2.a(this.f24497b, this.f24496a);
        }
        return this.f24500e;
    }

    @JavascriptInterface
    public b shareModule() {
        if (this.f24498c == null) {
            this.f24498c = new q2.a(this.f24497b, this.f24496a);
        }
        return this.f24498c;
    }

    public a(BaseActivity baseActivity, WebView webView) {
        this.f24496a = webView;
        this.f24497b = baseActivity;
    }
}
