package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final m f38461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public boolean f38462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public final o0 f38463c;

    public i0(@a7.d o0 source) {
        kotlin.jvm.internal.l0.p(source, "source");
        this.f38463c = source;
        this.f38461a = new m();
    }

    public static /* synthetic */ void b() {
    }

    @Override // okio.o
    public int A0() throws EOFException {
        G1(1L);
        byte bV0 = this.f38461a.v0(0L);
        if ((bV0 & 224) == 192) {
            G1(2L);
        } else if ((bV0 & 240) == 224) {
            G1(3L);
        } else if ((bV0 & 248) == 240) {
            G1(4L);
        }
        return this.f38461a.A0();
    }

    @Override // okio.o
    @a7.d
    public p E0() throws IOException {
        this.f38461a.C0(this.f38463c);
        return this.f38461a.E0();
    }

    @Override // okio.o
    public long F1(@a7.d p targetBytes, long j7) {
        kotlin.jvm.internal.l0.p(targetBytes, "targetBytes");
        if (!(!this.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jF1 = this.f38461a.F1(targetBytes, j7);
            if (jF1 != -1) {
                return jF1;
            }
            long jB1 = this.f38461a.B1();
            if (this.f38463c.read(this.f38461a, 8192) == -1) {
                return -1L;
            }
            j7 = Math.max(j7, jB1);
        }
    }

    @Override // okio.o
    public void G1(long j7) throws EOFException {
        if (!K0(j7)) {
            throw new EOFException();
        }
    }

    @Override // okio.o
    @a7.d
    public byte[] I() throws IOException {
        this.f38461a.C0(this.f38463c);
        return this.f38461a.I();
    }

    @Override // okio.o
    public long J(@a7.d p bytes) {
        kotlin.jvm.internal.l0.p(bytes, "bytes");
        return k(bytes, 0L);
    }

    @Override // okio.o
    public boolean K0(long j7) {
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (!(!this.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f38461a.B1() < j7) {
            if (this.f38463c.read(this.f38461a, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.o
    public long M1(byte b8) {
        return Y(b8, 0L, Long.MAX_VALUE);
    }

    @Override // okio.o
    public boolean N() {
        if (!this.f38462b) {
            return this.f38461a.N() && this.f38463c.read(this.f38461a, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.o
    public long Q1() throws EOFException {
        G1(1L);
        int i7 = 0;
        while (true) {
            int i8 = i7 + 1;
            if (!K0(i8)) {
                break;
            }
            byte bV0 = this.f38461a.v0(i7);
            if ((bV0 < ((byte) 48) || bV0 > ((byte) 57)) && ((bV0 < ((byte) 97) || bV0 > ((byte) 102)) && (bV0 < ((byte) 65) || bV0 > ((byte) 70)))) {
                if (i7 != 0) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bV0, kotlin.text.d.a(kotlin.text.d.a(16)));
                kotlin.jvm.internal.l0.o(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sb.append(string);
                throw new NumberFormatException(sb.toString());
            }
            i7 = i8;
        }
        return this.f38461a.Q1();
    }

    @Override // okio.o
    @a7.d
    public InputStream S1() {
        return new a();
    }

    @Override // okio.o
    public long U(byte b8, long j7) {
        return Y(b8, j7, Long.MAX_VALUE);
    }

    @Override // okio.o
    public void V(@a7.d m sink, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        try {
            G1(j7);
            this.f38461a.V(sink, j7);
        } catch (EOFException e8) {
            sink.C0(this.f38461a);
            throw e8;
        }
    }

    @Override // okio.o
    public int V1(@a7.d d0 options) throws EOFException {
        kotlin.jvm.internal.l0.p(options, "options");
        if (!(!this.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iD0 = v5.a.d0(this.f38461a, options, true);
            if (iD0 != -2) {
                if (iD0 == -1) {
                    break;
                }
                this.f38461a.skip(options.f()[iD0].a0());
                return iD0;
            }
        } while (this.f38463c.read(this.f38461a, 8192) != -1);
        return -1;
    }

    @Override // okio.o
    @a7.d
    public String X0() {
        return e0(Long.MAX_VALUE);
    }

    @Override // okio.o
    public long Y(byte b8, long j7, long j8) {
        if (!(!this.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j7 && j8 >= j7)) {
            throw new IllegalArgumentException(("fromIndex=" + j7 + " toIndex=" + j8).toString());
        }
        while (j7 < j8) {
            long jY = this.f38461a.Y(b8, j7, j8);
            if (jY != -1) {
                return jY;
            }
            long jB1 = this.f38461a.B1();
            if (jB1 >= j8 || this.f38463c.read(this.f38461a, 8192) == -1) {
                return -1L;
            }
            j7 = Math.max(j7, jB1);
        }
        return -1L;
    }

    @Override // okio.o
    public long Z(@a7.d p targetBytes) {
        kotlin.jvm.internal.l0.p(targetBytes, "targetBytes");
        return F1(targetBytes, 0L);
    }

    @Override // okio.o
    @a7.e
    public String a0() {
        long jM1 = M1((byte) 10);
        if (jM1 != -1) {
            return v5.a.b0(this.f38461a, jM1);
        }
        if (this.f38461a.B1() != 0) {
            return h(this.f38461a.B1());
        }
        return null;
    }

    @Override // okio.o
    public int b1() throws EOFException {
        G1(4L);
        return this.f38461a.b1();
    }

    @Override // okio.o
    public long c0() throws EOFException {
        G1(1L);
        long j7 = 0;
        while (true) {
            long j8 = j7 + 1;
            if (!K0(j8)) {
                break;
            }
            byte bV0 = this.f38461a.v0(j7);
            if ((bV0 < ((byte) 48) || bV0 > ((byte) 57)) && !(j7 == 0 && bV0 == ((byte) 45))) {
                if (j7 != 0) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9] or '-' character but was 0x");
                String string = Integer.toString(bV0, kotlin.text.d.a(kotlin.text.d.a(16)));
                kotlin.jvm.internal.l0.o(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sb.append(string);
                throw new NumberFormatException(sb.toString());
            }
            j7 = j8;
        }
        return this.f38461a.c0();
    }

    @Override // okio.o
    public boolean c1(long j7, @a7.d p bytes, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bytes, "bytes");
        if (!(!this.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j7 >= 0 && i7 >= 0 && i8 >= 0 && bytes.a0() - i7 >= i8) {
            for (int i9 = 0; i9 < i8; i9++) {
                long j8 = ((long) i9) + j7;
                if (K0(1 + j8) && this.f38461a.v0(j8) == bytes.n(i7 + i9)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f38462b) {
            return;
        }
        this.f38462b = true;
        this.f38463c.close();
        this.f38461a.q();
    }

    @Override // okio.o
    @a7.d
    public String e0(long j7) throws EOFException {
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j7).toString());
        }
        long j8 = j7 == Long.MAX_VALUE ? Long.MAX_VALUE : j7 + 1;
        byte b8 = (byte) 10;
        long jY = Y(b8, 0L, j8);
        if (jY != -1) {
            return v5.a.b0(this.f38461a, jY);
        }
        if (j8 < Long.MAX_VALUE && K0(j8) && this.f38461a.v0(j8 - 1) == ((byte) 13) && K0(1 + j8) && this.f38461a.v0(j8) == b8) {
            return v5.a.b0(this.f38461a, j8);
        }
        m mVar = new m();
        m mVar2 = this.f38461a;
        mVar2.Q(mVar, 0L, Math.min(32, mVar2.B1()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f38461a.B1(), j7) + " content=" + mVar.E0().t() + "…");
    }

    @Override // okio.o
    @a7.d
    public String h(long j7) throws EOFException {
        G1(j7);
        return this.f38461a.h(j7);
    }

    @Override // okio.o
    @a7.d
    public byte[] h1(long j7) throws EOFException {
        G1(j7);
        return this.f38461a.h1(j7);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f38462b;
    }

    @Override // okio.o
    public long k(@a7.d p bytes, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(bytes, "bytes");
        if (!(!this.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jK = this.f38461a.k(bytes, j7);
            if (jK != -1) {
                return jK;
            }
            long jB1 = this.f38461a.B1();
            if (this.f38463c.read(this.f38461a, 8192) == -1) {
                return -1L;
            }
            j7 = Math.max(j7, (jB1 - ((long) bytes.a0())) + 1);
        }
    }

    @Override // okio.o
    @a7.d
    public p l(long j7) throws EOFException {
        G1(j7);
        return this.f38461a.l(j7);
    }

    @Override // okio.o
    @a7.d
    public String m1() throws IOException {
        this.f38461a.C0(this.f38463c);
        return this.f38461a.m1();
    }

    @Override // okio.o
    @a7.d
    public m o() {
        return this.f38461a;
    }

    @Override // okio.o
    @a7.d
    public String o1(long j7, @a7.d Charset charset) throws EOFException {
        kotlin.jvm.internal.l0.p(charset, "charset");
        G1(j7);
        return this.f38461a.o1(j7, charset);
    }

    @Override // okio.o
    @a7.d
    public m p() {
        return this.f38461a;
    }

    @Override // okio.o
    @a7.d
    public o peek() {
        return a0.d(new f0(this));
    }

    @Override // okio.o
    public short r1() throws EOFException {
        G1(2L);
        return this.f38461a.r1();
    }

    @Override // okio.o
    public int read(@a7.d byte[] sink) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.o
    public byte readByte() throws EOFException {
        G1(1L);
        return this.f38461a.readByte();
    }

    @Override // okio.o
    public void readFully(@a7.d byte[] sink) throws EOFException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        try {
            G1(sink.length);
            this.f38461a.readFully(sink);
        } catch (EOFException e8) {
            int i7 = 0;
            while (this.f38461a.B1() > 0) {
                m mVar = this.f38461a;
                int i8 = mVar.read(sink, i7, (int) mVar.B1());
                if (i8 == -1) {
                    throw new AssertionError();
                }
                i7 += i8;
            }
            throw e8;
        }
    }

    @Override // okio.o
    public int readInt() throws EOFException {
        G1(4L);
        return this.f38461a.readInt();
    }

    @Override // okio.o
    public long readLong() throws EOFException {
        G1(8L);
        return this.f38461a.readLong();
    }

    @Override // okio.o
    public short readShort() throws EOFException {
        G1(2L);
        return this.f38461a.readShort();
    }

    @Override // okio.o
    public void skip(long j7) throws EOFException {
        if (!(!this.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j7 > 0) {
            if (this.f38461a.B1() == 0 && this.f38463c.read(this.f38461a, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j7, this.f38461a.B1());
            this.f38461a.skip(jMin);
            j7 -= jMin;
        }
    }

    @Override // okio.o
    public boolean t0(long j7, @a7.d p bytes) {
        kotlin.jvm.internal.l0.p(bytes, "bytes");
        return c1(j7, bytes, 0, bytes.a0());
    }

    @Override // okio.o0
    @a7.d
    public q0 timeout() {
        return this.f38463c.timeout();
    }

    @a7.d
    public String toString() {
        return "buffer(" + this.f38463c + ')';
    }

    @Override // okio.o
    @a7.d
    public String u0(@a7.d Charset charset) throws IOException {
        kotlin.jvm.internal.l0.p(charset, "charset");
        this.f38461a.C0(this.f38463c);
        return this.f38461a.u0(charset);
    }

    @Override // okio.o
    public long v1() throws EOFException {
        G1(8L);
        return this.f38461a.v1();
    }

    @Override // okio.o
    public long x1(@a7.d m0 sink) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        long j7 = 0;
        while (this.f38463c.read(this.f38461a, 8192) != -1) {
            long jU = this.f38461a.u();
            if (jU > 0) {
                j7 += jU;
                sink.write(this.f38461a, jU);
            }
        }
        if (this.f38461a.B1() <= 0) {
            return j7;
        }
        long jB1 = j7 + this.f38461a.B1();
        m mVar = this.f38461a;
        sink.write(mVar, mVar.B1());
        return jB1;
    }

    @Override // okio.o0
    public long read(@a7.d m sink, long j7) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (!(!this.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f38461a.B1() == 0 && this.f38463c.read(this.f38461a, 8192) == -1) {
            return -1L;
        }
        return this.f38461a.read(sink, Math.min(j7, this.f38461a.B1()));
    }

    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            i0 i0Var = i0.this;
            if (i0Var.f38462b) {
                throw new IOException("closed");
            }
            return (int) Math.min(i0Var.f38461a.B1(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            i0.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            i0 i0Var = i0.this;
            if (i0Var.f38462b) {
                throw new IOException("closed");
            }
            if (i0Var.f38461a.B1() == 0) {
                i0 i0Var2 = i0.this;
                if (i0Var2.f38463c.read(i0Var2.f38461a, 8192) == -1) {
                    return -1;
                }
            }
            return i0.this.f38461a.readByte() & 255;
        }

        @a7.d
        public String toString() {
            return i0.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(@a7.d byte[] data, int i7, int i8) throws IOException {
            kotlin.jvm.internal.l0.p(data, "data");
            if (!i0.this.f38462b) {
                j.e(data.length, i7, i8);
                if (i0.this.f38461a.B1() == 0) {
                    i0 i0Var = i0.this;
                    if (i0Var.f38463c.read(i0Var.f38461a, 8192) == -1) {
                        return -1;
                    }
                }
                return i0.this.f38461a.read(data, i7, i8);
            }
            throw new IOException("closed");
        }
    }

    @Override // okio.o
    public int read(@a7.d byte[] sink, int i7, int i8) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        long j7 = i8;
        j.e(sink.length, i7, j7);
        if (this.f38461a.B1() == 0 && this.f38463c.read(this.f38461a, 8192) == -1) {
            return -1;
        }
        return this.f38461a.read(sink, i7, (int) Math.min(j7, this.f38461a.B1()));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@a7.d ByteBuffer sink) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        if (this.f38461a.B1() == 0 && this.f38463c.read(this.f38461a, 8192) == -1) {
            return -1;
        }
        return this.f38461a.read(sink);
    }
}
