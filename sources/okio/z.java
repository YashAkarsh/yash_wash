package okio;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
final class z implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f38557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q0 f38558b;

    public z(@a7.d InputStream input, @a7.d q0 timeout) {
        kotlin.jvm.internal.l0.p(input, "input");
        kotlin.jvm.internal.l0.p(timeout, "timeout");
        this.f38557a = input;
        this.f38558b = timeout;
    }

    @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f38557a.close();
    }

    @Override // okio.o0
    public long read(@a7.d m sink, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        if (j7 == 0) {
            return 0L;
        }
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        try {
            this.f38558b.h();
            j0 j0VarW1 = sink.W1(1);
            int i7 = this.f38557a.read(j0VarW1.f38468a, j0VarW1.f38470c, (int) Math.min(j7, 8192 - j0VarW1.f38470c));
            if (i7 != -1) {
                j0VarW1.f38470c += i7;
                long j8 = i7;
                sink.s1(sink.B1() + j8);
                return j8;
            }
            if (j0VarW1.f38469b != j0VarW1.f38470c) {
                return -1L;
            }
            sink.f38494a = j0VarW1.b();
            k0.d(j0VarW1);
            return -1L;
        } catch (AssertionError e8) {
            if (a0.e(e8)) {
                throw new IOException(e8);
            }
            throw e8;
        }
    }

    @Override // okio.o0
    @a7.d
    public q0 timeout() {
        return this.f38558b;
    }

    @a7.d
    public String toString() {
        return "source(" + this.f38557a + ')';
    }
}
