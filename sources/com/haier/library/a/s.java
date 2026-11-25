package com.haier.library.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f26299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Inflater f26300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f26301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26302d;

    public s(c0 c0Var, Inflater inflater) {
        this(t.b(c0Var), inflater);
    }

    private void e() throws IOException {
        int i7 = this.f26301c;
        if (i7 == 0) {
            return;
        }
        int remaining = i7 - this.f26300b.getRemaining();
        this.f26301c -= remaining;
        this.f26299a.j0(remaining);
    }

    @Override // com.haier.library.a.c0
    public long P0(g gVar, long j7) throws IOException {
        boolean zB;
        if (j7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        }
        if (this.f26302d) {
            throw new IllegalStateException("closed");
        }
        if (j7 == 0) {
            return 0L;
        }
        do {
            zB = b();
            try {
                y yVarZ1 = gVar.Z1(1);
                int iInflate = this.f26300b.inflate(yVarZ1.f26331a, yVarZ1.f26333c, (int) Math.min(j7, 8192 - yVarZ1.f26333c));
                if (iInflate > 0) {
                    yVarZ1.f26333c += iInflate;
                    long j8 = iInflate;
                    gVar.f26255b += j8;
                    return j8;
                }
                if (!this.f26300b.finished() && !this.f26300b.needsDictionary()) {
                }
                e();
                if (yVarZ1.f26332b != yVarZ1.f26333c) {
                    return -1L;
                }
                gVar.f26254a = yVarZ1.f();
                z.b(yVarZ1);
                return -1L;
            } catch (DataFormatException e8) {
                throw new IOException(e8);
            }
        } while (!zB);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // com.haier.library.a.c0
    public d0 a() {
        return this.f26299a.a();
    }

    public final boolean b() throws IOException {
        if (!this.f26300b.needsInput()) {
            return false;
        }
        e();
        if (this.f26300b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f26299a.g()) {
            return true;
        }
        y yVar = this.f26299a.c().f26254a;
        int i7 = yVar.f26333c;
        int i8 = yVar.f26332b;
        int i9 = i7 - i8;
        this.f26301c = i9;
        this.f26300b.setInput(yVar.f26331a, i8, i9);
        return false;
    }

    @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26302d) {
            return;
        }
        this.f26300b.end();
        this.f26302d = true;
        this.f26299a.close();
    }

    s(i iVar, Inflater inflater) {
        if (iVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f26299a = iVar;
        this.f26300b = inflater;
    }
}
