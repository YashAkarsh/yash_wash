package androidx.constraintlayout.motion.widget;

import android.view.View;
import c.m0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class r implements Comparable<r> {
    static final int A = 4;
    static final int B = 5;
    static final int C = 1;
    static final int D = 0;
    static final int E = 2;
    static String[] F = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f4180t = "MotionPaths";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f4181u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f4182v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final int f4183w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final int f4184x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final int f4185y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f4186z = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    androidx.constraintlayout.core.motion.utils.d f4187a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f4189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f4190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f4191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f4192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f4193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f4194h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f4197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f4198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f4199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    o f4200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    LinkedHashMap<String, androidx.constraintlayout.widget.a> f4201o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f4202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f4203q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    double[] f4204r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    double[] f4205s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4188b = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f4195i = Float.NaN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f4196j = Float.NaN;

    public r() {
        int i7 = f.f3951f;
        this.f4197k = i7;
        this.f4198l = i7;
        this.f4199m = Float.NaN;
        this.f4200n = null;
        this.f4201o = new LinkedHashMap<>();
        this.f4202p = 0;
        this.f4204r = new double[18];
        this.f4205s = new double[18];
    }

    private boolean d(float a8, float b8) {
        if (Float.isNaN(a8) || Float.isNaN(b8)) {
            return Float.isNaN(a8) != Float.isNaN(b8);
        }
        return Math.abs(a8 - b8) > 1.0E-6f;
    }

    private static final float w(float sin, float cos, float cx, float cy, float x7, float y7) {
        return (((x7 - cx) * cos) - ((y7 - cy) * sin)) + cx;
    }

    private static final float x(float sin, float cos, float cx, float cy, float x7, float y7) {
        return ((x7 - cx) * sin) + ((y7 - cy) * cos) + cy;
    }

    public void a(androidx.constraintlayout.widget.d.a c8) {
        this.f4187a = androidx.constraintlayout.core.motion.utils.d.c(c8.f4768d.f4883d);
        androidx.constraintlayout.widget.d.c cVar = c8.f4768d;
        this.f4197k = cVar.f4884e;
        this.f4198l = cVar.f4881b;
        this.f4195i = cVar.f4888i;
        this.f4188b = cVar.f4885f;
        this.f4203q = cVar.f4882c;
        this.f4196j = c8.f4767c.f4898e;
        this.f4199m = c8.f4769e.D;
        for (String str : c8.f4771g.keySet()) {
            androidx.constraintlayout.widget.a aVar = c8.f4771g.get(str);
            if (aVar != null && aVar.n()) {
                this.f4201o.put(str, aVar);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@m0 r o7) {
        return Float.compare(this.f4190d, o7.f4190d);
    }

    public void c(o toOrbit) {
        toOrbit.A(this.f4196j);
    }

    void e(r points, boolean[] mask, String[] custom, boolean arcMode) {
        boolean zD = d(this.f4191e, points.f4191e);
        boolean zD2 = d(this.f4192f, points.f4192f);
        mask[0] = mask[0] | d(this.f4190d, points.f4190d);
        boolean z7 = zD | zD2 | arcMode;
        mask[1] = mask[1] | z7;
        mask[2] = z7 | mask[2];
        mask[3] = mask[3] | d(this.f4193g, points.f4193g);
        mask[4] = d(this.f4194h, points.f4194h) | mask[4];
    }

    void f(double[] data, int[] toUse) {
        float[] fArr = {this.f4190d, this.f4191e, this.f4192f, this.f4193g, this.f4194h, this.f4195i};
        int i7 = 0;
        for (int i8 : toUse) {
            if (i8 < 6) {
                data[i7] = fArr[i8];
                i7++;
            }
        }
    }

    void g(int[] toUse, double[] data, float[] point, int offset) {
        float f8 = this.f4193g;
        float f9 = this.f4194h;
        for (int i7 = 0; i7 < toUse.length; i7++) {
            float f10 = (float) data[i7];
            int i8 = toUse[i7];
            if (i8 == 3) {
                f8 = f10;
            } else if (i8 == 4) {
                f9 = f10;
            }
        }
        point[offset] = f8;
        point[offset + 1] = f9;
    }

    void h(double p7, int[] toUse, double[] data, float[] point, int offset) {
        float fSin = this.f4191e;
        float fCos = this.f4192f;
        float f8 = this.f4193g;
        float f9 = this.f4194h;
        for (int i7 = 0; i7 < toUse.length; i7++) {
            float f10 = (float) data[i7];
            int i8 = toUse[i7];
            if (i8 == 1) {
                fSin = f10;
            } else if (i8 == 2) {
                fCos = f10;
            } else if (i8 == 3) {
                f8 = f10;
            } else if (i8 == 4) {
                f9 = f10;
            }
        }
        o oVar = this.f4200n;
        if (oVar != null) {
            float[] fArr = new float[2];
            oVar.m(p7, fArr, new float[2]);
            float f11 = fArr[0];
            float f12 = fArr[1];
            double d8 = f11;
            double d9 = fSin;
            double d10 = fCos;
            fSin = (float) ((d8 + (Math.sin(d10) * d9)) - ((double) (f8 / 2.0f)));
            fCos = (float) ((((double) f12) - (d9 * Math.cos(d10))) - ((double) (f9 / 2.0f)));
        }
        point[offset] = fSin + (f8 / 2.0f) + 0.0f;
        point[offset + 1] = fCos + (f9 / 2.0f) + 0.0f;
    }

    void i(double p7, int[] toUse, double[] data, float[] point, double[] vdata, float[] velocity) {
        float f8 = this.f4191e;
        float f9 = this.f4192f;
        float f10 = this.f4193g;
        float f11 = this.f4194h;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i7 = 0; i7 < toUse.length; i7++) {
            float f16 = (float) data[i7];
            float f17 = (float) vdata[i7];
            int i8 = toUse[i7];
            if (i8 == 1) {
                f8 = f16;
                f12 = f17;
            } else if (i8 == 2) {
                f9 = f16;
                f14 = f17;
            } else if (i8 == 3) {
                f10 = f16;
                f13 = f17;
            } else if (i8 == 4) {
                f11 = f16;
                f15 = f17;
            }
        }
        float f18 = 2.0f;
        float f19 = (f13 / 2.0f) + f12;
        float fCos = (f15 / 2.0f) + f14;
        o oVar = this.f4200n;
        if (oVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            oVar.m(p7, fArr, fArr2);
            float f20 = fArr[0];
            float f21 = fArr[1];
            float f22 = fArr2[0];
            float f23 = fArr2[1];
            double d8 = f8;
            double d9 = f9;
            float fSin = (float) ((((double) f20) + (Math.sin(d9) * d8)) - ((double) (f10 / 2.0f)));
            float fCos2 = (float) ((((double) f21) - (d8 * Math.cos(d9))) - ((double) (f11 / 2.0f)));
            double d10 = f12;
            double d11 = f14;
            float fSin2 = (float) (((double) f22) + (Math.sin(d9) * d10) + (Math.cos(d9) * d11));
            fCos = (float) ((((double) f23) - (d10 * Math.cos(d9))) + (Math.sin(d9) * d11));
            f19 = fSin2;
            f8 = fSin;
            f9 = fCos2;
            f18 = 2.0f;
        }
        point[0] = f8 + (f10 / f18) + 0.0f;
        point[1] = f9 + (f11 / f18) + 0.0f;
        velocity[0] = f19;
        velocity[1] = fCos;
    }

    void j(double p7, int[] toUse, double[] data, float[] point, int offset) {
        float fSin = this.f4191e;
        float fCos = this.f4192f;
        float f8 = this.f4193g;
        float f9 = this.f4194h;
        for (int i7 = 0; i7 < toUse.length; i7++) {
            float f10 = (float) data[i7];
            int i8 = toUse[i7];
            if (i8 == 1) {
                fSin = f10;
            } else if (i8 == 2) {
                fCos = f10;
            } else if (i8 == 3) {
                f8 = f10;
            } else if (i8 == 4) {
                f9 = f10;
            }
        }
        o oVar = this.f4200n;
        if (oVar != null) {
            float[] fArr = new float[2];
            oVar.m(p7, fArr, new float[2]);
            float f11 = fArr[0];
            float f12 = fArr[1];
            double d8 = f11;
            double d9 = fSin;
            double d10 = fCos;
            fSin = (float) ((d8 + (Math.sin(d10) * d9)) - ((double) (f8 / 2.0f)));
            fCos = (float) ((((double) f12) - (d9 * Math.cos(d10))) - ((double) (f9 / 2.0f)));
        }
        point[offset] = fSin + (f8 / 2.0f) + 0.0f;
        point[offset + 1] = fCos + (f9 / 2.0f) + 0.0f;
    }

    int k(String name, double[] value, int offset) {
        androidx.constraintlayout.widget.a aVar = this.f4201o.get(name);
        int i7 = 0;
        if (aVar == null) {
            return 0;
        }
        if (aVar.p() == 1) {
            value[offset] = aVar.k();
            return 1;
        }
        int iP = aVar.p();
        float[] fArr = new float[iP];
        aVar.l(fArr);
        while (i7 < iP) {
            value[offset] = fArr[i7];
            i7++;
            offset++;
        }
        return iP;
    }

    int l(String name) {
        androidx.constraintlayout.widget.a aVar = this.f4201o.get(name);
        if (aVar == null) {
            return 0;
        }
        return aVar.p();
    }

    void m(int[] toUse, double[] data, float[] path, int offset) {
        float f8 = this.f4191e;
        float fCos = this.f4192f;
        float f9 = this.f4193g;
        float f10 = this.f4194h;
        for (int i7 = 0; i7 < toUse.length; i7++) {
            float f11 = (float) data[i7];
            int i8 = toUse[i7];
            if (i8 == 1) {
                f8 = f11;
            } else if (i8 == 2) {
                fCos = f11;
            } else if (i8 == 3) {
                f9 = f11;
            } else if (i8 == 4) {
                f10 = f11;
            }
        }
        o oVar = this.f4200n;
        if (oVar != null) {
            float fN = oVar.n();
            float fO = this.f4200n.o();
            double d8 = f8;
            double d9 = fCos;
            float fSin = (float) ((((double) fN) + (Math.sin(d9) * d8)) - ((double) (f9 / 2.0f)));
            fCos = (float) ((((double) fO) - (d8 * Math.cos(d9))) - ((double) (f10 / 2.0f)));
            f8 = fSin;
        }
        float f12 = f9 + f8;
        float f13 = f10 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i9 = offset + 1;
        path[offset] = f8 + 0.0f;
        int i10 = i9 + 1;
        path[i9] = fCos + 0.0f;
        int i11 = i10 + 1;
        path[i10] = f12 + 0.0f;
        int i12 = i11 + 1;
        path[i11] = fCos + 0.0f;
        int i13 = i12 + 1;
        path[i12] = f12 + 0.0f;
        int i14 = i13 + 1;
        path[i13] = f13 + 0.0f;
        path[i14] = f8 + 0.0f;
        path[i14 + 1] = f13 + 0.0f;
    }

    boolean n(String name) {
        return this.f4201o.containsKey(name);
    }

    void o(j c8, r startTimePoint, r endTimePoint) {
        float f8 = c8.f3972a / 100.0f;
        this.f4189c = f8;
        this.f4188b = c8.H;
        float f9 = Float.isNaN(c8.I) ? f8 : c8.I;
        float f10 = Float.isNaN(c8.f4041J) ? f8 : c8.f4041J;
        float f11 = endTimePoint.f4193g;
        float f12 = startTimePoint.f4193g;
        float f13 = endTimePoint.f4194h;
        float f14 = startTimePoint.f4194h;
        this.f4190d = this.f4189c;
        float f15 = startTimePoint.f4191e;
        float f16 = startTimePoint.f4192f;
        float f17 = (endTimePoint.f4191e + (f11 / 2.0f)) - ((f12 / 2.0f) + f15);
        float f18 = (endTimePoint.f4192f + (f13 / 2.0f)) - (f16 + (f14 / 2.0f));
        float f19 = (f11 - f12) * f9;
        float f20 = f19 / 2.0f;
        this.f4191e = (int) ((f15 + (f17 * f8)) - f20);
        float f21 = (f13 - f14) * f10;
        float f22 = f21 / 2.0f;
        this.f4192f = (int) ((f16 + (f18 * f8)) - f22);
        this.f4193g = (int) (f12 + f19);
        this.f4194h = (int) (f14 + f21);
        float f23 = Float.isNaN(c8.K) ? f8 : c8.K;
        float f24 = Float.isNaN(c8.N) ? 0.0f : c8.N;
        if (!Float.isNaN(c8.L)) {
            f8 = c8.L;
        }
        float f25 = Float.isNaN(c8.M) ? 0.0f : c8.M;
        this.f4202p = 0;
        this.f4191e = (int) (((startTimePoint.f4191e + (f23 * f17)) + (f25 * f18)) - f20);
        this.f4192f = (int) (((startTimePoint.f4192f + (f17 * f24)) + (f18 * f8)) - f22);
        this.f4187a = androidx.constraintlayout.core.motion.utils.d.c(c8.F);
        this.f4197k = c8.G;
    }

    void p(j c8, r startTimePoint, r endTimePoint) {
        float f8 = c8.f3972a / 100.0f;
        this.f4189c = f8;
        this.f4188b = c8.H;
        float f9 = Float.isNaN(c8.I) ? f8 : c8.I;
        float f10 = Float.isNaN(c8.f4041J) ? f8 : c8.f4041J;
        float f11 = endTimePoint.f4193g - startTimePoint.f4193g;
        float f12 = endTimePoint.f4194h - startTimePoint.f4194h;
        this.f4190d = this.f4189c;
        if (!Float.isNaN(c8.K)) {
            f8 = c8.K;
        }
        float f13 = startTimePoint.f4191e;
        float f14 = startTimePoint.f4193g;
        float f15 = startTimePoint.f4192f;
        float f16 = startTimePoint.f4194h;
        float f17 = (endTimePoint.f4191e + (endTimePoint.f4193g / 2.0f)) - ((f14 / 2.0f) + f13);
        float f18 = (endTimePoint.f4192f + (endTimePoint.f4194h / 2.0f)) - ((f16 / 2.0f) + f15);
        float f19 = f17 * f8;
        float f20 = f11 * f9;
        float f21 = f20 / 2.0f;
        this.f4191e = (int) ((f13 + f19) - f21);
        float f22 = f8 * f18;
        float f23 = f12 * f10;
        float f24 = f23 / 2.0f;
        this.f4192f = (int) ((f15 + f22) - f24);
        this.f4193g = (int) (f14 + f20);
        this.f4194h = (int) (f16 + f23);
        float f25 = Float.isNaN(c8.L) ? 0.0f : c8.L;
        this.f4202p = 1;
        float f26 = (int) ((startTimePoint.f4191e + f19) - f21);
        float f27 = (int) ((startTimePoint.f4192f + f22) - f24);
        this.f4191e = f26 + ((-f18) * f25);
        this.f4192f = f27 + (f17 * f25);
        this.f4198l = this.f4198l;
        this.f4187a = androidx.constraintlayout.core.motion.utils.d.c(c8.F);
        this.f4197k = c8.G;
    }

    void q(int parentWidth, int parentHeight, j c8, r s7, r e8) {
        float fMin;
        float f8;
        float f9 = c8.f3972a / 100.0f;
        this.f4189c = f9;
        this.f4188b = c8.H;
        this.f4202p = c8.O;
        float f10 = Float.isNaN(c8.I) ? f9 : c8.I;
        float f11 = Float.isNaN(c8.f4041J) ? f9 : c8.f4041J;
        float f12 = e8.f4193g;
        float f13 = s7.f4193g;
        float f14 = e8.f4194h;
        float f15 = s7.f4194h;
        this.f4190d = this.f4189c;
        this.f4193g = (int) (f13 + ((f12 - f13) * f10));
        this.f4194h = (int) (f15 + ((f14 - f15) * f11));
        int i7 = c8.O;
        if (i7 == 1) {
            float f16 = Float.isNaN(c8.K) ? f9 : c8.K;
            float f17 = e8.f4191e;
            float f18 = s7.f4191e;
            this.f4191e = (f16 * (f17 - f18)) + f18;
            if (!Float.isNaN(c8.L)) {
                f9 = c8.L;
            }
            float f19 = e8.f4192f;
            float f20 = s7.f4192f;
            this.f4192f = (f9 * (f19 - f20)) + f20;
        } else if (i7 != 2) {
            float f21 = Float.isNaN(c8.K) ? f9 : c8.K;
            float f22 = e8.f4191e;
            float f23 = s7.f4191e;
            this.f4191e = (f21 * (f22 - f23)) + f23;
            if (!Float.isNaN(c8.L)) {
                f9 = c8.L;
            }
            float f24 = e8.f4192f;
            float f25 = s7.f4192f;
            this.f4192f = (f9 * (f24 - f25)) + f25;
        } else {
            if (Float.isNaN(c8.K)) {
                float f26 = e8.f4191e;
                float f27 = s7.f4191e;
                fMin = ((f26 - f27) * f9) + f27;
            } else {
                fMin = Math.min(f11, f10) * c8.K;
            }
            this.f4191e = fMin;
            if (Float.isNaN(c8.L)) {
                float f28 = e8.f4192f;
                float f29 = s7.f4192f;
                f8 = (f9 * (f28 - f29)) + f29;
            } else {
                f8 = c8.L;
            }
            this.f4192f = f8;
        }
        this.f4198l = s7.f4198l;
        this.f4187a = androidx.constraintlayout.core.motion.utils.d.c(c8.F);
        this.f4197k = c8.G;
    }

    void r(int parentWidth, int parentHeight, j c8, r startTimePoint, r endTimePoint) {
        float f8 = c8.f3972a / 100.0f;
        this.f4189c = f8;
        this.f4188b = c8.H;
        float f9 = Float.isNaN(c8.I) ? f8 : c8.I;
        float f10 = Float.isNaN(c8.f4041J) ? f8 : c8.f4041J;
        float f11 = endTimePoint.f4193g;
        float f12 = startTimePoint.f4193g;
        float f13 = endTimePoint.f4194h;
        float f14 = startTimePoint.f4194h;
        this.f4190d = this.f4189c;
        float f15 = startTimePoint.f4191e;
        float f16 = startTimePoint.f4192f;
        float f17 = endTimePoint.f4191e + (f11 / 2.0f);
        float f18 = endTimePoint.f4192f + (f13 / 2.0f);
        float f19 = (f11 - f12) * f9;
        this.f4191e = (int) ((f15 + ((f17 - ((f12 / 2.0f) + f15)) * f8)) - (f19 / 2.0f));
        float f20 = (f13 - f14) * f10;
        this.f4192f = (int) ((f16 + ((f18 - (f16 + (f14 / 2.0f))) * f8)) - (f20 / 2.0f));
        this.f4193g = (int) (f12 + f19);
        this.f4194h = (int) (f14 + f20);
        this.f4202p = 2;
        if (!Float.isNaN(c8.K)) {
            this.f4191e = (int) (c8.K * ((int) (parentWidth - this.f4193g)));
        }
        if (!Float.isNaN(c8.L)) {
            this.f4192f = (int) (c8.L * ((int) (parentHeight - this.f4194h)));
        }
        this.f4198l = this.f4198l;
        this.f4187a = androidx.constraintlayout.core.motion.utils.d.c(c8.F);
        this.f4197k = c8.G;
    }

    void s(float x7, float y7, float w7, float h7) {
        this.f4191e = x7;
        this.f4192f = y7;
        this.f4193g = w7;
        this.f4194h = h7;
    }

    void t(float locationX, float locationY, float[] mAnchorDpDt, int[] toUse, double[] deltaData, double[] data) {
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i7 = 0; i7 < toUse.length; i7++) {
            float f12 = (float) deltaData[i7];
            double d8 = data[i7];
            int i8 = toUse[i7];
            if (i8 == 1) {
                f8 = f12;
            } else if (i8 == 2) {
                f10 = f12;
            } else if (i8 == 3) {
                f9 = f12;
            } else if (i8 == 4) {
                f11 = f12;
            }
        }
        float f13 = f8 - ((0.0f * f9) / 2.0f);
        float f14 = f10 - ((0.0f * f11) / 2.0f);
        mAnchorDpDt[0] = (f13 * (1.0f - locationX)) + (((f9 * 1.0f) + f13) * locationX) + 0.0f;
        mAnchorDpDt[1] = (f14 * (1.0f - locationY)) + (((f11 * 1.0f) + f14) * locationY) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void u(float position, View view, int[] toUse, double[] data, double[] slope, double[] cycle, boolean mForceMeasure) {
        float f8;
        boolean z7;
        boolean z8;
        float f9;
        float f10 = this.f4191e;
        float f11 = this.f4192f;
        float f12 = this.f4193g;
        float f13 = this.f4194h;
        if (toUse.length != 0 && this.f4204r.length <= toUse[toUse.length - 1]) {
            int i7 = toUse[toUse.length - 1] + 1;
            this.f4204r = new double[i7];
            this.f4205s = new double[i7];
        }
        Arrays.fill(this.f4204r, Double.NaN);
        for (int i8 = 0; i8 < toUse.length; i8++) {
            double[] dArr = this.f4204r;
            int i9 = toUse[i8];
            dArr[i9] = data[i8];
            this.f4205s[i9] = slope[i8];
        }
        float f14 = Float.NaN;
        int i10 = 0;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        while (true) {
            double[] dArr2 = this.f4204r;
            if (i10 >= dArr2.length) {
                break;
            }
            if (Double.isNaN(dArr2[i10]) && (cycle == null || cycle[i10] == 0.0d)) {
                f9 = f14;
            } else {
                double d8 = cycle != null ? cycle[i10] : 0.0d;
                if (!Double.isNaN(this.f4204r[i10])) {
                    d8 = this.f4204r[i10] + d8;
                }
                f9 = f14;
                float f19 = (float) d8;
                float f20 = (float) this.f4205s[i10];
                if (i10 == 1) {
                    f14 = f9;
                    f15 = f20;
                    f10 = f19;
                } else if (i10 == 2) {
                    f14 = f9;
                    f16 = f20;
                    f11 = f19;
                } else if (i10 == 3) {
                    f14 = f9;
                    f17 = f20;
                    f12 = f19;
                } else if (i10 == 4) {
                    f14 = f9;
                    f18 = f20;
                    f13 = f19;
                } else if (i10 == 5) {
                    f14 = f19;
                }
                i10++;
            }
            f14 = f9;
            i10++;
        }
        float f21 = f14;
        o oVar = this.f4200n;
        if (oVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            oVar.m(position, fArr, fArr2);
            float f22 = fArr[0];
            float f23 = fArr[1];
            float f24 = fArr2[0];
            float f25 = fArr2[1];
            double d9 = f10;
            double d10 = f11;
            float fSin = (float) ((((double) f22) + (Math.sin(d10) * d9)) - ((double) (f12 / 2.0f)));
            f8 = f13;
            float fCos = (float) ((((double) f23) - (Math.cos(d10) * d9)) - ((double) (f13 / 2.0f)));
            double d11 = f15;
            double d12 = f16;
            float fSin2 = (float) (((double) f24) + (Math.sin(d10) * d11) + (Math.cos(d10) * d9 * d12));
            float fCos2 = (float) ((((double) f25) - (d11 * Math.cos(d10))) + (d9 * Math.sin(d10) * d12));
            if (slope.length >= 2) {
                z7 = false;
                slope[0] = fSin2;
                z8 = true;
                slope[1] = fCos2;
            } else {
                z7 = false;
                z8 = true;
            }
            if (!Float.isNaN(f21)) {
                view.setRotation((float) (((double) f21) + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f10 = fSin;
            f11 = fCos;
        } else {
            f8 = f13;
            z7 = false;
            z8 = true;
            if (!Float.isNaN(f21)) {
                view.setRotation((float) (((double) 0.0f) + ((double) f21) + Math.toDegrees(Math.atan2(f16 + (f18 / 2.0f), f15 + (f17 / 2.0f)))));
            }
        }
        if (view instanceof e) {
            ((e) view).a(f10, f11, f12 + f10, f11 + f8);
            return;
        }
        float f26 = f10 + 0.5f;
        int i11 = (int) f26;
        float f27 = f11 + 0.5f;
        int i12 = (int) f27;
        int i13 = (int) (f26 + f12);
        int i14 = (int) (f27 + f8);
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        if (i15 != view.getMeasuredWidth() || i16 != view.getMeasuredHeight()) {
            z7 = z8;
        }
        if (z7 || mForceMeasure) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i15, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
        }
        view.layout(i11, i12, i13, i14);
    }

    public void v(o mc, r relative) {
        double d8 = ((this.f4191e + (this.f4193g / 2.0f)) - relative.f4191e) - (relative.f4193g / 2.0f);
        double d9 = ((this.f4192f + (this.f4194h / 2.0f)) - relative.f4192f) - (relative.f4194h / 2.0f);
        this.f4200n = mc;
        this.f4191e = (float) Math.hypot(d9, d8);
        if (Float.isNaN(this.f4199m)) {
            this.f4192f = (float) (Math.atan2(d9, d8) + 1.5707963267948966d);
        } else {
            this.f4192f = (float) Math.toRadians(this.f4199m);
        }
    }

    public r(int parentWidth, int parentHeight, j c8, r startTimePoint, r endTimePoint) {
        int i7 = f.f3951f;
        this.f4197k = i7;
        this.f4198l = i7;
        this.f4199m = Float.NaN;
        this.f4200n = null;
        this.f4201o = new LinkedHashMap<>();
        this.f4202p = 0;
        this.f4204r = new double[18];
        this.f4205s = new double[18];
        if (startTimePoint.f4198l != f.f3951f) {
            q(parentWidth, parentHeight, c8, startTimePoint, endTimePoint);
            return;
        }
        int i8 = c8.O;
        if (i8 == 1) {
            p(c8, startTimePoint, endTimePoint);
        } else if (i8 != 2) {
            o(c8, startTimePoint, endTimePoint);
        } else {
            r(parentWidth, parentHeight, c8, startTimePoint, endTimePoint);
        }
    }
}
