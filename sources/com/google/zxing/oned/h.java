package com.google.zxing.oned;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h extends s {
    @Deprecated
    protected static int c(boolean[] zArr, int i7, int[] iArr, boolean z7) {
        return g(zArr, i7, iArr);
    }

    private static int g(boolean[] zArr, int i7, int[] iArr) {
        int length = iArr.length;
        int i8 = 0;
        while (i8 < length) {
            int i9 = i7 + 1;
            zArr[i7] = iArr[i8] != 0;
            i8++;
            i7 = i9;
        }
        return 9;
    }

    private static int h(String str, int i7) {
        int iIndexOf = 0;
        int i8 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i8;
            i8++;
            if (i8 > i7) {
                i8 = 1;
            }
        }
        return iIndexOf % 47;
    }

    private static void i(int i7, int[] iArr) {
        for (int i8 = 0; i8 < 9; i8++) {
            int i9 = 1;
            if (((1 << (8 - i8)) & i7) == 0) {
                i9 = 0;
            }
            iArr[i8] = i9;
        }
    }

    @Override // com.google.zxing.oned.s, com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<com.google.zxing.g, ?> map) throws com.google.zxing.w {
        if (aVar == com.google.zxing.a.CODE_93) {
            return super.b(str, aVar, i7, i8, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.oned.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        int[] iArr = new int[9];
        int length2 = ((str.length() + 2 + 2) * 9) + 1;
        i(g.f23851e[47], iArr);
        boolean[] zArr = new boolean[length2];
        int iG = g(zArr, 0, iArr);
        for (int i7 = 0; i7 < length; i7++) {
            i(g.f23851e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i7))], iArr);
            iG += g(zArr, iG, iArr);
        }
        int iH = h(str, 20);
        int[] iArr2 = g.f23851e;
        i(iArr2[iH], iArr);
        int iG2 = iG + g(zArr, iG, iArr);
        i(iArr2[h(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iH), 15)], iArr);
        int iG3 = iG2 + g(zArr, iG2, iArr);
        i(iArr2[47], iArr);
        zArr[iG3 + g(zArr, iG3, iArr)] = true;
        return zArr;
    }
}
