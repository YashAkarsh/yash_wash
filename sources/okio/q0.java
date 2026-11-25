package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f38525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f38526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f38527c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f38524e = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final q0 f38523d = new a();

    public static final class a extends q0 {
        a() {
        }

        @Override // okio.q0
        @a7.d
        public q0 e(long j7) {
            return this;
        }

        @Override // okio.q0
        public void h() {
        }

        @Override // okio.q0
        @a7.d
        public q0 i(long j7, @a7.d TimeUnit unit) {
            kotlin.jvm.internal.l0.p(unit, "unit");
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public final long a(long j7, long j8) {
            return (j7 != 0 && (j8 == 0 || j7 < j8)) ? j7 : j8;
        }

        public /* synthetic */ b(kotlin.jvm.internal.w wVar) {
            this();
        }
    }

    @a7.d
    public q0 a() {
        this.f38525a = false;
        return this;
    }

    @a7.d
    public q0 b() {
        this.f38527c = 0L;
        return this;
    }

    @a7.d
    public final q0 c(long j7, @a7.d TimeUnit unit) {
        kotlin.jvm.internal.l0.p(unit, "unit");
        if (j7 > 0) {
            return e(System.nanoTime() + unit.toNanos(j7));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j7).toString());
    }

    public long d() {
        if (this.f38525a) {
            return this.f38526b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    @a7.d
    public q0 e(long j7) {
        this.f38525a = true;
        this.f38526b = j7;
        return this;
    }

    public boolean f() {
        return this.f38525a;
    }

    public final void g(@a7.d q0 other, @a7.d i5.a<l2> block) {
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(block, "block");
        long j7 = j();
        i(f38524e.a(other.j(), j()), TimeUnit.NANOSECONDS);
        if (!f()) {
            if (other.f()) {
                e(other.d());
            }
            try {
                block.invoke();
                kotlin.jvm.internal.i0.d(1);
                return;
            } finally {
                kotlin.jvm.internal.i0.d(1);
                i(j7, TimeUnit.NANOSECONDS);
                if (other.f()) {
                    a();
                }
                kotlin.jvm.internal.i0.c(1);
            }
        }
        long jD = d();
        if (other.f()) {
            e(Math.min(d(), other.d()));
        }
        try {
            block.invoke();
            kotlin.jvm.internal.i0.d(1);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            i(j7, TimeUnit.NANOSECONDS);
            if (other.f()) {
                e(jD);
            }
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public void h() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f38525a && this.f38526b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @a7.d
    public q0 i(long j7, @a7.d TimeUnit unit) {
        kotlin.jvm.internal.l0.p(unit, "unit");
        if (j7 >= 0) {
            this.f38527c = unit.toNanos(j7);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j7).toString());
    }

    public long j() {
        return this.f38527c;
    }

    public final void k(@a7.d Object monitor) throws InterruptedIOException {
        kotlin.jvm.internal.l0.p(monitor, "monitor");
        try {
            boolean zF = f();
            long j7 = j();
            long jNanoTime = 0;
            if (!zF && j7 == 0) {
                monitor.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zF && j7 != 0) {
                j7 = Math.min(j7, d() - jNanoTime2);
            } else if (zF) {
                j7 = d() - jNanoTime2;
            }
            if (j7 > 0) {
                long j8 = j7 / 1000000;
                Long.signum(j8);
                monitor.wait(j8, (int) (j7 - (1000000 * j8)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= j7) {
                throw new InterruptedIOException(com.alipay.sdk.data.a.f13674p);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
