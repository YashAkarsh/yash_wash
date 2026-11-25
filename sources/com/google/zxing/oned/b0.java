package com.google.zxing.oned;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f23804a = 51;

    @Override // com.google.zxing.oned.s, com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<com.google.zxing.g, ?> map) throws com.google.zxing.w {
        if (aVar == com.google.zxing.a.UPC_E) {
            return super.b(str, aVar, i7, i8, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.oned.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + y.r(a0.s(str));
            } catch (com.google.zxing.h e8) {
                throw new IllegalArgumentException(e8);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!y.i(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (com.google.zxing.h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i7 = a0.f23798m[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iC = s.c(zArr, 0, y.f23982f, true) + 0;
        for (int i8 = 1; i8 <= 6; i8++) {
            int iDigit2 = Character.digit(str.charAt(i8), 10);
            if (((i7 >> (6 - i8)) & 1) == 1) {
                iDigit2 += 10;
            }
            iC += s.c(zArr, iC, y.f23986j[iDigit2], false);
        }
        s.c(zArr, iC, y.f23984h, false);
        return zArr;
    }
}
