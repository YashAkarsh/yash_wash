package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l2;
import kotlinx.coroutines.d4;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.u1;
import kotlinx.coroutines.v3;

/* JADX INFO: loaded from: classes3.dex */
public final class l<T> extends k1<T> implements kotlin.coroutines.jvm.internal.e, kotlin.coroutines.d<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f36993h = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_reusableCancellableContinuation");

    @a7.d
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @h5.e
    public final kotlinx.coroutines.o0 f36994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    @h5.e
    public final kotlin.coroutines.d<T> f36995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @h5.e
    @a7.e
    public Object f36996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    @h5.e
    public final Object f36997g;

    /* JADX WARN: Multi-variable type inference failed */
    public l(@a7.d kotlinx.coroutines.o0 o0Var, @a7.d kotlin.coroutines.d<? super T> dVar) {
        super(-1);
        this.f36994d = o0Var;
        this.f36995e = dVar;
        this.f36996f = m.f36999a;
        this.f36997g = w0.b(d());
        this._reusableCancellableContinuation = null;
    }

    private final kotlinx.coroutines.r<?> o() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof kotlinx.coroutines.r) {
            return (kotlinx.coroutines.r) obj;
        }
        return null;
    }

    public static /* synthetic */ void p() {
    }

    @a7.e
    public final Throwable A(@a7.d kotlinx.coroutines.q<?> qVar) {
        r0 r0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            r0Var = m.f37000b;
            if (obj != r0Var) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(kotlin.jvm.internal.l0.C("Inconsistent state ", obj).toString());
                }
                if (androidx.concurrent.futures.b.a(f36993h, this, obj, null)) {
                    return (Throwable) obj;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } while (!androidx.concurrent.futures.b.a(f36993h, this, r0Var, qVar));
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public StackTraceElement I() {
        return null;
    }

    @Override // kotlinx.coroutines.k1
    public void c(@a7.e Object obj, @a7.d Throwable th) {
        if (obj instanceof kotlinx.coroutines.f0) {
            ((kotlinx.coroutines.f0) obj).f35999b.z(th);
        }
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        return this.f36995e.d();
    }

    @Override // kotlinx.coroutines.k1
    @a7.d
    public kotlin.coroutines.d<T> f() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public kotlin.coroutines.jvm.internal.e i() {
        kotlin.coroutines.d<T> dVar = this.f36995e;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // kotlinx.coroutines.k1
    @a7.e
    public Object k() {
        Object obj = this.f36996f;
        this.f36996f = m.f36999a;
        return obj;
    }

    public final void l() {
        while (this._reusableCancellableContinuation == m.f37000b) {
        }
    }

    @a7.e
    public final kotlinx.coroutines.r<T> m() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = m.f37000b;
                return null;
            }
            if (obj instanceof kotlinx.coroutines.r) {
                if (androidx.concurrent.futures.b.a(f36993h, this, obj, m.f37000b)) {
                    return (kotlinx.coroutines.r) obj;
                }
            } else if (obj != m.f37000b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Inconsistent state ", obj).toString());
            }
        }
    }

    public final void n(@a7.d kotlin.coroutines.g gVar, T t7) {
        this.f36996f = t7;
        this.f37063c = 1;
        this.f36994d.V0(gVar, this);
    }

    public final boolean q() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean s(@a7.d Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            r0 r0Var = m.f37000b;
            if (kotlin.jvm.internal.l0.g(obj, r0Var)) {
                if (androidx.concurrent.futures.b.a(f36993h, this, r0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.b.a(f36993h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @a7.d
    public String toString() {
        return "DispatchedContinuation[" + this.f36994d + ", " + kotlinx.coroutines.a1.c(this.f36995e) + ']';
    }

    public final void u() {
        l();
        kotlinx.coroutines.r<?> rVarO = o();
        if (rVarO == null) {
            return;
        }
        rVarO.s();
    }

    public final void v(@a7.d Object obj, @a7.e i5.l<? super Throwable, l2> lVar) {
        boolean z7;
        Object objB = kotlinx.coroutines.k0.b(obj, lVar);
        if (this.f36994d.Y0(d())) {
            this.f36996f = objB;
            this.f37063c = 1;
            this.f36994d.T0(d(), this);
            return;
        }
        u1 u1VarB = v3.f37337a.b();
        if (u1VarB.N1()) {
            this.f36996f = objB;
            this.f37063c = 1;
            u1VarB.s1(this);
            return;
        }
        u1VarB.z1(true);
        try {
            o2 o2Var = (o2) d().get(o2.f37103s0);
            if (o2Var == null || o2Var.b()) {
                z7 = false;
            } else {
                CancellationException cancellationExceptionK = o2Var.K();
                c(objB, cancellationExceptionK);
                kotlin.d1.a aVar = kotlin.d1.f34719b;
                w(kotlin.d1.b(kotlin.e1.a(cancellationExceptionK)));
                z7 = true;
            }
            if (!z7) {
                kotlin.coroutines.d<T> dVar = this.f36995e;
                Object obj2 = this.f36997g;
                kotlin.coroutines.g gVarD = dVar.d();
                Object objC = w0.c(gVarD, obj2);
                d4<?> d4VarG = objC != w0.f37028a ? kotlinx.coroutines.n0.g(dVar, gVarD, objC) : null;
                try {
                    this.f36995e.w(obj);
                    l2 l2Var = l2.f34958a;
                    kotlin.jvm.internal.i0.d(1);
                    if (d4VarG == null || d4VarG.G1()) {
                        w0.a(gVarD, objC);
                    }
                    kotlin.jvm.internal.i0.c(1);
                } finally {
                    kotlin.jvm.internal.i0.d(1);
                    if (d4VarG == null || d4VarG.G1()) {
                        w0.a(gVarD, objC);
                    }
                    kotlin.jvm.internal.i0.c(1);
                }
            }
            while (u1VarB.X1()) {
            }
            kotlin.jvm.internal.i0.d(1);
        } catch (Throwable th) {
            try {
                j(th, null);
                kotlin.jvm.internal.i0.d(1);
            } finally {
                kotlin.jvm.internal.i0.d(1);
                u1VarB.e1(true);
                kotlin.jvm.internal.i0.c(1);
            }
        }
    }

    @Override // kotlin.coroutines.d
    public void w(@a7.d Object obj) {
        kotlin.coroutines.g gVarD = this.f36995e.d();
        Object objD = kotlinx.coroutines.k0.d(obj, null, 1, null);
        if (this.f36994d.Y0(gVarD)) {
            this.f36996f = objD;
            this.f37063c = 0;
            this.f36994d.T0(gVarD, this);
            return;
        }
        u1 u1VarB = v3.f37337a.b();
        if (u1VarB.N1()) {
            this.f36996f = objD;
            this.f37063c = 0;
            u1VarB.s1(this);
            return;
        }
        u1VarB.z1(true);
        try {
            kotlin.coroutines.g gVarD2 = d();
            Object objC = w0.c(gVarD2, this.f36997g);
            try {
                this.f36995e.w(obj);
                l2 l2Var = l2.f34958a;
                w0.a(gVarD2, objC);
                while (u1VarB.X1()) {
                }
            } catch (Throwable th) {
                w0.a(gVarD2, objC);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                j(th2, null);
            } finally {
                u1VarB.e1(true);
            }
        }
    }

    public final boolean y(@a7.e Object obj) {
        o2 o2Var = (o2) d().get(o2.f37103s0);
        if (o2Var == null || o2Var.b()) {
            return false;
        }
        CancellationException cancellationExceptionK = o2Var.K();
        c(obj, cancellationExceptionK);
        kotlin.d1.a aVar = kotlin.d1.f34719b;
        w(kotlin.d1.b(kotlin.e1.a(cancellationExceptionK)));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0029 A[DONT_GENERATE] */
    public final void z(@a7.d Object obj) {
        kotlin.coroutines.d<T> dVar = this.f36995e;
        Object obj2 = this.f36997g;
        kotlin.coroutines.g gVarD = dVar.d();
        Object objC = w0.c(gVarD, obj2);
        d4<?> d4VarG = objC != w0.f37028a ? kotlinx.coroutines.n0.g(dVar, gVarD, objC) : null;
        try {
            this.f36995e.w(obj);
            l2 l2Var = l2.f34958a;
        } finally {
            kotlin.jvm.internal.i0.d(1);
            if (d4VarG == null || d4VarG.G1()) {
                w0.a(gVarD, objC);
            }
            kotlin.jvm.internal.i0.c(1);
        }
    }
}
