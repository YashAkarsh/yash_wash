package okio;

import java.io.IOException;
import kotlin.b1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r implements m0 {

    @a7.d
    private final m0 delegate;

    public r(@a7.d m0 delegate) {
        kotlin.jvm.internal.l0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "delegate", imports = {}))
    @h5.h(name = "-deprecated_delegate")
    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final m0 m137deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @a7.d
    @h5.h(name = "delegate")
    public final m0 delegate() {
        return this.delegate;
    }

    @Override // okio.m0, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.m0
    @a7.d
    public q0 timeout() {
        return this.delegate.timeout();
    }

    @a7.d
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // okio.m0
    public void write(@a7.d m source, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        this.delegate.write(source, j7);
    }
}
