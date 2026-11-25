package okhttp3.internal.platform;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.text.a0;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public class i extends k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f38275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f38276g = new a(0 == true ? 1 : 0);

    public static final class a {
        private a() {
        }

        @a7.e
        public final i a() {
            if (b()) {
                return new i();
            }
            return null;
        }

        public final boolean b() {
            return i.f38275f;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String property = System.getProperty("java.specification.version");
        Integer numX0 = property != null ? a0.X0(property) : null;
        boolean z7 = true;
        if (numX0 == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
            } catch (NoSuchMethodException unused) {
                z7 = false;
            }
        } else if (numX0.intValue() < 9) {
            z7 = false;
        }
        f38275f = z7;
    }

    @Override // okhttp3.internal.platform.k
    @okhttp3.internal.c
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<Protocol> protocols) {
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        SSLParameters sslParameters = sslSocket.getSSLParameters();
        List<String> listB = k.f38284e.b(protocols);
        l0.o(sslParameters, "sslParameters");
        Object[] array = listB.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        sslParameters.setApplicationProtocols((String[]) array);
        sslSocket.setSSLParameters(sslParameters);
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    @okhttp3.internal.c
    public String j(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        try {
            String applicationProtocol = sslSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                return null;
            }
            if (applicationProtocol.hashCode() == 0 && applicationProtocol.equals("")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public X509TrustManager s(@a7.d SSLSocketFactory sslSocketFactory) {
        l0.p(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
