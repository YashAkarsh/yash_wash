package com.google.zxing.common;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f23558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<byte[]> f23561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f23563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Integer f23564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object f23565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f23566i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f23567j;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.f23561d;
    }

    public String b() {
        return this.f23562e;
    }

    public Integer c() {
        return this.f23564g;
    }

    public Integer d() {
        return this.f23563f;
    }

    public int e() {
        return this.f23559b;
    }

    public Object f() {
        return this.f23565h;
    }

    public byte[] g() {
        return this.f23558a;
    }

    public int h() {
        return this.f23566i;
    }

    public int i() {
        return this.f23567j;
    }

    public String j() {
        return this.f23560c;
    }

    public boolean k() {
        return this.f23566i >= 0 && this.f23567j >= 0;
    }

    public void l(Integer num) {
        this.f23564g = num;
    }

    public void m(Integer num) {
        this.f23563f = num;
    }

    public void n(int i7) {
        this.f23559b = i7;
    }

    public void o(Object obj) {
        this.f23565h = obj;
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i7, int i8) {
        this.f23558a = bArr;
        this.f23559b = bArr == null ? 0 : bArr.length * 8;
        this.f23560c = str;
        this.f23561d = list;
        this.f23562e = str2;
        this.f23566i = i8;
        this.f23567j = i7;
    }
}
