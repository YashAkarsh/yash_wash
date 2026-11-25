package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKDeviceConfigModeConst {
    CONFIG_MODE_SOFTAP("SoftAP配置模式"),
    CONFIG_MODE_SMARTCONFIG("SmartConfig配置模式");

    private final String content;

    uSDKDeviceConfigModeConst(String str) {
        this.content = str;
    }

    public static uSDKDeviceConfigModeConst getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return CONFIG_MODE_SOFTAP;
        }
    }

    public String getValue() {
        return this.content;
    }

    public static uSDKDeviceConfigModeConst getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return CONFIG_MODE_SOFTAP;
        }
    }
}
