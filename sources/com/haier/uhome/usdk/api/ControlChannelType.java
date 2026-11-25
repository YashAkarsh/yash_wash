package com.haier.uhome.usdk.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public enum ControlChannelType {
    WIFI(1, "WIFI"),
    BLE(2, "BLE"),
    BLE_MESH(4, "MESH");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30300b;

    ControlChannelType(int i7, String str) {
        this.f30299a = i7;
        this.f30300b = str;
    }

    @Keep
    public int getMask() {
        return this.f30299a;
    }

    @Keep
    public String getName() {
        return this.f30300b;
    }
}
