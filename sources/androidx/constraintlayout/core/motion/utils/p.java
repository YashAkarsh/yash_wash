package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class p implements r {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final double f2921l = Double.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f2924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f2925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f2926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f2928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f2929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f2930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f2931j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    double f2922a = 0.5d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2923b = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2932k = 0;

    private void e(double d8) {
        double d9 = this.f2924c;
        double d10 = this.f2922a;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d9 / ((double) this.f2930i)) * d8) * 4.0d)) + 1.0d);
        double d11 = d8 / ((double) iSqrt);
        int i7 = 0;
        while (i7 < iSqrt) {
            float f8 = this.f2928g;
            double d12 = this.f2925d;
            float f9 = this.f2929h;
            double d13 = d9;
            double d14 = ((-d9) * (((double) f8) - d12)) - (((double) f9) * d10);
            float f10 = this.f2930i;
            double d15 = d10;
            double d16 = ((double) f9) + (((d14 / ((double) f10)) * d11) / 2.0d);
            double d17 = ((((-((((double) f8) + ((d11 * d16) / 2.0d)) - d12)) * d13) - (d16 * d15)) / ((double) f10)) * d11;
            float f11 = (float) (((double) f9) + d17);
            this.f2929h = f11;
            float f12 = (float) (((double) f8) + ((((double) f9) + (d17 / 2.0d)) * d11));
            this.f2928g = f12;
            int i8 = this.f2932k;
            if (i8 > 0) {
                if (f12 < 0.0f && (i8 & 1) == 1) {
                    this.f2928g = -f12;
                    this.f2929h = -f11;
                }
                float f13 = this.f2928g;
                if (f13 > 1.0f && (i8 & 2) == 2) {
                    this.f2928g = 2.0f - f13;
                    this.f2929h = -this.f2929h;
                }
            }
            i7++;
            d9 = d13;
            d10 = d15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public float a() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public String b(String str, float f8) {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public float c(float f8) {
        return this.f2929h;
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public boolean d() {
        double d8 = ((double) this.f2928g) - this.f2925d;
        double d9 = this.f2924c;
        double d10 = this.f2929h;
        return Math.sqrt((((d10 * d10) * ((double) this.f2930i)) + ((d9 * d8) * d8)) / d9) <= ((double) this.f2931j);
    }

    public float f() {
        double d8 = this.f2924c;
        return ((float) (((-d8) * (((double) this.f2928g) - this.f2925d)) - (this.f2922a * ((double) this.f2929h)))) / this.f2930i;
    }

    void g(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }

    @Override // androidx.constraintlayout.core.motion.utils.r
    public float getInterpolation(float f8) {
        e(f8 - this.f2927f);
        this.f2927f = f8;
        return this.f2928g;
    }

    public void h(float f8, float f9, float f10, float f11, float f12, float f13, float f14, int i7) {
        this.f2925d = f9;
        this.f2922a = f13;
        this.f2923b = false;
        this.f2928g = f8;
        this.f2926e = f10;
        this.f2924c = f12;
        this.f2930i = f11;
        this.f2931j = f14;
        this.f2932k = i7;
        this.f2927f = 0.0f;
    }
}
