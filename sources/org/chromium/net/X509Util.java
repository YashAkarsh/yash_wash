package org.chromium.net;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.lang3.ClassUtils;
import org.chromium.base.metrics.RecordHistogram;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("net")
@x6.e
public class X509Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39084a = "X509Util";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CertificateFactory f39085b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f39086c = "1.3.6.1.5.5.7.3.1";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f39087d = "2.5.29.37.0";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f39088e = "2.16.840.1.113730.4.1";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f39089f = "1.3.6.1.4.1.311.10.3.3";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static d f39090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static b f39091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static d f39092i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static KeyStore f39093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static KeyStore f39094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static File f39095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Set<Pair<X500Principal, PublicKey>> f39096m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f39097n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static boolean f39099p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final /* synthetic */ boolean f39101r = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f39098o = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final char[] f39100q = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static final class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean zEquals;
            if (Build.VERSION.SDK_INT >= 26) {
                zEquals = true;
                if (!"android.security.action.KEYCHAIN_CHANGED".equals(intent.getAction()) && !"android.security.action.TRUST_STORE_CHANGED".equals(intent.getAction()) && (!"android.security.action.KEY_ACCESS_CHANGED".equals(intent.getAction()) || intent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false))) {
                    zEquals = false;
                }
            } else {
                zEquals = "android.security.STORAGE_CHANGED".equals(intent.getAction());
            }
            if (zEquals) {
                try {
                    X509Util.j();
                } catch (KeyStoreException e8) {
                    Log.e(X509Util.f39084a, "Unable to reload the default TrustManager", e8);
                } catch (NoSuchAlgorithmException e9) {
                    Log.e(X509Util.f39084a, "Unable to reload the default TrustManager", e9);
                } catch (CertificateException e10) {
                    Log.e(X509Util.f39084a, "Unable to reload the default TrustManager", e10);
                }
            }
        }
    }

    private static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f39102a;

        public c(X509TrustManager x509TrustManager) {
            this.f39102a = x509TrustManager;
        }

        @Override // org.chromium.net.X509Util.d
        public List<X509Certificate> a(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            this.f39102a.checkServerTrusted(x509CertificateArr, str);
            return Collections.emptyList();
        }
    }

    private interface d {
        List<X509Certificate> a(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException;
    }

    private static final class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManagerExtensions f39103a;

        @SuppressLint({"NewApi"})
        public e(X509TrustManager x509TrustManager) {
            this.f39103a = new X509TrustManagerExtensions(x509TrustManager);
        }

        @Override // org.chromium.net.X509Util.d
        @SuppressLint({"NewApi"})
        public List<X509Certificate> a(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            return this.f39103a.checkServerTrusted(x509CertificateArr, str, str2);
        }
    }

    public static void b(byte[] bArr) throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        f();
        X509Certificate x509CertificateD = d(bArr);
        synchronized (f39098o) {
            f39093j.setCertificateEntry("root_cert_" + Integer.toString(f39093j.size()), x509CertificateD);
            k();
        }
    }

    public static void c() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        f();
        synchronized (f39098o) {
            try {
                f39093j.load(null);
                k();
            } catch (IOException unused) {
            }
        }
    }

    public static X509Certificate d(byte[] bArr) throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        f();
        return (X509Certificate) f39085b.generateCertificate(new ByteArrayInputStream(bArr));
    }

    private static d e(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if (trustManager instanceof X509TrustManager) {
                try {
                    return new e((X509TrustManager) trustManager);
                } catch (IllegalArgumentException e8) {
                    Log.e(f39084a, "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e8);
                }
            }
        }
        Log.e(f39084a, "Could not find suitable trust manager");
        return null;
    }

    private static void f() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        synchronized (f39098o) {
            g();
        }
    }

    private static void g() throws NoSuchAlgorithmException, KeyStoreException, CertificateException {
        if (f39085b == null) {
            f39085b = CertificateFactory.getInstance("X.509");
        }
        if (f39090g == null) {
            f39090g = e(null);
        }
        if (!f39097n) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                f39094k = keyStore;
                try {
                    keyStore.load(null);
                } catch (IOException unused) {
                }
                f39095l = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
            } catch (KeyStoreException unused2) {
            }
            if (!f39099p) {
                RecordHistogram.e("Net.FoundSystemTrustRootsAndroid", f39094k != null);
            }
            f39097n = true;
        }
        if (f39096m == null) {
            f39096m = new HashSet();
        }
        if (f39093j == null) {
            KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
            f39093j = keyStore2;
            try {
                keyStore2.load(null);
            } catch (IOException unused3) {
            }
        }
        if (f39092i == null) {
            f39092i = e(f39093j);
        }
        if (f39091h == null) {
            f39091h = new b();
            IntentFilter intentFilter = new IntentFilter();
            if (Build.VERSION.SDK_INT >= 26) {
                intentFilter.addAction("android.security.action.KEYCHAIN_CHANGED");
                intentFilter.addAction("android.security.action.KEY_ACCESS_CHANGED");
                intentFilter.addAction("android.security.action.TRUST_STORE_CHANGED");
            } else {
                intentFilter.addAction("android.security.STORAGE_CHANGED");
            }
            org.chromium.base.o.e().registerReceiver(f39091h, intentFilter);
        }
    }

    private static String h(X500Principal x500Principal) throws NoSuchAlgorithmException {
        byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(x500Principal.getEncoded());
        char[] cArr = new char[8];
        for (int i7 = 0; i7 < 4; i7++) {
            int i8 = i7 * 2;
            char[] cArr2 = f39100q;
            byte b8 = bArrDigest[3 - i7];
            cArr[i8] = cArr2[(b8 >> 4) & 15];
            cArr[i8 + 1] = cArr2[b8 & com.google.common.base.c.f19317q];
        }
        return new String(cArr);
    }

    private static boolean i(X509Certificate x509Certificate) throws NoSuchAlgorithmException, KeyStoreException {
        if (f39094k == null) {
            return false;
        }
        Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
        if (f39096m.contains(pair)) {
            return true;
        }
        String strH = h(x509Certificate.getSubjectX500Principal());
        int i7 = 0;
        while (true) {
            String str = strH + ClassUtils.PACKAGE_SEPARATOR_CHAR + i7;
            if (!new File(f39095l, str).exists()) {
                return false;
            }
            Certificate certificate = f39094k.getCertificate("system:" + str);
            if (certificate != null) {
                if (certificate instanceof X509Certificate) {
                    X509Certificate x509Certificate2 = (X509Certificate) certificate;
                    if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                        f39096m.add(pair);
                        return true;
                    }
                } else {
                    Log.e(f39084a, "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName());
                }
            }
            i7++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() throws NoSuchAlgorithmException, KeyStoreException, CertificateException {
        synchronized (f39098o) {
            f39090g = null;
            f39096m = null;
            g();
        }
        nativeNotifyKeyChainChanged();
    }

    private static void k() throws NoSuchAlgorithmException, KeyStoreException {
        f39092i = e(f39093j);
    }

    public static void l(boolean z7) {
        f39099p = z7;
    }

    static boolean m(X509Certificate x509Certificate) throws CertificateException {
        try {
            List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
            if (extendedKeyUsage == null) {
                return true;
            }
            for (String str : extendedKeyUsage) {
                if (str.equals(f39086c) || str.equals(f39087d) || str.equals(f39088e) || str.equals(f39089f)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException unused) {
        }
    }

    public static AndroidCertVerifyResult n(byte[][] bArr, String str, String str2) throws NoSuchAlgorithmException, KeyStoreException {
        List<X509Certificate> listA;
        if (bArr == null || bArr.length == 0 || bArr[0] == null) {
            throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
        }
        try {
            f();
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(d(bArr[0]));
                for (int i7 = 1; i7 < bArr.length; i7++) {
                    try {
                        arrayList.add(d(bArr[i7]));
                    } catch (CertificateException unused) {
                        Log.w(f39084a, "intermediate " + i7 + " failed parsing");
                    }
                }
                X509Certificate[] x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                try {
                    x509CertificateArr[0].checkValidity();
                    if (!m(x509CertificateArr[0])) {
                        return new AndroidCertVerifyResult(-6);
                    }
                    synchronized (f39098o) {
                        d dVar = f39090g;
                        if (dVar == null) {
                            return new AndroidCertVerifyResult(-1);
                        }
                        try {
                            listA = dVar.a(x509CertificateArr, str, str2);
                        } catch (CertificateException e8) {
                            try {
                                listA = f39092i.a(x509CertificateArr, str, str2);
                            } catch (CertificateException unused2) {
                                Log.i(f39084a, "Failed to validate the certificate chain, error: " + e8.getMessage());
                                return new AndroidCertVerifyResult(-2);
                            }
                        }
                        return new AndroidCertVerifyResult(0, listA.size() > 0 ? i(listA.get(listA.size() - 1)) : false, listA);
                    }
                } catch (CertificateExpiredException unused3) {
                    return new AndroidCertVerifyResult(-3);
                } catch (CertificateNotYetValidException unused4) {
                    return new AndroidCertVerifyResult(-4);
                } catch (CertificateException unused5) {
                    return new AndroidCertVerifyResult(-1);
                }
            } catch (CertificateException unused6) {
                return new AndroidCertVerifyResult(-5);
            }
        } catch (CertificateException unused7) {
            return new AndroidCertVerifyResult(-1);
        }
    }

    private static native void nativeNotifyKeyChainChanged();
}
