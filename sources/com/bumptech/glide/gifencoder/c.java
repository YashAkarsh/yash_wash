package com.bumptech.glide.gifencoder;

/* JADX INFO: loaded from: classes.dex */
class c {
    protected static final int A = 6;
    protected static final int B = 64;
    protected static final int C = 2048;
    protected static final int D = 30;
    protected static final int E = 10;
    protected static final int F = 1024;
    protected static final int G = 8;
    protected static final int H = 256;
    protected static final int I = 18;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    protected static final int f14114J = 262144;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected static final int f14115j = 256;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static final int f14116k = 499;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected static final int f14117l = 491;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected static final int f14118m = 487;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static final int f14119n = 503;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected static final int f14120o = 1509;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected static final int f14121p = 255;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected static final int f14122q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected static final int f14123r = 100;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected static final int f14124s = 16;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected static final int f14125t = 65536;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected static final int f14126u = 10;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected static final int f14127v = 1024;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected static final int f14128w = 10;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected static final int f14129x = 64;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected static final int f14130y = 65536;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected static final int f14131z = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f14132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected byte[] f14133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f14134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f14135d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int[] f14137f = new int[256];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int[] f14138g = new int[256];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int[] f14139h = new int[256];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int[] f14140i = new int[32];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int[][] f14136e = new int[256][];

    public c(byte[] bArr, int i7, int i8) {
        this.f14133b = bArr;
        this.f14134c = i7;
        this.f14135d = i8;
        for (int i9 = 0; i9 < 256; i9++) {
            int[] iArr = new int[4];
            this.f14136e[i9] = iArr;
            iArr[2] = (i9 << 12) / 256;
            this.f14139h[i9] = 256;
            this.f14138g[i9] = 0;
        }
    }

    protected void a(int i7, int i8, int i9, int i10, int i11) {
        int i12 = i8 - i7;
        if (i12 < -1) {
            i12 = -1;
        }
        int i13 = i8 + i7;
        if (i13 > 256) {
            i13 = 256;
        }
        int i14 = i8 + 1;
        int i15 = i8 - 1;
        int i16 = 1;
        while (true) {
            if (i14 >= i13 && i15 <= i12) {
                return;
            }
            i16++;
            int i17 = this.f14140i[i16];
            if (i14 < i13) {
                int i18 = i14 + 1;
                int[] iArr = this.f14136e[i14];
                try {
                    int i19 = iArr[0];
                    iArr[0] = i19 - (((i19 - i9) * i17) / 262144);
                    int i20 = iArr[1];
                    iArr[1] = i20 - (((i20 - i10) * i17) / 262144);
                    int i21 = iArr[2];
                    iArr[2] = i21 - (((i21 - i11) * i17) / 262144);
                } catch (Exception unused) {
                }
                i14 = i18;
            }
            if (i15 > i12) {
                int i22 = i15 - 1;
                int[] iArr2 = this.f14136e[i15];
                try {
                    int i23 = iArr2[0];
                    iArr2[0] = i23 - (((i23 - i9) * i17) / 262144);
                    int i24 = iArr2[1];
                    iArr2[1] = i24 - (((i24 - i10) * i17) / 262144);
                    int i25 = iArr2[2];
                    iArr2[2] = i25 - ((i17 * (i25 - i11)) / 262144);
                } catch (Exception unused2) {
                }
                i15 = i22;
            }
        }
    }

    protected void b(int i7, int i8, int i9, int i10, int i11) {
        int[] iArr = this.f14136e[i8];
        int i12 = iArr[0];
        iArr[0] = i12 - (((i12 - i9) * i7) / 1024);
        int i13 = iArr[1];
        iArr[1] = i13 - (((i13 - i10) * i7) / 1024);
        int i14 = iArr[2];
        iArr[2] = i14 - ((i7 * (i14 - i11)) / 1024);
    }

