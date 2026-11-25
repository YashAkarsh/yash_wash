package org.chromium.net.impl;

import com.haier.uhome.account.api.Const;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.s0;
import org.chromium.net.k0;
import org.chromium.net.u0;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("cronet")
@s0
public class CronetBidirectionalStream extends org.chromium.net.n {
    static final /* synthetic */ boolean A = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CronetUrlRequestContext f39162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f39163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final VersionSafeCallbacks.a f39164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f39165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f39166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f39167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String[] f39168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f39169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Collection<Object> f39170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f39171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f39172k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f39173l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f39174m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private org.chromium.net.k f39175n;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @GuardedBy("mNativeStreamLock")
    private boolean f39179r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @GuardedBy("mNativeStreamLock")
    private boolean f39180s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @GuardedBy("mNativeStreamLock")
    private k0.b f39181t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @GuardedBy("mNativeStreamLock")
    private long f39182u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private u f39185x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private f f39186y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Runnable f39187z;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Object f39176o = new Object();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @GuardedBy("mNativeStreamLock")
    private int f39183v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @GuardedBy("mNativeStreamLock")
    private int f39184w = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> f39177p = new LinkedList<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> f39178q = new LinkedList<>();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f39188a;

        a(boolean z7) {
            this.f39188a = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.f39176o) {
                if (CronetBidirectionalStream.this.D()) {
                    return;
                }
                CronetBidirectionalStream.this.f39180s = this.f39188a;
                CronetBidirectionalStream.this.f39183v = 2;
                if (CronetBidirectionalStream.x(CronetBidirectionalStream.this.f39167f) || !CronetBidirectionalStream.this.f39180s) {
                    CronetBidirectionalStream.this.f39184w = 8;
                } else {
                    CronetBidirectionalStream.this.f39184w = 10;
                }
                try {
                    CronetBidirectionalStream.this.f39164c.f(CronetBidirectionalStream.this);
                } catch (Exception e8) {
                    CronetBidirectionalStream.this.F(e8);
                }
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.f39176o) {
                if (CronetBidirectionalStream.this.D()) {
                    return;
                }
                CronetBidirectionalStream.this.f39183v = 2;
                try {
                    VersionSafeCallbacks.a aVar = CronetBidirectionalStream.this.f39164c;
                    CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                    aVar.d(cronetBidirectionalStream, cronetBidirectionalStream.f39185x);
                } catch (Exception e8) {
                    CronetBidirectionalStream.this.F(e8);
                }
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0.a f39191a;

        c(u0.a aVar) {
            this.f39191a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.f39176o) {
                if (CronetBidirectionalStream.this.D()) {
                    return;
                }
                try {
                    VersionSafeCallbacks.a aVar = CronetBidirectionalStream.this.f39164c;
                    CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                    aVar.e(cronetBidirectionalStream, cronetBidirectionalStream.f39185x, this.f39191a);
                } catch (Exception e8) {
                    CronetBidirectionalStream.this.F(e8);
                }
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                VersionSafeCallbacks.a aVar = CronetBidirectionalStream.this.f39164c;
                CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                aVar.a(cronetBidirectionalStream, cronetBidirectionalStream.f39185x);
            } catch (Exception e8) {
                org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception in onCanceled method", e8);
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.chromium.net.k f39194a;

        e(org.chromium.net.k kVar) {
            this.f39194a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetBidirectionalStream.this.z(this.f39194a);
        }
    }

    private final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ByteBuffer f39196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f39197b;

        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer byteBuffer = this.f39196a;
                this.f39196a = null;
                synchronized (CronetBidirectionalStream.this.f39176o) {
                    if (CronetBidirectionalStream.this.D()) {
                        return;
                    }
                    boolean z7 = false;
                    if (this.f39197b) {
                        CronetBidirectionalStream.this.f39183v = 4;
                        if (CronetBidirectionalStream.this.f39184w == 10) {
                            z7 = true;
                        }
                    } else {
                        CronetBidirectionalStream.this.f39183v = 2;
                    }
                    VersionSafeCallbacks.a aVar = CronetBidirectionalStream.this.f39164c;
                    CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                    aVar.c(cronetBidirectionalStream, cronetBidirectionalStream.f39185x, byteBuffer, this.f39197b);
                    if (z7) {
                        CronetBidirectionalStream.this.E();
                    }
                }
            } catch (Exception e8) {
                CronetBidirectionalStream.this.F(e8);
            }
        }

        /* synthetic */ f(CronetBidirectionalStream cronetBidirectionalStream, a aVar) {
            this();
        }
    }

    private final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ByteBuffer f39199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f39200b;

        g(ByteBuffer byteBuffer, boolean z7) {
            this.f39199a = byteBuffer;
            this.f39200b = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer byteBuffer = this.f39199a;
                this.f39199a = null;
                synchronized (CronetBidirectionalStream.this.f39176o) {
                    if (CronetBidirectionalStream.this.D()) {
                        return;
                    }
                    boolean z7 = false;
                    if (this.f39200b) {
                        CronetBidirectionalStream.this.f39184w = 10;
                        if (CronetBidirectionalStream.this.f39183v == 4) {
                            z7 = true;
                        }
                    }
                    VersionSafeCallbacks.a aVar = CronetBidirectionalStream.this.f39164c;
                    CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                    aVar.h(cronetBidirectionalStream, cronetBidirectionalStream.f39185x, byteBuffer, this.f39200b);
                    if (z7) {
                        CronetBidirectionalStream.this.E();
                    }
                }
            } catch (Exception e8) {
                CronetBidirectionalStream.this.F(e8);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface h {
        public static final int A6 = 4;
        public static final int B6 = 5;
        public static final int C6 = 6;
        public static final int D6 = 7;
        public static final int E6 = 8;
        public static final int F6 = 9;
        public static final int G6 = 10;

        /* JADX INFO: renamed from: w6, reason: collision with root package name */
        public static final int f39202w6 = 0;

        /* JADX INFO: renamed from: x6, reason: collision with root package name */
        public static final int f39203x6 = 1;

        /* JADX INFO: renamed from: y6, reason: collision with root package name */
        public static final int f39204y6 = 2;

        /* JADX INFO: renamed from: z6, reason: collision with root package name */
        public static final int f39205z6 = 3;
    }

    CronetBidirectionalStream(CronetUrlRequestContext cronetUrlRequestContext, String str, int i7, org.chromium.net.d.b bVar, Executor executor, String str2, List<Map.Entry<String, String>> list, boolean z7, Collection<Object> collection, boolean z8, int i8, boolean z9, int i9) {
        this.f39162a = cronetUrlRequestContext;
        this.f39165d = str;
        this.f39166e = v(i7);
        this.f39164c = new VersionSafeCallbacks.a(bVar);
        this.f39163b = executor;
        this.f39167f = str2;
        this.f39168g = K(list);
        this.f39169h = z7;
        this.f39170i = collection;
        this.f39171j = z8;
        this.f39172k = i8;
        this.f39173l = z9;
        this.f39174m = i9;
    }

    private static ArrayList<Map.Entry<String, String>> C(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i7 = 0; i7 < strArr.length; i7 += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i7], strArr[i7 + 1]));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean D() {
        return this.f39183v != 0 && this.f39182u == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        synchronized (this.f39176o) {
            if (D()) {
                return;
            }
            if (this.f39184w == 10 && this.f39183v == 4) {
                this.f39184w = 7;
                this.f39183v = 7;
                w(false);
                try {
                    this.f39164c.g(this, this.f39185x);
                } catch (Exception e8) {
                    org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception in onSucceeded method", e8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Exception exc) {
        org.chromium.net.impl.c cVar = new org.chromium.net.impl.c("CalledByNative method has thrown an exception", exc);
        org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception in CalledByNative method", exc);
        z(cVar);
    }

    private void G(Runnable runnable) {
        try {
            this.f39163b.execute(runnable);
        } catch (RejectedExecutionException e8) {
            org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception posting task to executor", e8);
            synchronized (this.f39176o) {
                this.f39184w = 6;
                this.f39183v = 6;
                w(false);
            }
        }
    }

    private u H(int i7, String str, String[] strArr, long j7) {
        return new u(Arrays.asList(this.f39165d), i7, "", C(strArr), false, str, null, j7);
    }

    private void I() {
        int size = this.f39178q.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            ByteBuffer byteBufferPoll = this.f39178q.poll();
            byteBufferArr[i7] = byteBufferPoll;
            iArr[i7] = byteBufferPoll.position();
            iArr2[i7] = byteBufferPoll.limit();
        }
        this.f39184w = 9;
        this.f39180s = true;
        if (nativeWritevData(this.f39182u, byteBufferArr, iArr, iArr2, this.f39179r && this.f39177p.isEmpty())) {
            return;
        }
        this.f39184w = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    }

    private static String[] K(List<Map.Entry<String, String>> list) {
        String[] strArr = new String[list.size() * 2];
        int i7 = 0;
        for (Map.Entry<String, String> entry : list) {
            int i8 = i7 + 1;
            strArr[i7] = entry.getKey();
            i7 = i8 + 1;
            strArr[i8] = entry.getValue();
        }
        return strArr;
    }

    private native long nativeCreateBidirectionalStream(long j7, boolean z7, boolean z8, boolean z9, int i7, boolean z10, int i8);

    @x6.f("CronetBidirectionalStreamAdapter")
    private native void nativeDestroy(long j7, boolean z7);

    @x6.f("CronetBidirectionalStreamAdapter")
    private native boolean nativeReadData(long j7, ByteBuffer byteBuffer, int i7, int i8);

    @x6.f("CronetBidirectionalStreamAdapter")
    private native void nativeSendRequestHeaders(long j7);

    @x6.f("CronetBidirectionalStreamAdapter")
    private native int nativeStart(long j7, String str, int i7, String str2, String[] strArr, boolean z7);

    @x6.f("CronetBidirectionalStreamAdapter")
    private native boolean nativeWritevData(long j7, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z7);

    @CalledByNative
    private void onCanceled() {
        G(new d());
    }

    @CalledByNative
    private void onError(int i7, int i8, int i9, String str, long j7) {
        u uVar = this.f39185x;
        if (uVar != null) {
            uVar.k(j7);
        }
        if (i7 == 10 || i7 == 3) {
            y(new p("Exception in BidirectionalStream: " + str, i7, i8, i9));
            return;
        }
        y(new org.chromium.net.impl.b("Exception in BidirectionalStream: " + str, i7, i8));
    }

    @CalledByNative
    private void onMetricsCollected(long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, boolean z7, long j20, long j21) {
        int i7;
        synchronized (this.f39176o) {
            if (this.f39181t != null) {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
            org.chromium.net.impl.g gVar = new org.chromium.net.impl.g(j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, z7, j20, j21);
            this.f39181t = gVar;
            int i8 = this.f39183v;
            if (i8 == 7) {
                i7 = 0;
            } else {
                i7 = i8 == 5 ? 2 : 1;
            }
            this.f39162a.O(new q(this.f39165d, this.f39170i, gVar, i7, this.f39185x, this.f39175n));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i7, int i8, int i9, long j7) {
        int i10;
        this.f39185x.k(j7);
        if (byteBuffer.position() != i8 || byteBuffer.limit() != i9) {
            y(new org.chromium.net.impl.f("ByteBuffer modified externally during read", null));
            return;
        }
        if (i7 < 0 || (i10 = i8 + i7) > i9) {
            y(new org.chromium.net.impl.f("Invalid number of bytes read", null));
            return;
        }
        byteBuffer.position(i10);
        f fVar = this.f39186y;
        fVar.f39196a = byteBuffer;
        fVar.f39197b = i7 == 0;
        G(fVar);
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i7, String str, String[] strArr, long j7) {
        try {
            this.f39185x = H(i7, str, strArr, j7);
            G(new b());
        } catch (Exception unused) {
            y(new org.chromium.net.impl.f("Cannot prepare ResponseInfo", null));
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        G(new c(new u.a(C(strArr))));
    }

    @CalledByNative
    private void onStreamReady(boolean z7) {
        G(new a(z7));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0044  */
    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z7) {
        boolean z8;
        synchronized (this.f39176o) {
            if (D()) {
                return;
            }
            this.f39184w = 8;
            if (!this.f39178q.isEmpty()) {
                I();
            }
            for (int i7 = 0; i7 < byteBufferArr.length; i7++) {
                ByteBuffer byteBuffer = byteBufferArr[i7];
                if (byteBuffer.position() != iArr[i7] || byteBuffer.limit() != iArr2[i7]) {
                    y(new org.chromium.net.impl.f("ByteBuffer modified externally during write", null));
                    return;
                }
                byteBuffer.position(byteBuffer.limit());
                if (z7) {
                    z8 = true;
                    if (i7 != byteBufferArr.length - 1) {
                        z8 = false;
                    }
                } else {
                    z8 = false;
                }
                G(new g(byteBuffer, z8));
            }
        }
    }

    private static int v(int i7) {
        if (i7 == 0) {
            return 1;
        }
        if (i7 == 1) {
            return 2;
        }
        if (i7 == 2) {
            return 3;
        }
        if (i7 == 3) {
            return 4;
        }
        if (i7 == 4) {
            return 5;
        }
        throw new IllegalArgumentException("Invalid stream priority.");
    }

    @GuardedBy("mNativeStreamLock")
    private void w(boolean z7) {
        org.chromium.base.t.p(CronetUrlRequestContext.D, "destroyNativeStreamLocked " + toString(), new Object[0]);
        long j7 = this.f39182u;
        if (j7 == 0) {
            return;
        }
        nativeDestroy(j7, z7);
        this.f39162a.L();
        this.f39182u = 0L;
        Runnable runnable = this.f39187z;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean x(String str) {
        return (str.equals(Const.HTTP_REQUEST_TYPE_GET) || str.equals("HEAD")) ? false : true;
    }

    private void y(org.chromium.net.k kVar) {
        G(new e(kVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(org.chromium.net.k kVar) {
        this.f39175n = kVar;
        synchronized (this.f39176o) {
            if (D()) {
                return;
            }
            this.f39184w = 6;
            this.f39183v = 6;
            w(false);
            try {
                this.f39164c.b(this, this.f39185x, kVar);
            } catch (Exception e8) {
                org.chromium.base.t.j(CronetUrlRequestContext.D, "Exception notifying of failed request", e8);
            }
        }
    }

    @s0
    public List<ByteBuffer> A() {
        LinkedList linkedList;
        synchronized (this.f39176o) {
            linkedList = new LinkedList();
            Iterator<ByteBuffer> it = this.f39178q.iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().asReadOnlyBuffer());
            }
        }
        return linkedList;
    }

    @s0
    public List<ByteBuffer> B() {
        LinkedList linkedList;
        synchronized (this.f39176o) {
            linkedList = new LinkedList();
            Iterator<ByteBuffer> it = this.f39177p.iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().asReadOnlyBuffer());
            }
        }
        return linkedList;
    }

    @s0
    public void J(Runnable runnable) {
        this.f39187z = runnable;
    }

    @Override // org.chromium.net.d
    public void a() {
        synchronized (this.f39176o) {
            if (!D() && this.f39183v != 0) {
                this.f39184w = 5;
                this.f39183v = 5;
                w(true);
            }
        }
    }

    @Override // org.chromium.net.d
    public void b() {
        int i7;
        synchronized (this.f39176o) {
            if (!D() && ((i7 = this.f39184w) == 8 || i7 == 9)) {
                if (this.f39177p.isEmpty() && this.f39178q.isEmpty()) {
                    if (!this.f39180s) {
                        this.f39180s = true;
                        nativeSendRequestHeaders(this.f39182u);
                        if (!x(this.f39167f)) {
                            this.f39184w = 10;
                        }
                    }
                    return;
                }
                if (!this.f39177p.isEmpty()) {
                    this.f39178q.addAll(this.f39177p);
                    this.f39177p.clear();
                }
                if (this.f39184w == 9) {
                    return;
                }
                I();
            }
        }
    }

    @Override // org.chromium.net.d
    public boolean c() {
        boolean zD;
        synchronized (this.f39176o) {
            zD = D();
        }
        return zD;
    }

    @Override // org.chromium.net.d
    public void d(ByteBuffer byteBuffer) {
        synchronized (this.f39176o) {
            o.b(byteBuffer);
            o.a(byteBuffer);
            if (this.f39183v != 2) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            if (D()) {
                return;
            }
            if (this.f39186y == null) {
                this.f39186y = new f(this, null);
            }
            this.f39183v = 3;
            if (nativeReadData(this.f39182u, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                return;
            }
            this.f39183v = 2;
            throw new IllegalArgumentException("Unable to call native read");
        }
    }

    @Override // org.chromium.net.d
    public void e() {
        synchronized (this.f39176o) {
            if (this.f39183v != 0) {
                throw new IllegalStateException("Stream is already started.");
            }
            try {
                this.f39182u = nativeCreateBidirectionalStream(this.f39162a.H(), !this.f39169h, this.f39162a.I(), this.f39171j, this.f39172k, this.f39173l, this.f39174m);
                this.f39162a.M();
                long j7 = this.f39182u;
                String str = this.f39165d;
                int i7 = this.f39166e;
                String str2 = this.f39167f;
                int iNativeStart = nativeStart(j7, str, i7, str2, this.f39168g, !x(str2));
                if (iNativeStart == -1) {
                    throw new IllegalArgumentException("Invalid http method " + this.f39167f);
                }
                if (iNativeStart > 0) {
                    int i8 = iNativeStart - 1;
                    throw new IllegalArgumentException("Invalid header " + this.f39168g[i8] + "=" + this.f39168g[i8 + 1]);
                }
                this.f39184w = 1;
                this.f39183v = 1;
            } catch (RuntimeException e8) {
                w(false);
                throw e8;
            }
        }
    }

    @Override // org.chromium.net.d
    public void f(ByteBuffer byteBuffer, boolean z7) {
        synchronized (this.f39176o) {
            o.a(byteBuffer);
            if (!byteBuffer.hasRemaining() && !z7) {
                throw new IllegalArgumentException("Empty buffer before end of stream.");
            }
            if (this.f39179r) {
                throw new IllegalArgumentException("Write after writing end of stream.");
            }
            if (D()) {
                return;
            }
            this.f39177p.add(byteBuffer);
            if (z7) {
                this.f39179r = true;
            }
        }
    }
}
