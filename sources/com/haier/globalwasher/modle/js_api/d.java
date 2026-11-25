package com.haier.globalwasher.modle.js_api;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.gson.f;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseBeen;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f24504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f24505b;

    class a implements ValueCallback<String> {
        a() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            q.c("MyShareListener", "" + str);
        }
    }

    public d(WebView webView, String str) {
        this.f24504a = webView;
        this.f24505b = str;
    }

    public void a(String str, String str2) {
        q.c("MyShareListener", "callResultMethod ==" + str2);
        WebView webView = this.f24504a;
        if (webView == null || webView.getContext() == null || !d0.j(str)) {
            return;
        }
        q.c("MyShareListener", "str==" + str2 + " \n\t methodName=" + str);
        this.f24504a.evaluateJavascript("javascript:" + str + "(\"" + str2 + "\")", new a());
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
