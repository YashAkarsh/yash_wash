package com.haier.uhome.control.base.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkQualityReq extends BasicDeviceReq {

    @b(name = "module")
    private String module;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "traceId")
    private String traceId;

    public String getModule() {
        return this.module;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTraceId() {
        return this.traceId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_GET_NETWORK_QUALITY;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "NetworkQualityReq{" + super.toString() + ", timeout=" + this.timeout + ", traceId=" + this.traceId + '}';
    }
}
