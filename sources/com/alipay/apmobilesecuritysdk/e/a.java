package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static b a(String str) {
        try {
            if (o0.a.d(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"));
        } catch (Exception e8) {
            com.alipay.apmobilesecuritysdk.c.a.a(e8);
            return null;
        }
    }

    public static synchronized b b() {
        String strA = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
        if (o0.a.d(strA)) {
            return null;
        }
        return a(strA);
    }

    public static synchronized b c(Context context) {
        String strA = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
        if (o0.a.d(strA)) {
            return null;
        }
        return a(strA);
    }

    public static synchronized void a() {
    }

    public static synchronized b b(Context context) {
        String strA;
        strA = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
        if (o0.a.d(strA)) {
            strA = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
        }
        return a(strA);
    }

    public static synchronized void a(Context context) {
        com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", "");
        com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", "");
    }

    public static synchronized void a(Context context, b bVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apdid", bVar.f13509a);
            jSONObject.put("deviceInfoHash", bVar.f13510b);
            jSONObject.put("timestamp", bVar.f13511c);
            String string = jSONObject.toString();
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", string);
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", string);
        } catch (Exception e8) {
            com.alipay.apmobilesecuritysdk.c.a.a(e8);
        }
    }
}
