package com.google.zxing.common.reedsolomon;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f23599h = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f23600i = new a(1033, 1024, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f23601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f23602k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f23603l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f23604m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f23605n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f23606o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f23607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f23608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f23609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f23610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f23612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f23613g;

    static {
        a aVar = new a(67, 64, 1);
        f23601j = aVar;
        f23602k = new a(19, 16, 1);
        f23603l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f23604m = aVar2;
        f23605n = aVar2;
        f23606o = aVar;
    }

    public a(int i7, int i8, int i9) {
        this.f23612f = i7;
        this.f23611e = i8;
        this.f23613g = i9;
        this.f23607a = new int[i8];
        this.f23608b = new int[i8];
        int i10 = 1;
        for (int i11 = 0; i11 < i8; i11++) {
            this.f23607a[i11] = i10;
            i10 <<= 1;
            if (i10 >= i8) {
                i10 = (i10 ^ i7) & (i8 - 1);
            }
        }
        for (int i12 = 0; i12 < i8 - 1; i12++) {
            this.f23608b[this.f23607a[i12]] = i12;
        }
        this.f23609c = new b(this, new int[]{0});
        this.f23610d = new b(this, new int[]{1});
    }

    static int a(int i7, int i8) {
        return i7 ^ i8;
    }

    b b(int i7, int i8) {
        if (i7 < 0) {
            throw new IllegalArgumentException();
        }
        if (i8 == 0) {
            return this.f23609c;
        }
        int[] iArr = new int[i7 + 1];
        iArr[0] = i8;
        return new b(this, iArr);
    }

    int c(int i7) {
        return this.f23607a[i7];
    }

    public int d() {
        return this.f23613g;
    }

    b e() {
        return this.f23610d;
    }

    public int f() {
        return this.f23611e;
    }

    b g() {
        return this.f23609c;
    }

    int h(int i7) {
        if (i7 != 0) {
            return this.f23607a[(this.f23611e - this.f23608b[i7]) - 1];
        }
        throw new ArithmeticException();
    }

    int i(int i7) {
        if (i7 != 0) {
            return this.f23608b[i7];
        }
        throw new IllegalArgumentException();
    }

    int j(int i7, int i8) {
        if (i7 == 0 || i8 == 0) {
            return 0;
        }
        int[] iArr = this.f23607a;
        int[] iArr2 = this.f23608b;
        return iArr[(iArr2[i7] + iArr2[i8]) % (this.f23611e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f23612f) + ',' + this.f23611e + ')';
    }
}
