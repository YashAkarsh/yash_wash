package com.haier.uhome.config.json.resp;

import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class NoPasswordRxAckResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    @b(name = TraceProtocolConst.PRO_CONFIG_SCM)
    private String scm;

    public String getDevId() {
        return this.devId;
    }

    public String getScm() {
        return this.scm;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setScm(String str) {
        this.scm = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "NoPasswordRxAckResp{sn=" + getSn() + ", errNo=" + getErrNo() + ", devId='" + this.devId + ", scm='" + this.scm + '}';
    }
}
