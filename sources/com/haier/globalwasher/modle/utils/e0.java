package com.haier.globalwasher.modle.utils;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class e0 {
    public static String a() {
        return Build.BRAND;
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static Locale[] c() {
        return Locale.getAvailableLocales();
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static int[] f() {
        String strE = e();
        String[] strArrSplit = strE.contains(com.alibaba.android.arouter.utils.b.f12515h) ? strE.replace(com.alibaba.android.arouter.utils.b.f12515h, "-").split("-") : new String[]{strE};
        int[] iArr = new int[strArrSplit.length];
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            try {
                iArr[i7] = Integer.parseInt(strArrSplit[i7]);
            } catch (Exception unused) {
                iArr[i7] = 0;
            }
        }
        return iArr;
    }
}
