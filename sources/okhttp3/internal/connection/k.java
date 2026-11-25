package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.d0;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.w;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f37840i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<? extends Proxy> f37841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f37842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<? extends InetSocketAddress> f37843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Route> f37844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Address f37845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f37846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Call f37847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final EventListener f37848h;

    public static final class a {
        private a() {
        }

        @a7.d
        public final String a(@a7.d InetSocketAddress socketHost) {
            l0.p(socketHost, "$this$socketHost");
            InetAddress address = socketHost.getAddress();
            if (address != null) {
                String hostAddress = address.getHostAddress();
                l0.o(hostAddress, "address.hostAddress");
                return hostAddress;
            }
            String hostName = socketHost.getHostName();
            l0.o(hostName, "hostName");
            return hostName;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f37849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final List<Route> f37850b;

        public b(@a7.d List<Route> routes) {
            l0.p(routes, "routes");
            this.f37850b = routes;
        }

        @a7.d
        public final List<Route> a() {
            return this.f37850b;
        }

        public final boolean b() {
            return this.f37849a < this.f37850b.size();
        }

        @a7.d
        public final Route c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<Route> list = this.f37850b;
            int i7 = this.f37849a;
            this.f37849a = i7 + 1;
            return list.get(i7);
        }
    }

    static final class c extends n0 implements i5.a<List<? extends Proxy>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Proxy f37852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ HttpUrl f37853c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Proxy proxy, HttpUrl httpUrl) {
            super(0);
            this.f37852b = proxy;
            this.f37853c = httpUrl;
        }

        @Override // i5.a
        @a7.d
        public final List<? extends Proxy> invoke() {
            Proxy proxy = this.f37852b;
            if (proxy != null) {
                return x.l(proxy);
            }
            URI uri = this.f37853c.uri();
            if (uri.getHost() == null) {
                return okhttp3.internal.d.z(Proxy.NO_PROXY);
            }
            List<Proxy> listSelect = k.this.f37845e.proxySelector().select(uri);
            return listSelect == null || listSelect.isEmpty() ? okhttp3.internal.d.z(Proxy.NO_PROXY) : okhttp3.internal.d.c0(listSelect);
        }
    }

    public k(@a7.d Address address, @a7.d i routeDatabase, @a7.d Call call, @a7.d EventListener eventListener) {
        l0.p(address, "address");
        l0.p(routeDatabase, "routeDatabase");
        l0.p(call, "call");
        l0.p(eventListener, "eventListener");
        this.f37845e = address;
        this.f37846f = routeDatabase;
        this.f37847g = call;
        this.f37848h = eventListener;
        this.f37841a = y.F();
        this.f37843c = y.F();
        this.f37844d = new ArrayList();
        g(address.url(), address.proxy());
    }

    private final boolean c() {
        return this.f37842b < this.f37841a.size();
    }

    private final Proxy e() throws IOException {
        if (c()) {
            List<? extends Proxy> list = this.f37841a;
            int i7 = this.f37842b;
            this.f37842b = i7 + 1;
            Proxy proxy = list.get(i7);
            f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f37845e.url().host() + "; exhausted proxy configurations: " + this.f37841a);
    }

    private final void f(Proxy proxy) throws IOException {
        String strHost;
        int iPort;
        ArrayList arrayList = new ArrayList();
        this.f37843c = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strHost = this.f37845e.url().host();
            iPort = this.f37845e.url().port();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strHost = f37840i.a(inetSocketAddress);
            iPort = inetSocketAddress.getPort();
        }
        if (1 > iPort || 65535 < iPort) {
            throw new SocketException("No route to " + strHost + ':' + iPort + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(strHost, iPort));
            return;
        }
        this.f37848h.dnsStart(this.f37847g, strHost);
        List<InetAddress> listLookup = this.f37845e.dns().lookup(strHost);
        if (listLookup.isEmpty()) {
            throw new UnknownHostException(this.f37845e.dns() + " returned no addresses for " + strHost);
        }
        this.f37848h.dnsEnd(this.f37847g, strHost, listLookup);
        Iterator<InetAddress> it = listLookup.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress(it.next(), iPort));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g(HttpUrl httpUrl, Proxy proxy) {
        c cVar = new c(proxy, httpUrl);
        this.f37848h.proxySelectStart(this.f37847g, httpUrl);
        List<? extends Proxy> listInvoke = cVar.invoke();
        this.f37841a = listInvoke;
        this.f37842b = 0;
        this.f37848h.proxySelectEnd(this.f37847g, httpUrl, listInvoke);
    }

    public final boolean b() {
        return c() || (this.f37844d.isEmpty() ^ true);
    }

    @a7.d
    public final b d() throws IOException {
        if (!b()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy proxyE = e();
            Iterator<? extends InetSocketAddress> it = this.f37843c.iterator();
            while (it.hasNext()) {
                Route route = new Route(this.f37845e, proxyE, it.next());
                if (this.f37846f.c(route)) {
                    this.f37844d.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            d0.o0(arrayList, this.f37844d);
            this.f37844d.clear();
        }
        return new b(arrayList);
    }
}
