package com.haier.globalwasher.mvp_api.volley.toolbox;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f25039b = "volley";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f25040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.haier.globalwasher.mvp_api.volley.o f25041d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25042a;

    private static KeyStore a(Context context, int... iArr) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        String defaultType = KeyStore.getDefaultType();
        com.haier.globalwasher.modle.utils.q.c("buildKeyStore", "keyStoreType=" + defaultType);
        KeyStore keyStore = KeyStore.getInstance(defaultType);
        keyStore.load(null, null);
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            keyStore.setCertificateEntry(Integer.toString(i8), e(context, iArr[i7]));
            i7++;
            i8++;
        }
        return keyStore;
    }

    private static SSLSocketFactory b(Context context, int... iArr) {
        KeyStore keyStoreA;
        TrustManagerFactory trustManagerFactory;
        SSLContext sSLContext;
        try {
            keyStoreA = a(context, iArr);
        } catch (IOException e8) {
            e8.printStackTrace();
            keyStoreA = null;
        } catch (KeyStoreException e9) {
            e9.printStackTrace();
            keyStoreA = null;
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            keyStoreA = null;
        } catch (CertificateException e11) {
            e11.printStackTrace();
            keyStoreA = null;
        }
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            try {
                trustManagerFactory.init(keyStoreA);
            } catch (KeyStoreException e12) {
                e = e12;
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e13) {
                e = e13;
                e.printStackTrace();
            }
        } catch (KeyStoreException e14) {
            e = e14;
            trustManagerFactory = null;
        } catch (NoSuchAlgorithmException e15) {
            e = e15;
            trustManagerFactory = null;
        }
        try {
            sSLContext = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            sSLContext = null;
        }
        try {
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        } catch (KeyManagementException e17) {
            e17.printStackTrace();
        }
        return sSLContext.getSocketFactory();
    }

    public static com.haier.globalwasher.mvp_api.volley.o c(Context context, j jVar, int... iArr) {
        File file = new File(context.getCacheDir(), f25039b);
        if (jVar == null) {
            jVar = (iArr == null || iArr.length <= 0) ? new k() : new k(null, b(context, iArr));
        }
        if (f25040c == null) {
            f25040c = new c(jVar);
        }
        if (f25041d == null) {
            f25041d = new com.haier.globalwasher.mvp_api.volley.o(new f(file), f25040c);
        }
        f25041d.i();
        return f25041d;
    }

    public static com.haier.globalwasher.mvp_api.volley.o d(Context context, int... iArr) {
        return c(context, null, iArr);
    }

    private static Certificate e(Context context, int i7) {
        try {
            return CertificateFactory.getInstance("X.509").generateCertificate(context.getResources().openRawResource(i7));
        } catch (CertificateException e8) {
            e8.printStackTrace();
            return null;
        }
    }
}
