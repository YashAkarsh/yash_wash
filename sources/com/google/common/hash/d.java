package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
abstract class d implements u {
    d() {
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public /* bridge */ /* synthetic */ h0 h(byte b8) {
        return h(b8);
    }

    @Override // com.google.common.hash.u
    public <T> u n(T t7, p<? super T> pVar) {
        pVar.Q(t7, this);
        return this;
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public final u a(double d8) {
        return f(Double.doubleToRawLongBits(d8));
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public u b(short s7) {
        h((byte) s7);
        h((byte) (s7 >>> 8));
        return this;
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public final u c(boolean z7) {
        return h(z7 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public final u d(float f8) {
        return e(Float.floatToRawIntBits(f8));
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public u e(int i7) {
        h((byte) i7);
        h((byte) (i7 >>> 8));
        h((byte) (i7 >>> 16));
        h((byte) (i7 >>> 24));
        return this;
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public u f(long j7) {
        for (int i7 = 0; i7 < 64; i7 += 8) {
            h((byte) (j7 >>> i7));
        }
        return this;
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public u g(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public u i(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            k(charSequence.charAt(i7));
        }
        return this;
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public u j(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
        for (int i9 = 0; i9 < i8; i9++) {
            h(bArr[i7 + i9]);
        }
        return this;
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public u k(char c8) {
        h((byte) c8);
        h((byte) (c8 >>> '\b'));
        return this;
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public u l(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
        } else {
            for (int iRemaining = byteBuffer.remaining(); iRemaining > 0; iRemaining--) {
                h(byteBuffer.get());
            }
        }
        return this;
    }

    @Override // com.google.common.hash.u, com.google.common.hash.h0
    public u m(CharSequence charSequence, Charset charset) {
        return g(charSequence.toString().getBytes(charset));
    }
}
