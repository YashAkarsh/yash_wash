package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends u5.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f38221d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final X509TrustManager f38222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final X509TrustManagerExtensions f38223c;

    public static final class a {
        private a() {
        }

        @a7.e
        @okhttp3.internal.c
        public final d a(@a7.d X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            l0.p(trustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new d(trustManager, x509TrustManagerExtensions);
            }
            return null;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public d(@a7.d X509TrustManager trustManager, @a7.d X509TrustManagerExtensions x509TrustManagerExtensions) {
        l0.p(trustManager, "trustManager");
        l0.p(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f38222b = trustManager;
        this.f38223c = x509TrustManagerExtensions;
    }

    @Override // u5.c
    @a7.d
    @okhttp3.internal.c
    public List<Certificate> a(@a7.d List<? extends Certificate> chain, @a7.d String hostname) throws SSLPeerUnverifiedException {
        l0.p(chain, "chain");
        l0.p(hostname, "hostname");
        Object[] array = chain.toArray(new X509Certificate[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        try {
            List<X509Certificate> listCheckServerTrusted = this.f38223c.checkServerTrusted((X509Certificate[]) array, "RSA", hostname);
            l0.o(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e8) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e8.getMessage());
            sSLPeerUnverifiedException.initCause(e8);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(@a7.e Object obj) {
        return (obj instanceof d) && ((d) obj).f38222b == this.f38222b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f38222b);
    }
}
