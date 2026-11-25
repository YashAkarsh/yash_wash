package com.haier.library.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte f26282f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte f26283g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte f26284h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte f26285i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte f26286j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final byte f26287k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final byte f26288l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final byte f26289m = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f26291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Inflater f26292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s f26293d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26290a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CRC32 f26294e = new CRC32();

    public p(c0 c0Var) {
        if (c0Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f26292c = inflater;
        i iVarB = t.b(c0Var);
        this.f26291b = iVarB;
        this.f26293d = new s(iVarB, inflater);
    }

    private void b(g gVar, long j7, long j8) {
        y yVar = gVar.f26254a;
        while (true) {
            int i7 = yVar.f26333c;
            int i8 = yVar.f26332b;
            if (j7 < i7 - i8) {
                break;
            }
            j7 -= (long) (i7 - i8);
            yVar = yVar.f26336f;
        }
        while (j8 > 0) {
            int i9 = (int) (((long) yVar.f26332b) + j7);
            int iMin = (int) Math.min(yVar.f26333c - i9, j8);
            this.f26294e.update(yVar.f26331a, i9, iMin);
            j8 -= (long) iMin;
            yVar = yVar.f26336f;
            j7 = 0;
        }
    }

    private void c(String str, int i7, int i8) throws IOException {
        if (i8 != i7) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i8), Integer.valueOf(i7)));
        }
    }

    private void e() throws IOException {
        this.f26291b.a(10L);
        byte bQ1 = this.f26291b.c().q1(3L);
        boolean z7 = ((bQ1 >> 1) & 1) == 1;
        if (z7) {
            b(this.f26291b.c(), 0L, 10L);
        }
        c("ID1ID2", 8075, this.f26291b.k());
        this.f26291b.j0(8L);
        if (((bQ1 >> 2) & 1) == 1) {
            this.f26291b.a(2L);
            if (z7) {
                b(this.f26291b.c(), 0L, 2L);
            }
            long jN = this.f26291b.c().n();
            this.f26291b.a(jN);
            if (z7) {
                b(this.f26291b.c(), 0L, jN);
            }
            this.f26291b.j0(jN);
        }
        if (((bQ1 >> 3) & 1) == 1) {
            long jN0 = this.f26291b.n0((byte) 0);
            if (jN0 == -1) {
                throw new EOFException();
            }
            if (z7) {
                b(this.f26291b.c(), 0L, jN0 + 1);
            }
            this.f26291b.j0(jN0 + 1);
        }
        if (((bQ1 >> 4) & 1) == 1) {
            long jN1 = this.f26291b.n0((byte) 0);
            if (jN1 == -1) {
                throw new EOFException();
            }
            if (z7) {
                b(this.f26291b.c(), 0L, jN1 + 1);
            }
            this.f26291b.j0(jN1 + 1);
        }
        if (z7) {
            c("FHCRC", this.f26291b.n(), (short) this.f26294e.getValue());
            this.f26294e.reset();
        }
    }

    private void q() throws IOException {
        c("CRC", this.f26291b.Z0(), (int) this.f26294e.getValue());
        c("ISIZE", this.f26291b.Z0(), (int) this.f26292c.getBytesWritten());
    }

    @Override // com.haier.library.a.c0
    public long P0(g gVar, long j7) throws IOException {
        if (j7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        }
        if (j7 == 0) {
            return 0L;
        }
        if (this.f26290a == 0) {
            e();
            this.f26290a = 1;
        }
        if (this.f26290a == 1) {
            long j8 = gVar.f26255b;
            long jP0 = this.f26293d.P0(gVar, j7);
            if (jP0 != -1) {
                b(gVar, j8, jP0);
                return jP0;
            }
            this.f26290a = 2;
        }
        if (this.f26290a == 2) {
            q();
            this.f26290a = 3;
            if (!this.f26291b.g()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.haier.library.a.c0
    public d0 a() {
        return this.f26291b.a();
    }

    @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26293d.close();
    }
}
