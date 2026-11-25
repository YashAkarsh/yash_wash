package com.google.zxing.datamatrix.decoder;

import com.google.zxing.h;
import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final e[] f23640h = a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f23646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f23647g;

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f23648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f23649b;

        int a() {
            return this.f23648a;
        }

        int b() {
            return this.f23649b;
        }

        private b(int i7, int i8) {
            this.f23648a = i7;
            this.f23649b = i8;
        }
    }

    private e(int i7, int i8, int i9, int i10, int i11, c cVar) {
        this.f23641a = i7;
        this.f23642b = i8;
        this.f23643c = i9;
        this.f23644d = i10;
        this.f23645e = i11;
        this.f23646f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.f23647g = iA;
    }

    private static e[] a() {
        int i7 = 8;
        int i8 = 1;
        int i9 = 5;
        e eVar = new e(3, 14, 14, 12, 12, new c(10, new b(i8, i7)));
        int i10 = 2;
        int i11 = 12;
        int i12 = 18;
        e eVar2 = new e(7, 22, 22, 20, 20, new c(20, new b(i8, 30)));
        int i13 = 6;
        int i14 = 36;
        int i15 = 62;
        int i16 = 56;
        int i17 = 68;
        b bVar = new b(i8, 5);
        b bVar2 = new b(i8, 10);
        b bVar3 = new b(i8, 16);
        return new e[]{new e(1, 10, 10, 8, 8, new c(i9, new b(i8, 3))), new e(2, 12, 12, 10, 10, new c(7, new b(i8, i9))), eVar, new e(4, 16, 16, 14, 14, new c(i11, new b(i8, i11))), new e(5, 18, 18, 16, 16, new c(14, new b(i8, i12))), new e(6, 20, 20, 18, 18, new c(i12, new b(i8, 22))), eVar2, new e(8, 24, 24, 22, 22, new c(24, new b(i8, i14))), new e(9, 26, 26, 24, 24, new c(28, new b(i8, 44))), new e(10, 32, 32, 14, 14, new c(i14, new b(i8, i15))), new e(11, 36, 36, 16, 16, new c(42, new b(i8, 86))), new e(12, 40, 40, 18, 18, new c(48, new b(i8, 114))), new e(13, 44, 44, 20, 20, new c(i16, new b(i8, 144))), new e(14, 48, 48, 22, 22, new c(i17, new b(i8, 174))), new e(15, 52, 52, 24, 24, new c(42, new b(i10, 102))), new e(16, 64, 64, 14, 14, new c(i16, new b(i10, 140))), new e(17, 72, 72, 16, 16, new c(i14, new b(4, 92))), new e(18, 80, 80, 18, 18, new c(48, new b(4, 114))), new e(19, 88, 88, 20, 20, new c(i16, new b(4, 144))), new e(20, 96, 96, 22, 22, new c(i17, new b(4, 174))), new e(21, 104, 104, 24, 24, new c(i16, new b(i13, 136))), new e(22, 120, 120, 18, 18, new c(i17, new b(i13, 175))), new e(23, 132, 132, 20, 20, new c(i15, new b(i7, 163))), new e(24, 144, 144, 22, 22, new c(i15, new b(i7, Constants.ACTION_DELAY_PASSWORD_FOUND), new b(i10, Constants.ACTION_START_NB_OTP))), new e(25, 8, 18, 6, 16, new c(7, bVar)), new e(26, 8, 32, 6, 14, new c(11, bVar2)), new e(27, 12, 26, 10, 24, new c(14, bVar3)), new e(28, 12, 36, 10, 16, new c(i12, new b(i8, 22))), new e(29, 16, 36, 14, 16, new c(24, new b(i8, 32))), new e(30, 16, 48, 14, 22, new c(28, new b(i8, 49)))};
    }

    public static e h(int i7, int i8) throws h {
        if ((i7 & 1) != 0 || (i8 & 1) != 0) {
            throw h.a();
        }
        for (e eVar : f23640h) {
            if (eVar.f23642b == i7 && eVar.f23643c == i8) {
                return eVar;
            }
        }
        throw h.a();
    }

    public int b() {
        return this.f23645e;
    }

    public int c() {
        return this.f23644d;
    }

    c d() {
        return this.f23646f;
    }

    public int e() {
        return this.f23643c;
    }

    public int f() {
        return this.f23642b;
    }

    public int g() {
        return this.f23647g;
    }

    public int i() {
        return this.f23641a;
    }

    public String toString() {
        return String.valueOf(this.f23641a);
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f23650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b[] f23651b;

        b[] a() {
            return this.f23651b;
        }

        int b() {
            return this.f23650a;
        }

        private c(int i7, b bVar) {
            this.f23650a = i7;
            this.f23651b = new b[]{bVar};
        }

        private c(int i7, b bVar, b bVar2) {
            this.f23650a = i7;
            this.f23651b = new b[]{bVar, bVar2};
        }
    }
}
