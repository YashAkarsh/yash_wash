package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final m f38457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public boolean f38458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public final m0 f38459c;

    public h0(@a7.d m0 sink) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        this.f38459c = sink;
        this.f38457a = new m();
    }

    public static /* synthetic */ void b() {
    }

    @Override // okio.n
    @a7.d
    public n B0(@a7.d String string, int i7, int i8) {
        kotlin.jvm.internal.l0.p(string, "string");
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.B0(string, i7, i8);
        return b0();
    }

    @Override // okio.n
    public long C0(@a7.d o0 source) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        long j7 = 0;
        while (true) {
            long j8 = source.read(this.f38457a, 8192);
            if (j8 == -1) {
                return j7;
            }
            j7 += j8;
            b0();
        }
    }

    @Override // okio.n
    @a7.d
    public n D(long j7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.D(j7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n D0(long j7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.D0(j7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n D1(@a7.d String string, int i7, int i8, @a7.d Charset charset) {
        kotlin.jvm.internal.l0.p(string, "string");
        kotlin.jvm.internal.l0.p(charset, "charset");
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.D1(string, i7, i8, charset);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n F0(@a7.d String string, @a7.d Charset charset) {
        kotlin.jvm.internal.l0.p(string, "string");
        kotlin.jvm.internal.l0.p(charset, "charset");
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.F0(string, charset);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n H1(long j7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.H1(j7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public OutputStream J1() {
        return new a();
    }

    @Override // okio.n
    @a7.d
    public n L(int i7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.L(i7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n O0(@a7.d o0 source, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        while (j7 > 0) {
            long j8 = source.read(this.f38457a, j7);
            if (j8 == -1) {
                throw new EOFException();
            }
            j7 -= j8;
            b0();
        }
        return this;
    }

    @Override // okio.n
    @a7.d
    public n b0() throws IOException {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        long jU = this.f38457a.u();
        if (jU > 0) {
            this.f38459c.write(this.f38457a, jU);
        }
        return this;
    }

    @Override // okio.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f38458b) {
            return;
        }
        if (this.f38457a.B1() > 0) {
            m0 m0Var = this.f38459c;
            m mVar = this.f38457a;
            m0Var.write(mVar, mVar.B1());
        }
        th = null;
        try {
            this.f38459c.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.f38458b = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.n, okio.m0, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f38457a.B1() > 0) {
            m0 m0Var = this.f38459c;
            m mVar = this.f38457a;
            m0Var.write(mVar, mVar.B1());
        }
        this.f38459c.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f38458b;
    }

    @Override // okio.n
    @a7.d
    public n m0(int i7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.m0(i7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public m o() {
        return this.f38457a;
    }

    @Override // okio.n
    @a7.d
    public m p() {
        return this.f38457a;
    }

    @Override // okio.n
    @a7.d
    public n p1(@a7.d p byteString) {
        kotlin.jvm.internal.l0.p(byteString, "byteString");
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.p1(byteString);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n q0(@a7.d String string) {
        kotlin.jvm.internal.l0.p(string, "string");
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.q0(string);
        return b0();
    }

    @Override // okio.m0
    @a7.d
    public q0 timeout() {
        return this.f38459c.timeout();
    }

    @a7.d
    public String toString() {
        return "buffer(" + this.f38459c + ')';
    }

    @Override // okio.n
    @a7.d
    public n w() throws IOException {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        long jB1 = this.f38457a.B1();
        if (jB1 > 0) {
            this.f38459c.write(this.f38457a, jB1);
        }
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@a7.d ByteBuffer source) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f38457a.write(source);
        b0();
        return iWrite;
    }

    @Override // okio.n
    @a7.d
    public n writeByte(int i7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.writeByte(i7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n writeInt(int i7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.writeInt(i7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n writeLong(long j7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.writeLong(j7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n writeShort(int i7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.writeShort(i7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n x(int i7) {
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.x(i7);
        return b0();
    }

    @Override // okio.n
    @a7.d
    public n z(@a7.d p byteString, int i7, int i8) {
        kotlin.jvm.internal.l0.p(byteString, "byteString");
        if (!(!this.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f38457a.z(byteString, i7, i8);
        return b0();
    }

    public static final class a extends OutputStream {
        a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            h0.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            h0 h0Var = h0.this;
            if (h0Var.f38458b) {
                return;
            }
            h0Var.flush();
        }

        @a7.d
        public String toString() {
            return h0.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i7) throws IOException {
            h0 h0Var = h0.this;
            if (h0Var.f38458b) {
                throw new IOException("closed");
            }
            h0Var.f38457a.writeByte((byte) i7);
            h0.this.b0();
        }

        @Override // java.io.OutputStream
        public void write(@a7.d byte[] data, int i7, int i8) throws IOException {
            kotlin.jvm.internal.l0.p(data, "data");
            h0 h0Var = h0.this;
            if (!h0Var.f38458b) {
                h0Var.f38457a.write(data, i7, i8);
                h0.this.b0();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // okio.m0
    public void write(@a7.d m source, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        if (!this.f38458b) {
            this.f38457a.write(source, j7);
            b0();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.n
    @a7.d
    public n write(@a7.d byte[] source) {
        kotlin.jvm.internal.l0.p(source, "source");
        if (!this.f38458b) {
            this.f38457a.write(source);
            return b0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.n
    @a7.d
    public n write(@a7.d byte[] source, int i7, int i8) {
        kotlin.jvm.internal.l0.p(source, "source");
        if (!this.f38458b) {
            this.f38457a.write(source, i7, i8);
            return b0();
        }
        throw new IllegalStateException("closed".toString());
    }
}
