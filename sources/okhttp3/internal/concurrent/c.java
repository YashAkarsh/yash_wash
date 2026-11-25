package okhttp3.internal.concurrent;

import a7.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.collections.g0;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f37722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @e
    private okhttp3.internal.concurrent.a f37723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final List<okhttp3.internal.concurrent.a> f37724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final d f37726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final String f37727f;

    private static final class a extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.d
        private final CountDownLatch f37728e;

        public a() {
            super(okhttp3.internal.d.f37862i + " awaitIdle", false);
            this.f37728e = new CountDownLatch(1);
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            this.f37728e.countDown();
            return -1L;
        }

        @a7.d
        public final CountDownLatch i() {
            return this.f37728e;
        }
    }

    public static final class b extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ i5.a f37729e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f37730f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f37731g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i5.a aVar, String str, boolean z7, String str2, boolean z8) {
            super(str2, z8);
            this.f37729e = aVar;
            this.f37730f = str;
            this.f37731g = z7;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            this.f37729e.invoke();
            return -1L;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.c$c, reason: collision with other inner class name */
    public static final class C0503c extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ i5.a f37732e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f37733f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0503c(i5.a aVar, String str, String str2) {
            super(str2, false, 2, null);
            this.f37732e = aVar;
            this.f37733f = str;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            return ((Number) this.f37732e.invoke()).longValue();
        }
    }

    public c(@a7.d d taskRunner, @a7.d String name) {
        l0.p(taskRunner, "taskRunner");
        l0.p(name, "name");
        this.f37726e = taskRunner;
        this.f37727f = name;
        this.f37724c = new ArrayList();
    }

    public static /* synthetic */ void d(c cVar, String name, long j7, boolean z7, i5.a block, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            j7 = 0;
        }
        if ((i7 & 4) != 0) {
            z7 = true;
        }
        boolean z8 = z7;
        l0.p(name, "name");
        l0.p(block, "block");
        cVar.n(new b(block, name, z8, name, z8), j7);
    }

    public static /* synthetic */ void o(c cVar, String name, long j7, i5.a block, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            j7 = 0;
        }
        l0.p(name, "name");
        l0.p(block, "block");
        cVar.n(new C0503c(block, name, name), j7);
    }

    public static /* synthetic */ void p(c cVar, okhttp3.internal.concurrent.a aVar, long j7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            j7 = 0;
        }
        cVar.n(aVar, j7);
    }

    public final void a() {
        if (!okhttp3.internal.d.f37861h || !Thread.holdsLock(this)) {
            synchronized (this.f37726e) {
                if (b()) {
                    this.f37726e.i(this);
                }
                l2 l2Var = l2.f34958a;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        l0.o(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    public final boolean b() {
        okhttp3.internal.concurrent.a aVar = this.f37723b;
        if (aVar != null) {
            l0.m(aVar);
            if (aVar.a()) {
                this.f37725d = true;
            }
        }
        boolean z7 = false;
        for (int size = this.f37724c.size() - 1; size >= 0; size--) {
            if (this.f37724c.get(size).a()) {
                okhttp3.internal.concurrent.a aVar2 = this.f37724c.get(size);
                if (d.f37736j.a().isLoggable(Level.FINE)) {
                    okhttp3.internal.concurrent.b.c(aVar2, this, "canceled");
                }
                this.f37724c.remove(size);
                z7 = true;
            }
        }
        return z7;
    }

    public final void c(@a7.d String name, long j7, boolean z7, @a7.d i5.a<l2> block) {
        l0.p(name, "name");
        l0.p(block, "block");
        n(new b(block, name, z7, name, z7), j7);
    }

    @e
    public final okhttp3.internal.concurrent.a e() {
        return this.f37723b;
    }

    public final boolean f() {
        return this.f37725d;
    }

    @a7.d
    public final List<okhttp3.internal.concurrent.a> g() {
        return this.f37724c;
    }

    @a7.d
    public final String h() {
        return this.f37727f;
    }

    @a7.d
    public final List<okhttp3.internal.concurrent.a> i() {
        List<okhttp3.internal.concurrent.a> listQ5;
        synchronized (this.f37726e) {
            listQ5 = g0.Q5(this.f37724c);
        }
        return listQ5;
    }

    public final boolean j() {
        return this.f37722a;
    }

    @a7.d
    public final d k() {
        return this.f37726e;
    }

    @a7.d
    public final CountDownLatch l() {
        synchronized (this.f37726e) {
            if (this.f37723b == null && this.f37724c.isEmpty()) {
                return new CountDownLatch(0);
            }
            okhttp3.internal.concurrent.a aVar = this.f37723b;
            if (aVar instanceof a) {
                return ((a) aVar).i();
            }
            for (okhttp3.internal.concurrent.a aVar2 : this.f37724c) {
                if (aVar2 instanceof a) {
                    return ((a) aVar2).i();
                }
            }
            a aVar3 = new a();
            if (q(aVar3, 0L, false)) {
                this.f37726e.i(this);
            }
            return aVar3.i();
        }
    }

    public final void m(@a7.d String name, long j7, @a7.d i5.a<Long> block) {
        l0.p(name, "name");
        l0.p(block, "block");
        n(new C0503c(block, name, name), j7);
    }

    public final void n(@a7.d okhttp3.internal.concurrent.a task, long j7) {
        l0.p(task, "task");
        synchronized (this.f37726e) {
            if (!this.f37722a) {
                if (q(task, j7, false)) {
                    this.f37726e.i(this);
                }
                l2 l2Var = l2.f34958a;
            } else if (task.a()) {
                if (d.f37736j.a().isLoggable(Level.FINE)) {
                    okhttp3.internal.concurrent.b.c(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (d.f37736j.a().isLoggable(Level.FINE)) {
                    okhttp3.internal.concurrent.b.c(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean q(@a7.d okhttp3.internal.concurrent.a task, long j7, boolean z7) {
        String str;
        l0.p(task, "task");
        task.e(this);
        long jA = this.f37726e.h().a();
        long j8 = jA + j7;
        int iIndexOf = this.f37724c.indexOf(task);
        if (iIndexOf != -1) {
            if (task.c() <= j8) {
                if (d.f37736j.a().isLoggable(Level.FINE)) {
                    okhttp3.internal.concurrent.b.c(task, this, "already scheduled");
                }
                return false;
            }
            this.f37724c.remove(iIndexOf);
        }
        task.g(j8);
        if (d.f37736j.a().isLoggable(Level.FINE)) {
            if (z7) {
                str = "run again after " + okhttp3.internal.concurrent.b.b(j8 - jA);
            } else {
                str = "scheduled after " + okhttp3.internal.concurrent.b.b(j8 - jA);
            }
            okhttp3.internal.concurrent.b.c(task, this, str);
        }
        Iterator<okhttp3.internal.concurrent.a> it = this.f37724c.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().c() - jA > j7) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.f37724c.size();
        }
        this.f37724c.add(size, task);
        return size == 0;
    }

    public final void r(@e okhttp3.internal.concurrent.a aVar) {
        this.f37723b = aVar;
    }

    public final void s(boolean z7) {
        this.f37725d = z7;
    }

    public final void t(boolean z7) {
        this.f37722a = z7;
    }

    @a7.d
    public String toString() {
        return this.f37727f;
    }

    public final void u() {
        if (!okhttp3.internal.d.f37861h || !Thread.holdsLock(this)) {
            synchronized (this.f37726e) {
                this.f37722a = true;
                if (b()) {
                    this.f37726e.i(this);
                }
                l2 l2Var = l2.f34958a;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        l0.o(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }
}
