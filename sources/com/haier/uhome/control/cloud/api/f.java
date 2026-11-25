package com.haier.uhome.control.cloud.api;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29125a = "blemeshmodule";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f29126b = "blesdkmodule";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f29132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f29133i;

    public String a() {
        return this.f29127c;
    }

    public String b() {
        return this.f29128d;
    }

    public String c() {
        return this.f29129e;
    }

    public String d() {
        return this.f29130f;
    }

    public String e() {
        return this.f29131g;
    }

    public String f() {
        return com.haier.library.common.util.c.j(this.f29133i) ? f29125a : this.f29132h;
    }

    public String g() {
        return com.haier.library.common.util.c.j(this.f29133i) ? "" : this.f29133i;
    }

    public String toString() {
        return "DeviceVersionInfo{softType='" + this.f29127c + "', softVer='" + this.f29128d + "', hardType='" + this.f29129e + "', hardVer='" + this.f29130f + "', devVers='" + this.f29131g + "', type='" + this.f29132h + "', mac='" + this.f29133i + "'}";
    }

    public void a(String str) {
        this.f29127c = str;
    }

    public void b(String str) {
        this.f29128d = str;
    }

    public void c(String str) {
        this.f29129e = str;
    }

    public void d(String str) {
        this.f29130f = str;
    }

    public void e(String str) {
        this.f29131g = str;
    }

    public void a(int i7) {
        this.f29132h = i7 == 2 ? f29126b : f29125a;
    }

    public void f(String str) {
        this.f29133i = str;
    }
}
