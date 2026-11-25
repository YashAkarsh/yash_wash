package com.google.zxing.datamatrix.decoder;

import com.google.zxing.h;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.b f23620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.zxing.common.b f23621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f23622c;

    a(com.google.zxing.common.b bVar) throws h {
        int iM = bVar.m();
        if (iM < 8 || iM > 144 || (iM & 1) != 0) {
            throw h.a();
        }
        this.f23622c = j(bVar);
        com.google.zxing.common.b bVarA = a(bVar);
        this.f23620a = bVarA;
        this.f23621b = new com.google.zxing.common.b(bVarA.q(), bVarA.m());
    }

    private com.google.zxing.common.b a(com.google.zxing.common.b bVar) {
        int iF = this.f23622c.f();
        int iE = this.f23622c.e();
        if (bVar.m() != iF) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int iC = this.f23622c.c();
        int iB = this.f23622c.b();
        int i7 = iF / iC;
        int i8 = iE / iB;
        com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(i8 * iB, i7 * iC);
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = i9 * iC;
            for (int i11 = 0; i11 < i8; i11++) {
                int i12 = i11 * iB;
                for (int i13 = 0; i13 < iC; i13++) {
                    int i14 = ((iC + 2) * i9) + 1 + i13;
                    int i15 = i10 + i13;
                    for (int i16 = 0; i16 < iB; i16++) {
                        if (bVar.j(((iB + 2) * i11) + 1 + i16, i14)) {
                            bVar2.u(i12 + i16, i15);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    private int d(int i7, int i8) {
        int i9 = i7 - 1;
        int i10 = (h(i9, 0, i7, i8) ? 1 : 0) << 1;
        if (h(i9, 1, i7, i8)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(i9, 2, i7, i8)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(0, i8 - 2, i7, i8)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        int i14 = i8 - 1;
        if (h(0, i14, i7, i8)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        if (h(1, i14, i7, i8)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (h(2, i14, i7, i8)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        return h(3, i14, i7, i8) ? i17 | 1 : i17;
    }

    private int e(int i7, int i8) {
        int i9 = (h(i7 + (-3), 0, i7, i8) ? 1 : 0) << 1;
        if (h(i7 - 2, 0, i7, i8)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(i7 - 1, 0, i7, i8)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(0, i8 - 4, i7, i8)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(0, i8 - 3, i7, i8)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(0, i8 - 2, i7, i8)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        int i15 = i8 - 1;
        if (h(0, i15, i7, i8)) {
            i14 |= 1;
        }
        int i16 = i14 << 1;
        return h(1, i15, i7, i8) ? i16 | 1 : i16;
    }

    private int f(int i7, int i8) {
        int i9 = i7 - 1;
        int i10 = (h(i9, 0, i7, i8) ? 1 : 0) << 1;
        int i11 = i8 - 1;
        if (h(i9, i11, i7, i8)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        int i13 = i8 - 3;
        if (h(0, i13, i7, i8)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        int i15 = i8 - 2;
        if (h(0, i15, i7, i8)) {
            i14 |= 1;
        }
        int i16 = i14 << 1;
        if (h(0, i11, i7, i8)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        if (h(1, i13, i7, i8)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (h(1, i15, i7, i8)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        return h(1, i11, i7, i8) ? i19 | 1 : i19;
    }

    private int g(int i7, int i8) {
        int i9 = (h(i7 + (-3), 0, i7, i8) ? 1 : 0) << 1;
        if (h(i7 - 2, 0, i7, i8)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(i7 - 1, 0, i7, i8)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(0, i8 - 2, i7, i8)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        int i13 = i8 - 1;
        if (h(0, i13, i7, i8)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        if (h(1, i13, i7, i8)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(2, i13, i7, i8)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return h(3, i13, i7, i8) ? i16 | 1 : i16;
    }

    private boolean h(int i7, int i8, int i9, int i10) {
        if (i7 < 0) {
            i7 += i9;
            i8 += 4 - ((i9 + 4) & 7);
        }
        if (i8 < 0) {
            i8 += i10;
            i7 += 4 - ((i10 + 4) & 7);
        }
        this.f23621b.u(i8, i7);
        return this.f23620a.j(i8, i7);
    }

    private int i(int i7, int i8, int i9, int i10) {
        int i11 = i7 - 2;
        int i12 = i8 - 2;
        int i13 = (h(i11, i12, i9, i10) ? 1 : 0) << 1;
        int i14 = i8 - 1;
        if (h(i11, i14, i9, i10)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        int i16 = i7 - 1;
        if (h(i16, i12, i9, i10)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        if (h(i16, i14, i9, i10)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (h(i16, i8, i9, i10)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (h(i7, i12, i9, i10)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        if (h(i7, i14, i9, i10)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        return h(i7, i8, i9, i10) ? i21 | 1 : i21;
    }

    private static e j(com.google.zxing.common.b bVar) throws h {
        return e.h(bVar.m(), bVar.q());
    }

    e b() {
        return this.f23622c;
    }

    byte[] c() throws h {
        byte[] bArr = new byte[this.f23622c.g()];
        int iM = this.f23620a.m();
        int iQ = this.f23620a.q();
        int i7 = 0;
        boolean z7 = false;
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        int i9 = 4;
        while (true) {
            if (i9 == iM && i7 == 0 && !z7) {
                bArr[i8] = (byte) d(iM, iQ);
                i9 -= 2;
                i7 += 2;
                i8++;
                z7 = true;
            } else {
                int i10 = iM - 2;
                if (i9 == i10 && i7 == 0 && (iQ & 3) != 0 && !z8) {
                    bArr[i8] = (byte) e(iM, iQ);
                    i9 -= 2;
                    i7 += 2;
                    i8++;
                    z8 = true;
                } else if (i9 == iM + 4 && i7 == 2 && (iQ & 7) == 0 && !z9) {
                    bArr[i8] = (byte) f(iM, iQ);
                    i9 -= 2;
                    i7 += 2;
                    i8++;
                    z9 = true;
                } else if (i9 == i10 && i7 == 0 && (iQ & 7) == 4 && !z10) {
                    bArr[i8] = (byte) g(iM, iQ);
                    i9 -= 2;
                    i7 += 2;
                    i8++;
                    z10 = true;
                } else {
                    do {
                        if (i9 < iM && i7 >= 0 && !this.f23621b.j(i7, i9)) {
                            bArr[i8] = (byte) i(i9, i7, iM, iQ);
                            i8++;
                        }
                        i9 -= 2;
                        i7 += 2;
                        if (i9 < 0) {
                            break;
                        }
                    } while (i7 < iQ);
                    int i11 = i9 + 1;
                    int i12 = i7 + 3;
                    do {
                        if (i11 >= 0 && i12 < iQ && !this.f23621b.j(i12, i11)) {
                            bArr[i8] = (byte) i(i11, i12, iM, iQ);
                            i8++;
                        }
                        i11 += 2;
                        i12 -= 2;
                        if (i11 >= iM) {
                            break;
                        }
                    } while (i12 >= 0);
                    i9 = i11 + 3;
                    i7 = i12 + 1;
                }
            }
            if (i9 >= iM && i7 >= iQ) {
                break;
            }
        }
        if (i8 == this.f23622c.g()) {
            return bArr;
        }
        throw h.a();
    }
}
