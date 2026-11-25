package com.google.zxing.pdf417.decoder;

import com.google.zxing.m;
import com.google.zxing.t;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24064a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f24065b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f24066c = 512;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.google.zxing.pdf417.decoder.ec.a f24067d = new com.google.zxing.pdf417.decoder.ec.a();

    private j() {
    }

    private static c a(h hVar) throws m {
        int[] iArrJ;
        if (hVar == null || (iArrJ = hVar.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i7 = 0;
        int i8 = 0;
        for (int i9 : iArrJ) {
            i8 += iP - i9;
            if (i9 > 0) {
                break;
            }
        }
        d[] dVarArrD = hVar.d();
        for (int i10 = 0; i8 > 0 && dVarArrD[i10] == null; i10++) {
            i8--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            int i11 = iArrJ[length];
            i7 += iP - i11;
            if (i11 > 0) {
                break;
            }
        }
        for (int length2 = dVarArrD.length - 1; i7 > 0 && dVarArrD[length2] == null; length2--) {
            i7--;
        }
        return hVar.a().a(i8, i7, hVar.k());
    }

    private static void b(f fVar, b[][] bVarArr) throws m {
        b bVar = bVarArr[0][1];
        int[] iArrB = bVar.b();
        int iJ = (fVar.j() * fVar.l()) - r(fVar.k());
        if (iArrB.length != 0) {
            if (iArrB[0] != iJ) {
                bVar.c(iJ);
            }
        } else {
            if (iJ <= 0 || iJ > 928) {
                throw m.a();
            }
            bVar.c(iJ);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0011  */
    /* JADX WARN: Code duplicated, block: B:14:0x0017  */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[LOOP:1: B:8:0x000a->B:17:0x0020, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x001f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0022 A[EDGE_INSN: B:24:0x0022->B:18:0x0022 BREAK  A[LOOP:1: B:8:0x000a->B:17:0x0020], SYNTHETIC] */
    private static int c(com.google.zxing.common.b bVar, int i7, int i8, boolean z7, int i9, int i10) {
        int i11 = z7 ? -1 : 1;
        int i12 = i9;
        for (int i13 = 0; i13 < 2; i13++) {
            while (true) {
                if (!z7) {
                    if (i12 >= i8) {
                        break;
                    }
                    if (z7 == bVar.j(i12, i10)) {
                        break;
                        break;
                    }
                    if (Math.abs(i9 - i12) > 2) {
                        return i9;
                    }
                    i12 += i11;
                } else {
                    if (i12 < i7) {
                        break;
                    }
                    if (z7 == bVar.j(i12, i10)) {
                        break;
                    }
                    if (Math.abs(i9 - i12) > 2) {
                        return i9;
                    }
                    i12 += i11;
                }
            }
            i11 = -i11;
            z7 = !z7;
        }
        return i12;
    }

    private static boolean d(int i7, int i8, int i9) {
        return i8 + (-2) <= i7 && i7 <= i9 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i7) throws com.google.zxing.d {
        if ((iArr2 == null || iArr2.length <= (i7 / 2) + 3) && i7 >= 0 && i7 <= 512) {
            return f24067d.a(iArr, i7, iArr2);
        }
        throw com.google.zxing.d.a();
    }

    private static b[][] f(f fVar) {
        int iC;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, fVar.l(), fVar.j() + 2);
        for (b[] bVarArr2 : bVarArr) {
            int i7 = 0;
            while (true) {
                if (i7 < bVarArr2.length) {
                    bVarArr2[i7] = new b();
                    i7++;
                }
            }
        }
        int i8 = 0;
        for (g gVar : fVar.o()) {
            if (gVar != null) {
                for (d dVar : gVar.d()) {
                    if (dVar != null && (iC = dVar.c()) >= 0 && iC < bVarArr.length) {
                        bVarArr[iC][i8].c(dVar.e());
                    }
                }
            }
            i8++;
        }
        return bVarArr;
    }

    private static com.google.zxing.common.e g(f fVar) throws m, com.google.zxing.d, com.google.zxing.h {
        b[][] bVarArrF = f(fVar);
        b(fVar, bVarArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.l() * fVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i7 = 0; i7 < fVar.l(); i7++) {
            int i8 = 0;
            while (i8 < fVar.j()) {
                int i9 = i8 + 1;
                int[] iArrB = bVarArrF[i7][i9].b();
                int iJ = (fVar.j() * i7) + i8;
                if (iArrB.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrB.length == 1) {
                    iArr[iJ] = iArrB[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrB);
                }
                i8 = i9;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i10 = 0; i10 < size; i10++) {
            iArr2[i10] = (int[]) arrayList2.get(i10);
        }
        return h(fVar.k(), iArr, e2.a.c(arrayList), e2.a.c(arrayList3), iArr2);
    }

    private static com.google.zxing.common.e h(int i7, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws com.google.zxing.d, com.google.zxing.h {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i8 = 100;
        while (true) {
            int i9 = i8 - 1;
            if (i8 <= 0) {
                throw com.google.zxing.d.a();
            }
            for (int i10 = 0; i10 < length; i10++) {
                iArr[iArr3[i10]] = iArr4[i10][iArr5[i10]];
            }
            try {
                return j(iArr, i7, iArr2);
            } catch (com.google.zxing.d unused) {
                if (length == 0) {
                    throw com.google.zxing.d.a();
                }
                for (int i11 = 0; i11 < length; i11++) {
                    int i12 = iArr5[i11];
                    if (i12 < iArr4[i11].length - 1) {
                        iArr5[i11] = i12 + 1;
                        break;
                    }
                    iArr5[i11] = 0;
                    if (i11 == length - 1) {
                        throw com.google.zxing.d.a();
                    }
                }
                i8 = i9;
            }
        }
    }

    public static com.google.zxing.common.e i(com.google.zxing.common.b bVar, t tVar, t tVar2, t tVar3, t tVar4, int i7, int i8) throws m, com.google.zxing.d, com.google.zxing.h {
        int i9;
        int i10;
        int i11;
        h hVarS = null;
        h hVarS2 = null;
        f fVarV = null;
        c cVar = new c(bVar, tVar, tVar2, tVar3, tVar4);
        for (int i12 = 0; i12 < 2; i12++) {
            if (tVar != null) {
                hVarS = s(bVar, cVar, tVar, true, i7, i8);
            }
            if (tVar3 != null) {
                hVarS2 = s(bVar, cVar, tVar3, false, i7, i8);
            }
            fVarV = v(hVarS, hVarS2);
            if (fVarV == null) {
                throw m.a();
            }
            if (i12 != 0 || fVarV.m() == null || (fVarV.m().g() >= cVar.g() && fVarV.m().e() <= cVar.e())) {
                fVarV.p(cVar);
                break;
            }
            cVar = fVarV.m();
        }
        int iJ = fVarV.j() + 1;
        fVarV.q(0, hVarS);
        fVarV.q(iJ, hVarS2);
        boolean z7 = hVarS != null;
        int iMin = i7;
        int iMax = i8;
        for (int i13 = 1; i13 <= iJ; i13++) {
            int i14 = z7 ? i13 : iJ - i13;
            if (fVarV.n(i14) == null) {
                g hVar = (i14 == 0 || i14 == iJ) ? new h(cVar, i14 == 0) : new g(cVar);
                fVarV.q(i14, hVar);
                int i15 = -1;
                int iG = cVar.g();
                int i16 = -1;
                while (iG <= cVar.e()) {
                    int iT = t(fVarV, i14, iG, z7);
                    if (iT < 0 || iT > cVar.d()) {
                        if (i16 != i15) {
                            i11 = i16;
                        } else {
                            i9 = iG;
                            i10 = i15;
                        }
                        i16 = i16;
                        iG = i9 + 1;
                        i15 = i10;
                    } else {
                        i11 = iT;
                    }
                    int i17 = iG;
                    i10 = i15;
                    d dVarK = k(bVar, cVar.f(), cVar.d(), z7, i11, i17, iMin, iMax);
                    i9 = i17;
                    if (dVarK != null) {
                        hVar.f(i9, dVarK);
                        iMin = Math.min(iMin, dVarK.f());
                        iMax = Math.max(iMax, dVarK.f());
                        i16 = i11;
                    } else {
                        i16 = i16;
                    }
                    iG = i9 + 1;
                    i15 = i10;
                }
            }
        }
        return g(fVarV);
    }

    private static com.google.zxing.common.e j(int[] iArr, int i7, int[] iArr2) throws com.google.zxing.d, com.google.zxing.h {
        if (iArr.length == 0) {
            throw com.google.zxing.h.a();
        }
        int i8 = 1 << (i7 + 1);
        int iE = e(iArr, iArr2, i8);
        x(iArr, i8);
        com.google.zxing.common.e eVarB = e.b(iArr, String.valueOf(i7));
        eVarB.m(Integer.valueOf(iE));
        eVarB.l(Integer.valueOf(iArr2.length));
        return eVarB;
    }

    private static d k(com.google.zxing.common.b bVar, int i7, int i8, boolean z7, int i9, int i10, int i11, int i12) {
        int i13;
        int iD;
        int iB;
        int iC = c(bVar, i7, i8, z7, i9, i10);
        int[] iArrQ = q(bVar, i7, i8, z7, iC, i10);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = a2.a.d(iArrQ);
        if (z7) {
            i13 = iC + iD2;
        } else {
            for (int i14 = 0; i14 < iArrQ.length / 2; i14++) {
                int i15 = iArrQ[i14];
                iArrQ[i14] = iArrQ[(iArrQ.length - 1) - i14];
                iArrQ[(iArrQ.length - 1) - i14] = i15;
            }
            iC -= iD2;
            i13 = iC;
        }
        if (d(iD2, i11, i12) && (iB = e2.a.b((iD = i.d(iArrQ)))) != -1) {
            return new d(iC, i13, n(iD), iB);
        }
        return null;
    }

    private static a l(h hVar, h hVar2) {
        a aVarI;
        a aVarI2;
        if (hVar == null || (aVarI = hVar.i()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.i();
        }
        if (hVar2 == null || (aVarI2 = hVar2.i()) == null || aVarI.a() == aVarI2.a() || aVarI.b() == aVarI2.b() || aVarI.c() == aVarI2.c()) {
            return aVarI;
        }
        return null;
    }

    private static int[] m(int i7) {
        int[] iArr = new int[8];
        int i8 = 0;
        int i9 = 7;
        while (true) {
            int i10 = i7 & 1;
            if (i10 != i8) {
                i9--;
                if (i9 < 0) {
                    return iArr;
                }
                i8 = i10;
            }
            iArr[i9] = iArr[i9] + 1;
            i7 >>= 1;
        }
    }

    private static int n(int i7) {
        return o(m(i7));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int iMax = -1;
        for (int i7 : iArr) {
            iMax = Math.max(iMax, i7);
        }
        return iMax;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    /* JADX WARN: Code duplicated, block: B:28:0x0027 A[EDGE_INSN: B:28:0x0027->B:16:0x0027 BREAK  A[LOOP:0: B:7:0x000c->B:31:0x000c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x001b A[SYNTHETIC] */
    private static int[] q(com.google.zxing.common.b bVar, int i7, int i8, boolean z7, int i9, int i10) {
        int[] iArr = new int[8];
        int i11 = z7 ? 1 : -1;
        int i12 = 0;
        boolean z8 = z7;
        while (true) {
            if (!z7) {
                if (i9 < i7) {
                    break;
                }
                if (i12 < 8) {
                    break;
                    break;
                }
                if (bVar.j(i9, i10) == z8) {
                    iArr[i12] = iArr[i12] + 1;
                    i9 += i11;
                } else {
                    i12++;
                    z8 = !z8;
                }
            } else {
                if (i9 >= i8) {
                    break;
                }
                if (i12 < 8) {
                    break;
                }
                if (bVar.j(i9, i10) == z8) {
                    iArr[i12] = iArr[i12] + 1;
                    i9 += i11;
                } else {
                    i12++;
                    z8 = !z8;
                }
            }
        }
        if (i12 != 8) {
            if (z7) {
                i7 = i8;
            }
            if (i9 != i7 || i12 != 7) {
                return null;
            }
        }
        return iArr;
    }

    private static int r(int i7) {
        return 2 << i7;
    }

    private static h s(com.google.zxing.common.b bVar, c cVar, t tVar, boolean z7, int i7, int i8) {
        h hVar = new h(cVar, z7);
        int i9 = 0;
        while (i9 < 2) {
            int i10 = i9 == 0 ? 1 : -1;
            int iC = (int) tVar.c();
            for (int iD = (int) tVar.d(); iD <= cVar.e() && iD >= cVar.g(); iD += i10) {
                d dVarK = k(bVar, 0, bVar.q(), z7, iC, iD, i7, i8);
                if (dVarK != null) {
                    hVar.f(iD, dVarK);
                    iC = z7 ? dVarK.d() : dVarK.b();
                }
            }
            i9++;
        }
        return hVar;
    }

    private static int t(f fVar, int i7, int i8, boolean z7) {
        int i9 = z7 ? 1 : -1;
        int i10 = i7 - i9;
        d dVarB = u(fVar, i10) ? fVar.n(i10).b(i8) : null;
        if (dVarB != null) {
            return z7 ? dVarB.b() : dVarB.d();
        }
        d dVarC = fVar.n(i7).c(i8);
        if (dVarC != null) {
            return z7 ? dVarC.d() : dVarC.b();
        }
        if (u(fVar, i10)) {
            dVarC = fVar.n(i10).c(i8);
        }
        if (dVarC != null) {
            return z7 ? dVarC.b() : dVarC.d();
        }
        int i11 = 0;
        while (true) {
            i7 -= i9;
            if (!u(fVar, i7)) {
                c cVarM = fVar.m();
                return z7 ? cVarM.f() : cVarM.d();
            }
            for (d dVar : fVar.n(i7).d()) {
                if (dVar != null) {
                    return (z7 ? dVar.b() : dVar.d()) + (i9 * i11 * (dVar.b() - dVar.d()));
                }
            }
            i11++;
        }
    }

    private static boolean u(f fVar, int i7) {
        return i7 >= 0 && i7 <= fVar.j() + 1;
    }

    private static f v(h hVar, h hVar2) throws m {
        a aVarL;
        if ((hVar == null && hVar2 == null) || (aVarL = l(hVar, hVar2)) == null) {
            return null;
        }
        return new f(aVarL, c.j(a(hVar), a(hVar2)));
    }

    public static String w(b[][] bVarArr) {
        Formatter formatter = new Formatter();
        for (int i7 = 0; i7 < bVarArr.length; i7++) {
            try {
                formatter.format("Row %2d: ", Integer.valueOf(i7));
                int i8 = 0;
                while (true) {
                    b[] bVarArr2 = bVarArr[i7];
                    if (i8 < bVarArr2.length) {
                        b bVar = bVarArr2[i8];
                        if (bVar.b().length == 0) {
                            formatter.format("        ", null);
                        } else {
                            formatter.format("%4d(%2d)", Integer.valueOf(bVar.b()[0]), bVar.a(bVar.b()[0]));
                        }
                        i8++;
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    private static void x(int[] iArr, int i7) throws com.google.zxing.h {
        if (iArr.length < 4) {
            throw com.google.zxing.h.a();
        }
        int i8 = iArr[0];
        if (i8 > iArr.length) {
            throw com.google.zxing.h.a();
        }
        if (i8 == 0) {
            if (i7 >= iArr.length) {
                throw com.google.zxing.h.a();
            }
            iArr[0] = iArr.length - i7;
        }
    }
}
