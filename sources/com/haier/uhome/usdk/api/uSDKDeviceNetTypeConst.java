package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKDeviceNetTypeConst {
    NET_REMOTE("远程"),
    NET_LOCAL("本地"),
    NET_NOUMENON("本机"),
    NET_BLE("蓝牙"),
    NET_MESH("MESH"),
    NET_LOCAL_GATEWAY("本地网关");

    private final String content;

    uSDKDeviceNetTypeConst(String str) {
        this.content = str;
    }

    public static uSDKDeviceNetTypeConst getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return NET_LOCAL;
        }
    }

    public String getValue() {
        return this.content;
    }

    public static uSDKDeviceNetTypeConst getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return NET_LOCAL;
        }
    }
}
