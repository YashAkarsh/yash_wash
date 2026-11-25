package com.haier.uhome.control.local.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GetDeviceVersionInfoResp extends BasicResp {

    @b(name = "devVers")
    private String devVers;

    @b(name = "hardType")
    private String hardType;

    @b(name = "hardVer")
    private String hardVer;

    @b(name = "softType")
    private String softType;

    @b(name = "softVer")
    private String softVer;

    public String getDevVers() {
        return this.devVers;
    }

    public String getHardType() {
        return this.hardType;
    }

    public String getHardVer() {
        return this.hardVer;
    }

    public String getSoftType() {
        return this.softType;
    }

    public String getSoftVer() {
        return this.softVer;
    }

    public void setDevVers(String str) {
        this.devVers = str;
    }

    public void setHardType(String str) {
        this.hardType = str;
    }

    public void setHardVer(String str) {
        this.hardVer = str;
    }

    public void setSoftType(String str) {
        this.softType = str;
    }

    public void setSoftVer(String str) {
        this.softVer = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "GetDeviceVersionInfoResp{softType='" + this.softType + "', softVer='" + this.softVer + "', hardType='" + this.hardType + "', hardVer='" + this.hardVer + "', devVers='" + this.devVers + "'}";
    }
}
