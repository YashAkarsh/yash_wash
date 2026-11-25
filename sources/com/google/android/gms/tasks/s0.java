package com.google.android.gms.tasks;

import android.app.Activity;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class s0<TResult> extends m<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f16819a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n0<TResult> f16820b = new n0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    private boolean f16821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f16822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    @GuardedBy("mLock")
    private TResult f16823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("mLock")
    private Exception f16824f;

    s0() {
    }

    @GuardedBy("mLock")
    private final void D() {
        com.google.android.gms.common.internal.u.r(this.f16821c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void E() {
        if (this.f16822d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    @GuardedBy("mLock")
    private final void F() {
        if (this.f16821c) {
            throw d.a(this);
        }
    }

    private final void G() {
        synchronized (this.f16819a) {
            if (this.f16821c) {
                this.f16820b.b(this);
            }
        }
    }

    public final boolean A() {
        synchronized (this.f16819a) {
            if (this.f16821c) {
                return false;
            }
            this.f16821c = true;
            this.f16822d = true;
            this.f16820b.b(this);
            return true;
        }
    }

    public final boolean B(@c.m0 Exception exc) {
        com.google.android.gms.common.internal.u.l(exc, "Exception must not be null");
        synchronized (this.f16819a) {
            if (this.f16821c) {
                return false;
            }
            this.f16821c = true;
            this.f16824f = exc;
            this.f16820b.b(this);
            return true;
        }
    }

    public final boolean C(@c.o0 TResult tresult) {
        synchronized (this.f16819a) {
            if (this.f16821c) {
                return false;
            }
            this.f16821c = true;
            this.f16823e = tresult;
            this.f16820b.b(this);
            return true;
        }
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> a(@c.m0 Activity activity, @c.m0 e eVar) {
        d0 d0Var = new d0(o.f16811a, eVar);
        this.f16820b.a(d0Var);
        r0.m(activity).n(d0Var);
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> b(@c.m0 e eVar) {
        c(o.f16811a, eVar);
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> c(@c.m0 Executor executor, @c.m0 e eVar) {
        this.f16820b.a(new d0(executor, eVar));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> d(@c.m0 Activity activity, @c.m0 f<TResult> fVar) {
        f0 f0Var = new f0(o.f16811a, fVar);
        this.f16820b.a(f0Var);
        r0.m(activity).n(f0Var);
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> e(@c.m0 f<TResult> fVar) {
        this.f16820b.a(new f0(o.f16811a, fVar));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> f(@c.m0 Executor executor, @c.m0 f<TResult> fVar) {
        this.f16820b.a(new f0(executor, fVar));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> g(@c.m0 Activity activity, @c.m0 g gVar) {
        h0 h0Var = new h0(o.f16811a, gVar);
        this.f16820b.a(h0Var);
        r0.m(activity).n(h0Var);
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> h(@c.m0 g gVar) {
        i(o.f16811a, gVar);
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> i(@c.m0 Executor executor, @c.m0 g gVar) {
        this.f16820b.a(new h0(executor, gVar));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> j(@c.m0 Activity activity, @c.m0 h<? super TResult> hVar) {
        j0 j0Var = new j0(o.f16811a, hVar);
        this.f16820b.a(j0Var);
        r0.m(activity).n(j0Var);
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> k(@c.m0 h<? super TResult> hVar) {
        l(o.f16811a, hVar);
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final m<TResult> l(@c.m0 Executor executor, @c.m0 h<? super TResult> hVar) {
        this.f16820b.a(new j0(executor, hVar));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final <TContinuationResult> m<TContinuationResult> m(@c.m0 c<TResult, TContinuationResult> cVar) {
        return n(o.f16811a, cVar);
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final <TContinuationResult> m<TContinuationResult> n(@c.m0 Executor executor, @c.m0 c<TResult, TContinuationResult> cVar) {
        s0 s0Var = new s0();
        this.f16820b.a(new z(executor, cVar, s0Var));
        G();
        return s0Var;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final <TContinuationResult> m<TContinuationResult> o(@c.m0 c<TResult, m<TContinuationResult>> cVar) {
        return p(o.f16811a, cVar);
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final <TContinuationResult> m<TContinuationResult> p(@c.m0 Executor executor, @c.m0 c<TResult, m<TContinuationResult>> cVar) {
        s0 s0Var = new s0();
        this.f16820b.a(new b0(executor, cVar, s0Var));
        G();
        return s0Var;
    }

    @Override // com.google.android.gms.tasks.m
    @c.o0
    public final Exception q() {
        Exception exc;
        synchronized (this.f16819a) {
            exc = this.f16824f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.m
    public final TResult r() {
        TResult tresult;
        synchronized (this.f16819a) {
            D();
            E();
            Exception exc = this.f16824f;
            if (exc != null) {
                throw new k(exc);
            }
            tresult = this.f16823e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.m
    public final <X extends Throwable> TResult s(@c.m0 Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f16819a) {
            D();
            E();
            if (cls.isInstance(this.f16824f)) {
                throw cls.cast(this.f16824f);
            }
            Exception exc = this.f16824f;
            if (exc != null) {
                throw new k(exc);
            }
            tresult = this.f16823e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.m
    public final boolean t() {
        return this.f16822d;
    }

    @Override // com.google.android.gms.tasks.m
    public final boolean u() {
        boolean z7;
        synchronized (this.f16819a) {
            z7 = this.f16821c;
        }
        return z7;
    }

    @Override // com.google.android.gms.tasks.m
    public final boolean v() {
        boolean z7;
        synchronized (this.f16819a) {
            z7 = false;
            if (this.f16821c && !this.f16822d && this.f16824f == null) {
                z7 = true;
            }
        }
        return z7;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final <TContinuationResult> m<TContinuationResult> w(@c.m0 l<TResult, TContinuationResult> lVar) {
        Executor executor = o.f16811a;
        s0 s0Var = new s0();
        this.f16820b.a(new l0(executor, lVar, s0Var));
        G();
        return s0Var;
    }

    @Override // com.google.android.gms.tasks.m
    @c.m0
    public final <TContinuationResult> m<TContinuationResult> x(Executor executor, l<TResult, TContinuationResult> lVar) {
        s0 s0Var = new s0();
        this.f16820b.a(new l0(executor, lVar, s0Var));
        G();
        return s0Var;
    }

    public final void y(@c.m0 Exception exc) {
        com.google.android.gms.common.internal.u.l(exc, "Exception must not be null");
        synchronized (this.f16819a) {
            F();
            this.f16821c = true;
            this.f16824f = exc;
        }
        this.f16820b.b(this);
    }

    public final void z(@c.o0 TResult tresult) {
        synchronized (this.f16819a) {
            F();
            this.f16821c = true;
            this.f16823e = tresult;
        }
        this.f16820b.b(this);
    }
}
