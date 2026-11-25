package com.haier.uhome.control.cloud.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.cloud.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UpDeviceVersionInfoReq extends BasicReq {

    @b(name = "devId")
    private String devId;

    @b(name = "devVers")
    private String devVers;

    @b(name = "hard")
    private String hard;

    @b(name = "hardVer")
    private String hardVer;

    @b(name = "mac")
    private String mac;

    @b(name = "soft")
    private String soft;

    @b(name = "softVer")
    private String softVer;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "type")
    private String type;

    public String getDevId() {
        return this.devId;
    }

    public String getDevVers() {
        return this.devVers;
    }

    public String getHard() {
        return this.hard;
    }

    public String getHardVer() {
        return this.hardVer;
    }

    public String getMac() {
        return this.mac;
    }

    public String getSoft() {
        return this.soft;
    }

    public String getSoftVer() {
        return this.softVer;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getType() {
        return this.type;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_UPDATE_DEVICE_VERSION;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDevVers(String str) {
        this.devVers = str;
    }

    public void setHard(String str) {
        this.hard = str;
    }

    public void setHardVer(String str) {
        this.hardVer = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setSoft(String str) {
        this.soft = str;
    }

    public void setSoftVer(String str) {
        this.softVer = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "UpDeviceVersionInfoReq{timeout=" + this.timeout + ", devId='" + this.devId + "', soft='" + this.soft + "', softVer='" + this.softVer + "', hard='" + this.hard + "', hardVer='" + this.hardVer + "', devVers='" + this.devVers + "', type='" + this.type + "', mac='" + this.mac + "'}";
    }
}
