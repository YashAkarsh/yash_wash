package com.haier.uhome.control.base.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GetCacheAlarmReq extends BasicDeviceReq {

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "module")
    private String module;

    @b(name = "proxyAddr")
    private int proxyAddr;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "traceId")
    private String traceId;

    public int getElementAddr() {
        return this.elementAddr;
    }

    public String getModule() {
        return this.module;
    }

    public int getProxyAddr() {
        return this.proxyAddr;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTraceId() {
        return this.traceId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_GET_CACHE_ALARM;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setProxyAddr(int i7) {
        this.proxyAddr = i7;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }
}
