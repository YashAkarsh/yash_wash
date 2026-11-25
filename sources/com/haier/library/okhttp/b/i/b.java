package com.haier.library.okhttp.b.i;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes2.dex */
public class b extends f {
    private b() {
    }

    public static b v() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new b();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider w() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // com.haier.library.okhttp.b.i.f
    @Nullable
    public String e(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.e(sSLSocket);
    }

    @Override // com.haier.library.okhttp.b.i.f
    @Nullable
    public X509TrustManager g(SSLSocketFactory sSLSocketFactory) {
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.g(sSLSocketFactory);
        }
        try {
            Object objC = f.c(sSLSocketFactory, Object.class, "sslParameters");
            if (objC != null) {
                return (X509TrustManager) f.c(objC, X509TrustManager.class, "x509TrustManager");
            }
            return null;
        } catch (Exception e8) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e8);
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public void k(SSLSocket sSLSocket, String str, List<com.haier.library.okhttp.d> list) {
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.k(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) f.f(list).toArray(new String[0]));
    }

    @Override // com.haier.library.okhttp.b.i.f
    public SSLContext m() {
        try {
            return SSLContext.getInstance("TLSv1.3", w());
        } catch (NoSuchAlgorithmException e8) {
            try {
                return SSLContext.getInstance("TLS", w());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e8);
            }
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public void o(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
