package com.haier.uhome.control.cloud.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.cloud.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GatewayStartPairingReq extends BasicDeviceReq {

    @b(name = "bindSn")
    private String bindSn;

    @b(name = "devId")
    private String devId;

    @b(name = "extendInfo")
    private String extendInfo;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "upCodeT")
    private String upCodeT;

    @b(name = "upid")
    private String upid;

    public String getBindSn() {
        return this.bindSn;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq
    public String getDevId() {
        return this.devId;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getUpCodeT() {
        return this.upCodeT;
    }

    public String getUpid() {
        return this.upid;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_GATEWAY_START_PAIRING;
    }

    public void setBindSn(String str) {
        this.bindSn = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq
    public void setDevId(String str) {
        this.devId = str;
    }

    public void setExtendInfo(String str) {
        this.extendInfo = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setUpCodeT(String str) {
        this.upCodeT = str;
    }

    public void setUpid(String str) {
        this.upid = str;
    }
}
