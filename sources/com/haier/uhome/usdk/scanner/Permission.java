package com.haier.uhome.usdk.scanner;

import c.o0;
import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public enum Permission {
    BLE_DISABLE(new String[0]),
    BLE_INVALID("android.permission.ACCESS_FINE_LOCATION"),
    WIFI_DISABLE(new String[0]),
    WIFI_INVALID("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");

    private String[] permissions;

    Permission(String... strArr) {
        this.permissions = strArr;
    }

    @o0
    @Keep
    public String[] getSystemPermissions() {
        return this.permissions;
    }
}
