package com.google.zxing.aztec.encoder;

/* JADX INFO: loaded from: classes2.dex */
abstract class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final g f23394b = new e(null, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f23395a;

    g(g gVar) {
        this.f23395a = gVar;
    }

    final g a(int i7, int i8) {
        return new e(this, i7, i8);
    }

    final g b(int i7, int i8) {
        return new b(this, i7, i8);
    }

    abstract void c(com.google.zxing.common.a aVar, byte[] bArr);

    final g d() {
        return this.f23395a;
    }
}
