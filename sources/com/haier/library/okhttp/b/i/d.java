package com.haier.library.okhttp.b.i;

import com.haier.library.okhttp.n;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
class d extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f27367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Method f27368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Method f27369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Class<?> f27370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<?> f27371i;

    private static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f27372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f27373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f27374c;

        a(List<String> list) {
            this.f27372a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = n.d.f27687b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f27373b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f27372a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        if (this.f27372a.contains(list.get(i7))) {
                            String str = (String) list.get(i7);
                            this.f27374c = str;
                            return str;
                        }
                    }
                    String str2 = this.f27372a.get(0);
                    this.f27374c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f27374c = (String) objArr[0];
            return null;
        }
    }

    d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f27367e = method;
        this.f27368f = method2;
        this.f27369g = method3;
        this.f27370h = cls;
        this.f27371i = cls2;
    }

    public static f a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    @Nullable
    public String e(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f27368f.invoke(null, sSLSocket));
            boolean z7 = aVar.f27373b;
            if (!z7 && aVar.f27374c == null) {
                f.r().h(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z7) {
                return null;
            }
            return aVar.f27374c;
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw n.d.g("unable to get selected protocol", e8);
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public void k(SSLSocket sSLSocket, String str, List<com.haier.library.okhttp.d> list) {
        try {
            this.f27367e.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f27370h, this.f27371i}, new a(f.f(list))));
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw n.d.g("unable to set alpn", e8);
        }
    }

    @Override // com.haier.library.okhttp.b.i.f
    public void n(SSLSocket sSLSocket) {
        try {
            this.f27369g.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw n.d.g("unable to remove alpn", e8);
        }
    }
}
