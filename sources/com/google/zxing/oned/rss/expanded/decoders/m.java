package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23947a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f23948b = a.NUMERIC;

    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    m() {
    }

    int a() {
        return this.f23947a;
    }

    void b(int i7) {
        this.f23947a += i7;
    }

    boolean c() {
        return this.f23948b == a.ALPHA;
    }

    boolean d() {
        return this.f23948b == a.ISO_IEC_646;
    }

    boolean e() {
        return this.f23948b == a.NUMERIC;
    }

    void f() {
        this.f23948b = a.ALPHA;
    }

    void g() {
        this.f23948b = a.ISO_IEC_646;
    }

    void h() {
        this.f23948b = a.NUMERIC;
    }

    void i(int i7) {
        this.f23947a = i7;
    }
}
