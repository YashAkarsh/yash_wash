package com.haier.globalwasher.modle.js_api;

import android.webkit.WebView;
import com.google.gson.f;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.mvp_api.moudle.BaseBeen;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f24502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseActivity f24503b;

    public b(BaseActivity baseActivity, WebView webView) {
        this.f24502a = webView;
        this.f24503b = baseActivity;
    }

    public void a(String str, String str2) {
        if (this.f24502a == null || !d0.j(str)) {
            return;
        }
        this.f24502a.loadUrl("javascript:(" + str + "(" + str2 + "))");
    }

    public String b(String str, String str2, String str3) {
        f fVar = new f();
        BaseBeen baseBeen = new BaseBeen();
        baseBeen.setRetCode(str);
        baseBeen.setRetInfo(str2);
        baseBeen.setSysTime(System.currentTimeMillis());
        baseBeen.setRetData(str3);
        return fVar.z(baseBeen);
    }
}
