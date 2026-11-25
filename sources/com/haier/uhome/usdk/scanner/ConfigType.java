package com.haier.uhome.usdk.scanner;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public enum ConfigType {
    BLE(1, "蓝牙"),
    PURE_BLE(2, "纯蓝牙"),
    HI_ROUTER(4, "极路由"),
    SOFT_AP(8, "SoftAP"),
    NEW_DIRECT_LINK(16, "新直连设备"),
    BLE_MESH(32, "MESH"),
    BLE_ADV(64, "蓝牙广播设备"),
    SMARTLINK(128, "SmartLink"),
    BIND_WITHOUT_WIFI(256, "先绑后配");

    private final int mask;
    private final String name;

    ConfigType(int i7, String str) {
        this.mask = i7;
        this.name = str;
    }

    public int getMask() {
        return this.mask;
    }

    public String getName() {
        return this.name;
    }
}
