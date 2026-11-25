package com.google.common.math;

import com.google.common.base.e0;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f22053a = -2.147483648E9d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final double f22054b = 2.147483647E9d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final double f22055c = -9.223372036854776E18d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final double f22056d = 9.223372036854776E18d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @s1.d
    static final int f22058f = 170;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final double f22057e = Math.log(2.0d);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @s1.d
    static final double[] f22059g = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f22060a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f22060a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22060a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22060a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22060a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22060a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22060a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22060a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f22060a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private b() {
    }

    @u1.a
    @s1.c
    private static double a(double d8) {
        e0.d(c.d(d8));
        return d8;
    }

    public static double b(int i7) {
        g.e("n", i7);
        if (i7 > f22058f) {
            return Double.POSITIVE_INFINITY;
        }
        double d8 = 1.0d;
        for (int i8 = (i7 & (-16)) + 1; i8 <= i7; i8++) {
            d8 *= (double) i8;
        }
        return d8 * f22059g[i7 >> 4];
    }

    public static int c(double d8, double d9, double d10) {
        if (d(d8, d9, d10)) {
            return 0;
        }
        if (d8 < d9) {
            return -1;
        }
        if (d8 > d9) {
            return 1;
        }
        return com.google.common.primitives.a.d(Double.isNaN(d8), Double.isNaN(d9));
    }

    public static boolean d(double d8, double d9, double d10) {
        g.d("tolerance", d10);
        return Math.copySign(d8 - d9, 1.0d) <= d10 || d8 == d9 || (Double.isNaN(d8) && Double.isNaN(d9));
    }

    @s1.c
    public static boolean e(double d8) {
        return c.d(d8) && (d8 == 0.0d || 52 - Long.numberOfTrailingZeros(c.c(d8)) <= Math.getExponent(d8));
    }

    @s1.c
    public static boolean f(double d8) {
        if (d8 <= 0.0d || !c.d(d8)) {
            return false;
        }
        long jC = c.c(d8);
        return (jC & (jC - 1)) == 0;
    }

    public static double g(double d8) {
        return Math.log(d8) / f22057e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    @s1.c
    public static int h(double d8, RoundingMode roundingMode) {
        boolean zF;
        boolean z7 = false;
        e0.e(d8 > 0.0d && c.d(d8), "x must be positive and finite");
        int exponent = Math.getExponent(d8);
        if (!c.e(d8)) {
            return h(d8 * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (a.f22060a[roundingMode.ordinal()]) {
            case 1:
                g.k(f(d8));
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 2:
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 3:
                z7 = !f(d8);
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 4:
                z7 = exponent < 0;
                zF = f(d8);
                z7 &= !zF;
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 5:
                z7 = exponent >= 0;
                zF = f(d8);
                z7 &= !zF;
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 6:
            case 7:
            case 8:
                double dG = c.g(d8);
                if (dG * dG > 2.0d) {
                    z7 = true;
                }
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            default:
                throw new AssertionError();
        }
    }

    @s1.c
    @Deprecated
    public static double i(Iterable<? extends Number> iterable) {
        return j(iterable.iterator());
    }

    @s1.c
    @Deprecated
    public static double j(Iterator<? extends Number> it) {
        e0.e(it.hasNext(), "Cannot take mean of 0 values");
        double dA = a(it.next().doubleValue());
        long j7 = 1;
        while (it.hasNext()) {
            j7++;
            dA += (a(it.next().doubleValue()) - dA) / j7;
        }
        return dA;
    }

    @s1.c
    @Deprecated
    public static double k(double... dArr) {
        e0.e(dArr.length > 0, "Cannot take mean of 0 values");
        double dA = a(dArr[0]);
        long j7 = 1;
        for (int i7 = 1; i7 < dArr.length; i7++) {
            a(dArr[i7]);
            j7++;
            dA += (dArr[i7] - dA) / j7;
        }
        return dA;
    }

    @Deprecated
    public static double l(int... iArr) {
        e0.e(iArr.length > 0, "Cannot take mean of 0 values");
        long j7 = 0;
        for (int i7 : iArr) {
            j7 += (long) i7;
        }
        return j7 / ((double) iArr.length);
    }

    @Deprecated
    public static double m(long... jArr) {
        e0.e(jArr.length > 0, "Cannot take mean of 0 values");
        double d8 = jArr[0];
        long j7 = 1;
        for (int i7 = 1; i7 < jArr.length; i7++) {
            j7++;
            d8 += (jArr[i7] - d8) / j7;
        }
        return d8;
    }

    @s1.c
    static double n(double d8, RoundingMode roundingMode) {
        if (!c.d(d8)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.f22060a[roundingMode.ordinal()]) {
            case 1:
                g.k(e(d8));
                return d8;
            case 2:
                return (d8 >= 0.0d || e(d8)) ? d8 : ((long) d8) - 1;
            case 3:
                return (d8 <= 0.0d || e(d8)) ? d8 : ((long) d8) + 1;
            case 4:
                return d8;
            case 5:
                if (e(d8)) {
                    return d8;
                }
                return ((long) d8) + ((long) (d8 > 0.0d ? 1 : -1));
            case 6:
                return Math.rint(d8);
            case 7:
                double dRint = Math.rint(d8);
                return Math.abs(d8 - dRint) == 0.5d ? d8 + Math.copySign(0.5d, d8) : dRint;
            case 8:
                double dRint2 = Math.rint(d8);
                return Math.abs(d8 - dRint2) == 0.5d ? d8 : dRint2;
            default:
                throw new AssertionError();
        }
    }

    @s1.c
    public static BigInteger o(double d8, RoundingMode roundingMode) {
        double dN = n(d8, roundingMode);
        if ((f22055c - dN < 1.0d) && (dN < f22056d)) {
            return BigInteger.valueOf((long) dN);
        }
        BigInteger bigIntegerShiftLeft = BigInteger.valueOf(c.c(dN)).shiftLeft(Math.getExponent(dN) - 52);
        return dN < 0.0d ? bigIntegerShiftLeft.negate() : bigIntegerShiftLeft;
    }

    @s1.c
    public static int p(double d8, RoundingMode roundingMode) {
        double dN = n(d8, roundingMode);
        g.a((dN > -2.147483649E9d) & (dN < 2.147483648E9d), d8, roundingMode);
        return (int) dN;
    }

    @s1.c
    public static long q(double d8, RoundingMode roundingMode) {
        double dN = n(d8, roundingMode);
        g.a((f22055c - dN < 1.0d) & (dN < f22056d), d8, roundingMode);
        return (long) dN;
    }
}
