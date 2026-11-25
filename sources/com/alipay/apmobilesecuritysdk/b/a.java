package com.alipay.apmobilesecuritysdk.b;

import com.alipay.security.mobile.module.http.d;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f13505b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13506a = 0;

    public static a a() {
        return f13505b;
    }

    public final int b() {
        return this.f13506a;
    }

    public final String c() {
        String strB = d.b();
        if (o0.a.g(strB)) {
            return strB;
        }
        int i7 = this.f13506a;
        if (i7 == 1) {
            return "http://mobilegw.stable.alipay.net/mgw.htm";
        }
        if (i7 != 3) {
            return i7 != 4 ? "https://mobilegw.alipay.com/mgw.htm" : "http://mobilegw.aaa.alipay.net/mgw.htm";
        }
        return "http://mobilegw-1-64.test.alipay.net/mgw.htm";
    }

    public final void a(int i7) {
        this.f13506a = i7;
    }
}
