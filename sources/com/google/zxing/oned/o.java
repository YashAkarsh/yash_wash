package com.google.zxing.oned;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f23874c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23875d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f23872a = {1, 1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f23873b = {3, 1, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[][] f23876e = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.oned.s, com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<com.google.zxing.g, ?> map) throws com.google.zxing.w {
        if (aVar == com.google.zxing.a.ITF) {
            return super.b(str, aVar, i7, i8, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.oned.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iC = s.c(zArr, 0, f23872a, true);
        for (int i7 = 0; i7 < length; i7 += 2) {
            int iDigit = Character.digit(str.charAt(i7), 10);
            int iDigit2 = Character.digit(str.charAt(i7 + 1), 10);
            int[] iArr = new int[10];
            for (int i8 = 0; i8 < 5; i8++) {
                int i9 = i8 * 2;
                int[][] iArr2 = f23876e;
                iArr[i9] = iArr2[iDigit][i8];
                iArr[i9 + 1] = iArr2[iDigit2][i8];
            }
            iC += s.c(zArr, iC, iArr, true);
        }
        s.c(zArr, iC, f23873b, true);
        return zArr;
    }
}
