package com.haier.uhome.control.local.json.req;

import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.local.json.ProtocolConst;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class EndDeviceBleOtaReq extends BasicDeviceReq {

    @b(name = "module")
    private String module;

    @b(name = d.R)
    private String token;

    public String getModule() {
        return this.module;
    }

    public String getToken() {
        return this.token;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_END_DEVICE_BLE_OTA;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "EndDeviceBleOtaReq{devId='" + getDevId() + ", sn='" + getSn() + ", module='" + this.module + "', token='" + this.token + "'}";
    }
}
