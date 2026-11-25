package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static Map<String, String> a(Context context) {
        com.alipay.security.mobile.module.b.c cVarA = com.alipay.security.mobile.module.b.c.a();
        HashMap map = new HashMap();
        f fVarA = com.alipay.apmobilesecuritysdk.e.e.a(context);
        String strB = com.alipay.security.mobile.module.b.c.b(context);
        String strE = com.alipay.security.mobile.module.b.c.e(context);
        String strW = com.alipay.security.mobile.module.b.c.w(context);
        String strA = com.alipay.security.mobile.module.b.c.A(context);
        if (fVarA != null) {
            if (o0.a.d(strB)) {
                strB = fVarA.a();
            }
            if (o0.a.d(strE)) {
                strE = fVarA.b();
            }
            if (o0.a.d(strW)) {
                strW = fVarA.c();
            }
            if (o0.a.d(strA)) {
                strA = fVarA.e();
            }
        }
        f fVar = new f(strB, strE, strW, "", strA);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String string = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", string);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", string);
            } catch (Exception e8) {
                com.alipay.apmobilesecuritysdk.c.a.a(e8);
            }
        }
        map.put("AD1", strB);
        map.put("AD2", strE);
        map.put("AD3", com.alipay.security.mobile.module.b.c.m(context));
        map.put("AD5", com.alipay.security.mobile.module.b.c.q(context));
        map.put("AD6", com.alipay.security.mobile.module.b.c.s(context));
        map.put("AD7", com.alipay.security.mobile.module.b.c.u(context));
        map.put("AD8", strW);
        map.put("AD9", com.alipay.security.mobile.module.b.c.y(context));
        map.put("AD10", strA);
        map.put("AD11", com.alipay.security.mobile.module.b.c.h());
        map.put("AD12", cVarA.j());
        map.put("AD13", com.alipay.security.mobile.module.b.c.l());
        map.put("AD14", com.alipay.security.mobile.module.b.c.p());
        map.put("AD15", com.alipay.security.mobile.module.b.c.r());
        map.put("AD16", com.alipay.security.mobile.module.b.c.t());
        map.put("AD17", "");
        map.put("AD19", com.alipay.security.mobile.module.b.c.C(context));
        map.put("AD20", com.alipay.security.mobile.module.b.c.v());
        map.put("AD22", "");
        map.put("AD23", com.alipay.security.mobile.module.b.c.G(context));
        map.put("AD24", o0.a.l(com.alipay.security.mobile.module.b.c.o(context)));
        map.put("AD26", com.alipay.security.mobile.module.b.c.k(context));
        map.put("AD27", com.alipay.security.mobile.module.b.c.F());
        map.put("AD28", com.alipay.security.mobile.module.b.c.J());
        map.put("AD29", com.alipay.security.mobile.module.b.c.N());
        map.put("AD30", com.alipay.security.mobile.module.b.c.H());
        map.put("AD31", com.alipay.security.mobile.module.b.c.L());
        map.put("AD32", com.alipay.security.mobile.module.b.c.B());
        map.put("AD33", com.alipay.security.mobile.module.b.c.D());
        map.put("AD34", com.alipay.security.mobile.module.b.c.K(context));
        map.put("AD35", com.alipay.security.mobile.module.b.c.M(context));
        map.put("AD36", com.alipay.security.mobile.module.b.c.I(context));
        map.put("AD37", com.alipay.security.mobile.module.b.c.z());
        map.put("AD38", com.alipay.security.mobile.module.b.c.x());
        map.put("AD39", com.alipay.security.mobile.module.b.c.g(context));
        map.put("AD40", com.alipay.security.mobile.module.b.c.i(context));
        map.put("AD41", com.alipay.security.mobile.module.b.c.d());
        map.put("AD42", com.alipay.security.mobile.module.b.c.f());
        map.put("AL3", com.alipay.security.mobile.module.b.c.E(context));
        return map;
    }
}
