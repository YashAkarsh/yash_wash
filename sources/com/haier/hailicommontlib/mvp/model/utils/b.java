package com.haier.hailicommontlib.mvp.model.utils;

import android.util.Log;
import com.haier.hailicommontlib.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26159a = "HaierWasherTopSpeed";

    public static void a(String str, String str2) {
        com.haier.hailicommontlib.a.b();
        if (BaseApplication.f26154e) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        com.haier.hailicommontlib.a.b();
        if (BaseApplication.f26154e) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2) {
        com.haier.hailicommontlib.a.b();
        if (BaseApplication.f26154e) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        com.haier.hailicommontlib.a.b();
        if (BaseApplication.f26154e) {
            Log.v(str, str2);
        }
    }

    public static void e(String str, String str2) {
        com.haier.hailicommontlib.a.b();
        if (BaseApplication.f26154e) {
            Log.w(str, str2);
        }
    }
}
