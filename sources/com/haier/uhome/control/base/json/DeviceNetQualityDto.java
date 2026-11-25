package com.haier.uhome.control.base.json;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceNetQualityDto {

    @b(name = "hardwareType")
    private String hardwareType;

    @b(name = "hardwareVers")
    private String hardwareVers;

    @b(name = "netType")
    private String netType;

    @b(name = "softwareType")
    private String softwareType;

    @b(name = "softwareVers")
    private String softwareVers;

    @b(name = "strength")
    private int strength;

    public String getHardwareType() {
        return this.hardwareType;
    }

    public String getHardwareVers() {
        return this.hardwareVers;
    }

    public String getNetType() {
        return this.netType;
    }

    public String getSoftwareType() {
        return this.softwareType;
    }

    public String getSoftwareVers() {
        return this.softwareVers;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setHardwareType(String str) {
        this.hardwareType = str;
    }

    public void setHardwareVers(String str) {
        this.hardwareVers = str;
    }

    public void setNetType(String str) {
        this.netType = str;
    }

    public void setSoftwareType(String str) {
        this.softwareType = str;
    }

    public void setSoftwareVers(String str) {
        this.softwareVers = str;
    }

    public void setStrength(int i7) {
        this.strength = i7;
    }
}