    public byte[] c() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i7 = 0; i7 < 256; i7++) {
            iArr[this.f14136e[i7][3]] = i7;
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < 256) {
            int i10 = i9 + 1;
            int[] iArr2 = this.f14136e[iArr[i8]];
            bArr[i9] = (byte) iArr2[0];
            int i11 = i10 + 1;
            bArr[i10] = (byte) iArr2[1];
            bArr[i11] = (byte) iArr2[2];
            i8++;
            i9 = i11 + 1;
        }
        return bArr;
    }

    protected int d(int i7, int i8, int i9) {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        int i12 = -1;
        int i13 = Integer.MAX_VALUE;
        for (int i14 = 0; i14 < 256; i14++) {
            int[] iArr = this.f14136e[i14];
            int i15 = iArr[0] - i7;
            if (i15 < 0) {
                i15 = -i15;
            }
            int i16 = iArr[1] - i8;
            if (i16 < 0) {
                i16 = -i16;
            }
            int i17 = i15 + i16;
            int i18 = iArr[2] - i9;
            if (i18 < 0) {
                i18 = -i18;
            }
            int i19 = i17 + i18;
            if (i19 < i10) {
                i11 = i14;
                i10 = i19;
            }
            int[] iArr2 = this.f14138g;
            int i20 = i19 - (iArr2[i14] >> 12);
            if (i20 < i13) {
                i12 = i14;
                i13 = i20;
            }
            int[] iArr3 = this.f14139h;
            int i21 = iArr3[i14];
            int i22 = i21 >> 10;
            iArr3[i14] = i21 - i22;
            iArr2[i14] = iArr2[i14] + (i22 << 10);
        }
        int[] iArr4 = this.f14139h;
        iArr4[i11] = iArr4[i11] + 64;
        int[] iArr5 = this.f14138g;
        iArr5[i11] = iArr5[i11] - 65536;
        return i12;
    }

    public void e() {
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < 256) {
            int[] iArr = this.f14136e[i7];
            int i10 = iArr[1];
            int i11 = i7 + 1;
            int i12 = i7;
            for (int i13 = i11; i13 < 256; i13++) {
                int i14 = this.f14136e[i13][1];
                if (i14 < i10) {
                    i12 = i13;
                    i10 = i14;
                }
            }
            int[] iArr2 = this.f14136e[i12];
            if (i7 != i12) {
                int i15 = iArr2[0];
                iArr2[0] = iArr[0];
                iArr[0] = i15;
                int i16 = iArr2[1];
                iArr2[1] = iArr[1];
                iArr[1] = i16;
                int i17 = iArr2[2];
                iArr2[2] = iArr[2];
                iArr[2] = i17;
                int i18 = iArr2[3];
                iArr2[3] = iArr[3];
                iArr[3] = i18;
            }
            if (i10 != i8) {
                this.f14137f[i8] = (i9 + i7) >> 1;
                while (true) {
                    i8++;
                    if (i8 >= i10) {
                        break;
                    } else {
                        this.f14137f[i8] = i7;
                    }
                }
                i9 = i7;
                i8 = i10;
            }
            i7 = i11;
        }
        this.f14137f[i8] = (i9 + 255) >> 1;
        for (int i19 = i8 + 1; i19 < 256; i19++) {
            this.f14137f[i19] = 255;
        }
    }

    public void f() {
        int i7;
        int i8 = this.f14134c;
        int i9 = f14120o;
        if (i8 < f14120o) {
            this.f14135d = 1;
        }
        int i10 = this.f14135d;
        this.f14132a = ((i10 - 1) / 3) + 30;
        byte[] bArr = this.f14133b;
        int i11 = i8 / (i10 * 3);
        int i12 = i11 / 100;
        for (int i13 = 0; i13 < 32; i13++) {
            this.f14140i[i13] = 1024 * (((1024 - (i13 * i13)) * 256) / 1024);
        }
        int i14 = this.f14134c;
        if (i14 < f14120o) {
            i7 = 3;
        } else {
            if (i14 % f14116k != 0) {
                i9 = 1497;
            } else if (i14 % f14117l != 0) {
                i9 = 1473;
            } else if (i14 % f14118m != 0) {
                i9 = 1461;
            }
            i7 = i9;
        }
        int i15 = 2048;
        int i16 = i12;
        int i17 = 1024;
        int i18 = 32;
        int i19 = 0;
        int i20 = 0;
        while (i19 < i11) {
            int i21 = (bArr[i20 + 0] & 255) << 4;
            int i22 = (bArr[i20 + 1] & 255) << 4;
            int i23 = (bArr[i20 + 2] & 255) << 4;
            int iD = d(i21, i22, i23);
            int i24 = i19;
            b(i17, iD, i21, i22, i23);
            if (i18 != 0) {
                a(i18, iD, i21, i22, i23);
            }
            int i25 = i20 + i7;
            if (i25 >= i8) {
                i25 -= this.f14134c;
            }
            i20 = i25;
            i19 = i24 + 1;
            if (i16 == 0) {
                i16 = 1;
            }
            if (i19 % i16 == 0) {
                i17 -= i17 / this.f14132a;
                i15 -= i15 / 30;
                int i26 = i15 >> 6;
                if (i26 <= 1) {
                    i26 = 0;
                }
                for (int i27 = 0; i27 < i26; i27++) {
                    int i28 = i26 * i26;
                    this.f14140i[i27] = (((i28 - (i27 * i27)) * 256) / i28) * i17;
                }
                i18 = i26;
            }
        }
    }

    public int g(int i7, int i8, int i9) {
        int i10 = this.f14137f[i8];
        int i11 = i10 - 1;
        int i12 = 1000;
        int i13 = -1;
        while (true) {
            if (i10 >= 256 && i11 < 0) {
                return i13;
            }
            if (i10 < 256) {
                int[] iArr = this.f14136e[i10];
                int i14 = iArr[1] - i8;
                if (i14 >= i12) {
                    i10 = 256;
                } else {
                    i10++;
                    if (i14 < 0) {
                        i14 = -i14;
                    }
                    int i15 = iArr[0] - i7;
                    if (i15 < 0) {
                        i15 = -i15;
                    }
                    int i16 = i14 + i15;
                    if (i16 < i12) {
                        int i17 = iArr[2] - i9;
                        if (i17 < 0) {
                            i17 = -i17;
                        }
                        int i18 = i16 + i17;
                        if (i18 < i12) {
                            i13 = iArr[3];
                            i12 = i18;
                        }
                    }
                }
            }
            if (i11 >= 0) {
                int[] iArr2 = this.f14136e[i11];
                int i19 = i8 - iArr2[1];
                if (i19 >= i12) {
                    i11 = -1;
                } else {
                    i11--;
                    if (i19 < 0) {
                        i19 = -i19;
                    }
                    int i20 = iArr2[0] - i7;
                    if (i20 < 0) {
                        i20 = -i20;
                    }
                    int i21 = i19 + i20;
                    if (i21 < i12) {
                        int i22 = iArr2[2] - i9;
                        if (i22 < 0) {
                            i22 = -i22;
                        }
                        int i23 = i22 + i21;
                        if (i23 < i12) {
                            i13 = iArr2[3];
                            i12 = i23;
                        }
                    }
                }
            }
        }
    }

    public byte[] h() {
        f();
        i();
        e();
        return c();
    }

    public void i() {
        for (int i7 = 0; i7 < 256; i7++) {
            int[] iArr = this.f14136e[i7];
            iArr[0] = iArr[0] >> 4;
            iArr[1] = iArr[1] >> 4;
            iArr[2] = iArr[2] >> 4;
            iArr[3] = i7;
        }
    }
}
