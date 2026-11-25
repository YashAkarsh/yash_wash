package com.alipay.sdk.widget;

import android.webkit.SslErrorHandler;

/* JADX INFO: loaded from: classes.dex */
class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SslErrorHandler f13893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f13894b;

    n(j jVar, SslErrorHandler sslErrorHandler) {
        this.f13894b = jVar;
        this.f13893a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        e.b(this.f13894b.f13858a, "安全警告", "安全連接證書校驗無效，將無法保證訪問資料的安全性，可能存在風險，請選擇是否繼續？", "繼續", new o(this), "退出", new p(this));
    }
}
