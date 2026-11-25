package com.haier.uhome.control.local.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.local.json.ProtocolConst;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GetBleOtaInfoReq extends BasicDeviceReq {

    @b(name = "active_connect")
    private int activeConnect;

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "elementAddr")
    private String elementAddr;

    @b(name = "module")
    private String module;

    @b(name = "protocol")
    private String protocol;

    @b(name = "securityKey")
    private String securityKey;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = d.R)
    private String token;

    public int getActiveConnect() {
        return this.activeConnect;
    }

    public String getBleDevId() {
        return this.bleDevId;
    }

    public String getElementAddr() {
        return this.elementAddr;
    }

    public String getModule() {
        return this.module;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getSecurityKey() {
        return this.securityKey;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getToken() {
        return this.token;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_BLE_GET_OTA_INFO;
    }

    public void setActiveConnect(int i7) {
        this.activeConnect = i7;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setElementAddr(String str) {
        this.elementAddr = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setSecurityKey(String str) {
        this.securityKey = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "GetBleOtaInfoReq{protocol='" + this.protocol + "', securityKey='" + this.securityKey + "', bleDevId='" + this.bleDevId + "', timeout=" + this.timeout + ", module='" + this.module + "', token='" + this.token + "', elementAddr='" + this.elementAddr + "', activeConnect=" + this.activeConnect + '}';
    }
}
