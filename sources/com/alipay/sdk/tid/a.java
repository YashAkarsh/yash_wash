package com.alipay.sdk.tid;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f13745c;

    public a(String str, String str2, long j7) {
        this.f13743a = str;
        this.f13744b = str2;
        this.f13745c = j7;
    }

    public static boolean d(a aVar) {
        return aVar == null || TextUtils.isEmpty(aVar.f13743a);
    }

    public String a() {
        return this.f13743a;
    }

    public String b() {
        return this.f13744b;
    }

    public long c() {
        return this.f13745c;
    }
}
