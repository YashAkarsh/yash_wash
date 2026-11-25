package com.haier.uhome.control.base.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CloudGetDeviceListReq extends BasicDeviceReq {

    @b(name = "queryNum")
    private int queryNum;

    @b(name = a.f13674p)
    private int timeout;

    public int getQueryNum() {
        return this.queryNum;
    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_CLOUD_GET_DEVICE_LIST;
    }

    public void setQueryNum(int i7) {
        this.queryNum = i7;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "CloudGetDeviceListReq{" + super.toString() + "timeout=" + this.timeout + ", queryNum=" + this.queryNum + '}';
    }
}
