package org.chromium.net.impl;

import com.haier.uhome.account.api.Const;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.s0;
import org.chromium.net.k0;
import org.chromium.net.q0;
import org.chromium.net.t0;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("cronet")
@x6.b({VersionSafeCallbacks.class})
@s0
public final class CronetUrlRequest extends r {
    static final /* synthetic */ boolean E = false;
    private org.chromium.net.k A;
    private org.chromium.net.impl.g B;
    private k C;

    @GuardedBy("mUrlRequestAdapterLock")
    private Runnable D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mUrlRequestAdapterLock")
    private long f39233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean f39234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean f39235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("mUrlRequestAdapterLock")
    private boolean f39236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f39237g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CronetUrlRequestContext f39238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f39239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<String> f39240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final VersionSafeCallbacks.g f39241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f39242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f39243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f39244n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final j f39245o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Collection<Object> f39246p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f39247q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f39248r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f39249s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f39250t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f39251u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f39252v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final VersionSafeCallbacks.e f39253w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CronetUploadDataStream f39254x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private u f39255y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f39256z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.f39254x.t();
            synchronized (CronetUrlRequest.this.f39237g) {
                if (CronetUrlRequest.this.E()) {
                    return;
                }
                CronetUrlRequest.this.f39254x.n(CronetUrlRequest.this.f39233c);
                CronetUrlRequest.this.N();
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VersionSafeCallbacks.UrlRequestStatusListener f39258a;

        b(VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener) {
            this.f39258a = urlRequestStatusListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f39258a.a(-1);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f39260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39261b;

        c(u uVar, String str) {
            this.f39260a = uVar;
            this.f39261b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.y();
            synchronized (CronetUrlRequest.this.f39237g) {
                if (CronetUrlRequest.this.E()) {
                    return;
                }
                CronetUrlRequest.this.f39235e = true;
                try {
                    CronetUrlRequest.this.f39241k.d(CronetUrlRequest.this, this.f39260a, this.f39261b);
                } catch (Exception e8) {
                    CronetUrlRequest.this.H(e8);
                }
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.y();
            synchronized (CronetUrlRequest.this.f39237g) {
                if (CronetUrlRequest.this.E()) {
                    return;
                }
                CronetUrlRequest.this.f39236f = true;
                try {
                    VersionSafeCallbacks.g gVar = CronetUrlRequest.this.f39241k;
                    CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                    gVar.e(cronetUrlRequest, cronetUrlRequest.f39255y);
                } catch (Exception e8) {
                    CronetUrlRequest.this.H(e8);
                }
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUrlRequest.this.f39237g) {
                if (CronetUrlRequest.this.E()) {
                    return;
                }
                CronetUrlRequest.this.B(0);
                try {
                    VersionSafeCallbacks.g gVar = CronetUrlRequest.this.f39241k;
                    CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                    gVar.f(cronetUrlRequest, cronetUrlRequest.f39255y);
                    CronetUrlRequest.this.G();
                } catch (Exception e8) {
                    org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception in onSucceeded method", e8);
                }
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                VersionSafeCallbacks.g gVar = CronetUrlRequest.this.f39241k;
                CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                gVar.a(cronetUrlRequest, cronetUrlRequest.f39255y);
                CronetUrlRequest.this.G();
            } catch (Exception e8) {
                org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception in onCanceled method", e8);
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VersionSafeCallbacks.UrlRequestStatusListener f39266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f39267b;

        g(VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, int i7) {
            this.f39266a = urlRequestStatusListener;
            this.f39267b = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f39266a.a(r.h(this.f39267b));
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                VersionSafeCallbacks.g gVar = CronetUrlRequest.this.f39241k;
                CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                gVar.b(cronetUrlRequest, cronetUrlRequest.f39255y, CronetUrlRequest.this.A);
                CronetUrlRequest.this.G();
            } catch (Exception e8) {
                org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception in onFailed method", e8);
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k0 f39270a;

        i(k0 k0Var) {
            this.f39270a = k0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.f39253w.b(this.f39270a);
        }
    }

    private static final class j extends ArrayList<Map.Entry<String, String>> {
        private j() {
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    private final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ByteBuffer f39272a;

        private k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.y();
            ByteBuffer byteBuffer = this.f39272a;
            this.f39272a = null;
            try {
                synchronized (CronetUrlRequest.this.f39237g) {
                    if (CronetUrlRequest.this.E()) {
                        return;
                    }
                    CronetUrlRequest.this.f39236f = true;
                    VersionSafeCallbacks.g gVar = CronetUrlRequest.this.f39241k;
                    CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                    gVar.c(cronetUrlRequest, cronetUrlRequest.f39255y, byteBuffer);
                }
            } catch (Exception e8) {
                CronetUrlRequest.this.H(e8);
            }
        }

        /* synthetic */ k(CronetUrlRequest cronetUrlRequest, a aVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i7, t0.b bVar, Executor executor, Collection<Object> collection, boolean z7, boolean z8, boolean z9, boolean z10, int i8, boolean z11, int i9, k0.a aVar) {
        ArrayList arrayList = new ArrayList();
        this.f39240j = arrayList;
        this.f39245o = new j(0 == true ? 1 : 0);
        if (str == null) {
            throw new NullPointerException("URL is required");
        }
        if (bVar == null) {
            throw new NullPointerException("Listener is required");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required");
        }
        this.f39232b = z9;
        this.f39238h = cronetUrlRequestContext;
        this.f39242l = str;
        arrayList.add(str);
        this.f39243m = A(i7);
        this.f39241k = new VersionSafeCallbacks.g(bVar);
        this.f39239i = executor;
        this.f39246p = collection;
        this.f39247q = z7;
        this.f39248r = z8;
        this.f39249s = z10;
        this.f39250t = i8;
        this.f39251u = z11;
        this.f39252v = i9;
        this.f39253w = aVar != null ? new VersionSafeCallbacks.e(aVar) : null;
    }

    private static int A(int i7) {
        if (i7 == 0) {
            return 1;
        }
        if (i7 == 1) {
            return 2;
        }
        if (i7 != 2) {
            return i7 != 4 ? 4 : 5;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void B(int i7) {
        this.f39256z = i7;
        if (this.f39233c == 0) {
            return;
        }
        this.f39238h.L();
        nativeDestroy(this.f39233c, i7 == 2);
        this.f39233c = 0L;
    }

    private void C(org.chromium.net.k kVar) {
        synchronized (this.f39237g) {
            if (E()) {
                return;
            }
            this.A = kVar;
            B(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean E() {
        return this.f39234d && this.f39233c == 0;
    }

    private int F(int i7) {
        switch (i7) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            default:
                org.chromium.base.t.j(CronetUrlRequestContext.D, "Unknown error code: " + i7, new Object[0]);
                return i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        org.chromium.net.impl.g gVar = this.B;
        if (gVar != null) {
            q qVar = new q(this.f39242l, this.f39246p, gVar, this.f39256z, this.f39255y, this.A);
            this.f39238h.O(qVar);
            VersionSafeCallbacks.e eVar = this.f39253w;
            if (eVar != null) {
                try {
                    eVar.a().execute(new i(qVar));
                } catch (RejectedExecutionException e8) {
                    org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception posting task to executor", e8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(Exception exc) {
        org.chromium.net.impl.c cVar = new org.chromium.net.impl.c("Exception received from UrlRequest.Callback", exc);
        org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception in CalledByNative method", exc);
        C(cVar);
    }

    private void J(Runnable runnable) {
        try {
            this.f39239i.execute(runnable);
        } catch (RejectedExecutionException e8) {
            org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception posting task to executor", e8);
            C(new org.chromium.net.impl.f("Exception posting task to executor", e8));
        }
    }

    private u K(int i7, String str, String[] strArr, boolean z7, String str2, String str3, long j7) {
        j jVar = new j(null);
        for (int i8 = 0; i8 < strArr.length; i8 += 2) {
            jVar.add(new AbstractMap.SimpleImmutableEntry(strArr[i8], strArr[i8 + 1]));
        }
        return new u(new ArrayList(this.f39240j), i7, str, jVar, z7, str2, str3, j7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mUrlRequestAdapterLock")
    public void N() {
        nativeStart(this.f39233c);
    }

    @x6.f("CronetURLRequestAdapter")
    private native boolean nativeAddRequestHeader(long j7, String str, String str2);

    private native long nativeCreateRequestAdapter(long j7, String str, int i7, boolean z7, boolean z8, boolean z9, boolean z10, int i8, boolean z11, int i9);

    @x6.f("CronetURLRequestAdapter")
    private native void nativeDestroy(long j7, boolean z7);

    @x6.f("CronetURLRequestAdapter")
    private native void nativeFollowDeferredRedirect(long j7);

    @x6.f("CronetURLRequestAdapter")
    private native void nativeGetStatus(long j7, VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener);

    @x6.f("CronetURLRequestAdapter")
    private native boolean nativeReadData(long j7, ByteBuffer byteBuffer, int i7, int i8);

    @x6.f("CronetURLRequestAdapter")
    private native boolean nativeSetHttpMethod(long j7, String str);

    @x6.f("CronetURLRequestAdapter")
    private native void nativeStart(long j7);

    @CalledByNative
    private void onCanceled() {
        J(new f());
    }

    @CalledByNative
    private void onError(int i7, int i8, int i9, String str, long j7) {
        u uVar = this.f39255y;
        if (uVar != null) {
            uVar.k(j7);
        }
        if (i7 == 10 || i7 == 3) {
            C(new p("Exception in CronetUrlRequest: " + str, i7, i8, i9));
            return;
        }
        C(new n("Exception in CronetUrlRequest: " + str, F(i7), i8));
    }

    @CalledByNative
    private void onMetricsCollected(long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, boolean z7, long j20, long j21) {
        synchronized (this.f39237g) {
            if (this.B != null) {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
            this.B = new org.chromium.net.impl.g(j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, z7, j20, j21);
        }
    }

    @CalledByNative
    private void onNativeAdapterDestroyed() {
        synchronized (this.f39237g) {
            Runnable runnable = this.D;
            if (runnable != null) {
                runnable.run();
            }
            if (this.A == null) {
                return;
            }
            try {
                this.f39239i.execute(new h());
            } catch (RejectedExecutionException e8) {
                org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception posting task to executor", e8);
            }
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i7, int i8, int i9, long j7) {
        this.f39255y.k(j7);
        a aVar = null;
        if (byteBuffer.position() != i8 || byteBuffer.limit() != i9) {
            C(new org.chromium.net.impl.f("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.C == null) {
            this.C = new k(this, aVar);
        }
        byteBuffer.position(i8 + i7);
        k kVar = this.C;
        kVar.f39272a = byteBuffer;
        J(kVar);
    }

    @CalledByNative
    private void onRedirectReceived(String str, int i7, String str2, String[] strArr, boolean z7, String str3, String str4, long j7) {
        u uVarK = K(i7, str2, strArr, z7, str3, str4, j7);
        this.f39240j.add(str);
        J(new c(uVarK, str));
    }

    @CalledByNative
    private void onResponseStarted(int i7, String str, String[] strArr, boolean z7, String str2, String str3, long j7) {
        this.f39255y = K(i7, str, strArr, z7, str2, str3, j7);
        J(new d());
    }

    @CalledByNative
    private void onStatus(VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, int i7) {
        J(new g(urlRequestStatusListener, i7));
    }

    @CalledByNative
    private void onSucceeded(long j7) {
        this.f39255y.k(j7);
        J(new e());
    }

    private void z() {
        synchronized (this.f39237g) {
            if (this.f39234d || E()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    @s0
    public long D() {
        long j7;
        synchronized (this.f39237g) {
            j7 = this.f39233c;
        }
        return j7;
    }

    void I(Throwable th) {
        org.chromium.net.impl.c cVar = new org.chromium.net.impl.c("Exception received from UploadDataProvider", th);
        org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception in upload method", th);
        C(cVar);
    }

    @s0
    public void L(Runnable runnable) {
        synchronized (this.f39237g) {
            this.D = runnable;
        }
    }

    @s0
    public void M(Runnable runnable) {
        this.f39254x.w(runnable);
    }

    @Override // org.chromium.net.t0
    public void a() {
        synchronized (this.f39237g) {
            if (!E() && this.f39234d) {
                B(2);
            }
        }
    }

    @Override // org.chromium.net.t0
    public void b() {
        synchronized (this.f39237g) {
            if (!this.f39235e) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.f39235e = false;
            if (E()) {
                return;
            }
            nativeFollowDeferredRedirect(this.f39233c);
        }
    }

    @Override // org.chromium.net.t0
    public void c(t0.d dVar) {
        VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener = new VersionSafeCallbacks.UrlRequestStatusListener(dVar);
        synchronized (this.f39237g) {
            long j7 = this.f39233c;
            if (j7 != 0) {
                nativeGetStatus(j7, urlRequestStatusListener);
            } else {
                J(new b(urlRequestStatusListener));
            }
        }
    }

    @Override // org.chromium.net.t0
    public boolean d() {
        boolean zE;
        synchronized (this.f39237g) {
            zE = E();
        }
        return zE;
    }

    @Override // org.chromium.net.t0
    public void e(ByteBuffer byteBuffer) {
        o.b(byteBuffer);
        o.a(byteBuffer);
        synchronized (this.f39237g) {
            if (!this.f39236f) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.f39236f = false;
            if (E()) {
                return;
            }
            if (nativeReadData(this.f39233c, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                return;
            }
            this.f39236f = true;
            throw new IllegalArgumentException("Unable to call native read");
        }
    }

    @Override // org.chromium.net.t0
    public void f() {
        synchronized (this.f39237g) {
            z();
            try {
                boolean z7 = false;
                this.f39233c = nativeCreateRequestAdapter(this.f39238h.H(), this.f39242l, this.f39243m, this.f39247q, this.f39248r, this.f39238h.I() || this.f39253w != null, this.f39249s, this.f39250t, this.f39251u, this.f39252v);
                this.f39238h.M();
                String str = this.f39244n;
                if (str != null && !nativeSetHttpMethod(this.f39233c, str)) {
                    throw new IllegalArgumentException("Invalid http method " + this.f39244n);
                }
                for (Map.Entry<String, String> entry : this.f39245o) {
                    if (entry.getKey().equalsIgnoreCase("Content-Type") && !entry.getValue().isEmpty()) {
                        z7 = true;
                    }
                    if (!nativeAddRequestHeader(this.f39233c, entry.getKey(), entry.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + entry.getKey() + "=" + entry.getValue());
                    }
                }
                CronetUploadDataStream cronetUploadDataStream = this.f39254x;
                if (cronetUploadDataStream == null) {
                    this.f39234d = true;
                    N();
                } else {
                    if (!z7) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.f39234d = true;
                    cronetUploadDataStream.v(new a());
                }
            } catch (RuntimeException e8) {
                B(1);
                throw e8;
            }
        }
    }

    @Override // org.chromium.net.impl.r
    public void g(String str, String str2) {
        z();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.f39245o.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // org.chromium.net.impl.r
    public void i(String str) {
        z();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.f39244n = str;
    }

    @Override // org.chromium.net.impl.r
    public void j(q0 q0Var, Executor executor) {
        if (q0Var == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.f39244n == null) {
            this.f39244n = Const.HTTP_REQUEST_TYPE_POST;
        }
        this.f39254x = new CronetUploadDataStream(q0Var, executor, this);
    }

    void y() {
        if (!this.f39232b && this.f39238h.K(Thread.currentThread())) {
            throw new org.chromium.net.t();
        }
    }
}
