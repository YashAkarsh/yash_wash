package com.google.zxing.pdf417.decoder.ec;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f24052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f24053b;

    c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f24052a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f24053b = iArr;
            return;
        }
        int i7 = 1;
        while (i7 < length && iArr[i7] == 0) {
            i7++;
        }
        if (i7 == length) {
            this.f24053b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i7];
        this.f24053b = iArr2;
        System.arraycopy(iArr, i7, iArr2, 0, iArr2.length);
    }

    c a(c cVar) {
        if (!this.f24052a.equals(cVar.f24052a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (f()) {
            return cVar;
        }
        if (cVar.f()) {
            return this;
        }
        int[] iArr = this.f24053b;
        int[] iArr2 = cVar.f24053b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i7 = length; i7 < iArr.length; i7++) {
            iArr3[i7] = this.f24052a.a(iArr2[i7 - length], iArr[i7]);
        }
        return new c(this.f24052a, iArr3);
    }

    int b(int i7) {
        if (i7 == 0) {
            return c(0);
        }
        if (i7 == 1) {
            int iA = 0;
            for (int i8 : this.f24053b) {
                iA = this.f24052a.a(iA, i8);
            }
            return iA;
        }
        int[] iArr = this.f24053b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i9 = 1; i9 < length; i9++) {
            b bVar = this.f24052a;
            iA2 = bVar.a(bVar.i(i7, iA2), this.f24053b[i9]);
        }
        return iA2;
    }

    int c(int i7) {
        int[] iArr = this.f24053b;
        return iArr[(iArr.length - 1) - i7];
    }

    int[] d() {
        return this.f24053b;
    }

    int e() {
        return this.f24053b.length - 1;
    }

    boolean f() {
        return this.f24053b[0] == 0;
    }

    c g(int i7) {
        if (i7 == 0) {
            return this.f24052a.f();
        }
        if (i7 == 1) {
            return this;
        }
        int length = this.f24053b.length;
        int[] iArr = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = this.f24052a.i(this.f24053b[i8], i7);
        }
        return new c(this.f24052a, iArr);
    }

    c h(c cVar) {
        if (!this.f24052a.equals(cVar.f24052a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (f() || cVar.f()) {
            return this.f24052a.f();
        }
        int[] iArr = this.f24053b;
        int length = iArr.length;
        int[] iArr2 = cVar.f24053b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = iArr[i7];
            for (int i9 = 0; i9 < length2; i9++) {
                int i10 = i7 + i9;
                b bVar = this.f24052a;
                iArr3[i10] = bVar.a(iArr3[i10], bVar.i(i8, iArr2[i9]));
            }
        }
        return new c(this.f24052a, iArr3);
    }

    c i(int i7, int i8) {
        if (i7 < 0) {
            throw new IllegalArgumentException();
        }
        if (i8 == 0) {
            return this.f24052a.f();
        }
        int length = this.f24053b.length;
        int[] iArr = new int[i7 + length];
        for (int i9 = 0; i9 < length; i9++) {
            iArr[i9] = this.f24052a.i(this.f24053b[i9], i8);
        }
        return new c(this.f24052a, iArr);
    }

    c j() {
        int length = this.f24053b.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = this.f24052a.j(0, this.f24053b[i7]);
        }
        return new c(this.f24052a, iArr);
    }

    c k(c cVar) {
        if (this.f24052a.equals(cVar.f24052a)) {
            return cVar.f() ? this : a(cVar.j());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(e() * 8);
        for (int iE = e(); iE >= 0; iE--) {
            int iC = c(iE);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iE == 0 || iC != 1) {
                    sb.append(iC);
                }
                if (iE != 0) {
                    if (iE == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iE);
                    }
                }
            }
        }
        return sb.toString();
    }
}
