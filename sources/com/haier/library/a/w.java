package com.haier.library.a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
final class w implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f26321a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f26322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f26323c;

    w(b0 b0Var) {
        if (b0Var == null) {
            throw new NullPointerException("sink == null");
        }
        this.f26322b = b0Var;
    }

    @Override // com.haier.library.a.h
    public h B(j jVar) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.B(jVar);
        return P();
    }

    @Override // com.haier.library.a.b0
    public void I1(g gVar, long j7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.I1(gVar, j7);
        P();
    }

    @Override // com.haier.library.a.h
    public h K1(byte[] bArr) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.K1(bArr);
        return P();
    }

    @Override // com.haier.library.a.h
    public h M(long j7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.M(j7);
        return P();
    }

    @Override // com.haier.library.a.h
    public h N0(int i7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.N0(i7);
        return P();
    }

    @Override // com.haier.library.a.h
    public h O1(int i7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.O1(i7);
        return P();
    }

    @Override // com.haier.library.a.h
    public h P() throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        long jC2 = this.f26321a.c2();
        if (jC2 > 0) {
            this.f26322b.I1(this.f26321a, jC2);
        }
        return this;
    }

    @Override // com.haier.library.a.h
    public h P1(long j7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.P1(j7);
        return P();
    }

    @Override // com.haier.library.a.h
    public h S0(c0 c0Var, long j7) throws IOException {
        while (j7 > 0) {
            long jP0 = c0Var.P0(this.f26321a, j7);
            if (jP0 == -1) {
                throw new EOFException();
            }
            j7 -= jP0;
            P();
        }
        return this;
    }

    @Override // com.haier.library.a.h
    public h T1(byte[] bArr, int i7, int i8) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.T1(bArr, i7, i8);
        return P();
    }

    @Override // com.haier.library.a.h
    public h U0(String str, Charset charset) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.U0(str, charset);
        return P();
    }

    @Override // com.haier.library.a.h
    public h W(String str, int i7, int i8, Charset charset) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.W(str, i7, i8, charset);
        return P();
    }

    @Override // com.haier.library.a.b0
    public d0 a() {
        return this.f26322b.a();
    }

    @Override // com.haier.library.a.h
    public h b(String str) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.b(str);
        return P();
    }

    @Override // com.haier.library.a.h, com.haier.library.a.i
    public g c() {
        return this.f26321a;
    }

    @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f26323c) {
            return;
        }
        g gVar = this.f26321a;
        long j7 = gVar.f26255b;
        if (j7 > 0) {
            this.f26322b.I1(gVar, j7);
        }
        th = null;
        try {
            this.f26322b.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.f26323c = true;
        if (th != null) {
            c.e(th);
        }
    }

    @Override // com.haier.library.a.h
    public OutputStream d() {
        return new a();
    }

    @Override // com.haier.library.a.h
    public h d0(long j7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.d0(j7);
        return P();
    }

    @Override // com.haier.library.a.h
    public h f() throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        long jY0 = this.f26321a.Y0();
        if (jY0 > 0) {
            this.f26322b.I1(this.f26321a, jY0);
        }
        return this;
    }

    @Override // com.haier.library.a.h
    public long f0(c0 c0Var) throws IOException {
        if (c0Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j7 = 0;
        while (true) {
            long jP0 = c0Var.P0(this.f26321a, PlaybackStateCompat.f450z);
            if (jP0 == -1) {
                return j7;
            }
            j7 += jP0;
            P();
        }
    }

    @Override // com.haier.library.a.h, com.haier.library.a.b0, java.io.Flushable
    public void flush() throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        g gVar = this.f26321a;
        long j7 = gVar.f26255b;
        if (j7 > 0) {
            this.f26322b.I1(gVar, j7);
        }
        this.f26322b.flush();
    }

    @Override // com.haier.library.a.h
    public h i0(int i7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.i0(i7);
        return P();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f26323c;
    }

    @Override // com.haier.library.a.h
    public h l1(int i7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.l1(i7);
        return P();
    }

    @Override // com.haier.library.a.h
    public h n(long j7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.n(j7);
        return P();
    }

    public String toString() {
        return "buffer(" + this.f26322b + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f26321a.write(byteBuffer);
        P();
        return iWrite;
    }

    @Override // com.haier.library.a.h
    public h y1(int i7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.y1(i7);
        return P();
    }

    @Override // com.haier.library.a.h
    public h z0(int i7) throws IOException {
        if (this.f26323c) {
            throw new IllegalStateException("closed");
        }
        this.f26321a.z0(i7);
        return P();
    }

    class a extends OutputStream {
        a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            w.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            w wVar = w.this;
            if (wVar.f26323c) {
                return;
            }
            wVar.flush();
        }

        public String toString() {
            return w.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i7) throws IOException {
            w wVar = w.this;
            if (wVar.f26323c) {
                throw new IOException("closed");
            }
            wVar.f26321a.y1((byte) i7);
            w.this.P();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) throws IOException {
            w wVar = w.this;
            if (!wVar.f26323c) {
                wVar.f26321a.T1(bArr, i7, i8);
                w.this.P();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // com.haier.library.a.h
    public h b(String str, int i7, int i8) throws IOException {
        if (!this.f26323c) {
            this.f26321a.b(str, i7, i8);
            return P();
        }
        throw new IllegalStateException("closed");
    }
}
