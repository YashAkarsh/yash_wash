package com.haier.uhome.account.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
    }

    public static String b() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.getDefault()).format(new Date());
    }

    public static String c(Context context, String str) {
        Bundle bundleA = a(context);
        if (bundleA == null) {
            return "";
        }
        Object obj = bundleA.get(str);
        return (String) (obj != null ? obj : "");
    }

    public static int a(Context context, String str) {
        if (context == null) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            return packageManager.getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "0.0.0";
        }
    }

    public static Bundle a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
