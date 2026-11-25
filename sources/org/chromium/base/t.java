package org.chromium.base;

import android.util.Log;
import java.util.Locale;
import org.chromium.base.annotations.RemovableInRelease;

/* JADX INFO: loaded from: classes3.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38870a = 7;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38871b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38872c = 6;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38873d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38874e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38875f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f38876g = "cr_";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f38877h = "cr.";

    private t() {
    }

    private static void A(String str, String str2, Object... objArr) {
        String strL = l(str2, objArr);
        Throwable thO = o(objArr);
        if (thO != null) {
            Log.v(r(str), strL, thO);
        } else {
            Log.v(r(str), strL);
        }
    }

    @s0
    public static void B(String str, String str2, Object... objArr) {
        String strK = k(str2, objArr);
        Throwable thO = o(objArr);
        if (thO != null) {
            Log.w(r(str), strK, thO);
        } else {
            Log.w(r(str), strK);
        }
    }

    @s0
    public static void C(String str, String str2, Object... objArr) {
        String strK = k(str2, objArr);
        Throwable thO = o(objArr);
        if (thO != null) {
            Log.wtf(r(str), strK, thO);
        } else {
            Log.wtf(r(str), strK);
        }
    }

    @RemovableInRelease
    @s0
    public static void a(String str, String str2) {
        i(str, str2, new Object[0]);
    }

    @RemovableInRelease
    @s0
    public static void b(String str, String str2, Object obj) {
        i(str, str2, obj);
    }

    @RemovableInRelease
    @s0
    public static void c(String str, String str2, Object obj, Object obj2) {
        i(str, str2, obj, obj2);
    }

    @RemovableInRelease
    @s0
    public static void d(String str, String str2, Object obj, Object obj2, Object obj3) {
        i(str, str2, obj, obj2, obj3);
    }

    @RemovableInRelease
    @s0
    public static void e(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        i(str, str2, obj, obj2, obj3, obj4);
    }

    @RemovableInRelease
    @s0
    public static void f(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        i(str, str2, obj, obj2, obj3, obj4, obj5);
    }

    @RemovableInRelease
    @s0
    public static void g(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        i(str, str2, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @RemovableInRelease
    @s0
    public static void h(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        i(str, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    private static void i(String str, String str2, Object... objArr) {
        String strL = l(str2, objArr);
        Throwable thO = o(objArr);
        if (thO != null) {
            Log.d(r(str), strL, thO);
        } else {
            Log.d(r(str), strL);
        }
    }

    @s0
    public static void j(String str, String str2, Object... objArr) {
        String strK = k(str2, objArr);
        Throwable thO = o(objArr);
        if (thO != null) {
            Log.e(r(str), strK, thO);
        } else {
            Log.e(r(str), strK);
        }
    }

    private static String k(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    private static String l(String str, Object... objArr) {
        return "[" + m() + "] " + k(str, objArr);
    }

    private static String m() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = t.class.getName();
        int i7 = 0;
        while (i7 < stackTrace.length) {
            if (stackTrace[i7].getClassName().equals(name)) {
                i7 += 4;
                break;
            }
            i7++;
        }
        return stackTrace[i7].getFileName() + ":" + stackTrace[i7].getLineNumber();
    }

    public static String n(Throwable th) {
        return Log.getStackTraceString(th);
    }

    private static Throwable o(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    @s0
    public static void p(String str, String str2, Object... objArr) {
        String strK = k(str2, objArr);
        Throwable thO = o(objArr);
        if (thO != null) {
            Log.i(r(str), strK, thO);
        } else {
            Log.i(r(str), strK);
        }
    }

    public static boolean q(String str, int i7) {
        return Log.isLoggable(str, i7);
    }

    public static String r(String str) {
        if (str.startsWith(f38876g)) {
            return str;
        }
        return f38876g + str.substring(str.startsWith(f38877h) ? 3 : 0, str.length());
    }

    @RemovableInRelease
    @s0
    public static void s(String str, String str2) {
        A(str, str2, new Object[0]);
    }

    @RemovableInRelease
    @s0
    public static void t(String str, String str2, Object obj) {
        A(str, str2, obj);
    }

    @RemovableInRelease
    @s0
    public static void u(String str, String str2, Object obj, Object obj2) {
        A(str, str2, obj, obj2);
    }

    @RemovableInRelease
    @s0
    public static void v(String str, String str2, Object obj, Object obj2, Object obj3) {
        A(str, str2, obj, obj2, obj3);
    }

    @RemovableInRelease
    @s0
    public static void w(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        A(str, str2, obj, obj2, obj3, obj4);
    }

    @RemovableInRelease
    @s0
    public static void x(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        A(str, str2, obj, obj2, obj3, obj4, obj5);
    }

    @RemovableInRelease
    @s0
    public static void y(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        A(str, str2, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @RemovableInRelease
    @s0
    public static void z(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        A(str, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }
}
