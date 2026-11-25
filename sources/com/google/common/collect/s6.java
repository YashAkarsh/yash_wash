package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f21041a = -862048943;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f21042b = 461845907;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f21043c = 1073741824;

    private s6() {
    }

    static int a(int i7, double d8) {
        int iMax = Math.max(i7, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (d8 * ((double) iHighestOneBit)))) {
            return iHighestOneBit;
        }
        int i8 = iHighestOneBit << 1;
        if (i8 > 0) {
            return i8;
        }
        return 1073741824;
    }

    static boolean b(int i7, int i8, double d8) {
        return ((double) i7) > d8 * ((double) i8) && i8 < 1073741824;
    }

    static int c(int i7) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i7) * f21041a), 15)) * f21042b);
    }

    static int d(Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
