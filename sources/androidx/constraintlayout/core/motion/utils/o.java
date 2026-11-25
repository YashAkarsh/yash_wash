package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2907f = "SplineSet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected androidx.constraintlayout.core.motion.utils.b f2908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int[] f2909b = new int[10];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float[] f2910c = new float[10];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2912e;

    private static class a extends o {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f2913g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f2914h;

        public a(String str, long j7) {
            this.f2913g = str;
            this.f2914h = j7;
        }

        @Override // androidx.constraintlayout.core.motion.utils.o
        public void h(w wVar, float f8) {
            wVar.b(wVar.e(this.f2913g), a(f8));
        }
    }

    public static class b extends o {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f2915g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        i.a f2916h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float[] f2917i;

        public b(String str, i.a aVar) {
            this.f2915g = str.split(",")[1];
            this.f2916h = aVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.o
        public void g(int i7, float f8) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.o
        public void j(int i7) {
            int iF = this.f2916h.f();
            int iH = this.f2916h.g(0).h();
            double[] dArr = new double[iF];
            this.f2917i = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iF, iH);
            for (int i8 = 0; i8 < iF; i8++) {
                int iD = this.f2916h.d(i8);
                androidx.constraintlayout.core.motion.a aVarG = this.f2916h.g(i8);
                dArr[i8] = ((double) iD) * 0.01d;
                aVarG.e(this.f2917i);
                int i9 = 0;
                while (true) {
                    float[] fArr = this.f2917i;
                    if (i9 < fArr.length) {
                        dArr2[i8][i9] = fArr[i9];
                        i9++;
                    }
                }
            }
            this.f2908a = androidx.constraintlayout.core.motion.utils.b.a(i7, dArr, dArr2);
        }

        public void k(int i7, androidx.constraintlayout.core.motion.a aVar) {
            this.f2916h.a(i7, aVar);
        }

        public void l(androidx.constraintlayout.core.state.r rVar, float f8) {
            this.f2908a.e(f8, this.f2917i);
            rVar.z(this.f2916h.g(0), this.f2917i);
        }
    }

    public static class c extends o {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f2918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        i.b f2919h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float[] f2920i;

        public c(String str, i.b bVar) {
            this.f2918g = str.split(",")[1];
            this.f2919h = bVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.o
        public void g(int i7, float f8) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.o
        public void h(w wVar, float f8) {
            l((androidx.constraintlayout.core.motion.f) wVar, f8);
        }

        @Override // androidx.constraintlayout.core.motion.utils.o
        public void j(int i7) {
            int iF = this.f2919h.f();
            int iR = this.f2919h.g(0).r();
            double[] dArr = new double[iF];
            this.f2920i = new float[iR];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iF, iR);
            for (int i8 = 0; i8 < iF; i8++) {
                int iD = this.f2919h.d(i8);
                androidx.constraintlayout.core.motion.b bVarG = this.f2919h.g(i8);
                dArr[i8] = ((double) iD) * 0.01d;
                bVarG.o(this.f2920i);
                int i9 = 0;
                while (true) {
                    float[] fArr = this.f2920i;
                    if (i9 < fArr.length) {
                        dArr2[i8][i9] = fArr[i9];
                        i9++;
                    }
                }
            }
            this.f2908a = androidx.constraintlayout.core.motion.utils.b.a(i7, dArr, dArr2);
        }

        public void k(int i7, androidx.constraintlayout.core.motion.b bVar) {
            this.f2919h.a(i7, bVar);
        }

        public void l(androidx.constraintlayout.core.motion.f fVar, float f8) {
            this.f2908a.e(f8, this.f2920i);
            this.f2919h.g(0).w(fVar, this.f2920i);
        }
    }

    private static class d {
        private d() {
        }

        static void a(int[] iArr, float[] fArr, int i7, int i8) {
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

        private static int b(int[] iArr, float[] fArr, int i7, int i8) {
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

        private static void c(int[] iArr, float[] fArr, int i7, int i8) {
            int i9 = iArr[i7];
            iArr[i7] = iArr[i8];
            iArr[i8] = i9;
            float f8 = fArr[i7];
            fArr[i7] = fArr[i8];
            fArr[i8] = f8;
        }
    }

    public static o d(String str, i.a aVar) {
        return new b(str, aVar);
    }

    public static o e(String str, i.b bVar) {
        return new c(str, bVar);
    }

    public static o f(String str, long j7) {
        return new a(str, j7);
    }

    public float a(float f8) {
        return (float) this.f2908a.c(f8, 0);
    }

    public androidx.constraintlayout.core.motion.utils.b b() {
        return this.f2908a;
    }

    public float c(float f8) {
        return (float) this.f2908a.f(f8, 0);
    }

    public void g(int i7, float f8) {
        int[] iArr = this.f2909b;
        if (iArr.length < this.f2911d + 1) {
            this.f2909b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f2910c;
            this.f2910c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f2909b;
        int i8 = this.f2911d;
        iArr2[i8] = i7;
        this.f2910c[i8] = f8;
        this.f2911d = i8 + 1;
    }

    public void h(w wVar, float f8) {
        wVar.b(v.a(this.f2912e), a(f8));
    }

    public void i(String str) {
        this.f2912e = str;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    public void j(int i7) {
        int i8 = this.f2911d;
        if (i8 == 0) {
            return;
        }
        d.a(this.f2909b, this.f2910c, 0, i8 - 1);
        int i9 = 1;
        for (int i10 = 1; i10 < this.f2911d; i10++) {
            int[] iArr = this.f2909b;
            if (iArr[i10 - 1] != iArr[i10]) {
                i9++;
            }
        }
        double[] dArr = new double[i9];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i9, 1);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f2911d; i12++) {
            if (i12 > 0) {
                int[] iArr2 = this.f2909b;
                if (iArr2[i12] != iArr2[i12 - 1]) {
                    dArr[i11] = ((double) this.f2909b[i12]) * 0.01d;
                    dArr2[i11][0] = this.f2910c[i12];
                    i11++;
                }
            } else {
                dArr[i11] = ((double) this.f2909b[i12]) * 0.01d;
                dArr2[i11][0] = this.f2910c[i12];
                i11++;
            }
        }
        this.f2908a = androidx.constraintlayout.core.motion.utils.b.a(i7, dArr, dArr2);
    }

    public String toString() {
        String str = this.f2912e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i7 = 0; i7 < this.f2911d; i7++) {
            str = str + "[" + this.f2909b[i7] + " , " + decimalFormat.format(this.f2910c[i7]) + "] ";
        }
        return str;
    }
}
