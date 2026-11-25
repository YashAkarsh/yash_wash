package com.haier.uhome.control.base.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.ProtocolConst;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CloudBindDeviceReq extends BasicDeviceReq {

    @b(name = "bindCode")
    private long bindCode;

    @b(name = "bindCodeFrom")
    private int bindCodeFrom;

    @b(name = "deviceName")
    private String deviceName;

    @b(name = "meshDevKey")
    private String meshDevKey;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = d.R)
    private String token;

    @b(name = "traceId")
    private String traceId;

    @b(name = "uplusId")
    private String uplusId;

    public long getBindCode() {
        return this.bindCode;
    }

    public int getBindCodeFrom() {
        return this.bindCodeFrom;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getMeshDevKey() {
        return this.meshDevKey;
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

    public String getUplusId() {
        return this.uplusId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_CLOUD_BIND_DEVICE;
    }

    public void setBindCode(long j7) {
        this.bindCode = j7;
    }

    public void setBindCodeFrom(int i7) {
        this.bindCodeFrom = i7;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setMeshDevKey(String str) {
        this.meshDevKey = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "CloudBindDeviceReq{traceId=" + this.traceId + ", token=" + this.token + ", timeout=" + this.timeout + ", uplusId=" + this.uplusId + ", bindCode=" + this.bindCode + ", bindCodeFrom=" + this.bindCodeFrom + ", deviceName=" + this.deviceName + '}';
    }
}
