package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@u1.j
abstract class c implements s {
    c() {
    }

    @Override // com.google.common.hash.s
    public r a(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.s
    public r c(int i7) {
        return k(4).e(i7).o();
    }

    @Override // com.google.common.hash.s
    public <T> r d(T t7, p<? super T> pVar) {
        return b().n(t7, pVar).o();
    }

    @Override // com.google.common.hash.s
    public r e(CharSequence charSequence, Charset charset) {
        return b().m(charSequence, charset).o();
    }

    @Override // com.google.common.hash.s
    public r f(ByteBuffer byteBuffer) {
        return k(byteBuffer.remaining()).l(byteBuffer).o();
    }

    @Override // com.google.common.hash.s
    public r g(CharSequence charSequence) {
        return k(charSequence.length() * 2).i(charSequence).o();
    }

    @Override // com.google.common.hash.s
    public r i(long j7) {
        return k(8).f(j7).o();
    }

    @Override // com.google.common.hash.s
    public r j(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
        return k(i8).j(bArr, i7, i8).o();
    }

    @Override // com.google.common.hash.s
    public u k(int i7) {
        com.google.common.base.e0.k(i7 >= 0, "expectedInputSize must be >= 0 but was %s", i7);
        return b();
    }
}
