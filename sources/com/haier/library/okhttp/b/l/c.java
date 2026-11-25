package com.haier.library.okhttp.b.l;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static c a(X509TrustManager x509TrustManager) {
        return com.haier.library.okhttp.b.i.f.r().b(x509TrustManager);
    }

    public static c b(X509Certificate... x509CertificateArr) {
        return new a(new b(x509CertificateArr));
    }

    public abstract List<Certificate> c(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
