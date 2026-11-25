package com.google.zxing.common;

import com.google.zxing.m;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.google.zxing.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23570d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f23571e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f23572f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f23573g = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f23574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f23575c;

    public h(com.google.zxing.j jVar) {
        super(jVar);
        this.f23574b = f23573g;
        this.f23575c = new int[32];
    }

    private static int g(int[] iArr) throws m {
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            if (i11 > i7) {
                i9 = i10;
                i7 = i11;
            }
            if (i11 > i8) {
                i8 = i11;
            }
        }
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            int i15 = i14 - i9;
            int i16 = iArr[i14] * i15 * i15;
            if (i16 > i13) {
                i12 = i14;
                i13 = i16;
            }
        }
        if (i9 <= i12) {
            int i17 = i9;
            i9 = i12;
            i12 = i17;
        }
        if (i9 - i12 <= length / 16) {
            throw m.a();
        }
        int i18 = i9 - 1;
        int i19 = -1;
        int i20 = i18;
        while (i18 > i12) {
            int i21 = i18 - i12;
            int i22 = i21 * i21 * (i9 - i18) * (i8 - iArr[i18]);
            if (i22 > i19) {
                i20 = i18;
                i19 = i22;
            }
            i18--;
        }
        return i20 << 3;
    }

    private void h(int i7) {
        if (this.f23574b.length < i7) {
            this.f23574b = new byte[i7];
        }
        for (int i8 = 0; i8 < 32; i8++) {
            this.f23575c[i8] = 0;
        }
    }

    @Override // com.google.zxing.b
    public com.google.zxing.b a(com.google.zxing.j jVar) {
        return new h(jVar);
    }

    @Override // com.google.zxing.b
    public b b() throws m {
        com.google.zxing.j jVarE = e();
        int iE = jVarE.e();
        int iB = jVarE.b();
        b bVar = new b(iE, iB);
        h(iE);
        int[] iArr = this.f23575c;
        for (int i7 = 1; i7 < 5; i7++) {
            byte[] bArrD = jVarE.d((iB * i7) / 5, this.f23574b);
            int i8 = (iE << 2) / 5;
            for (int i9 = iE / 5; i9 < i8; i9++) {
                int i10 = (bArrD[i9] & 255) >> 3;
                iArr[i10] = iArr[i10] + 1;
            }
        }
        int iG = g(iArr);
        byte[] bArrC = jVarE.c();
        for (int i11 = 0; i11 < iB; i11++) {
            int i12 = i11 * iE;
            for (int i13 = 0; i13 < iE; i13++) {
                if ((bArrC[i12 + i13] & 255) < iG) {
                    bVar.u(i13, i11);
                }
            }
        }
        return bVar;
    }

    @Override // com.google.zxing.b
    public a c(int i7, a aVar) throws m {
        com.google.zxing.j jVarE = e();
        int iE = jVarE.e();
        if (aVar == null || aVar.o() < iE) {
            aVar = new a(iE);
        } else {
            aVar.e();
        }
        h(iE);
        byte[] bArrD = jVarE.d(i7, this.f23574b);
        int[] iArr = this.f23575c;
        for (int i8 = 0; i8 < iE; i8++) {
            int i9 = (bArrD[i8] & 255) >> 3;
            iArr[i9] = iArr[i9] + 1;
        }
        int iG = g(iArr);
        if (iE < 3) {
            for (int i10 = 0; i10 < iE; i10++) {
                if ((bArrD[i10] & 255) < iG) {
                    aVar.t(i10);
                }
            }
        } else {
            int i11 = 1;
            int i12 = bArrD[0] & 255;
            int i13 = bArrD[1] & 255;
            while (i11 < iE - 1) {
                int i14 = i11 + 1;
                int i15 = bArrD[i14] & 255;
                if ((((i13 << 2) - i12) - i15) / 2 < iG) {
                    aVar.t(i11);
                }
                i12 = i13;
                i11 = i14;
                i13 = i15;
            }
        }
        return aVar;
    }
}
