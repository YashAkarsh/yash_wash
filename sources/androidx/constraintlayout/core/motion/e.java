package androidx.constraintlayout.core.motion;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class e implements Comparable<e> {
    static final int A = 4;
    static final int B = 5;
    public static final int C = 1;
    public static final int D = 0;
    public static final int E = 2;
    static String[] F = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f2605t = "MotionPaths";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f2606u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f2607v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final int f2608w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final int f2609x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final int f2610y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f2611z = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    androidx.constraintlayout.core.motion.utils.d f2612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f2614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f2615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f2616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f2617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f2618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f2619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f2620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f2621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f2622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f2623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f2624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    c f2625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    HashMap<String, b> f2626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f2627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f2628q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    double[] f2629r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    double[] f2630s;

    public e() {
        this.f2613b = 0;
        this.f2620i = Float.NaN;
        this.f2621j = Float.NaN;
        this.f2622k = -1;
        this.f2623l = -1;
        this.f2624m = Float.NaN;
        this.f2625n = null;
        this.f2626o = new HashMap<>();
        this.f2627p = 0;
        this.f2629r = new double[18];
        this.f2630s = new double[18];
    }

    private boolean d(float f8, float f9) {
        if (Float.isNaN(f8) || Float.isNaN(f9)) {
            return Float.isNaN(f8) != Float.isNaN(f9);
        }
        return Math.abs(f8 - f9) > 1.0E-6f;
    }

    private static final float w(float f8, float f9, float f10, float f11, float f12, float f13) {
        return (((f12 - f10) * f9) - ((f13 - f11) * f8)) + f10;
    }

    private static final float x(float f8, float f9, float f10, float f11, float f12, float f13) {
        return ((f12 - f10) * f8) + ((f13 - f11) * f9) + f11;
    }

    public void a(f fVar) {
        this.f2612a = androidx.constraintlayout.core.motion.utils.d.c(fVar.f2646i.f2655c);
        f.a aVar = fVar.f2646i;
        this.f2622k = aVar.f2656d;
        this.f2623l = aVar.f2653a;
        this.f2620i = aVar.f2660h;
        this.f2613b = aVar.f2657e;
        this.f2628q = aVar.f2654b;
        this.f2621j = fVar.f2647j.f2669d;
        this.f2624m = 0.0f;
        for (String str : fVar.j()) {
            b bVarI = fVar.i(str);
            if (bVarI != null && bVarI.q()) {
                this.f2626o.put(str, bVarI);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return Float.compare(this.f2615d, eVar.f2615d);
    }

    public void c(c cVar) {
        cVar.F(this.f2621j);
    }

    void e(e eVar, boolean[] zArr, String[] strArr, boolean z7) {
        boolean zD = d(this.f2616e, eVar.f2616e);
        boolean zD2 = d(this.f2617f, eVar.f2617f);
        zArr[0] = zArr[0] | d(this.f2615d, eVar.f2615d);
        boolean z8 = zD | zD2 | z7;
        zArr[1] = zArr[1] | z8;
        zArr[2] = z8 | zArr[2];
        zArr[3] = zArr[3] | d(this.f2618g, eVar.f2618g);
        zArr[4] = d(this.f2619h, eVar.f2619h) | zArr[4];
    }

    void f(double[] dArr, int[] iArr) {
        float[] fArr = {this.f2615d, this.f2616e, this.f2617f, this.f2618g, this.f2619h, this.f2620i};
        int i7 = 0;
        for (int i8 : iArr) {
            if (i8 < 6) {
                dArr[i7] = fArr[i8];
                i7++;
            }
        }
    }

    void g(int[] iArr, double[] dArr, float[] fArr, int i7) {
        float f8 = this.f2618g;
        float f9 = this.f2619h;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f10 = (float) dArr[i8];
            int i9 = iArr[i8];
            if (i9 == 3) {
                f8 = f10;
            } else if (i9 == 4) {
                f9 = f10;
            }
        }
        fArr[i7] = f8;
        fArr[i7 + 1] = f9;
    }

    void h(double d8, int[] iArr, double[] dArr, float[] fArr, int i7) {
        float fSin = this.f2616e;
        float fCos = this.f2617f;
        float f8 = this.f2618g;
        float f9 = this.f2619h;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f10 = (float) dArr[i8];
            int i9 = iArr[i8];
            if (i9 == 1) {
                fSin = f10;
            } else if (i9 == 2) {
                fCos = f10;
            } else if (i9 == 3) {
                f8 = f10;
            } else if (i9 == 4) {
                f9 = f10;
            }
        }
        c cVar = this.f2625n;
        if (cVar != null) {
            float[] fArr2 = new float[2];
            cVar.r(d8, fArr2, new float[2]);
            float f11 = fArr2[0];
            float f12 = fArr2[1];
            double d9 = f11;
            double d10 = fSin;
            double d11 = fCos;
            fSin = (float) ((d9 + (Math.sin(d11) * d10)) - ((double) (f8 / 2.0f)));
            fCos = (float) ((((double) f12) - (d10 * Math.cos(d11))) - ((double) (f9 / 2.0f)));
        }
        fArr[i7] = fSin + (f8 / 2.0f) + 0.0f;
        fArr[i7 + 1] = fCos + (f9 / 2.0f) + 0.0f;
    }

    void i(double d8, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f8 = this.f2616e;
        float f9 = this.f2617f;
        float f10 = this.f2618g;
        float f11 = this.f2619h;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            float f16 = (float) dArr[i7];
            float f17 = (float) dArr2[i7];
            int i8 = iArr[i7];
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
        c cVar = this.f2625n;
        if (cVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            cVar.r(d8, fArr3, fArr4);
            float f20 = fArr3[0];
            float f21 = fArr3[1];
            float f22 = fArr4[0];
            float f23 = fArr4[1];
            double d9 = f8;
            double d10 = f9;
            float fSin = (float) ((((double) f20) + (Math.sin(d10) * d9)) - ((double) (f10 / 2.0f)));
            float fCos2 = (float) ((((double) f21) - (d9 * Math.cos(d10))) - ((double) (f11 / 2.0f)));
            double d11 = f12;
            double d12 = f14;
            float fSin2 = (float) (((double) f22) + (Math.sin(d10) * d11) + (Math.cos(d10) * d12));
            fCos = (float) ((((double) f23) - (d11 * Math.cos(d10))) + (Math.sin(d10) * d12));
            f19 = fSin2;
            f8 = fSin;
            f9 = fCos2;
            f18 = 2.0f;
        }
        fArr[0] = f8 + (f10 / f18) + 0.0f;
        fArr[1] = f9 + (f11 / f18) + 0.0f;
        fArr2[0] = f19;
        fArr2[1] = fCos;
    }

    void j(double d8, int[] iArr, double[] dArr, float[] fArr, int i7) {
        float fSin = this.f2616e;
        float fCos = this.f2617f;
        float f8 = this.f2618g;
        float f9 = this.f2619h;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f10 = (float) dArr[i8];
            int i9 = iArr[i8];
            if (i9 == 1) {
                fSin = f10;
            } else if (i9 == 2) {
                fCos = f10;
            } else if (i9 == 3) {
                f8 = f10;
            } else if (i9 == 4) {
                f9 = f10;
            }
        }
        c cVar = this.f2625n;
        if (cVar != null) {
            float[] fArr2 = new float[2];
            cVar.r(d8, fArr2, new float[2]);
            float f11 = fArr2[0];
            float f12 = fArr2[1];
            double d9 = f11;
            double d10 = fSin;
            double d11 = fCos;
            fSin = (float) ((d9 + (Math.sin(d11) * d10)) - ((double) (f8 / 2.0f)));
            fCos = (float) ((((double) f12) - (d10 * Math.cos(d11))) - ((double) (f9 / 2.0f)));
        }
        fArr[i7] = fSin + (f8 / 2.0f) + 0.0f;
        fArr[i7 + 1] = fCos + (f9 / 2.0f) + 0.0f;
    }

    int k(String str, double[] dArr, int i7) {
        b bVar = this.f2626o.get(str);
        int i8 = 0;
        if (bVar == null) {
            return 0;
        }
        if (bVar.r() == 1) {
            dArr[i7] = bVar.n();
            return 1;
        }
        int iR = bVar.r();
        float[] fArr = new float[iR];
        bVar.o(fArr);
        while (i8 < iR) {
            dArr[i7] = fArr[i8];
            i8++;
            i7++;
        }
        return iR;
    }

    int l(String str) {
        b bVar = this.f2626o.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.r();
    }

    void m(int[] iArr, double[] dArr, float[] fArr, int i7) {
        float f8 = this.f2616e;
        float fCos = this.f2617f;
        float f9 = this.f2618g;
        float f10 = this.f2619h;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f11 = (float) dArr[i8];
            int i9 = iArr[i8];
            if (i9 == 1) {
                f8 = f11;
            } else if (i9 == 2) {
                fCos = f11;
            } else if (i9 == 3) {
                f9 = f11;
            } else if (i9 == 4) {
                f10 = f11;
            }
        }
        c cVar = this.f2625n;
        if (cVar != null) {
            float fS = cVar.s();
            float fT = this.f2625n.t();
            double d8 = f8;
            double d9 = fCos;
            float fSin = (float) ((((double) fS) + (Math.sin(d9) * d8)) - ((double) (f9 / 2.0f)));
            fCos = (float) ((((double) fT) - (d8 * Math.cos(d9))) - ((double) (f10 / 2.0f)));
            f8 = fSin;
        }
        float f12 = f9 + f8;
        float f13 = f10 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i10 = i7 + 1;
        fArr[i7] = f8 + 0.0f;
        int i11 = i10 + 1;
        fArr[i10] = fCos + 0.0f;
        int i12 = i11 + 1;
        fArr[i11] = f12 + 0.0f;
        int i13 = i12 + 1;
        fArr[i12] = fCos + 0.0f;
        int i14 = i13 + 1;
        fArr[i13] = f12 + 0.0f;
        int i15 = i14 + 1;
        fArr[i14] = f13 + 0.0f;
        fArr[i15] = f8 + 0.0f;
        fArr[i15 + 1] = f13 + 0.0f;
    }

    boolean n(String str) {
        return this.f2626o.containsKey(str);
    }

    void o(androidx.constraintlayout.core.motion.key.e eVar, e eVar2, e eVar3) {
        float f8 = eVar.f2695h / 100.0f;
        this.f2614c = f8;
        this.f2613b = eVar.B;
        float f9 = Float.isNaN(eVar.C) ? f8 : eVar.C;
        float f10 = Float.isNaN(eVar.D) ? f8 : eVar.D;
        float f11 = eVar3.f2618g;
        float f12 = eVar2.f2618g;
        float f13 = eVar3.f2619h;
        float f14 = eVar2.f2619h;
        this.f2615d = this.f2614c;
        float f15 = eVar2.f2616e;
        float f16 = eVar2.f2617f;
        float f17 = (eVar3.f2616e + (f11 / 2.0f)) - ((f12 / 2.0f) + f15);
        float f18 = (eVar3.f2617f + (f13 / 2.0f)) - (f16 + (f14 / 2.0f));
        float f19 = (f11 - f12) * f9;
        float f20 = f19 / 2.0f;
        this.f2616e = (int) ((f15 + (f17 * f8)) - f20);
        float f21 = (f13 - f14) * f10;
        float f22 = f21 / 2.0f;
        this.f2617f = (int) ((f16 + (f18 * f8)) - f22);
        this.f2618g = (int) (f12 + f19);
        this.f2619h = (int) (f14 + f21);
        float f23 = Float.isNaN(eVar.E) ? f8 : eVar.E;
        float f24 = Float.isNaN(eVar.H) ? 0.0f : eVar.H;
        if (!Float.isNaN(eVar.F)) {
            f8 = eVar.F;
        }
        float f25 = Float.isNaN(eVar.G) ? 0.0f : eVar.G;
        this.f2627p = 0;
        this.f2616e = (int) (((eVar2.f2616e + (f23 * f17)) + (f25 * f18)) - f20);
        this.f2617f = (int) (((eVar2.f2617f + (f17 * f24)) + (f18 * f8)) - f22);
        this.f2612a = androidx.constraintlayout.core.motion.utils.d.c(eVar.f2713z);
        this.f2622k = eVar.A;
    }

    void p(androidx.constraintlayout.core.motion.key.e eVar, e eVar2, e eVar3) {
        float f8 = eVar.f2695h / 100.0f;
        this.f2614c = f8;
        this.f2613b = eVar.B;
        float f9 = Float.isNaN(eVar.C) ? f8 : eVar.C;
        float f10 = Float.isNaN(eVar.D) ? f8 : eVar.D;
        float f11 = eVar3.f2618g - eVar2.f2618g;
        float f12 = eVar3.f2619h - eVar2.f2619h;
        this.f2615d = this.f2614c;
        if (!Float.isNaN(eVar.E)) {
            f8 = eVar.E;
        }
        float f13 = eVar2.f2616e;
        float f14 = eVar2.f2618g;
        float f15 = eVar2.f2617f;
        float f16 = eVar2.f2619h;
        float f17 = (eVar3.f2616e + (eVar3.f2618g / 2.0f)) - ((f14 / 2.0f) + f13);
        float f18 = (eVar3.f2617f + (eVar3.f2619h / 2.0f)) - ((f16 / 2.0f) + f15);
        float f19 = f17 * f8;
        float f20 = f11 * f9;
        float f21 = f20 / 2.0f;
        this.f2616e = (int) ((f13 + f19) - f21);
        float f22 = f8 * f18;
        float f23 = f12 * f10;
        float f24 = f23 / 2.0f;
        this.f2617f = (int) ((f15 + f22) - f24);
        this.f2618g = (int) (f14 + f20);
        this.f2619h = (int) (f16 + f23);
        float f25 = Float.isNaN(eVar.F) ? 0.0f : eVar.F;
        this.f2627p = 1;
        float f26 = (int) ((eVar2.f2616e + f19) - f21);
        float f27 = (int) ((eVar2.f2617f + f22) - f24);
        this.f2616e = f26 + ((-f18) * f25);
        this.f2617f = f27 + (f17 * f25);
        this.f2623l = this.f2623l;
        this.f2612a = androidx.constraintlayout.core.motion.utils.d.c(eVar.f2713z);
        this.f2622k = eVar.A;
    }

    void q(int i7, int i8, androidx.constraintlayout.core.motion.key.e eVar, e eVar2, e eVar3) {
        float fMin;
        float f8;
        float f9 = eVar.f2695h / 100.0f;
        this.f2614c = f9;
        this.f2613b = eVar.B;
        this.f2627p = eVar.I;
        float f10 = Float.isNaN(eVar.C) ? f9 : eVar.C;
        float f11 = Float.isNaN(eVar.D) ? f9 : eVar.D;
        float f12 = eVar3.f2618g;
        float f13 = eVar2.f2618g;
        float f14 = eVar3.f2619h;
        float f15 = eVar2.f2619h;
        this.f2615d = this.f2614c;
        this.f2618g = (int) (f13 + ((f12 - f13) * f10));
        this.f2619h = (int) (f15 + ((f14 - f15) * f11));
        int i9 = eVar.I;
        if (i9 == 1) {
            float f16 = Float.isNaN(eVar.E) ? f9 : eVar.E;
            float f17 = eVar3.f2616e;
            float f18 = eVar2.f2616e;
            this.f2616e = (f16 * (f17 - f18)) + f18;
            if (!Float.isNaN(eVar.F)) {
                f9 = eVar.F;
            }
            float f19 = eVar3.f2617f;
            float f20 = eVar2.f2617f;
            this.f2617f = (f9 * (f19 - f20)) + f20;
        } else if (i9 != 2) {
            float f21 = Float.isNaN(eVar.E) ? f9 : eVar.E;
            float f22 = eVar3.f2616e;
            float f23 = eVar2.f2616e;
            this.f2616e = (f21 * (f22 - f23)) + f23;
            if (!Float.isNaN(eVar.F)) {
                f9 = eVar.F;
            }
            float f24 = eVar3.f2617f;
            float f25 = eVar2.f2617f;
            this.f2617f = (f9 * (f24 - f25)) + f25;
        } else {
            if (Float.isNaN(eVar.E)) {
                float f26 = eVar3.f2616e;
                float f27 = eVar2.f2616e;
                fMin = ((f26 - f27) * f9) + f27;
            } else {
                fMin = Math.min(f11, f10) * eVar.E;
            }
            this.f2616e = fMin;
            if (Float.isNaN(eVar.F)) {
                float f28 = eVar3.f2617f;
                float f29 = eVar2.f2617f;
                f8 = (f9 * (f28 - f29)) + f29;
            } else {
                f8 = eVar.F;
            }
            this.f2617f = f8;
        }
        this.f2623l = eVar2.f2623l;
        this.f2612a = androidx.constraintlayout.core.motion.utils.d.c(eVar.f2713z);
        this.f2622k = eVar.A;
    }

    void r(int i7, int i8, androidx.constraintlayout.core.motion.key.e eVar, e eVar2, e eVar3) {
        float f8 = eVar.f2695h / 100.0f;
        this.f2614c = f8;
        this.f2613b = eVar.B;
        float f9 = Float.isNaN(eVar.C) ? f8 : eVar.C;
        float f10 = Float.isNaN(eVar.D) ? f8 : eVar.D;
        float f11 = eVar3.f2618g;
        float f12 = eVar2.f2618g;
        float f13 = eVar3.f2619h;
        float f14 = eVar2.f2619h;
        this.f2615d = this.f2614c;
        float f15 = eVar2.f2616e;
        float f16 = eVar2.f2617f;
        float f17 = eVar3.f2616e + (f11 / 2.0f);
        float f18 = eVar3.f2617f + (f13 / 2.0f);
        float f19 = (f11 - f12) * f9;
        this.f2616e = (int) ((f15 + ((f17 - ((f12 / 2.0f) + f15)) * f8)) - (f19 / 2.0f));
        float f20 = (f13 - f14) * f10;
        this.f2617f = (int) ((f16 + ((f18 - (f16 + (f14 / 2.0f))) * f8)) - (f20 / 2.0f));
        this.f2618g = (int) (f12 + f19);
        this.f2619h = (int) (f14 + f20);
        this.f2627p = 2;
        if (!Float.isNaN(eVar.E)) {
            this.f2616e = (int) (eVar.E * ((int) (i7 - this.f2618g)));
        }
        if (!Float.isNaN(eVar.F)) {
            this.f2617f = (int) (eVar.F * ((int) (i8 - this.f2619h)));
        }
        this.f2623l = this.f2623l;
        this.f2612a = androidx.constraintlayout.core.motion.utils.d.c(eVar.f2713z);
        this.f2622k = eVar.A;
    }

    void s(float f8, float f9, float f10, float f11) {
        this.f2616e = f8;
        this.f2617f = f9;
        this.f2618g = f10;
        this.f2619h = f11;
    }

    void t(float f8, float f9, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            float f14 = (float) dArr[i7];
            double d8 = dArr2[i7];
            int i8 = iArr[i7];
            if (i8 == 1) {
                f10 = f14;
            } else if (i8 == 2) {
                f12 = f14;
            } else if (i8 == 3) {
                f11 = f14;
            } else if (i8 == 4) {
                f13 = f14;
            }
        }
        float f15 = f10 - ((0.0f * f11) / 2.0f);
        float f16 = f12 - ((0.0f * f13) / 2.0f);
        fArr[0] = (f15 * (1.0f - f8)) + (((f11 * 1.0f) + f15) * f8) + 0.0f;
        fArr[1] = (f16 * (1.0f - f9)) + (((f13 * 1.0f) + f16) * f9) + 0.0f;
    }

    void u(float f8, f fVar, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f9;
        float f10;
        float f11 = this.f2616e;
        float f12 = this.f2617f;
        float f13 = this.f2618g;
        float f14 = this.f2619h;
        if (iArr.length != 0 && this.f2629r.length <= iArr[iArr.length - 1]) {
            int i7 = iArr[iArr.length - 1] + 1;
            this.f2629r = new double[i7];
            this.f2630s = new double[i7];
        }
        Arrays.fill(this.f2629r, Double.NaN);
        for (int i8 = 0; i8 < iArr.length; i8++) {
            double[] dArr4 = this.f2629r;
            int i9 = iArr[i8];
            dArr4[i9] = dArr[i8];
            this.f2630s[i9] = dArr2[i8];
        }
        float f15 = Float.NaN;
        int i10 = 0;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        while (true) {
            double[] dArr5 = this.f2629r;
            if (i10 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i10]) && (dArr3 == null || dArr3[i10] == 0.0d)) {
                f10 = f15;
            } else {
                double d8 = dArr3 != null ? dArr3[i10] : 0.0d;
                if (!Double.isNaN(this.f2629r[i10])) {
                    d8 = this.f2629r[i10] + d8;
                }
                f10 = f15;
                float f20 = (float) d8;
                float f21 = (float) this.f2630s[i10];
                if (i10 == 1) {
                    f15 = f10;
                    f16 = f21;
                    f11 = f20;
                } else if (i10 == 2) {
                    f15 = f10;
                    f17 = f21;
                    f12 = f20;
                } else if (i10 == 3) {
                    f15 = f10;
                    f18 = f21;
                    f13 = f20;
                } else if (i10 == 4) {
                    f15 = f10;
                    f19 = f21;
                    f14 = f20;
                } else if (i10 == 5) {
                    f15 = f20;
                }
                i10++;
            }
            f15 = f10;
            i10++;
        }
        float f22 = f15;
        c cVar = this.f2625n;
        if (cVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            cVar.r(f8, fArr, fArr2);
            float f23 = fArr[0];
            float f24 = fArr[1];
            float f25 = fArr2[0];
            float f26 = fArr2[1];
            double d9 = f11;
            double d10 = f12;
            float fSin = (float) ((((double) f23) + (Math.sin(d10) * d9)) - ((double) (f13 / 2.0f)));
            f9 = f14;
            float fCos = (float) ((((double) f24) - (Math.cos(d10) * d9)) - ((double) (f14 / 2.0f)));
            double d11 = f16;
            double d12 = f17;
            float fSin2 = (float) (((double) f25) + (Math.sin(d10) * d11) + (Math.cos(d10) * d9 * d12));
            float fCos2 = (float) ((((double) f26) - (d11 * Math.cos(d10))) + (d9 * Math.sin(d10) * d12));
            if (dArr2.length >= 2) {
                dArr2[0] = fSin2;
                dArr2[1] = fCos2;
            }
            if (!Float.isNaN(f22)) {
                fVar.R((float) (((double) f22) + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f11 = fSin;
            f12 = fCos;
        } else {
            f9 = f14;
            if (!Float.isNaN(f22)) {
                fVar.R((float) (((double) 0.0f) + ((double) f22) + Math.toDegrees(Math.atan2(f17 + (f19 / 2.0f), f16 + (f18 / 2.0f)))));
            }
        }
        float f27 = f11 + 0.5f;
        float f28 = f12 + 0.5f;
        fVar.G((int) f27, (int) f28, (int) (f27 + f13), (int) (f28 + f9));
    }

    public void v(c cVar, e eVar) {
        double d8 = ((this.f2616e + (this.f2618g / 2.0f)) - eVar.f2616e) - (eVar.f2618g / 2.0f);
        double d9 = ((this.f2617f + (this.f2619h / 2.0f)) - eVar.f2617f) - (eVar.f2619h / 2.0f);
        this.f2625n = cVar;
        this.f2616e = (float) Math.hypot(d9, d8);
        if (Float.isNaN(this.f2624m)) {
            this.f2617f = (float) (Math.atan2(d9, d8) + 1.5707963267948966d);
        } else {
            this.f2617f = (float) Math.toRadians(this.f2624m);
        }
    }

    public e(int i7, int i8, androidx.constraintlayout.core.motion.key.e eVar, e eVar2, e eVar3) {
        this.f2613b = 0;
        this.f2620i = Float.NaN;
        this.f2621j = Float.NaN;
        this.f2622k = -1;
        this.f2623l = -1;
        this.f2624m = Float.NaN;
        this.f2625n = null;
        this.f2626o = new HashMap<>();
        this.f2627p = 0;
        this.f2629r = new double[18];
        this.f2630s = new double[18];
        if (eVar2.f2623l != -1) {
            q(i7, i8, eVar, eVar2, eVar3);
            return;
        }
        int i9 = eVar.I;
        if (i9 == 1) {
            p(eVar, eVar2, eVar3);
        } else if (i9 != 2) {
            o(eVar, eVar2, eVar3);
        } else {
            r(i7, i8, eVar, eVar2, eVar3);
        }
    }
}
