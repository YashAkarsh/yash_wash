package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f38245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f38246b;

    public interface a {
        boolean a(@a7.d SSLSocket sSLSocket);

        @a7.d
        m b(@a7.d SSLSocket sSLSocket);
    }

    public l(@a7.d a socketAdapterFactory) {
        l0.p(socketAdapterFactory, "socketAdapterFactory");
        this.f38246b = socketAdapterFactory;
    }

    private final synchronized m g(SSLSocket sSLSocket) {
        if (this.f38245a == null && this.f38246b.a(sSLSocket)) {
            this.f38245a = this.f38246b.b(sSLSocket);
        }
        return this.f38245a;
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean a(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        return this.f38246b.a(sslSocket);
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean b() {
        return true;
    }

    @Override // okhttp3.internal.platform.android.m
    @a7.e
    public String c(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        m mVarG = g(sslSocket);
        if (mVarG != null) {
            return mVarG.c(sslSocket);
        }
        return null;
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
        m mVarG = g(sslSocket);
        if (mVarG != null) {
            mVarG.f(sslSocket, str, protocols);
        }
    }
}
