package com.google.zxing.pdf417.encoder;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f24072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24073b = 0;

    b(int i7) {
        this.f24072a = new byte[i7];
    }

    private void d(int i7, boolean z7) {
        this.f24072a[i7] = z7 ? (byte) 1 : (byte) 0;
    }

    void a(boolean z7, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = this.f24073b;
            this.f24073b = i9 + 1;
            d(i9, z7);
        }
    }

    byte[] b(int i7) {
        int length = this.f24072a.length * i7;
        byte[] bArr = new byte[length];
        for (int i8 = 0; i8 < length; i8++) {
            bArr[i8] = this.f24072a[i8 / i7];
        }
        return bArr;
    }

    void c(int i7, byte b8) {
        this.f24072a[i7] = b8;
    }
}
