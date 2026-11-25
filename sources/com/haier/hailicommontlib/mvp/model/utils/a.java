package com.haier.hailicommontlib.mvp.model.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.haier.hailicommontlib.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Integer a(String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = BaseApplication.b().getApplicationContext().getPackageManager().getApplicationInfo(BaseApplication.b().getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                return Integer.valueOf(bundle.getInt(str));
            }
            b.c("ApplicationInfo", "需要在AndroidManifest.xml中配置" + str + " meta数据");
            return 0;
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            return 0;
        }
    }

    public static String b(String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = BaseApplication.b().getApplicationContext().getPackageManager().getApplicationInfo(BaseApplication.b().getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                return bundle.getString(str);
            }
            b.c("ApplicationInfo", "需要在AndroidManifest.xml中配置" + str + " meta数据");
            return "";
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            return "";
        } catch (ClassCastException e9) {
            e9.printStackTrace();
            return "";
        }
    }
}
