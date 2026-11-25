package com.haier.uhome.control.local.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.local.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CreateGroupReq extends BasicReq {

    @b(name = "baseDeviceId")
    private String baseDeviceId;

    @b(name = a.f13674p)
    private int timeout;

    public String getBaseDeviceId() {
        return this.baseDeviceId;
    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_CREATE_GROUP;
    }

    public void setBaseDeviceId(String str) {
        this.baseDeviceId = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return protocol() + "{timeout=" + this.timeout + ", baseDeviceId='" + this.baseDeviceId + "'}";
    }
}
