package com.haier.uhome.control.base.json.resp;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BasicOpResp extends BasicDeviceResp {

    @b(name = "boardSpan")
    private int boardSpan;

    @b(name = "module")
    private String module;

    @b(name = "netSpan")
    private String netSpan;

    @b(name = "traceId")
    private String traceId;

    public int getBoardSpan() {
        return this.boardSpan;
    }

    public String getModule() {
        return this.module;
    }

    public String getNetSpan() {
        return this.netSpan;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setBoardSpan(int i7) {
        this.boardSpan = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setNetSpan(String str) {
        this.netSpan = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    @Override // com.haier.uhome.control.base.json.resp.BasicDeviceResp, com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "BasicOpResp{" + super.toString() + "module='" + this.module + "', boardSpan=" + this.boardSpan + ", traceId='" + this.traceId + "', netSpan='" + this.netSpan + "'}";
    }
}
