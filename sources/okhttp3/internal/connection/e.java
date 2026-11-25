package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.d0;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import kotlin.p;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Call {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f37778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final EventListener f37779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f37780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f37781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f37782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d f37783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.e
    private f f37784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f37785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.e
    private okhttp3.internal.connection.c f37786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f37787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f37788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f37789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f37790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile okhttp3.internal.connection.c f37791n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @a7.e
    private volatile f f37792o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @a7.d
    private final OkHttpClient f37793p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @a7.d
    private final Request f37794q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f37795r;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private volatile AtomicInteger f37796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Callback f37797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f37798c;

        public a(@a7.d e eVar, Callback responseCallback) {
            l0.p(responseCallback, "responseCallback");
            this.f37798c = eVar;
            this.f37797b = responseCallback;
            this.f37796a = new AtomicInteger(0);
        }

        public final void a(@a7.d ExecutorService executorService) {
            l0.p(executorService, "executorService");
            Dispatcher dispatcher = this.f37798c.l().dispatcher();
            if (okhttp3.internal.d.f37861h && Thread.holdsLock(dispatcher)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                l0.o(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(dispatcher);
                throw new AssertionError(sb.toString());
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e8) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e8);
                    this.f37798c.v(interruptedIOException);
                    this.f37797b.onFailure(this.f37798c, interruptedIOException);
                    this.f37798c.l().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                this.f37798c.l().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        @a7.d
        public final e b() {
            return this.f37798c;
        }

        @a7.d
        public final AtomicInteger c() {
            return this.f37796a;
        }

        @a7.d
        public final String d() {
            return this.f37798c.r().url().host();
        }

        @a7.d
        public final Request e() {
            return this.f37798c.r();
        }

        public final void f(@a7.d a other) {
            l0.p(other, "other");
            this.f37796a = other.f37796a;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z7;
            Throwable th;
            IOException e8;
            Dispatcher dispatcher;
            String str = "OkHttp " + this.f37798c.w();
            Thread currentThread = Thread.currentThread();
            l0.o(currentThread, "currentThread");
            String name = currentThread.getName();
            currentThread.setName(str);
            try {
                this.f37798c.f37780c.v();
                try {
                    try {
                        z7 = true;
                        try {
                            this.f37797b.onResponse(this.f37798c, this.f37798c.s());
                            dispatcher = this.f37798c.l().dispatcher();
                        } catch (IOException e9) {
                            e8 = e9;
                            if (z7) {
                                okhttp3.internal.platform.k.f38284e.g().m("Callback failure for " + this.f37798c.D(), 4, e8);
                            } else {
                                this.f37797b.onFailure(this.f37798c, e8);
                            }
                            dispatcher = this.f37798c.l().dispatcher();
                        } catch (Throwable th2) {
                            th = th2;
                            this.f37798c.cancel();
                            if (!z7) {
                                IOException iOException = new IOException("canceled due to " + th);
                                p.a(iOException, th);
                                this.f37797b.onFailure(this.f37798c, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        this.f37798c.l().dispatcher().finished$okhttp(this);
                        throw th3;
                    }
                } catch (IOException e10) {
                    z7 = false;
                    e8 = e10;
                } catch (Throwable th4) {
                    z7 = false;
                    th = th4;
                }
                dispatcher.finished$okhttp(this);
                currentThread.setName(name);
            } catch (Throwable th5) {
                currentThread.setName(name);
                throw th5;
            }
        }
    }

    public static final class b extends WeakReference<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.e
        private final Object f37799a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@a7.d e referent, @a7.e Object obj) {
            super(referent);
            l0.p(referent, "referent");
            this.f37799a = obj;
        }

        @a7.e
        public final Object a() {
            return this.f37799a;
        }
    }

    public static final class c extends okio.k {
        c() {
        }

        @Override // okio.k
        protected void B() {
            e.this.cancel();
        }
    }

    public e(@a7.d OkHttpClient client, @a7.d Request originalRequest, boolean z7) {
        l0.p(client, "client");
        l0.p(originalRequest, "originalRequest");
        this.f37793p = client;
        this.f37794q = originalRequest;
        this.f37795r = z7;
        this.f37778a = client.connectionPool().getDelegate$okhttp();
        this.f37779b = client.eventListenerFactory().create(this);
        c cVar = new c();
        cVar.i(client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        l2 l2Var = l2.f34958a;
        this.f37780c = cVar;
        this.f37781d = new AtomicBoolean();
        this.f37789l = true;
    }

    private final <E extends IOException> E C(E e8) {
        if (this.f37785h || !this.f37780c.w()) {
            return e8;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(com.alipay.sdk.data.a.f13674p);
        if (e8 != null) {
            interruptedIOException.initCause(e8);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String D() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f37795r ? "web socket" : androidx.core.app.l2.f5208p0);
        sb.append(" to ");
        sb.append(w());
        return sb.toString();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final <E extends IOException> E d(E e8) {
        Socket socketX;
        boolean z7 = okhttp3.internal.d.f37861h;
        if (z7 && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        f fVar = this.f37784g;
        if (fVar != null) {
            if (z7 && Thread.holdsLock(fVar)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread threadCurrentThread2 = Thread.currentThread();
                l0.o(threadCurrentThread2, "Thread.currentThread()");
                sb2.append(threadCurrentThread2.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(fVar);
                throw new AssertionError(sb2.toString());
            }
            synchronized (fVar) {
                socketX = x();
            }
            if (this.f37784g == null) {
                if (socketX != null) {
                    okhttp3.internal.d.n(socketX);
                }
                this.f37779b.connectionReleased(this, fVar);
            } else {
                if (!(socketX == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e9 = (E) C(e8);
        if (e8 != null) {
            EventListener eventListener = this.f37779b;
            l0.m(e9);
            eventListener.callFailed(this, e9);
        } else {
            this.f37779b.callEnd(this);
        }
        return e9;
    }

    private final void e() {
        this.f37782e = okhttp3.internal.platform.k.f38284e.g().k("response.body().close()");
        this.f37779b.callStart(this);
    }

    private final Address i(HttpUrl httpUrl) {
        SSLSocketFactory sslSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            sslSocketFactory = this.f37793p.sslSocketFactory();
            hostnameVerifier = this.f37793p.hostnameVerifier();
            certificatePinner = this.f37793p.certificatePinner();
        } else {
            sslSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.f37793p.dns(), this.f37793p.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, this.f37793p.proxyAuthenticator(), this.f37793p.proxy(), this.f37793p.protocols(), this.f37793p.connectionSpecs(), this.f37793p.proxySelector());
    }

    @Override // okhttp3.Call
    @a7.d
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public okio.k timeout() {
        return this.f37780c;
    }

    public final void B() {
        if (!(!this.f37785h)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f37785h = true;
        this.f37780c.w();
    }

    public final void c(@a7.d f connection) {
        l0.p(connection, "connection");
        if (!okhttp3.internal.d.f37861h || Thread.holdsLock(connection)) {
            if (!(this.f37784g == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.f37784g = connection;
            connection.q().add(new b(this, this.f37782e));
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

    @Override // okhttp3.Call
    public void cancel() {
        if (this.f37790m) {
            return;
        }
        this.f37790m = true;
        okhttp3.internal.connection.c cVar = this.f37791n;
        if (cVar != null) {
            cVar.b();
        }
        f fVar = this.f37792o;
        if (fVar != null) {
            fVar.g();
        }
        this.f37779b.canceled(this);
    }

    @Override // okhttp3.Call
    public void enqueue(@a7.d Callback responseCallback) {
        l0.p(responseCallback, "responseCallback");
        if (!this.f37781d.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        e();
        this.f37793p.dispatcher().enqueue$okhttp(new a(this, responseCallback));
    }

    @Override // okhttp3.Call
    @a7.d
    public Response execute() {
        if (!this.f37781d.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.f37780c.v();
        e();
        try {
            this.f37793p.dispatcher().executed$okhttp(this);
            return s();
        } finally {
            this.f37793p.dispatcher().finished$okhttp(this);
        }
    }

    @Override // okhttp3.Call
    @a7.d
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e mo136clone() {
        return new e(this.f37793p, this.f37794q, this.f37795r);
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.f37790m;
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.f37781d.get();
    }

    public final void j(@a7.d Request request, boolean z7) {
        l0.p(request, "request");
        if (!(this.f37786i == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.f37788k)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.f37787j)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            l2 l2Var = l2.f34958a;
        }
        if (z7) {
            this.f37783f = new d(this.f37778a, i(request.url()), this, this.f37779b);
        }
    }

    public final void k(boolean z7) {
        okhttp3.internal.connection.c cVar;
        synchronized (this) {
            if (!this.f37789l) {
                throw new IllegalStateException("released".toString());
            }
            l2 l2Var = l2.f34958a;
        }
        if (z7 && (cVar = this.f37791n) != null) {
            cVar.d();
        }
        this.f37786i = null;
    }

    @a7.d
    public final OkHttpClient l() {
        return this.f37793p;
    }

    @a7.e
    public final f m() {
        return this.f37784g;
    }

    @a7.e
    public final f n() {
        return this.f37792o;
    }

    @a7.d
    public final EventListener o() {
        return this.f37779b;
    }

    public final boolean p() {
        return this.f37795r;
    }

    @a7.e
    public final okhttp3.internal.connection.c q() {
        return this.f37786i;
    }

    @a7.d
    public final Request r() {
        return this.f37794q;
    }

    @Override // okhttp3.Call
    @a7.d
    public Request request() {
        return this.f37794q;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a3  */
    @a7.d
    public final Response s() throws Throwable {
        ArrayList arrayList = new ArrayList();
        d0.o0(arrayList, this.f37793p.interceptors());
        arrayList.add(new okhttp3.internal.http.j(this.f37793p));
        arrayList.add(new okhttp3.internal.http.a(this.f37793p.cookieJar()));
        arrayList.add(new okhttp3.internal.cache.a(this.f37793p.cache()));
        arrayList.add(okhttp3.internal.connection.a.f37746a);
        if (!this.f37795r) {
            d0.o0(arrayList, this.f37793p.networkInterceptors());
        }
        arrayList.add(new okhttp3.internal.http.b(this.f37795r));
        boolean z7 = false;
        try {
            Response responseProceed = new okhttp3.internal.http.g(this, arrayList, 0, null, this.f37794q, this.f37793p.connectTimeoutMillis(), this.f37793p.readTimeoutMillis(), this.f37793p.writeTimeoutMillis()).proceed(this.f37794q);
            if (isCanceled()) {
                okhttp3.internal.d.l(responseProceed);
                throw new IOException("Canceled");
            }
            v(null);
            return responseProceed;
        } catch (IOException e8) {
            try {
                IOException iOExceptionV = v(e8);
                if (iOExceptionV == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                throw iOExceptionV;
            } catch (Throwable th) {
                th = th;
                z7 = true;
                if (!z7) {
                    v(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z7) {
                v(null);
            }
            throw th;
        }
    }

    @a7.d
    public final okhttp3.internal.connection.c t(@a7.d okhttp3.internal.http.g chain) throws IOException {
        l0.p(chain, "chain");
        synchronized (this) {
            if (!this.f37789l) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.f37788k)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.f37787j)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            l2 l2Var = l2.f34958a;
        }
        d dVar = this.f37783f;
        l0.m(dVar);
        okhttp3.internal.connection.c cVar = new okhttp3.internal.connection.c(this, this.f37779b, dVar, dVar.a(this.f37793p, chain));
        this.f37786i = cVar;
        this.f37791n = cVar;
        synchronized (this) {
            this.f37787j = true;
            this.f37788k = true;
        }
        if (this.f37790m) {
            throw new IOException("Canceled");
        }
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0023 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:8:0x0014, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:35:0x0043, B:14:0x001d), top: B:47:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0027 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:8:0x0014, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:35:0x0043, B:14:0x001d), top: B:47:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0033  */
    /* JADX WARN: Code duplicated, block: B:32:0x003f  */
    public final <E extends IOException> E u(@a7.d okhttp3.internal.connection.c exchange, boolean z7, boolean z8, E e8) {
        boolean z9;
        boolean z10;
        boolean z11;
        l0.p(exchange, "exchange");
        boolean z12 = true;
        if (!l0.g(exchange, this.f37791n)) {
            return e8;
        }
        synchronized (this) {
            z9 = false;
            if (z7) {
                try {
                    if (this.f37787j) {
                        if (z7) {
                            this.f37787j = false;
                        }
                        if (z8) {
                            this.f37788k = false;
                        }
                        z10 = this.f37787j;
                        if (z10) {
                            z11 = false;
                        } else {
                            z11 = false;
                        }
                        if (z10) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        z9 = z11;
                    } else if (z8 || !this.f37788k) {
                        z12 = false;
                    } else {
                        if (z7) {
                            this.f37787j = false;
                        }
                        if (z8) {
                            this.f37788k = false;
                        }
                        z10 = this.f37787j;
                        if (z10 || this.f37788k) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (z10 || this.f37788k || this.f37789l) {
                            z12 = false;
                        }
                        z9 = z11;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z8) {
                }
                z12 = false;
            }
            l2 l2Var = l2.f34958a;
        }
        if (z9) {
            this.f37791n = null;
            f fVar = this.f37784g;
            if (fVar != null) {
                fVar.v();
            }
        }
        return z12 ? (E) d(e8) : e8;
    }

    @a7.e
    public final IOException v(@a7.e IOException iOException) {
        boolean z7;
        synchronized (this) {
            z7 = false;
            if (this.f37789l) {
                this.f37789l = false;
                if (!this.f37787j && !this.f37788k) {
                    z7 = true;
                }
            }
            l2 l2Var = l2.f34958a;
        }
        return z7 ? d(iOException) : iOException;
    }

    @a7.d
    public final String w() {
        return this.f37794q.url().redact();
    }

    @a7.e
    public final Socket x() {
        f fVar = this.f37784g;
        l0.m(fVar);
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
        Iterator<Reference<e>> it = listQ.iterator();
        int i7 = 0;
        while (true) {
            if (!it.hasNext()) {
                i7 = -1;
                break;
            }
            if (l0.g(it.next().get(), this)) {
                break;
            }
            i7++;
        }
        if (!(i7 != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        listQ.remove(i7);
        this.f37784g = null;
        if (listQ.isEmpty()) {
            fVar.E(System.nanoTime());
            if (this.f37778a.c(fVar)) {
                return fVar.socket();
            }
        }
        return null;
    }

    public final boolean y() {
        d dVar = this.f37783f;
        l0.m(dVar);
        return dVar.e();
    }

    public final void z(@a7.e f fVar) {
        this.f37792o = fVar;
    }
}
