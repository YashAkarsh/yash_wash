package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l0;
import okio.m;
import okio.o;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f38391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f38392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f38393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f38395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f38396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f38397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m f38398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f38399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f38400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final m.a f38401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f38402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @a7.d
    private final o f38403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final a f38404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f38405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f38406p;

    public interface a {
        void a(@a7.d p pVar) throws IOException;

        void b(@a7.d String str) throws IOException;

        void c(@a7.d p pVar);

        void d(@a7.d p pVar);

        void e(int i7, @a7.d String str);
    }

    public h(boolean z7, @a7.d o source, @a7.d a frameCallback, boolean z8, boolean z9) {
        l0.p(source, "source");
        l0.p(frameCallback, "frameCallback");
        this.f38402l = z7;
        this.f38403m = source;
        this.f38404n = frameCallback;
        this.f38405o = z8;
        this.f38406p = z9;
        this.f38397g = new m();
        this.f38398h = new m();
        this.f38400j = z7 ? null : new byte[4];
        this.f38401k = z7 ? null : new m.a();
    }

    private final void C() throws IOException {
        int i7 = this.f38392b;
        if (i7 != 1 && i7 != 2) {
            throw new ProtocolException("Unknown opcode: " + okhttp3.internal.d.Y(i7));
        }
        u();
        if (this.f38396f) {
            c cVar = this.f38399i;
            if (cVar == null) {
                cVar = new c(this.f38406p);
                this.f38399i = cVar;
            }
            cVar.b(this.f38398h);
        }
        if (i7 == 1) {
            this.f38404n.b(this.f38398h.m1());
        } else {
            this.f38404n.a(this.f38398h.E0());
        }
    }

    private final void E() throws IOException {
        while (!this.f38391a) {
            r();
            if (!this.f38395e) {
                return;
            } else {
                q();
            }
        }
    }

    private final void q() throws IOException {
        short s7;
        String strM1;
        long j7 = this.f38393c;
        if (j7 > 0) {
            this.f38403m.V(this.f38397g, j7);
            if (!this.f38402l) {
                m mVar = this.f38397g;
                m.a aVar = this.f38401k;
                l0.m(aVar);
                mVar.T0(aVar);
                this.f38401k.g(0L);
                g gVar = g.f38390w;
                m.a aVar2 = this.f38401k;
                byte[] bArr = this.f38400j;
                l0.m(bArr);
                gVar.c(aVar2, bArr);
                this.f38401k.close();
            }
        }
        switch (this.f38392b) {
            case 8:
                long jB1 = this.f38397g.B1();
                if (jB1 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (jB1 != 0) {
                    s7 = this.f38397g.readShort();
                    strM1 = this.f38397g.m1();
                    String strB = g.f38390w.b(s7);
                    if (strB != null) {
                        throw new ProtocolException(strB);
                    }
                } else {
                    s7 = 1005;
                    strM1 = "";
                }
                this.f38404n.e(s7, strM1);
                this.f38391a = true;
                return;
            case 9:
                this.f38404n.c(this.f38397g.E0());
                return;
            case 10:
                this.f38404n.d(this.f38397g.E0());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + okhttp3.internal.d.Y(this.f38392b));
        }
    }

    private final void r() throws IOException {
        boolean z7;
        if (this.f38391a) {
            throw new IOException("closed");
        }
        long j7 = this.f38403m.timeout().j();
        this.f38403m.timeout().b();
        try {
            int iB = okhttp3.internal.d.b(this.f38403m.readByte(), 255);
            this.f38403m.timeout().i(j7, TimeUnit.NANOSECONDS);
            int i7 = iB & 15;
            this.f38392b = i7;
            boolean z8 = (iB & 128) != 0;
            this.f38394d = z8;
            boolean z9 = (iB & 8) != 0;
            this.f38395e = z9;
            if (z9 && !z8) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z10 = (iB & 64) != 0;
            if (i7 == 1 || i7 == 2) {
                if (!z10) {
                    z7 = false;
                } else {
                    if (!this.f38405o) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z7 = true;
                }
                this.f38396f = z7;
            } else if (z10) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iB & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iB & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iB2 = okhttp3.internal.d.b(this.f38403m.readByte(), 255);
            boolean z11 = (iB2 & 128) != 0;
            if (z11 == this.f38402l) {
                throw new ProtocolException(this.f38402l ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j8 = iB2 & 127;
            this.f38393c = j8;
            if (j8 == 126) {
                this.f38393c = okhttp3.internal.d.c(this.f38403m.readShort(), 65535);
            } else if (j8 == 127) {
                long j9 = this.f38403m.readLong();
                this.f38393c = j9;
                if (j9 < 0) {
                    throw new ProtocolException("Frame length 0x" + okhttp3.internal.d.Z(this.f38393c) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.f38395e && this.f38393c > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z11) {
                o oVar = this.f38403m;
                byte[] bArr = this.f38400j;
                l0.m(bArr);
                oVar.readFully(bArr);
            }
        } catch (Throwable th) {
            this.f38403m.timeout().i(j7, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void u() throws IOException {
        while (!this.f38391a) {
            long j7 = this.f38393c;
            if (j7 > 0) {
                this.f38403m.V(this.f38398h, j7);
                if (!this.f38402l) {
                    m mVar = this.f38398h;
                    m.a aVar = this.f38401k;
                    l0.m(aVar);
                    mVar.T0(aVar);
                    this.f38401k.g(this.f38398h.B1() - this.f38393c);
                    g gVar = g.f38390w;
                    m.a aVar2 = this.f38401k;
                    byte[] bArr = this.f38400j;
                    l0.m(bArr);
                    gVar.c(aVar2, bArr);
                    this.f38401k.close();
                }
            }
            if (this.f38394d) {
                return;
            }
            E();
            if (this.f38392b != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + okhttp3.internal.d.Y(this.f38392b));
            }
        }
        throw new IOException("closed");
    }

    @a7.d
    public final o b() {
        return this.f38403m;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        c cVar = this.f38399i;
        if (cVar != null) {
            cVar.close();
        }
    }

    public final void e() throws IOException {
        r();
        if (this.f38395e) {
            q();
        } else {
            C();
        }
    }
}
