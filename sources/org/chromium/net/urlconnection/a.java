package org.chromium.net.urlconnection;

import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import org.chromium.net.q0;
import org.chromium.net.s0;

/* JADX INFO: loaded from: classes3.dex */
final class a extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f39530i = 16384;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f39531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f39532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final q0 f39533f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ByteBuffer f39534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f39535h;

    private class b extends q0 {
        private b() {
        }

        @Override // org.chromium.net.q0
        public long b() {
            if (a.this.f39531d == -1) {
                return a.this.f39535h ? a.this.f39534g.limit() : a.this.f39534g.position();
            }
            return a.this.f39531d;
        }

        @Override // org.chromium.net.q0
        public void c(s0 s0Var, ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (iRemaining < a.this.f39534g.remaining()) {
                byteBuffer.put(a.this.f39534g.array(), a.this.f39534g.position(), iRemaining);
                a.this.f39534g.position(a.this.f39534g.position() + iRemaining);
            } else {
                byteBuffer.put(a.this.f39534g);
            }
            s0Var.b(false);
        }

        @Override // org.chromium.net.q0
        public void e(s0 s0Var) {
            a.this.f39534g.position(0);
            s0Var.d();
        }
    }

    a(d dVar, long j7) {
        if (dVar == null) {
            throw new NullPointerException("Argument connection cannot be null.");
        }
        if (j7 > 2147483647L) {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
        }
        if (j7 < 0) {
            throw new IllegalArgumentException("Content length < 0.");
        }
        this.f39532e = dVar;
        int i7 = (int) j7;
        this.f39531d = i7;
        this.f39534g = ByteBuffer.allocate(i7);
    }

    private void G(int i7) throws IOException {
        if (this.f39531d != -1 && this.f39534g.position() + i7 > this.f39531d) {
            throw new ProtocolException("exceeded content-length limit of " + this.f39531d + " bytes");
        }
        if (this.f39535h) {
            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for writing after connect");
        }
        if (this.f39531d == -1 && this.f39534g.limit() - this.f39534g.position() <= i7) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.max(this.f39534g.capacity() * 2, this.f39534g.capacity() + i7));
            this.f39534g.flip();
            byteBufferAllocate.put(this.f39534g);
            this.f39534g = byteBufferAllocate;
        }
    }

    @Override // org.chromium.net.urlconnection.g
    void q() throws IOException {
    }

    @Override // org.chromium.net.urlconnection.g
    q0 r() {
        return this.f39533f;
    }

    @Override // org.chromium.net.urlconnection.g
    void u() throws IOException {
        this.f39535h = true;
        if (this.f39534g.position() < this.f39531d) {
            throw new ProtocolException("Content received is less than Content-Length");
        }
        this.f39534g.flip();
    }

    @Override // java.io.OutputStream
    public void write(int i7) throws IOException {
        e();
        G(1);
        this.f39534g.put((byte) i7);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) throws IOException {
        e();
        G(i8);
        this.f39534g.put(bArr, i7, i8);
    }

    a(d dVar) {
        dVar.getClass();
        this.f39532e = dVar;
        this.f39531d = -1;
        this.f39534g = ByteBuffer.allocate(16384);
    }
}
