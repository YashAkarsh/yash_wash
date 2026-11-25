package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class u {
    private u() {
        throw new AssertionError("Uninstantiable");
    }

    @c1.a
    public static void a(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    @c1.a
    public static void b(boolean z7, @c.m0 Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @c1.a
    public static void c(boolean z7, @c.m0 String str, @c.m0 Object... objArr) {
        if (!z7) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @c1.a
    public static void d(@c.m0 Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name2).length() + 36 + String.valueOf(name).length());
            sb.append("Must be called on ");
            sb.append(name2);
            sb.append(" thread, but got ");
            sb.append(name);
            sb.append(com.alibaba.android.arouter.utils.b.f12515h);
            throw new IllegalStateException(sb.toString());
        }
    }

    @c1.a
    public static void e(@c.m0 Handler handler, @c.m0 String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    @c1.a
    public static void f(@c.m0 String str) {
        if (!g1.g0.a()) {
            throw new IllegalStateException(str);
        }
    }

    @g6.b({"#1"})
    @c1.a
    @c.m0
    public static String g(@c.o0 String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    @g6.b({"#1"})
    @c1.a
    @c.m0
    public static String h(@c.o0 String str, @c.m0 Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    @c1.a
    public static void i() {
        j("Must not be called on the main application thread");
    }

    @c1.a
    public static void j(@c.m0 String str) {
        if (g1.g0.a()) {
            throw new IllegalStateException(str);
        }
    }

    @g6.b({"#1"})
    @c1.a
    @c.m0
    public static <T> T k(@c.o0 T t7) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException("null reference");
    }

    @g6.b({"#1"})
    @c1.a
    @c.m0
    public static <T> T l(@c.m0 T t7, @c.m0 Object obj) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @c1.a
    public static int m(int i7) {
        if (i7 != 0) {
            return i7;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    @c1.a
    public static int n(int i7, @c.m0 Object obj) {
        if (i7 != 0) {
            return i7;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @c1.a
    public static long o(long j7) {
        if (j7 != 0) {
            return j7;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    @c1.a
    public static long p(long j7, @c.m0 Object obj) {
        if (j7 != 0) {
            return j7;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @c1.a
    public static void q(boolean z7) {
        if (!z7) {
            throw new IllegalStateException();
        }
    }

    @c1.a
    public static void r(boolean z7, @c.m0 Object obj) {
        if (!z7) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @c1.a
    public static void s(boolean z7, @c.m0 String str, @c.m0 Object... objArr) {
        if (!z7) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }
}
