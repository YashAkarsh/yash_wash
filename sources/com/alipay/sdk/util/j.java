package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13805a = "pref_trade_token";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13806b = ";";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13807c = "result={";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13808d = "}";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13809e = "trade_token=\"";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13810f = "\"";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13811g = "trade_token=";

    public static String a(Context context) {
        String strD = k.d(context, f13805a, "");
        d.f("", "PayResultUtil::fetchTradeToken > tradeToken:" + strD);
        return strD;
    }

    public static String b(String str) {
        String strSubstring = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(f13806b);
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            if (strArrSplit[i7].startsWith(f13807c) && strArrSplit[i7].endsWith(f13808d)) {
                String str2 = strArrSplit[i7];
                String[] strArrSplit2 = str2.substring(8, str2.length() - 1).split(m0.a.f37445e);
                for (int i8 = 0; i8 < strArrSplit2.length; i8++) {
                    if (strArrSplit2[i8].startsWith(f13809e) && strArrSplit2[i8].endsWith("\"")) {
                        String str3 = strArrSplit2[i8];
                        strSubstring = str3.substring(13, str3.length() - 1);
                        break;
                    }
                    if (strArrSplit2[i8].startsWith(f13811g)) {
                        strSubstring = strArrSplit2[i8].substring(12);
                        break;
                    }
                }
            }
        }
        return strSubstring;
    }

    public static void c(Context context, String str) {
        try {
            String strB = b(str);
            d.f("", "PayResultUtil::saveTradeToken > tradeToken:" + strB);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            k.b(context, f13805a, strB);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.L, th);
            d.d(th);
        }
    }
}
