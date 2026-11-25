package com.alibaba.android.arouter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f12525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f12526b;

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            com.alibaba.android.arouter.launcher.a.f12464e.error("ARouter::", "Get package info error.");
            return null;
        }
    }

    public static boolean b(Context context) {
        PackageInfo packageInfoA = a(context);
        if (packageInfoA != null) {
            String str = packageInfoA.versionName;
            int i7 = packageInfoA.versionCode;
            SharedPreferences sharedPreferences = context.getSharedPreferences(b.f12517j, 0);
            if (str.equals(sharedPreferences.getString(b.f12519l, null)) && i7 == sharedPreferences.getInt(b.f12520m, -1)) {
                return false;
            }
            f12525a = str;
            f12526b = i7;
        }
        return true;
    }

    public static void c(Context context) {
        if (TextUtils.isEmpty(f12525a) || f12526b == 0) {
            return;
        }
        context.getSharedPreferences(b.f12517j, 0).edit().putString(b.f12519l, f12525a).putInt(b.f12520m, f12526b).apply();
    }
}
