package com.haier.library.okhttp.b.i;

import com.haier.library.a.g;
import com.haier.library.okhttp.l0;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f27379b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f27380c = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f27378a = a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f27381d = Logger.getLogger(l0.class.getName());

    private static f a() {
        b bVarV;
        f fVarA = a.a();
        if (fVarA != null) {
            return fVarA;
        }
        if (u() && (bVarV = b.v()) != null) {
            return bVarV;
        }
        c cVarV = c.v();
        if (cVarV != null) {
            return cVarV;
        }
        f fVarA2 = d.a();
        return fVarA2 != null ? fVarA2 : new f();
    }

    @Nullable
    static <T> T c(Object obj, Class<T> cls, String str) {
        Object objC;
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null && cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (objC = c(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return (T) c(objC, cls, str);
    }

    public static List<String> f(List<com.haier.library.okhttp.d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            com.haier.library.okhttp.d dVar = list.get(i7);
            if (dVar != com.haier.library.okhttp.d.HTTP_1_0) {
                arrayList.add(dVar.toString());
            }
        }
        return arrayList;
    }

    static byte[] q(List<com.haier.library.okhttp.d> list) {
        g gVar = new g();
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            com.haier.library.okhttp.d dVar = list.get(i7);
            if (dVar != com.haier.library.okhttp.d.HTTP_1_0) {
                gVar.y1(dVar.toString().length());
                gVar.b(dVar.toString());
            }
        }
        return gVar.n1();
    }

    public static f r() {
        return f27378a;
    }

    public static boolean u() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public com.haier.library.okhttp.b.l.c b(X509TrustManager x509TrustManager) {
        return new com.haier.library.okhttp.b.l.a(l(x509TrustManager));
    }

    public Object d(String str) {
        if (f27381d.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    @Nullable
    public String e(SSLSocket sSLSocket) {
        return null;
    }

    @Nullable
    protected X509TrustManager g(SSLSocketFactory sSLSocketFactory) {
        try {
            Object objC = c(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (objC == null) {
                return null;
            }
            return (X509TrustManager) c(objC, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void h(int i7, String str, @Nullable Throwable th) {
        f27381d.log(i7 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void i(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        h(5, str, (Throwable) obj);
    }

    public void j(Socket socket, InetSocketAddress inetSocketAddress, int i7) throws IOException {
        socket.connect(inetSocketAddress, i7);
    }

    public void k(SSLSocket sSLSocket, @Nullable String str, List<com.haier.library.okhttp.d> list) {
    }

    public com.haier.library.okhttp.b.l.f l(X509TrustManager x509TrustManager) {
        return new com.haier.library.okhttp.b.l.b(x509TrustManager.getAcceptedIssuers());
    }

    public SSLContext m() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e8) {
            throw new IllegalStateException("No TLS provider", e8);
        }
    }

    public void n(SSLSocket sSLSocket) {
    }

    public void o(SSLSocketFactory sSLSocketFactory) {
    }

    public boolean p(String str) {
        return true;
    }

    public com.haier.library.okhttp.b.l.c s(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager x509TrustManagerG = g(sSLSocketFactory);
        if (x509TrustManagerG != null) {
            return b(x509TrustManagerG);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + r() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    public String t() {
        return "OkHttp";
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
