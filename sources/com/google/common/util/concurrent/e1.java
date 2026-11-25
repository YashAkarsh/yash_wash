package com.google.common.util.concurrent;

import com.google.common.collect.d7;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b(emulated = true)
public final class e1 extends h1 {

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Future f22622a;

        a(Future future) {
            this.f22622a = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22622a.cancel(false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [O] */
    static class b<O> implements Future<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Future f22623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.s f22624b;

        b(Future future, com.google.common.base.s sVar) {
            this.f22623a = future;
            this.f22624b = sVar;
        }

        private O a(I i7) throws ExecutionException {
            try {
                return (O) this.f22624b.apply(i7);
            } catch (Throwable th) {
                throw new ExecutionException(th);
            }
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z7) {
            return this.f22623a.cancel(z7);
        }

        @Override // java.util.concurrent.Future
        public O get() throws ExecutionException, InterruptedException {
            return a(this.f22623a.get());
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f22623a.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f22623a.isDone();
        }

        @Override // java.util.concurrent.Future
        public O get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return a(this.f22623a.get(j7, timeUnit));
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f22625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d7 f22626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f22627c;

        c(g gVar, d7 d7Var, int i7) {
            this.f22625a = gVar;
            this.f22626b = d7Var;
            this.f22627c = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22625a.f(this.f22626b, this.f22627c);
        }
    }

    private static final class d<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Future<V> f22628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final d1<? super V> f22629b;

        d(Future<V> future, d1<? super V> d1Var) {
            this.f22628a = future;
            this.f22629b = d1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f22629b.onSuccess(e1.h(this.f22628a));
            } catch (Error e8) {
                e = e8;
                this.f22629b.a(e);
            } catch (RuntimeException e9) {
                e = e9;
                this.f22629b.a(e);
            } catch (ExecutionException e10) {
                this.f22629b.a(e10.getCause());
            }
        }

