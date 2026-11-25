package com.haier.globalwasher.modle.utils.login;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import c.o0;
import com.google.gson.f;
import com.haier.globalwasher.modle.js_api.c;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.LoginActivity;
import com.haier.library.sumhttp.plugin.h;
import s2.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24661a = "LoginAction";

    /* JADX INFO: renamed from: com.haier.globalwasher.modle.utils.login.a$a, reason: collision with other inner class name */
    class C0322a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebView f24662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24663b;

        C0322a(WebView webView, String str) {
            this.f24662a = webView;
            this.f24663b = str;
        }

        @Override // com.haier.globalwasher.modle.js_api.c
        public void onActivityResult(int i7, int i8, @o0 Intent intent) {
            q.c(a.f24661a, "toLogin   onActivityResult");
            if (intent != null) {
                BaseData baseData = (BaseData) intent.getSerializableExtra("LOGIN_DATA");
                b bVar = new b(this.f24662a, this.f24663b);
                if (baseData == null) {
                    bVar.c();
                } else {
                    bVar.d(new f().z(baseData));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, WebView webView, String str) {
        q.c(f24661a, "toLogin   " + str);
        if (activity instanceof p2.a) {
            ((p2.a) activity).w(new C0322a(webView, str));
        }
        activity.startActivityForResult(new Intent(activity, (Class<?>) LoginActivity.class), h.f27944a);
    }
}
