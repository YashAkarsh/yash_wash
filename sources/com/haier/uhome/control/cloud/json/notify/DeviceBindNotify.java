package com.haier.uhome.control.cloud.json.notify;

import android.text.TextUtils;
import com.haier.uhome.control.base.json.notify.BasicDeviceNotify;
import com.haier.uhome.control.cloud.a.k;
import com.haier.uhome.usdk.base.c.e;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBindNotify extends BasicDeviceNotify {

    @b(name = d.R)
    private String token;

    @b(name = "typeId")
    private String typeId;

    protected DeviceBindNotify() {
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new k();
    }

    public String getToken() {
        return this.token;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTypeId(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("typeId should not be null");
        }
        this.typeId = str;
    }

    @Override // com.haier.uhome.control.base.json.notify.BasicDeviceNotify, com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceBindNotify{devId=" + getDevId() + ", typeId=" + this.typeId + '}';
    }
}
