package com.google.zxing.oned.rss;

import com.google.zxing.t;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f23892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t[] f23893c;

    public c(int i7, int[] iArr, int i8, int i9, int i10) {
        this.f23891a = i7;
        this.f23892b = iArr;
        float f8 = i10;
        this.f23893c = new t[]{new t(i8, f8), new t(i9, f8)};
    }

    public t[] a() {
        return this.f23893c;
    }

    public int[] b() {
        return this.f23892b;
    }

    public int c() {
        return this.f23891a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f23891a == ((c) obj).f23891a;
    }

    public int hashCode() {
        return this.f23891a;
    }
}
