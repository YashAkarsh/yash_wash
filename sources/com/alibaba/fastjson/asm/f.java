package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f12577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f12578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f12580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f12582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    f f12583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    f f12584h;

    private void a(int i7, int i8) {
        if (this.f12580d == null) {
            this.f12580d = new int[6];
        }
        int i9 = this.f12579c;
        int[] iArr = this.f12580d;
        if (i9 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f12580d = iArr2;
        }
        int[] iArr3 = this.f12580d;
        int i10 = this.f12579c;
        int i11 = i10 + 1;
        iArr3[i10] = i7;
        this.f12579c = i11 + 1;
        iArr3[i11] = i8;
    }

    void b(i iVar, a aVar, int i7) {
        if ((this.f12577a & 2) != 0) {
            aVar.g(this.f12578b - i7);
        } else {
            a(i7, aVar.f12538b);
            aVar.g(-1);
        }
    }

    void c(i iVar, int i7, byte[] bArr) {
        this.f12577a |= 2;
        this.f12578b = i7;
        int i8 = 0;
        while (i8 < this.f12579c) {
            int[] iArr = this.f12580d;
            int i9 = i8 + 1;
            int i10 = iArr[i8];
            int i11 = iArr[i9];
            int i12 = i7 - i10;
            bArr[i11] = (byte) (i12 >>> 8);
            bArr[i11 + 1] = (byte) i12;
            i8 = i9 + 1;
        }
    }
}
