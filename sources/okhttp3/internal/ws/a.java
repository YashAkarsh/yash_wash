package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.l0;
import okio.m;
import okio.m0;
import okio.p;
import okio.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f38295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deflater f38296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q f38297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f38298d;

    public a(boolean z7) {
        this.f38298d = z7;
        m mVar = new m();
        this.f38295a = mVar;
        Deflater deflater = new Deflater(-1, true);
        this.f38296b = deflater;
        this.f38297c = new q((m0) mVar, deflater);
    }

    private final boolean c(m mVar, p pVar) {
        return mVar.t0(mVar.B1() - ((long) pVar.a0()), pVar);
    }

    public final void b(@a7.d m buffer) throws IOException {
        l0.p(buffer, "buffer");
        if (!(this.f38295a.B1() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.f38298d) {
            this.f38296b.reset();
        }
        this.f38297c.write(buffer, buffer.B1());
        this.f38297c.flush();
        if (c(this.f38295a, b.f38299a)) {
            long jB1 = this.f38295a.B1() - ((long) 4);
            m.a aVarV0 = m.V0(this.f38295a, null, 1, null);
            try {
                aVarV0.f(jB1);
                kotlin.io.c.a(aVarV0, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.c.a(aVarV0, th);
                    throw th2;
                }
            }
        } else {
            this.f38295a.writeByte(0);
        }
        m mVar = this.f38295a;
        buffer.write(mVar, mVar.B1());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f38297c.close();
    }
}
