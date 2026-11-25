package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@u1.j
final class i0 extends c implements Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final s f21786e = new i0(2, 4, 506097522914230528L, 1084818905618843912L);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f21787f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f21790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f21791d;

    private static final class a extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f21792l = 8;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f21793d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f21794e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f21795f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f21796g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f21797h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f21798i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f21799j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f21800k;

        a(int i7, int i8, long j7, long j8) {
            super(8);
            this.f21799j = 0L;
            this.f21800k = 0L;
            this.f21793d = i7;
            this.f21794e = i8;
            this.f21795f = 8317987319222330741L ^ j7;
            this.f21796g = 7237128888997146477L ^ j8;
            this.f21797h = 7816392313619706465L ^ j7;
            this.f21798i = 8387220255154660723L ^ j8;
        }

        private void v(long j7) {
            this.f21798i ^= j7;
            w(this.f21793d);
            this.f21795f = j7 ^ this.f21795f;
        }

        private void w(int i7) {
            for (int i8 = 0; i8 < i7; i8++) {
                long j7 = this.f21795f;
                long j8 = this.f21796g;
                this.f21795f = j7 + j8;
                this.f21797h += this.f21798i;
                this.f21796g = Long.rotateLeft(j8, 13);
                long jRotateLeft = Long.rotateLeft(this.f21798i, 16);
                long j9 = this.f21796g;
                long j10 = this.f21795f;
                this.f21796g = j9 ^ j10;
                this.f21798i = jRotateLeft ^ this.f21797h;
                long jRotateLeft2 = Long.rotateLeft(j10, 32);
                long j11 = this.f21797h;
                long j12 = this.f21796g;
                this.f21797h = j11 + j12;
                this.f21795f = jRotateLeft2 + this.f21798i;
                this.f21796g = Long.rotateLeft(j12, 17);
                long jRotateLeft3 = Long.rotateLeft(this.f21798i, 21);
                long j13 = this.f21796g;
                long j14 = this.f21797h;
                this.f21796g = j13 ^ j14;
                this.f21798i = jRotateLeft3 ^ this.f21795f;
                this.f21797h = Long.rotateLeft(j14, 32);
            }
        }

        @Override // com.google.common.hash.f
        public r p() {
            long j7 = this.f21800k ^ (this.f21799j << 56);
            this.f21800k = j7;
            v(j7);
            this.f21797h ^= 255;
            w(this.f21794e);
            return r.j(((this.f21795f ^ this.f21796g) ^ this.f21797h) ^ this.f21798i);
        }

        @Override // com.google.common.hash.f
        protected void s(ByteBuffer byteBuffer) {
            this.f21799j += 8;
            v(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.f
        protected void t(ByteBuffer byteBuffer) {
            this.f21799j += (long) byteBuffer.remaining();
            int i7 = 0;
            while (byteBuffer.hasRemaining()) {
                this.f21800k ^= (((long) byteBuffer.get()) & 255) << i7;
                i7 += 8;
            }
        }
    }

    i0(int i7, int i8, long j7, long j8) {
        com.google.common.base.e0.k(i7 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i7);
        com.google.common.base.e0.k(i8 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i8);
        this.f21788a = i7;
        this.f21789b = i8;
        this.f21790c = j7;
        this.f21791d = j8;
    }

    @Override // com.google.common.hash.s
    public u b() {
        return new a(this.f21788a, this.f21789b, this.f21790c, this.f21791d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.f21788a == i0Var.f21788a && this.f21789b == i0Var.f21789b && this.f21790c == i0Var.f21790c && this.f21791d == i0Var.f21791d;
    }

    @Override // com.google.common.hash.s
    public int h() {
        return 64;
    }

    public int hashCode() {
        return (int) ((((long) ((i0.class.hashCode() ^ this.f21788a) ^ this.f21789b)) ^ this.f21790c) ^ this.f21791d);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f21788a + "" + this.f21789b + "(" + this.f21790c + ", " + this.f21791d + ")";
    }
}
