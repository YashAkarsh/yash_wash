package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.ranges.q;
import okio.o;
import okio.o0;
import okio.p;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private static final Logger f38146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f38147f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f38148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.a f38149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f38150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f38151d;

    public static final class a {
        private a() {
        }

        @a7.d
        public final Logger a() {
            return h.f38146e;
        }

        public final int b(int i7, int i8, int i9) throws IOException {
            if ((i8 & 8) != 0) {
                i7--;
            }
            if (i9 <= i7) {
                return i7 - i9;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i9 + " > remaining length " + i7);
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public static final class b implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f38153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f38155d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f38156e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final o f38157f;

        public b(@a7.d o source) {
            l0.p(source, "source");
            this.f38157f = source;
        }

        private final void C() throws IOException {
            int i7 = this.f38154c;
            int iR = okhttp3.internal.d.R(this.f38157f);
            this.f38155d = iR;
            this.f38152a = iR;
            int iB = okhttp3.internal.d.b(this.f38157f.readByte(), 255);
            this.f38153b = okhttp3.internal.d.b(this.f38157f.readByte(), 255);
            a aVar = h.f38147f;
            if (aVar.a().isLoggable(Level.FINE)) {
                aVar.a().fine(e.f38023x.c(true, this.f38154c, this.f38152a, iB, this.f38153b));
            }
            int i8 = this.f38157f.readInt() & Integer.MAX_VALUE;
            this.f38154c = i8;
            if (iB == 9) {
                if (i8 != i7) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iB + " != TYPE_CONTINUATION");
            }
        }

        public final void E(int i7) {
            this.f38153b = i7;
        }

        public final void F(int i7) {
            this.f38155d = i7;
        }

        public final void G(int i7) {
            this.f38152a = i7;
        }

        public final void H(int i7) {
            this.f38156e = i7;
        }

        public final void K(int i7) {
            this.f38154c = i7;
        }

        public final int b() {
            return this.f38153b;
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final int e() {
            return this.f38155d;
        }

        public final int q() {
            return this.f38152a;
        }

        public final int r() {
            return this.f38156e;
        }

        @Override // okio.o0
        public long read(@a7.d okio.m sink, long j7) throws IOException {
            l0.p(sink, "sink");
            while (true) {
                int i7 = this.f38155d;
                if (i7 != 0) {
                    long j8 = this.f38157f.read(sink, Math.min(j7, i7));
                    if (j8 == -1) {
                        return -1L;
                    }
                    this.f38155d -= (int) j8;
                    return j8;
                }
                this.f38157f.skip(this.f38156e);
                this.f38156e = 0;
                if ((this.f38153b & 4) != 0) {
                    return -1L;
                }
                C();
            }
        }

        @Override // okio.o0
        @a7.d
        public q0 timeout() {
            return this.f38157f.timeout();
        }

        public final int u() {
            return this.f38154c;
        }
    }

    public interface c {
        void b();

        void d(boolean z7, @a7.d m mVar);

        void e(boolean z7, int i7, int i8, @a7.d List<okhttp3.internal.http2.c> list);

        void f(int i7, long j7);

        void g(int i7, @a7.d String str, @a7.d p pVar, @a7.d String str2, int i8, long j7);

        void i(boolean z7, int i7, @a7.d o oVar, int i8) throws IOException;

        void j(boolean z7, int i7, int i8);

        void m(int i7, int i8, int i9, boolean z7);

        void q(int i7, @a7.d okhttp3.internal.http2.b bVar);

        void r(int i7, int i8, @a7.d List<okhttp3.internal.http2.c> list) throws IOException;

        void s(int i7, @a7.d okhttp3.internal.http2.b bVar, @a7.d p pVar);
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        l0.o(logger, "Logger.getLogger(Http2::class.java.name)");
        f38146e = logger;
    }

    public h(@a7.d o source, boolean z7) {
        l0.p(source, "source");
        this.f38150c = source;
        this.f38151d = z7;
        b bVar = new b(source);
        this.f38148a = bVar;
        this.f38149b = new d.a(bVar, 4096, 0, 4, null);
    }

    private final void C(c cVar, int i7, int i8, int i9) throws IOException {
        if (i7 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i7 + " != 4");
        }
        if (i9 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i10 = this.f38150c.readInt();
        okhttp3.internal.http2.b bVarA = okhttp3.internal.http2.b.f37956q.a(i10);
        if (bVarA != null) {
            cVar.q(i9, bVarA);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + i10);
    }

    private final void E(c cVar, int i7, int i8, int i9) throws IOException {
        if (i9 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i8 & 1) != 0) {
            if (i7 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            cVar.b();
            return;
        }
        if (i7 % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i7);
        }
        m mVar = new m();
        kotlin.ranges.i iVarE1 = q.e1(q.z1(0, i7), 6);
        int iG = iVarE1.g();
        int iH = iVarE1.h();
        int iJ = iVarE1.j();
        if (iJ < 0 ? iG >= iH : iG <= iH) {
            while (true) {
                int iC = okhttp3.internal.d.c(this.f38150c.readShort(), 65535);
                int i10 = this.f38150c.readInt();
                if (iC != 2) {
                    if (iC == 3) {
                        iC = 4;
                    } else if (iC != 4) {
                        if (iC == 5 && (i10 < 16384 || i10 > 16777215)) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + i10);
                        }
                    } else {
                        if (i10 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iC = 7;
                    }
                } else if (i10 != 0 && i10 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                mVar.k(iC, i10);
                if (iG != iH) {
                    iG += iJ;
                }
            }
        }
        cVar.d(false, mVar);
    }

    private final void F(c cVar, int i7, int i8, int i9) throws IOException {
        if (i7 != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i7);
        }
        long jD = okhttp3.internal.d.d(this.f38150c.readInt(), 2147483647L);
        if (jD == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        cVar.f(i9, jD);
    }

    private final void f(c cVar, int i7, int i8, int i9) throws IOException {
        if (i9 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z7 = (i8 & 1) != 0;
        if ((i8 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iB = (i8 & 8) != 0 ? okhttp3.internal.d.b(this.f38150c.readByte(), 255) : 0;
        cVar.i(z7, i9, this.f38150c, f38147f.b(i7, i8, iB));
        this.f38150c.skip(iB);
    }

    private final void g(c cVar, int i7, int i8, int i9) throws IOException {
        if (i7 < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i7);
        }
        if (i9 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i10 = this.f38150c.readInt();
        int i11 = this.f38150c.readInt();
        int i12 = i7 - 8;
        okhttp3.internal.http2.b bVarA = okhttp3.internal.http2.b.f37956q.a(i11);
        if (bVarA == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i11);
        }
        p pVarL = p.f38507e;
        if (i12 > 0) {
            pVarL = this.f38150c.l(i12);
        }
        cVar.s(i10, bVarA, pVarL);
    }

    private final List<okhttp3.internal.http2.c> m(int i7, int i8, int i9, int i10) throws IOException {
        this.f38148a.F(i7);
        b bVar = this.f38148a;
        bVar.G(bVar.e());
        this.f38148a.H(i8);
        this.f38148a.E(i9);
        this.f38148a.K(i10);
        this.f38149b.l();
        return this.f38149b.e();
    }

    private final void q(c cVar, int i7, int i8, int i9) throws IOException {
        if (i9 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z7 = (i8 & 1) != 0;
        int iB = (i8 & 8) != 0 ? okhttp3.internal.d.b(this.f38150c.readByte(), 255) : 0;
        if ((i8 & 32) != 0) {
            s(cVar, i9);
            i7 -= 5;
        }
        cVar.e(z7, i9, -1, m(f38147f.b(i7, i8, iB), iB, i8, i9));
    }

    private final void r(c cVar, int i7, int i8, int i9) throws IOException {
        if (i7 != 8) {
            throw new IOException("TYPE_PING length != 8: " + i7);
        }
        if (i9 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        cVar.j((i8 & 1) != 0, this.f38150c.readInt(), this.f38150c.readInt());
    }

    private final void s(c cVar, int i7) throws IOException {
        int i8 = this.f38150c.readInt();
        cVar.m(i7, i8 & Integer.MAX_VALUE, okhttp3.internal.d.b(this.f38150c.readByte(), 255) + 1, (((int) 2147483648L) & i8) != 0);
    }

    private final void u(c cVar, int i7, int i8, int i9) throws IOException {
        if (i7 == 5) {
            if (i9 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            s(cVar, i9);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i7 + " != 5");
        }
    }

    private final void v(c cVar, int i7, int i8, int i9) throws IOException {
        if (i9 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iB = (i8 & 8) != 0 ? okhttp3.internal.d.b(this.f38150c.readByte(), 255) : 0;
        cVar.r(i9, this.f38150c.readInt() & Integer.MAX_VALUE, m(f38147f.b(i7 - 4, i8, iB), iB, i8, i9));
    }

    public final boolean c(boolean z7, @a7.d c handler) throws IOException {
        l0.p(handler, "handler");
        try {
            this.f38150c.G1(9L);
            int iR = okhttp3.internal.d.R(this.f38150c);
            if (iR > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + iR);
            }
            int iB = okhttp3.internal.d.b(this.f38150c.readByte(), 255);
            int iB2 = okhttp3.internal.d.b(this.f38150c.readByte(), 255);
            int i7 = this.f38150c.readInt() & Integer.MAX_VALUE;
            Logger logger = f38146e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.f38023x.c(true, i7, iR, iB, iB2));
            }
            if (z7 && iB != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + e.f38023x.b(iB));
            }
            switch (iB) {
                case 0:
                    f(handler, iR, iB2, i7);
                    return true;
                case 1:
                    q(handler, iR, iB2, i7);
                    return true;
                case 2:
                    u(handler, iR, iB2, i7);
                    return true;
                case 3:
                    C(handler, iR, iB2, i7);
                    return true;
                case 4:
                    E(handler, iR, iB2, i7);
                    return true;
                case 5:
                    v(handler, iR, iB2, i7);
                    return true;
                case 6:
                    r(handler, iR, iB2, i7);
                    return true;
                case 7:
                    g(handler, iR, iB2, i7);
                    return true;
                case 8:
                    F(handler, iR, iB2, i7);
                    return true;
                default:
                    this.f38150c.skip(iR);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f38150c.close();
    }

    public final void e(@a7.d c handler) throws IOException {
        l0.p(handler, "handler");
        if (this.f38151d) {
            if (!c(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        o oVar = this.f38150c;
        p pVar = e.f38000a;
        p pVarL = oVar.l(pVar.a0());
        Logger logger = f38146e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(okhttp3.internal.d.v("<< CONNECTION " + pVarL.t(), new Object[0]));
        }
        if (!l0.g(pVar, pVarL)) {
            throw new IOException("Expected a connection header but was " + pVarL.l0());
        }
    }
}
