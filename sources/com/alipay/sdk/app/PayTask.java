package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.util.m;
import com.alipay.sdk.util.o;
import com.facebook.internal.NativeProtocol;
import com.haier.uhome.account.api.Const;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PayTask {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Object f13568g = com.alipay.sdk.util.f.class;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f13569h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f13570i = 3000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f13571j = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f13572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alipay.sdk.widget.a f13573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13574c = "wappaygw.alipay.com/service/rest.htm";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13575d = "mclient.alipay.com/service/rest.htm";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13576e = "mclient.alipay.com/home/exterfaceAssign.htm";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, a> f13577f = new HashMap();

    public PayTask(Activity activity) {
        this.f13572a = activity;
        m0.b.a().b(this.f13572a, com.alipay.sdk.data.c.g());
        com.alipay.sdk.app.statistic.a.a(activity);
        this.f13573b = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f13842j);
    }

    private com.alipay.sdk.util.f.a a() {
        return new i(this);
    }

    private String b(String str) {
        String strA = new m0.a(this.f13572a).a(str);
        if (strA.contains("paymethod=\"expressGateway\"")) {
            return k(strA);
        }
        List<com.alipay.sdk.data.a.C0156a> listL = com.alipay.sdk.data.a.m().l();
        if (!com.alipay.sdk.data.a.m().f13688f || listL == null) {
            listL = j.f13608d;
        }
        if (!o.r(this.f13572a, listL)) {
            com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.Z, "");
            return k(strA);
        }
        com.alipay.sdk.util.f fVar = new com.alipay.sdk.util.f(this.f13572a, a());
        String strD = fVar.d(strA);
        fVar.g();
        if (TextUtils.equals(strD, com.alipay.sdk.util.f.f13791i) || TextUtils.equals(strD, com.alipay.sdk.util.f.f13792j)) {
            com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.Y, "");
            return k(strA);
        }
        if (TextUtils.isEmpty(strD)) {
            return k.f();
        }
        if (!strD.contains(PayResultActivity.f13557a)) {
            return strD;
        }
        com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.f13626a0, "");
        return d(strA, listL, strD, this.f13572a);
    }

    private String c(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(com.alipay.sdk.util.j.f13808d));
    }

    private static String d(String str, List<com.alipay.sdk.data.a.C0156a> list, String str2, Activity activity) {
        o.a aVarB = o.b(activity, list);
        if (aVarB == null || aVarB.a() || aVarB.b() || !TextUtils.equals(aVarB.f13826a.packageName, PayResultActivity.f13559c)) {
            return str2;
        }
        com.alipay.sdk.util.d.f("msp", "PayTask:payResult: NOT_LOGIN");
        String strValueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> map = PayResultActivity.f13558b;
        map.put(strValueOf, obj);
        Intent intent = new Intent(activity, (Class<?>) PayResultActivity.class);
        intent.putExtra(PayResultActivity.f13561e, str);
        intent.putExtra(PayResultActivity.f13562f, activity.getPackageName());
        intent.putExtra(PayResultActivity.f13560d, strValueOf);
        activity.startActivity(intent);
        synchronized (map.get(strValueOf)) {
            try {
                com.alipay.sdk.util.d.f("msp", "PayTask:payResult: wait");
                map.get(strValueOf).wait();
            } catch (InterruptedException e8) {
                com.alipay.sdk.util.d.f("msp", "PayTask:payResult: InterruptedException:" + e8);
                return k.f();
            }
        }
        String str3 = PayResultActivity.a.f13567b;
        com.alipay.sdk.util.d.f("msp", "PayTask:payResult: result:" + str3);
        return str3;
    }

    private String e(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean zEquals = "9000".equals(map.get(m.f13816a));
        String str2 = map.get(m.f13818c);
        a aVarRemove = this.f13577f.remove(str);
        String[] strArr = new String[2];
        strArr[0] = aVarRemove != null ? aVarRemove.c() : "";
        strArr[1] = aVarRemove != null ? aVarRemove.g() : "";
        h(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String strH = h(o.h("&callBackUrl=\"", "\"", str2), o.h("&call_back_url=\"", "\"", str2), o.h(j0.a.f34220p, "\"", str2), URLDecoder.decode(o.h(j0.a.f34221q, m0.a.f37445e, str2), "utf-8"), URLDecoder.decode(o.h("&callBackUrl=", m0.a.f37445e, str2), "utf-8"), o.h("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(strH)) {
                return strH;
            }
        }
        if (aVarRemove != null) {
            String strA = zEquals ? aVarRemove.a() : aVarRemove.e();
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        return aVarRemove != null ? com.alipay.sdk.data.a.m().j() : "";
    }

    private String f(l0.b bVar) {
        String[] strArrG = bVar.g();
        Intent intent = new Intent(this.f13572a, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", strArrG[0]);
        if (strArrG.length == 2) {
            bundle.putString("cookie", strArrG[1]);
        }
        intent.putExtras(bundle);
        this.f13572a.startActivity(intent);
        Object obj = f13568g;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e8) {
                com.alipay.sdk.util.d.d(e8);
                return k.f();
            }
        }
        String strA = k.a();
        return TextUtils.isEmpty(strA) ? k.f() : strA;
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        try {
            m0.b.a().b(context, com.alipay.sdk.data.c.g());
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (jElapsedRealtime - f13569h < com.alipay.sdk.data.a.m().k()) {
                return false;
            }
            f13569h = jElapsedRealtime;
            com.alipay.sdk.data.a.m().b(context.getApplicationContext());
            return true;
        } catch (Exception e8) {
            com.alipay.sdk.util.d.d(e8);
            return false;
        }
        throw th;
    }

    private String g(l0.b bVar, String str) {
        boolean zE;
        String strA;
        String[] strArrG = bVar.g();
        Intent intent = new Intent(this.f13572a, (Class<?>) H5PayActivity.class);
        try {
            JSONObject jSONObjectZ = o.z(new String(com.alipay.sdk.encrypt.a.d(strArrG[2])));
            intent.putExtra("url", strArrG[0]);
            intent.putExtra("title", strArrG[1]);
            intent.putExtra("version", "v2");
            intent.putExtra("method", jSONObjectZ.optString("method", Const.HTTP_REQUEST_TYPE_POST));
            k.d(false);
            k.c(null);
            this.f13572a.startActivity(intent);
            Object obj = f13568g;
            synchronized (obj) {
                try {
                    obj.wait();
                    zE = k.e();
                    strA = k.a();
                    k.d(false);
                    k.c(null);
                } catch (InterruptedException e8) {
                    com.alipay.sdk.util.d.d(e8);
                    return k.f();
                }
            }
            String strB = "";
            if (zE) {
                try {
                    List<l0.b> listB = l0.b.b(o.z(new String(com.alipay.sdk.encrypt.a.d(strA))));
                    for (int i7 = 0; i7 < listB.size(); i7++) {
                        l0.b bVar2 = listB.get(i7);
                        if (bVar2.e() == l0.a.SetResult) {
                            String[] strArrG2 = bVar2.g();
                            strB = k.b(Integer.valueOf(strArrG2[1]).intValue(), strArrG2[0], o.B(strArrG2[2]));
                            break;
                        }
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.util.d.d(th);
                    com.alipay.sdk.app.statistic.a.f(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.E, th, strA);
                }
            }
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
            try {
                return k.b(Integer.valueOf(str).intValue(), "", "");
            } catch (Throwable th2) {
                com.alipay.sdk.app.statistic.a.f(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.E, th2, "endCode: " + str);
                return k.b(com.haier.uhome.video.a.f32107b, "", "");
            }
        } catch (Throwable th3) {
            com.alipay.sdk.util.d.d(th3);
            com.alipay.sdk.app.statistic.a.f(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.E, th3, Arrays.toString(strArrG));
            return k.f();
        }
    }

    private static final String h(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    private void i(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("tid");
            String strOptString2 = jSONObject.optString(com.alipay.sdk.tid.d.f13753k);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return;
            }
            com.alipay.sdk.tid.d.a(m0.b.a().c()).c(strOptString, strOptString2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.R, th);
        }
    }

    private boolean j(boolean z7, boolean z8, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i7];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i7++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z8;
        }
        if (!z7) {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
        sb.append(m0.a.f37445e);
        sb.append(str);
        sb.append("=\"");
        sb.append(str2);
        sb.append("\"");
        return true;
    }

    private String k(String str) {
        showLoading();
        l lVarD = null;
        try {
            try {
                JSONObject jSONObjectC = new com.alipay.sdk.packet.impl.e().b(this.f13572a.getApplicationContext(), str).c();
                String strOptString = jSONObjectC.optString("end_code", null);
                List<l0.b> listB = l0.b.b(jSONObjectC.optJSONObject(j0.c.f34239c).optJSONObject(j0.c.f34240d));
                for (int i7 = 0; i7 < listB.size(); i7++) {
                    if (listB.get(i7).e() == l0.a.Update) {
                        l0.b.c(listB.get(i7));
                    }
                }
                i(jSONObjectC);
                dismissLoading();
                for (int i8 = 0; i8 < listB.size(); i8++) {
                    l0.b bVar = listB.get(i8);
                    if (bVar.e() == l0.a.WapPay) {
                        String strF = f(bVar);
                        dismissLoading();
                        return strF;
                    }
                    if (bVar.e() == l0.a.OpenWeb) {
                        String strG = g(bVar, strOptString);
                        dismissLoading();
                        return strG;
                    }
                }
            } catch (Throwable th) {
                dismissLoading();
                throw th;
            }
        } catch (IOException e8) {
            lVarD = l.d(l.NETWORK_ERROR.a());
            com.alipay.sdk.app.statistic.a.g("net", e8);
        } catch (Throwable th2) {
            com.alipay.sdk.util.d.d(th2);
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.E, th2);
        }
        dismissLoading();
        if (lVarD == null) {
            lVarD = l.d(l.FAILED.a());
        }
        return k.b(lVarD.a(), lVarD.e(), "");
    }

    private static boolean l() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - f13571j < f13570i) {
            return true;
        }
        f13571j = jElapsedRealtime;
        return false;
    }

    public void dismissLoading() {
        com.alipay.sdk.widget.a aVar = this.f13573b;
        if (aVar != null) {
            aVar.i();
            this.f13573b = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0041 A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:12:0x0069 A[Catch: all -> 0x04ac, TRY_LEAVE, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x00de A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0106 A[Catch: all -> 0x04ac, TRY_LEAVE, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x017b A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x018b A[Catch: all -> 0x04ac, TRY_LEAVE, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x01fd A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x020b A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x022a A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0257 A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0268 A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x026e A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:62:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:68:0x033c A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0356 A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:80:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:83:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:84:0x03df  */
    /* JADX WARN: Code duplicated, block: B:87:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:88:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:91:0x0434 A[Catch: all -> 0x04ac, TryCatch #2 {all -> 0x04ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0028, B:15:0x00ac, B:17:0x00c5, B:24:0x0149, B:26:0x0162, B:39:0x01ec, B:41:0x01fd, B:43:0x020b, B:45:0x022a, B:47:0x0257, B:57:0x028c, B:63:0x02c5, B:50:0x0268, B:52:0x026e, B:54:0x027c, B:66:0x0332, B:68:0x033c, B:70:0x0342, B:73:0x034c, B:75:0x0356, B:77:0x0366, B:81:0x03ce, B:85:0x03e1, B:89:0x03f4, B:91:0x0434, B:93:0x043a, B:95:0x0440, B:98:0x047e, B:28:0x017b, B:30:0x0183, B:32:0x018b, B:38:0x01e9, B:19:0x00de, B:21:0x0106, B:10:0x0041, B:12:0x0069, B:34:0x01b3), top: B:113:0x0005, inners: #1 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:10:0x0041, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:12:0x0069, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x00de, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x0106, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x018b, please report this as an issue */
    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        String strTrim;
        String strTrim2;
        h hVar;
        Uri uri;
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String strH;
        String strH2;
        String str2;
        String str3;
        String str4;
        String strH3;
        String strH4;
        String strH5;
        String strH6;
        Map<String, String> mapP;
        StringBuilder sb;
        String str5;
        try {
            if (!TextUtils.isEmpty(str)) {
                String strTrim3 = str.trim();
                if (strTrim3.startsWith("https://" + this.f13574c)) {
                    strTrim = strTrim3.replaceFirst("(http|https)://" + this.f13574c + "\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + o.h("<request_token>", "</request_token>", o.p(strTrim).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new m0.a(this.f13572a).b("sc", "h5tonative") + "\"";
                    }
                } else {
                    if (strTrim3.startsWith("http://" + this.f13574c)) {
                        strTrim = strTrim3.replaceFirst("(http|https)://" + this.f13574c + "\\?", "").trim();
                        if (!TextUtils.isEmpty(strTrim)) {
                            return "_input_charset=\"utf-8\"&ordertoken=\"" + o.h("<request_token>", "</request_token>", o.p(strTrim).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new m0.a(this.f13572a).b("sc", "h5tonative") + "\"";
                        }
                    }
                }
                if (strTrim3.startsWith("https://" + this.f13575d)) {
                    strTrim2 = strTrim3.replaceFirst("(http|https)://" + this.f13575d + "\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + o.h("<request_token>", "</request_token>", o.p(strTrim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new m0.a(this.f13572a).b("sc", "h5tonative") + "\"";
                    }
                } else {
                    if (strTrim3.startsWith("http://" + this.f13575d)) {
                        strTrim2 = strTrim3.replaceFirst("(http|https)://" + this.f13575d + "\\?", "").trim();
                        if (!TextUtils.isEmpty(strTrim2)) {
                            return "_input_charset=\"utf-8\"&ordertoken=\"" + o.h("<request_token>", "</request_token>", o.p(strTrim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new m0.a(this.f13572a).b("sc", "h5tonative") + "\"";
                        }
                    }
                }
                if (!strTrim3.startsWith("https://" + this.f13576e)) {
                    if (strTrim3.startsWith("http://" + this.f13576e)) {
                        if (strTrim3.contains("alipay.wap.create.direct.pay.by.user") || strTrim3.contains("create_forex_trade_wap")) {
                            if (!TextUtils.isEmpty(strTrim3.replaceFirst("(http|https)://" + this.f13576e + "\\?", "").trim())) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("url", str);
                                    jSONObject.put("bizcontext", new m0.a(this.f13572a).b("sc", "h5tonative"));
                                    return "new_external_info==" + jSONObject.toString();
                                } catch (Throwable th) {
                                    com.alipay.sdk.util.d.d(th);
                                }
                            }
                        }
                    }
                    hVar = null;
                    if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                        strH6 = o.h("?", "", str);
                        if (!TextUtils.isEmpty(strH6)) {
                            mapP = o.p(strH6);
                            sb = new StringBuilder();
                            if (j(false, true, "trade_no", sb, mapP, "trade_no", "alipay_trade_no")) {
                                j(true, false, "pay_phase_id", sb, mapP, "payPhaseId", "pay_phase_id", "out_relation_id");
                                sb.append("&biz_sub_type=\"TRADE\"");
                                sb.append("&biz_type=\"trade\"");
                                str5 = mapP.get(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(mapP.get("cid"))) {
                                    str5 = "ali1688";
                                } else if (TextUtils.isEmpty(str5) && (!TextUtils.isEmpty(mapP.get("sid")) || !TextUtils.isEmpty(mapP.get("s_id")))) {
                                    str5 = "tb";
                                }
                                sb.append("&app_name=\"" + str5 + "\"");
                                if (!j(true, true, "extern_token", sb, mapP, "extern_token", "cid", "sid", "s_id")) {
                                    return "";
                                }
                                j(true, false, "appenv", sb, mapP, "appenv");
                                sb.append("&pay_channel_id=\"alipay_sdk\"");
                                a aVar = new a(this, hVar);
                                aVar.b(mapP.get("return_url"));
                                aVar.f(mapP.get("show_url"));
                                aVar.d(mapP.get("pay_order_id"));
                                String str6 = sb.toString() + "&bizcontext=\"" + new m0.a(this.f13572a).b("sc", "h5tonative") + "\"";
                                this.f13577f.put(str6, aVar);
                                return str6;
                            }
                        }
                    }
                    if (!strTrim3.contains("mclient.alipay.com/cashier/mobilepay.htm") && (!com.alipay.sdk.app.a.b() || !strTrim3.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                        if (com.alipay.sdk.data.a.m().i() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(strTrim3).find()) {
                            uri = Uri.parse(strTrim3);
                            queryParameter = uri.getQueryParameter("return_url");
                            queryParameter2 = uri.getQueryParameter("show_url");
                            queryParameter3 = uri.getQueryParameter("pay_order_id");
                            strH = h(uri.getQueryParameter("trade_nos"), uri.getQueryParameter("alipay_trade_no"));
                            strH2 = h(uri.getQueryParameter("payPhaseId"), uri.getQueryParameter("pay_phase_id"), uri.getQueryParameter("out_relation_id"));
                            String[] strArr = new String[4];
                            strArr[0] = uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                            if (TextUtils.isEmpty(uri.getQueryParameter("cid"))) {
                                str2 = "";
                            } else {
                                str2 = "ali1688";
                            }
                            strArr[1] = str2;
                            if (TextUtils.isEmpty(uri.getQueryParameter("sid"))) {
                                str3 = "";
                            } else {
                                str3 = "tb";
                            }
                            strArr[2] = str3;
                            if (TextUtils.isEmpty(uri.getQueryParameter("s_id"))) {
                                str4 = "";
                            } else {
                                str4 = "tb";
                            }
                            strArr[3] = str4;
                            strH3 = h(strArr);
                            strH4 = h(uri.getQueryParameter("extern_token"), uri.getQueryParameter("cid"), uri.getQueryParameter("sid"), uri.getQueryParameter("s_id"));
                            strH5 = h(uri.getQueryParameter("appenv"));
                            if (!TextUtils.isEmpty(strH) && !TextUtils.isEmpty(strH3) && !TextUtils.isEmpty(strH4)) {
                                String str7 = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", strH, strH2, strH3, strH4, strH5, new m0.a(this.f13572a).b("sc", "h5tonative"));
                                a aVar2 = new a(this, null);
                                aVar2.b(queryParameter);
                                aVar2.f(queryParameter2);
                                aVar2.d(queryParameter3);
                                aVar2.h(strH);
                                this.f13577f.put(str7, aVar2);
                                return str7;
                            }
                        }
                    }
                    String strB = new m0.a(this.f13572a).b("sc", "h5tonative");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("url", strTrim3);
                    jSONObject2.put("bizcontext", strB);
                    return String.format("new_external_info==%s", jSONObject2.toString());
                }
                if (strTrim3.contains("alipay.wap.create.direct.pay.by.user")) {
                    if (!TextUtils.isEmpty(strTrim3.replaceFirst("(http|https)://" + this.f13576e + "\\?", "").trim())) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("url", str);
                        jSONObject3.put("bizcontext", new m0.a(this.f13572a).b("sc", "h5tonative"));
                        return "new_external_info==" + jSONObject3.toString();
                    }
                    hVar = null;
                    if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                        strH6 = o.h("?", "", str);
                        if (!TextUtils.isEmpty(strH6)) {
                            mapP = o.p(strH6);
                            sb = new StringBuilder();
                            if (j(false, true, "trade_no", sb, mapP, "trade_no", "alipay_trade_no")) {
                                j(true, false, "pay_phase_id", sb, mapP, "payPhaseId", "pay_phase_id", "out_relation_id");
                                sb.append("&biz_sub_type=\"TRADE\"");
                                sb.append("&biz_type=\"trade\"");
                                str5 = mapP.get(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                                if (!TextUtils.isEmpty(str5)) {
                                    if (TextUtils.isEmpty(str5)) {
                                        str5 = "tb";
                                    }
                                } else if (TextUtils.isEmpty(str5)) {
                                    str5 = "tb";
                                }
                                sb.append("&app_name=\"" + str5 + "\"");
                                if (!j(true, true, "extern_token", sb, mapP, "extern_token", "cid", "sid", "s_id")) {
                                    return "";
                                }
                                j(true, false, "appenv", sb, mapP, "appenv");
                                sb.append("&pay_channel_id=\"alipay_sdk\"");
                                a aVar3 = new a(this, hVar);
                                aVar3.b(mapP.get("return_url"));
                                aVar3.f(mapP.get("show_url"));
                                aVar3.d(mapP.get("pay_order_id"));
                                String str8 = sb.toString() + "&bizcontext=\"" + new m0.a(this.f13572a).b("sc", "h5tonative") + "\"";
                                this.f13577f.put(str8, aVar3);
                                return str8;
                            }
                        }
                    }
                    if (!strTrim3.contains("mclient.alipay.com/cashier/mobilepay.htm")) {
                        if (com.alipay.sdk.data.a.m().i()) {
                            uri = Uri.parse(strTrim3);
                            queryParameter = uri.getQueryParameter("return_url");
                            queryParameter2 = uri.getQueryParameter("show_url");
                            queryParameter3 = uri.getQueryParameter("pay_order_id");
                            strH = h(uri.getQueryParameter("trade_nos"), uri.getQueryParameter("alipay_trade_no"));
                            strH2 = h(uri.getQueryParameter("payPhaseId"), uri.getQueryParameter("pay_phase_id"), uri.getQueryParameter("out_relation_id"));
                            String[] strArr2 = new String[4];
                            strArr2[0] = uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                            if (TextUtils.isEmpty(uri.getQueryParameter("cid"))) {
                                str2 = "ali1688";
                            } else {
                                str2 = "";
                            }
                            strArr2[1] = str2;
                            if (TextUtils.isEmpty(uri.getQueryParameter("sid"))) {
                                str3 = "tb";
                            } else {
                                str3 = "";
                            }
                            strArr2[2] = str3;
                            if (TextUtils.isEmpty(uri.getQueryParameter("s_id"))) {
                                str4 = "tb";
                            } else {
                                str4 = "";
                            }
                            strArr2[3] = str4;
                            strH3 = h(strArr2);
                            strH4 = h(uri.getQueryParameter("extern_token"), uri.getQueryParameter("cid"), uri.getQueryParameter("sid"), uri.getQueryParameter("s_id"));
                            strH5 = h(uri.getQueryParameter("appenv"));
                            if (!TextUtils.isEmpty(strH)) {
                                String str9 = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", strH, strH2, strH3, strH4, strH5, new m0.a(this.f13572a).b("sc", "h5tonative"));
                                a aVar4 = new a(this, null);
                                aVar4.b(queryParameter);
                                aVar4.f(queryParameter2);
                                aVar4.d(queryParameter3);
                                aVar4.h(strH);
                                this.f13577f.put(str9, aVar4);
                                return str9;
                            }
                        }
                    }
                    String strB2 = new m0.a(this.f13572a).b("sc", "h5tonative");
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("url", strTrim3);
                    jSONObject4.put("bizcontext", strB2);
                    return String.format("new_external_info==%s", jSONObject4.toString());
                }
                if (!TextUtils.isEmpty(strTrim3.replaceFirst("(http|https)://" + this.f13576e + "\\?", "").trim())) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("url", str);
                    jSONObject5.put("bizcontext", new m0.a(this.f13572a).b("sc", "h5tonative"));
                    return "new_external_info==" + jSONObject5.toString();
                }
                hVar = null;
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    strH6 = o.h("?", "", str);
                    if (!TextUtils.isEmpty(strH6)) {
                        mapP = o.p(strH6);
                        sb = new StringBuilder();
                        if (j(false, true, "trade_no", sb, mapP, "trade_no", "alipay_trade_no")) {
                            j(true, false, "pay_phase_id", sb, mapP, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            str5 = mapP.get(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                            if (!TextUtils.isEmpty(str5)) {
                                if (TextUtils.isEmpty(str5)) {
                                    str5 = "tb";
                                }
                            } else if (TextUtils.isEmpty(str5)) {
                                str5 = "tb";
                            }
                            sb.append("&app_name=\"" + str5 + "\"");
                            if (!j(true, true, "extern_token", sb, mapP, "extern_token", "cid", "sid", "s_id")) {
                                return "";
                            }
                            j(true, false, "appenv", sb, mapP, "appenv");
                            sb.append("&pay_channel_id=\"alipay_sdk\"");
                            a aVar5 = new a(this, hVar);
                            aVar5.b(mapP.get("return_url"));
                            aVar5.f(mapP.get("show_url"));
                            aVar5.d(mapP.get("pay_order_id"));
                            String str10 = sb.toString() + "&bizcontext=\"" + new m0.a(this.f13572a).b("sc", "h5tonative") + "\"";
                            this.f13577f.put(str10, aVar5);
                            return str10;
                        }
                    }
                }
                if (!strTrim3.contains("mclient.alipay.com/cashier/mobilepay.htm")) {
                    if (com.alipay.sdk.data.a.m().i()) {
                        uri = Uri.parse(strTrim3);
                        queryParameter = uri.getQueryParameter("return_url");
                        queryParameter2 = uri.getQueryParameter("show_url");
                        queryParameter3 = uri.getQueryParameter("pay_order_id");
                        strH = h(uri.getQueryParameter("trade_nos"), uri.getQueryParameter("alipay_trade_no"));
                        strH2 = h(uri.getQueryParameter("payPhaseId"), uri.getQueryParameter("pay_phase_id"), uri.getQueryParameter("out_relation_id"));
                        String[] strArr3 = new String[4];
                        strArr3[0] = uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                        if (TextUtils.isEmpty(uri.getQueryParameter("cid"))) {
                            str2 = "ali1688";
                        } else {
                            str2 = "";
                        }
                        strArr3[1] = str2;
                        if (TextUtils.isEmpty(uri.getQueryParameter("sid"))) {
                            str3 = "tb";
                        } else {
                            str3 = "";
                        }
                        strArr3[2] = str3;
                        if (TextUtils.isEmpty(uri.getQueryParameter("s_id"))) {
                            str4 = "tb";
                        } else {
                            str4 = "";
                        }
                        strArr3[3] = str4;
                        strH3 = h(strArr3);
                        strH4 = h(uri.getQueryParameter("extern_token"), uri.getQueryParameter("cid"), uri.getQueryParameter("sid"), uri.getQueryParameter("s_id"));
                        strH5 = h(uri.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(strH)) {
                            String str11 = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", strH, strH2, strH3, strH4, strH5, new m0.a(this.f13572a).b("sc", "h5tonative"));
                            a aVar6 = new a(this, null);
                            aVar6.b(queryParameter);
                            aVar6.f(queryParameter2);
                            aVar6.d(queryParameter3);
                            aVar6.h(strH);
                            this.f13577f.put(str11, aVar6);
                            return str11;
                        }
                    }
                }
                String strB3 = new m0.a(this.f13572a).b("sc", "h5tonative");
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("url", strTrim3);
                jSONObject6.put("bizcontext", strB3);
                return String.format("new_external_info==%s", jSONObject6.toString());
            }
        } catch (Throwable th2) {
            com.alipay.sdk.util.d.d(th2);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return com.alipay.sdk.util.j.a(this.f13572a.getApplicationContext());
    }

    public String getVersion() {
        return "15.6.8";
    }

    public synchronized com.alipay.sdk.util.a h5Pay(String str, boolean z7) {
        com.alipay.sdk.util.a aVar;
        aVar = new com.alipay.sdk.util.a();
        try {
            String[] strArrSplit = pay(str, z7).split(com.alipay.sdk.util.j.f13806b);
            HashMap map = new HashMap();
            for (String str2 : strArrSplit) {
                int iIndexOf = str2.indexOf("={");
                if (iIndexOf >= 0) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    map.put(strSubstring, c(str2, strSubstring));
                }
            }
            if (map.containsKey(m.f13816a)) {
                aVar.c(map.get(m.f13816a));
            }
            aVar.d(e(str, map));
            if (TextUtils.isEmpty(aVar.b())) {
                com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.f13629d0, "");
            }
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.f13630e0, th);
            com.alipay.sdk.util.d.d(th);
        }
        return aVar;
    }

    public synchronized String pay(String str, boolean z7) {
        String strB;
        if (l()) {
            return k.g();
        }
        if (z7) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            String strSubstring = str.substring(str.indexOf("payment_inst=") + 13);
            int iIndexOf = strSubstring.indexOf(38);
            if (iIndexOf > 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            j.b(strSubstring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            j.b("");
        }
        if (str.contains(j0.a.f34222r)) {
            j0.a.f34223s = true;
        }
        if (j0.a.f34223s) {
            if (str.startsWith(j0.a.f34224t)) {
                str = str.substring(str.indexOf(j0.a.f34224t) + 53);
            } else if (str.startsWith(j0.a.f34225u)) {
                str = str.substring(str.indexOf(j0.a.f34225u) + 52);
            }
        }
        try {
            strB = b(str);
            com.alipay.sdk.util.j.c(this.f13572a.getApplicationContext(), strB);
            com.alipay.sdk.data.a.m().b(this.f13572a.getApplicationContext());
            dismissLoading();
            com.alipay.sdk.app.statistic.a.h(this.f13572a.getApplicationContext(), str);
        } catch (Throwable th) {
            try {
                String strF = k.f();
                com.alipay.sdk.util.d.d(th);
                com.alipay.sdk.data.a.m().b(this.f13572a.getApplicationContext());
                dismissLoading();
                com.alipay.sdk.app.statistic.a.h(this.f13572a.getApplicationContext(), str);
                strB = strF;
            } catch (Throwable th2) {
                com.alipay.sdk.data.a.m().b(this.f13572a.getApplicationContext());
                dismissLoading();
                com.alipay.sdk.app.statistic.a.h(this.f13572a.getApplicationContext(), str);
                throw th2;
            }
        }
        return strB;
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z7, H5PayCallback h5PayCallback) {
        String strFetchOrderInfoFromH5PayUrl;
        strFetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl)) {
            new Thread(new h(this, strFetchOrderInfoFromH5PayUrl, z7, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z7) {
        return m.c(pay(str, z7));
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar = this.f13573b;
        if (aVar != null) {
            aVar.g();
        }
    }

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f13579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f13580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f13581d;

        private a() {
            this.f13578a = "";
            this.f13579b = "";
            this.f13580c = "";
            this.f13581d = "";
        }

        public String a() {
            return this.f13578a;
        }

        public void b(String str) {
            this.f13578a = str;
        }

        public String c() {
            return this.f13580c;
        }

        public void d(String str) {
            this.f13580c = str;
        }

        public String e() {
            return this.f13579b;
        }

        public void f(String str) {
            this.f13579b = str;
        }

        public String g() {
            return this.f13581d;
        }

        public void h(String str) {
            this.f13581d = str;
        }

        /* synthetic */ a(PayTask payTask, h hVar) {
            this();
        }
    }
}
