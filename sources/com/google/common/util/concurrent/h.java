package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public abstract class h implements b2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f22707b = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f22708a = new e(this, null);

    class a extends b2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScheduledExecutorService f22709a;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f22709a = scheduledExecutorService;
        }

        @Override // com.google.common.util.concurrent.b2.b
        public void a(b2.c cVar, Throwable th) {
            this.f22709a.shutdown();
        }

        @Override // com.google.common.util.concurrent.b2.b
        public void e(b2.c cVar) {
            this.f22709a.shutdown();
        }
    }

    class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return v1.n(h.this.o(), runnable);
        }
    }

    @s1.a
    public static abstract class c extends d {

        private class a extends z0<Void> implements Callable<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Runnable f22712a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ScheduledExecutorService f22713b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final i f22714c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final ReentrantLock f22715d = new ReentrantLock();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @v1.a("lock")
            private Future<Void> f22716e;

            a(i iVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.f22712a = runnable;
                this.f22713b = scheduledExecutorService;
                this.f22714c = iVar;
            }

            @Override // com.google.common.util.concurrent.z0, java.util.concurrent.Future
            public boolean cancel(boolean z7) {
                this.f22715d.lock();
                try {
                    return this.f22716e.cancel(z7);
                } finally {
                    this.f22715d.unlock();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.util.concurrent.z0, com.google.common.collect.b6
            /* JADX INFO: renamed from: d0 */
            public Future<? extends Void> c0() {
                throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                this.f22712a.run();
                f0();
                return null;
            }

            public void f0() {
                try {
                    b bVarD = c.this.d();
                    this.f22715d.lock();
                    try {
                        Future<Void> future = this.f22716e;
                        if (future == null || !future.isCancelled()) {
                            this.f22716e = this.f22713b.schedule(this, bVarD.f22718a, bVarD.f22719b);
                        }
                        this.f22715d.unlock();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                        this.f22715d.unlock();
                    }
                    if (th != null) {
                        this.f22714c.u(th);
                    }
                } catch (Throwable th2) {
                    this.f22714c.u(th2);
                }
            }

            @Override // com.google.common.util.concurrent.z0, java.util.concurrent.Future
            public boolean isCancelled() {
                this.f22715d.lock();
                try {
                    return this.f22716e.isCancelled();
                } finally {
                    this.f22715d.unlock();
                }
            }
        }

        @s1.a
        protected static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f22718a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final TimeUnit f22719b;

            public b(long j7, TimeUnit timeUnit) {
                this.f22718a = j7;
                this.f22719b = (TimeUnit) com.google.common.base.e0.E(timeUnit);
            }
        }

        public c() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.h.d
        final Future<?> c(i iVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            a aVar = new a(iVar, scheduledExecutorService, runnable);
            aVar.f0();
            return aVar;
        }

        protected abstract b d() throws Exception;
    }

    public static abstract class d {

        static class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f22720a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f22721b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ TimeUnit f22722c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j7, long j8, TimeUnit timeUnit) {
                super(null);
                this.f22720a = j7;
                this.f22721b = j8;
                this.f22722c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.h.d
            public Future<?> c(i iVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return scheduledExecutorService.scheduleWithFixedDelay(runnable, this.f22720a, this.f22721b, this.f22722c);
            }
        }

        static class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f22723a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f22724b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ TimeUnit f22725c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(long j7, long j8, TimeUnit timeUnit) {
                super(null);
                this.f22723a = j7;
                this.f22724b = j8;
                this.f22725c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.h.d
            public Future<?> c(i iVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return scheduledExecutorService.scheduleAtFixedRate(runnable, this.f22723a, this.f22724b, this.f22725c);
            }
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        public static d a(long j7, long j8, TimeUnit timeUnit) {
            com.google.common.base.e0.E(timeUnit);
            com.google.common.base.e0.p(j8 > 0, "delay must be > 0, found %s", j8);
            return new a(j7, j8, timeUnit);
        }

        public static d b(long j7, long j8, TimeUnit timeUnit) {
            com.google.common.base.e0.E(timeUnit);
            com.google.common.base.e0.p(j8 > 0, "period must be > 0, found %s", j8);
            return new b(j7, j8, timeUnit);
        }

        abstract Future<?> c(i iVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        private d() {
        }
    }

    protected h() {
    }

    @Override // com.google.common.util.concurrent.b2
    public final void a(b2.b bVar, Executor executor) {
        this.f22708a.a(bVar, executor);
    }

    @Override // com.google.common.util.concurrent.b2
    public final void b(long j7, TimeUnit timeUnit) throws TimeoutException {
        this.f22708a.b(j7, timeUnit);
    }

    @Override // com.google.common.util.concurrent.b2
    public final b2.c c() {
        return this.f22708a.c();
    }

    @Override // com.google.common.util.concurrent.b2
    public final void d() {
        this.f22708a.d();
    }

    @Override // com.google.common.util.concurrent.b2
    public final Throwable e() {
        return this.f22708a.e();
    }

    @Override // com.google.common.util.concurrent.b2
    public final void f(long j7, TimeUnit timeUnit) throws TimeoutException {
        this.f22708a.f(j7, timeUnit);
    }

    @Override // com.google.common.util.concurrent.b2
    @u1.a
    public final b2 g() {
        this.f22708a.g();
        return this;
    }

    @Override // com.google.common.util.concurrent.b2
    public final void h() {
        this.f22708a.h();
    }

    @Override // com.google.common.util.concurrent.b2
    @u1.a
    public final b2 i() {
        this.f22708a.i();
        return this;
    }

    @Override // com.google.common.util.concurrent.b2
    public final boolean isRunning() {
        return this.f22708a.isRunning();
    }

    protected ScheduledExecutorService l() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new b());
        a(new a(scheduledExecutorServiceNewSingleThreadScheduledExecutor), v1.c());
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    protected abstract void m() throws Exception;

    protected abstract d n();

    protected String o() {
        return getClass().getSimpleName();
    }

    protected void p() throws Exception {
    }

    protected void q() throws Exception {
    }

    public String toString() {
        return o() + " [" + c() + "]";
    }

    private final class e extends i {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private volatile Future<?> f22726p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private volatile ScheduledExecutorService f22727q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final ReentrantLock f22728r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Runnable f22729s;

        class a implements com.google.common.base.p0<String> {
            a() {
            }

            @Override // com.google.common.base.p0, java.util.function.Supplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get() {
                return h.this.o() + " " + e.this.c();
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f22728r.lock();
                try {
                    h.this.q();
                    e eVar = e.this;
                    eVar.f22726p = h.this.n().c(h.this.f22708a, e.this.f22727q, e.this.f22729s);
                    e.this.v();
                } catch (Throwable th) {
                    try {
                        e.this.u(th);
                        if (e.this.f22726p != null) {
                            e.this.f22726p.cancel(false);
                        }
                    } finally {
                        e.this.f22728r.unlock();
                    }
                }
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f22728r.lock();
                    try {
                        if (e.this.c() != b2.c.f22552d) {
                            e.this.f22728r.unlock();
                            return;
                        }
                        h.this.p();
                        e.this.f22728r.unlock();
                        e.this.w();
                    } catch (Throwable th) {
                        e.this.f22728r.unlock();
                        throw th;
                    }
                } catch (Throwable th2) {
                    e.this.u(th2);
                }
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f22728r.lock();
                try {
                    if (e.this.f22726p.isCancelled()) {
                        e.this.f22728r.unlock();
                        return;
                    }
                    h.this.m();
                } catch (Throwable th) {
                    try {
                        try {
                            h.this.p();
                        } catch (Exception e8) {
                            h.f22707b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e8);
                        }
                        e.this.u(th);
                        e.this.f22726p.cancel(false);
                    } finally {
                        e.this.f22728r.unlock();
                    }
                }
            }
        }

        private e() {
            this.f22728r = new ReentrantLock();
            this.f22729s = new d();
        }

        @Override // com.google.common.util.concurrent.i
        protected final void n() {
            this.f22727q = v1.s(h.this.l(), new a());
            this.f22727q.execute(new b());
        }

        @Override // com.google.common.util.concurrent.i
        protected final void o() {
            this.f22726p.cancel(false);
            this.f22727q.execute(new c());
        }

        @Override // com.google.common.util.concurrent.i
        public String toString() {
            return h.this.toString();
        }

        /* synthetic */ e(h hVar, a aVar) {
            this();
        }
    }
}
