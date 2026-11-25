package com.alipay.sdk.packet;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.app.j;
import com.alipay.sdk.util.n;
import com.alipay.sdk.util.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13723c = "msp-gzip";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13724d = "Msp-Param";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13725e = "Operation-Type";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13726f = "content-type";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13727g = "Version";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13728h = "AppId";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13729i = "des-mode";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13730j = "namespace";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13731k = "api_name";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13732l = "api_version";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13733m = "data";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13734n = "params";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13735o = "public_key";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f13736p = "device";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f13737q = "action";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f13738r = "type";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f13739s = "method";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f13740a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f13741b = true;

    private static String g(k0.a.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.f34405a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    protected static JSONObject j(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    private boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has("params")) {
                return false;
            }
            String strOptString = jSONObject.getJSONObject("params").optString(f13735o, null);
            if (TextUtils.isEmpty(strOptString)) {
                return false;
            }
            m0.b.a().d().f(strOptString);
            return true;
        } catch (JSONException e8) {
            com.alipay.sdk.util.d.d(e8);
            return false;
        }
    }

    private static boolean l(k0.a.b bVar) {
        return Boolean.valueOf(g(bVar, f13723c)).booleanValue();
    }

    public b a(Context context) throws Throwable {
        return b(context, "");
    }

    public b b(Context context, String str) throws Throwable {
        return c(context, str, n.a(context));
    }

    public b c(Context context, String str, String str2) throws Throwable {
        return d(context, str, str2, true);
    }

    protected b d(Context context, String str, String str2, boolean z7) throws Throwable {
        com.alipay.sdk.util.d.f("", "PacketTask::request url >" + str2);
        c cVar = new c(this.f13741b);
        b bVar = new b(n(), e(str, i()));
        Map<String, String> mapH = h(false, str);
        d dVarC = cVar.c(bVar, this.f13740a, mapH.get("iSr"));
        k0.a.b bVarB = k0.a.b(context, new k0.a.C0420a(str2, h(dVarC.a(), str), dVarC.b()));
        if (bVarB == null) {
            throw new RuntimeException("Response is null.");
        }
        b bVarB2 = cVar.b(new d(l(bVarB), bVarB.f34407c), mapH.get("iSr"));
        return (bVarB2 != null && k(bVarB2.a()) && z7) ? d(context, str, str2, false) : bVarB2;
    }

    protected String e(String str, JSONObject jSONObject) {
        m0.b bVarA = m0.b.a();
        com.alipay.sdk.tid.d dVarA = com.alipay.sdk.tid.d.a(bVarA.c());
        JSONObject jSONObjectA = com.alipay.sdk.util.c.a(new JSONObject(), jSONObject);
        try {
            jSONObjectA.put("tid", dVarA.b());
            jSONObjectA.put(j0.b.f34227b, bVarA.d().e(dVarA));
            jSONObjectA.put(j0.b.f34230e, o.r(bVarA.c(), j.f13608d));
            jSONObjectA.put(j0.b.f34231f, o.j(bVarA.c()));
            jSONObjectA.put(j0.b.f34229d, str);
            jSONObjectA.put(j0.b.f34233h, j0.a.f34208d);
            jSONObjectA.put(j0.b.f34232g, bVarA.f());
            jSONObjectA.put(j0.b.f34235j, dVarA.f());
            jSONObjectA.put(j0.b.f34236k, bVarA.d().b(bVarA.c()));
        } catch (Throwable th) {
            com.alipay.sdk.util.d.d(th);
        }
        return jSONObjectA.toString();
    }

    protected String f(HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (map2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    protected Map<String, String> h(boolean z7, String str) {
        HashMap map = new HashMap();
        map.put(f13723c, String.valueOf(z7));
        map.put(f13725e, "alipay.msp.cashier.dispatch.bytes");
        map.put(f13726f, "application/octet-stream");
        map.put(f13727g, "2.0");
        map.put(f13728h, "TAOBAO");
        map.put(f13724d, a.a(str));
        map.put(f13729i, "CBC");
        return map;
    }

    protected abstract JSONObject i() throws JSONException;

    protected String m() {
        return "4.9.0";
    }

    protected String n() throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put(f13736p, Build.MODEL);
        map.put("namespace", "com.alipay.mobilecashier");
        map.put(f13731k, "com.alipay.mcpay");
        map.put(f13732l, m());
        return f(map, new HashMap<>());
    }
}
