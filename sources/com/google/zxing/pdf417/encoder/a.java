package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f24068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24071d;

    a(int i7, int i8) {
        b[] bVarArr = new b[i7];
        this.f24068a = bVarArr;
        int length = bVarArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            this.f24068a[i9] = new b(((i8 + 4) * 17) + 1);
        }
        this.f24071d = i8 * 17;
        this.f24070c = i7;
        this.f24069b = -1;
    }

    b a() {
        return this.f24068a[this.f24069b];
    }

    public byte[][] b() {
        return c(1, 1);
    }

    public byte[][] c(int i7, int i8) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f24070c * i8, this.f24071d * i7);
        int i9 = this.f24070c * i8;
        for (int i10 = 0; i10 < i9; i10++) {
            bArr[(i9 - i10) - 1] = this.f24068a[i10 / i8].b(i7);
        }
        return bArr;
    }

    void d(int i7, int i8, byte b8) {
        this.f24068a[i8].c(i7, b8);
    }

    void e() {
        this.f24069b++;
    }
}
