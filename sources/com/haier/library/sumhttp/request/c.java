package com.haier.library.sumhttp.request;

import com.haier.library.okhttp.api.e;
import com.haier.library.okhttp.api.f;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static c f27985g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f27988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f27990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f27991f;

    c() {
    }

    public static c a() {
        if (f27985g == null) {
            synchronized (c.class) {
                if (f27985g == null) {
                    f27985g = new c();
                }
            }
        }
        return f27985g;
    }

    public c b(int i7) {
        this.f27987b = i7;
        return this;
    }

    public c c(f fVar) {
        this.f27990e = fVar;
        return this;
    }

    public c d(String str) {
        this.f27989d = str;
        return this;
    }

    public c e(String str, String str2) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strA = com.haier.library.sumhttp.c.a.a(l3.a.B, l3.a.C, strValueOf, str, str2);
        HashMap<String, String> map = new HashMap<>();
        map.put("appid", l3.a.B);
        map.put("timestamp", strValueOf);
        map.put("sign", strA);
        map.put("Content-Type", "application/json;charset=UTF-8");
        this.f27988c = map;
        return this;
    }

    public c f(int i7) {
        if (i7 == 0) {
            i7 = 30;
        }
        this.f27991f = i7;
        return this;
    }

    public c g(String str) {
        this.f27986a = str;
        return this;
    }

    public void h() {
        e3.a.e("HttpRequest OpenPlatformRequestFactory mRequestType = %s", Integer.valueOf(this.f27987b));
        e3.a.e("HttpRequest OpenPlatformRequestFactory mUrl = %s", this.f27986a);
        e3.a.e("HttpRequest OpenPlatformRequestFactory mHeadMap = %s", this.f27988c);
        e3.a.e("HttpRequest OpenPlatformRequestFactory mBody = %s", this.f27989d);
        int i7 = this.f27987b;
        if (i7 == 1) {
            e.m(this.f27991f, TimeUnit.SECONDS).i(this.f27986a, this.f27988c, this.f27990e);
        } else if (i7 == 2) {
            e.m(this.f27991f, TimeUnit.SECONDS).u(this.f27986a, this.f27988c, this.f27989d, this.f27990e);
        }
    }
}
