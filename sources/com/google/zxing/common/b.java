package com.google.zxing.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f23528d;

    public b(int i7) {
        this(i7, i7);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f23526b * (this.f23525a + 1));
        for (int i7 = 0; i7 < this.f23526b; i7++) {
            for (int i8 = 0; i8 < this.f23525a; i8++) {
                sb.append(j(i8, i7) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public static b r(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i7 = -1;
        int length = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (length < str.length()) {
            if (str.charAt(length) == '\n' || str.charAt(length) == '\r') {
                if (i8 > i9) {
                    if (i7 == -1) {
                        i7 = i8 - i9;
                    } else if (i8 - i9 != i7) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i10++;
                    i9 = i8;
                }
                length++;
            } else {
                if (str.substring(length, str2.length() + length).equals(str2)) {
                    length += str2.length();
                    zArr[i8] = true;
                } else {
                    if (!str.substring(length, str3.length() + length).equals(str3)) {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(length));
                    }
                    length += str3.length();
                    zArr[i8] = false;
                }
                i8++;
            }
        }
        if (i8 > i9) {
            if (i7 == -1) {
                i7 = i8 - i9;
            } else if (i8 - i9 != i7) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i10++;
        }
        b bVar = new b(i7, i10);
        for (int i11 = 0; i11 < i8; i11++) {
            if (zArr[i11]) {
                bVar.u(i11 % i7, i11 / i7);
            }
        }
        return bVar;
    }

    public static b s(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        b bVar = new b(length2, length);
        for (int i7 = 0; i7 < length; i7++) {
            boolean[] zArr2 = zArr[i7];
            for (int i8 = 0; i8 < length2; i8++) {
                if (zArr2[i8]) {
                    bVar.u(i8, i7);
                }
            }
        }
        return bVar;
    }

    public void A(b bVar) {
        if (this.f23525a != bVar.q() || this.f23526b != bVar.m() || this.f23527c != bVar.o()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        a aVar = new a(this.f23525a);
        for (int i7 = 0; i7 < this.f23526b; i7++) {
            int i8 = this.f23527c * i7;
            int[] iArrL = bVar.n(i7, aVar).l();
            for (int i9 = 0; i9 < this.f23527c; i9++) {
                int[] iArr = this.f23528d;
                int i10 = i8 + i9;
                iArr[i10] = iArr[i10] ^ iArrL[i9];
            }
        }
    }

    public void e() {
        int length = this.f23528d.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.f23528d[i7] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f23525a == bVar.f23525a && this.f23526b == bVar.f23526b && this.f23527c == bVar.f23527c && Arrays.equals(this.f23528d, bVar.f23528d);
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f23525a, this.f23526b, this.f23527c, (int[]) this.f23528d.clone());
    }

    public int hashCode() {
        int i7 = this.f23525a;
        return (((((((i7 * 31) + i7) * 31) + this.f23526b) * 31) + this.f23527c) * 31) + Arrays.hashCode(this.f23528d);
    }

    public void i(int i7, int i8) {
        int i9 = (i8 * this.f23527c) + (i7 / 32);
        int[] iArr = this.f23528d;
        iArr[i9] = (1 << (i7 & 31)) ^ iArr[i9];
    }

    public boolean j(int i7, int i8) {
        return ((this.f23528d[(i8 * this.f23527c) + (i7 / 32)] >>> (i7 & 31)) & 1) != 0;
    }

    public int[] k() {
        int length = this.f23528d.length - 1;
        while (length >= 0 && this.f23528d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i7 = this.f23527c;
        int i8 = length / i7;
        int i9 = (length % i7) << 5;
        int i10 = 31;
        while ((this.f23528d[length] >>> i10) == 0) {
            i10--;
        }
        return new int[]{i9 + i10, i8};
    }

    public int[] l() {
        int i7 = this.f23525a;
        int i8 = this.f23526b;
        int i9 = -1;
        int i10 = -1;
        for (int i11 = 0; i11 < this.f23526b; i11++) {
            int i12 = 0;
            while (true) {
                int i13 = this.f23527c;
                if (i12 < i13) {
                    int i14 = this.f23528d[(i13 * i11) + i12];
                    if (i14 != 0) {
                        if (i11 < i8) {
                            i8 = i11;
                        }
                        if (i11 > i10) {
                            i10 = i11;
                        }
                        int i15 = i12 << 5;
                        if (i15 < i7) {
                            int i16 = 0;
                            while ((i14 << (31 - i16)) == 0) {
                                i16++;
                            }
                            int i17 = i16 + i15;
                            if (i17 < i7) {
                                i7 = i17;
                            }
                        }
                        if (i15 + 31 > i9) {
                            int i18 = 31;
                            while ((i14 >>> i18) == 0) {
                                i18--;
                            }
                            int i19 = i15 + i18;
                            if (i19 > i9) {
                                i9 = i19;
                            }
                        }
                    }
                    i12++;
                }
            }
        }
        if (i9 < i7 || i10 < i8) {
            return null;
        }
        return new int[]{i7, i8, (i9 - i7) + 1, (i10 - i8) + 1};
    }

    public int m() {
        return this.f23526b;
    }

    public a n(int i7, a aVar) {
        if (aVar == null || aVar.o() < this.f23525a) {
            aVar = new a(this.f23525a);
        } else {
            aVar.e();
        }
        int i8 = i7 * this.f23527c;
        for (int i9 = 0; i9 < this.f23527c; i9++) {
            aVar.u(i9 << 5, this.f23528d[i8 + i9]);
        }
        return aVar;
    }

    public int o() {
        return this.f23527c;
    }

    public int[] p() {
        int[] iArr;
        int i7 = 0;
        while (true) {
            iArr = this.f23528d;
            if (i7 >= iArr.length || iArr[i7] != 0) {
                break;
            }
            i7++;
        }
        if (i7 == iArr.length) {
            return null;
        }
        int i8 = this.f23527c;
        int i9 = i7 / i8;
        int i10 = (i7 % i8) << 5;
        int i11 = iArr[i7];
        int i12 = 0;
        while ((i11 << (31 - i12)) == 0) {
            i12++;
        }
        return new int[]{i10 + i12, i9};
    }

    public int q() {
        return this.f23525a;
    }

    public void t() {
        int iQ = q();
        int iM = m();
        a aVar = new a(iQ);
        a aVar2 = new a(iQ);
        for (int i7 = 0; i7 < (iM + 1) / 2; i7++) {
            aVar = n(i7, aVar);
            int i8 = (iM - 1) - i7;
            aVar2 = n(i8, aVar2);
            aVar.s();
            aVar2.s();
            w(i7, aVar2);
            w(i8, aVar);
        }
    }

    public String toString() {
        return x("X ", "  ");
    }

    public void u(int i7, int i8) {
        int i9 = (i8 * this.f23527c) + (i7 / 32);
        int[] iArr = this.f23528d;
        iArr[i9] = (1 << (i7 & 31)) | iArr[i9];
    }

    public void v(int i7, int i8, int i9, int i10) {
        if (i8 < 0 || i7 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i10 <= 0 || i9 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i11 = i9 + i7;
        int i12 = i10 + i8;
        if (i12 > this.f23526b || i11 > this.f23525a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i8 < i12) {
            int i13 = this.f23527c * i8;
            for (int i14 = i7; i14 < i11; i14++) {
                int[] iArr = this.f23528d;
                int i15 = (i14 / 32) + i13;
                iArr[i15] = iArr[i15] | (1 << (i14 & 31));
            }
            i8++;
        }
    }

    public void w(int i7, a aVar) {
        int[] iArrL = aVar.l();
        int[] iArr = this.f23528d;
        int i8 = this.f23527c;
        System.arraycopy(iArrL, 0, iArr, i7 * i8, i8);
    }

    public String x(String str, String str2) {
        return a(str, str2, "\n");
    }

    @Deprecated
    public String y(String str, String str2, String str3) {
        return a(str, str2, str3);
    }

    public void z(int i7, int i8) {
        int i9 = (i8 * this.f23527c) + (i7 / 32);
        int[] iArr = this.f23528d;
        iArr[i9] = (~(1 << (i7 & 31))) & iArr[i9];
    }

    public b(int i7, int i8) {
        if (i7 <= 0 || i8 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f23525a = i7;
        this.f23526b = i8;
        int i9 = (i7 + 31) / 32;
        this.f23527c = i9;
        this.f23528d = new int[i9 * i8];
    }

    private b(int i7, int i8, int i9, int[] iArr) {
        this.f23525a = i7;
        this.f23526b = i8;
        this.f23527c = i9;
        this.f23528d = iArr;
    }
}
