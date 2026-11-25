package com.alipay.sdk.app;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static EnumC0155a f13583a = EnumC0155a.ONLINE;

    /* JADX INFO: renamed from: com.alipay.sdk.app.a$a, reason: collision with other inner class name */
    public enum EnumC0155a {
        ONLINE,
        SANDBOX
    }

    public static EnumC0155a a() {
        return f13583a;
    }

    public static boolean b() {
        return f13583a == EnumC0155a.SANDBOX;
    }

    public static void c(EnumC0155a enumC0155a) {
        f13583a = enumC0155a;
    }
}
