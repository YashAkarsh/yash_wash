package com.haier.library.okhttp.b.g;

import com.haier.library.a.c0;
import com.haier.library.a.d0;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.g2;

/* JADX INFO: loaded from: classes2.dex */
final class h implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Logger f27286e = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.haier.library.a.i f27287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f27288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f27289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final d.a f27290d;

    static final class a implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.haier.library.a.i f27291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f27292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        byte f27293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27295e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        short f27296f;

        a(com.haier.library.a.i iVar) {
            this.f27291a = iVar;
        }

        private void b() throws IOException {
            int i7 = this.f27294d;
            int iC = h.c(this.f27291a);
            this.f27295e = iC;
            this.f27292b = iC;
            byte bJ = (byte) (this.f27291a.j() & 255);
            this.f27293c = (byte) (this.f27291a.j() & 255);
            Logger logger = h.f27286e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.c(true, this.f27294d, this.f27292b, bJ, this.f27293c));
            }
            int iL = this.f27291a.l() & Integer.MAX_VALUE;
            this.f27294d = iL;
            if (bJ != 9) {
                throw e.d("%s != TYPE_CONTINUATION", Byte.valueOf(bJ));
            }
            if (iL != i7) {
                throw e.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.haier.library.a.c0
        public long P0(com.haier.library.a.g gVar, long j7) throws IOException {
            while (true) {
                int i7 = this.f27295e;
                if (i7 != 0) {
                    long jP0 = this.f27291a.P0(gVar, Math.min(j7, i7));
                    if (jP0 == -1) {
                        return -1L;
                    }
                    this.f27295e = (int) (((long) this.f27295e) - jP0);
                    return jP0;
                }
                this.f27291a.j0(this.f27296f);
                this.f27296f = (short) 0;
                if ((this.f27293c & 4) != 0) {
                    return -1L;
                }
                b();
            }
        }

        @Override // com.haier.library.a.c0
        public d0 a() {
            return this.f27291a.a();
        }

        @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    interface b {
        void a();

        void a(int i7, com.haier.library.okhttp.b.g.b bVar);

        void b(boolean z7, int i7, int i8);

        void c(int i7, int i8, List<c> list) throws IOException;

        void d(boolean z7, int i7, int i8, List<c> list);

        void e(int i7, com.haier.library.okhttp.b.g.b bVar, com.haier.library.a.j jVar);

        void f(int i7, int i8, int i9, boolean z7);

        void g(boolean z7, int i7, com.haier.library.a.i iVar, int i8) throws IOException;

        void h(int i7, String str, com.haier.library.a.j jVar, String str2, int i8, long j7);

        void i(boolean z7, m mVar);

        void j(int i7, long j7);
    }

    h(com.haier.library.a.i iVar, boolean z7) {
        this.f27287a = iVar;
        this.f27289c = z7;
        a aVar = new a(iVar);
        this.f27288b = aVar;
        this.f27290d = new d.a(4096, aVar);
    }

    private void C(b bVar, int i7, byte b8, int i8) throws IOException {
        if (i8 == 0) {
            throw e.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sJ = (b8 & 8) != 0 ? (short) (this.f27287a.j() & 255) : (short) 0;
        bVar.c(i8, this.f27287a.l() & Integer.MAX_VALUE, e(b(i7 - 4, b8, sJ), sJ, b8, i8));
    }

    private void E(b bVar, int i7, byte b8, int i8) throws IOException {
        if (i7 != 8) {
            throw e.d("TYPE_PING length != 8: %s", Integer.valueOf(i7));
        }
        if (i8 != 0) {
            throw e.d("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.b((b8 & 1) != 0, this.f27287a.l(), this.f27287a.l());
    }

    private void F(b bVar, int i7, byte b8, int i8) throws IOException {
        if (i7 < 8) {
            throw e.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i7));
        }
        if (i8 != 0) {
            throw e.d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iL = this.f27287a.l();
        int iL2 = this.f27287a.l();
        int i9 = i7 - 8;
        com.haier.library.okhttp.b.g.b bVarA = com.haier.library.okhttp.b.g.b.a(iL2);
        if (bVarA == null) {
            throw e.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iL2));
        }
        com.haier.library.a.j jVarT1 = com.haier.library.a.j.f26267f;
        if (i9 > 0) {
            jVarT1 = this.f27287a.t1(i9);
        }
        bVar.e(iL, bVarA, jVarT1);
    }

    private void G(b bVar, int i7, byte b8, int i8) throws IOException {
        if (i7 != 4) {
            throw e.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i7));
        }
        long jL = ((long) this.f27287a.l()) & 2147483647L;
        if (jL == 0) {
            throw e.d("windowSizeIncrement was 0", Long.valueOf(jL));
        }
        bVar.j(i8, jL);
    }

    static int b(int i7, byte b8, short s7) throws IOException {
        if ((b8 & 8) != 0) {
            i7--;
        }
        if (s7 <= i7) {
            return (short) (i7 - s7);
        }
        throw e.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s7), Integer.valueOf(i7));
    }

    static int c(com.haier.library.a.i iVar) throws IOException {
        return (iVar.j() & 255) | ((iVar.j() & 255) << 16) | ((iVar.j() & 255) << 8);
    }

    private List<c> e(int i7, short s7, byte b8, int i8) throws IOException {
        a aVar = this.f27288b;
        aVar.f27295e = i7;
        aVar.f27292b = i7;
        aVar.f27296f = s7;
        aVar.f27293c = b8;
        aVar.f27294d = i8;
        this.f27290d.e();
        return this.f27290d.h();
    }

    private void g(b bVar, int i7) throws IOException {
        int iL = this.f27287a.l();
        bVar.f(i7, iL & Integer.MAX_VALUE, (this.f27287a.j() & 255) + 1, (Integer.MIN_VALUE & iL) != 0);
    }

    private void m(b bVar, int i7, byte b8, int i8) throws IOException {
        if (i8 == 0) {
            throw e.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z7 = (b8 & 1) != 0;
        short sJ = (b8 & 8) != 0 ? (short) (this.f27287a.j() & 255) : (short) 0;
        if ((b8 & 32) != 0) {
            g(bVar, i8);
            i7 -= 5;
        }
        bVar.d(z7, i8, -1, e(b(i7, b8, sJ), sJ, b8, i8));
    }

    private void r(b bVar, int i7, byte b8, int i8) throws IOException {
        if (i8 == 0) {
            throw e.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z7 = (b8 & 1) != 0;
        if ((b8 & 32) != 0) {
            throw e.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sJ = (b8 & 8) != 0 ? (short) (this.f27287a.j() & 255) : (short) 0;
        bVar.g(z7, i8, this.f27287a, b(i7, b8, sJ));
        this.f27287a.j0(sJ);
    }

    private void s(b bVar, int i7, byte b8, int i8) throws IOException {
        if (i7 != 5) {
            throw e.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i7));
        }
        if (i8 == 0) {
            throw e.d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        g(bVar, i8);
    }

    private void u(b bVar, int i7, byte b8, int i8) throws IOException {
        if (i7 != 4) {
            throw e.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i7));
        }
        if (i8 == 0) {
            throw e.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iL = this.f27287a.l();
        com.haier.library.okhttp.b.g.b bVarA = com.haier.library.okhttp.b.g.b.a(iL);
        if (bVarA == null) {
            throw e.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iL));
        }
        bVar.a(i8, bVarA);
    }

    private void v(b bVar, int i7, byte b8, int i8) throws IOException {
        if (i8 != 0) {
            throw e.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b8 & 1) != 0) {
            if (i7 != 0) {
                throw e.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.a();
            return;
        }
        if (i7 % 6 != 0) {
            throw e.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i7));
        }
        m mVar = new m();
        for (int i9 = 0; i9 < i7; i9 += 6) {
            int iK = this.f27287a.k() & g2.f34732d;
            int iL = this.f27287a.l();
            if (iK == 2) {
                if (iL != 0 && iL != 1) {
                    throw e.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (iK == 3) {
                iK = 4;
            } else if (iK != 4) {
                if (iK == 5 && (iL < 16384 || iL > 16777215)) {
                    throw e.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iL));
                }
            } else {
                if (iL < 0) {
                    throw e.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                iK = 7;
            }
            mVar.a(iK, iL);
        }
        bVar.i(false, mVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27287a.close();
    }

    public void f(b bVar) throws IOException {
        if (this.f27289c) {
            if (!q(true, bVar)) {
                throw e.d("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.haier.library.a.i iVar = this.f27287a;
        com.haier.library.a.j jVar = e.f27181a;
        com.haier.library.a.j jVarT1 = iVar.t1(jVar.Z());
        Logger logger = f27286e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.haier.library.okhttp.n.d.j("<< CONNECTION %s", jVarT1.W()));
        }
        if (!jVar.equals(jVarT1)) {
            throw e.d("Expected a connection header but was %s", jVarT1.o());
        }
    }

    public boolean q(boolean z7, b bVar) throws IOException {
        try {
            this.f27287a.a(9L);
            int iC = c(this.f27287a);
            if (iC < 0 || iC > 16384) {
                throw e.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(iC));
            }
            byte bJ = (byte) (this.f27287a.j() & 255);
            if (z7 && bJ != 4) {
                throw e.d("Expected a SETTINGS frame but was %s", Byte.valueOf(bJ));
            }
            byte bJ2 = (byte) (this.f27287a.j() & 255);
            int iL = this.f27287a.l() & Integer.MAX_VALUE;
            Logger logger = f27286e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.c(true, iL, iC, bJ, bJ2));
            }
            switch (bJ) {
                case 0:
                    r(bVar, iC, bJ2, iL);
                    return true;
                case 1:
                    m(bVar, iC, bJ2, iL);
                    return true;
                case 2:
                    s(bVar, iC, bJ2, iL);
                    return true;
                case 3:
                    u(bVar, iC, bJ2, iL);
                    return true;
                case 4:
                    v(bVar, iC, bJ2, iL);
                    return true;
                case 5:
                    C(bVar, iC, bJ2, iL);
                    return true;
                case 6:
                    E(bVar, iC, bJ2, iL);
                    return true;
                case 7:
                    F(bVar, iC, bJ2, iL);
                    return true;
                case 8:
                    G(bVar, iC, bJ2, iL);
                    return true;
                default:
                    this.f27287a.j0(iC);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }
}
