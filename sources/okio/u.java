package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.b1;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h0 f38537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final Deflater f38538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q f38539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CRC32 f38541e;

    public u(@a7.d m0 sink) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        h0 h0Var = new h0(sink);
        this.f38537a = h0Var;
        Deflater deflater = new Deflater(-1, true);
        this.f38538b = deflater;
        this.f38539c = new q((n) h0Var, deflater);
        this.f38541e = new CRC32();
        m mVar = h0Var.f38457a;
        mVar.writeShort(8075);
        mVar.writeByte(8);
        mVar.writeByte(0);
        mVar.writeInt(0);
        mVar.writeByte(0);
        mVar.writeByte(0);
    }

    private final void f(m mVar, long j7) {
        j0 j0Var = mVar.f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        while (j7 > 0) {
            int iMin = (int) Math.min(j7, j0Var.f38470c - j0Var.f38469b);
            this.f38541e.update(j0Var.f38468a, j0Var.f38469b, iMin);
            j7 -= (long) iMin;
            j0Var = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var);
        }
    }

    private final void q() {
        this.f38537a.L((int) this.f38541e.getValue());
        this.f38537a.L((int) this.f38538b.getBytesRead());
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "deflater", imports = {}))
    @h5.h(name = "-deprecated_deflater")
    public final Deflater b() {
        return this.f38538b;
    }

    @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f38540d) {
            return;
        }
        this.f38539c.e();
        q();
        th = null;
        try {
            this.f38538b.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.f38537a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f38540d = true;
        if (th != null) {
            throw th;
        }
    }

    @a7.d
    @h5.h(name = "deflater")
    public final Deflater e() {
        return this.f38538b;
    }

    @Override // okio.m0, java.io.Flushable
    public void flush() throws IOException {
        this.f38539c.flush();
    }

    @Override // okio.m0
    @a7.d
    public q0 timeout() {
        return this.f38537a.timeout();
    }

    @Override // okio.m0
    public void write(@a7.d m source, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (j7 == 0) {
            return;
        }
        f(source, j7);
        this.f38539c.write(source, j7);
    }
}
