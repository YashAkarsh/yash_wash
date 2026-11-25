package okio;

import java.io.IOException;
import kotlin.b1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s implements o0 {

    @a7.d
    private final o0 delegate;

    public s(@a7.d o0 delegate) {
        kotlin.jvm.internal.l0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "delegate", imports = {}))
    @h5.h(name = "-deprecated_delegate")
    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final o0 m138deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @a7.d
    @h5.h(name = "delegate")
    public final o0 delegate() {
        return this.delegate;
    }

    @Override // okio.o0
    public long read(@a7.d m sink, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        return this.delegate.read(sink, j7);
    }

    @Override // okio.o0
    @a7.d
    public q0 timeout() {
        return this.delegate.timeout();
    }

    @a7.d
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
