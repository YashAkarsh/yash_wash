package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.jvm.internal.l0;
import okio.m;
import okio.n;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f38407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f38408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f38410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f38411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m.a f38412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f38413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private final n f38414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    private final Random f38415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f38416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f38417k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f38418l;

    public i(boolean z7, @a7.d n sink, @a7.d Random random, boolean z8, boolean z9, long j7) {
        l0.p(sink, "sink");
        l0.p(random, "random");
        this.f38413g = z7;
        this.f38414h = sink;
        this.f38415i = random;
        this.f38416j = z8;
        this.f38417k = z9;
        this.f38418l = j7;
        this.f38407a = new m();
        this.f38408b = sink.p();
        this.f38411e = z7 ? new byte[4] : null;
        this.f38412f = z7 ? new m.a() : null;
    }

    private final void g(int i7, p pVar) throws IOException {
        if (this.f38409c) {
            throw new IOException("closed");
        }
        int iA0 = pVar.a0();
        if (!(((long) iA0) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.f38408b.writeByte(i7 | 128);
        if (this.f38413g) {
            this.f38408b.writeByte(iA0 | 128);
            Random random = this.f38415i;
            byte[] bArr = this.f38411e;
            l0.m(bArr);
            random.nextBytes(bArr);
            this.f38408b.write(this.f38411e);
            if (iA0 > 0) {
                long jB1 = this.f38408b.B1();
                this.f38408b.p1(pVar);
                m mVar = this.f38408b;
                m.a aVar = this.f38412f;
                l0.m(aVar);
                mVar.T0(aVar);
                this.f38412f.g(jB1);
                g.f38390w.c(this.f38412f, this.f38411e);
                this.f38412f.close();
            }
        } else {
            this.f38408b.writeByte(iA0);
            this.f38408b.p1(pVar);
        }
        this.f38414h.flush();
    }

    @a7.d
    public final Random b() {
        return this.f38415i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        a aVar = this.f38410d;
        if (aVar != null) {
            aVar.close();
        }
    }

    @a7.d
    public final n e() {
        return this.f38414h;
    }

    public final void f(int i7, @a7.e p pVar) throws IOException {
        p pVarE0 = p.f38507e;
        if (i7 != 0 || pVar != null) {
            if (i7 != 0) {
                g.f38390w.d(i7);
            }
            m mVar = new m();
            mVar.writeShort(i7);
            if (pVar != null) {
                mVar.p1(pVar);
            }
            pVarE0 = mVar.E0();
        }
        try {
            g(8, pVarE0);
        } finally {
            this.f38409c = true;
        }
    }

    public final void m(int i7, @a7.d p data) throws IOException {
        l0.p(data, "data");
        if (this.f38409c) {
            throw new IOException("closed");
        }
        this.f38407a.p1(data);
        int i8 = i7 | 128;
        if (this.f38416j && data.a0() >= this.f38418l) {
            a aVar = this.f38410d;
            if (aVar == null) {
                aVar = new a(this.f38417k);
                this.f38410d = aVar;
            }
            aVar.b(this.f38407a);
            i8 |= 64;
        }
        long jB1 = this.f38407a.B1();
        this.f38408b.writeByte(i8);
        int i9 = this.f38413g ? 128 : 0;
        if (jB1 <= 125) {
            this.f38408b.writeByte(((int) jB1) | i9);
        } else if (jB1 <= g.f38386s) {
            this.f38408b.writeByte(i9 | 126);
            this.f38408b.writeShort((int) jB1);
        } else {
            this.f38408b.writeByte(i9 | 127);
            this.f38408b.writeLong(jB1);
        }
        if (this.f38413g) {
            Random random = this.f38415i;
            byte[] bArr = this.f38411e;
            l0.m(bArr);
            random.nextBytes(bArr);
            this.f38408b.write(this.f38411e);
            if (jB1 > 0) {
                m mVar = this.f38407a;
                m.a aVar2 = this.f38412f;
                l0.m(aVar2);
                mVar.T0(aVar2);
                this.f38412f.g(0L);
                g.f38390w.c(this.f38412f, this.f38411e);
                this.f38412f.close();
            }
        }
        this.f38408b.write(this.f38407a, jB1);
        this.f38414h.w();
    }

    public final void q(@a7.d p payload) throws IOException {
        l0.p(payload, "payload");
        g(9, payload);
    }

    public final void r(@a7.d p payload) throws IOException {
        l0.p(payload, "payload");
        g(10, payload);
    }
}
