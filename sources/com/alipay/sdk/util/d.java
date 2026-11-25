package com.alipay.sdk.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13772a = "alipaysdk";

    public static void a(String str, String str2) {
    }

    public static void b(String str, String str2, Throwable th) {
    }

    public static void c(String str, Throwable th) {
    }

    public static void d(Throwable th) {
    }

    private static String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void f(String str, String str2) {
    }

    public static void g(String str, String str2) {
    }

    public static void h(String str, String str2) {
    }

    public static void i(String str, String str2) {
    }

    private static String j(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return String.format("[%s][%s]", str, str2);
    }
}
