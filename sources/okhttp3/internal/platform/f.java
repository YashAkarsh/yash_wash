package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends k {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f38266k = new b(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Method f38267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Method f38268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Method f38269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<?> f38270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Class<?> f38271j;

    private static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f38272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.e
        private String f38273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f38274c;

        public a(@a7.d List<String> protocols) {
            l0.p(protocols, "protocols");
            this.f38274c = protocols;
        }

        @a7.e
        public final String a() {
            return this.f38273b;
        }

        public final boolean b() {
            return this.f38272a;
        }

        public final void c(@a7.e String str) {
            this.f38273b = str;
        }

        public final void d(boolean z7) {
            this.f38272a = z7;
        }

        @Override // java.lang.reflect.InvocationHandler
        @a7.e
        public Object invoke(@a7.d Object proxy, @a7.d Method method, @a7.e Object[] objArr) throws Throwable {
            l0.p(proxy, "proxy");
            l0.p(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (l0.g(name, "supports") && l0.g(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (l0.g(name, "unsupported") && l0.g(Void.TYPE, returnType)) {
                this.f38272a = true;
                return null;
            }
            if (l0.g(name, "protocols")) {
                if (objArr.length == 0) {
                    return this.f38274c;
                }
            }
            if ((l0.g(name, "selectProtocol") || l0.g(name, "select")) && l0.g(String.class, returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i7 = 0;
                        while (true) {
                            Object obj2 = list.get(i7);
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) obj2;
                            if (this.f38274c.contains(str)) {
                                this.f38273b = str;
                                return str;
                            }
                            if (i7 != size) {
                                i7++;
                            }
                        }
                    }
                    String str2 = this.f38274c.get(0);
                    this.f38273b = str2;
                    return str2;
                }
            }
            if ((!l0.g(name, "protocolSelected") && !l0.g(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj3 = objArr[0];
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.f38273b = (String) obj3;
            return null;
        }
    }

    public static final class b {
        private b() {
        }

        @a7.e
        public final k a() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                l0.o(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                Method getMethod = cls.getMethod("get", SSLSocket.class);
                Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                l0.o(putMethod, "putMethod");
                l0.o(getMethod, "getMethod");
                l0.o(removeMethod, "removeMethod");
                l0.o(clientProviderClass, "clientProviderClass");
                l0.o(serverProviderClass, "serverProviderClass");
                return new f(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }

        public /* synthetic */ b(w wVar) {
            this();
        }
    }

    public f(@a7.d Method putMethod, @a7.d Method getMethod, @a7.d Method removeMethod, @a7.d Class<?> clientProviderClass, @a7.d Class<?> serverProviderClass) {
        l0.p(putMethod, "putMethod");
        l0.p(getMethod, "getMethod");
        l0.p(removeMethod, "removeMethod");
        l0.p(clientProviderClass, "clientProviderClass");
        l0.p(serverProviderClass, "serverProviderClass");
        this.f38267f = putMethod;
        this.f38268g = getMethod;
        this.f38269h = removeMethod;
        this.f38270i = clientProviderClass;
        this.f38271j = serverProviderClass;
    }

    @Override // okhttp3.internal.platform.k
    public void c(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        try {
            this.f38269h.invoke(null, sslSocket);
        } catch (IllegalAccessException e8) {
            throw new AssertionError("failed to remove ALPN", e8);
        } catch (InvocationTargetException e9) {
            throw new AssertionError("failed to remove ALPN", e9);
        }
    }

    @Override // okhttp3.internal.platform.k
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<? extends Protocol> protocols) {
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        try {
            this.f38267f.invoke(null, sslSocket, Proxy.newProxyInstance(k.class.getClassLoader(), new Class[]{this.f38270i, this.f38271j}, new a(k.f38284e.b(protocols))));
        } catch (IllegalAccessException e8) {
            throw new AssertionError("failed to set ALPN", e8);
        } catch (InvocationTargetException e9) {
            throw new AssertionError("failed to set ALPN", e9);
        }
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public String j(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f38268g.invoke(null, sslSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            a aVar = (a) invocationHandler;
            if (!aVar.b() && aVar.a() == null) {
                k.n(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (aVar.b()) {
                return null;
            }
            return aVar.a();
        } catch (IllegalAccessException e8) {
            throw new AssertionError("failed to get ALPN selected protocol", e8);
        } catch (InvocationTargetException e9) {
            throw new AssertionError("failed to get ALPN selected protocol", e9);
        }
    }
}
