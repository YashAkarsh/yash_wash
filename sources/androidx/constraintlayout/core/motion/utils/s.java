package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class s implements r {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f2935p = 1.0E-5f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f2936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f2938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f2939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f2942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f2943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f2944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f2946k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f2948m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f2949n;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2947l = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2950o = false;

    private float e(float f8) {
        this.f2950o = false;
        float f9 = this.f2939d;
        if (f8 <= f9) {
            float f10 = this.f2936a;
            return (f10 * f8) + ((((this.f2937b - f10) * f8) * f8) / (f9 * 2.0f));
        }
        int i7 = this.f2945j;
        if (i7 == 1) {
            return this.f2942g;
        }
        float f11 = f8 - f9;
        float f12 = this.f2940e;
        if (f11 < f12) {
            float f13 = this.f2942g;
            float f14 = this.f2937b;
            return f13 + (f14 * f11) + ((((this.f2938c - f14) * f11) * f11) / (f12 * 2.0f));
        }
        if (i7 == 2) {
            return this.f2943h;
        }
        float f15 = f11 - f12;
        float f16 = this.f2941f;
        if (f15 > f16) {
            this.f2950o = true;
            return this.f2944i;
        }
        float f17 = this.f2943h;
        float f18 = this.f2938c;
        return (f17 + (f18 * f15)) - (((f18 * f15) * f15) / (f16 * 2.0f));
    }

    private void g(float f8, float f9, float f10, float f11, float f12) {
        this.f2950o = false;
        if (f8 == 0.0f) {
            f8 = 1.0E-4f;
        }
        this.f2936a = f8;
        float f13 = f8 / f10;
        float f14 = (f13 * f8) / 2.0f;
        if (f8 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f9 - ((((-f8) / f10) * f8) / 2.0f)) * f10);
            if (fSqrt < f11) {
                this.f2946k = "backward accelerate, decelerate";
                this.f2945j = 2;
                this.f2936a = f8;
                this.f2937b = fSqrt;
                this.f2938c = 0.0f;
                float f15 = (fSqrt - f8) / f10;
                this.f2939d = f15;
                this.f2940e = fSqrt / f10;
                this.f2942g = ((f8 + fSqrt) * f15) / 2.0f;
                this.f2943h = f9;
                this.f2944i = f9;
                return;
            }
            this.f2946k = "backward accelerate cruse decelerate";
            this.f2945j = 3;
            this.f2936a = f8;
            this.f2937b = f11;
            this.f2938c = f11;
            float f16 = (f11 - f8) / f10;
            this.f2939d = f16;
            float f17 = f11 / f10;
            this.f2941f = f17;
            float f18 = ((f8 + f11) * f16) / 2.0f;
            float f19 = (f17 * f11) / 2.0f;
            this.f2940e = ((f9 - f18) - f19) / f11;
            this.f2942g = f18;
            this.f2943h = f9 - f19;
            this.f2944i = f9;
            return;
        }
        if (f14 >= f9) {
            this.f2946k = "hard stop";
            this.f2945j = 1;
            this.f2936a = f8;
            this.f2937b = 0.0f;
            this.f2942g = f9;
            this.f2939d = (2.0f * f9) / f8;
            return;
        }
        float f20 = f9 - f14;
        float f21 = f20 / f8;
        if (f21 + f13 < f12) {
            this.f2946k = "cruse decelerate";
            this.f2945j = 2;
            this.f2936a = f8;
            this.f2937b = f8;
            this.f2938c = 0.0f;
            this.f2942g = f20;
            this.f2943h = f9;
            this.f2939d = f21;
            this.f2940e = f13;
            return;
        }
        float fSqrt2 = (float) Math.sqrt((f10 * f9) + ((f8 * f8) / 2.0f));
        float f22 = (fSqrt2 - f8) / f10;
        this.f2939d = f22;
        float f23 = fSqrt2 / f10;
        this.f2940e = f23;
        if (fSqrt2 < f11) {
            this.f2946k = "accelerate decelerate";
            this.f2945j = 2;
            this.f2936a = f8;
            this.f2937b = fSqrt2;
            this.f2938c = 0.0f;
            this.f2939d = f22;
            this.f2940e = f23;
            this.f2942g = ((f8 + fSqrt2) * f22) / 2.0f;
            this.f2943h = f9;
            return;
        }
        this.f2946k = "accelerate cruse decelerate";
        this.f2945j = 3;
        this.f2936a = f8;
        this.f2937b = f11;
        this.f2938c = f11;
        float f24 = (f11 - f8) / f10;
        this.f2939d = f24;
        float f25 = f11 / f10;
        this.f2941f = f25;
        float f26 = ((f8 + f11) * f24) / 2.0f;
        float f27 = (f25 * f11) / 2.0f;
        this.f2940e = ((f9 - f26) - f27) / f11;
        this.f2942g = f26;
        this.f2943h = f9 - f27;
        this.f2944i = f9;
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public float a() {
        return this.f2947l ? -c(this.f2949n) : c(this.f2949n);
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public String b(String str, float f8) {
        String str2 = str + " ===== " + this.f2946k + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        sb.append(this.f2947l ? "backwards" : "forward ");
        sb.append(" time = ");
        sb.append(f8);
        sb.append("  stages ");
        sb.append(this.f2945j);
        sb.append("\n");
        String str3 = sb.toString() + str + " dur " + this.f2939d + " vel " + this.f2936a + " pos " + this.f2942g + "\n";
        if (this.f2945j > 1) {
            str3 = str3 + str + " dur " + this.f2940e + " vel " + this.f2937b + " pos " + this.f2943h + "\n";
        }
        if (this.f2945j > 2) {
            str3 = str3 + str + " dur " + this.f2941f + " vel " + this.f2938c + " pos " + this.f2944i + "\n";
        }
        float f9 = this.f2939d;
        if (f8 <= f9) {
            return str3 + str + "stage 0\n";
        }
        int i7 = this.f2945j;
        if (i7 == 1) {
            return str3 + str + "end stage 0\n";
        }
        float f10 = f8 - f9;
        float f11 = this.f2940e;
        if (f10 < f11) {
            return str3 + str + " stage 1\n";
        }
        if (i7 == 2) {
            return str3 + str + "end stage 1\n";
        }
        if (f10 - f11 < this.f2941f) {
            return str3 + str + " stage 2\n";
        }
        return str3 + str + " end stage 2\n";
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public float c(float f8) {
        float f9 = this.f2939d;
        if (f8 <= f9) {
            float f10 = this.f2936a;
            return f10 + (((this.f2937b - f10) * f8) / f9);
        }
        int i7 = this.f2945j;
        if (i7 == 1) {
            return 0.0f;
        }
        float f11 = f8 - f9;
        float f12 = this.f2940e;
        if (f11 < f12) {
            float f13 = this.f2937b;
            return f13 + (((this.f2938c - f13) * f11) / f12);
        }
        if (i7 == 2) {
            return this.f2943h;
        }
        float f14 = f11 - f12;
        float f15 = this.f2941f;
        if (f14 >= f15) {
            return this.f2944i;
        }
        float f16 = this.f2938c;
        return f16 - ((f14 * f16) / f15);
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public boolean d() {
        return a() < f2935p && Math.abs(this.f2944i - this.f2949n) < f2935p;
    }

    public void f(float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f2950o = false;
        this.f2948m = f8;
        boolean z7 = f8 > f9;
        this.f2947l = z7;
        if (z7) {
            g(-f10, f8 - f9, f12, f13, f11);
        } else {
            g(f10, f9 - f8, f12, f13, f11);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public float getInterpolation(float f8) {
        float fE = e(f8);
        this.f2949n = f8;
        return this.f2947l ? this.f2948m - fE : this.f2948m + fE;
    }
}
