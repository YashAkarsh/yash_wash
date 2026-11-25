package com.nostra13.universalimageloader.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f32919a = "%1$s\n%2$s";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f32920b = false;

    private d() {
    }

    public static void a(String str, Object... objArr) {
        h(3, null, str, objArr);
    }

    public static void b() {
        f32920b = true;
    }

    public static void c(String str, Object... objArr) {
        h(6, null, str, objArr);
    }

    public static void d(Throwable th) {
        h(6, th, null, new Object[0]);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        h(6, th, str, objArr);
    }

    public static void f() {
        f32920b = false;
    }

    public static void g(String str, Object... objArr) {
        h(4, null, str, objArr);
    }

    private static void h(int i7, Throwable th, String str, Object... objArr) {
        if (f32920b) {
            return;
        }
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (th != null) {
            if (str == null) {
                str = th.getMessage();
            }
            str = String.format(f32919a, str, Log.getStackTraceString(th));
        }
        Log.println(i7, com.nostra13.universalimageloader.core.d.f32730d, str);
    }

    public static void i(String str, Object... objArr) {
        h(5, null, str, objArr);
    }
}
