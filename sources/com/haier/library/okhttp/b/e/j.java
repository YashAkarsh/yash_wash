package com.haier.library.okhttp.b.e;

import com.haier.library.okhttp.d0;
import com.haier.library.okhttp.h0;
import com.haier.library.okhttp.i0;
import com.haier.library.okhttp.l0;
import com.haier.library.okhttp.n;
import com.haier.library.okhttp.q;
import com.haier.library.okhttp.s;
import com.haier.uhome.account.api.Const;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements i0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f27082f = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l0 f27083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f27084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile com.haier.library.okhttp.b.d.g f27085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f27086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f27087e;

    public j(l0 l0Var, boolean z7) {
        this.f27083a = l0Var;
        this.f27084b = z7;
    }

    private int b(com.haier.library.okhttp.a aVar, int i7) {
        String strE = aVar.E(com.google.common.net.c.f22165q0);
        if (strE == null) {
            return i7;
        }
        if (strE.matches("\\d+")) {
            return Integer.valueOf(strE).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private com.haier.library.okhttp.c c(h0 h0Var) {
        SSLSocketFactory sSLSocketFactoryV;
        HostnameVerifier hostnameVerifierW;
        s sVarX;
        if (h0Var.w()) {
            sSLSocketFactoryV = this.f27083a.v();
            hostnameVerifierW = this.f27083a.w();
            sVarX = this.f27083a.x();
        } else {
            sSLSocketFactoryV = null;
            hostnameVerifierW = null;
            sVarX = null;
        }
        return new com.haier.library.okhttp.c(h0Var.F(), h0Var.G(), this.f27083a.t(), this.f27083a.u(), sSLSocketFactoryV, hostnameVerifierW, sVarX, this.f27083a.z(), this.f27083a.o(), this.f27083a.F(), this.f27083a.G(), this.f27083a.p());
    }

    private com.haier.library.okhttp.f d(com.haier.library.okhttp.a aVar, com.haier.library.okhttp.h hVar) throws IOException {
        String strE;
        h0 h0VarX;
        if (aVar == null) {
            throw new IllegalStateException();
        }
        int iU = aVar.u();
        String strD = aVar.v0().d();
        if (iU == 307 || iU == 308) {
            if (!strD.equals(Const.HTTP_REQUEST_TYPE_GET) && !strD.equals("HEAD")) {
                return null;
            }
        } else {
            if (iU == 401) {
                return this.f27083a.y().a(hVar, aVar);
            }
            if (iU == 503) {
                if ((aVar.p0() == null || aVar.p0().u() != 503) && b(aVar, Integer.MAX_VALUE) == 0) {
                    return aVar.v0();
                }
                return null;
            }
            if (iU == 407) {
                if (hVar.b().type() == Proxy.Type.HTTP) {
                    return this.f27083a.z().a(hVar, aVar);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iU == 408) {
                if (!this.f27083a.D() || (aVar.v0().g() instanceof l)) {
                    return null;
                }
                if ((aVar.p0() == null || aVar.p0().u() != 408) && b(aVar, 0) <= 0) {
                    return aVar.v0();
                }
                return null;
            }
            switch (iU) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f27083a.C() || (strE = aVar.E(com.google.common.net.c.f22157m0)) == null || (h0VarX = aVar.v0().a().x(strE)) == null) {
            return null;
        }
        if (!h0VarX.t().equals(aVar.v0().a().t()) && !this.f27083a.B()) {
            return null;
        }
        com.haier.library.okhttp.f.a aVarI = aVar.v0().i();
        if (f.c(strD)) {
            boolean zD = f.d(strD);
            if (f.e(strD)) {
                aVarI.i(Const.HTTP_REQUEST_TYPE_GET, null);
            } else {
                aVarI.i(strD, zD ? aVar.v0().g() : null);
            }
            if (!zD) {
                aVarI.n(com.google.common.net.c.f22183z0);
                aVarI.n(com.google.common.net.c.f22134b);
                aVarI.n("Content-Type");
            }
        }
        if (!g(aVar, h0VarX)) {
            aVarI.n(com.google.common.net.c.f22158n);
        }
        return aVarI.e(h0VarX).s();
    }

    private boolean g(com.haier.library.okhttp.a aVar, h0 h0Var) {
        h0 h0VarA = aVar.v0().a();
        return h0VarA.F().equals(h0Var.F()) && h0VarA.G() == h0Var.G() && h0VarA.t().equals(h0Var.t());
    }

    private boolean h(IOException iOException, com.haier.library.okhttp.f fVar) {
        return (fVar.g() instanceof l) || (iOException instanceof FileNotFoundException);
    }

    private boolean i(IOException iOException, com.haier.library.okhttp.b.d.g gVar, boolean z7, com.haier.library.okhttp.f fVar) {
        gVar.h(iOException);
        if (this.f27083a.D()) {
            return !(z7 && h(iOException, fVar)) && j(iOException, z7) && gVar.p();
        }
        return false;
    }

    private boolean j(IOException iOException, boolean z7) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z7;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    @Override // com.haier.library.okhttp.i0
    public com.haier.library.okhttp.a a(i0.a aVar) throws IOException {
        com.haier.library.okhttp.f fVarA = aVar.a();
        g gVar = (g) aVar;
        q qVarC = gVar.c();
        d0 d0VarI = gVar.i();
        com.haier.library.okhttp.b.d.g gVar2 = new com.haier.library.okhttp.b.d.g(this.f27083a.A(), c(fVarA.a()), qVarC, d0VarI, this.f27086d);
        this.f27085c = gVar2;
        int i7 = 0;
        com.haier.library.okhttp.a aVar2 = null;
        while (!this.f27087e) {
            try {
                try {
                    com.haier.library.okhttp.a aVarE = gVar.e(fVarA, gVar2, null, null);
                    if (aVar2 != null) {
                        aVarE = aVarE.l0().q(aVar2.l0().d(null).k()).k();
                    }
                    try {
                        com.haier.library.okhttp.f fVarD = d(aVarE, gVar2.j());
                        if (fVarD == null) {
                            gVar2.m();
                            return aVarE;
                        }
                        n.d.s(aVarE.b());
                        int i8 = i7 + 1;
                        if (i8 > 20) {
                            gVar2.m();
                            throw new ProtocolException("Too many follow-up requests: " + i8);
                        }
                        if (fVarD.g() instanceof l) {
                            gVar2.m();
                            throw new HttpRetryException("Cannot retry streamed HTTP body", aVarE.u());
                        }
                        if (!g(aVarE, fVarD.a())) {
                            gVar2.m();
                            gVar2 = new com.haier.library.okhttp.b.d.g(this.f27083a.A(), c(fVarD.a()), qVarC, d0VarI, this.f27086d);
                            this.f27085c = gVar2;
                        } else if (gVar2.c() != null) {
                            throw new IllegalStateException("Closing the body of " + aVarE + " didn't close its backing stream. Bad interceptor?");
                        }
                        aVar2 = aVarE;
                        fVarA = fVarD;
                        i7 = i8;
                    } catch (IOException e8) {
                        gVar2.m();
                        throw e8;
                    }
                } catch (com.haier.library.okhttp.b.d.e e9) {
                    if (!i(e9.c(), gVar2, false, fVarA)) {
                        throw e9.a();
                    }
                } catch (IOException e10) {
                    if (!i(e10, gVar2, !(e10 instanceof com.haier.library.okhttp.b.g.a), fVarA)) {
                        throw e10;
                    }
                }
            } catch (Throwable th) {
                gVar2.h(null);
                gVar2.m();
                throw th;
            }
        }
        gVar2.m();
        throw new IOException("Canceled");
    }

    public void e() {
        this.f27087e = true;
        com.haier.library.okhttp.b.d.g gVar = this.f27085c;
        if (gVar != null) {
            gVar.o();
        }
    }

    public void f(Object obj) {
        this.f27086d = obj;
    }

    public boolean k() {
        return this.f27087e;
    }

    public com.haier.library.okhttp.b.d.g l() {
        return this.f27085c;
    }
}
