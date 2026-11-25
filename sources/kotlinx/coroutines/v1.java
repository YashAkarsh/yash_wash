package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v1 extends w1 implements f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f37327e = AtomicReferenceFieldUpdater.newUpdater(v1.class, Object.class, "_queue");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f37328f = AtomicReferenceFieldUpdater.newUpdater(v1.class, Object.class, "_delayed");

    @a7.d
    private volatile /* synthetic */ Object _queue = null;

    @a7.d
    private volatile /* synthetic */ Object _delayed = null;

    @a7.d
    private volatile /* synthetic */ int _isCompleted = 0;

    private final class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        private final q<kotlin.l2> f37329d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@a7.d long j7, q<? super kotlin.l2> qVar) {
            super(j7);
            this.f37329d = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37329d.N(v1.this, kotlin.l2.f34958a);
        }

        @Override // kotlinx.coroutines.v1.c
        @a7.d
        public String toString() {
            return kotlin.jvm.internal.l0.C(super.toString(), this.f37329d);
        }
    }

    private static final class b extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        private final Runnable f37331d;

        public b(long j7, @a7.d Runnable runnable) {
            super(j7);
            this.f37331d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37331d.run();
        }

        @Override // kotlinx.coroutines.v1.c
        @a7.d
        public String toString() {
            return kotlin.jvm.internal.l0.C(super.toString(), this.f37331d);
        }
    }

    public static abstract class c implements Runnable, Comparable<c>, q1, kotlinx.coroutines.internal.b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @h5.e
        public long f37332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.e
        private Object f37333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f37334c = -1;

        public c(long j7) {
            this.f37332a = j7;
        }

        @Override // kotlinx.coroutines.q1
        public final synchronized void F() {
            Object obj = this.f37333b;
            if (obj == y1.f37374a) {
                return;
            }
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                dVar.j(this);
            }
            this.f37333b = y1.f37374a;
        }

        @Override // kotlinx.coroutines.internal.b1
        public void a(@a7.e kotlinx.coroutines.internal.a1<?> a1Var) {
            if (!(this.f37333b != y1.f37374a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f37333b = a1Var;
        }

        @Override // kotlinx.coroutines.internal.b1
        @a7.e
        public kotlinx.coroutines.internal.a1<?> b() {
            Object obj = this.f37333b;
            if (obj instanceof kotlinx.coroutines.internal.a1) {
                return (kotlinx.coroutines.internal.a1) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.b1
        public void c(int i7) {
            this.f37334c = i7;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(@a7.d c cVar) {
            long j7 = this.f37332a - cVar.f37332a;
            if (j7 > 0) {
                return 1;
            }
            return j7 < 0 ? -1 : 0;
        }

        public final synchronized int e(long j7, @a7.d d dVar, @a7.d v1 v1Var) {
            if (this.f37333b == y1.f37374a) {
                return 2;
            }
            synchronized (dVar) {
                c cVarE = dVar.e();
                if (v1Var.r()) {
                    return 1;
                }
                if (cVarE == null) {
                    dVar.f37335b = j7;
                } else {
                    long j8 = cVarE.f37332a;
                    if (j8 - j7 < 0) {
                        j7 = j8;
                    }
                    if (j7 - dVar.f37335b > 0) {
                        dVar.f37335b = j7;
                    }
                }
                long j9 = this.f37332a;
                long j10 = dVar.f37335b;
                if (j9 - j10 < 0) {
                    this.f37332a = j10;
                }
                dVar.a(this);
                return 0;
            }
        }

        public final boolean f(long j7) {
            return j7 - this.f37332a >= 0;
        }

        @Override // kotlinx.coroutines.internal.b1
        public int g() {
            return this.f37334c;
        }

        @a7.d
        public String toString() {
            return "Delayed[nanos=" + this.f37332a + ']';
        }
    }

    public static final class d extends kotlinx.coroutines.internal.a1<c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @h5.e
        public long f37335b;

        public d(long j7) {
            this.f37335b = j7;
        }
    }

    private final void d2() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (androidx.concurrent.futures.b.a(f37327e, this, null, y1.f37381h)) {
                    return;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.b0) {
                ((kotlinx.coroutines.internal.b0) obj).d();
                return;
            } else {
                if (obj == y1.f37381h) {
                    return;
                }
                kotlinx.coroutines.internal.b0 b0Var = new kotlinx.coroutines.internal.b0(8, true);
                b0Var.a((Runnable) obj);
                if (androidx.concurrent.futures.b.a(f37327e, this, obj, b0Var)) {
                    return;
                }
            }
        }
    }

    private final Runnable e2() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.b0) {
                kotlinx.coroutines.internal.b0 b0Var = (kotlinx.coroutines.internal.b0) obj;
                Object objL = b0Var.l();
                if (objL != kotlinx.coroutines.internal.b0.f36955t) {
                    return (Runnable) objL;
                }
                androidx.concurrent.futures.b.a(f37327e, this, obj, b0Var.k());
            } else {
                if (obj == y1.f37381h) {
                    return null;
                }
                if (androidx.concurrent.futures.b.a(f37327e, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean g2(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (r()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.b.a(f37327e, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.b0) {
                kotlinx.coroutines.internal.b0 b0Var = (kotlinx.coroutines.internal.b0) obj;
                int iA = b0Var.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    androidx.concurrent.futures.b.a(f37327e, this, obj, b0Var.k());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == y1.f37381h) {
                    return false;
                }
                kotlinx.coroutines.internal.b0 b0Var2 = new kotlinx.coroutines.internal.b0(8, true);
                b0Var2.a((Runnable) obj);
                b0Var2.a(runnable);
                if (androidx.concurrent.futures.b.a(f37327e, this, obj, b0Var2)) {
                    return true;
                }
            }
        }
    }

    private final void h2() {
        kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
        Long lValueOf = bVarB == null ? null : Long.valueOf(bVarB.b());
        long jNanoTime = lValueOf == null ? System.nanoTime() : lValueOf.longValue();
        while (true) {
            d dVar = (d) this._delayed;
            c cVarM = dVar == null ? null : dVar.m();
            if (cVarM == null) {
                return;
            } else {
                a2(jNanoTime, cVarM);
            }
        }
    }

    private final int k2(long j7, c cVar) {
        if (r()) {
            return 1;
        }
        d dVar = (d) this._delayed;
        if (dVar == null) {
            androidx.concurrent.futures.b.a(f37328f, this, null, new d(j7));
            Object obj = this._delayed;
            kotlin.jvm.internal.l0.m(obj);
            dVar = (d) obj;
        }
        return cVar.e(j7, dVar, this);
    }

    private final void m2(boolean z7) {
        this._isCompleted = z7 ? 1 : 0;
    }

    private final boolean n2(c cVar) {
        d dVar = (d) this._delayed;
        return (dVar == null ? null : dVar.h()) == cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean r() {
        return this._isCompleted;
    }

    @Override // kotlinx.coroutines.u1
    protected boolean B1() {
        if (!R1()) {
            return false;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.g()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.b0) {
                return ((kotlinx.coroutines.internal.b0) obj).h();
            }
            if (obj != y1.f37381h) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.o0
    public final void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        f2(runnable);
    }

    @Override // kotlinx.coroutines.u1
    public long W1() {
        c cVarK;
        if (X1()) {
            return 0L;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.g()) {
            kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
            Long lValueOf = bVarB == null ? null : Long.valueOf(bVarB.b());
            long jNanoTime = lValueOf == null ? System.nanoTime() : lValueOf.longValue();
            do {
                synchronized (dVar) {
                    c cVarE = dVar.e();
                    if (cVarE == null) {
                        cVarK = null;
                    } else {
                        c cVar = cVarE;
                        cVarK = cVar.f(jNanoTime) ? g2(cVar) : false ? dVar.k(0) : null;
                    }
                }
            } while (cVarK != null);
        }
        Runnable runnableE2 = e2();
        if (runnableE2 == null) {
            return w1();
        }
        runnableE2.run();
        return 0L;
    }

    public void f2(@a7.d Runnable runnable) {
        if (g2(runnable)) {
            b2();
        } else {
            b1.f35517g.f2(runnable);
        }
    }

    protected final void i2() {
        this._queue = null;
        this._delayed = null;
    }

    public final void j2(long j7, @a7.d c cVar) {
        int iK2 = k2(j7, cVar);
        if (iK2 == 0) {
            if (n2(cVar)) {
                b2();
            }
        } else if (iK2 == 1) {
            a2(j7, cVar);
        } else if (iK2 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @a7.d
    protected final q1 l2(long j7, @a7.d Runnable runnable) {
        long jD = y1.d(j7);
        if (jD >= kotlin.time.f.f35465c) {
            return d3.f35894a;
        }
        kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
        Long lValueOf = bVarB == null ? null : Long.valueOf(bVarB.b());
        long jNanoTime = lValueOf == null ? System.nanoTime() : lValueOf.longValue();
        b bVar = new b(jD + jNanoTime, runnable);
        j2(jNanoTime, bVar);
        return bVar;
    }

    @a7.d
    public q1 p0(long j7, @a7.d Runnable runnable, @a7.d kotlin.coroutines.g gVar) {
        return f1.a.b(this, j7, runnable, gVar);
    }

    @Override // kotlinx.coroutines.f1
    public void s(long j7, @a7.d q<? super kotlin.l2> qVar) {
        long jD = y1.d(j7);
        if (jD < kotlin.time.f.f35465c) {
            kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
            Long lValueOf = bVarB == null ? null : Long.valueOf(bVarB.b());
            long jNanoTime = lValueOf == null ? System.nanoTime() : lValueOf.longValue();
            a aVar = new a(jD + jNanoTime, qVar);
            t.a(qVar, aVar);
            j2(jNanoTime, aVar);
        }
    }

    @Override // kotlinx.coroutines.f1
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @a7.e
    public Object s0(long j7, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        return f1.a.a(this, j7, dVar);
    }

    @Override // kotlinx.coroutines.u1
    public void shutdown() {
        v3.f37337a.c();
        m2(true);
        d2();
        while (W1() <= 0) {
        }
        h2();
    }

    @Override // kotlinx.coroutines.u1
    protected long w1() {
        if (super.w1() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.b0)) {
                return obj == y1.f37381h ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.b0) obj).h()) {
                return 0L;
            }
        }
        d dVar = (d) this._delayed;
        c cVarH = dVar == null ? null : dVar.h();
        if (cVarH == null) {
            return Long.MAX_VALUE;
        }
        long j7 = cVarH.f37332a;
        kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
        Long lValueOf = bVarB != null ? Long.valueOf(bVarB.b()) : null;
        return kotlin.ranges.q.o(j7 - (lValueOf == null ? System.nanoTime() : lValueOf.longValue()), 0L);
    }
}
