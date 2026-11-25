package com.haier.library.okhttp;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class l0 implements k.a, q.a, Cloneable {
    static final List<d> C = n.d.n(d.HTTP_2, d.HTTP_1_1);
    static final List<x> D = n.d.n(x.f27886h, x.f27888j);
    final int A;
    final int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b0 f27631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    final Proxy f27632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<d> f27633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List<x> f27634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<i0> f27635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<i0> f27636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final d0.c f27637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final ProxySelector f27638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final z f27639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    final o f27640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    final com.haier.library.okhttp.b.b.f f27641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final SocketFactory f27642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final SSLSocketFactory f27643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final com.haier.library.okhttp.b.l.c f27644n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final HostnameVerifier f27645o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final s f27646p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final n f27647q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final n f27648r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final w f27649s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final c0 f27650t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final boolean f27651u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final boolean f27652v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final boolean f27653w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final int f27654x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final int f27655y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final int f27656z;

    static class a extends n.b {
        a() {
        }

        @Override // com.haier.library.okhttp.n.b
        public int a(com.haier.library.okhttp.a.C0352a c0352a) {
            return c0352a.f26891c;
        }

        @Override // com.haier.library.okhttp.n.b
        public com.haier.library.okhttp.b.d.c b(w wVar, c cVar, com.haier.library.okhttp.b.d.g gVar, h hVar) {
            return wVar.d(cVar, gVar, hVar);
        }

        @Override // com.haier.library.okhttp.n.b
        public com.haier.library.okhttp.b.d.d c(w wVar) {
            return wVar.f27880e;
        }

        @Override // com.haier.library.okhttp.n.b
        public com.haier.library.okhttp.b.d.g d(q qVar) {
            return ((e) qVar).h();
        }

        @Override // com.haier.library.okhttp.n.b
        public q e(l0 l0Var, f fVar) {
            return e.a(l0Var, fVar, true);
        }

        @Override // com.haier.library.okhttp.n.b
        @Nullable
        public IOException f(q qVar, @Nullable IOException iOException) {
            return ((e) qVar).c(iOException);
        }

        @Override // com.haier.library.okhttp.n.b
        public Socket g(w wVar, c cVar, com.haier.library.okhttp.b.d.g gVar) {
            return wVar.e(cVar, gVar);
        }

        @Override // com.haier.library.okhttp.n.b
        public void i(x xVar, SSLSocket sSLSocket, boolean z7) {
            xVar.a(sSLSocket, z7);
        }

        @Override // com.haier.library.okhttp.n.b
        public void j(g0.a aVar, String str) {
            aVar.b(str);
        }

        @Override // com.haier.library.okhttp.n.b
        public void k(g0.a aVar, String str, String str2) {
            aVar.j(str, str2);
        }

        @Override // com.haier.library.okhttp.n.b
        public void l(b bVar, com.haier.library.okhttp.b.b.f fVar) {
            bVar.v(fVar);
        }

        @Override // com.haier.library.okhttp.n.b
        public boolean m(c cVar, c cVar2) {
            return cVar.b(cVar2);
        }

        @Override // com.haier.library.okhttp.n.b
        public boolean n(w wVar, com.haier.library.okhttp.b.d.c cVar) {
            return wVar.h(cVar);
        }

        @Override // com.haier.library.okhttp.n.b
        public boolean o(IllegalArgumentException illegalArgumentException) {
            return illegalArgumentException.getMessage().startsWith(HttpUrl.Builder.INVALID_HOST);
        }

        @Override // com.haier.library.okhttp.n.b
        public void p(w wVar, com.haier.library.okhttp.b.d.c cVar) {
            wVar.f(cVar);
        }
    }

    static {
        n.b.f27684a = new a();
    }

    public l0() {
        this(new b());
    }

    private static SSLSocketFactory j(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextM = com.haier.library.okhttp.b.i.f.r().m();
            sSLContextM.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextM.getSocketFactory();
        } catch (GeneralSecurityException e8) {
            throw n.d.g("No System TLS", e8);
        }
    }

    public w A() {
        return this.f27649s;
    }

    public boolean B() {
        return this.f27651u;
    }

    public boolean C() {
        return this.f27652v;
    }

    public boolean D() {
        return this.f27653w;
    }

    public b0 E() {
        return this.f27631a;
    }

    public List<d> F() {
        return this.f27633c;
    }

    public List<x> G() {
        return this.f27634d;
    }

    public List<i0> H() {
        return this.f27635e;
    }

    public List<i0> I() {
        return this.f27636f;
    }

    @Override // com.haier.library.okhttp.q.a
    public q a(f fVar) {
        return e.a(this, fVar, false);
    }

    @Override // com.haier.library.okhttp.k.a
    public k b(f fVar, l lVar) {
        com.haier.library.okhttp.b.m.a aVar = new com.haier.library.okhttp.b.m.a(fVar, lVar, new Random(), this.B);
        aVar.i(this);
        return aVar;
    }

    public d0.c e() {
        return this.f27637g;
    }

    public b h() {
        return new b(this);
    }

    public int i() {
        return this.f27654x;
    }

    public int k() {
        return this.f27655y;
    }

    public int l() {
        return this.f27656z;
    }

    public int m() {
        return this.A;
    }

    public int n() {
        return this.B;
    }

    @Nullable
    public Proxy o() {
        return this.f27632b;
    }

    public ProxySelector p() {
        return this.f27638h;
    }

    public z q() {
        return this.f27639i;
    }

    @Nullable
    public o r() {
        return this.f27640j;
    }

    com.haier.library.okhttp.b.b.f s() {
        o oVar = this.f27640j;
        return oVar != null ? oVar.f27731a : this.f27641k;
    }

    public c0 t() {
        return this.f27650t;
    }

    public SocketFactory u() {
        return this.f27642l;
    }

    public SSLSocketFactory v() {
        return this.f27643m;
    }

    public HostnameVerifier w() {
        return this.f27645o;
    }

    public s x() {
        return this.f27646p;
    }

    public n y() {
        return this.f27648r;
    }

    public n z() {
        return this.f27647q;
    }

    l0(b bVar) {
        boolean z7;
        this.f27631a = bVar.f27657a;
        this.f27632b = bVar.f27658b;
        this.f27633c = bVar.f27659c;
        List<x> list = bVar.f27660d;
        this.f27634d = list;
        this.f27635e = n.d.m(bVar.f27661e);
        this.f27636f = n.d.m(bVar.f27662f);
        this.f27637g = bVar.f27663g;
        this.f27638h = bVar.f27664h;
        this.f27639i = bVar.f27665i;
        this.f27640j = bVar.f27666j;
        this.f27641k = bVar.f27667k;
        this.f27642l = bVar.f27668l;
        Iterator<x> it = list.iterator();
        loop0: while (true) {
            z7 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z7 = (z7 || it.next().b()) ? true : z7;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f27669m;
        if (sSLSocketFactory == null && z7) {
            X509TrustManager x509TrustManagerQ = n.d.q();
            this.f27643m = j(x509TrustManagerQ);
            this.f27644n = com.haier.library.okhttp.b.l.c.a(x509TrustManagerQ);
        } else {
            this.f27643m = sSLSocketFactory;
            this.f27644n = bVar.f27670n;
        }
        if (this.f27643m != null) {
            com.haier.library.okhttp.b.i.f.r().o(this.f27643m);
        }
        this.f27645o = bVar.f27671o;
        this.f27646p = bVar.f27672p.b(this.f27644n);
        this.f27647q = bVar.f27673q;
        this.f27648r = bVar.f27674r;
        this.f27649s = bVar.f27675s;
        this.f27650t = bVar.f27676t;
        this.f27651u = bVar.f27677u;
        this.f27652v = bVar.f27678v;
        this.f27653w = bVar.f27679w;
        this.f27654x = bVar.f27680x;
        this.f27655y = bVar.f27681y;
        this.f27656z = bVar.f27682z;
        this.A = bVar.A;
        this.B = bVar.B;
        if (this.f27635e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f27635e);
        }
        if (this.f27636f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f27636f);
        }
    }

    public static final class b {
        int A;
        int B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b0 f27657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        Proxy f27658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<d> f27659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<x> f27660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final List<i0> f27661e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<i0> f27662f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        d0.c f27663g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ProxySelector f27664h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        z f27665i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        o f27666j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        com.haier.library.okhttp.b.b.f f27667k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        SocketFactory f27668l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        SSLSocketFactory f27669m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        com.haier.library.okhttp.b.l.c f27670n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        HostnameVerifier f27671o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        s f27672p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        n f27673q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        n f27674r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        w f27675s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        c0 f27676t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f27677u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f27678v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f27679w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int f27680x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f27681y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int f27682z;

        public b() {
            this.f27661e = new ArrayList();
            this.f27662f = new ArrayList();
            this.f27657a = new b0();
            this.f27659c = l0.C;
            this.f27660d = l0.D;
            this.f27663g = d0.a(d0.f27521a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f27664h = proxySelector;
            if (proxySelector == null) {
                this.f27664h = new k3.a();
            }
            this.f27665i = z.f27919a;
            this.f27668l = SocketFactory.getDefault();
            this.f27671o = com.haier.library.okhttp.b.l.e.f27402a;
            this.f27672p = s.f27792c;
            n nVar = n.f27683a;
            this.f27673q = nVar;
            this.f27674r = nVar;
            this.f27675s = new w();
            this.f27676t = c0.f27512a;
            this.f27677u = true;
            this.f27678v = true;
            this.f27679w = true;
            this.f27680x = 0;
            this.f27681y = com.haier.library.sumhttp.plugin.h.f27948e;
            this.f27682z = com.haier.library.sumhttp.plugin.h.f27948e;
            this.A = com.haier.library.sumhttp.plugin.h.f27948e;
            this.B = 0;
        }

        public b A(List<x> list) {
            this.f27660d = n.d.m(list);
            return this;
        }

        public b B(boolean z7) {
            this.f27678v = z7;
            return this;
        }

        public List<i0> C() {
            return this.f27662f;
        }

        public b D(long j7, TimeUnit timeUnit) {
            this.f27682z = n.d.e(com.alipay.sdk.data.a.f13674p, j7, timeUnit);
            return this;
        }

        @z6.a
        public b E(Duration duration) {
            this.f27682z = n.d.e(com.alipay.sdk.data.a.f13674p, duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public b F(boolean z7) {
            this.f27679w = z7;
            return this;
        }

        public l0 G() {
            return new l0(this);
        }

        public b H(long j7, TimeUnit timeUnit) {
            this.A = n.d.e(com.alipay.sdk.data.a.f13674p, j7, timeUnit);
            return this;
        }

        @z6.a
        public b I(Duration duration) {
            this.A = n.d.e(com.alipay.sdk.data.a.f13674p, duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public b J(long j7, TimeUnit timeUnit) {
            this.B = n.d.e("interval", j7, timeUnit);
            return this;
        }

        @z6.a
        public b K(Duration duration) {
            this.B = n.d.e(com.alipay.sdk.data.a.f13674p, duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public b a(long j7, TimeUnit timeUnit) {
            this.f27680x = n.d.e(com.alipay.sdk.data.a.f13674p, j7, timeUnit);
            return this;
        }

        public b b(n nVar) {
            if (nVar == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.f27674r = nVar;
            return this;
        }

        public b c(@Nullable o oVar) {
            this.f27666j = oVar;
            this.f27667k = null;
            return this;
        }

        public b d(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.f27672p = sVar;
            return this;
        }

        public b e(w wVar) {
            if (wVar == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.f27675s = wVar;
            return this;
        }

        public b f(z zVar) {
            if (zVar == null) {
                throw new NullPointerException("cookieJar == null");
            }
            this.f27665i = zVar;
            return this;
        }

        public b g(b0 b0Var) {
            if (b0Var == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.f27657a = b0Var;
            return this;
        }

        public b h(c0 c0Var) {
            if (c0Var == null) {
                throw new NullPointerException("dns == null");
            }
            this.f27676t = c0Var;
            return this;
        }

        public b i(d0.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("eventListenerFactory == null");
            }
            this.f27663g = cVar;
            return this;
        }

        public b j(d0 d0Var) {
            if (d0Var == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.f27663g = d0.a(d0Var);
            return this;
        }

        public b k(i0 i0Var) {
            if (i0Var == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f27661e.add(i0Var);
            return this;
        }

        public b l(@Nullable Proxy proxy) {
            this.f27658b = proxy;
            return this;
        }

        public b m(ProxySelector proxySelector) {
            if (proxySelector == null) {
                throw new NullPointerException("proxySelector == null");
            }
            this.f27664h = proxySelector;
            return this;
        }

        @z6.a
        public b n(Duration duration) {
            this.f27680x = n.d.e(com.alipay.sdk.data.a.f13674p, duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public b o(List<d> list) {
            ArrayList arrayList = new ArrayList(list);
            d dVar = d.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(dVar) && !arrayList.contains(d.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(dVar) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(d.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(d.SPDY_3);
            this.f27659c = Collections.unmodifiableList(arrayList);
            return this;
        }

        public b p(SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new NullPointerException("socketFactory == null");
            }
            this.f27668l = socketFactory;
            return this;
        }

        public b q(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.f27671o = hostnameVerifier;
            return this;
        }

        public b r(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.f27669m = sSLSocketFactory;
            this.f27670n = com.haier.library.okhttp.b.i.f.r().s(sSLSocketFactory);
            return this;
        }

        public b s(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.f27669m = sSLSocketFactory;
            this.f27670n = com.haier.library.okhttp.b.l.c.a(x509TrustManager);
            return this;
        }

        public b t(boolean z7) {
            this.f27677u = z7;
            return this;
        }

        public List<i0> u() {
            return this.f27661e;
        }

        void v(@Nullable com.haier.library.okhttp.b.b.f fVar) {
            this.f27667k = fVar;
            this.f27666j = null;
        }

        public b w(long j7, TimeUnit timeUnit) {
            this.f27681y = n.d.e(com.alipay.sdk.data.a.f13674p, j7, timeUnit);
            return this;
        }

        public b x(n nVar) {
            if (nVar == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.f27673q = nVar;
            return this;
        }

        public b y(i0 i0Var) {
            if (i0Var == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f27662f.add(i0Var);
            return this;
        }

        @z6.a
        public b z(Duration duration) {
            this.f27681y = n.d.e(com.alipay.sdk.data.a.f13674p, duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        b(l0 l0Var) {
            ArrayList arrayList = new ArrayList();
            this.f27661e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f27662f = arrayList2;
            this.f27657a = l0Var.f27631a;
            this.f27658b = l0Var.f27632b;
            this.f27659c = l0Var.f27633c;
            this.f27660d = l0Var.f27634d;
            arrayList.addAll(l0Var.f27635e);
            arrayList2.addAll(l0Var.f27636f);
            this.f27663g = l0Var.f27637g;
            this.f27664h = l0Var.f27638h;
            this.f27665i = l0Var.f27639i;
            this.f27667k = l0Var.f27641k;
            this.f27666j = l0Var.f27640j;
            this.f27668l = l0Var.f27642l;
            this.f27669m = l0Var.f27643m;
            this.f27670n = l0Var.f27644n;
            this.f27671o = l0Var.f27645o;
            this.f27672p = l0Var.f27646p;
            this.f27673q = l0Var.f27647q;
            this.f27674r = l0Var.f27648r;
            this.f27675s = l0Var.f27649s;
            this.f27676t = l0Var.f27650t;
            this.f27677u = l0Var.f27651u;
            this.f27678v = l0Var.f27652v;
            this.f27679w = l0Var.f27653w;
            this.f27680x = l0Var.f27654x;
            this.f27681y = l0Var.f27655y;
            this.f27682z = l0Var.f27656z;
            this.A = l0Var.A;
            this.B = l0Var.B;
        }
    }
}
