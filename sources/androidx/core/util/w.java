package androidx.core.util;

import android.text.TextUtils;
import c.m0;
import c.o0;
import c.x0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public final class w {
    private w() {
    }

    public static void a(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z7, @m0 Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void c(boolean z7, @m0 String str, @m0 Object... objArr) {
        if (!z7) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static float d(float f8, @m0 String str) {
        if (Float.isNaN(f8)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        }
        if (!Float.isInfinite(f8)) {
            return f8;
        }
        throw new IllegalArgumentException(str + " must not be infinite");
    }

    public static double e(double d8, double d9, double d10, @m0 String str) {
        if (d8 < d9) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d9), Double.valueOf(d10)));
        }
        if (d8 <= d10) {
            return d8;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d9), Double.valueOf(d10)));
    }

    public static float f(float f8, float f9, float f10, @m0 String str) {
        if (f8 < f9) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f9), Float.valueOf(f10)));
        }
        if (f8 <= f10) {
            return f8;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f9), Float.valueOf(f10)));
    }

    public static int g(int i7, int i8, int i9, @m0 String str) {
        if (i7 < i8) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i8), Integer.valueOf(i9)));
        }
        if (i7 <= i9) {
            return i7;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i8), Integer.valueOf(i9)));
    }

    public static long h(long j7, long j8, long j9, @m0 String str) {
        if (j7 < j8) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j8), Long.valueOf(j9)));
        }
        if (j7 <= j9) {
            return j7;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j8), Long.valueOf(j9)));
    }

    @c.e0(from = 0)
    public static int i(int i7) {
        if (i7 >= 0) {
            return i7;
        }
        throw new IllegalArgumentException();
    }

    @c.e0(from = 0)
    public static int j(int i7, @o0 String str) {
        if (i7 >= 0) {
            return i7;
        }
        throw new IllegalArgumentException(str);
    }

    public static int k(int i7, int i8) {
        if ((i7 & i8) == i7) {
            return i7;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i7) + ", but only 0x" + Integer.toHexString(i8) + " are allowed");
    }

    @m0
    public static <T> T l(@o0 T t7) {
        t7.getClass();
        return t7;
    }

    @m0
    public static <T> T m(@o0 T t7, @m0 Object obj) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void n(boolean z7) {
        o(z7, null);
    }

    public static void o(boolean z7, @o0 String str) {
        if (!z7) {
            throw new IllegalStateException(str);
        }
    }

    @m0
    public static <T extends CharSequence> T p(@o0 T t7) {
        if (TextUtils.isEmpty(t7)) {
            throw new IllegalArgumentException();
        }
        return t7;
    }

    @m0
    public static <T extends CharSequence> T q(@o0 T t7, @m0 Object obj) {
        if (TextUtils.isEmpty(t7)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t7;
    }

    @m0
    public static <T extends CharSequence> T r(@o0 T t7, @m0 String str, @m0 Object... objArr) {
        if (TextUtils.isEmpty(t7)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t7;
    }
}
