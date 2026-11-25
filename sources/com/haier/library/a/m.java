package com.haier.library.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c0 f26275a;

    public m(c0 c0Var) {
        if (c0Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f26275a = c0Var;
    }

    @Override // com.haier.library.a.c0
    public long P0(g gVar, long j7) throws IOException {
        return this.f26275a.P0(gVar, j7);
    }

    @Override // com.haier.library.a.c0
    public d0 a() {
        return this.f26275a.a();
    }

    public final c0 b() {
        return this.f26275a;
    }

    @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26275a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f26275a.toString() + ")";
    }
}
