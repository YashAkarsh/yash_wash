package com.haier.uhome.control.base.json.req;

import com.haier.uhome.control.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceDisconnectReq extends BasicDeviceReq {

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "module")
    private String module;

    public int getElementAddr() {
        return this.elementAddr;
    }

    public String getModule() {
        return this.module;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_DISCONNECT;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceDisconnectReq{module='" + this.module + "'}";
    }
}
