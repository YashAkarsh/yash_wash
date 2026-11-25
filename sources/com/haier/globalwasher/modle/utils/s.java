package com.haier.globalwasher.modle.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.haier.globalwasher.MyApplication;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public static String a(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public static int b() {
        try {
            return MyApplication.k().getPackageManager().getPackageInfo(MyApplication.k().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            return 0;
        }
    }

    public static String c() {
        try {
            PackageInfo packageInfo = MyApplication.k().getPackageManager().getPackageInfo(MyApplication.k().getPackageName(), 0);
            q.c("getVersionName", "" + packageInfo.versionName);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            return null;
        }
    }
}
