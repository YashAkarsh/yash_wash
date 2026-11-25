package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.jvm.internal.l0;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.a0;
import okio.m;
import okio.m0;
import okio.o0;
import okio.r;
import okio.s;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f37751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final f f37752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final e f37753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final EventListener f37754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final d f37755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final okhttp3.internal.http.d f37756f;

    private final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f37757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f37758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f37759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f37760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f37761e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@a7.d c cVar, m0 delegate, long j7) {
            super(delegate);
            l0.p(delegate, "delegate");
            this.f37761e = cVar;
            this.f37760d = j7;
        }

        private final <E extends IOException> E b(E e8) {
            if (this.f37757a) {
                return e8;
            }
            this.f37757a = true;
            return (E) this.f37761e.a(this.f37758b, false, true, e8);
        }

        @Override // okio.r, okio.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f37759c) {
                return;
            }
            this.f37759c = true;
            long j7 = this.f37760d;
            if (j7 != -1 && this.f37758b != j7) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                b(null);
            } catch (IOException e8) {
                throw b(e8);
            }
        }

        @Override // okio.r, okio.m0, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e8) {
                throw b(e8);
            }
        }

        @Override // okio.r, okio.m0
        public void write(@a7.d m source, long j7) throws IOException {
            l0.p(source, "source");
            if (!(!this.f37759c)) {
                throw new IllegalStateException("closed".toString());
            }
            long j8 = this.f37760d;
            if (j8 == -1 || this.f37758b + j7 <= j8) {
                try {
                    super.write(source, j7);
                    this.f37758b += j7;
                    return;
                } catch (IOException e8) {
                    throw b(e8);
                }
            }
            throw new ProtocolException("expected " + this.f37760d + " bytes but received " + (this.f37758b + j7));
        }
    }

    public final class b extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f37762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f37763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f37764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f37765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f37766e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f37767f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@a7.d c cVar, o0 delegate, long j7) {
            super(delegate);
            l0.p(delegate, "delegate");
            this.f37767f = cVar;
            this.f37766e = j7;
            this.f37763b = true;
            if (j7 == 0) {
                b(null);
            }
        }

        public final <E extends IOException> E b(E e8) {
            if (this.f37764c) {
                return e8;
            }
            this.f37764c = true;
            if (e8 == null && this.f37763b) {
                this.f37763b = false;
                this.f37767f.i().responseBodyStart(this.f37767f.g());
            }
            return (E) this.f37767f.a(this.f37762a, true, false, e8);
        }

        @Override // okio.s, okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f37765d) {
                return;
            }
            this.f37765d = true;
            try {
                super.close();
                b(null);
            } catch (IOException e8) {
                throw b(e8);
            }
        }

        @Override // okio.s, okio.o0
        public long read(@a7.d m sink, long j7) throws IOException {
            l0.p(sink, "sink");
            if (!(!this.f37765d)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long j8 = delegate().read(sink, j7);
                if (this.f37763b) {
                    this.f37763b = false;
                    this.f37767f.i().responseBodyStart(this.f37767f.g());
                }
                if (j8 == -1) {
                    b(null);
                    return -1L;
                }
                long j9 = this.f37762a + j8;
                long j10 = this.f37766e;
                if (j10 != -1 && j9 > j10) {
                    throw new ProtocolException("expected " + this.f37766e + " bytes but received " + j9);
                }
                this.f37762a = j9;
                if (j9 == j10) {
                    b(null);
                }
                return j8;
            } catch (IOException e8) {
                throw b(e8);
            }
        }
    }

    public c(@a7.d e call, @a7.d EventListener eventListener, @a7.d d finder, @a7.d okhttp3.internal.http.d codec) {
        l0.p(call, "call");
        l0.p(eventListener, "eventListener");
        l0.p(finder, "finder");
        l0.p(codec, "codec");
        this.f37753c = call;
        this.f37754d = eventListener;
        this.f37755e = finder;
        this.f37756f = codec;
        this.f37752b = codec.e();
    }

    private final void t(IOException iOException) {
        this.f37755e.h(iOException);
        this.f37756f.e().J(this.f37753c, iOException);
    }

    public final <E extends IOException> E a(long j7, boolean z7, boolean z8, E e8) {
        if (e8 != null) {
            t(e8);
        }
        if (z8) {
            if (e8 != null) {
                this.f37754d.requestFailed(this.f37753c, e8);
            } else {
                this.f37754d.requestBodyEnd(this.f37753c, j7);
            }
        }
        if (z7) {
            if (e8 != null) {
                this.f37754d.responseFailed(this.f37753c, e8);
            } else {
                this.f37754d.responseBodyEnd(this.f37753c, j7);
            }
        }
        return (E) this.f37753c.u(this, z8, z7, e8);
    }

    public final void b() {
        this.f37756f.cancel();
    }

    @a7.d
    public final m0 c(@a7.d Request request, boolean z7) throws IOException {
        l0.p(request, "request");
        this.f37751a = z7;
        RequestBody requestBodyBody = request.body();
        l0.m(requestBodyBody);
        long jContentLength = requestBodyBody.contentLength();
        this.f37754d.requestBodyStart(this.f37753c);
        return new a(this, this.f37756f.i(request, jContentLength), jContentLength);
    }

    public final void d() {
        this.f37756f.cancel();
        this.f37753c.u(this, true, true, null);
    }

    public final void e() throws IOException {
        try {
            this.f37756f.a();
        } catch (IOException e8) {
            this.f37754d.requestFailed(this.f37753c, e8);
            t(e8);
            throw e8;
        }
    }

    public final void f() throws IOException {
        try {
            this.f37756f.f();
        } catch (IOException e8) {
            this.f37754d.requestFailed(this.f37753c, e8);
            t(e8);
            throw e8;
        }
    }

    @a7.d
    public final e g() {
        return this.f37753c;
    }

    @a7.d
    public final f h() {
        return this.f37752b;
    }

    @a7.d
    public final EventListener i() {
        return this.f37754d;
    }

    @a7.d
    public final d j() {
        return this.f37755e;
    }

    public final boolean k() {
        return !l0.g(this.f37755e.d().url().host(), this.f37752b.route().address().url().host());
    }

    public final boolean l() {
        return this.f37751a;
    }

    @a7.d
    public final okhttp3.internal.ws.e.d m() throws SocketException {
        this.f37753c.B();
        return this.f37756f.e().A(this);
    }

    public final void n() {
        this.f37756f.e().C();
    }

    public final void o() {
        this.f37753c.u(this, true, false, null);
    }

    @a7.d
    public final ResponseBody p(@a7.d Response response) throws IOException {
        l0.p(response, "response");
        try {
            String strHeader$default = Response.header$default(response, "Content-Type", null, 2, null);
            long jG = this.f37756f.g(response);
            return new okhttp3.internal.http.h(strHeader$default, jG, a0.d(new b(this, this.f37756f.c(response), jG)));
        } catch (IOException e8) {
            this.f37754d.responseFailed(this.f37753c, e8);
            t(e8);
            throw e8;
        }
    }

    @a7.e
    public final Response.Builder q(boolean z7) throws IOException {
        try {
            Response.Builder builderD = this.f37756f.d(z7);
            if (builderD != null) {
                builderD.initExchange$okhttp(this);
            }
            return builderD;
        } catch (IOException e8) {
            this.f37754d.responseFailed(this.f37753c, e8);
            t(e8);
            throw e8;
        }
    }

    public final void r(@a7.d Response response) {
        l0.p(response, "response");
        this.f37754d.responseHeadersEnd(this.f37753c, response);
    }

    public final void s() {
        this.f37754d.responseHeadersStart(this.f37753c);
    }

    @a7.d
    public final Headers u() throws IOException {
        return this.f37756f.h();
    }

    public final void v() {
        a(-1L, true, true, null);
    }

    public final void w(@a7.d Request request) throws IOException {
        l0.p(request, "request");
        try {
            this.f37754d.requestHeadersStart(this.f37753c);
            this.f37756f.b(request);
            this.f37754d.requestHeadersEnd(this.f37753c, request);
        } catch (IOException e8) {
            this.f37754d.requestFailed(this.f37753c, e8);
            t(e8);
            throw e8;
        }
    }
}
