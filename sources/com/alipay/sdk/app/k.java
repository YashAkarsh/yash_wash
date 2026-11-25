package com.alipay.sdk.app;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f13609a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f13610b;

    public static String a() {
        return f13610b;
    }

    public static String b(int i7, String str, String str2) {
        return "resultStatus={" + i7 + "};memo={" + str + "};result={" + str2 + com.alipay.sdk.util.j.f13808d;
    }

    public static void c(String str) {
        f13610b = str;
    }

    public static void d(boolean z7) {
        f13609a = z7;
    }

    public static boolean e() {
        return f13609a;
    }

    public static String f() {
        l lVarD = l.d(l.CANCELED.a());
        return b(lVarD.a(), lVarD.e(), "");
    }

    public static String g() {
        l lVarD = l.d(l.DOUBLE_REQUEST.a());
        return b(lVarD.a(), lVarD.e(), "");
    }

    public static String h() {
        l lVarD = l.d(l.PARAMS_ERROR.a());
        return b(lVarD.a(), lVarD.e(), "");
    }
}
