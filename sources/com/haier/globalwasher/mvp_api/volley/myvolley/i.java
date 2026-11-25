package com.haier.globalwasher.mvp_api.volley.myvolley;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class i implements X509TrustManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TrustManager[] f24881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final X509Certificate[] f24882b = new X509Certificate[0];

    class a implements HostnameVerifier {
        a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public static void a() {
        SSLContext sSLContext;
        NoSuchAlgorithmException e8;
        KeyManagementException e9;
        HttpsURLConnection.setDefaultHostnameVerifier(new a());
        if (f24881a == null) {
            f24881a = new TrustManager[]{new i()};
        }
        try {
            sSLContext = SSLContext.getInstance("TLS");
            try {
                sSLContext.init(null, f24881a, new SecureRandom());
            } catch (KeyManagementException e10) {
                e9 = e10;
                e9.printStackTrace();
            } catch (NoSuchAlgorithmException e11) {
                e8 = e11;
                e8.printStackTrace();
            }
        } catch (KeyManagementException e12) {
            sSLContext = null;
            e9 = e12;
        } catch (NoSuchAlgorithmException e13) {
            sSLContext = null;
            e8 = e13;
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
    }

    public boolean b(X509Certificate[] x509CertificateArr) {
        return true;
    }

    public boolean c(X509Certificate[] x509CertificateArr) {
        return true;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return f24882b;
    }
}
