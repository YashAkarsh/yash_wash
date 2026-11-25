package m0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.d;
import com.alipay.sdk.util.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f37444d = "\"&";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f37445e = "&";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f37446f = "bizcontext=\"";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f37447g = "bizcontext=";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f37448h = "\"";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f37449i = "appkey";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f37450j = "ty";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f37451k = "sv";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f37452l = "an";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f37453m = "setting";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f37454n = "av";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f37455o = "sdk_start_time";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f37456p = "UTF-8";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f37459c;

    public a(Context context) {
        this.f37457a = "";
        this.f37458b = "";
        this.f37459c = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f37457a = packageInfo.versionName;
            this.f37458b = packageInfo.packageName;
            this.f37459c = context.getApplicationContext();
        } catch (Exception unused) {
        }
    }

    private String c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(str2);
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            if (!TextUtils.isEmpty(strArrSplit[i7]) && strArrSplit[i7].startsWith(str3)) {
                return strArrSplit[i7];
            }
        }
        return null;
    }

    private String d(String str, String str2, String str3, boolean z7) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject;
        String strSubstring = str.substring(str2.length());
        boolean z8 = false;
        String strSubstring2 = strSubstring.substring(0, strSubstring.length() - str3.length());
        if (strSubstring2.length() >= 2 && strSubstring2.startsWith("\"") && strSubstring2.endsWith("\"")) {
            jSONObject = new JSONObject(strSubstring2.substring(1, strSubstring2.length() - 1));
            z8 = true;
        } else {
            jSONObject = new JSONObject(strSubstring2);
        }
        if (!jSONObject.has(f37449i)) {
            jSONObject.put(f37449i, j0.a.f34208d);
        }
        if (!jSONObject.has(f37450j)) {
            jSONObject.put(f37450j, "and_lite");
        }
        if (!jSONObject.has(f37451k)) {
            jSONObject.put(f37451k, "h.a.3.6.8");
        }
        if (!jSONObject.has(f37452l) && (!this.f37458b.contains(f37453m) || !o.q(this.f37459c))) {
            jSONObject.put(f37452l, this.f37458b);
        }
        if (!jSONObject.has(f37454n)) {
            jSONObject.put(f37454n, this.f37457a);
        }
        if (!jSONObject.has(f37455o)) {
            jSONObject.put(f37455o, System.currentTimeMillis());
        }
        String string = jSONObject.toString();
        if (z8) {
            string = "\"" + string + "\"";
        }
        return str2 + string + str3;
    }

    private String e(String str, String str2) throws JSONException, UnsupportedEncodingException {
        return str + b("", "") + str2;
    }

    private boolean f(String str) {
        return !str.contains(f37444d);
    }

    private String g(String str) {
        try {
            String strC = c(str, f37445e, f37447g);
            if (TextUtils.isEmpty(strC)) {
                str = str + f37445e + e(f37447g, "");
            } else {
                int iIndexOf = str.indexOf(strC);
                str = str.substring(0, iIndexOf) + d(strC, f37447g, "", true) + str.substring(iIndexOf + strC.length());
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    private String h(String str) {
        try {
            String strC = c(str, f37444d, f37446f);
            if (TextUtils.isEmpty(strC)) {
                return str + f37445e + e(f37446f, "\"");
            }
            if (!strC.endsWith("\"")) {
                strC = strC + "\"";
            }
            int iIndexOf = str.indexOf(strC);
            return str.substring(0, iIndexOf) + d(strC, f37446f, "\"", false) + str.substring(iIndexOf + strC.length());
        } catch (Throwable unused) {
            return str;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
            return str;
        }
        return f(str) ? g(str) : h(str);
    }

    public String b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f37449i, j0.a.f34208d);
            jSONObject.put(f37450j, "and_lite");
            jSONObject.put(f37451k, "h.a.3.6.8");
            if (!this.f37458b.contains(f37453m) || !o.q(this.f37459c)) {
                jSONObject.put(f37452l, this.f37458b);
            }
            jSONObject.put(f37454n, this.f37457a);
            jSONObject.put(f37455o, System.currentTimeMillis());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(str, str2);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            d.d(th);
            return "";
        }
    }
}
