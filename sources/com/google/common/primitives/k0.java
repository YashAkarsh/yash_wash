package com.google.common.primitives;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f22398a = 4294967295L;

    enum a implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                int i8 = iArr[i7];
                int i9 = iArr2[i7];
                if (i8 != i9) {
                    return k0.b(i8, i9);
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    private k0() {
    }

    public static int a(long j7) {
        com.google.common.base.e0.p((j7 >> 32) == 0, "out of range: %s", j7);
        return (int) j7;
    }

    public static int b(int i7, int i8) {
        return c0.e(e(i7), e(i8));
    }

    @u1.a
    public static int c(String str) {
        e0 e0VarA = e0.a(str);
        try {
            return k(e0VarA.f22349a, e0VarA.f22350b);
        } catch (NumberFormatException e8) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e8);
            throw numberFormatException;
        }
    }

    public static int d(int i7, int i8) {
        return (int) (r(i7) / r(i8));
    }

    static int e(int i7) {
        return i7 ^ Integer.MIN_VALUE;
    }

    public static String f(String str, int... iArr) {
        com.google.common.base.e0.E(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(s(iArr[0]));
        for (int i7 = 1; i7 < iArr.length; i7++) {
            sb.append(str);
            sb.append(s(iArr[i7]));
        }
        return sb.toString();
    }

    public static Comparator<int[]> g() {
        return a.INSTANCE;
    }

    public static int h(int... iArr) {
        com.google.common.base.e0.d(iArr.length > 0);
        int iE = e(iArr[0]);
        for (int i7 = 1; i7 < iArr.length; i7++) {
            int iE2 = e(iArr[i7]);
            if (iE2 > iE) {
                iE = iE2;
            }
        }
        return e(iE);
    }

    public static int i(int... iArr) {
        com.google.common.base.e0.d(iArr.length > 0);
        int iE = e(iArr[0]);
        for (int i7 = 1; i7 < iArr.length; i7++) {
            int iE2 = e(iArr[i7]);
            if (iE2 < iE) {
                iE = iE2;
            }
        }
        return e(iE);
    }

    @u1.a
    public static int j(String str) {
        return k(str, 10);
    }

    @u1.a
    public static int k(String str, int i7) {
        com.google.common.base.e0.E(str);
        long j7 = Long.parseLong(str, i7);
        if ((f22398a & j7) == j7) {
            return (int) j7;
        }
        throw new NumberFormatException("Input " + str + " in base " + i7 + " is not in the range of an unsigned integer");
    }

    public static int l(int i7, int i8) {
        return (int) (r(i7) % r(i8));
    }

    public static int m(long j7) {
        if (j7 <= 0) {
            return 0;
        }
        if (j7 >= 4294967296L) {
            return -1;
        }
        return (int) j7;
    }

    public static void n(int[] iArr) {
        com.google.common.base.e0.E(iArr);
        o(iArr, 0, iArr.length);
    }

    public static void o(int[] iArr, int i7, int i8) {
        com.google.common.base.e0.E(iArr);
        com.google.common.base.e0.f0(i7, i8, iArr.length);
        for (int i9 = i7; i9 < i8; i9++) {
            iArr[i9] = e(iArr[i9]);
        }
        Arrays.sort(iArr, i7, i8);
        while (i7 < i8) {
            iArr[i7] = e(iArr[i7]);
            i7++;
        }
    }

    public static void p(int[] iArr) {
        com.google.common.base.e0.E(iArr);
        q(iArr, 0, iArr.length);
    }

    public static void q(int[] iArr, int i7, int i8) {
        com.google.common.base.e0.E(iArr);
        com.google.common.base.e0.f0(i7, i8, iArr.length);
        for (int i9 = i7; i9 < i8; i9++) {
            iArr[i9] = Integer.MAX_VALUE ^ iArr[i9];
        }
        Arrays.sort(iArr, i7, i8);
        while (i7 < i8) {
            iArr[i7] = iArr[i7] ^ Integer.MAX_VALUE;
            i7++;
        }
    }

    public static long r(int i7) {
        return ((long) i7) & f22398a;
    }

    public static String s(int i7) {
        return t(i7, 10);
    }

    public static String t(int i7, int i8) {
        return Long.toString(((long) i7) & f22398a, i8);
    }
}
