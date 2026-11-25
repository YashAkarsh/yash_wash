package com.haier.uhome.control.base.json.req;

import com.haier.uhome.control.base.json.ProtocolConst;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceConnectReq extends BasicDeviceReq {

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "deviceType")
    private int deviceType;

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = TraceProtocolConst.PRO_IP)
    private String ip;

    @b(name = "isAuxConfigCapability")
    private int isAuxConfigCapability;

    @b(name = "isMeshGW")
    private int isMeshGW;

    @b(name = "macAddress")
    private String macAddress;

    @b(name = "module")
    private String module;

    @b(name = "port")
    private int port;

    @b(name = "protVers")
    private String protVers;

    @b(name = "protocol")
    private String protocol;

    @b(name = "securityVersion")
    private String securityVersion;

    @b(name = "sharedPort")
    private int sharedPort;

    @b(name = d.R)
    private String token;

    @b(name = "uplusId")
    private String uplusId;

    public String getBleDevId() {
        return this.bleDevId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getElementAddr() {
        return this.elementAddr;
    }

    public String getIp() {
        return this.ip;
    }

    public int getIsAuxConfigCapability() {
        return this.isAuxConfigCapability;
    }

    public int getIsMeshGW() {
        return this.isMeshGW;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getModule() {
        return this.module;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtVers() {
        return this.protVers;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getSecurityVersion() {
        return this.securityVersion;
    }

    public int getSharedPort() {
        return this.sharedPort;
    }

    public String getToken() {
        return this.token;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_CONNECT;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setDeviceType(int i7) {
        this.deviceType = i7;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setIsAuxConfigCapability(int i7) {
        this.isAuxConfigCapability = i7;
    }

    public void setIsMeshGW(int i7) {
        this.isMeshGW = i7;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setPort(int i7) {
        this.port = i7;
    }

    public void setProtVers(String str) {
        this.protVers = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setSecurityVersion(String str) {
        this.securityVersion = str;
    }

    public void setSharedPort(int i7) {
        this.sharedPort = i7;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceConnectReq{" + super.toString() + "module='" + this.module + "', macAddress='" + this.macAddress + "', bleDevId='" + this.bleDevId + "', ip='" + this.ip + "', port=" + this.port + ", uplusId='" + this.uplusId + "', deviceType=" + this.deviceType + ", protocol='" + this.protocol + "', token='" + this.token + "', securityVersion='" + this.securityVersion + "', sharedPort=" + this.sharedPort + ", elementAddr=" + this.elementAddr + ", isMeshGW=" + this.isMeshGW + ", isAuxConfigCapability=" + this.isAuxConfigCapability + ", protVers=" + this.protVers + '}';
    }
}
