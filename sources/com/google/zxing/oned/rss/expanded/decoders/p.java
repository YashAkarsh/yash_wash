package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
final class p extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f23958d = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23960c;

    p(int i7, int i8, int i9) throws com.google.zxing.h {
        super(i7);
        if (i8 < 0 || i8 > 10 || i9 < 0 || i9 > 10) {
            throw com.google.zxing.h.a();
        }
        this.f23959b = i8;
        this.f23960c = i9;
    }

    int b() {
        return this.f23959b;
    }

    int c() {
        return this.f23960c;
    }

    int d() {
        return (this.f23959b * 10) + this.f23960c;
    }

    boolean e() {
        return this.f23959b == 10 || this.f23960c == 10;
    }

    boolean f() {
        return this.f23959b == 10;
    }

    boolean g() {
        return this.f23960c == 10;
    }
}
