package com.haier.uhome.account.b;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f28110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28114e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f28115a = new c();

        private a() {
        }
    }

    public static c a() {
        return a.f28115a;
    }

    public Context b() {
        return this.f28110a;
    }

    public String c() {
        return this.f28111b;
    }

    public String d() {
        return this.f28112c;
    }

    public String e() {
        return this.f28113d;
    }

    public String f() {
        return this.f28114e;
    }

    public boolean g() {
        if (TextUtils.isEmpty(d())) {
            e3.a.h("terrible situation because <U_ANALYTICS_APPID> no configuration!!!", new Object[0]);
            return false;
        }
        if (!TextUtils.isEmpty(c())) {
            return true;
        }
        e3.a.h("terrible situation because <U_ANALYTICS_APPKEY> no configuration!!!", new Object[0]);
        return false;
    }

    public void a(Context context) {
        this.f28110a = context;
    }

    public void b(String str) {
        this.f28112c = str;
    }

    public void c(String str) {
        this.f28113d = str;
    }

    public void d(String str) {
        this.f28114e = str;
    }

    public void a(String str) {
        this.f28111b = str;
    }
}
