package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.util.o;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class c extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f13588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f13590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.alipay.sdk.widget.a f13591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13592e;

    private static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f13593a;

        a(c cVar) {
            this.f13593a = new WeakReference<>(cVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.f13593a.get();
            if (cVar != null) {
                cVar.f();
            }
        }
    }

    public c(Activity activity) {
        this.f13588a = activity;
        this.f13590c = new Handler(this.f13588a.getMainLooper());
    }

    private void e() {
        Activity activity = this.f13588a;
        if (activity == null) {
            return;
        }
        if (this.f13591d == null) {
            com.alipay.sdk.widget.a aVar = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f13841i);
            this.f13591d = aVar;
            aVar.e(true);
        }
        this.f13591d.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.alipay.sdk.widget.a aVar = this.f13591d;
        if (aVar != null) {
            aVar.i();
        }
        this.f13591d = null;
    }

    public void a() {
        this.f13590c = null;
        this.f13588a = null;
    }

    public boolean d() {
        return this.f13592e;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Activity activity = this.f13588a;
        if (this.f13590c == null || activity == null || activity.isFinishing()) {
            return;
        }
        f();
        this.f13590c.removeCallbacksAndMessages(null);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Activity activity = this.f13588a;
        if (this.f13590c != null && activity != null && !activity.isFinishing()) {
            e();
            this.f13590c.postDelayed(new a(this), 30000L);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i7, String str, String str2) {
        this.f13592e = true;
        super.onReceivedError(webView, i7, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f13588a;
        if (activity == null) {
            return;
        }
        com.alipay.sdk.app.statistic.a.d("net", com.alipay.sdk.app.statistic.c.B, "1" + sslError);
        if (!this.f13589b) {
            activity.runOnUiThread(new d(this, activity, sslErrorHandler));
        } else {
            sslErrorHandler.proceed();
            this.f13589b = false;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return o.l(webView, str, this.f13588a);
    }
}
