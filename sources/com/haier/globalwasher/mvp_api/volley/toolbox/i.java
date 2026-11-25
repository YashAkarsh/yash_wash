package com.haier.globalwasher.mvp_api.volley.toolbox;

import java.util.Map;
import org.apache.commons.lang3.CharEncoding;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static com.haier.globalwasher.mvp_api.volley.b.a a(com.haier.globalwasher.mvp_api.volley.j jVar) {
        boolean z7;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = jVar.f24844c;
        String str = map.get(com.google.common.net.c.f22138d);
        long jD = str != null ? d(str) : 0L;
        String str2 = map.get(com.google.common.net.c.f22132a);
        int i7 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",");
            z7 = false;
            j7 = 0;
            j8 = 0;
            while (i7 < strArrSplit.length) {
                String strTrim = strArrSplit[i7].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j7 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j8 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z7 = true;
                }
                i7++;
            }
            i7 = 1;
        } else {
            z7 = false;
            j7 = 0;
            j8 = 0;
        }
        String str3 = map.get(com.google.common.net.c.f22151j0);
        long jD2 = str3 != null ? d(str3) : 0L;
        String str4 = map.get(com.google.common.net.c.f22153k0);
        long jD3 = str4 != null ? d(str4) : 0L;
        String str5 = map.get(com.google.common.net.c.f22149i0);
        if (i7 != 0) {
            j10 = jCurrentTimeMillis + (j7 * 1000);
            if (z7) {
                j11 = j10;
            } else {
                Long.signum(j8);
                j11 = (j8 * 1000) + j10;
            }
            j9 = j11;
        } else {
            j9 = 0;
            if (jD <= 0 || jD2 < jD) {
                j10 = 0;
            } else {
                j10 = jCurrentTimeMillis + (jD2 - jD);
                j9 = j10;
            }
        }
        com.haier.globalwasher.mvp_api.volley.b.a aVar = new com.haier.globalwasher.mvp_api.volley.b.a();
        aVar.f24806a = jVar.f24843b;
        aVar.f24807b = str5;
        aVar.f24811f = j10;
        aVar.f24810e = j9;
        aVar.f24808c = jD;
        aVar.f24809d = jD3;
        aVar.f24812g = map;
        return aVar;
    }

    public static String b(Map<String, String> map) {
        return c(map, CharEncoding.ISO_8859_1);
    }

    public static String c(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] strArrSplit = str2.split(com.alipay.sdk.util.j.f13806b);
            for (int i7 = 1; i7 < strArrSplit.length; i7++) {
                String[] strArrSplit2 = strArrSplit[i7].trim().split("=");
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static long d(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0L;
        }
    }
}
