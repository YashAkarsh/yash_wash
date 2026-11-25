package com.haier.uhome.usdk.api;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKDeviceConfigInfoAP implements Serializable {
    private static final long serialVersionUID = 4511821586034710205L;
    private uSDKApEncryptionTypeConst encryptionType;
    private int power;
    private String ssid;

    protected uSDKDeviceConfigInfoAP(String str, int i7, uSDKApEncryptionTypeConst usdkapencryptiontypeconst) {
        this.ssid = str;
        this.power = i7;
        this.encryptionType = usdkapencryptiontypeconst;
    }

    public uSDKApEncryptionTypeConst getEncryptionType() {
        return this.encryptionType;
    }

    public int getPower() {
        return this.power;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String toString() {
        return "uSDKDeviceConfigInfoAP{ssid='" + this.ssid + ", power=" + this.power + ", encryptionType=" + this.encryptionType + '}';
    }
}
