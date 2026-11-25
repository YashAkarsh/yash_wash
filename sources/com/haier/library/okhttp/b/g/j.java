package com.haier.library.okhttp.b.g;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class j implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Logger f27324g = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.haier.library.a.h f27325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f27326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.haier.library.a.g f27327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f27328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f27329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final d.b f27330f;

    j(com.haier.library.a.h hVar, boolean z7) {
        this.f27325a = hVar;
        this.f27326b = z7;
        com.haier.library.a.g gVar = new com.haier.library.a.g();
        this.f27327c = gVar;
        this.f27330f = new d.b(gVar);
        this.f27328d = 16384;
    }

    private void H(int i7, long j7) throws IOException {
        while (j7 > 0) {
            int iMin = (int) Math.min(this.f27328d, j7);
            long j8 = iMin;
            j7 -= j8;
            e(i7, iMin, (byte) 9, j7 == 0 ? (byte) 4 : (byte) 0);
            this.f27325a.I1(this.f27327c, j8);
        }
    }

    private static void s(com.haier.library.a.h hVar, int i7) throws IOException {
        hVar.y1((i7 >>> 16) & 255);
        hVar.y1((i7 >>> 8) & 255);
        hVar.y1(i7 & 255);
    }

    public synchronized void C(boolean z7, int i7, int i8, List<c> list) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        Q(z7, i7, list);
    }

    public synchronized void E(boolean z7, int i7, com.haier.library.a.g gVar, int i8) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        c(i7, z7 ? (byte) 1 : (byte) 0, gVar, i8);
    }

    public synchronized void F(boolean z7, int i7, List<c> list) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        Q(z7, i7, list);
    }

    public synchronized void G() throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        this.f27325a.flush();
    }

    public synchronized void K(m mVar) throws IOException {
        int i7;
        if (this.f27329e) {
            throw new IOException("closed");
        }
        int i8 = 0;
        e(0, mVar.f() * 6, (byte) 4, (byte) 0);
        while (i8 < 10) {
            if (mVar.d(i8)) {
                if (i8 == 4) {
                    i7 = 3;
                } else {
                    i7 = i8 == 7 ? 4 : i8;
                }
                this.f27325a.l1(i7);
                this.f27325a.z0(mVar.g(i8));
            }
            i8++;
        }
        this.f27325a.flush();
    }

    void Q(boolean z7, int i7, List<c> list) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        this.f27330f.f(list);
        long jY0 = this.f27327c.Y0();
        int iMin = (int) Math.min(this.f27328d, jY0);
        long j7 = iMin;
        byte b8 = jY0 == j7 ? (byte) 4 : (byte) 0;
        if (z7) {
            b8 = (byte) (b8 | 1);
        }
        e(i7, iMin, (byte) 1, b8);
        this.f27325a.I1(this.f27327c, j7);
        if (jY0 > j7) {
            H(i7, jY0 - j7);
        }
    }

    public synchronized void b() throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        if (this.f27326b) {
            Logger logger = f27324g;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.haier.library.okhttp.n.d.j(">> CONNECTION %s", e.f27181a.W()));
            }
            this.f27325a.K1(e.f27181a.a0());
            this.f27325a.flush();
        }
    }

    void c(int i7, byte b8, com.haier.library.a.g gVar, int i8) throws IOException {
        e(i7, i8, (byte) 0, b8);
        if (i8 > 0) {
            this.f27325a.I1(gVar, i8);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f27329e = true;
        this.f27325a.close();
    }

    public void e(int i7, int i8, byte b8, byte b9) throws IOException {
        Logger logger = f27324g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.c(false, i7, i8, b8, b9));
        }
        int i9 = this.f27328d;
        if (i8 > i9) {
            throw e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i9), Integer.valueOf(i8));
        }
        if ((Integer.MIN_VALUE & i7) != 0) {
            throw e.a("reserved bit set: %s", Integer.valueOf(i7));
        }
        s(this.f27325a, i8);
        this.f27325a.y1(b8 & 255);
        this.f27325a.y1(b9 & 255);
        this.f27325a.z0(i7 & Integer.MAX_VALUE);
    }

    public synchronized void f(int i7, int i8, List<c> list) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        this.f27330f.f(list);
        long jY0 = this.f27327c.Y0();
        int iMin = (int) Math.min(this.f27328d - 4, jY0);
        long j7 = iMin;
        e(i7, iMin + 4, (byte) 5, jY0 == j7 ? (byte) 4 : (byte) 0);
        this.f27325a.z0(i8 & Integer.MAX_VALUE);
        this.f27325a.I1(this.f27327c, j7);
        if (jY0 > j7) {
            H(i7, jY0 - j7);
        }
    }

    public synchronized void g(int i7, long j7) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        if (j7 == 0 || j7 > 2147483647L) {
            throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j7));
        }
        e(i7, 4, (byte) 8, (byte) 0);
        this.f27325a.z0((int) j7);
        this.f27325a.flush();
    }

    public int g0() {
        return this.f27328d;
    }

    public synchronized void m(int i7, b bVar) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        if (bVar.f27140a == -1) {
            throw new IllegalArgumentException();
        }
        e(i7, 4, (byte) 3, (byte) 0);
        this.f27325a.z0(bVar.f27140a);
        this.f27325a.flush();
    }

    public synchronized void q(int i7, b bVar, byte[] bArr) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        if (bVar.f27140a == -1) {
            throw e.a("errorCode.httpCode == -1", new Object[0]);
        }
        e(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.f27325a.z0(i7);
        this.f27325a.z0(bVar.f27140a);
        if (bArr.length > 0) {
            this.f27325a.K1(bArr);
        }
        this.f27325a.flush();
    }

    public synchronized void r(int i7, List<c> list) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        Q(false, i7, list);
    }

    public synchronized void u(m mVar) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        this.f27328d = mVar.k(this.f27328d);
        if (mVar.h() != -1) {
            this.f27330f.b(mVar.h());
        }
        e(0, 0, (byte) 4, (byte) 1);
        this.f27325a.flush();
    }

    public synchronized void v(boolean z7, int i7, int i8) throws IOException {
        if (this.f27329e) {
            throw new IOException("closed");
        }
        e(0, 8, (byte) 6, z7 ? (byte) 1 : (byte) 0);
        this.f27325a.z0(i7);
        this.f27325a.z0(i8);
        this.f27325a.flush();
    }
}
