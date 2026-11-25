package androidx.dynamicanimation.animation;

import c.v;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public final class k implements i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f7423k = 10000.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float f7424l = 1500.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f7425m = 200.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float f7426n = 50.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f7427o = 0.2f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f7428p = 0.5f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f7429q = 0.75f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f7430r = 1.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final double f7431s = 62.5d;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final double f7432t = Double.MAX_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    double f7433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    double f7434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f7436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f7437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f7438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f7439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f7440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f7441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b.p f7442j;

    public k() {
        this.f7433a = Math.sqrt(1500.0d);
        this.f7434b = 0.5d;
        this.f7435c = false;
        this.f7441i = Double.MAX_VALUE;
        this.f7442j = new b.p();
    }

    private void f() {
        if (this.f7435c) {
            return;
        }
        if (this.f7441i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d8 = this.f7434b;
        if (d8 > 1.0d) {
            double d9 = this.f7433a;
            this.f7438f = ((-d8) * d9) + (d9 * Math.sqrt((d8 * d8) - 1.0d));
            double d10 = this.f7434b;
            double d11 = this.f7433a;
            this.f7439g = ((-d10) * d11) - (d11 * Math.sqrt((d10 * d10) - 1.0d));
        } else if (d8 >= 0.0d && d8 < 1.0d) {
            this.f7440h = this.f7433a * Math.sqrt(1.0d - (d8 * d8));
        }
        this.f7435c = true;
    }

    @Override // androidx.dynamicanimation.animation.i
    @x0({x0.a.LIBRARY})
    public boolean a(float f8, float f9) {
        return ((double) Math.abs(f9)) < this.f7437e && ((double) Math.abs(f8 - d())) < this.f7436d;
    }

    @Override // androidx.dynamicanimation.animation.i
    @x0({x0.a.LIBRARY})
    public float b(float f8, float f9) {
        float fD = f8 - d();
        double d8 = this.f7433a;
        return (float) (((-(d8 * d8)) * ((double) fD)) - (((d8 * 2.0d) * this.f7434b) * ((double) f9)));
    }

    public float c() {
        return (float) this.f7434b;
    }

    public float d() {
        return (float) this.f7441i;
    }

    public float e() {
        double d8 = this.f7433a;
        return (float) (d8 * d8);
    }

    public k g(@v(from = 0.0d) float f8) {
        if (f8 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f7434b = f8;
        this.f7435c = false;
        return this;
    }

    public k h(float f8) {
        this.f7441i = f8;
        return this;
    }

    public k i(@v(from = 0.0d, fromInclusive = false) float f8) {
        if (f8 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f7433a = Math.sqrt(f8);
        this.f7435c = false;
        return this;
    }

    void j(double d8) {
        double dAbs = Math.abs(d8);
        this.f7436d = dAbs;
        this.f7437e = dAbs * f7431s;
    }

    b.p k(double d8, double d9, long j7) {
        double dCos;
        double dPow;
        f();
        double d10 = j7 / 1000.0d;
        double d11 = d8 - this.f7441i;
        double d12 = this.f7434b;
        if (d12 > 1.0d) {
            double d13 = this.f7439g;
            double d14 = this.f7438f;
            double d15 = d11 - (((d13 * d11) - d9) / (d13 - d14));
            double d16 = ((d11 * d13) - d9) / (d13 - d14);
            dPow = (Math.pow(2.718281828459045d, d13 * d10) * d15) + (Math.pow(2.718281828459045d, this.f7438f * d10) * d16);
            double d17 = this.f7439g;
            double dPow2 = d15 * d17 * Math.pow(2.718281828459045d, d17 * d10);
            double d18 = this.f7438f;
            dCos = dPow2 + (d16 * d18 * Math.pow(2.718281828459045d, d18 * d10));
        } else if (d12 == 1.0d) {
            double d19 = this.f7433a;
            double d20 = d9 + (d19 * d11);
            double d21 = d11 + (d20 * d10);
            dPow = Math.pow(2.718281828459045d, (-d19) * d10) * d21;
            double dPow3 = d21 * Math.pow(2.718281828459045d, (-this.f7433a) * d10);
            double d22 = this.f7433a;
            dCos = (d20 * Math.pow(2.718281828459045d, (-d22) * d10)) + (dPow3 * (-d22));
        } else {
            double d23 = 1.0d / this.f7440h;
            double d24 = this.f7433a;
            double d25 = d23 * ((d12 * d24 * d11) + d9);
            double dPow4 = Math.pow(2.718281828459045d, (-d12) * d24 * d10) * ((Math.cos(this.f7440h * d10) * d11) + (Math.sin(this.f7440h * d10) * d25));
            double d26 = this.f7433a;
            double d27 = this.f7434b;
            double d28 = (-d26) * dPow4 * d27;
            double dPow5 = Math.pow(2.718281828459045d, (-d27) * d26 * d10);
            double d29 = this.f7440h;
            double dSin = (-d29) * d11 * Math.sin(d29 * d10);
            double d30 = this.f7440h;
            dCos = d28 + (dPow5 * (dSin + (d25 * d30 * Math.cos(d30 * d10))));
            dPow = dPow4;
        }
        b.p pVar = this.f7442j;
        pVar.f7412a = (float) (dPow + this.f7441i);
        pVar.f7413b = (float) dCos;
        return pVar;
    }

    public k(float f8) {
        this.f7433a = Math.sqrt(1500.0d);
        this.f7434b = 0.5d;
        this.f7435c = false;
        this.f7441i = Double.MAX_VALUE;
        this.f7442j = new b.p();
        this.f7441i = f8;
    }
}
