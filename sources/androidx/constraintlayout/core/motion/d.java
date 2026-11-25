package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.e0;
import androidx.constraintlayout.core.motion.utils.m;
import androidx.constraintlayout.core.motion.utils.o;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class d implements Comparable<d> {
    public static final String D = "MotionPaths";
    public static final boolean E = false;
    static final int F = 1;
    static final int G = 2;
    static String[] H = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2581c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.d f2594p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f2596r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f2597s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f2598t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f2599u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f2600v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f2579a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2580b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2582d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2583e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2584f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f2585g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2586h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f2587i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f2588j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f2589k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f2590l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f2591m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f2592n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f2593o = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2595q = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f2601w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f2602x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f2603y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    LinkedHashMap<String, b> f2604z = new LinkedHashMap<>();
    int A = 0;
    double[] B = new double[18];
    double[] C = new double[18];

    private boolean d(float f8, float f9) {
        if (Float.isNaN(f8) || Float.isNaN(f9)) {
            return Float.isNaN(f8) != Float.isNaN(f9);
        }
        return Math.abs(f8 - f9) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(HashMap<String, o> map, int i7) {
        for (String str : map.keySet()) {
            o oVar = map.get(str);
            str.hashCode();
            byte b8 = -1;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        b8 = 0;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        b8 = 1;
                    }
                    break;
                case -1249320804:
                    if (str.equals("rotationZ")) {
                        b8 = 2;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        b8 = 3;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b8 = 4;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b8 = 5;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        b8 = 6;
                    }
                    break;
                case -987906986:
                    if (str.equals("pivotX")) {
                        b8 = 7;
                    }
                    break;
                case -987906985:
                    if (str.equals("pivotY")) {
                        b8 = 8;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b8 = 9;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b8 = 10;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b8 = com.google.common.base.c.f19313m;
                    }
                    break;
                case 803192288:
                    if (str.equals("pathRotate")) {
                        b8 = com.google.common.base.c.f19314n;
                    }
                    break;
            }
            switch (b8) {
                case 0:
                    oVar.g(i7, Float.isNaN(this.f2585g) ? 0.0f : this.f2585g);
                    break;
                case 1:
                    oVar.g(i7, Float.isNaN(this.f2586h) ? 0.0f : this.f2586h);
                    break;
                case 2:
                    oVar.g(i7, Float.isNaN(this.f2584f) ? 0.0f : this.f2584f);
                    break;
                case 3:
                    oVar.g(i7, Float.isNaN(this.f2591m) ? 0.0f : this.f2591m);
                    break;
                case 4:
                    oVar.g(i7, Float.isNaN(this.f2592n) ? 0.0f : this.f2592n);
                    break;
                case 5:
                    oVar.g(i7, Float.isNaN(this.f2593o) ? 0.0f : this.f2593o);
                    break;
                case 6:
                    oVar.g(i7, Float.isNaN(this.f2602x) ? 0.0f : this.f2602x);
                    break;
                case 7:
                    oVar.g(i7, Float.isNaN(this.f2589k) ? 0.0f : this.f2589k);
                    break;
                case 8:
                    oVar.g(i7, Float.isNaN(this.f2590l) ? 0.0f : this.f2590l);
                    break;
                case 9:
                    oVar.g(i7, Float.isNaN(this.f2587i) ? 1.0f : this.f2587i);
                    break;
                case 10:
                    oVar.g(i7, Float.isNaN(this.f2588j) ? 1.0f : this.f2588j);
                    break;
                case 11:
                    oVar.g(i7, Float.isNaN(this.f2579a) ? 1.0f : this.f2579a);
                    break;
                case 12:
                    oVar.g(i7, Float.isNaN(this.f2601w) ? 0.0f : this.f2601w);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.f2604z.containsKey(str2)) {
                            b bVar = this.f2604z.get(str2);
                            if (oVar instanceof o.c) {
                                ((o.c) oVar).k(i7, bVar);
                            } else {
                                e0.f("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i7 + ", value" + bVar.n() + oVar);
                            }
                        }
                    } else {
                        e0.f("MotionPaths", "UNKNOWN spline " + str);
                    }
                    break;
            }
        }
    }

    public void b(f fVar) {
        this.f2581c = fVar.B();
        this.f2579a = fVar.B() != 4 ? 0.0f : fVar.g();
        this.f2582d = false;
        this.f2584f = fVar.t();
        this.f2585g = fVar.r();
        this.f2586h = fVar.s();
        this.f2587i = fVar.u();
        this.f2588j = fVar.v();
        this.f2589k = fVar.o();
        this.f2590l = fVar.p();
        this.f2591m = fVar.x();
        this.f2592n = fVar.y();
        this.f2593o = fVar.z();
        for (String str : fVar.j()) {
            b bVarI = fVar.i(str);
            if (bVarI != null && bVarI.q()) {
                this.f2604z.put(str, bVarI);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        return Float.compare(this.f2596r, dVar.f2596r);
    }

    void e(d dVar, HashSet<String> hashSet) {
        if (d(this.f2579a, dVar.f2579a)) {
            hashSet.add("alpha");
        }
        if (d(this.f2583e, dVar.f2583e)) {
            hashSet.add("translationZ");
        }
        int i7 = this.f2581c;
        int i8 = dVar.f2581c;
        if (i7 != i8 && this.f2580b == 0 && (i7 == 4 || i8 == 4)) {
            hashSet.add("alpha");
        }
        if (d(this.f2584f, dVar.f2584f)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.f2601w) || !Float.isNaN(dVar.f2601w)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f2602x) || !Float.isNaN(dVar.f2602x)) {
            hashSet.add("progress");
        }
        if (d(this.f2585g, dVar.f2585g)) {
            hashSet.add("rotationX");
        }
        if (d(this.f2586h, dVar.f2586h)) {
            hashSet.add("rotationY");
        }
        if (d(this.f2589k, dVar.f2589k)) {
            hashSet.add("pivotX");
        }
        if (d(this.f2590l, dVar.f2590l)) {
            hashSet.add("pivotY");
        }
        if (d(this.f2587i, dVar.f2587i)) {
            hashSet.add("scaleX");
        }
        if (d(this.f2588j, dVar.f2588j)) {
            hashSet.add("scaleY");
        }
        if (d(this.f2591m, dVar.f2591m)) {
            hashSet.add("translationX");
        }
        if (d(this.f2592n, dVar.f2592n)) {
            hashSet.add("translationY");
        }
        if (d(this.f2593o, dVar.f2593o)) {
            hashSet.add("translationZ");
        }
        if (d(this.f2583e, dVar.f2583e)) {
            hashSet.add("elevation");
        }
    }

    void f(d dVar, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | d(this.f2596r, dVar.f2596r);
        zArr[1] = zArr[1] | d(this.f2597s, dVar.f2597s);
        zArr[2] = zArr[2] | d(this.f2598t, dVar.f2598t);
        zArr[3] = zArr[3] | d(this.f2599u, dVar.f2599u);
        zArr[4] = d(this.f2600v, dVar.f2600v) | zArr[4];
    }

    void g(double[] dArr, int[] iArr) {
        float[] fArr = {this.f2596r, this.f2597s, this.f2598t, this.f2599u, this.f2600v, this.f2579a, this.f2583e, this.f2584f, this.f2585g, this.f2586h, this.f2587i, this.f2588j, this.f2589k, this.f2590l, this.f2591m, this.f2592n, this.f2593o, this.f2601w};
        int i7 = 0;
        for (int i8 : iArr) {
            if (i8 < 18) {
                dArr[i7] = fArr[i8];
                i7++;
            }
        }
    }

    int h(String str, double[] dArr, int i7) {
        b bVar = this.f2604z.get(str);
        if (bVar.r() == 1) {
            dArr[i7] = bVar.n();
            return 1;
        }
        int iR = bVar.r();
        float[] fArr = new float[iR];
        bVar.o(fArr);
        int i8 = 0;
        while (i8 < iR) {
            dArr[i7] = fArr[i8];
            i8++;
            i7++;
        }
        return iR;
    }

    int i(String str) {
        return this.f2604z.get(str).r();
    }

    boolean j(String str) {
        return this.f2604z.containsKey(str);
    }

    void k(float f8, float f9, float f10, float f11) {
        this.f2597s = f8;
        this.f2598t = f9;
        this.f2599u = f10;
        this.f2600v = f11;
    }

    public void l(f fVar) {
        k(fVar.E(), fVar.F(), fVar.D(), fVar.k());
        b(fVar);
    }

    public void m(m mVar, f fVar, int i7, float f8) {
        k(mVar.f2900b, mVar.f2902d, mVar.b(), mVar.a());
        b(fVar);
        this.f2589k = Float.NaN;
        this.f2590l = Float.NaN;
        if (i7 == 1) {
            this.f2584f = f8 - 90.0f;
        } else {
            if (i7 != 2) {
                return;
            }
            this.f2584f = f8 + 90.0f;
        }
    }
}
