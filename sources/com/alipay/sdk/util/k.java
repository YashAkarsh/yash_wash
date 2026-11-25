package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13812a;

    private static String a(Context context) {
        String packageName;
        if (TextUtils.isEmpty(f13812a)) {
            try {
                packageName = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                d.d(th);
                packageName = "";
            }
            f13812a = (packageName + "0000000000000000000000000000").substring(0, 24);
        }
        return f13812a;
    }

    public static void b(Context context, String str, String str2) {
        try {
            String strA = com.alipay.sdk.encrypt.f.a(a(context), str2, str);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(strA)) {
                com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13640m, com.alipay.sdk.app.statistic.c.f13625J, String.format("%s,%s", str, str2));
            }
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, strA).commit();
        } catch (Throwable th) {
            d.d(th);
        }
    }

    public static boolean c(Context context, String str) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
        } catch (Throwable th) {
            d.d(th);
            return false;
        }
    }

    public static String d(Context context, String str, String str2) {
        String strC = null;
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
            strC = TextUtils.isEmpty(string) ? null : com.alipay.sdk.encrypt.f.c(a(context), string, str);
            if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(strC)) {
                com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13640m, com.alipay.sdk.app.statistic.c.I, String.format("%s,%s", str, string));
            }
        } catch (Exception e8) {
            d.d(e8);
        }
        return strC;
    }

    public static void e(Context context, String str) {
        try {
            PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).commit();
        } catch (Throwable th) {
            d.d(th);
        }
    }
}
