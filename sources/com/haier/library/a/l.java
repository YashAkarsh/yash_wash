package com.haier.library.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b0 f26274a;

    public l(b0 b0Var) {
        if (b0Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f26274a = b0Var;
    }

    @Override // com.haier.library.a.b0
    public void I1(g gVar, long j7) throws IOException {
        this.f26274a.I1(gVar, j7);
    }

    @Override // com.haier.library.a.b0
    public d0 a() {
        return this.f26274a.a();
    }

    public final b0 b() {
        return this.f26274a;
    }

    @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26274a.close();
    }

    @Override // com.haier.library.a.b0, java.io.Flushable
    public void flush() throws IOException {
        this.f26274a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f26274a.toString() + ")";
    }
}
