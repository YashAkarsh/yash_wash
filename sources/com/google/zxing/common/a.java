package com.google.zxing.common;

import java.util.Arrays;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f23523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23524b;

    public a() {
        this.f23524b = 0;
        this.f23523a = new int[1];
    }

    private void i(int i7) {
        if (i7 > (this.f23523a.length << 5)) {
            int[] iArrR = r(i7);
            int[] iArr = this.f23523a;
            System.arraycopy(iArr, 0, iArrR, 0, iArr.length);
            this.f23523a = iArrR;
        }
    }

    private static int[] r(int i7) {
        return new int[(i7 + 31) / 32];
    }

    public void a(boolean z7) {
        i(this.f23524b + 1);
        if (z7) {
            int[] iArr = this.f23523a;
            int i7 = this.f23524b;
            int i8 = i7 / 32;
            iArr[i8] = (1 << (i7 & 31)) | iArr[i8];
        }
        this.f23524b++;
    }

    public void b(a aVar) {
        int i7 = aVar.f23524b;
        i(this.f23524b + i7);
        for (int i8 = 0; i8 < i7; i8++) {
            a(aVar.k(i8));
        }
    }

    public void c(int i7, int i8) {
        if (i8 < 0 || i8 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        i(this.f23524b + i8);
        while (i8 > 0) {
            boolean z7 = true;
            if (((i7 >> (i8 - 1)) & 1) != 1) {
                z7 = false;
            }
            a(z7);
            i8--;
        }
    }

    public void e() {
        int length = this.f23523a.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.f23523a[i7] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f23524b == aVar.f23524b && Arrays.equals(this.f23523a, aVar.f23523a);
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f23523a.clone(), this.f23524b);
    }

    public int hashCode() {
        return (this.f23524b * 31) + Arrays.hashCode(this.f23523a);
    }

    public void j(int i7) {
        int[] iArr = this.f23523a;
        int i8 = i7 / 32;
        iArr[i8] = (1 << (i7 & 31)) ^ iArr[i8];
    }

    public boolean k(int i7) {
        return ((1 << (i7 & 31)) & this.f23523a[i7 / 32]) != 0;
    }

    public int[] l() {
        return this.f23523a;
    }

    public int m(int i7) {
        int i8 = this.f23524b;
        if (i7 >= i8) {
            return i8;
        }
        int i9 = i7 / 32;
        int i10 = (~((1 << (i7 & 31)) - 1)) & this.f23523a[i9];
        while (i10 == 0) {
            i9++;
            int[] iArr = this.f23523a;
            if (i9 == iArr.length) {
                return this.f23524b;
            }
            i10 = iArr[i9];
        }
        int iNumberOfTrailingZeros = (i9 << 5) + Integer.numberOfTrailingZeros(i10);
        int i11 = this.f23524b;
        return iNumberOfTrailingZeros > i11 ? i11 : iNumberOfTrailingZeros;
    }

    public int n(int i7) {
        int i8 = this.f23524b;
        if (i7 >= i8) {
            return i8;
        }
        int i9 = i7 / 32;
        int i10 = (~((1 << (i7 & 31)) - 1)) & (~this.f23523a[i9]);
        while (i10 == 0) {
            i9++;
            int[] iArr = this.f23523a;
            if (i9 == iArr.length) {
                return this.f23524b;
            }
            i10 = ~iArr[i9];
        }
        int iNumberOfTrailingZeros = (i9 << 5) + Integer.numberOfTrailingZeros(i10);
        int i11 = this.f23524b;
        return iNumberOfTrailingZeros > i11 ? i11 : iNumberOfTrailingZeros;
    }

    public int o() {
        return this.f23524b;
    }

    public int p() {
        return (this.f23524b + 7) / 8;
    }

    public boolean q(int i7, int i8, boolean z7) {
        if (i8 < i7 || i7 < 0 || i8 > this.f23524b) {
            throw new IllegalArgumentException();
        }
        if (i8 == i7) {
            return true;
        }
        int i9 = i8 - 1;
        int i10 = i7 / 32;
        int i11 = i9 / 32;
        int i12 = i10;
        while (i12 <= i11) {
            int i13 = (2 << (i12 >= i11 ? 31 & i9 : 31)) - (1 << (i12 > i10 ? 0 : i7 & 31));
            int i14 = this.f23523a[i12] & i13;
            if (!z7) {
                i13 = 0;
            }
            if (i14 != i13) {
                return false;
            }
            i12++;
        }
        return true;
    }

    public void s() {
        int[] iArr = new int[this.f23523a.length];
        int i7 = (this.f23524b - 1) / 32;
        int i8 = i7 + 1;
        for (int i9 = 0; i9 < i8; i9++) {
            long j7 = this.f23523a[i9];
            long j8 = ((j7 & 1431655765) << 1) | ((j7 >> 1) & 1431655765);
            long j9 = ((j8 & 858993459) << 2) | ((j8 >> 2) & 858993459);
            long j10 = ((j9 & 252645135) << 4) | ((j9 >> 4) & 252645135);
            long j11 = ((j10 & 16711935) << 8) | ((j10 >> 8) & 16711935);
            iArr[i7 - i9] = (int) (((j11 & okhttp3.internal.ws.g.f38386s) << 16) | ((j11 >> 16) & okhttp3.internal.ws.g.f38386s));
        }
        int i10 = this.f23524b;
        int i11 = i8 << 5;
        if (i10 != i11) {
            int i12 = i11 - i10;
            int i13 = iArr[0] >>> i12;
            for (int i14 = 1; i14 < i8; i14++) {
                int i15 = iArr[i14];
                iArr[i14 - 1] = i13 | (i15 << (32 - i12));
                i13 = i15 >>> i12;
            }
            iArr[i8 - 1] = i13;
        }
        this.f23523a = iArr;
    }

    public void t(int i7) {
        int[] iArr = this.f23523a;
        int i8 = i7 / 32;
        iArr[i8] = (1 << (i7 & 31)) | iArr[i8];
    }

    public String toString() {
        int i7 = this.f23524b;
        StringBuilder sb = new StringBuilder(i7 + (i7 / 8) + 1);
        for (int i8 = 0; i8 < this.f23524b; i8++) {
            if ((i8 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(k(i8) ? 'X' : ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        return sb.toString();
    }

    public void u(int i7, int i8) {
        this.f23523a[i7 / 32] = i8;
    }

    public void v(int i7, int i8) {
        if (i8 < i7 || i7 < 0 || i8 > this.f23524b) {
            throw new IllegalArgumentException();
        }
        if (i8 == i7) {
            return;
        }
        int i9 = i8 - 1;
        int i10 = i7 / 32;
        int i11 = i9 / 32;
        int i12 = i10;
        while (i12 <= i11) {
            int i13 = 31;
            int i14 = i12 > i10 ? 0 : i7 & 31;
            if (i12 >= i11) {
                i13 = 31 & i9;
            }
            int i15 = (2 << i13) - (1 << i14);
            int[] iArr = this.f23523a;
            iArr[i12] = i15 | iArr[i12];
            i12++;
        }
    }

    public void w(int i7, byte[] bArr, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = 0;
            for (int i12 = 0; i12 < 8; i12++) {
                if (k(i7)) {
                    i11 |= 1 << (7 - i12);
                }
                i7++;
            }
            bArr[i8 + i10] = (byte) i11;
        }
    }

    public void x(a aVar) {
        if (this.f23524b != aVar.f23524b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i7 = 0;
        while (true) {
            int[] iArr = this.f23523a;
            if (i7 >= iArr.length) {
                return;
            }
            iArr[i7] = iArr[i7] ^ aVar.f23523a[i7];
            i7++;
        }
    }

    public a(int i7) {
        this.f23524b = i7;
        this.f23523a = r(i7);
    }

    a(int[] iArr, int i7) {
        this.f23523a = iArr;
        this.f23524b = i7;
    }
}
