package com.haier.uhome.control.cloud.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.cloud.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceStartFotaReq extends BasicDeviceReq {

    @b(name = "firmwareID")
    String firmwareID;

    @b(name = a.f13674p)
    int timeout;

    @b(name = "traceId")
    String traceId;

    public String getFirmwareID() {
        return this.firmwareID;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTraceId() {
        return this.traceId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_START_FOTA;
    }

    public void setFirmwareID(String str) {
        this.firmwareID = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }
}
