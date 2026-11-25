package com.haier.uhome.control.base.json.resp;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GetModuleInfoResp extends BasicDeviceResp {

    @b(name = "accessType")
    private String accessType;

    @b(name = "hardwareType")
    private String hardwareType;

    @b(name = "hardwareVer")
    private String hardwareVer;

    @b(name = "machineId")
    private String machineId;

    @b(name = "module")
    private String module;

    @b(name = "softwareType")
    private String softwareType;

    @b(name = "softwareVer")
    private String softwareVer;

    public String getAccessType() {
        return this.accessType;
    }

    public String getHardwareType() {
        return this.hardwareType;
    }

    public String getHardwareVer() {
        return this.hardwareVer;
    }

    public String getMachineId() {
        return this.machineId;
    }

    public String getModule() {
        return this.module;
    }

    public String getSoftwareType() {
        return this.softwareType;
    }

    public String getSoftwareVer() {
        return this.softwareVer;
    }

    public void setAccessType(String str) {
        this.accessType = str;
    }

    public void setHardwareType(String str) {
        this.hardwareType = str;
    }

    public void setHardwareVer(String str) {
        this.hardwareVer = str;
    }

    public void setMachineId(String str) {
        this.machineId = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setSoftwareType(String str) {
        this.softwareType = str;
    }

    public void setSoftwareVer(String str) {
        this.softwareVer = str;
    }
}
