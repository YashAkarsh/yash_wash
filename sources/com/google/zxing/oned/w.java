package com.google.zxing.oned;

import java.util.EnumMap;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f23974c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f23975a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f23976b = new StringBuilder();

    w() {
    }

    private int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws com.google.zxing.m {
        int[] iArr2 = this.f23975a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iO = aVar.o();
        int iN = iArr[1];
        int i7 = 0;
        for (int i8 = 0; i8 < 5 && iN < iO; i8++) {
            int iJ = y.j(aVar, iArr2, iN, y.f23986j);
            sb.append((char) ((iJ % 10) + 48));
            for (int i9 : iArr2) {
                iN += i9;
            }
            if (iJ >= 10) {
                i7 |= 1 << (4 - i8);
            }
            if (i8 != 4) {
                iN = aVar.n(aVar.m(iN));
            }
        }
        if (sb.length() != 5) {
            throw com.google.zxing.m.a();
        }
        if (d(sb.toString()) == c(i7)) {
            return iN;
        }
        throw com.google.zxing.m.a();
    }

    private static int c(int i7) throws com.google.zxing.m {
        for (int i8 = 0; i8 < 10; i8++) {
            if (i7 == f23974c[i8]) {
                return i8;
            }
        }
        throw com.google.zxing.m.a();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i7 = length - 2; i7 >= 0; i7 -= 2) {
            iCharAt += charSequence.charAt(i7) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i8 = length - 1; i8 >= 0; i8 -= 2) {
            iCharAt2 += charSequence.charAt(i8) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static String e(String str) {
        String str2;
        byte b8 = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt != '5') {
            str2 = "";
            if (cCharAt == '9') {
                switch (str.hashCode()) {
                    case 54118329:
                        if (!str.equals("90000")) {
                            b8 = -1;
                        }
                        break;
                    case 54395376:
                        b8 = !str.equals("99990") ? (byte) -1 : (byte) 1;
                        break;
                    case 54395377:
                        b8 = !str.equals("99991") ? (byte) -1 : (byte) 2;
                        break;
                    default:
                        b8 = -1;
                        break;
                }
                switch (b8) {
                    case 0:
                        return null;
                    case 1:
                        return "Used";
                    case 2:
                        return "0.00";
                }
            }
        } else {
            str2 = "$";
        }
        int i7 = Integer.parseInt(str.substring(1));
        String strValueOf = String.valueOf(i7 / 100);
        int i8 = i7 % 100;
        return str2 + strValueOf + ClassUtils.PACKAGE_SEPARATOR_CHAR + (i8 < 10 ? "0".concat(String.valueOf(i8)) : String.valueOf(i8));
    }

    private static Map<com.google.zxing.s, Object> f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(com.google.zxing.s.class);
        enumMap.put(com.google.zxing.s.SUGGESTED_PRICE, strE);
        return enumMap;
    }

    com.google.zxing.r b(int i7, com.google.zxing.common.a aVar, int[] iArr) throws com.google.zxing.m {
        StringBuilder sb = this.f23976b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<com.google.zxing.s, Object> mapF = f(string);
        float f8 = i7;
        com.google.zxing.r rVar = new com.google.zxing.r(string, null, new com.google.zxing.t[]{new com.google.zxing.t((iArr[0] + iArr[1]) / 2.0f, f8), new com.google.zxing.t(iA, f8)}, com.google.zxing.a.UPC_EAN_EXTENSION);
        if (mapF != null) {
            rVar.i(mapF);
        }
        return rVar;
    }
}
