package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface m0 extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    @a7.d
    q0 timeout();

    void write(@a7.d m mVar, long j7) throws IOException;
}
