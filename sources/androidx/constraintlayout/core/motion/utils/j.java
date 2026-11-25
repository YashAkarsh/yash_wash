package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class j extends b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f2870i = "LinearCurveFit";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double[] f2871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double[][] f2872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f2873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2874g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    double[] f2875h;

    public j(double[] dArr, double[][] dArr2) {
        this.f2873f = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f2875h = new double[length2];
        this.f2871d = dArr;
        this.f2872e = dArr2;
        if (length2 <= 2) {
            return;
        }
        int i7 = 0;
        double d8 = 0.0d;
        while (true) {
            double d9 = d8;
            if (i7 >= dArr.length) {
                this.f2873f = 0.0d;
                return;
            }
            double d10 = dArr2[i7][0];
            if (i7 > 0) {
                Math.hypot(d10 - d8, d10 - d9);
            }
            i7++;
            d8 = d10;
        }
    }

    private double i(double d8) {
        if (Double.isNaN(this.f2873f)) {
            return 0.0d;
        }
        double[] dArr = this.f2871d;
        int length = dArr.length;
        if (d8 <= dArr[0]) {
            return 0.0d;
        }
        int i7 = length - 1;
        if (d8 >= dArr[i7]) {
            return this.f2873f;
        }
        double dHypot = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        int i8 = 0;
        while (i8 < i7) {
            double[] dArr2 = this.f2872e[i8];
            double d11 = dArr2[0];
            double d12 = dArr2[1];
            if (i8 > 0) {
                dHypot += Math.hypot(d11 - d9, d12 - d10);
            }
            double[] dArr3 = this.f2871d;
            double d13 = dArr3[i8];
            if (d8 == d13) {
                return dHypot;
            }
            int i9 = i8 + 1;
            double d14 = dArr3[i9];
            if (d8 < d14) {
                double d15 = (d8 - d13) / (d14 - d13);
                double[][] dArr4 = this.f2872e;
                double[] dArr5 = dArr4[i8];
                double d16 = dArr5[0];
                double[] dArr6 = dArr4[i9];
                double d17 = 1.0d - d15;
                return dHypot + Math.hypot(d12 - ((dArr5[1] * d17) + (dArr6[1] * d15)), d11 - ((d16 * d17) + (dArr6[0] * d15)));
            }
            i8 = i9;
            d9 = d11;
            d10 = d12;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double c(double d8, int i7) {
        double d9;
        double d10;
        double dF;
        double[] dArr = this.f2871d;
        int length = dArr.length;
        int i8 = 0;
        if (this.f2874g) {
            double d11 = dArr[0];
            if (d8 <= d11) {
                d9 = this.f2872e[0][i7];
                d10 = d8 - d11;
                dF = f(d11, i7);
            } else {
                int i9 = length - 1;
                double d12 = dArr[i9];
                if (d8 >= d12) {
                    d9 = this.f2872e[i9][i7];
                    d10 = d8 - d12;
                    dF = f(d12, i7);
                }
            }
            return d9 + (d10 * dF);
        }
        if (d8 <= dArr[0]) {
            return this.f2872e[0][i7];
        }
        int i10 = length - 1;
        if (d8 >= dArr[i10]) {
            return this.f2872e[i10][i7];
        }
        while (i8 < length - 1) {
            double[] dArr2 = this.f2871d;
            double d13 = dArr2[i8];
            if (d8 == d13) {
                return this.f2872e[i8][i7];
            }
            int i11 = i8 + 1;
            double d14 = dArr2[i11];
            if (d8 < d14) {
                double d15 = (d8 - d13) / (d14 - d13);
                double[][] dArr3 = this.f2872e;
                return (dArr3[i8][i7] * (1.0d - d15)) + (dArr3[i11][i7] * d15);
            }
            i8 = i11;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void d(double d8, double[] dArr) {
        double[] dArr2 = this.f2871d;
        int length = dArr2.length;
        int i7 = 0;
        int length2 = this.f2872e[0].length;
        if (this.f2874g) {
            double d9 = dArr2[0];
            if (d8 <= d9) {
                g(d9, this.f2875h);
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.f2872e[0][i8] + ((d8 - this.f2871d[0]) * this.f2875h[i8]);
                }
                return;
            }
            int i9 = length - 1;
            double d10 = dArr2[i9];
            if (d8 >= d10) {
                g(d10, this.f2875h);
                while (i7 < length2) {
                    dArr[i7] = this.f2872e[i9][i7] + ((d8 - this.f2871d[i9]) * this.f2875h[i7]);
                    i7++;
                }
                return;
            }
        } else {
            if (d8 <= dArr2[0]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    dArr[i10] = this.f2872e[0][i10];
                }
                return;
            }
            int i11 = length - 1;
            if (d8 >= dArr2[i11]) {
                while (i7 < length2) {
                    dArr[i7] = this.f2872e[i11][i7];
                    i7++;
                }
                return;
            }
        }
        int i12 = 0;
        while (i12 < length - 1) {
            if (d8 == this.f2871d[i12]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    dArr[i13] = this.f2872e[i12][i13];
                }
            }
            double[] dArr3 = this.f2871d;
            int i14 = i12 + 1;
            double d11 = dArr3[i14];
            if (d8 < d11) {
                double d12 = dArr3[i12];
                double d13 = (d8 - d12) / (d11 - d12);
                while (i7 < length2) {
                    double[][] dArr4 = this.f2872e;
                    dArr[i7] = (dArr4[i12][i7] * (1.0d - d13)) + (dArr4[i14][i7] * d13);
                    i7++;
                }
                return;
            }
            i12 = i14;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void e(double d8, float[] fArr) {
        double[] dArr = this.f2871d;
        int length = dArr.length;
        int i7 = 0;
        int length2 = this.f2872e[0].length;
        if (this.f2874g) {
            double d9 = dArr[0];
            if (d8 <= d9) {
                g(d9, this.f2875h);
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) (this.f2872e[0][i8] + ((d8 - this.f2871d[0]) * this.f2875h[i8]));
                }
                return;
            }
            int i9 = length - 1;
            double d10 = dArr[i9];
            if (d8 >= d10) {
                g(d10, this.f2875h);
                while (i7 < length2) {
                    fArr[i7] = (float) (this.f2872e[i9][i7] + ((d8 - this.f2871d[i9]) * this.f2875h[i7]));
                    i7++;
                }
                return;
            }
        } else {
            if (d8 <= dArr[0]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    fArr[i10] = (float) this.f2872e[0][i10];
                }
                return;
            }
            int i11 = length - 1;
            if (d8 >= dArr[i11]) {
                while (i7 < length2) {
                    fArr[i7] = (float) this.f2872e[i11][i7];
                    i7++;
                }
                return;
            }
        }
        int i12 = 0;
        while (i12 < length - 1) {
            if (d8 == this.f2871d[i12]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    fArr[i13] = (float) this.f2872e[i12][i13];
                }
            }
            double[] dArr2 = this.f2871d;
            int i14 = i12 + 1;
            double d11 = dArr2[i14];
            if (d8 < d11) {
                double d12 = dArr2[i12];
                double d13 = (d8 - d12) / (d11 - d12);
                while (i7 < length2) {
                    double[][] dArr3 = this.f2872e;
                    fArr[i7] = (float) ((dArr3[i12][i7] * (1.0d - d13)) + (dArr3[i14][i7] * d13));
                    i7++;
                }
                return;
            }
            i12 = i14;
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000a A[PHI: r3
      0x000a: PHI (r3v4 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.b
    public double f(double d8, int i7) {
        double[] dArr = this.f2871d;
        int length = dArr.length;
        int i8 = 0;
        double d9 = dArr[0];
        if (d8 < d9) {
            d8 = d9;
        } else {
            d9 = dArr[length - 1];
            if (d8 >= d9) {
                d8 = d9;
            }
        }
        while (i8 < length - 1) {
            double[] dArr2 = this.f2871d;
            int i9 = i8 + 1;
            double d10 = dArr2[i9];
            if (d8 <= d10) {
                double d11 = d10 - dArr2[i8];
                double[][] dArr3 = this.f2872e;
                return (dArr3[i9][i7] - dArr3[i8][i7]) / d11;
            }
            i8 = i9;
        }
        return 0.0d;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000f A[PHI: r4
      0x000f: PHI (r4v5 double) = (r4v0 double), (r4v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.b
    public void g(double d8, double[] dArr) {
        double[] dArr2 = this.f2871d;
        int length = dArr2.length;
        int length2 = this.f2872e[0].length;
        double d9 = dArr2[0];
        if (d8 <= d9) {
            d8 = d9;
        } else {
            d9 = dArr2[length - 1];
            if (d8 >= d9) {
                d8 = d9;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            double[] dArr3 = this.f2871d;
            int i8 = i7 + 1;
            double d10 = dArr3[i8];
            if (d8 <= d10) {
                double d11 = d10 - dArr3[i7];
                for (int i9 = 0; i9 < length2; i9++) {
                    double[][] dArr4 = this.f2872e;
                    dArr[i9] = (dArr4[i8][i9] - dArr4[i7][i9]) / d11;
                }
                return;
            }
            i7 = i8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double[] h() {
        return this.f2871d;
    }
}
