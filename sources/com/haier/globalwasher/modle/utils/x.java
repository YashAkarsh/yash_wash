package com.haier.globalwasher.modle.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24732a = "Rom";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f24733b = "MIUI";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f24734c = "EMUI";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f24735d = "FLYME";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f24736e = "OPPO";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f24737f = "SMARTISAN";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f24738g = "VIVO";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f24739h = "QIKU";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f24740i = "ro.miui.ui.version.code";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f24741j = "ro.miui.internal.storage";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f24742k = "ro.miui.ui.version.name";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f24743l = "ro.build.version.emui";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f24744m = "ro.build.version.opporom";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f24745n = "ro.smartisan.version";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f24746o = "ro.vivo.os.version";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f24747p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f24748q;

    public static boolean a(String str) throws Throwable {
        String str2 = f24747p;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strC = c(f24742k);
        f24748q = strC;
        if (TextUtils.isEmpty(strC)) {
            String strC2 = c(f24743l);
            f24748q = strC2;
            if (TextUtils.isEmpty(strC2)) {
                String strC3 = c(f24744m);
                f24748q = strC3;
                if (TextUtils.isEmpty(strC3)) {
                    String strC4 = c(f24746o);
                    f24748q = strC4;
                    if (TextUtils.isEmpty(strC4)) {
                        String strC5 = c(f24745n);
                        f24748q = strC5;
                        if (TextUtils.isEmpty(strC5)) {
                            String str3 = Build.DISPLAY;
                            f24748q = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                f24747p = "FLYME";
                            } else {
                                f24748q = "unknown";
                                f24747p = Build.MANUFACTURER.toUpperCase();
                            }
                        } else {
                            f24747p = "SMARTISAN";
                        }
                    } else {
                        f24747p = "VIVO";
                    }
                } else {
                    f24747p = "OPPO";
                }
            } else {
                f24747p = "EMUI";
            }
        } else {
            f24747p = "MIUI";
        }
        return f24747p.equals(str);
    }

    public static String b() throws Throwable {
        if (f24747p == null) {
            a("");
        }
        return f24747p;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0062: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:99), block:B:24:0x0062 */
    public static String c(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    return line;
                } catch (IOException e9) {
                    e = e9;
                    Log.e(f24732a, "Unable to read prop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e12) {
            e = e12;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            throw th;
        }
    }

    public static String d() throws Throwable {
        if (f24748q == null) {
            a("");
        }
        return f24748q;
    }

    public static boolean e() {
        return a("QIKU") || a("360");
    }

    public static boolean f() {
        return a("EMUI");
    }

    public static boolean g() {
        return a("FLYME");
    }

    public static boolean h() {
        return a("MIUI");
    }

    public static boolean i() {
        return a("OPPO");
    }

    public static boolean j() {
        return a("SMARTISAN");
    }

    public static boolean k() {
        return a("VIVO");
    }
}
