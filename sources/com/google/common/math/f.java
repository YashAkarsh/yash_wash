package com.google.common.math;

import com.google.common.base.e0;
import com.google.common.primitives.m0;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @s1.d
    static final long f22085a = 4611686018427387904L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.d
    static final long f22086b = -5402926248376769404L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @s1.d
    static final long f22090f = 3037000499L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f22094j = -545925251;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @s1.d
    static final byte[] f22087c = {19, com.google.common.base.c.f19321u, com.google.common.base.c.f19321u, com.google.common.base.c.f19321u, com.google.common.base.c.f19321u, 17, 17, 17, com.google.common.base.c.f19318r, com.google.common.base.c.f19318r, com.google.common.base.c.f19318r, com.google.common.base.c.f19317q, com.google.common.base.c.f19317q, com.google.common.base.c.f19317q, com.google.common.base.c.f19317q, com.google.common.base.c.f19316p, com.google.common.base.c.f19316p, com.google.common.base.c.f19316p, com.google.common.base.c.f19315o, com.google.common.base.c.f19315o, com.google.common.base.c.f19315o, com.google.common.base.c.f19314n, com.google.common.base.c.f19314n, com.google.common.base.c.f19314n, com.google.common.base.c.f19314n, com.google.common.base.c.f19313m, com.google.common.base.c.f19313m, com.google.common.base.c.f19313m, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @s1.c
    @s1.d
    static final long[] f22088d = {1, 10, 100, 1000, RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT, 100000, 1000000, 10000000, 100000000, 1000000000, okhttp3.internal.connection.f.f37803v, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @s1.c
    @s1.d
    static final long[] f22089e = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final long[] f22091g = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f22092h = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, com.alibaba.fastjson.asm.j.Q, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @s1.d
    static final int[] f22093i = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, com.alibaba.fastjson.asm.j.Q, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long[][] f22095k = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f22096a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f22096a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22096a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22096a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22096a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22096a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22096a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22096a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f22096a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f22097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f22098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f22099c;

        static enum a extends b {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.math.f.b
            long a(long j7, long j8, long j9) {
                return (j7 * j8) % j9;
            }

            @Override // com.google.common.math.f.b
            long c(long j7, long j8) {
                return (j7 * j7) % j8;
            }
        }

        /* JADX INFO: renamed from: com.google.common.math.f$b$b, reason: collision with other inner class name */
        static enum C0283b extends b {
            C0283b(String str, int i7) {
                super(str, i7, null);
            }

            private long f(long j7, long j8, long j9) {
                long j10 = j7 + j8;
                return j7 >= j9 - j8 ? j10 - j9 : j10;
            }

            private long g(long j7, long j8) {
                int i7 = 32;
                do {
                    int iMin = Math.min(i7, Long.numberOfLeadingZeros(j7));
                    j7 = m0.k(j7 << iMin, j8);
                    i7 -= iMin;
                } while (i7 > 0);
                return j7;
            }

            @Override // com.google.common.math.f.b
            long a(long j7, long j8, long j9) {
                long j10 = j7 >>> 32;
                long j11 = j8 >>> 32;
                long j12 = j7 & 4294967295L;
                long j13 = j8 & 4294967295L;
                long jG = g(j10 * j11, j9) + (j10 * j13);
                if (jG < 0) {
                    jG = m0.k(jG, j9);
                }
                Long.signum(j12);
                return f(g(jG + (j11 * j12), j9), m0.k(j12 * j13, j9), j9);
            }

            @Override // com.google.common.math.f.b
            long c(long j7, long j8) {
                long j9 = j7 >>> 32;
                long j10 = j7 & 4294967295L;
                long jG = g(j9 * j9, j8);
                long jK = j9 * j10 * 2;
                if (jK < 0) {
                    jK = m0.k(jK, j8);
                }
                return f(g(jG + jK, j8), m0.k(j10 * j10, j8), j8);
            }
        }

        static {
            a aVar = new a("SMALL", 0);
            f22097a = aVar;
            C0283b c0283b = new C0283b("LARGE", 1);
            f22098b = c0283b;
            f22099c = new b[]{aVar, c0283b};
        }

        private b(String str, int i7) {
            super(str, i7);
        }

        private long b(long j7, long j8, long j9) {
            long jA = 1;
            while (j8 != 0) {
                if ((j8 & 1) != 0) {
                    jA = a(jA, j7, j9);
                }
                j7 = c(j7, j9);
                j8 >>= 1;
            }
            return jA;
        }

        static boolean d(long j7, long j8) {
            return (j8 <= f.f22090f ? f22097a : f22098b).e(j7, j8);
        }

        private boolean e(long j7, long j8) {
            long j9 = j8 - 1;
            int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j9);
            long j10 = j9 >> iNumberOfTrailingZeros;
            long j11 = j7 % j8;
            if (j11 == 0) {
                return true;
            }
            long jB = b(j11, j10, j8);
            if (jB == 1) {
                return true;
            }
            int i7 = 0;
            while (jB != j9) {
                i7++;
                if (i7 == iNumberOfTrailingZeros) {
                    return false;
                }
                jB = c(jB, j8);
            }
            return true;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f22099c.clone();
        }

        abstract long a(long j7, long j8, long j9);

        abstract long c(long j7, long j8);

        /* synthetic */ b(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    private f() {
    }

    @s1.c
    public static long A(long j7, RoundingMode roundingMode) {
        g.f("x", j7);
        if (i(j7)) {
            return d.x((int) j7, roundingMode);
        }
        long jSqrt = (long) Math.sqrt(j7);
        long j8 = jSqrt * jSqrt;
        switch (a.f22096a[roundingMode.ordinal()]) {
            case 1:
                g.k(j8 == j7);
                return jSqrt;
            case 2:
            case 3:
                return j7 < j8 ? jSqrt - 1 : jSqrt;
            case 4:
            case 5:
                return j7 > j8 ? jSqrt + 1 : jSqrt;
            case 6:
            case 7:
            case 8:
                long j9 = jSqrt - ((long) (j7 >= j8 ? 0 : 1));
                return j9 + ((long) n((j9 * j9) + j9, j7));
            default:
                throw new AssertionError();
        }
    }

    public static long a(int i7, int i8) {
        g.e("n", i7);
        g.e("k", i8);
        e0.m(i8 <= i7, "k (%s) > n (%s)", i8, i7);
        if (i8 > (i7 >> 1)) {
            i8 = i7 - i8;
        }
        long jU = 1;
        if (i8 == 0) {
            return 1L;
        }
        if (i8 == 1) {
            return i7;
        }
        long[] jArr = f22091g;
        if (i7 < jArr.length) {
            return jArr[i7] / (jArr[i8] * jArr[i7 - i8]);
        }
        int[] iArr = f22092h;
        if (i8 >= iArr.length || i7 > iArr[i8]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = f22093i;
        if (i8 < iArr2.length && i7 <= iArr2[i8]) {
            int i9 = i7 - 1;
            long j7 = i7;
            for (int i10 = 2; i10 <= i8; i10++) {
                j7 = (j7 * ((long) i9)) / ((long) i10);
                i9--;
            }
            return j7;
        }
        long j8 = i7;
        int iQ = q(j8, RoundingMode.CEILING);
        int i11 = i7 - 1;
        int i12 = iQ;
        int i13 = 2;
        long j9 = j8;
        long j10 = 1;
        while (i13 <= i8) {
            i12 += iQ;
            if (i12 < 63) {
                j9 *= (long) i11;
                j10 *= (long) i13;
            } else {
                jU = u(jU, j9, j10);
                j9 = i11;
                j10 = i13;
                i12 = iQ;
            }
            i13++;
            i11--;
        }
        return u(jU, j9, j10);
    }

    @s1.a
    public static long b(long j7) {
        g.i("x", j7);
        if (j7 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j7 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j7 + ") is not representable as a long");
    }

    @s1.c
    public static long c(long j7, long j8) {
        long j9 = j7 + j8;
        g.c(((j7 ^ j8) < 0) | ((j7 ^ j9) >= 0), "checkedAdd", j7, j8);
        return j9;
    }

    public static long d(long j7, long j8) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j7) + Long.numberOfLeadingZeros(~j7) + Long.numberOfLeadingZeros(j8) + Long.numberOfLeadingZeros(~j8);
        if (iNumberOfLeadingZeros > 65) {
            return j7 * j8;
        }
        g.c(iNumberOfLeadingZeros >= 64, "checkedMultiply", j7, j8);
        g.c((j7 >= 0) | (j8 != Long.MIN_VALUE), "checkedMultiply", j7, j8);
        long j9 = j7 * j8;
        g.c(j7 == 0 || j9 / j7 == j8, "checkedMultiply", j7, j8);
        return j9;
    }

    @s1.c
    public static long e(long j7, int i7) {
        g.e("exponent", i7);
        long jD = 1;
        if ((j7 >= -2) && (j7 <= 2)) {
            int i8 = (int) j7;
            if (i8 == -2) {
                g.c(i7 < 64, "checkedPow", j7, i7);
                return (i7 & 1) == 0 ? 1 << i7 : (-1) << i7;
            }
            if (i8 == -1) {
                return (i7 & 1) == 0 ? 1L : -1L;
            }
            if (i8 == 0) {
                return i7 == 0 ? 1L : 0L;
            }
            if (i8 == 1) {
                return 1L;
            }
            if (i8 != 2) {
                throw new AssertionError();
            }
            g.c(i7 < 63, "checkedPow", j7, i7);
            return 1 << i7;
        }
        long j8 = j7;
        int i9 = i7;
        while (i9 != 0) {
            if (i9 == 1) {
                return d(jD, j8);
            }
            if ((i9 & 1) != 0) {
                jD = d(jD, j8);
            }
            long j9 = jD;
            int i10 = i9 >> 1;
            if (i10 > 0) {
                g.c(-3037000499L <= j8 && j8 <= f22090f, "checkedPow", j8, i10);
                j8 *= j8;
            }
            i9 = i10;
            jD = j9;
        }
        return jD;
    }

    @s1.c
    public static long f(long j7, long j8) {
        long j9 = j7 - j8;
        g.c(((j7 ^ j8) >= 0) | ((j7 ^ j9) >= 0), "checkedSubtract", j7, j8);
        return j9;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    @s1.c
    public static long g(long j7, long j8, RoundingMode roundingMode) {
        e0.E(roundingMode);
        long j9 = j7 / j8;
        long j10 = j7 - (j8 * j9);
        if (j10 == 0) {
            return j9;
        }
        boolean z7 = true;
        int i7 = ((int) ((j7 ^ j8) >> 63)) | 1;
        switch (a.f22096a[roundingMode.ordinal()]) {
            case 1:
                g.k(j10 == 0);
                z7 = false;
                if (z7) {
                    return j9 + ((long) i7);
                }
                return j9;
            case 2:
                z7 = false;
                if (z7) {
                    return j9 + ((long) i7);
                }
                return j9;
            case 3:
                if (i7 >= 0) {
                    z7 = false;
                }
                if (z7) {
                    return j9 + ((long) i7);
                }
                return j9;
            case 4:
                if (z7) {
                    return j9 + ((long) i7);
                }
                return j9;
            case 5:
                if (i7 <= 0) {
                    z7 = false;
                }
                if (z7) {
                    return j9 + ((long) i7);
                }
                return j9;
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j10);
                long jAbs2 = jAbs - (Math.abs(j8) - jAbs);
                if (jAbs2 == 0) {
                    z7 = (((1 & j9) != 0) & (roundingMode == RoundingMode.HALF_EVEN)) | (roundingMode == RoundingMode.HALF_UP);
                } else if (jAbs2 <= 0) {
                    z7 = false;
                }
                if (z7) {
                    return j9 + ((long) i7);
                }
                return j9;
            default:
                throw new AssertionError();
        }
    }

    @s1.c
    public static long h(int i7) {
        g.e("n", i7);
        long[] jArr = f22091g;
        if (i7 < jArr.length) {
            return jArr[i7];
        }
        return Long.MAX_VALUE;
    }

    static boolean i(long j7) {
        return ((long) ((int) j7)) == j7;
    }

    @s1.a
    public static long j(long j7) {
        g.i("x", j7);
        return 1 << (63 - Long.numberOfLeadingZeros(j7));
    }

    public static long k(long j7, long j8) {
        g.f("a", j7);
        g.f("b", j8);
        if (j7 == 0) {
            return j8;
        }
        if (j8 == 0) {
            return j7;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j7);
        long jNumberOfTrailingZeros = j7 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j8);
        long j9 = j8 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j9) {
            long j10 = jNumberOfTrailingZeros - j9;
            long j11 = (j10 >> 63) & j10;
            long j12 = (j10 - j11) - j11;
            j9 += j11;
            jNumberOfTrailingZeros = j12 >> Long.numberOfTrailingZeros(j12);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static boolean l(long j7) {
        return (j7 > 0) & ((j7 & (j7 - 1)) == 0);
    }

    @s1.a
    @s1.c
    public static boolean m(long j7) {
        if (j7 < 2) {
            g.f("n", j7);
            return false;
        }
        if (j7 == 2 || j7 == 3 || j7 == 5 || j7 == 7 || j7 == 11 || j7 == 13) {
            return true;
        }
        if (((1 << ((int) (j7 % 30))) & f22094j) != 0 || j7 % 7 == 0 || j7 % 11 == 0 || j7 % 13 == 0) {
            return false;
        }
        if (j7 < 289) {
            return true;
        }
        for (long[] jArr : f22095k) {
            if (j7 <= jArr[0]) {
                for (int i7 = 1; i7 < jArr.length; i7++) {
                    if (!b.d(jArr[i7], j7)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }

    @s1.d
    static int n(long j7, long j8) {
        return (int) ((~(~(j7 - j8))) >>> 63);
    }

    @s1.c
    public static int o(long j7, RoundingMode roundingMode) {
        int iN;
        g.i("x", j7);
        int iP = p(j7);
        long j8 = f22088d[iP];
        switch (a.f22096a[roundingMode.ordinal()]) {
            case 1:
                g.k(j7 == j8);
            case 2:
            case 3:
                return iP;
            case 4:
            case 5:
                iN = n(j8, j7);
                return iP + iN;
            case 6:
            case 7:
            case 8:
                iN = n(f22089e[iP], j7);
                return iP + iN;
            default:
                throw new AssertionError();
        }
    }

    @s1.c
    static int p(long j7) {
        byte b8 = f22087c[Long.numberOfLeadingZeros(j7)];
        return b8 - n(j7, f22088d[b8]);
    }

    public static int q(long j7, RoundingMode roundingMode) {
        g.i("x", j7);
        switch (a.f22096a[roundingMode.ordinal()]) {
            case 1:
                g.k(l(j7));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j7 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j7);
                return (63 - iNumberOfLeadingZeros) + n(f22086b >>> iNumberOfLeadingZeros, j7);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j7);
    }

    public static long r(long j7, long j8) {
        return (j7 & j8) + ((j7 ^ j8) >> 1);
    }

    @s1.c
    public static int s(long j7, int i7) {
        return (int) t(j7, i7);
    }

    @s1.c
    public static long t(long j7, long j8) {
        if (j8 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long j9 = j7 % j8;
        return j9 >= 0 ? j9 : j9 + j8;
    }

    static long u(long j7, long j8, long j9) {
        if (j7 == 1) {
            return j8 / j9;
        }
        long jK = k(j7, j9);
        return (j7 / jK) * (j8 / (j9 / jK));
    }

    @s1.c
    public static long v(long j7, int i7) {
        g.e("exponent", i7);
        if (-2 > j7 || j7 > 2) {
            long j8 = 1;
            while (i7 != 0) {
                if (i7 == 1) {
                    return j8 * j7;
                }
                j8 *= (i7 & 1) == 0 ? 1L : j7;
                j7 *= j7;
                i7 >>= 1;
            }
            return j8;
        }
        int i8 = (int) j7;
        if (i8 == -2) {
            if (i7 < 64) {
                return (i7 & 1) == 0 ? 1 << i7 : -(1 << i7);
            }
            return 0L;
        }
        if (i8 == -1) {
            return (i7 & 1) == 0 ? 1L : -1L;
        }
        if (i8 == 0) {
            return i7 == 0 ? 1L : 0L;
        }
        if (i8 == 1) {
            return 1L;
        }
        if (i8 != 2) {
            throw new AssertionError();
        }
        if (i7 < 64) {
            return 1 << i7;
        }
        return 0L;
    }

    @s1.a
    public static long w(long j7, long j8) {
        long j9 = j7 + j8;
        return (((j8 ^ j7) > 0L ? 1 : ((j8 ^ j7) == 0L ? 0 : -1)) < 0) | ((j7 ^ j9) >= 0) ? j9 : ((j9 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @s1.a
    public static long x(long j7, long j8) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j7) + Long.numberOfLeadingZeros(~j7) + Long.numberOfLeadingZeros(j8) + Long.numberOfLeadingZeros(~j8);
        if (iNumberOfLeadingZeros > 65) {
            return j7 * j8;
        }
        long j9 = ((j7 ^ j8) >>> 63) + Long.MAX_VALUE;
        if ((iNumberOfLeadingZeros < 64) || ((j8 == Long.MIN_VALUE) & (j7 < 0))) {
            return j9;
        }
        long j10 = j7 * j8;
        return (j7 == 0 || j10 / j7 == j8) ? j10 : j9;
    }

    @s1.a
    public static long y(long j7, int i7) {
        g.e("exponent", i7);
        long jX = 1;
        if (!(j7 >= -2) || !(j7 <= 2)) {
            long j8 = ((j7 >>> 63) & ((long) (i7 & 1))) + Long.MAX_VALUE;
            while (i7 != 0) {
                if (i7 == 1) {
                    return x(jX, j7);
                }
                if ((i7 & 1) != 0) {
                    jX = x(jX, j7);
                }
                i7 >>= 1;
                if (i7 > 0) {
                    if ((-3037000499L > j7) || (j7 > f22090f)) {
                        return j8;
                    }
                    j7 *= j7;
                }
            }
            return jX;
        }
        int i8 = (int) j7;
        if (i8 == -2) {
            if (i7 >= 64) {
                return ((long) (i7 & 1)) + Long.MAX_VALUE;
            }
            return (i7 & 1) == 0 ? 1 << i7 : (-1) << i7;
        }
        if (i8 == -1) {
            return (i7 & 1) == 0 ? 1L : -1L;
        }
        if (i8 == 0) {
            return i7 == 0 ? 1L : 0L;
        }
        if (i8 == 1) {
            return 1L;
        }
        if (i8 != 2) {
            throw new AssertionError();
        }
        if (i7 >= 63) {
            return Long.MAX_VALUE;
        }
        return 1 << i7;
    }

    @s1.a
    public static long z(long j7, long j8) {
        long j9 = j7 - j8;
        return (((j8 ^ j7) > 0L ? 1 : ((j8 ^ j7) == 0L ? 0 : -1)) >= 0) | ((j7 ^ j9) >= 0) ? j9 : ((j9 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
