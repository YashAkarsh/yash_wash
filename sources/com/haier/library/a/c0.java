package com.haier.library.a;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface c0 extends Closeable {
    long P0(g gVar, long j7) throws IOException;

    d0 a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
