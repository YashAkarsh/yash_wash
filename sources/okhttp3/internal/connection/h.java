package okhttp3.internal.connection;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f37830f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f37831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.internal.concurrent.c f37832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f37833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentLinkedQueue<f> f37834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f37835e;

    public static final class a {
        private a() {
        }

        @a7.d
        public final h a(@a7.d ConnectionPool connectionPool) {
            l0.p(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public static final class b extends okhttp3.internal.concurrent.a {
        b(String str) {
            super(str, false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            return h.this.b(System.nanoTime());
        }
    }

    public h(@a7.d okhttp3.internal.concurrent.d taskRunner, int i7, long j7, @a7.d TimeUnit timeUnit) {
        l0.p(taskRunner, "taskRunner");
        l0.p(timeUnit, "timeUnit");
        this.f37835e = i7;
        this.f37831a = timeUnit.toNanos(j7);
        this.f37832b = taskRunner.j();
        this.f37833c = new b(okhttp3.internal.d.f37862i + " ConnectionPool");
        this.f37834d = new ConcurrentLinkedQueue<>();
        if (j7 > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j7).toString());
    }

    private final int g(f fVar, long j7) {
        if (okhttp3.internal.d.f37861h && !Thread.holdsLock(fVar)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(fVar);
            throw new AssertionError(sb.toString());
        }
        List<Reference<e>> listQ = fVar.q();
        int i7 = 0;
        while (i7 < listQ.size()) {
            Reference<e> reference = listQ.get(i7);
            if (reference.get() != null) {
                i7++;
            } else {
                okhttp3.internal.platform.k.f38284e.g().o("A connection to " + fVar.route().address().url() + " was leaked. Did you forget to close a response body?", ((e.b) reference).a());
                listQ.remove(i7);
                fVar.F(true);
                if (listQ.isEmpty()) {
                    fVar.E(j7 - this.f37831a);
                    return 0;
                }
            }
        }
        return listQ.size();
    }

    public final boolean a(@a7.d Address address, @a7.d e call, @a7.e List<Route> list, boolean z7) {
        l0.p(address, "address");
        l0.p(call, "call");
        for (f connection : this.f37834d) {
            l0.o(connection, "connection");
            synchronized (connection) {
                if (z7) {
                    if (!connection.y()) {
                    }
                    l2 l2Var = l2.f34958a;
                }
                if (connection.w(address, list)) {
                    call.c(connection);
                    return true;
                }
                l2 l2Var2 = l2.f34958a;
            }
        }
        return false;
    }

    public final long b(long j7) {
        int i7 = 0;
        long j8 = Long.MIN_VALUE;
        f fVar = null;
        int i8 = 0;
        for (f connection : this.f37834d) {
            l0.o(connection, "connection");
            synchronized (connection) {
                if (g(connection, j7) > 0) {
                    i8++;
                } else {
                    i7++;
                    long jS = j7 - connection.s();
                    if (jS > j8) {
                        l2 l2Var = l2.f34958a;
                        fVar = connection;
                        j8 = jS;
                    } else {
                        l2 l2Var2 = l2.f34958a;
                    }
                }
            }
        }
        long j9 = this.f37831a;
        if (j8 < j9 && i7 <= this.f37835e) {
            if (i7 > 0) {
                return j9 - j8;
            }
            if (i8 > 0) {
                return j9;
            }
            return -1L;
        }
        l0.m(fVar);
        synchronized (fVar) {
            if (!fVar.q().isEmpty()) {
                return 0L;
            }
            if (fVar.s() + j8 != j7) {
                return 0L;
            }
            fVar.F(true);
            this.f37834d.remove(fVar);
            okhttp3.internal.d.n(fVar.socket());
            if (this.f37834d.isEmpty()) {
                this.f37832b.a();
            }
            return 0L;
        }
    }

    public final boolean c(@a7.d f connection) {
        l0.p(connection, "connection");
        if (okhttp3.internal.d.f37861h && !Thread.holdsLock(connection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(connection);
            throw new AssertionError(sb.toString());
        }
        if (!connection.t() && this.f37835e != 0) {
            okhttp3.internal.concurrent.c.p(this.f37832b, this.f37833c, 0L, 2, null);
            return false;
        }
        connection.F(true);
        this.f37834d.remove(connection);
        if (this.f37834d.isEmpty()) {
            this.f37832b.a();
        }
        return true;
    }

    public final int d() {
        return this.f37834d.size();
    }

    public final void e() {
        Socket socket;
        Iterator<f> it = this.f37834d.iterator();
        l0.o(it, "connections.iterator()");
        while (it.hasNext()) {
            f connection = it.next();
            l0.o(connection, "connection");
            synchronized (connection) {
                if (connection.q().isEmpty()) {
                    it.remove();
                    connection.F(true);
                    socket = connection.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                okhttp3.internal.d.n(socket);
            }
        }
        if (this.f37834d.isEmpty()) {
            this.f37832b.a();
        }
    }

    public final int f() {
        boolean zIsEmpty;
        ConcurrentLinkedQueue<f> concurrentLinkedQueue = this.f37834d;
        int i7 = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            for (f it : concurrentLinkedQueue) {
                l0.o(it, "it");
                synchronized (it) {
                    zIsEmpty = it.q().isEmpty();
                }
                if (zIsEmpty && (i7 = i7 + 1) < 0) {
                    y.W();
                }
            }
        }
        return i7;
    }

    public final void h(@a7.d f connection) {
        l0.p(connection, "connection");
        if (!okhttp3.internal.d.f37861h || Thread.holdsLock(connection)) {
            this.f37834d.add(connection);
            okhttp3.internal.concurrent.c.p(this.f37832b, this.f37833c, 0L, 2, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        l0.o(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(connection);
        throw new AssertionError(sb.toString());
    }
}
