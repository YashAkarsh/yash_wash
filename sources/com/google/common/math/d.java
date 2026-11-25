package com.google.common.math;

import androidx.constraintlayout.core.motion.utils.w;
import com.google.common.base.e0;
import com.google.common.primitives.c0;
import easypay.appinvoke.manager.Constants;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @s1.d
    static final int f22068a = 1073741824;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.d
    static final int f22069b = -1257966797;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @s1.d
    static final int f22073f = 46340;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @s1.d
    static final byte[] f22070c = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @s1.d
    static final int[] f22071d = {1, 10, 100, 1000, com.haier.library.sumhttp.plugin.h.f27948e, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @s1.d
    static final int[] f22072e = {3, 31, w.a.f3016q, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f22074g = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @s1.d
    static int[] f22075h = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, com.alibaba.fastjson.asm.j.f12608d0, Constants.LOG_ERROR_OTP, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f22076a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f22076a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22076a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22076a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22076a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22076a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22076a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22076a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f22076a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private d() {
    }

    public static int a(int i7, int i8) {
        g.e("n", i7);
        g.e("k", i8);
        int i9 = 0;
        e0.m(i8 <= i7, "k (%s) > n (%s)", i8, i7);
        if (i8 > (i7 >> 1)) {
            i8 = i7 - i8;
        }
        int[] iArr = f22075h;
        if (i8 >= iArr.length || i7 > iArr[i8]) {
            return Integer.MAX_VALUE;
        }
        if (i8 == 0) {
            return 1;
        }
        if (i8 == 1) {
            return i7;
        }
        long j7 = 1;
        while (i9 < i8) {
            long j8 = j7 * ((long) (i7 - i9));
            i9++;
            j7 = j8 / ((long) i9);
        }
        return (int) j7;
    }

    @s1.a
    public static int b(int i7) {
        g.h("x", i7);
        if (i7 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i7 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + i7 + ") not representable as an int");
    }

    public static int c(int i7, int i8) {
        long j7 = ((long) i7) + ((long) i8);
        int i9 = (int) j7;
        g.b(j7 == ((long) i9), "checkedAdd", i7, i8);
        return i9;
    }

    public static int d(int i7, int i8) {
        long j7 = ((long) i7) * ((long) i8);
        int i9 = (int) j7;
        g.b(j7 == ((long) i9), "checkedMultiply", i7, i8);
        return i9;
    }

    public static int e(int i7, int i8) {
        g.e("exponent", i8);
        if (i7 == -2) {
            g.b(i8 < 32, "checkedPow", i7, i8);
            return (i8 & 1) == 0 ? 1 << i8 : (-1) << i8;
        }
        if (i7 == -1) {
            return (i8 & 1) == 0 ? 1 : -1;
        }
        if (i7 == 0) {
            return i8 == 0 ? 1 : 0;
        }
        if (i7 == 1) {
            return 1;
        }
        if (i7 == 2) {
            g.b(i8 < 31, "checkedPow", i7, i8);
            return 1 << i8;
        }
        int iD = 1;
        while (i8 != 0) {
            if (i8 == 1) {
                return d(iD, i7);
            }
            if ((i8 & 1) != 0) {
                iD = d(iD, i7);
            }
            i8 >>= 1;
            if (i8 > 0) {
                g.b((-46340 <= i7) & (i7 <= f22073f), "checkedPow", i7, i8);
                i7 *= i7;
            }
        }
        return iD;
    }

    public static int f(int i7, int i8) {
        long j7 = ((long) i7) - ((long) i8);
        int i9 = (int) j7;
        g.b(j7 == ((long) i9), "checkedSubtract", i7, i8);
        return i9;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x0057  */
    /* JADX WARN: Code duplicated, block: B:38:0x005a  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public static int g(int i7, int i8, RoundingMode roundingMode) {
        e0.E(roundingMode);
        if (i8 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i9 = i7 / i8;
        int i10 = i7 - (i8 * i9);
        if (i10 == 0) {
            return i9;
        }
        boolean z7 = true;
        int i11 = ((i7 ^ i8) >> 31) | 1;
        switch (a.f22076a[roundingMode.ordinal()]) {
            case 1:
                g.k(i10 == 0);
                z7 = false;
                if (z7) {
                    return i9 + i11;
                }
                return i9;
            case 2:
                z7 = false;
                if (z7) {
                    return i9 + i11;
                }
                return i9;
            case 3:
                if (i11 >= 0) {
                    z7 = false;
                }
                if (z7) {
                    return i9 + i11;
                }
                return i9;
            case 4:
                if (z7) {
                    return i9 + i11;
                }
                return i9;
            case 5:
                if (i11 <= 0) {
                    z7 = false;
                }
                if (z7) {
                    return i9 + i11;
                }
                return i9;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i10);
                int iAbs2 = iAbs - (Math.abs(i8) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i9 & 1) != 0))) {
                            z7 = false;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    z7 = false;
                }
                if (z7) {
                    return i9 + i11;
                }
                return i9;
            default:
                throw new AssertionError();
        }
    }

    public static int h(int i7) {
        g.e("n", i7);
        int[] iArr = f22074g;
        if (i7 < iArr.length) {
            return iArr[i7];
        }
        return Integer.MAX_VALUE;
    }

    @s1.a
    public static int i(int i7) {
        g.h("x", i7);
        return Integer.highestOneBit(i7);
    }

    public static int j(int i7, int i8) {
        g.e("a", i7);
        g.e("b", i8);
        if (i7 == 0) {
            return i8;
        }
        if (i8 == 0) {
            return i7;
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i7);
        int iNumberOfTrailingZeros2 = i7 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros3 = Integer.numberOfTrailingZeros(i8);
        int i9 = i8 >> iNumberOfTrailingZeros3;
        while (iNumberOfTrailingZeros2 != i9) {
            int i10 = iNumberOfTrailingZeros2 - i9;
            int i11 = (i10 >> 31) & i10;
            int i12 = (i10 - i11) - i11;
            i9 += i11;
            iNumberOfTrailingZeros2 = i12 >> Integer.numberOfTrailingZeros(i12);
        }
        return iNumberOfTrailingZeros2 << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros3);
    }

    public static boolean k(int i7) {
        return (i7 > 0) & ((i7 & (i7 + (-1))) == 0);
    }

    @s1.a
    @s1.c
    public static boolean l(int i7) {
        return f.m(i7);
    }

    @s1.d
    static int m(int i7, int i8) {
        return (~(~(i7 - i8))) >>> 31;
    }

    @s1.c
    public static int n(int i7, RoundingMode roundingMode) {
        int iM;
        g.h("x", i7);
        int iO = o(i7);
        int i8 = f22071d[iO];
        switch (a.f22076a[roundingMode.ordinal()]) {
            case 1:
                g.k(i7 == i8);
            case 2:
            case 3:
                return iO;
            case 4:
            case 5:
                iM = m(i8, i7);
                return iO + iM;
            case 6:
            case 7:
            case 8:
                iM = m(f22072e[iO], i7);
                return iO + iM;
            default:
                throw new AssertionError();
        }
    }

    private static int o(int i7) {
        byte b8 = f22070c[Integer.numberOfLeadingZeros(i7)];
        return b8 - m(i7, f22071d[b8]);
    }

    public static int p(int i7, RoundingMode roundingMode) {
        g.h("x", i7);
        switch (a.f22076a[roundingMode.ordinal()]) {
            case 1:
                g.k(k(i7));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i7 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i7);
                return (31 - iNumberOfLeadingZeros) + m(f22069b >>> iNumberOfLeadingZeros, i7);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i7);
    }

    public static int q(int i7, int i8) {
        return (i7 & i8) + ((i7 ^ i8) >> 1);
    }

    public static int r(int i7, int i8) {
        if (i8 > 0) {
            int i9 = i7 % i8;
            return i9 >= 0 ? i9 : i9 + i8;
        }
        throw new ArithmeticException("Modulus " + i8 + " must be > 0");
    }

    @s1.c
    public static int s(int i7, int i8) {
        g.e("exponent", i8);
        if (i7 == -2) {
            if (i8 < 32) {
                return (i8 & 1) == 0 ? 1 << i8 : -(1 << i8);
            }
            return 0;
        }
        if (i7 == -1) {
            return (i8 & 1) == 0 ? 1 : -1;
        }
        if (i7 == 0) {
            return i8 == 0 ? 1 : 0;
        }
        if (i7 == 1) {
            return 1;
        }
        if (i7 == 2) {
            if (i8 < 32) {
                return 1 << i8;
            }
            return 0;
        }
        int i9 = 1;
        while (i8 != 0) {
            if (i8 == 1) {
                return i7 * i9;
            }
            i9 *= (i8 & 1) == 0 ? 1 : i7;
            i7 *= i7;
            i8 >>= 1;
        }
        return i9;
    }

    @s1.a
    public static int t(int i7, int i8) {
        return c0.x(((long) i7) + ((long) i8));
    }

    @s1.a
    public static int u(int i7, int i8) {
        return c0.x(((long) i7) * ((long) i8));
    }

    @s1.a
    public static int v(int i7, int i8) {
        g.e("exponent", i8);
        if (i7 == -2) {
            if (i8 >= 32) {
                return (i8 & 1) + Integer.MAX_VALUE;
            }
            return (i8 & 1) == 0 ? 1 << i8 : (-1) << i8;
        }
        if (i7 == -1) {
            return (i8 & 1) == 0 ? 1 : -1;
        }
        if (i7 == 0) {
            return i8 == 0 ? 1 : 0;
        }
        if (i7 == 1) {
            return 1;
        }
        if (i7 == 2) {
            if (i8 >= 31) {
                return Integer.MAX_VALUE;
            }
            return 1 << i8;
        }
        int i9 = ((i7 >>> 31) & i8 & 1) + Integer.MAX_VALUE;
        int iU = 1;
        while (i8 != 0) {
            if (i8 == 1) {
                return u(iU, i7);
            }
            if ((i8 & 1) != 0) {
                iU = u(iU, i7);
            }
            i8 >>= 1;
            if (i8 > 0) {
                if ((-46340 > i7) || (i7 > f22073f)) {
                    return i9;
                }
                i7 *= i7;
            }
        }
        return iU;
    }

    @s1.a
    public static int w(int i7, int i8) {
        return c0.x(((long) i7) - ((long) i8));
    }

    @s1.c
    public static int x(int i7, RoundingMode roundingMode) {
        int iM;
        g.e("x", i7);
        int iY = y(i7);
        switch (a.f22076a[roundingMode.ordinal()]) {
            case 1:
                g.k(iY * iY == i7);
            case 2:
            case 3:
                return iY;
            case 4:
            case 5:
                iM = m(iY * iY, i7);
                return iY + iM;
            case 6:
            case 7:
            case 8:
                iM = m((iY * iY) + iY, i7);
                return iY + iM;
            default:
                throw new AssertionError();
        }
    }

    private static int y(int i7) {
        return (int) Math.sqrt(i7);
    }
}
