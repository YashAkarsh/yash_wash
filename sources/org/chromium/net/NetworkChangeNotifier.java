package org.chromium.net;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("net")
public class NetworkChangeNotifier {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static NetworkChangeNotifier f39011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final /* synthetic */ boolean f39012g = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private NetworkChangeNotifierAutoDetect f39016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f39017e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Long> f39013a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.chromium.base.a0<b> f39014b = new org.chromium.base.a0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConnectivityManager f39015c = (ConnectivityManager) org.chromium.base.o.e().getSystemService("connectivity");

    class a implements NetworkChangeNotifierAutoDetect.f {
        a() {
        }

        @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.f
        public void a(int i7) {
            NetworkChangeNotifier.this.y(i7);
        }

        @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.f
        public void b(long j7) {
            NetworkChangeNotifier.this.p(j7);
        }

        @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.f
        public void c(long j7, int i7) {
            NetworkChangeNotifier.this.n(j7, i7);
        }

        @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.f
        public void d(int i7) {
            NetworkChangeNotifier.this.k(i7);
        }

        @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.f
        public void e(long[] jArr) {
            NetworkChangeNotifier.this.q(jArr);
        }

        @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.f
        public void f(long j7) {
            NetworkChangeNotifier.this.o(j7);
        }
    }

    public interface b {
        void a(int i7);
    }

    @org.chromium.base.s0
    protected NetworkChangeNotifier() {
    }

    public static void b(b bVar) {
        g().c(bVar);
    }

    private void c(b bVar) {
        this.f39014b.g(bVar);
    }

    private void d() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f39016d;
        if (networkChangeNotifierAutoDetect != null) {
            networkChangeNotifierAutoDetect.m();
            this.f39016d = null;
        }
    }

    private void e(boolean z7) {
        if ((this.f39017e != 6) != z7) {
            y(z7 ? 0 : 6);
            k(!z7 ? 1 : 0);
        }
    }

    public static NetworkChangeNotifierAutoDetect f() {
        return g().f39016d;
    }

    @CalledByNative
    public static void fakeConnectionSubtypeChanged(int i7) {
        w(false);
        g().k(i7);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(long j7, int i7) {
        w(false);
        g().m(i7, j7);
    }

    @CalledByNative
    public static void fakeNetworkConnected(long j7, int i7) {
        w(false);
        g().n(j7, i7);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(long j7) {
        w(false);
        g().o(j7);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(long j7) {
        w(false);
        g().p(j7);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(long[] jArr) {
        w(false);
        g().q(jArr);
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z7) {
        w(false);
        g().e(z7);
    }

    public static NetworkChangeNotifier g() {
        return f39011f;
    }

    public static boolean h() {
        return f39011f != null;
    }

    public static boolean i() {
        return g().getCurrentConnectionType() != 6;
    }

    @CalledByNative
    public static NetworkChangeNotifier init() {
        if (f39011f == null) {
            f39011f = new NetworkChangeNotifier();
        }
        return f39011f;
    }

    @CalledByNative
    public static boolean isProcessBoundToNetwork() {
        return g().j();
    }

    private boolean j() {
        return y6.a.c(this.f39015c) != null;
    }

    private void m(int i7, long j7) {
        Iterator<Long> it = this.f39013a.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i7, j7);
        }
        Iterator<b> it2 = this.f39014b.iterator();
        while (it2.hasNext()) {
            it2.next().a(i7);
        }
    }

    @x6.f("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyConnectionTypeChanged(long j7, int i7, long j8);

    @x6.f("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyMaxBandwidthChanged(long j7, int i7);

    @x6.f("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyOfNetworkConnect(long j7, long j8, int i7);

    @x6.f("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyOfNetworkDisconnect(long j7, long j8);

    @x6.f("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyOfNetworkSoonToDisconnect(long j7, long j8);

    @x6.f("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyPurgeActiveNetworkList(long j7, long[] jArr);

    public static void r() {
        g().x(true, new i0());
    }

    public static void s(b bVar) {
        g().t(bVar);
    }

    private void t(b bVar) {
        this.f39014b.o(bVar);
    }

    static void u(NetworkChangeNotifier networkChangeNotifier) {
        f39011f = networkChangeNotifier;
    }

    public static void v(NetworkChangeNotifierAutoDetect.g gVar) {
        g().x(true, gVar);
    }

    public static void w(boolean z7) {
        g().x(z7, new j0());
    }

    private void x(boolean z7, NetworkChangeNotifierAutoDetect.g gVar) {
        if (!z7) {
            d();
            return;
        }
        if (this.f39016d == null) {
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = new NetworkChangeNotifierAutoDetect(new a(), gVar);
            this.f39016d = networkChangeNotifierAutoDetect;
            NetworkChangeNotifierAutoDetect.e eVarO = networkChangeNotifierAutoDetect.o();
            y(eVarO.b());
            k(eVarO.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i7) {
        this.f39017e = i7;
        l(i7);
    }

    @CalledByNative
    public void addNativeObserver(long j7) {
        this.f39013a.add(Long.valueOf(j7));
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f39016d;
        if (networkChangeNotifierAutoDetect == null) {
            return 0;
        }
        return networkChangeNotifierAutoDetect.o().a();
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.f39017e;
    }

    @CalledByNative
    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f39016d;
        if (networkChangeNotifierAutoDetect == null) {
            return -1L;
        }
        return networkChangeNotifierAutoDetect.p();
    }

    @CalledByNative
    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f39016d;
        return networkChangeNotifierAutoDetect == null ? new long[0] : networkChangeNotifierAutoDetect.q();
    }

    void k(int i7) {
        Iterator<Long> it = this.f39013a.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), i7);
        }
    }

    void l(int i7) {
        m(i7, getCurrentDefaultNetId());
    }

    void n(long j7, int i7) {
        Iterator<Long> it = this.f39013a.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), j7, i7);
        }
    }

    void o(long j7) {
        Iterator<Long> it = this.f39013a.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), j7);
        }
    }

    void p(long j7) {
        Iterator<Long> it = this.f39013a.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), j7);
        }
    }

    void q(long[] jArr) {
        Iterator<Long> it = this.f39013a.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), jArr);
        }
    }

    @CalledByNative
    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f39016d;
        if (networkChangeNotifierAutoDetect == null) {
            return false;
        }
        return networkChangeNotifierAutoDetect.w();
    }

    @CalledByNative
    public void removeNativeObserver(long j7) {
        this.f39013a.remove(Long.valueOf(j7));
    }
}
