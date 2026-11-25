package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f13666h = 3500;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13667i = "https://h5.m.taobao.com/mlapp/olist.html";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f13668j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f13669k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f13670l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f13671m = 1000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f13672n = 20000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13673o = "alipay_cashier_dynamic_config";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f13674p = "timeout";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f13675q = "st_sdk_config";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f13676r = "tbreturl";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f13677s = "launchAppSwitch";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f13678t = "configQueryInterval";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f13679u = "scheme_pay";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f13680v = "scheme_pay_2";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f13681w = "intercept_batch";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static a f13682x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13683a = f13666h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13684b = f13667i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13685c = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13686d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13687e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13688f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<C0156a> f13689g = null;

    /* JADX INFO: renamed from: com.alipay.sdk.data.a$a, reason: collision with other inner class name */
    public static final class C0156a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f13692c;

        public C0156a(String str, int i7, String str2) {
            this.f13690a = str;
            this.f13691b = i7;
            this.f13692c = str2;
        }

        public static C0156a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C0156a(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public static List<C0156a> b(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i7 = 0; i7 < length; i7++) {
                C0156a c0156aA = a(jSONArray.optJSONObject(i7));
                if (c0156aA != null) {
                    arrayList.add(c0156aA);
                }
            }
            return arrayList;
        }

        public static JSONArray c(List<C0156a> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<C0156a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(d(it.next()));
            }
            return jSONArray;
        }

        public static JSONObject d(C0156a c0156a) {
            if (c0156a == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", c0156a.f13690a).put("v", c0156a.f13691b).put("pk", c0156a.f13692c);
            } catch (JSONException e8) {
                com.alipay.sdk.util.d.d(e8);
                return null;
            }
        }

        public String toString() {
            return String.valueOf(d(this));
        }
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f13683a = jSONObject.optInt(f13674p, f13666h);
            this.f13684b = jSONObject.optString(f13676r, f13667i).trim();
            this.f13685c = jSONObject.optInt(f13678t, 10);
            this.f13689g = C0156a.b(jSONObject.optJSONArray(f13677s));
            this.f13686d = jSONObject.optBoolean(f13680v, true);
            this.f13687e = jSONObject.optBoolean(f13681w, true);
        } catch (Throwable th) {
            com.alipay.sdk.util.d.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(f13675q);
            if (jSONObjectOptJSONObject != null) {
                this.f13683a = jSONObjectOptJSONObject.optInt(f13674p, f13666h);
                this.f13684b = jSONObjectOptJSONObject.optString(f13676r, f13667i).trim();
                this.f13685c = jSONObjectOptJSONObject.optInt(f13678t, 10);
                this.f13689g = C0156a.b(jSONObjectOptJSONObject.optJSONArray(f13677s));
                this.f13686d = jSONObjectOptJSONObject.optBoolean(f13680v, true);
                this.f13687e = jSONObjectOptJSONObject.optBoolean(f13681w, true);
            } else {
                com.alipay.sdk.util.d.h("msp", "config is null");
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.d.d(th);
        }
    }

    public static a m() {
        if (f13682x == null) {
            a aVar = new a();
            f13682x = aVar;
            aVar.n();
        }
        return f13682x;
    }

    private void n() {
        e(k.d(m0.b.a().c(), f13673o, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f13674p, a());
            jSONObject.put(f13676r, j());
            jSONObject.put(f13678t, k());
            jSONObject.put(f13677s, C0156a.c(l()));
            jSONObject.put(f13680v, h());
            jSONObject.put(f13681w, i());
            k.b(m0.b.a().c(), f13673o, jSONObject.toString());
        } catch (Exception e8) {
            com.alipay.sdk.util.d.d(e8);
        }
    }

    public int a() {
        int i7 = this.f13683a;
        if (i7 < 1000 || i7 > 20000) {
            com.alipay.sdk.util.d.f("", "DynamicConfig::getJumpTimeout(default) >3500");
            return f13666h;
        }
        com.alipay.sdk.util.d.f("", "DynamicConfig::getJumpTimeout >" + this.f13683a);
        return this.f13683a;
    }

    public void b(Context context) {
        new Thread(new b(this, context)).start();
    }

    public void f(boolean z7) {
        this.f13688f = z7;
    }

    public boolean h() {
        return this.f13686d;
    }

    public boolean i() {
        return this.f13687e;
    }

    public String j() {
        return this.f13684b;
    }

    public int k() {
        return this.f13685c;
    }

    public List<C0156a> l() {
        return this.f13689g;
    }
}
