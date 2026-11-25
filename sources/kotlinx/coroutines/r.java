package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.a1
public class r<T> extends k1<T> implements q<T>, kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37112g = AtomicIntegerFieldUpdater.newUpdater(r.class, "_decision");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f37113h = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "_state");

    @a7.d
    private volatile /* synthetic */ int _decision;

    @a7.d
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.d<T> f37114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.g f37115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.e
    private q1 f37116f;

    /* JADX WARN: Multi-variable type inference failed */
    public r(@a7.d kotlin.coroutines.d<? super T> dVar, int i7) {
        super(i7);
        this.f37114d = dVar;
        this.f37115e = dVar.d();
        this._decision = 0;
        this._state = d.f35888a;
    }

    private final String B() {
        Object objA = A();
        if (objA instanceof e3) {
            return "Active";
        }
        return objA instanceof u ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
    }

    private final q1 C() {
        o2 o2Var = (o2) d().get(o2.f37103s0);
        if (o2Var == null) {
            return null;
        }
        q1 q1VarF = o2.a.f(o2Var, true, false, new v(this), 2, null);
        this.f37116f = q1VarF;
        return q1VarF;
    }

    private final boolean D() {
        return l1.d(this.f37063c) && ((kotlinx.coroutines.internal.l) this.f37114d).q();
    }

    private final o E(i5.l<? super Throwable, kotlin.l2> lVar) {
        return lVar instanceof o ? (o) lVar : new l2(lVar);
    }

    private final void F(i5.l<? super Throwable, kotlin.l2> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void K() {
        kotlin.coroutines.d<T> dVar = this.f37114d;
        kotlinx.coroutines.internal.l lVar = dVar instanceof kotlinx.coroutines.internal.l ? (kotlinx.coroutines.internal.l) dVar : null;
        Throwable thA = lVar != null ? lVar.A(this) : null;
        if (thA == null) {
            return;
        }
        s();
        e(thA);
    }

    private final void P(Object obj, int i7, i5.l<? super Throwable, kotlin.l2> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof e3)) {
                if (obj2 instanceof u) {
                    u uVar = (u) obj2;
                    if (uVar.c()) {
                        if (lVar == null) {
                            return;
                        }
                        p(lVar, uVar.f35988a);
                        return;
                    }
                }
                l(obj);
                throw new kotlin.y();
            }
        } while (!androidx.concurrent.futures.b.a(f37113h, this, obj2, R((e3) obj2, obj, i7, lVar, null)));
        u();
        v(i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void Q(r rVar, Object obj, int i7, i5.l lVar, int i8, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i8 & 4) != 0) {
            lVar = null;
        }
        rVar.P(obj, i7, lVar);
    }

    private final Object R(e3 e3Var, Object obj, int i7, i5.l<? super Throwable, kotlin.l2> lVar, Object obj2) {
        if (obj instanceof e0) {
            return obj;
        }
        if (!l1.c(i7) && obj2 == null) {
            return obj;
        }
        if (lVar != null || (((e3Var instanceof o) && !(e3Var instanceof g)) || obj2 != null)) {
            return new d0(obj, e3Var instanceof o ? (o) e3Var : null, lVar, obj2, null, 16, null);
        }
        return obj;
    }

    private final boolean S() {
        do {
            int i7 = this._decision;
            if (i7 != 0) {
                if (i7 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f37112g.compareAndSet(this, 0, 2));
        return true;
    }

    private final kotlinx.coroutines.internal.r0 T(Object obj, Object obj2, i5.l<? super Throwable, kotlin.l2> lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof e3)) {
                if ((obj3 instanceof d0) && obj2 != null && ((d0) obj3).f35892d == obj2) {
                    return s.f37123d;
                }
                return null;
            }
        } while (!androidx.concurrent.futures.b.a(f37113h, this, obj3, R((e3) obj3, obj, this.f37063c, lVar, obj2)));
        u();
        return s.f37123d;
    }

    private final boolean U() {
        do {
            int i7 = this._decision;
            if (i7 != 0) {
                if (i7 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f37112g.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void l(Object obj) {
        throw new IllegalStateException(kotlin.jvm.internal.l0.C("Already resumed, but proposed with update ", obj).toString());
    }

    private final void m(i5.l<? super Throwable, kotlin.l2> lVar, Throwable th) {
        try {
            lVar.z(th);
        } catch (Throwable th2) {
            r0.b(d(), new h0(kotlin.jvm.internal.l0.C("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    private final void o(i5.a<kotlin.l2> aVar) {
        try {
            aVar.invoke();
        } catch (Throwable th) {
            r0.b(d(), new h0(kotlin.jvm.internal.l0.C("Exception in invokeOnCancellation handler for ", this), th));
        }
    }

    private final boolean q(Throwable th) {
        if (D()) {
            return ((kotlinx.coroutines.internal.l) this.f37114d).s(th);
        }
        return false;
    }

    private final void u() {
        if (D()) {
            return;
        }
        s();
    }

    private final void v(int i7) {
        if (S()) {
            return;
        }
        l1.a(this, i7);
    }

    @a7.e
    public final Object A() {
        return this._state;
    }

    @a7.d
    protected String G() {
        return "CancellableContinuation";
    }

    public final void H(@a7.d Throwable th) {
        if (q(th)) {
            return;
        }
        e(th);
        u();
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public StackTraceElement I() {
        return null;
    }

    @Override // kotlinx.coroutines.q
    @a7.e
    public Object J(@a7.d Throwable th) {
        return T(new e0(th, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.q
    public void L(@a7.d o0 o0Var, @a7.d Throwable th) {
        kotlin.coroutines.d<T> dVar = this.f37114d;
        kotlinx.coroutines.internal.l lVar = dVar instanceof kotlinx.coroutines.internal.l ? (kotlinx.coroutines.internal.l) dVar : null;
        Q(this, new e0(th, false, 2, null), (lVar != null ? lVar.f36994d : null) == o0Var ? 4 : this.f37063c, null, 4, null);
    }

    @h5.h(name = "resetStateReusable")
    public final boolean M() {
        Object obj = this._state;
        if ((obj instanceof d0) && ((d0) obj).f35892d != null) {
            s();
            return false;
        }
        this._decision = 0;
        this._state = d.f35888a;
        return true;
    }

    @Override // kotlinx.coroutines.q
    public void N(@a7.d o0 o0Var, T t7) {
        kotlin.coroutines.d<T> dVar = this.f37114d;
        kotlinx.coroutines.internal.l lVar = dVar instanceof kotlinx.coroutines.internal.l ? (kotlinx.coroutines.internal.l) dVar : null;
        Q(this, t7, (lVar != null ? lVar.f36994d : null) == o0Var ? 4 : this.f37063c, null, 4, null);
    }

    @Override // kotlinx.coroutines.q
    public void O() {
        q1 q1VarC = C();
        if (q1VarC != null && r()) {
            q1VarC.F();
            this.f37116f = d3.f35894a;
        }
    }

    @Override // kotlinx.coroutines.q
    public boolean b() {
        return A() instanceof e3;
    }

    @Override // kotlinx.coroutines.k1
    public void c(@a7.e Object obj, @a7.d Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof e3) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof e0) {
                return;
            }
            if (obj2 instanceof d0) {
                d0 d0Var = (d0) obj2;
                if (!(!d0Var.h())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (androidx.concurrent.futures.b.a(f37113h, this, obj2, d0.g(d0Var, null, null, null, null, th, 15, null))) {
                    d0Var.i(this, th);
                    return;
                }
            } else if (androidx.concurrent.futures.b.a(f37113h, this, obj2, new d0(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.q
    @a7.e
    public Object c0(T t7, @a7.e Object obj, @a7.e i5.l<? super Throwable, kotlin.l2> lVar) {
        return T(t7, obj, lVar);
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        return this.f37115e;
    }

    @Override // kotlinx.coroutines.q
    public boolean e(@a7.e Throwable th) {
        Object obj;
        boolean z7;
        do {
            obj = this._state;
            if (!(obj instanceof e3)) {
                return false;
            }
            z7 = obj instanceof o;
        } while (!androidx.concurrent.futures.b.a(f37113h, this, obj, new u(this, th, z7)));
        o oVar = z7 ? (o) obj : null;
        if (oVar != null) {
            n(oVar, th);
        }
        u();
        v(this.f37063c);
        return true;
    }

    @Override // kotlinx.coroutines.k1
    @a7.d
    public final kotlin.coroutines.d<T> f() {
        return this.f37114d;
    }

    @Override // kotlinx.coroutines.k1
    @a7.e
    public Throwable g(@a7.e Object obj) {
        Throwable thG = super.g(obj);
        if (thG == null) {
            return null;
        }
        f();
        return thG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.k1
    public <T> T h(@a7.e Object obj) {
        return obj instanceof d0 ? (T) ((d0) obj).f35889a : obj;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public kotlin.coroutines.jvm.internal.e i() {
        kotlin.coroutines.d<T> dVar = this.f37114d;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // kotlinx.coroutines.q
    public void i0(@a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        o oVarE = E(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (androidx.concurrent.futures.b.a(f37113h, this, obj, oVarE)) {
                    return;
                }
            } else if (obj instanceof o) {
                F(lVar, obj);
            } else {
                boolean z7 = obj instanceof e0;
                if (z7) {
                    e0 e0Var = (e0) obj;
                    if (!e0Var.b()) {
                        F(lVar, obj);
                    }
                    if (obj instanceof u) {
                        if (!z7) {
                            e0Var = null;
                        }
                        m(lVar, e0Var != null ? e0Var.f35988a : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof d0) {
                    d0 d0Var = (d0) obj;
                    if (d0Var.f35890b != null) {
                        F(lVar, obj);
                    }
                    if (oVarE instanceof g) {
                        return;
                    }
                    if (d0Var.h()) {
                        m(lVar, d0Var.f35893e);
                        return;
                    } else {
                        if (androidx.concurrent.futures.b.a(f37113h, this, obj, d0.g(d0Var, null, oVarE, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (oVarE instanceof g) {
                        return;
                    }
                    if (androidx.concurrent.futures.b.a(f37113h, this, obj, new d0(obj, oVarE, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.q
    public boolean isCancelled() {
        return A() instanceof u;
    }

    @Override // kotlinx.coroutines.k1
    @a7.e
    public Object k() {
        return A();
    }

    public final void n(@a7.d o oVar, @a7.e Throwable th) {
        try {
            oVar.b(th);
        } catch (Throwable th2) {
            r0.b(d(), new h0(kotlin.jvm.internal.l0.C("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    public final void p(@a7.d i5.l<? super Throwable, kotlin.l2> lVar, @a7.d Throwable th) {
        try {
            lVar.z(th);
        } catch (Throwable th2) {
            r0.b(d(), new h0(kotlin.jvm.internal.l0.C("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    @Override // kotlinx.coroutines.q
    public boolean r() {
        return !(A() instanceof e3);
    }

    public final void s() {
        q1 q1Var = this.f37116f;
        if (q1Var == null) {
            return;
        }
        q1Var.F();
        this.f37116f = d3.f35894a;
    }

    @Override // kotlinx.coroutines.q
    @a7.e
    public Object t(T t7, @a7.e Object obj) {
        return T(t7, obj, null);
    }

    @Override // kotlinx.coroutines.q
    public void t0(@a7.d Object obj) {
        v(this.f37063c);
    }

    @a7.d
    public String toString() {
        return G() + '(' + a1.c(this.f37114d) + "){" + B() + "}@" + a1.b(this);
    }

    @Override // kotlin.coroutines.d
    public void w(@a7.d Object obj) {
        Q(this, k0.c(obj, this), this.f37063c, null, 4, null);
    }

    @Override // kotlinx.coroutines.q
    public void x(T t7, @a7.e i5.l<? super Throwable, kotlin.l2> lVar) {
        P(t7, this.f37063c, lVar);
    }

    @a7.d
    public Throwable y(@a7.d o2 o2Var) {
        return o2Var.K();
    }

    @a7.e
    @kotlin.a1
    public final Object z() {
        o2 o2Var;
        boolean zD = D();
        if (U()) {
            if (this.f37116f == null) {
                C();
            }
            if (zD) {
                K();
            }
            return kotlin.coroutines.intrinsics.d.h();
        }
        if (zD) {
            K();
        }
        Object objA = A();
        if (objA instanceof e0) {
            throw ((e0) objA).f35988a;
        }
        if (!l1.c(this.f37063c) || (o2Var = (o2) d().get(o2.f37103s0)) == null || o2Var.b()) {
            return h(objA);
        }
        CancellationException cancellationExceptionK = o2Var.K();
        c(objA, cancellationExceptionK);
        throw cancellationExceptionK;
    }
}
