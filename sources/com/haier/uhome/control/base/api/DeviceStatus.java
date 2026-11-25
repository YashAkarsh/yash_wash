package com.haier.uhome.control.base.api;

/* JADX INFO: loaded from: classes2.dex */
public enum DeviceStatus {
    STATUS_UNCONNECT("未连接"),
    STATUS_OFFLINE("离线"),
    STATUS_CONNECTING("连接中"),
    STATUS_CONNECTED("连接成功"),
    STATUS_READY("就绪");

    private final String info;

    DeviceStatus(String str) {
        this.info = str;
    }

    public static DeviceStatus getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return STATUS_UNCONNECT;
        }
    }

    public String getValue() {
        return this.info;
    }

    public static DeviceStatus getInstance(boolean z7) {
        if (z7) {
            return STATUS_UNCONNECT;
        }
        return STATUS_OFFLINE;
    }

    public static DeviceStatus getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return STATUS_UNCONNECT;
        }
    }
}
