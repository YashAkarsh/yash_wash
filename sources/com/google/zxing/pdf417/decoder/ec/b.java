package com.google.zxing.pdf417.decoder.ec;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f24046f = new b(e2.a.f33514a, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f24047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f24048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f24049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f24050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24051e;

    private b(int i7, int i8) {
        this.f24051e = i7;
        this.f24047a = new int[i7];
        this.f24048b = new int[i7];
        int i9 = 1;
        for (int i10 = 0; i10 < i7; i10++) {
            this.f24047a[i10] = i9;
            i9 = (i9 * i8) % i7;
        }
        for (int i11 = 0; i11 < i7 - 1; i11++) {
            this.f24048b[this.f24047a[i11]] = i11;
        }
        this.f24049c = new c(this, new int[]{0});
        this.f24050d = new c(this, new int[]{1});
    }

    int a(int i7, int i8) {
        return (i7 + i8) % this.f24051e;
    }

    c b(int i7, int i8) {
        if (i7 < 0) {
            throw new IllegalArgumentException();
        }
        if (i8 == 0) {
            return this.f24049c;
        }
        int[] iArr = new int[i7 + 1];
        iArr[0] = i8;
        return new c(this, iArr);
    }

    int c(int i7) {
        return this.f24047a[i7];
    }

    c d() {
        return this.f24050d;
    }

    int e() {
        return this.f24051e;
    }

    c f() {
        return this.f24049c;
    }

    int g(int i7) {
        if (i7 != 0) {
            return this.f24047a[(this.f24051e - this.f24048b[i7]) - 1];
        }
        throw new ArithmeticException();
    }

    int h(int i7) {
        if (i7 != 0) {
            return this.f24048b[i7];
        }
        throw new IllegalArgumentException();
    }

    int i(int i7, int i8) {
        if (i7 == 0 || i8 == 0) {
            return 0;
        }
        int[] iArr = this.f24047a;
        int[] iArr2 = this.f24048b;
        return iArr[(iArr2[i7] + iArr2[i8]) % (this.f24051e - 1)];
    }

    int j(int i7, int i8) {
        int i9 = this.f24051e;
        return ((i7 + i9) - i8) % i9;
    }
}
