package com.bumptech.glide.gifencoder;

import androidx.core.app.y;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f14088x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final int f14089y = 12;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f14090z = 5003;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f14093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f14097g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f14099i;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f14106p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f14107q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f14108r;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f14112v;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f14098h = 12;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f14100j = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int[] f14101k = new int[5003];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int[] f14102l = new int[5003];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f14103m = 5003;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f14104n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f14105o = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f14109s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f14110t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int[] f14111u = {0, 1, 3, 7, 15, 31, 63, 127, 255, y.f5559u, 1023, 2047, 4095, 8191, 16383, 32767, 65535};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    byte[] f14113w = new byte[256];

    b(int i7, int i8, byte[] bArr, int i9) {
        this.f14091a = i7;
        this.f14092b = i8;
        this.f14093c = bArr;
        this.f14094d = Math.max(2, i9);
    }

    private int h() {
        int i7 = this.f14095e;
        if (i7 == 0) {
            return -1;
        }
        this.f14095e = i7 - 1;
        byte[] bArr = this.f14093c;
        int i8 = this.f14096f;
        this.f14096f = i8 + 1;
        return bArr[i8] & 255;
    }

    final int a(int i7) {
        return (1 << i7) - 1;
    }

    void b(byte b8, OutputStream outputStream) throws IOException {
        byte[] bArr = this.f14113w;
        int i7 = this.f14112v;
        int i8 = i7 + 1;
        this.f14112v = i8;
        bArr[i7] = b8;
        if (i8 >= 254) {
            g(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        d(this.f14103m);
        int i7 = this.f14107q;
        this.f14104n = i7 + 2;
        this.f14105o = true;
        i(i7, outputStream);
    }

    void d(int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            this.f14101k[i8] = -1;
        }
    }

    void e(int i7, OutputStream outputStream) throws IOException {
        this.f14106p = i7;
        int i8 = 0;
        this.f14105o = false;
        this.f14097g = i7;
        this.f14099i = a(i7);
        int i9 = 1 << (i7 - 1);
        this.f14107q = i9;
        this.f14108r = i9 + 1;
        this.f14104n = i9 + 2;
        this.f14112v = 0;
        int iH = h();
        for (int i10 = this.f14103m; i10 < 65536; i10 *= 2) {
            i8++;
        }
        int i11 = 8 - i8;
        int i12 = this.f14103m;
        d(i12);
        i(this.f14107q, outputStream);
        while (true) {
            int iH2 = h();
            if (iH2 == -1) {
                i(iH, outputStream);
                i(this.f14108r, outputStream);
                return;
            }
            int i13 = (iH2 << this.f14098h) + iH;
            int i14 = (iH2 << i11) ^ iH;
            int i15 = this.f14101k[i14];
            if (i15 == i13) {
                iH = this.f14102l[i14];
            } else {
                if (i15 >= 0) {
                    int i16 = i12 - i14;
                    if (i14 == 0) {
                        i16 = 1;
                    }
                    while (true) {
                        i14 -= i16;
                        if (i14 < 0) {
                            i14 += i12;
                        }
                        int i17 = this.f14101k[i14];
                        if (i17 == i13) {
                            iH = this.f14102l[i14];
                        } else if (i17 < 0) {
                        }
                    }
                }
                i(iH, outputStream);
                int i18 = this.f14104n;
                if (i18 < this.f14100j) {
                    int[] iArr = this.f14102l;
                    this.f14104n = i18 + 1;
                    iArr[i14] = i18;
                    this.f14101k[i14] = i13;
                } else {
                    c(outputStream);
                }
                iH = iH2;
            }
        }
    }

    void f(OutputStream outputStream) throws IOException {
        outputStream.write(this.f14094d);
        this.f14095e = this.f14091a * this.f14092b;
        this.f14096f = 0;
        e(this.f14094d + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        int i7 = this.f14112v;
        if (i7 > 0) {
            outputStream.write(i7);
            outputStream.write(this.f14113w, 0, this.f14112v);
            this.f14112v = 0;
        }
    }

    void i(int i7, OutputStream outputStream) throws IOException {
        int i8 = this.f14109s;
        int[] iArr = this.f14111u;
        int i9 = this.f14110t;
        int i10 = i8 & iArr[i9];
        this.f14109s = i10;
        if (i9 > 0) {
            this.f14109s = i10 | (i7 << i9);
        } else {
            this.f14109s = i7;
        }
        this.f14110t = i9 + this.f14097g;
        while (this.f14110t >= 8) {
            b((byte) (this.f14109s & 255), outputStream);
            this.f14109s >>= 8;
            this.f14110t -= 8;
        }
        if (this.f14104n > this.f14099i || this.f14105o) {
            if (this.f14105o) {
                int i11 = this.f14106p;
                this.f14097g = i11;
                this.f14099i = a(i11);
                this.f14105o = false;
            } else {
                int i12 = this.f14097g + 1;
                this.f14097g = i12;
                if (i12 == this.f14098h) {
                    this.f14099i = this.f14100j;
                } else {
                    this.f14099i = a(i12);
                }
            }
        }
        if (i7 == this.f14108r) {
            while (this.f14110t > 0) {
                b((byte) (this.f14109s & 255), outputStream);
                this.f14109s >>= 8;
                this.f14110t -= 8;
            }
            g(outputStream);
        }
    }
}
