package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f23738c;

    public i(j jVar) {
        super(jVar.e(), jVar.b());
        this.f23738c = jVar;
    }

    @Override // com.google.zxing.j
    public j a(int i7, int i8, int i9, int i10) {
        return new i(this.f23738c.a(i7, i8, i9, i10));
    }

    @Override // com.google.zxing.j
    public byte[] c() {
        byte[] bArrC = this.f23738c.c();
        int iE = e() * b();
        byte[] bArr = new byte[iE];
        for (int i7 = 0; i7 < iE; i7++) {
            bArr[i7] = (byte) (255 - (bArrC[i7] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.j
    public byte[] d(int i7, byte[] bArr) {
        byte[] bArrD = this.f23738c.d(i7, bArr);
        int iE = e();
        for (int i8 = 0; i8 < iE; i8++) {
            bArrD[i8] = (byte) (255 - (bArrD[i8] & 255));
        }
        return bArrD;
    }

    @Override // com.google.zxing.j
    public j f() {
        return this.f23738c;
    }

    @Override // com.google.zxing.j
    public boolean g() {
        return this.f23738c.g();
    }

    @Override // com.google.zxing.j
    public boolean h() {
        return this.f23738c.h();
    }

    @Override // com.google.zxing.j
    public j i() {
        return new i(this.f23738c.i());
    }

    @Override // com.google.zxing.j
    public j j() {
        return new i(this.f23738c.j());
    }
}
