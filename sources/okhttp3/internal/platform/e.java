package okhttp3.internal.platform;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f38262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f38263h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Provider f38264f;

    public static final class a {
        private a() {
        }

        public static /* synthetic */ boolean b(a aVar, int i7, int i8, int i9, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                i8 = 0;
            }
            if ((i10 & 4) != 0) {
                i9 = 0;
            }
            return aVar.a(i7, i8, i9);
        }

        public final boolean a(int i7, int i8, int i9) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != i7) {
                return version.major() > i7;
            }
            if (version.minor() != i8) {
                return version.minor() > i8;
            }
            return version.patch() >= i9;
        }

        @a7.e
        public final e c() {
            w wVar = null;
            if (d()) {
                return new e(wVar);
            }
            return null;
        }

        public final boolean d() {
            return e.f38262g;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public static final class b implements ConscryptHostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f38265a = new b();

        private b() {
        }

        public final boolean a(@a7.e String str, @a7.e SSLSession sSLSession) {
            return true;
        }

        public boolean b(@a7.e X509Certificate[] x509CertificateArr, @a7.e String str, @a7.e SSLSession sSLSession) {
            return true;
        }
    }

    static {
        a aVar = new a(null);
        f38263h = aVar;
        boolean z7 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && aVar.a(2, 1, 0)) {
                z7 = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f38262g = z7;
    }

    private e() {
        Provider providerNewProvider = Conscrypt.newProvider();
        l0.o(providerNewProvider, "Conscrypt.newProvider()");
        this.f38264f = providerNewProvider;
    }

    @Override // okhttp3.internal.platform.k
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<Protocol> protocols) {
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        if (!Conscrypt.isConscrypt(sslSocket)) {
            super.f(sslSocket, str, protocols);
            return;
        }
        Conscrypt.setUseSessionTickets(sslSocket, true);
        Object[] array = k.f38284e.b(protocols).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public String j(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket) ? Conscrypt.getApplicationProtocol(sslSocket) : super.j(sslSocket);
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public SSLContext p() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f38264f);
        l0.o(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public SSLSocketFactory q(@a7.d X509TrustManager trustManager) throws NoSuchAlgorithmException, KeyManagementException {
        l0.p(trustManager, "trustManager");
        SSLContext sSLContextP = p();
        sSLContextP.init(null, new TrustManager[]{trustManager}, null);
        SSLSocketFactory socketFactory = sSLContextP.getSocketFactory();
        l0.o(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public X509TrustManager r() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        l0.o(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        l0.m(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager, b.f38265a);
            return x509TrustManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        l0.o(string, "java.util.Arrays.toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public X509TrustManager s(@a7.d SSLSocketFactory sslSocketFactory) {
        l0.p(sslSocketFactory, "sslSocketFactory");
        return null;
    }

    public /* synthetic */ e(w wVar) {
        this();
    }
}
