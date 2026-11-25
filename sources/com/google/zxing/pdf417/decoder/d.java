package com.google.zxing.pdf417.decoder;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f24005f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f24010e = -1;

    d(int i7, int i8, int i9, int i10) {
        this.f24006a = i7;
        this.f24007b = i8;
        this.f24008c = i9;
        this.f24009d = i10;
    }

    int a() {
        return this.f24008c;
    }

    int b() {
        return this.f24007b;
    }

    int c() {
        return this.f24010e;
    }

    int d() {
        return this.f24006a;
    }

    int e() {
        return this.f24009d;
    }

    int f() {
        return this.f24007b - this.f24006a;
    }

    boolean g() {
        return h(this.f24010e);
    }

    boolean h(int i7) {
        return i7 != -1 && this.f24008c == (i7 % 3) * 3;
    }

    void i(int i7) {
        this.f24010e = i7;
    }

    void j() {
        this.f24010e = ((this.f24009d / 30) * 3) + (this.f24008c / 3);
    }

    public String toString() {
        return this.f24010e + "|" + this.f24009d;
    }
}
