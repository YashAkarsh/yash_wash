package com.alipay.sdk.app;

import android.app.Activity;
import android.webkit.SslErrorHandler;

/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f13594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SslErrorHandler f13595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f13596c;

    d(c cVar, Activity activity, SslErrorHandler sslErrorHandler) {
        this.f13596c = cVar;
        this.f13594a = activity;
        this.f13595b = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alipay.sdk.widget.e.b(this.f13594a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new e(this), "退出", new f(this));
    }
}
