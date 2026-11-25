package com.haier.uhome.control.cloud.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.cloud.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class OpenBindTimeWindowReq extends BasicReq {

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "traceId")
    private String traceId;

    public int getTimeout() {
        return this.timeout;
    }

    public String getTraceId() {
        return this.traceId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_CLOUD_OPEN_USER_BIND_TIME_WINDOW;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "OpenBindTimeWindowReq{timeout=" + this.timeout + ", traceId='" + this.traceId + "'}";
    }
}
