package com.alipay.sdk.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13816a = "resultStatus";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13817b = "memo";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13818c = "result";

    private static String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(j.f13808d));
    }

    private static Map<String, String> b() {
        com.alipay.sdk.app.l lVarD = com.alipay.sdk.app.l.d(com.alipay.sdk.app.l.CANCELED.a());
        HashMap map = new HashMap();
        map.put(f13816a, Integer.toString(lVarD.a()));
        map.put(f13817b, lVarD.e());
        map.put(f13818c, "");
        return map;
    }

    public static Map<String, String> c(String str) {
        Map<String, String> mapB = b();
        try {
            return d(str);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.f13646q, th);
            return mapB;
        }
    }

    public static Map<String, String> d(String str) {
        String[] strArrSplit = str.split(j.f13806b);
        HashMap map = new HashMap();
        for (String str2 : strArrSplit) {
            String strSubstring = str2.substring(0, str2.indexOf("={"));
            map.put(strSubstring, a(str2, strSubstring));
        }
        return map;
    }
}
