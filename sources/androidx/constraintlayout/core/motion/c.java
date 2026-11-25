package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.g;
import androidx.constraintlayout.core.motion.utils.e0;
import androidx.constraintlayout.core.motion.utils.f0;
import androidx.constraintlayout.core.motion.utils.g0;
import androidx.constraintlayout.core.motion.utils.h;
import androidx.constraintlayout.core.motion.utils.i;
import androidx.constraintlayout.core.motion.utils.m;
import androidx.constraintlayout.core.motion.utils.o;
import androidx.constraintlayout.core.motion.utils.t;
import androidx.constraintlayout.core.motion.utils.w;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c implements w {
    public static final int T = 0;
    public static final int U = 1;
    public static final int V = 2;
    public static final int W = 3;
    public static final int X = 4;
    public static final int Y = 5;
    public static final int Z = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f2537a0 = 1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f2538b0 = 2;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f2539c0 = 3;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f2540d0 = 4;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f2541e0 = 5;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f2542f0 = 6;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f2543g0 = 1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f2544h0 = 2;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final String f2545i0 = "MotionController";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final boolean f2546j0 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final boolean f2547k0 = false;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    static final int f2548l0 = 0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    static final int f2549m0 = 1;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    static final int f2550n0 = 2;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    static final int f2551o0 = 3;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    static final int f2552p0 = 4;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    static final int f2553q0 = 5;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final int f2554r0 = -1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final int f2555s0 = -2;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final int f2556t0 = -3;
    private String[] A;
    private int[] B;
    private HashMap<String, t> H;
    private HashMap<String, o> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private HashMap<String, h> f2557J;
    private g[] K;
    String[] S;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    f f2559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f2560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f2561k;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.b[] f2567q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.b f2568r;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    float f2572v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    float f2573w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int[] f2574x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private double[] f2575y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private double[] f2576z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    m f2558h = new m();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2562l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private e f2563m = new e();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private e f2564n = new e();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private d f2565o = new d();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private d f2566p = new d();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    float f2569s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f2570t = 0.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    float f2571u = 1.0f;
    private int C = 4;
    private float[] D = new float[4];
    private ArrayList<e> E = new ArrayList<>();
    private float[] F = new float[1];
    private ArrayList<androidx.constraintlayout.core.motion.key.b> G = new ArrayList<>();
    private int L = -1;
    private int M = -1;
    private f N = null;
    private int O = -1;
    private float P = Float.NaN;
    private androidx.constraintlayout.core.motion.utils.c Q = null;
    private boolean R = false;

    static class a implements androidx.constraintlayout.core.motion.utils.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f2577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.constraintlayout.core.motion.utils.d f2578b;

        a(androidx.constraintlayout.core.motion.utils.d dVar) {
            this.f2578b = dVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.c
        public float a() {
            return (float) this.f2578b.b(this.f2577a);
        }

        @Override // androidx.constraintlayout.core.motion.utils.c
        public float getInterpolation(float f8) {
            this.f2577a = f8;
            return (float) this.f2578b.a(f8);
        }
    }

    public c(f fVar) {
        c0(fVar);
    }

    private static androidx.constraintlayout.core.motion.utils.c A(int i7, String str, int i8) {
        if (i7 != -1) {
            return null;
        }
        return new a(androidx.constraintlayout.core.motion.utils.d.c(str));
    }

    private float I() {
        char c8;
        float fHypot;
        float[] fArr = new float[2];
        float f8 = 1.0f / 99;
        double d8 = 0.0d;
        double d9 = 0.0d;
        float f9 = 0.0f;
        int i7 = 0;
        while (i7 < 100) {
            float f10 = i7 * f8;
            double dA = f10;
            androidx.constraintlayout.core.motion.utils.d dVar = this.f2563m.f2612a;
            float f11 = Float.NaN;
            float f12 = 0.0f;
            for (e eVar : this.E) {
                androidx.constraintlayout.core.motion.utils.d dVar2 = eVar.f2612a;
                if (dVar2 != null) {
                    float f13 = eVar.f2614c;
                    if (f13 < f10) {
                        dVar = dVar2;
                        f12 = f13;
                    } else if (Float.isNaN(f11)) {
                        f11 = eVar.f2614c;
                    }
                }
            }
            if (dVar != null) {
                if (Float.isNaN(f11)) {
                    f11 = 1.0f;
                }
                float f14 = f11 - f12;
                dA = (((float) dVar.a((f10 - f12) / f14)) * f14) + f12;
            }
            this.f2567q[0].d(dA, this.f2575y);
            float f15 = f9;
            int i8 = i7;
            this.f2563m.h(dA, this.f2574x, this.f2575y, fArr, 0);
            if (i8 > 0) {
                c8 = 0;
                fHypot = (float) (((double) f15) + Math.hypot(d9 - ((double) fArr[1]), d8 - ((double) fArr[0])));
            } else {
                c8 = 0;
                fHypot = f15;
            }
            d8 = fArr[c8];
            i7 = i8 + 1;
            f9 = fHypot;
            d9 = fArr[1];
        }
        return f9;
    }

    private void P(e eVar) {
        e eVar2 = null;
        for (e eVar3 : this.E) {
            if (eVar.f2615d == eVar3.f2615d) {
                eVar2 = eVar3;
            }
        }
        if (eVar2 != null) {
            this.E.remove(eVar2);
        }
        int iBinarySearch = Collections.binarySearch(this.E, eVar);
        if (iBinarySearch == 0) {
            e0.f(f2545i0, " KeyPath position \"" + eVar.f2615d + "\" outside of range");
        }
        this.E.add((-iBinarySearch) - 1, eVar);
    }

    private void T(e eVar) {
        eVar.s(this.f2559i.E(), this.f2559i.F(), this.f2559i.D(), this.f2559i.k());
    }

    private float o(float f8, float[] fArr) {
        float f9 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f10 = this.f2571u;
            if (f10 != 1.0d) {
                float f11 = this.f2570t;
                if (f8 < f11) {
                    f8 = 0.0f;
                }
                if (f8 > f11 && f8 < 1.0d) {
                    f8 = Math.min((f8 - f11) * f10, 1.0f);
                }
            }
        }
        androidx.constraintlayout.core.motion.utils.d dVar = this.f2563m.f2612a;
        float f12 = Float.NaN;
        for (e eVar : this.E) {
            androidx.constraintlayout.core.motion.utils.d dVar2 = eVar.f2612a;
            if (dVar2 != null) {
                float f13 = eVar.f2614c;
                if (f13 < f8) {
                    dVar = dVar2;
                    f9 = f13;
                } else if (Float.isNaN(f12)) {
                    f12 = eVar.f2614c;
                }
            }
        }
        if (dVar != null) {
            float f14 = (Float.isNaN(f12) ? 1.0f : f12) - f9;
            double d8 = (f8 - f9) / f14;
            f8 = (((float) dVar.a(d8)) * f14) + f9;
            if (fArr != null) {
                fArr[0] = (float) dVar.b(d8);
            }
        }
        return f8;
    }

    public e B(int i7) {
        return this.E.get(i7);
    }

    public int C(int i7, int[] iArr) {
        float[] fArr = new float[2];
        int i8 = 0;
        int i9 = 0;
        for (androidx.constraintlayout.core.motion.key.b bVar : this.G) {
            int i10 = bVar.f2698k;
            if (i10 == i7 || i7 != -1) {
                iArr[i9] = 0;
                int i11 = i9 + 1;
                iArr[i11] = i10;
                int i12 = i11 + 1;
                int i13 = bVar.f2695h;
                iArr[i12] = i13;
                double d8 = i13 / 100.0f;
                this.f2567q[0].d(d8, this.f2575y);
                this.f2563m.h(d8, this.f2574x, this.f2575y, fArr, 0);
                int i14 = i12 + 1;
                iArr[i14] = Float.floatToIntBits(fArr[0]);
                int i15 = i14 + 1;
                iArr[i15] = Float.floatToIntBits(fArr[1]);
                if (bVar instanceof androidx.constraintlayout.core.motion.key.e) {
                    androidx.constraintlayout.core.motion.key.e eVar = (androidx.constraintlayout.core.motion.key.e) bVar;
                    int i16 = i15 + 1;
                    iArr[i16] = eVar.I;
                    int i17 = i16 + 1;
                    iArr[i17] = Float.floatToIntBits(eVar.E);
                    i15 = i17 + 1;
                    iArr[i15] = Float.floatToIntBits(eVar.F);
                }
                int i18 = i15 + 1;
                iArr[i9] = i18 - i9;
                i8++;
                i9 = i18;
            }
        }
        return i8;
    }

    float D(int i7, float f8, float f9) {
        e eVar = this.f2564n;
        float f10 = eVar.f2616e;
        e eVar2 = this.f2563m;
        float f11 = eVar2.f2616e;
        float f12 = f10 - f11;
        float f13 = eVar.f2617f;
        float f14 = eVar2.f2617f;
        float f15 = f13 - f14;
        float f16 = f11 + (eVar2.f2618g / 2.0f);
        float f17 = f14 + (eVar2.f2619h / 2.0f);
        float fHypot = (float) Math.hypot(f12, f15);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f18 = f8 - f16;
        float f19 = f9 - f17;
        if (((float) Math.hypot(f18, f19)) == 0.0f) {
            return 0.0f;
        }
        float f20 = (f18 * f12) + (f19 * f15);
        if (i7 == 0) {
            return f20 / fHypot;
        }
        if (i7 == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f20 * f20));
        }
        if (i7 == 2) {
            return f18 / f12;
        }
        if (i7 == 3) {
            return f19 / f12;
        }
        if (i7 == 4) {
            return f18 / f15;
        }
        if (i7 != 5) {
            return 0.0f;
        }
        return f19 / f15;
    }

    public int E(int[] iArr, float[] fArr) {
        int i7 = 0;
        int i8 = 0;
        for (androidx.constraintlayout.core.motion.key.b bVar : this.G) {
            int i9 = bVar.f2695h;
            iArr[i7] = (bVar.f2698k * 1000) + i9;
            double d8 = i9 / 100.0f;
            this.f2567q[0].d(d8, this.f2575y);
            this.f2563m.h(d8, this.f2574x, this.f2575y, fArr, i8);
            i8 += 2;
            i7++;
        }
        return i7;
    }

    double[] F(double d8) {
        this.f2567q[0].d(d8, this.f2575y);
        androidx.constraintlayout.core.motion.utils.b bVar = this.f2568r;
        if (bVar != null) {
            double[] dArr = this.f2575y;
            if (dArr.length > 0) {
                bVar.d(d8, dArr);
            }
        }
        return this.f2575y;
    }

    androidx.constraintlayout.core.motion.key.e G(int i7, int i8, float f8, float f9) {
        androidx.constraintlayout.core.motion.utils.e eVar = new androidx.constraintlayout.core.motion.utils.e();
        e eVar2 = this.f2563m;
        float f10 = eVar2.f2616e;
        eVar.f2795b = f10;
        float f11 = eVar2.f2617f;
        eVar.f2797d = f11;
        eVar.f2796c = f10 + eVar2.f2618g;
        eVar.f2794a = f11 + eVar2.f2619h;
        androidx.constraintlayout.core.motion.utils.e eVar3 = new androidx.constraintlayout.core.motion.utils.e();
        e eVar4 = this.f2564n;
        float f12 = eVar4.f2616e;
        eVar3.f2795b = f12;
        float f13 = eVar4.f2617f;
        eVar3.f2797d = f13;
        eVar3.f2796c = f12 + eVar4.f2618g;
        eVar3.f2794a = f13 + eVar4.f2619h;
        for (androidx.constraintlayout.core.motion.key.b bVar : this.G) {
            if (bVar instanceof androidx.constraintlayout.core.motion.key.e) {
                androidx.constraintlayout.core.motion.key.e eVar5 = (androidx.constraintlayout.core.motion.key.e) bVar;
                if (eVar5.B(i7, i8, eVar, eVar3, f8, f9)) {
                    return eVar5;
                }
            }
        }
        return null;
    }

    void H(float f8, int i7, int i8, float f9, float f10, float[] fArr) {
        float fO = o(f8, this.F);
        HashMap<String, o> map = this.I;
        o oVar = map == null ? null : map.get("translationX");
        HashMap<String, o> map2 = this.I;
        o oVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, o> map3 = this.I;
        o oVar3 = map3 == null ? null : map3.get("rotationZ");
        HashMap<String, o> map4 = this.I;
        o oVar4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, o> map5 = this.I;
        o oVar5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, h> map6 = this.f2557J;
        h hVar = map6 == null ? null : map6.get("translationX");
        HashMap<String, h> map7 = this.f2557J;
        h hVar2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, h> map8 = this.f2557J;
        h hVar3 = map8 == null ? null : map8.get("rotationZ");
        HashMap<String, h> map9 = this.f2557J;
        h hVar4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, h> map10 = this.f2557J;
        h hVar5 = map10 != null ? map10.get("scaleY") : null;
        f0 f0Var = new f0();
        f0Var.b();
        f0Var.d(oVar3, fO);
        f0Var.h(oVar, oVar2, fO);
        f0Var.f(oVar4, oVar5, fO);
        f0Var.c(hVar3, fO);
        f0Var.g(hVar, hVar2, fO);
        f0Var.e(hVar4, hVar5, fO);
        androidx.constraintlayout.core.motion.utils.b bVar = this.f2568r;
        if (bVar != null) {
            double[] dArr = this.f2575y;
            if (dArr.length > 0) {
                double d8 = fO;
                bVar.d(d8, dArr);
                this.f2568r.g(d8, this.f2576z);
                this.f2563m.t(f9, f10, fArr, this.f2574x, this.f2576z, this.f2575y);
            }
            f0Var.a(f9, f10, i7, i8, fArr);
            return;
        }
        int i9 = 0;
        if (this.f2567q == null) {
            e eVar = this.f2564n;
            float f11 = eVar.f2616e;
            e eVar2 = this.f2563m;
            float f12 = f11 - eVar2.f2616e;
            h hVar6 = hVar5;
            float f13 = eVar.f2617f - eVar2.f2617f;
            h hVar7 = hVar4;
            float f14 = (eVar.f2618g - eVar2.f2618g) + f12;
            float f15 = (eVar.f2619h - eVar2.f2619h) + f13;
            fArr[0] = (f12 * (1.0f - f9)) + (f14 * f9);
            fArr[1] = (f13 * (1.0f - f10)) + (f15 * f10);
            f0Var.b();
            f0Var.d(oVar3, fO);
            f0Var.h(oVar, oVar2, fO);
            f0Var.f(oVar4, oVar5, fO);
            f0Var.c(hVar3, fO);
            f0Var.g(hVar, hVar2, fO);
            f0Var.e(hVar7, hVar6, fO);
            f0Var.a(f9, f10, i7, i8, fArr);
            return;
        }
        double dO = o(fO, this.F);
        this.f2567q[0].g(dO, this.f2576z);
        this.f2567q[0].d(dO, this.f2575y);
        float f16 = this.F[0];
        while (true) {
            double[] dArr2 = this.f2576z;
            if (i9 >= dArr2.length) {
                this.f2563m.t(f9, f10, fArr, this.f2574x, dArr2, this.f2575y);
                f0Var.a(f9, f10, i7, i8, fArr);
                return;
            } else {
                dArr2[i9] = dArr2[i9] * ((double) f16);
                i9++;
            }
        }
    }

    public float J() {
        return this.f2563m.f2619h;
    }

    public float K() {
        return this.f2563m.f2618g;
    }

    public float L() {
        return this.f2563m.f2616e;
    }

    public float M() {
        return this.f2563m.f2617f;
    }

    public int N() {
        return this.M;
    }

    public f O() {
        return this.f2559i;
    }

    public boolean Q(f fVar, float f8, long j7, androidx.constraintlayout.core.motion.utils.g gVar) {
        float fO = o(f8, null);
        int i7 = this.O;
        if (i7 != -1) {
            float f9 = 1.0f / i7;
            float fFloor = ((float) Math.floor(fO / f9)) * f9;
            float f10 = (fO % f9) / f9;
            if (!Float.isNaN(this.P)) {
                f10 = (f10 + this.P) % 1.0f;
            }
            androidx.constraintlayout.core.motion.utils.c cVar = this.Q;
            fO = ((cVar != null ? cVar.getInterpolation(f10) : ((double) f10) > 0.5d ? 1.0f : 0.0f) * f9) + fFloor;
        }
        float f11 = fO;
        HashMap<String, o> map = this.I;
        if (map != null) {
            Iterator<o> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().h(fVar, f11);
            }
        }
        androidx.constraintlayout.core.motion.utils.b[] bVarArr = this.f2567q;
        if (bVarArr != null) {
            double d8 = f11;
            bVarArr[0].d(d8, this.f2575y);
            this.f2567q[0].g(d8, this.f2576z);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f2568r;
            if (bVar != null) {
                double[] dArr = this.f2575y;
                if (dArr.length > 0) {
                    bVar.d(d8, dArr);
                    this.f2568r.g(d8, this.f2576z);
                }
            }
            if (!this.R) {
                this.f2563m.u(f11, fVar, this.f2574x, this.f2575y, this.f2576z, null);
            }
            if (this.M != -1) {
                if (this.N == null) {
                    this.N = fVar.n().f(this.M);
                }
                f fVar2 = this.N;
                if (fVar2 != null) {
                    float fW = (fVar2.w() + this.N.h()) / 2.0f;
                    float fL = (this.N.l() + this.N.q()) / 2.0f;
                    if (fVar.q() - fVar.l() > 0 && fVar.h() - fVar.w() > 0) {
                        float fL2 = fL - fVar.l();
                        float fW2 = fW - fVar.w();
                        fVar.N(fL2);
                        fVar.O(fW2);
                    }
                }
            }
            int i8 = 1;
            while (true) {
                androidx.constraintlayout.core.motion.utils.b[] bVarArr2 = this.f2567q;
                if (i8 >= bVarArr2.length) {
                    break;
                }
                bVarArr2[i8].e(d8, this.D);
                this.f2563m.f2626o.get(this.A[i8 - 1]).w(fVar, this.D);
                i8++;
            }
            d dVar = this.f2565o;
            if (dVar.f2580b == 0) {
                if (f11 <= 0.0f) {
                    fVar.b0(dVar.f2581c);
                } else if (f11 >= 1.0f) {
                    fVar.b0(this.f2566p.f2581c);
                } else if (this.f2566p.f2581c != dVar.f2581c) {
                    fVar.b0(4);
                }
            }
            if (this.K != null) {
                int i9 = 0;
                while (true) {
                    g[] gVarArr = this.K;
                    if (i9 >= gVarArr.length) {
                        break;
                    }
                    gVarArr[i9].v(f11, fVar);
                    i9++;
                }
            }
        } else {
            e eVar = this.f2563m;
            float f12 = eVar.f2616e;
            e eVar2 = this.f2564n;
            float f13 = f12 + ((eVar2.f2616e - f12) * f11);
            float f14 = eVar.f2617f;
            float f15 = f14 + ((eVar2.f2617f - f14) * f11);
            float f16 = eVar.f2618g;
            float f17 = f16 + ((eVar2.f2618g - f16) * f11);
            float f18 = eVar.f2619h;
            float f19 = f13 + 0.5f;
            float f20 = f15 + 0.5f;
            fVar.G((int) f19, (int) f20, (int) (f19 + f17), (int) (f20 + f18 + ((eVar2.f2619h - f18) * f11)));
        }
        HashMap<String, h> map2 = this.f2557J;
        if (map2 == null) {
            return false;
        }
        for (h hVar : map2.values()) {
            if (hVar instanceof h.f) {
                double[] dArr2 = this.f2576z;
                ((h.f) hVar).l(fVar, f11, dArr2[0], dArr2[1]);
            } else {
                hVar.h(fVar, f11);
            }
        }
        return false;
    }

    String R() {
        return this.f2559i.m();
    }

    void S(f fVar, androidx.constraintlayout.core.motion.key.e eVar, float f8, float f9, String[] strArr, float[] fArr) {
        androidx.constraintlayout.core.motion.utils.e eVar2 = new androidx.constraintlayout.core.motion.utils.e();
        e eVar3 = this.f2563m;
        float f10 = eVar3.f2616e;
        eVar2.f2795b = f10;
        float f11 = eVar3.f2617f;
        eVar2.f2797d = f11;
        eVar2.f2796c = f10 + eVar3.f2618g;
        eVar2.f2794a = f11 + eVar3.f2619h;
        androidx.constraintlayout.core.motion.utils.e eVar4 = new androidx.constraintlayout.core.motion.utils.e();
        e eVar5 = this.f2564n;
        float f12 = eVar5.f2616e;
        eVar4.f2795b = f12;
        float f13 = eVar5.f2617f;
        eVar4.f2797d = f13;
        eVar4.f2796c = f12 + eVar5.f2618g;
        eVar4.f2794a = f13 + eVar5.f2619h;
        eVar.C(fVar, eVar2, eVar4, f8, f9, strArr, fArr);
    }

    void U(m mVar, m mVar2, int i7, int i8, int i9) {
        if (i7 == 1) {
            int i10 = mVar.f2900b + mVar.f2901c;
            mVar2.f2900b = ((mVar.f2902d + mVar.f2899a) - mVar.b()) / 2;
            mVar2.f2902d = i9 - ((i10 + mVar.a()) / 2);
            mVar2.f2901c = mVar2.f2900b + mVar.b();
            mVar2.f2899a = mVar2.f2902d + mVar.a();
            return;
        }
        if (i7 == 2) {
            int i11 = mVar.f2900b + mVar.f2901c;
            mVar2.f2900b = i8 - (((mVar.f2902d + mVar.f2899a) + mVar.b()) / 2);
            mVar2.f2902d = (i11 - mVar.a()) / 2;
            mVar2.f2901c = mVar2.f2900b + mVar.b();
            mVar2.f2899a = mVar2.f2902d + mVar.a();
            return;
        }
        if (i7 == 3) {
            int i12 = mVar.f2900b + mVar.f2901c;
            mVar2.f2900b = ((mVar.a() / 2) + mVar.f2902d) - (i12 / 2);
            mVar2.f2902d = i9 - ((i12 + mVar.a()) / 2);
            mVar2.f2901c = mVar2.f2900b + mVar.b();
            mVar2.f2899a = mVar2.f2902d + mVar.a();
            return;
        }
        if (i7 != 4) {
            return;
        }
        int i13 = mVar.f2900b + mVar.f2901c;
        mVar2.f2900b = i8 - (((mVar.f2899a + mVar.f2902d) + mVar.b()) / 2);
        mVar2.f2902d = (i13 - mVar.a()) / 2;
        mVar2.f2901c = mVar2.f2900b + mVar.b();
        mVar2.f2899a = mVar2.f2902d + mVar.a();
    }

    void V(f fVar) {
        e eVar = this.f2563m;
        eVar.f2614c = 0.0f;
        eVar.f2615d = 0.0f;
        this.R = true;
        eVar.s(fVar.E(), fVar.F(), fVar.D(), fVar.k());
        this.f2564n.s(fVar.E(), fVar.F(), fVar.D(), fVar.k());
        this.f2565o.l(fVar);
        this.f2566p.l(fVar);
    }

    public void W(int i7) {
        this.f2563m.f2613b = i7;
    }

    public void X(f fVar) {
        e eVar = this.f2564n;
        eVar.f2614c = 1.0f;
        eVar.f2615d = 1.0f;
        T(eVar);
        this.f2564n.s(fVar.l(), fVar.w(), fVar.D(), fVar.k());
        this.f2564n.a(fVar);
        this.f2566p.l(fVar);
    }

    public void Y(int i7) {
        this.L = i7;
    }

    public void Z(f fVar) {
        e eVar = this.f2563m;
        eVar.f2614c = 0.0f;
        eVar.f2615d = 0.0f;
        eVar.s(fVar.E(), fVar.F(), fVar.D(), fVar.k());
        this.f2563m.a(fVar);
        this.f2565o.l(fVar);
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean a(int i7, int i8) {
        if (i7 != 509) {
            return i7 == 704;
        }
        Y(i8);
        return true;
    }

    public void a0(g0 g0Var, f fVar, int i7, int i8, int i9) {
        e eVar = this.f2563m;
        eVar.f2614c = 0.0f;
        eVar.f2615d = 0.0f;
        m mVar = new m();
        if (i7 == 1) {
            int i10 = g0Var.f2818b + g0Var.f2820d;
            mVar.f2900b = ((g0Var.f2819c + g0Var.f2821e) - g0Var.c()) / 2;
            mVar.f2902d = i8 - ((i10 + g0Var.b()) / 2);
            mVar.f2901c = mVar.f2900b + g0Var.c();
            mVar.f2899a = mVar.f2902d + g0Var.b();
        } else if (i7 == 2) {
            int i11 = g0Var.f2818b + g0Var.f2820d;
            mVar.f2900b = i9 - (((g0Var.f2819c + g0Var.f2821e) + g0Var.c()) / 2);
            mVar.f2902d = (i11 - g0Var.b()) / 2;
            mVar.f2901c = mVar.f2900b + g0Var.c();
            mVar.f2899a = mVar.f2902d + g0Var.b();
        }
        this.f2563m.s(mVar.f2900b, mVar.f2902d, mVar.b(), mVar.a());
        this.f2565o.m(mVar, fVar, i7, g0Var.f2817a);
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean b(int i7, float f8) {
        return false;
    }

    public void b0(int i7) {
        this.M = i7;
        this.N = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean c(int i7, String str) {
        if (705 == i7) {
            System.out.println("TYPE_INTERPOLATOR  " + str);
            this.Q = A(-1, str, 0);
        }
        return false;
    }

    public void c0(f fVar) {
        this.f2559i = fVar;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean d(int i7, boolean z7) {
        return false;
    }

    public void d0(int i7, int i8, float f8, long j7) {
        ArrayList arrayList;
        String[] strArr;
        int i9;
        b bVar;
        o oVarF;
        b bVar2;
        Integer num;
        o oVarF2;
        b bVar3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i10 = this.L;
        if (i10 != -1) {
            this.f2563m.f2622k = i10;
        }
        this.f2565o.e(this.f2566p, hashSet2);
        ArrayList<androidx.constraintlayout.core.motion.key.b> arrayList2 = this.G;
        if (arrayList2 != null) {
            arrayList = null;
            for (androidx.constraintlayout.core.motion.key.b bVar4 : arrayList2) {
                if (bVar4 instanceof androidx.constraintlayout.core.motion.key.e) {
                    androidx.constraintlayout.core.motion.key.e eVar = (androidx.constraintlayout.core.motion.key.e) bVar4;
                    P(new e(i7, i8, eVar, this.f2563m, this.f2564n));
                    int i11 = eVar.f2712y;
                    if (i11 != -1) {
                        this.f2562l = i11;
                    }
                } else if (bVar4 instanceof androidx.constraintlayout.core.motion.key.d) {
                    bVar4.i(hashSet3);
                } else if (bVar4 instanceof androidx.constraintlayout.core.motion.key.f) {
                    bVar4.i(hashSet);
                } else if (bVar4 instanceof g) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((g) bVar4);
                } else {
                    bVar4.q(map);
                    bVar4.i(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.K = (g[]) arrayList.toArray(new g[0]);
        }
        char c8 = 1;
        if (!hashSet2.isEmpty()) {
            this.I = new HashMap<>();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    i.b bVar5 = new i.b();
                    String str2 = str.split(",")[c8];
                    for (androidx.constraintlayout.core.motion.key.b bVar6 : this.G) {
                        HashMap<String, b> map2 = bVar6.f2699l;
                        if (map2 != null && (bVar3 = map2.get(str2)) != null) {
                            bVar5.a(bVar6.f2695h, bVar3);
                        }
                    }
                    oVarF2 = o.e(str, bVar5);
                } else {
                    oVarF2 = o.f(str, j7);
                }
                if (oVarF2 != null) {
                    oVarF2.i(str);
                    this.I.put(str, oVarF2);
                }
                c8 = 1;
            }
            ArrayList<androidx.constraintlayout.core.motion.key.b> arrayList3 = this.G;
            if (arrayList3 != null) {
                for (androidx.constraintlayout.core.motion.key.b bVar7 : arrayList3) {
                    if (bVar7 instanceof androidx.constraintlayout.core.motion.key.c) {
                        bVar7.f(this.I);
                    }
                }
            }
            this.f2565o.a(this.I, 0);
            this.f2566p.a(this.I, 100);
            for (String str3 : this.I.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = map.get(str3)) == null) ? 0 : num.intValue();
                o oVar = this.I.get(str3);
                if (oVar != null) {
                    oVar.j(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.H == null) {
                this.H = new HashMap<>();
            }
            for (String str4 : hashSet) {
                if (!this.H.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        i.b bVar8 = new i.b();
                        String str5 = str4.split(",")[1];
                        for (androidx.constraintlayout.core.motion.key.b bVar9 : this.G) {
                            HashMap<String, b> map3 = bVar9.f2699l;
                            if (map3 != null && (bVar2 = map3.get(str5)) != null) {
                                bVar8.a(bVar9.f2695h, bVar2);
                            }
                        }
                        oVarF = o.e(str4, bVar8);
                    } else {
                        oVarF = o.f(str4, j7);
                    }
                    if (oVarF != null) {
                        oVarF.i(str4);
                    }
                }
            }
            ArrayList<androidx.constraintlayout.core.motion.key.b> arrayList4 = this.G;
            if (arrayList4 != null) {
                for (androidx.constraintlayout.core.motion.key.b bVar10 : arrayList4) {
                    if (bVar10 instanceof androidx.constraintlayout.core.motion.key.f) {
                        ((androidx.constraintlayout.core.motion.key.f) bVar10).v(this.H);
                    }
                }
            }
            for (String str6 : this.H.keySet()) {
                this.H.get(str6).f(map.containsKey(str6) ? map.get(str6).intValue() : 0);
            }
        }
        int i12 = 2;
        int size = this.E.size() + 2;
        e[] eVarArr = new e[size];
        eVarArr[0] = this.f2563m;
        eVarArr[size - 1] = this.f2564n;
        if (this.E.size() > 0 && this.f2562l == androidx.constraintlayout.core.motion.key.b.f2683m) {
            this.f2562l = 0;
        }
        Iterator<e> it = this.E.iterator();
        int i13 = 1;
        while (it.hasNext()) {
            eVarArr[i13] = it.next();
            i13++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.f2564n.f2626o.keySet()) {
            if (this.f2563m.f2626o.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.A = strArr2;
        this.B = new int[strArr2.length];
        int i14 = 0;
        while (true) {
            strArr = this.A;
            if (i14 >= strArr.length) {
                break;
            }
            String str8 = strArr[i14];
            this.B[i14] = 0;
            for (int i15 = 0; i15 < size; i15++) {
                if (eVarArr[i15].f2626o.containsKey(str8) && (bVar = eVarArr[i15].f2626o.get(str8)) != null) {
                    int[] iArr = this.B;
                    iArr[i14] = iArr[i14] + bVar.r();
                    break;
                }
            }
            i14++;
        }
        boolean z7 = eVarArr[0].f2622k != -1;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i16 = 1; i16 < size; i16++) {
            eVarArr[i16].e(eVarArr[i16 - 1], zArr, this.A, z7);
        }
        int i17 = 0;
        for (int i18 = 1; i18 < length; i18++) {
            if (zArr[i18]) {
                i17++;
            }
        }
        this.f2574x = new int[i17];
        int iMax = Math.max(2, i17);
        this.f2575y = new double[iMax];
        this.f2576z = new double[iMax];
        int i19 = 0;
        for (int i20 = 1; i20 < length; i20++) {
            if (zArr[i20]) {
                this.f2574x[i19] = i20;
                i19++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, this.f2574x.length);
        double[] dArr2 = new double[size];
        for (int i21 = 0; i21 < size; i21++) {
            eVarArr[i21].f(dArr[i21], this.f2574x);
            dArr2[i21] = eVarArr[i21].f2614c;
        }
        int i22 = 0;
        while (true) {
            int[] iArr2 = this.f2574x;
            if (i22 >= iArr2.length) {
                break;
            }
            if (iArr2[i22] < e.F.length) {
                String str9 = e.F[this.f2574x[i22]] + " [";
                for (int i23 = 0; i23 < size; i23++) {
                    str9 = str9 + dArr[i23][i22];
                }
            }
            i22++;
        }
        this.f2567q = new androidx.constraintlayout.core.motion.utils.b[this.A.length + 1];
        int i24 = 0;
        while (true) {
            String[] strArr3 = this.A;
            if (i24 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i24];
            int i25 = 0;
            int i26 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i25 < size) {
                if (eVarArr[i25].n(str10)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr3 = new int[i12];
                        iArr3[1] = eVarArr[i25].l(str10);
                        i9 = 0;
                        iArr3[0] = size;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                    } else {
                        i9 = 0;
                    }
                    e eVar2 = eVarArr[i25];
                    dArr3[i26] = eVar2.f2614c;
                    eVar2.k(str10, dArr4[i26], i9);
                    i26++;
                }
                i25++;
                eVarArr = eVarArr;
                i12 = 2;
            }
            i24++;
            this.f2567q[i24] = androidx.constraintlayout.core.motion.utils.b.a(this.f2562l, Arrays.copyOf(dArr3, i26), (double[][]) Arrays.copyOf(dArr4, i26));
            eVarArr = eVarArr;
            i12 = 2;
        }
        e[] eVarArr2 = eVarArr;
        this.f2567q[0] = androidx.constraintlayout.core.motion.utils.b.a(this.f2562l, dArr2, dArr);
        if (eVarArr2[0].f2622k != -1) {
            int[] iArr4 = new int[size];
            double[] dArr5 = new double[size];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 2);
            for (int i27 = 0; i27 < size; i27++) {
                e eVar3 = eVarArr2[i27];
                iArr4[i27] = eVar3.f2622k;
                dArr5[i27] = eVar3.f2614c;
                double[] dArr7 = dArr6[i27];
                dArr7[0] = eVar3.f2616e;
                dArr7[1] = eVar3.f2617f;
            }
            this.f2568r = androidx.constraintlayout.core.motion.utils.b.b(iArr4, dArr5, dArr6);
        }
        this.f2557J = new HashMap<>();
        if (this.G != null) {
            float fI = Float.NaN;
            for (String str11 : hashSet3) {
                h hVarD = h.d(str11);
                if (hVarD != null) {
                    if (hVarD.k() && Float.isNaN(fI)) {
                        fI = I();
                    }
                    hVarD.i(str11);
                    this.f2557J.put(str11, hVarD);
                }
            }
            for (androidx.constraintlayout.core.motion.key.b bVar11 : this.G) {
                if (bVar11 instanceof androidx.constraintlayout.core.motion.key.d) {
                    ((androidx.constraintlayout.core.motion.key.d) bVar11).v(this.f2557J);
                }
            }
            Iterator<h> it2 = this.f2557J.values().iterator();
            while (it2.hasNext()) {
                it2.next().j(fI);
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public int e(String str) {
        return 0;
    }

    public void e0(c cVar) {
        this.f2563m.v(cVar, cVar.f2563m);
        this.f2564n.v(cVar, cVar.f2564n);
    }

    public void f(androidx.constraintlayout.core.motion.key.b bVar) {
        this.G.add(bVar);
    }

    void g(ArrayList<androidx.constraintlayout.core.motion.key.b> arrayList) {
        this.G.addAll(arrayList);
    }

    void h(float[] fArr, int i7) {
        float f8 = 1.0f / (i7 - 1);
        HashMap<String, o> map = this.I;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, o> map2 = this.I;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, h> map3 = this.f2557J;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, h> map4 = this.f2557J;
        if (map4 != null) {
            map4.get("translationY");
        }
        for (int i8 = 0; i8 < i7; i8++) {
            float fMin = i8 * f8;
            float f9 = this.f2571u;
            float f10 = 0.0f;
            if (f9 != 1.0f) {
                float f11 = this.f2570t;
                if (fMin < f11) {
                    fMin = 0.0f;
                }
                if (fMin > f11 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f11) * f9, 1.0f);
                }
            }
            double dA = fMin;
            androidx.constraintlayout.core.motion.utils.d dVar = this.f2563m.f2612a;
            float f12 = Float.NaN;
            for (e eVar : this.E) {
                androidx.constraintlayout.core.motion.utils.d dVar2 = eVar.f2612a;
                if (dVar2 != null) {
                    float f13 = eVar.f2614c;
                    if (f13 < fMin) {
                        dVar = dVar2;
                        f10 = f13;
                    } else if (Float.isNaN(f12)) {
                        f12 = eVar.f2614c;
                    }
                }
            }
            if (dVar != null) {
                if (Float.isNaN(f12)) {
                    f12 = 1.0f;
                }
                float f14 = f12 - f10;
                dA = (((float) dVar.a((fMin - f10) / f14)) * f14) + f10;
            }
            this.f2567q[0].d(dA, this.f2575y);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f2568r;
            if (bVar != null) {
                double[] dArr = this.f2575y;
                if (dArr.length > 0) {
                    bVar.d(dA, dArr);
                }
            }
            this.f2563m.g(this.f2574x, this.f2575y, fArr, i8 * 2);
        }
    }

    int i(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrH = this.f2567q[0].h();
        if (iArr != null) {
            Iterator<e> it = this.E.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                iArr[i7] = it.next().f2627p;
                i7++;
            }
        }
        int i8 = 0;
        for (double d8 : dArrH) {
            this.f2567q[0].d(d8, this.f2575y);
            this.f2563m.g(this.f2574x, this.f2575y, fArr, i8);
            i8 += 2;
        }
        return i8 / 2;
    }

    public int j(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrH = this.f2567q[0].h();
        if (iArr != null) {
            Iterator<e> it = this.E.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                iArr[i7] = it.next().f2627p;
                i7++;
            }
        }
        if (iArr2 != null) {
            Iterator<e> it2 = this.E.iterator();
            int i8 = 0;
            while (it2.hasNext()) {
                iArr2[i8] = (int) (it2.next().f2615d * 100.0f);
                i8++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < dArrH.length; i10++) {
            this.f2567q[0].d(dArrH[i10], this.f2575y);
            this.f2563m.h(dArrH[i10], this.f2574x, this.f2575y, fArr, i9);
            i9 += 2;
        }
        return i9 / 2;
    }

    public void k(float[] fArr, int i7) {
        double dA;
        float f8 = 1.0f;
        float f9 = 1.0f / (i7 - 1);
        HashMap<String, o> map = this.I;
        o oVar = map == null ? null : map.get("translationX");
        HashMap<String, o> map2 = this.I;
        o oVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, h> map3 = this.f2557J;
        h hVar = map3 == null ? null : map3.get("translationX");
        HashMap<String, h> map4 = this.f2557J;
        h hVar2 = map4 != null ? map4.get("translationY") : null;
        int i8 = 0;
        while (i8 < i7) {
            float fMin = i8 * f9;
            float f10 = this.f2571u;
            float f11 = 0.0f;
            if (f10 != f8) {
                float f12 = this.f2570t;
                if (fMin < f12) {
                    fMin = 0.0f;
                }
                if (fMin > f12 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f12) * f10, f8);
                }
            }
            float f13 = fMin;
            double d8 = f13;
            androidx.constraintlayout.core.motion.utils.d dVar = this.f2563m.f2612a;
            float f14 = Float.NaN;
            for (e eVar : this.E) {
                androidx.constraintlayout.core.motion.utils.d dVar2 = eVar.f2612a;
                double d9 = d8;
                if (dVar2 != null) {
                    float f15 = eVar.f2614c;
                    if (f15 < f13) {
                        f11 = f15;
                        dVar = dVar2;
                    } else if (Float.isNaN(f14)) {
                        f14 = eVar.f2614c;
                    }
                }
                d8 = d9;
            }
            double d10 = d8;
            if (dVar != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                float f16 = f14 - f11;
                dA = (((float) dVar.a((f13 - f11) / f16)) * f16) + f11;
            } else {
                dA = d10;
            }
            this.f2567q[0].d(dA, this.f2575y);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f2568r;
            if (bVar != null) {
                double[] dArr = this.f2575y;
                if (dArr.length > 0) {
                    bVar.d(dA, dArr);
                }
            }
            int i9 = i8 * 2;
            int i10 = i8;
            this.f2563m.h(dA, this.f2574x, this.f2575y, fArr, i9);
            if (hVar != null) {
                fArr[i9] = fArr[i9] + hVar.a(f13);
            } else if (oVar != null) {
                fArr[i9] = fArr[i9] + oVar.a(f13);
            }
            if (hVar2 != null) {
                int i11 = i9 + 1;
                fArr[i11] = fArr[i11] + hVar2.a(f13);
            } else if (oVar2 != null) {
                int i12 = i9 + 1;
                fArr[i12] = fArr[i12] + oVar2.a(f13);
            }
            i8 = i10 + 1;
            f8 = 1.0f;
        }
    }

    public void l(float f8, float[] fArr, int i7) {
        this.f2567q[0].d(o(f8, null), this.f2575y);
        this.f2563m.m(this.f2574x, this.f2575y, fArr, i7);
    }

    void m(float[] fArr, int i7) {
        float f8 = 1.0f / (i7 - 1);
        for (int i8 = 0; i8 < i7; i8++) {
            this.f2567q[0].d(o(i8 * f8, null), this.f2575y);
            this.f2563m.m(this.f2574x, this.f2575y, fArr, i8 * 8);
        }
    }

    void n(boolean z7) {
    }

    public int p() {
        return this.f2563m.f2623l;
    }

    int q(String str, float[] fArr, int i7) {
        o oVar = this.I.get(str);
        if (oVar == null) {
            return -1;
        }
        for (int i8 = 0; i8 < fArr.length; i8++) {
            fArr[i8] = oVar.a(i8 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void r(double d8, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f2567q[0].d(d8, dArr);
        this.f2567q[0].g(d8, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f2563m.i(d8, this.f2574x, dArr, fArr, dArr2, fArr2);
    }

    public float s() {
        return this.f2572v;
    }

    public float t() {
        return this.f2573w;
    }

    public String toString() {
        return " start: x: " + this.f2563m.f2616e + " y: " + this.f2563m.f2617f + " end: x: " + this.f2564n.f2616e + " y: " + this.f2564n.f2617f;
    }

    void u(float f8, float f9, float f10, float[] fArr) {
        double[] dArr;
        float fO = o(f8, this.F);
        androidx.constraintlayout.core.motion.utils.b[] bVarArr = this.f2567q;
        int i7 = 0;
        if (bVarArr == null) {
            e eVar = this.f2564n;
            float f11 = eVar.f2616e;
            e eVar2 = this.f2563m;
            float f12 = f11 - eVar2.f2616e;
            float f13 = eVar.f2617f - eVar2.f2617f;
            float f14 = (eVar.f2618g - eVar2.f2618g) + f12;
            float f15 = (eVar.f2619h - eVar2.f2619h) + f13;
            fArr[0] = (f12 * (1.0f - f9)) + (f14 * f9);
            fArr[1] = (f13 * (1.0f - f10)) + (f15 * f10);
            return;
        }
        double d8 = fO;
        bVarArr[0].g(d8, this.f2576z);
        this.f2567q[0].d(d8, this.f2575y);
        float f16 = this.F[0];
        while (true) {
            dArr = this.f2576z;
            if (i7 >= dArr.length) {
                break;
            }
            dArr[i7] = dArr[i7] * ((double) f16);
            i7++;
        }
        androidx.constraintlayout.core.motion.utils.b bVar = this.f2568r;
        if (bVar == null) {
            this.f2563m.t(f9, f10, fArr, this.f2574x, dArr, this.f2575y);
            return;
        }
        double[] dArr2 = this.f2575y;
        if (dArr2.length > 0) {
            bVar.d(d8, dArr2);
            this.f2568r.g(d8, this.f2576z);
            this.f2563m.t(f9, f10, fArr, this.f2574x, this.f2576z, this.f2575y);
        }
    }

    public int v() {
        int iMax = this.f2563m.f2613b;
        Iterator<e> it = this.E.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f2613b);
        }
        return Math.max(iMax, this.f2564n.f2613b);
    }

    public float w() {
        return this.f2564n.f2619h;
    }

    public float x() {
        return this.f2564n.f2618g;
    }

    public float y() {
        return this.f2564n.f2616e;
    }

    public float z() {
        return this.f2564n.f2617f;
    }
}
