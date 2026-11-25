package com.google.common.math;

import com.google.common.base.e0;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f22061a = 4503599627370495L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final long f22062b = 9218868437227405312L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f22063c = Long.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f22064d = 52;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f22065e = 1023;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final long f22066f = 4503599627370496L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @s1.d
    static final long f22067g = 4607182418800017408L;

    private c() {
    }

    static double a(BigInteger bigInteger) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        boolean z7 = true;
        int iBitLength = bigIntegerAbs.bitLength() - 1;
        if (iBitLength < 63) {
            return bigInteger.longValue();
        }
        if (iBitLength > f22065e) {
            return ((double) bigInteger.signum()) * Double.POSITIVE_INFINITY;
        }
        int i7 = (iBitLength - 52) - 1;
        long jLongValue = bigIntegerAbs.shiftRight(i7).longValue();
        long j7 = (jLongValue >> 1) & f22061a;
        if ((jLongValue & 1) == 0 || ((j7 & 1) == 0 && bigIntegerAbs.getLowestSetBit() >= i7)) {
            z7 = false;
        }
        if (z7) {
            j7++;
        }
        return Double.longBitsToDouble(((((long) (iBitLength + f22065e)) << 52) + j7) | (((long) bigInteger.signum()) & Long.MIN_VALUE));
    }

    static double b(double d8) {
        e0.d(!Double.isNaN(d8));
        if (d8 > 0.0d) {
            return d8;
        }
        return 0.0d;
    }

    static long c(double d8) {
        e0.e(d(d8), "not a normal value");
        int exponent = Math.getExponent(d8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d8) & f22061a;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | f22066f;
    }

    static boolean d(double d8) {
        return Math.getExponent(d8) <= f22065e;
    }

    static boolean e(double d8) {
        return Math.getExponent(d8) >= -1022;
    }

    static double f(double d8) {
        return -Math.nextUp(-d8);
    }

    static double g(double d8) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d8) & f22061a) | f22067g);
    }
}
