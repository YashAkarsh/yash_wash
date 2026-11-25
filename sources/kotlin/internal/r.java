package kotlin.internal;

import kotlin.a1;
import kotlin.a2;
import kotlin.g1;
import kotlin.o2;
import kotlin.w1;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    private static final int a(int i7, int i8, int i9) {
        int iE = o2.e(i7, i9);
        int iE2 = o2.e(i8, i9);
        int iC = o2.c(iE, iE2);
        int iH = w1.h(iE - iE2);
        return iC >= 0 ? iH : w1.h(iH + i9);
    }

    private static final long b(long j7, long j8, long j9) {
        long jI = o2.i(j7, j9);
        long jI2 = o2.i(j8, j9);
        int iG = o2.g(jI, jI2);
        long jH = a2.h(jI - jI2);
        return iG >= 0 ? jH : a2.h(jH + j9);
    }

    @g1(version = "1.3")
    @a1
    public static final long c(long j7, long j8, long j9) {
        if (j9 > 0) {
            return o2.g(j7, j8) >= 0 ? j8 : a2.h(j8 - b(j8, j7, a2.h(j9)));
        }
        if (j9 < 0) {
            return o2.g(j7, j8) <= 0 ? j8 : a2.h(j8 + b(j7, j8, a2.h(-j9)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @g1(version = "1.3")
    @a1
    public static final int d(int i7, int i8, int i9) {
        if (i9 > 0) {
            return o2.c(i7, i8) >= 0 ? i8 : w1.h(i8 - a(i8, i7, w1.h(i9)));
        }
        if (i9 < 0) {
            return o2.c(i7, i8) <= 0 ? i8 : w1.h(i8 + a(i7, i8, w1.h(-i9)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
