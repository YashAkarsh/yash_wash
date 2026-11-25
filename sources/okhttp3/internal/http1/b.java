package okhttp3.internal.http1;

import com.alipay.sdk.util.j;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.text.b0;
import kotlin.text.c0;
import kotlin.text.h0;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.i;
import okhttp3.internal.http.k;
import okio.m;
import okio.m0;
import okio.n;
import okio.o;
import okio.o0;
import okio.q0;
import okio.t;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements okhttp3.internal.http.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f37908j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f37909k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f37910l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f37911m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f37912n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f37913o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f37914p = 5;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f37915q = 6;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f37916r = new d(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f37917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.http1.a f37918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Headers f37919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OkHttpClient f37920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final okhttp3.internal.connection.f f37921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final o f37922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final n f37923i;

    private abstract class a implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final t f37924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f37925b;

        public a() {
            this.f37924a = new t(b.this.f37922h.timeout());
        }

        protected final boolean b() {
            return this.f37925b;
        }

        @a7.d
        protected final t e() {
            return this.f37924a;
        }

        public final void q() {
            if (b.this.f37917c == 6) {
                return;
            }
            if (b.this.f37917c == 5) {
                b.this.s(this.f37924a);
                b.this.f37917c = 6;
            } else {
                throw new IllegalStateException("state: " + b.this.f37917c);
            }
        }

        protected final void r(boolean z7) {
            this.f37925b = z7;
        }

        @Override // okio.o0
        public long read(@a7.d m sink, long j7) throws IOException {
            l0.p(sink, "sink");
            try {
                return b.this.f37922h.read(sink, j7);
            } catch (IOException e8) {
                b.this.e().C();
                q();
                throw e8;
            }
        }

        @Override // okio.o0
        @a7.d
        public q0 timeout() {
            return this.f37924a;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.http1.b$b, reason: collision with other inner class name */
    private final class C0506b implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t f37927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f37928b;

        public C0506b() {
            this.f37927a = new t(b.this.f37923i.timeout());
        }

        @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f37928b) {
                return;
            }
            this.f37928b = true;
            b.this.f37923i.q0("0\r\n\r\n");
            b.this.s(this.f37927a);
            b.this.f37917c = 3;
        }

        @Override // okio.m0, java.io.Flushable
        public synchronized void flush() {
            if (this.f37928b) {
                return;
            }
            b.this.f37923i.flush();
        }

        @Override // okio.m0
        @a7.d
        public q0 timeout() {
            return this.f37927a;
        }

        @Override // okio.m0
        public void write(@a7.d m source, long j7) throws IOException {
            l0.p(source, "source");
            if (!(!this.f37928b)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j7 == 0) {
                return;
            }
            b.this.f37923i.D0(j7);
            b.this.f37923i.q0("\r\n");
            b.this.f37923i.write(source, j7);
            b.this.f37923i.q0("\r\n");
        }
    }

    private final class c extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f37930d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f37931e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final HttpUrl f37932f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f37933g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@a7.d b bVar, HttpUrl url) {
            super();
            l0.p(url, "url");
            this.f37933g = bVar;
            this.f37932f = url;
            this.f37930d = -1L;
            this.f37931e = true;
        }

        private final void u() throws IOException {
            if (this.f37930d != -1) {
                this.f37933g.f37922h.X0();
            }
            try {
                this.f37930d = this.f37933g.f37922h.Q1();
                String strX0 = this.f37933g.f37922h.X0();
                if (strX0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String string = c0.E5(strX0).toString();
                if (this.f37930d >= 0) {
                    if (!(string.length() > 0) || b0.u2(string, j.f13806b, false, 2, null)) {
                        if (this.f37930d == 0) {
                            this.f37931e = false;
                            b bVar = this.f37933g;
                            bVar.f37919e = bVar.f37918d.b();
                            OkHttpClient okHttpClient = this.f37933g.f37920f;
                            l0.m(okHttpClient);
                            CookieJar cookieJar = okHttpClient.cookieJar();
                            HttpUrl httpUrl = this.f37932f;
                            Headers headers = this.f37933g.f37919e;
                            l0.m(headers);
                            okhttp3.internal.http.e.g(cookieJar, httpUrl, headers);
                            q();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f37930d + string + h0.f35376b);
            } catch (NumberFormatException e8) {
                throw new ProtocolException(e8.getMessage());
            }
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (b()) {
                return;
            }
            if (this.f37931e && !okhttp3.internal.d.t(this, 100, TimeUnit.MILLISECONDS)) {
                this.f37933g.e().C();
                q();
            }
            r(true);
        }

        @Override // okhttp3.internal.http1.b.a, okio.o0
        public long read(@a7.d m sink, long j7) throws IOException {
            l0.p(sink, "sink");
            if (!(j7 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
            }
            if (!(!b())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f37931e) {
                return -1L;
            }
            long j8 = this.f37930d;
            if (j8 == 0 || j8 == -1) {
                u();
                if (!this.f37931e) {
                    return -1L;
                }
            }
            long j9 = super.read(sink, Math.min(j7, this.f37930d));
            if (j9 != -1) {
                this.f37930d -= j9;
                return j9;
            }
            this.f37933g.e().C();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            q();
            throw protocolException;
        }
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(w wVar) {
            this();
        }
    }

    private final class e extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f37934d;

        public e(long j7) {
            super();
            this.f37934d = j7;
            if (j7 == 0) {
                q();
            }
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (b()) {
                return;
            }
            if (this.f37934d != 0 && !okhttp3.internal.d.t(this, 100, TimeUnit.MILLISECONDS)) {
                b.this.e().C();
                q();
            }
            r(true);
        }

        @Override // okhttp3.internal.http1.b.a, okio.o0
        public long read(@a7.d m sink, long j7) throws IOException {
            l0.p(sink, "sink");
            if (!(j7 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
            }
            if (!(!b())) {
                throw new IllegalStateException("closed".toString());
            }
            long j8 = this.f37934d;
            if (j8 == 0) {
                return -1L;
            }
            long j9 = super.read(sink, Math.min(j8, j7));
            if (j9 == -1) {
                b.this.e().C();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                q();
                throw protocolException;
            }
            long j10 = this.f37934d - j9;
            this.f37934d = j10;
            if (j10 == 0) {
                q();
            }
            return j9;
        }
    }

    private final class f implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t f37936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f37937b;

        public f() {
            this.f37936a = new t(b.this.f37923i.timeout());
        }

        @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f37937b) {
                return;
            }
            this.f37937b = true;
            b.this.s(this.f37936a);
            b.this.f37917c = 3;
        }

        @Override // okio.m0, java.io.Flushable
        public void flush() throws IOException {
            if (this.f37937b) {
                return;
            }
            b.this.f37923i.flush();
        }

        @Override // okio.m0
        @a7.d
        public q0 timeout() {
            return this.f37936a;
        }

        @Override // okio.m0
        public void write(@a7.d m source, long j7) throws IOException {
            l0.p(source, "source");
            if (!(!this.f37937b)) {
                throw new IllegalStateException("closed".toString());
            }
            okhttp3.internal.d.k(source.B1(), 0L, j7);
            b.this.f37923i.write(source, j7);
        }
    }

    private final class g extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f37939d;

        public g() {
            super();
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (b()) {
                return;
            }
            if (!this.f37939d) {
                q();
            }
            r(true);
        }

        @Override // okhttp3.internal.http1.b.a, okio.o0
        public long read(@a7.d m sink, long j7) throws IOException {
            l0.p(sink, "sink");
            if (!(j7 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
            }
            if (!(!b())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f37939d) {
                return -1L;
            }
            long j8 = super.read(sink, j7);
            if (j8 != -1) {
                return j8;
            }
            this.f37939d = true;
            q();
            return -1L;
        }
    }

    public b(@a7.e OkHttpClient okHttpClient, @a7.d okhttp3.internal.connection.f connection, @a7.d o source, @a7.d n sink) {
        l0.p(connection, "connection");
        l0.p(source, "source");
        l0.p(sink, "sink");
        this.f37920f = okHttpClient;
        this.f37921g = connection;
        this.f37922h = source;
        this.f37923i = sink;
        this.f37918d = new okhttp3.internal.http1.a(source);
    }

    private final o0 A() {
        if (this.f37917c == 4) {
            this.f37917c = 5;
            e().C();
            return new g();
        }
        throw new IllegalStateException(("state: " + this.f37917c).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(t tVar) {
        q0 q0VarL = tVar.l();
        tVar.m(q0.f38523d);
        q0VarL.a();
        q0VarL.b();
    }

    private final boolean t(Request request) {
        return b0.K1("chunked", request.header(com.google.common.net.c.f22183z0), true);
    }

    private final boolean u(Response response) {
        return b0.K1("chunked", Response.header$default(response, com.google.common.net.c.f22183z0, null, 2, null), true);
    }

    private final m0 w() {
        if (this.f37917c == 1) {
            this.f37917c = 2;
            return new C0506b();
        }
        throw new IllegalStateException(("state: " + this.f37917c).toString());
    }

    private final o0 x(HttpUrl httpUrl) {
        if (this.f37917c == 4) {
            this.f37917c = 5;
            return new c(this, httpUrl);
        }
        throw new IllegalStateException(("state: " + this.f37917c).toString());
    }

    private final o0 y(long j7) {
        if (this.f37917c == 4) {
            this.f37917c = 5;
            return new e(j7);
        }
        throw new IllegalStateException(("state: " + this.f37917c).toString());
    }

    private final m0 z() {
        if (this.f37917c == 1) {
            this.f37917c = 2;
            return new f();
        }
        throw new IllegalStateException(("state: " + this.f37917c).toString());
    }

    public final void B(@a7.d Response response) {
        l0.p(response, "response");
        long jX = okhttp3.internal.d.x(response);
        if (jX == -1) {
            return;
        }
        o0 o0VarY = y(jX);
        okhttp3.internal.d.T(o0VarY, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        o0VarY.close();
    }

    public final void C(@a7.d Headers headers, @a7.d String requestLine) {
        l0.p(headers, "headers");
        l0.p(requestLine, "requestLine");
        if (!(this.f37917c == 0)) {
            throw new IllegalStateException(("state: " + this.f37917c).toString());
        }
        this.f37923i.q0(requestLine).q0("\r\n");
        int size = headers.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f37923i.q0(headers.name(i7)).q0(": ").q0(headers.value(i7)).q0("\r\n");
        }
        this.f37923i.q0("\r\n");
        this.f37917c = 1;
    }

    @Override // okhttp3.internal.http.d
    public void a() {
        this.f37923i.flush();
    }

    @Override // okhttp3.internal.http.d
    public void b(@a7.d Request request) {
        l0.p(request, "request");
        i iVar = i.f37892a;
        Proxy.Type type = e().route().proxy().type();
        l0.o(type, "connection.route().proxy.type()");
        C(request.headers(), iVar.a(request, type));
    }

    @Override // okhttp3.internal.http.d
    @a7.d
    public o0 c(@a7.d Response response) {
        l0.p(response, "response");
        if (!okhttp3.internal.http.e.c(response)) {
            return y(0L);
        }
        if (u(response)) {
            return x(response.request().url());
        }
        long jX = okhttp3.internal.d.x(response);
        return jX != -1 ? y(jX) : A();
    }

    @Override // okhttp3.internal.http.d
    public void cancel() {
        e().g();
    }

    @Override // okhttp3.internal.http.d
    @a7.e
    public Response.Builder d(boolean z7) {
        int i7 = this.f37917c;
        boolean z8 = true;
        if (i7 != 1 && i7 != 3) {
            z8 = false;
        }
        if (!z8) {
            throw new IllegalStateException(("state: " + this.f37917c).toString());
        }
        try {
            k kVarB = k.f37900h.b(this.f37918d.c());
            Response.Builder builderHeaders = new Response.Builder().protocol(kVarB.f37901a).code(kVarB.f37902b).message(kVarB.f37903c).headers(this.f37918d.b());
            if (z7 && kVarB.f37902b == 100) {
                return null;
            }
            if (kVarB.f37902b == 100) {
                this.f37917c = 3;
                return builderHeaders;
            }
            this.f37917c = 4;
            return builderHeaders;
        } catch (EOFException e8) {
            throw new IOException("unexpected end of stream on " + e().route().address().url().redact(), e8);
        }
    }

    @Override // okhttp3.internal.http.d
    @a7.d
    public okhttp3.internal.connection.f e() {
        return this.f37921g;
    }

    @Override // okhttp3.internal.http.d
    public void f() throws IOException {
        this.f37923i.flush();
    }

    @Override // okhttp3.internal.http.d
    public long g(@a7.d Response response) {
        l0.p(response, "response");
        if (!okhttp3.internal.http.e.c(response)) {
            return 0L;
        }
        if (u(response)) {
            return -1L;
        }
        return okhttp3.internal.d.x(response);
    }

    @Override // okhttp3.internal.http.d
    @a7.d
    public Headers h() {
        if (!(this.f37917c == 6)) {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        Headers headers = this.f37919e;
        return headers != null ? headers : okhttp3.internal.d.f37855b;
    }

    @Override // okhttp3.internal.http.d
    @a7.d
    public m0 i(@a7.d Request request, long j7) throws ProtocolException {
        l0.p(request, "request");
        if (request.body() != null && request.body().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (t(request)) {
            return w();
        }
        if (j7 != -1) {
            return z();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public final boolean v() {
        return this.f37917c == 6;
    }
}
