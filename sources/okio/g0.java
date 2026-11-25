package okio;

import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.b1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m f38445a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f38446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private m0 f38449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final m0 f38450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final o0 f38451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f38452h;

    public static final class a implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q0 f38453a = new q0();

        a() {
        }

        @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            boolean zF;
            synchronized (g0.this.g()) {
                if (g0.this.k()) {
                    return;
                }
                m0 m0VarI = g0.this.i();
                if (m0VarI == null) {
                    if (g0.this.l() && g0.this.g().B1() > 0) {
                        throw new IOException("source is closed");
                    }
                    g0.this.o(true);
                    m mVarG = g0.this.g();
                    if (mVarG == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    mVarG.notifyAll();
                    m0VarI = null;
                }
                l2 l2Var = l2.f34958a;
                if (m0VarI != null) {
                    g0 g0Var = g0.this;
                    q0 q0VarTimeout = m0VarI.timeout();
                    q0 q0VarTimeout2 = g0Var.q().timeout();
                    long j7 = q0VarTimeout.j();
                    q0VarTimeout.i(q0.f38524e.a(q0VarTimeout2.j(), q0VarTimeout.j()), TimeUnit.NANOSECONDS);
                    if (!q0VarTimeout.f()) {
                        if (q0VarTimeout2.f()) {
                            q0VarTimeout.e(q0VarTimeout2.d());
                        }
                        try {
                            m0VarI.close();
                            if (zF) {
                                return;
                            } else {
                                return;
                            }
                        } finally {
                            q0VarTimeout.i(j7, TimeUnit.NANOSECONDS);
                            if (q0VarTimeout2.f()) {
                                q0VarTimeout.a();
                            }
                        }
                    }
                    long jD = q0VarTimeout.d();
                    if (q0VarTimeout2.f()) {
                        q0VarTimeout.e(Math.min(q0VarTimeout.d(), q0VarTimeout2.d()));
                    }
                    try {
                        m0VarI.close();
                    } finally {
                        q0VarTimeout.i(j7, TimeUnit.NANOSECONDS);
                        if (q0VarTimeout2.f()) {
                            q0VarTimeout.e(jD);
                        }
                    }
                }
            }
        }

        @Override // okio.m0, java.io.Flushable
        public void flush() {
            m0 m0VarI;
            boolean zF;
            synchronized (g0.this.g()) {
                if (!(!g0.this.k())) {
                    throw new IllegalStateException("closed".toString());
                }
                if (g0.this.h()) {
                    throw new IOException("canceled");
                }
                m0VarI = g0.this.i();
                if (m0VarI == null) {
                    if (g0.this.l() && g0.this.g().B1() > 0) {
                        throw new IOException("source is closed");
                    }
                    m0VarI = null;
                }
                l2 l2Var = l2.f34958a;
            }
            if (m0VarI != null) {
                g0 g0Var = g0.this;
                q0 q0VarTimeout = m0VarI.timeout();
                q0 q0VarTimeout2 = g0Var.q().timeout();
                long j7 = q0VarTimeout.j();
                q0VarTimeout.i(q0.f38524e.a(q0VarTimeout2.j(), q0VarTimeout.j()), TimeUnit.NANOSECONDS);
                if (!q0VarTimeout.f()) {
                    if (q0VarTimeout2.f()) {
                        q0VarTimeout.e(q0VarTimeout2.d());
                    }
                    try {
                        m0VarI.flush();
                        if (zF) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        q0VarTimeout.i(j7, TimeUnit.NANOSECONDS);
                        if (q0VarTimeout2.f()) {
                            q0VarTimeout.a();
                        }
                    }
                }
                long jD = q0VarTimeout.d();
                if (q0VarTimeout2.f()) {
                    q0VarTimeout.e(Math.min(q0VarTimeout.d(), q0VarTimeout2.d()));
                }
                try {
                    m0VarI.flush();
                } finally {
                    q0VarTimeout.i(j7, TimeUnit.NANOSECONDS);
                    if (q0VarTimeout2.f()) {
                        q0VarTimeout.e(jD);
                    }
                }
            }
        }

        @Override // okio.m0
        @a7.d
        public q0 timeout() {
            return this.f38453a;
        }

        @Override // okio.m0
        public void write(@a7.d m source, long j7) {
            m0 m0VarI;
            boolean zF;
            kotlin.jvm.internal.l0.p(source, "source");
            synchronized (g0.this.g()) {
                if (!(!g0.this.k())) {
                    throw new IllegalStateException("closed".toString());
                }
                if (g0.this.h()) {
                    throw new IOException("canceled");
                }
                while (true) {
                    if (j7 <= 0) {
                        m0VarI = null;
                        break;
                    }
                    m0VarI = g0.this.i();
                    if (m0VarI != null) {
                        break;
                    }
                    if (g0.this.l()) {
                        throw new IOException("source is closed");
                    }
                    long j8 = g0.this.j() - g0.this.g().B1();
                    if (j8 == 0) {
                        this.f38453a.k(g0.this.g());
                        if (g0.this.h()) {
                            throw new IOException("canceled");
                        }
                    } else {
                        long jMin = Math.min(j8, j7);
                        g0.this.g().write(source, jMin);
                        j7 -= jMin;
                        m mVarG = g0.this.g();
                        if (mVarG == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        mVarG.notifyAll();
                    }
                }
                l2 l2Var = l2.f34958a;
            }
            if (m0VarI != null) {
                g0 g0Var = g0.this;
                q0 q0VarTimeout = m0VarI.timeout();
                q0 q0VarTimeout2 = g0Var.q().timeout();
                long j9 = q0VarTimeout.j();
                q0VarTimeout.i(q0.f38524e.a(q0VarTimeout2.j(), q0VarTimeout.j()), TimeUnit.NANOSECONDS);
                if (!q0VarTimeout.f()) {
                    if (q0VarTimeout2.f()) {
                        q0VarTimeout.e(q0VarTimeout2.d());
                    }
                    try {
                        m0VarI.write(source, j7);
                        if (zF) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        q0VarTimeout.i(j9, TimeUnit.NANOSECONDS);
                        if (q0VarTimeout2.f()) {
                            q0VarTimeout.a();
                        }
                    }
                }
                long jD = q0VarTimeout.d();
                if (q0VarTimeout2.f()) {
                    q0VarTimeout.e(Math.min(q0VarTimeout.d(), q0VarTimeout2.d()));
                }
                try {
                    m0VarI.write(source, j7);
                } finally {
                    q0VarTimeout.i(j9, TimeUnit.NANOSECONDS);
                    if (q0VarTimeout2.f()) {
                        q0VarTimeout.e(jD);
                    }
                }
            }
        }
    }

    public static final class b implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q0 f38455a = new q0();

        b() {
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (g0.this.g()) {
                g0.this.p(true);
                m mVarG = g0.this.g();
                if (mVarG == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                mVarG.notifyAll();
                l2 l2Var = l2.f34958a;
            }
        }

        @Override // okio.o0
        public long read(@a7.d m sink, long j7) {
            kotlin.jvm.internal.l0.p(sink, "sink");
            synchronized (g0.this.g()) {
                if (!(!g0.this.l())) {
                    throw new IllegalStateException("closed".toString());
                }
                if (g0.this.h()) {
                    throw new IOException("canceled");
                }
                while (g0.this.g().B1() == 0) {
                    if (g0.this.k()) {
                        return -1L;
                    }
                    this.f38455a.k(g0.this.g());
                    if (g0.this.h()) {
                        throw new IOException("canceled");
                    }
                }
                long j8 = g0.this.g().read(sink, j7);
                m mVarG = g0.this.g();
                if (mVarG == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                mVarG.notifyAll();
                return j8;
            }
        }

        @Override // okio.o0
        @a7.d
        public q0 timeout() {
            return this.f38455a;
        }
    }

    public g0(long j7) {
        this.f38452h = j7;
        if (j7 >= 1) {
            this.f38450f = new a();
            this.f38451g = new b();
        } else {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j7).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(m0 m0Var, i5.l<? super m0, l2> lVar) {
        q0 q0VarTimeout = m0Var.timeout();
        q0 q0VarTimeout2 = q().timeout();
        long j7 = q0VarTimeout.j();
        q0VarTimeout.i(q0.f38524e.a(q0VarTimeout2.j(), q0VarTimeout.j()), TimeUnit.NANOSECONDS);
        if (!q0VarTimeout.f()) {
            if (q0VarTimeout2.f()) {
                q0VarTimeout.e(q0VarTimeout2.d());
            }
            try {
                lVar.z(m0Var);
                kotlin.jvm.internal.i0.d(1);
                return;
            } finally {
                kotlin.jvm.internal.i0.d(1);
                q0VarTimeout.i(j7, TimeUnit.NANOSECONDS);
                if (q0VarTimeout2.f()) {
                    q0VarTimeout.a();
                }
                kotlin.jvm.internal.i0.c(1);
            }
        }
        long jD = q0VarTimeout.d();
        if (q0VarTimeout2.f()) {
            q0VarTimeout.e(Math.min(q0VarTimeout.d(), q0VarTimeout2.d()));
        }
        try {
            lVar.z(m0Var);
            kotlin.jvm.internal.i0.d(1);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            q0VarTimeout.i(j7, TimeUnit.NANOSECONDS);
            if (q0VarTimeout2.f()) {
                q0VarTimeout.e(jD);
            }
            kotlin.jvm.internal.i0.c(1);
        }
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "sink", imports = {}))
    @h5.h(name = "-deprecated_sink")
    public final m0 a() {
        return this.f38450f;
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = ShareConstants.FEED_SOURCE_PARAM, imports = {}))
    @h5.h(name = "-deprecated_source")
    public final o0 b() {
        return this.f38451g;
    }

    public final void d() {
        synchronized (this.f38445a) {
            this.f38446b = true;
            this.f38445a.q();
            m mVar = this.f38445a;
            if (mVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
            mVar.notifyAll();
            l2 l2Var = l2.f34958a;
        }
    }

    public final void e(@a7.d m0 sink) throws IOException {
        boolean z7;
        m mVar;
        kotlin.jvm.internal.l0.p(sink, "sink");
        while (true) {
            synchronized (this.f38445a) {
                if (!(this.f38449e == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.f38446b) {
                    this.f38449e = sink;
                    throw new IOException("canceled");
                }
                if (this.f38445a.N()) {
                    this.f38448d = true;
                    this.f38449e = sink;
                    return;
                }
                z7 = this.f38447c;
                mVar = new m();
                m mVar2 = this.f38445a;
                mVar.write(mVar2, mVar2.B1());
                m mVar3 = this.f38445a;
                if (mVar3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                mVar3.notifyAll();
                l2 l2Var = l2.f34958a;
            }
            try {
                sink.write(mVar, mVar.B1());
                if (z7) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.f38445a) {
                    this.f38448d = true;
                    m mVar4 = this.f38445a;
                    if (mVar4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    mVar4.notifyAll();
                    l2 l2Var2 = l2.f34958a;
                    throw th;
                }
            }
        }
    }

    @a7.d
    public final m g() {
        return this.f38445a;
    }

    public final boolean h() {
        return this.f38446b;
    }

    @a7.e
    public final m0 i() {
        return this.f38449e;
    }

    public final long j() {
        return this.f38452h;
    }

    public final boolean k() {
        return this.f38447c;
    }

    public final boolean l() {
        return this.f38448d;
    }

    public final void m(boolean z7) {
        this.f38446b = z7;
    }

    public final void n(@a7.e m0 m0Var) {
        this.f38449e = m0Var;
    }

    public final void o(boolean z7) {
        this.f38447c = z7;
    }

    public final void p(boolean z7) {
        this.f38448d = z7;
    }

    @a7.d
    @h5.h(name = "sink")
    public final m0 q() {
        return this.f38450f;
    }

    @a7.d
    @h5.h(name = ShareConstants.FEED_SOURCE_PARAM)
    public final o0 r() {
        return this.f38451g;
    }
}
