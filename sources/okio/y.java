package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f38553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f38554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f38555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Inflater f38556d;

    public y(@a7.d o source, @a7.d Inflater inflater) {
        kotlin.jvm.internal.l0.p(source, "source");
        kotlin.jvm.internal.l0.p(inflater, "inflater");
        this.f38555c = source;
        this.f38556d = inflater;
    }

    private final void q() throws IOException {
        int i7 = this.f38553a;
        if (i7 == 0) {
            return;
        }
        int remaining = i7 - this.f38556d.getRemaining();
        this.f38553a -= remaining;
        this.f38555c.skip(remaining);
    }

    public final long b(@a7.d m sink, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (!(!this.f38554b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j7 == 0) {
            return 0L;
        }
        try {
            j0 j0VarW1 = sink.W1(1);
            int iMin = (int) Math.min(j7, 8192 - j0VarW1.f38470c);
            e();
            int iInflate = this.f38556d.inflate(j0VarW1.f38468a, j0VarW1.f38470c, iMin);
            q();
            if (iInflate > 0) {
                j0VarW1.f38470c += iInflate;
                long j8 = iInflate;
                sink.s1(sink.B1() + j8);
                return j8;
            }
            if (j0VarW1.f38469b == j0VarW1.f38470c) {
                sink.f38494a = j0VarW1.b();
                k0.d(j0VarW1);
            }
            return 0L;
        } catch (DataFormatException e8) {
            throw new IOException(e8);
        }
    }

    @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f38554b) {
            return;
        }
        this.f38556d.end();
        this.f38554b = true;
        this.f38555c.close();
    }

    public final boolean e() throws IOException {
        if (!this.f38556d.needsInput()) {
            return false;
        }
        if (this.f38555c.N()) {
            return true;
        }
        j0 j0Var = this.f38555c.p().f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        int i7 = j0Var.f38470c;
        int i8 = j0Var.f38469b;
        int i9 = i7 - i8;
        this.f38553a = i9;
        this.f38556d.setInput(j0Var.f38468a, i8, i9);
        return false;
    }

    @Override // okio.o0
    public long read(@a7.d m sink, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        do {
            long jB = b(sink, j7);
            if (jB > 0) {
                return jB;
            }
            if (this.f38556d.finished() || this.f38556d.needsDictionary()) {
                return -1L;
            }
        } while (!this.f38555c.N());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // okio.o0
    @a7.d
    public q0 timeout() {
        return this.f38555c.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y(@a7.d o0 source, @a7.d Inflater inflater) {
        this(a0.d(source), inflater);
        kotlin.jvm.internal.l0.p(source, "source");
        kotlin.jvm.internal.l0.p(inflater, "inflater");
    }
}
