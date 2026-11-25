package com.haier.hailicommontlib;

import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a() {
        try {
            return b().getPackageManager().getPackageInfo(b().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            return "-1";
        }
    }

    public static BaseApplication b() {
        return BaseApplication.b();
    }
}
