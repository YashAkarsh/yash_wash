package org.chromium.net.impl;

import android.os.ConditionVariable;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.a0;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.UsedByReflection;
import org.chromium.base.s0;
import org.chromium.net.b0;
import org.chromium.net.c0;
import org.chromium.net.k0;
import org.chromium.net.t0;

/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("CronetEngine.java")
@x6.c("cronet")
@s0
public class CronetUrlRequestContext extends org.chromium.net.impl.d {
    private static final int A = 3;
    private static final int B = -1;
    private static final int C = -2;
    static final String D = "CronetUrlRequestContext";

    @GuardedBy("sInUseStoragePaths")
    private static final HashSet<String> E = new HashSet<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f39274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ConditionVariable f39275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f39276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy("mLock")
    private long f39277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Thread f39278m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f39279n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Object f39280o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Object f39281p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @GuardedBy("mNetworkQualityLock")
    private int f39282q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @GuardedBy("mNetworkQualityLock")
    private int f39283r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @GuardedBy("mNetworkQualityLock")
    private int f39284s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @GuardedBy("mNetworkQualityLock")
    private int f39285t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @GuardedBy("mNetworkQualityLock")
    private final a0<VersionSafeCallbacks.c> f39286u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @GuardedBy("mNetworkQualityLock")
    private final a0<VersionSafeCallbacks.d> f39287v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @GuardedBy("mFinishedListenerLock")
    private final Map<k0.a, VersionSafeCallbacks.e> f39288w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile ConditionVariable f39289x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final String f39290y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @GuardedBy("mLock")
    private boolean f39291z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.b();
            synchronized (CronetUrlRequestContext.this.f39274i) {
                CronetUrlRequestContext cronetUrlRequestContext = CronetUrlRequestContext.this;
                cronetUrlRequestContext.nativeInitRequestContextOnInitThread(cronetUrlRequestContext.f39277l);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VersionSafeCallbacks.c f39293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f39294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f39295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f39296d;

        b(VersionSafeCallbacks.c cVar, int i7, long j7, int i8) {
            this.f39293a = cVar;
            this.f39294b = i7;
            this.f39295c = j7;
            this.f39296d = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f39293a.b(this.f39294b, this.f39295c, this.f39296d);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VersionSafeCallbacks.d f39298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f39299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f39300c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f39301d;

        c(VersionSafeCallbacks.d dVar, int i7, long j7, int i8) {
            this.f39298a = dVar;
            this.f39299b = i7;
            this.f39300c = j7;
            this.f39301d = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f39298a.b(this.f39299b, this.f39300c, this.f39301d);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VersionSafeCallbacks.e f39303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k0 f39304b;

        d(VersionSafeCallbacks.e eVar, k0 k0Var) {
            this.f39303a = eVar;
            this.f39304b = k0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f39303a.b(this.f39304b);
        }
    }

    @UsedByReflection("CronetEngine.java")
    public CronetUrlRequestContext(e eVar) {
        Object obj = new Object();
        this.f39274i = obj;
        this.f39275j = new ConditionVariable(false);
        this.f39276k = new AtomicInteger(0);
        this.f39280o = new Object();
        this.f39281p = new Object();
        this.f39282q = 0;
        this.f39283r = -1;
        this.f39284s = -1;
        this.f39285t = -1;
        this.f39286u = new a0<>();
        this.f39287v = new a0<>();
        this.f39288w = new HashMap();
        this.f39279n = eVar.K();
        CronetLibraryLoader.a(eVar.C(), eVar);
        nativeSetMinLogLevel(G());
        if (eVar.H() == 1) {
            String strV = eVar.V();
            this.f39290y = strV;
            HashSet<String> hashSet = E;
            synchronized (hashSet) {
                if (!hashSet.add(strV)) {
                    throw new IllegalStateException("Disk cache storage path already in use");
                }
            }
        } else {
            this.f39290y = null;
        }
        synchronized (obj) {
            long jNativeCreateRequestContextAdapter = nativeCreateRequestContextAdapter(F(eVar));
            this.f39277l = jNativeCreateRequestContextAdapter;
            if (jNativeCreateRequestContextAdapter == 0) {
                throw new NullPointerException("Context Adapter creation failed.");
            }
        }
        CronetLibraryLoader.d(new a());
    }

    @GuardedBy("mLock")
    private void D() throws IllegalStateException {
        if (!J()) {
            throw new IllegalStateException("Engine is shut down.");
        }
    }

    private static int E(int i7) {
        if (i7 == 0) {
            return 0;
        }
        int i8 = 1;
        if (i7 != 1) {
            i8 = 2;
            if (i7 != 2) {
                i8 = 3;
                if (i7 != 3) {
                    i8 = 4;
                    if (i7 != 4) {
                        if (i7 == 5) {
                            return 5;
                        }
                        throw new RuntimeException("Internal Error: Illegal EffectiveConnectionType value " + i7);
                    }
                }
            }
        }
        return i8;
    }

    @s0
    public static long F(e eVar) {
        long jNativeCreateRequestContextConfig = nativeCreateRequestContextConfig(eVar.E(), eVar.V(), eVar.N(), eVar.D(), eVar.F(), eVar.s(), eVar.t(), eVar.H(), eVar.G(), eVar.B(), eVar.J(), eVar.K(), eVar.L(), eVar.W(10));
        for (e.c cVar : eVar.O()) {
            nativeAddQuicHint(jNativeCreateRequestContextConfig, cVar.f39350a, cVar.f39351b, cVar.f39352c);
        }
        for (e.b bVar : eVar.M()) {
            nativeAddPkp(jNativeCreateRequestContextConfig, bVar.f39346a, bVar.f39347b, bVar.f39348c, bVar.f39349d.getTime());
        }
        return jNativeCreateRequestContextConfig;
    }

    private int G() {
        String str = D;
        if (org.chromium.base.t.q(str, 2)) {
            return -2;
        }
        return org.chromium.base.t.q(str, 3) ? -1 : 3;
    }

    @GuardedBy("mLock")
    private boolean J() {
        return this.f39277l != 0;
    }

    private static void N(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e8) {
            org.chromium.base.t.j(D, "Exception posting task to executor", e8);
        }
    }

    @CalledByNative
    private void initNetworkThread() {
        this.f39278m = Thread.currentThread();
        this.f39275j.open();
        Thread.currentThread().setName("ChromiumNet");
    }

    private static native void nativeAddPkp(long j7, String str, byte[][] bArr, boolean z7, long j8);

    private static native void nativeAddQuicHint(long j7, String str, int i7, int i8);

    @x6.f("CronetURLRequestContextAdapter")
    private native void nativeConfigureNetworkQualityEstimatorForTesting(long j7, boolean z7, boolean z8, boolean z9);

    private static native long nativeCreateRequestContextAdapter(long j7);

    private static native long nativeCreateRequestContextConfig(String str, String str2, boolean z7, String str3, boolean z8, boolean z9, boolean z10, int i7, long j7, String str4, long j8, boolean z11, boolean z12, int i8);

    @x6.f("CronetURLRequestContextAdapter")
    private native void nativeDestroy(long j7);

    private static native byte[] nativeGetHistogramDeltas();

    /* JADX INFO: Access modifiers changed from: private */
    @x6.f("CronetURLRequestContextAdapter")
    public native void nativeInitRequestContextOnInitThread(long j7);

    @x6.f("CronetURLRequestContextAdapter")
    private native void nativeProvideRTTObservations(long j7, boolean z7);

    @x6.f("CronetURLRequestContextAdapter")
    private native void nativeProvideThroughputObservations(long j7, boolean z7);

    private static native int nativeSetMinLogLevel(int i7);

    @x6.f("CronetURLRequestContextAdapter")
    private native void nativeStartNetLogToDisk(long j7, String str, boolean z7, int i7);

    @x6.f("CronetURLRequestContextAdapter")
    private native boolean nativeStartNetLogToFile(long j7, String str, boolean z7);

    @x6.f("CronetURLRequestContextAdapter")
    private native void nativeStopNetLog(long j7);

    @CalledByNative
    private void onEffectiveConnectionTypeChanged(int i7) {
        synchronized (this.f39280o) {
            this.f39282q = i7;
        }
    }

    @CalledByNative
    private void onRTTOrThroughputEstimatesComputed(int i7, int i8, int i9) {
        synchronized (this.f39280o) {
            this.f39283r = i7;
            this.f39284s = i8;
            this.f39285t = i9;
        }
    }

    @CalledByNative
    private void onRttObservation(int i7, long j7, int i8) {
        synchronized (this.f39280o) {
            for (VersionSafeCallbacks.c cVar : this.f39286u) {
                N(cVar.a(), new b(cVar, i7, j7, i8));
            }
        }
    }

    @CalledByNative
    private void onThroughputObservation(int i7, long j7, int i8) {
        synchronized (this.f39280o) {
            for (VersionSafeCallbacks.d dVar : this.f39287v) {
                N(dVar.a(), new c(dVar, i7, j7, i8));
            }
        }
    }

    @s0
    public long H() {
        long j7;
        synchronized (this.f39274i) {
            D();
            j7 = this.f39277l;
        }
        return j7;
    }

    boolean I() {
        boolean z7;
        synchronized (this.f39281p) {
            z7 = !this.f39288w.isEmpty();
        }
        return z7;
    }

    public boolean K(Thread thread) {
        return thread == this.f39278m;
    }

    void L() {
        this.f39276k.decrementAndGet();
    }

    void M() {
        this.f39276k.incrementAndGet();
    }

    void O(k0 k0Var) {
        synchronized (this.f39281p) {
            if (this.f39288w.isEmpty()) {
                return;
            }
            for (VersionSafeCallbacks.e eVar : new ArrayList(this.f39288w.values())) {
                N(eVar.a(), new d(eVar, k0Var));
            }
        }
    }

    @Override // org.chromium.net.j
    public URLStreamHandlerFactory b() {
        return new org.chromium.net.urlconnection.h(this);
    }

    @Override // org.chromium.net.j
    public byte[] c() {
        return nativeGetHistogramDeltas();
    }

    @Override // org.chromium.net.j
    public String d() {
        return "Cronet/" + i.c();
    }

    @Override // org.chromium.net.j
    public URLConnection f(URL url) {
        return t(url, Proxy.NO_PROXY);
    }

    @Override // org.chromium.net.j
    public void g() {
        if (this.f39290y != null) {
            HashSet<String> hashSet = E;
            synchronized (hashSet) {
                hashSet.remove(this.f39290y);
            }
        }
        synchronized (this.f39274i) {
            D();
            if (this.f39276k.get() != 0) {
                throw new IllegalStateException("Cannot shutdown with active requests.");
            }
            if (Thread.currentThread() == this.f39278m) {
                throw new IllegalThreadStateException("Cannot shutdown from network thread.");
            }
        }
        this.f39275j.block();
        i();
        synchronized (this.f39274i) {
            if (J()) {
                nativeDestroy(this.f39277l);
                this.f39277l = 0L;
            }
        }
    }

    @Override // org.chromium.net.j
    public void h(String str, boolean z7) {
        synchronized (this.f39274i) {
            D();
            if (!nativeStartNetLogToFile(this.f39277l, str, z7)) {
                throw new RuntimeException("Unable to start NetLog");
            }
            this.f39291z = true;
        }
    }

    @Override // org.chromium.net.j
    public void i() {
        synchronized (this.f39274i) {
            if (this.f39291z) {
                D();
                this.f39289x = new ConditionVariable();
                nativeStopNetLog(this.f39277l);
                this.f39291z = false;
                this.f39289x.block();
            }
        }
    }

    @Override // org.chromium.net.o
    public void j(k0.a aVar) {
        synchronized (this.f39281p) {
            this.f39288w.put(aVar, new VersionSafeCallbacks.e(aVar));
        }
    }

    @Override // org.chromium.net.o
    public void k(b0 b0Var) {
        if (!this.f39279n) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.f39280o) {
            if (this.f39286u.isEmpty()) {
                synchronized (this.f39274i) {
                    D();
                    nativeProvideRTTObservations(this.f39277l, true);
                }
            }
            this.f39286u.g(new VersionSafeCallbacks.c(b0Var));
        }
    }

