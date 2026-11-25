package com.alipay.sdk.util;

/* JADX INFO: loaded from: classes.dex */
public enum e {
    WIFI(0, "WIFI"),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NONE(-1, "none");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13790b;

    e(int i7, String str) {
        this.f13789a = i7;
        this.f13790b = str;
    }

    public static e b(int i7) {
        for (e eVar : values()) {
            if (eVar.a() == i7) {
                return eVar;
            }
        }
        return NONE;
    }

    public final int a() {
        return this.f13789a;
    }

    public final String c() {
        return this.f13790b;
    }
}
