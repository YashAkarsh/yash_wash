package com.haier.library.a;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f26277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deflater f26278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f26279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CRC32 f26281e = new CRC32();

    public o(b0 b0Var) {
        if (b0Var == null) {
            throw new IllegalArgumentException("sink == null");
        }
        Deflater deflater = new Deflater(-1, true);
        this.f26278b = deflater;
        h hVarA = t.a(b0Var);
        this.f26277a = hVarA;
        this.f26279c = new k(hVarA, deflater);
        e();
    }

    private void e() {
        g gVarC = this.f26277a.c();
        gVarC.l1(8075);
        gVarC.y1(8);
        gVarC.y1(0);
        gVarC.z0(0);
        gVarC.y1(0);
        gVarC.y1(0);
    }

    private void q() throws IOException {
        this.f26277a.i0((int) this.f26281e.getValue());
        this.f26277a.i0((int) this.f26278b.getBytesRead());
    }

    private void y0(g gVar, long j7) {
        y yVar = gVar.f26254a;
        while (j7 > 0) {
            int iMin = (int) Math.min(j7, yVar.f26333c - yVar.f26332b);
            this.f26281e.update(yVar.f26331a, yVar.f26332b, iMin);
            j7 -= (long) iMin;
            yVar = yVar.f26336f;
        }
    }

    @Override // com.haier.library.a.b0
    public void I1(g gVar, long j7) throws IOException {
        if (j7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        }
        if (j7 == 0) {
            return;
        }
        y0(gVar, j7);
        this.f26279c.I1(gVar, j7);
    }

    @Override // com.haier.library.a.b0
    public d0 a() {
        return this.f26277a.a();
    }

    public final Deflater b() {
        return this.f26278b;
    }

    @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f26280d) {
            return;
        }
        this.f26279c.e();
        q();
        th = null;
        try {
            this.f26278b.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.f26277a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f26280d = true;
        if (th != null) {
            c.e(th);
        }
    }

    @Override // com.haier.library.a.b0, java.io.Flushable
    public void flush() throws IOException {
        this.f26279c.flush();
    }
}
