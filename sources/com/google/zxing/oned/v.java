package com.google.zxing.oned;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f23972a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f23973b = new StringBuilder();

    v() {
    }

    private int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws com.google.zxing.m {
        int[] iArr2 = this.f23972a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iO = aVar.o();
        int iN = iArr[1];
        int i7 = 0;
        for (int i8 = 0; i8 < 2 && iN < iO; i8++) {
            int iJ = y.j(aVar, iArr2, iN, y.f23986j);
            sb.append((char) ((iJ % 10) + 48));
            for (int i9 : iArr2) {
                iN += i9;
            }
            if (iJ >= 10) {
                i7 |= 1 << (1 - i8);
            }
            if (i8 != 1) {
                iN = aVar.n(aVar.m(iN));
            }
        }
        if (sb.length() != 2) {
            throw com.google.zxing.m.a();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i7) {
            return iN;
        }
        throw com.google.zxing.m.a();
    }

    private static Map<com.google.zxing.s, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(com.google.zxing.s.class);
        enumMap.put(com.google.zxing.s.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    com.google.zxing.r b(int i7, com.google.zxing.common.a aVar, int[] iArr) throws com.google.zxing.m {
        StringBuilder sb = this.f23973b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<com.google.zxing.s, Object> mapC = c(string);
        float f8 = i7;
        com.google.zxing.r rVar = new com.google.zxing.r(string, null, new com.google.zxing.t[]{new com.google.zxing.t((iArr[0] + iArr[1]) / 2.0f, f8), new com.google.zxing.t(iA, f8)}, com.google.zxing.a.UPC_EAN_EXTENSION);
        if (mapC != null) {
            rVar.i(mapC);
        }
        return rVar;
    }
}
