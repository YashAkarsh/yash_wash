package com.google.zxing.aztec.detector;

import com.google.zxing.common.b;
import com.google.zxing.common.i;
import com.google.zxing.common.reedsolomon.c;
import com.google.zxing.common.reedsolomon.e;
import com.google.zxing.m;
import com.google.zxing.t;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f23355g = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f23356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f23357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23361f;

    /* JADX INFO: renamed from: com.google.zxing.aztec.detector.a$a, reason: collision with other inner class name */
    static final class C0310a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f23362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f23363b;

        C0310a(int i7, int i8) {
            this.f23362a = i7;
            this.f23363b = i8;
        }

        int a() {
            return this.f23362a;
        }

        int b() {
            return this.f23363b;
        }

        t c() {
            return new t(a(), b());
        }

        public String toString() {
            return "<" + this.f23362a + ' ' + this.f23363b + h0.f35380f;
        }
    }

    public a(b bVar) {
        this.f23356a = bVar;
    }

    private static float c(t tVar, t tVar2) {
        return a2.a.a(tVar.c(), tVar.d(), tVar2.c(), tVar2.d());
    }

    private static float d(C0310a c0310a, C0310a c0310a2) {
        return a2.a.b(c0310a.a(), c0310a.b(), c0310a2.a(), c0310a2.b());
    }

    private static t[] e(t[] tVarArr, int i7, int i8) {
        float f8 = i8 / (i7 * 2.0f);
        float fC = tVarArr[0].c() - tVarArr[2].c();
        float fD = tVarArr[0].d() - tVarArr[2].d();
        float fC2 = (tVarArr[0].c() + tVarArr[2].c()) / 2.0f;
        float fD2 = (tVarArr[0].d() + tVarArr[2].d()) / 2.0f;
        float f9 = fC * f8;
        float f10 = fD * f8;
        t tVar = new t(fC2 + f9, fD2 + f10);
        t tVar2 = new t(fC2 - f9, fD2 - f10);
        float fC3 = tVarArr[1].c() - tVarArr[3].c();
        float fD3 = tVarArr[1].d() - tVarArr[3].d();
        float fC4 = (tVarArr[1].c() + tVarArr[3].c()) / 2.0f;
        float fD4 = (tVarArr[1].d() + tVarArr[3].d()) / 2.0f;
        float f11 = fC3 * f8;
        float f12 = f8 * fD3;
        return new t[]{tVar, new t(fC4 + f11, fD4 + f12), tVar2, new t(fC4 - f11, fD4 - f12)};
    }

    private void f(t[] tVarArr) throws m {
        long j7;
        long j8;
        if (!p(tVarArr[0]) || !p(tVarArr[1]) || !p(tVarArr[2]) || !p(tVarArr[3])) {
            throw m.a();
        }
        int i7 = this.f23360e * 2;
        int[] iArr = {s(tVarArr[0], tVarArr[1], i7), s(tVarArr[1], tVarArr[2], i7), s(tVarArr[2], tVarArr[3], i7), s(tVarArr[3], tVarArr[0], i7)};
        this.f23361f = n(iArr, i7);
        long j9 = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            int i9 = iArr[(this.f23361f + i8) % 4];
            if (this.f23357b) {
                j7 = j9 << 7;
                j8 = (i9 >> 1) & 127;
            } else {
                j7 = j9 << 10;
                j8 = ((i9 >> 2) & 992) + ((i9 >> 1) & 31);
            }
            j9 = j7 + j8;
        }
        int i10 = i(j9, this.f23357b);
        if (this.f23357b) {
            this.f23358c = (i10 >> 6) + 1;
            this.f23359d = (i10 & 63) + 1;
        } else {
            this.f23358c = (i10 >> 11) + 1;
            this.f23359d = (i10 & 2047) + 1;
        }
    }

    private t[] g(C0310a c0310a) throws m {
        this.f23360e = 1;
        C0310a c0310a2 = c0310a;
        C0310a c0310a3 = c0310a2;
        C0310a c0310a4 = c0310a3;
        boolean z7 = true;
        while (this.f23360e < 9) {
            C0310a c0310aK = k(c0310a, z7, 1, -1);
            C0310a c0310aK2 = k(c0310a2, z7, 1, 1);
            C0310a c0310aK3 = k(c0310a3, z7, -1, 1);
            C0310a c0310aK4 = k(c0310a4, z7, -1, -1);
            if (this.f23360e > 2) {
                double d8 = (d(c0310aK4, c0310aK) * this.f23360e) / (d(c0310a4, c0310a) * (this.f23360e + 2));
                if (d8 < 0.75d || d8 > 1.25d || !q(c0310aK, c0310aK2, c0310aK3, c0310aK4)) {
                    break;
                }
            }
            z7 = !z7;
            this.f23360e++;
            c0310a4 = c0310aK4;
            c0310a = c0310aK;
            c0310a2 = c0310aK2;
            c0310a3 = c0310aK3;
        }
        int i7 = this.f23360e;
        if (i7 != 5 && i7 != 7) {
            throw m.a();
        }
        this.f23357b = i7 == 5;
        t[] tVarArr = {new t(c0310a.a() + 0.5f, c0310a.b() - 0.5f), new t(c0310a2.a() + 0.5f, c0310a2.b() + 0.5f), new t(c0310a3.a() - 0.5f, c0310a3.b() + 0.5f), new t(c0310a4.a() - 0.5f, c0310a4.b() - 0.5f)};
        int i8 = this.f23360e;
        return e(tVarArr, (i8 * 2) - 3, i8 * 2);
    }

    private int h(C0310a c0310a, C0310a c0310a2) {
        float fD = d(c0310a, c0310a2);
        float fA = (c0310a2.a() - c0310a.a()) / fD;
        float fB = (c0310a2.b() - c0310a.b()) / fD;
        float fA2 = c0310a.a();
        float fB2 = c0310a.b();
        boolean zJ = this.f23356a.j(c0310a.a(), c0310a.b());
        int iCeil = (int) Math.ceil(fD);
        int i7 = 0;
        for (int i8 = 0; i8 < iCeil; i8++) {
            fA2 += fA;
            fB2 += fB;
            if (this.f23356a.j(a2.a.c(fA2), a2.a.c(fB2)) != zJ) {
                i7++;
            }
        }
        float f8 = i7 / fD;
        if (f8 <= 0.1f || f8 >= 0.9f) {
            return (f8 <= 0.1f) == zJ ? 1 : -1;
        }
        return 0;
    }

    private static int i(long j7, boolean z7) throws m {
        int i7;
        int i8;
        if (z7) {
            i7 = 7;
            i8 = 2;
        } else {
            i7 = 10;
            i8 = 4;
        }
        int i9 = i7 - i8;
        int[] iArr = new int[i7];
        for (int i10 = i7 - 1; i10 >= 0; i10--) {
            iArr[i10] = ((int) j7) & 15;
            j7 >>= 4;
        }
        try {
            new c(com.google.zxing.common.reedsolomon.a.f23602k).a(iArr, i9);
            int i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                i11 = (i11 << 4) + iArr[i12];
            }
            return i11;
        } catch (e unused) {
            throw m.a();
        }
    }

    private int j() {
        if (this.f23357b) {
            return (this.f23358c * 4) + 11;
        }
        int i7 = this.f23358c;
        return i7 <= 4 ? (i7 * 4) + 15 : (i7 * 4) + ((((i7 - 4) / 8) + 1) * 2) + 15;
    }

    private C0310a k(C0310a c0310a, boolean z7, int i7, int i8) {
        int iA = c0310a.a() + i7;
        int iB = c0310a.b();
        while (true) {
            iB += i8;
            if (!o(iA, iB) || this.f23356a.j(iA, iB) != z7) {
                break;
            }
            iA += i7;
        }
        int i9 = iA - i7;
        int i10 = iB - i8;
        while (o(i9, i10) && this.f23356a.j(i9, i10) == z7) {
            i9 += i7;
        }
        int i11 = i9 - i7;
        while (o(i11, i10) && this.f23356a.j(i11, i10) == z7) {
            i10 += i8;
        }
        return new C0310a(i11, i10 - i8);
    }

    private C0310a l() {
        t tVarC;
        t tVar;
        t tVar2;
        t tVar3;
        t tVarC2;
        t tVarC3;
        t tVarC4;
        t tVarC5;
        try {
            t[] tVarArrC = new a2.c(this.f23356a).c();
            tVar2 = tVarArrC[0];
            tVar3 = tVarArrC[1];
            tVar = tVarArrC[2];
            tVarC = tVarArrC[3];
        } catch (m unused) {
            int iQ = this.f23356a.q() / 2;
            int iM = this.f23356a.m() / 2;
            int i7 = iQ + 7;
            int i8 = iM - 7;
            t tVarC6 = k(new C0310a(i7, i8), false, 1, -1).c();
            int i9 = iM + 7;
            t tVarC7 = k(new C0310a(i7, i9), false, 1, 1).c();
            int i10 = iQ - 7;
            t tVarC8 = k(new C0310a(i10, i9), false, -1, 1).c();
            tVarC = k(new C0310a(i10, i8), false, -1, -1).c();
            tVar = tVarC8;
            tVar2 = tVarC6;
            tVar3 = tVarC7;
        }
        int iC = a2.a.c((((tVar2.c() + tVarC.c()) + tVar3.c()) + tVar.c()) / 4.0f);
        int iC2 = a2.a.c((((tVar2.d() + tVarC.d()) + tVar3.d()) + tVar.d()) / 4.0f);
        try {
            t[] tVarArrC2 = new a2.c(this.f23356a, 15, iC, iC2).c();
            tVarC2 = tVarArrC2[0];
            tVarC3 = tVarArrC2[1];
            tVarC4 = tVarArrC2[2];
            tVarC5 = tVarArrC2[3];
        } catch (m unused2) {
            int i11 = iC + 7;
            int i12 = iC2 - 7;
            tVarC2 = k(new C0310a(i11, i12), false, 1, -1).c();
            int i13 = iC2 + 7;
            tVarC3 = k(new C0310a(i11, i13), false, 1, 1).c();
            int i14 = iC - 7;
            tVarC4 = k(new C0310a(i14, i13), false, -1, 1).c();
            tVarC5 = k(new C0310a(i14, i12), false, -1, -1).c();
        }
        return new C0310a(a2.a.c((((tVarC2.c() + tVarC5.c()) + tVarC3.c()) + tVarC4.c()) / 4.0f), a2.a.c((((tVarC2.d() + tVarC5.d()) + tVarC3.d()) + tVarC4.d()) / 4.0f));
    }

    private t[] m(t[] tVarArr) {
        return e(tVarArr, this.f23360e * 2, j());
    }

    private static int n(int[] iArr, int i7) throws m {
        int i8 = 0;
        for (int i9 : iArr) {
            i8 = (i8 << 3) + ((i9 >> (i7 - 2)) << 1) + (i9 & 1);
        }
        int i10 = ((i8 & 1) << 11) + (i8 >> 1);
        for (int i11 = 0; i11 < 4; i11++) {
            if (Integer.bitCount(f23355g[i11] ^ i10) <= 2) {
                return i11;
            }
        }
        throw m.a();
    }

    private boolean o(int i7, int i8) {
        return i7 >= 0 && i7 < this.f23356a.q() && i8 > 0 && i8 < this.f23356a.m();
    }

    private boolean p(t tVar) {
        return o(a2.a.c(tVar.c()), a2.a.c(tVar.d()));
    }

    private boolean q(C0310a c0310a, C0310a c0310a2, C0310a c0310a3, C0310a c0310a4) {
        C0310a c0310a5 = new C0310a(c0310a.a() - 3, c0310a.b() + 3);
        C0310a c0310a6 = new C0310a(c0310a2.a() - 3, c0310a2.b() - 3);
        C0310a c0310a7 = new C0310a(c0310a3.a() + 3, c0310a3.b() - 3);
        C0310a c0310a8 = new C0310a(c0310a4.a() + 3, c0310a4.b() + 3);
        int iH = h(c0310a8, c0310a5);
        return iH != 0 && h(c0310a5, c0310a6) == iH && h(c0310a6, c0310a7) == iH && h(c0310a7, c0310a8) == iH;
    }

    private b r(b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        i iVarB = i.b();
        int iJ = j();
        float f8 = iJ / 2.0f;
        int i7 = this.f23360e;
        float f9 = f8 - i7;
        float f10 = f8 + i7;
        return iVarB.c(bVar, iJ, iJ, f9, f9, f10, f9, f10, f10, f9, f10, tVar.c(), tVar.d(), tVar2.c(), tVar2.d(), tVar3.c(), tVar3.d(), tVar4.c(), tVar4.d());
    }

    private int s(t tVar, t tVar2, int i7) {
        float fC = c(tVar, tVar2);
        float f8 = fC / i7;
        float fC2 = tVar.c();
        float fD = tVar.d();
        float fC3 = ((tVar2.c() - tVar.c()) * f8) / fC;
        float fD2 = (f8 * (tVar2.d() - tVar.d())) / fC;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            float f9 = i9;
            if (this.f23356a.j(a2.a.c((f9 * fC3) + fC2), a2.a.c((f9 * fD2) + fD))) {
                i8 |= 1 << ((i7 - i9) - 1);
            }
        }
        return i8;
    }

    public z1.a a() throws m {
        return b(false);
    }

    public z1.a b(boolean z7) throws m {
        t[] tVarArrG = g(l());
        if (z7) {
            t tVar = tVarArrG[0];
            tVarArrG[0] = tVarArrG[2];
            tVarArrG[2] = tVar;
        }
        f(tVarArrG);
        b bVar = this.f23356a;
        int i7 = this.f23361f;
        return new z1.a(r(bVar, tVarArrG[i7 % 4], tVarArrG[(i7 + 1) % 4], tVarArrG[(i7 + 2) % 4], tVarArrG[(i7 + 3) % 4]), m(tVarArrG), this.f23357b, this.f23359d, this.f23358c);
    }
}
