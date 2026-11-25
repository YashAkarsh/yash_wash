package com.alipay.sdk.app.statistic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.tid.d;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final String A = "H5AuthNetworkError";
    public static final String B = "SSLError";
    public static final String C = "SSLProceed";
    public static final String D = "SSLDenied";
    public static final String E = "H5PayDataAnalysisError";
    public static final String F = "H5AuthDataAnalysisError";
    public static final String G = "PublicKeyUnmatch";
    public static final String H = "ClientBindFailed";
    public static final String I = "TriDesEncryptError";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final String f13625J = "TriDesDecryptError";
    public static final String K = "ClientBindException";
    public static final String L = "SaveTradeTokenError";
    public static final String M = "ClientBindServiceFailed";
    public static final String N = "BindWaitTimeoutEx";
    public static final String O = "CheckClientExistEx";
    public static final String P = "CheckClientSignEx";
    public static final String Q = "GetInstalledAppEx";
    public static final String R = "ParserTidClientKeyEx";
    public static final String S = "GetInstalledAppEx";
    public static final String T = "StartLaunchAppTransEx";
    public static final String U = "CheckLaunchAppExistEx";
    public static final String V = "LogCurrentAppLaunchSwitch";
    public static final String W = "LogCurrentQueryTime";
    public static final String X = "LogCalledPackage";
    public static final String Y = "LogBindCalledH5";
    public static final String Z = "LogCalledH5";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f13626a0 = "LogHkLoginByIntent";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f13627b0 = "SchemePayWrongHashEx";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f13628c0 = "LogAppLaunchSwitchEnabled";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f13629d0 = "H5CbUrlEmpty";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f13630e0 = "H5CbEx";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f13631f0 = "BuildSchemePayUriError";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f13632g0 = "StartActivityEx";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f13633h0 = "JSONEx";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f13634i0 = "ParseBundleSerializableError";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f13635j0 = "ParseSchemeQueryError";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13636k = "net";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f13637k0 = "tid_context_null";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13638l = "biz";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f13639l0 = "partner";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13640m = "cp";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f13641m0 = "out_trade_no";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13642n = "auth";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f13643n0 = "trade_no";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13644o = "third";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f13645p = "tid";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f13646q = "FormatResultEx";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f13647r = "GetApdidEx";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f13648s = "GetApdidNull";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f13649t = "GetApdidTimeout";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f13650u = "GetUtdidEx";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f13651v = "GetPackageInfoEx";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f13652w = "NotIncludeSignatures";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f13653x = "GetInstalledPackagesEx";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f13654y = "GetPublicKeyFromSignEx";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f13655z = "H5PayNetworkError";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f13663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f13664i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f13665j;

    public c(Context context) {
        context = context != null ? context.getApplicationContext() : context;
        this.f13656a = i();
        this.f13658c = a(context);
        this.f13659d = l();
        this.f13660e = n();
        this.f13661f = j(context);
        this.f13662g = "-";
        this.f13663h = "-";
        this.f13665j = "-";
    }

    private String a(Context context) {
        String packageName;
        String str;
        String str2 = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                packageName = applicationContext.getPackageName();
                try {
                    str2 = applicationContext.getPackageManager().getPackageInfo(packageName, 0).versionName;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                packageName = "-";
            }
            str = str2;
            str2 = packageName;
        } else {
            str = "-";
        }
        return String.format("%s,%s,-,-,-", str2, str);
    }

    private String c(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString() + " 》 ");
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"SimpleDateFormat"})
    private String i() {
        return String.format("123456789,%s", new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    private String j(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", k(com.alipay.sdk.util.b.j(context)), "android", k(Build.VERSION.RELEASE), k(Build.MODEL), "-", k(com.alipay.sdk.util.b.a(context).b()), k(com.alipay.sdk.util.b.d(context).c()), "gw", k(com.alipay.sdk.util.b.a(context).e()));
    }

    private String k(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("-", "=").replace("^", "~");
    }

    private String l() {
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", k("15.6.8"), k("h.a.3.6.8"));
    }

    private String m(String str) {
        String str2;
        String[] strArrSplit = str.split(m0.a.f37445e);
        String strReplace = null;
        if (strArrSplit != null) {
            String strReplace2 = null;
            for (String str3 : strArrSplit) {
                String[] strArrSplit2 = str3.split("=");
                if (strArrSplit2 != null && strArrSplit2.length == 2) {
                    if (strArrSplit2[0].equalsIgnoreCase(f13639l0)) {
                        strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase(f13641m0)) {
                        strReplace = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase("trade_no")) {
                        strReplace2 = strArrSplit2[1].replace("\"", "");
                    }
                }
            }
            str2 = strReplace;
            strReplace = strReplace2;
        } else {
            str2 = null;
        }
        String strK = k(strReplace);
        String strK2 = k(str2);
        return String.format("%s,%s,-,%s,-,-,-", strK, strK2, k(strK2));
    }

    private String n() {
        return String.format("%s,%s,-,-,-", k(d.a(m0.b.a().c()).b()), k(m0.b.a().f()));
    }

    public String b(String str) {
        if (h()) {
            return "";
        }
        String strM = m(str);
        this.f13657b = strM;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.f13656a, strM, this.f13658c, this.f13659d, this.f13660e, this.f13661f, this.f13662g, this.f13663h, this.f13664i, this.f13665j);
    }

    public void d(String str, String str2, String str3) {
        e(str, str2, str3, "-");
    }

    public void e(String str, String str2, String str3, String str4) {
        String str5 = "";
        if (!TextUtils.isEmpty(this.f13664i)) {
            str5 = "^";
        }
        this.f13664i += (str5 + String.format("%s,%s,%s,%s", str, str2, k(str3), str4));
    }

    public void f(String str, String str2, Throwable th) {
        d(str, str2, c(th));
    }

    public void g(String str, String str2, Throwable th, String str3) {
        e(str, str2, c(th), str3);
    }

    public boolean h() {
        return TextUtils.isEmpty(this.f13664i);
    }
}
