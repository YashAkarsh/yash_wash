package com.google.zxing.aztec.encoder;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f23371a = 33;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f23372b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f23373c = 32;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23374d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f23375e = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private c() {
    }

    private static int[] a(com.google.zxing.common.a aVar, int i7, int i8) {
        int[] iArr = new int[i8];
        int iO = aVar.o() / i7;
        for (int i9 = 0; i9 < iO; i9++) {
            int i10 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                i10 |= aVar.k((i9 * i7) + i11) ? 1 << ((i7 - i11) - 1) : 0;
            }
            iArr[i9] = i10;
        }
        return iArr;
    }

    private static void b(com.google.zxing.common.b bVar, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9 += 2) {
            int i10 = i7 - i9;
            int i11 = i10;
            while (true) {
                int i12 = i7 + i9;
                if (i11 <= i12) {
                    bVar.u(i11, i10);
                    bVar.u(i11, i12);
                    bVar.u(i10, i11);
                    bVar.u(i12, i11);
                    i11++;
                }
            }
        }
        int i13 = i7 - i8;
        bVar.u(i13, i13);
        int i14 = i13 + 1;
        bVar.u(i14, i13);
        bVar.u(i13, i14);
        int i15 = i7 + i8;
        bVar.u(i15, i13);
        bVar.u(i15, i14);
        bVar.u(i15, i15 - 1);
    }

    private static void c(com.google.zxing.common.b bVar, boolean z7, int i7, com.google.zxing.common.a aVar) {
        int i8 = i7 / 2;
        int i9 = 0;
        if (z7) {
            while (i9 < 7) {
                int i10 = (i8 - 3) + i9;
                if (aVar.k(i9)) {
                    bVar.u(i10, i8 - 5);
                }
                if (aVar.k(i9 + 7)) {
                    bVar.u(i8 + 5, i10);
                }
                if (aVar.k(20 - i9)) {
                    bVar.u(i10, i8 + 5);
                }
                if (aVar.k(27 - i9)) {
                    bVar.u(i8 - 5, i10);
                }
                i9++;
            }
            return;
        }
        while (i9 < 10) {
            int i11 = (i8 - 5) + i9 + (i9 / 5);
            if (aVar.k(i9)) {
                bVar.u(i11, i8 - 7);
            }
            if (aVar.k(i9 + 10)) {
                bVar.u(i8 + 7, i11);
            }
            if (aVar.k(29 - i9)) {
                bVar.u(i11, i8 + 7);
            }
            if (aVar.k(39 - i9)) {
                bVar.u(i8 - 7, i11);
            }
            i9++;
        }
    }

    public static a d(byte[] bArr) {
        return e(bArr, 33, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a e(byte[] bArr, int i7, int i8) {
        com.google.zxing.common.a aVarI;
        int i9;
        boolean z7;
        int iAbs;
        int iJ;
        int i10;
        com.google.zxing.common.a aVarA = new d(bArr).a();
        int iO = ((aVarA.o() * i7) / 100) + 11;
        int iO2 = aVarA.o() + iO;
        int i11 = 0;
        int i12 = 1;
        if (i8 != 0) {
            boolean z8 = i8 < 0;
            iAbs = Math.abs(i8);
            if (iAbs > (z8 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i8)));
            }
            iJ = j(iAbs, z8);
            i9 = f23375e[iAbs];
            int i13 = iJ - (iJ % i9);
            aVarI = i(aVarA, i9);
            if (aVarI.o() + iO > i13) {
                z7 = z8;
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z8) {
                z7 = z8;
                if (aVarI.o() > (i9 << 6)) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            }
        } else {
            com.google.zxing.common.a aVarI2 = null;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                if (i14 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                boolean z9 = i14 <= 3 ? i12 : i11;
                int i16 = z9 != 0 ? i14 + 1 : i14;
                int iJ2 = j(i16, z9);
                if (iO2 <= iJ2) {
                    if (aVarI2 == null || i15 != f23375e[i16]) {
                        int i17 = f23375e[i16];
                        i15 = i17;
                        aVarI2 = i(aVarA, i17);
                    }
                    int i18 = iJ2 - (iJ2 % i15);
                    if ((z9 == 0 || aVarI2.o() <= (i15 << 6)) && aVarI2.o() + iO <= i18) {
                        aVarI = aVarI2;
                        i9 = i15;
                        z7 = z9;
                        iAbs = i16;
                        iJ = iJ2;
                        break;
                    }
                }
                i14++;
                i12 = i12;
                i11 = 0;
            }
        }
        com.google.zxing.common.a aVarF = f(aVarI, iJ, i9);
        int iO3 = aVarI.o() / i9;
        com.google.zxing.common.a aVarG = g(z7, iAbs, iO3);
        int i19 = (z7 ? 11 : 14) + (iAbs << 2);
        int[] iArr = new int[i19];
        int i20 = 2;
        if (z7) {
            for (int i21 = i11; i21 < i19; i21++) {
                iArr[i21] = i21;
            }
            i10 = i19;
        } else {
            int i22 = i19 / 2;
            i10 = i19 + 1 + (((i22 - 1) / 15) * 2);
            int i23 = i10 / 2;
            for (int i24 = i11; i24 < i22; i24++) {
                int i25 = (i24 / 15) + i24;
                iArr[(i22 - i24) - i12] = (i23 - i25) - 1;
                iArr[i22 + i24] = i25 + i23 + i12;
            }
        }
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(i10);
        int i26 = i11;
        int i27 = i26;
        while (i26 < iAbs) {
            int i28 = ((iAbs - i26) << i20) + (z7 ? 9 : 12);
            int i29 = i11;
            while (i29 < i28) {
                int i30 = i29 << 1;
                while (i11 < i20) {
                    if (aVarF.k(i27 + i30 + i11)) {
                        int i31 = i26 << 1;
                        bVar.u(iArr[i31 + i11], iArr[i31 + i29]);
                    }
                    if (aVarF.k((i28 << 1) + i27 + i30 + i11)) {
                        int i32 = i26 << 1;
                        bVar.u(iArr[i32 + i29], iArr[((i19 - 1) - i32) - i11]);
                    }
                    if (aVarF.k((i28 << 2) + i27 + i30 + i11)) {
                        int i33 = (i19 - 1) - (i26 << 1);
                        bVar.u(iArr[i33 - i11], iArr[i33 - i29]);
                    }
                    if (aVarF.k((i28 * 6) + i27 + i30 + i11)) {
                        int i34 = i26 << 1;
                        bVar.u(iArr[((i19 - 1) - i34) - i29], iArr[i34 + i11]);
                    }
                    i11++;
                    i20 = 2;
                }
                i29++;
                i11 = 0;
                i20 = 2;
            }
            i27 += i28 << 3;
            i26++;
            i11 = 0;
            i20 = 2;
        }
        c(bVar, z7, i10, aVarG);
        if (z7) {
            b(bVar, i10 / 2, 5);
        } else {
            int i35 = i10 / 2;
            b(bVar, i35, 7);
            int i36 = 0;
            int i37 = 0;
            while (i37 < (i19 / 2) - 1) {
                for (int i38 = i35 & 1; i38 < i10; i38 += 2) {
                    int i39 = i35 - i36;
                    bVar.u(i39, i38);
                    int i40 = i35 + i36;
                    bVar.u(i40, i38);
                    bVar.u(i38, i39);
                    bVar.u(i38, i40);
                }
                i37 += 15;
                i36 += 16;
            }
        }
        a aVar = new a();
        aVar.g(z7);
        aVar.j(i10);
        aVar.h(iAbs);
        aVar.f(iO3);
        aVar.i(bVar);
        return aVar;
    }

    private static com.google.zxing.common.a f(com.google.zxing.common.a aVar, int i7, int i8) {
        int iO = aVar.o() / i8;
        com.google.zxing.common.reedsolomon.d dVar = new com.google.zxing.common.reedsolomon.d(h(i8));
        int i9 = i7 / i8;
        int[] iArrA = a(aVar, i8, i9);
        dVar.b(iArrA, i9 - iO);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        aVar2.c(0, i7 % i8);
        for (int i10 : iArrA) {
            aVar2.c(i10, i8);
        }
        return aVar2;
    }

    static com.google.zxing.common.a g(boolean z7, int i7, int i8) {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        if (z7) {
            aVar.c(i7 - 1, 2);
            aVar.c(i8 - 1, 6);
            return f(aVar, 28, 4);
        }
        aVar.c(i7 - 1, 5);
        aVar.c(i8 - 1, 11);
        return f(aVar, 40, 4);
    }

    private static com.google.zxing.common.reedsolomon.a h(int i7) {
        if (i7 == 4) {
            return com.google.zxing.common.reedsolomon.a.f23602k;
        }
        if (i7 == 6) {
            return com.google.zxing.common.reedsolomon.a.f23601j;
        }
        if (i7 == 8) {
            return com.google.zxing.common.reedsolomon.a.f23605n;
        }
        if (i7 == 10) {
            return com.google.zxing.common.reedsolomon.a.f23600i;
        }
        if (i7 == 12) {
            return com.google.zxing.common.reedsolomon.a.f23599h;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i7)));
    }

    static com.google.zxing.common.a i(com.google.zxing.common.a aVar, int i7) {
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        int iO = aVar.o();
        int i8 = (1 << i7) - 2;
        int i9 = 0;
        while (i9 < iO) {
            int i10 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                int i12 = i9 + i11;
                if (i12 >= iO || aVar.k(i12)) {
                    i10 |= 1 << ((i7 - 1) - i11);
                }
            }
            int i13 = i10 & i8;
            if (i13 == i8) {
                aVar2.c(i13, i7);
            } else {
                if (i13 == 0) {
                    aVar2.c(i10 | 1, i7);
                } else {
                    aVar2.c(i10, i7);
                }
                i9 += i7;
            }
            i9--;
            i9 += i7;
        }
        return aVar2;
    }

    private static int j(int i7, boolean z7) {
        return ((z7 ? 88 : 112) + (i7 << 4)) * i7;
    }
}
