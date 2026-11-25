package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.l;
import okhttp3.internal.platform.android.m;

/* JADX INFO: loaded from: classes3.dex */
@okhttp3.internal.c
public final class b extends k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f38250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f38251h = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<m> f38252f;

    public static final class a {
        private a() {
        }

        @a7.e
        public final k a() {
            if (b()) {
                return new b();
            }
            return null;
        }

        public final boolean b() {
            return b.f38250g;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    static {
        f38250g = k.f38284e.h() && Build.VERSION.SDK_INT >= 29;
    }

    public b() {
        List listO = y.O(okhttp3.internal.platform.android.c.f38220a.a(), new l(okhttp3.internal.platform.android.h.f38230g.d()), new l(okhttp3.internal.platform.android.k.f38244b.a()), new l(okhttp3.internal.platform.android.i.f38238b.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listO) {
            if (((m) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f38252f = arrayList;
    }

    @Override // okhttp3.internal.platform.k
    @a7.d
    public u5.c d(@a7.d X509TrustManager trustManager) {
        l0.p(trustManager, "trustManager");
        okhttp3.internal.platform.android.d dVarA = okhttp3.internal.platform.android.d.f38221d.a(trustManager);
        return dVarA != null ? dVarA : super.d(trustManager);
    }

    @Override // okhttp3.internal.platform.k
    public void f(@a7.d SSLSocket sslSocket, @a7.e String str, @a7.d List<? extends Protocol> protocols) {
        Object next;
        l0.p(sslSocket, "sslSocket");
        l0.p(protocols, "protocols");
        Iterator<T> it = this.f38252f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((m) next).a(sslSocket));
        m mVar = (m) next;
        if (mVar != null) {
            mVar.f(sslSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public String j(@a7.d SSLSocket sslSocket) {
        Object next;
        l0.p(sslSocket, "sslSocket");
        Iterator<T> it = this.f38252f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((m) next).a(sslSocket));
        m mVar = (m) next;
        if (mVar != null) {
            return mVar.c(sslSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.k
    @SuppressLint({"NewApi"})
    public boolean l(@a7.d String hostname) {
        l0.p(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // okhttp3.internal.platform.k
    @a7.e
    public X509TrustManager s(@a7.d SSLSocketFactory sslSocketFactory) {
        Object next;
        l0.p(sslSocketFactory, "sslSocketFactory");
        Iterator<T> it = this.f38252f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((m) next).e(sslSocketFactory));
        m mVar = (m) next;
        if (mVar != null) {
            return mVar.d(sslSocketFactory);
        }
        return null;
    }
}
