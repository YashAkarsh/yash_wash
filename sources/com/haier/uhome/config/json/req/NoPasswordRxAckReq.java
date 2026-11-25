package com.haier.uhome.config.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class NoPasswordRxAckReq extends BasicReq {

    @b(name = "devId")
    private String devId;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "typeId")
    private String typeId;

    public String getDevId() {
        return this.devId;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTypeId() {
        return this.typeId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_NO_PASS_RX_ACK;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTypeId(String str) {
        this.typeId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "NoPasswordRxAckReq{sn=" + getSn() + ", devId=" + this.devId + ", typeId=" + this.typeId + ", timeout=" + this.timeout + '}';
    }
}
