package com.google.zxing.common;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f23583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f23584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f23585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f23586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f23587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f23588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f23589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f23590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f23591i;

    private k(float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f23583a = f8;
        this.f23584b = f11;
        this.f23585c = f14;
        this.f23586d = f9;
        this.f23587e = f12;
        this.f23588f = f15;
        this.f23589g = f10;
        this.f23590h = f13;
        this.f23591i = f16;
    }

    public static k b(float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23) {
        return d(f16, f17, f18, f19, f20, f21, f22, f23).e(c(f8, f9, f10, f11, f12, f13, f14, f15));
    }

    public static k c(float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        return d(f8, f9, f10, f11, f12, f13, f14, f15).a();
    }

    public static k d(float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        float f16 = ((f8 - f10) + f12) - f14;
        float f17 = ((f9 - f11) + f13) - f15;
        if (f16 == 0.0f && f17 == 0.0f) {
            return new k(f10 - f8, f12 - f10, f8, f11 - f9, f13 - f11, f9, 0.0f, 0.0f, 1.0f);
        }
        float f18 = f10 - f12;
        float f19 = f14 - f12;
        float f20 = f11 - f13;
        float f21 = f15 - f13;
        float f22 = (f18 * f21) - (f19 * f20);
        float f23 = ((f21 * f16) - (f19 * f17)) / f22;
        float f24 = ((f18 * f17) - (f16 * f20)) / f22;
        return new k((f23 * f10) + (f10 - f8), (f24 * f14) + (f14 - f8), f8, (f11 - f9) + (f23 * f11), (f15 - f9) + (f24 * f15), f9, f23, f24, 1.0f);
    }

    k a() {
        float f8 = this.f23587e;
        float f9 = this.f23591i;
        float f10 = this.f23588f;
        float f11 = this.f23590h;
        float f12 = (f8 * f9) - (f10 * f11);
        float f13 = this.f23589g;
        float f14 = this.f23586d;
        float f15 = (f10 * f13) - (f14 * f9);
        float f16 = (f14 * f11) - (f8 * f13);
        float f17 = this.f23585c;
        float f18 = this.f23584b;
        float f19 = (f17 * f11) - (f18 * f9);
        float f20 = this.f23583a;
        return new k(f12, f15, f16, f19, (f9 * f20) - (f17 * f13), (f13 * f18) - (f11 * f20), (f18 * f10) - (f17 * f8), (f17 * f14) - (f10 * f20), (f20 * f8) - (f18 * f14));
    }

    k e(k kVar) {
        float f8 = this.f23583a;
        float f9 = kVar.f23583a;
        float f10 = this.f23586d;
        float f11 = kVar.f23584b;
        float f12 = this.f23589g;
        float f13 = kVar.f23585c;
        float f14 = (f8 * f9) + (f10 * f11) + (f12 * f13);
        float f15 = kVar.f23586d;
        float f16 = kVar.f23587e;
        float f17 = kVar.f23588f;
        float f18 = (f8 * f15) + (f10 * f16) + (f12 * f17);
        float f19 = kVar.f23589g;
        float f20 = kVar.f23590h;
        float f21 = kVar.f23591i;
        float f22 = (f8 * f19) + (f10 * f20) + (f12 * f21);
        float f23 = this.f23584b;
        float f24 = this.f23587e;
        float f25 = this.f23590h;
        float f26 = (f23 * f9) + (f24 * f11) + (f25 * f13);
        float f27 = (f23 * f15) + (f24 * f16) + (f25 * f17);
        float f28 = (f25 * f21) + (f23 * f19) + (f24 * f20);
        float f29 = this.f23585c;
        float f30 = this.f23588f;
        float f31 = (f9 * f29) + (f11 * f30);
        float f32 = this.f23591i;
        return new k(f14, f18, f22, f26, f27, f28, (f13 * f32) + f31, (f15 * f29) + (f16 * f30) + (f17 * f32), (f29 * f19) + (f30 * f20) + (f32 * f21));
    }

    public void f(float[] fArr) {
        int length = fArr.length;
        float f8 = this.f23583a;
        float f9 = this.f23584b;
        float f10 = this.f23585c;
        float f11 = this.f23586d;
        float f12 = this.f23587e;
        float f13 = this.f23588f;
        float f14 = this.f23589g;
        float f15 = this.f23590h;
        float f16 = this.f23591i;
        for (int i7 = 0; i7 < length; i7 += 2) {
            float f17 = fArr[i7];
            int i8 = i7 + 1;
            float f18 = fArr[i8];
            float f19 = (f10 * f17) + (f13 * f18) + f16;
            fArr[i7] = (((f8 * f17) + (f11 * f18)) + f14) / f19;
            fArr[i8] = (((f17 * f9) + (f18 * f12)) + f15) / f19;
        }
    }

    public void g(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            float f8 = fArr[i7];
            float f9 = fArr2[i7];
            float f10 = (this.f23585c * f8) + (this.f23588f * f9) + this.f23591i;
            fArr[i7] = (((this.f23583a * f8) + (this.f23586d * f9)) + this.f23589g) / f10;
            fArr2[i7] = (((this.f23584b * f8) + (this.f23587e * f9)) + this.f23590h) / f10;
        }
    }
}
