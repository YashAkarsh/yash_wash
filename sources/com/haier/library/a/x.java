package com.haier.library.a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
final class x implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f26325a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f26326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f26327c;

    x(c0 c0Var) {
        if (c0Var == null) {
            throw new NullPointerException("source == null");
        }
        this.f26326b = c0Var;
    }

    @Override // com.haier.library.a.i
    public boolean A(long j7, j jVar) throws IOException {
        return w0(j7, jVar, 0, jVar.Z());
    }

    @Override // com.haier.library.a.i
    public String C1(long j7) throws IOException {
        a(j7);
        return this.f26325a.C1(j7);
    }

    @Override // com.haier.library.a.i
    public long E1() throws IOException {
        a(1L);
        int i7 = 0;
        while (true) {
            int i8 = i7 + 1;
            if (!b(i8)) {
                break;
            }
            byte bQ1 = this.f26325a.q1(i7);
            if ((bQ1 < 48 || bQ1 > 57) && !(i7 == 0 && bQ1 == 45)) {
                if (i7 != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(bQ1)));
            }
            i7 = i8;
        }
        return this.f26325a.E1();
    }

    @Override // com.haier.library.a.i
    public long H0(j jVar, long j7) throws IOException {
        if (this.f26327c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jH0 = this.f26325a.H0(jVar, j7);
            if (jH0 != -1) {
                return jH0;
            }
            g gVar = this.f26325a;
            long j8 = gVar.f26255b;
            if (this.f26326b.P0(gVar, PlaybackStateCompat.f450z) == -1) {
                return -1L;
            }
            j7 = Math.max(j7, j8);
        }
    }

    @Override // com.haier.library.a.i
    public long L1(byte b8, long j7) throws IOException {
        return U1(b8, j7, Long.MAX_VALUE);
    }

    @Override // com.haier.library.a.i
    public int M0(byte[] bArr) throws IOException {
        return W0(bArr, 0, bArr.length);
    }

    @Override // com.haier.library.a.i
    public String O(long j7, Charset charset) throws IOException {
        a(j7);
        if (charset != null) {
            return this.f26325a.O(j7, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.haier.library.a.c0
    public long P0(g gVar, long j7) throws IOException {
        if (gVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        }
        if (this.f26327c) {
            throw new IllegalStateException("closed");
        }
        g gVar2 = this.f26325a;
        if (gVar2.f26255b == 0 && this.f26326b.P0(gVar2, PlaybackStateCompat.f450z) == -1) {
            return -1L;
        }
        return this.f26325a.P0(gVar, Math.min(j7, this.f26325a.f26255b));
    }

    @Override // com.haier.library.a.i
    public int R0() throws IOException {
        a(1L);
        byte bQ1 = this.f26325a.q1(0L);
        if ((bQ1 & 224) == 192) {
            a(2L);
        } else if ((bQ1 & 240) == 224) {
            a(3L);
        } else if ((bQ1 & 248) == 240) {
            a(4L);
        }
        return this.f26325a.R0();
    }

    @Override // com.haier.library.a.i
    public byte[] S(long j7) throws IOException {
        a(j7);
        return this.f26325a.S(j7);
    }

    @Override // com.haier.library.a.i
    public String T() throws IOException {
        this.f26325a.f0(this.f26326b);
        return this.f26325a.T();
    }

    @Override // com.haier.library.a.i
    public long U1(byte b8, long j7, long j8) throws IOException {
        if (this.f26327c) {
            throw new IllegalStateException("closed");
        }
        if (j7 < 0 || j8 < j7) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j7), Long.valueOf(j8)));
        }
        while (j7 < j8) {
            long jU1 = this.f26325a.U1(b8, j7, j8);
            if (jU1 != -1) {
                return jU1;
            }
            g gVar = this.f26325a;
            long j9 = gVar.f26255b;
            if (j9 >= j8 || this.f26326b.P0(gVar, PlaybackStateCompat.f450z) == -1) {
                break;
            }
            j7 = Math.max(j7, j9);
        }
        return -1L;
    }

    @Override // com.haier.library.a.i
    public int W0(byte[] bArr, int i7, int i8) throws IOException {
        long j7 = i8;
        c.d(bArr.length, i7, j7);
        g gVar = this.f26325a;
        if (gVar.f26255b == 0 && this.f26326b.P0(gVar, PlaybackStateCompat.f450z) == -1) {
            return -1;
        }
        return this.f26325a.W0(bArr, i7, (int) Math.min(j7, this.f26325a.f26255b));
    }

    @Override // com.haier.library.a.i
    public int X(u uVar) throws IOException {
        if (this.f26327c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iH = this.f26325a.H(uVar, true);
            if (iH == -1) {
                return -1;
            }
            if (iH != -2) {
                this.f26325a.j0(uVar.f26309a[iH].Z());
                return iH;
            }
        } while (this.f26326b.P0(this.f26325a, PlaybackStateCompat.f450z) != -1);
        return -1;
    }

    @Override // com.haier.library.a.i
    public int Z0() throws IOException {
        a(4L);
        return this.f26325a.Z0();
    }

    @Override // com.haier.library.a.i
    public void a(long j7) throws IOException {
        if (!b(j7)) {
            throw new EOFException();
        }
    }

    @Override // com.haier.library.a.i
    public boolean b(long j7) throws IOException {
        g gVar;
        if (j7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        }
        if (this.f26327c) {
            throw new IllegalStateException("closed");
        }
        do {
            gVar = this.f26325a;
            if (gVar.f26255b >= j7) {
                return true;
            }
        } while (this.f26326b.P0(gVar, PlaybackStateCompat.f450z) != -1);
        return false;
    }

    @Override // com.haier.library.a.i
    public g c() {
        return this.f26325a;
    }

    @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26327c) {
            return;
        }
        this.f26327c = true;
        this.f26326b.close();
        this.f26325a.h2();
    }

    @Override // com.haier.library.a.i
    public long d(j jVar) throws IOException {
        return f1(jVar, 0L);
    }

    @Override // com.haier.library.a.i
    public long f1(j jVar, long j7) throws IOException {
        if (this.f26327c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jF1 = this.f26325a.f1(jVar, j7);
            if (jF1 != -1) {
                return jF1;
            }
            g gVar = this.f26325a;
            long j8 = gVar.f26255b;
            if (this.f26326b.P0(gVar, PlaybackStateCompat.f450z) == -1) {
                return -1L;
            }
            j7 = Math.max(j7, (j8 - ((long) jVar.Z())) + 1);
        }
    }

    @Override // com.haier.library.a.i
    public boolean g() throws IOException {
        if (this.f26327c) {
            throw new IllegalStateException("closed");
        }
        return this.f26325a.g() && this.f26326b.P0(this.f26325a, PlaybackStateCompat.f450z) == -1;
    }

    @Override // com.haier.library.a.i
    public long g1(b0 b0Var) throws IOException {
        if (b0Var == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j7 = 0;
        while (this.f26326b.P0(this.f26325a, PlaybackStateCompat.f450z) != -1) {
            long jC2 = this.f26325a.c2();
            if (jC2 > 0) {
                j7 += jC2;
                b0Var.I1(this.f26325a, jC2);
            }
        }
        if (this.f26325a.Y0() <= 0) {
            return j7;
        }
        long jY0 = j7 + this.f26325a.Y0();
        g gVar = this.f26325a;
        b0Var.I1(gVar, gVar.Y0());
        return jY0;
    }

    @Override // com.haier.library.a.i
    public InputStream h() {
        return new a();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f26327c;
    }

    @Override // com.haier.library.a.i
    public byte j() throws IOException {
        a(1L);
        return this.f26325a.j();
    }

    @Override // com.haier.library.a.i
    public void j0(long j7) throws IOException {
        if (this.f26327c) {
            throw new IllegalStateException("closed");
        }
        while (j7 > 0) {
            g gVar = this.f26325a;
            if (gVar.f26255b == 0 && this.f26326b.P0(gVar, PlaybackStateCompat.f450z) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j7, this.f26325a.Y0());
            this.f26325a.j0(jMin);
            j7 -= jMin;
        }
    }

    @Override // com.haier.library.a.i
    public String j1(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f26325a.f0(this.f26326b);
        return this.f26325a.j1(charset);
    }

    @Override // com.haier.library.a.i
    public short k() throws IOException {
        a(2L);
        return this.f26325a.k();
    }

    @Override // com.haier.library.a.i
    @Nullable
    public String k0() throws IOException {
        long jN0 = n0((byte) 10);
        if (jN0 != -1) {
            return this.f26325a.a2(jN0);
        }
        long j7 = this.f26325a.f26255b;
        if (j7 != 0) {
            return C1(j7);
        }
        return null;
    }

    @Override // com.haier.library.a.i
    public void k1(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.f26325a.k1(bArr);
        } catch (EOFException e8) {
            int i7 = 0;
            while (true) {
                g gVar = this.f26325a;
                long j7 = gVar.f26255b;
                if (j7 <= 0) {
                    throw e8;
                }
                int iW0 = gVar.W0(bArr, i7, (int) j7);
                if (iW0 == -1) {
                    throw new AssertionError();
                }
                i7 += iW0;
            }
        }
    }

    @Override // com.haier.library.a.i
    public int l() throws IOException {
        a(4L);
        return this.f26325a.l();
    }

    @Override // com.haier.library.a.i
    public long m() throws IOException {
        a(8L);
        return this.f26325a.m();
    }

    @Override // com.haier.library.a.i
    public short n() throws IOException {
        a(2L);
        return this.f26325a.n();
    }

    @Override // com.haier.library.a.i
    public long n0(byte b8) throws IOException {
        return U1(b8, 0L, Long.MAX_VALUE);
    }

    @Override // com.haier.library.a.i
    public byte[] n1() throws IOException {
        this.f26325a.f0(this.f26326b);
        return this.f26325a.n1();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        g gVar = this.f26325a;
        if (gVar.f26255b == 0 && this.f26326b.P0(gVar, PlaybackStateCompat.f450z) == -1) {
            return -1;
        }
        return this.f26325a.read(byteBuffer);
    }

    @Override // com.haier.library.a.i
    public j s() throws IOException {
        this.f26325a.f0(this.f26326b);
        return this.f26325a.s();
    }

    @Override // com.haier.library.a.i
    public long t() throws IOException {
        a(1L);
        int i7 = 0;
        while (true) {
            int i8 = i7 + 1;
            if (!b(i8)) {
                break;
            }
            byte bQ1 = this.f26325a.q1(i7);
            if ((bQ1 < 48 || bQ1 > 57) && ((bQ1 < 97 || bQ1 > 102) && (bQ1 < 65 || bQ1 > 70))) {
                if (i7 != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bQ1)));
            }
            i7 = i8;
        }
        return this.f26325a.t();
    }

    @Override // com.haier.library.a.i
    public j t1(long j7) throws IOException {
        a(j7);
        return this.f26325a.t1(j7);
    }

    public String toString() {
        return "buffer(" + this.f26326b + ")";
    }

    @Override // com.haier.library.a.i
    public long u1() throws IOException {
        a(8L);
        return this.f26325a.u1();
    }

    @Override // com.haier.library.a.i
    public String v() throws IOException {
        return j(Long.MAX_VALUE);
    }

    @Override // com.haier.library.a.i
    public boolean w0(long j7, j jVar, int i7, int i8) throws IOException {
        if (this.f26327c) {
            throw new IllegalStateException("closed");
        }
        if (j7 < 0 || i7 < 0 || i8 < 0 || jVar.Z() - i7 < i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            long j8 = ((long) i9) + j7;
            if (!b(1 + j8) || this.f26325a.q1(j8) != jVar.x(i7 + i9)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.haier.library.a.i
    public void y0(g gVar, long j7) throws IOException {
        try {
            a(j7);
            this.f26325a.y0(gVar, j7);
        } catch (EOFException e8) {
            gVar.f0(this.f26325a);
            throw e8;
        }
    }

    @Override // com.haier.library.a.i
    public long a(j jVar) throws IOException {
        return H0(jVar, 0L);
    }

    @Override // com.haier.library.a.c0
    public d0 a() {
        return this.f26326b.a();
    }

    @Override // com.haier.library.a.i
    public String j(long j7) throws IOException {
        if (j7 >= 0) {
            long j8 = j7 == Long.MAX_VALUE ? Long.MAX_VALUE : j7 + 1;
            long jU1 = U1((byte) 10, 0L, j8);
            if (jU1 != -1) {
                return this.f26325a.a2(jU1);
            }
            if (j8 < Long.MAX_VALUE && b(j8) && this.f26325a.q1(j8 - 1) == 13 && b(1 + j8) && this.f26325a.q1(j8) == 10) {
                return this.f26325a.a2(j8);
            }
            g gVar = new g();
            g gVar2 = this.f26325a;
            gVar2.h0(gVar, 0L, Math.min(32L, gVar2.Y0()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f26325a.Y0(), j7) + " content=" + gVar.s().W() + h0.F);
        }
        throw new IllegalArgumentException("limit < 0: " + j7);
    }

    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            x xVar = x.this;
            if (xVar.f26327c) {
                throw new IOException("closed");
            }
            return (int) Math.min(xVar.f26325a.f26255b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            x.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            x xVar = x.this;
            if (xVar.f26327c) {
                throw new IOException("closed");
            }
            g gVar = xVar.f26325a;
            if (gVar.f26255b == 0 && xVar.f26326b.P0(gVar, PlaybackStateCompat.f450z) == -1) {
                return -1;
            }
            return x.this.f26325a.j() & 255;
        }

        public String toString() {
            return x.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) throws IOException {
            if (!x.this.f26327c) {
                c.d(bArr.length, i7, i8);
                x xVar = x.this;
                g gVar = xVar.f26325a;
                if (gVar.f26255b == 0 && xVar.f26326b.P0(gVar, PlaybackStateCompat.f450z) == -1) {
                    return -1;
                }
                return x.this.f26325a.W0(bArr, i7, i8);
            }
            throw new IOException("closed");
        }
    }
}
