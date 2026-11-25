package com.haier.uhome.config.a;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    AP_ENCRYPTION_UNKNOWN("未知"),
    AP_ENCRYPTION_NONE("无加密"),
    AP_ENCRYPTION_WEP("WEP加密"),
    AP_ENCRYPTION_WPA_WPA2("WPA/WPA2加密");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28409e;

    a(String str) {
        this.f28409e = str;
    }

    public String a() {
        return this.f28409e;
    }

    public static a a(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return AP_ENCRYPTION_UNKNOWN;
        }
    }

    public static a a(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return AP_ENCRYPTION_UNKNOWN;
        }
    }
}
