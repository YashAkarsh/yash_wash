package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
abstract class f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f21758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21760c;

    protected f(int i7) {
        this(i7, i7);
    }

    private void q() {
        this.f21758a.flip();
        while (this.f21758a.remaining() >= this.f21760c) {
            s(this.f21758a);
        }
        this.f21758a.compact();
    }

    private void r() {
        if (this.f21758a.remaining() < 8) {
            q();
        }
    }

    private u u(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f21758a.remaining()) {
            this.f21758a.put(byteBuffer);
            r();
            return this;
        }
        int iPosition = this.f21759b - this.f21758a.position();
        for (int i7 = 0; i7 < iPosition; i7++) {
            this.f21758a.put(byteBuffer.get());
        }
        q();
        while (byteBuffer.remaining() >= this.f21760c) {
            s(byteBuffer);
        }
        this.f21758a.put(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.u
    public final r o() {
        q();
        this.f21758a.flip();
        if (this.f21758a.remaining() > 0) {
            t(this.f21758a);
            ByteBuffer byteBuffer = this.f21758a;
            byteBuffer.position(byteBuffer.limit());
        }
        return p();
    }

    protected abstract r p();

    protected abstract void s(ByteBuffer byteBuffer);

    protected void t(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(this.f21760c + 7);
        while (true) {
            int iPosition = byteBuffer.position();
            int i7 = this.f21760c;
            if (iPosition >= i7) {
                byteBuffer.limit(i7);
                byteBuffer.flip();
                s(byteBuffer);
                return;
            }
            byteBuffer.putLong(0L);
        }
    }

    protected f(int i7, int i8) {
        com.google.common.base.e0.d(i8 % i7 == 0);
        this.f21758a = ByteBuffer.allocate(i8 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f21759b = i8;
        this.f21760c = i7;
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public final u b(short s7) {
        this.f21758a.putShort(s7);
        r();
        return this;
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public final u e(int i7) {
        this.f21758a.putInt(i7);
        r();
        return this;
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public final u f(long j7) {
        this.f21758a.putLong(j7);
        r();
        return this;
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public final u h(byte b8) {
        this.f21758a.put(b8);
        r();
        return this;
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public final u j(byte[] bArr, int i7, int i8) {
        return u(ByteBuffer.wrap(bArr, i7, i8).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public final u k(char c8) {
        this.f21758a.putChar(c8);
        r();
        return this;
    }

    @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
    public final u l(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return u(byteBuffer);
        } finally {
            byteBuffer.order(byteOrderOrder);
        }
    }
}
