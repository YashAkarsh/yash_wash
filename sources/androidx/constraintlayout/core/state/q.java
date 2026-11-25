package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.u;
import androidx.constraintlayout.core.motion.utils.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class q implements w {
    private static final int A = -1;
    private static final int B = -2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f3357q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f3358r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f3359s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final int f3360t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final int f3361u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final int f3362v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final int f3363w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final int f3364x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final int f3365y = 5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f3366z = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    HashMap<Integer, HashMap<String, a>> f3367h = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HashMap<String, b> f3368i = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    u f3369j = new u();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3370k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f3371l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.d f3372m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3373n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3374o = 400;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f3375p = 0.0f;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f3377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f3379d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f3380e;

        public a(String str, int i7, int i8, float f8, float f9) {
            this.f3377b = str;
            this.f3376a = i7;
            this.f3378c = i8;
            this.f3379d = f8;
            this.f3380e = f9;
        }
    }

    static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        androidx.constraintlayout.core.motion.c f3384d;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        androidx.constraintlayout.core.motion.utils.g f3388h = new androidx.constraintlayout.core.motion.utils.g();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f3389i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f3390j = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        r f3381a = new r();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        r f3382b = new r();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        r f3383c = new r();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        androidx.constraintlayout.core.motion.f f3385e = new androidx.constraintlayout.core.motion.f(this.f3381a);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        androidx.constraintlayout.core.motion.f f3386f = new androidx.constraintlayout.core.motion.f(this.f3382b);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.constraintlayout.core.motion.f f3387g = new androidx.constraintlayout.core.motion.f(this.f3383c);

        public b() {
            androidx.constraintlayout.core.motion.c cVar = new androidx.constraintlayout.core.motion.c(this.f3385e);
            this.f3384d = cVar;
            cVar.Z(this.f3385e);
            this.f3384d.X(this.f3386f);
        }

        public r a(int i7) {
            if (i7 == 0) {
                return this.f3381a;
            }
            return i7 == 1 ? this.f3382b : this.f3383c;
        }

        public void b(int i7, int i8, float f8, q qVar) {
            this.f3389i = i8;
            this.f3390j = i7;
            this.f3384d.d0(i7, i8, 1.0f, System.nanoTime());
            r.n(i7, i8, this.f3383c, this.f3381a, this.f3382b, qVar, f8);
            this.f3383c.f3409q = f8;
            this.f3384d.Q(this.f3387g, f8, System.nanoTime(), this.f3388h);
        }

        public void c(u uVar) {
            androidx.constraintlayout.core.motion.key.c cVar = new androidx.constraintlayout.core.motion.key.c();
            uVar.g(cVar);
            this.f3384d.f(cVar);
        }

        public void d(u uVar) {
            androidx.constraintlayout.core.motion.key.d dVar = new androidx.constraintlayout.core.motion.key.d();
            uVar.g(dVar);
            this.f3384d.f(dVar);
        }

        public void e(u uVar) {
            androidx.constraintlayout.core.motion.key.e eVar = new androidx.constraintlayout.core.motion.key.e();
            uVar.g(eVar);
            this.f3384d.f(eVar);
        }

        public void f(androidx.constraintlayout.core.widgets.e eVar, int i7) {
            if (i7 == 0) {
                this.f3381a.C(eVar);
                this.f3384d.Z(this.f3385e);
            } else if (i7 == 1) {
                this.f3382b.C(eVar);
                this.f3384d.X(this.f3386f);
            }
            this.f3390j = -1;
        }
    }

    public static d E(int i7, final String str) {
        switch (i7) {
            case -1:
                return new d() { // from class: androidx.constraintlayout.core.state.i
                    @Override // androidx.constraintlayout.core.state.d
                    public final float getInterpolation(float f8) {
                        return q.Q(str, f8);
                    }
                };
            case 0:
                return new d() { // from class: androidx.constraintlayout.core.state.j
                    @Override // androidx.constraintlayout.core.state.d
                    public final float getInterpolation(float f8) {
                        return q.R(f8);
                    }
                };
            case 1:
                return new d() { // from class: androidx.constraintlayout.core.state.k
                    @Override // androidx.constraintlayout.core.state.d
                    public final float getInterpolation(float f8) {
                        return q.S(f8);
                    }
                };
            case 2:
                return new d() { // from class: androidx.constraintlayout.core.state.l
                    @Override // androidx.constraintlayout.core.state.d
                    public final float getInterpolation(float f8) {
                        return q.T(f8);
                    }
                };
            case 3:
                return new d() { // from class: androidx.constraintlayout.core.state.m
                    @Override // androidx.constraintlayout.core.state.d
                    public final float getInterpolation(float f8) {
                        return q.U(f8);
                    }
                };
            case 4:
                return new d() { // from class: androidx.constraintlayout.core.state.p
                    @Override // androidx.constraintlayout.core.state.d
                    public final float getInterpolation(float f8) {
                        return q.X(f8);
                    }
                };
            case 5:
                return new d() { // from class: androidx.constraintlayout.core.state.o
                    @Override // androidx.constraintlayout.core.state.d
                    public final float getInterpolation(float f8) {
                        return q.W(f8);
                    }
                };
            case 6:
                return new d() { // from class: androidx.constraintlayout.core.state.n
                    @Override // androidx.constraintlayout.core.state.d
                    public final float getInterpolation(float f8) {
                        return q.V(f8);
                    }
                };
            default:
                return null;
        }
    }

    private b L(String str) {
        return this.f3368i.get(str);
    }

    private b M(String str, androidx.constraintlayout.core.widgets.e eVar, int i7) {
        b bVar = this.f3368i.get(str);
        if (bVar == null) {
            bVar = new b();
            this.f3369j.g(bVar.f3384d);
            this.f3368i.put(str, bVar);
            if (eVar != null) {
                bVar.f(eVar, i7);
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float Q(String str, float f8) {
        return (float) androidx.constraintlayout.core.motion.utils.d.c(str).a(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float R(float f8) {
        return (float) androidx.constraintlayout.core.motion.utils.d.c("standard").a(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float S(float f8) {
        return (float) androidx.constraintlayout.core.motion.utils.d.c("accelerate").a(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float T(float f8) {
        return (float) androidx.constraintlayout.core.motion.utils.d.c("decelerate").a(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float U(float f8) {
        return (float) androidx.constraintlayout.core.motion.utils.d.c("linear").a(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float V(float f8) {
        return (float) androidx.constraintlayout.core.motion.utils.d.c("anticipate").a(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float W(float f8) {
        return (float) androidx.constraintlayout.core.motion.utils.d.c("overshoot").a(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float X(float f8) {
        return (float) androidx.constraintlayout.core.motion.utils.d.c("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").a(f8);
    }

    public r A(String str) {
        b bVar = this.f3368i.get(str);
        if (bVar == null) {
            return null;
        }
        return bVar.f3382b;
    }

    public r B(androidx.constraintlayout.core.widgets.e eVar) {
        return M(eVar.f3628o, null, 2).f3383c;
    }

    public r C(String str) {
        b bVar = this.f3368i.get(str);
        if (bVar == null) {
            return null;
        }
        return bVar.f3383c;
    }

    public d D() {
        return E(this.f3370k, this.f3371l);
    }

    public int F(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.f3368i.get(str).f3384d.j(fArr, iArr, iArr2);
    }

    public androidx.constraintlayout.core.motion.c G(String str) {
        return M(str, null, 0).f3384d;
    }

    public int H(r rVar) {
        int i7 = 0;
        for (int i8 = 0; i8 <= 100; i8++) {
            HashMap<String, a> map = this.f3367h.get(Integer.valueOf(i8));
            if (map != null && map.get(rVar.f3393a.f3628o) != null) {
                i7++;
            }
        }
        return i7;
    }

    public float[] I(String str) {
        float[] fArr = new float[124];
        this.f3368i.get(str).f3384d.k(fArr, 62);
        return fArr;
    }

    public r J(androidx.constraintlayout.core.widgets.e eVar) {
        return M(eVar.f3628o, null, 0).f3381a;
    }

    public r K(String str) {
        b bVar = this.f3368i.get(str);
        if (bVar == null) {
            return null;
        }
        return bVar.f3381a;
    }

    public boolean N() {
        return this.f3367h.size() > 0;
    }

    public void O(int i7, int i8, float f8) {
        androidx.constraintlayout.core.motion.utils.d dVar = this.f3372m;
        if (dVar != null) {
            f8 = (float) dVar.a(f8);
        }
        Iterator<String> it = this.f3368i.keySet().iterator();
        while (it.hasNext()) {
            this.f3368i.get(it.next()).b(i7, i8, f8, this);
        }
    }

    public boolean P() {
        return this.f3368i.isEmpty();
    }

    public void Y(u uVar) {
        uVar.f(this.f3369j);
        uVar.g(this);
    }

    public void Z(androidx.constraintlayout.core.widgets.f fVar, int i7) {
        ArrayList<androidx.constraintlayout.core.widgets.e> arrayListL2 = fVar.l2();
        int size = arrayListL2.size();
        for (int i8 = 0; i8 < size; i8++) {
            androidx.constraintlayout.core.widgets.e eVar = arrayListL2.get(i8);
            M(eVar.f3628o, null, i7).f(eVar, i7);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean a(int i7, int i8) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean b(int i7, float f8) {
        if (i7 != 706) {
            return false;
        }
        this.f3375p = f8;
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean c(int i7, String str) {
        if (i7 != 705) {
            return false;
        }
        this.f3371l = str;
        this.f3372m = androidx.constraintlayout.core.motion.utils.d.c(str);
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean d(int i7, boolean z7) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public int e(String str) {
        return 0;
    }

    public void n(int i7, String str, String str2, int i8) {
        M(str, null, i7).a(i7).c(str2, i8);
    }

    public void o(int i7, String str, String str2, float f8) {
        M(str, null, i7).a(i7).d(str2, f8);
    }

    public void p(String str, u uVar) {
        M(str, null, 0).c(uVar);
    }

    public void q(String str, u uVar) {
        M(str, null, 0).d(uVar);
    }

    public void r(String str, int i7, int i8, float f8, float f9) {
        u uVar = new u();
        uVar.b(w.g.f3141r, 2);
        uVar.b(100, i7);
        uVar.a(w.g.f3137n, f8);
        uVar.a(w.g.f3138o, f9);
        M(str, null, 0).e(uVar);
        a aVar = new a(str, i7, i8, f8, f9);
        HashMap<String, a> map = this.f3367h.get(Integer.valueOf(i7));
        if (map == null) {
            map = new HashMap<>();
            this.f3367h.put(Integer.valueOf(i7), map);
        }
        map.put(str, aVar);
    }

    public void s(String str, u uVar) {
        M(str, null, 0).e(uVar);
    }

    public void t() {
        this.f3368i.clear();
    }

    public boolean u(String str) {
        return this.f3368i.containsKey(str);
    }

    public void v(r rVar, float[] fArr, float[] fArr2, float[] fArr3) {
        a aVar;
        int i7 = 0;
        for (int i8 = 0; i8 <= 100; i8++) {
            HashMap<String, a> map = this.f3367h.get(Integer.valueOf(i8));
            if (map != null && (aVar = map.get(rVar.f3393a.f3628o)) != null) {
                fArr[i7] = aVar.f3379d;
                fArr2[i7] = aVar.f3380e;
                fArr3[i7] = aVar.f3376a;
                i7++;
            }
        }
    }

    public a w(String str, int i7) {
        a aVar;
        while (i7 <= 100) {
            HashMap<String, a> map = this.f3367h.get(Integer.valueOf(i7));
            if (map != null && (aVar = map.get(str)) != null) {
                return aVar;
            }
            i7++;
        }
        return null;
    }

    public a x(String str, int i7) {
        a aVar;
        while (i7 >= 0) {
            HashMap<String, a> map = this.f3367h.get(Integer.valueOf(i7));
            if (map != null && (aVar = map.get(str)) != null) {
                return aVar;
            }
            i7--;
        }
        return null;
    }

    public int y() {
        return this.f3373n;
    }

    public r z(androidx.constraintlayout.core.widgets.e eVar) {
        return M(eVar.f3628o, null, 1).f3382b;
    }
}
