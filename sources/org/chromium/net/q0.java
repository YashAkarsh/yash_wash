package org.chromium.net;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q0 implements Closeable {
    public abstract long b() throws IOException;

    public abstract void c(s0 s0Var, ByteBuffer byteBuffer) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract void e(s0 s0Var) throws IOException;
}
