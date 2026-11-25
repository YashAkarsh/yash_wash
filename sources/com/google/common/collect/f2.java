package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class f2 {
    f2() {
    }

    static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    @u1.a
    static int b(int i7, String str) {
        if (i7 >= 0) {
            return i7;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i7);
    }

    @u1.a
    static long c(long j7, String str) {
        if (j7 >= 0) {
            return j7;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j7);
    }

    static void d(int i7, String str) {
        if (i7 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i7);
    }

    static void e(boolean z7) {
        com.google.common.base.e0.h0(z7, "no calls to next() since the last call to remove()");
    }
}
