package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f24045a = b.f24046f;

    private int[] b(c cVar) throws d {
        int iE = cVar.e();
        int[] iArr = new int[iE];
        int i7 = 0;
        for (int i8 = 1; i8 < this.f24045a.e() && i7 < iE; i8++) {
            if (cVar.b(i8) == 0) {
                iArr[i7] = this.f24045a.g(i8);
                i7++;
            }
        }
        if (i7 == iE) {
            return iArr;
        }
        throw d.a();
    }

    private int[] c(c cVar, c cVar2, int[] iArr) {
        int iE = cVar2.e();
        int[] iArr2 = new int[iE];
        for (int i7 = 1; i7 <= iE; i7++) {
            iArr2[iE - i7] = this.f24045a.i(i7, cVar2.c(i7));
        }
        c cVar3 = new c(this.f24045a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            int iG = this.f24045a.g(iArr[i8]);
            iArr3[i8] = this.f24045a.i(this.f24045a.j(0, cVar.b(iG)), this.f24045a.g(cVar3.b(iG)));
        }
        return iArr3;
    }

    private c[] d(c cVar, c cVar2, int i7) throws d {
        if (cVar.e() < cVar2.e()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c cVarF = this.f24045a.f();
        c cVarD = this.f24045a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = cVarD;
            c cVar5 = cVarF;
            cVarF = cVar4;
            if (cVar.e() < i7 / 2) {
                int iC = cVarF.c(0);
                if (iC == 0) {
                    throw d.a();
                }
                int iG = this.f24045a.g(iC);
                return new c[]{cVarF.g(iG), cVar.g(iG)};
            }
            if (cVar.f()) {
                throw d.a();
            }
            c cVarF2 = this.f24045a.f();
            int iG2 = this.f24045a.g(cVar.c(cVar.e()));
            while (cVar2.e() >= cVar.e() && !cVar2.f()) {
                int iE = cVar2.e() - cVar.e();
                int i8 = this.f24045a.i(cVar2.c(cVar2.e()), iG2);
                cVarF2 = cVarF2.a(this.f24045a.b(iE, i8));
                cVar2 = cVar2.k(cVar.i(iE, i8));
            }
            cVarD = cVarF2.h(cVarF).k(cVar5).j();
        }
    }

    public int a(int[] iArr, int i7, int[] iArr2) throws d {
        c cVar = new c(this.f24045a, iArr);
        int[] iArr3 = new int[i7];
        boolean z7 = false;
        for (int i8 = i7; i8 > 0; i8--) {
            int iB = cVar.b(this.f24045a.c(i8));
            iArr3[i7 - i8] = iB;
            if (iB != 0) {
                z7 = true;
            }
        }
        if (!z7) {
            return 0;
        }
        c cVarD = this.f24045a.d();
        if (iArr2 != null) {
            for (int i9 : iArr2) {
                int iC = this.f24045a.c((iArr.length - 1) - i9);
                b bVar = this.f24045a;
                cVarD = cVarD.h(new c(bVar, new int[]{bVar.j(0, iC), 1}));
            }
        }
        c[] cVarArrD = d(this.f24045a.b(i7, 1), new c(this.f24045a, iArr3), i7);
        c cVar2 = cVarArrD[0];
        c cVar3 = cVarArrD[1];
        int[] iArrB = b(cVar2);
        int[] iArrC = c(cVar3, cVar2, iArrB);
        for (int i10 = 0; i10 < iArrB.length; i10++) {
            int length = (iArr.length - 1) - this.f24045a.h(iArrB[i10]);
            if (length < 0) {
                throw d.a();
            }
            iArr[length] = this.f24045a.j(iArr[length], iArrC[i10]);
        }
        return iArrB.length;
    }
}
