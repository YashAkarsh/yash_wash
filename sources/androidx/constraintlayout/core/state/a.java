package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.w;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f3228a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f3229a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h f3230b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f3231b0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    androidx.constraintlayout.core.state.b f3235d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    androidx.constraintlayout.core.state.b f3237e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Object f3239f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.e f3241g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private HashMap<String, Integer> f3243h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private HashMap<String, Float> f3245i0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f3232c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    androidx.constraintlayout.core.state.helpers.e f3234d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f3236e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3238f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f3240g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f3242h = -1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f3244i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f3246j = 0.5f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f3247k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f3248l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f3249m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f3250n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f3251o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f3252p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected int f3253q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected int f3254r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f3255s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f3256t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected int f3257u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected int f3258v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f3259w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f3260x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f3261y = Float.NaN;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    float f3262z = Float.NaN;
    float A = Float.NaN;
    float B = Float.NaN;
    float C = Float.NaN;
    float D = Float.NaN;
    float E = Float.NaN;
    float F = Float.NaN;
    float G = Float.NaN;
    float H = Float.NaN;
    float I = Float.NaN;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    int f3227J = 0;
    protected Object K = null;
    protected Object L = null;
    protected Object M = null;
    protected Object N = null;
    protected Object O = null;
    protected Object P = null;
    protected Object Q = null;
    protected Object R = null;
    protected Object S = null;
    protected Object T = null;
    protected Object U = null;
    protected Object V = null;
    Object W = null;
    Object X = null;
    Object Y = null;
    Object Z = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    h.c f3233c0 = null;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0039a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3263a;

        static {
            int[] iArr = new int[h.c.values().length];
            f3263a = iArr;
            try {
                iArr[h.c.LEFT_TO_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3263a[h.c.LEFT_TO_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3263a[h.c.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3263a[h.c.RIGHT_TO_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3263a[h.c.START_TO_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3263a[h.c.START_TO_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3263a[h.c.END_TO_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3263a[h.c.END_TO_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3263a[h.c.TOP_TO_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3263a[h.c.TOP_TO_BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3263a[h.c.BOTTOM_TO_TOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3263a[h.c.BOTTOM_TO_BOTTOM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3263a[h.c.BASELINE_TO_BOTTOM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3263a[h.c.BASELINE_TO_TOP.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3263a[h.c.BASELINE_TO_BASELINE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3263a[h.c.CIRCULAR_CONSTRAINT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3263a[h.c.CENTER_HORIZONTALLY.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f3263a[h.c.CENTER_VERTICALLY.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public interface b {
        a a(h hVar);
    }

    static class c extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList<String> f3264a;

        public c(ArrayList<String> arrayList) {
            this.f3264a = arrayList;
        }

        public ArrayList<String> a() {
            return this.f3264a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.f3264a.toString();
        }
    }

    public a(h hVar) {
        Object obj = androidx.constraintlayout.core.state.b.f3266j;
        this.f3235d0 = androidx.constraintlayout.core.state.b.b(obj);
        this.f3237e0 = androidx.constraintlayout.core.state.b.b(obj);
        this.f3243h0 = new HashMap<>();
        this.f3245i0 = new HashMap<>();
        this.f3230b = hVar;
    }

    private Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        return !(obj instanceof a) ? this.f3230b.r(obj) : obj;
    }

    private androidx.constraintlayout.core.widgets.e O(Object obj) {
        if (obj instanceof e) {
            return ((e) obj).a();
        }
        return null;
    }

    private void h(androidx.constraintlayout.core.widgets.e eVar, Object obj, h.c cVar) {
        androidx.constraintlayout.core.widgets.e eVarO = O(obj);
        if (eVarO == null) {
        }
        int[] iArr = C0039a.f3263a;
        int i7 = iArr[cVar.ordinal()];
        switch (iArr[cVar.ordinal()]) {
            case 1:
                androidx.constraintlayout.core.widgets.d.b bVar = androidx.constraintlayout.core.widgets.d.b.LEFT;
                eVar.r(bVar).b(eVarO.r(bVar), this.f3247k, this.f3253q, false);
                break;
            case 2:
                eVar.r(androidx.constraintlayout.core.widgets.d.b.LEFT).b(eVarO.r(androidx.constraintlayout.core.widgets.d.b.RIGHT), this.f3247k, this.f3253q, false);
                break;
            case 3:
                eVar.r(androidx.constraintlayout.core.widgets.d.b.RIGHT).b(eVarO.r(androidx.constraintlayout.core.widgets.d.b.LEFT), this.f3248l, this.f3254r, false);
                break;
            case 4:
                androidx.constraintlayout.core.widgets.d.b bVar2 = androidx.constraintlayout.core.widgets.d.b.RIGHT;
                eVar.r(bVar2).b(eVarO.r(bVar2), this.f3248l, this.f3254r, false);
                break;
            case 5:
                androidx.constraintlayout.core.widgets.d.b bVar3 = androidx.constraintlayout.core.widgets.d.b.LEFT;
                eVar.r(bVar3).b(eVarO.r(bVar3), this.f3249m, this.f3255s, false);
                break;
            case 6:
                eVar.r(androidx.constraintlayout.core.widgets.d.b.LEFT).b(eVarO.r(androidx.constraintlayout.core.widgets.d.b.RIGHT), this.f3249m, this.f3255s, false);
                break;
            case 7:
                eVar.r(androidx.constraintlayout.core.widgets.d.b.RIGHT).b(eVarO.r(androidx.constraintlayout.core.widgets.d.b.LEFT), this.f3250n, this.f3256t, false);
                break;
            case 8:
                androidx.constraintlayout.core.widgets.d.b bVar4 = androidx.constraintlayout.core.widgets.d.b.RIGHT;
                eVar.r(bVar4).b(eVarO.r(bVar4), this.f3250n, this.f3256t, false);
                break;
            case 9:
                androidx.constraintlayout.core.widgets.d.b bVar5 = androidx.constraintlayout.core.widgets.d.b.TOP;
                eVar.r(bVar5).b(eVarO.r(bVar5), this.f3251o, this.f3257u, false);
                break;
            case 10:
                eVar.r(androidx.constraintlayout.core.widgets.d.b.TOP).b(eVarO.r(androidx.constraintlayout.core.widgets.d.b.BOTTOM), this.f3251o, this.f3257u, false);
                break;
            case 11:
                eVar.r(androidx.constraintlayout.core.widgets.d.b.BOTTOM).b(eVarO.r(androidx.constraintlayout.core.widgets.d.b.TOP), this.f3252p, this.f3258v, false);
                break;
            case 12:
                androidx.constraintlayout.core.widgets.d.b bVar6 = androidx.constraintlayout.core.widgets.d.b.BOTTOM;
                eVar.r(bVar6).b(eVarO.r(bVar6), this.f3252p, this.f3258v, false);
                break;
            case 13:
                eVar.v0(androidx.constraintlayout.core.widgets.d.b.BASELINE, eVarO, androidx.constraintlayout.core.widgets.d.b.BOTTOM, this.f3259w, this.f3260x);
                break;
            case 14:
                eVar.v0(androidx.constraintlayout.core.widgets.d.b.BASELINE, eVarO, androidx.constraintlayout.core.widgets.d.b.TOP, this.f3259w, this.f3260x);
                break;
            case 15:
                androidx.constraintlayout.core.widgets.d.b bVar7 = androidx.constraintlayout.core.widgets.d.b.BASELINE;
                eVar.v0(bVar7, eVarO, bVar7, this.f3259w, this.f3260x);
                break;
            case 16:
                eVar.m(eVarO, this.f3229a0, (int) this.f3231b0);
                break;
        }
    }

    private void x() {
        this.K = B(this.K);
        this.L = B(this.L);
        this.M = B(this.M);
        this.N = B(this.N);
        this.O = B(this.O);
        this.P = B(this.P);
        this.Q = B(this.Q);
        this.R = B(this.R);
        this.S = B(this.S);
        this.T = B(this.T);
        this.U = B(this.U);
        this.V = B(this.V);
        this.W = B(this.W);
        this.X = B(this.X);
        this.Y = B(this.Y);
    }

    public a A(Object obj) {
        this.f3233c0 = h.c.END_TO_START;
        this.Q = obj;
        return this;
    }

    public a A0(Object obj) {
        this.f3233c0 = h.c.START_TO_START;
        this.O = obj;
        return this;
    }

    public a B0() {
        if (this.S != null) {
            this.f3233c0 = h.c.TOP_TO_TOP;
        } else {
            this.f3233c0 = h.c.TOP_TO_BOTTOM;
        }
        return this;
    }

    public float C() {
        return this.G;
    }

    public a C0(Object obj) {
        this.f3233c0 = h.c.TOP_TO_BOTTOM;
        this.T = obj;
        return this;
    }

    public androidx.constraintlayout.core.state.b D() {
        return this.f3237e0;
    }

    public a D0(Object obj) {
        this.f3233c0 = h.c.TOP_TO_TOP;
        this.S = obj;
        return this;
    }

    public int E() {
        return this.f3236e;
    }

    public a E0(float f8) {
        this.D = f8;
        return this;
    }

    public float F() {
        return this.f3240g;
    }

    public a F0(float f8) {
        this.E = f8;
        return this;
    }

    public float G() {
        return this.f3261y;
    }

    public a G0(float f8) {
        this.F = f8;
        return this;
    }

    public float H() {
        return this.f3262z;
    }

    public void H0() throws c {
        ArrayList arrayList = new ArrayList();
        if (this.K != null && this.L != null) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (this.M != null && this.N != null) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (this.O != null && this.P != null) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (this.Q != null && this.R != null) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if ((this.K != null || this.L != null || this.M != null || this.N != null) && (this.O != null || this.P != null || this.Q != null || this.R != null)) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() > 0) {
            throw new c(arrayList);
        }
    }

    public float I() {
        return this.A;
    }

    public a I0(float f8) {
        this.f3246j = f8;
        return this;
    }

    public float J() {
        return this.B;
    }

    public a J0(int i7) {
        this.f3227J = i7;
        return this;
    }

    public float K() {
        return this.C;
    }

    public a K0(androidx.constraintlayout.core.state.b bVar) {
        return x0(bVar);
    }

    public float L() {
        return this.H;
    }

    public float M() {
        return this.I;
    }

    public String N() {
        return this.f3232c;
    }

    public float P() {
        return this.D;
    }

    public float Q() {
        return this.E;
    }

    public float R() {
        return this.F;
    }

    public int S(int i7) {
        return this.f3238f;
    }

    public float T() {
        return this.f3242h;
    }

    public Object U() {
        return this.f3239f0;
    }

    public androidx.constraintlayout.core.state.b V() {
        return this.f3235d0;
    }

    public a W(androidx.constraintlayout.core.state.b bVar) {
        return q0(bVar);
    }

    public a X(float f8) {
        this.f3244i = f8;
        return this;
    }

    public a Y() {
        if (this.K != null) {
            this.f3233c0 = h.c.LEFT_TO_LEFT;
        } else {
            this.f3233c0 = h.c.LEFT_TO_RIGHT;
        }
        return this;
    }

    public a Z(Object obj) {
        this.f3233c0 = h.c.LEFT_TO_LEFT;
        this.K = obj;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.e
    public androidx.constraintlayout.core.widgets.e a() {
        if (this.f3241g0 == null) {
            androidx.constraintlayout.core.widgets.e eVarW = w();
            this.f3241g0 = eVarW;
            eVarW.h1(this.f3239f0);
        }
        return this.f3241g0;
    }

    public a a0(Object obj) {
        this.f3233c0 = h.c.LEFT_TO_RIGHT;
        this.L = obj;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.e
    public void apply() {
        if (this.f3241g0 == null) {
            return;
        }
        androidx.constraintlayout.core.state.helpers.e eVar = this.f3234d;
        if (eVar != null) {
            eVar.apply();
        }
        this.f3235d0.j(this.f3230b, this.f3241g0, 0);
        this.f3237e0.j(this.f3230b, this.f3241g0, 1);
        x();
        h(this.f3241g0, this.K, h.c.LEFT_TO_LEFT);
        h(this.f3241g0, this.L, h.c.LEFT_TO_RIGHT);
        h(this.f3241g0, this.M, h.c.RIGHT_TO_LEFT);
        h(this.f3241g0, this.N, h.c.RIGHT_TO_RIGHT);
        h(this.f3241g0, this.O, h.c.START_TO_START);
        h(this.f3241g0, this.P, h.c.START_TO_END);
        h(this.f3241g0, this.Q, h.c.END_TO_START);
        h(this.f3241g0, this.R, h.c.END_TO_END);
        h(this.f3241g0, this.S, h.c.TOP_TO_TOP);
        h(this.f3241g0, this.T, h.c.TOP_TO_BOTTOM);
        h(this.f3241g0, this.U, h.c.BOTTOM_TO_TOP);
        h(this.f3241g0, this.V, h.c.BOTTOM_TO_BOTTOM);
        h(this.f3241g0, this.W, h.c.BASELINE_TO_BASELINE);
        h(this.f3241g0, this.X, h.c.BASELINE_TO_TOP);
        h(this.f3241g0, this.Y, h.c.BASELINE_TO_BOTTOM);
        h(this.f3241g0, this.Z, h.c.CIRCULAR_CONSTRAINT);
        int i7 = this.f3236e;
        if (i7 != 0) {
            this.f3241g0.B1(i7);
        }
        int i8 = this.f3238f;
        if (i8 != 0) {
            this.f3241g0.W1(i8);
        }
        float f8 = this.f3240g;
        if (f8 != -1.0f) {
            this.f3241g0.F1(f8);
        }
        float f9 = this.f3242h;
        if (f9 != -1.0f) {
            this.f3241g0.a2(f9);
        }
        this.f3241g0.A1(this.f3244i);
        this.f3241g0.V1(this.f3246j);
        androidx.constraintlayout.core.widgets.e eVar2 = this.f3241g0;
        r rVar = eVar2.f3626n;
        rVar.f3398f = this.f3261y;
        rVar.f3399g = this.f3262z;
        rVar.f3400h = this.A;
        rVar.f3401i = this.B;
        rVar.f3402j = this.C;
        rVar.f3403k = this.D;
        rVar.f3404l = this.E;
        rVar.f3405m = this.F;
        rVar.f3406n = this.H;
        rVar.f3407o = this.I;
        rVar.f3408p = this.G;
        int i9 = this.f3227J;
        rVar.f3410r = i9;
        eVar2.b2(i9);
        HashMap<String, Integer> map = this.f3243h0;
        if (map != null) {
            for (String str : map.keySet()) {
                this.f3241g0.f3626n.w(str, w.b.f3037l, this.f3243h0.get(str).intValue());
            }
        }
        HashMap<String, Float> map2 = this.f3245i0;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                this.f3241g0.f3626n.v(str2, w.b.f3036k, this.f3245i0.get(str2).floatValue());
            }
        }
    }

    @Override // androidx.constraintlayout.core.state.e
    public void b(androidx.constraintlayout.core.widgets.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f3241g0 = eVar;
        eVar.h1(this.f3239f0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public a b0(int i7) {
        h.c cVar = this.f3233c0;
        if (cVar != null) {
            switch (C0039a.f3263a[cVar.ordinal()]) {
                case 1:
                case 2:
                    this.f3247k = i7;
                    break;
                case 3:
                case 4:
                    this.f3248l = i7;
                    break;
                case 5:
                case 6:
                    this.f3249m = i7;
                    break;
                case 7:
                case 8:
                    this.f3250n = i7;
                    break;
                case 9:
                case 10:
                    this.f3251o = i7;
                    break;
                case 11:
                case 12:
                    this.f3252p = i7;
                    break;
                case 13:
                case 14:
                case 15:
                    this.f3259w = i7;
                    break;
                case 16:
                    this.f3231b0 = i7;
                    break;
            }
        } else {
            this.f3247k = i7;
            this.f3248l = i7;
            this.f3249m = i7;
            this.f3250n = i7;
            this.f3251o = i7;
            this.f3252p = i7;
        }
        return this;
    }

    @Override // androidx.constraintlayout.core.state.e
    public void c(Object obj) {
        this.f3228a = obj;
    }

    public a c0(Object obj) {
        return b0(this.f3230b.f(obj));
    }

    @Override // androidx.constraintlayout.core.state.e
    public androidx.constraintlayout.core.state.helpers.e d() {
        return this.f3234d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public a d0(int i7) {
        h.c cVar = this.f3233c0;
        if (cVar != null) {
            switch (C0039a.f3263a[cVar.ordinal()]) {
                case 1:
                case 2:
                    this.f3253q = i7;
                    break;
                case 3:
                case 4:
                    this.f3254r = i7;
                    break;
                case 5:
                case 6:
                    this.f3255s = i7;
                    break;
                case 7:
                case 8:
                    this.f3256t = i7;
                    break;
                case 9:
                case 10:
                    this.f3257u = i7;
                    break;
                case 11:
                case 12:
                    this.f3258v = i7;
                    break;
                case 13:
                case 14:
                case 15:
                    this.f3260x = i7;
                    break;
            }
        } else {
            this.f3253q = i7;
            this.f3254r = i7;
            this.f3255s = i7;
            this.f3256t = i7;
            this.f3257u = i7;
            this.f3258v = i7;
        }
        return this;
    }

    public void e(String str, int i7) {
        this.f3243h0.put(str, Integer.valueOf(i7));
    }

    public a e0(Object obj) {
        return d0(this.f3230b.f(obj));
    }

    public void f(String str, float f8) {
        if (this.f3245i0 == null) {
            this.f3245i0 = new HashMap<>();
        }
        this.f3245i0.put(str, Float.valueOf(f8));
    }

    public a f0(float f8) {
        this.f3261y = f8;
        return this;
    }

    public a g(float f8) {
        this.G = f8;
        return this;
    }

    public a g0(float f8) {
        this.f3262z = f8;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.e
    public Object getKey() {
        return this.f3228a;
    }

    public a h0() {
        if (this.M != null) {
            this.f3233c0 = h.c.RIGHT_TO_LEFT;
        } else {
            this.f3233c0 = h.c.RIGHT_TO_RIGHT;
        }
        return this;
    }

    public a i() {
        this.f3233c0 = h.c.BASELINE_TO_BASELINE;
        return this;
    }

    public a i0(Object obj) {
        this.f3233c0 = h.c.RIGHT_TO_LEFT;
        this.M = obj;
        return this;
    }

    public a j(Object obj) {
        this.f3233c0 = h.c.BASELINE_TO_BASELINE;
        this.W = obj;
        return this;
    }

    public a j0(Object obj) {
        this.f3233c0 = h.c.RIGHT_TO_RIGHT;
        this.N = obj;
        return this;
    }

    public a k(Object obj) {
        this.f3233c0 = h.c.BASELINE_TO_BOTTOM;
        this.Y = obj;
        return this;
    }

    public a k0(float f8) {
        this.A = f8;
        return this;
    }

    public a l(Object obj) {
        this.f3233c0 = h.c.BASELINE_TO_TOP;
        this.X = obj;
        return this;
    }

    public a l0(float f8) {
        this.B = f8;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    /* JADX WARN: Code duplicated, block: B:12:0x001c  */
    public a m(float f8) {
        h.c cVar = this.f3233c0;
        if (cVar == null) {
            return this;
        }
        int i7 = C0039a.f3263a[cVar.ordinal()];
        if (i7 == 17) {
            this.f3244i = f8;
        } else if (i7 != 18) {
            switch (i7) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    this.f3244i = f8;
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                    this.f3246j = f8;
                    break;
            }
        } else {
            this.f3246j = f8;
        }
        return this;
    }

    public a m0(float f8) {
        this.C = f8;
        return this;
    }

    public a n() {
        if (this.U != null) {
            this.f3233c0 = h.c.BOTTOM_TO_TOP;
        } else {
            this.f3233c0 = h.c.BOTTOM_TO_BOTTOM;
        }
        return this;
    }

    public a n0(float f8) {
        this.H = f8;
        return this;
    }

    public a o(Object obj) {
        this.f3233c0 = h.c.BOTTOM_TO_BOTTOM;
        this.V = obj;
        return this;
    }

    public a o0(float f8) {
        this.I = f8;
        return this;
    }

    public a p(Object obj) {
        this.f3233c0 = h.c.BOTTOM_TO_TOP;
        this.U = obj;
        return this;
    }

    public void p0(androidx.constraintlayout.core.state.helpers.e eVar) {
        this.f3234d = eVar;
        if (eVar != null) {
            b(eVar.a());
        }
    }

    public a q(Object obj) {
        Object objB = B(obj);
        this.O = objB;
        this.R = objB;
        this.f3233c0 = h.c.CENTER_HORIZONTALLY;
        this.f3244i = 0.5f;
        return this;
    }

    public a q0(androidx.constraintlayout.core.state.b bVar) {
        this.f3237e0 = bVar;
        return this;
    }

    public a r(Object obj) {
        Object objB = B(obj);
        this.S = objB;
        this.V = objB;
        this.f3233c0 = h.c.CENTER_VERTICALLY;
        this.f3246j = 0.5f;
        return this;
    }

    public void r0(int i7) {
        this.f3236e = i7;
    }

    public a s(Object obj, float f8, float f9) {
        this.Z = B(obj);
        this.f3229a0 = f8;
        this.f3231b0 = f9;
        this.f3233c0 = h.c.CIRCULAR_CONSTRAINT;
        return this;
    }

    public void s0(float f8) {
        this.f3240g = f8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public a t() {
        h.c cVar = this.f3233c0;
        if (cVar != null) {
            switch (C0039a.f3263a[cVar.ordinal()]) {
                case 1:
                case 2:
                    this.K = null;
                    this.L = null;
                    this.f3247k = 0;
                    this.f3253q = 0;
                    break;
                case 3:
                case 4:
                    this.M = null;
                    this.N = null;
                    this.f3248l = 0;
                    this.f3254r = 0;
                    break;
                case 5:
                case 6:
                    this.O = null;
                    this.P = null;
                    this.f3249m = 0;
                    this.f3255s = 0;
                    break;
                case 7:
                case 8:
                    this.Q = null;
                    this.R = null;
                    this.f3250n = 0;
                    this.f3256t = 0;
                    break;
                case 9:
                case 10:
                    this.S = null;
                    this.T = null;
                    this.f3251o = 0;
                    this.f3257u = 0;
                    break;
                case 11:
                case 12:
                    this.U = null;
                    this.V = null;
                    this.f3252p = 0;
                    this.f3258v = 0;
                    break;
                case 15:
                    this.W = null;
                    break;
                case 16:
                    this.Z = null;
                    break;
            }
        } else {
            this.K = null;
            this.L = null;
            this.f3247k = 0;
            this.M = null;
            this.N = null;
            this.f3248l = 0;
            this.O = null;
            this.P = null;
            this.f3249m = 0;
            this.Q = null;
            this.R = null;
            this.f3250n = 0;
            this.S = null;
            this.T = null;
            this.f3251o = 0;
            this.U = null;
            this.V = null;
            this.f3252p = 0;
            this.W = null;
            this.Z = null;
            this.f3244i = 0.5f;
            this.f3246j = 0.5f;
            this.f3253q = 0;
            this.f3254r = 0;
            this.f3255s = 0;
            this.f3256t = 0;
            this.f3257u = 0;
            this.f3258v = 0;
        }
        return this;
    }

    public void t0(String str) {
        this.f3232c = str;
    }

    public a u() {
        y0().t();
        y().t();
        Y().t();
        h0().t();
        return this;
    }

    public void u0(int i7) {
        this.f3238f = i7;
    }

    public a v() {
        B0().t();
        i().t();
        n().t();
        return this;
    }

    public void v0(float f8) {
        this.f3242h = f8;
    }

    public androidx.constraintlayout.core.widgets.e w() {
        return new androidx.constraintlayout.core.widgets.e(V().n(), D().n());
    }

    public void w0(Object obj) {
        this.f3239f0 = obj;
        androidx.constraintlayout.core.widgets.e eVar = this.f3241g0;
        if (eVar != null) {
            eVar.h1(obj);
        }
    }

    public a x0(androidx.constraintlayout.core.state.b bVar) {
        this.f3235d0 = bVar;
        return this;
    }

    public a y() {
        if (this.Q != null) {
            this.f3233c0 = h.c.END_TO_START;
        } else {
            this.f3233c0 = h.c.END_TO_END;
        }
        return this;
    }

    public a y0() {
        if (this.O != null) {
            this.f3233c0 = h.c.START_TO_START;
        } else {
            this.f3233c0 = h.c.START_TO_END;
        }
        return this;
    }

    public a z(Object obj) {
        this.f3233c0 = h.c.END_TO_END;
        this.R = obj;
        return this;
    }

    public a z0(Object obj) {
        this.f3233c0 = h.c.START_TO_END;
        this.P = obj;
        return this;
    }
}
