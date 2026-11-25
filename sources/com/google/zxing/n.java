package com.google.zxing;

import androidx.core.view.n2;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f23776h = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f23777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f23780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f23781g;

    public n(byte[] bArr, int i7, int i8, int i9, int i10, int i11, int i12, boolean z7) {
        super(i11, i12);
        if (i9 + i11 > i7 || i10 + i12 > i8) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f23777c = bArr;
        this.f23778d = i7;
        this.f23779e = i8;
        this.f23780f = i9;
        this.f23781g = i10;
        if (z7) {
            n(i11, i12);
        }
    }

    private void n(int i7, int i8) {
        byte[] bArr = this.f23777c;
        int i9 = (this.f23781g * this.f23778d) + this.f23780f;
        int i10 = 0;
        while (i10 < i8) {
            int i11 = (i7 / 2) + i9;
            int i12 = (i9 + i7) - 1;
            int i13 = i9;
            while (i13 < i11) {
                byte b8 = bArr[i13];
                bArr[i13] = bArr[i12];
                bArr[i12] = b8;
                i13++;
                i12--;
            }
            i10++;
            i9 += this.f23778d;
        }
    }

    @Override // com.google.zxing.j
    public j a(int i7, int i8, int i9, int i10) {
        return new n(this.f23777c, this.f23778d, this.f23779e, this.f23780f + i7, this.f23781g + i8, i9, i10, false);
    }

    @Override // com.google.zxing.j
    public byte[] c() {
        int iE = e();
        int iB = b();
        int i7 = this.f23778d;
        if (iE == i7 && iB == this.f23779e) {
            return this.f23777c;
        }
        int i8 = iE * iB;
        byte[] bArr = new byte[i8];
        int i9 = (this.f23781g * i7) + this.f23780f;
        if (iE == i7) {
            System.arraycopy(this.f23777c, i9, bArr, 0, i8);
            return bArr;
        }
        for (int i10 = 0; i10 < iB; i10++) {
            System.arraycopy(this.f23777c, i9, bArr, i10 * iE, iE);
            i9 += this.f23778d;
        }
        return bArr;
    }

    @Override // com.google.zxing.j
    public byte[] d(int i7, byte[] bArr) {
        if (i7 < 0 || i7 >= b()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i7)));
        }
        int iE = e();
        if (bArr == null || bArr.length < iE) {
            bArr = new byte[iE];
        }
        System.arraycopy(this.f23777c, ((i7 + this.f23781g) * this.f23778d) + this.f23780f, bArr, 0, iE);
        return bArr;
    }

    @Override // com.google.zxing.j
    public boolean g() {
        return true;
    }

    public int k() {
        return b() / 2;
    }

    public int l() {
        return e() / 2;
    }

    public int[] m() {
        int iE = e() / 2;
        int iB = b() / 2;
        int[] iArr = new int[iE * iB];
        byte[] bArr = this.f23777c;
        int i7 = (this.f23781g * this.f23778d) + this.f23780f;
        for (int i8 = 0; i8 < iB; i8++) {
            int i9 = i8 * iE;
            for (int i10 = 0; i10 < iE; i10++) {
                iArr[i9 + i10] = ((bArr[(i10 << 1) + i7] & 255) * 65793) | n2.f6743t;
            }
            i7 += this.f23778d << 1;
        }
        return iArr;
    }
}
