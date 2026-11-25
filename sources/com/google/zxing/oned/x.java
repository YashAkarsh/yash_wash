package com.google.zxing.oned;

/* JADX INFO: loaded from: classes2.dex */
final class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f23977c = {1, 1, 2};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v f23978a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w f23979b = new w();

    x() {
    }

    com.google.zxing.r a(int i7, com.google.zxing.common.a aVar, int i8) throws com.google.zxing.m {
        int[] iArrN = y.n(aVar, i8, false, f23977c);
        try {
            return this.f23979b.b(i7, aVar, iArrN);
        } catch (com.google.zxing.q unused) {
            return this.f23978a.b(i7, aVar, iArrN);
        }
    }
}
