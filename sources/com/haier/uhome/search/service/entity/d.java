package com.haier.uhome.search.service.entity;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f29891a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f29892b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f29893c = 33;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f29894d = 34;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f29898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f29899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f29900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f29901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f29902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f29903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f29904n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f29905o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f29906p;

    public d() {
        this.f29905o = 33;
    }

    public static boolean e(int i7) {
        return i7 == 1001 || i7 == 1002 || i7 == 1003 || i7 == 1004;
    }

    public String a() {
        return this.f29895e;
    }

    public int b() {
        return this.f29896f;
    }

    public String c() {
        return this.f29897g;
    }

    public String d() {
        return this.f29898h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f29896f == dVar.f29896f && this.f29902l == dVar.f29902l && this.f29904n == dVar.f29904n && this.f29905o == dVar.f29905o && Objects.equals(this.f29895e, dVar.f29895e) && Objects.equals(this.f29897g, dVar.f29897g) && Objects.equals(this.f29898h, dVar.f29898h) && Objects.equals(this.f29899i, dVar.f29899i) && Objects.equals(this.f29900j, dVar.f29900j) && Objects.equals(this.f29901k, dVar.f29901k) && Objects.equals(this.f29903m, dVar.f29903m);
    }

    public String f() {
        return this.f29900j;
    }

    public String g() {
        return this.f29901k;
    }

    public int h() {
        return this.f29902l;
    }

    public int hashCode() {
        return Objects.hash(this.f29895e, Integer.valueOf(this.f29896f), this.f29897g, this.f29898h, this.f29899i, this.f29900j, this.f29901k, Integer.valueOf(this.f29902l), this.f29903m, Integer.valueOf(this.f29904n), Integer.valueOf(this.f29905o));
    }

    public String i() {
        return this.f29903m;
    }

    public int j() {
        return this.f29904n;
    }

    public int k() {
        return this.f29902l / 1000;
    }

    public int l() {
        return this.f29905o;
    }

    public long m() {
        return this.f29906p;
    }

    public String toString() {
        return "DeviceBleEvent{name='" + this.f29895e + "', type=" + this.f29896f + ", devId='" + this.f29897g + "', bleDevId='" + this.f29898h + "', flags='" + this.f29899i + "', protocol='" + this.f29900j + "', protVers='" + this.f29901k + "', stateCode=" + this.f29902l + ", buf='" + this.f29903m + "', bufSize=" + this.f29904n + ", module=" + this.f29905o + ", createTime=" + this.f29906p + '}';
    }

    public void a(String str) {
        this.f29895e = str;
    }

    public void b(String str) {
        this.f29897g = str;
    }

    public void c(String str) {
        this.f29898h = str;
    }

    public void d(String str) {
        this.f29899i = str;
    }

    public String e() {
        return this.f29899i;
    }

    public void f(String str) {
        this.f29901k = str;
    }

    public void g(String str) {
        this.f29903m = str;
    }

    public d(int i7) {
        this(i7, 33);
    }

    public void a(int i7) {
        this.f29896f = i7;
    }

    public void b(int i7) {
        this.f29902l = i7;
    }

    public void c(int i7) {
        this.f29904n = i7;
    }

    public void d(int i7) {
        this.f29905o = i7;
    }

    public void e(String str) {
        this.f29900j = str;
    }

    public d(int i7, int i8) {
        this.f29902l = i7;
        this.f29905o = i8;
    }

    public void a(long j7) {
        this.f29906p = j7;
    }
}
