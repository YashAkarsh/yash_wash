package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class f0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f2809g = "VelocityMatrix";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f2810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f2811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f2812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f2813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f2814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f2815f;

    public void a(float f8, float f9, int i7, int i8, float[] fArr) {
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = (f8 - 0.5f) * 2.0f;
        float f13 = (f9 - 0.5f) * 2.0f;
        float f14 = f10 + this.f2812c;
        float f15 = f11 + this.f2813d;
        float f16 = f14 + (this.f2810a * f12);
        float f17 = f15 + (this.f2811b * f13);
        float radians = (float) Math.toRadians(this.f2815f);
        float radians2 = (float) Math.toRadians(this.f2814e);
        double d8 = radians;
        double d9 = i8 * f13;
        float fSin = f16 + (((float) ((((double) ((-i7) * f12)) * Math.sin(d8)) - (Math.cos(d8) * d9))) * radians2);
        float fCos = f17 + (radians2 * ((float) ((((double) (i7 * f12)) * Math.cos(d8)) - (d9 * Math.sin(d8)))));
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    public void b() {
        this.f2814e = 0.0f;
        this.f2813d = 0.0f;
        this.f2812c = 0.0f;
        this.f2811b = 0.0f;
        this.f2810a = 0.0f;
    }

    public void c(h hVar, float f8) {
        if (hVar != null) {
            this.f2814e = hVar.c(f8);
        }
    }

    public void d(o oVar, float f8) {
        if (oVar != null) {
            this.f2814e = oVar.c(f8);
            this.f2815f = oVar.a(f8);
        }
    }

    public void e(h hVar, h hVar2, float f8) {
        if (hVar != null) {
            this.f2810a = hVar.c(f8);
        }
        if (hVar2 != null) {
            this.f2811b = hVar2.c(f8);
        }
    }

    public void f(o oVar, o oVar2, float f8) {
        if (oVar != null) {
            this.f2810a = oVar.c(f8);
        }
        if (oVar2 != null) {
            this.f2811b = oVar2.c(f8);
        }
    }

    public void g(h hVar, h hVar2, float f8) {
        if (hVar != null) {
            this.f2812c = hVar.c(f8);
        }
        if (hVar2 != null) {
            this.f2813d = hVar2.c(f8);
        }
    }

    public void h(o oVar, o oVar2, float f8) {
        if (oVar != null) {
            this.f2812c = oVar.c(f8);
        }
        if (oVar2 != null) {
            this.f2813d = oVar2.c(f8);
        }
    }
}
