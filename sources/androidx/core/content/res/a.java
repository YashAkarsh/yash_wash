package androidx.core.content.res;

import androidx.core.graphics.v1;
import c.m0;
import c.o0;
import c.v;
import kotlin.jvm.internal.x;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f5691j = 0.2f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f5692k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f5693l = 0.4f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f5694m = 0.01f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f5697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f5698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f5699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f5700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f5701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f5702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f5703i;

    a(float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f5695a = f8;
        this.f5696b = f9;
        this.f5697c = f10;
        this.f5698d = f11;
        this.f5699e = f12;
        this.f5700f = f13;
        this.f5701g = f14;
        this.f5702h = f15;
        this.f5703i = f16;
    }

    @o0
    private static a b(@v(from = 0.0d, to = 360.0d) float f8, @v(from = 0.0d, to = x.f34951d, toInclusive = false) float f9, @v(from = 0.0d, to = 100.0d) float f10) {
        float f11 = 100.0f;
        float f12 = 1000.0f;
        float f13 = 0.0f;
        a aVar = null;
        float f14 = 1000.0f;
        while (Math.abs(f13 - f11) > f5694m) {
            float f15 = ((f11 - f13) / 2.0f) + f13;
            int iS = e(f15, f9, f8).s();
            float fB = b.b(iS);
            float fAbs = Math.abs(f10 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iS);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f8));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f12 = fAbs;
                    f14 = fA;
                }
            }
            if (f12 == 0.0f && f14 == 0.0f) {
                break;
            }
            if (fB < f10) {
                f13 = f15;
            } else {
                f11 = f15;
            }
        }
        return aVar;
    }

    @m0
    static a c(@c.l int i7) {
        return d(i7, r.f5754k);
    }

    @m0
    static a d(@c.l int i7, @m0 r rVar) {
        float[] fArrF = b.f(i7);
        float[][] fArr = b.f5704a;
        float f8 = fArrF[0];
        float[] fArr2 = fArr[0];
        float f9 = fArr2[0] * f8;
        float f10 = fArrF[1];
        float f11 = f9 + (fArr2[1] * f10);
        float f12 = fArrF[2];
        float f13 = f11 + (fArr2[2] * f12);
        float[] fArr3 = fArr[1];
        float f14 = (fArr3[0] * f8) + (fArr3[1] * f10) + (fArr3[2] * f12);
        float[] fArr4 = fArr[2];
        float f15 = (f8 * fArr4[0]) + (f10 * fArr4[1]) + (f12 * fArr4[2]);
        float f16 = rVar.i()[0] * f13;
        float f17 = rVar.i()[1] * f14;
        float f18 = rVar.i()[2] * f15;
        float fPow = (float) Math.pow(((double) (rVar.c() * Math.abs(f16))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (rVar.c() * Math.abs(f17))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (rVar.c() * Math.abs(f18))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f16) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f17) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f18) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d8 = fSignum3;
        float f19 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d8)) / 11.0f;
        float f20 = ((float) (((double) (fSignum + fSignum2)) - (d8 * 2.0d))) / 9.0f;
        float f21 = fSignum2 * 20.0f;
        float f22 = (((fSignum * 20.0f) + f21) + (21.0f * fSignum3)) / 20.0f;
        float f23 = (((fSignum * 40.0f) + f21) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f20, f19)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f24 = fAtan2;
        float f25 = (3.1415927f * f24) / 180.0f;
        float fPow4 = ((float) Math.pow((f23 * rVar.f()) / rVar.a(), rVar.b() * rVar.j())) * 100.0f;
        float fD = rVar.d() * (4.0f / rVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (rVar.a() + 4.0f);
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, rVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) f24) < 20.14d ? 360.0f + f24 : f24)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * rVar.g()) * rVar.h()) * ((float) Math.sqrt((f19 * f19) + (f20 * f20)))) / (f22 + 0.305f), 0.9d));
        float fSqrt = fPow5 * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        float fD2 = fSqrt * rVar.d();
        float fSqrt2 = ((float) Math.sqrt((fPow5 * rVar.b()) / (rVar.a() + 4.0f))) * 50.0f;
        float f26 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD2) + 1.0f)) * 43.85965f;
        double d9 = f25;
        return new a(f24, fSqrt, fPow4, fD, fD2, fSqrt2, f26, fLog * ((float) Math.cos(d9)), fLog * ((float) Math.sin(d9)));
    }

    @m0
    private static a e(@v(from = 0.0d, to = 100.0d) float f8, @v(from = 0.0d, to = x.f34951d, toInclusive = false) float f9, @v(from = 0.0d, to = 360.0d) float f10) {
        return f(f8, f9, f10, r.f5754k);
    }

    @m0
    private static a f(@v(from = 0.0d, to = 100.0d) float f8, @v(from = 0.0d, to = x.f34951d, toInclusive = false) float f9, @v(from = 0.0d, to = 360.0d) float f10, r rVar) {
        double d8 = ((double) f8) / 100.0d;
        float fB = (4.0f / rVar.b()) * ((float) Math.sqrt(d8)) * (rVar.a() + 4.0f) * rVar.d();
        float fD = f9 * rVar.d();
        float fSqrt = ((float) Math.sqrt(((f9 / ((float) Math.sqrt(d8))) * rVar.b()) / (rVar.a() + 4.0f))) * 50.0f;
        float f11 = (1.7f * f8) / ((0.007f * f8) + 1.0f);
        float fLog = ((float) Math.log((((double) fD) * 0.0228d) + 1.0d)) * 43.85965f;
        double d9 = (3.1415927f * f10) / 180.0f;
        return new a(f10, f9, f8, fB, fD, fSqrt, f11, fLog * ((float) Math.cos(d9)), fLog * ((float) Math.sin(d9)));
    }

    static int p(@v(from = 0.0d, to = 360.0d) float f8, @v(from = 0.0d, to = x.f34951d, toInclusive = false) float f9, @v(from = 0.0d, to = 100.0d) float f10) {
        return q(f8, f9, f10, r.f5754k);
    }

    @c.l
    static int q(@v(from = 0.0d, to = 360.0d) float f8, @v(from = 0.0d, to = x.f34951d, toInclusive = false) float f9, @v(from = 0.0d, to = 100.0d) float f10, @m0 r rVar) {
        if (f9 < 1.0d || Math.round(f10) <= 0.0d || Math.round(f10) >= 100.0d) {
            return b.a(f10);
        }
        float fMin = f8 < 0.0f ? 0.0f : Math.min(360.0f, f8);
        a aVar = null;
        boolean z7 = true;
        float f11 = 0.0f;
        float f12 = f9;
        while (Math.abs(f11 - f9) >= f5693l) {
            a aVarB = b(fMin, f12, f10);
            if (!z7) {
                if (aVarB == null) {
                    f9 = f12;
                } else {
                    f11 = f12;
                    aVar = aVarB;
                }
                f12 = ((f9 - f11) / 2.0f) + f11;
            } else {
                if (aVarB != null) {
                    return aVarB.r(rVar);
                }
                f12 = ((f9 - f11) / 2.0f) + f11;
                z7 = false;
            }
        }
        return aVar == null ? b.a(f10) : aVar.r(rVar);
    }

    float a(@m0 a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    @v(from = x.f34952e, fromInclusive = false, to = x.f34951d, toInclusive = false)
    float g() {
        return this.f5702h;
    }

    @v(from = x.f34952e, fromInclusive = false, to = x.f34951d, toInclusive = false)
    float h() {
        return this.f5703i;
    }

    @v(from = 0.0d, to = x.f34951d, toInclusive = false)
    float i() {
        return this.f5696b;
    }

    @v(from = 0.0d, to = 360.0d, toInclusive = false)
    float j() {
        return this.f5695a;
    }

    @v(from = 0.0d, to = 100.0d)
    float k() {
        return this.f5697c;
    }

    @v(from = 0.0d, to = 100.0d)
    float l() {
        return this.f5701g;
    }

    @v(from = 0.0d, to = x.f34951d, toInclusive = false)
    float m() {
        return this.f5699e;
    }

    @v(from = 0.0d, to = x.f34951d, toInclusive = false)
    float n() {
        return this.f5698d;
    }

    @v(from = 0.0d, to = x.f34951d, toInclusive = false)
    float o() {
        return this.f5700f;
    }

    @c.l
    int r(@m0 r rVar) {
        float fPow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, rVar.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = rVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) rVar.b())) / ((double) rVar.j())));
        float fG = fCos * 3846.1538f * rVar.g() * rVar.h();
        float f8 = fA / rVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f9 = (((0.305f + f8) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f10 = fCos2 * f9;
        float f11 = f9 * fSin;
        float f12 = f8 * 460.0f;
        float f13 = (((451.0f * f10) + f12) + (288.0f * f11)) / 1403.0f;
        float f14 = ((f12 - (891.0f * f10)) - (261.0f * f11)) / 1403.0f;
        float f15 = ((f12 - (f10 * 220.0f)) - (f11 * 6300.0f)) / 1403.0f;
        float fSignum = Math.signum(f13) * (100.0f / rVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f13)) * 27.13d) / (400.0d - ((double) Math.abs(f13)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f14) * (100.0f / rVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f14)) * 27.13d) / (400.0d - ((double) Math.abs(f14)))), 2.380952380952381d));
        float fSignum3 = Math.signum(f15) * (100.0f / rVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f15)) * 27.13d) / (400.0d - ((double) Math.abs(f15)))), 2.380952380952381d));
        float f16 = fSignum / rVar.i()[0];
        float f17 = fSignum2 / rVar.i()[1];
        float f18 = fSignum3 / rVar.i()[2];
        float[][] fArr = b.f5705b;
        float[] fArr2 = fArr[0];
        float f19 = (fArr2[0] * f16) + (fArr2[1] * f17) + (fArr2[2] * f18);
        float[] fArr3 = fArr[1];
        float f20 = (fArr3[0] * f16) + (fArr3[1] * f17) + (fArr3[2] * f18);
        float[] fArr4 = fArr[2];
        return v1.g(f19, f20, (f16 * fArr4[0]) + (f17 * fArr4[1]) + (f18 * fArr4[2]));
    }

    @c.l
    int s() {
        return r(r.f5754k);
    }
}
