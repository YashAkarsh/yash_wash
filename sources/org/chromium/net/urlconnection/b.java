package org.chromium.net.urlconnection;

import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
import org.chromium.net.q0;
import org.chromium.net.s0;

/* JADX INFO: loaded from: classes3.dex */
final class b extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f39537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i f39538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ByteBuffer f39539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final q0 f39540g = new C0525b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f39541h;

    /* JADX INFO: renamed from: org.chromium.net.urlconnection.b$b, reason: collision with other inner class name */
    private class C0525b extends q0 {
        private C0525b() {
        }

        @Override // org.chromium.net.q0
        public long b() {
            return -1L;
        }

        @Override // org.chromium.net.q0
        public void c(s0 s0Var, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() < b.this.f39539f.remaining()) {
                int iLimit = b.this.f39539f.limit();
                b.this.f39539f.limit(b.this.f39539f.position() + byteBuffer.remaining());
                byteBuffer.put(b.this.f39539f);
                b.this.f39539f.limit(iLimit);
                s0Var.b(false);
                return;
            }
            byteBuffer.put(b.this.f39539f);
            b.this.f39539f.clear();
            s0Var.b(b.this.f39541h);
            if (b.this.f39541h) {
                return;
            }
            b.this.f39538e.f();
        }

        @Override // org.chromium.net.q0
        public void e(s0 s0Var) {
            s0Var.c(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    b(d dVar, int i7, i iVar) {
        dVar.getClass();
        if (i7 <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.f39539f = ByteBuffer.allocate(i7);
        this.f39537d = dVar;
        this.f39538e = iVar;
    }

    private void G() throws IOException {
        if (this.f39539f.hasRemaining()) {
            return;
        }
        H();
    }

    private void H() throws IOException {
        e();
        this.f39539f.flip();
        this.f39538e.d();
        b();
    }

    @Override // org.chromium.net.urlconnection.g, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.f39541h) {
            return;
        }
        this.f39541h = true;
        this.f39539f.flip();
    }

    @Override // org.chromium.net.urlconnection.g
    void q() throws IOException {
    }

    @Override // org.chromium.net.urlconnection.g
    q0 r() {
        return this.f39540g;
    }

    @Override // org.chromium.net.urlconnection.g
    void u() throws IOException {
    }

    @Override // java.io.OutputStream
    public void write(int i7) throws IOException {
        G();
        this.f39539f.put((byte) i7);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) throws IOException {
        e();
        if (bArr.length - i7 < i8 || i7 < 0 || i8 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i9 = i8;
        while (i9 > 0) {
            int iMin = Math.min(i9, this.f39539f.remaining());
            this.f39539f.put(bArr, (i7 + i8) - i9, iMin);
            i9 -= iMin;
            G();
        }
    }
}
