package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKDeviceDHCPTypeConst {
    MANUAL("手动设定"),
    DHCP_USED("使用DHCP"),
    DHCP_OTHER("其他方式分配IP");

    private final String content;

    uSDKDeviceDHCPTypeConst(String str) {
        this.content = str;
    }

    public static uSDKDeviceDHCPTypeConst getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return DHCP_OTHER;
        }
    }

    public String getValue() {
        return this.content;
    }

    public static uSDKDeviceDHCPTypeConst getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return DHCP_OTHER;
        }
    }
}
