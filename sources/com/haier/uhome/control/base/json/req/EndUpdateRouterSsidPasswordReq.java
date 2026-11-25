package com.haier.uhome.control.base.json.req;

import com.haier.uhome.control.base.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class EndUpdateRouterSsidPasswordReq extends BasicReq {

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "devId")
    private String devId;

    @b(name = "module")
    private String module;

    public String getBleDevId() {
        return this.bleDevId;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getModule() {
        return this.module;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_END_UPDATE_ROUTER_SSID_PASSWORD;
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

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "EndUpdateRouterSsidPasswordReq{module='" + this.module + "', devId='" + this.devId + "', bleDevId='" + this.bleDevId + "'}";
    }
}
