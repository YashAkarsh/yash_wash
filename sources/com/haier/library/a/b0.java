package com.haier.library.a;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface b0 extends Closeable, Flushable {
    void I1(g gVar, long j7) throws IOException;

    d0 a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;
}
