package com.haier.uhome.control.local.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.local.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DelGroupReq extends BasicDeviceReq {

    @b(name = "groupAddr")
    private int groupAddr;

    @b(name = "module")
    private String module;

    @b(name = a.f13674p)
    private int timeout;

    public int getGroupAddr() {
        return this.groupAddr;
    }

    public String getModule() {
        return this.module;
    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEL_GROUP;
    }

    public void setGroupAddr(int i7) {
        this.groupAddr = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }
}
