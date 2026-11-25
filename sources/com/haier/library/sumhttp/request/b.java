package com.haier.library.sumhttp.request;

import com.haier.library.okhttp.api.f;
import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.service.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27977a = l3.a.B;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f27978b = l3.a.C;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f27979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f27980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f27981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f27982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f f27983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f27984h;

    b() {
    }

    public static b a() {
        return new b();
    }

    public b b(int i7) {
        this.f27980d = i7;
        return this;
    }

    public b c(f fVar) {
        this.f27983g = fVar;
        return this;
    }

    public b d(String str) {
        this.f27977a = str;
        return this;
    }

    public b e(String str, String str2, String str3, String str4, String str5) {
        return f(str, str2, str3, str4, str5, null);
    }

    public b f(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strC = com.haier.library.sumhttp.c.a.c(this.f27977a, this.f27978b, strValueOf, str, str2);
        HashMap<String, String> map2 = new HashMap<>(12);
        map2.put("appId", this.f27977a);
        map2.put(HttpHelper.a.f29518b, e.a().j());
        map2.put("apiVersion", "v1");
        map2.put(HttpHelper.a.f29520d, str3);
        map2.put(HttpHelper.a.f29521e, strValueOf + "000010");
        map2.put("accessToken", str4);
        map2.put("sign", strC);
        map2.put(TraceProtocolConst.PRO_TRACE_ID, str5);
        map2.put("timestamp", strValueOf);
        map2.put("language", "zh-cn");
        map2.put(HttpHelper.a.f29526j, HttpHelper.b.f29530c);
        map2.put("Content-Type", "application/json;charset=UTF-8");
        if (map != null && map.size() > 0) {
            map2.putAll(map);
        }
        this.f27981e = map2;
        return this;
    }

    public b g(int i7) {
        if (i7 == 0) {
            i7 = 30;
        }
        this.f27984h = i7;
        return this;
    }

    public b h(String str) {
        this.f27978b = str;
        return this;
    }

    public void i() {
        e3.a.e("HttpRequest DeviceCenterRequestFactory mRequestType = %s", Integer.valueOf(this.f27980d));
        e3.a.e("HttpRequest DeviceCenterRequestFactory mUrl = %s", this.f27979c);
        e3.a.e("HttpRequest DeviceCenterRequestFactory mHeadMap = %s", this.f27981e);
        e3.a.e("HttpRequest DeviceCenterRequestFactory mBody = %s", this.f27982f);
        int i7 = this.f27980d;
        if (i7 == 1) {
            com.haier.library.okhttp.api.e.n(this.f27984h, TimeUnit.SECONDS, false).i(this.f27979c, this.f27981e, this.f27983g);
        } else if (i7 == 2) {
            com.haier.library.okhttp.api.e.n(this.f27984h, TimeUnit.SECONDS, false).u(this.f27979c, this.f27981e, this.f27982f, this.f27983g);
        }
    }

    public b j(String str) {
        this.f27979c = str;
        return this;
    }

    public b k(String str) {
        this.f27982f = str;
        return this;
    }
}
