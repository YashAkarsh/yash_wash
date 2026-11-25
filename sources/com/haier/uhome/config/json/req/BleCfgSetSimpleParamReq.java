package com.haier.uhome.config.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleCfgSetSimpleParamReq extends BasicReq {

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "devId")
    private String devId;

    @b(name = "module")
    private String module;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "traceId")
    private String traceId;

    public String getBleDevId() {
        return this.bleDevId;
    }

    public String getDevId() {
        return this.devId;
    }

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
        return ProtocolConst.REQ_CFG_SET_SIMPLE_PARAM;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setDevId(String str) {
        this.devId = str;
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

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "BleCfgSetSimpleParamReq{" + super.toString() + "module=" + this.module + ", traceId=" + this.traceId + ", bleDevId=" + this.bleDevId + ", devId=" + this.devId + ", timeout=" + this.timeout + '}';
    }
}
