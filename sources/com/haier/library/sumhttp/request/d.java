package com.haier.library.sumhttp.request;

import com.haier.library.okhttp.api.e;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static d f27992g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f27995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.library.okhttp.api.b f27997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f27998f;

    d() {
    }

    public static d a() {
        if (f27992g == null) {
            synchronized (d.class) {
                if (f27992g == null) {
                    f27992g = new d();
                }
            }
        }
        return f27992g;
    }

    public d b(int i7) {
        this.f27994b = i7;
        return this;
    }

    public d c(com.haier.library.okhttp.api.b bVar) {
        this.f27997e = bVar;
        return this;
    }

    public d d(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("secretKey", str);
        map.put(com.google.common.net.c.f22174v, "resource.haier.net");
        map.put("Content-Type", "application/octet-stream");
        map.put(com.google.common.net.c.f22160o, "Keep-Alive");
        this.f27995c = map;
        return this;
    }

    public d e(int i7) {
        if (i7 == 0) {
            i7 = 30;
        }
        this.f27998f = i7;
        return this;
    }

    public d f(String str) {
        this.f27996d = str;
        return this;
    }

    public void g() {
        e3.a.e("HttpRequest ResourceServiceRequestFactory mRequestType = %s", Integer.valueOf(this.f27994b));
        e3.a.e("HttpRequest ResourceServiceRequestFactory mUrl = %s", this.f27993a);
        e3.a.e("HttpRequest ResourceServiceRequestFactory mHeadMap = %s", this.f27995c);
        e3.a.e("HttpRequest ResourceServiceRequestFactory mBody = %s", this.f27996d);
        int i7 = this.f27994b;
        if (i7 == 1) {
            e.m(this.f27998f, TimeUnit.SECONDS).i(this.f27993a, this.f27995c, this.f27997e);
        } else if (i7 == 2) {
            e.m(this.f27998f, TimeUnit.SECONDS).u(this.f27993a, this.f27995c, this.f27996d, this.f27997e);
        }
    }

    public d h(String str) {
        this.f27993a = str;
        return this;
    }
}
