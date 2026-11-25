package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.text.b0;
import okhttp3.Protocol;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes3.dex */
public class h implements m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final l.a f38229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f38230g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f38231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f38232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f38233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f38234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<? super SSLSocket> f38235e;

    public static final class a {

        /* JADX INFO: renamed from: okhttp3.internal.platform.android.h$a$a, reason: collision with other inner class name */
        public static final class C0511a implements l.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f38236a;

            C0511a(String str) {
                this.f38236a = str;
            }

            @Override // okhttp3.internal.platform.android.l.a
            public boolean a(@a7.d SSLSocket sslSocket) {
                l0.p(sslSocket, "sslSocket");
                String name = sslSocket.getClass().getName();
                l0.o(name, "sslSocket.javaClass.name");
                return b0.u2(name, this.f38236a + ClassUtils.PACKAGE_SEPARATOR_CHAR, false, 2, null);
            }

            @Override // okhttp3.internal.platform.android.l.a
            @a7.d
            public m b(@a7.d SSLSocket sslSocket) {
                l0.p(sslSocket, "sslSocket");
                return h.f38230g.b(sslSocket.getClass());
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final h b(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> superclass = cls;
            while (superclass != null && (!l0.g(superclass.getSimpleName(), "OpenSSLSocketImpl"))) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            l0.m(superclass);
            return new h(superclass);
        }

        @a7.d
        public final l.a c(@a7.d String packageName) {
            l0.p(packageName, "packageName");
            return new C0511a(packageName);
        }

        @a7.d
        public final l.a d() {
            return h.f38229f;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f38230g = aVar;
        f38229f = aVar.c("com.google.android.gms.org.conscrypt");
    }

    public h(@a7.d Class<? super SSLSocket> sslSocketClass) throws NoSuchMethodException {
        l0.p(sslSocketClass, "sslSocketClass");
        this.f38235e = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        l0.o(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f38231a = declaredMethod;
        this.f38232b = sslSocketClass.getMethod("setHostname", String.class);
        this.f38233c = sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f38234d = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean a(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        return this.f38235e.isInstance(sslSocket);
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean b() {
        return okhttp3.internal.platform.c.f38254i.b();
    }

    @Override // okhttp3.internal.platform.android.m
    @a7.e
    public String c(@a7.d SSLSocket sslSocket) {
        l0.p(sslSocket, "sslSocket");
        if (!a(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f38233c.invoke(sslSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            l0.o(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e8) {
            throw new AssertionError(e8);
        } catch (NullPointerException e9) {
            if (l0.g(e9.getMessage(), "ssl == null")) {
                return null;
            }
            throw e9;
        } catch (InvocationTargetException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // okhttp3.internal.platform.android.m
    @a7.e
    public X509TrustManager d(@a7.d SSLSocketFactory sslSocketFactory) {
        l0.p(sslSocketFactory, "sslSocketFactory");
        return m.a.b(this, sslSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.m
    public boolean e(@a7.d SSLSocketFactory sslSocketFactory) {
        l0.p(sslSocketFactory, "sslSocketFactory");
        return m.a.a(this, sslSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.m
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<? extends Protocol> protocols) {
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        if (a(sslSocket)) {
            try {
                this.f38231a.invoke(sslSocket, Boolean.TRUE);
                if (str != null) {
                    this.f38232b.invoke(sslSocket, str);
                }
                this.f38234d.invoke(sslSocket, okhttp3.internal.platform.k.f38284e.c(protocols));
            } catch (IllegalAccessException e8) {
                throw new AssertionError(e8);
            } catch (InvocationTargetException e9) {
                throw new AssertionError(e9);
            }
        }
    }
}
