package com.google.zxing.oned;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends y {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final int[] f23855l = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f23856k = new int[4];

    private static void s(StringBuilder sb, int i7) throws com.google.zxing.m {
        for (int i8 = 0; i8 < 10; i8++) {
            if (i7 == f23855l[i8]) {
                sb.insert(0, (char) (i8 + 48));
                return;
            }
        }
        throw com.google.zxing.m.a();
    }

    @Override // com.google.zxing.oned.y
    protected int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws com.google.zxing.m {
        int[] iArr2 = this.f23856k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iO = aVar.o();
        int i7 = iArr[1];
        int i8 = 0;
        for (int i9 = 0; i9 < 6 && i7 < iO; i9++) {
            int iJ = y.j(aVar, iArr2, i7, y.f23986j);
            sb.append((char) ((iJ % 10) + 48));
            for (int i10 : iArr2) {
                i7 += i10;
            }
            if (iJ >= 10) {
                i8 |= 1 << (5 - i9);
            }
        }
        s(sb, i8);
        int i11 = y.n(aVar, i7, true, y.f23983g)[1];
        for (int i12 = 0; i12 < 6 && i11 < iO; i12++) {
            sb.append((char) (y.j(aVar, iArr2, i11, y.f23985i) + 48));
            for (int i13 : iArr2) {
                i11 += i13;
            }
        }
        return i11;
    }

    @Override // com.google.zxing.oned.y
    com.google.zxing.a q() {
        return com.google.zxing.a.EAN_13;
    }
}
