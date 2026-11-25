package org.chromium.net.urlconnection;

import c.g1;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import org.chromium.net.q0;
import org.chromium.net.s0;

/* JADX INFO: loaded from: classes3.dex */
final class c extends g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g1
    private static int f39543j = 16384;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f39544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i f39545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f39546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ByteBuffer f39547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final q0 f39548h = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f39549i;

    private class b extends q0 {
        private b() {
        }

        @Override // org.chromium.net.q0
        public long b() {
            return c.this.f39546f;
        }

        @Override // org.chromium.net.q0
        public void c(s0 s0Var, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.f39547g.remaining()) {
                byteBuffer.put(c.this.f39547g);
                c.this.f39547g.clear();
                s0Var.b(false);
                c.this.f39545e.f();
                return;
            }
            int iLimit = c.this.f39547g.limit();
            c.this.f39547g.limit(c.this.f39547g.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.f39547g);
            c.this.f39547g.limit(iLimit);
            s0Var.b(false);
        }

        @Override // org.chromium.net.q0
        public void e(s0 s0Var) {
            s0Var.c(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    c(d dVar, long j7, i iVar) {
        dVar.getClass();
        if (j7 < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.f39546f = j7;
        this.f39547g = ByteBuffer.allocate((int) Math.min(j7, f39543j));
        this.f39544d = dVar;
        this.f39545e = iVar;
        this.f39549i = 0L;
    }

    private void G(int i7) throws ProtocolException {
        if (this.f39549i + ((long) i7) <= this.f39546f) {
            return;
        }
        throw new ProtocolException("expected " + (this.f39546f - this.f39549i) + " bytes but received " + i7);
    }

    private void H() throws IOException {
        if (this.f39547g.hasRemaining()) {
            return;
        }
        Q();
    }

    @g1
    static void K(int i7) {
        f39543j = i7;
    }

    private void Q() throws IOException {
        e();
        this.f39547g.flip();
        this.f39545e.d();
        b();
    }

    private void g0() throws IOException {
        if (this.f39549i == this.f39546f) {
            Q();
        }
    }

    @Override // org.chromium.net.urlconnection.g
    void q() throws IOException {
        if (this.f39549i < this.f39546f) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    @Override // org.chromium.net.urlconnection.g
    q0 r() {
        return this.f39548h;
    }

    @Override // org.chromium.net.urlconnection.g
    void u() throws IOException {
    }

    @Override // java.io.OutputStream
    public void write(int i7) throws IOException {
        e();
        G(1);
        H();
        this.f39547g.put((byte) i7);
        this.f39549i++;
        g0();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) throws IOException {
        e();
        if (bArr.length - i7 >= i8 && i7 >= 0 && i8 >= 0) {
            G(i8);
            int i9 = i8;
            while (i9 > 0) {
                H();
                int iMin = Math.min(i9, this.f39547g.remaining());
                this.f39547g.put(bArr, (i7 + i8) - i9, iMin);
                i9 -= iMin;
            }
            this.f39549i += (long) i8;
            g0();
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
