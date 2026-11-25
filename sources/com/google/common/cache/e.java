package com.google.common.cache;

import com.google.common.base.p0;
import com.google.common.base.q0;
import com.google.common.base.s0;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class e<K, V> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f19619q = 16;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f19620r = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f19621s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f19622t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final p0<? extends com.google.common.cache.a.b> f19623u = q0.d(new a());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final h f19624v = new h(0, 0, 0, 0, 0, 0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final p0<com.google.common.cache.a.b> f19625w = new b();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final s0 f19626x = new c();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Logger f19627y = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f19628z = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    d0<? super K, ? super V> f19634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    r.t f19635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    r.t f19636h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    com.google.common.base.l<Object> f19640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    com.google.common.base.l<Object> f19641m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    z<? super K, ? super V> f19642n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    s0 f19643o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f19629a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f19630b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f19631c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f19632d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f19633e = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f19637i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f19638j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f19639k = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    p0<? extends com.google.common.cache.a.b> f19644p = f19623u;

    static class a implements com.google.common.cache.a.b {
        a() {
        }

        @Override // com.google.common.cache.a.b
        public void a() {
        }

        @Override // com.google.common.cache.a.b
        public void b(int i7) {
        }

        @Override // com.google.common.cache.a.b
        public void c(int i7) {
        }

        @Override // com.google.common.cache.a.b
        public void d(long j7) {
        }

        @Override // com.google.common.cache.a.b
        public void e(long j7) {
        }

        @Override // com.google.common.cache.a.b
        public h f() {
            return e.f19624v;
        }
    }

    static class b implements p0<com.google.common.cache.a.b> {
        b() {
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.a.b get() {
            return new com.google.common.cache.a.C0227a();
        }
    }

    static class c extends s0 {
        c() {
        }

        @Override // com.google.common.base.s0
        public long a() {
            return 0L;
        }
    }

    enum d implements z<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.z
        public void a(b0<Object, Object> b0Var) {
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.e$e, reason: collision with other inner class name */
    enum EnumC0229e implements d0<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.d0
        public int a(Object obj, Object obj2) {
            return 1;
        }
    }

    private e() {
    }

    public static e<Object, Object> F() {
        return new e<>();
    }

    private void c() {
        com.google.common.base.e0.h0(this.f19639k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void d() {
        if (this.f19634f == null) {
            com.google.common.base.e0.h0(this.f19633e == -1, "maximumWeight requires weigher");
        } else if (this.f19629a) {
            com.google.common.base.e0.h0(this.f19633e != -1, "weigher requires maximumWeight");
        } else if (this.f19633e == -1) {
            f19627y.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    @s1.c
    public static e<Object, Object> j(f fVar) {
        return fVar.f().C();
    }

    @s1.c
    public static e<Object, Object> k(String str) {
        return j(f.e(str));
    }

    boolean A() {
        return this.f19644p == f19625w;
    }

    @s1.c
    e<K, V> B(com.google.common.base.l<Object> lVar) {
        com.google.common.base.l<Object> lVar2 = this.f19640l;
        com.google.common.base.e0.x0(lVar2 == null, "key equivalence was already set to %s", lVar2);
        this.f19640l = (com.google.common.base.l) com.google.common.base.e0.E(lVar);
        return this;
    }

    @s1.c
    e<K, V> C() {
        this.f19629a = false;
        return this;
    }

    public e<K, V> D(long j7) {
        long j8 = this.f19632d;
        com.google.common.base.e0.s0(j8 == -1, "maximum size was already set to %s", j8);
        long j9 = this.f19633e;
        com.google.common.base.e0.s0(j9 == -1, "maximum weight was already set to %s", j9);
        com.google.common.base.e0.h0(this.f19634f == null, "maximum size can not be combined with weigher");
        com.google.common.base.e0.e(j7 >= 0, "maximum size must not be negative");
        this.f19632d = j7;
        return this;
    }

    @s1.c
    public e<K, V> E(long j7) {
        long j8 = this.f19633e;
        com.google.common.base.e0.s0(j8 == -1, "maximum weight was already set to %s", j8);
        long j9 = this.f19632d;
        com.google.common.base.e0.s0(j9 == -1, "maximum size was already set to %s", j9);
        this.f19633e = j7;
        com.google.common.base.e0.e(j7 >= 0, "maximum weight must not be negative");
        return this;
    }

    public e<K, V> G() {
        this.f19644p = f19625w;
        return this;
    }

    @s1.c
    public e<K, V> H(long j7, TimeUnit timeUnit) {
        com.google.common.base.e0.E(timeUnit);
        long j8 = this.f19639k;
        com.google.common.base.e0.s0(j8 == -1, "refresh was already set to %s ns", j8);
        com.google.common.base.e0.t(j7 > 0, "duration must be positive: %s %s", j7, timeUnit);
        this.f19639k = timeUnit.toNanos(j7);
        return this;
    }

    @s1.c
    public e<K, V> I(Duration duration) {
        return H(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @u1.b
    public <K1 extends K, V1 extends V> e<K1, V1> J(z<? super K1, ? super V1> zVar) {
        com.google.common.base.e0.g0(this.f19642n == null);
        this.f19642n = (z) com.google.common.base.e0.E(zVar);
        return this;
    }

    e<K, V> K(r.t tVar) {
        r.t tVar2 = this.f19635g;
        com.google.common.base.e0.x0(tVar2 == null, "Key strength was already set to %s", tVar2);
        this.f19635g = (r.t) com.google.common.base.e0.E(tVar);
        return this;
    }

    e<K, V> L(r.t tVar) {
        r.t tVar2 = this.f19636h;
        com.google.common.base.e0.x0(tVar2 == null, "Value strength was already set to %s", tVar2);
        this.f19636h = (r.t) com.google.common.base.e0.E(tVar);
        return this;
    }

    @s1.c
    public e<K, V> M() {
        return L(r.t.f19826b);
    }

    public e<K, V> N(s0 s0Var) {
        com.google.common.base.e0.g0(this.f19643o == null);
        this.f19643o = (s0) com.google.common.base.e0.E(s0Var);
        return this;
    }

    @s1.c
    e<K, V> O(com.google.common.base.l<Object> lVar) {
        com.google.common.base.l<Object> lVar2 = this.f19641m;
        com.google.common.base.e0.x0(lVar2 == null, "value equivalence was already set to %s", lVar2);
        this.f19641m = (com.google.common.base.l) com.google.common.base.e0.E(lVar);
        return this;
    }

    @s1.c
    public e<K, V> P() {
        return K(r.t.f19827c);
    }

    @s1.c
    public e<K, V> Q() {
        return L(r.t.f19827c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s1.c
    public <K1 extends K, V1 extends V> e<K1, V1> R(d0<? super K1, ? super V1> d0Var) {
        com.google.common.base.e0.g0(this.f19634f == null);
        if (this.f19629a) {
            long j7 = this.f19632d;
            com.google.common.base.e0.s0(j7 == -1, "weigher can not be combined with maximum size", j7);
        }
        this.f19634f = (d0) com.google.common.base.e0.E(d0Var);
        return this;
    }

    public <K1 extends K, V1 extends V> com.google.common.cache.c<K1, V1> a() {
        d();
        c();
        return new r.o(this);
    }

    public <K1 extends K, V1 extends V> k<K1, V1> b(g<? super K1, V1> gVar) {
        d();
        return new r.n(this, gVar);
    }

    public e<K, V> e(int i7) {
        int i8 = this.f19631c;
        com.google.common.base.e0.n0(i8 == -1, "concurrency level was already set to %s", i8);
        com.google.common.base.e0.d(i7 > 0);
        this.f19631c = i7;
        return this;
    }

    public e<K, V> f(long j7, TimeUnit timeUnit) {
        long j8 = this.f19638j;
        com.google.common.base.e0.s0(j8 == -1, "expireAfterAccess was already set to %s ns", j8);
        com.google.common.base.e0.t(j7 >= 0, "duration cannot be negative: %s %s", j7, timeUnit);
        this.f19638j = timeUnit.toNanos(j7);
        return this;
    }

    @s1.c
    public e<K, V> g(Duration duration) {
        return f(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public e<K, V> h(long j7, TimeUnit timeUnit) {
        long j8 = this.f19637i;
        com.google.common.base.e0.s0(j8 == -1, "expireAfterWrite was already set to %s ns", j8);
        com.google.common.base.e0.t(j7 >= 0, "duration cannot be negative: %s %s", j7, timeUnit);
        this.f19637i = timeUnit.toNanos(j7);
        return this;
    }

    @s1.c
    public e<K, V> i(Duration duration) {
        return h(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    int l() {
        int i7 = this.f19631c;
        if (i7 == -1) {
            return 4;
        }
        return i7;
    }

    long m() {
        long j7 = this.f19638j;
        if (j7 == -1) {
            return 0L;
        }
        return j7;
    }

    long n() {
        long j7 = this.f19637i;
        if (j7 == -1) {
            return 0L;
        }
        return j7;
    }

    int o() {
        int i7 = this.f19630b;
        if (i7 == -1) {
            return 16;
        }
        return i7;
    }

    com.google.common.base.l<Object> p() {
        return (com.google.common.base.l) com.google.common.base.x.a(this.f19640l, q().a());
    }

    r.t q() {
        return (r.t) com.google.common.base.x.a(this.f19635g, r.t.f19825a);
    }

    long r() {
        if (this.f19637i == 0 || this.f19638j == 0) {
            return 0L;
        }
        return this.f19634f == null ? this.f19632d : this.f19633e;
    }

    long s() {
        long j7 = this.f19639k;
        if (j7 == -1) {
            return 0L;
        }
        return j7;
    }

    <K1 extends K, V1 extends V> z<K1, V1> t() {
        return (z) com.google.common.base.x.a(this.f19642n, d.INSTANCE);
    }

    public String toString() {
        com.google.common.base.x.b bVarC = com.google.common.base.x.c(this);
        int i7 = this.f19630b;
        if (i7 != -1) {
            bVarC.d("initialCapacity", i7);
        }
        int i8 = this.f19631c;
        if (i8 != -1) {
            bVarC.d("concurrencyLevel", i8);
        }
        long j7 = this.f19632d;
        if (j7 != -1) {
            bVarC.e("maximumSize", j7);
        }
        long j8 = this.f19633e;
        if (j8 != -1) {
            bVarC.e("maximumWeight", j8);
        }
        if (this.f19637i != -1) {
            bVarC.f("expireAfterWrite", this.f19637i + "ns");
        }
        if (this.f19638j != -1) {
            bVarC.f("expireAfterAccess", this.f19638j + "ns");
        }
        r.t tVar = this.f19635g;
        if (tVar != null) {
            bVarC.f("keyStrength", com.google.common.base.c.g(tVar.toString()));
        }
        r.t tVar2 = this.f19636h;
        if (tVar2 != null) {
            bVarC.f("valueStrength", com.google.common.base.c.g(tVar2.toString()));
        }
        if (this.f19640l != null) {
            bVarC.p("keyEquivalence");
        }
        if (this.f19641m != null) {
            bVarC.p("valueEquivalence");
        }
        if (this.f19642n != null) {
            bVarC.p("removalListener");
        }
        return bVarC.toString();
    }

    p0<? extends com.google.common.cache.a.b> u() {
        return this.f19644p;
    }

    s0 v(boolean z7) {
        s0 s0Var = this.f19643o;
        if (s0Var != null) {
            return s0Var;
        }
        return z7 ? s0.b() : f19626x;
    }

    com.google.common.base.l<Object> w() {
        return (com.google.common.base.l) com.google.common.base.x.a(this.f19641m, x().a());
    }

    r.t x() {
        return (r.t) com.google.common.base.x.a(this.f19636h, r.t.f19825a);
    }

    <K1 extends K, V1 extends V> d0<K1, V1> y() {
        return (d0) com.google.common.base.x.a(this.f19634f, EnumC0229e.INSTANCE);
    }

    public e<K, V> z(int i7) {
        int i8 = this.f19630b;
        com.google.common.base.e0.n0(i8 == -1, "initial capacity was already set to %s", i8);
        com.google.common.base.e0.d(i7 >= 0);
        this.f19630b = i7;
        return this;
    }
}
