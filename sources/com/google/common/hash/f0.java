package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
@u1.j
final class f0 extends c implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final s f21761b = new f0(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final s f21762c = new f0(v.f21875a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f21763d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21764a;

    private static final class a extends f {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f21765g = 16;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final long f21766h = -8663945395140668459L;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final long f21767i = 5545529020109919103L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f21768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f21769e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f21770f;

        a(int i7) {
            super(16);
            long j7 = i7;
            this.f21768d = j7;
            this.f21769e = j7;
            this.f21770f = 0;
        }

        private void v(long j7, long j8) {
            long jX = x(j7) ^ this.f21768d;
            this.f21768d = jX;
            long jRotateLeft = Long.rotateLeft(jX, 27);
            long j9 = this.f21769e;
            this.f21768d = ((jRotateLeft + j9) * 5) + 1390208809;
            long jY = y(j8) ^ j9;
            this.f21769e = jY;
            this.f21769e = ((Long.rotateLeft(jY, 31) + this.f21768d) * 5) + 944331445;
        }

        private static long w(long j7) {
            long j8 = (j7 ^ (j7 >>> 33)) * (-49064778989728563L);
            long j9 = (j8 ^ (j8 >>> 33)) * (-4265267296055464877L);
            return j9 ^ (j9 >>> 33);
        }

        private static long x(long j7) {
            return Long.rotateLeft(j7 * f21766h, 31) * f21767i;
        }

        private static long y(long j7) {
            return Long.rotateLeft(j7 * f21767i, 33) * f21766h;
        }

        @Override // com.google.common.hash.f
        public r p() {
            long j7 = this.f21768d;
            int i7 = this.f21770f;
            long j8 = j7 ^ ((long) i7);
            long j9 = this.f21769e ^ ((long) i7);
            long j10 = j8 + j9;
            this.f21768d = j10;
            this.f21769e = j9 + j10;
            this.f21768d = w(j10);
            long jW = w(this.f21769e);
            long j11 = this.f21768d + jW;
            this.f21768d = j11;
            this.f21769e = jW + j11;
            return r.h(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f21768d).putLong(this.f21769e).array());
        }

        @Override // com.google.common.hash.f
        protected void s(ByteBuffer byteBuffer) {
            v(byteBuffer.getLong(), byteBuffer.getLong());
            this.f21770f += 16;
        }

        @Override // com.google.common.hash.f
        protected void t(ByteBuffer byteBuffer) {
            long jP;
            long jP2;
            long jP3;
            long jP4;
            long jP5;
            long jP6;
            long jP7;
            long jP8;
            long jP9;
            long jP10;
            long jP11;
            long jP12;
            long jP13;
            long jP14;
            this.f21770f += byteBuffer.remaining();
            long j7 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    jP = 0;
                    jP7 = ((long) com.google.common.primitives.i0.p(byteBuffer.get(0))) ^ jP;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 2:
                    jP2 = 0;
                    jP = jP2 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) com.google.common.primitives.i0.p(byteBuffer.get(0))) ^ jP;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 3:
                    jP3 = 0;
                    jP2 = jP3 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) com.google.common.primitives.i0.p(byteBuffer.get(0))) ^ jP;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 4:
                    jP4 = 0;
                    jP3 = jP4 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(3))) << 24);
                    jP2 = jP3 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) com.google.common.primitives.i0.p(byteBuffer.get(0))) ^ jP;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 5:
                    jP5 = 0;
                    jP4 = jP5 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(4))) << 32);
                    jP3 = jP4 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(3))) << 24);
                    jP2 = jP3 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) com.google.common.primitives.i0.p(byteBuffer.get(0))) ^ jP;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 6:
                    jP6 = 0;
                    jP5 = jP6 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(5))) << 40);
                    jP4 = jP5 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(4))) << 32);
                    jP3 = jP4 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(3))) << 24);
                    jP2 = jP3 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) com.google.common.primitives.i0.p(byteBuffer.get(0))) ^ jP;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 7:
                    jP6 = (((long) com.google.common.primitives.i0.p(byteBuffer.get(6))) << 48) ^ 0;
                    jP5 = jP6 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(5))) << 40);
                    jP4 = jP5 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(4))) << 32);
                    jP3 = jP4 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(3))) << 24);
                    jP2 = jP3 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) com.google.common.primitives.i0.p(byteBuffer.get(0))) ^ jP;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 8:
                    jP8 = 0;
                    jP7 = byteBuffer.getLong() ^ 0;
                    j7 = jP8;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 9:
                    jP9 = 0;
                    jP8 = jP9 ^ ((long) com.google.common.primitives.i0.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j7 = jP8;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 10:
                    jP10 = 0;
                    jP9 = jP10 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) com.google.common.primitives.i0.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j7 = jP8;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 11:
                    jP11 = 0;
                    jP10 = jP11 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) com.google.common.primitives.i0.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j7 = jP8;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 12:
                    jP12 = 0;
                    jP11 = jP12 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(11))) << 24);
                    jP10 = jP11 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) com.google.common.primitives.i0.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j7 = jP8;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 13:
                    jP13 = 0;
                    jP12 = jP13 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(12))) << 32);
                    jP11 = jP12 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(11))) << 24);
                    jP10 = jP11 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) com.google.common.primitives.i0.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j7 = jP8;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 14:
                    jP14 = 0;
                    jP13 = jP14 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(13))) << 40);
                    jP12 = jP13 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(12))) << 32);
                    jP11 = jP12 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(11))) << 24);
                    jP10 = jP11 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) com.google.common.primitives.i0.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j7 = jP8;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                case 15:
                    jP14 = (((long) com.google.common.primitives.i0.p(byteBuffer.get(14))) << 48) ^ 0;
                    jP13 = jP14 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(13))) << 40);
                    jP12 = jP13 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(12))) << 32);
                    jP11 = jP12 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(11))) << 24);
                    jP10 = jP11 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) com.google.common.primitives.i0.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) com.google.common.primitives.i0.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j7 = jP8;
                    this.f21768d ^= x(jP7);
                    this.f21769e ^= y(j7);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    f0(int i7) {
        this.f21764a = i7;
    }

    @Override // com.google.common.hash.s
    public u b() {
        return new a(this.f21764a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f0) && this.f21764a == ((f0) obj).f21764a;
    }

    @Override // com.google.common.hash.s
    public int h() {
        return 128;
    }

    public int hashCode() {
        return f0.class.hashCode() ^ this.f21764a;
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.f21764a + ")";
    }
}
