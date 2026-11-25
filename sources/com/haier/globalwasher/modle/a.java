package com.haier.globalwasher.modle;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.haier.globalwasher.base.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f24330a = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f24331b = "GsonRequest";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f24332c = -1;

    public static int a(Activity activity) {
        try {
            f24332c = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e8) {
            f24332c = -1;
            e8.printStackTrace();
        }
        return f24332c;
    }

    public static int b(BaseActivity baseActivity, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            strArr = f24330a;
        }
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < strArr.length; i7++) {
            if (androidx.core.content.d.a(baseActivity, strArr[i7]) != 0) {
                arrayList.add(strArr[i7]);
            }
        }
        return arrayList.size();
    }

    public static Map<String, Integer> c(BaseActivity baseActivity, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            strArr = f24330a;
        }
        HashMap map = new HashMap();
        for (int i7 = 0; i7 < strArr.length; i7++) {
            int iA = androidx.core.content.d.a(baseActivity, strArr[i7]);
            if (iA != 0) {
                map.put(strArr[i7], Integer.valueOf(iA));
            }
        }
        return map;
    }

    public static boolean d(BaseActivity baseActivity, int i7, String... strArr) {
        b(baseActivity, strArr);
        Map<String, Integer> mapC = c(baseActivity, strArr);
        if (mapC.size() <= 0) {
            return false;
        }
        Set<String> setKeySet = mapC.keySet();
        androidx.core.app.b.G(baseActivity, (String[]) setKeySet.toArray(new String[setKeySet.size()]), i7);
        return true;
    }
}
