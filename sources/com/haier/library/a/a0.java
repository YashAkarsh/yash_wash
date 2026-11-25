package com.haier.library.a;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class a0 extends j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient byte[][] f26243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final transient int[] f26244h;

    a0(g gVar, int i7) {
        super(null);
        c.d(gVar.f26255b, 0L, i7);
        y yVar = gVar.f26254a;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            int i11 = yVar.f26333c;
            int i12 = yVar.f26332b;
            if (i11 == i12) {
                throw new AssertionError("s.limit == s.pos");
            }
            i9 += i11 - i12;
            i10++;
            yVar = yVar.f26336f;
        }
        this.f26243g = new byte[i10][];
        this.f26244h = new int[i10 * 2];
        y yVar2 = gVar.f26254a;
        int i13 = 0;
        while (i8 < i7) {
            byte[][] bArr = this.f26243g;
            bArr[i13] = yVar2.f26331a;
            int i14 = yVar2.f26333c;
            int i15 = yVar2.f26332b;
            i8 += i14 - i15;
            if (i8 > i7) {
                i8 = i7;
            }
            int[] iArr = this.f26244h;
            iArr[i13] = i8;
            iArr[bArr.length + i13] = i15;
            yVar2.f26334d = true;
            i13++;
            yVar2 = yVar2.f26336f;
        }
    }

    private int d0(int i7) {
        int iBinarySearch = Arrays.binarySearch(this.f26244h, 0, this.f26243g.length, i7 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private j e0() {
        return new j(a0());
    }

    private Object f0() {
        return e0();
    }

    @Override // com.haier.library.a.j
    public j A(j jVar) {
        return e0().A(jVar);
    }

    @Override // com.haier.library.a.j
    public String C() {
        return e0().C();
    }

    @Override // com.haier.library.a.j
    public j E() {
        return e0().E();
    }

    @Override // com.haier.library.a.j
    public j K() {
        return e0().K();
    }

    @Override // com.haier.library.a.j
    public j O() {
        return e0().O();
    }

    @Override // com.haier.library.a.j
    public String U() {
        return e0().U();
    }

    @Override // com.haier.library.a.j
    public String W() {
        return e0().W();
    }

    @Override // com.haier.library.a.j
    public j X() {
        return e0().X();
    }

    @Override // com.haier.library.a.j
    public j Y() {
        return e0().Y();
    }

    @Override // com.haier.library.a.j
    public int Z() {
        return this.f26244h[this.f26243g.length - 1];
    }

    @Override // com.haier.library.a.j
    public byte[] a0() {
        int[] iArr = this.f26244h;
        byte[][] bArr = this.f26243g;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int[] iArr2 = this.f26244h;
            int i9 = iArr2[length + i7];
            int i10 = iArr2[i7];
            System.arraycopy(this.f26243g[i7], i9, bArr2, i8, i10 - i8);
            i7++;
            i8 = i10;
        }
        return bArr2;
    }

    @Override // com.haier.library.a.j
    byte[] b0() {
        return a0();
    }

    @Override // com.haier.library.a.j
    public ByteBuffer c0() {
        return ByteBuffer.wrap(a0()).asReadOnlyBuffer();
    }

    @Override // com.haier.library.a.j
    public int d(byte[] bArr, int i7) {
        return e0().d(bArr, i7);
    }

    @Override // com.haier.library.a.j
    public j e(int i7) {
        return e0().e(i7);
    }

    @Override // com.haier.library.a.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (jVar.Z() == Z() && v(0, jVar, 0, Z())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.haier.library.a.j
    public j f(int i7, int i8) {
        return e0().f(i7, i8);
    }

    @Override // com.haier.library.a.j
    public j g(j jVar) {
        return e0().g(jVar);
    }

    @Override // com.haier.library.a.j
    public int hashCode() {
        int i7 = this.f26269b;
        if (i7 != 0) {
            return i7;
        }
        int length = this.f26243g.length;
        int i8 = 0;
        int i9 = 1;
        int i10 = 0;
        while (i8 < length) {
            byte[] bArr = this.f26243g[i8];
            int[] iArr = this.f26244h;
            int i11 = iArr[length + i8];
            int i12 = iArr[i8];
            int i13 = (i12 - i10) + i11;
            while (i11 < i13) {
                i9 = (i9 * 31) + bArr[i11];
                i11++;
            }
            i8++;
            i10 = i12;
        }
        this.f26269b = i9;
        return i9;
    }

    @Override // com.haier.library.a.j
    public String o() {
        return e0().o();
    }

    @Override // com.haier.library.a.j
    public String p(Charset charset) {
        return e0().p(charset);
    }

    @Override // com.haier.library.a.j
    void q(g gVar) {
        int length = this.f26243g.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int[] iArr = this.f26244h;
            int i9 = iArr[length + i7];
            int i10 = iArr[i7];
            y yVar = new y(this.f26243g[i7], i9, (i9 + i10) - i8, true, false);
            y yVar2 = gVar.f26254a;
            if (yVar2 == null) {
                yVar.f26337g = yVar;
                yVar.f26336f = yVar;
                gVar.f26254a = yVar;
            } else {
                yVar2.f26337g.c(yVar);
            }
            i7++;
            i8 = i10;
        }
        gVar.f26255b += (long) i8;
    }

    @Override // com.haier.library.a.j
    public String toString() {
        return e0().toString();
    }

    @Override // com.haier.library.a.j
    public void u(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.f26243g.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int[] iArr = this.f26244h;
            int i9 = iArr[length + i7];
            int i10 = iArr[i7];
            outputStream.write(this.f26243g[i7], i9, i10 - i8);
            i7++;
            i8 = i10;
        }
    }

    @Override // com.haier.library.a.j
    public boolean v(int i7, j jVar, int i8, int i9) {
        if (i7 < 0 || i7 > Z() - i9) {
            return false;
        }
        int iD0 = d0(i7);
        while (i9 > 0) {
            int i10 = iD0 == 0 ? 0 : this.f26244h[iD0 - 1];
            int iMin = Math.min(i9, ((this.f26244h[iD0] - i10) + i10) - i7);
            int[] iArr = this.f26244h;
            byte[][] bArr = this.f26243g;
            if (!jVar.w(i8, bArr[iD0], (i7 - i10) + iArr[bArr.length + iD0], iMin)) {
                return false;
            }
            i7 += iMin;
            i8 += iMin;
            i9 -= iMin;
            iD0++;
        }
        return true;
    }

    @Override // com.haier.library.a.j
    public boolean w(int i7, byte[] bArr, int i8, int i9) {
        if (i7 < 0 || i7 > Z() - i9 || i8 < 0 || i8 > bArr.length - i9) {
            return false;
        }
        int iD0 = d0(i7);
        while (i9 > 0) {
            int i10 = iD0 == 0 ? 0 : this.f26244h[iD0 - 1];
            int iMin = Math.min(i9, ((this.f26244h[iD0] - i10) + i10) - i7);
            int[] iArr = this.f26244h;
            byte[][] bArr2 = this.f26243g;
            if (!c.f(bArr2[iD0], (i7 - i10) + iArr[bArr2.length + iD0], bArr, i8, iMin)) {
                return false;
            }
            i7 += iMin;
            i8 += iMin;
            i9 -= iMin;
            iD0++;
        }
        return true;
    }

    @Override // com.haier.library.a.j
    public byte x(int i7) {
        c.d(this.f26244h[this.f26243g.length - 1], i7, 1L);
        int iD0 = d0(i7);
        int i8 = iD0 == 0 ? 0 : this.f26244h[iD0 - 1];
        int[] iArr = this.f26244h;
        byte[][] bArr = this.f26243g;
        return bArr[iD0][(i7 - i8) + iArr[bArr.length + iD0]];
    }

    @Override // com.haier.library.a.j
    public int z(byte[] bArr, int i7) {
        return e0().z(bArr, i7);
    }
}
