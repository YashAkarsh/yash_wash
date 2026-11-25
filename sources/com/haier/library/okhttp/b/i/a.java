package com.haier.library.okhttp.b.i;

import android.os.Build;
import android.util.Log;
import com.haier.library.okhttp.n;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
class a extends f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f27351k = 4000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<?> f27352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e<Socket> f27353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e<Socket> f27354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e<Socket> f27355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e<Socket> f27356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c f27357j = c.a();

    /* JADX INFO: renamed from: com.haier.library.okhttp.b.i.a$a, reason: collision with other inner class name */
    static final class C0360a extends com.haier.library.okhttp.b.l.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f27358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f27359b;

        C0360a(Object obj, Method method) {
            this.f27358a = obj;
            this.f27359b = method;
        }

        @Override // com.haier.library.okhttp.b.l.c
        public List<Certificate> c(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f27359b.invoke(this.f27358a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e8) {
                throw new AssertionError(e8);
            } catch (InvocationTargetException e9) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e9.getMessage());
                sSLPeerUnverifiedException.initCause(e9);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0360a;
        }

        public int hashCode() {
            return 0;
        }
    }

    static final class b implements com.haier.library.okhttp.b.l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f27360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f27361b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f27361b = method;
            this.f27360a = x509TrustManager;
        }

        @Override // com.haier.library.okhttp.b.l.f
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f27361b.invoke(this.f27360a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e8) {
                throw n.d.g("unable to get issues and signature", e8);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f27360a.equals(bVar.f27360a) && this.f27361b.equals(bVar.f27361b);
        }

        public int hashCode() {
            return this.f27360a.hashCode() + (this.f27361b.hashCode() * 31);
        }
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f27362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f27363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f27364c;

        c(Method method, Method method2, Method method3) {
            this.f27362a = method;
            this.f27363b = method2;
            this.f27364c = method3;
        }

        static c a() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new c(method, method3, method2);
        }

        Object b(String str) {
            Method method = this.f27362a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.f27363b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f27364c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    a(Class<?> cls, e<Socket> eVar, e<Socket> eVar2, e<Socket> eVar3, e<Socket> eVar4) {
        this.f27352e = cls;
        this.f27353f = eVar;
        this.f27354g = eVar2;
        this.f27355h = eVar3;
        this.f27356i = eVar4;
    }

    public static f a() {
        Class<?> cls;
        e eVar;
        e eVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            e eVar3 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar4 = new e(null, "setHostname", String.class);
            if (x()) {
                e eVar5 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                eVar2 = new e(null, "setAlpnProtocols", byte[].class);
                eVar = eVar5;
            } else {
                eVar = null;
                eVar2 = null;
            }
            return new a(cls2, eVar3, eVar4, eVar, eVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    private boolean v(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return w(str, cls, obj);
        }
    }

    private boolean w(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.p(str);
        }
    }

    private static boolean x() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public com.haier.library.okhttp.b.l.c b(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0360a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public Object d(String str) {
        return this.f27357j.b(str);
    }

    @Override // com.haier.library.okhttp.b.i.f
    @Nullable
    public String e(SSLSocket sSLSocket) {
        byte[] bArr;
        e<Socket> eVar = this.f27355h;
        if (eVar == null || !eVar.d(sSLSocket) || (bArr = (byte[]) this.f27355h.g(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, n.d.f27695j);
    }

    @Override // com.haier.library.okhttp.b.i.f
    @Nullable
    protected X509TrustManager g(SSLSocketFactory sSLSocketFactory) {
        Object objC = f.c(sSLSocketFactory, this.f27352e, "sslParameters");
        if (objC == null) {
            try {
                objC = f.c(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.g(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) f.c(objC, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) f.c(objC, X509TrustManager.class, "trustManager");
    }

    @Override // com.haier.library.okhttp.b.i.f
    public void h(int i7, String str, @Nullable Throwable th) {
        int iMin;
        int i8 = i7 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i9 = 0;
        while (i9 < length) {
            int iIndexOf = str.indexOf(10, i9);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i9 + 4000);
                Log.println(i8, "OkHttp", str.substring(i9, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i9 = iMin;
                }
            }
            i9 = iMin + 1;
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public void i(String str, Object obj) {
        if (this.f27357j.c(obj)) {
            return;
        }
        h(5, str, null);
    }

    @Override // com.haier.library.okhttp.b.i.f
    public void j(Socket socket, InetSocketAddress inetSocketAddress, int i7) throws IOException {
        try {
            socket.connect(inetSocketAddress, i7);
        } catch (AssertionError e8) {
            if (!n.d.x(e8)) {
                throw e8;
            }
            throw new IOException(e8);
        } catch (ClassCastException e9) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e9;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e9);
            throw iOException;
        } catch (SecurityException e10) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e10);
            throw iOException2;
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public void k(SSLSocket sSLSocket, String str, List<com.haier.library.okhttp.d> list) {
        if (str != null) {
            this.f27353f.e(sSLSocket, Boolean.TRUE);
            this.f27354g.e(sSLSocket, str);
        }
        e<Socket> eVar = this.f27356i;
        if (eVar == null || !eVar.d(sSLSocket)) {
            return;
        }
        this.f27356i.g(sSLSocket, f.q(list));
    }

    @Override // com.haier.library.okhttp.b.i.f
    public com.haier.library.okhttp.b.l.f l(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.l(x509TrustManager);
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public SSLContext m() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e8) {
            throw new IllegalStateException("No TLS provider", e8);
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public boolean p(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return v(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.p(str);
        } catch (IllegalAccessException e8) {
            e = e8;
            throw n.d.g("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e9) {
            e = e9;
            throw n.d.g("unable to determine cleartext support", e);
        } catch (InvocationTargetException e10) {
            e = e10;
            throw n.d.g("unable to determine cleartext support", e);
        }
    }
}
