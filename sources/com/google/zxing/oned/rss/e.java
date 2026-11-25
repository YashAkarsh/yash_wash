package com.google.zxing.oned.rss;

import com.google.zxing.m;
import com.google.zxing.r;
import com.google.zxing.t;
import com.google.zxing.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f23896m = {1, 10, 34, 70, 126};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f23897n = {4, 20, 48, 81};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f23898o = {0, 161, 961, 2015, 2715};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f23899p = {0, 336, 1036, 1516};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f23900q = {8, 6, 4, 3, 1};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f23901r = {2, 4, 6, 8};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int[][] f23902s = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<d> f23903k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<d> f23904l = new ArrayList();

    private static void s(Collection<d> collection, d dVar) {
        boolean z7;
        if (dVar == null) {
            return;
        }
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                z7 = false;
                break;
            }
            d next = it.next();
            if (next.b() == dVar.b()) {
                next.e();
                z7 = true;
                break;
            }
        }
        if (z7) {
            return;
        }
        collection.add(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003c A[PHI: r6 r7
      0x003c: PHI (r6v4 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:22:0x003a, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]
      0x003c: PHI (r7v4 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:22:0x003a, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0041 A[PHI: r6 r7
      0x0041: PHI (r6v5 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x0041: PHI (r7v5 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0044 A[PHI: r6 r7
      0x0044: PHI (r6v7 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x0044: PHI (r7v11 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:67:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x009b  */
    /* JADX WARN: Code duplicated, block: B:69:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:74:0x00bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    private void t(boolean z7, int i7) throws m {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        int iD = a2.a.d(n());
        int iD2 = a2.a.d(l());
        boolean z12 = true;
        if (z7) {
            if (iD > 12) {
                z9 = true;
                z8 = false;
            } else if (iD < 4) {
                z8 = true;
                z9 = false;
            } else {
                z8 = false;
                z9 = false;
            }
            if (iD2 > 12) {
                z10 = true;
                z11 = false;
            } else if (iD2 < 4) {
                z11 = true;
                z10 = false;
            } else {
                z11 = false;
                z10 = false;
            }
        } else {
            if (iD > 11) {
                z9 = true;
                z8 = false;
            } else if (iD < 5) {
                z8 = true;
                z9 = false;
            } else {
                z8 = false;
                z9 = false;
            }
            if (iD2 > 10) {
                z10 = true;
                z11 = false;
            } else if (iD2 < 4) {
                z11 = true;
                z10 = false;
            } else {
                z11 = false;
                z10 = false;
            }
        }
        int i8 = (iD + iD2) - i7;
        boolean z13 = (iD & 1) == z7;
        boolean z14 = (iD2 & 1) == 1;
        if (i8 != 1) {
            if (i8 == -1) {
                if (z13) {
                    if (z14) {
                        throw m.a();
                    }
                } else {
                    if (!z14) {
                        throw m.a();
                    }
                    z11 = true;
                }
            } else {
                if (i8 != 0) {
                    throw m.a();
                }
                if (z13) {
                    if (!z14) {
                        throw m.a();
                    }
                    if (iD < iD2) {
                        z10 = true;
                    } else {
                        z11 = true;
                        z9 = true;
                    }
                } else if (z14) {
                    throw m.a();
                }
            }
            if (z12) {
                if (!z9) {
                    throw m.a();
                }
                a.p(n(), o());
            }
            if (z9) {
                a.i(n(), o());
            }
            if (z11) {
                if (!z10) {
                    throw m.a();
                }
                a.p(l(), o());
            }
            if (z10) {
                a.i(l(), m());
            }
        }
        if (z13) {
            if (z14) {
                throw m.a();
            }
            z9 = true;
        } else {
            if (!z14) {
                throw m.a();
            }
            z10 = true;
        }
        z12 = z8;
        if (z12) {
            if (!z9) {
                throw m.a();
            }
            a.p(n(), o());
        }
        if (z9) {
            a.i(n(), o());
        }
        if (z11) {
            if (!z10) {
                throw m.a();
            }
            a.p(l(), o());
        }
        if (z10) {
            a.i(l(), m());
        }
    }

    private static boolean u(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    private static r v(d dVar, d dVar2) {
        String strValueOf = String.valueOf((((long) dVar.b()) * 4537077) + ((long) dVar2.b()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i7 = 0;
        for (int i8 = 0; i8 < 13; i8++) {
            int iCharAt = sb.charAt(i8) - '0';
            if ((i8 & 1) == 0) {
                iCharAt *= 3;
            }
            i7 += iCharAt;
        }
        int i9 = 10 - (i7 % 10);
        if (i9 == 10) {
            i9 = 0;
        }
        sb.append(i9);
        t[] tVarArrA = dVar.d().a();
        t[] tVarArrA2 = dVar2.d().a();
        return new r(sb.toString(), null, new t[]{tVarArrA[0], tVarArrA[1], tVarArrA2[0], tVarArrA2[1]}, com.google.zxing.a.RSS_14);
    }

    private b w(com.google.zxing.common.a aVar, c cVar, boolean z7) throws m {
        int[] iArrJ = j();
        for (int i7 = 0; i7 < iArrJ.length; i7++) {
            iArrJ[i7] = 0;
        }
        if (z7) {
            com.google.zxing.oned.r.g(aVar, cVar.b()[0], iArrJ);
        } else {
            com.google.zxing.oned.r.f(aVar, cVar.b()[1] + 1, iArrJ);
            int i8 = 0;
            for (int length = iArrJ.length - 1; i8 < length; length--) {
                int i9 = iArrJ[i8];
                iArrJ[i8] = iArrJ[length];
                iArrJ[length] = i9;
                i8++;
            }
        }
        int i10 = z7 ? 16 : 15;
        float fD = a2.a.d(iArrJ) / i10;
        int[] iArrN = n();
        int[] iArrL = l();
        float[] fArrO = o();
        float[] fArrM = m();
        for (int i11 = 0; i11 < iArrJ.length; i11++) {
            float f8 = iArrJ[i11] / fD;
            int i12 = (int) (0.5f + f8);
            if (i12 <= 0) {
                i12 = 1;
            } else if (i12 > 8) {
                i12 = 8;
            }
            int i13 = i11 / 2;
            if ((i11 & 1) == 0) {
                iArrN[i13] = i12;
                fArrO[i13] = f8 - i12;
            } else {
                iArrL[i13] = i12;
                fArrM[i13] = f8 - i12;
            }
        }
        t(z7, i10);
        int i14 = 0;
        int i15 = 0;
        for (int length2 = iArrN.length - 1; length2 >= 0; length2--) {
            int i16 = iArrN[length2];
            i14 = (i14 * 9) + i16;
            i15 += i16;
        }
        int i17 = 0;
        int i18 = 0;
        for (int length3 = iArrL.length - 1; length3 >= 0; length3--) {
            int i19 = iArrL[length3];
            i17 = (i17 * 9) + i19;
            i18 += i19;
        }
        int i20 = i14 + (i17 * 3);
        if (!z7) {
            if ((i18 & 1) != 0 || i18 > 10 || i18 < 4) {
                throw m.a();
            }
            int i21 = (10 - i18) / 2;
            int i22 = f23901r[i21];
            return new b((f.b(iArrL, 9 - i22, false) * f23897n[i21]) + f.b(iArrN, i22, true) + f23899p[i21], i20);
        }
        if ((i15 & 1) != 0 || i15 > 12 || i15 < 4) {
            throw m.a();
        }
        int i23 = (12 - i15) / 2;
        int i24 = f23900q[i23];
        return new b((f.b(iArrN, i24, false) * f23896m[i23]) + f.b(iArrL, 9 - i24, true) + f23898o[i23], i20);
    }

    private d x(com.google.zxing.common.a aVar, boolean z7, int i7, Map<com.google.zxing.e, ?> map) {
        try {
            int[] iArrY = y(aVar, z7);
            c cVarZ = z(aVar, i7, z7, iArrY);
            u uVar = map == null ? null : (u) map.get(com.google.zxing.e.NEED_RESULT_POINT_CALLBACK);
            if (uVar != null) {
                float fO = (iArrY[0] + iArrY[1]) / 2.0f;
                if (z7) {
                    fO = (aVar.o() - 1) - fO;
                }
                uVar.a(new t(fO, i7));
            }
            b bVarW = w(aVar, cVarZ, true);
            b bVarW2 = w(aVar, cVarZ, false);
            return new d((bVarW.b() * 1597) + bVarW2.b(), bVarW.a() + (bVarW2.a() * 4), cVarZ);
        } catch (m unused) {
            return null;
        }
    }

    private int[] y(com.google.zxing.common.a aVar, boolean z7) throws m {
        int[] iArrK = k();
        iArrK[0] = 0;
        iArrK[1] = 0;
        iArrK[2] = 0;
        iArrK[3] = 0;
        int iO = aVar.o();
        int i7 = 0;
        boolean z8 = false;
        while (i7 < iO) {
            z8 = !aVar.k(i7);
            if (z7 == z8) {
                break;
            }
            i7++;
        }
        int i8 = 0;
        int i9 = i7;
        while (i7 < iO) {
            if (aVar.k(i7) != z8) {
                iArrK[i8] = iArrK[i8] + 1;
            } else {
                if (i8 != 3) {
                    i8++;
                } else {
                    if (a.q(iArrK)) {
                        return new int[]{i9, i7};
                    }
                    i9 += iArrK[0] + iArrK[1];
                    iArrK[0] = iArrK[2];
                    iArrK[1] = iArrK[3];
                    iArrK[2] = 0;
                    iArrK[3] = 0;
                    i8--;
                }
                iArrK[i8] = 1;
                z8 = !z8;
            }
            i7++;
        }
        throw m.a();
    }

    private c z(com.google.zxing.common.a aVar, int i7, boolean z7, int[] iArr) throws m {
        int iO;
        int i8;
        boolean zK = aVar.k(iArr[0]);
        int i9 = iArr[0] - 1;
        while (i9 >= 0 && zK != aVar.k(i9)) {
            i9--;
        }
        int i10 = i9 + 1;
        int i11 = iArr[0] - i10;
        int[] iArrK = k();
        System.arraycopy(iArrK, 0, iArrK, 1, iArrK.length - 1);
        iArrK[0] = i11;
        int iR = a.r(iArrK, f23902s);
        int i12 = iArr[1];
        if (z7) {
            int iO2 = (aVar.o() - 1) - i10;
            iO = (aVar.o() - 1) - i12;
            i8 = iO2;
        } else {
            iO = i12;
            i8 = i10;
        }
        return new c(iR, new int[]{i10, iArr[1]}, i8, iO, i7);
    }

    @Override // com.google.zxing.oned.r
    public r c(int i7, com.google.zxing.common.a aVar, Map<com.google.zxing.e, ?> map) throws m {
        s(this.f23903k, x(aVar, false, i7, map));
        aVar.s();
        s(this.f23904l, x(aVar, true, i7, map));
        aVar.s();
        for (d dVar : this.f23903k) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f23904l) {
                    if (dVar2.c() > 1 && u(dVar, dVar2)) {
                        return v(dVar, dVar2);
                    }
                }
            }
        }
        throw m.a();
    }

    @Override // com.google.zxing.oned.r, com.google.zxing.p
    public void reset() {
        this.f23903k.clear();
        this.f23904l.clear();
    }
}
