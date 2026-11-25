package com.google.common.primitives;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f22407a = -1;

    enum a implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(long[] jArr, long[] jArr2) {
            int iMin = Math.min(jArr.length, jArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                long j7 = jArr[i7];
                long j8 = jArr2[i7];
                if (j7 != j8) {
                    return m0.a(j7, j8);
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final long[] f22410a = new long[37];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int[] f22411b = new int[37];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int[] f22412c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i7 = 2; i7 <= 36; i7++) {
                long j7 = i7;
                f22410a[i7] = m0.c(-1L, j7);
                f22411b[i7] = (int) m0.k(-1L, j7);
                f22412c[i7] = bigInteger.toString(i7).length() - 1;
            }
        }

        private b() {
        }

        static boolean a(long j7, int i7, int i8) {
            if (j7 < 0) {
                return true;
            }
            long j8 = f22410a[i8];
            if (j7 < j8) {
                return false;
            }
            return j7 > j8 || i7 > f22411b[i8];
        }
    }

    private m0() {
    }

    public static int a(long j7, long j8) {
        return d0.d(d(j7), d(j8));
    }

    @u1.a
    public static long b(String str) {
        e0 e0VarA = e0.a(str);
        try {
            return j(e0VarA.f22349a, e0VarA.f22350b);
        } catch (NumberFormatException e8) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e8);
            throw numberFormatException;
        }
    }

    public static long c(long j7, long j8) {
        if (j8 < 0) {
            return a(j7, j8) < 0 ? 0L : 1L;
        }
        if (j7 >= 0) {
            return j7 / j8;
        }
        long j9 = ((j7 >>> 1) / j8) << 1;
        return j9 + ((long) (a(j7 - (j9 * j8), j8) < 0 ? 0 : 1));
    }

    private static long d(long j7) {
        return j7 ^ Long.MIN_VALUE;
    }

    public static String e(String str, long... jArr) {
        com.google.common.base.e0.E(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(p(jArr[0]));
        for (int i7 = 1; i7 < jArr.length; i7++) {
            sb.append(str);
            sb.append(p(jArr[i7]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> f() {
        return a.INSTANCE;
    }

    public static long g(long... jArr) {
        com.google.common.base.e0.d(jArr.length > 0);
        long jD = d(jArr[0]);
        for (int i7 = 1; i7 < jArr.length; i7++) {
            long jD2 = d(jArr[i7]);
            if (jD2 > jD) {
                jD = jD2;
            }
        }
        return d(jD);
    }

    public static long h(long... jArr) {
        com.google.common.base.e0.d(jArr.length > 0);
        long jD = d(jArr[0]);
        for (int i7 = 1; i7 < jArr.length; i7++) {
            long jD2 = d(jArr[i7]);
            if (jD2 < jD) {
                jD = jD2;
            }
        }
        return d(jD);
    }

    @u1.a
    public static long i(String str) {
        return j(str, 10);
    }

    @u1.a
    public static long j(String str, int i7) {
        com.google.common.base.e0.E(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i7 < 2 || i7 > 36) {
            throw new NumberFormatException("illegal radix: " + i7);
        }
        int i8 = b.f22412c[i7] - 1;
        long j7 = 0;
        for (int i9 = 0; i9 < str.length(); i9++) {
            int iDigit = Character.digit(str.charAt(i9), i7);
            if (iDigit == -1) {
                throw new NumberFormatException(str);
            }
            if (i9 > i8 && b.a(j7, iDigit, i7)) {
                throw new NumberFormatException("Too large for unsigned long: " + str);
            }
            j7 = (j7 * ((long) i7)) + ((long) iDigit);
        }
        return j7;
    }

    public static long k(long j7, long j8) {
        if (j8 < 0) {
            return a(j7, j8) < 0 ? j7 : j7 - j8;
        }
        if (j7 >= 0) {
            return j7 % j8;
        }
        long j9 = j7 - ((((j7 >>> 1) / j8) << 1) * j8);
        if (a(j9, j8) < 0) {
            j8 = 0;
        }
        return j9 - j8;
    }

    public static void l(long[] jArr) {
        com.google.common.base.e0.E(jArr);
        m(jArr, 0, jArr.length);
    }

    public static void m(long[] jArr, int i7, int i8) {
        com.google.common.base.e0.E(jArr);
        com.google.common.base.e0.f0(i7, i8, jArr.length);
        for (int i9 = i7; i9 < i8; i9++) {
            jArr[i9] = d(jArr[i9]);
        }
        Arrays.sort(jArr, i7, i8);
        while (i7 < i8) {
            jArr[i7] = d(jArr[i7]);
            i7++;
        }
    }

    public static void n(long[] jArr) {
        com.google.common.base.e0.E(jArr);
        o(jArr, 0, jArr.length);
    }

    public static void o(long[] jArr, int i7, int i8) {
        com.google.common.base.e0.E(jArr);
        com.google.common.base.e0.f0(i7, i8, jArr.length);
        for (int i9 = i7; i9 < i8; i9++) {
            jArr[i9] = Long.MAX_VALUE ^ jArr[i9];
        }
        Arrays.sort(jArr, i7, i8);
        while (i7 < i8) {
            jArr[i7] = jArr[i7] ^ Long.MAX_VALUE;
            i7++;
        }
    }

    public static String p(long j7) {
        return q(j7, 10);
    }

    public static String q(long j7, int i7) {
        com.google.common.base.e0.k(i7 >= 2 && i7 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i7);
        if (j7 == 0) {
            return "0";
        }
        if (j7 > 0) {
            return Long.toString(j7, i7);
        }
        int i8 = 64;
        char[] cArr = new char[64];
        int i9 = i7 - 1;
        if ((i7 & i9) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i7);
            do {
                i8--;
                cArr[i8] = Character.forDigit(((int) j7) & i9, i7);
                j7 >>>= iNumberOfTrailingZeros;
            } while (j7 != 0);
        } else {
            long jC = (i7 & 1) == 0 ? (j7 >>> 1) / ((long) (i7 >>> 1)) : c(j7, i7);
            long j8 = i7;
            int i10 = 63;
            cArr[63] = Character.forDigit((int) (j7 - (jC * j8)), i7);
            while (jC > 0) {
                i10--;
                cArr[i10] = Character.forDigit((int) (jC % j8), i7);
                jC /= j8;
            }
            i8 = i10;
        }
        return new String(cArr, i8, 64 - i8);
    }
}
