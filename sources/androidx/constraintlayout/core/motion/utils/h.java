package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f2822h = "KeyCycleOscillator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.b f2823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f2824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2826d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2827e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2828f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList<g> f2829g = new ArrayList<>();

    class a implements Comparator<g> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            return Integer.compare(gVar.f2853a, gVar2.f2853a);
        }
    }

    private static class b extends h {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        String f2831i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f2832j;

        public b(String str) {
            this.f2831i = str;
            this.f2832j = y.a(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.h
        public void h(androidx.constraintlayout.core.motion.f fVar, float f8) {
            fVar.b(this.f2832j, a(f8));
        }
    }

    static class c {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final int f2833q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final String f2834r = "CycleOscillator";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        l f2836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f2838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f2839e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float[] f2840f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        double[] f2841g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float[] f2842h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float[] f2843i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float[] f2844j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float[] f2845k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f2846l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        androidx.constraintlayout.core.motion.utils.b f2847m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        double[] f2848n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        double[] f2849o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f2850p;

        c(int i7, String str, int i8, int i9) {
            l lVar = new l();
            this.f2836b = lVar;
            this.f2837c = 0;
            this.f2838d = 1;
            this.f2839e = 2;
            this.f2846l = i7;
            this.f2835a = i8;
            lVar.g(i7, str);
            this.f2840f = new float[i9];
            this.f2841g = new double[i9];
            this.f2842h = new float[i9];
            this.f2843i = new float[i9];
            this.f2844j = new float[i9];
            this.f2845k = new float[i9];
        }

        public double a() {
            return this.f2848n[1];
        }

        public double b(float f8) {
            androidx.constraintlayout.core.motion.utils.b bVar = this.f2847m;
            if (bVar != null) {
                double d8 = f8;
                bVar.g(d8, this.f2849o);
                this.f2847m.d(d8, this.f2848n);
            } else {
                double[] dArr = this.f2849o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d9 = f8;
            double dE = this.f2836b.e(d9, this.f2848n[1]);
            double d10 = this.f2836b.d(d9, this.f2848n[1], this.f2849o[1]);
            double[] dArr2 = this.f2849o;
            return dArr2[0] + (dE * dArr2[2]) + (d10 * this.f2848n[2]);
        }

        public double c(float f8) {
            androidx.constraintlayout.core.motion.utils.b bVar = this.f2847m;
            if (bVar != null) {
                bVar.d(f8, this.f2848n);
            } else {
                double[] dArr = this.f2848n;
                dArr[0] = this.f2843i[0];
                dArr[1] = this.f2844j[0];
                dArr[2] = this.f2840f[0];
            }
            double[] dArr2 = this.f2848n;
            return dArr2[0] + (this.f2836b.e(f8, dArr2[1]) * this.f2848n[2]);
        }

        public void d(int i7, int i8, float f8, float f9, float f10, float f11) {
            this.f2841g[i7] = ((double) i8) / 100.0d;
            this.f2842h[i7] = f8;
            this.f2843i[i7] = f9;
            this.f2844j[i7] = f10;
            this.f2840f[i7] = f11;
        }

        public void e(float f8) {
            this.f2850p = f8;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.f2841g.length, 3);
            float[] fArr = this.f2840f;
            this.f2848n = new double[fArr.length + 2];
            this.f2849o = new double[fArr.length + 2];
            if (this.f2841g[0] > 0.0d) {
                this.f2836b.a(0.0d, this.f2842h[0]);
            }
            double[] dArr2 = this.f2841g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f2836b.a(1.0d, this.f2842h[length]);
            }
            for (int i7 = 0; i7 < dArr.length; i7++) {
                double[] dArr3 = dArr[i7];
                dArr3[0] = this.f2843i[i7];
                dArr3[1] = this.f2844j[i7];
                dArr3[2] = this.f2840f[i7];
                this.f2836b.a(this.f2841g[i7], this.f2842h[i7]);
            }
            this.f2836b.f();
            double[] dArr4 = this.f2841g;
            if (dArr4.length > 1) {
                this.f2847m = androidx.constraintlayout.core.motion.utils.b.a(0, dArr4, dArr);
            } else {
                this.f2847m = null;
            }
        }
    }

    private static class d {
        private d() {
        }

        private static int a(int[] iArr, float[] fArr, int i7, int i8) {
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

        static void b(int[] iArr, float[] fArr, int i7, int i8) {
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
                    int iA = a(iArr, fArr, i11, i12);
                    int i13 = i9 + 1;
                    iArr2[i9] = iA - 1;
                    int i14 = i13 + 1;
                    iArr2[i13] = i11;
                    int i15 = i14 + 1;
                    iArr2[i14] = i12;
                    i9 = i15 + 1;
                    iArr2[i15] = iA + 1;
                }
            }
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

    private static class e {
        private e() {
        }

        private static int a(int[] iArr, float[] fArr, float[] fArr2, int i7, int i8) {
            int i9 = iArr[i8];
            int i10 = i7;
            while (i7 < i8) {
                if (iArr[i7] <= i9) {
                    c(iArr, fArr, fArr2, i10, i7);
                    i10++;
                }
                i7++;
            }
            c(iArr, fArr, fArr2, i10, i8);
            return i10;
        }

        static void b(int[] iArr, float[] fArr, float[] fArr2, int i7, int i8) {
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
                    int iA = a(iArr, fArr, fArr2, i11, i12);
                    int i13 = i9 + 1;
                    iArr2[i9] = iA - 1;
                    int i14 = i13 + 1;
                    iArr2[i13] = i11;
                    int i15 = i14 + 1;
                    iArr2[i14] = i12;
                    i9 = i15 + 1;
                    iArr2[i15] = iA + 1;
                }
            }
        }

        private static void c(int[] iArr, float[] fArr, float[] fArr2, int i7, int i8) {
            int i9 = iArr[i7];
            iArr[i7] = iArr[i8];
            iArr[i8] = i9;
            float f8 = fArr[i7];
            fArr[i7] = fArr[i8];
            fArr[i8] = f8;
            float f9 = fArr2[i7];
            fArr2[i7] = fArr2[i8];
            fArr2[i8] = f9;
        }
    }

    public static class f extends h {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        String f2851i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f2852j;

        public f(String str) {
            this.f2851i = str;
            this.f2852j = y.a(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.h
        public void h(androidx.constraintlayout.core.motion.f fVar, float f8) {
            fVar.b(this.f2852j, a(f8));
        }

        public void l(androidx.constraintlayout.core.motion.f fVar, float f8, double d8, double d9) {
            fVar.R(a(f8) + ((float) Math.toDegrees(Math.atan2(d9, d8))));
        }
    }

    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f2854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f2855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f2856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f2857e;

        public g(int i7, float f8, float f9, float f10, float f11) {
            this.f2853a = i7;
            this.f2854b = f11;
            this.f2855c = f9;
            this.f2856d = f8;
            this.f2857e = f10;
        }
    }

    public static h d(String str) {
        return str.equals("pathRotate") ? new f(str) : new b(str);
    }

    public float a(float f8) {
        return (float) this.f2824b.c(f8);
    }

    public androidx.constraintlayout.core.motion.utils.b b() {
        return this.f2823a;
    }

    public float c(float f8) {
        return (float) this.f2824b.b(f8);
    }

    protected void e(Object obj) {
    }

    public void f(int i7, int i8, String str, int i9, float f8, float f9, float f10, float f11) {
        this.f2829g.add(new g(i7, f8, f9, f10, f11));
        if (i9 != -1) {
            this.f2828f = i9;
        }
        this.f2826d = i8;
        this.f2827e = str;
    }

    public void g(int i7, int i8, String str, int i9, float f8, float f9, float f10, float f11, Object obj) {
        this.f2829g.add(new g(i7, f8, f9, f10, f11));
        if (i9 != -1) {
            this.f2828f = i9;
        }
        this.f2826d = i8;
        e(obj);
        this.f2827e = str;
    }

    public void h(androidx.constraintlayout.core.motion.f fVar, float f8) {
    }

    public void i(String str) {
        this.f2825c = str;
    }

    public void j(float f8) {
        int size = this.f2829g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f2829g, new a());
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.f2824b = new c(this.f2826d, this.f2827e, this.f2828f, size);
        int i7 = 0;
        for (g gVar : this.f2829g) {
            float f9 = gVar.f2856d;
            dArr[i7] = ((double) f9) * 0.01d;
            double[] dArr3 = dArr2[i7];
            float f10 = gVar.f2854b;
            dArr3[0] = f10;
            float f11 = gVar.f2855c;
            dArr3[1] = f11;
            float f12 = gVar.f2857e;
            dArr3[2] = f12;
            this.f2824b.d(i7, gVar.f2853a, f9, f11, f12, f10);
            i7++;
            dArr2 = dArr2;
        }
        this.f2824b.e(f8);
        this.f2823a = androidx.constraintlayout.core.motion.utils.b.a(0, dArr, dArr2);
    }

    public boolean k() {
        return this.f2828f == 1;
    }

    public String toString() {
        String str = this.f2825c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (g gVar : this.f2829g) {
            str = str + "[" + gVar.f2853a + " , " + decimalFormat.format(gVar.f2854b) + "] ";
        }
        return str;
    }
}
