package androidx.constraintlayout.core.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f3290f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f3291g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f3292h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f3293i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Integer f3294j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashMap<Object, androidx.constraintlayout.core.state.e> f3295a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected HashMap<Object, androidx.constraintlayout.core.state.c> f3296b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    HashMap<String, ArrayList<String>> f3297c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.constraintlayout.core.state.a f3298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3299e;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3300a;

        static {
            int[] iArr = new int[e.values().length];
            f3300a = iArr;
            try {
                iArr[e.HORIZONTAL_CHAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3300a[e.VERTICAL_CHAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3300a[e.ALIGN_HORIZONTALLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3300a[e.ALIGN_VERTICALLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3300a[e.BARRIER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    public enum c {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BASELINE_TO_BASELINE,
        BASELINE_TO_TOP,
        BASELINE_TO_BOTTOM,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    public enum d {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum e {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW
    }

    public h() {
        androidx.constraintlayout.core.state.a aVar = new androidx.constraintlayout.core.state.a(this);
        this.f3298d = aVar;
        this.f3299e = 0;
        this.f3295a.put(f3294j, aVar);
    }

    private String h() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i7 = this.f3299e;
        this.f3299e = i7 + 1;
        sb.append(i7);
        sb.append("__");
        return sb.toString();
    }

    public androidx.constraintlayout.core.state.helpers.f A(Object obj) {
        return k(obj, 1);
    }

    public h B(androidx.constraintlayout.core.state.b bVar) {
        return x(bVar);
    }

    public void a(androidx.constraintlayout.core.widgets.f fVar) {
        androidx.constraintlayout.core.state.c cVar;
        androidx.constraintlayout.core.widgets.j jVarM0;
        androidx.constraintlayout.core.widgets.j jVarM1;
        fVar.p2();
        this.f3298d.V().j(this, fVar, 0);
        this.f3298d.D().j(this, fVar, 1);
        for (Object obj : this.f3296b.keySet()) {
            androidx.constraintlayout.core.widgets.j jVarM2 = this.f3296b.get(obj).M0();
            if (jVarM2 != null) {
                androidx.constraintlayout.core.state.e eVarE = this.f3295a.get(obj);
                if (eVarE == null) {
                    eVarE = e(obj);
                }
                eVarE.b(jVarM2);
            }
        }
        for (Object obj2 : this.f3295a.keySet()) {
            androidx.constraintlayout.core.state.e eVar = this.f3295a.get(obj2);
            if (eVar != this.f3298d && (eVar.d() instanceof androidx.constraintlayout.core.state.c) && (jVarM1 = ((androidx.constraintlayout.core.state.c) eVar.d()).M0()) != null) {
                androidx.constraintlayout.core.state.e eVarE2 = this.f3295a.get(obj2);
                if (eVarE2 == null) {
                    eVarE2 = e(obj2);
                }
                eVarE2.b(jVarM1);
            }
        }
        Iterator<Object> it = this.f3295a.keySet().iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.core.state.e eVar2 = this.f3295a.get(it.next());
            if (eVar2 != this.f3298d) {
                androidx.constraintlayout.core.widgets.e eVarA = eVar2.a();
                eVarA.j1(eVar2.getKey().toString());
                eVarA.S1(null);
                if (eVar2.d() instanceof androidx.constraintlayout.core.state.helpers.f) {
                    eVar2.apply();
                }
                fVar.b(eVarA);
            } else {
                eVar2.b(fVar);
            }
        }
        Iterator<Object> it2 = this.f3296b.keySet().iterator();
        while (it2.hasNext()) {
            androidx.constraintlayout.core.state.c cVar2 = this.f3296b.get(it2.next());
            if (cVar2.M0() != null) {
                Iterator<Object> it3 = cVar2.f3286l0.iterator();
                while (it3.hasNext()) {
                    cVar2.M0().b(this.f3295a.get(it3.next()).a());
                }
                cVar2.apply();
            } else {
                cVar2.apply();
            }
        }
        Iterator<Object> it4 = this.f3295a.keySet().iterator();
        while (it4.hasNext()) {
            androidx.constraintlayout.core.state.e eVar3 = this.f3295a.get(it4.next());
            if (eVar3 != this.f3298d && (eVar3.d() instanceof androidx.constraintlayout.core.state.c) && (jVarM0 = (cVar = (androidx.constraintlayout.core.state.c) eVar3.d()).M0()) != null) {
                for (Object obj3 : cVar.f3286l0) {
                    androidx.constraintlayout.core.state.e eVar4 = this.f3295a.get(obj3);
                    if (eVar4 != null) {
                        jVarM0.b(eVar4.a());
                    } else if (obj3 instanceof androidx.constraintlayout.core.state.e) {
                        jVarM0.b(((androidx.constraintlayout.core.state.e) obj3).a());
                    } else {
                        System.out.println("couldn't find reference for " + obj3);
                    }
                }
                eVar3.apply();
            }
        }
        for (Object obj4 : this.f3295a.keySet()) {
            androidx.constraintlayout.core.state.e eVar5 = this.f3295a.get(obj4);
            eVar5.apply();
            androidx.constraintlayout.core.widgets.e eVarA2 = eVar5.a();
            if (eVarA2 != null && obj4 != null) {
                eVarA2.f3628o = obj4.toString();
            }
        }
    }

    public androidx.constraintlayout.core.state.helpers.c b(Object obj, d dVar) {
        androidx.constraintlayout.core.state.a aVarE = e(obj);
        if (aVarE.d() == null || !(aVarE.d() instanceof androidx.constraintlayout.core.state.helpers.c)) {
            androidx.constraintlayout.core.state.helpers.c cVar = new androidx.constraintlayout.core.state.helpers.c(this);
            cVar.P0(dVar);
            aVarE.p0(cVar);
        }
        return (androidx.constraintlayout.core.state.helpers.c) aVarE.d();
    }

    public androidx.constraintlayout.core.state.helpers.a c(Object... objArr) {
        androidx.constraintlayout.core.state.helpers.a aVar = (androidx.constraintlayout.core.state.helpers.a) m(null, e.ALIGN_HORIZONTALLY);
        aVar.L0(objArr);
        return aVar;
    }

    public androidx.constraintlayout.core.state.helpers.b d(Object... objArr) {
        androidx.constraintlayout.core.state.helpers.b bVar = (androidx.constraintlayout.core.state.helpers.b) m(null, e.ALIGN_VERTICALLY);
        bVar.L0(objArr);
        return bVar;
    }

    public androidx.constraintlayout.core.state.a e(Object obj) {
        androidx.constraintlayout.core.state.e eVarG = this.f3295a.get(obj);
        if (eVarG == null) {
            eVarG = g(obj);
            this.f3295a.put(obj, eVarG);
            eVarG.c(obj);
        }
        if (eVarG instanceof androidx.constraintlayout.core.state.a) {
            return (androidx.constraintlayout.core.state.a) eVarG;
        }
        return null;
    }

    public int f(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public androidx.constraintlayout.core.state.a g(Object obj) {
        return new androidx.constraintlayout.core.state.a(this);
    }

    public void i() {
        for (Object obj : this.f3295a.keySet()) {
            androidx.constraintlayout.core.state.a aVarE = e(obj);
            if (aVarE instanceof androidx.constraintlayout.core.state.a) {
                aVarE.w0(obj);
            }
        }
    }

    public ArrayList<String> j(String str) {
        if (this.f3297c.containsKey(str)) {
            return this.f3297c.get(str);
        }
        return null;
    }

    public androidx.constraintlayout.core.state.helpers.f k(Object obj, int i7) {
        androidx.constraintlayout.core.state.a aVarE = e(obj);
        if (aVarE.d() == null || !(aVarE.d() instanceof androidx.constraintlayout.core.state.helpers.f)) {
            androidx.constraintlayout.core.state.helpers.f fVar = new androidx.constraintlayout.core.state.helpers.f(this);
            fVar.h(i7);
            fVar.c(obj);
            aVarE.p0(fVar);
        }
        return (androidx.constraintlayout.core.state.helpers.f) aVarE.d();
    }

    public h l(androidx.constraintlayout.core.state.b bVar) {
        return v(bVar);
    }

    public androidx.constraintlayout.core.state.c m(Object obj, e eVar) {
        androidx.constraintlayout.core.state.c gVar;
        if (obj == null) {
            obj = h();
        }
        androidx.constraintlayout.core.state.c cVar = this.f3296b.get(obj);
        if (cVar == null) {
            int i7 = a.f3300a[eVar.ordinal()];
            if (i7 == 1) {
                gVar = new androidx.constraintlayout.core.state.helpers.g(this);
            } else if (i7 == 2) {
                gVar = new androidx.constraintlayout.core.state.helpers.h(this);
            } else if (i7 == 3) {
                gVar = new androidx.constraintlayout.core.state.helpers.a(this);
            } else if (i7 != 4) {
                if (i7 != 5) {
                    cVar = new androidx.constraintlayout.core.state.c(this, eVar);
                } else {
                    gVar = new androidx.constraintlayout.core.state.helpers.c(this);
                }
                cVar.c(obj);
                this.f3296b.put(obj, cVar);
            } else {
                gVar = new androidx.constraintlayout.core.state.helpers.b(this);
            }
            cVar = gVar;
            cVar.c(obj);
            this.f3296b.put(obj, cVar);
        }
        return cVar;
    }

    public androidx.constraintlayout.core.state.helpers.g n() {
        return (androidx.constraintlayout.core.state.helpers.g) m(null, e.HORIZONTAL_CHAIN);
    }

    public androidx.constraintlayout.core.state.helpers.g o(Object... objArr) {
        androidx.constraintlayout.core.state.helpers.g gVar = (androidx.constraintlayout.core.state.helpers.g) m(null, e.HORIZONTAL_CHAIN);
        gVar.L0(objArr);
        return gVar;
    }

    public androidx.constraintlayout.core.state.helpers.f p(Object obj) {
        return k(obj, 0);
    }

    public void q(Object obj, Object obj2) {
        androidx.constraintlayout.core.state.a aVarE = e(obj);
        if (aVarE instanceof androidx.constraintlayout.core.state.a) {
            aVarE.w0(obj2);
        }
    }

    androidx.constraintlayout.core.state.e r(Object obj) {
        return this.f3295a.get(obj);
    }

    public void s() {
        this.f3296b.clear();
        this.f3297c.clear();
    }

    public boolean t(int i7) {
        return this.f3298d.D().k(i7);
    }

    public boolean u(int i7) {
        return this.f3298d.V().k(i7);
    }

    public h v(androidx.constraintlayout.core.state.b bVar) {
        this.f3298d.q0(bVar);
        return this;
    }

    public void w(String str, String str2) {
        ArrayList<String> arrayList;
        androidx.constraintlayout.core.state.a aVarE = e(str);
        if (aVarE instanceof androidx.constraintlayout.core.state.a) {
            aVarE.t0(str2);
            if (this.f3297c.containsKey(str2)) {
                arrayList = this.f3297c.get(str2);
            } else {
                arrayList = new ArrayList<>();
                this.f3297c.put(str2, arrayList);
            }
            arrayList.add(str);
        }
    }

    public h x(androidx.constraintlayout.core.state.b bVar) {
        this.f3298d.x0(bVar);
        return this;
    }

    public androidx.constraintlayout.core.state.helpers.h y() {
        return (androidx.constraintlayout.core.state.helpers.h) m(null, e.VERTICAL_CHAIN);
    }

    public androidx.constraintlayout.core.state.helpers.h z(Object... objArr) {
        androidx.constraintlayout.core.state.helpers.h hVar = (androidx.constraintlayout.core.state.helpers.h) m(null, e.VERTICAL_CHAIN);
        hVar.L0(objArr);
        return hVar;
    }
}
