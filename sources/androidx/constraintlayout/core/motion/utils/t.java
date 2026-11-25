package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f2951k = "SplineSet";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected static final int f2952l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected static final int f2953m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static final int f2954n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected static float f2955o = 6.2831855f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected androidx.constraintlayout.core.motion.utils.b f2956a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f2960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f2961f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected long f2964i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f2957b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int[] f2958c = new int[10];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float[][] f2959d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected float[] f2962g = new float[3];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f2963h = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected float f2965j = Float.NaN;

    public static class a extends t {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        String f2966p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        i.a f2967q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        i.c f2968r = new i.c();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        float[] f2969s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        float[] f2970t;

        public a(String str, i.a aVar) {
            this.f2966p = str.split(",")[1];
            this.f2967q = aVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.t
        public void c(int i7, float f8, float f9, int i8, float f10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.t
        public void f(int i7) {
            int iF = this.f2967q.f();
            int iH = this.f2967q.g(0).h();
            double[] dArr = new double[iF];
            int i8 = iH + 2;
            this.f2969s = new float[i8];
            this.f2970t = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iF, i8);
            for (int i9 = 0; i9 < iF; i9++) {
                int iD = this.f2967q.d(i9);
                androidx.constraintlayout.core.motion.a aVarG = this.f2967q.g(i9);
                float[] fArrG = this.f2968r.g(i9);
                dArr[i9] = ((double) iD) * 0.01d;
                aVarG.e(this.f2969s);
                int i10 = 0;
                while (true) {
                    float[] fArr = this.f2969s;
                    if (i10 < fArr.length) {
                        dArr2[i9][i10] = fArr[i10];
                        i10++;
                    }
                }
                double[] dArr3 = dArr2[i9];
                dArr3[iH] = fArrG[0];
                dArr3[iH + 1] = fArrG[1];
            }
            this.f2956a = androidx.constraintlayout.core.motion.utils.b.a(i7, dArr, dArr2);
        }

        public void g(int i7, androidx.constraintlayout.core.motion.a aVar, float f8, int i8, float f9) {
            this.f2967q.a(i7, aVar);
            this.f2968r.a(i7, new float[]{f8, f9});
            this.f2957b = Math.max(this.f2957b, i8);
        }

        public boolean h(androidx.constraintlayout.core.motion.f fVar, float f8, long j7, g gVar) {
            this.f2956a.e(f8, this.f2969s);
            float[] fArr = this.f2969s;
            float f9 = fArr[fArr.length - 2];
            float f10 = fArr[fArr.length - 1];
            long j8 = j7 - this.f2964i;
            if (Float.isNaN(this.f2965j)) {
                float fA = gVar.a(fVar, this.f2966p, 0);
                this.f2965j = fA;
                if (Float.isNaN(fA)) {
                    this.f2965j = 0.0f;
                }
            }
            float f11 = (float) ((((double) this.f2965j) + ((j8 * 1.0E-9d) * ((double) f9))) % 1.0d);
            this.f2965j = f11;
            this.f2964i = j7;
            float fA2 = a(f11);
            this.f2963h = false;
            int i7 = 0;
            while (true) {
                float[] fArr2 = this.f2970t;
                if (i7 >= fArr2.length) {
                    break;
                }
                boolean z7 = this.f2963h;
                float f12 = this.f2969s[i7];
                this.f2963h = z7 | (((double) f12) != 0.0d);
                fArr2[i7] = (f12 * fA2) + f10;
                i7++;
            }
            fVar.M(this.f2967q.g(0), this.f2970t);
            if (f9 != 0.0f) {
                this.f2963h = true;
            }
            return this.f2963h;
        }
    }

    public static class b extends t {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        String f2971p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        i.b f2972q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        i.c f2973r = new i.c();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        float[] f2974s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        float[] f2975t;

        public b(String str, i.b bVar) {
            this.f2971p = str.split(",")[1];
            this.f2972q = bVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.t
        public void c(int i7, float f8, float f9, int i8, float f10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.t
        public void f(int i7) {
            int iF = this.f2972q.f();
            int iR = this.f2972q.g(0).r();
            double[] dArr = new double[iF];
            int i8 = iR + 2;
            this.f2974s = new float[i8];
            this.f2975t = new float[iR];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iF, i8);
            for (int i9 = 0; i9 < iF; i9++) {
                int iD = this.f2972q.d(i9);
                androidx.constraintlayout.core.motion.b bVarG = this.f2972q.g(i9);
                float[] fArrG = this.f2973r.g(i9);
                dArr[i9] = ((double) iD) * 0.01d;
                bVarG.o(this.f2974s);
                int i10 = 0;
                while (true) {
                    float[] fArr = this.f2974s;
                    if (i10 < fArr.length) {
                        dArr2[i9][i10] = fArr[i10];
                        i10++;
                    }
                }
                double[] dArr3 = dArr2[i9];
                dArr3[iR] = fArrG[0];
                dArr3[iR + 1] = fArrG[1];
            }
            this.f2956a = androidx.constraintlayout.core.motion.utils.b.a(i7, dArr, dArr2);
        }

        public void g(int i7, androidx.constraintlayout.core.motion.b bVar, float f8, int i8, float f9) {
            this.f2972q.a(i7, bVar);
            this.f2973r.a(i7, new float[]{f8, f9});
            this.f2957b = Math.max(this.f2957b, i8);
        }

        public boolean h(androidx.constraintlayout.core.motion.f fVar, float f8, long j7, g gVar) {
            this.f2956a.e(f8, this.f2974s);
            float[] fArr = this.f2974s;
            float f9 = fArr[fArr.length - 2];
            float f10 = fArr[fArr.length - 1];
            long j8 = j7 - this.f2964i;
            if (Float.isNaN(this.f2965j)) {
                float fA = gVar.a(fVar, this.f2971p, 0);
                this.f2965j = fA;
                if (Float.isNaN(fA)) {
                    this.f2965j = 0.0f;
                }
            }
            float f11 = (float) ((((double) this.f2965j) + ((j8 * 1.0E-9d) * ((double) f9))) % 1.0d);
            this.f2965j = f11;
            this.f2964i = j7;
            float fA2 = a(f11);
            this.f2963h = false;
            int i7 = 0;
            while (true) {
                float[] fArr2 = this.f2975t;
                if (i7 >= fArr2.length) {
                    break;
                }
                boolean z7 = this.f2963h;
                float f12 = this.f2974s[i7];
                this.f2963h = z7 | (((double) f12) != 0.0d);
                fArr2[i7] = (f12 * fA2) + f10;
                i7++;
            }
            this.f2972q.g(0).w(fVar, this.f2975t);
            if (f9 != 0.0f) {
                this.f2963h = true;
            }
            return this.f2963h;
        }
    }

    protected static class c {
        protected c() {
        }

        static void a(int[] iArr, float[][] fArr, int i7, int i8) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i8;
            iArr2[1] = i7;
            int i9 = 2;
            while (i9 > 0) {
                int i10 = i9 - 1;
                int i11 = iArr2[i10];
                i9 = i10 - 1;
                int i12 = iArr2[i9];
                if (i11 < i12) {
                    int iB = b(iArr, fArr, i11, i12);
                    int i13 = i9 + 1;
                    iArr2[i9] = iB - 1;
                    int i14 = i13 + 1;
                    iArr2[i13] = i11;
                    int i15 = i14 + 1;
                    iArr2[i14] = i12;
                    i9 = i15 + 1;
                    iArr2[i15] = iB + 1;
                }
            }
        }

        private static int b(int[] iArr, float[][] fArr, int i7, int i8) {
            int i9 = iArr[i8];
            int i10 = i7;
            while (i7 < i8) {
                if (iArr[i7] <= i9) {
                    c(iArr, fArr, i10, i7);
                    i10++;
                }
                i7++;
            }
            c(iArr, fArr, i10, i8);
            return i10;
        }

        private static void c(int[] iArr, float[][] fArr, int i7, int i8) {
            int i9 = iArr[i7];
            iArr[i7] = iArr[i8];
            iArr[i8] = i9;
            float[] fArr2 = fArr[i7];
            fArr[i7] = fArr[i8];
            fArr[i8] = fArr2;
        }
    }

    protected float a(float f8) {
        float fAbs;
        switch (this.f2957b) {
            case 1:
                return Math.signum(f8 * f2955o);
            case 2:
                fAbs = Math.abs(f8);
                break;
            case 3:
                return (((f8 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                fAbs = ((f8 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f8 * f2955o);
            case 6:
                float fAbs2 = 1.0f - Math.abs(((f8 * 4.0f) % 4.0f) - 2.0f);
                fAbs = fAbs2 * fAbs2;
                break;
            default:
                return (float) Math.sin(f8 * f2955o);
        }
        return 1.0f - fAbs;
    }

    public androidx.constraintlayout.core.motion.utils.b b() {
        return this.f2956a;
    }

    public void c(int i7, float f8, float f9, int i8, float f10) {
        int[] iArr = this.f2958c;
        int i9 = this.f2960e;
        iArr[i9] = i7;
        float[] fArr = this.f2959d[i9];
        fArr[0] = f8;
        fArr[1] = f9;
        fArr[2] = f10;
        this.f2957b = Math.max(this.f2957b, i8);
        this.f2960e++;
    }

    protected void d(long j7) {
        this.f2964i = j7;
    }

    public void e(String str) {
        this.f2961f = str;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0063  */
    public void f(int i7) {
        int i8 = this.f2960e;
        if (i8 == 0) {
            System.err.println("Error no points added to " + this.f2961f);
            return;
        }
        c.a(this.f2958c, this.f2959d, 0, i8 - 1);
        int i9 = 1;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2958c;
            if (i9 >= iArr.length) {
                break;
            }
            if (iArr[i9] != iArr[i9 - 1]) {
                i10++;
            }
            i9++;
        }
        if (i10 == 0) {
            i10 = 1;
        }
        double[] dArr = new double[i10];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i10, 3);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f2960e; i12++) {
            if (i12 > 0) {
                int[] iArr2 = this.f2958c;
                if (iArr2[i12] != iArr2[i12 - 1]) {
                    dArr[i11] = ((double) this.f2958c[i12]) * 0.01d;
                    double[] dArr3 = dArr2[i11];
                    float[] fArr = this.f2959d[i12];
                    dArr3[0] = fArr[0];
                    dArr3[1] = fArr[1];
                    dArr3[2] = fArr[2];
                    i11++;
                }
            } else {
                dArr[i11] = ((double) this.f2958c[i12]) * 0.01d;
                double[] dArr4 = dArr2[i11];
                float[] fArr2 = this.f2959d[i12];
                dArr4[0] = fArr2[0];
                dArr4[1] = fArr2[1];
                dArr4[2] = fArr2[2];
                i11++;
            }
        }
        this.f2956a = androidx.constraintlayout.core.motion.utils.b.a(i7, dArr, dArr2);
    }

    public String toString() {
        String str = this.f2961f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i7 = 0; i7 < this.f2960e; i7++) {
            str = str + "[" + this.f2958c[i7] + " , " + decimalFormat.format(this.f2959d[i7]) + "] ";
        }
        return str;
    }
}
