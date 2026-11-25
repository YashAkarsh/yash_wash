package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final okio.m f38189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f38190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final d.b f38192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final okio.n f38193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f38194f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f38188h = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Logger f38187g = Logger.getLogger(e.class.getName());

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public j(@a7.d okio.n sink, boolean z7) {
        l0.p(sink, "sink");
        this.f38193e = sink;
        this.f38194f = z7;
        okio.m mVar = new okio.m();
        this.f38189a = mVar;
        this.f38190b = 16384;
        this.f38192d = new d.b(0, false, mVar, 3, null);
    }

    private final void H(int i7, long j7) throws IOException {
        while (j7 > 0) {
            long jMin = Math.min(this.f38190b, j7);
            j7 -= jMin;
            m(i7, (int) jMin, 9, j7 == 0 ? 4 : 0);
            this.f38193e.write(this.f38189a, jMin);
        }
    }

    public final synchronized void C(int i7, int i8, @a7.d List<c> requestHeaders) throws IOException {
        l0.p(requestHeaders, "requestHeaders");
        if (this.f38191c) {
            throw new IOException("closed");
        }
        this.f38192d.g(requestHeaders);
        long jB1 = this.f38189a.B1();
        int iMin = (int) Math.min(((long) this.f38190b) - 4, jB1);
        long j7 = iMin;
        m(i7, iMin + 4, 5, jB1 == j7 ? 4 : 0);
        this.f38193e.writeInt(i8 & Integer.MAX_VALUE);
        this.f38193e.write(this.f38189a, j7);
        if (jB1 > j7) {
            H(i7, jB1 - j7);
        }
    }

    public final synchronized void E(int i7, @a7.d b errorCode) throws IOException {
        l0.p(errorCode, "errorCode");
        if (this.f38191c) {
            throw new IOException("closed");
        }
        if (!(errorCode.a() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        m(i7, 4, 3, 0);
        this.f38193e.writeInt(errorCode.a());
        this.f38193e.flush();
    }

    public final synchronized void F(@a7.d m settings) throws IOException {
        int i7;
        l0.p(settings, "settings");
        if (this.f38191c) {
            throw new IOException("closed");
        }
        int i8 = 0;
        m(0, settings.l() * 6, 4, 0);
        while (i8 < 10) {
            if (settings.i(i8)) {
                if (i8 != 4) {
                    i7 = i8 != 7 ? i8 : 4;
                } else {
                    i7 = 3;
                }
                this.f38193e.writeShort(i7);
                this.f38193e.writeInt(settings.b(i8));
            }
            i8++;
        }
        this.f38193e.flush();
    }

    public final synchronized void G(int i7, long j7) throws IOException {
        if (this.f38191c) {
            throw new IOException("closed");
        }
        if (!(j7 != 0 && j7 <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j7).toString());
        }
        m(i7, 4, 8, 0);
        this.f38193e.writeInt((int) j7);
        this.f38193e.flush();
    }

    public final synchronized void b(@a7.d m peerSettings) throws IOException {
        l0.p(peerSettings, "peerSettings");
        if (this.f38191c) {
            throw new IOException("closed");
        }
        this.f38190b = peerSettings.g(this.f38190b);
        if (peerSettings.d() != -1) {
            this.f38192d.e(peerSettings.d());
        }
        m(0, 0, 4, 1);
        this.f38193e.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f38191c = true;
        this.f38193e.close();
    }

    public final synchronized void e() throws IOException {
        if (this.f38191c) {
            throw new IOException("closed");
        }
        if (this.f38194f) {
            Logger logger = f38187g;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(okhttp3.internal.d.v(">> CONNECTION " + e.f38000a.t(), new Object[0]));
            }
            this.f38193e.p1(e.f38000a);
            this.f38193e.flush();
        }
    }

    public final synchronized void f(boolean z7, int i7, @a7.e okio.m mVar, int i8) throws IOException {
        if (this.f38191c) {
            throw new IOException("closed");
        }
        g(i7, z7 ? 1 : 0, mVar, i8);
    }

    public final synchronized void flush() throws IOException {
        if (this.f38191c) {
            throw new IOException("closed");
        }
        this.f38193e.flush();
    }

    public final void g(int i7, int i8, @a7.e okio.m mVar, int i9) throws IOException {
        m(i7, i9, 0, i8);
        if (i9 > 0) {
            okio.n nVar = this.f38193e;
            l0.m(mVar);
            nVar.write(mVar, i9);
        }
    }

    public final void m(int i7, int i8, int i9, int i10) throws IOException {
        Logger logger = f38187g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.f38023x.c(false, i7, i8, i9, i10));
        }
        if (!(i8 <= this.f38190b)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f38190b + ": " + i8).toString());
        }
        if (!((((int) 2147483648L) & i7) == 0)) {
            throw new IllegalArgumentException(("reserved bit set: " + i7).toString());
        }
        okhttp3.internal.d.k0(this.f38193e, i8);
        this.f38193e.writeByte(i9 & 255);
        this.f38193e.writeByte(i10 & 255);
        this.f38193e.writeInt(i7 & Integer.MAX_VALUE);
    }

    @a7.d
    public final d.b q() {
        return this.f38192d;
    }

    public final synchronized void r(int i7, @a7.d b errorCode, @a7.d byte[] debugData) throws IOException {
        l0.p(errorCode, "errorCode");
        l0.p(debugData, "debugData");
        if (this.f38191c) {
            throw new IOException("closed");
        }
        if (!(errorCode.a() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        m(0, debugData.length + 8, 7, 0);
        this.f38193e.writeInt(i7);
        this.f38193e.writeInt(errorCode.a());
        if (!(debugData.length == 0)) {
            this.f38193e.write(debugData);
        }
        this.f38193e.flush();
    }

    public final synchronized void s(boolean z7, int i7, @a7.d List<c> headerBlock) throws IOException {
        l0.p(headerBlock, "headerBlock");
        if (this.f38191c) {
            throw new IOException("closed");
        }
        this.f38192d.g(headerBlock);
        long jB1 = this.f38189a.B1();
        long jMin = Math.min(this.f38190b, jB1);
        int i8 = jB1 == jMin ? 4 : 0;
        if (z7) {
            i8 |= 1;
        }
        m(i7, (int) jMin, 1, i8);
        this.f38193e.write(this.f38189a, jMin);
        if (jB1 > jMin) {
            H(i7, jB1 - jMin);
        }
    }

    public final int u() {
        return this.f38190b;
    }

    public final synchronized void v(boolean z7, int i7, int i8) throws IOException {
        if (this.f38191c) {
            throw new IOException("closed");
        }
        m(0, 8, 6, z7 ? 1 : 0);
        this.f38193e.writeInt(i7);
        this.f38193e.writeInt(i8);
        this.f38193e.flush();
    }
}
