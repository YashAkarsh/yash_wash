package com.haier.library.okhttp.b.m;

import com.haier.library.a.h;
import com.haier.library.a.i;
import com.haier.library.a.j;
import com.haier.library.a.t;
import com.haier.library.okhttp.d0;
import com.haier.library.okhttp.k;
import com.haier.library.okhttp.l;
import com.haier.library.okhttp.l0;
import com.haier.library.okhttp.n;
import com.haier.library.okhttp.q;
import com.haier.library.okhttp.r;
import com.haier.uhome.account.api.Const;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements k, com.haier.library.okhttp.b.m.c.a {
    static final /* synthetic */ boolean A = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final List<com.haier.library.okhttp.d> f27405x = Collections.singletonList(com.haier.library.okhttp.d.HTTP_1_1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final long f27406y = 16777216;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final long f27407z = 60000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.haier.library.okhttp.f f27408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final l f27409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Random f27410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f27411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f27412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private q f27413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f27414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.haier.library.okhttp.b.m.c f27415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.haier.library.okhttp.b.m.d f27416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ScheduledExecutorService f27417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private g f27418k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f27421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f27422o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ScheduledFuture<?> f27423p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f27425r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f27426s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f27427t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f27428u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f27429v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f27430w;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ArrayDeque<j> f27419l = new ArrayDeque<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ArrayDeque<Object> f27420m = new ArrayDeque<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f27424q = -1;

    /* JADX INFO: renamed from: com.haier.library.okhttp.b.m.a$a, reason: collision with other inner class name */
    class RunnableC0361a implements Runnable {
        RunnableC0361a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            do {
                try {
                } catch (IOException e8) {
                    a.this.j(e8, null);
                    return;
                }
            } while (a.this.u());
        }
    }

    class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.haier.library.okhttp.f f27432a;

        b(com.haier.library.okhttp.f fVar) {
            this.f27432a = fVar;
        }

        @Override // com.haier.library.okhttp.r
        public void a(q qVar, IOException iOException) {
            a.this.j(iOException, null);
        }

        @Override // com.haier.library.okhttp.r
        public void b(q qVar, com.haier.library.okhttp.a aVar) {
            try {
                a.this.h(aVar);
                com.haier.library.okhttp.b.d.g gVarD = n.b.f27684a.d(qVar);
                gVarD.n();
                g gVarF = gVarD.l().f(gVarD);
                try {
                    a aVar2 = a.this;
                    aVar2.f27409b.c(aVar2, aVar);
                    a.this.k("OkHttp WebSocket " + this.f27432a.a().R(), gVarF);
                    gVarD.l().b().setSoTimeout(0);
                    a.this.n();
                } catch (Exception e8) {
                    a.this.j(e8, null);
                }
            } catch (ProtocolException e9) {
                a.this.j(e9, aVar);
                n.d.s(aVar);
            }
        }
    }

    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c();
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f27435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j f27436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f27437c;

        d(int i7, j jVar, long j7) {
            this.f27435a = i7;
            this.f27436b = jVar;
            this.f27437c = j7;
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f27438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j f27439b;

        e(int i7, j jVar) {
            this.f27438a = i7;
            this.f27439b = jVar;
        }
    }

    private final class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.v();
        }
    }

    public static abstract class g implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f27441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f27442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h f27443c;

        public g(boolean z7, i iVar, h hVar) {
            this.f27441a = z7;
            this.f27442b = iVar;
            this.f27443c = hVar;
        }
    }

    public a(com.haier.library.okhttp.f fVar, l lVar, Random random, long j7) {
        if (!Const.HTTP_REQUEST_TYPE_GET.equals(fVar.d())) {
            throw new IllegalArgumentException("Request must be GET: " + fVar.d());
        }
        this.f27408a = fVar;
        this.f27409b = lVar;
        this.f27410c = random;
        this.f27411d = j7;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f27412e = j.m(bArr).C();
        this.f27414g = new RunnableC0361a();
    }

    private synchronized boolean m(j jVar, int i7) {
        if (!this.f27426s && !this.f27422o) {
            if (this.f27421n + ((long) jVar.Z()) > f27406y) {
                c(1001, null);
                return false;
            }
            this.f27421n += (long) jVar.Z();
            this.f27420m.add(new e(i7, jVar));
            w();
            return true;
        }
        return false;
    }

    private void w() {
        if (!A && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ScheduledExecutorService scheduledExecutorService = this.f27417j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.f27414g);
        }
    }

    @Override // com.haier.library.okhttp.k
    public com.haier.library.okhttp.f a() {
        return this.f27408a;
    }

    @Override // com.haier.library.okhttp.k
    public synchronized long b() {
        return this.f27421n;
    }

    @Override // com.haier.library.okhttp.k
    public void c() {
        this.f27413f.c();
    }

    @Override // com.haier.library.okhttp.b.m.c.a
    public void d(j jVar) throws IOException {
        this.f27409b.b(this, jVar);
    }

    @Override // com.haier.library.okhttp.b.m.c.a
    public synchronized void e(j jVar) {
        this.f27429v++;
        this.f27430w = false;
    }

    @Override // com.haier.library.okhttp.k
    public boolean f(j jVar) {
        if (jVar != null) {
            return m(jVar, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    void g(int i7, TimeUnit timeUnit) throws InterruptedException {
        this.f27417j.awaitTermination(i7, timeUnit);
    }

    void h(com.haier.library.okhttp.a aVar) throws ProtocolException {
        if (aVar.u() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + aVar.u() + " " + aVar.g0() + "'");
        }
        String strE = aVar.E(com.google.common.net.c.f22160o);
        if (!com.google.common.net.c.L.equalsIgnoreCase(strE)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strE + "'");
        }
        String strE2 = aVar.E(com.google.common.net.c.L);
        if (!"websocket".equalsIgnoreCase(strE2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strE2 + "'");
        }
        String strE3 = aVar.E("Sec-WebSocket-Accept");
        String strC = j.i(this.f27412e + okhttp3.internal.ws.g.f38368a).K().C();
        if (strC.equals(strE3)) {
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strC + "' but was '" + strE3 + "'");
    }

    public void i(l0 l0Var) {
        l0 l0VarG = l0Var.h().j(d0.f27521a).o(f27405x).G();
        com.haier.library.okhttp.f fVarS = this.f27408a.i().j(com.google.common.net.c.L, "websocket").j(com.google.common.net.c.f22160o, com.google.common.net.c.L).j("Sec-WebSocket-Key", this.f27412e).j("Sec-WebSocket-Version", "13").s();
        q qVarE = n.b.f27684a.e(l0VarG, fVarS);
        this.f27413f = qVarE;
        qVarE.f().f();
        this.f27413f.p0(new b(fVarS));
    }

    public void j(Exception exc, @Nullable com.haier.library.okhttp.a aVar) {
        synchronized (this) {
            if (this.f27426s) {
                return;
            }
            this.f27426s = true;
            g gVar = this.f27418k;
            this.f27418k = null;
            ScheduledFuture<?> scheduledFuture = this.f27423p;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.f27417j;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                this.f27409b.e(this, exc, aVar);
            } finally {
                n.d.s(gVar);
            }
        }
    }

    public void k(String str, g gVar) throws IOException {
        synchronized (this) {
            this.f27418k = gVar;
            this.f27416i = new com.haier.library.okhttp.b.m.d(gVar.f27441a, gVar.f27443c, this.f27410c);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, n.d.p(str, false));
            this.f27417j = scheduledThreadPoolExecutor;
            if (this.f27411d != 0) {
                f fVar = new f();
                long j7 = this.f27411d;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(fVar, j7, j7, TimeUnit.MILLISECONDS);
            }
            if (!this.f27420m.isEmpty()) {
                w();
            }
        }
        this.f27415h = new com.haier.library.okhttp.b.m.c(gVar.f27441a, gVar.f27442b, this);
    }

    synchronized boolean l(int i7, String str, long j7) {
        j jVarI;
        com.haier.library.okhttp.b.m.b.d(i7);
        if (str != null) {
            jVarI = j.i(str);
            if (jVarI.Z() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        } else {
            jVarI = null;
        }
        if (!this.f27426s && !this.f27422o) {
            this.f27422o = true;
            this.f27420m.add(new d(i7, jVarI, j7));
            w();
            return true;
        }
        return false;
    }

    public void n() throws IOException {
        while (this.f27424q == -1) {
            this.f27415h.a();
        }
    }

    boolean o() throws IOException {
        try {
            this.f27415h.a();
            return this.f27424q == -1;
        } catch (Exception e8) {
            j(e8, null);
            return false;
        }
    }

    synchronized boolean p(j jVar) {
        if (!this.f27426s && (!this.f27422o || !this.f27420m.isEmpty())) {
            this.f27419l.add(jVar);
            w();
            return true;
        }
        return false;
    }

    void q() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.f27423p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f27417j.shutdown();
        this.f27417j.awaitTermination(10L, TimeUnit.SECONDS);
    }

    synchronized int r() {
        return this.f27427t;
    }

    synchronized int s() {
        return this.f27428u;
    }

    synchronized int t() {
        return this.f27429v;
    }

    boolean u() throws IOException {
        String str;
        int i7;
        g gVar;
        synchronized (this) {
            if (this.f27426s) {
                return false;
            }
            com.haier.library.okhttp.b.m.d dVar = this.f27416i;
            j jVarPoll = this.f27419l.poll();
            Object obj = null;
            if (jVarPoll == null) {
                Object objPoll = this.f27420m.poll();
                if (objPoll instanceof d) {
                    i7 = this.f27424q;
                    str = this.f27425r;
                    if (i7 != -1) {
                        gVar = this.f27418k;
                        this.f27418k = null;
                        this.f27417j.shutdown();
                    } else {
                        this.f27423p = this.f27417j.schedule(new c(), ((d) objPoll).f27437c, TimeUnit.MILLISECONDS);
                        gVar = null;
                    }
                } else {
                    if (objPoll == null) {
                        return false;
                    }
                    str = null;
                    i7 = -1;
                    gVar = null;
                }
                obj = objPoll;
            } else {
                str = null;
                i7 = -1;
                gVar = null;
            }
            try {
                if (jVarPoll != null) {
                    dVar.f(jVarPoll);
                } else if (obj instanceof e) {
                    j jVar = ((e) obj).f27439b;
                    h hVarA = t.a(dVar.a(((e) obj).f27438a, jVar.Z()));
                    hVarA.B(jVar);
                    hVarA.close();
                    synchronized (this) {
                        this.f27421n -= (long) jVar.Z();
                    }
                } else {
                    if (!(obj instanceof d)) {
                        throw new AssertionError();
                    }
                    d dVar2 = (d) obj;
                    dVar.c(dVar2.f27435a, dVar2.f27436b);
                    if (gVar != null) {
                        this.f27409b.f(this, i7, str);
                    }
                }
                n.d.s(gVar);
                return true;
            } catch (Throwable th) {
                n.d.s(gVar);
                throw th;
            }
        }
    }

    void v() {
        synchronized (this) {
            if (this.f27426s) {
                return;
            }
            com.haier.library.okhttp.b.m.d dVar = this.f27416i;
            int i7 = this.f27430w ? this.f27427t : -1;
            this.f27427t++;
            this.f27430w = true;
            if (i7 == -1) {
                try {
                    dVar.d(j.f26267f);
                    return;
                } catch (IOException e8) {
                    j(e8, null);
                    return;
                }
            }
            j(new SocketTimeoutException("sent ping but didn't receive pong within " + this.f27411d + "ms (after " + (i7 - 1) + " successful ping/pongs)"), null);
        }
    }

    @Override // com.haier.library.okhttp.b.m.c.a
    public synchronized void a(j jVar) {
        if (!this.f27426s && (!this.f27422o || !this.f27420m.isEmpty())) {
            this.f27419l.add(jVar);
            w();
            this.f27428u++;
        }
    }

    @Override // com.haier.library.okhttp.b.m.c.a
    public void b(String str) throws IOException {
        this.f27409b.d(this, str);
    }

    @Override // com.haier.library.okhttp.k
    public boolean c(int i7, String str) {
        return l(i7, str, 60000L);
    }

    @Override // com.haier.library.okhttp.b.m.c.a
    public void b(int i7, String str) {
        g gVar;
        if (i7 != -1) {
            synchronized (this) {
                if (this.f27424q == -1) {
                    this.f27424q = i7;
                    this.f27425r = str;
                    gVar = null;
                    if (this.f27422o && this.f27420m.isEmpty()) {
                        g gVar2 = this.f27418k;
                        this.f27418k = null;
                        ScheduledFuture<?> scheduledFuture = this.f27423p;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        this.f27417j.shutdown();
                        gVar = gVar2;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.f27409b.a(this, i7, str);
                if (gVar != null) {
                    this.f27409b.f(this, i7, str);
                }
                return;
            } finally {
                n.d.s(gVar);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // com.haier.library.okhttp.k
    public boolean a(String str) {
        if (str != null) {
            return m(j.i(str), 1);
        }
        throw new NullPointerException("text == null");
    }
}
