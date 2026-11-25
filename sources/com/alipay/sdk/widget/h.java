package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alipay.sdk.app.c f13859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f13860c;

    public h(Activity activity) {
        super(activity);
        WebView webView = new WebView(activity);
        this.f13860c = webView;
        m(webView, activity);
        addView(this.f13860c);
        com.alipay.sdk.app.c cVar = new com.alipay.sdk.app.c(activity);
        this.f13859b = cVar;
        this.f13860c.setWebViewClient(cVar);
    }

    private void m(WebView webView, Context context) {
        WebSettings settings = this.f13860c.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + com.alipay.sdk.util.o.u(context));
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(1);
        this.f13860c.resumeTimers();
        this.f13860c.setVerticalScrollbarOverlay(true);
        this.f13860c.setDownloadListener(new i(this));
        try {
            try {
                this.f13860c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f13860c.removeJavascriptInterface("accessibility");
                this.f13860c.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
                Method method = this.f13860c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method != null) {
                    method.invoke(this.f13860c, "searchBoxJavaBridge_");
                    method.invoke(this.f13860c, "accessibility");
                    method.invoke(this.f13860c, "accessibilityTraversal");
                }
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.alipay.sdk.widget.g
    public void i() {
        this.f13859b.a();
        removeAllViews();
    }

    @Override // com.alipay.sdk.widget.g
    public void j(String str) {
        this.f13860c.loadUrl(str);
    }

    @Override // com.alipay.sdk.widget.g
    public boolean l() {
        if (!this.f13860c.canGoBack()) {
            com.alipay.sdk.app.k.c(com.alipay.sdk.app.k.f());
            this.f13858a.finish();
            return true;
        }
        if (!this.f13859b.d()) {
            return true;
        }
        com.alipay.sdk.app.l lVarD = com.alipay.sdk.app.l.d(com.alipay.sdk.app.l.NETWORK_ERROR.a());
        com.alipay.sdk.app.k.c(com.alipay.sdk.app.k.b(lVarD.a(), lVarD.e(), ""));
        this.f13858a.finish();
        return true;
    }
}
