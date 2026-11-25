package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f2882i = "Oscillator";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f2883j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f2884k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f2885l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f2886m = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f2887n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f2888o = 5;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f2889p = 6;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f2890q = 7;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    double[] f2893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f2894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    k f2895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2896f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float[] f2891a = new float[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    double[] f2892b = new double[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    double f2897g = 6.283185307179586d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2898h = false;

    public void a(double d8, float f8) {
        int length = this.f2891a.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.f2892b, d8);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.f2892b = Arrays.copyOf(this.f2892b, length);
        this.f2891a = Arrays.copyOf(this.f2891a, length);
        this.f2893c = new double[length];
        double[] dArr = this.f2892b;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.f2892b[iBinarySearch] = d8;
        this.f2891a[iBinarySearch] = f8;
        this.f2898h = false;
    }

    double b(double d8) {
        if (d8 <= 0.0d) {
            d8 = 1.0E-5d;
        } else if (d8 >= 1.0d) {
            d8 = 0.999999d;
        }
        int iBinarySearch = Arrays.binarySearch(this.f2892b, d8);
        if (iBinarySearch > 0 || iBinarySearch == 0) {
            return 0.0d;
        }
        int i7 = (-iBinarySearch) - 1;
        float[] fArr = this.f2891a;
        float f8 = fArr[i7];
        int i8 = i7 - 1;
        float f9 = fArr[i8];
        double d9 = f8 - f9;
        double[] dArr = this.f2892b;
        double d10 = dArr[i7];
        double d11 = dArr[i8];
        double d12 = d9 / (d10 - d11);
        return (((double) f9) - (d12 * d11)) + (d8 * d12);
    }

    double c(double d8) {
        if (d8 < 0.0d) {
            d8 = 0.0d;
        } else if (d8 > 1.0d) {
            d8 = 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.f2892b, d8);
        if (iBinarySearch > 0) {
            return 1.0d;
        }
        if (iBinarySearch == 0) {
            return 0.0d;
        }
        int i7 = (-iBinarySearch) - 1;
        float[] fArr = this.f2891a;
        float f8 = fArr[i7];
        int i8 = i7 - 1;
        float f9 = fArr[i8];
        double d9 = f8 - f9;
        double[] dArr = this.f2892b;
        double d10 = dArr[i7];
        double d11 = dArr[i8];
        double d12 = d9 / (d10 - d11);
        return this.f2893c[i8] + ((((double) f9) - (d12 * d11)) * (d8 - d11)) + ((d12 * ((d8 * d8) - (d11 * d11))) / 2.0d);
    }

    public double d(double d8, double d9, double d10) {
        double dC = d9 + c(d8);
        double dB = b(d8) + d10;
        switch (this.f2896f) {
            case 1:
                return 0.0d;
            case 2:
                return dB * 4.0d * Math.signum((((dC * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return dB * 2.0d;
            case 4:
                return (-dB) * 2.0d;
            case 5:
                double d11 = this.f2897g;
                return (-d11) * dB * Math.sin(d11 * dC);
            case 6:
                return dB * 4.0d * ((((dC * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.f2895e.f(dC % 1.0d, 0);
            default:
                double d12 = this.f2897g;
                return dB * d12 * Math.cos(d12 * dC);
        }
    }

    public double e(double d8, double d9) {
        double dAbs;
        double dC = c(d8) + d9;
        switch (this.f2896f) {
            case 1:
                return Math.signum(0.5d - (dC % 1.0d));
            case 2:
                dAbs = Math.abs((((dC * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((dC * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((dC * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f2897g * (d9 + dC));
            case 6:
                double dAbs2 = 1.0d - Math.abs(((dC * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            case 7:
                return this.f2895e.c(dC % 1.0d, 0);
            default:
                return Math.sin(this.f2897g * dC);
        }
        return 1.0d - dAbs;
    }

    public void f() {
        double d8 = 0.0d;
        int i7 = 0;
        while (true) {
            float[] fArr = this.f2891a;
            if (i7 >= fArr.length) {
                break;
            }
            d8 += (double) fArr[i7];
            i7++;
        }
        double d9 = 0.0d;
        int i8 = 1;
        while (true) {
            float[] fArr2 = this.f2891a;
            if (i8 >= fArr2.length) {
                break;
            }
            int i9 = i8 - 1;
            float f8 = (fArr2[i9] + fArr2[i8]) / 2.0f;
            double[] dArr = this.f2892b;
            d9 += (dArr[i8] - dArr[i9]) * ((double) f8);
            i8++;
        }
        int i10 = 0;
        while (true) {
            float[] fArr3 = this.f2891a;
            if (i10 >= fArr3.length) {
                break;
            }
            fArr3[i10] = (float) (((double) fArr3[i10]) * (d8 / d9));
            i10++;
        }
        this.f2893c[0] = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr4 = this.f2891a;
            if (i11 >= fArr4.length) {
                this.f2898h = true;
                return;
            }
            int i12 = i11 - 1;
            float f9 = (fArr4[i12] + fArr4[i11]) / 2.0f;
            double[] dArr2 = this.f2892b;
            double d10 = dArr2[i11] - dArr2[i12];
            double[] dArr3 = this.f2893c;
            dArr3[i11] = dArr3[i12] + (d10 * ((double) f9));
            i11++;
        }
    }

    public void g(int i7, String str) {
        this.f2896f = i7;
        this.f2894d = str;
        if (str != null) {
            this.f2895e = k.i(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f2892b) + " period=" + Arrays.toString(this.f2891a);
    }
}
