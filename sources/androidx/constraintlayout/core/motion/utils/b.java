package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2768a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2769b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f2770c = 2;

    static class a extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double f2771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        double[] f2772e;

        a(double d8, double[] dArr) {
            this.f2771d = d8;
            this.f2772e = dArr;
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public double c(double d8, int i7) {
            return this.f2772e[i7];
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void d(double d8, double[] dArr) {
            double[] dArr2 = this.f2772e;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void e(double d8, float[] fArr) {
            int i7 = 0;
            while (true) {
                double[] dArr = this.f2772e;
                if (i7 >= dArr.length) {
                    return;
                }
                fArr[i7] = (float) dArr[i7];
                i7++;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public double f(double d8, int i7) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void g(double d8, double[] dArr) {
            for (int i7 = 0; i7 < this.f2772e.length; i7++) {
                dArr[i7] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public double[] h() {
            return new double[]{this.f2771d};
        }
    }

    public static b a(int i7, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i7 = 2;
        }
        if (i7 != 0) {
            return i7 != 2 ? new j(dArr, dArr2) : new a(dArr[0], dArr2[0]);
        }
        return new k(dArr, dArr2);
    }

    public static b b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new androidx.constraintlayout.core.motion.utils.a(iArr, dArr, dArr2);
    }

    public abstract double c(double d8, int i7);

    public abstract void d(double d8, double[] dArr);

    public abstract void e(double d8, float[] fArr);

    public abstract double f(double d8, int i7);

    public abstract void g(double d8, double[] dArr);

    public abstract double[] h();
}
