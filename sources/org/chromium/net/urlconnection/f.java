package org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
class f extends InputStream {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f39571e = 32768;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f39572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f39573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer f39574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IOException f39575d;

    public f(d dVar) {
        this.f39572a = dVar;
    }

    private void b() throws IOException {
        if (this.f39573b) {
            IOException iOException = this.f39575d;
            if (iOException != null) {
                throw iOException;
            }
        } else {
            if (e()) {
                return;
            }
            if (this.f39574c == null) {
                this.f39574c = ByteBuffer.allocateDirect(32768);
            }
            this.f39574c.clear();
            this.f39572a.r(this.f39574c);
            IOException iOException2 = this.f39575d;
            if (iOException2 != null) {
                throw iOException2;
            }
            ByteBuffer byteBuffer = this.f39574c;
            if (byteBuffer != null) {
                byteBuffer.flip();
            }
        }
    }

    private boolean e() {
        ByteBuffer byteBuffer = this.f39574c;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }

    void f(IOException iOException) {
        this.f39575d = iOException;
        this.f39573b = true;
        this.f39574c = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        b();
        if (e()) {
            return this.f39574c.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        if (i7 < 0 || i8 < 0 || i7 + i8 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i8 == 0) {
            return 0;
        }
        b();
        if (!e()) {
            return -1;
        }
        int iMin = Math.min(this.f39574c.limit() - this.f39574c.position(), i8);
        this.f39574c.get(bArr, i7, iMin);
        return iMin;
    }
}
