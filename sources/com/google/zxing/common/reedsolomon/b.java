package com.google.zxing.common.reedsolomon;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f23614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f23615b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f23614a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f23615b = iArr;
            return;
        }
        int i7 = 1;
        while (i7 < length && iArr[i7] == 0) {
            i7++;
        }
        if (i7 == length) {
            this.f23615b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i7];
        this.f23615b = iArr2;
        System.arraycopy(iArr, i7, iArr2, 0, iArr2.length);
    }

    b a(b bVar) {
        if (!this.f23614a.equals(bVar.f23614a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return bVar;
        }
        if (bVar.g()) {
            return this;
        }
        int[] iArr = this.f23615b;
        int[] iArr2 = bVar.f23615b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i7 = length; i7 < iArr.length; i7++) {
            iArr3[i7] = a.a(iArr2[i7 - length], iArr[i7]);
        }
        return new b(this.f23614a, iArr3);
    }

    b[] b(b bVar) {
        if (!this.f23614a.equals(bVar.f23614a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b bVarG = this.f23614a.g();
        int iH = this.f23614a.h(bVar.d(bVar.f()));
        b bVarA = this;
        while (bVarA.f() >= bVar.f() && !bVarA.g()) {
            int iF = bVarA.f() - bVar.f();
            int iJ = this.f23614a.j(bVarA.d(bVarA.f()), iH);
            b bVarJ = bVar.j(iF, iJ);
            bVarG = bVarG.a(this.f23614a.b(iF, iJ));
            bVarA = bVarA.a(bVarJ);
        }
        return new b[]{bVarG, bVarA};
    }

    int c(int i7) {
        if (i7 == 0) {
            return d(0);
        }
        if (i7 == 1) {
            int iA = 0;
            for (int i8 : this.f23615b) {
                iA = a.a(iA, i8);
            }
            return iA;
        }
        int[] iArr = this.f23615b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i9 = 1; i9 < length; i9++) {
            iA2 = a.a(this.f23614a.j(i7, iA2), this.f23615b[i9]);
        }
        return iA2;
    }

    int d(int i7) {
        int[] iArr = this.f23615b;
        return iArr[(iArr.length - 1) - i7];
    }

    int[] e() {
        return this.f23615b;
    }

    int f() {
        return this.f23615b.length - 1;
    }

    boolean g() {
        return this.f23615b[0] == 0;
    }

    b h(int i7) {
        if (i7 == 0) {
            return this.f23614a.g();
        }
        if (i7 == 1) {
            return this;
        }
        int length = this.f23615b.length;
        int[] iArr = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = this.f23614a.j(this.f23615b[i8], i7);
        }
        return new b(this.f23614a, iArr);
    }

    b i(b bVar) {
        if (!this.f23614a.equals(bVar.f23614a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || bVar.g()) {
            return this.f23614a.g();
        }
        int[] iArr = this.f23615b;
        int length = iArr.length;
        int[] iArr2 = bVar.f23615b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = iArr[i7];
            for (int i9 = 0; i9 < length2; i9++) {
                int i10 = i7 + i9;
                iArr3[i10] = a.a(iArr3[i10], this.f23614a.j(i8, iArr2[i9]));
            }
        }
        return new b(this.f23614a, iArr3);
    }

    b j(int i7, int i8) {
        if (i7 < 0) {
            throw new IllegalArgumentException();
        }
        if (i8 == 0) {
            return this.f23614a.g();
        }
        int length = this.f23615b.length;
        int[] iArr = new int[i7 + length];
        for (int i9 = 0; i9 < length; i9++) {
            iArr[i9] = this.f23614a.j(this.f23615b[i9], i8);
        }
        return new b(this.f23614a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(f() * 8);
        for (int iF = f(); iF >= 0; iF--) {
            int iD = d(iF);
            if (iD != 0) {
                if (iD < 0) {
                    sb.append(" - ");
                    iD = -iD;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iF == 0 || iD != 1) {
                    int i7 = this.f23614a.i(iD);
                    if (i7 == 0) {
                        sb.append('1');
                    } else if (i7 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i7);
                    }
                }
                if (iF != 0) {
                    if (iF == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iF);
                    }
                }
            }
        }
        return sb.toString();
    }
}
