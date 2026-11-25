package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.b f24124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f24125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f24126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f24127d;

    a(com.google.zxing.common.b bVar) throws com.google.zxing.h {
        int iM = bVar.m();
        if (iM < 21 || (iM & 3) != 1) {
            throw com.google.zxing.h.a();
        }
        this.f24124a = bVar;
    }

    private int a(int i7, int i8, int i9) {
        return this.f24127d ? this.f24124a.j(i8, i7) : this.f24124a.j(i7, i8) ? (i9 << 1) | 1 : i9 << 1;
    }

    void b() {
        int i7 = 0;
        while (i7 < this.f24124a.q()) {
            int i8 = i7 + 1;
            for (int i9 = i8; i9 < this.f24124a.m(); i9++) {
                if (this.f24124a.j(i7, i9) != this.f24124a.j(i9, i7)) {
                    this.f24124a.i(i9, i7);
                    this.f24124a.i(i7, i9);
                }
            }
            i7 = i8;
        }
    }

    byte[] c() throws com.google.zxing.h {
        g gVarD = d();
        j jVarE = e();
        c cVar = c.values()[gVarD.c()];
        int iM = this.f24124a.m();
        cVar.b(this.f24124a, iM);
        com.google.zxing.common.b bVarA = jVarE.a();
        byte[] bArr = new byte[jVarE.h()];
        int i7 = iM - 1;
        boolean z7 = true;
        int i8 = i7;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i8 > 0) {
            if (i8 == 6) {
                i8--;
            }
            for (int i12 = 0; i12 < iM; i12++) {
                int i13 = z7 ? i7 - i12 : i12;
                for (int i14 = 0; i14 < 2; i14++) {
                    int i15 = i8 - i14;
                    if (!bVarA.j(i15, i13)) {
                        i10++;
                        i11 <<= 1;
                        if (this.f24124a.j(i15, i13)) {
                            i11 |= 1;
                        }
                        if (i10 == 8) {
                            bArr[i9] = (byte) i11;
                            i9++;
                            i10 = 0;
                            i11 = 0;
                        }
                    }
                }
            }
            z7 = !z7;
            i8 -= 2;
        }
        if (i9 == jVarE.h()) {
            return bArr;
        }
        throw com.google.zxing.h.a();
    }

    g d() throws com.google.zxing.h {
        g gVar = this.f24126c;
        if (gVar != null) {
            return gVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i7 = 0; i7 < 6; i7++) {
            iA2 = a(i7, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i8 = 5; i8 >= 0; i8--) {
            iA3 = a(8, i8, iA3);
        }
        int iM = this.f24124a.m();
        int i9 = iM - 7;
        for (int i10 = iM - 1; i10 >= i9; i10--) {
            iA = a(8, i10, iA);
        }
        for (int i11 = iM - 8; i11 < iM; i11++) {
            iA = a(i11, 8, iA);
        }
        g gVarA = g.a(iA3, iA);
        this.f24126c = gVarA;
        if (gVarA != null) {
            return gVarA;
        }
        throw com.google.zxing.h.a();
    }

    j e() throws com.google.zxing.h {
        j jVar = this.f24125b;
        if (jVar != null) {
            return jVar;
        }
        int iM = this.f24124a.m();
        int i7 = (iM - 17) / 4;
        if (i7 <= 6) {
            return j.i(i7);
        }
        int i8 = iM - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i9 = 5; i9 >= 0; i9--) {
            for (int i10 = iM - 9; i10 >= i8; i10--) {
                iA2 = a(i10, i9, iA2);
            }
        }
        j jVarC = j.c(iA2);
        if (jVarC != null && jVarC.e() == iM) {
            this.f24125b = jVarC;
            return jVarC;
        }
        for (int i11 = 5; i11 >= 0; i11--) {
            for (int i12 = iM - 9; i12 >= i8; i12--) {
                iA = a(i11, i12, iA);
            }
        }
        j jVarC2 = j.c(iA);
        if (jVarC2 == null || jVarC2.e() != iM) {
            throw com.google.zxing.h.a();
        }
        this.f24125b = jVarC2;
        return jVarC2;
    }

    void f() {
        if (this.f24126c == null) {
            return;
        }
        c.values()[this.f24126c.c()].b(this.f24124a, this.f24124a.m());
    }

    void g(boolean z7) {
        this.f24125b = null;
        this.f24126c = null;
        this.f24127d = z7;
    }
}
