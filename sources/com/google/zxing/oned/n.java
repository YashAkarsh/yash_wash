package com.google.zxing.oned;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f23862b = 0.38f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f23863c = 0.5f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23864d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f23865e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f23866f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f23867g = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f23868h = {1, 1, 1, 1};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[][] f23869i = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[][] f23870j = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23871a = -1;

    private static int h(int[] iArr) throws com.google.zxing.m {
        int length = f23870j.length;
        float f8 = 0.38f;
        int i7 = -1;
        for (int i8 = 0; i8 < length; i8++) {
            float fE = r.e(iArr, f23870j[i8], 0.5f);
            if (fE < f8) {
                i7 = i8;
                f8 = fE;
            } else if (fE == f8) {
                i7 = -1;
            }
        }
        if (i7 >= 0) {
            return i7 % 10;
        }
        throw com.google.zxing.m.a();
    }

    private int[] i(com.google.zxing.common.a aVar) throws com.google.zxing.m {
        int[] iArrL;
        aVar.s();
        try {
            int iM = m(aVar);
            try {
                iArrL = l(aVar, iM, f23869i[0]);
            } catch (com.google.zxing.m unused) {
                iArrL = l(aVar, iM, f23869i[1]);
            }
            n(aVar, iArrL[0]);
            int i7 = iArrL[0];
            iArrL[0] = aVar.o() - iArrL[1];
            iArrL[1] = aVar.o() - i7;
            aVar.s();
            return iArrL;
        } catch (Throwable th) {
            aVar.s();
            throw th;
        }
    }

    private static void j(com.google.zxing.common.a aVar, int i7, int i8, StringBuilder sb) throws com.google.zxing.m {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i7 < i8) {
            r.f(aVar, i7, iArr);
            for (int i9 = 0; i9 < 5; i9++) {
                int i10 = i9 * 2;
                iArr2[i9] = iArr[i10];
                iArr3[i9] = iArr[i10 + 1];
            }
            sb.append((char) (h(iArr2) + 48));
            sb.append((char) (h(iArr3) + 48));
            for (int i11 = 0; i11 < 10; i11++) {
                i7 += iArr[i11];
            }
        }
    }

    private int[] k(com.google.zxing.common.a aVar) throws com.google.zxing.m {
        int[] iArrL = l(aVar, m(aVar), f23868h);
        int i7 = iArrL[1];
        int i8 = iArrL[0];
        this.f23871a = (i7 - i8) / 4;
        n(aVar, i8);
        return iArrL;
    }

    private static int[] l(com.google.zxing.common.a aVar, int i7, int[] iArr) throws com.google.zxing.m {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iO = aVar.o();
        int i8 = i7;
        boolean z7 = false;
        int i9 = 0;
        while (i7 < iO) {
            if (aVar.k(i7) != z7) {
                iArr2[i9] = iArr2[i9] + 1;
            } else {
                if (i9 != length - 1) {
                    i9++;
                } else {
                    if (r.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i8, i7};
                    }
                    i8 += iArr2[0] + iArr2[1];
                    int i10 = i9 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i10);
                    iArr2[i10] = 0;
                    iArr2[i9] = 0;
                    i9--;
                }
                iArr2[i9] = 1;
                z7 = !z7;
            }
            i7++;
        }
        throw com.google.zxing.m.a();
    }

    private static int m(com.google.zxing.common.a aVar) throws com.google.zxing.m {
        int iO = aVar.o();
        int iM = aVar.m(0);
        if (iM != iO) {
            return iM;
        }
        throw com.google.zxing.m.a();
    }

    private void n(com.google.zxing.common.a aVar, int i7) throws com.google.zxing.m {
        int i8 = this.f23871a * 10;
        if (i8 >= i7) {
            i8 = i7;
        }
        for (int i9 = i7 - 1; i8 > 0 && i9 >= 0 && !aVar.k(i9); i9--) {
            i8--;
        }
        if (i8 != 0) {
            throw com.google.zxing.m.a();
        }
    }

    @Override // com.google.zxing.oned.r
    public com.google.zxing.r c(int i7, com.google.zxing.common.a aVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.h {
        boolean z7;
        int[] iArrK = k(aVar);
        int[] iArrI = i(aVar);
        StringBuilder sb = new StringBuilder(20);
        j(aVar, iArrK[1], iArrI[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(com.google.zxing.e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f23867g;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i8 >= length2) {
                z7 = false;
                break;
            }
            int i10 = iArr[i8];
            if (length == i10) {
                z7 = true;
                break;
            }
            if (i10 > i9) {
                i9 = i10;
            }
            i8++;
        }
        if (!z7 && length > i9) {
            z7 = true;
        }
        if (!z7) {
            throw com.google.zxing.h.a();
        }
        float f8 = i7;
        return new com.google.zxing.r(string, null, new com.google.zxing.t[]{new com.google.zxing.t(iArrK[1], f8), new com.google.zxing.t(iArrI[0], f8)}, com.google.zxing.a.ITF);
    }
}
