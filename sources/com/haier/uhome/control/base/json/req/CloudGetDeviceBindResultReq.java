package com.haier.uhome.control.base.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.ProtocolConst;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CloudGetDeviceBindResultReq extends BasicDeviceReq {

    @b(name = "bindCode")
    private long bindCode;

    @b(name = "bindCodeFrom")
    private int bindCodeFrom;

    @b(name = "btsOffset")
    private long btsOffset;

    @b(name = "lastBts")
    private long lastBts;

    @b(name = "module")
    private String mModule;

    @b(name = a.f13674p)
    private int mTimeout;

    @b(name = d.R)
    private String mToken;

    @b(name = "traceId")
    private String mTraceId;

    public long getBindCode() {
        return this.bindCode;
    }

    public int getBindCodeFrom() {
        return this.bindCodeFrom;
    }

    public long getBtsOffset() {
        return this.btsOffset;
    }

    public long getLastBts() {
        return this.lastBts;
    }

    public String getModule() {
        return this.mModule;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public String getToken() {
        return this.mToken;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_CLOUD_GET_DEVICE_BIND_RESULT;
    }

    public void setBindCode(long j7) {
        this.bindCode = j7;
    }

    public void setBindCodeFrom(int i7) {
        this.bindCodeFrom = i7;
    }

    public void setBtsOffset(long j7) {
        this.btsOffset = j7;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq
    public void setDevId(String str) {
        this.devId = str;
    }

    public void setLastBts(long j7) {
        this.lastBts = j7;
    }

    public void setModule(String str) {
        this.mModule = str;
    }

    public void setTimeout(int i7) {
        this.mTimeout = i7;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setTraceId(String str) {
        this.mTraceId = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "CloudGetDeviceBindResultReq{mModule='" + this.mModule + "', mTimeout=" + this.mTimeout + ", mToken='" + this.mToken + "', bindCode=" + this.bindCode + ", bindCodeFrom=" + this.bindCodeFrom + ", mTraceId='" + this.mTraceId + "'}";
    }
}
