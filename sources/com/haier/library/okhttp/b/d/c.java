package com.haier.library.okhttp.b.d;

import com.haier.library.a.c0;
import com.haier.library.a.i;
import com.haier.library.a.t;
import com.haier.library.okhttp.d0;
import com.haier.library.okhttp.f0;
import com.haier.library.okhttp.h;
import com.haier.library.okhttp.h0;
import com.haier.library.okhttp.i0;
import com.haier.library.okhttp.j;
import com.haier.library.okhttp.l0;
import com.haier.library.okhttp.n;
import com.haier.library.okhttp.q;
import com.haier.library.okhttp.s;
import com.haier.library.okhttp.v;
import com.haier.library.okhttp.w;
import com.haier.library.okhttp.x;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.haier.library.okhttp.b.g.g.h implements v {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f27010p = "throw with null exception";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f27011q = 21;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w f27012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f27013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Socket f27014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Socket f27015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f0 f27016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.haier.library.okhttp.d f27017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.haier.library.okhttp.b.g.g f27018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private i f27019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.haier.library.a.h f27020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f27021k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f27022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f27023m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Reference<g>> f27024n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f27025o = Long.MAX_VALUE;

    class a extends com.haier.library.okhttp.b.m.a.g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f27026d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z7, i iVar, com.haier.library.a.h hVar, g gVar) {
            super(z7, iVar, hVar);
            this.f27026d = gVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            g gVar = this.f27026d;
            gVar.i(true, gVar.c(), -1L, null);
        }
    }

    public c(w wVar, h hVar) {
        this.f27012b = wVar;
        this.f27013c = hVar;
    }

    private com.haier.library.okhttp.f c(int i7, int i8, com.haier.library.okhttp.f fVar, h0 h0Var) throws IOException {
        String str = "CONNECT " + n.d.h(h0Var, true) + " HTTP/1.1";
        while (true) {
            com.haier.library.okhttp.b.f.a aVar = new com.haier.library.okhttp.b.f.a(null, null, this.f27019i, this.f27020j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f27019i.a().b(i7, timeUnit);
            this.f27020j.a().b(i8, timeUnit);
            aVar.g(fVar.f(), str);
            aVar.b();
            com.haier.library.okhttp.a aVarK = aVar.a(false).f(fVar).k();
            long jD = com.haier.library.okhttp.b.e.e.d(aVarK);
            if (jD == -1) {
                jD = 0;
            }
            c0 c0VarH = aVar.h(jD);
            n.d.F(c0VarH, Integer.MAX_VALUE, timeUnit);
            c0VarH.close();
            int iU = aVarK.u();
            if (iU == 200) {
                if (this.f27019i.c().g() && this.f27020j.c().g()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iU != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + aVarK.u());
            }
            com.haier.library.okhttp.f fVarA = this.f27013c.a().e().a(this.f27013c, aVarK);
            if (fVarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(aVarK.E(com.google.common.net.c.f22160o))) {
                return fVarA;
            }
            fVar = fVarA;
        }
    }

    public static c d(w wVar, h hVar, Socket socket, long j7) {
        c cVar = new c(wVar, hVar);
        cVar.f27015e = socket;
        cVar.f27025o = j7;
        return cVar;
    }

    private void g(int i7) throws IOException {
        this.f27015e.setSoTimeout(0);
        com.haier.library.okhttp.b.g.g gVarF = new com.haier.library.okhttp.b.g.g.C0358g(true).e(this.f27015e, this.f27013c.a().a().F(), this.f27019i, this.f27020j).b(this).a(i7).f();
        this.f27018h = gVarF;
        gVarF.L0();
    }

    private void i(int i7, int i8, int i9, q qVar, d0 d0Var) throws IOException {
        com.haier.library.okhttp.f fVarR = r();
        h0 h0VarA = fVarR.a();
        for (int i10 = 0; i10 < 21; i10++) {
            j(i7, i8, qVar, d0Var);
            fVarR = c(i8, i9, fVarR, h0VarA);
            if (fVarR == null) {
                return;
            }
            n.d.v(this.f27014d);
            this.f27014d = null;
            this.f27020j = null;
            this.f27019i = null;
            d0Var.l(qVar, this.f27013c.c(), this.f27013c.b(), null);
        }
    }

    private void j(int i7, int i8, q qVar, d0 d0Var) throws IOException {
        Proxy proxyB = this.f27013c.b();
        this.f27014d = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? this.f27013c.a().d().createSocket() : new Socket(proxyB);
        d0Var.k(qVar, this.f27013c.c(), proxyB);
        this.f27014d.setSoTimeout(i8);
        try {
            com.haier.library.okhttp.b.i.f.r().j(this.f27014d, this.f27013c.c(), i7);
            try {
                this.f27019i = t.b(t.n(this.f27014d));
                this.f27020j = t.a(t.f(this.f27014d));
            } catch (NullPointerException e8) {
                if (f27010p.equals(e8.getMessage())) {
                    throw new IOException(e8);
                }
            }
        } catch (ConnectException e9) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f27013c.c());
            connectException.initCause(e9);
            throw connectException;
        }
    }

    private void k(b bVar) throws Throwable {
        com.haier.library.okhttp.c cVarA = this.f27013c.a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) cVarA.j().createSocket(this.f27014d, cVarA.a().F(), cVarA.a().G(), true);
                try {
                    x xVarA = bVar.a(sSLSocket2);
                    if (xVarA.g()) {
                        com.haier.library.okhttp.b.i.f.r().k(sSLSocket2, cVarA.a().F(), cVarA.f());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    f0 f0VarC = f0.c(session);
                    if (cVarA.k().verify(cVarA.a().F(), session)) {
                        cVarA.l().e(cVarA.a().F(), f0VarC.e());
                        String strE = xVarA.g() ? com.haier.library.okhttp.b.i.f.r().e(sSLSocket2) : null;
                        this.f27015e = sSLSocket2;
                        this.f27019i = t.b(t.n(sSLSocket2));
                        this.f27020j = t.a(t.f(this.f27015e));
                        this.f27016f = f0VarC;
                        this.f27017g = strE != null ? com.haier.library.okhttp.d.a(strE) : com.haier.library.okhttp.d.HTTP_1_1;
                        com.haier.library.okhttp.b.i.f.r().n(sSLSocket2);
                        return;
                    }
                    List<Certificate> listE = f0VarC.e();
                    if (listE.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + cVarA.a().F() + " not verified (no certificates)");
                    }
                    X509Certificate x509Certificate = (X509Certificate) listE.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + cVarA.a().F() + " not verified:\n    certificate: " + s.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.haier.library.okhttp.b.l.e.a(x509Certificate));
                } catch (AssertionError e8) {
                    e = e8;
                    if (!n.d.x(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.haier.library.okhttp.b.i.f.r().n(sSLSocket);
                    }
                    n.d.v(sSLSocket);
                    throw th;
                }
            } catch (AssertionError e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void l(b bVar, int i7, q qVar, d0 d0Var) throws Throwable {
        if (this.f27013c.a().j() != null) {
            d0Var.n(qVar);
            k(bVar);
            d0Var.g(qVar, this.f27016f);
            if (this.f27017g == com.haier.library.okhttp.d.HTTP_2) {
                g(i7);
                return;
            }
            return;
        }
        List<com.haier.library.okhttp.d> listF = this.f27013c.a().f();
        com.haier.library.okhttp.d dVar = com.haier.library.okhttp.d.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(dVar)) {
            this.f27015e = this.f27014d;
            this.f27017g = com.haier.library.okhttp.d.HTTP_1_1;
        } else {
            this.f27015e = this.f27014d;
            this.f27017g = dVar;
            g(i7);
        }
    }

    private com.haier.library.okhttp.f r() throws IOException {
        com.haier.library.okhttp.f fVarS = new com.haier.library.okhttp.f.a().e(this.f27013c.a().a()).i("CONNECT", null).j(com.google.common.net.c.f22174v, n.d.h(this.f27013c.a().a(), true)).j("Proxy-Connection", "Keep-Alive").j(com.google.common.net.c.M, j.a()).s();
        com.haier.library.okhttp.f fVarA = this.f27013c.a().e().a(this.f27013c, new com.haier.library.okhttp.a.C0352a().f(fVarS).e(com.haier.library.okhttp.d.HTTP_1_1).a(407).i("Preemptive Authenticate").d(n.d.f27688c).b(-1L).m(-1L).j(com.google.common.net.c.f22161o0, "OkHttp-Preemptive").k());
        return fVarA != null ? fVarA : fVarS;
    }

    @Override // com.haier.library.okhttp.v
    public h a() {
        return this.f27013c;
    }

    @Override // com.haier.library.okhttp.v
    public Socket b() {
        return this.f27015e;
    }

    public com.haier.library.okhttp.b.e.c e(l0 l0Var, i0.a aVar, g gVar) throws SocketException {
        if (this.f27018h != null) {
            return new com.haier.library.okhttp.b.g.f(l0Var, aVar, gVar, this.f27018h);
        }
        this.f27015e.setSoTimeout(aVar.K());
        com.haier.library.a.d0 d0VarA = this.f27019i.a();
        long jK = aVar.K();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        d0VarA.b(jK, timeUnit);
        this.f27020j.a().b(aVar.f(), timeUnit);
        return new com.haier.library.okhttp.b.f.a(l0Var, gVar, this.f27019i, this.f27020j);
    }

    public com.haier.library.okhttp.b.m.a.g f(g gVar) {
        return new a(true, this.f27019i, this.f27020j, gVar);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x012f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0135  */
    /* JADX WARN: Code duplicated, block: B:58:0x013a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[LOOP:0: B:66:0x0088->B:78:?, LOOP_END, SYNTHETIC] */
    public void h(int i7, int i8, int i9, int i10, boolean z7, q qVar, d0 d0Var) throws Throwable {
        if (this.f27017g != null) {
            throw new IllegalStateException("already connected");
        }
        List<x> listG = this.f27013c.a().g();
        b bVar = new b(listG);
        if (this.f27013c.a().j() == null) {
            if (!listG.contains(x.f27888j)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strF = this.f27013c.a().a().F();
            if (!com.haier.library.okhttp.b.i.f.r().p(strF)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication to " + strF + " not permitted by network security policy"));
            }
        } else if (this.f27013c.a().f().contains(com.haier.library.okhttp.d.H2_PRIOR_KNOWLEDGE)) {
            throw new e(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        e eVar = null;
        while (true) {
            try {
                if (this.f27013c.d()) {
                    i(i7, i8, i9, qVar, d0Var);
                    if (this.f27014d == null) {
                        break;
                    }
                } else {
                    try {
                        j(i7, i8, qVar, d0Var);
                    } catch (IOException e8) {
                        e = e8;
                        n.d.v(this.f27015e);
                        n.d.v(this.f27014d);
                        this.f27015e = null;
                        this.f27014d = null;
                        this.f27019i = null;
                        this.f27020j = null;
                        this.f27016f = null;
                        this.f27017g = null;
                        this.f27018h = null;
                        d0Var.m(qVar, this.f27013c.c(), this.f27013c.b(), null, e);
                        if (eVar == null) {
                            eVar = new e(e);
                        } else {
                            eVar.b(e);
                        }
                        if (z7) {
                            throw eVar;
                        }
                        if (bVar.b(e)) {
                            throw eVar;
                        }
                    }
                }
                try {
                    l(bVar, i10, qVar, d0Var);
                    d0Var.l(qVar, this.f27013c.c(), this.f27013c.b(), this.f27017g);
                    break;
                } catch (IOException e9) {
                    e = e9;
                    n.d.v(this.f27015e);
                    n.d.v(this.f27014d);
                    this.f27015e = null;
                    this.f27014d = null;
                    this.f27019i = null;
                    this.f27020j = null;
                    this.f27016f = null;
                    this.f27017g = null;
                    this.f27018h = null;
                    d0Var.m(qVar, this.f27013c.c(), this.f27013c.b(), null, e);
                    if (eVar == null) {
                        eVar = new e(e);
                    } else {
                        eVar.b(e);
                    }
                    if (z7) {
                        throw eVar;
                    }
                    if (bVar.b(e)) {
                        throw eVar;
                    }
                }
            } catch (IOException e10) {
                e = e10;
            }
        }
        if (this.f27013c.d() && this.f27014d == null) {
            throw new e(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.f27018h != null) {
            synchronized (this.f27012b) {
                this.f27023m = this.f27018h.r0();
            }
        }
    }

    public boolean m(com.haier.library.okhttp.c cVar, @Nullable h hVar) {
        if (this.f27024n.size() >= this.f27023m || this.f27021k || !n.b.f27684a.m(this.f27013c.a(), cVar)) {
            return false;
        }
        if (cVar.a().F().equals(a().a().a().F())) {
            return true;
        }
        if (this.f27018h == null || hVar == null || hVar.b().type() != Proxy.Type.DIRECT || this.f27013c.b().type() != Proxy.Type.DIRECT || !this.f27013c.c().equals(hVar.c()) || hVar.a().k() != com.haier.library.okhttp.b.l.e.f27402a || !n(cVar.a())) {
            return false;
        }
        try {
            cVar.l().e(cVar.a().F(), c().e());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean n(h0 h0Var) {
        if (h0Var.G() != this.f27013c.a().a().G()) {
            return false;
        }
        if (h0Var.F().equals(this.f27013c.a().a().F())) {
            return true;
        }
        return this.f27016f != null && com.haier.library.okhttp.b.l.e.f27402a.d(h0Var.F(), (X509Certificate) this.f27016f.e().get(0));
    }

    public boolean o(boolean z7) {
        if (this.f27015e.isClosed() || this.f27015e.isInputShutdown() || this.f27015e.isOutputShutdown()) {
            return false;
        }
        com.haier.library.okhttp.b.g.g gVar = this.f27018h;
        if (gVar != null) {
            return !gVar.Q0();
        }
        if (z7) {
            try {
                int soTimeout = this.f27015e.getSoTimeout();
                try {
                    this.f27015e.setSoTimeout(1);
                    if (this.f27019i.g()) {
                        this.f27015e.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.f27015e.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.f27015e.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public void p() {
        n.d.v(this.f27014d);
    }

    public boolean q() {
        return this.f27018h != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f27013c.a().a().F());
        sb.append(":");
        sb.append(this.f27013c.a().a().G());
        sb.append(", proxy=");
        sb.append(this.f27013c.b());
        sb.append(" hostAddress=");
        sb.append(this.f27013c.c());
        sb.append(" cipherSuite=");
        f0 f0Var = this.f27016f;
        sb.append(f0Var != null ? f0Var.d() : "none");
        sb.append(" protocol=");
        sb.append(this.f27017g);
        sb.append('}');
        return sb.toString();
    }

    @Override // com.haier.library.okhttp.b.g.g.h
    public void a(com.haier.library.okhttp.b.g.g gVar) {
        synchronized (this.f27012b) {
            this.f27023m = gVar.r0();
        }
    }

    @Override // com.haier.library.okhttp.b.g.g.h
    public void b(com.haier.library.okhttp.b.g.i iVar) throws IOException {
        iVar.e(com.haier.library.okhttp.b.g.b.REFUSED_STREAM);
    }

    @Override // com.haier.library.okhttp.v
    public com.haier.library.okhttp.d d() {
        return this.f27017g;
    }

    @Override // com.haier.library.okhttp.v
    public f0 c() {
        return this.f27016f;
    }
}
