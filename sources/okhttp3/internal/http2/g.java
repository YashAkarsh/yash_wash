package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okio.m0;
import okio.o0;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements okhttp3.internal.http.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f38130j = "host";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile i f38140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Protocol f38141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f38142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final okhttp3.internal.connection.f f38143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final okhttp3.internal.http.g f38144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f38145h;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f38139s = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f38129i = "connection";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f38131k = "keep-alive";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f38132l = "proxy-connection";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f38134n = "te";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f38133m = "transfer-encoding";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f38135o = "encoding";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f38136p = "upgrade";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final List<String> f38137q = okhttp3.internal.d.z(f38129i, "host", f38131k, f38132l, f38134n, f38133m, f38135o, f38136p, ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final List<String> f38138r = okhttp3.internal.d.z(f38129i, "host", f38131k, f38132l, f38134n, f38133m, f38135o, f38136p);

    public static final class a {
        private a() {
        }

        @a7.d
        public final List<c> a(@a7.d Request request) {
            l0.p(request, "request");
            Headers headers = request.headers();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new c(c.f37965k, request.method()));
            arrayList.add(new c(c.f37966l, okhttp3.internal.http.i.f37892a.c(request.url())));
            String strHeader = request.header(com.google.common.net.c.f22174v);
            if (strHeader != null) {
                arrayList.add(new c(c.f37968n, strHeader));
            }
            arrayList.add(new c(c.f37967m, request.url().scheme()));
            int size = headers.size();
            for (int i7 = 0; i7 < size; i7++) {
                String strName = headers.name(i7);
                Locale locale = Locale.US;
                l0.o(locale, "Locale.US");
                if (strName == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = strName.toLowerCase(locale);
                l0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!g.f38137q.contains(lowerCase) || (l0.g(lowerCase, g.f38134n) && l0.g(headers.value(i7), "trailers"))) {
                    arrayList.add(new c(lowerCase, headers.value(i7)));
                }
            }
            return arrayList;
        }

        @a7.d
        public final Response.Builder b(@a7.d Headers headerBlock, @a7.d Protocol protocol) throws IOException {
            l0.p(headerBlock, "headerBlock");
            l0.p(protocol, "protocol");
            Headers.Builder builder = new Headers.Builder();
            int size = headerBlock.size();
            okhttp3.internal.http.k kVarB = null;
            for (int i7 = 0; i7 < size; i7++) {
                String strName = headerBlock.name(i7);
                String strValue = headerBlock.value(i7);
                if (l0.g(strName, ":status")) {
                    kVarB = okhttp3.internal.http.k.f37900h.b("HTTP/1.1 " + strValue);
                } else if (!g.f38138r.contains(strName)) {
                    builder.addLenient$okhttp(strName, strValue);
                }
            }
            if (kVarB != null) {
                return new Response.Builder().protocol(protocol).code(kVarB.f37902b).message(kVarB.f37903c).headers(builder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public g(@a7.d OkHttpClient client, @a7.d okhttp3.internal.connection.f connection, @a7.d okhttp3.internal.http.g chain, @a7.d f http2Connection) {
        l0.p(client, "client");
        l0.p(connection, "connection");
        l0.p(chain, "chain");
        l0.p(http2Connection, "http2Connection");
        this.f38143f = connection;
        this.f38144g = chain;
        this.f38145h = http2Connection;
        List<Protocol> listProtocols = client.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f38141d = listProtocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.d
    public void a() throws IOException {
        i iVar = this.f38140c;
        l0.m(iVar);
        iVar.o().close();
    }

    @Override // okhttp3.internal.http.d
    public void b(@a7.d Request request) throws IOException {
        l0.p(request, "request");
        if (this.f38140c != null) {
            return;
        }
        this.f38140c = this.f38145h.A1(f38139s.a(request), request.body() != null);
        if (this.f38142e) {
            i iVar = this.f38140c;
            l0.m(iVar);
            iVar.f(b.CANCEL);
            throw new IOException("Canceled");
        }
        i iVar2 = this.f38140c;
        l0.m(iVar2);
        q0 q0VarX = iVar2.x();
        long jF = this.f38144g.f();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        q0VarX.i(jF, timeUnit);
        i iVar3 = this.f38140c;
        l0.m(iVar3);
        iVar3.L().i(this.f38144g.h(), timeUnit);
    }

    @Override // okhttp3.internal.http.d
    @a7.d
    public o0 c(@a7.d Response response) {
        l0.p(response, "response");
        i iVar = this.f38140c;
        l0.m(iVar);
        return iVar.r();
    }

    @Override // okhttp3.internal.http.d
    public void cancel() {
        this.f38142e = true;
        i iVar = this.f38140c;
        if (iVar != null) {
            iVar.f(b.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.d
    @a7.e
    public Response.Builder d(boolean z7) throws IOException {
        i iVar = this.f38140c;
        l0.m(iVar);
        Response.Builder builderB = f38139s.b(iVar.H(), this.f38141d);
        if (z7 && builderB.getCode$okhttp() == 100) {
            return null;
        }
        return builderB;
    }

    @Override // okhttp3.internal.http.d
    @a7.d
    public okhttp3.internal.connection.f e() {
        return this.f38143f;
    }

    @Override // okhttp3.internal.http.d
    public void f() throws IOException {
        this.f38145h.flush();
    }

    @Override // okhttp3.internal.http.d
    public long g(@a7.d Response response) {
        l0.p(response, "response");
        if (okhttp3.internal.http.e.c(response)) {
            return okhttp3.internal.d.x(response);
        }
        return 0L;
    }

    @Override // okhttp3.internal.http.d
    @a7.d
    public Headers h() {
        i iVar = this.f38140c;
        l0.m(iVar);
        return iVar.I();
    }

    @Override // okhttp3.internal.http.d
    @a7.d
    public m0 i(@a7.d Request request, long j7) {
        l0.p(request, "request");
        i iVar = this.f38140c;
        l0.m(iVar);
        return iVar.o();
    }
}
