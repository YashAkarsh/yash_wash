package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
final class o extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f23957d;

    o(int i7, String str) {
        super(i7);
        this.f23955b = str;
        this.f23957d = false;
        this.f23956c = 0;
    }

    String b() {
        return this.f23955b;
    }

    int c() {
        return this.f23956c;
    }

    boolean d() {
        return this.f23957d;
    }

    o(int i7, String str, int i8) {
        super(i7);
        this.f23957d = true;
        this.f23956c = i8;
        this.f23955b = str;
    }
}
