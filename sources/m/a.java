package m;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private a() {
    }

    public static int a(int i7, int i8) {
        int i9 = i7 + i8;
        if (((i7 ^ i9) & (i8 ^ i9)) >= 0) {
            return i9;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long b(long j7, long j8) {
        long j9 = j7 + j8;
        if (((j7 ^ j9) & (j8 ^ j9)) >= 0) {
            return j9;
        }
        throw new ArithmeticException("long overflow");
    }

    public static double c(double d8, double d9, double d10) {
        if (d8 < d9) {
            return d9;
        }
        return d8 > d10 ? d10 : d8;
    }

    public static float d(float f8, float f9, float f10) {
        if (f8 < f9) {
            return f9;
        }
        return f8 > f10 ? f10 : f8;
    }

    public static int e(int i7, int i8, int i9) {
        if (i7 < i8) {
            return i8;
        }
        return i7 > i9 ? i9 : i7;
    }

    public static long f(long j7, long j8, long j9) {
        if (j7 < j8) {
            return j8;
        }
        return j7 > j9 ? j9 : j7;
    }

    public static int g(int i7) {
        if (i7 != Integer.MIN_VALUE) {
            return i7 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long h(long j7) {
        if (j7 != Long.MIN_VALUE) {
            return j7 - 1;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int i(int i7) {
        if (i7 != Integer.MAX_VALUE) {
            return i7 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long j(long j7) {
        if (j7 != Long.MAX_VALUE) {
            return j7 + 1;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int k(int i7, int i8) {
        long j7 = ((long) i7) * ((long) i8);
        int i9 = (int) j7;
        if (i9 == j7) {
            return i9;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long l(long j7, long j8) {
        long j9 = j7 * j8;
        if (((Math.abs(j7) | Math.abs(j8)) >>> 31) == 0 || ((j8 == 0 || j9 / j8 == j7) && !(j7 == Long.MIN_VALUE && j8 == -1))) {
            return j9;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int m(int i7) {
        if (i7 != Integer.MIN_VALUE) {
            return -i7;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long n(long j7) {
        if (j7 != Long.MIN_VALUE) {
            return -j7;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int o(int i7, int i8) {
        int i9 = i7 - i8;
        if (((i7 ^ i9) & (i8 ^ i7)) >= 0) {
            return i9;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long p(long j7, long j8) {
        long j9 = j7 - j8;
        if (((j7 ^ j9) & (j8 ^ j7)) >= 0) {
            return j9;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int q(long j7) {
        int i7 = (int) j7;
        if (i7 == j7) {
            return i7;
        }
        throw new ArithmeticException("integer overflow");
    }
}
