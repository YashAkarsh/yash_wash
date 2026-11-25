package com.haier.uhome.config.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGetWifiInfoReq extends BasicReq {

    @b(name = "module")
    private String module;

    @b(name = a.f13674p)
    private int timeout;

    public String getModule() {
        return this.module;
    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_GET_WIFI_INFO;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceGetWifiInfoReq{module='" + this.module + "', timeout=" + this.timeout + '}';
    }
}
