package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class n extends d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final boolean f2903s = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    double f2904p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    double f2905q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    double f2906r;

    n(String str) {
        this.f2787a = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.f2904p = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i7 = iIndexOf2 + 1;
        this.f2905q = Double.parseDouble(str.substring(i7, str.indexOf(44, i7)).trim());
    }

    private double d(double d8) {
        double d9 = this.f2905q;
        if (d8 < d9) {
            double d10 = this.f2904p;
            return ((d10 * d9) * d9) / ((((d9 - d8) * d10) + d8) * ((d10 * (d9 - d8)) + d8));
        }
        double d11 = this.f2904p;
        return (((d9 - 1.0d) * d11) * (d9 - 1.0d)) / (((((-d11) * (d9 - d8)) - d8) + 1.0d) * ((((-d11) * (d9 - d8)) - d8) + 1.0d));
    }

    private double e(double d8) {
        double d9 = this.f2905q;
        return d8 < d9 ? (d9 * d8) / (d8 + (this.f2904p * (d9 - d8))) : ((1.0d - d9) * (d8 - 1.0d)) / ((1.0d - d8) - (this.f2904p * (d9 - d8)));
    }

    @Override // androidx.constraintlayout.core.motion.utils.d
    public double a(double d8) {
        return e(d8);
    }

    @Override // androidx.constraintlayout.core.motion.utils.d
    public double b(double d8) {
        return d(d8);
    }
}
