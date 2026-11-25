package easypay.appinvoke.utils;

import android.util.Log;
import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void a(String str, String str2) {
        if (Constants.DEV_MODE) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (Constants.DEV_MODE) {
            Log.d(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        if (Constants.DEV_MODE) {
            Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (Constants.DEV_MODE) {
            Log.d(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        Log.i(str, str2);
    }

    public static void f(String str, String str2) {
        if (Constants.DEV_MODE) {
            Log.d(str, str2);
        }
    }

    public static void g(String str, String str2) {
        if (Constants.DEV_MODE) {
            Log.w(str, str2);
        }
    }

    public static void h(String str, String str2, Throwable th) {
        if (Constants.DEV_MODE) {
            Log.w(str, str2, th);
        }
    }
}
