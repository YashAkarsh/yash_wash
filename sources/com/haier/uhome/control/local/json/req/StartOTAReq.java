package com.haier.uhome.control.local.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.local.json.ProtocolConst;
import com.haier.uhome.trace.api.TraceProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class StartOTAReq extends BasicDeviceReq {

    @b(name = TraceProtocolConst.PRO_IP)
    private String ip;

    @b(name = "module")
    private String module;

    @b(name = "otaFilePath")
    private String otaFilePath;

    @b(name = "port")
    private int port;

    @b(name = "securityVersion")
    private String securityVersion;

    @b(name = a.f13674p, serialize = false)
    private int timeout;

    public String getIp() {
        return this.ip;
    }

    public String getModule() {
        return this.module;
    }

    public String getOtaFilePath() {
        return this.otaFilePath;
    }

    public int getPort() {
        return this.port;
    }

    public String getSecurityVersion() {
        return this.securityVersion;
    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_MODULE_START_OTA;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setOtaFilePath(String str) {
        this.otaFilePath = str;
    }

    public void setPort(int i7) {
        this.port = i7;
    }

    public void setSecurityVersion(String str) {
        this.securityVersion = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "StartOTAReq{module='" + this.module + "', timeout=" + this.timeout + ", otaFilePath='" + this.otaFilePath + "', ip='" + this.ip + "', port=" + this.port + ", securityVersion='" + this.securityVersion + "'}";
    }
}
