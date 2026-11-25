package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13820a = "com.alipay.android.app";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f13821b = "com.eg.android.AlipayGphone";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13822c = "com.eg.android.AlipayGphoneRC";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f13823d = 99;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f13824e = {"10.1.5.1013151", "10.1.5.1013148"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f13825f = 125;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PackageInfo f13826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f13828c;

        public a(PackageInfo packageInfo, int i7, String str) {
            this.f13826a = packageInfo;
            this.f13827b = i7;
            this.f13828c = str;
        }

        public boolean a() {
            Signature[] signatureArr = this.f13826a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String strO = o.o(signature.toByteArray());
                if (strO != null && !TextUtils.equals(strO, this.f13828c)) {
                    com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.G, String.format("Got %s, expected %s", strO, this.f13828c));
                    return true;
                }
            }
            return false;
        }

        public boolean b() {
            return this.f13826a.versionCode < this.f13827b;
        }
    }

    public static String A(Context context) {
        DisplayMetrics displayMetricsG = G(context);
        return displayMetricsG.widthPixels + "*" + displayMetricsG.heightPixels;
    }

    public static String B(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e8) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.E, e8);
            return "";
        }
    }

    public static String C(Context context) {
        String strA = n.a(context);
        return strA.substring(0, strA.indexOf("://"));
    }

    public static boolean D(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static String E(Context context) {
        return "-1;-1";
    }

    public static String F(Context context) {
        return v(context, context.getPackageName());
    }

    private static DisplayMetrics G(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static a a(Context context, String str, int i7, String str2) {
        PackageInfo packageInfoM;
        if (com.alipay.sdk.app.a.b() && f13821b.equals(str)) {
            str = f13822c;
        }
        try {
            packageInfoM = m(context, str);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13642n, com.alipay.sdk.app.statistic.c.f13651v, th);
            packageInfoM = null;
        }
        if (s(packageInfoM)) {
            return c(packageInfoM, i7, str2);
        }
        return null;
    }

    public static a b(Context context, List<com.alipay.sdk.data.a.C0156a> list) {
        a aVarA;
        if (list == null) {
            return null;
        }
        for (com.alipay.sdk.data.a.C0156a c0156a : list) {
            if (c0156a != null && (aVarA = a(context, c0156a.f13690a, c0156a.f13691b, c0156a.f13692c)) != null && !aVarA.a() && !aVarA.b()) {
                return aVarA;
            }
        }
        return null;
    }

    private static a c(PackageInfo packageInfo, int i7, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new a(packageInfo, i7, str);
    }

    static String d() {
        if (com.alipay.sdk.app.a.b()) {
            return f13822c;
        }
        try {
            return com.alipay.sdk.app.j.f13608d.get(0).f13690a;
        } catch (Throwable unused) {
            return f13821b;
        }
    }

    public static String e(int i7) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < i7; i8++) {
            int iNextInt = random.nextInt(3);
            if (iNextInt == 0) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (iNextInt == 1) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (iNextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    static String f(Context context, String str) {
        String strSubstring = "";
        try {
            String string = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    string = string + "#M";
                } else {
                    if (runningAppProcessInfo.processName.startsWith(str + ":")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(string);
                        sb.append("#");
                        sb.append(runningAppProcessInfo.processName.replace(str + ":", ""));
                        string = sb.toString();
                    }
                }
            }
            strSubstring = string;
        } catch (Throwable unused) {
        }
        if (strSubstring.length() > 0) {
            strSubstring = strSubstring.substring(1);
        }
        return strSubstring.length() == 0 ? "N" : strSubstring;
    }

    static String g(String str) {
        return (com.alipay.sdk.app.a.b() && TextUtils.equals(str, f13822c)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static String h(String str, String str2, String str3) {
        try {
            int iIndexOf = str3.indexOf(str) + str.length();
            if (iIndexOf <= str.length()) {
                return "";
            }
            int iIndexOf2 = !TextUtils.isEmpty(str2) ? str3.indexOf(str2, iIndexOf) : 0;
            return iIndexOf2 < 1 ? str3.substring(iIndexOf) : str3.substring(iIndexOf, iIndexOf2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean j(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f13820a, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    static boolean k(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = f13824e;
            return TextUtils.equals(str, strArr[0]) || TextUtils.equals(str, strArr[1]);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean l(WebView webView, String str, Activity activity) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith(j0.a.f34214j.toLowerCase()) || str.toLowerCase().startsWith(j0.a.f34215k.toLowerCase())) {
            try {
                a aVarB = b(activity, com.alipay.sdk.app.j.f13608d);
                if (aVarB != null && !aVarB.b() && !aVarB.a()) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp\\?", j0.a.f34214j);
                    }
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Throwable unused) {
            }
            return true;
        }
        if (TextUtils.equals(str, j0.a.f34217m) || TextUtils.equals(str, j0.a.f34218n)) {
            com.alipay.sdk.app.k.c(com.alipay.sdk.app.k.f());
            activity.finish();
            return true;
        }
        if (!str.startsWith(j0.a.f34216l)) {
            return false;
        }
        try {
            String strSubstring2 = str.substring(str.indexOf(j0.a.f34216l) + 24);
            int i7 = Integer.parseInt(strSubstring2.substring(strSubstring2.lastIndexOf(j0.a.f34219o) + 10));
            if (i7 == com.alipay.sdk.app.l.SUCCEEDED.a() || i7 == com.alipay.sdk.app.l.PAY_WAITTING.a()) {
                if (j0.a.f34223s) {
                    StringBuilder sb = new StringBuilder();
                    String strDecode = URLDecoder.decode(str);
                    String strDecode2 = URLDecoder.decode(strDecode);
                    String str2 = strDecode2.substring(strDecode2.indexOf(j0.a.f34216l) + 24, strDecode2.lastIndexOf(j0.a.f34219o)).split(j0.a.f34221q)[0];
                    int iIndexOf = strDecode.indexOf(j0.a.f34221q) + 12;
                    sb.append(str2);
                    sb.append(j0.a.f34221q);
                    sb.append(strDecode.substring(iIndexOf, strDecode.indexOf(m0.a.f37445e, iIndexOf)));
                    sb.append(strDecode.substring(strDecode.indexOf(m0.a.f37445e, iIndexOf)));
                    strSubstring = sb.toString();
                } else {
                    String strDecode3 = URLDecoder.decode(str);
                    strSubstring = strDecode3.substring(strDecode3.indexOf(j0.a.f34216l) + 24, strDecode3.lastIndexOf(j0.a.f34219o));
                }
                com.alipay.sdk.app.l lVarD = com.alipay.sdk.app.l.d(i7);
                com.alipay.sdk.app.k.c(com.alipay.sdk.app.k.b(lVarD.a(), lVarD.e(), strSubstring));
            } else {
                com.alipay.sdk.app.l lVarD2 = com.alipay.sdk.app.l.d(com.alipay.sdk.app.l.FAILED.a());
                com.alipay.sdk.app.k.c(com.alipay.sdk.app.k.b(lVarD2.a(), lVarD2.e(), ""));
            }
        } catch (Exception unused2) {
            com.alipay.sdk.app.k.c(com.alipay.sdk.app.k.h());
        }
        activity.runOnUiThread(new p(activity));
        return true;
    }

    private static PackageInfo m(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, com.alibaba.fastjson.asm.j.f12606c0);
    }

    public static String n() {
        return "Android " + Build.VERSION.RELEASE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String o(byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e8) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13642n, com.alipay.sdk.app.statistic.c.f13654y, e8);
            return null;
        }
    }

    public static Map<String, String> p(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split(m0.a.f37445e)) {
            int iIndexOf = str2.indexOf("=", 1);
            if (-1 != iIndexOf) {
                map.put(str2.substring(0, iIndexOf), URLDecoder.decode(str2.substring(iIndexOf + 1)));
            }
        }
        return map;
    }

    public static boolean q(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(d(), 128);
            return packageInfo != null && packageInfo.versionCode < 99;
        } catch (Throwable th) {
            d.d(th);
            return false;
        }
    }

    public static boolean r(Context context, List<com.alipay.sdk.data.a.C0156a> list) {
        try {
            for (com.alipay.sdk.data.a.C0156a c0156a : list) {
                if (c0156a != null) {
                    String str = c0156a.f13690a;
                    if (com.alipay.sdk.app.a.b() && f13821b.equals(str)) {
                        str = f13822c;
                    }
                    try {
                        if (context.getPackageManager().getPackageInfo(str, 128) != null) {
                            return true;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.U, th);
            return false;
        }
    }

    private static boolean s(PackageInfo packageInfo) {
        String str = "";
        boolean z7 = false;
        if (packageInfo == null) {
            str = "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = "info.signatures.length <= 0";
            } else {
                z7 = true;
            }
        }
        if (!z7) {
            com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13642n, com.alipay.sdk.app.statistic.c.f13652w, str);
        }
        return z7;
    }

    public static String t() {
        String strX = x();
        int iIndexOf = strX.indexOf("-");
        if (iIndexOf != -1) {
            strX = strX.substring(0, iIndexOf);
        }
        int iIndexOf2 = strX.indexOf("\n");
        if (iIndexOf2 != -1) {
            strX = strX.substring(0, iIndexOf2);
        }
        return "Linux " + strX;
    }

    public static String u(Context context) {
        return " (" + n() + j.f13806b + t() + j.f13806b + y(context) + j.f13806b + j.f13806b + A(context) + ")(sdk android)";
    }

    private static String v(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.f13651v, th);
            return "";
        }
    }

    public static Map<String, String> w(String str) {
        HashMap map = new HashMap(4);
        int iIndexOf = str.indexOf(63);
        if (iIndexOf != -1 && iIndexOf < str.length() - 1) {
            for (String str2 : str.substring(iIndexOf + 1).split(m0.a.f37445e)) {
                int iIndexOf2 = str2.indexOf(61, 1);
                if (iIndexOf2 != -1 && iIndexOf2 < str2.length() - 1) {
                    map.put(str2.substring(0, iIndexOf2), B(str2.substring(iIndexOf2 + 1)));
                }
            }
        }
        return map;
    }

    private static String x() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(line);
                if (!matcher.matches() || matcher.groupCount() < 4) {
                    return "Unavailable";
                }
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static String y(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static JSONObject z(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }
}
