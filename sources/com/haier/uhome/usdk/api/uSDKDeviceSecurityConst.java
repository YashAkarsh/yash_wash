package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKDeviceSecurityConst {
    UNKNOWN,
    UNSAFE,
    SAFE;

    public static uSDKDeviceSecurityConst getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return UNKNOWN;
        }
    }

    public static uSDKDeviceSecurityConst getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return UNKNOWN;
        }
    }
}
