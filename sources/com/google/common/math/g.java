package com.google.common.math;

import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
@u1.a
final class g {
    private g() {
    }

    static void a(boolean z7, double d8, RoundingMode roundingMode) {
        if (z7) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d8 + " and rounding mode " + roundingMode);
    }

    static void b(boolean z7, String str, int i7, int i8) {
        if (z7) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i7 + ", " + i8 + ")");
    }

    static void c(boolean z7, String str, long j7, long j8) {
        if (z7) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j7 + ", " + j8 + ")");
    }

    static double d(String str, double d8) {
        if (d8 >= 0.0d) {
            return d8;
        }
        throw new IllegalArgumentException(str + " (" + d8 + ") must be >= 0");
    }

    static int e(String str, int i7) {
        if (i7 >= 0) {
            return i7;
        }
        throw new IllegalArgumentException(str + " (" + i7 + ") must be >= 0");
    }

    static long f(String str, long j7) {
        if (j7 >= 0) {
            return j7;
        }
        throw new IllegalArgumentException(str + " (" + j7 + ") must be >= 0");
    }

    static BigInteger g(String str, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be >= 0");
    }

    static int h(String str, int i7) {
        if (i7 > 0) {
            return i7;
        }
        throw new IllegalArgumentException(str + " (" + i7 + ") must be > 0");
    }

    static long i(String str, long j7) {
        if (j7 > 0) {
            return j7;
        }
        throw new IllegalArgumentException(str + " (" + j7 + ") must be > 0");
    }

    static BigInteger j(String str, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
    }

    static void k(boolean z7) {
        if (!z7) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
