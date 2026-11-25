package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.l;
import okhttp3.internal.platform.android.m;
import okhttp3.internal.platform.android.n;

/* JADX INFO: loaded from: classes3.dex */
@okhttp3.internal.c
public final class c extends k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f38253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f38254i = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<m> f38255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final okhttp3.internal.platform.android.j f38256g;

    public static final class a {
        private a() {
        }

        @a7.e
        public final k a() {
            if (b()) {
                return new c();
            }
            return null;
        }

        public final boolean b() {
            return c.f38253h;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public static final class b implements u5.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f38257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f38258b;

        public b(@a7.d X509TrustManager trustManager, @a7.d Method findByIssuerAndSignatureMethod) {
            l0.p(trustManager, "trustManager");
            l0.p(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.f38257a = trustManager;
            this.f38258b = findByIssuerAndSignatureMethod;
        }

        private final X509TrustManager b() {
            return this.f38257a;
        }

        private final Method c() {
            return this.f38258b;
        }

        public static /* synthetic */ b e(b bVar, X509TrustManager x509TrustManager, Method method, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                x509TrustManager = bVar.f38257a;
            }
            if ((i7 & 2) != 0) {
                method = bVar.f38258b;
            }
            return bVar.d(x509TrustManager, method);
        }

        @Override // u5.e
        @a7.e
        public X509Certificate a(@a7.d X509Certificate cert) {
            l0.p(cert, "cert");
            try {
                Object objInvoke = this.f38258b.invoke(this.f38257a, cert);
                if (objInvoke != null) {
                    return ((TrustAnchor) objInvoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e8) {
                throw new AssertionError("unable to get issues and signature", e8);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        @a7.d
        public final b d(@a7.d X509TrustManager trustManager, @a7.d Method findByIssuerAndSignatureMethod) {
            l0.p(trustManager, "trustManager");
            l0.p(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            return new b(trustManager, findByIssuerAndSignatureMethod);
        }

        public boolean equals(@a7.e Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return l0.g(this.f38257a, bVar.f38257a) && l0.g(this.f38258b, bVar.f38258b);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.f38257a;
            int iHashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.f38258b;
            return iHashCode + (method != null ? method.hashCode() : 0);
        }

        @a7.d
        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f38257a + ", findByIssuerAndSignatureMethod=" + this.f38258b + ")";
        }
    }

    static {
        boolean z7 = false;
        if (k.f38284e.h() && Build.VERSION.SDK_INT < 30) {
            z7 = true;
        }
        f38253h = z7;
    }

    public c() {
        List listO = y.O(n.a.b(n.f38247j, null, 1, null), new l(okhttp3.internal.platform.android.h.f38230g.d()), new l(okhttp3.internal.platform.android.k.f38244b.a()), new l(okhttp3.internal.platform.android.i.f38238b.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listO) {
            if (((m) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f38255f = arrayList;
        this.f38256g = okhttp3.internal.platform.android.j.f38239d.a();
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public u5.c d(@a7.d X509TrustManager trustManager) {
        l0.p(trustManager, "trustManager");
        okhttp3.internal.platform.android.d dVarA = okhttp3.internal.platform.android.d.f38221d.a(trustManager);
        return dVarA != null ? dVarA : super.d(trustManager);
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public u5.e e(@a7.d X509TrustManager trustManager) {
        l0.p(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            l0.o(method, "method");
            method.setAccessible(true);
            return new b(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.e(trustManager);
        }
    }

    @Override // okhttp3.internal.platform.k
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<Protocol> protocols) {
        Object next;
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        Iterator<T> it = this.f38255f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((m) next).a(sslSocket));
        m mVar = (m) next;
        if (mVar != null) {
            mVar.f(sslSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.k
    public void g(@a7.d Socket socket, @a7.d InetSocketAddress address, int i7) throws IOException {
        l0.p(socket, "socket");
        l0.p(address, "address");
        try {
            socket.connect(address, i7);
        } catch (ClassCastException e8) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e8;
            }
            throw new IOException("Exception in connect", e8);
        }
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public String j(@a7.d SSLSocket sslSocket) {
        Object next;
        l0.p(sslSocket, "sslSocket");
        Iterator<T> it = this.f38255f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((m) next).a(sslSocket));
        m mVar = (m) next;
        if (mVar != null) {
            return mVar.c(sslSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public Object k(@a7.d String closer) {
        l0.p(closer, "closer");
        return this.f38256g.a(closer);
    }

    @Override // okhttp3.internal.platform.k
    public boolean l(@a7.d String hostname) {
        l0.p(hostname, "hostname");
        if (Build.VERSION.SDK_INT >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
        }
        NetworkSecurityPolicy networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        l0.o(networkSecurityPolicy, "NetworkSecurityPolicy.getInstance()");
        return networkSecurityPolicy.isCleartextTrafficPermitted();
    }

    @Override // okhttp3.internal.platform.k
    public void o(@a7.d String message, @a7.e Object obj) {
        l0.p(message, "message");
        if (this.f38256g.b(obj)) {
            return;
        }
        k.n(this, message, 5, null, 4, null);
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public X509TrustManager s(@a7.d SSLSocketFactory sslSocketFactory) {
        Object next;
        l0.p(sslSocketFactory, "sslSocketFactory");
        Iterator<T> it = this.f38255f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((m) next).e(sslSocketFactory));
        m mVar = (m) next;
        if (mVar != null) {
            return mVar.d(sslSocketFactory);
        }
        return null;
    }
}
