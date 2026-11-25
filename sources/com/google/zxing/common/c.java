package com.google.zxing.common;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f23529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23531c;

    public c(byte[] bArr) {
        this.f23529a = bArr;
    }

    public int a() {
        return ((this.f23529a.length - this.f23530b) * 8) - this.f23531c;
    }

    public int b() {
        return this.f23531c;
    }

    public int c() {
        return this.f23530b;
    }

    public int d(int i7) {
        if (i7 <= 0 || i7 > 32 || i7 > a()) {
            throw new IllegalArgumentException(String.valueOf(i7));
        }
        int i8 = this.f23531c;
        int i9 = 0;
        if (i8 > 0) {
            int i10 = 8 - i8;
            int i11 = i7 < i10 ? i7 : i10;
            int i12 = i10 - i11;
            byte[] bArr = this.f23529a;
            int i13 = this.f23530b;
            int i14 = (((255 >> (8 - i11)) << i12) & bArr[i13]) >> i12;
            i7 -= i11;
            int i15 = i8 + i11;
            this.f23531c = i15;
            if (i15 == 8) {
                this.f23531c = 0;
                this.f23530b = i13 + 1;
            }
            i9 = i14;
        }
        if (i7 <= 0) {
            return i9;
        }
        while (i7 >= 8) {
            int i16 = i9 << 8;
            byte[] bArr2 = this.f23529a;
            int i17 = this.f23530b;
            i9 = (bArr2[i17] & 255) | i16;
            this.f23530b = i17 + 1;
            i7 -= 8;
        }
        if (i7 <= 0) {
            return i9;
        }
        int i18 = 8 - i7;
        int i19 = (i9 << i7) | ((((255 >> i18) << i18) & this.f23529a[this.f23530b]) >> i18);
        this.f23531c += i7;
        return i19;
    }
}
