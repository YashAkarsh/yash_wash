package com.google.zxing.oned;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f23857a = 95;

    @Override // com.google.zxing.oned.s, com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<com.google.zxing.g, ?> map) throws com.google.zxing.w {
        if (aVar == com.google.zxing.a.EAN_13) {
            return super.b(str, aVar, i7, i8, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.oned.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + y.r(str);
            } catch (com.google.zxing.h e8) {
                throw new IllegalArgumentException(e8);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!y.i(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (com.google.zxing.h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        int i7 = i.f23855l[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[f23857a];
        int iC = s.c(zArr, 0, y.f23982f, true) + 0;
        for (int i8 = 1; i8 <= 6; i8++) {
            int iDigit = Character.digit(str.charAt(i8), 10);
            if (((i7 >> (6 - i8)) & 1) == 1) {
                iDigit += 10;
            }
            iC += s.c(zArr, iC, y.f23986j[iDigit], false);
        }
        int iC2 = iC + s.c(zArr, iC, y.f23983g, false);
        for (int i9 = 7; i9 <= 12; i9++) {
            iC2 += s.c(zArr, iC2, y.f23985i[Character.digit(str.charAt(i9), 10)], true);
        }
        s.c(zArr, iC2, y.f23982f, true);
        return zArr;
    }
}
