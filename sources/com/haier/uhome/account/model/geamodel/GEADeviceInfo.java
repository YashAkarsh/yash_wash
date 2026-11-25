package com.haier.uhome.account.model.geamodel;

import com.facebook.internal.NativeProtocol;
import com.haier.globalwasher.presenter.o;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GEADeviceInfo {

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "deviceName")
    private String deviceName;

    @b(name = "deviceType")
    private String deviceType;

    @b(name = "deviceVersion")
    private GEADeviceVersion deviceVersion;

    @b(name = "online")
    private Boolean online = Boolean.FALSE;

    @b(name = NativeProtocol.RESULT_ARGS_PERMISSIONS)
    private GEAPermission[] permissions;

    @b(name = "totalPermission")
    private GEAAuthInfo totalPermission;

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

    public GEADeviceVersion getDeviceVersion() {
        return this.deviceVersion;
    }

    public Boolean getOnline() {
        return this.online;
    }

    public GEAPermission[] getPermissions() {
        return this.permissions;
    }

    public GEAAuthInfo getTotalPermission() {
        return this.totalPermission;
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

    public void setDeviceVersion(GEADeviceVersion gEADeviceVersion) {
        this.deviceVersion = gEADeviceVersion;
    }

    public void setOnline(Boolean bool) {
        this.online = bool;
    }

    public void setPermissions(GEAPermission[] gEAPermissionArr) {
        this.permissions = gEAPermissionArr;
    }

    public void setTotalPermission(GEAAuthInfo gEAAuthInfo) {
        this.totalPermission = gEAAuthInfo;
    }

    public void setWifiType(String str) {
        this.wifiType = str;
    }
}
