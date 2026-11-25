package com.google.common.hash;

/* JADX INFO: loaded from: classes2.dex */
final class o extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final s f21851a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f21852b = -4348849565147123417L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f21853c = -5435081209227447693L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f21854d = -7286425919675154353L;

    o() {
    }

    @s1.d
    static long l(byte[] bArr, int i7, int i8) {
        if (i8 <= 32) {
            return i8 <= 16 ? m(bArr, i7, i8) : o(bArr, i7, i8);
        }
        return i8 <= 64 ? p(bArr, i7, i8) : q(bArr, i7, i8);
    }

    private static long m(byte[] bArr, int i7, int i8) {
        if (i8 >= 8) {
            long j7 = ((long) (i8 * 2)) + f21854d;
            long jB = z.b(bArr, i7) + f21854d;
            long jB2 = z.b(bArr, (i7 + i8) - 8);
            return n((Long.rotateRight(jB2, 37) * j7) + jB, (Long.rotateRight(jB, 25) + jB2) * j7, j7);
        }
        if (i8 >= 4) {
            return n(((long) i8) + ((((long) z.a(bArr, i7)) & 4294967295L) << 3), ((long) z.a(bArr, (i7 + i8) - 4)) & 4294967295L, ((long) (i8 * 2)) + f21854d);
        }
        if (i8 <= 0) {
            return f21854d;
        }
        return r((((long) ((bArr[i7] & 255) + ((bArr[(i8 >> 1) + i7] & 255) << 8))) * f21854d) ^ (((long) (i8 + ((bArr[i7 + (i8 - 1)] & 255) << 2))) * f21852b)) * f21854d;
    }

    private static long n(long j7, long j8, long j9) {
        long j10 = (j7 ^ j8) * j9;
        long j11 = ((j10 ^ (j10 >>> 47)) ^ j8) * j9;
        return (j11 ^ (j11 >>> 47)) * j9;
    }

    private static long o(byte[] bArr, int i7, int i8) {
        long j7 = ((long) (i8 * 2)) + f21854d;
        long jB = z.b(bArr, i7) * f21853c;
        long jB2 = z.b(bArr, i7 + 8);
        int i9 = i7 + i8;
        long jB3 = z.b(bArr, i9 - 8) * j7;
        return n((z.b(bArr, i9 - 16) * f21854d) + Long.rotateRight(jB + jB2, 43) + Long.rotateRight(jB3, 30), jB + Long.rotateRight(jB2 + f21854d, 18) + jB3, j7);
    }

    private static long p(byte[] bArr, int i7, int i8) {
        long j7 = ((long) (i8 * 2)) + f21854d;
        long jB = z.b(bArr, i7) * f21854d;
        long jB2 = z.b(bArr, i7 + 8);
        int i9 = i7 + i8;
        long jB3 = z.b(bArr, i9 - 8) * j7;
        long jRotateRight = Long.rotateRight(jB + jB2, 43) + Long.rotateRight(jB3, 30) + (z.b(bArr, i9 - 16) * f21854d);
        long jN = n(jRotateRight, jB3 + Long.rotateRight(jB2 + f21854d, 18) + jB, j7);
        long jB4 = z.b(bArr, i7 + 16) * j7;
        long jB5 = z.b(bArr, i7 + 24);
        long jB6 = (jRotateRight + z.b(bArr, i9 - 32)) * j7;
        return n(((jN + z.b(bArr, i9 - 24)) * j7) + Long.rotateRight(jB4 + jB5, 43) + Long.rotateRight(jB6, 30), jB4 + Long.rotateRight(jB5 + jB, 18) + jB6, j7);
    }

    private static long q(byte[] bArr, int i7, int i8) {
        long jR = r(-7956866745689871395L) * f21854d;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long jB = 95310865018149119L + z.b(bArr, i7);
        int i9 = i8 - 1;
        int i10 = i7 + ((i9 / 64) * 64);
        int i11 = i9 & 63;
        int i12 = (i10 + i11) - 63;
        long j7 = 2480279821605975764L;
        int i13 = i7;
        while (true) {
            long jRotateRight = Long.rotateRight(jB + j7 + jArr[0] + z.b(bArr, i13 + 8), 37) * f21853c;
            long jRotateRight2 = Long.rotateRight(j7 + jArr[1] + z.b(bArr, i13 + 48), 42) * f21853c;
            long j8 = jRotateRight ^ jArr2[1];
            long jB2 = jRotateRight2 + jArr[0] + z.b(bArr, i13 + 40);
            long jRotateRight3 = Long.rotateRight(jR + jArr2[0], 33) * f21853c;
            t(bArr, i13, jArr[1] * f21853c, j8 + jArr2[0], jArr);
            t(bArr, i13 + 32, jRotateRight3 + jArr2[1], jB2 + z.b(bArr, i13 + 16), jArr2);
            i13 += 64;
            if (i13 == i10) {
                long j9 = ((j8 & 255) << 1) + f21853c;
                long j10 = jArr2[0] + ((long) i11);
                jArr2[0] = j10;
                long j11 = jArr[0] + j10;
                jArr[0] = j11;
                jArr2[0] = jArr2[0] + j11;
                long jRotateRight4 = Long.rotateRight(jRotateRight3 + jB2 + jArr[0] + z.b(bArr, i12 + 8), 37) * j9;
                long jRotateRight5 = Long.rotateRight(jB2 + jArr[1] + z.b(bArr, i12 + 48), 42) * j9;
                long j12 = jRotateRight4 ^ (jArr2[1] * 9);
                long jB3 = jRotateRight5 + (jArr[0] * 9) + z.b(bArr, i12 + 40);
                long jRotateRight6 = Long.rotateRight(j8 + jArr2[0], 33) * j9;
                t(bArr, i12, jArr[1] * j9, j12 + jArr2[0], jArr);
                t(bArr, i12 + 32, jRotateRight6 + jArr2[1], z.b(bArr, i12 + 16) + jB3, jArr2);
                return n(n(jArr[0], jArr2[0], j9) + (r(jB3) * f21852b) + j12, n(jArr[1], jArr2[1], j9) + jRotateRight6, j9);
            }
            jR = j8;
            j7 = jB2;
            jB = jRotateRight3;
        }
    }

    private static long r(long j7) {
        return j7 ^ (j7 >>> 47);
    }

    private static void t(byte[] bArr, int i7, long j7, long j8, long[] jArr) {
        long jB = z.b(bArr, i7);
        long jB2 = z.b(bArr, i7 + 8);
        long jB3 = z.b(bArr, i7 + 16);
        long jB4 = z.b(bArr, i7 + 24);
        long j9 = j7 + jB;
        long j10 = jB2 + j9 + jB3;
        long jRotateRight = Long.rotateRight(j8 + j9 + jB4, 21) + Long.rotateRight(j10, 44);
        jArr[0] = j10 + jB4;
        jArr[1] = jRotateRight + j9;
    }

    @Override // com.google.common.hash.s
    public int h() {
        return 64;
    }

    @Override // com.google.common.hash.e, com.google.common.hash.c, com.google.common.hash.s
    public r j(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
        return r.j(l(bArr, i7, i8));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
