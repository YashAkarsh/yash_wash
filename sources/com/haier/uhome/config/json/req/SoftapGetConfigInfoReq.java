package com.haier.uhome.config.json.req;

import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class SoftapGetConfigInfoReq extends BasicReq {

    @b(name = "traceId")
    private String traceId;

    public String getTraceId() {
        return this.traceId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_SOFTAP_APLIST_GET;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "SoftapGetConfigInfoReq{sn=" + getSn() + ",traceId=" + this.traceId + '}';
    }
}
