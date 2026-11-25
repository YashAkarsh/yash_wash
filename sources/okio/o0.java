package okio;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface o0 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(@a7.d m mVar, long j7) throws IOException;

    @a7.d
    q0 timeout();
}
