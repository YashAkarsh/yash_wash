package okio;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
final class e0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f38429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q0 f38430b;

    public e0(@a7.d OutputStream out, @a7.d q0 timeout) {
        kotlin.jvm.internal.l0.p(out, "out");
        kotlin.jvm.internal.l0.p(timeout, "timeout");
        this.f38429a = out;
        this.f38430b = timeout;
    }

    @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f38429a.close();
    }

    @Override // okio.m0, java.io.Flushable
    public void flush() throws IOException {
        this.f38429a.flush();
    }

    @Override // okio.m0
    @a7.d
    public q0 timeout() {
        return this.f38430b;
    }

    @a7.d
    public String toString() {
        return "sink(" + this.f38429a + ')';
    }

    @Override // okio.m0
    public void write(@a7.d m source, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        j.e(source.B1(), 0L, j7);
        while (j7 > 0) {
            this.f38430b.h();
            j0 j0Var = source.f38494a;
            kotlin.jvm.internal.l0.m(j0Var);
            int iMin = (int) Math.min(j7, j0Var.f38470c - j0Var.f38469b);
            this.f38429a.write(j0Var.f38468a, j0Var.f38469b, iMin);
            j0Var.f38469b += iMin;
            long j8 = iMin;
            j7 -= j8;
            source.s1(source.B1() - j8);
            if (j0Var.f38469b == j0Var.f38470c) {
                source.f38494a = j0Var.b();
                k0.d(j0Var);
            }
        }
    }
}
