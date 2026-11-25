package com.google.zxing.pdf417.decoder;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[][] f24063a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, e2.a.f33522i.length, 8);

    static {
        int i7;
        int i8 = 0;
        while (true) {
            int[] iArr = e2.a.f33522i;
            if (i8 >= iArr.length) {
                return;
            }
            int i9 = iArr[i8];
            int i10 = i9 & 1;
            int i11 = 0;
            while (i11 < 8) {
                float f8 = 0.0f;
                while (true) {
                    i7 = i9 & 1;
                    if (i7 == i10) {
                        f8 += 1.0f;
                        i9 >>= 1;
                    }
                }
                f24063a[i8][(8 - i11) - 1] = f8 / 17.0f;
                i11++;
                i10 = i7;
            }
            i8++;
        }
    }

    private i() {
    }

    private static int a(int[] iArr) {
        long j7 = 0;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            for (int i8 = 0; i8 < iArr[i7]; i8++) {
                int i9 = 1;
                long j8 = j7 << 1;
                if (i7 % 2 != 0) {
                    i9 = 0;
                }
                j7 = j8 | ((long) i9);
            }
        }
        return (int) j7;
    }

    private static int b(int[] iArr) {
        int iD = a2.a.d(iArr);
        float[] fArr = new float[8];
        if (iD > 1) {
            for (int i7 = 0; i7 < 8; i7++) {
                fArr[i7] = iArr[i7] / iD;
            }
        }
        float f8 = Float.MAX_VALUE;
        int i8 = -1;
        int i9 = 0;
        while (true) {
            float[][] fArr2 = f24063a;
            if (i9 >= fArr2.length) {
                return i8;
            }
            float[] fArr3 = fArr2[i9];
            float f9 = 0.0f;
            for (int i10 = 0; i10 < 8; i10++) {
                float f10 = fArr3[i10] - fArr[i10];
                f9 += f10 * f10;
                if (f9 >= f8) {
                    break;
                }
            }
            if (f9 < f8) {
                i8 = e2.a.f33522i[i9];
                f8 = f9;
            }
            i9++;
        }
    }

    private static int c(int[] iArr) {
        int iA = a(iArr);
        if (e2.a.b(iA) == -1) {
            return -1;
        }
        return iA;
    }

    static int d(int[] iArr) {
        int iC = c(e(iArr));
        return iC != -1 ? iC : b(iArr);
    }

    private static int[] e(int[] iArr) {
        float fD = a2.a.d(iArr);
        int[] iArr2 = new int[8];
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < 17; i9++) {
            float f8 = (fD / 34.0f) + ((i9 * fD) / 17.0f);
            int i10 = iArr[i8];
            if (i7 + i10 <= f8) {
                i7 += i10;
                i8++;
            }
            iArr2[i8] = iArr2[i8] + 1;
        }
        return iArr2;
    }
}
