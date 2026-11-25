package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
abstract class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f21731a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    a() {
    }

    private u p(int i7) {
        try {
            t(this.f21731a.array(), 0, i7);
            return this;
        } finally {
            this.f21731a.clear();
        }
    }

    protected abstract void q(byte b8);

    protected void r(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            t(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
        } else {
            for (int iRemaining = byteBuffer.remaining(); iRemaining > 0; iRemaining--) {
                q(byteBuffer.get());
            }
        }
    }

    protected void s(byte[] bArr) {
        t(bArr, 0, bArr.length);
    }

    protected void t(byte[] bArr, int i7, int i8) {
        for (int i9 = i7; i9 < i7 + i8; i9++) {
            q(bArr[i9]);
        }
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public u b(short s7) {
        this.f21731a.putShort(s7);
        return p(2);
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public u e(int i7) {
        this.f21731a.putInt(i7);
        return p(4);
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public u f(long j7) {
        this.f21731a.putLong(j7);
        return p(8);
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public u g(byte[] bArr) {
        com.google.common.base.e0.E(bArr);
        s(bArr);
        return this;
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public u h(byte b8) {
        q(b8);
        return this;
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public u j(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
        t(bArr, i7, i8);
        return this;
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public u k(char c8) {
        this.f21731a.putChar(c8);
        return p(2);
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public u l(ByteBuffer byteBuffer) {
        r(byteBuffer);
        return this;
    }
}
