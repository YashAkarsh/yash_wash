package com.haier.uhome.config.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBleSecurityAuthReq extends BasicReq {

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "devId")
    private String devId;

    @b(name = "module")
    private String module;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = d.R)
    private String token;

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

    public String getToken() {
        return this.token;
    }

    public String getTraceId() {
        return this.traceId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_BLE_SECURITY_AUTH;
    }

    public void setBleDevId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("DeviceBleSecurityAuthReq bleDevId is null");
        }
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

    public void setToken(String str) {
        if (str == null) {
            throw new IllegalArgumentException("DeviceBleSecurityAuthReq token is null");
        }
        this.token = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceBleSecurityAuthReq{bleDevId='" + this.bleDevId + "', devId='" + this.devId + "', module='" + this.module + "', traceId='" + this.traceId + "', token='" + this.token + "', timeout=" + this.timeout + '}';
    }
}
