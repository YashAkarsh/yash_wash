package kotlin;

/* JADX INFO: loaded from: classes2.dex */
class o0 extends n0 {
    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int J(byte b8, byte b9) {
        int i7 = b8 / b9;
        return ((b8 ^ b9) >= 0 || b9 * i7 == b8) ? i7 : i7 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int K(byte b8, int i7) {
        int i8 = b8 / i7;
        return ((b8 ^ i7) >= 0 || i7 * i8 == b8) ? i8 : i8 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int L(byte b8, short s7) {
        int i7 = b8 / s7;
        return ((b8 ^ s7) >= 0 || s7 * i7 == b8) ? i7 : i7 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int M(int i7, byte b8) {
        int i8 = i7 / b8;
        return ((i7 ^ b8) >= 0 || b8 * i8 == i7) ? i8 : i8 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int N(int i7, int i8) {
        int i9 = i7 / i8;
        return ((i7 ^ i8) >= 0 || i8 * i9 == i7) ? i9 : i9 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int O(int i7, short s7) {
        int i8 = i7 / s7;
        return ((i7 ^ s7) >= 0 || s7 * i8 == i7) ? i8 : i8 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int P(short s7, byte b8) {
        int i7 = s7 / b8;
        return ((s7 ^ b8) >= 0 || b8 * i7 == s7) ? i7 : i7 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int Q(short s7, int i7) {
        int i8 = s7 / i7;
        return ((s7 ^ i7) >= 0 || i7 * i8 == s7) ? i8 : i8 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int R(short s7, short s8) {
        int i7 = s7 / s8;
        return ((s7 ^ s8) >= 0 || s8 * i7 == s7) ? i7 : i7 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long S(byte b8, long j7) {
        long j8 = b8;
        long j9 = j8 / j7;
        return ((j8 ^ j7) >= 0 || j7 * j9 == j8) ? j9 : j9 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long T(int i7, long j7) {
        long j8 = i7;
        long j9 = j8 / j7;
        return ((j8 ^ j7) >= 0 || j7 * j9 == j8) ? j9 : j9 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long U(long j7, byte b8) {
        long j8 = b8;
        long j9 = j7 / j8;
        return ((j7 ^ j8) >= 0 || j8 * j9 == j7) ? j9 : j9 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long V(long j7, int i7) {
        long j8 = i7;
        long j9 = j7 / j8;
        return ((j7 ^ j8) >= 0 || j8 * j9 == j7) ? j9 : j9 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long W(long j7, long j8) {
        long j9 = j7 / j8;
        return ((j7 ^ j8) >= 0 || j8 * j9 == j7) ? j9 : j9 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long X(long j7, short s7) {
        long j8 = s7;
        long j9 = j7 / j8;
        return ((j7 ^ j8) >= 0 || j8 * j9 == j7) ? j9 : j9 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long Y(short s7, long j7) {
        long j8 = s7;
        long j9 = j8 / j7;
        return ((j8 ^ j7) >= 0 || j7 * j9 == j8) ? j9 : j9 - 1;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final byte Z(byte b8, byte b9) {
        int i7 = b8 % b9;
        return (byte) (i7 + (b9 & (((i7 ^ b9) & ((-i7) | i7)) >> 31)));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final byte a0(int i7, byte b8) {
        int i8 = i7 % b8;
        return (byte) (i8 + (b8 & (((i8 ^ b8) & ((-i8) | i8)) >> 31)));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final byte b0(long j7, byte b8) {
        long j8 = b8;
        long j9 = j7 % j8;
        return (byte) (j9 + (j8 & (((j9 ^ j8) & ((-j9) | j9)) >> 63)));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final byte c0(short s7, byte b8) {
        int i7 = s7 % b8;
        return (byte) (i7 + (b8 & (((i7 ^ b8) & ((-i7) | i7)) >> 31)));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final double d0(double d8, double d9) {
        double d10 = d8 % d9;
        if (d10 == 0.0d) {
            return d10;
        }
        return !(Math.signum(d10) == Math.signum(d9)) ? d10 + d9 : d10;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final double e0(double d8, float f8) {
        double d9 = f8;
        double d10 = d8 % d9;
        if (d10 == 0.0d) {
            return d10;
        }
        return !(Math.signum(d10) == Math.signum(d9)) ? d10 + d9 : d10;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final double f0(float f8, double d8) {
        double d9 = ((double) f8) % d8;
        if (d9 == 0.0d) {
            return d9;
        }
        return !(Math.signum(d9) == Math.signum(d8)) ? d9 + d8 : d9;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final float g0(float f8, float f9) {
        float f10 = f8 % f9;
        if (f10 == 0.0f) {
            return f10;
        }
        return !(Math.signum(f10) == Math.signum(f9)) ? f10 + f9 : f10;
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int h0(byte b8, int i7) {
        int i8 = b8 % i7;
        return i8 + (i7 & (((i8 ^ i7) & ((-i8) | i8)) >> 31));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int i0(int i7, int i8) {
        int i9 = i7 % i8;
        return i9 + (i8 & (((i9 ^ i8) & ((-i9) | i9)) >> 31));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int j0(long j7, int i7) {
        long j8 = i7;
        long j9 = j7 % j8;
        return (int) (j9 + (j8 & (((j9 ^ j8) & ((-j9) | j9)) >> 63)));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final int k0(short s7, int i7) {
        int i8 = s7 % i7;
        return i8 + (i7 & (((i8 ^ i7) & ((-i8) | i8)) >> 31));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long l0(byte b8, long j7) {
        long j8 = ((long) b8) % j7;
        return j8 + (j7 & (((j8 ^ j7) & ((-j8) | j8)) >> 63));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long m0(int i7, long j7) {
        long j8 = ((long) i7) % j7;
        return j8 + (j7 & (((j8 ^ j7) & ((-j8) | j8)) >> 63));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long n0(long j7, long j8) {
        long j9 = j7 % j8;
        return j9 + (j8 & (((j9 ^ j8) & ((-j9) | j9)) >> 63));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final long o0(short s7, long j7) {
        long j8 = ((long) s7) % j7;
        return j8 + (j7 & (((j8 ^ j7) & ((-j8) | j8)) >> 63));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final short p0(byte b8, short s7) {
        int i7 = b8 % s7;
        return (short) (i7 + (s7 & (((i7 ^ s7) & ((-i7) | i7)) >> 31)));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final short q0(int i7, short s7) {
        int i8 = i7 % s7;
        return (short) (i8 + (s7 & (((i8 ^ s7) & ((-i8) | i8)) >> 31)));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final short r0(long j7, short s7) {
        long j8 = s7;
        long j9 = j7 % j8;
        return (short) (j9 + (j8 & (((j9 ^ j8) & ((-j9) | j9)) >> 63)));
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final short s0(short s7, short s8) {
        int i7 = s7 % s8;
        return (short) (i7 + (s8 & (((i7 ^ s8) & ((-i7) | i7)) >> 31)));
    }
}
