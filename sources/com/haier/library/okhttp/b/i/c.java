package com.haier.library.okhttp.b.i;

import com.haier.library.okhttp.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
final class c extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Method f27365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Method f27366f;

    c(Method method, Method method2) {
        this.f27365e = method;
        this.f27366f = method2;
    }

    public static c v() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    @Nullable
    public String e(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f27366f.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw n.d.g("unable to get selected protocols", e8);
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public X509TrustManager g(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    @Override // com.haier.library.okhttp.b.i.f
    public void k(SSLSocket sSLSocket, String str, List<com.haier.library.okhttp.d> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listF = f.f(list);
            this.f27365e.invoke(sSLParameters, listF.toArray(new String[listF.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw n.d.g("unable to set ssl parameters", e8);
        }
    }
}
