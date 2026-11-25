package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.a1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public class k extends q0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f38475i = 65536;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f38476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f38477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static k f38478l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f38479m = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f38480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private k f38481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f38482h;

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(k kVar) {
            synchronized (k.class) {
                for (k kVar2 = k.f38478l; kVar2 != null; kVar2 = kVar2.f38481g) {
                    if (kVar2.f38481g == kVar) {
                        kVar2.f38481g = kVar.f38481g;
                        kVar.f38481g = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(k kVar, long j7, boolean z7) {
            synchronized (k.class) {
                if (k.f38478l == null) {
                    k.f38478l = new k();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j7 != 0 && z7) {
                    kVar.f38482h = Math.min(j7, kVar.d() - jNanoTime) + jNanoTime;
                } else if (j7 != 0) {
                    kVar.f38482h = j7 + jNanoTime;
                } else {
                    if (!z7) {
                        throw new AssertionError();
                    }
                    kVar.f38482h = kVar.d();
                }
                long jY = kVar.y(jNanoTime);
                k kVar2 = k.f38478l;
                kotlin.jvm.internal.l0.m(kVar2);
                while (kVar2.f38481g != null) {
                    k kVar3 = kVar2.f38481g;
                    kotlin.jvm.internal.l0.m(kVar3);
                    if (jY < kVar3.y(jNanoTime)) {
                        break;
                    }
                    kVar2 = kVar2.f38481g;
                    kotlin.jvm.internal.l0.m(kVar2);
                }
                kVar.f38481g = kVar2.f38481g;
                kVar2.f38481g = kVar;
                if (kVar2 == k.f38478l) {
                    k.class.notify();
                }
                l2 l2Var = l2.f34958a;
            }
        }

        @a7.e
        public final k c() throws InterruptedException {
            k kVar = k.f38478l;
            kotlin.jvm.internal.l0.m(kVar);
            k kVar2 = kVar.f38481g;
            if (kVar2 == null) {
                long jNanoTime = System.nanoTime();
                k.class.wait(k.f38476j);
                k kVar3 = k.f38478l;
                kotlin.jvm.internal.l0.m(kVar3);
                if (kVar3.f38481g != null || System.nanoTime() - jNanoTime < k.f38477k) {
                    return null;
                }
                return k.f38478l;
            }
            long jY = kVar2.y(System.nanoTime());
            if (jY > 0) {
                long j7 = jY / 1000000;
                k.class.wait(j7, (int) (jY - (1000000 * j7)));
                return null;
            }
            k kVar4 = k.f38478l;
            kotlin.jvm.internal.l0.m(kVar4);
            kVar4.f38481g = kVar2.f38481g;
            kVar2.f38481g = null;
            return kVar2;
        }

        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }
    }

    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            k kVarC;
            while (true) {
                try {
                    synchronized (k.class) {
                        kVarC = k.f38479m.c();
                        if (kVarC == k.f38478l) {
                            k.f38478l = null;
                            return;
                        }
                        l2 l2Var = l2.f34958a;
                    }
                    if (kVarC != null) {
                        kVarC.B();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static final class c implements m0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m0 f38484b;

        c(m0 m0Var) {
            this.f38484b = m0Var;
        }

        @Override // okio.m0
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k timeout() {
            return k.this;
        }

        @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            k kVar = k.this;
            kVar.v();
            try {
                try {
                    this.f38484b.close();
                    l2 l2Var = l2.f34958a;
                    if (kVar.w()) {
                        throw kVar.q(null);
                    }
                } catch (IOException e8) {
                    if (!kVar.w()) {
                        throw e8;
                    }
                    throw kVar.q(e8);
                }
            } catch (Throwable th) {
                kVar.w();
                throw th;
            }
        }

        @Override // okio.m0, java.io.Flushable
        public void flush() throws IOException {
            k kVar = k.this;
            kVar.v();
            try {
                try {
                    this.f38484b.flush();
                    l2 l2Var = l2.f34958a;
                    if (kVar.w()) {
                        throw kVar.q(null);
                    }
                } catch (IOException e8) {
                    if (!kVar.w()) {
                        throw e8;
                    }
                    throw kVar.q(e8);
                }
            } catch (Throwable th) {
                kVar.w();
                throw th;
            }
        }

        @a7.d
        public String toString() {
            return "AsyncTimeout.sink(" + this.f38484b + ')';
        }

        @Override // okio.m0
        public void write(@a7.d m source, long j7) throws IOException {
            kotlin.jvm.internal.l0.p(source, "source");
            j.e(source.B1(), 0L, j7);
            while (true) {
                long j8 = 0;
                if (j7 <= 0) {
                    return;
                }
                j0 j0Var = source.f38494a;
                kotlin.jvm.internal.l0.m(j0Var);
                while (j8 < 65536) {
                    j8 += (long) (j0Var.f38470c - j0Var.f38469b);
                    if (j8 >= j7) {
                        j8 = j7;
                        break;
                    } else {
                        j0Var = j0Var.f38473f;
                        kotlin.jvm.internal.l0.m(j0Var);
                    }
                }
                k kVar = k.this;
                kVar.v();
                try {
                    try {
                        this.f38484b.write(source, j8);
                        l2 l2Var = l2.f34958a;
                        if (kVar.w()) {
                            throw kVar.q(null);
                        }
                        j7 -= j8;
                    } catch (IOException e8) {
                        if (!kVar.w()) {
                            throw e8;
                        }
                        throw kVar.q(e8);
                    }
                } catch (Throwable th) {
                    kVar.w();
                    throw th;
                }
            }
        }
    }

    public static final class d implements o0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o0 f38486b;

        d(o0 o0Var) {
            this.f38486b = o0Var;
        }

        @Override // okio.o0
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k timeout() {
            return k.this;
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            k kVar = k.this;
            kVar.v();
            try {
                try {
                    this.f38486b.close();
                    l2 l2Var = l2.f34958a;
                    if (kVar.w()) {
                        throw kVar.q(null);
                    }
                } catch (IOException e8) {
                    if (!kVar.w()) {
                        throw e8;
                    }
                    throw kVar.q(e8);
                }
            } catch (Throwable th) {
                kVar.w();
                throw th;
            }
        }

        @Override // okio.o0
        public long read(@a7.d m sink, long j7) throws IOException {
            kotlin.jvm.internal.l0.p(sink, "sink");
            k kVar = k.this;
            kVar.v();
            try {
                try {
                    long j8 = this.f38486b.read(sink, j7);
                    if (kVar.w()) {
                        throw kVar.q(null);
                    }
                    return j8;
                } catch (IOException e8) {
                    if (kVar.w()) {
                        throw kVar.q(e8);
                    }
                    throw e8;
                }
            } catch (Throwable th) {
                kVar.w();
                throw th;
            }
        }

        @a7.d
        public String toString() {
            return "AsyncTimeout.source(" + this.f38486b + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f38476j = millis;
        f38477k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long y(long j7) {
        return this.f38482h - j7;
    }

    @a7.d
    public final o0 A(@a7.d o0 source) {
        kotlin.jvm.internal.l0.p(source, "source");
        return new d(source);
    }

    protected void B() {
    }

    public final <T> T C(@a7.d i5.a<? extends T> block) throws IOException {
        kotlin.jvm.internal.l0.p(block, "block");
        v();
        try {
            try {
                T tInvoke = block.invoke();
                kotlin.jvm.internal.i0.d(1);
                if (w()) {
                    throw q(null);
                }
                kotlin.jvm.internal.i0.c(1);
                return tInvoke;
            } catch (IOException e8) {
                if (w()) {
                    throw q(e8);
                }
                throw e8;
            }
        } catch (Throwable th) {
            kotlin.jvm.internal.i0.d(1);
            w();
            kotlin.jvm.internal.i0.c(1);
            throw th;
        }
    }

    @a7.d
    @a1
    public final IOException q(@a7.e IOException iOException) {
        return x(iOException);
    }

    public final void v() {
        if (!(!this.f38480f)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long j7 = j();
        boolean zF = f();
        if (j7 != 0 || zF) {
            this.f38480f = true;
            f38479m.e(this, j7, zF);
        }
    }

    public final boolean w() {
        if (!this.f38480f) {
            return false;
        }
        this.f38480f = false;
        return f38479m.d(this);
    }

    @a7.d
    protected IOException x(@a7.e IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(com.alipay.sdk.data.a.f13674p);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @a7.d
    public final m0 z(@a7.d m0 sink) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        return new c(sink);
    }
}
