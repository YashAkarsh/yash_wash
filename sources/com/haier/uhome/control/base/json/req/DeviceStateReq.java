package com.haier.uhome.control.base.json.req;

import com.haier.uhome.control.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceStateReq extends BasicDeviceReq {

    @b(name = "module")
    private String module;

    public String getModule() {
        return this.module;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_GET_STATE;
    }

    public void setModule(String str) {
        this.module = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceStateReq{" + super.toString() + "module='" + this.module + "'}";
    }
}
