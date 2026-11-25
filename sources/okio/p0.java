package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f38512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f38513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f38514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f38515d;

    public static final class a extends r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m0 f38517b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(m0 m0Var, m0 m0Var2) {
            super(m0Var2);
            this.f38517b = m0Var;
        }

        @Override // okio.r, okio.m0
        public void write(@a7.d m source, long j7) throws IOException {
            kotlin.jvm.internal.l0.p(source, "source");
            while (j7 > 0) {
                try {
                    long j8 = p0.this.j(j7);
                    super.write(source, j8);
                    j7 -= j8;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        }
    }

    public static final class b extends s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o0 f38519b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(o0 o0Var, o0 o0Var2) {
            super(o0Var2);
            this.f38519b = o0Var;
        }

        @Override // okio.s, okio.o0
        public long read(@a7.d m sink, long j7) throws InterruptedIOException {
            kotlin.jvm.internal.l0.p(sink, "sink");
            try {
                return super.read(sink, p0.this.j(j7));
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }

    public p0(long j7) {
        this.f38515d = j7;
        this.f38513b = PlaybackStateCompat.f450z;
        this.f38514c = PlaybackStateCompat.E;
    }

    public static /* synthetic */ void e(p0 p0Var, long j7, long j8, long j9, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            j8 = p0Var.f38513b;
        }
        long j10 = j8;
        if ((i7 & 4) != 0) {
            j9 = p0Var.f38514c;
        }
        p0Var.d(j7, j10, j9);
    }

    private final long f(long j7) {
        return (j7 * 1000000000) / this.f38512a;
    }

    private final long g(long j7) {
        return (j7 * this.f38512a) / 1000000000;
    }

    private final void k(long j7) throws InterruptedException {
        long j8 = j7 / 1000000;
        wait(j8, (int) (j7 - (1000000 * j8)));
    }

    public final long a(long j7, long j8) {
        if (this.f38512a == 0) {
            return j8;
        }
        long jMax = Math.max(this.f38515d - j7, 0L);
        long jG = this.f38514c - g(jMax);
        if (jG >= j8) {
            this.f38515d = j7 + jMax + f(j8);
            return j8;
        }
        long j9 = this.f38513b;
        if (jG >= j9) {
            this.f38515d = j7 + f(this.f38514c);
            return jG;
        }
        long jMin = Math.min(j9, j8);
        long jF = jMax + f(jMin - this.f38514c);
        if (jF != 0) {
            return -jF;
        }
        this.f38515d = j7 + f(this.f38514c);
        return jMin;
    }

    @h5.i
    public final void b(long j7) {
        e(this, j7, 0L, 0L, 6, null);
    }

    @h5.i
    public final void c(long j7, long j8) {
        e(this, j7, j8, 0L, 4, null);
    }

    @h5.i
    public final void d(long j7, long j8, long j9) {
        synchronized (this) {
            try {
                if (!(j7 >= 0)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (!(j8 > 0)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (!(j9 >= j8)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                this.f38512a = j7;
                this.f38513b = j8;
                this.f38514c = j9;
                notifyAll();
                l2 l2Var = l2.f34958a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @a7.d
    public final m0 h(@a7.d m0 sink) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        return new a(sink, sink);
    }

    @a7.d
    public final o0 i(@a7.d o0 source) {
        kotlin.jvm.internal.l0.p(source, "source");
        return new b(source, source);
    }

    public final long j(long j7) {
        long jA;
        if (!(j7 > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            while (true) {
                jA = a(System.nanoTime(), j7);
                if (jA < 0) {
                    k(-jA);
                }
            }
        }
        return jA;
    }

    public p0() {
        this(System.nanoTime());
    }
}
