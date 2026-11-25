package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKApEncryptionTypeConst {
    AP_ENCRYPTION_UNKNOWN("未知"),
    AP_ENCRYPTION_NONE("无加密"),
    AP_ENCRYPTION_WEP("WEP加密"),
    AP_ENCRYPTION_WPA_WPA2("WPA/WPA2加密");

    private final String content;

    uSDKApEncryptionTypeConst(String str) {
        this.content = str;
    }

    public static uSDKApEncryptionTypeConst getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return AP_ENCRYPTION_UNKNOWN;
        }
    }

    public String getValue() {
        return this.content;
    }

    public static uSDKApEncryptionTypeConst getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return AP_ENCRYPTION_UNKNOWN;
        }
    }
}
