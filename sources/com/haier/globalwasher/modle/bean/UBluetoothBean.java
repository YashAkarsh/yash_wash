package com.haier.globalwasher.modle.bean;

import v3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UBluetoothBean implements b {
    private String accessToken;
    private String blueMac;
    private String command;

    public UBluetoothBean(String str, String str2, String str3) {
        this.accessToken = str;
        this.blueMac = str2;
        this.command = str3;
    }

    @Override // v3.b
    public int bluetoothType() {
        return 1;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    @Override // v3.b
    public String getBluetoothMac() {
        return this.blueMac;
    }

    @Override // v3.b
    public String getStartCommand() {
        return this.command;
    }
}
