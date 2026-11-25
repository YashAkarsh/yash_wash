package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f38542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i0 f38543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Inflater f38544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final y f38545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CRC32 f38546e;

    public v(@a7.d o0 source) {
        kotlin.jvm.internal.l0.p(source, "source");
        i0 i0Var = new i0(source);
        this.f38543b = i0Var;
        Inflater inflater = new Inflater(true);
        this.f38544c = inflater;
        this.f38545d = new y((o) i0Var, inflater);
        this.f38546e = new CRC32();
    }

    private final void c(String str, int i7, int i8) throws IOException {
        if (i8 == i7) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i8), Integer.valueOf(i7)}, 3));
        kotlin.jvm.internal.l0.o(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    private final void e() throws IOException {
        this.f38543b.G1(10L);
        byte bV0 = this.f38543b.f38461a.v0(3L);
        boolean z7 = ((bV0 >> 1) & 1) == 1;
        if (z7) {
            r(this.f38543b.f38461a, 0L, 10L);
        }
        c("ID1ID2", 8075, this.f38543b.readShort());
        this.f38543b.skip(8L);
        if (((bV0 >> 2) & 1) == 1) {
            this.f38543b.G1(2L);
            if (z7) {
                r(this.f38543b.f38461a, 0L, 2L);
            }
            long jR1 = this.f38543b.f38461a.r1();
            this.f38543b.G1(jR1);
            if (z7) {
                r(this.f38543b.f38461a, 0L, jR1);
            }
            this.f38543b.skip(jR1);
        }
        if (((bV0 >> 3) & 1) == 1) {
            long jM1 = this.f38543b.M1((byte) 0);
            if (jM1 == -1) {
                throw new EOFException();
            }
            if (z7) {
                r(this.f38543b.f38461a, 0L, jM1 + 1);
            }
            this.f38543b.skip(jM1 + 1);
        }
        if (((bV0 >> 4) & 1) == 1) {
            long jM2 = this.f38543b.M1((byte) 0);
            if (jM2 == -1) {
                throw new EOFException();
            }
            if (z7) {
                r(this.f38543b.f38461a, 0L, jM2 + 1);
            }
            this.f38543b.skip(jM2 + 1);
        }
        if (z7) {
            c("FHCRC", this.f38543b.r1(), (short) this.f38546e.getValue());
            this.f38546e.reset();
        }
    }

    private final void q() throws IOException {
        c("CRC", this.f38543b.b1(), (int) this.f38546e.getValue());
        c("ISIZE", this.f38543b.b1(), (int) this.f38544c.getBytesWritten());
    }

    private final void r(m mVar, long j7, long j8) {
        j0 j0Var = mVar.f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        while (true) {
            int i7 = j0Var.f38470c;
            int i8 = j0Var.f38469b;
            if (j7 < i7 - i8) {
                break;
            }
            j7 -= (long) (i7 - i8);
            j0Var = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var);
        }
        while (j8 > 0) {
            int i9 = (int) (((long) j0Var.f38469b) + j7);
            int iMin = (int) Math.min(j0Var.f38470c - i9, j8);
            this.f38546e.update(j0Var.f38468a, i9, iMin);
            j8 -= (long) iMin;
            j0Var = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var);
            j7 = 0;
        }
    }

    @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f38545d.close();
    }

    @Override // okio.o0
    public long read(@a7.d m sink, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (j7 == 0) {
            return 0L;
        }
        if (this.f38542a == 0) {
            e();
            this.f38542a = (byte) 1;
        }
        if (this.f38542a == 1) {
            long jB1 = sink.B1();
            long j8 = this.f38545d.read(sink, j7);
            if (j8 != -1) {
                r(sink, jB1, j8);
                return j8;
            }
            this.f38542a = (byte) 2;
        }
        if (this.f38542a == 2) {
            q();
            this.f38542a = (byte) 3;
            if (!this.f38543b.N()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.o0
    @a7.d
    public q0 timeout() {
        return this.f38543b.timeout();
    }
}
