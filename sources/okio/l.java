package okio;

import java.io.EOFException;

/* JADX INFO: loaded from: classes3.dex */
final class l implements m0 {
    @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.m0, java.io.Flushable
    public void flush() {
    }

    @Override // okio.m0
    @a7.d
    public q0 timeout() {
        return q0.f38523d;
    }

    @Override // okio.m0
    public void write(@a7.d m source, long j7) throws EOFException {
        kotlin.jvm.internal.l0.p(source, "source");
        source.skip(j7);
    }
}
