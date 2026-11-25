package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothInfoBean implements Serializable {
    private String accessToken;
    private String blueMac;
    private String blueName;
    private String deviceCode;
    private String directive;
    private String moduleType;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getBlueMac() {
        return this.blueMac;
    }

    public String getBlueName() {
        return this.blueName;
    }

    public String getDeviceCode() {
        return this.deviceCode;
    }

    public String getDirective() {
        return this.directive;
    }

    public String getModuleType() {
        return this.moduleType;
    }

    public void setBlueMac(String str) {
        this.blueMac = str;
    }

    public void setBlueName(String str) {
        this.blueName = str;
    }

    public void setDeviceCode(String str) {
        this.deviceCode = str;
    }

    public void setModuleType(String str) {
        this.moduleType = str;
    }
}
