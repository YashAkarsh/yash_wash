package com.haier.uhome.usdk.api;

import com.haier.uhome.control.base.api.DeviceStatus;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKDeviceStatusConst {
    STATUS_UNCONNECT(DeviceStatus.STATUS_UNCONNECT),
    STATUS_OFFLINE(DeviceStatus.STATUS_OFFLINE),
    STATUS_CONNECTING(DeviceStatus.STATUS_CONNECTING),
    STATUS_CONNECTED(DeviceStatus.STATUS_CONNECTED),
    STATUS_READY(DeviceStatus.STATUS_READY);

    private final DeviceStatus statusConst;

    uSDKDeviceStatusConst(DeviceStatus deviceStatus) {
        this.statusConst = deviceStatus;
    }

    public static uSDKDeviceStatusConst getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return STATUS_UNCONNECT;
        }
    }

    public String getValue() {
        return this.statusConst.getValue();
    }

    public static uSDKDeviceStatusConst getInstance(boolean z7) {
        return z7 ? STATUS_UNCONNECT : STATUS_OFFLINE;
    }

    public static uSDKDeviceStatusConst getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return STATUS_UNCONNECT;
        }
    }
}
