package com.google.zxing.oned;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f23980d = 0.48f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f23981e = 0.7f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f23982f = {1, 1, 1};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f23983g = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f23984h = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[][] f23985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int[][] f23986j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f23987a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f23988b = new x();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m f23989c = new m();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f23985i = iArr;
        int[][] iArr2 = new int[20][];
        f23986j = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i7 = 10; i7 < 20; i7++) {
            int[] iArr3 = f23985i[i7 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i8 = 0; i8 < iArr3.length; i8++) {
                iArr4[i8] = iArr3[(iArr3.length - i8) - 1];
            }
            f23986j[i7] = iArr4;
        }
    }

    protected y() {
    }

    static boolean i(CharSequence charSequence) throws com.google.zxing.h {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i7 = length - 1;
        return r(charSequence.subSequence(0, i7)) == Character.digit(charSequence.charAt(i7), 10);
    }

    static int j(com.google.zxing.common.a aVar, int[] iArr, int i7, int[][] iArr2) throws com.google.zxing.m {
        r.f(aVar, i7, iArr);
        int length = iArr2.length;
        float f8 = f23980d;
        int i8 = -1;
        for (int i9 = 0; i9 < length; i9++) {
            float fE = r.e(iArr, iArr2[i9], f23981e);
            if (fE < f8) {
                i8 = i9;
                f8 = fE;
            }
        }
        if (i8 >= 0) {
            return i8;
        }
        throw com.google.zxing.m.a();
    }

    static int[] n(com.google.zxing.common.a aVar, int i7, boolean z7, int[] iArr) throws com.google.zxing.m {
        return o(aVar, i7, z7, iArr, new int[iArr.length]);
    }

    private static int[] o(com.google.zxing.common.a aVar, int i7, boolean z7, int[] iArr, int[] iArr2) throws com.google.zxing.m {
        int iO = aVar.o();
        int iN = z7 ? aVar.n(i7) : aVar.m(i7);
        int length = iArr.length;
        boolean z8 = z7;
        int i8 = 0;
        int i9 = iN;
        while (iN < iO) {
            if (aVar.k(iN) != z8) {
                iArr2[i8] = iArr2[i8] + 1;
            } else {
                if (i8 != length - 1) {
                    i8++;
                } else {
                    if (r.e(iArr2, iArr, f23981e) < f23980d) {
                        return new int[]{i9, iN};
                    }
                    i9 += iArr2[0] + iArr2[1];
                    int i10 = i8 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i10);
                    iArr2[i10] = 0;
                    iArr2[i8] = 0;
                    i8--;
                }
                iArr2[i8] = 1;
                z8 = !z8;
            }
            iN++;
        }
        throw com.google.zxing.m.a();
    }

    static int[] p(com.google.zxing.common.a aVar) throws com.google.zxing.m {
        int[] iArr = new int[f23982f.length];
        int[] iArrO = null;
        boolean zQ = false;
        int i7 = 0;
        while (!zQ) {
            int[] iArr2 = f23982f;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrO = o(aVar, i7, false, iArr2, iArr);
            int i8 = iArrO[0];
            int i9 = iArrO[1];
            int i10 = i8 - (i9 - i8);
            if (i10 >= 0) {
                zQ = aVar.q(i10, i8, false);
            }
            i7 = i9;
        }
        return iArrO;
    }

    static int r(CharSequence charSequence) throws com.google.zxing.h {
        int length = charSequence.length();
        int i7 = 0;
        for (int i8 = length - 1; i8 >= 0; i8 -= 2) {
            int iCharAt = charSequence.charAt(i8) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw com.google.zxing.h.a();
            }
            i7 += iCharAt;
        }
        int i9 = i7 * 3;
        for (int i10 = length - 2; i10 >= 0; i10 -= 2) {
            int iCharAt2 = charSequence.charAt(i10) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw com.google.zxing.h.a();
            }
            i9 += iCharAt2;
        }
        return (1000 - i9) % 10;
    }

    @Override // com.google.zxing.oned.r
    public com.google.zxing.r c(int i7, com.google.zxing.common.a aVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.d, com.google.zxing.h {
        return m(i7, aVar, p(aVar), map);
    }

    boolean h(String str) throws com.google.zxing.h {
        return i(str);
    }

    int[] k(com.google.zxing.common.a aVar, int i7) throws com.google.zxing.m {
        return n(aVar, i7, false, f23982f);
    }

    protected abstract int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws com.google.zxing.m;

    public com.google.zxing.r m(int i7, com.google.zxing.common.a aVar, int[] iArr, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.d, com.google.zxing.h {
        int length;
        String strC;
        com.google.zxing.u uVar = map == null ? null : (com.google.zxing.u) map.get(com.google.zxing.e.NEED_RESULT_POINT_CALLBACK);
        boolean z7 = true;
        if (uVar != null) {
            uVar.a(new com.google.zxing.t((iArr[0] + iArr[1]) / 2.0f, i7));
        }
        StringBuilder sb = this.f23987a;
        sb.setLength(0);
        int iL = l(aVar, iArr, sb);
        if (uVar != null) {
            uVar.a(new com.google.zxing.t(iL, i7));
        }
        int[] iArrK = k(aVar, iL);
        if (uVar != null) {
            uVar.a(new com.google.zxing.t((iArrK[0] + iArrK[1]) / 2.0f, i7));
        }
        int i8 = iArrK[1];
        int i9 = (i8 - iArrK[0]) + i8;
        if (i9 >= aVar.o() || !aVar.q(i8, i9, false)) {
            throw com.google.zxing.m.a();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw com.google.zxing.h.a();
        }
        if (!h(string)) {
            throw com.google.zxing.d.a();
        }
        float f8 = (iArr[1] + iArr[0]) / 2.0f;
        float f9 = (iArrK[1] + iArrK[0]) / 2.0f;
        com.google.zxing.a aVarQ = q();
        float f10 = i7;
        com.google.zxing.r rVar = new com.google.zxing.r(string, null, new com.google.zxing.t[]{new com.google.zxing.t(f8, f10), new com.google.zxing.t(f9, f10)}, aVarQ);
        try {
            com.google.zxing.r rVarA = this.f23988b.a(i7, aVar, iArrK[1]);
            rVar.j(com.google.zxing.s.UPC_EAN_EXTENSION, rVarA.g());
            rVar.i(rVarA.e());
            rVar.a(rVarA.f());
            length = rVarA.g().length();
        } catch (com.google.zxing.q unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(com.google.zxing.e.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length2) {
                    z7 = false;
                    break;
                }
                if (length == iArr2[i10]) {
                    break;
                }
                i10++;
            }
            if (!z7) {
                throw com.google.zxing.m.a();
            }
        }
        if ((aVarQ == com.google.zxing.a.EAN_13 || aVarQ == com.google.zxing.a.UPC_A) && (strC = this.f23989c.c(string)) != null) {
            rVar.j(com.google.zxing.s.POSSIBLE_COUNTRY, strC);
        }
        return rVar;
    }

    abstract com.google.zxing.a q();
}
