package com.google.zxing.common;

import com.google.zxing.m;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f23577i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f23578j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f23579k = 7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f23580l = 40;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f23581m = 24;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f23582h;

    public j(com.google.zxing.j jVar) {
        super(jVar);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009a A[PHI: r5
      0x009a: PHI (r5v4 int) = (r5v3 int), (r5v7 int), (r5v7 int) binds: [B:31:0x007a, B:33:0x007e, B:34:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    private static int[][] i(byte[] bArr, int i7, int i8, int i9, int i10) {
        char c8;
        int i11 = 8;
        int i12 = i10 - 8;
        int i13 = i9 - 8;
        char c9 = 2;
        boolean z7 = true;
        int i14 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i8, i7);
        int i15 = 0;
        while (i15 < i8) {
            int i16 = i15 << 3;
            if (i16 > i12) {
                i16 = i12;
            }
            int i17 = i14;
            while (i17 < i7) {
                int i18 = i17 << 3;
                if (i18 > i13) {
                    i18 = i13;
                }
                int i19 = (i16 * i9) + i18;
                int i20 = i14;
                int i21 = i20;
                int i22 = i21;
                int i23 = 255;
                while (i20 < i11) {
                    int i24 = i22;
                    int i25 = 0;
                    while (i25 < i11) {
                        int i26 = bArr[i19 + i25] & 255;
                        i21 += i26;
                        if (i26 < i23) {
                            i23 = i26;
                        }
                        if (i26 > i24) {
                            i24 = i26;
                        }
                        i25++;
                        i11 = 8;
                    }
                    if (i24 - i23 > 24) {
                        while (true) {
                            i20++;
                            i19 += i9;
                            if (i20 < 8) {
                                int i27 = 0;
                                for (int i28 = 8; i27 < i28; i28 = 8) {
                                    i21 += bArr[i19 + i27] & 255;
                                    i27++;
                                }
                            }
                        }
                    }
                    i20++;
                    i19 += i9;
                    i22 = i24;
                    z7 = true;
                    i11 = 8;
                }
                boolean z8 = z7;
                int i29 = i21 >> 6;
                if (i22 - i23 <= 24) {
                    i29 = i23 / 2;
                    if (i15 <= 0 || i17 <= 0) {
                        c8 = 2;
                    } else {
                        int[] iArr2 = iArr[i15 - 1];
                        int i30 = i17 - 1;
                        c8 = 2;
                        int i31 = ((iArr2[i17] + (iArr[i15][i30] * 2)) + iArr2[i30]) / 4;
                        if (i23 < i31) {
                            i29 = i31;
                        }
                    }
                } else {
                    c8 = 2;
                }
                iArr[i15][i17] = i29;
                i17++;
                z7 = z8;
                c9 = c8;
                i11 = 8;
                i14 = 0;
            }
            i15++;
            i11 = 8;
            i14 = 0;
        }
        return iArr;
    }

    private static void j(byte[] bArr, int i7, int i8, int i9, int i10, int[][] iArr, b bVar) {
        int i11 = i10 - 8;
        int i12 = i9 - 8;
        for (int i13 = 0; i13 < i8; i13++) {
            int i14 = i13 << 3;
            int i15 = i14 > i11 ? i11 : i14;
            int iK = k(i13, 2, i8 - 3);
            for (int i16 = 0; i16 < i7; i16++) {
                int i17 = i16 << 3;
                int i18 = i17 > i12 ? i12 : i17;
                int iK2 = k(i16, 2, i7 - 3);
                int i19 = 0;
                for (int i20 = -2; i20 <= 2; i20++) {
                    int[] iArr2 = iArr[iK + i20];
                    i19 += iArr2[iK2 - 2] + iArr2[iK2 - 1] + iArr2[iK2] + iArr2[iK2 + 1] + iArr2[iK2 + 2];
                }
                l(bArr, i18, i15, i19 / 25, i9, bVar);
            }
        }
    }

    private static int k(int i7, int i8, int i9) {
        if (i7 < i8) {
            return i8;
        }
        return i7 > i9 ? i9 : i7;
    }

    private static void l(byte[] bArr, int i7, int i8, int i9, int i10, b bVar) {
        int i11 = (i8 * i10) + i7;
        int i12 = 0;
        while (i12 < 8) {
            for (int i13 = 0; i13 < 8; i13++) {
                if ((bArr[i11 + i13] & 255) <= i9) {
                    bVar.u(i7 + i13, i8 + i12);
                }
            }
            i12++;
            i11 += i10;
        }
    }

    @Override // com.google.zxing.common.h, com.google.zxing.b
    public com.google.zxing.b a(com.google.zxing.j jVar) {
        return new j(jVar);
    }

    @Override // com.google.zxing.common.h, com.google.zxing.b
    public b b() throws m {
        b bVar = this.f23582h;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.j jVarE = e();
        int iE = jVarE.e();
        int iB = jVarE.b();
        if (iE < 40 || iB < 40) {
            this.f23582h = super.b();
        } else {
            byte[] bArrC = jVarE.c();
            int i7 = iE >> 3;
            if ((iE & 7) != 0) {
                i7++;
            }
            int i8 = i7;
            int i9 = iB >> 3;
            if ((iB & 7) != 0) {
                i9++;
            }
            int i10 = i9;
            int[][] iArrI = i(bArrC, i8, i10, iE, iB);
            b bVar2 = new b(iE, iB);
            j(bArrC, i8, i10, iE, iB, iArrI, bVar2);
            this.f23582h = bVar2;
        }
        return this.f23582h;
    }
}
