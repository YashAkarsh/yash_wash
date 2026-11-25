package okhttp3.internal.platform;

import h5.l;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.z;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okio.m;

/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k f38280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38281b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38282c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f38283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f38284e;

    public static final class a {
        private a() {
        }

        private final k d() {
            okhttp3.internal.platform.android.e.f38227d.b();
            k kVarA = b.f38251h.a();
            if (kVarA != null) {
                return kVarA;
            }
            k kVarA2 = c.f38254i.a();
            l0.m(kVarA2);
            return kVarA2;
        }

        private final k e() {
            j jVarA;
            d dVarA;
            e eVarC;
            if (j() && (eVarC = e.f38263h.c()) != null) {
                return eVarC;
            }
            if (i() && (dVarA = d.f38260h.a()) != null) {
                return dVarA;
            }
            if (k() && (jVarA = j.f38278h.a()) != null) {
                return jVarA;
            }
            i iVarA = i.f38276g.a();
            if (iVarA != null) {
                return iVarA;
            }
            k kVarA = f.f38266k.a();
            return kVarA != null ? kVarA : new k();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final k f() {
            return h() ? d() : e();
        }

        private final boolean i() {
            Provider provider = Security.getProviders()[0];
            l0.o(provider, "Security.getProviders()[0]");
            return l0.g("BC", provider.getName());
        }

        private final boolean j() {
            Provider provider = Security.getProviders()[0];
            l0.o(provider, "Security.getProviders()[0]");
            return l0.g("Conscrypt", provider.getName());
        }

        private final boolean k() {
            Provider provider = Security.getProviders()[0];
            l0.o(provider, "Security.getProviders()[0]");
            return l0.g("OpenJSSE", provider.getName());
        }

        public static /* synthetic */ void m(a aVar, k kVar, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                kVar = aVar.f();
            }
            aVar.l(kVar);
        }

        @a7.d
        public final List<String> b(@a7.d List<? extends Protocol> protocols) {
            l0.p(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(z.Z(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol) it.next()).toString());
            }
            return arrayList2;
        }

        @a7.d
        public final byte[] c(@a7.d List<? extends Protocol> protocols) {
            l0.p(protocols, "protocols");
            m mVar = new m();
            for (String str : b(protocols)) {
                mVar.writeByte(str.length());
                mVar.q0(str);
            }
            return mVar.I();
        }

        @a7.d
        @l
        public final k g() {
            return k.f38280a;
        }

        public final boolean h() {
            return l0.g("Dalvik", System.getProperty("java.vm.name"));
        }

        public final void l(@a7.d k platform) {
            l0.p(platform, "platform");
            k.f38280a = platform;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f38284e = aVar;
        f38280a = aVar.f();
        f38283d = Logger.getLogger(OkHttpClient.class.getName());
    }

    @a7.d
    @l
    public static final k h() {
        return f38284e.g();
    }

    public static /* synthetic */ void n(k kVar, String str, int i7, Throwable th, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i8 & 2) != 0) {
            i7 = 4;
        }
        if ((i8 & 4) != 0) {
            th = null;
        }
        kVar.m(str, i7, th);
    }

    public void c(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
    }

    @a7.d
    public u5.c d(@a7.d X509TrustManager trustManager) {
        l0.p(trustManager, "trustManager");
        return new u5.a(e(trustManager));
    }

    @a7.d
    public u5.e e(@a7.d X509TrustManager trustManager) {
        l0.p(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        l0.o(acceptedIssuers, "trustManager.acceptedIssuers");
        return new u5.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<Protocol> protocols) {
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
    }

    public void g(@a7.d Socket socket, @a7.d InetSocketAddress address, int i7) throws IOException {
        l0.p(socket, "socket");
        l0.p(address, "address");
        socket.connect(address, i7);
    }

    @a7.d
    public final String i() {
        return "OkHttp";
    }

    @a7.e
    public String j(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        return null;
    }

    @a7.e
    public Object k(@a7.d String closer) {
        l0.p(closer, "closer");
        if (f38283d.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean l(@a7.d String hostname) {
        l0.p(hostname, "hostname");
        return true;
    }

    public void m(@a7.d String message, int i7, @a7.e Throwable th) {
        l0.p(message, "message");
        f38283d.log(i7 == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void o(@a7.d String message, @a7.e Object obj) {
        l0.p(message, "message");
        if (obj == null) {
            message = message + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        m(message, 5, (Throwable) obj);
    }

    @a7.d
    public SSLContext p() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        l0.o(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    @a7.d
    public SSLSocketFactory q(@a7.d X509TrustManager trustManager) {
        l0.p(trustManager, "trustManager");
        try {
            SSLContext sSLContextP = p();
            sSLContextP.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextP.getSocketFactory();
            l0.o(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e8) {
            throw new AssertionError("No System TLS: " + e8, e8);
        }
    }

    @a7.d
    public X509TrustManager r() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        factory.init((KeyStore) null);
        l0.o(factory, "factory");
        TrustManager[] trustManagers = factory.getTrustManagers();
        l0.m(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        l0.o(string, "java.util.Arrays.toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    @a7.e
    public X509TrustManager s(@a7.d SSLSocketFactory sslSocketFactory) {
        l0.p(sslSocketFactory, "sslSocketFactory");
        try {
            Class<?> sslContextClass = Class.forName("sun.security.ssl.SSLContextImpl");
            l0.o(sslContextClass, "sslContextClass");
            Object objQ = okhttp3.internal.d.Q(sslSocketFactory, sslContextClass, "context");
            if (objQ != null) {
                return (X509TrustManager) okhttp3.internal.d.Q(objQ, X509TrustManager.class, "trustManager");
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @a7.d
    public String toString() {
        String simpleName = getClass().getSimpleName();
        l0.o(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
