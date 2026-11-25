package com.haier.globalwasher.modle.utils;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f24623a;

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j7 = jCurrentTimeMillis - f24623a;
        if (j7 > 0 && j7 < 1000) {
            return true;
        }
        f24623a = jCurrentTimeMillis;
        return false;
    }

    public static boolean b(long j7) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j8 = jCurrentTimeMillis - f24623a;
        if (j8 > 0 && j8 < j7) {
            return true;
        }
        f24623a = jCurrentTimeMillis;
        return false;
    }
}
