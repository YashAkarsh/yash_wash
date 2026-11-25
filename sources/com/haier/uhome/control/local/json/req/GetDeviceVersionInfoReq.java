package com.haier.uhome.control.local.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.local.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GetDeviceVersionInfoReq extends BasicDeviceReq {

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "module")
    private String module;

    @b(name = a.f13674p)
    private int timeout;

    public int getElementAddr() {
        return this.elementAddr;
    }

    public String getModule() {
        return this.module;
    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_GET_VERSION;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "GetDeviceVersionInfoReq{timeout=" + this.timeout + ", module='" + this.module + "', elementAddr='" + this.elementAddr + "'}";
    }
}
