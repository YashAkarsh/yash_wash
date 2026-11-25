package com.haier.uhome.control.cloud.api;

/* JADX INFO: loaded from: classes2.dex */
public enum b {
    UNCONNECTED("未连接"),
    CONNECTING("连接中"),
    CONNECTED("已连接"),
    CONNECT_FAILED("连接失败");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f29105e;

    b(String str) {
        this.f29105e = str;
    }

    public String a() {
        return this.f29105e;
    }

    public static b a(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return UNCONNECTED;
        }
    }
}
