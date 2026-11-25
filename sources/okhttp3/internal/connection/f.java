package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.z;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.w;
import kotlin.text.b0;
import kotlin.text.u;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.http2.m;
import okio.a0;
import okio.n;
import okio.o;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends okhttp3.internal.http2.f.d implements Connection {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f37801t = "throw with null exception";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f37802u = 21;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f37803v = 10000000000L;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f37804w = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Socket f37805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Socket f37806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handshake f37807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Protocol f37808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private okhttp3.internal.http2.f f37809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private o f37810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private n f37811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f37812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f37813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f37814l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f37815m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f37816n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f37817o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @a7.d
    private final List<Reference<e>> f37818p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f37819q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @a7.d
    private final h f37820r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Route f37821s;

    public static final class a {
        private a() {
        }

        @a7.d
        public final f a(@a7.d h connectionPool, @a7.d Route route, @a7.d Socket socket, long j7) {
            l0.p(connectionPool, "connectionPool");
            l0.p(route, "route");
            l0.p(socket, "socket");
            f fVar = new f(connectionPool, route);
            fVar.f37806d = socket;
            fVar.E(j7);
            return fVar;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    static final class b extends n0 implements i5.a<List<? extends Certificate>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertificatePinner f37822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handshake f37823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Address f37824c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CertificatePinner certificatePinner, Handshake handshake, Address address) {
            super(0);
            this.f37822a = certificatePinner;
            this.f37823b = handshake;
            this.f37824c = address;
        }

        @Override // i5.a
        @a7.d
        public final List<? extends Certificate> invoke() {
            u5.c certificateChainCleaner$okhttp = this.f37822a.getCertificateChainCleaner$okhttp();
            l0.m(certificateChainCleaner$okhttp);
            return certificateChainCleaner$okhttp.a(this.f37823b.peerCertificates(), this.f37824c.url().host());
        }
    }

    static final class c extends n0 implements i5.a<List<? extends X509Certificate>> {
        c() {
            super(0);
        }

        @Override // i5.a
        @a7.d
        public final List<? extends X509Certificate> invoke() {
            Handshake handshake = f.this.f37807e;
            l0.m(handshake);
            List<Certificate> listPeerCertificates = handshake.peerCertificates();
            ArrayList arrayList = new ArrayList(z.Z(listPeerCertificates, 10));
            for (Certificate certificate : listPeerCertificates) {
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public static final class d extends okhttp3.internal.ws.e.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ okhttp3.internal.connection.c f37826d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ o f37827e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ n f37828f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(okhttp3.internal.connection.c cVar, o oVar, n nVar, boolean z7, o oVar2, n nVar2) {
            super(z7, oVar2, nVar2);
            this.f37826d = cVar;
            this.f37827e = oVar;
            this.f37828f = nVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f37826d.a(-1L, true, true, null);
        }
    }

    public f(@a7.d h connectionPool, @a7.d Route route) {
        l0.p(connectionPool, "connectionPool");
        l0.p(route, "route");
        this.f37820r = connectionPool;
        this.f37821s = route;
        this.f37817o = 1;
        this.f37818p = new ArrayList();
        this.f37819q = Long.MAX_VALUE;
    }

    private final boolean D(List<Route> list) {
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (Route route : list) {
            if (route.proxy().type() == Proxy.Type.DIRECT && this.f37821s.proxy().type() == Proxy.Type.DIRECT && l0.g(this.f37821s.socketAddress(), route.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private final void H(int i7) throws IOException {
        Socket socket = this.f37806d;
        l0.m(socket);
        o oVar = this.f37810h;
        l0.m(oVar);
        n nVar = this.f37811i;
        l0.m(nVar);
        socket.setSoTimeout(0);
        okhttp3.internal.http2.f fVarA = new okhttp3.internal.http2.f.b(true, okhttp3.internal.concurrent.d.f37734h).y(socket, this.f37821s.address().url().host(), oVar, nVar).k(this).l(i7).a();
        this.f37809g = fVarA;
        this.f37817o = okhttp3.internal.http2.f.f38024J.a().f();
        okhttp3.internal.http2.f.k2(fVarA, false, null, 3, null);
    }

    private final boolean I(HttpUrl httpUrl) {
        Handshake handshake;
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
        HttpUrl httpUrlUrl = this.f37821s.address().url();
        if (httpUrl.port() != httpUrlUrl.port()) {
            return false;
        }
        if (l0.g(httpUrl.host(), httpUrlUrl.host())) {
            return true;
        }
        if (this.f37813k || (handshake = this.f37807e) == null) {
            return false;
        }
        l0.m(handshake);
        return h(httpUrl, handshake);
    }

    private final boolean h(HttpUrl httpUrl, Handshake handshake) {
        List<Certificate> listPeerCertificates = handshake.peerCertificates();
        if (!listPeerCertificates.isEmpty()) {
            u5.d dVar = u5.d.f40420c;
            String strHost = httpUrl.host();
            Certificate certificate = listPeerCertificates.get(0);
            if (certificate == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            if (dVar.c(strHost, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    private final void k(int i7, int i8, Call call, EventListener eventListener) throws IOException {
        Socket socket;
        int i9;
        Proxy proxy = this.f37821s.proxy();
        Address address = this.f37821s.address();
        Proxy.Type type = proxy.type();
        if (type != null && ((i9 = g.f37829a[type.ordinal()]) == 1 || i9 == 2)) {
            socket = address.socketFactory().createSocket();
            l0.m(socket);
        } else {
            socket = new Socket(proxy);
        }
        this.f37805c = socket;
        eventListener.connectStart(call, this.f37821s.socketAddress(), proxy);
        socket.setSoTimeout(i8);
        try {
            okhttp3.internal.platform.k.f38284e.g().g(socket, this.f37821s.socketAddress(), i7);
            try {
                this.f37810h = a0.d(a0.n(socket));
                this.f37811i = a0.c(a0.i(socket));
            } catch (NullPointerException e8) {
                if (l0.g(e8.getMessage(), f37801t)) {
                    throw new IOException(e8);
                }
            }
        } catch (ConnectException e9) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f37821s.socketAddress());
            connectException.initCause(e9);
            throw connectException;
        }
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
    private final void l(okhttp3.internal.connection.b bVar) throws Throwable {
        Address address = this.f37821s.address();
        SSLSocketFactory sslSocketFactory = address.sslSocketFactory();
        SSLSocket sSLSocket = null;
        try {
            l0.m(sslSocketFactory);
            Socket socketCreateSocket = sslSocketFactory.createSocket(this.f37805c, address.url().host(), address.url().port(), true);
            if (socketCreateSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                ConnectionSpec connectionSpecA = bVar.a(sSLSocket2);
                if (connectionSpecA.supportsTlsExtensions()) {
                    okhttp3.internal.platform.k.f38284e.g().f(sSLSocket2, address.url().host(), address.protocols());
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                Handshake.Companion companion = Handshake.Companion;
                l0.o(sslSocketSession, "sslSocketSession");
                Handshake handshake = companion.get(sslSocketSession);
                HostnameVerifier hostnameVerifier = address.hostnameVerifier();
                l0.m(hostnameVerifier);
                if (hostnameVerifier.verify(address.url().host(), sslSocketSession)) {
                    CertificatePinner certificatePinner = address.certificatePinner();
                    l0.m(certificatePinner);
                    this.f37807e = new Handshake(handshake.tlsVersion(), handshake.cipherSuite(), handshake.localCertificates(), new b(certificatePinner, handshake, address));
                    certificatePinner.check$okhttp(address.url().host(), new c());
                    String strJ = connectionSpecA.supportsTlsExtensions() ? okhttp3.internal.platform.k.f38284e.g().j(sSLSocket2) : null;
                    this.f37806d = sSLSocket2;
                    this.f37810h = a0.d(a0.n(sSLSocket2));
                    this.f37811i = a0.c(a0.i(sSLSocket2));
                    this.f37808f = strJ != null ? Protocol.Companion.get(strJ) : Protocol.HTTP_1_1;
                    okhttp3.internal.platform.k.f38284e.g().c(sSLSocket2);
                    return;
                }
                List<Certificate> listPeerCertificates = handshake.peerCertificates();
                if (!(!listPeerCertificates.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
                }
                Certificate certificate = listPeerCertificates.get(0);
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                X509Certificate x509Certificate = (X509Certificate) certificate;
                StringBuilder sb = new StringBuilder();
                sb.append("\n              |Hostname ");
                sb.append(address.url().host());
                sb.append(" not verified:\n              |    certificate: ");
                sb.append(CertificatePinner.Companion.pin(x509Certificate));
                sb.append("\n              |    DN: ");
                Principal subjectDN = x509Certificate.getSubjectDN();
                l0.o(subjectDN, "cert.subjectDN");
                sb.append(subjectDN.getName());
                sb.append("\n              |    subjectAltNames: ");
                sb.append(u5.d.f40420c.a(x509Certificate));
                sb.append("\n              ");
                throw new SSLPeerUnverifiedException(u.r(sb.toString(), null, 1, null));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    okhttp3.internal.platform.k.f38284e.g().c(sSLSocket);
                }
                if (sSLSocket != null) {
                    okhttp3.internal.d.n(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void m(int i7, int i8, int i9, Call call, EventListener eventListener) throws IOException {
        Request requestO = o();
        HttpUrl httpUrlUrl = requestO.url();
        for (int i10 = 0; i10 < 21; i10++) {
            k(i7, i8, call, eventListener);
            requestO = n(i8, i9, requestO, httpUrlUrl);
            if (requestO == null) {
                return;
            }
            Socket socket = this.f37805c;
            if (socket != null) {
                okhttp3.internal.d.n(socket);
            }
            this.f37805c = null;
            this.f37811i = null;
            this.f37810h = null;
            eventListener.connectEnd(call, this.f37821s.socketAddress(), this.f37821s.proxy(), null);
        }
    }

    private final Request n(int i7, int i8, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + okhttp3.internal.d.a0(httpUrl, true) + " HTTP/1.1";
        while (true) {
            o oVar = this.f37810h;
            l0.m(oVar);
            n nVar = this.f37811i;
            l0.m(nVar);
            okhttp3.internal.http1.b bVar = new okhttp3.internal.http1.b(null, this, oVar, nVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            oVar.timeout().i(i7, timeUnit);
            nVar.timeout().i(i8, timeUnit);
            bVar.C(request.headers(), str);
            bVar.a();
            Response.Builder builderD = bVar.d(false);
            l0.m(builderD);
            Response responseBuild = builderD.request(request).build();
            bVar.B(responseBuild);
            int iCode = responseBuild.code();
            if (iCode == 200) {
                if (oVar.p().N() && nVar.p().N()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iCode != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + responseBuild.code());
            }
            Request requestAuthenticate = this.f37821s.address().proxyAuthenticator().authenticate(this.f37821s, responseBuild);
            if (requestAuthenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (b0.K1("close", Response.header$default(responseBuild, com.google.common.net.c.f22160o, null, 2, null), true)) {
                return requestAuthenticate;
            }
            request = requestAuthenticate;
        }
    }

    private final Request o() throws IOException {
        Request requestBuild = new Request.Builder().url(this.f37821s.address().url()).method("CONNECT", null).header(com.google.common.net.c.f22174v, okhttp3.internal.d.a0(this.f37821s.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header(com.google.common.net.c.M, okhttp3.internal.d.f37863j).build();
        Request requestAuthenticate = this.f37821s.address().proxyAuthenticator().authenticate(this.f37821s, new Response.Builder().request(requestBuild).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(okhttp3.internal.d.f37856c).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header(com.google.common.net.c.f22161o0, "OkHttp-Preemptive").build());
        return requestAuthenticate != null ? requestAuthenticate : requestBuild;
    }

    private final void p(okhttp3.internal.connection.b bVar, int i7, Call call, EventListener eventListener) throws Throwable {
        if (this.f37821s.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            l(bVar);
            eventListener.secureConnectEnd(call, this.f37807e);
            if (this.f37808f == Protocol.HTTP_2) {
                H(i7);
                return;
            }
            return;
        }
        List<Protocol> listProtocols = this.f37821s.address().protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!listProtocols.contains(protocol)) {
            this.f37806d = this.f37805c;
            this.f37808f = Protocol.HTTP_1_1;
        } else {
            this.f37806d = this.f37805c;
            this.f37808f = protocol;
            H(i7);
        }
    }

    @a7.d
    public final okhttp3.internal.ws.e.d A(@a7.d okhttp3.internal.connection.c exchange) throws SocketException {
        l0.p(exchange, "exchange");
        Socket socket = this.f37806d;
        l0.m(socket);
        o oVar = this.f37810h;
        l0.m(oVar);
        n nVar = this.f37811i;
        l0.m(nVar);
        socket.setSoTimeout(0);
        C();
        return new d(exchange, oVar, nVar, true, oVar, nVar);
    }

    public final synchronized void B() {
        this.f37813k = true;
    }

    public final synchronized void C() {
        this.f37812j = true;
    }

    public final void E(long j7) {
        this.f37819q = j7;
    }

    public final void F(boolean z7) {
        this.f37812j = z7;
    }

    public final void G(int i7) {
        this.f37814l = i7;
    }

    public final synchronized void J(@a7.d e call, @a7.e IOException iOException) {
        l0.p(call, "call");
        if (iOException instanceof okhttp3.internal.http2.n) {
            if (((okhttp3.internal.http2.n) iOException).f38216a == okhttp3.internal.http2.b.REFUSED_STREAM) {
                int i7 = this.f37816n + 1;
                this.f37816n = i7;
                if (i7 > 1) {
                    this.f37812j = true;
                    this.f37814l++;
                }
            } else if (((okhttp3.internal.http2.n) iOException).f38216a != okhttp3.internal.http2.b.CANCEL || !call.isCanceled()) {
                this.f37812j = true;
                this.f37814l++;
            }
        } else if (!y() || (iOException instanceof okhttp3.internal.http2.a)) {
            this.f37812j = true;
            if (this.f37815m == 0) {
                if (iOException != null) {
                    j(call.l(), this.f37821s, iOException);
                }
                this.f37814l++;
            }
        }
    }

    @Override // okhttp3.internal.http2.f.d
    public synchronized void a(@a7.d okhttp3.internal.http2.f connection, @a7.d m settings) {
        l0.p(connection, "connection");
        l0.p(settings, "settings");
        this.f37817o = settings.f();
    }

    @Override // okhttp3.internal.http2.f.d
    public void b(@a7.d okhttp3.internal.http2.i stream) throws IOException {
        l0.p(stream, "stream");
        stream.d(okhttp3.internal.http2.b.REFUSED_STREAM, null);
    }

    public final void g() {
        Socket socket = this.f37805c;
        if (socket != null) {
            okhttp3.internal.d.n(socket);
        }
    }

    @Override // okhttp3.Connection
    @a7.e
    public Handshake handshake() {
        return this.f37807e;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0108  */
    /* JADX WARN: Code duplicated, block: B:52:0x010f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0139  */
    /* JADX WARN: Code duplicated, block: B:56:0x013f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0144  */
    /* JADX WARN: Code duplicated, block: B:74:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:? A[LOOP:0: B:68:0x009a->B:76:?, LOOP_END, SYNTHETIC] */
    public final void i(int i7, int i8, int i9, int i10, boolean z7, @a7.d Call call, @a7.d EventListener eventListener) throws Throwable {
        Socket socket;
        Socket socket2;
        l0.p(call, "call");
        l0.p(eventListener, "eventListener");
        if (!(this.f37808f == null)) {
            throw new IllegalStateException("already connected".toString());
        }
        List<ConnectionSpec> listConnectionSpecs = this.f37821s.address().connectionSpecs();
        okhttp3.internal.connection.b bVar = new okhttp3.internal.connection.b(listConnectionSpecs);
        if (this.f37821s.address().sslSocketFactory() == null) {
            if (!listConnectionSpecs.contains(ConnectionSpec.CLEARTEXT)) {
                throw new j(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strHost = this.f37821s.address().url().host();
            if (!okhttp3.internal.platform.k.f38284e.g().l(strHost)) {
                throw new j(new UnknownServiceException("CLEARTEXT communication to " + strHost + " not permitted by network security policy"));
            }
        } else if (this.f37821s.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new j(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        j jVar = null;
        while (true) {
            try {
                if (this.f37821s.requiresTunnel()) {
                    m(i7, i8, i9, call, eventListener);
                    if (this.f37805c == null) {
                        break;
                    }
                } else {
                    try {
                        k(i7, i8, call, eventListener);
                    } catch (IOException e8) {
                        e = e8;
                        socket = this.f37806d;
                        if (socket != null) {
                            okhttp3.internal.d.n(socket);
                        }
                        socket2 = this.f37805c;
                        if (socket2 != null) {
                            okhttp3.internal.d.n(socket2);
                        }
                        this.f37806d = null;
                        this.f37805c = null;
                        this.f37810h = null;
                        this.f37811i = null;
                        this.f37807e = null;
                        this.f37808f = null;
                        this.f37809g = null;
                        this.f37817o = 1;
                        eventListener.connectFailed(call, this.f37821s.socketAddress(), this.f37821s.proxy(), null, e);
                        if (jVar == null) {
                            jVar = new j(e);
                        } else {
                            jVar.a(e);
                        }
                        if (z7) {
                            throw jVar;
                        }
                        if (bVar.b(e)) {
                            throw jVar;
                        }
                    }
                }
                try {
                    p(bVar, i10, call, eventListener);
                    eventListener.connectEnd(call, this.f37821s.socketAddress(), this.f37821s.proxy(), this.f37808f);
                    break;
                } catch (IOException e9) {
                    e = e9;
                    socket = this.f37806d;
                    if (socket != null) {
                        okhttp3.internal.d.n(socket);
                    }
                    socket2 = this.f37805c;
                    if (socket2 != null) {
                        okhttp3.internal.d.n(socket2);
                    }
                    this.f37806d = null;
                    this.f37805c = null;
                    this.f37810h = null;
                    this.f37811i = null;
                    this.f37807e = null;
                    this.f37808f = null;
                    this.f37809g = null;
                    this.f37817o = 1;
                    eventListener.connectFailed(call, this.f37821s.socketAddress(), this.f37821s.proxy(), null, e);
                    if (jVar == null) {
                        jVar = new j(e);
                    } else {
                        jVar.a(e);
                    }
                    if (z7) {
                        throw jVar;
                    }
                    if (bVar.b(e)) {
                        throw jVar;
                    }
                }
            } catch (IOException e10) {
                e = e10;
            }
        }
        if (this.f37821s.requiresTunnel() && this.f37805c == null) {
            throw new j(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.f37819q = System.nanoTime();
    }

    public final void j(@a7.d OkHttpClient client, @a7.d Route failedRoute, @a7.d IOException failure) {
        l0.p(client, "client");
        l0.p(failedRoute, "failedRoute");
        l0.p(failure, "failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        client.getRouteDatabase().b(failedRoute);
    }

    @Override // okhttp3.Connection
    @a7.d
    public Protocol protocol() {
        Protocol protocol = this.f37808f;
        l0.m(protocol);
        return protocol;
    }

    @a7.d
    public final List<Reference<e>> q() {
        return this.f37818p;
    }

    @a7.d
    public final h r() {
        return this.f37820r;
    }

    @Override // okhttp3.Connection
    @a7.d
    public Route route() {
        return this.f37821s;
    }

    public final long s() {
        return this.f37819q;
    }

    @Override // okhttp3.Connection
    @a7.d
    public Socket socket() {
        Socket socket = this.f37806d;
        l0.m(socket);
        return socket;
    }

    public final boolean t() {
        return this.f37812j;
    }

    @a7.d
    public String toString() {
        Object objCipherSuite;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f37821s.address().url().host());
        sb.append(':');
        sb.append(this.f37821s.address().url().port());
        sb.append(',');
        sb.append(" proxy=");
        sb.append(this.f37821s.proxy());
        sb.append(" hostAddress=");
        sb.append(this.f37821s.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f37807e;
        if (handshake == null || (objCipherSuite = handshake.cipherSuite()) == null) {
            objCipherSuite = "none";
        }
        sb.append(objCipherSuite);
        sb.append(" protocol=");
        sb.append(this.f37808f);
        sb.append('}');
        return sb.toString();
    }

    public final int u() {
        return this.f37814l;
    }

    public final synchronized void v() {
        this.f37815m++;
    }

    public final boolean w(@a7.d Address address, @a7.e List<Route> list) {
        l0.p(address, "address");
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
        if (this.f37818p.size() >= this.f37817o || this.f37812j || !this.f37821s.address().equalsNonHost$okhttp(address)) {
            return false;
        }
        if (l0.g(address.url().host(), route().address().url().host())) {
            return true;
        }
        if (this.f37809g == null || list == null || !D(list) || address.hostnameVerifier() != u5.d.f40420c || !I(address.url())) {
            return false;
        }
        try {
            CertificatePinner certificatePinner = address.certificatePinner();
            l0.m(certificatePinner);
            String strHost = address.url().host();
            Handshake handshake = handshake();
            l0.m(handshake);
            certificatePinner.check(strHost, handshake.peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean x(boolean z7) {
        long j7;
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
        long jNanoTime = System.nanoTime();
        Socket socket = this.f37805c;
        l0.m(socket);
        Socket socket2 = this.f37806d;
        l0.m(socket2);
        o oVar = this.f37810h;
        l0.m(oVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        okhttp3.internal.http2.f fVar = this.f37809g;
        if (fVar != null) {
            return fVar.w1(jNanoTime);
        }
        synchronized (this) {
            j7 = jNanoTime - this.f37819q;
        }
        if (j7 < f37803v || !z7) {
            return true;
        }
        return okhttp3.internal.d.K(socket2, oVar);
    }

    public final boolean y() {
        return this.f37809g != null;
    }

    @a7.d
    public final okhttp3.internal.http.d z(@a7.d OkHttpClient client, @a7.d okhttp3.internal.http.g chain) throws SocketException {
        l0.p(client, "client");
        l0.p(chain, "chain");
        Socket socket = this.f37806d;
        l0.m(socket);
        o oVar = this.f37810h;
        l0.m(oVar);
        n nVar = this.f37811i;
        l0.m(nVar);
        okhttp3.internal.http2.f fVar = this.f37809g;
        if (fVar != null) {
            return new okhttp3.internal.http2.g(client, this, chain, fVar);
        }
        socket.setSoTimeout(chain.readTimeoutMillis());
        q0 q0VarTimeout = oVar.timeout();
        long jF = chain.f();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        q0VarTimeout.i(jF, timeUnit);
        nVar.timeout().i(chain.h(), timeUnit);
        return new okhttp3.internal.http1.b(client, this, oVar, nVar);
    }
}
