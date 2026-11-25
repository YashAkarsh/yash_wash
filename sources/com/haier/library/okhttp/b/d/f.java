package com.haier.library.okhttp.b.d;

import com.haier.library.okhttp.d0;
import com.haier.library.okhttp.h;
import com.haier.library.okhttp.h0;
import com.haier.library.okhttp.n;
import com.haier.library.okhttp.q;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.haier.library.okhttp.c f27031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f27032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q f27033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d0 f27034d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f27036f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Proxy> f27035e = Collections.emptyList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<InetSocketAddress> f27037g = Collections.emptyList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<h> f27038h = new ArrayList();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<h> f27039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f27040b = 0;

        a(List<h> list) {
            this.f27039a = list;
        }

        public boolean a() {
            return this.f27040b < this.f27039a.size();
        }

        public h b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<h> list = this.f27039a;
            int i7 = this.f27040b;
            this.f27040b = i7 + 1;
            return list.get(i7);
        }

        public List<h> c() {
            return new ArrayList(this.f27039a);
        }
    }

    public f(com.haier.library.okhttp.c cVar, d dVar, q qVar, d0 d0Var) {
        this.f27031a = cVar;
        this.f27032b = dVar;
        this.f27033c = qVar;
        this.f27034d = d0Var;
        c(cVar.a(), cVar.i());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void c(h0 h0Var, Proxy proxy) {
        if (proxy != null) {
            this.f27035e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f27031a.h().select(h0Var.q());
            this.f27035e = (listSelect == null || listSelect.isEmpty()) ? n.d.n(Proxy.NO_PROXY) : n.d.m(listSelect);
        }
        this.f27036f = 0;
    }

    private void d(Proxy proxy) throws IOException {
        String strF;
        int iG;
        this.f27037g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strF = this.f27031a.a().F();
            iG = this.f27031a.a().G();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strF = a(inetSocketAddress);
            iG = inetSocketAddress.getPort();
        }
        if (iG < 1 || iG > 65535) {
            throw new SocketException("No route to " + strF + ":" + iG + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f27037g.add(InetSocketAddress.createUnresolved(strF, iG));
            return;
        }
        this.f27034d.i(this.f27033c, strF);
        List<InetAddress> listA = this.f27031a.c().a(strF);
        if (listA.isEmpty()) {
            throw new UnknownHostException(this.f27031a.c() + " returned no addresses for " + strF);
        }
        this.f27034d.j(this.f27033c, strF, listA);
        int size = listA.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f27037g.add(new InetSocketAddress(listA.get(i7), iG));
        }
    }

    private boolean g() {
        return this.f27036f < this.f27035e.size();
    }

    private Proxy h() throws IOException {
        if (g()) {
            List<Proxy> list = this.f27035e;
            int i7 = this.f27036f;
            this.f27036f = i7 + 1;
            Proxy proxy = list.get(i7);
            d(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f27031a.a().F() + "; exhausted proxy configurations: " + this.f27035e);
    }

    public void b(h hVar, IOException iOException) {
        if (hVar.b().type() != Proxy.Type.DIRECT && this.f27031a.h() != null) {
            this.f27031a.h().connectFailed(this.f27031a.a().q(), hVar.b().address(), iOException);
        }
        this.f27032b.a(hVar);
    }

    public boolean e() {
        return g() || !this.f27038h.isEmpty();
    }

    public a f() throws IOException {
        if (!e()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (g()) {
            Proxy proxyH = h();
            int size = this.f27037g.size();
            for (int i7 = 0; i7 < size; i7++) {
                h hVar = new h(this.f27031a, proxyH, this.f27037g.get(i7));
                if (this.f27032b.c(hVar)) {
                    this.f27038h.add(hVar);
                } else {
                    arrayList.add(hVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f27038h);
            this.f27038h.clear();
        }
        return new a(arrayList);
    }
}
