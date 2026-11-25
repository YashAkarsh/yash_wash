package com.haier.uhome.control.base.json.req;

import com.haier.uhome.control.base.json.ProtocolConst;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceSetGatewayReq extends BasicDeviceReq {

    @b(name = "gateway")
    private String gateway;

    @b(name = "gatewayport")
    private int gatewayport;

    @b(name = "ip4hostaddress")
    private String ip4hostaddress;

    @b(name = "module")
    private String module;

    @b(name = "port")
    private int port;

    @b(name = "protocol")
    private String protocol;

    @b(name = "security")
    private String security;

    @b(name = d.R)
    private String token;

    @b(name = "uplusId")
    private String uplusId;

    public String getGateway() {
        return this.gateway;
    }

    public int getGatewayport() {
        return this.gatewayport;
    }

    public String getIp4hostaddress() {
        return this.ip4hostaddress;
    }

    public String getModule() {
        return this.module;
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

    public String getUplusId() {
        return this.uplusId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_SET_GATEWAY;
    }

    public void setGateway(String str) {
        this.gateway = str;
    }

    public void setGatewayport(int i7) {
        this.gatewayport = i7;
    }

    public void setIp4hostaddress(String str) {
        this.ip4hostaddress = str;
    }

    public void setModule(String str) {
        this.module = str;
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

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceSetGatewayReq{module='" + this.module + "', gateway='" + this.gateway + "', uplusId='" + this.uplusId + "', gatewayport=" + this.gatewayport + ", ip4hostaddress='" + this.ip4hostaddress + "', port=" + this.port + ", security='" + this.security + "', protocol='" + this.protocol + "', token='" + this.token + "'}";
    }
}
