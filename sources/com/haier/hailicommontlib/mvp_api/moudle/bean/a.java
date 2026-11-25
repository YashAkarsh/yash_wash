package com.haier.hailicommontlib.mvp_api.moudle.bean;

import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f26198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f26202e;

    public String a() {
        return this.f26199b;
    }

    public String b() {
        return this.f26201d;
    }

    public String c() {
        return this.f26200c;
    }

    public String d() {
        return this.f26202e;
    }

    public long e() {
        return this.f26198a;
    }

    public void f(String str) {
        this.f26199b = str;
    }

    public void g(String str) {
        this.f26201d = str;
    }

    public void h(String str) {
        this.f26200c = str;
    }

    public void i(String str) {
        this.f26202e = str;
    }

    public void j(long j7) {
        this.f26198a = j7;
    }

    public String toString() {
        return "{\"sysTime\":" + this.f26198a + ", \"retCode\":\"" + this.f26199b + h0.f35376b + ", \"retInfo\":\"" + this.f26200c + h0.f35376b + ", \"retData\":\"" + this.f26201d + h0.f35376b + ", \"retSign\":\"" + this.f26202e + h0.f35376b + '}';
    }
}
