package com.haier.globalwasher.modle.utils;

import android.util.Log;
import com.haier.globalwasher.MyApplication;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f24688a = MyApplication.f24257m;

    public static void a(String str, String str2) {
        if (f24688a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f24688a) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (f24688a) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f24688a) {
            Log.v(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f24688a) {
            Log.w(str, str2);
        }
    }
}
