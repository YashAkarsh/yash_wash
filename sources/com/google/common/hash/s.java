package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.j
public interface s {
    r a(byte[] bArr);

    u b();

    r c(int i7);

    <T> r d(T t7, p<? super T> pVar);

    r e(CharSequence charSequence, Charset charset);

    r f(ByteBuffer byteBuffer);

    r g(CharSequence charSequence);

    int h();

    r i(long j7);

    r j(byte[] bArr, int i7, int i8);

    u k(int i7);
}
