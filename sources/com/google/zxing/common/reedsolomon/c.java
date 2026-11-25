package com.google.zxing.common.reedsolomon;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f23616a;

    public c(a aVar) {
        this.f23616a = aVar;
    }

    private int[] b(b bVar) throws e {
        int iF = bVar.f();
        int i7 = 0;
        if (iF == 1) {
            return new int[]{bVar.d(1)};
        }
        int[] iArr = new int[iF];
        for (int i8 = 1; i8 < this.f23616a.f() && i7 < iF; i8++) {
            if (bVar.c(i8) == 0) {
                iArr[i7] = this.f23616a.h(i8);
                i7++;
            }
        }
        if (i7 == iF) {
            return iArr;
        }
        throw new e("Error locator degree does not match number of roots");
    }

    private int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            int iH = this.f23616a.h(iArr[i7]);
            int iJ = 1;
            for (int i8 = 0; i8 < length; i8++) {
                if (i7 != i8) {
                    int iJ2 = this.f23616a.j(iArr[i8], iH);
                    iJ = this.f23616a.j(iJ, (iJ2 & 1) == 0 ? iJ2 | 1 : iJ2 & (-2));
                }
            }
            iArr2[i7] = this.f23616a.j(bVar.c(iH), this.f23616a.h(iJ));
            if (this.f23616a.d() != 0) {
                iArr2[i7] = this.f23616a.j(iArr2[i7], iH);
            }
        }
        return iArr2;
    }

    private b[] d(b bVar, b bVar2, int i7) throws e {
        if (bVar.f() < bVar2.f()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b bVarG = this.f23616a.g();
        b bVarE = this.f23616a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = bVarE;
            b bVar5 = bVarG;
            bVarG = bVar4;
            if (bVar.f() < i7 / 2) {
                int iD = bVarG.d(0);
                if (iD == 0) {
                    throw new e("sigmaTilde(0) was zero");
                }
                int iH = this.f23616a.h(iD);
                return new b[]{bVarG.h(iH), bVar.h(iH)};
            }
            if (bVar.g()) {
                throw new e("r_{i-1} was zero");
            }
            b bVarG2 = this.f23616a.g();
            int iH2 = this.f23616a.h(bVar.d(bVar.f()));
            while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                int iF = bVar2.f() - bVar.f();
                int iJ = this.f23616a.j(bVar2.d(bVar2.f()), iH2);
                bVarG2 = bVarG2.a(this.f23616a.b(iF, iJ));
                bVar2 = bVar2.a(bVar.j(iF, iJ));
            }
            bVarE = bVarG2.i(bVarG).a(bVar5);
        } while (bVar2.f() < bVar.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void a(int[] iArr, int i7) throws e {
        b bVar = new b(this.f23616a, iArr);
        int[] iArr2 = new int[i7];
        boolean z7 = true;
        for (int i8 = 0; i8 < i7; i8++) {
            a aVar = this.f23616a;
            int iC = bVar.c(aVar.c(aVar.d() + i8));
            iArr2[(i7 - 1) - i8] = iC;
            if (iC != 0) {
                z7 = false;
            }
        }
        if (z7) {
            return;
        }
        b[] bVarArrD = d(this.f23616a.b(i7, 1), new b(this.f23616a, iArr2), i7);
        b bVar2 = bVarArrD[0];
        b bVar3 = bVarArrD[1];
        int[] iArrB = b(bVar2);
        int[] iArrC = c(bVar3, iArrB);
        for (int i9 = 0; i9 < iArrB.length; i9++) {
            int length = (iArr.length - 1) - this.f23616a.i(iArrB[i9]);
            if (length < 0) {
                throw new e("Bad error location");
            }
            iArr[length] = a.a(iArr[length], iArrC[i9]);
        }
    }
}
