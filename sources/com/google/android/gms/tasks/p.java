package com.google.android.gms.tasks;

import android.os.Looper;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    private p() {
    }

    public static <TResult> TResult a(@c.m0 m<TResult> mVar) throws ExecutionException, InterruptedException {
        com.google.android.gms.common.internal.u.i();
        com.google.android.gms.common.internal.u.l(mVar, "Task must not be null");
        if (mVar.u()) {
            return (TResult) o(mVar);
        }
        u uVar = new u(null);
        p(mVar, uVar);
        uVar.b();
        return (TResult) o(mVar);
    }

    public static <TResult> TResult b(@c.m0 m<TResult> mVar, long j7, @c.m0 TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        com.google.android.gms.common.internal.u.i();
        com.google.android.gms.common.internal.u.l(mVar, "Task must not be null");
        com.google.android.gms.common.internal.u.l(timeUnit, "TimeUnit must not be null");
        if (mVar.u()) {
            return (TResult) o(mVar);
        }
        u uVar = new u(null);
        p(mVar, uVar);
        if (uVar.d(j7, timeUnit)) {
            return (TResult) o(mVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @c.m0
    @Deprecated
    public static <TResult> m<TResult> c(@c.m0 Callable<TResult> callable) {
        return d(o.f16811a, callable);
    }

    @c.m0
    @Deprecated
    public static <TResult> m<TResult> d(@c.m0 Executor executor, @c.m0 Callable<TResult> callable) {
        com.google.android.gms.common.internal.u.l(executor, "Executor must not be null");
        com.google.android.gms.common.internal.u.l(callable, "Callback must not be null");
        s0 s0Var = new s0();
        executor.execute(new v0(s0Var, callable));
        return s0Var;
    }

    @c.m0
    public static <TResult> m<TResult> e() {
        s0 s0Var = new s0();
        s0Var.A();
        return s0Var;
    }

    @c.m0
    public static <TResult> m<TResult> f(@c.m0 Exception exc) {
        s0 s0Var = new s0();
        s0Var.y(exc);
        return s0Var;
    }

    @c.m0
    public static <TResult> m<TResult> g(TResult tresult) {
        s0 s0Var = new s0();
        s0Var.z(tresult);
        return s0Var;
    }

    @c.m0
    public static m<Void> h(@c.o0 Collection<? extends m<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return g(null);
        }
        Iterator<? extends m<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        s0 s0Var = new s0();
        w wVar = new w(collection.size(), s0Var);
        Iterator<? extends m<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            p(it2.next(), wVar);
        }
        return s0Var;
    }

    @c.m0
    public static m<Void> i(@c.o0 m<?>... mVarArr) {
        return (mVarArr == null || mVarArr.length == 0) ? g(null) : h(Arrays.asList(mVarArr));
    }

    @c.m0
    public static m<List<m<?>>> j(@c.o0 Collection<? extends m<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return g(Collections.emptyList());
        }
        return h(collection).p(o.f16811a, new s(collection));
    }

    @c.m0
    public static m<List<m<?>>> k(@c.o0 m<?>... mVarArr) {
        return (mVarArr == null || mVarArr.length == 0) ? g(Collections.emptyList()) : j(Arrays.asList(mVarArr));
    }

    @c.m0
    public static <TResult> m<List<TResult>> l(@c.o0 Collection<? extends m> collection) {
        if (collection == null || collection.isEmpty()) {
            return g(Collections.emptyList());
        }
        return (m<List<TResult>>) h(collection).n(o.f16811a, new r(collection));
    }

    @c.m0
    public static <TResult> m<List<TResult>> m(@c.o0 m... mVarArr) {
        return (mVarArr == null || mVarArr.length == 0) ? g(Collections.emptyList()) : l(Arrays.asList(mVarArr));
    }

    @c.m0
    public static <T> m<T> n(@c.m0 m<T> mVar, long j7, @c.m0 TimeUnit timeUnit) {
        com.google.android.gms.common.internal.u.l(mVar, "Task must not be null");
        com.google.android.gms.common.internal.u.b(j7 > 0, "Timeout must be positive");
        com.google.android.gms.common.internal.u.l(timeUnit, "TimeUnit must not be null");
        final x xVar = new x();
        final n nVar = new n(xVar);
        final h1.a aVar = new h1.a(Looper.getMainLooper());
        aVar.postDelayed(new Runnable() { // from class: com.google.android.gms.tasks.u0
            @Override // java.lang.Runnable
            public final void run() {
                nVar.d(new TimeoutException());
            }
        }, timeUnit.toMillis(j7));
        mVar.e(new f() { // from class: com.google.android.gms.tasks.t0
            @Override // com.google.android.gms.tasks.f
            public final void a(m mVar2) {
                h1.a aVar2 = aVar;
                n nVar2 = nVar;
                x xVar2 = xVar;
                aVar2.removeCallbacksAndMessages(null);
                if (mVar2.v()) {
                    nVar2.e(mVar2.r());
                } else {
                    if (mVar2.t()) {
                        xVar2.c();
                        return;
                    }
                    Exception excQ = mVar2.q();
                    excQ.getClass();
                    nVar2.d(excQ);
                }
            }
        });
        return nVar.a();
    }

    private static <TResult> TResult o(@c.m0 m<TResult> mVar) throws ExecutionException {
        if (mVar.v()) {
            return mVar.r();
        }
        if (mVar.t()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(mVar.q());
    }

    private static <T> void p(m<T> mVar, v<? super T> vVar) {
        Executor executor = o.f16812b;
        mVar.l(executor, vVar);
        mVar.i(executor, vVar);
        mVar.c(executor, vVar);
    }
}
