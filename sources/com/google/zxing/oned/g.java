package com.google.zxing.oned;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f23849c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f23850d = f23849c.toCharArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f23851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f23852f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f23853a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f23854b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, androidx.constraintlayout.core.motion.utils.w.c.f3064v, androidx.constraintlayout.core.motion.utils.w.c.f3060r, 418, 404, androidx.constraintlayout.core.motion.utils.w.c.f3045c, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, androidx.constraintlayout.core.motion.utils.w.c.f3062t, 406, 410, 364, 358, 310, 314, 302, 468, 466, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 366, 374, 430, 294, 474, 470, 306, 350};
        f23851e = iArr;
        f23852f = iArr[47];
    }

    private static void h(CharSequence charSequence) throws com.google.zxing.d {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    private static void i(CharSequence charSequence, int i7, int i8) throws com.google.zxing.d {
        int iIndexOf = 0;
        int i9 = 1;
        for (int i10 = i7 - 1; i10 >= 0; i10--) {
            iIndexOf += f23849c.indexOf(charSequence.charAt(i10)) * i9;
            i9++;
            if (i9 > i8) {
                i9 = 1;
            }
        }
        if (charSequence.charAt(i7) != f23850d[iIndexOf % 47]) {
            throw com.google.zxing.d.a();
        }
    }

    private static String j(CharSequence charSequence) throws com.google.zxing.h {
        int i7;
        char c8;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i8 = 0;
        while (i8 < length) {
            char cCharAt = charSequence.charAt(i8);
            if (cCharAt >= 'a' && cCharAt <= 'd') {
                if (i8 >= length - 1) {
                    throw com.google.zxing.h.a();
                }
                i8++;
                char cCharAt2 = charSequence.charAt(i8);
                switch (cCharAt) {
                    case 'a':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw com.google.zxing.h.a();
                        }
                        i7 = cCharAt2 - '@';
                        c8 = (char) i7;
                        sb.append(c8);
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i7 = cCharAt2 - '&';
                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                            i7 = cCharAt2 - 11;
                        } else if (cCharAt2 < 'K' || cCharAt2 > 'O') {
                            if (cCharAt2 >= 'P' && cCharAt2 <= 'S') {
                                i7 = cCharAt2 + '+';
                            } else {
                                if (cCharAt2 < 'T' || cCharAt2 > 'Z') {
                                    throw com.google.zxing.h.a();
                                }
                                c8 = com.google.common.base.c.N;
                            }
                            sb.append(c8);
                        } else {
                            i7 = cCharAt2 + 16;
                        }
                        c8 = (char) i7;
                        sb.append(c8);
                        break;
                    case com.haier.uhome.ble.a.f28150x /* 99 */:
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i7 = cCharAt2 - ' ';
                            c8 = (char) i7;
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw com.google.zxing.h.a();
                            }
                            c8 = ':';
                        }
                        sb.append(c8);
                        break;
                    case 'd':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw com.google.zxing.h.a();
                        }
                        i7 = cCharAt2 + ' ';
                        c8 = (char) i7;
                        sb.append(c8);
                        break;
                    default:
                        c8 = 0;
                        sb.append(c8);
                        break;
                }
            } else {
                sb.append(cCharAt);
            }
            i8++;
        }
        return sb.toString();
    }

    private int[] k(com.google.zxing.common.a aVar) throws com.google.zxing.m {
        int iO = aVar.o();
        int iM = aVar.m(0);
        Arrays.fill(this.f23854b, 0);
        int[] iArr = this.f23854b;
        int length = iArr.length;
        boolean z7 = false;
        int i7 = 0;
        int i8 = iM;
        while (iM < iO) {
            if (aVar.k(iM) != z7) {
                iArr[i7] = iArr[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (m(iArr) == f23852f) {
                        return new int[]{i8, iM};
                    }
                    i8 += iArr[0] + iArr[1];
                    int i9 = i7 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i9);
                    iArr[i9] = 0;
                    iArr[i7] = 0;
                    i7--;
                }
                iArr[i7] = 1;
                z7 = !z7;
            }
            iM++;
        }
        throw com.google.zxing.m.a();
    }

    private static char l(int i7) throws com.google.zxing.m {
        int i8 = 0;
        while (true) {
            int[] iArr = f23851e;
            if (i8 >= iArr.length) {
                throw com.google.zxing.m.a();
            }
            if (iArr[i8] == i7) {
                return f23850d[i8];
            }
            i8++;
        }
    }

    private static int m(int[] iArr) {
        int i7 = 0;
        for (int i8 : iArr) {
            i7 += i8;
        }
        int length = iArr.length;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            int iRound = Math.round((iArr[i10] * 9.0f) / i7);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i10 & 1) == 0) {
                for (int i11 = 0; i11 < iRound; i11++) {
                    i9 = (i9 << 1) | 1;
                }
            } else {
                i9 <<= iRound;
            }
        }
        return i9;
    }

    @Override // com.google.zxing.oned.r
    public com.google.zxing.r c(int i7, com.google.zxing.common.a aVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.d, com.google.zxing.h {
        int[] iArrK = k(aVar);
        int iM = aVar.m(iArrK[1]);
        int iO = aVar.o();
        int[] iArr = this.f23854b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f23853a;
        sb.setLength(0);
        while (true) {
            r.f(aVar, iM, iArr);
            int iM2 = m(iArr);
            if (iM2 < 0) {
                throw com.google.zxing.m.a();
            }
            char cL = l(iM2);
            sb.append(cL);
            int i8 = iM;
            for (int i9 : iArr) {
                i8 += i9;
            }
            int iM3 = aVar.m(i8);
            if (cL == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i10 = 0;
                for (int i11 : iArr) {
                    i10 += i11;
                }
                if (iM3 == iO || !aVar.k(iM3)) {
                    throw com.google.zxing.m.a();
                }
                if (sb.length() < 2) {
                    throw com.google.zxing.m.a();
                }
                h(sb);
                sb.setLength(sb.length() - 2);
                float f8 = i7;
                return new com.google.zxing.r(j(sb), null, new com.google.zxing.t[]{new com.google.zxing.t((iArrK[1] + iArrK[0]) / 2.0f, f8), new com.google.zxing.t(iM + (i10 / 2.0f), f8)}, com.google.zxing.a.CODE_93);
            }
            iM = iM3;
        }
    }
}
