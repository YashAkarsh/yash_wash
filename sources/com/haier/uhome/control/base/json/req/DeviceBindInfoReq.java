package com.haier.uhome.control.base.json.req;

import com.haier.uhome.control.base.json.ProtocolConst;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBindInfoReq extends BasicDeviceReq {

    @b(name = "ip4hostAddress")
    private String ip4hostAddress;

    @b(name = "isSharePort")
    private int isSharePort;

    @b(name = "port")
    private int port;

    @b(name = "protocol")
    private String protocol;

    @b(name = "security")
    private String security;

    @b(name = d.R)
    private String token;

    public String getIp4hostAddress() {
        return this.ip4hostAddress;
    }

    public int getIsSharePort() {
        return this.isSharePort;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getSecurity() {
        return this.security;
    }

    public String getToken() {
        return this.token;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_BIND_INFO;
    }

    public void setIp4hostAddress(String str) {
        this.ip4hostAddress = str;
    }

    public void setIsSharePort(int i7) {
        this.isSharePort = i7;
    }

    public void setPort(int i7) {
        this.port = i7;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setSecurity(String str) {
        this.security = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceBindInfoReq{ip4hostAddress='" + this.ip4hostAddress + "', token='" + this.token + "', port=" + this.port + ", security='" + this.security + "', isSharePort=" + this.isSharePort + ", protocol='" + this.protocol + "'}";
    }
}
