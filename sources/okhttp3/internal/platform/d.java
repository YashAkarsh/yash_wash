package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f38259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f38260h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Provider f38261f;

    public static final class a {
        private a() {
        }

        @a7.e
        public final d a() {
            w wVar = null;
            if (b()) {
                return new d(wVar);
            }
            return null;
        }

        public final boolean b() {
            return d.f38259g;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f38260h = aVar;
        boolean z7 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, aVar.getClass().getClassLoader());
            z7 = true;
        } catch (ClassNotFoundException unused) {
        }
        f38259g = z7;
    }

    private d() {
        this.f38261f = new BouncyCastleJsseProvider();
    }

    @Override // okhttp3.internal.platform.k
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<Protocol> protocols) {
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        if (!(sslSocket instanceof BCSSLSocket)) {
            super.f(sslSocket, str, protocols);
            return;
        }
        BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
        BCSSLParameters sslParameters = bCSSLSocket.getParameters();
        List<String> listB = k.f38284e.b(protocols);
        l0.o(sslParameters, "sslParameters");
        Object[] array = listB.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        sslParameters.setApplicationProtocols((String[]) array);
        bCSSLSocket.setParameters(sslParameters);
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public String j(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        if (!(sslSocket instanceof BCSSLSocket)) {
            return super.j(sslSocket);
        }
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public SSLContext p() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f38261f);
        l0.o(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public X509TrustManager r() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory factory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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

    @Override // okhttp3.internal.platform.k
    @a7.e
    public X509TrustManager s(@a7.d SSLSocketFactory sslSocketFactory) {
        l0.p(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }

    public /* synthetic */ d(w wVar) {
        this();
    }
}
