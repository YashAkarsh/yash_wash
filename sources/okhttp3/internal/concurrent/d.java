package okhttp3.internal.concurrent;

import com.haier.library.sumhttp.plugin.h;
import h5.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.g0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    private static final Logger f37735i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f37738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f37739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<okhttp3.internal.concurrent.c> f37740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<okhttp3.internal.concurrent.c> f37741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runnable f37742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final a f37743g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f37736j = new b(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    @e
    public static final d f37734h = new d(new c(okhttp3.internal.d.U(okhttp3.internal.d.f37862i + " TaskRunner", true)));

    public interface a {
        long a();

        void b(@a7.d d dVar);

        void c(@a7.d d dVar, long j7);

        void d(@a7.d d dVar);

        void execute(@a7.d Runnable runnable);
    }

    public static final class b {
        private b() {
        }

        @a7.d
        public final Logger a() {
            return d.f37735i;
        }

        public /* synthetic */ b(w wVar) {
            this();
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f37744a;

        public c(@a7.d ThreadFactory threadFactory) {
            l0.p(threadFactory, "threadFactory");
            this.f37744a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // okhttp3.internal.concurrent.d.a
        public long a() {
            return System.nanoTime();
        }

        @Override // okhttp3.internal.concurrent.d.a
        public void b(@a7.d d taskRunner) {
            l0.p(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // okhttp3.internal.concurrent.d.a
        public void c(@a7.d d taskRunner, long j7) throws InterruptedException {
            l0.p(taskRunner, "taskRunner");
            long j8 = j7 / 1000000;
            long j9 = j7 - (1000000 * j8);
            if (j8 > 0 || j7 > 0) {
                taskRunner.wait(j8, (int) j9);
            }
        }

        @Override // okhttp3.internal.concurrent.d.a
        public void d(@a7.d d taskRunner) {
            l0.p(taskRunner, "taskRunner");
        }

        public final void e() {
            this.f37744a.shutdown();
        }

        @Override // okhttp3.internal.concurrent.d.a
        public void execute(@a7.d Runnable runnable) {
            l0.p(runnable, "runnable");
            this.f37744a.execute(runnable);
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.d$d, reason: collision with other inner class name */
    public static final class RunnableC0504d implements Runnable {
        RunnableC0504d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            okhttp3.internal.concurrent.a aVarE;
            long jA;
            while (true) {
                synchronized (d.this) {
                    aVarE = d.this.e();
                }
                if (aVarE == null) {
                    return;
                }
                okhttp3.internal.concurrent.c cVarD = aVarE.d();
                l0.m(cVarD);
                boolean zIsLoggable = d.f37736j.a().isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jA = cVarD.k().h().a();
                    okhttp3.internal.concurrent.b.c(aVarE, cVarD, "starting");
                } else {
                    jA = -1;
                }
                try {
                    d.this.k(aVarE);
                    try {
                        l2 l2Var = l2.f34958a;
                        if (zIsLoggable) {
                            okhttp3.internal.concurrent.b.c(aVarE, cVarD, "finished run in " + okhttp3.internal.concurrent.b.b(cVarD.k().h().a() - jA));
                        }
                    } catch (Throwable th) {
                        if (zIsLoggable) {
                            okhttp3.internal.concurrent.b.c(aVarE, cVarD, "failed a run in " + okhttp3.internal.concurrent.b.b(cVarD.k().h().a() - jA));
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    d.this.h().execute(this);
                    throw th2;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(d.class.getName());
        l0.o(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f37735i = logger;
    }

    public d(@a7.d a backend) {
        l0.p(backend, "backend");
        this.f37743g = backend;
        this.f37737a = h.f27948e;
        this.f37740d = new ArrayList();
        this.f37741e = new ArrayList();
        this.f37742f = new RunnableC0504d();
    }

    private final void d(okhttp3.internal.concurrent.a aVar, long j7) {
        if (okhttp3.internal.d.f37861h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        okhttp3.internal.concurrent.c cVarD = aVar.d();
        l0.m(cVarD);
        if (!(cVarD.e() == aVar)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean zF = cVarD.f();
        cVarD.s(false);
        cVarD.r(null);
        this.f37740d.remove(cVarD);
        if (j7 != -1 && !zF && !cVarD.j()) {
            cVarD.q(aVar, j7, true);
        }
        if (!cVarD.g().isEmpty()) {
            this.f37741e.add(cVarD);
        }
    }

    private final void f(okhttp3.internal.concurrent.a aVar) {
        if (!okhttp3.internal.d.f37861h || Thread.holdsLock(this)) {
            aVar.g(-1L);
            okhttp3.internal.concurrent.c cVarD = aVar.d();
            l0.m(cVarD);
            cVarD.g().remove(aVar);
            this.f37741e.remove(cVarD);
            cVarD.r(aVar);
            this.f37740d.add(cVarD);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        l0.o(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(okhttp3.internal.concurrent.a aVar) {
        if (okhttp3.internal.d.f37861h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        Thread currentThread = Thread.currentThread();
        l0.o(currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(aVar.b());
        try {
            long jF = aVar.f();
            synchronized (this) {
                d(aVar, jF);
                l2 l2Var = l2.f34958a;
            }
        } finally {
            synchronized (this) {
                d(aVar, -1L);
                l2 l2Var2 = l2.f34958a;
                currentThread.setName(name);
            }
        }
    }

    @a7.d
    public final List<okhttp3.internal.concurrent.c> c() {
        List<okhttp3.internal.concurrent.c> listY4;
        synchronized (this) {
            listY4 = g0.y4(this.f37740d, this.f37741e);
        }
        return listY4;
    }

    @a7.e
    public final okhttp3.internal.concurrent.a e() {
        boolean z7;
        if (okhttp3.internal.d.f37861h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        while (!this.f37741e.isEmpty()) {
            long jA = this.f37743g.a();
            Iterator<okhttp3.internal.concurrent.c> it = this.f37741e.iterator();
            long jMin = Long.MAX_VALUE;
            okhttp3.internal.concurrent.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z7 = false;
                    break;
                }
                okhttp3.internal.concurrent.a aVar2 = it.next().g().get(0);
                long jMax = Math.max(0L, aVar2.c() - jA);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z7 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                f(aVar);
                if (z7 || (!this.f37738b && (!this.f37741e.isEmpty()))) {
                    this.f37743g.execute(this.f37742f);
                }
                return aVar;
            }
            if (this.f37738b) {
                if (jMin < this.f37739c - jA) {
                    this.f37743g.b(this);
                }
                return null;
            }
            this.f37738b = true;
            this.f37739c = jA + jMin;
            try {
                try {
                    this.f37743g.c(this, jMin);
                } catch (InterruptedException unused) {
                    g();
                }
                this.f37738b = false;
            } catch (Throwable th) {
                this.f37738b = false;
                throw th;
            }
        }
        return null;
    }

    public final void g() {
        for (int size = this.f37740d.size() - 1; size >= 0; size--) {
            this.f37740d.get(size).b();
        }
        for (int size2 = this.f37741e.size() - 1; size2 >= 0; size2--) {
            okhttp3.internal.concurrent.c cVar = this.f37741e.get(size2);
            cVar.b();
            if (cVar.g().isEmpty()) {
                this.f37741e.remove(size2);
            }
        }
    }

    @a7.d
    public final a h() {
        return this.f37743g;
    }

    public final void i(@a7.d okhttp3.internal.concurrent.c taskQueue) {
        l0.p(taskQueue, "taskQueue");
        if (okhttp3.internal.d.f37861h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (taskQueue.e() == null) {
            if (!taskQueue.g().isEmpty()) {
                okhttp3.internal.d.a(this.f37741e, taskQueue);
            } else {
                this.f37741e.remove(taskQueue);
            }
        }
        if (this.f37738b) {
            this.f37743g.b(this);
        } else {
            this.f37743g.execute(this.f37742f);
        }
    }

    @a7.d
    public final okhttp3.internal.concurrent.c j() {
        int i7;
        synchronized (this) {
            i7 = this.f37737a;
            this.f37737a = i7 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i7);
        return new okhttp3.internal.concurrent.c(this, sb.toString());
    }
}
