package com.haier.library.a;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f26271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deflater f26272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26273c;

    public k(b0 b0Var, Deflater deflater) {
        this(t.a(b0Var), deflater);
    }

    @z6.a
    private void b(boolean z7) throws IOException {
        y yVarZ1;
        int iDeflate;
        g gVarC = this.f26271a.c();
        while (true) {
            yVarZ1 = gVarC.Z1(1);
            if (z7) {
                Deflater deflater = this.f26272b;
                byte[] bArr = yVarZ1.f26331a;
                int i7 = yVarZ1.f26333c;
                iDeflate = deflater.deflate(bArr, i7, 8192 - i7, 2);
            } else {
                Deflater deflater2 = this.f26272b;
                byte[] bArr2 = yVarZ1.f26331a;
                int i8 = yVarZ1.f26333c;
                iDeflate = deflater2.deflate(bArr2, i8, 8192 - i8);
            }
            if (iDeflate > 0) {
                yVarZ1.f26333c += iDeflate;
                gVarC.f26255b += (long) iDeflate;
                this.f26271a.P();
            } else if (this.f26272b.needsInput()) {
                break;
            }
        }
        if (yVarZ1.f26332b == yVarZ1.f26333c) {
            gVarC.f26254a = yVarZ1.f();
            z.b(yVarZ1);
        }
    }

    @Override // com.haier.library.a.b0
    public void I1(g gVar, long j7) throws IOException {
        c.d(gVar.f26255b, 0L, j7);
        while (j7 > 0) {
            y yVar = gVar.f26254a;
            int iMin = (int) Math.min(j7, yVar.f26333c - yVar.f26332b);
            this.f26272b.setInput(yVar.f26331a, yVar.f26332b, iMin);
            b(false);
            long j8 = iMin;
            gVar.f26255b -= j8;
            int i7 = yVar.f26332b + iMin;
            yVar.f26332b = i7;
            if (i7 == yVar.f26333c) {
                gVar.f26254a = yVar.f();
                z.b(yVar);
            }
            j7 -= j8;
        }
    }

    @Override // com.haier.library.a.b0
    public d0 a() {
        return this.f26271a.a();
    }

    @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f26273c) {
            return;
        }
        e();
        th = null;
        try {
            this.f26272b.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.f26271a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f26273c = true;
        if (th != null) {
            c.e(th);
        }
    }

    void e() throws IOException {
        this.f26272b.finish();
        b(false);
    }

    @Override // com.haier.library.a.b0, java.io.Flushable
    public void flush() throws IOException {
        b(true);
        this.f26271a.flush();
    }

    public String toString() {
        return "DeflaterSink(" + this.f26271a + ")";
    }

    k(h hVar, Deflater deflater) {
        if (hVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f26271a = hVar;
        this.f26272b = deflater;
    }
}
