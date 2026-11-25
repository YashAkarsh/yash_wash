package com.haier.globalwasher.view.custom_view.webview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import c.o0;
import com.haier.globalwasher.modle.utils.q;
import java.util.Map;
import v2.a;

/* JADX INFO: loaded from: classes2.dex */
public class MyWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f25971a;

    public MyWebView(Context context) {
        super(context, null);
        this.f25971a = false;
    }

    public void a(String str, String str2) {
        try {
            WebSettings settings = getSettings();
            if (settings != null) {
                settings.setUserAgentString(settings.getUserAgentString() + " " + str + "/" + str2);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public String getDeviceModel() {
        return Build.MODEL;
    }

    public String getDeviceType() {
        return Build.FINGERPRINT;
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(@o0 String str, String str2, @o0 String str3, @o0 String str4, @o0 String str5) {
        if (!this.f25971a) {
            this.f25971a = true;
            a("Mrsysinfo", a.a() + " (Android:" + getDeviceType() + ")");
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (!this.f25971a) {
            this.f25971a = true;
            a("Mrsysinfo", a.a() + " (Android:" + getDeviceType() + ")");
        }
        super.loadUrl(str);
        q.c("WebView", "getUserAgentString=" + getSettings().getUserAgentString());
    }

    public MyWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25971a = false;
    }

    public MyWebView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25971a = false;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (!this.f25971a) {
            this.f25971a = true;
            a("Mrsysinfo", a.a() + " (Android:" + getDeviceType() + ")");
        }
        super.loadUrl(str, map);
    }

    public MyWebView(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f25971a = false;
    }
}
