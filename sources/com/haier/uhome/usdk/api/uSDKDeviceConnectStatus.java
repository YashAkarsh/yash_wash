package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKDeviceConnectStatus {
    CLOUD_CONNECTED("远程连接"),
    LOCAL_CONNECTED("本地连接"),
    LOCAL_BLE_CONNECTED("蓝牙连接"),
    OFFLINE("离线");

    private String desc;

    uSDKDeviceConnectStatus(String str) {
        this.desc = str;
    }

    public String getDesc() {
        return this.desc;
    }
}
