package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.control.base.json.notify.BasicDeviceNotify;
import com.haier.uhome.control.cloud.a.n;
import com.haier.uhome.usdk.base.c.e;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceUnbindNotify extends BasicDeviceNotify {

    @b(name = d.R)
    private String token;

    protected DeviceUnbindNotify() {
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new n();
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.haier.uhome.control.base.json.notify.BasicDeviceNotify, com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceUnbindNotify{devId=" + getDevId() + '}';
    }
}
