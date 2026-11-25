package kotlinx.coroutines.selects;

import i5.l;
import i5.p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.a1;
import kotlin.d1;
import kotlin.e1;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s;

/* JADX INFO: loaded from: classes3.dex */
@a1
public final class b<R> extends w implements kotlinx.coroutines.selects.a<R>, f<R>, kotlin.coroutines.d<R>, kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f37210e = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_state");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f37211f = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_result");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.d<R> f37212d;

    @a7.d
    volatile /* synthetic */ Object _state = g.f();

    @a7.d
    private volatile /* synthetic */ Object _result = g.f37223c;

    @a7.d
    private volatile /* synthetic */ Object _parentHandle = null;

    private static final class a extends kotlinx.coroutines.internal.d<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        @h5.e
        public final b<?> f37213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        @h5.e
        public final kotlinx.coroutines.internal.b f37214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f37215d = g.f37225e.a();

        public a(@a7.d b<?> bVar, @a7.d kotlinx.coroutines.internal.b bVar2) {
            this.f37213b = bVar;
            this.f37214c = bVar2;
            bVar2.d(this);
        }

        private final void j(Object obj) {
            boolean z7 = obj == null;
            if (androidx.concurrent.futures.b.a(b.f37210e, this.f37213b, this, z7 ? null : g.f()) && z7) {
                this.f37213b.a1();
            }
        }

        private final Object k() {
            b<?> bVar = this.f37213b;
            while (true) {
                Object obj = bVar._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof j0) {
                    ((j0) obj).c(this.f37213b);
                } else {
                    if (obj != g.f()) {
                        return g.d();
                    }
                    if (androidx.concurrent.futures.b.a(b.f37210e, this.f37213b, g.f(), this)) {
                        return null;
                    }
                }
            }
        }

        private final void l() {
            androidx.concurrent.futures.b.a(b.f37210e, this.f37213b, this, g.f());
        }

        @Override // kotlinx.coroutines.internal.d
        public void d(@a7.e Object obj, @a7.e Object obj2) {
            j(obj2);
            this.f37214c.a(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.d
        public long g() {
            return this.f37215d;
        }

        @Override // kotlinx.coroutines.internal.d
        @a7.e
        public Object i(@a7.e Object obj) {
            Object objK;
            if (obj == null && (objK = k()) != null) {
                return objK;
            }
            try {
                return this.f37214c.c(this);
            } catch (Throwable th) {
                if (obj == null) {
                    l();
                }
                throw th;
            }
        }

        @Override // kotlinx.coroutines.internal.j0
        @a7.d
        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + ')';
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.b$b, reason: collision with other inner class name */
    private static final class C0492b extends y {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        @h5.e
        public final q1 f37216d;

        public C0492b(@a7.d q1 q1Var) {
            this.f37216d = q1Var;
        }
    }

    private static final class c extends j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        @h5.e
        public final y.d f37217a;

        public c(@a7.d y.d dVar) {
            this.f37217a = dVar;
        }

        @Override // kotlinx.coroutines.internal.j0
        @a7.d
        public kotlinx.coroutines.internal.d<?> a() {
            return this.f37217a.a();
        }

        @Override // kotlinx.coroutines.internal.j0
        @a7.e
        public Object c(@a7.e Object obj) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            }
            b bVar = (b) obj;
            this.f37217a.d();
            Object objE = this.f37217a.a().e(null);
            androidx.concurrent.futures.b.a(b.f37210e, bVar, this, objE == null ? this.f37217a.f37053c : g.f());
            return objE;
        }
    }

    private final class d extends q2 {
        public d() {
        }

        @Override // kotlinx.coroutines.g0
        public void V0(@a7.e Throwable th) {
            if (b.this.q()) {
                b.this.Z(W0().K());
            }
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) {
            V0(th);
            return l2.f34958a;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f37220b;

        public e(l lVar) {
            this.f37220b = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            if (b.this.q()) {
                r5.a.c(this.f37220b, b.this.G());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@a7.d kotlin.coroutines.d<? super R> dVar) {
        this.f37212d = dVar;
    }

    private final void O() {
        o2 o2Var = (o2) d().get(o2.f37103s0);
        if (o2Var == null) {
            return;
        }
        q1 q1VarF = o2.a.f(o2Var, true, false, new d(), 2, null);
        f1(q1VarF);
        if (E()) {
            q1VarF.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1() {
        q1 q1VarC1 = c1();
        if (q1VarC1 != null) {
            q1VarC1.F();
        }
        for (y yVarH0 = (y) G0(); !l0.g(yVarH0, this); yVarH0 = yVarH0.H0()) {
            if (yVarH0 instanceof C0492b) {
                ((C0492b) yVarH0).f37216d.F();
            }
        }
    }

    private final void b1(i5.a<? extends Object> aVar, i5.a<l2> aVar2) {
        while (true) {
            Object obj = this._result;
            if (obj == g.f37223c) {
                if (androidx.concurrent.futures.b.a(f37211f, this, g.f37223c, aVar.invoke())) {
                    return;
                }
            } else {
                if (obj != kotlin.coroutines.intrinsics.d.h()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (androidx.concurrent.futures.b.a(f37211f, this, kotlin.coroutines.intrinsics.d.h(), g.f37224d)) {
                    aVar2.invoke();
                    return;
                }
            }
        }
    }

    private final q1 c1() {
        return (q1) this._parentHandle;
    }

    private final void f1(q1 q1Var) {
        this._parentHandle = q1Var;
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean E() {
        while (true) {
            Object obj = this._state;
            if (obj == g.f()) {
                return false;
            }
            if (!(obj instanceof j0)) {
                return true;
            }
            ((j0) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.selects.f
    @a7.d
    public kotlin.coroutines.d<R> G() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public StackTraceElement I() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.a
    public void Q(long j7, @a7.d l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar) {
        if (j7 > 0) {
            o0(g1.d(d()).p0(j7, new e(lVar), d()));
        } else if (q()) {
            r5.b.c(lVar, G());
        }
    }

    @Override // kotlinx.coroutines.selects.a
    public <P, Q> void V(@a7.d kotlinx.coroutines.selects.e<? super P, ? extends Q> eVar, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        kotlinx.coroutines.selects.a.C0491a.a(this, eVar, pVar);
    }

    @Override // kotlinx.coroutines.selects.f
    public void Z(@a7.d Throwable th) {
        while (true) {
            Object obj = this._result;
            if (obj == g.f37223c) {
                if (androidx.concurrent.futures.b.a(f37211f, this, g.f37223c, new e0(th, false, 2, null))) {
                    return;
                }
            } else {
                if (obj != kotlin.coroutines.intrinsics.d.h()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (androidx.concurrent.futures.b.a(f37211f, this, kotlin.coroutines.intrinsics.d.h(), g.f37224d)) {
                    kotlin.coroutines.d dVarD = kotlin.coroutines.intrinsics.c.d(this.f37212d);
                    d1.a aVar = d1.f34719b;
                    dVarD.w(d1.b(e1.a(th)));
                    return;
                }
            }
        }
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        return this.f37212d.d();
    }

    @a7.e
    @a1
    public final Object d1() {
        if (!E()) {
            O();
        }
        Object obj = this._result;
        if (obj == g.f37223c) {
            if (androidx.concurrent.futures.b.a(f37211f, this, g.f37223c, kotlin.coroutines.intrinsics.d.h())) {
                return kotlin.coroutines.intrinsics.d.h();
            }
            obj = this._result;
        }
        if (obj == g.f37224d) {
            throw new IllegalStateException("Already resumed");
        }
        if (obj instanceof e0) {
            throw ((e0) obj).f35988a;
        }
        return obj;
    }

    @Override // kotlinx.coroutines.selects.f
    @a7.e
    public Object e0(@a7.d kotlinx.coroutines.internal.b bVar) {
        return new a(this, bVar).c(null);
    }

    @a1
    public final void e1(@a7.d Throwable th) {
        if (q()) {
            d1.a aVar = d1.f34719b;
            w(d1.b(e1.a(th)));
        } else {
            if (th instanceof CancellationException) {
                return;
            }
            Object objD1 = d1();
            if ((objD1 instanceof e0) && ((e0) objD1).f35988a == th) {
                return;
            }
            r0.b(d(), th);
        }
    }

    @Override // kotlinx.coroutines.selects.a
    public void f(@a7.d kotlinx.coroutines.selects.c cVar, @a7.d l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar) {
        cVar.P(this, lVar);
    }

    @Override // kotlinx.coroutines.selects.f
    @a7.e
    public Object g(@a7.e y.d dVar) {
        while (true) {
            Object obj = this._state;
            if (obj == g.f()) {
                if (dVar != null) {
                    c cVar = new c(dVar);
                    if (androidx.concurrent.futures.b.a(f37210e, this, g.f(), cVar)) {
                        Object objC = cVar.c(this);
                        if (objC == null) {
                            break;
                        }
                        return objC;
                    }
                } else if (androidx.concurrent.futures.b.a(f37210e, this, g.f(), null)) {
                    break;
                }
            } else {
                if (!(obj instanceof j0)) {
                    if (dVar != null && obj == dVar.f37053c) {
                        return s.f37123d;
                    }
                    return null;
                }
                if (dVar != null) {
                    kotlinx.coroutines.internal.d<?> dVarA = dVar.a();
                    if ((dVarA instanceof a) && ((a) dVarA).f37213b == this) {
                        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    }
                    if (dVarA.b((j0) obj)) {
                        return kotlinx.coroutines.internal.c.f36965b;
                    }
                }
                ((j0) obj).c(this);
            }
        }
        a1();
        return s.f37123d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.a
    public <P, Q> void g0(@a7.d kotlinx.coroutines.selects.e<? super P, ? extends Q> eVar, P p7, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        eVar.y(this, p7, pVar);
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public kotlin.coroutines.jvm.internal.e i() {
        kotlin.coroutines.d<R> dVar = this.f37212d;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.a
    public <Q> void m(@a7.d kotlinx.coroutines.selects.d<? extends Q> dVar, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        dVar.h(this, pVar);
    }

    @Override // kotlinx.coroutines.selects.f
    public void o0(@a7.d q1 q1Var) {
        C0492b c0492b = new C0492b(q1Var);
        if (!E()) {
            v0(c0492b);
            if (!E()) {
                return;
            }
        }
        q1Var.F();
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean q() {
        Object objG = g(null);
        if (objG == s.f37123d) {
            return true;
        }
        if (objG == null) {
            return false;
        }
        throw new IllegalStateException(l0.C("Unexpected trySelectIdempotent result ", objG).toString());
    }

    @Override // kotlinx.coroutines.internal.y
    @a7.d
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    @Override // kotlin.coroutines.d
    public void w(@a7.d Object obj) {
        while (true) {
            Object obj2 = this._result;
            if (obj2 == g.f37223c) {
                if (androidx.concurrent.futures.b.a(f37211f, this, g.f37223c, k0.d(obj, null, 1, null))) {
                    return;
                }
            } else {
                if (obj2 != kotlin.coroutines.intrinsics.d.h()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (androidx.concurrent.futures.b.a(f37211f, this, kotlin.coroutines.intrinsics.d.h(), g.f37224d)) {
                    if (!d1.i(obj)) {
                        this.f37212d.w(obj);
                        return;
                    }
                    kotlin.coroutines.d<R> dVar = this.f37212d;
                    Throwable thE = d1.e(obj);
                    l0.m(thE);
                    d1.a aVar = d1.f34719b;
                    dVar.w(d1.b(e1.a(thE)));
                    return;
                }
            }
        }
    }
}
