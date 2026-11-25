package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f38247j = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Class<? super SSLSocketFactory> f38248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<?> f38249i;

    public static final class a {
        private a() {
        }

        public static /* synthetic */ m b(a aVar, String str, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.a(str);
        }

        @a7.e
        public final m a(@a7.d String packageName) {
            l0.p(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(packageName + ".OpenSSLSocketImpl");
                Class<?> cls2 = Class.forName(packageName + ".OpenSSLSocketFactoryImpl");
                Class<?> paramsClass = Class.forName(packageName + ".SSLParametersImpl");
                l0.o(paramsClass, "paramsClass");
                return new n(cls, cls2, paramsClass);
            } catch (Exception e8) {
                okhttp3.internal.platform.k.f38284e.g().m("unable to load android socket classes", 5, e8);
                return null;
            }
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@a7.d Class<? super SSLSocket> sslSocketClass, @a7.d Class<? super SSLSocketFactory> sslSocketFactoryClass, @a7.d Class<?> paramClass) {
        super(sslSocketClass);
        l0.p(sslSocketClass, "sslSocketClass");
        l0.p(sslSocketFactoryClass, "sslSocketFactoryClass");
        l0.p(paramClass, "paramClass");
        this.f38248h = sslSocketFactoryClass;
        this.f38249i = paramClass;
    }

    @Override // okhttp3.internal.platform.android.h, okhttp3.internal.platform.android.m
    @a7.e
    public X509TrustManager d(@a7.d SSLSocketFactory sslSocketFactory) throws IllegalAccessException {
        l0.p(sslSocketFactory, "sslSocketFactory");
        Object objQ = okhttp3.internal.d.Q(sslSocketFactory, this.f38249i, "sslParameters");
        l0.m(objQ);
        X509TrustManager x509TrustManager = (X509TrustManager) okhttp3.internal.d.Q(objQ, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) okhttp3.internal.d.Q(objQ, X509TrustManager.class, "trustManager");
    }

    @Override // okhttp3.internal.platform.android.h, okhttp3.internal.platform.android.m
    public boolean e(@a7.d SSLSocketFactory sslSocketFactory) {
        l0.p(sslSocketFactory, "sslSocketFactory");
        return this.f38248h.isInstance(sslSocketFactory);
    }
}
