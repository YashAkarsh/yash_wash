package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public abstract class c implements b2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f22556b = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b2 f22557a = new a();

    class a extends i {

        /* JADX INFO: renamed from: com.google.common.util.concurrent.c$a$a, reason: collision with other inner class name */
        class C0293a implements com.google.common.base.p0<String> {
            C0293a() {
            }

            @Override // com.google.common.base.p0, java.util.function.Supplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.m();
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.o();
                    a.this.v();
                    if (a.this.isRunning()) {
                        try {
                            c.this.l();
                        } catch (Throwable th) {
                            try {
                                c.this.n();
                            } catch (Exception e8) {
                                c.f22556b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e8);
                            }
                            a.this.u(th);
                            return;
                        }
                    }
                    c.this.n();
                    a.this.w();
                } catch (Throwable th2) {
                    a.this.u(th2);
                }
            }
        }

        a() {
        }

        @Override // com.google.common.util.concurrent.i
        protected final void n() {
            v1.q(c.this.k(), new C0293a()).execute(new b());
        }

        @Override // com.google.common.util.concurrent.i
        protected void o() {
            c.this.p();
        }

        @Override // com.google.common.util.concurrent.i
        public String toString() {
            return c.this.toString();
        }
    }

    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            v1.n(c.this.m(), runnable).start();
        }
    }

    protected c() {
    }

    @Override // com.google.common.util.concurrent.b2
    public final void a(b2.b bVar, Executor executor) {
        this.f22557a.a(bVar, executor);
    }

    @Override // com.google.common.util.concurrent.b2
    public final void b(long j7, TimeUnit timeUnit) throws TimeoutException {
        this.f22557a.b(j7, timeUnit);
    }

    @Override // com.google.common.util.concurrent.b2
    public final b2.c c() {
        return this.f22557a.c();
    }

    @Override // com.google.common.util.concurrent.b2
    public final void d() {
        this.f22557a.d();
    }

    @Override // com.google.common.util.concurrent.b2
    public final Throwable e() {
        return this.f22557a.e();
    }

    @Override // com.google.common.util.concurrent.b2
    public final void f(long j7, TimeUnit timeUnit) throws TimeoutException {
        this.f22557a.f(j7, timeUnit);
    }

    @Override // com.google.common.util.concurrent.b2
    @u1.a
    public final b2 g() {
        this.f22557a.g();
        return this;
    }

    @Override // com.google.common.util.concurrent.b2
    public final void h() {
        this.f22557a.h();
    }

    @Override // com.google.common.util.concurrent.b2
    @u1.a
    public final b2 i() {
        this.f22557a.i();
        return this;
    }

    @Override // com.google.common.util.concurrent.b2
    public final boolean isRunning() {
        return this.f22557a.isRunning();
    }

    protected Executor k() {
        return new b();
    }

    protected abstract void l() throws Exception;

    protected String m() {
        return getClass().getSimpleName();
    }

    protected void n() throws Exception {
    }

    protected void o() throws Exception {
    }

    protected void p() {
    }

    public String toString() {
        return m() + " [" + c() + "]";
    }
}
