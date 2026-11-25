package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import okhttp3.Headers;
import okio.m0;
import okio.o;
import okio.o0;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f38158o = 16384;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f38159p = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f38160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f38161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f38162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f38163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayDeque<Headers> f38164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f38165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final c f38166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private final b f38167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    private final d f38168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @a7.d
    private final d f38169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @a7.e
    private okhttp3.internal.http2.b f38170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @a7.e
    private IOException f38171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f38172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @a7.d
    private final f f38173n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public final class c implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final okio.m f38179a = new okio.m();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final okio.m f38180b = new okio.m();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.e
        private Headers f38181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f38182d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f38183e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f38184f;

        public c(long j7, boolean z7) {
            this.f38183e = j7;
            this.f38184f = z7;
        }

        private final void G(long j7) {
            i iVar = i.this;
            if (!okhttp3.internal.d.f37861h || !Thread.holdsLock(iVar)) {
                i.this.h().l2(j7);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(iVar);
            throw new AssertionError(sb.toString());
        }

        public final void C(boolean z7) {
            this.f38182d = z7;
        }

        public final void E(boolean z7) {
            this.f38184f = z7;
        }

        public final void F(@a7.e Headers headers) {
            this.f38181c = headers;
        }

        public final boolean b() {
            return this.f38182d;
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long jB1;
            synchronized (i.this) {
                this.f38182d = true;
                jB1 = this.f38180b.B1();
                this.f38180b.q();
                i iVar = i.this;
                if (iVar == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                iVar.notifyAll();
                l2 l2Var = l2.f34958a;
            }
            if (jB1 > 0) {
                G(jB1);
            }
            i.this.b();
        }

        public final boolean e() {
            return this.f38184f;
        }

        @a7.d
        public final okio.m q() {
            return this.f38180b;
        }

        @a7.d
        public final okio.m r() {
            return this.f38179a;
        }

        @Override // okio.o0
        public long read(@a7.d okio.m sink, long j7) throws IOException {
            IOException iOExceptionJ;
            long j8;
            boolean z7;
            l0.p(sink, "sink");
            long j9 = 0;
            if (!(j7 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
            }
            while (true) {
                synchronized (i.this) {
                    i.this.n().v();
                    try {
                        if (i.this.i() != null) {
                            iOExceptionJ = i.this.j();
                            if (iOExceptionJ == null) {
                                okhttp3.internal.http2.b bVarI = i.this.i();
                                l0.m(bVarI);
                                iOExceptionJ = new n(bVarI);
                            }
                        } else {
                            iOExceptionJ = null;
                        }
                        if (this.f38182d) {
                            throw new IOException("stream closed");
                        }
                        if (this.f38180b.B1() > j9) {
                            okio.m mVar = this.f38180b;
                            j8 = mVar.read(sink, Math.min(j7, mVar.B1()));
                            i iVar = i.this;
                            iVar.E(iVar.m() + j8);
                            long jM = i.this.m() - i.this.l();
                            if (iOExceptionJ == null && jM >= i.this.h().L0().e() / 2) {
                                i.this.h().t2(i.this.k(), jM);
                                i iVar2 = i.this;
                                iVar2.D(iVar2.m());
                            }
                        } else {
                            if (this.f38184f || iOExceptionJ != null) {
                                j8 = -1;
                            } else {
                                i.this.J();
                                j8 = -1;
                                z7 = true;
                            }
                            i.this.n().D();
                            l2 l2Var = l2.f34958a;
                        }
                        z7 = false;
                        i.this.n().D();
                        l2 l2Var2 = l2.f34958a;
                    } catch (Throwable th) {
                        i.this.n().D();
                        throw th;
                    }
                    throw th;
                }
                if (!z7) {
                    if (j8 != -1) {
                        G(j8);
                        return j8;
                    }
                    if (iOExceptionJ == null) {
                        return -1L;
                    }
                    l0.m(iOExceptionJ);
                    throw iOExceptionJ;
                }
                j9 = 0;
            }
        }

        @Override // okio.o0
        @a7.d
        public q0 timeout() {
            return i.this.n();
        }

        @a7.e
        public final Headers u() {
            return this.f38181c;
        }

        public final void v(@a7.d o source, long j7) throws IOException {
            boolean z7;
            boolean z8;
            boolean z9;
            long jB1;
            l0.p(source, "source");
            i iVar = i.this;
            if (okhttp3.internal.d.f37861h && Thread.holdsLock(iVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                l0.o(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(iVar);
                throw new AssertionError(sb.toString());
            }
            while (j7 > 0) {
                synchronized (i.this) {
                    z7 = this.f38184f;
                    z8 = true;
                    z9 = this.f38180b.B1() + j7 > this.f38183e;
                    l2 l2Var = l2.f34958a;
                }
                if (z9) {
                    source.skip(j7);
                    i.this.f(okhttp3.internal.http2.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z7) {
                    source.skip(j7);
                    return;
                }
                long j8 = source.read(this.f38179a, j7);
                if (j8 == -1) {
                    throw new EOFException();
                }
                j7 -= j8;
                synchronized (i.this) {
                    if (this.f38182d) {
                        jB1 = this.f38179a.B1();
                        this.f38179a.q();
                    } else {
                        if (this.f38180b.B1() != 0) {
                            z8 = false;
                        }
                        this.f38180b.C0(this.f38179a);
                        if (z8) {
                            i iVar2 = i.this;
                            if (iVar2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            iVar2.notifyAll();
                        }
                        jB1 = 0;
                    }
                }
                if (jB1 > 0) {
                    G(jB1);
                }
            }
        }
    }

    public final class d extends okio.k {
        public d() {
        }

        @Override // okio.k
        protected void B() {
            i.this.f(okhttp3.internal.http2.b.CANCEL);
            i.this.h().b2();
        }

        public final void D() throws IOException {
            if (w()) {
                throw x(null);
            }
        }

        @Override // okio.k
        @a7.d
        protected IOException x(@a7.e IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(com.alipay.sdk.data.a.f13674p);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    public i(int i7, @a7.d f connection, boolean z7, boolean z8, @a7.e Headers headers) {
        l0.p(connection, "connection");
        this.f38172m = i7;
        this.f38173n = connection;
        this.f38163d = connection.Q0().e();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.f38164e = arrayDeque;
        this.f38166g = new c(connection.L0().e(), z8);
        this.f38167h = new b(z7);
        this.f38168i = new d();
        this.f38169j = new d();
        if (headers == null) {
            if (!v()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!v())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(headers);
        }
    }

    private final boolean e(okhttp3.internal.http2.b bVar, IOException iOException) {
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
        synchronized (this) {
            if (this.f38170k != null) {
                return false;
            }
            if (this.f38166g.e() && this.f38167h.q()) {
                return false;
            }
            this.f38170k = bVar;
            this.f38171l = iOException;
            notifyAll();
            l2 l2Var = l2.f34958a;
            this.f38173n.a2(this.f38172m);
            return true;
        }
    }

    public final synchronized void A(@a7.d okhttp3.internal.http2.b errorCode) {
        l0.p(errorCode, "errorCode");
        if (this.f38170k == null) {
            this.f38170k = errorCode;
            notifyAll();
        }
    }

    public final void B(@a7.e okhttp3.internal.http2.b bVar) {
        this.f38170k = bVar;
    }

    public final void C(@a7.e IOException iOException) {
        this.f38171l = iOException;
    }

    public final void D(long j7) {
        this.f38161b = j7;
    }

    public final void E(long j7) {
        this.f38160a = j7;
    }

    public final void F(long j7) {
        this.f38163d = j7;
    }

    public final void G(long j7) {
        this.f38162c = j7;
    }

    @a7.d
    public final synchronized Headers H() throws IOException {
        Headers headersRemoveFirst;
        this.f38168i.v();
        while (this.f38164e.isEmpty() && this.f38170k == null) {
            try {
                J();
            } catch (Throwable th) {
                this.f38168i.D();
                throw th;
            }
        }
        this.f38168i.D();
        if (!(!this.f38164e.isEmpty())) {
            IOException iOException = this.f38171l;
            if (iOException != null) {
                throw iOException;
            }
            okhttp3.internal.http2.b bVar = this.f38170k;
            l0.m(bVar);
            throw new n(bVar);
        }
        headersRemoveFirst = this.f38164e.removeFirst();
        l0.o(headersRemoveFirst, "headersQueue.removeFirst()");
        return headersRemoveFirst;
    }

    @a7.d
    public final synchronized Headers I() throws IOException {
        Headers headersU;
        if (this.f38170k != null) {
            IOException iOException = this.f38171l;
            if (iOException != null) {
                throw iOException;
            }
            okhttp3.internal.http2.b bVar = this.f38170k;
            l0.m(bVar);
            throw new n(bVar);
        }
        if (!(this.f38166g.e() && this.f38166g.r().N() && this.f38166g.q().N())) {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        headersU = this.f38166g.u();
        if (headersU == null) {
            headersU = okhttp3.internal.d.f37855b;
        }
        return headersU;
    }

    public final void J() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void K(@a7.d List<okhttp3.internal.http2.c> responseHeaders, boolean z7, boolean z8) throws IOException {
        boolean z9;
        l0.p(responseHeaders, "responseHeaders");
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
        synchronized (this) {
            this.f38165f = true;
            if (z7) {
                this.f38167h.u(true);
            }
            l2 l2Var = l2.f34958a;
        }
        if (!z8) {
            synchronized (this.f38173n) {
                z9 = this.f38173n.q1() >= this.f38173n.i1();
            }
            z8 = z9;
        }
        this.f38173n.n2(this.f38172m, z7, responseHeaders);
        if (z8) {
            this.f38173n.flush();
        }
    }

    @a7.d
    public final q0 L() {
        return this.f38169j;
    }

    public final void a(long j7) {
        this.f38163d += j7;
        if (j7 > 0) {
            notifyAll();
        }
    }

    public final void b() throws IOException {
        boolean z7;
        boolean zW;
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
        synchronized (this) {
            z7 = !this.f38166g.e() && this.f38166g.b() && (this.f38167h.q() || this.f38167h.e());
            zW = w();
            l2 l2Var = l2.f34958a;
        }
        if (z7) {
            d(okhttp3.internal.http2.b.CANCEL, null);
        } else {
            if (zW) {
                return;
            }
            this.f38173n.a2(this.f38172m);
        }
    }

    public final void c() throws IOException {
        if (this.f38167h.e()) {
            throw new IOException("stream closed");
        }
        if (this.f38167h.q()) {
            throw new IOException("stream finished");
        }
        if (this.f38170k != null) {
            IOException iOException = this.f38171l;
            if (iOException != null) {
                throw iOException;
            }
            okhttp3.internal.http2.b bVar = this.f38170k;
            l0.m(bVar);
            throw new n(bVar);
        }
    }

    public final void d(@a7.d okhttp3.internal.http2.b rstStatusCode, @a7.e IOException iOException) throws IOException {
        l0.p(rstStatusCode, "rstStatusCode");
        if (e(rstStatusCode, iOException)) {
            this.f38173n.r2(this.f38172m, rstStatusCode);
        }
    }

    public final void f(@a7.d okhttp3.internal.http2.b errorCode) {
        l0.p(errorCode, "errorCode");
        if (e(errorCode, null)) {
            this.f38173n.s2(this.f38172m, errorCode);
        }
    }

    public final void g(@a7.d Headers trailers) {
        l0.p(trailers, "trailers");
        synchronized (this) {
            boolean z7 = true;
            if (!(!this.f38167h.q())) {
                throw new IllegalStateException("already finished".toString());
            }
            if (trailers.size() == 0) {
                z7 = false;
            }
            if (!z7) {
                throw new IllegalArgumentException("trailers.size() == 0".toString());
            }
            this.f38167h.v(trailers);
            l2 l2Var = l2.f34958a;
        }
    }

    @a7.d
    public final f h() {
        return this.f38173n;
    }

    @a7.e
    public final synchronized okhttp3.internal.http2.b i() {
        return this.f38170k;
    }

    @a7.e
    public final IOException j() {
        return this.f38171l;
    }

    public final int k() {
        return this.f38172m;
    }

    public final long l() {
        return this.f38161b;
    }

    public final long m() {
        return this.f38160a;
    }

    @a7.d
    public final d n() {
        return this.f38168i;
    }

    @a7.d
    public final m0 o() {
        synchronized (this) {
            if (!(this.f38165f || v())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
            l2 l2Var = l2.f34958a;
        }
        return this.f38167h;
    }

    @a7.d
    public final b p() {
        return this.f38167h;
    }

    @a7.d
    public final o0 q() {
        return this.f38166g;
    }

    @a7.d
    public final c r() {
        return this.f38166g;
    }

    public final long s() {
        return this.f38163d;
    }

    public final long t() {
        return this.f38162c;
    }

    @a7.d
    public final d u() {
        return this.f38169j;
    }

    public final boolean v() {
        return this.f38173n.v0() == ((this.f38172m & 1) == 1);
    }

    public final synchronized boolean w() {
        if (this.f38170k != null) {
            return false;
        }
        return ((this.f38166g.e() || this.f38166g.b()) && (this.f38167h.q() || this.f38167h.e()) && this.f38165f) ? false : true;
    }

    @a7.d
    public final q0 x() {
        return this.f38168i;
    }

    public final void y(@a7.d o source, int i7) throws IOException {
        l0.p(source, "source");
        if (!okhttp3.internal.d.f37861h || !Thread.holdsLock(this)) {
            this.f38166g.v(source, i7);
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

    public final void z(@a7.d Headers headers, boolean z7) {
        boolean zW;
        l0.p(headers, "headers");
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
        synchronized (this) {
            if (this.f38165f && z7) {
                this.f38166g.F(headers);
            } else {
                this.f38165f = true;
                this.f38164e.add(headers);
            }
            if (z7) {
                this.f38166g.E(true);
            }
            zW = w();
            notifyAll();
            l2 l2Var = l2.f34958a;
        }
        if (zW) {
            return;
        }
        this.f38173n.a2(this.f38172m);
    }

    public final class b implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final okio.m f38174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.e
        private Headers f38175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f38176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f38177d;

        public b(boolean z7) {
            this.f38177d = z7;
            this.f38174a = new okio.m();
        }

        private final void b(boolean z7) throws IOException {
            long jMin;
            boolean z8;
            synchronized (i.this) {
                i.this.u().v();
                while (i.this.t() >= i.this.s() && !this.f38177d && !this.f38176c && i.this.i() == null) {
                    try {
                        i.this.J();
                    } catch (Throwable th) {
                        i.this.u().D();
                        throw th;
                    }
                }
                i.this.u().D();
                i.this.c();
                jMin = Math.min(i.this.s() - i.this.t(), this.f38174a.B1());
                i iVar = i.this;
                iVar.G(iVar.t() + jMin);
                z8 = z7 && jMin == this.f38174a.B1() && i.this.i() == null;
                l2 l2Var = l2.f34958a;
            }
            i.this.u().v();
            try {
                i.this.h().m2(i.this.k(), z8, this.f38174a, jMin);
            } finally {
                i.this.u().D();
            }
        }

        @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            i iVar = i.this;
            if (okhttp3.internal.d.f37861h && Thread.holdsLock(iVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                l0.o(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(iVar);
                throw new AssertionError(sb.toString());
            }
            synchronized (i.this) {
                if (this.f38176c) {
                    return;
                }
                boolean z7 = i.this.i() == null;
                l2 l2Var = l2.f34958a;
                if (!i.this.p().f38177d) {
                    boolean z8 = this.f38174a.B1() > 0;
                    if (this.f38175b != null) {
                        while (this.f38174a.B1() > 0) {
                            b(false);
                        }
                        f fVarH = i.this.h();
                        int iK = i.this.k();
                        Headers headers = this.f38175b;
                        l0.m(headers);
                        fVarH.n2(iK, z7, okhttp3.internal.d.W(headers));
                    } else if (z8) {
                        while (this.f38174a.B1() > 0) {
                            b(true);
                        }
                    } else if (z7) {
                        i.this.h().m2(i.this.k(), true, null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.f38176c = true;
                    l2 l2Var2 = l2.f34958a;
                }
                i.this.h().flush();
                i.this.b();
            }
        }

        public final boolean e() {
            return this.f38176c;
        }

        @Override // okio.m0, java.io.Flushable
        public void flush() throws IOException {
            i iVar = i.this;
            if (okhttp3.internal.d.f37861h && Thread.holdsLock(iVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                l0.o(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(iVar);
                throw new AssertionError(sb.toString());
            }
            synchronized (i.this) {
                i.this.c();
                l2 l2Var = l2.f34958a;
            }
            while (this.f38174a.B1() > 0) {
                b(false);
                i.this.h().flush();
            }
        }

        public final boolean q() {
            return this.f38177d;
        }

        @a7.e
        public final Headers r() {
            return this.f38175b;
        }

        public final void s(boolean z7) {
            this.f38176c = z7;
        }

        @Override // okio.m0
        @a7.d
        public q0 timeout() {
            return i.this.u();
        }

        public final void u(boolean z7) {
            this.f38177d = z7;
        }

        public final void v(@a7.e Headers headers) {
            this.f38175b = headers;
        }

        @Override // okio.m0
        public void write(@a7.d okio.m source, long j7) throws IOException {
            l0.p(source, "source");
            i iVar = i.this;
            if (!okhttp3.internal.d.f37861h || !Thread.holdsLock(iVar)) {
                this.f38174a.write(source, j7);
                while (this.f38174a.B1() >= 16384) {
                    b(false);
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(iVar);
            throw new AssertionError(sb.toString());
        }

        public /* synthetic */ b(i iVar, boolean z7, int i7, w wVar) {
            this((i7 & 1) != 0 ? false : z7);
        }
    }
}
