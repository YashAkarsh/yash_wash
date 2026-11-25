package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a[][] f2800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    double[] f2802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double f2803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    double[][] f2804f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f2805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f2806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f2807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double f2808d;

        public a(double d8, double d9, double d10, double d11) {
            this.f2805a = d8;
            this.f2806b = d9;
            this.f2807c = d10;
            this.f2808d = d11;
        }

        public double a(double d8) {
            return (((((this.f2808d * d8) + this.f2807c) * d8) + this.f2806b) * d8) + this.f2805a;
        }

        public double b(double d8) {
            return (((this.f2808d * 3.0d * d8) + (this.f2807c * 2.0d)) * d8) + this.f2806b;
        }
    }

    public f(double[][] dArr) {
        g(dArr);
    }

    static a[] b(int i7, double[] dArr) {
        double[] dArr2 = new double[i7];
        double[] dArr3 = new double[i7];
        double[] dArr4 = new double[i7];
        int i8 = i7 - 1;
        int i9 = 0;
        dArr2[0] = 0.5d;
        int i10 = 1;
        for (int i11 = 1; i11 < i8; i11++) {
            dArr2[i11] = 1.0d / (4.0d - dArr2[i11 - 1]);
        }
        int i12 = i8 - 1;
        dArr2[i8] = 1.0d / (2.0d - dArr2[i12]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i10 < i8) {
            int i13 = i10 + 1;
            int i14 = i10 - 1;
            dArr3[i10] = (((dArr[i13] - dArr[i14]) * 3.0d) - dArr3[i14]) * dArr2[i10];
            i10 = i13;
        }
        double d8 = (((dArr[i8] - dArr[i12]) * 3.0d) - dArr3[i12]) * dArr2[i8];
        dArr3[i8] = d8;
        dArr4[i8] = d8;
        while (i12 >= 0) {
            dArr4[i12] = dArr3[i12] - (dArr2[i12] * dArr4[i12 + 1]);
            i12--;
        }
        a[] aVarArr = new a[i8];
        while (i9 < i8) {
            double d9 = dArr[i9];
            double d10 = dArr4[i9];
            int i15 = i9 + 1;
            double d11 = dArr[i15];
            double d12 = dArr4[i15];
            aVarArr[i9] = new a((float) d9, d10, (((d11 - d9) * 3.0d) - (d10 * 2.0d)) - d12, ((d9 - d11) * 2.0d) + d10 + d12);
            i9 = i15;
        }
        return aVarArr;
    }

    public double a(a[] aVarArr) {
        int i7;
        int length = aVarArr.length;
        double[] dArr = new double[aVarArr.length];
        double d8 = 0.0d;
        double d9 = 0.0d;
        double dSqrt = 0.0d;
        while (true) {
            i7 = 0;
            if (d9 >= 1.0d) {
                break;
            }
            double d10 = 0.0d;
            while (i7 < aVarArr.length) {
                double d11 = dArr[i7];
                double dA = aVarArr[i7].a(d9);
                dArr[i7] = dA;
                double d12 = d11 - dA;
                d10 += d12 * d12;
                i7++;
            }
            if (d9 > 0.0d) {
                dSqrt += Math.sqrt(d10);
            }
            d9 += 0.1d;
        }
        while (i7 < aVarArr.length) {
            double d13 = dArr[i7];
            double dA2 = aVarArr[i7].a(1.0d);
            dArr[i7] = dA2;
            double d14 = d13 - dA2;
            d8 += d14 * d14;
            i7++;
        }
        return dSqrt + Math.sqrt(d8);
    }

    public double c(double d8, int i7) {
        double[] dArr;
        double d9 = d8 * this.f2803e;
        int i8 = 0;
        while (true) {
            dArr = this.f2802d;
            if (i8 >= dArr.length - 1) {
                break;
            }
            double d10 = dArr[i8];
            if (d10 >= d9) {
                break;
            }
            d9 -= d10;
            i8++;
        }
        return this.f2800b[i7][i8].a(d9 / dArr[i8]);
    }

    public void d(double d8, double[] dArr) {
        double d9 = d8 * this.f2803e;
        int i7 = 0;
        while (true) {
            double[] dArr2 = this.f2802d;
            if (i7 >= dArr2.length - 1) {
                break;
            }
            double d10 = dArr2[i7];
            if (d10 >= d9) {
                break;
            }
            d9 -= d10;
            i7++;
        }
        for (int i8 = 0; i8 < dArr.length; i8++) {
            dArr[i8] = this.f2800b[i8][i7].a(d9 / this.f2802d[i7]);
        }
    }

    public void e(double d8, float[] fArr) {
        double d9 = d8 * this.f2803e;
        int i7 = 0;
        while (true) {
            double[] dArr = this.f2802d;
            if (i7 >= dArr.length - 1) {
                break;
            }
            double d10 = dArr[i7];
            if (d10 >= d9) {
                break;
            }
            d9 -= d10;
            i7++;
        }
        for (int i8 = 0; i8 < fArr.length; i8++) {
            fArr[i8] = (float) this.f2800b[i8][i7].a(d9 / this.f2802d[i7]);
        }
    }

    public void f(double d8, double[] dArr) {
        double d9 = d8 * this.f2803e;
        int i7 = 0;
        while (true) {
            double[] dArr2 = this.f2802d;
            if (i7 >= dArr2.length - 1) {
                break;
            }
            double d10 = dArr2[i7];
            if (d10 >= d9) {
                break;
            }
            d9 -= d10;
            i7++;
        }
        for (int i8 = 0; i8 < dArr.length; i8++) {
            dArr[i8] = this.f2800b[i8][i7].b(d9 / this.f2802d[i7]);
        }
    }

    public void g(double[][] dArr) {
        int i7;
        int length = dArr[0].length;
        this.f2801c = length;
        int length2 = dArr.length;
        this.f2799a = length2;
        this.f2804f = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.f2800b = new a[this.f2801c][];
        for (int i8 = 0; i8 < this.f2801c; i8++) {
            for (int i9 = 0; i9 < this.f2799a; i9++) {
                this.f2804f[i8][i9] = dArr[i9][i8];
            }
        }
        int i10 = 0;
        while (true) {
            i7 = this.f2801c;
            if (i10 >= i7) {
                break;
            }
            a[][] aVarArr = this.f2800b;
            double[] dArr2 = this.f2804f[i10];
            aVarArr[i10] = b(dArr2.length, dArr2);
            i10++;
        }
        this.f2802d = new double[this.f2799a - 1];
        this.f2803e = 0.0d;
        a[] aVarArr2 = new a[i7];
        for (int i11 = 0; i11 < this.f2802d.length; i11++) {
            for (int i12 = 0; i12 < this.f2801c; i12++) {
                aVarArr2[i12] = this.f2800b[i12][i11];
            }
            double d8 = this.f2803e;
            double[] dArr3 = this.f2802d;
            double dA = a(aVarArr2);
            dArr3[i11] = dA;
            this.f2803e = d8 + dA;
        }
    }

    public f() {
    }
}
