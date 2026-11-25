package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f2774c = "cubic(0.4, 0.0, 0.2, 1)";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f2775d = "cubic(0.4, 0.05, 0.8, 0.7)";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f2776e = "cubic(0.0, 0.0, 0.2, 0.95)";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2777f = "cubic(1, 1, 0, 0)";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f2778g = "cubic(0.36, 0, 0.66, -0.56)";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f2779h = "cubic(0.34, 1.56, 0.64, 1)";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f2784m = "anticipate";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f2785n = "overshoot";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f2787a = "identity";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static d f2773b = new d();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f2782k = "standard";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f2781j = "accelerate";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f2780i = "decelerate";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f2783l = "linear";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String[] f2786o = {f2782k, f2781j, f2780i, f2783l};

    public static d c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        if (str.startsWith("spline")) {
            return new q(str);
        }
        if (str.startsWith("Schlick")) {
            return new n(str);
        }
        switch (str) {
            case "accelerate":
                return new a(f2775d);
            case "decelerate":
                return new a(f2776e);
            case "anticipate":
                return new a(f2778g);
            case "linear":
                return new a(f2777f);
            case "overshoot":
                return new a(f2779h);
            case "standard":
                return new a(f2774c);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f2786o));
                return f2773b;
        }
    }

    public double a(double d8) {
        return d8;
    }

    public double b(double d8) {
        return 1.0d;
    }

    public String toString() {
        return this.f2787a;
    }

    static class a extends d {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static double f2788t = 0.01d;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static double f2789u = 1.0E-4d;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        double f2790p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        double f2791q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        double f2792r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        double f2793s;

        a(String str) {
            this.f2787a = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f2790p = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i7 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i7);
            this.f2791q = Double.parseDouble(str.substring(i7, iIndexOf3).trim());
            int i8 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i8);
            this.f2792r = Double.parseDouble(str.substring(i8, iIndexOf4).trim());
            int i9 = iIndexOf4 + 1;
            this.f2793s = Double.parseDouble(str.substring(i9, str.indexOf(41, i9)).trim());
        }

        private double d(double d8) {
            double d9 = 1.0d - d8;
            double d10 = this.f2790p;
            double d11 = this.f2792r;
            return (d9 * 3.0d * d9 * d10) + (d9 * 6.0d * d8 * (d11 - d10)) + (3.0d * d8 * d8 * (1.0d - d11));
        }

        private double e(double d8) {
            double d9 = 1.0d - d8;
            double d10 = this.f2791q;
            double d11 = this.f2793s;
            return (d9 * 3.0d * d9 * d10) + (d9 * 6.0d * d8 * (d11 - d10)) + (3.0d * d8 * d8 * (1.0d - d11));
        }

        private double f(double d8) {
            double d9 = 1.0d - d8;
            double d10 = 3.0d * d9;
            return (this.f2790p * d9 * d10 * d8) + (this.f2792r * d10 * d8 * d8) + (d8 * d8 * d8);
        }

        private double g(double d8) {
            double d9 = 1.0d - d8;
            double d10 = 3.0d * d9;
            return (this.f2791q * d9 * d10 * d8) + (this.f2793s * d10 * d8 * d8) + (d8 * d8 * d8);
        }

        @Override // androidx.constraintlayout.core.motion.utils.d
        public double a(double d8) {
            if (d8 <= 0.0d) {
                return 0.0d;
            }
            if (d8 >= 1.0d) {
                return 1.0d;
            }
            double d9 = 0.5d;
            double d10 = 0.5d;
            while (d9 > f2788t) {
                d9 *= 0.5d;
                d10 = f(d10) < d8 ? d10 + d9 : d10 - d9;
            }
            double d11 = d10 - d9;
            double dF = f(d11);
            double d12 = d10 + d9;
            double dF2 = f(d12);
            double dG = g(d11);
            return (((g(d12) - dG) * (d8 - dF)) / (dF2 - dF)) + dG;
        }

        @Override // androidx.constraintlayout.core.motion.utils.d
        public double b(double d8) {
            double d9 = 0.5d;
            double d10 = 0.5d;
            while (d9 > f2789u) {
                d9 *= 0.5d;
                d10 = f(d10) < d8 ? d10 + d9 : d10 - d9;
            }
            double d11 = d10 - d9;
            double d12 = d10 + d9;
            return (g(d12) - g(d11)) / (f(d12) - f(d11));
        }

        void h(double d8, double d9, double d10, double d11) {
            this.f2790p = d8;
            this.f2791q = d9;
            this.f2792r = d10;
            this.f2793s = d11;
        }

        public a(double d8, double d9, double d10, double d11) {
            h(d8, d9, d10, d11);
        }
    }
}
