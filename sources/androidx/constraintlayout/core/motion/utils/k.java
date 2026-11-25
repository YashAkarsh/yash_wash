package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class k extends b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f2876i = "MonotonicCurveFit";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double[] f2877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double[][] f2878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double[][] f2879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2880g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    double[] f2881h;

    public k(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f2881h = new double[length2];
        int i7 = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i7, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        for (int i8 = 0; i8 < length2; i8++) {
            int i9 = 0;
            while (i9 < i7) {
                int i10 = i9 + 1;
                double d8 = dArr[i10] - dArr[i9];
                double[] dArr5 = dArr3[i9];
                double d9 = (dArr2[i10][i8] - dArr2[i9][i8]) / d8;
                dArr5[i8] = d9;
                if (i9 == 0) {
                    dArr4[i9][i8] = d9;
                } else {
                    dArr4[i9][i8] = (dArr3[i9 - 1][i8] + d9) * 0.5d;
                }
                i9 = i10;
            }
            dArr4[i7][i8] = dArr3[length - 2][i8];
        }
        for (int i11 = 0; i11 < i7; i11++) {
            for (int i12 = 0; i12 < length2; i12++) {
                double d10 = dArr3[i11][i12];
                if (d10 == 0.0d) {
                    dArr4[i11][i12] = 0.0d;
                    dArr4[i11 + 1][i12] = 0.0d;
                } else {
                    double d11 = dArr4[i11][i12] / d10;
                    int i13 = i11 + 1;
                    double d12 = dArr4[i13][i12] / d10;
                    double dHypot = Math.hypot(d11, d12);
                    if (dHypot > 9.0d) {
                        double d13 = 3.0d / dHypot;
                        double[] dArr6 = dArr4[i11];
                        double[] dArr7 = dArr3[i11];
                        dArr6[i12] = d11 * d13 * dArr7[i12];
                        dArr4[i13][i12] = d13 * d12 * dArr7[i12];
                    }
                }
            }
        }
        this.f2877d = dArr;
        this.f2878e = dArr2;
        this.f2879f = dArr4;
    }

    public static k i(String str) {
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i7 = 0;
        while (iIndexOf2 != -1) {
            dArr[i7] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i7++;
        }
        dArr[i7] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        return j(Arrays.copyOf(dArr, i7 + 1));
    }

    private static k j(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d8 = 1.0d / ((double) length2);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i7 = 0; i7 < dArr.length; i7++) {
            double d9 = dArr[i7];
            int i8 = i7 + length2;
            dArr2[i8][0] = d9;
            double d10 = ((double) i7) * d8;
            dArr3[i8] = d10;
            if (i7 > 0) {
                int i9 = (length2 * 2) + i7;
                dArr2[i9][0] = d9 + 1.0d;
                dArr3[i9] = d10 + 1.0d;
                int i10 = i7 - 1;
                dArr2[i10][0] = (d9 - 1.0d) - d8;
                dArr3[i10] = (d10 - 1.0d) - d8;
            }
        }
        return new k(dArr3, dArr2);
    }

    private static double k(double d8, double d9, double d10, double d11, double d12, double d13) {
        double d14 = d9 * d9;
        double d15 = d9 * 6.0d;
        double d16 = 3.0d * d8;
        return ((((((((((-6.0d) * d14) * d11) + (d15 * d11)) + ((6.0d * d14) * d10)) - (d15 * d10)) + ((d16 * d13) * d14)) + ((d16 * d12) * d14)) - (((2.0d * d8) * d13) * d9)) - (((4.0d * d8) * d12) * d9)) + (d8 * d12);
    }

    private static double l(double d8, double d9, double d10, double d11, double d12, double d13) {
        double d14 = d9 * d9;
        double d15 = d14 * d9;
        double d16 = 3.0d * d14;
        double d17 = ((((((-2.0d) * d15) * d11) + (d16 * d11)) + ((d15 * 2.0d) * d10)) - (d16 * d10)) + d10;
        double d18 = d8 * d13;
        double d19 = d8 * d12;
        return ((((d17 + (d18 * d15)) + (d15 * d19)) - (d18 * d14)) - (((d8 * 2.0d) * d12) * d14)) + (d19 * d9);
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double c(double d8, int i7) {
        double d9;
        double d10;
        double dF;
        double[] dArr = this.f2877d;
        int length = dArr.length;
        int i8 = 0;
        if (this.f2880g) {
            double d11 = dArr[0];
            if (d8 <= d11) {
                d9 = this.f2878e[0][i7];
                d10 = d8 - d11;
                dF = f(d11, i7);
            } else {
                int i9 = length - 1;
                double d12 = dArr[i9];
                if (d8 >= d12) {
                    d9 = this.f2878e[i9][i7];
                    d10 = d8 - d12;
                    dF = f(d12, i7);
                }
            }
            return d9 + (d10 * dF);
        }
        if (d8 <= dArr[0]) {
            return this.f2878e[0][i7];
        }
        int i10 = length - 1;
        if (d8 >= dArr[i10]) {
            return this.f2878e[i10][i7];
        }
        while (i8 < length - 1) {
            double[] dArr2 = this.f2877d;
            double d13 = dArr2[i8];
            if (d8 == d13) {
                return this.f2878e[i8][i7];
            }
            int i11 = i8 + 1;
            double d14 = dArr2[i11];
            if (d8 < d14) {
                double d15 = d14 - d13;
                double d16 = (d8 - d13) / d15;
                double[][] dArr3 = this.f2878e;
                double d17 = dArr3[i8][i7];
                double d18 = dArr3[i11][i7];
                double[][] dArr4 = this.f2879f;
                return l(d15, d16, d17, d18, dArr4[i8][i7], dArr4[i11][i7]);
            }
            i8 = i11;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void d(double d8, double[] dArr) {
        double[] dArr2 = this.f2877d;
        int length = dArr2.length;
        int i7 = 0;
        int length2 = this.f2878e[0].length;
        if (this.f2880g) {
            double d9 = dArr2[0];
            if (d8 <= d9) {
                g(d9, this.f2881h);
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.f2878e[0][i8] + ((d8 - this.f2877d[0]) * this.f2881h[i8]);
                }
                return;
            }
            int i9 = length - 1;
            double d10 = dArr2[i9];
            if (d8 >= d10) {
                g(d10, this.f2881h);
                while (i7 < length2) {
                    dArr[i7] = this.f2878e[i9][i7] + ((d8 - this.f2877d[i9]) * this.f2881h[i7]);
                    i7++;
                }
                return;
            }
        } else {
            if (d8 <= dArr2[0]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    dArr[i10] = this.f2878e[0][i10];
                }
                return;
            }
            int i11 = length - 1;
            if (d8 >= dArr2[i11]) {
                while (i7 < length2) {
                    dArr[i7] = this.f2878e[i11][i7];
                    i7++;
                }
                return;
            }
        }
        int i12 = 0;
        while (i12 < length - 1) {
            if (d8 == this.f2877d[i12]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    dArr[i13] = this.f2878e[i12][i13];
                }
            }
            double[] dArr3 = this.f2877d;
            int i14 = i12 + 1;
            double d11 = dArr3[i14];
            if (d8 < d11) {
                double d12 = dArr3[i12];
                double d13 = d11 - d12;
                double d14 = (d8 - d12) / d13;
                while (i7 < length2) {
                    double[][] dArr4 = this.f2878e;
                    double d15 = dArr4[i12][i7];
                    double d16 = dArr4[i14][i7];
                    double[][] dArr5 = this.f2879f;
                    dArr[i7] = l(d13, d14, d15, d16, dArr5[i12][i7], dArr5[i14][i7]);
                    i7++;
                }
                return;
            }
            i12 = i14;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void e(double d8, float[] fArr) {
        double[] dArr = this.f2877d;
        int length = dArr.length;
        int i7 = 0;
        int length2 = this.f2878e[0].length;
        if (this.f2880g) {
            double d9 = dArr[0];
            if (d8 <= d9) {
                g(d9, this.f2881h);
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) (this.f2878e[0][i8] + ((d8 - this.f2877d[0]) * this.f2881h[i8]));
                }
                return;
            }
            int i9 = length - 1;
            double d10 = dArr[i9];
            if (d8 >= d10) {
                g(d10, this.f2881h);
                while (i7 < length2) {
                    fArr[i7] = (float) (this.f2878e[i9][i7] + ((d8 - this.f2877d[i9]) * this.f2881h[i7]));
                    i7++;
                }
                return;
            }
        } else {
            if (d8 <= dArr[0]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    fArr[i10] = (float) this.f2878e[0][i10];
                }
                return;
            }
            int i11 = length - 1;
            if (d8 >= dArr[i11]) {
                while (i7 < length2) {
                    fArr[i7] = (float) this.f2878e[i11][i7];
                    i7++;
                }
                return;
            }
        }
        int i12 = 0;
        while (i12 < length - 1) {
            if (d8 == this.f2877d[i12]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    fArr[i13] = (float) this.f2878e[i12][i13];
                }
            }
            double[] dArr2 = this.f2877d;
            int i14 = i12 + 1;
            double d11 = dArr2[i14];
            if (d8 < d11) {
                double d12 = dArr2[i12];
                double d13 = d11 - d12;
                double d14 = (d8 - d12) / d13;
                while (i7 < length2) {
                    double[][] dArr3 = this.f2878e;
                    double d15 = dArr3[i12][i7];
                    double d16 = dArr3[i14][i7];
                    double[][] dArr4 = this.f2879f;
                    fArr[i7] = (float) l(d13, d14, d15, d16, dArr4[i12][i7], dArr4[i14][i7]);
                    i7++;
                }
                return;
            }
            i12 = i14;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double f(double d8, int i7) {
        double[] dArr = this.f2877d;
        int length = dArr.length;
        int i8 = 0;
        double d9 = dArr[0];
        if (d8 >= d9) {
            d9 = dArr[length - 1];
            if (d8 < d9) {
                d9 = d8;
            }
        }
        while (i8 < length - 1) {
            double[] dArr2 = this.f2877d;
            int i9 = i8 + 1;
            double d10 = dArr2[i9];
            if (d9 <= d10) {
                double d11 = dArr2[i8];
                double d12 = d10 - d11;
                double[][] dArr3 = this.f2878e;
                double d13 = dArr3[i8][i7];
                double d14 = dArr3[i9][i7];
                double[][] dArr4 = this.f2879f;
                return k(d12, (d9 - d11) / d12, d13, d14, dArr4[i8][i7], dArr4[i9][i7]) / d12;
            }
            i8 = i9;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void g(double d8, double[] dArr) {
        double[] dArr2 = this.f2877d;
        int length = dArr2.length;
        int length2 = this.f2878e[0].length;
        double d9 = dArr2[0];
        if (d8 > d9) {
            d9 = dArr2[length - 1];
            if (d8 < d9) {
                d9 = d8;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            double[] dArr3 = this.f2877d;
            int i8 = i7 + 1;
            double d10 = dArr3[i8];
            if (d9 <= d10) {
                double d11 = dArr3[i7];
                double d12 = d10 - d11;
                double d13 = (d9 - d11) / d12;
                for (int i9 = 0; i9 < length2; i9++) {
                    double[][] dArr4 = this.f2878e;
                    double d14 = dArr4[i7][i9];
                    double d15 = dArr4[i8][i9];
                    double[][] dArr5 = this.f2879f;
                    dArr[i9] = k(d12, d13, d14, d15, dArr5[i7][i9], dArr5[i8][i9]) / d12;
                }
                return;
            }
            i7 = i8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double[] h() {
        return this.f2877d;
    }
}
