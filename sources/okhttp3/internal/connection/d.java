package okhttp3.internal.connection;

import com.haier.uhome.account.api.Const;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.http2.n;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k.b f37768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f37769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f37770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Route f37773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h f37774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private final Address f37775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e f37776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final EventListener f37777j;

    public d(@a7.d h connectionPool, @a7.d Address address, @a7.d e call, @a7.d EventListener eventListener) {
        l0.p(connectionPool, "connectionPool");
        l0.p(address, "address");
        l0.p(call, "call");
        l0.p(eventListener, "eventListener");
        this.f37774g = connectionPool;
        this.f37775h = address;
        this.f37776i = call;
        this.f37777j = eventListener;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0136  */
    /* JADX WARN: Code duplicated, block: B:60:0x0150  */
    /* JADX WARN: Code duplicated, block: B:77:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final f b(int i7, int i8, int i9, int i10, boolean z7) throws IOException {
        List<Route> listA;
        f fVar;
        Socket socketX;
        if (this.f37776i.isCanceled()) {
            throw new IOException("Canceled");
        }
        f fVarM = this.f37776i.m();
        if (fVarM != null) {
            synchronized (fVarM) {
                socketX = (fVarM.t() || !g(fVarM.route().address().url())) ? this.f37776i.x() : null;
                l2 l2Var = l2.f34958a;
            }
            if (this.f37776i.m() != null) {
                if (socketX == null) {
                    return fVarM;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            if (socketX != null) {
                okhttp3.internal.d.n(socketX);
            }
            this.f37777j.connectionReleased(this.f37776i, fVarM);
        }
        this.f37770c = 0;
        this.f37771d = 0;
        this.f37772e = 0;
        if (this.f37774g.a(this.f37775h, this.f37776i, null, false)) {
            f fVarM2 = this.f37776i.m();
            l0.m(fVarM2);
            this.f37777j.connectionAcquired(this.f37776i, fVarM2);
            return fVarM2;
        }
        Route routeC = this.f37773f;
        try {
            if (routeC == null) {
                k.b bVar = this.f37768a;
                if (bVar != null) {
                    l0.m(bVar);
                    if (bVar.b()) {
                        k.b bVar2 = this.f37768a;
                        l0.m(bVar2);
                        routeC = bVar2.c();
                    }
                    fVar = new f(this.f37774g, routeC);
                    this.f37776i.z(fVar);
                    fVar.i(i7, i8, i9, i10, z7, this.f37776i, this.f37777j);
                    this.f37776i.z(null);
                    this.f37776i.l().getRouteDatabase().a(fVar.route());
                    if (this.f37774g.a(this.f37775h, this.f37776i, listA, true)) {
                        f fVarM3 = this.f37776i.m();
                        l0.m(fVarM3);
                        this.f37773f = routeC;
                        okhttp3.internal.d.n(fVar.socket());
                        this.f37777j.connectionAcquired(this.f37776i, fVarM3);
                        return fVarM3;
                    }
                    synchronized (fVar) {
                        this.f37774g.h(fVar);
                        this.f37776i.c(fVar);
                        l2 l2Var2 = l2.f34958a;
                    }
                    this.f37777j.connectionAcquired(this.f37776i, fVar);
                    return fVar;
                }
                k kVar = this.f37769b;
                if (kVar == null) {
                    kVar = new k(this.f37775h, this.f37776i.l().getRouteDatabase(), this.f37776i, this.f37777j);
                    this.f37769b = kVar;
                }
                k.b bVarD = kVar.d();
                this.f37768a = bVarD;
                listA = bVarD.a();
                if (this.f37776i.isCanceled()) {
                    throw new IOException("Canceled");
                }
                if (this.f37774g.a(this.f37775h, this.f37776i, listA, false)) {
                    f fVarM4 = this.f37776i.m();
                    l0.m(fVarM4);
                    this.f37777j.connectionAcquired(this.f37776i, fVarM4);
                    return fVarM4;
                }
                routeC = bVarD.c();
                fVar = new f(this.f37774g, routeC);
                this.f37776i.z(fVar);
                fVar.i(i7, i8, i9, i10, z7, this.f37776i, this.f37777j);
                this.f37776i.z(null);
                this.f37776i.l().getRouteDatabase().a(fVar.route());
                if (this.f37774g.a(this.f37775h, this.f37776i, listA, true)) {
                    f fVarM5 = this.f37776i.m();
                    l0.m(fVarM5);
                    this.f37773f = routeC;
                    okhttp3.internal.d.n(fVar.socket());
                    this.f37777j.connectionAcquired(this.f37776i, fVarM5);
                    return fVarM5;
                }
                synchronized (fVar) {
                    this.f37774g.h(fVar);
                    this.f37776i.c(fVar);
                    l2 l2Var3 = l2.f34958a;
                    this.f37777j.connectionAcquired(this.f37776i, fVar);
                    return fVar;
                }
            }
            l0.m(routeC);
            this.f37773f = null;
            fVar.i(i7, i8, i9, i10, z7, this.f37776i, this.f37777j);
            this.f37776i.z(null);
            this.f37776i.l().getRouteDatabase().a(fVar.route());
            if (this.f37774g.a(this.f37775h, this.f37776i, listA, true)) {
                f fVarM6 = this.f37776i.m();
                l0.m(fVarM6);
                this.f37773f = routeC;
                okhttp3.internal.d.n(fVar.socket());
                this.f37777j.connectionAcquired(this.f37776i, fVarM6);
                return fVarM6;
            }
            synchronized (fVar) {
                this.f37774g.h(fVar);
                this.f37776i.c(fVar);
                l2 l2Var4 = l2.f34958a;
                this.f37777j.connectionAcquired(this.f37776i, fVar);
                return fVar;
            }
        } catch (Throwable th) {
            this.f37776i.z(null);
            throw th;
        }
        listA = null;
        fVar = new f(this.f37774g, routeC);
        this.f37776i.z(fVar);
    }

    private final f c(int i7, int i8, int i9, int i10, boolean z7, boolean z8) throws IOException {
        while (true) {
            f fVarB = b(i7, i8, i9, i10, z7);
            if (fVarB.x(z8)) {
                return fVarB;
            }
            fVarB.C();
            if (this.f37773f == null) {
                k.b bVar = this.f37768a;
                if (bVar != null ? bVar.b() : true) {
                    continue;
                } else {
                    k kVar = this.f37769b;
                    if (!(kVar != null ? kVar.b() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final Route f() {
        f fVarM;
        if (this.f37770c > 1 || this.f37771d > 1 || this.f37772e > 0 || (fVarM = this.f37776i.m()) == null) {
            return null;
        }
        synchronized (fVarM) {
            if (fVarM.u() != 0) {
                return null;
            }
            if (okhttp3.internal.d.i(fVarM.route().address().url(), this.f37775h.url())) {
                return fVarM.route();
            }
            return null;
        }
    }

    @a7.d
    public final okhttp3.internal.http.d a(@a7.d OkHttpClient client, @a7.d okhttp3.internal.http.g chain) {
        l0.p(client, "client");
        l0.p(chain, "chain");
        try {
            return c(chain.d(), chain.f(), chain.h(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), !l0.g(chain.g().method(), Const.HTTP_REQUEST_TYPE_GET)).z(client, chain);
        } catch (IOException e8) {
            h(e8);
            throw new j(e8);
        } catch (j e9) {
            h(e9.c());
            throw e9;
        }
    }

    @a7.d
    public final Address d() {
        return this.f37775h;
    }

    public final boolean e() {
        k kVar;
        if (this.f37770c == 0 && this.f37771d == 0 && this.f37772e == 0) {
            return false;
        }
        if (this.f37773f != null) {
            return true;
        }
        Route routeF = f();
        if (routeF != null) {
            this.f37773f = routeF;
            return true;
        }
        k.b bVar = this.f37768a;
        if ((bVar == null || !bVar.b()) && (kVar = this.f37769b) != null) {
            return kVar.b();
        }
        return true;
    }

    public final boolean g(@a7.d HttpUrl url) {
        l0.p(url, "url");
        HttpUrl httpUrlUrl = this.f37775h.url();
        return url.port() == httpUrlUrl.port() && l0.g(url.host(), httpUrlUrl.host());
    }

    public final void h(@a7.d IOException e8) {
        l0.p(e8, "e");
        this.f37773f = null;
        if ((e8 instanceof n) && ((n) e8).f38216a == okhttp3.internal.http2.b.REFUSED_STREAM) {
            this.f37770c++;
        } else if (e8 instanceof okhttp3.internal.http2.a) {
            this.f37771d++;
        } else {
            this.f37772e++;
        }
    }
}
