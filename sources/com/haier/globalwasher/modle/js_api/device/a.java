package com.haier.globalwasher.modle.js_api.device;

import android.content.res.Configuration;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.gson.f;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.js_api.b;
import com.haier.globalwasher.modle.utils.f0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Configuration f24507c;

    public a(BaseActivity baseActivity, WebView webView) {
        super(baseActivity, webView);
        this.f24507c = c();
    }

    private Configuration c() {
        return MyApplication.k().getResources().getConfiguration();
    }

    @JavascriptInterface
    public String getCountry() {
        if (this.f24507c == null) {
            this.f24507c = c();
        }
        Locale locale = this.f24507c.locale;
        return locale != null ? locale.getCountry() : "";
    }

    @JavascriptInterface
    public String getCurrentTimeZone() {
        return f0.c();
    }

    @JavascriptInterface
    public String getDeviceSysm() {
        BaseData baseData = new BaseData();
        o2.a aVar = o2.a.SUCCESS;
        baseData.setRetCode(aVar.b());
        baseData.setRetCode(aVar.c());
        baseData.setRetData(new DeviceInfoBean(getLanguage(), getCountry(), getCurrentTimeZone()));
        return new f().z(baseData);
    }

    @JavascriptInterface
    public String getLanguage() {
        if (this.f24507c == null) {
            this.f24507c = c();
        }
        Locale locale = this.f24507c.locale;
        return locale != null ? locale.getLanguage() : "";
    }
}
