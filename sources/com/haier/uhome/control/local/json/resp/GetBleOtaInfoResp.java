package com.haier.uhome.control.local.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GetBleOtaInfoResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    @b(name = "devVers")
    private String devVers;

    @b(name = "hw_type")
    private String hwType;

    @b(name = "hw_version")
    private String hwVersion;

    @b(name = "is_ota_able")
    private String isOtaAble;

    @b(name = "is_ota_active")
    private int isOtaActive;

    @b(name = "is_ota_resume")
    private int isOtaResume;

    @b(name = "mac")
    private String mac;

    @b(name = "module_type")
    private int moduleType;

    @b(name = "session")
    private int session;

    @b(name = "sw_type")
    private String swType;

    @b(name = "sw_version")
    private String swVersion;

    public String getDevId() {
        return this.devId;
    }

    public String getDevVers() {
        return this.devVers;
    }

    public String getHwType() {
        return this.hwType;
    }

    public String getHwVersion() {
        return this.hwVersion;
    }

    public String getIsOtaAble() {
        return this.isOtaAble;
    }

    public int getIsOtaActive() {
        return this.isOtaActive;
    }

    public int getIsOtaResume() {
        return this.isOtaResume;
    }

    public String getMac() {
        return this.mac;
    }

    public int getModuleType() {
        return this.moduleType;
    }

    public int getSession() {
        return this.session;
    }

    public String getSwType() {
        return this.swType;
    }

    public String getSwVersion() {
        return this.swVersion;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDevVers(String str) {
        this.devVers = str;
    }

    public void setHwType(String str) {
        this.hwType = str;
    }

    public void setHwVersion(String str) {
        this.hwVersion = str;
    }

    public void setIsOtaAble(String str) {
        this.isOtaAble = str;
    }

    public void setIsOtaActive(int i7) {
        this.isOtaActive = i7;
    }

    public void setIsOtaResume(int i7) {
        this.isOtaResume = i7;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setModuleType(int i7) {
        this.moduleType = i7;
    }

    public void setSession(int i7) {
        this.session = i7;
    }

    public void setSwType(String str) {
        this.swType = str;
    }

    public void setSwVersion(String str) {
        this.swVersion = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "GetBleOtaInfoResp{devId='" + this.devId + "', isOtaActive=" + this.isOtaActive + ", isOtaResume=" + this.isOtaResume + ", session=" + this.session + ", hwType='" + this.hwType + "', hwVersion='" + this.hwVersion + "', swType='" + this.swType + "', swVersion='" + this.swVersion + "', isOtaAble='" + this.isOtaAble + "', devVers='" + this.devVers + "', mac='" + this.mac + "', moduleType=" + this.moduleType + '}';
    }
}
