package com.haier.uhome.account.model.uwsmodel;

import com.haier.globalwasher.presenter.o;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBriefInfo {

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "deviceName")
    private String deviceName;

    @b(name = "deviceType")
    private String deviceType;

    @b(name = "online")
    private Boolean online = Boolean.FALSE;

    @b(name = "wifiType")
    private String wifiType;

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public Boolean getOnline() {
        return this.online;
    }

    public String getWifiType() {
        return this.wifiType;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setOnline(Boolean bool) {
        this.online = bool;
    }

    public void setWifiType(String str) {
        this.wifiType = str;
    }
}
