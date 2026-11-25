package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f23782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f23785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f23786g;

    public o(int i7, int i8, int[] iArr) {
        super(i7, i8);
        this.f23783d = i7;
        this.f23784e = i8;
        this.f23785f = 0;
        this.f23786g = 0;
        int i9 = i7 * i8;
        this.f23782c = new byte[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = iArr[i10];
            this.f23782c[i10] = (byte) (((((i11 >> 16) & 255) + ((i11 >> 7) & androidx.constraintlayout.core.motion.utils.w.g.f3141r)) + (i11 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.j
    public j a(int i7, int i8, int i9, int i10) {
        return new o(this.f23782c, this.f23783d, this.f23784e, this.f23785f + i7, this.f23786g + i8, i9, i10);
    }

    @Override // com.google.zxing.j
    public byte[] c() {
        int iE = e();
        int iB = b();
        int i7 = this.f23783d;
        if (iE == i7 && iB == this.f23784e) {
            return this.f23782c;
        }
        int i8 = iE * iB;
        byte[] bArr = new byte[i8];
        int i9 = (this.f23786g * i7) + this.f23785f;
        if (iE == i7) {
            System.arraycopy(this.f23782c, i9, bArr, 0, i8);
            return bArr;
        }
        for (int i10 = 0; i10 < iB; i10++) {
            System.arraycopy(this.f23782c, i9, bArr, i10 * iE, iE);
            i9 += this.f23783d;
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
        System.arraycopy(this.f23782c, ((i7 + this.f23786g) * this.f23783d) + this.f23785f, bArr, 0, iE);
        return bArr;
    }

    @Override // com.google.zxing.j
    public boolean g() {
        return true;
    }

    private o(byte[] bArr, int i7, int i8, int i9, int i10, int i11, int i12) {
        super(i11, i12);
        if (i11 + i9 <= i7 && i12 + i10 <= i8) {
            this.f23782c = bArr;
            this.f23783d = i7;
            this.f23784e = i8;
            this.f23785f = i9;
            this.f23786g = i10;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
