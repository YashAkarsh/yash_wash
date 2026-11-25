package okhttp3.internal.platform.android;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
@okhttp3.internal.c
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38220a = new a(null);

    @okhttp3.internal.c
    public static final class a {
        private a() {
        }

        @a7.e
        public final m a() {
            if (b()) {
                return new c();
            }
            return null;
        }

        public final boolean b() {
            return okhttp3.internal.platform.k.f38284e.h() && Build.VERSION.SDK_INT >= 29;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean a(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sslSocket);
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean b() {
        return f38220a.b();
    }

    @Override // okhttp3.internal.platform.android.m
    @a7.e
    @SuppressLint({"NewApi"})
    public String c(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        String applicationProtocol = sslSocket.getApplicationProtocol();
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
    @SuppressLint({"NewApi"})
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<? extends Protocol> protocols) throws IOException {
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sslSocket, true);
            SSLParameters sslParameters = sslSocket.getSSLParameters();
            l0.o(sslParameters, "sslParameters");
            Object[] array = okhttp3.internal.platform.k.f38284e.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sslParameters.setApplicationProtocols((String[]) array);
            sslSocket.setSSLParameters(sslParameters);
        } catch (IllegalArgumentException e8) {
            throw new IOException("Android internal error", e8);
        }
    }
}
