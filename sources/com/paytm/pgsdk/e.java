package com.paytm.pgsdk;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f33024a = false;

    public static void a(String str, String str2) {
        if (f33024a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f33024a) {
            Log.d(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        if (f33024a) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f33024a) {
            Log.e(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        Log.i(str, str2);
    }

    public static void f(boolean z7) {
        f33024a = z7;
    }

    public static void g(String str, String str2) {
        if (f33024a) {
            Log.v(str, str2);
        }
    }

    public static void h(String str, String str2) {
        if (f33024a) {
            Log.w(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (f33024a) {
            Log.w(str, str2, th);
        }
    }
}
