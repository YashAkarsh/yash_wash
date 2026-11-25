package com.google.zxing.oned;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends y {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f23858k = new int[4];

    @Override // com.google.zxing.oned.y
    protected int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws com.google.zxing.m {
        int[] iArr2 = this.f23858k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iO = aVar.o();
        int i7 = iArr[1];
        for (int i8 = 0; i8 < 4 && i7 < iO; i8++) {
            sb.append((char) (y.j(aVar, iArr2, i7, y.f23985i) + 48));
            for (int i9 : iArr2) {
                i7 += i9;
            }
        }
        int i10 = y.n(aVar, i7, true, y.f23983g)[1];
        for (int i11 = 0; i11 < 4 && i10 < iO; i11++) {
            sb.append((char) (y.j(aVar, iArr2, i10, y.f23985i) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        return i10;
    }

    @Override // com.google.zxing.oned.y
    com.google.zxing.a q() {
        return com.google.zxing.a.EAN_8;
    }
}
