package com.google.common.math;

import com.google.common.base.e0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @s1.d
    static final int f22048a = 256;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.d
    static final BigInteger f22049b = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final double f22050c = Math.log(10.0d);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final double f22051d = Math.log(2.0d);

    /* JADX INFO: renamed from: com.google.common.math.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0281a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f22052a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f22052a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22052a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22052a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22052a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22052a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22052a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22052a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f22052a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private a() {
    }

    public static BigInteger a(int i7, int i8) {
        g.e("n", i7);
        g.e("k", i8);
        int i9 = 1;
        e0.m(i8 <= i7, "k (%s) > n (%s)", i8, i7);
        if (i8 > (i7 >> 1)) {
            i8 = i7 - i8;
        }
        int[] iArr = f.f22092h;
        if (i8 < iArr.length && i7 <= iArr[i8]) {
            return BigInteger.valueOf(f.a(i7, i8));
        }
        BigInteger bigIntegerDivide = BigInteger.ONE;
        long j7 = i7;
        int iQ = f.q(j7, RoundingMode.CEILING);
        long j8 = 1;
        while (true) {
            int i10 = iQ;
            while (i9 < i8) {
                int i11 = i7 - i9;
                i9++;
                i10 += iQ;
                if (i10 >= 63) {
                    bigIntegerDivide = bigIntegerDivide.multiply(BigInteger.valueOf(j7)).divide(BigInteger.valueOf(j8));
                    j7 = i11;
                    j8 = i9;
                } else {
                    j7 *= (long) i11;
                    j8 *= (long) i9;
                }
            }
            return bigIntegerDivide.multiply(BigInteger.valueOf(j7)).divide(BigInteger.valueOf(j8));
        }
    }

    @s1.a
    public static BigInteger b(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(k(bigInteger, RoundingMode.CEILING));
    }

    @s1.c
    public static BigInteger c(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger d(int i7) {
        g.e("n", i7);
        long[] jArr = f.f22091g;
        if (i7 < jArr.length) {
            return BigInteger.valueOf(jArr[i7]);
        }
        ArrayList arrayList = new ArrayList(d.g(d.p(i7, RoundingMode.CEILING) * i7, 64, RoundingMode.CEILING));
        int length = jArr.length;
        long j7 = jArr[length - 1];
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j7);
        long j8 = j7 >> iNumberOfTrailingZeros;
        int iQ = f.q(j8, RoundingMode.FLOOR) + 1;
        long j9 = length;
        int iQ2 = f.q(j9, RoundingMode.FLOOR) + 1;
        int i8 = 1 << (iQ2 - 1);
        while (j9 <= i7) {
            if ((j9 & ((long) i8)) != 0) {
                i8 <<= 1;
                iQ2++;
            }
            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j9);
            long j10 = j9 >> iNumberOfTrailingZeros2;
            iNumberOfTrailingZeros += iNumberOfTrailingZeros2;
            if ((iQ2 - iNumberOfTrailingZeros2) + iQ >= 64) {
                arrayList.add(BigInteger.valueOf(j8));
                j8 = 1;
            }
            j8 *= j10;
            iQ = f.q(j8, RoundingMode.FLOOR) + 1;
            j9++;
        }
        if (j8 > 1) {
            arrayList.add(BigInteger.valueOf(j8));
        }
        return h(arrayList).shiftLeft(iNumberOfTrailingZeros);
    }

    @s1.c
    static boolean e(BigInteger bigInteger) {
        return bigInteger.bitLength() <= 63;
    }

    @s1.a
    public static BigInteger f(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(k(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean g(BigInteger bigInteger) {
        e0.E(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }

    static BigInteger h(List<BigInteger> list) {
        return i(list, 0, list.size());
    }

    static BigInteger i(List<BigInteger> list, int i7, int i8) {
        int i9 = i8 - i7;
        if (i9 == 0) {
            return BigInteger.ONE;
        }
        if (i9 == 1) {
            return list.get(i7);
        }
        if (i9 == 2) {
            return list.get(i7).multiply(list.get(i7 + 1));
        }
        if (i9 == 3) {
            return list.get(i7).multiply(list.get(i7 + 1)).multiply(list.get(i7 + 2));
        }
        int i10 = (i8 + i7) >>> 1;
        return i(list, i7, i10).multiply(i(list, i10, i8));
    }

    @s1.c
    public static int j(BigInteger bigInteger, RoundingMode roundingMode) {
        int iCompareTo;
        g.j("x", bigInteger);
        if (e(bigInteger)) {
            return f.o(bigInteger.longValue(), roundingMode);
        }
        int iK = (int) ((((double) k(bigInteger, RoundingMode.FLOOR)) * f22051d) / f22050c);
        BigInteger bigIntegerPow = BigInteger.TEN.pow(iK);
        int iCompareTo2 = bigIntegerPow.compareTo(bigInteger);
        if (iCompareTo2 > 0) {
            do {
                iK--;
                bigIntegerPow = bigIntegerPow.divide(BigInteger.TEN);
                iCompareTo = bigIntegerPow.compareTo(bigInteger);
            } while (iCompareTo > 0);
        } else {
            BigInteger bigIntegerMultiply = BigInteger.TEN.multiply(bigIntegerPow);
            int i7 = iCompareTo2;
            int iCompareTo3 = bigIntegerMultiply.compareTo(bigInteger);
            while (iCompareTo3 <= 0) {
                iK++;
                BigInteger bigIntegerMultiply2 = BigInteger.TEN.multiply(bigIntegerMultiply);
                int iCompareTo4 = bigIntegerMultiply2.compareTo(bigInteger);
                BigInteger bigInteger2 = bigIntegerMultiply;
                bigIntegerMultiply = bigIntegerMultiply2;
                bigIntegerPow = bigInteger2;
                i7 = iCompareTo3;
                iCompareTo3 = iCompareTo4;
            }
            iCompareTo = i7;
        }
        switch (C0281a.f22052a[roundingMode.ordinal()]) {
            case 1:
                g.k(iCompareTo == 0);
            case 2:
            case 3:
                return iK;
            case 4:
            case 5:
                return bigIntegerPow.equals(bigInteger) ? iK : iK + 1;
            case 6:
            case 7:
            case 8:
                return bigInteger.pow(2).compareTo(bigIntegerPow.pow(2).multiply(BigInteger.TEN)) <= 0 ? iK : iK + 1;
            default:
                throw new AssertionError();
        }
    }

    public static int k(BigInteger bigInteger, RoundingMode roundingMode) {
        g.j("x", (BigInteger) e0.E(bigInteger));
        int iBitLength = bigInteger.bitLength() - 1;
        switch (C0281a.f22052a[roundingMode.ordinal()]) {
            case 1:
                g.k(g(bigInteger));
            case 2:
            case 3:
                return iBitLength;
            case 4:
            case 5:
                return g(bigInteger) ? iBitLength : iBitLength + 1;
            case 6:
            case 7:
            case 8:
                if (iBitLength < 256) {
                    return bigInteger.compareTo(f22049b.shiftRight(256 - iBitLength)) <= 0 ? iBitLength : iBitLength + 1;
                }
                return bigInteger.pow(2).bitLength() + (-1) < (iBitLength * 2) + 1 ? iBitLength : iBitLength + 1;
            default:
                throw new AssertionError();
        }
    }

    @s1.c
    public static BigInteger l(BigInteger bigInteger, RoundingMode roundingMode) {
        g.g("x", bigInteger);
        if (e(bigInteger)) {
            return BigInteger.valueOf(f.A(bigInteger.longValue(), roundingMode));
        }
        BigInteger bigIntegerN = n(bigInteger);
        switch (C0281a.f22052a[roundingMode.ordinal()]) {
            case 1:
                g.k(bigIntegerN.pow(2).equals(bigInteger));
            case 2:
            case 3:
                return bigIntegerN;
            case 4:
            case 5:
                int iIntValue = bigIntegerN.intValue();
                return iIntValue * iIntValue == bigInteger.intValue() && bigIntegerN.pow(2).equals(bigInteger) ? bigIntegerN : bigIntegerN.add(BigInteger.ONE);
            case 6:
            case 7:
            case 8:
                return bigIntegerN.pow(2).add(bigIntegerN).compareTo(bigInteger) >= 0 ? bigIntegerN : bigIntegerN.add(BigInteger.ONE);
            default:
                throw new AssertionError();
        }
    }

    @s1.c
    private static BigInteger m(BigInteger bigInteger) {
        return b.o(Math.sqrt(c.a(bigInteger)), RoundingMode.HALF_EVEN);
    }

    @s1.c
    private static BigInteger n(BigInteger bigInteger) {
        BigInteger bigIntegerShiftLeft;
        int iK = k(bigInteger, RoundingMode.FLOOR);
        if (iK < 1023) {
            bigIntegerShiftLeft = m(bigInteger);
        } else {
            int i7 = (iK - 52) & (-2);
            bigIntegerShiftLeft = m(bigInteger.shiftRight(i7)).shiftLeft(i7 >> 1);
        }
        BigInteger bigIntegerShiftRight = bigIntegerShiftLeft.add(bigInteger.divide(bigIntegerShiftLeft)).shiftRight(1);
        if (bigIntegerShiftLeft.equals(bigIntegerShiftRight)) {
            return bigIntegerShiftLeft;
        }
        while (true) {
            BigInteger bigIntegerShiftRight2 = bigIntegerShiftRight.add(bigInteger.divide(bigIntegerShiftRight)).shiftRight(1);
            if (bigIntegerShiftRight2.compareTo(bigIntegerShiftRight) >= 0) {
                return bigIntegerShiftRight;
            }
            bigIntegerShiftRight = bigIntegerShiftRight2;
        }
    }
}
