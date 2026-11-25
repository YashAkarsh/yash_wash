package com.haier.library.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    public static Bundle a(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            return packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String b(Context context, String str) {
        Bundle bundleA;
        if (context == null || TextUtils.isEmpty(str) || (bundleA = a(context)) == null) {
            return null;
        }
        return bundleA.getString(str);
    }

    public static int c(Context context, String str) {
        Bundle bundleA;
        if (context == null || TextUtils.isEmpty(str) || (bundleA = a(context)) == null) {
            return -1;
        }
        return bundleA.getInt(str);
    }

    public static List<String> d(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return Arrays.asList(packageManager.getPackageInfo(packageManager.getPackageInfo(context.getPackageName(), 0).packageName, 4096).requestedPermissions);
        } catch (Exception unused) {
            e3.a.h("Couldn't retrieve permissions for package", new Object[0]);
            return null;
        }
    }

    public static boolean e(Context context, String str) {
        Bundle bundleA;
        if (context == null || TextUtils.isEmpty(str) || (bundleA = a(context)) == null) {
            return false;
        }
        return bundleA.getBoolean(str);
    }
}
