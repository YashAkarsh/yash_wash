package com.google.zxing.oned.rss.expanded;

import com.alibaba.fastjson.asm.j;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.oned.rss.f;
import com.google.zxing.r;
import com.google.zxing.t;
import easypay.appinvoke.manager.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.google.zxing.oned.rss.a {
    private static final int A = 11;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f23917t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f23918u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f23919v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f23920w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f23921x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f23922y = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<b> f23924k = new ArrayList(11);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<c> f23925l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int[] f23926m = new int[2];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f23927n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f23912o = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f23913p = {4, 20, 52, 104, 204};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f23914q = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[][] f23915r = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int[][] f23916s = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{j.f12608d0, Constants.ACTION_SAVE_CUST_ID, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, j.Q, 85, 44, 132}, new int[]{j.Z, d4.d.f33486i, j.f12604b0, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, Constants.ACTION_DELAY_PASSWORD_FOUND}, new int[]{46, 138, 203, j.f12602a0, 139, 206, 196, j.O}, new int[]{76, 17, 51, 153, 37, 111, 122, Constants.ACTION_START_NB_OTP}, new int[]{43, 129, j.R, Constants.ACTION_SUBMIT_CLICKED, Constants.OTP_FILLER_WEB_SUCCESS, Constants.LOG_ERROR_OTP, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, j.S}, new int[]{109, 116, 137, 200, j.T, 112, 125, Constants.ACTION_NB_REMOVE_LOADER}, new int[]{70, 210, 208, 202, j.Y, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, FacebookRequestErrorClassification.EC_INVALID_TOKEN}, new int[]{j.C, 22, 66, j.f12610e0, 172, 94, 71, 2}, new int[]{6, 18, 54, j.L, 64, j.f12606c0, 154, 40}, new int[]{120, j.D, 25, 75, 14, 42, 126, j.P}, new int[]{79, 26, 78, 23, 69, 207, j.f12612f0, 175}, new int[]{Constants.ACTION_SUBMIT_BTN_USER_PWD_NB, 98, 83, 38, 114, 131, j.W, 124}, new int[]{161, 61, j.X, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[][] f23923z = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    private static int A(com.google.zxing.common.a aVar, int i7) {
        return aVar.k(i7) ? aVar.m(aVar.n(i7)) : aVar.n(aVar.m(i7));
    }

    private static boolean C(com.google.zxing.oned.rss.c cVar, boolean z7, boolean z8) {
        return (cVar.c() == 0 && z7 && z8) ? false : true;
    }

    private static boolean D(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z7;
        boolean z8;
        Iterator<c> it = iterable2.iterator();
        do {
            z7 = false;
            if (!it.hasNext()) {
                return false;
            }
            c next = it.next();
            Iterator<b> it2 = iterable.iterator();
            do {
                if (!it2.hasNext()) {
                    z7 = true;
                    break;
                }
                b next2 = it2.next();
                Iterator<b> it3 = next.a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z8 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z8 = true;
                        break;
                    }
                }
            } while (z8);
        } while (!z7);
        return true;
    }

    private static boolean E(List<b> list) {
        boolean z7;
        for (int[] iArr : f23923z) {
            if (list.size() <= iArr.length) {
                int i7 = 0;
                while (true) {
                    if (i7 >= list.size()) {
                        z7 = true;
                        break;
                    }
                    if (list.get(i7).b().c() != iArr[i7]) {
                        z7 = false;
                        break;
                    }
                    i7++;
                }
                if (z7) {
                    return true;
                }
            }
        }
        return false;
    }

    private com.google.zxing.oned.rss.c F(com.google.zxing.common.a aVar, int i7, boolean z7) {
        int i8;
        int i9;
        int i10;
        if (z7) {
            int i11 = this.f23926m[0] - 1;
            while (i11 >= 0 && !aVar.k(i11)) {
                i11--;
            }
            int i12 = i11 + 1;
            int[] iArr = this.f23926m;
            i10 = iArr[0] - i12;
            i8 = iArr[1];
            i9 = i12;
        } else {
            int[] iArr2 = this.f23926m;
            int i13 = iArr2[0];
            int iN = aVar.n(iArr2[1] + 1);
            i8 = iN;
            i9 = i13;
            i10 = iN - this.f23926m[1];
        }
        int[] iArrK = k();
        System.arraycopy(iArrK, 0, iArrK, 1, iArrK.length - 1);
        iArrK[0] = i10;
        try {
            return new com.google.zxing.oned.rss.c(com.google.zxing.oned.rss.a.r(iArrK, f23915r), new int[]{i9, i8}, i9, i8, i7);
        } catch (m unused) {
            return null;
        }
    }

    private static void G(List<b> list, List<c> list2) {
        boolean z7;
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    z7 = true;
                    if (!it2.hasNext()) {
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    do {
                        if (!it3.hasNext()) {
                            z7 = false;
                            break;
                        }
                    } while (!next2.equals(it3.next()));
                    if (!z7) {
                        z7 = false;
                        break;
                    }
                }
                if (z7) {
                    it.remove();
                }
            }
        }
    }

    private static void I(int[] iArr) {
        int length = iArr.length;
        for (int i7 = 0; i7 < length / 2; i7++) {
            int i8 = iArr[i7];
            int i9 = (length - i7) - 1;
            iArr[i7] = iArr[i9];
            iArr[i9] = i8;
        }
    }

    private void J(int i7, boolean z7) {
        boolean zC = false;
        int i8 = 0;
        boolean zC2 = false;
        while (i8 < this.f23925l.size()) {
            c cVar = this.f23925l.get(i8);
            if (cVar.b() > i7) {
                zC = cVar.c(this.f23924k);
                break;
            } else {
                zC2 = cVar.c(this.f23924k);
                i8++;
            }
        }
        if (zC || zC2 || D(this.f23924k, this.f23925l)) {
            return;
        }
        this.f23925l.add(i8, new c(this.f23924k, i7, z7));
        G(this.f23924k, this.f23925l);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0082  */
    /* JADX WARN: Code duplicated, block: B:55:0x008e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0095  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    private void s(int i7) throws m {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int iD = a2.a.d(n());
        int iD2 = a2.a.d(l());
        boolean z11 = true;
        if (iD > 13) {
            z8 = true;
            z7 = false;
        } else if (iD < 4) {
            z7 = true;
            z8 = false;
        } else {
            z7 = false;
            z8 = false;
        }
        if (iD2 > 13) {
            z10 = true;
            z9 = false;
        } else if (iD2 < 4) {
            z9 = true;
            z10 = false;
        } else {
            z9 = false;
            z10 = false;
        }
        int i8 = (iD + iD2) - i7;
        boolean z12 = (iD & 1) == 1;
        boolean z13 = (iD2 & 1) == 0;
        if (i8 != 1) {
            if (i8 == -1) {
                if (z12) {
                    if (z13) {
                        throw m.a();
                    }
                } else {
                    if (!z13) {
                        throw m.a();
                    }
                    z9 = true;
                }
            } else {
                if (i8 != 0) {
                    throw m.a();
                }
                if (z12) {
                    if (!z13) {
                        throw m.a();
                    }
                    if (iD < iD2) {
                        z10 = true;
                    } else {
                        z9 = true;
                        z8 = true;
                    }
                } else if (z13) {
                    throw m.a();
                }
            }
            if (z11) {
                if (!z8) {
                    throw m.a();
                }
                com.google.zxing.oned.rss.a.p(n(), o());
            }
            if (z8) {
                com.google.zxing.oned.rss.a.i(n(), o());
            }
            if (z9) {
                if (!z10) {
                    throw m.a();
                }
                com.google.zxing.oned.rss.a.p(l(), o());
            }
            if (z10) {
                com.google.zxing.oned.rss.a.i(l(), m());
            }
        }
        if (z12) {
            if (z13) {
                throw m.a();
            }
            z8 = true;
        } else {
            if (!z13) {
                throw m.a();
            }
            z10 = true;
        }
        z11 = z7;
        if (z11) {
            if (!z8) {
                throw m.a();
            }
            com.google.zxing.oned.rss.a.p(n(), o());
        }
        if (z8) {
            com.google.zxing.oned.rss.a.i(n(), o());
        }
        if (z9) {
            if (!z10) {
                throw m.a();
            }
            com.google.zxing.oned.rss.a.p(l(), o());
        }
        if (z10) {
            com.google.zxing.oned.rss.a.i(l(), m());
        }
    }

    private boolean t() {
        b bVar = this.f23924k.get(0);
        com.google.zxing.oned.rss.b bVarC = bVar.c();
        com.google.zxing.oned.rss.b bVarD = bVar.d();
        if (bVarD == null) {
            return false;
        }
        int iA = bVarD.a();
        int i7 = 2;
        for (int i8 = 1; i8 < this.f23924k.size(); i8++) {
            b bVar2 = this.f23924k.get(i8);
            iA += bVar2.c().a();
            i7++;
            com.google.zxing.oned.rss.b bVarD2 = bVar2.d();
            if (bVarD2 != null) {
                iA += bVarD2.a();
                i7++;
            }
        }
        return ((i7 + (-4)) * 211) + (iA % 211) == bVarC.b();
    }

    private List<b> u(List<c> list, int i7) throws m {
        while (i7 < this.f23925l.size()) {
            c cVar = this.f23925l.get(i7);
            this.f23924k.clear();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                this.f23924k.addAll(it.next().a());
            }
            this.f23924k.addAll(cVar.a());
            if (E(this.f23924k)) {
                if (t()) {
                    return this.f23924k;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return u(arrayList, i7 + 1);
                } catch (m unused) {
                    continue;
                }
            }
            i7++;
        }
        throw m.a();
    }

    private List<b> v(boolean z7) {
        List<b> listU = null;
        if (this.f23925l.size() > 25) {
            this.f23925l.clear();
            return null;
        }
        this.f23924k.clear();
        if (z7) {
            Collections.reverse(this.f23925l);
        }
        try {
            listU = u(new ArrayList(), 0);
        } catch (m unused) {
        }
        if (z7) {
            Collections.reverse(this.f23925l);
        }
        return listU;
    }

    static r w(List<b> list) throws m, h {
        String strD = com.google.zxing.oned.rss.expanded.decoders.j.a(a.a(list)).d();
        t[] tVarArrA = list.get(0).b().a();
        t[] tVarArrA2 = list.get(list.size() - 1).b().a();
        return new r(strD, null, new t[]{tVarArrA[0], tVarArrA[1], tVarArrA2[0], tVarArrA2[1]}, com.google.zxing.a.RSS_EXPANDED);
    }

    private void z(com.google.zxing.common.a aVar, List<b> list, int i7) throws m {
        int[] iArrK = k();
        iArrK[0] = 0;
        iArrK[1] = 0;
        iArrK[2] = 0;
        iArrK[3] = 0;
        int iO = aVar.o();
        if (i7 < 0) {
            i7 = list.isEmpty() ? 0 : list.get(list.size() - 1).b().b()[1];
        }
        boolean z7 = list.size() % 2 != 0;
        if (this.f23927n) {
            z7 = !z7;
        }
        boolean z8 = false;
        while (i7 < iO) {
            z8 = !aVar.k(i7);
            if (!z8) {
                break;
            } else {
                i7++;
            }
        }
        int i8 = 0;
        boolean z9 = z8;
        int i9 = i7;
        while (i7 < iO) {
            if (aVar.k(i7) != z9) {
                iArrK[i8] = iArrK[i8] + 1;
            } else {
                if (i8 == 3) {
                    if (z7) {
                        I(iArrK);
                    }
                    if (com.google.zxing.oned.rss.a.q(iArrK)) {
                        int[] iArr = this.f23926m;
                        iArr[0] = i9;
                        iArr[1] = i7;
                        return;
                    }
                    if (z7) {
                        I(iArrK);
                    }
                    i9 += iArrK[0] + iArrK[1];
                    iArrK[0] = iArrK[2];
                    iArrK[1] = iArrK[3];
                    iArrK[2] = 0;
                    iArrK[3] = 0;
                    i8--;
                } else {
                    i8++;
                }
                iArrK[i8] = 1;
                z9 = !z9;
            }
            i7++;
        }
        throw m.a();
    }

    List<c> B() {
        return this.f23925l;
    }

    b H(com.google.zxing.common.a aVar, List<b> list, int i7) throws m {
        com.google.zxing.oned.rss.c cVarF;
        com.google.zxing.oned.rss.b bVarX;
        boolean z7 = list.size() % 2 == 0;
        if (this.f23927n) {
            z7 = !z7;
        }
        int iA = -1;
        boolean z8 = true;
        do {
            z(aVar, list, iA);
            cVarF = F(aVar, i7, z7);
            if (cVarF == null) {
                iA = A(aVar, this.f23926m[0]);
            } else {
                z8 = false;
            }
        } while (z8);
        com.google.zxing.oned.rss.b bVarX2 = x(aVar, cVarF, z7, true);
        if (!list.isEmpty() && list.get(list.size() - 1).g()) {
            throw m.a();
        }
        try {
            bVarX = x(aVar, cVarF, z7, false);
        } catch (m unused) {
            bVarX = null;
        }
        return new b(bVarX2, bVarX, cVarF, true);
    }

    @Override // com.google.zxing.oned.r
    public r c(int i7, com.google.zxing.common.a aVar, Map<e, ?> map) throws m, h {
        this.f23924k.clear();
        this.f23927n = false;
        try {
            return w(y(i7, aVar));
        } catch (m unused) {
            this.f23924k.clear();
            this.f23927n = true;
            return w(y(i7, aVar));
        }
    }

    @Override // com.google.zxing.oned.r, com.google.zxing.p
    public void reset() {
        this.f23924k.clear();
        this.f23925l.clear();
    }

    com.google.zxing.oned.rss.b x(com.google.zxing.common.a aVar, com.google.zxing.oned.rss.c cVar, boolean z7, boolean z8) throws m {
        int[] iArrJ = j();
        for (int i7 = 0; i7 < iArrJ.length; i7++) {
            iArrJ[i7] = 0;
        }
        if (z8) {
            com.google.zxing.oned.r.g(aVar, cVar.b()[0], iArrJ);
        } else {
            com.google.zxing.oned.r.f(aVar, cVar.b()[1], iArrJ);
            int i8 = 0;
            for (int length = iArrJ.length - 1; i8 < length; length--) {
                int i9 = iArrJ[i8];
                iArrJ[i8] = iArrJ[length];
                iArrJ[length] = i9;
                i8++;
            }
        }
        float fD = a2.a.d(iArrJ) / 17.0f;
        float f8 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(fD - f8) / f8 > 0.3f) {
            throw m.a();
        }
        int[] iArrN = n();
        int[] iArrL = l();
        float[] fArrO = o();
        float[] fArrM = m();
        for (int i10 = 0; i10 < iArrJ.length; i10++) {
            float f9 = (iArrJ[i10] * 1.0f) / fD;
            int i11 = (int) (0.5f + f9);
            if (i11 <= 0) {
                if (f9 < 0.3f) {
                    throw m.a();
                }
                i11 = 1;
            } else if (i11 > 8) {
                if (f9 > 8.7f) {
                    throw m.a();
                }
                i11 = 8;
            }
            int i12 = i10 / 2;
            if ((i10 & 1) == 0) {
                iArrN[i12] = i11;
                fArrO[i12] = f9 - i11;
            } else {
                iArrL[i12] = i11;
                fArrM[i12] = f9 - i11;
            }
        }
        s(17);
        int iC = (((cVar.c() * 4) + (z7 ? 0 : 2)) + (!z8 ? 1 : 0)) - 1;
        int i13 = 0;
        int i14 = 0;
        for (int length2 = iArrN.length - 1; length2 >= 0; length2--) {
            if (C(cVar, z7, z8)) {
                i13 += iArrN[length2] * f23916s[iC][length2 * 2];
            }
            i14 += iArrN[length2];
        }
        int i15 = 0;
        for (int length3 = iArrL.length - 1; length3 >= 0; length3--) {
            if (C(cVar, z7, z8)) {
                i15 += iArrL[length3] * f23916s[iC][(length3 * 2) + 1];
            }
        }
        int i16 = i13 + i15;
        if ((i14 & 1) != 0 || i14 > 13 || i14 < 4) {
            throw m.a();
        }
        int i17 = (13 - i14) / 2;
        int i18 = f23912o[i17];
        return new com.google.zxing.oned.rss.b((f.b(iArrN, i18, true) * f23913p[i17]) + f.b(iArrL, 9 - i18, false) + f23914q[i17], i16);
    }

    List<b> y(int i7, com.google.zxing.common.a aVar) throws m {
        boolean z7 = false;
        while (!z7) {
            try {
                List<b> list = this.f23924k;
                list.add(H(aVar, list, i7));
            } catch (m e8) {
                if (this.f23924k.isEmpty()) {
                    throw e8;
                }
                z7 = true;
            }
        }
        if (t()) {
            return this.f23924k;
        }
        boolean z8 = !this.f23925l.isEmpty();
        J(i7, false);
        if (z8) {
            List<b> listV = v(false);
            if (listV != null) {
                return listV;
            }
            List<b> listV2 = v(true);
            if (listV2 != null) {
                return listV2;
            }
        }
        throw m.a();
    }
}
