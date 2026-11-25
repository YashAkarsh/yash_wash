package com.alipay.sdk.tid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13749g = "alipay_tid_storage";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13750h = "tidinfo";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13751i = "upgraded_from_db";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13752j = "tid";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13753k = "client_key";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13754l = "timestamp";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13755m = "vimei";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13756n = "vimsi";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static Context f13757o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static d f13758p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13764f = false;

    public static class a {
        private static String a() {
            return "!@#23457";
        }

        public static String b(String str, String str2, boolean z7) {
            String strC;
            if (d.f13757o == null) {
                return null;
            }
            String string = d.f13757o.getSharedPreferences(str, 0).getString(str2, null);
            if (TextUtils.isEmpty(string) || !z7) {
                strC = string;
            } else {
                String strF = f();
                strC = com.alipay.sdk.encrypt.b.c(string, strF);
                if (TextUtils.isEmpty(strC)) {
                    strC = com.alipay.sdk.encrypt.b.c(string, a());
                    if (!TextUtils.isEmpty(strC)) {
                        d(str, str2, strC, true);
                    }
                }
                if (TextUtils.isEmpty(strC)) {
                    String.format("LocalPreference::getLocalPreferences failed %s，%s", string, strF);
                    com.alipay.sdk.util.d.f("TidStorage", "TidStorage.save LocalPreference::getLocalPreferences failed");
                }
            }
            com.alipay.sdk.util.d.f("TidStorage", "TidStorage.save LocalPreference::getLocalPreferences value " + string);
            return strC;
        }

        public static void c(String str, String str2, String str3) {
            d(str, str2, str3, true);
        }

        public static void d(String str, String str2, String str3, boolean z7) {
            if (d.f13757o == null) {
                return;
            }
            SharedPreferences sharedPreferences = d.f13757o.getSharedPreferences(str, 0);
            if (z7) {
                String strF = f();
                String strB = com.alipay.sdk.encrypt.b.b(str3, strF);
                if (TextUtils.isEmpty(strB)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, strF);
                }
                str3 = strB;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static boolean e(String str, String str2) {
            if (d.f13757o == null) {
                return false;
            }
            return d.f13757o.getSharedPreferences(str, 0).contains(str2);
        }

        private static String f() {
            String packageName;
            try {
                packageName = d.f13757o.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                com.alipay.sdk.util.d.d(th);
                packageName = "";
            }
            if (TextUtils.isEmpty(packageName)) {
                packageName = "unknow";
            }
            return (packageName + "00000000").substring(0, 8);
        }

        public static void g(String str, String str2) {
            if (d.f13757o == null) {
                return;
            }
            d.f13757o.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static String h(String str, String str2) {
            return b(str, str2, true);
        }

        public static boolean i(String str, String str2) {
            if (d.f13757o == null) {
                return false;
            }
            return d.f13757o.getSharedPreferences(str, 0).contains(str2);
        }
    }

    public static synchronized d a(Context context) {
        if (f13758p == null) {
            com.alipay.sdk.util.d.f("TidStorage", "getInstance");
            f13758p = new d();
        }
        if (f13757o == null) {
            f13758p.g(context);
        }
        return f13758p;
    }

    private void d(String str, String str2, String str3, String str4, Long l7) {
        if (e(str, str2, str3, str4)) {
            return;
        }
        this.f13759a = str;
        this.f13760b = str2;
        this.f13762d = str3;
        this.f13763e = str4;
        if (l7 == null) {
            this.f13761c = System.currentTimeMillis();
        } else {
            this.f13761c = l7.longValue();
        }
        u();
    }

    private boolean e(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    private void g(Context context) {
        if (context != null) {
            com.alipay.sdk.util.d.f("TidStorage", "TidStorage.initialize context != null");
            f13757o = context.getApplicationContext();
        }
        if (this.f13764f) {
            return;
        }
        this.f13764f = true;
        p();
        q();
    }

    private void p() {
        c cVar;
        Throwable th;
        c cVar2;
        Context context = f13757o;
        if (context == null) {
            return;
        }
        if (a.i(f13749g, f13751i)) {
            com.alipay.sdk.util.d.f("TidStorage", "transferTidFromOldDb: already migrated. returning");
            return;
        }
        try {
            com.alipay.sdk.util.d.f("TidStorage", "transferTidFromOldDb: tid from db: ");
            cVar = new c(context);
            try {
                String strE = com.alipay.sdk.util.b.a(context).e();
                String strB = com.alipay.sdk.util.b.a(context).b();
                String strB2 = cVar.b(strE, strB);
                String strF = cVar.f(strE, strB);
                if (!TextUtils.isEmpty(strB2) && !TextUtils.isEmpty(strF)) {
                    com.alipay.sdk.util.d.f("TidStorage", "transferTidFromOldDb: tid from db is " + strB2 + ", " + strF);
                    c(strB2, strF);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.alipay.sdk.util.d.d(th);
                    if (cVar != null) {
                    }
                    com.alipay.sdk.util.d.f("TidStorage", "transferTidFromOldDb: removing database table");
                    cVar2 = new c(context);
                    try {
                        cVar2.e();
                        cVar2.close();
                    } catch (Throwable th3) {
                        th = th3;
                        cVar = cVar2;
                        try {
                            com.alipay.sdk.util.d.d(th);
                            if (cVar != null) {
                                cVar.close();
                            }
                        } catch (Throwable th4) {
                            if (cVar != null) {
                                cVar.close();
                            }
                            throw th4;
                        }
                    }
                    a.d(f13749g, f13751i, "updated", false);
                } catch (Throwable th5) {
                    if (cVar != null) {
                        cVar.close();
                    }
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            cVar = null;
            th = th6;
        }
        cVar.close();
        try {
            com.alipay.sdk.util.d.f("TidStorage", "transferTidFromOldDb: removing database table");
            cVar2 = new c(context);
            cVar2.e();
            cVar2.close();
        } catch (Throwable th7) {
            th = th7;
        }
        a.d(f13749g, f13751i, "updated", false);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0091  */
    /* JADX WARN: Code duplicated, block: B:25:0x0095  */
    private void q() {
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        String str = null;
        try {
            String strB = a.b(f13749g, f13750h, true);
            if (TextUtils.isEmpty(strB)) {
                strOptString4 = null;
                strOptString2 = null;
                strOptString3 = null;
            } else {
                JSONObject jSONObject = new JSONObject(strB);
                strOptString = jSONObject.optString("tid", "");
                try {
                    strOptString2 = jSONObject.optString(f13753k, "");
                    try {
                        lValueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                        strOptString3 = jSONObject.optString(f13755m, "");
                        try {
                            strOptString4 = jSONObject.optString(f13756n, "");
                        } catch (Exception e8) {
                            e = e8;
                            com.alipay.sdk.util.d.d(e);
                            strOptString4 = null;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        strOptString3 = null;
                    }
                } catch (Exception e10) {
                    e = e10;
                    strOptString2 = null;
                    strOptString3 = strOptString2;
                    com.alipay.sdk.util.d.d(e);
                    strOptString4 = null;
                    str = strOptString;
                    com.alipay.sdk.util.d.f("TidStorage", "TidStorage.load " + str + " " + strOptString2 + " " + lValueOf + " " + strOptString3 + " " + strOptString4);
                    if (e(str, strOptString2, strOptString3, strOptString4)) {
                        r();
                        return;
                    }
                    this.f13759a = str;
                    this.f13760b = strOptString2;
                    this.f13761c = lValueOf.longValue();
                    this.f13762d = strOptString3;
                    this.f13763e = strOptString4;
                }
                str = strOptString;
            }
        } catch (Exception e11) {
            e = e11;
            strOptString = null;
            strOptString2 = null;
        }
        com.alipay.sdk.util.d.f("TidStorage", "TidStorage.load " + str + " " + strOptString2 + " " + lValueOf + " " + strOptString3 + " " + strOptString4);
        if (e(str, strOptString2, strOptString3, strOptString4)) {
            r();
            return;
        }
        this.f13759a = str;
        this.f13760b = strOptString2;
        this.f13761c = lValueOf.longValue();
        this.f13762d = strOptString3;
        this.f13763e = strOptString4;
    }

    private void r() {
        this.f13759a = "";
        this.f13760b = k();
        this.f13761c = System.currentTimeMillis();
        this.f13762d = s();
        this.f13763e = s();
        a.g(f13749g, f13750h);
    }

    private String s() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    private void t() {
    }

    private void u() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f13759a);
            jSONObject.put(f13753k, this.f13760b);
            jSONObject.put("timestamp", this.f13761c);
            jSONObject.put(f13755m, this.f13762d);
            jSONObject.put(f13756n, this.f13763e);
            a.d(f13749g, f13750h, jSONObject.toString(), true);
        } catch (Exception e8) {
            com.alipay.sdk.util.d.d(e8);
        }
    }

    public String b() {
        com.alipay.sdk.util.d.f("TidStorage", "TidStorage.getTid " + this.f13759a);
        return this.f13759a;
    }

    public void c(String str, String str2) {
        com.alipay.sdk.util.d.f("TidStorage", "TidStorage.save " + ("tid=" + str + ",clientKey=" + str2));
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f13759a = str;
        this.f13760b = str2;
        this.f13761c = System.currentTimeMillis();
        u();
        t();
    }

    public String f() {
        com.alipay.sdk.util.d.f("TidStorage", "TidStorage.getClientKey " + this.f13760b);
        return this.f13760b;
    }

    public String h() {
        com.alipay.sdk.util.d.f("TidStorage", "TidStorage.getVirtualImei " + this.f13762d);
        return this.f13762d;
    }

    public String i() {
        com.alipay.sdk.util.d.f("TidStorage", "TidStorage.getVirtualImsi " + this.f13763e);
        return this.f13763e;
    }

    public boolean j() {
        return TextUtils.isEmpty(this.f13759a) || TextUtils.isEmpty(this.f13760b) || TextUtils.isEmpty(this.f13762d) || TextUtils.isEmpty(this.f13763e);
    }

    public String k() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public void l() {
        com.alipay.sdk.util.d.f("TidStorage", "TidStorage.delete " + String.format("TidStorage::delete > %s，%s，%s，%s，%s", this.f13759a, this.f13760b, Long.valueOf(this.f13761c), this.f13762d, this.f13763e));
        r();
    }

    public boolean m() {
        return j();
    }

    public Long n() {
        return Long.valueOf(this.f13761c);
    }
}
