package com.google.common.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class e2 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Reader f21958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharsetEncoder f21959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f21960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharBuffer f21961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ByteBuffer f21962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f21963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f21964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f21965h;

    e2(Reader reader, Charset charset, int i7) {
        this(reader, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), i7);
    }

    private static int b(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    private int c(byte[] bArr, int i7, int i8) {
        int iMin = Math.min(i8, this.f21962e.remaining());
        this.f21962e.get(bArr, i7, iMin);
        return iMin;
    }

    private static CharBuffer e(CharBuffer charBuffer) {
        CharBuffer charBufferWrap = CharBuffer.wrap(Arrays.copyOf(charBuffer.array(), charBuffer.capacity() * 2));
        charBufferWrap.position(charBuffer.position());
        charBufferWrap.limit(charBuffer.limit());
        return charBufferWrap;
    }

    private void q() throws IOException {
        if (b(this.f21961d) == 0) {
            if (this.f21961d.position() > 0) {
                this.f21961d.compact().flip();
            } else {
                this.f21961d = e(this.f21961d);
            }
        }
        int iLimit = this.f21961d.limit();
        int i7 = this.f21958a.read(this.f21961d.array(), iLimit, b(this.f21961d));
        if (i7 == -1) {
            this.f21963f = true;
        } else {
            this.f21961d.limit(iLimit + i7);
        }
    }

    private void r(boolean z7) {
        this.f21962e.flip();
        if (z7 && this.f21962e.remaining() == 0) {
            this.f21962e = ByteBuffer.allocate(this.f21962e.capacity() * 2);
        } else {
            this.f21964g = true;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21958a.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f21960c) == 1) {
            return com.google.common.primitives.i0.p(this.f21960c[0]);
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        CoderResult coderResultFlush;
        com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
        if (i8 == 0) {
            return 0;
        }
        boolean z7 = this.f21963f;
        int iC = 0;
        while (true) {
            if (this.f21964g) {
                iC += c(bArr, i7 + iC, i8 - iC);
                if (iC == i8 || this.f21965h) {
                    break;
                }
                this.f21964g = false;
                this.f21962e.clear();
            }
            while (true) {
                if (this.f21965h) {
                    coderResultFlush = CoderResult.UNDERFLOW;
                } else {
                    coderResultFlush = z7 ? this.f21959b.flush(this.f21962e) : this.f21959b.encode(this.f21961d, this.f21962e, this.f21963f);
                }
                if (coderResultFlush.isOverflow()) {
                    r(true);
                    break;
                }
                if (coderResultFlush.isUnderflow()) {
                    if (z7) {
                        this.f21965h = true;
                        r(false);
                        break;
                    }
                    if (this.f21963f) {
                        z7 = true;
                    } else {
                        q();
                    }
                } else if (coderResultFlush.isError()) {
                    coderResultFlush.throwException();
                    return 0;
                }
            }
        }
        if (iC > 0) {
            return iC;
        }
        return -1;
    }

    e2(Reader reader, CharsetEncoder charsetEncoder, int i7) {
        this.f21960c = new byte[1];
        this.f21958a = (Reader) com.google.common.base.e0.E(reader);
        this.f21959b = (CharsetEncoder) com.google.common.base.e0.E(charsetEncoder);
        com.google.common.base.e0.k(i7 > 0, "bufferSize must be positive: %s", i7);
        charsetEncoder.reset();
        CharBuffer charBufferAllocate = CharBuffer.allocate(i7);
        this.f21961d = charBufferAllocate;
        charBufferAllocate.flip();
        this.f21962e = ByteBuffer.allocate(i7);
    }
}
