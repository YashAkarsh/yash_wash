package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f2737g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f2738h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2739i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f2740j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f2741k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f2742l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f2743m = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double[] f2744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    C0038a[] f2745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2746f = true;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.motion.utils.a$a, reason: collision with other inner class name */
    private static class C0038a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final String f2747s = "Arc";

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static double[] f2748t = new double[91];

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final double f2749u = 0.001d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double[] f2750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f2751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f2752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double f2753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        double f2754e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        double f2755f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        double f2756g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        double f2757h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        double f2758i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        double f2759j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        double f2760k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        double f2761l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        double f2762m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        double f2763n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        double f2764o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        double f2765p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f2766q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f2767r;

        C0038a(int i7, double d8, double d9, double d10, double d11, double d12, double d13) {
            this.f2767r = false;
            this.f2766q = i7 == 1;
            this.f2752c = d8;
            this.f2753d = d9;
            this.f2758i = 1.0d / (d9 - d8);
            if (3 == i7) {
                this.f2767r = true;
            }
            double d14 = d12 - d10;
            double d15 = d13 - d11;
            if (!this.f2767r && Math.abs(d14) >= f2749u && Math.abs(d15) >= f2749u) {
                this.f2750a = new double[101];
                boolean z7 = this.f2766q;
                this.f2759j = d14 * ((double) (z7 ? -1 : 1));
                this.f2760k = d15 * ((double) (z7 ? 1 : -1));
                this.f2761l = z7 ? d12 : d10;
                this.f2762m = z7 ? d11 : d13;
                a(d10, d11, d12, d13);
                this.f2763n = this.f2751b * this.f2758i;
                return;
            }
            this.f2767r = true;
            this.f2754e = d10;
            this.f2755f = d12;
            this.f2756g = d11;
            this.f2757h = d13;
            double dHypot = Math.hypot(d15, d14);
            this.f2751b = dHypot;
            this.f2763n = dHypot * this.f2758i;
            double d16 = this.f2753d;
            double d17 = this.f2752c;
            this.f2761l = d14 / (d16 - d17);
            this.f2762m = d15 / (d16 - d17);
        }

        private void a(double d8, double d9, double d10, double d11) {
            double dHypot;
            double d12 = d10 - d8;
            double d13 = d9 - d11;
            int i7 = 0;
            double d14 = 0.0d;
            double d15 = 0.0d;
            double d16 = 0.0d;
            while (true) {
                double[] dArr = f2748t;
                if (i7 >= dArr.length) {
                    break;
                }
                double d17 = d14;
                double radians = Math.toRadians((((double) i7) * 90.0d) / ((double) (dArr.length - 1)));
                double dSin = Math.sin(radians) * d12;
                double dCos = Math.cos(radians) * d13;
                if (i7 > 0) {
                    dHypot = Math.hypot(dSin - d15, dCos - d16) + d17;
                    f2748t[i7] = dHypot;
                } else {
                    dHypot = d17;
                }
                i7++;
                d16 = dCos;
                d14 = dHypot;
                d15 = dSin;
            }
            double d18 = d14;
            this.f2751b = d18;
            int i8 = 0;
            while (true) {
                double[] dArr2 = f2748t;
                if (i8 >= dArr2.length) {
                    break;
                }
                dArr2[i8] = dArr2[i8] / d18;
                i8++;
            }
            int i9 = 0;
            while (true) {
                double[] dArr3 = this.f2750a;
                if (i9 >= dArr3.length) {
                    return;
                }
                double length = ((double) i9) / ((double) (dArr3.length - 1));
                int iBinarySearch = Arrays.binarySearch(f2748t, length);
                if (iBinarySearch >= 0) {
                    this.f2750a[i9] = ((double) iBinarySearch) / ((double) (f2748t.length - 1));
                } else if (iBinarySearch == -1) {
                    this.f2750a[i9] = 0.0d;
                } else {
                    int i10 = -iBinarySearch;
                    int i11 = i10 - 2;
                    double[] dArr4 = f2748t;
                    double d19 = dArr4[i11];
                    this.f2750a[i9] = (((double) i11) + ((length - d19) / (dArr4[i10 - 1] - d19))) / ((double) (dArr4.length - 1));
                }
                i9++;
            }
        }

        double b() {
            double d8 = this.f2759j * this.f2765p;
            double dHypot = this.f2763n / Math.hypot(d8, (-this.f2760k) * this.f2764o);
            if (this.f2766q) {
                d8 = -d8;
            }
            return d8 * dHypot;
        }

        double c() {
            double d8 = this.f2759j * this.f2765p;
            double d9 = (-this.f2760k) * this.f2764o;
            double dHypot = this.f2763n / Math.hypot(d8, d9);
            return this.f2766q ? (-d9) * dHypot : d9 * dHypot;
        }

        public double d(double d8) {
            return this.f2761l;
        }

        public double e(double d8) {
            return this.f2762m;
        }

        public double f(double d8) {
            double d9 = (d8 - this.f2752c) * this.f2758i;
            double d10 = this.f2754e;
            return d10 + (d9 * (this.f2755f - d10));
        }

        public double g(double d8) {
            double d9 = (d8 - this.f2752c) * this.f2758i;
            double d10 = this.f2756g;
            return d10 + (d9 * (this.f2757h - d10));
        }

        double h() {
            return this.f2761l + (this.f2759j * this.f2764o);
        }

        double i() {
            return this.f2762m + (this.f2760k * this.f2765p);
        }

        double j(double d8) {
            if (d8 <= 0.0d) {
                return 0.0d;
            }
            if (d8 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f2750a;
            double length = d8 * ((double) (dArr.length - 1));
            int i7 = (int) length;
            double d9 = length - ((double) i7);
            double d10 = dArr[i7];
            return d10 + (d9 * (dArr[i7 + 1] - d10));
        }

        void k(double d8) {
            double dJ = j((this.f2766q ? this.f2753d - d8 : d8 - this.f2752c) * this.f2758i) * 1.5707963267948966d;
            this.f2764o = Math.sin(dJ);
            this.f2765p = Math.cos(dJ);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c  */
    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        this.f2744d = dArr;
        this.f2745e = new C0038a[dArr.length - 1];
        int i7 = 1;
        int i8 = 1;
        int i9 = 0;
        while (true) {
            C0038a[] c0038aArr = this.f2745e;
            if (i9 >= c0038aArr.length) {
                return;
            }
            int i10 = iArr[i9];
            if (i10 == 0) {
                i8 = 3;
            } else if (i10 == 1) {
                i7 = 1;
                i8 = i7;
            } else {
                if (i10 != 2) {
                    if (i10 == 3) {
                        if (i7 != 1) {
                            i7 = 1;
                        }
                        i8 = i7;
                    }
                }
                i7 = 2;
                i8 = i7;
            }
            double d8 = dArr[i9];
            int i11 = i9 + 1;
            double d9 = dArr[i11];
            double[] dArr3 = dArr2[i9];
            double d10 = dArr3[0];
            double d11 = dArr3[1];
            double[] dArr4 = dArr2[i11];
            c0038aArr[i9] = new C0038a(i8, d8, d9, d10, d11, dArr4[0], dArr4[1]);
            i9 = i11;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double c(double d8, int i7) {
        double dG;
        double dE;
        double dI;
        double dC;
        double dG2;
        double dE2;
        int i8 = 0;
        if (this.f2746f) {
            C0038a[] c0038aArr = this.f2745e;
            C0038a c0038a = c0038aArr[0];
            double d9 = c0038a.f2752c;
            if (d8 < d9) {
                double d10 = d8 - d9;
                if (c0038a.f2767r) {
                    if (i7 == 0) {
                        dG2 = c0038a.f(d9);
                        dE2 = this.f2745e[0].d(d9);
                    } else {
                        dG2 = c0038a.g(d9);
                        dE2 = this.f2745e[0].e(d9);
                    }
                    return dG2 + (d10 * dE2);
                }
                c0038a.k(d9);
                if (i7 == 0) {
                    dI = this.f2745e[0].h();
                    dC = this.f2745e[0].b();
                } else {
                    dI = this.f2745e[0].i();
                    dC = this.f2745e[0].c();
                }
                return dI + (d10 * dC);
            }
            if (d8 > c0038aArr[c0038aArr.length - 1].f2753d) {
                double d11 = c0038aArr[c0038aArr.length - 1].f2753d;
                double d12 = d8 - d11;
                int length = c0038aArr.length - 1;
                if (i7 == 0) {
                    dG = c0038aArr[length].f(d11);
                    dE = this.f2745e[length].d(d11);
                } else {
                    dG = c0038aArr[length].g(d11);
                    dE = this.f2745e[length].e(d11);
                }
                return dG + (d12 * dE);
            }
        } else {
            C0038a[] c0038aArr2 = this.f2745e;
            double d13 = c0038aArr2[0].f2752c;
            if (d8 < d13) {
                d8 = d13;
            } else if (d8 > c0038aArr2[c0038aArr2.length - 1].f2753d) {
                d8 = c0038aArr2[c0038aArr2.length - 1].f2753d;
            }
        }
        while (true) {
            C0038a[] c0038aArr3 = this.f2745e;
            if (i8 >= c0038aArr3.length) {
                return Double.NaN;
            }
            C0038a c0038a2 = c0038aArr3[i8];
            if (d8 <= c0038a2.f2753d) {
                if (c0038a2.f2767r) {
                    return i7 == 0 ? c0038a2.f(d8) : c0038a2.g(d8);
                }
                c0038a2.k(d8);
                return i7 == 0 ? this.f2745e[i8].h() : this.f2745e[i8].i();
            }
            i8++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void d(double d8, double[] dArr) {
        if (this.f2746f) {
            C0038a[] c0038aArr = this.f2745e;
            C0038a c0038a = c0038aArr[0];
            double d9 = c0038a.f2752c;
            if (d8 < d9) {
                double d10 = d8 - d9;
                if (c0038a.f2767r) {
                    dArr[0] = c0038a.f(d9) + (this.f2745e[0].d(d9) * d10);
                    dArr[1] = this.f2745e[0].g(d9) + (d10 * this.f2745e[0].e(d9));
                    return;
                } else {
                    c0038a.k(d9);
                    dArr[0] = this.f2745e[0].h() + (this.f2745e[0].b() * d10);
                    dArr[1] = this.f2745e[0].i() + (d10 * this.f2745e[0].c());
                    return;
                }
            }
            if (d8 > c0038aArr[c0038aArr.length - 1].f2753d) {
                double d11 = c0038aArr[c0038aArr.length - 1].f2753d;
                double d12 = d8 - d11;
                int length = c0038aArr.length - 1;
                C0038a c0038a2 = c0038aArr[length];
                if (c0038a2.f2767r) {
                    dArr[0] = c0038a2.f(d11) + (this.f2745e[length].d(d11) * d12);
                    dArr[1] = this.f2745e[length].g(d11) + (d12 * this.f2745e[length].e(d11));
                    return;
                } else {
                    c0038a2.k(d8);
                    dArr[0] = this.f2745e[length].h() + (this.f2745e[length].b() * d12);
                    dArr[1] = this.f2745e[length].i() + (d12 * this.f2745e[length].c());
                    return;
                }
            }
        } else {
            C0038a[] c0038aArr2 = this.f2745e;
            double d13 = c0038aArr2[0].f2752c;
            if (d8 < d13) {
                d8 = d13;
            }
            if (d8 > c0038aArr2[c0038aArr2.length - 1].f2753d) {
                d8 = c0038aArr2[c0038aArr2.length - 1].f2753d;
            }
        }
        int i7 = 0;
        while (true) {
            C0038a[] c0038aArr3 = this.f2745e;
            if (i7 >= c0038aArr3.length) {
                return;
            }
            C0038a c0038a3 = c0038aArr3[i7];
            if (d8 <= c0038a3.f2753d) {
                if (c0038a3.f2767r) {
                    dArr[0] = c0038a3.f(d8);
                    dArr[1] = this.f2745e[i7].g(d8);
                    return;
                } else {
                    c0038a3.k(d8);
                    dArr[0] = this.f2745e[i7].h();
                    dArr[1] = this.f2745e[i7].i();
                    return;
                }
            }
            i7++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void e(double d8, float[] fArr) {
        if (this.f2746f) {
            C0038a[] c0038aArr = this.f2745e;
            C0038a c0038a = c0038aArr[0];
            double d9 = c0038a.f2752c;
            if (d8 < d9) {
                double d10 = d8 - d9;
                if (c0038a.f2767r) {
                    fArr[0] = (float) (c0038a.f(d9) + (this.f2745e[0].d(d9) * d10));
                    fArr[1] = (float) (this.f2745e[0].g(d9) + (d10 * this.f2745e[0].e(d9)));
                    return;
                } else {
                    c0038a.k(d9);
                    fArr[0] = (float) (this.f2745e[0].h() + (this.f2745e[0].b() * d10));
                    fArr[1] = (float) (this.f2745e[0].i() + (d10 * this.f2745e[0].c()));
                    return;
                }
            }
            if (d8 > c0038aArr[c0038aArr.length - 1].f2753d) {
                double d11 = c0038aArr[c0038aArr.length - 1].f2753d;
                double d12 = d8 - d11;
                int length = c0038aArr.length - 1;
                C0038a c0038a2 = c0038aArr[length];
                if (c0038a2.f2767r) {
                    fArr[0] = (float) (c0038a2.f(d11) + (this.f2745e[length].d(d11) * d12));
                    fArr[1] = (float) (this.f2745e[length].g(d11) + (d12 * this.f2745e[length].e(d11)));
                    return;
                } else {
                    c0038a2.k(d8);
                    fArr[0] = (float) this.f2745e[length].h();
                    fArr[1] = (float) this.f2745e[length].i();
                    return;
                }
            }
        } else {
            C0038a[] c0038aArr2 = this.f2745e;
            double d13 = c0038aArr2[0].f2752c;
            if (d8 < d13) {
                d8 = d13;
            } else if (d8 > c0038aArr2[c0038aArr2.length - 1].f2753d) {
                d8 = c0038aArr2[c0038aArr2.length - 1].f2753d;
            }
        }
        int i7 = 0;
        while (true) {
            C0038a[] c0038aArr3 = this.f2745e;
            if (i7 >= c0038aArr3.length) {
                return;
            }
            C0038a c0038a3 = c0038aArr3[i7];
            if (d8 <= c0038a3.f2753d) {
                if (c0038a3.f2767r) {
                    fArr[0] = (float) c0038a3.f(d8);
                    fArr[1] = (float) this.f2745e[i7].g(d8);
                    return;
                } else {
                    c0038a3.k(d8);
                    fArr[0] = (float) this.f2745e[i7].h();
                    fArr[1] = (float) this.f2745e[i7].i();
                    return;
                }
            }
            i7++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double f(double d8, int i7) {
        C0038a[] c0038aArr = this.f2745e;
        int i8 = 0;
        double d9 = c0038aArr[0].f2752c;
        if (d8 < d9) {
            d8 = d9;
        }
        if (d8 > c0038aArr[c0038aArr.length - 1].f2753d) {
            d8 = c0038aArr[c0038aArr.length - 1].f2753d;
        }
        while (true) {
            C0038a[] c0038aArr2 = this.f2745e;
            if (i8 >= c0038aArr2.length) {
                return Double.NaN;
            }
            C0038a c0038a = c0038aArr2[i8];
            if (d8 <= c0038a.f2753d) {
                if (c0038a.f2767r) {
                    return i7 == 0 ? c0038a.d(d8) : c0038a.e(d8);
                }
                c0038a.k(d8);
                return i7 == 0 ? this.f2745e[i8].b() : this.f2745e[i8].c();
            }
            i8++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void g(double d8, double[] dArr) {
        C0038a[] c0038aArr = this.f2745e;
        double d9 = c0038aArr[0].f2752c;
        if (d8 < d9) {
            d8 = d9;
        } else if (d8 > c0038aArr[c0038aArr.length - 1].f2753d) {
            d8 = c0038aArr[c0038aArr.length - 1].f2753d;
        }
        int i7 = 0;
        while (true) {
            C0038a[] c0038aArr2 = this.f2745e;
            if (i7 >= c0038aArr2.length) {
                return;
            }
            C0038a c0038a = c0038aArr2[i7];
            if (d8 <= c0038a.f2753d) {
                if (c0038a.f2767r) {
                    dArr[0] = c0038a.d(d8);
                    dArr[1] = this.f2745e[i7].e(d8);
                    return;
                } else {
                    c0038a.k(d8);
                    dArr[0] = this.f2745e[i7].b();
                    dArr[1] = this.f2745e[i7].c();
                    return;
                }
            }
            i7++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double[] h() {
        return this.f2744d;
    }
}
