package com.google.zxing.datamatrix.decoder;

import com.google.zxing.h;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.reedsolomon.c f23639a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f23604m);

    private void a(byte[] bArr, int i7) throws com.google.zxing.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = bArr[i8] & 255;
        }
        try {
            this.f23639a.a(iArr, bArr.length - i7);
            for (int i9 = 0; i9 < i7; i9++) {
                bArr[i9] = (byte) iArr[i9];
            }
        } catch (com.google.zxing.common.reedsolomon.e unused) {
            throw com.google.zxing.d.a();
        }
    }

    public com.google.zxing.common.e b(com.google.zxing.common.b bVar) throws com.google.zxing.d, h {
        a aVar = new a(bVar);
        b[] bVarArrB = b.b(aVar.c(), aVar.b());
        int iC = 0;
        for (b bVar2 : bVarArrB) {
            iC += bVar2.c();
        }
        byte[] bArr = new byte[iC];
        int length = bVarArrB.length;
        for (int i7 = 0; i7 < length; i7++) {
            b bVar3 = bVarArrB[i7];
            byte[] bArrA = bVar3.a();
            int iC2 = bVar3.c();
            a(bArrA, iC2);
            for (int i8 = 0; i8 < iC2; i8++) {
                bArr[(i8 * length) + i7] = bArrA[i8];
            }
        }
        return c.a(bArr);
    }

    public com.google.zxing.common.e c(boolean[][] zArr) throws com.google.zxing.d, h {
        return b(com.google.zxing.common.b.s(zArr));
    }
}
