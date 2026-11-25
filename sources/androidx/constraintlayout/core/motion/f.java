package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.a0;
import androidx.constraintlayout.core.motion.utils.v;
import androidx.constraintlayout.core.motion.utils.w;
import androidx.constraintlayout.core.state.r;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f implements w {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = -1;
    public static final int D = -1;
    public static final int E = -2;
    public static final int F = Integer.MIN_VALUE;
    public static final int G = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f2631m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f2632n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f2633o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f2634p = -2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f2635q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f2636r = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f2637s = -3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f2638t = -4;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f2639u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f2640v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f2641w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f2642x = 3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f2643y = 4;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f2644z = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    r f2645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    a f2646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    b f2647j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f2648k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f2649l;

    public static class a {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int f2650n = -2;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final int f2651o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final int f2652p = -3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2653a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2654b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f2655c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2656d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2657e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f2658f = Float.NaN;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2659g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f2660h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f2661i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f2662j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f2663k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f2664l = -3;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2665m = -1;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2666a = 4;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2667b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2668c = 1.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2669d = Float.NaN;
    }

    public f() {
        this.f2645h = new r();
        this.f2646i = new a();
        this.f2647j = new b();
    }

    public float A(int i7) {
        switch (i7) {
            case 303:
                return this.f2645h.f3408p;
            case 304:
                return this.f2645h.f3403k;
            case 305:
                return this.f2645h.f3404l;
            case 306:
                return this.f2645h.f3405m;
            case 307:
            default:
                return Float.NaN;
            case 308:
                return this.f2645h.f3400h;
            case 309:
                return this.f2645h.f3401i;
            case 310:
                return this.f2645h.f3402j;
            case 311:
                return this.f2645h.f3406n;
            case 312:
                return this.f2645h.f3407o;
            case 313:
                return this.f2645h.f3398f;
            case 314:
                return this.f2645h.f3399g;
            case 315:
                return this.f2648k;
            case w.a.f3016q /* 316 */:
                return this.f2649l;
        }
    }

    public int B() {
        return this.f2647j.f2666a;
    }

    public r C() {
        return this.f2645h;
    }

    public int D() {
        r rVar = this.f2645h;
        return rVar.f3396d - rVar.f3394b;
    }

    public int E() {
        return this.f2645h.f3394b;
    }

    public int F() {
        return this.f2645h.f3395c;
    }

    public void G(int i7, int i8, int i9, int i10) {
        H(i7, i8, i9, i10);
    }

    public void H(int i7, int i8, int i9, int i10) {
        if (this.f2645h == null) {
            this.f2645h = new r((androidx.constraintlayout.core.widgets.e) null);
        }
        r rVar = this.f2645h;
        rVar.f3395c = i8;
        rVar.f3394b = i7;
        rVar.f3396d = i9;
        rVar.f3397e = i10;
    }

    public void I(String str, int i7, float f8) {
        this.f2645h.v(str, i7, f8);
    }

    public void J(String str, int i7, int i8) {
        this.f2645h.w(str, i7, i8);
    }

    public void K(String str, int i7, String str2) {
        this.f2645h.x(str, i7, str2);
    }

    public void L(String str, int i7, boolean z7) {
        this.f2645h.y(str, i7, z7);
    }

    public void M(androidx.constraintlayout.core.motion.a aVar, float[] fArr) {
        this.f2645h.v(aVar.f2513b, w.b.f3036k, fArr[0]);
    }

    public void N(float f8) {
        this.f2645h.f3398f = f8;
    }

    public void O(float f8) {
        this.f2645h.f3399g = f8;
    }

    public void P(float f8) {
        this.f2645h.f3400h = f8;
    }

    public void Q(float f8) {
        this.f2645h.f3401i = f8;
    }

    public void R(float f8) {
        this.f2645h.f3402j = f8;
    }

    public void S(float f8) {
        this.f2645h.f3406n = f8;
    }

    public void T(float f8) {
        this.f2645h.f3407o = f8;
    }

    public void U(float f8) {
        this.f2645h.f3403k = f8;
    }

    public void V(float f8) {
        this.f2645h.f3404l = f8;
    }

    public void W(float f8) {
        this.f2645h.f3405m = f8;
    }

    public boolean X(int i7, float f8) {
        switch (i7) {
            case 303:
                this.f2645h.f3408p = f8;
                return true;
            case 304:
                this.f2645h.f3403k = f8;
                return true;
            case 305:
                this.f2645h.f3404l = f8;
                return true;
            case 306:
                this.f2645h.f3405m = f8;
                return true;
            case 307:
            default:
                return false;
            case 308:
                this.f2645h.f3400h = f8;
                return true;
            case 309:
                this.f2645h.f3401i = f8;
                return true;
            case 310:
                this.f2645h.f3402j = f8;
                return true;
            case 311:
                this.f2645h.f3406n = f8;
                return true;
            case 312:
                this.f2645h.f3407o = f8;
                return true;
            case 313:
                this.f2645h.f3398f = f8;
                return true;
            case 314:
                this.f2645h.f3399g = f8;
                return true;
            case 315:
                this.f2648k = f8;
                return true;
            case w.a.f3016q /* 316 */:
                this.f2649l = f8;
                return true;
        }
    }

    public boolean Y(int i7, float f8) {
        switch (i7) {
            case 600:
                this.f2646i.f2658f = f8;
                return true;
            case 601:
                this.f2646i.f2660h = f8;
                return true;
            case w.e.f3092r /* 602 */:
                this.f2646i.f2661i = f8;
                return true;
            default:
                return false;
        }
    }

    public boolean Z(int i7, int i8) {
        switch (i7) {
            case w.e.f3095u /* 605 */:
                this.f2646i.f2653a = i8;
                return true;
            case w.e.f3096v /* 606 */:
                this.f2646i.f2654b = i8;
                return true;
            case w.e.f3097w /* 607 */:
                this.f2646i.f2656d = i8;
                return true;
            case w.e.f3098x /* 608 */:
                this.f2646i.f2657e = i8;
                return true;
            case w.e.f3099y /* 609 */:
                this.f2646i.f2659g = i8;
                return true;
            case w.e.f3100z /* 610 */:
                this.f2646i.f2662j = i8;
                return true;
            case w.e.A /* 611 */:
                this.f2646i.f2664l = i8;
                return true;
            case w.e.B /* 612 */:
                this.f2646i.f2665m = i8;
                return true;
            default:
                return false;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean a(int i7, int i8) {
        return X(i7, i8);
    }

    public boolean a0(int i7, String str) {
        if (i7 == 603) {
            this.f2646i.f2655c = str;
            return true;
        }
        if (i7 != 604) {
            return false;
        }
        this.f2646i.f2663k = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean b(int i7, float f8) {
        if (X(i7, f8)) {
            return true;
        }
        return Y(i7, f8);
    }

    public void b0(int i7) {
        this.f2647j.f2666a = i7;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean c(int i7, String str) {
        return a0(i7, str);
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean d(int i7, boolean z7) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public int e(String str) {
        int iA = v.a(str);
        return iA != -1 ? iA : a0.a(str);
    }

    public f f(int i7) {
        return null;
    }

    public float g() {
        return this.f2647j.f2668c;
    }

    public int h() {
        return this.f2645h.f3397e;
    }

    public androidx.constraintlayout.core.motion.b i(String str) {
        return this.f2645h.g(str);
    }

    public Set<String> j() {
        return this.f2645h.h();
    }

    public int k() {
        r rVar = this.f2645h;
        return rVar.f3397e - rVar.f3395c;
    }

    public int l() {
        return this.f2645h.f3394b;
    }

    public String m() {
        return this.f2645h.k();
    }

    public f n() {
        return null;
    }

    public float o() {
        return this.f2645h.f3398f;
    }

    public float p() {
        return this.f2645h.f3399g;
    }

    public int q() {
        return this.f2645h.f3396d;
    }

    public float r() {
        return this.f2645h.f3400h;
    }

    public float s() {
        return this.f2645h.f3401i;
    }

    public float t() {
        return this.f2645h.f3402j;
    }

    public String toString() {
        return this.f2645h.f3394b + ", " + this.f2645h.f3395c + ", " + this.f2645h.f3396d + ", " + this.f2645h.f3397e;
    }

    public float u() {
        return this.f2645h.f3406n;
    }

    public float v() {
        return this.f2645h.f3407o;
    }

    public int w() {
        return this.f2645h.f3395c;
    }

    public float x() {
        return this.f2645h.f3403k;
    }

    public float y() {
        return this.f2645h.f3404l;
    }

    public float z() {
        return this.f2645h.f3405m;
    }

    public f(r rVar) {
        this.f2645h = new r();
        this.f2646i = new a();
        this.f2647j = new b();
        this.f2645h = rVar;
    }
}
