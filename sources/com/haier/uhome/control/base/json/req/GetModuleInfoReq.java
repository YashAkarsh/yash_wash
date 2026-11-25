package com.haier.uhome.control.base.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GetModuleInfoReq extends BasicDeviceReq {

    @b(name = "module")
    private String module;

    @b(name = a.f13674p)
    private int timeout;

    public String getModule() {
        return this.module;
    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_MODULE_INFO;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }
}
