package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes2.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final f[] f24147f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24149a;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        f24147f = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i7) {
        this.f24149a = i7;
    }

    public static f a(int i7) {
        if (i7 >= 0) {
            f[] fVarArr = f24147f;
            if (i7 < fVarArr.length) {
                return fVarArr[i7];
            }
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.f24149a;
    }
}
