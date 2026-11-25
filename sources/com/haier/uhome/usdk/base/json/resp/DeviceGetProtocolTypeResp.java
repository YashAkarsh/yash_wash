package com.haier.uhome.usdk.base.json.resp;

import com.alipay.sdk.util.j;
import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGetProtocolTypeResp extends BasicResp {

    @b(name = "deviceProtocolType")
    private int deviceProtocolType;

    public int getDeviceProtocolType() {
        return this.deviceProtocolType;
    }

    public void setDeviceProtocolType(int i7) {
        this.deviceProtocolType = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "DeviceGetProtocolTypeResp{" + super.toString() + j.f13808d;
    }
}
