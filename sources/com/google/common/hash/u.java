package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.a
public interface u extends h0 {
    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 a(double d8);

    @Override // com.google.common.hash.h0
    u a(double d8);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 b(short s7);

    @Override // com.google.common.hash.h0
    u b(short s7);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 c(boolean z7);

    @Override // com.google.common.hash.h0
    u c(boolean z7);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 d(float f8);

    @Override // com.google.common.hash.h0
    u d(float f8);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 e(int i7);

    @Override // com.google.common.hash.h0
    u e(int i7);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 f(long j7);

    @Override // com.google.common.hash.h0
    u f(long j7);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 g(byte[] bArr);

    @Override // com.google.common.hash.h0
    u g(byte[] bArr);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 h(byte b8);

    @Override // com.google.common.hash.h0
    u h(byte b8);

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 i(CharSequence charSequence);

    @Override // com.google.common.hash.h0
    u i(CharSequence charSequence);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 j(byte[] bArr, int i7, int i8);

    @Override // com.google.common.hash.h0
    u j(byte[] bArr, int i7, int i8);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 k(char c8);

    @Override // com.google.common.hash.h0
    u k(char c8);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 l(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.h0
    u l(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.h0
    /* bridge */ /* synthetic */ h0 m(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.h0
    u m(CharSequence charSequence, Charset charset);

    <T> u n(T t7, p<? super T> pVar);

    r o();
}
