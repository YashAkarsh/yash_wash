package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
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
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f38277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f38278h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Provider f38279f;

    public static final class a {
        private a() {
        }

        @a7.e
        public final j a() {
            w wVar = null;
            if (b()) {
                return new j(wVar);
            }
            return null;
        }

        public final boolean b() {
            return j.f38277g;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f38278h = aVar;
        boolean z7 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, aVar.getClass().getClassLoader());
            z7 = true;
        } catch (ClassNotFoundException unused) {
        }
        f38277g = z7;
    }

    private j() {
        this.f38279f = new OpenJSSE();
    }

    @Override // okhttp3.internal.platform.k
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<Protocol> protocols) {
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        if (!(sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            super.f(sslSocket, str, protocols);
            return;
        }
        org.openjsse.javax.net.ssl.SSLSocket sSLSocket = (org.openjsse.javax.net.ssl.SSLSocket) sslSocket;
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (sSLParameters instanceof SSLParameters) {
            SSLParameters sSLParameters2 = sSLParameters;
            Object[] array = k.f38284e.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters2.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
        }
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public String j(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        if (!(sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            return super.j(sslSocket);
        }
        String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public SSLContext p() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f38279f);
        l0.o(sSLContext, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public X509TrustManager r() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f38279f);
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
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }

    public /* synthetic */ j(w wVar) {
        this();
    }
}
