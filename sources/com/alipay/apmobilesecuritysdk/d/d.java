package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static synchronized Map<String, String> a() {
        HashMap map;
        map = new HashMap();
        try {
            new com.alipay.apmobilesecuritysdk.c.b();
            map.put("AE16", "");
        } catch (Throwable unused) {
        }
        return map;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap map;
        com.alipay.security.mobile.module.b.e.a();
        com.alipay.security.mobile.module.b.c.a();
        map = new HashMap();
        map.put("AE1", com.alipay.security.mobile.module.b.e.d());
        StringBuilder sb = new StringBuilder();
        sb.append(com.alipay.security.mobile.module.b.e.e() ? "1" : "0");
        map.put("AE2", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.alipay.security.mobile.module.b.e.c(context) ? "1" : "0");
        map.put("AE3", sb2.toString());
        map.put("AE4", com.alipay.security.mobile.module.b.e.f());
        map.put("AE5", com.alipay.security.mobile.module.b.e.g());
        map.put("AE6", com.alipay.security.mobile.module.b.e.h());
        map.put("AE7", com.alipay.security.mobile.module.b.e.i());
        map.put("AE8", com.alipay.security.mobile.module.b.e.j());
        map.put("AE9", com.alipay.security.mobile.module.b.e.k());
        map.put("AE10", com.alipay.security.mobile.module.b.e.l());
        map.put("AE11", com.alipay.security.mobile.module.b.e.m());
        map.put("AE12", com.alipay.security.mobile.module.b.e.n());
        map.put("AE13", com.alipay.security.mobile.module.b.e.o());
        map.put("AE14", com.alipay.security.mobile.module.b.e.p());
        map.put("AE15", com.alipay.security.mobile.module.b.e.q());
        map.put("AE21", com.alipay.security.mobile.module.b.c.n());
        return map;
    }
}