        public String toString() {
            return com.google.common.base.x.c(this).p(this.f22629b).toString();
        }
    }

    @u1.a
    @s1.a
    @s1.b
    public static final class e<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f22630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d7<l1<? extends V>> f22631b;

        class a implements Callable<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f22632a;

            a(Runnable runnable) {
                this.f22632a = runnable;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                this.f22632a.run();
                return null;
            }
        }

        /* synthetic */ e(boolean z7, d7 d7Var, a aVar) {
            this(z7, d7Var);
        }

        @u1.a
        public <C> l1<C> a(Callable<C> callable, Executor executor) {
            return new l0(this.f22631b, this.f22630a, executor, callable);
        }

        public <C> l1<C> b(m<C> mVar, Executor executor) {
            return new l0(this.f22631b, this.f22630a, executor, mVar);
        }

        public l1<?> c(Runnable runnable, Executor executor) {
            return a(new a(runnable), executor);
        }

        private e(boolean z7, d7<l1<? extends V>> d7Var) {
            this.f22630a = z7;
            this.f22631b = d7Var;
        }
    }

    private static final class f<T> extends com.google.common.util.concurrent.d<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private g<T> f22634i;

        /* synthetic */ f(g gVar, a aVar) {
            this(gVar);
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        public boolean cancel(boolean z7) {
            g<T> gVar = this.f22634i;
            if (!super.cancel(z7)) {
                return false;
            }
            gVar.g(z7);
            return true;
        }

        @Override // com.google.common.util.concurrent.d
        protected void m() {
            this.f22634i = null;
        }

        @Override // com.google.common.util.concurrent.d
        protected String x() {
            g<T> gVar = this.f22634i;
            if (gVar == null) {
                return null;
            }
            return "inputCount=[" + ((g) gVar).f22638d.length + "], remaining=[" + ((g) gVar).f22637c.get() + "]";
        }

        private f(g<T> gVar) {
            this.f22634i = gVar;
        }
    }

    private static final class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f22635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f22636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicInteger f22637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final l1<? extends T>[] f22638d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile int f22639e;

        /* synthetic */ g(l1[] l1VarArr, a aVar) {
            this(l1VarArr);
        }

        private void e() {
            if (this.f22637c.decrementAndGet() == 0 && this.f22635a) {
                for (l1<? extends T> l1Var : this.f22638d) {
                    if (l1Var != null) {
                        l1Var.cancel(this.f22636b);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(d7<com.google.common.util.concurrent.d<T>> d7Var, int i7) {
            l1<? extends T>[] l1VarArr = this.f22638d;
            l1<? extends T> l1Var = l1VarArr[i7];
            l1VarArr[i7] = null;
            for (int i8 = this.f22639e; i8 < d7Var.size(); i8++) {
                if (d7Var.get(i8).C(l1Var)) {
                    e();
                    this.f22639e = i8 + 1;
                    return;
                }
            }
            this.f22639e = d7Var.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(boolean z7) {
            this.f22635a = true;
            if (!z7) {
                this.f22636b = false;
            }
            e();
        }

        private g(l1<? extends T>[] l1VarArr) {
            this.f22635a = false;
            this.f22636b = true;
            this.f22639e = 0;
            this.f22638d = l1VarArr;
            this.f22637c = new AtomicInteger(l1VarArr.length);
        }
    }

    @s1.c
    private static class h<V, X extends Exception> extends com.google.common.util.concurrent.b<V, X> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.google.common.base.s<? super Exception, X> f22640b;

        h(l1<V> l1Var, com.google.common.base.s<? super Exception, X> sVar) {
            super(l1Var);
            this.f22640b = (com.google.common.base.s) com.google.common.base.e0.E(sVar);
        }

        @Override // com.google.common.util.concurrent.b
        protected X f0(Exception exc) {
            return this.f22640b.apply(exc);
        }
    }

    private static final class i<V> extends com.google.common.util.concurrent.d.j<V> implements Runnable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private l1<V> f22641i;

        i(l1<V> l1Var) {
            this.f22641i = l1Var;
        }

        @Override // com.google.common.util.concurrent.d
        protected void m() {
            this.f22641i = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            l1<V> l1Var = this.f22641i;
            if (l1Var != null) {
                C(l1Var);
            }
        }

        @Override // com.google.common.util.concurrent.d
        protected String x() {
            l1<V> l1Var = this.f22641i;
            if (l1Var == null) {
                return null;
            }
            return "delegate=[" + l1Var + "]";
        }
    }

    private e1() {
    }

    public static <V> e<V> A(Iterable<? extends l1<? extends V>> iterable) {
        return new e<>(true, d7.p(iterable), null);
    }

    @SafeVarargs
    public static <V> e<V> B(l1<? extends V>... l1VarArr) {
        return new e<>(true, d7.u(l1VarArr), null);
    }

    @s1.c
    public static <V> l1<V> C(l1<V> l1Var, long j7, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return l1Var.isDone() ? l1Var : k2.R(l1Var, j7, timeUnit, scheduledExecutorService);
    }

    private static void D(Throwable th) {
        if (!(th instanceof Error)) {
            throw new n2(th);
        }
        throw new o0((Error) th);
    }

    public static <V> void a(l1<V> l1Var, d1<? super V> d1Var, Executor executor) {
        com.google.common.base.e0.E(d1Var);
        l1Var.I(new d(l1Var, d1Var), executor);
    }

    @s1.a
    public static <V> l1<List<V>> b(Iterable<? extends l1<? extends V>> iterable) {
        return new k0.b(d7.p(iterable), true);
    }

    @SafeVarargs
    @s1.a
    public static <V> l1<List<V>> c(l1<? extends V>... l1VarArr) {
        return new k0.b(d7.u(l1VarArr), true);
    }

    @w1.a("AVAILABLE but requires exceptionType to be Throwable.class")
    public static <V, X extends Throwable> l1<V> d(l1<? extends V> l1Var, Class<X> cls, com.google.common.base.s<? super X, ? extends V> sVar, Executor executor) {
        return com.google.common.util.concurrent.a.O(l1Var, cls, sVar, executor);
    }

    @w1.a("AVAILABLE but requires exceptionType to be Throwable.class")
    @u1.a
    public static <V, X extends Throwable> l1<V> e(l1<? extends V> l1Var, Class<X> cls, n<? super X, ? extends V> nVar, Executor executor) {
        return com.google.common.util.concurrent.a.P(l1Var, cls, nVar, executor);
    }

    @u1.a
    @s1.c
    public static <V, X extends Exception> V f(Future<V> future, Class<X> cls) throws Exception {
        return (V) f1.e(future, cls);
    }

    @u1.a
    @s1.c
    public static <V, X extends Exception> V g(Future<V> future, Class<X> cls, long j7, TimeUnit timeUnit) throws Exception {
        return (V) f1.f(future, cls, j7, timeUnit);
    }

    @u1.a
    public static <V> V h(Future<V> future) throws ExecutionException {
        com.google.common.base.e0.x0(future.isDone(), "Future was expected to be done: %s", future);
        return (V) p2.d(future);
    }

    @u1.a
    public static <V> V i(Future<V> future) {
        com.google.common.base.e0.E(future);
        try {
            return (V) p2.d(future);
        } catch (ExecutionException e8) {
            D(e8.getCause());
            throw new AssertionError();
        }
    }

    public static <V> l1<V> j() {
        return new i1.a();
    }

    @s1.c
    @Deprecated
    public static <V, X extends Exception> j0<V, X> k(V v7) {
        return new i1.d(v7);
    }

    @s1.c
    @Deprecated
    public static <V, X extends Exception> j0<V, X> l(X x7) {
        com.google.common.base.e0.E(x7);
        return new i1.b(x7);
    }

    public static <V> l1<V> m(Throwable th) {
        com.google.common.base.e0.E(th);
        return new i1.c(th);
    }

    public static <V> l1<V> n(V v7) {
        return v7 == null ? i1.e.f22773c : new i1.e(v7);
    }

    @s1.a
    public static <T> d7<l1<T>> o(Iterable<? extends l1<? extends T>> iterable) {
        Collection collectionP = iterable instanceof Collection ? (Collection) iterable : d7.p(iterable);
        l1[] l1VarArr = (l1[]) collectionP.toArray(new l1[collectionP.size()]);
        a aVar = null;
        g gVar = new g(l1VarArr, aVar);
        d7.b bVarM = d7.m();
        for (int i7 = 0; i7 < l1VarArr.length; i7++) {
            bVarM.a(new f(gVar, aVar));
        }
        d7<l1<T>> d7VarE = bVarM.e();
        for (int i8 = 0; i8 < l1VarArr.length; i8++) {
            l1VarArr[i8].I(new c(gVar, d7VarE, i8), v1.c());
        }
        return d7VarE;
    }

    @s1.c
    public static <I, O> Future<O> p(Future<I> future, com.google.common.base.s<? super I, ? extends O> sVar) {
        com.google.common.base.e0.E(future);
        com.google.common.base.e0.E(sVar);
        return new b(future, sVar);
    }

    @s1.c
    @Deprecated
    public static <V, X extends Exception> j0<V, X> q(l1<V> l1Var, com.google.common.base.s<? super Exception, X> sVar) {
        return new h((l1) com.google.common.base.e0.E(l1Var), sVar);
    }

    public static <V> l1<V> r(l1<V> l1Var) {
        if (l1Var.isDone()) {
            return l1Var;
        }
        i iVar = new i(l1Var);
        l1Var.I(iVar, v1.c());
        return iVar;
    }

    @s1.c
    public static <O> l1<O> s(m<O> mVar, long j7, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        l2 l2VarO = l2.O(mVar);
        l2VarO.I(new a(scheduledExecutorService.schedule(l2VarO, j7, timeUnit)), v1.c());
        return l2VarO;
    }

    public static <O> l1<O> t(m<O> mVar, Executor executor) {
        l2 l2VarO = l2.O(mVar);
        executor.execute(l2VarO);
        return l2VarO;
    }

    @s1.a
    public static <V> l1<List<V>> u(Iterable<? extends l1<? extends V>> iterable) {
        return new k0.b(d7.p(iterable), false);
    }

    @SafeVarargs
    @s1.a
    public static <V> l1<List<V>> v(l1<? extends V>... l1VarArr) {
        return new k0.b(d7.u(l1VarArr), false);
    }

    public static <I, O> l1<O> w(l1<I> l1Var, com.google.common.base.s<? super I, ? extends O> sVar, Executor executor) {
        return j.O(l1Var, sVar, executor);
    }

    public static <I, O> l1<O> x(l1<I> l1Var, n<? super I, ? extends O> nVar, Executor executor) {
        return j.P(l1Var, nVar, executor);
    }

    public static <V> e<V> y(Iterable<? extends l1<? extends V>> iterable) {
        return new e<>(false, d7.p(iterable), null);
    }

    @SafeVarargs
    public static <V> e<V> z(l1<? extends V>... l1VarArr) {
        return new e<>(false, d7.u(l1VarArr), null);
    }
}
