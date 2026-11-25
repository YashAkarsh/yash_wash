package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public abstract class f implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.common.base.p0<String> f22651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b2 f22652b;

    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            v1.n((String) f.this.f22651a.get(), runnable).start();
        }
    }

    private final class b extends i {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    f.this.n();
                    b.this.v();
                } catch (Throwable th) {
                    b.this.u(th);
                }
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.f$b$b, reason: collision with other inner class name */
        class RunnableC0296b implements Runnable {
            RunnableC0296b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    f.this.m();
                    b.this.w();
                } catch (Throwable th) {
                    b.this.u(th);
                }
            }
        }

        private b() {
        }

        @Override // com.google.common.util.concurrent.i
        protected final void n() {
            v1.q(f.this.k(), f.this.f22651a).execute(new a());
        }

        @Override // com.google.common.util.concurrent.i
        protected final void o() {
            v1.q(f.this.k(), f.this.f22651a).execute(new RunnableC0296b());
        }

        @Override // com.google.common.util.concurrent.i
        public String toString() {
            return f.this.toString();
        }

        /* synthetic */ b(f fVar, a aVar) {
            this();
        }
    }

    private final class c implements com.google.common.base.p0<String> {
        private c() {
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get() {
            return f.this.l() + " " + f.this.c();
        }

        /* synthetic */ c(f fVar, a aVar) {
            this();
        }
    }

    protected f() {
        a aVar = null;
        this.f22651a = new c(this, aVar);
        this.f22652b = new b(this, aVar);
    }

    @Override // com.google.common.util.concurrent.b2
    public final void a(b2.b bVar, Executor executor) {
        this.f22652b.a(bVar, executor);
    }

    @Override // com.google.common.util.concurrent.b2
    public final void b(long j7, TimeUnit timeUnit) throws TimeoutException {
        this.f22652b.b(j7, timeUnit);
    }

    @Override // com.google.common.util.concurrent.b2
    public final b2.c c() {
        return this.f22652b.c();
    }

    @Override // com.google.common.util.concurrent.b2
    public final void d() {
        this.f22652b.d();
    }

    @Override // com.google.common.util.concurrent.b2
    public final Throwable e() {
        return this.f22652b.e();
    }

    @Override // com.google.common.util.concurrent.b2
    public final void f(long j7, TimeUnit timeUnit) throws TimeoutException {
        this.f22652b.f(j7, timeUnit);
    }

    @Override // com.google.common.util.concurrent.b2
    @u1.a
    public final b2 g() {
        this.f22652b.g();
        return this;
    }

    @Override // com.google.common.util.concurrent.b2
    public final void h() {
        this.f22652b.h();
    }

    @Override // com.google.common.util.concurrent.b2
    @u1.a
    public final b2 i() {
        this.f22652b.i();
        return this;
    }

    @Override // com.google.common.util.concurrent.b2
    public final boolean isRunning() {
        return this.f22652b.isRunning();
    }

    protected Executor k() {
        return new a();
    }

    protected String l() {
        return getClass().getSimpleName();
    }

    protected abstract void m() throws Exception;

    protected abstract void n() throws Exception;

    public String toString() {
        return l() + " [" + c() + "]";
    }
}
