package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f38238b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final l.a f38237a = new a();

    public static final class a implements l.a {
        a() {
        }

        @Override // okhttp3.internal.platform.android.l.a
        public boolean a(@a7.d SSLSocket sslSocket) {
            l0.p(sslSocket, "sslSocket");
            return okhttp3.internal.platform.d.f38260h.b() && (sslSocket instanceof BCSSLSocket);
        }

        @Override // okhttp3.internal.platform.android.l.a
        @a7.d
        public m b(@a7.d SSLSocket sslSocket) {
            l0.p(sslSocket, "sslSocket");
            return new i();
        }
    }

    public static final class b {
        private b() {
        }

        @a7.d
        public final l.a a() {
            return i.f38237a;
        }

        public /* synthetic */ b(w wVar) {
            this();
        }
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean a(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        return sslSocket instanceof BCSSLSocket;
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean b() {
        return okhttp3.internal.platform.d.f38260h.b();
    }

    @Override // okhttp3.internal.platform.android.m
    @a7.e
    public String c(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // okhttp3.internal.platform.android.m
    @a7.e
    public X509TrustManager d(@a7.d SSLSocketFactory sslSocketFactory) {
        l0.p(sslSocketFactory, "sslSocketFactory");
        return m.a.b(this, sslSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean e(@a7.d SSLSocketFactory sslSocketFactory) {
        l0.p(sslSocketFactory, "sslSocketFactory");
        return m.a.a(this, sslSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.m
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<? extends Protocol> protocols) {
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        if (a(sslSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
            BCSSLParameters sslParameters = bCSSLSocket.getParameters();
            l0.o(sslParameters, "sslParameters");
            Object[] array = okhttp3.internal.platform.k.f38284e.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sslParameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(sslParameters);
        }
    }
}