    @Override // org.chromium.net.o
    public void l(c0 c0Var) {
        if (!this.f39279n) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.f39280o) {
            if (this.f39287v.isEmpty()) {
                synchronized (this.f39274i) {
                    D();
                    nativeProvideThroughputObservations(this.f39277l, true);
                }
            }
            this.f39287v.g(new VersionSafeCallbacks.d(c0Var));
        }
    }

    @Override // org.chromium.net.o
    @s0
    public void m(boolean z7, boolean z8, boolean z9) {
        if (!this.f39279n) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.f39274i) {
            D();
            nativeConfigureNetworkQualityEstimatorForTesting(this.f39277l, z7, z8, z9);
        }
    }

    @Override // org.chromium.net.o
    public int n() {
        int i7;
        if (!this.f39279n) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.f39280o) {
            i7 = this.f39285t;
            if (i7 == -1) {
                i7 = -1;
            }
        }
        return i7;
    }

    @Override // org.chromium.net.o
    public int o() {
        int iE;
        if (!this.f39279n) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.f39280o) {
            iE = E(this.f39282q);
        }
        return iE;
    }

    @Override // org.chromium.net.o
    public int p() {
        int i7;
        if (!this.f39279n) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.f39280o) {
            i7 = this.f39283r;
            if (i7 == -1) {
                i7 = -1;
            }
        }
        return i7;
    }

    @Override // org.chromium.net.o
    public int q() {
        int i7;
        if (!this.f39279n) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.f39280o) {
            i7 = this.f39284s;
            if (i7 == -1) {
                i7 = -1;
            }
        }
        return i7;
    }

    @Override // org.chromium.net.o
    public org.chromium.net.n.a r(String str, org.chromium.net.d.b bVar, Executor executor) {
        return new org.chromium.net.impl.a(str, bVar, executor, this);
    }

    @CalledByNative
    public void stopNetLogCompleted() {
        this.f39289x.open();
    }

    @Override // org.chromium.net.o
    public URLConnection t(URL url, Proxy proxy) {
        if (proxy.type() != Proxy.Type.DIRECT) {
            throw new UnsupportedOperationException();
        }
        String protocol = url.getProtocol();
        if (com.haier.uhome.usdk.base.a.av.equals(protocol) || j0.b.f34226a.equals(protocol)) {
            return new org.chromium.net.urlconnection.d(url, this);
        }
        throw new UnsupportedOperationException("Unexpected protocol:" + protocol);
    }

    @Override // org.chromium.net.o
    public void u(k0.a aVar) {
        synchronized (this.f39281p) {
            this.f39288w.remove(aVar);
        }
    }

    @Override // org.chromium.net.o
    public void v(b0 b0Var) {
        if (!this.f39279n) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.f39280o) {
            if (this.f39286u.o(new VersionSafeCallbacks.c(b0Var)) && this.f39286u.isEmpty()) {
                synchronized (this.f39274i) {
                    D();
                    nativeProvideRTTObservations(this.f39277l, false);
                }
            }
        }
    }

    @Override // org.chromium.net.o
    public void w(c0 c0Var) {
        if (!this.f39279n) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.f39280o) {
            if (this.f39287v.o(new VersionSafeCallbacks.d(c0Var)) && this.f39287v.isEmpty()) {
                synchronized (this.f39274i) {
                    D();
                    nativeProvideThroughputObservations(this.f39277l, false);
                }
            }
        }
    }

    @Override // org.chromium.net.o
    public void x(String str, boolean z7, int i7) {
        synchronized (this.f39274i) {
            D();
            nativeStartNetLogToDisk(this.f39277l, str, z7, i7);
            this.f39291z = true;
        }
    }

    @Override // org.chromium.net.impl.d
    protected org.chromium.net.n y(String str, org.chromium.net.d.b bVar, Executor executor, String str2, List<Map.Entry<String, String>> list, int i7, boolean z7, Collection<Object> collection, boolean z8, int i8, boolean z9, int i9) throws Throwable {
        synchronized (this.f39274i) {
            try {
                try {
                    D();
                    return new CronetBidirectionalStream(this, str, i7, bVar, executor, str2, list, z7, collection, z8, i8, z9, i9);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // org.chromium.net.impl.d
    public r z(String str, t0.b bVar, Executor executor, int i7, Collection<Object> collection, boolean z7, boolean z8, boolean z9, boolean z10, int i8, boolean z11, int i9, k0.a aVar) throws Throwable {
        synchronized (this.f39274i) {
            try {
                try {
                    D();
                    return new CronetUrlRequest(this, str, i7, bVar, executor, collection, z7, z8, z9, z10, i8, z11, i9, aVar);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }
}
