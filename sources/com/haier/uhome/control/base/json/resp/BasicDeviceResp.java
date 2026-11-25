package com.haier.uhome.control.base.json.resp;

import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BasicDeviceResp extends BasicResp {

    @b(name = "code")
    private String code;

    @b(name = "devId")
    private String devId;

    @b(name = TraceProtocolConst.PRO_SPAN)
    private String span;

    public BasicDeviceResp() {
    }

    public String getCode() {
        return this.code;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getSpan() {
        return this.span;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setSpan(String str) {
        this.span = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "BasicDeviceResp{" + super.toString() + ", devId=" + this.devId + ", span=" + this.span + ", code=" + this.code + '}';
    }

    public BasicDeviceResp(String str) {
        this.devId = str;
    }
}
