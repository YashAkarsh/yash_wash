package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f24129b;

    private b(int i7, byte[] bArr) {
        this.f24128a = i7;
        this.f24129b = bArr;
    }

    static b[] b(byte[] bArr, j jVar, f fVar) {
        if (bArr.length != jVar.h()) {
            throw new IllegalArgumentException();
        }
        j.b bVarF = jVar.f(fVar);
        j.a[] aVarArrA = bVarF.a();
        int iA = 0;
        for (j.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        b[] bVarArr = new b[iA];
        int i7 = 0;
        for (j.a aVar2 : aVarArrA) {
            int i8 = 0;
            while (i8 < aVar2.a()) {
                int iB = aVar2.b();
                bVarArr[i7] = new b(iB, new byte[bVarF.b() + iB]);
                i8++;
                i7++;
            }
        }
        int length = bVarArr[0].f24129b.length;
        int i9 = iA - 1;
        while (i9 >= 0 && bVarArr[i9].f24129b.length != length) {
            i9--;
        }
        int i10 = i9 + 1;
        int iB2 = length - bVarF.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB2; i12++) {
            int i13 = 0;
            while (i13 < i7) {
                bVarArr[i13].f24129b[i12] = bArr[i11];
                i13++;
                i11++;
            }
        }
        int i14 = i10;
        while (i14 < i7) {
            bVarArr[i14].f24129b[iB2] = bArr[i11];
            i14++;
            i11++;
        }
        int length2 = bVarArr[0].f24129b.length;
        while (iB2 < length2) {
            int i15 = 0;
            while (i15 < i7) {
                bVarArr[i15].f24129b[i15 < i10 ? iB2 : iB2 + 1] = bArr[i11];
                i15++;
                i11++;
            }
            iB2++;
        }
        return bVarArr;
    }

    byte[] a() {
        return this.f24129b;
    }

    int c() {
        return this.f24128a;
    }
}
