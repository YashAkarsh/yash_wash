package com.google.common.hash;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@u1.j
abstract class e extends c {

    private final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f21745a;

        a(int i7) {
            this.f21745a = new b(i7);
        }

        @Override // com.google.common.hash.u
        public r o() {
            return e.this.j(this.f21745a.b(), 0, this.f21745a.e());
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u h(byte b8) throws IOException {
            this.f21745a.write(b8);
            return this;
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u j(byte[] bArr, int i7, int i8) throws IOException {
            this.f21745a.write(bArr, i7, i8);
            return this;
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u l(ByteBuffer byteBuffer) {
            this.f21745a.f(byteBuffer);
            return this;
        }
    }

    private static final class b extends ByteArrayOutputStream {
        b(int i7) {
            super(i7);
        }

        byte[] b() {
            return ((ByteArrayOutputStream) this).buf;
        }

        int e() {
            return ((ByteArrayOutputStream) this).count;
        }

        void f(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            int i7 = ((ByteArrayOutputStream) this).count;
            int i8 = i7 + iRemaining;
            byte[] bArr = ((ByteArrayOutputStream) this).buf;
            if (i8 > bArr.length) {
                ((ByteArrayOutputStream) this).buf = Arrays.copyOf(bArr, i7 + iRemaining);
            }
            byteBuffer.get(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count, iRemaining);
            ((ByteArrayOutputStream) this).count += iRemaining;
        }
    }

    e() {
    }

    @Override // com.google.common.hash.s
    public u b() {
        return k(32);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r c(int i7) {
        return a(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i7).array());
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r e(CharSequence charSequence, Charset charset) {
        return a(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r f(ByteBuffer byteBuffer) {
        return k(byteBuffer.remaining()).l(byteBuffer).o();
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r g(CharSequence charSequence) {
        int length = charSequence.length();
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (int i7 = 0; i7 < length; i7++) {
            byteBufferOrder.putChar(charSequence.charAt(i7));
        }
        return a(byteBufferOrder.array());
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r i(long j7) {
        return a(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j7).array());
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public abstract r j(byte[] bArr, int i7, int i8);

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public u k(int i7) {
        com.google.common.base.e0.d(i7 >= 0);
        return new a(i7);
    }
}
