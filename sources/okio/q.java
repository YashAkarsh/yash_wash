package okio;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f38520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f38521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Deflater f38522c;

    public q(@a7.d n sink, @a7.d Deflater deflater) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        kotlin.jvm.internal.l0.p(deflater, "deflater");
        this.f38521b = sink;
        this.f38522c = deflater;
    }

    @z6.a
    private final void b(boolean z7) throws IOException {
        j0 j0VarW1;
        int iDeflate;
        m mVarP = this.f38521b.p();
        while (true) {
            j0VarW1 = mVarP.W1(1);
            if (z7) {
                Deflater deflater = this.f38522c;
                byte[] bArr = j0VarW1.f38468a;
                int i7 = j0VarW1.f38470c;
                iDeflate = deflater.deflate(bArr, i7, 8192 - i7, 2);
            } else {
                Deflater deflater2 = this.f38522c;
                byte[] bArr2 = j0VarW1.f38468a;
                int i8 = j0VarW1.f38470c;
                iDeflate = deflater2.deflate(bArr2, i8, 8192 - i8);
            }
            if (iDeflate > 0) {
                j0VarW1.f38470c += iDeflate;
                mVarP.s1(mVarP.B1() + ((long) iDeflate));
                this.f38521b.b0();
            } else if (this.f38522c.needsInput()) {
                break;
            }
        }
        if (j0VarW1.f38469b == j0VarW1.f38470c) {
            mVarP.f38494a = j0VarW1.b();
            k0.d(j0VarW1);
        }
    }

    @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f38520a) {
            return;
        }
        e();
        th = null;
        try {
            this.f38522c.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.f38521b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f38520a = true;
        if (th != null) {
            throw th;
        }
    }

    public final void e() throws IOException {
        this.f38522c.finish();
        b(false);
    }

    @Override // okio.m0, java.io.Flushable
    public void flush() throws IOException {
        b(true);
        this.f38521b.flush();
    }

    @Override // okio.m0
    @a7.d
    public q0 timeout() {
        return this.f38521b.timeout();
    }

    @a7.d
    public String toString() {
        return "DeflaterSink(" + this.f38521b + ')';
    }

    @Override // okio.m0
    public void write(@a7.d m source, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        j.e(source.B1(), 0L, j7);
        while (j7 > 0) {
            j0 j0Var = source.f38494a;
            kotlin.jvm.internal.l0.m(j0Var);
            int iMin = (int) Math.min(j7, j0Var.f38470c - j0Var.f38469b);
            this.f38522c.setInput(j0Var.f38468a, j0Var.f38469b, iMin);
            b(false);
            long j8 = iMin;
            source.s1(source.B1() - j8);
            int i7 = j0Var.f38469b + iMin;
            j0Var.f38469b = i7;
            if (i7 == j0Var.f38470c) {
                source.f38494a = j0Var.b();
                k0.d(j0Var);
            }
            j7 -= j8;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(@a7.d m0 sink, @a7.d Deflater deflater) {
        this(a0.c(sink), deflater);
        kotlin.jvm.internal.l0.p(sink, "sink");
        kotlin.jvm.internal.l0.p(deflater, "deflater");
    }
}
