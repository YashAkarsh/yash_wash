package com.haier.uhome.control.base.json;

import com.haier.globalwasher.presenter.o;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceTokenInfo {

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "deviceToken")
    private String deviceToken;

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceToken(String str) {
        this.deviceToken = str;
    }
}
